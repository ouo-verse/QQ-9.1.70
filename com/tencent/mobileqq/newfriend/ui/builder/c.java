package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends d implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private NewFriendServiceImpl C;
    protected int D;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a extends d.b {
        static IPatchRedirector $redirector_;
        public TextView I;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public static void r(Activity activity, AllInOne allInOne, int i3, Bundle bundle) {
        if (activity != null) {
            try {
                Intent intent = ProfileUtils.getIntent(activity, allInOne);
                intent.addFlags(536870912);
                if (bundle != null) {
                    intent.putExtra(IProfileCardConst.KEY_PROFILE_EXTRA, bundle);
                }
                activity.startActivityForResult(intent, i3);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("MayKnowRecommendBuilder", 2, e16.toString());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected void e() {
        List<MayKnowRecommend.MayKnowRecommendLabel> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(this.f254107d)) {
            Context context = this.f254107d;
            QQToast.makeText(context, context.getResources().getString(R.string.b3j), 0).show(this.f254107d.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        String str = ((com.tencent.mobileqq.newfriend.msg.d) this.f254111i).f254031d.uin;
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).cancelMayKnowRecommend(str, this.f254108e);
        this.f254109f.i(this);
        this.f254109f.h(200L);
        ReportController.o(this.f254108e, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
        MayKnowRecommend mayKnowRecommend = ((com.tencent.mobileqq.newfriend.msg.d) this.f254111i).f254031d;
        if (mayKnowRecommend != null) {
            list = mayKnowRecommend.msgLabel;
        } else {
            list = null;
        }
        int a16 = this.f254109f.a();
        IAddFriendTempApi iAddFriendTempApi = (IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class);
        AppInterface appInterface = this.f254108e;
        com.tencent.mobileqq.newfriend.msg.i iVar = this.f254111i;
        iAddFriendTempApi.reportRecommend(appInterface, str, "frd_list_dlt", a16, 0, ((com.tencent.mobileqq.newfriend.msg.d) iVar).f254031d.recommendReason, this.D, ((com.tencent.mobileqq.newfriend.msg.d) iVar).f254031d.algBuffer, ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getRecommendLabelString(list), 0);
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    public View h(int i3, View view) {
        a aVar;
        View view2 = view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) view2);
        }
        if (view2 != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            view2 = d(this.f254107d, R.layout.f168886cc0, aVar);
            aVar.f254114d = (ImageView) view2.findViewById(R.id.f163821d);
            aVar.f254115e = (TextView) view2.findViewById(R.id.nickname);
            aVar.f254119m = (TextView) view2.findViewById(R.id.f166787i92);
            aVar.f254118i = (Button) view2.findViewById(R.id.i8s);
            TroopLabelLayout troopLabelLayout = (TroopLabelLayout) view2.findViewById(R.id.jzj);
            aVar.F = troopLabelLayout;
            troopLabelLayout.setLabelType(4);
            aVar.G = (TextView) view2.findViewById(R.id.f166195ls0);
            aVar.I = (TextView) view2.findViewById(R.id.m_3);
            a(aVar.f254114d);
            view2.setTag(aVar);
        }
        View view3 = view2;
        a aVar2 = aVar;
        aVar2.leftView.setTag(aVar2);
        aVar2.leftView.setOnClickListener(this);
        l(this.f254107d, view3, i3, this.f254111i, aVar2, this);
        com.tencent.mobileqq.newfriend.msg.i iVar = this.f254111i;
        MayKnowRecommend mayKnowRecommend = ((com.tencent.mobileqq.newfriend.msg.d) iVar).f254031d;
        if (!iVar.b()) {
            com.tencent.mobileqq.newfriend.utils.a.h(aVar2.leftView, true);
            if (Utils.G(String.valueOf(mayKnowRecommend.uin))) {
                ReportController.o(this.f254108e, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
            }
        } else {
            com.tencent.mobileqq.newfriend.utils.a.h(aVar2.leftView, false);
        }
        StringBuilder sb5 = new StringBuilder(256);
        String displayName = mayKnowRecommend.getDisplayName();
        if (!TextUtils.isEmpty(displayName)) {
            aVar2.f254115e.setVisibility(0);
            aVar2.f254115e.setText(displayName);
            if (AppSetting.f99565y) {
                sb5.append(displayName);
            }
        } else {
            aVar2.f254115e.setVisibility(8);
        }
        if (!TextUtils.isEmpty(mayKnowRecommend.uin) && Utils.G(mayKnowRecommend.uin)) {
            Drawable drawable = this.f254107d.getResources().getDrawable(R.drawable.br7);
            drawable.setBounds(0, 0, ViewUtils.dpToPx(15.0f), ViewUtils.dpToPx(15.0f));
            aVar2.f254115e.setCompoundDrawables(null, null, drawable, null);
        } else {
            aVar2.f254115e.setCompoundDrawables(null, null, null, null);
        }
        if (TextUtils.isEmpty(mayKnowRecommend.recommendReason)) {
            TextView textView = aVar2.G;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            TextView textView2 = aVar2.G;
            if (textView2 != null) {
                textView2.setText(mayKnowRecommend.recommendReason);
            }
            if (AppSetting.f99565y) {
                sb5.append(",");
                sb5.append(mayKnowRecommend.recommendReason);
            }
        }
        aVar2.F.i(RecommendLabel.convertToRecommendLabel(mayKnowRecommend.msgLabel), mayKnowRecommend.gender, mayKnowRecommend.age);
        int i16 = mayKnowRecommend.friendStatus;
        if (i16 == 0) {
            aVar2.f254118i.setOnClickListener(this);
            aVar2.f254118i.setVisibility(0);
            aVar2.f254118i.setText(HardCodeUtil.qqStr(R.string.f170028dd));
            aVar2.f254118i.setTag(mayKnowRecommend);
            aVar2.f254119m.setVisibility(8);
            if (AppSetting.f99565y) {
                sb5.append(",\u70b9\u51fb\u6dfb\u52a0");
                aVar2.f254118i.setContentDescription(HardCodeUtil.qqStr(R.string.f170028dd));
            }
        } else if (i16 == 1) {
            aVar2.f254118i.setVisibility(8);
            aVar2.f254119m.setVisibility(0);
            aVar2.f254119m.setText(R.string.f173067h24);
            if (AppSetting.f99565y) {
                sb5.append(",\u7b49\u5f85\u9a8c\u8bc1");
                aVar2.f254119m.setContentDescription(HardCodeUtil.qqStr(R.string.l2b));
            }
        } else {
            aVar2.f254118i.setVisibility(8);
            aVar2.f254119m.setVisibility(0);
            aVar2.f254119m.setText(R.string.f170322m9);
            if (AppSetting.f99565y) {
                sb5.append(",\u5df2\u6dfb\u52a0");
                aVar2.f254119m.setContentDescription(HardCodeUtil.qqStr(R.string.f170322m9));
            }
        }
        if (AppSetting.f99565y) {
            view3.setContentDescription(sb5.toString());
        }
        String str = mayKnowRecommend.uin;
        aVar2.D = str;
        aVar2.f254114d.setImageBitmap(this.f254109f.c(1, str));
        s(aVar2.I, mayKnowRecommend);
        if (QQTheme.isNowThemeIsNight()) {
            com.tencent.mobileqq.newfriend.utils.a.e(aVar2.f254119m, aVar2.f254116f, aVar2.f254117h);
        }
        return view3;
    }

    public byte[] n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return ((com.tencent.mobileqq.newfriend.msg.d) this.f254111i).f254031d.algBuffer;
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.D;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MayKnowRecommend mayKnowRecommend;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            int a16 = this.f254109f.a();
            int id5 = view.getId();
            int i3 = 1;
            if (id5 == R.id.ibi) {
                if ((view.getTag() instanceof a) && (mayKnowRecommend = ((com.tencent.mobileqq.newfriend.msg.d) this.f254111i).f254031d) != null) {
                    if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(mayKnowRecommend.uin), "MayKnowRecommendBuilder")) {
                        i3 = 110;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MayKnowRecommendBuilder", 2, "onClick rlSystemMsg\uff0c friendtype=" + i3 + ", gameSourceId=" + mayKnowRecommend.recommendReason);
                    }
                    AllInOne allInOne = new AllInOne(mayKnowRecommend.uin, i3);
                    String recommendName = mayKnowRecommend.getRecommendName();
                    if (!TextUtils.isEmpty(recommendName)) {
                        allInOne.recommendName = recommendName;
                    }
                    if (!TextUtils.isEmpty(mayKnowRecommend.nick)) {
                        allInOne.nickname = mayKnowRecommend.nick;
                    }
                    String recommendLabelString = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getRecommendLabelString(mayKnowRecommend.msgLabel);
                    allInOne.profileEntryType = 88;
                    Bundle bundle = new Bundle();
                    bundle.putString("recommend_entry_type", "3");
                    bundle.putString("recommend_reason", mayKnowRecommend.getMultiReason());
                    bundle.putInt("recommend_pos", this.D);
                    bundle.putByteArray("recommend_algh_id", mayKnowRecommend.algBuffer);
                    bundle.putString("recommend_label", recommendLabelString);
                    bundle.putInt("tabID", a16);
                    r((Activity) this.f254107d, allInOne, 228, bundle);
                    this.C.markRecommendReaded();
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).reportRecommend(this.f254108e, mayKnowRecommend.uin, "frd_list_clk", a16, 0, mayKnowRecommend.recommendReason, this.D, mayKnowRecommend.algBuffer, recommendLabelString, 0);
                }
            } else if (id5 == R.id.i8s) {
                Object tag = view.getTag();
                if (tag instanceof MayKnowRecommend) {
                    if (!NetworkUtil.isNetworkAvailable(this.f254107d)) {
                        Context context = this.f254107d;
                        QQToast.makeText(context, context.getResources().getString(R.string.b3j), 0).show(g());
                    } else {
                        MayKnowRecommend mayKnowRecommend2 = (MayKnowRecommend) tag;
                        IFriendDataService iFriendDataService = (IFriendDataService) this.f254108e.getRuntimeService(IFriendDataService.class, "");
                        IAddFriendServiceApi iAddFriendServiceApi = (IAddFriendServiceApi) this.f254108e.getRuntimeService(IAddFriendServiceApi.class, "");
                        if (!iFriendDataService.isFriend(mayKnowRecommend2.uin) && !iAddFriendServiceApi.hasSendAddFriendReq(mayKnowRecommend2.uin)) {
                            String displayName = mayKnowRecommend2.getDisplayName();
                            int a17 = this.f254109f.a();
                            IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
                            Context context2 = this.f254107d;
                            Intent startAddFriend = iAddFriendApi.startAddFriend(context2, 1, mayKnowRecommend2.uin, null, 3045, a17, displayName, null, null, context2.getString(R.string.f170028dd), null);
                            ReportController.o(this.f254108e, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(a17), "", "", "");
                            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity) this.f254107d, startAddFriend, 228);
                        } else if (iFriendDataService.isFriend(mayKnowRecommend2.uin)) {
                            mayKnowRecommend2.friendStatus = 2;
                            this.f254109f.notifyDataSetChanged();
                        } else {
                            mayKnowRecommend2.friendStatus = 1;
                            this.f254109f.notifyDataSetChanged();
                        }
                        this.C.markRecommendReaded();
                        ReportController.o(this.f254108e, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
                        if (Utils.G(String.valueOf(mayKnowRecommend2.uin))) {
                            ReportController.o(this.f254108e, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
                        }
                        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).reportRecommend(this.f254108e, mayKnowRecommend2.uin, "frd_list_add", a16, 1, mayKnowRecommend2.recommendReason, this.D, mayKnowRecommend2.algBuffer, ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getRecommendLabelString(mayKnowRecommend2.msgLabel), 0);
                    }
                }
            } else {
                i(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ((com.tencent.mobileqq.newfriend.msg.d) this.f254111i).f254031d.recommendReason;
    }

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return ((com.tencent.mobileqq.newfriend.msg.d) this.f254111i).f254031d.uin;
    }

    public void s(TextView textView, MayKnowRecommend mayKnowRecommend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) textView, (Object) mayKnowRecommend);
            return;
        }
        if (mayKnowRecommend == null) {
            return;
        }
        String displayName = mayKnowRecommend.getDisplayName();
        if (!TextUtils.isEmpty(mayKnowRecommend.mobile_name) && !displayName.equals(mayKnowRecommend.mobile_name)) {
            textView.setText("(" + mayKnowRecommend.mobile_name + ")");
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }
}
