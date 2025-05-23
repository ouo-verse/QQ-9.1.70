package com.tencent.mobileqq.activity.contacts.topentry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.adapter.j;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MayknowRecommendsAdapter extends j implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    ArrayList<MayKnowRecommend> F;
    Context G;
    QQAppInterface H;
    Resources I;
    XListView J;
    MayknowRecommendManager K;
    long L;
    private AbsListView.OnScrollListener M;
    protected Runnable N;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayknowRecommendsAdapter.this);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
            } else {
                if (i3 != 0) {
                    return;
                }
                MayknowRecommendsAdapter.this.r();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static class b extends k {
        static IPatchRedirector $redirector_;
        public Button C;
        public TextView D;
        public MayKnowRecommend E;
        public ImageView F;
        public TroopLabelLayout G;

        /* renamed from: i, reason: collision with root package name */
        public SingleLineTextView f181751i;

        /* renamed from: m, reason: collision with root package name */
        public SingleLineTextView f181752m;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements TroopLabelLayout.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private View f181753a;

        /* renamed from: b, reason: collision with root package name */
        private String f181754b;

        /* renamed from: c, reason: collision with root package name */
        private int f181755c;

        c(View view, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MayknowRecommendsAdapter.this, view, str, Integer.valueOf(i3));
                return;
            }
            this.f181753a = view;
            this.f181754b = str;
            this.f181755c = i3;
            QLog.i("contacts.RecommendsAdapter", 1, "TroopLabelLayoutOnContentDescriptionChangedListener prefix: " + str + ", friendStatus:" + i3);
        }

        @Override // com.tencent.mobileqq.troop.widget.TroopLabelLayout.a
        public void a(ViewGroup viewGroup, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, (Object) str);
                return;
            }
            if (AppSetting.f99565y && this.f181753a != null) {
                StringBuilder sb5 = new StringBuilder();
                String str2 = this.f181754b;
                if (str2 != null) {
                    sb5.append(str2);
                }
                if (viewGroup.getVisibility() == 0 && !TextUtils.isEmpty(str)) {
                    sb5.append(",");
                    sb5.append(str);
                }
                int i3 = this.f181755c;
                if (i3 != 0) {
                    if (i3 == 1) {
                        sb5.append(",\u7b49\u5f85\u9a8c\u8bc1");
                    } else {
                        sb5.append(",\u5df2\u6dfb\u52a0");
                    }
                }
                String sb6 = sb5.toString();
                QLog.i("contacts.RecommendsAdapter", 1, "onContentDescriptionChanged contentDescriptionResult:" + sb6);
                this.f181753a.setContentDescription(sb6);
            }
        }
    }

    public MayknowRecommendsAdapter(Context context, QQAppInterface qQAppInterface, XListView xListView, int i3, boolean z16) {
        super(context, qQAppInterface, xListView, i3, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, xListView, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.F = new ArrayList<>();
        this.L = 0L;
        this.M = new a();
        this.N = new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.topentry.MayknowRecommendsAdapter.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MayknowRecommendsAdapter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MayknowRecommendsAdapter.this.r();
                }
            }
        };
        this.G = context;
        this.H = qQAppInterface;
        this.I = context.getResources();
        this.J = xListView;
        this.K = (MayknowRecommendManager) qQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        g(this.M);
    }

    private void n(MayKnowRecommend mayKnowRecommend) {
        QQAppInterface qQAppInterface;
        int i3;
        if (mayKnowRecommend != null && (qQAppInterface = this.H) != null && this.G != null) {
            FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            int i16 = 1;
            if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(mayKnowRecommend.uin), "contacts.RecommendsAdapter") && !friendsManager.P(mayKnowRecommend.uin)) {
                boolean booleanExtra = ((Activity) this.G).getIntent().getBooleanExtra(AppConstants.Key.KEY_FROM_BABYQ, false);
                String displayName = mayKnowRecommend.getDisplayName();
                if (booleanExtra) {
                    i3 = 3083;
                } else {
                    i3 = 3045;
                    i16 = 60;
                }
                IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
                Context context = this.G;
                Intent startAddFriend = iAddFriendApi.startAddFriend(context, 1, mayKnowRecommend.uin, (String) null, i3, i16, displayName, (String) null, (String) null, context.getString(R.string.f170028dd), (String) null, mayKnowRecommend.getToken());
                startAddFriend.putExtra("key_param_age_area", ProfileCardUtil.Z(this.G, mayKnowRecommend.gender, mayKnowRecommend.age, mayKnowRecommend.country, mayKnowRecommend.province, mayKnowRecommend.city));
                startAddFriend.putExtra(AppConstants.Key.KEY_FROM_BABYQ, booleanExtra);
                byte[] bArr = mayKnowRecommend.algBuffer;
                if (bArr != null && bArr.length > 0) {
                    startAddFriend.putExtra("algo_id", new String(bArr, StandardCharsets.UTF_8));
                }
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend((Activity) this.G, startAddFriend);
            } else if (friendsManager.c0(mayKnowRecommend.uin)) {
                mayKnowRecommend.friendStatus = 2;
                notifyDataSetChanged();
            } else {
                mayKnowRecommend.friendStatus = 1;
                notifyDataSetChanged();
            }
            ContactReportUtils.d(this.H, mayKnowRecommend.uin, "frd_list_add", 24, 1, mayKnowRecommend.recommendReason, this.F.indexOf(mayKnowRecommend), mayKnowRecommend.algBuffer, 0, "1");
        }
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.F.size();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.F.size()) {
            return this.F.get(i3);
        }
        return new MayKnowRecommend();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            view2 = view;
            view = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (this.I != null && this.G != null && this.H != null) {
                if (view == null) {
                    bVar = new b();
                    view3 = LayoutInflater.from(this.G).inflate(R.layout.e4i, viewGroup, false);
                    bVar.f187212f = (ImageView) view3.findViewById(R.id.f163821d);
                    bVar.f181751i = (SingleLineTextView) view3.findViewById(R.id.nickname);
                    bVar.f181752m = (SingleLineTextView) view3.findViewById(R.id.i95);
                    bVar.C = (Button) view3.findViewById(R.id.i8s);
                    bVar.D = (TextView) view3.findViewById(R.id.f166787i92);
                    bVar.F = (ImageView) view3.findViewById(R.id.bfl);
                    TroopLabelLayout troopLabelLayout = (TroopLabelLayout) view3.findViewById(R.id.jzj);
                    bVar.G = troopLabelLayout;
                    troopLabelLayout.setLabelType(1);
                    view3.setTag(bVar);
                    ImageView imageView = bVar.f187212f;
                    if (imageView instanceof ThemeImageView) {
                        ((ThemeImageView) imageView).setSupportMaskView(false);
                    }
                } else {
                    view3 = view;
                    bVar = (b) view.getTag();
                }
                MayKnowRecommend mayKnowRecommend = (MayKnowRecommend) getItem(i3);
                bVar.f187210d = mayKnowRecommend.uin;
                bVar.E = mayKnowRecommend;
                k(bVar.C, mayKnowRecommend);
                m(view3.findViewById(R.id.ibi), mayKnowRecommend);
                l(bVar.F, bVar.f187210d, mayKnowRecommend);
                String displayName = mayKnowRecommend.getDisplayName();
                StringBuilder sb5 = new StringBuilder(512);
                if (!TextUtils.isEmpty(displayName)) {
                    bVar.f181751i.setVisibility(0);
                    bVar.f181751i.setText(displayName);
                    if (AppSetting.f99565y) {
                        sb5.append(displayName);
                    }
                } else {
                    bVar.f181751i.setVisibility(8);
                }
                StringBuilder sb6 = new StringBuilder();
                if (!TextUtils.isEmpty(mayKnowRecommend.category)) {
                    sb6.append(mayKnowRecommend.category);
                    sb6.append(" ");
                }
                if (!TextUtils.isEmpty(mayKnowRecommend.recommendReason)) {
                    sb6.append(mayKnowRecommend.recommendReason);
                }
                String sb7 = sb6.toString();
                bVar.f181752m.setVisibility(8);
                bVar.G.setVisibility(0);
                List<RecommendLabel> convertToRecommendLabel = RecommendLabel.convertToRecommendLabel(mayKnowRecommend.msgLabel);
                if (!TextUtils.isEmpty(sb7)) {
                    RecommendLabel recommendLabel = new RecommendLabel();
                    recommendLabel.bytes_name = sb7;
                    convertToRecommendLabel.add(0, recommendLabel);
                }
                bVar.G.k(convertToRecommendLabel, mayKnowRecommend.gender, mayKnowRecommend.age, true);
                if (AppSetting.f99565y) {
                    bVar.G.setOnLayoutCompletedListener(new c(view3, sb5.toString(), mayKnowRecommend.friendStatus));
                }
                int i16 = mayKnowRecommend.friendStatus;
                if (i16 == 0) {
                    bVar.C.setOnClickListener(this);
                    bVar.C.setVisibility(0);
                    bVar.C.setTag(mayKnowRecommend);
                    bVar.C.setText(HardCodeUtil.qqStr(R.string.f170028dd));
                    bVar.D.setVisibility(8);
                    if (AppSetting.f99565y) {
                        bVar.C.setContentDescription(HardCodeUtil.qqStr(R.string.f170028dd));
                    }
                } else if (i16 == 1) {
                    bVar.C.setVisibility(8);
                    bVar.D.setVisibility(0);
                    bVar.D.setText(R.string.f173067h24);
                    if (AppSetting.f99565y) {
                        bVar.D.setContentDescription(this.I.getString(R.string.f173067h24));
                    }
                } else {
                    bVar.C.setVisibility(8);
                    bVar.D.setVisibility(0);
                    bVar.D.setText(R.string.f170322m9);
                    if (AppSetting.f99565y) {
                        bVar.D.setContentDescription(this.I.getString(R.string.f170322m9));
                    }
                }
                bVar.F.setOnClickListener(this);
                bVar.F.setTag(mayKnowRecommend);
                view3.setOnClickListener(this);
                if (AppSetting.f99565y) {
                    bVar.F.setContentDescription(HardCodeUtil.qqStr(R.string.nyj));
                }
                bVar.f187212f.setImageBitmap(c(1, bVar.f187210d));
                view = view3;
            }
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }

    public ArrayList<MayKnowRecommend> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.F;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        ArrayList<MayKnowRecommend> arrayList = this.F;
        if (arrayList != null && arrayList.size() != 0) {
            return this.F.get(0).traceId;
        }
        return "";
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        ArrayList<MayKnowRecommend> arrayList = this.F;
        if (arrayList != null && arrayList.size() != 0) {
            return this.F.get(0).transInfo;
        }
        return "";
    }

    public void k(View view, MayKnowRecommend mayKnowRecommend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view, (Object) mayKnowRecommend);
            return;
        }
        VideoReport.setElementId(view, "em_kl_contact_youmayknow_add_friends_btn");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        HashMap hashMap = new HashMap(3);
        hashMap.put("to_uin", mayKnowRecommend.uin);
        byte[] bArr = mayKnowRecommend.algBuffer;
        if (bArr != null && bArr.length > 0) {
            hashMap.put("algo_id", new String(bArr, StandardCharsets.UTF_8));
        }
        hashMap.put("recommend_reason", mayKnowRecommend.recommendReason);
        hashMap.put("kl_youmayknow_entrance_type", 0);
        hashMap.put("trace_id", i());
        hashMap.put("trans_info", j());
        hashMap.put("user_request_sourceid", 3045);
        hashMap.put("user_request_subsourceid", 60);
        VideoReport.setElementParams(view, hashMap);
    }

    public void l(View view, String str, MayKnowRecommend mayKnowRecommend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, view, str, mayKnowRecommend);
            return;
        }
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_kl_contact_youmayknow_off_btn");
        VideoReport.setElementExposePolicy(this.G, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.G, ClickPolicy.REPORT_ALL);
        HashMap hashMap = new HashMap(3);
        hashMap.put("to_uin", str);
        hashMap.put("recommend_reason", mayKnowRecommend.recommendReason);
        hashMap.put("user_request_sourceid", 3045);
        hashMap.put("user_request_subsourceid", 60);
        byte[] bArr = mayKnowRecommend.algBuffer;
        if (bArr != null && bArr.length > 0) {
            hashMap.put("algo_id", new String(bArr, StandardCharsets.UTF_8));
        }
        hashMap.put("kl_youmayknow_entrance_type", 0);
        hashMap.put("trace_id", i());
        hashMap.put("trans_info", j());
        VideoReport.setElementParams(view, hashMap);
    }

    public void m(View view, MayKnowRecommend mayKnowRecommend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view, (Object) mayKnowRecommend);
            return;
        }
        VideoReport.setElementId(view, "em_kl_contact_youmayknow_recommend");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        HashMap hashMap = new HashMap(3);
        hashMap.put("to_uin", mayKnowRecommend.uin);
        byte[] bArr = mayKnowRecommend.algBuffer;
        if (bArr != null && bArr.length > 0) {
            hashMap.put("algo_id", new String(bArr, StandardCharsets.UTF_8));
        }
        hashMap.put("kl_youmayknow_entrance_type", 0);
        hashMap.put("trace_id", i());
        hashMap.put("trans_info", j());
        hashMap.put("user_request_sourceid", 3045);
        hashMap.put("user_request_subsourceid", 60);
        hashMap.put("recommend_reason", mayKnowRecommend.recommendReason);
        VideoReport.setElementParams(view, hashMap);
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            t();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MayKnowRecommend mayKnowRecommend;
        MayKnowRecommend mayKnowRecommend2;
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            e eVar = null;
            if (id5 == R.id.i8s) {
                n((MayKnowRecommend) view.getTag());
                VideoReport.reportEvent("clck", view, null);
            } else if (id5 == R.id.ibi) {
                b bVar = (b) view.getTag();
                if (bVar != null && (mayKnowRecommend2 = bVar.E) != null && this.H != null && this.G != null) {
                    if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(mayKnowRecommend2.uin), "contacts.RecommendsAdapter")) {
                        i3 = 1;
                    } else {
                        i3 = 101;
                    }
                    AllInOne allInOne = new AllInOne(mayKnowRecommend2.uin, i3);
                    String recommendName = mayKnowRecommend2.getRecommendName();
                    if (!TextUtils.isEmpty(recommendName)) {
                        allInOne.recommendName = recommendName;
                    }
                    if (!TextUtils.isEmpty(mayKnowRecommend2.nick)) {
                        allInOne.nickname = mayKnowRecommend2.nick;
                    }
                    allInOne.profileEntryType = 88;
                    boolean booleanExtra = ((Activity) this.G).getIntent().getBooleanExtra(AppConstants.Key.KEY_FROM_BABYQ, false);
                    Bundle bundle = new Bundle();
                    if (booleanExtra) {
                        bundle.putBoolean(AppConstants.Key.KEY_FROM_BABYQ, true);
                    }
                    bundle.putString("recommend_entry_type", "1");
                    bundle.putString("recommend_reason", mayKnowRecommend2.getMultiReason());
                    bundle.putInt("recommend_pos", this.F.indexOf(mayKnowRecommend2));
                    bundle.putByteArray("recommend_algh_id", mayKnowRecommend2.algBuffer);
                    allInOne.extras.putString("recommend_reason", mayKnowRecommend2.getMultiReason());
                    allInOne.extras.putByteArray("recommend_algh_id", mayKnowRecommend2.algBuffer);
                    allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 3);
                    allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 31);
                    allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_ID, 3045);
                    allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_SUB_ID, 60);
                    ProfileActivity.J2(this.G, allInOne, bundle);
                    ContactReportUtils.d(this.H, mayKnowRecommend2.uin, "frd_list_clk", 24, 0, mayKnowRecommend2.recommendReason, this.F.indexOf(mayKnowRecommend2), mayKnowRecommend2.algBuffer, 0, "1");
                    VideoReport.reportEvent("clck", view, null);
                }
            } else if (id5 == R.id.bfl && (mayKnowRecommend = (MayKnowRecommend) view.getTag()) != null && this.H != null && System.currentTimeMillis() - this.L > 500) {
                this.L = System.currentTimeMillis();
                CTEntryMng cTEntryMng = (CTEntryMng) this.H.getManager(QQManagerFactory.CTENTRY_MNG);
                if (cTEntryMng != null) {
                    eVar = cTEntryMng.w();
                }
                if (eVar != null) {
                    eVar.b(mayKnowRecommend.uin);
                }
                ArrayList<MayKnowRecommend> arrayList = this.F;
                if (arrayList != null) {
                    ContactReportUtils.d(this.H, mayKnowRecommend.uin, "frd_list_dlt", 24, 0, mayKnowRecommend.recommendReason, arrayList.indexOf(mayKnowRecommend), mayKnowRecommend.algBuffer, 0, "1");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.destroy();
        g(null);
        ArrayList<MayKnowRecommend> arrayList = this.F;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.J = null;
        this.K = null;
        this.G = null;
        this.I = null;
        this.H = null;
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.J != null) {
            if (QLog.isColorLevel()) {
                QLog.d("contacts.RecommendsAdapter", 2, "onResume firstVisible: " + this.J.getFirstVisiblePosition() + " lastvisible: " + this.J.getLastVisiblePosition());
            }
            this.J.removeCallbacks(this.N);
            this.J.postDelayed(this.N, 200L);
        }
    }

    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            notifyDataSetChanged();
        }
    }

    public void r() {
        QQAppInterface qQAppInterface;
        List<MayKnowRecommend.MayKnowRecommendLabel> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        XListView xListView = this.J;
        if (xListView != null && xListView.isShown() && !this.F.isEmpty()) {
            this.J.removeCallbacks(this.N);
            int firstVisiblePosition = this.J.getFirstVisiblePosition();
            int lastVisiblePosition = this.J.getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 >= 0 && i3 < this.F.size() && this.F.get(i3) != null) {
                    arrayList.add(this.F.get(i3).uin);
                    arrayList2.add(this.F.get(i3).recommendReason);
                    arrayList3.add(Integer.valueOf(i3));
                    arrayList4.add(this.F.get(i3).algBuffer);
                    arrayList5.add(Short.valueOf(this.F.get(i3).age));
                    arrayList6.add(Short.valueOf(this.F.get(i3).gender));
                    List<MayKnowRecommend.MayKnowRecommendLabel> list2 = this.F.get(i3).msgLabel;
                    StringBuilder sb5 = new StringBuilder();
                    if (list2 != null && list2.size() != 0) {
                        int size = list2.size();
                        int i16 = 0;
                        while (i16 < size) {
                            MayKnowRecommend.MayKnowRecommendLabel mayKnowRecommendLabel = list2.get(i16);
                            if (mayKnowRecommendLabel != null) {
                                String str = mayKnowRecommendLabel.bytes_name;
                                if (!TextUtils.isEmpty(str)) {
                                    list = list2;
                                    if (i16 > 0) {
                                        sb5.append(str.concat("_"));
                                    }
                                    sb5.append(str);
                                    i16++;
                                    list2 = list;
                                }
                            }
                            list = list2;
                            i16++;
                            list2 = list;
                        }
                        arrayList7.add(sb5.toString());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("contacts.RecommendsAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + firstVisiblePosition + " lastVisibleItem: " + lastVisiblePosition + " exp_uins: " + arrayList + " exp_reasons:" + arrayList2 + " exp_positions:" + arrayList3 + " algh_ids:" + arrayList4);
            }
            if (!arrayList.isEmpty() && (qQAppInterface = this.H) != null) {
                ContactReportUtils.i(qQAppInterface, 24, arrayList, arrayList2, arrayList3, arrayList4, 0, "1", arrayList5, arrayList6, arrayList7);
            }
        }
    }

    public void s(List<MayKnowRecommend> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) list);
            return;
        }
        this.F.clear();
        if (list != null && list.size() > 0) {
            this.F.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.J == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.RecommendsAdapter", 2, "stopVisibleExpose firstVisible: " + this.J.getFirstVisiblePosition() + " lastvisible: " + this.J.getLastVisiblePosition());
        }
        XListView xListView = this.J;
        if (xListView != null) {
            xListView.removeCallbacks(this.N);
        }
    }
}
