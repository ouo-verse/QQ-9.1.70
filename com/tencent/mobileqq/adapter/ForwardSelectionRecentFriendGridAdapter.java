package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.n;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ForwardSelectionRecentFriendGridAdapter extends BaseAdapter implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private TroopManager C;
    private com.tencent.mobileqq.app.n D;
    private boolean E;
    private n.c F;
    protected IFaceDecoder G;
    private Hashtable<String, Bitmap> H;
    private View.OnClickListener I;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f187024d;

    /* renamed from: e, reason: collision with root package name */
    private Context f187025e;

    /* renamed from: f, reason: collision with root package name */
    CardHandler f187026f;

    /* renamed from: h, reason: collision with root package name */
    private FriendsManager f187027h;

    /* renamed from: i, reason: collision with root package name */
    private HorizontalListView f187028i;

    /* renamed from: m, reason: collision with root package name */
    private List<b> f187029m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSelectionRecentFriendGridAdapter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ForwardSelectionRecentFriendGridAdapter.this.F.b(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f187034a;

        /* renamed from: b, reason: collision with root package name */
        public int f187035b;

        /* renamed from: c, reason: collision with root package name */
        public String f187036c;

        /* renamed from: d, reason: collision with root package name */
        public RecentUser f187037d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ForwardSelectionRecentFriendGridAdapter(Context context, QQAppInterface qQAppInterface, HorizontalListView horizontalListView, List<RecentUser> list, n.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, qQAppInterface, horizontalListView, list, cVar);
            return;
        }
        this.f187029m = new ArrayList();
        this.H = new Hashtable<>();
        this.I = new a();
        f(qQAppInterface);
        this.f187028i = horizontalListView;
        this.f187025e = context;
        this.F = cVar;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.G = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.f187028i.setOverScrollMode(2);
        this.f187028i.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        this.f187028i.setDivider(this.f187025e.getDrawable(R.drawable.jnt));
        this.f187028i.setPadding(ViewUtils.dpToPx(16.0f), 0, ViewUtils.dpToPx(16.0f), 0);
        e(list.subList(0, Math.min(5, list.size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x005f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<b> d(List<RecentUser> list) {
        String str;
        if (list == null) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList<>(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            RecentUser recentUser = list.get(i3);
            b bVar = new b();
            String str2 = recentUser.uin;
            int type = recentUser.getType();
            int type2 = recentUser.getType();
            int i16 = 1;
            if (type2 != 0) {
                if (type2 != 1) {
                    if (type2 != 1000 && type2 != 1001) {
                        if (type2 != 1008) {
                            if (type2 != 3000) {
                                if (type2 != 6002) {
                                    if (type2 != 10002 && type2 != 10004 && type2 != 10008 && type2 != 10010) {
                                        if (type2 != 10014) {
                                            if (type2 != 10027) {
                                                switch (type2) {
                                                    case 1003:
                                                    case 1004:
                                                    case 1005:
                                                        break;
                                                    case 1006:
                                                        String m06 = com.tencent.mobileqq.utils.ac.m0(this.f187024d, str2);
                                                        PhoneContact queryContactByCodeNumber = ((IPhoneContactService) this.f187024d.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(str2);
                                                        if (queryContactByCodeNumber != null) {
                                                            str = queryContactByCodeNumber.name;
                                                        } else if (m06 != null) {
                                                            str = com.tencent.mobileqq.utils.ac.g(this.f187024d, m06, true);
                                                        } else {
                                                            str = str2;
                                                        }
                                                        i16 = 11;
                                                        break;
                                                    default:
                                                        switch (type2) {
                                                            case 1020:
                                                            case 1022:
                                                            case 1023:
                                                            case 1024:
                                                            case 1025:
                                                                break;
                                                            case 1021:
                                                                str = com.tencent.mobileqq.utils.ac.g(this.f187024d, str2, true);
                                                                break;
                                                            default:
                                                                str = null;
                                                                break;
                                                        }
                                                }
                                            } else {
                                                IGProGuildInfo guildInfo = ((IGPSService) this.f187024d.getRuntimeService(IGPSService.class, "")).getGuildInfo(recentUser.troopUin);
                                                if (guildInfo != null) {
                                                    str = guildInfo.getGuildName();
                                                } else {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("ForwardRecentListAdapter", 2, "guidInf is null, recentUser:" + recentUser);
                                                    }
                                                    str = null;
                                                }
                                            }
                                        } else {
                                            IGPSService iGPSService = (IGPSService) this.f187024d.getRuntimeService(IGPSService.class, "");
                                            IGProGuildInfo guildInfo2 = iGPSService.getGuildInfo(recentUser.troopUin);
                                            IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str2);
                                            if (guildInfo2 != null && channelInfo != null) {
                                                str = guildInfo2.getGuildName() + "|" + channelInfo.getChannelName();
                                            }
                                            str = null;
                                        }
                                    }
                                } else {
                                    str = recentUser.displayName;
                                    i16 = 104;
                                }
                            } else {
                                DiscussionInfo h16 = this.D.h(str2);
                                if (h16 != null && !h16.isHidden()) {
                                    if (TextUtils.isEmpty(h16.discussionName)) {
                                        str = recentUser.displayName;
                                    } else {
                                        str = h16.discussionName;
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        str = this.f187025e.getResources().getString(R.string.as8);
                                    }
                                    i16 = 101;
                                }
                            }
                        } else {
                            PublicAccountInfo publicAccountInfo = (PublicAccountInfo) ((IPublicAccountDataManager) this.f187024d.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(str2);
                            if (publicAccountInfo != null) {
                                str = publicAccountInfo.name;
                            }
                            str = null;
                        }
                    }
                } else {
                    TroopInfo k3 = this.C.k(str2);
                    if (k3 != null) {
                        str = k3.getTroopDisplayName();
                    } else {
                        str = recentUser.displayName;
                    }
                    i16 = 4;
                    if (str == null || str.trim().equals("")) {
                        str = str2;
                    }
                }
                if (AppConstants.DATALINE_PC_UIN.equals(str2)) {
                    str = HardCodeUtil.qqStr(R.string.cf5);
                }
                if (!AppConstants.DATALINE_PHONE_UIN.equals(str2) && !AppConstants.DATALINE_IPAD_UIN.equals(str2)) {
                    if (TextUtils.isEmpty(str)) {
                        str = str2;
                    }
                    bVar.f187034a = str;
                    bVar.f187035b = i16;
                    bVar.f187036c = str2;
                    bVar.f187037d = recentUser;
                    arrayList.add(bVar);
                }
            }
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            aVar.d(uidFromUin);
            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            if (type != 1000 && type != 1020) {
                if (type == 1004) {
                    nameWithConfig = com.tencent.mobileqq.utils.ac.n(this.f187024d, recentUser.troopUin, str2);
                }
            } else {
                nameWithConfig = com.tencent.mobileqq.utils.ac.j0(this.f187024d, str2, this.C.G(recentUser.troopUin), recentUser.troopUin, true, null);
            }
            if (nameWithConfig == null || "".equals(nameWithConfig)) {
                nameWithConfig = com.tencent.mobileqq.utils.ac.g(this.f187024d, str2, true);
            }
            if (!TextUtils.isEmpty(nameWithConfig) && !nameWithConfig.equals(com.tencent.mobileqq.filemanager.fileassistant.util.h.g(this.f187024d))) {
                str = nameWithConfig;
            } else {
                str = recentUser.displayName;
            }
            if (AppConstants.DATALINE_PC_UIN.equals(str2)) {
            }
            if (!AppConstants.DATALINE_PHONE_UIN.equals(str2)) {
                if (TextUtils.isEmpty(str)) {
                }
                bVar.f187034a = str;
                bVar.f187035b = i16;
                bVar.f187036c = str2;
                bVar.f187037d = recentUser;
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void e(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            ThreadManagerV2.excute(new Runnable(list) { // from class: com.tencent.mobileqq.adapter.ForwardSelectionRecentFriendGridAdapter.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f187030d;

                {
                    this.f187030d = list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardSelectionRecentFriendGridAdapter.this, (Object) list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ArrayList d16 = ForwardSelectionRecentFriendGridAdapter.this.d(this.f187030d);
                        if (d16 != null && d16.size() > 0) {
                            ThreadManager.getUIHandler().post(new Runnable(d16) { // from class: com.tencent.mobileqq.adapter.ForwardSelectionRecentFriendGridAdapter.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ ArrayList f187031d;

                                {
                                    this.f187031d = d16;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) d16);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    ForwardSelectionRecentFriendGridAdapter.this.f187029m = this.f187031d;
                                    ForwardSelectionRecentFriendGridAdapter.this.notifyDataSetChanged();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 16, null, true);
        }
    }

    public void f(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f187024d = qQAppInterface;
        this.f187026f = (CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        this.f187027h = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.C = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        this.D = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.E = z16;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f187029m.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        return this.f187029m.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0164  */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        k kVar;
        ForwardRecentRoundItemView forwardRecentRoundItemView;
        Drawable avatarDrawable;
        Drawable drawable;
        ResultRecord resultRecord;
        TroopInfo k3;
        String str;
        QQProAvatarDrawable qQProAvatarDrawable;
        ForwardRecentRoundItemView forwardRecentRoundItemView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            forwardRecentRoundItemView2 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (view == null) {
                ForwardRecentRoundItemView forwardRecentRoundItemView3 = new ForwardRecentRoundItemView(this.f187025e);
                kVar = new k();
                forwardRecentRoundItemView3.setTag(kVar);
                forwardRecentRoundItemView = forwardRecentRoundItemView3;
            } else {
                ForwardRecentRoundItemView forwardRecentRoundItemView4 = (ForwardRecentRoundItemView) view;
                kVar = (k) forwardRecentRoundItemView4.getTag();
                forwardRecentRoundItemView = forwardRecentRoundItemView4;
            }
            b bVar = (b) getItem(i3);
            int i16 = bVar.f187037d.type;
            Drawable drawable2 = null;
            if (i16 != 10014 && i16 != 10027) {
                if (AppConstants.DATALINE_PC_UIN.equals(bVar.f187036c)) {
                    avatarDrawable = this.f187025e.getResources().getDrawable(R.drawable.qfile_dataline_pc_recent);
                } else if (AppConstants.DATALINE_PHONE_UIN.equals(bVar.f187036c)) {
                    avatarDrawable = this.f187025e.getResources().getDrawable(R.drawable.qfile_dataline_user_aio);
                } else if (AppConstants.DATALINE_IPAD_UIN.equals(bVar.f187036c)) {
                    avatarDrawable = this.f187025e.getResources().getDrawable(R.drawable.qfile_dataline_ipad_recent);
                } else {
                    ImageView imageView = forwardRecentRoundItemView.f187021h;
                    if (imageView != null) {
                        drawable2 = imageView.getDrawable();
                    }
                    if (drawable2 instanceof QQProAvatarDrawable) {
                        qQProAvatarDrawable = (QQProAvatarDrawable) drawable2;
                    } else {
                        qQProAvatarDrawable = new QQProAvatarDrawable();
                    }
                    qQProAvatarDrawable.q(this.f187025e, bVar.f187035b, bVar.f187036c);
                    drawable = qQProAvatarDrawable;
                    boolean a16 = this.F.a(bVar.f187036c, bVar.f187037d.getType());
                    resultRecord = forwardRecentRoundItemView.F;
                    if (resultRecord == null) {
                        resultRecord = new ResultRecord();
                    }
                    ResultRecord resultRecord2 = resultRecord;
                    resultRecord2.init(bVar.f187036c, bVar.f187034a, bVar.f187037d.getType(), bVar.f187037d.troopUin, "");
                    if (bVar.f187037d.getType() != 10014 || bVar.f187037d.getType() == 10027) {
                        RecentUser recentUser = bVar.f187037d;
                        resultRecord2.guildId = recentUser.troopUin;
                        resultRecord2.type = recentUser.type;
                    }
                    String str2 = bVar.f187034a;
                    if (bVar.f187037d.getType() != 3000) {
                        DiscussionInfo h16 = this.D.h(bVar.f187036c);
                        if (h16 != null && !h16.hasRenamed()) {
                            str2 = str2 + "(" + String.valueOf(this.D.q(bVar.f187036c)) + ")";
                        }
                    } else if (bVar.f187037d.getType() == 1 && (k3 = this.C.k(bVar.f187036c)) != null && !k3.hasSetTroopName() && k3.getMemberNumClient() > 0) {
                        str = str2 + "(" + String.valueOf(k3.getMemberNumClient()) + ")";
                        forwardRecentRoundItemView.a(str, drawable, resultRecord2, this.E, a16);
                        forwardRecentRoundItemView.setOnClickListener(this.I);
                        kVar.f187210d = bVar.f187036c;
                        kVar.f187211e = bVar.f187035b;
                        kVar.f187212f = forwardRecentRoundItemView.f187021h;
                        forwardRecentRoundItemView2 = forwardRecentRoundItemView;
                    }
                    str = str2;
                    forwardRecentRoundItemView.a(str, drawable, resultRecord2, this.E, a16);
                    forwardRecentRoundItemView.setOnClickListener(this.I);
                    kVar.f187210d = bVar.f187036c;
                    kVar.f187211e = bVar.f187035b;
                    kVar.f187212f = forwardRecentRoundItemView.f187021h;
                    forwardRecentRoundItemView2 = forwardRecentRoundItemView;
                }
            } else {
                avatarDrawable = ((IQQGuildService) this.f187024d.getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(bVar.f187037d.troopUin, 100, null, true);
            }
            drawable = avatarDrawable;
            boolean a162 = this.F.a(bVar.f187036c, bVar.f187037d.getType());
            resultRecord = forwardRecentRoundItemView.F;
            if (resultRecord == null) {
            }
            ResultRecord resultRecord22 = resultRecord;
            resultRecord22.init(bVar.f187036c, bVar.f187034a, bVar.f187037d.getType(), bVar.f187037d.troopUin, "");
            if (bVar.f187037d.getType() != 10014) {
            }
            RecentUser recentUser2 = bVar.f187037d;
            resultRecord22.guildId = recentUser2.troopUin;
            resultRecord22.type = recentUser2.type;
            String str22 = bVar.f187034a;
            if (bVar.f187037d.getType() != 3000) {
            }
            str = str22;
            forwardRecentRoundItemView.a(str, drawable, resultRecord22, this.E, a162);
            forwardRecentRoundItemView.setOnClickListener(this.I);
            kVar.f187210d = bVar.f187036c;
            kVar.f187211e = bVar.f187035b;
            kVar.f187212f = forwardRecentRoundItemView.f187021h;
            forwardRecentRoundItemView2 = forwardRecentRoundItemView;
        }
        ForwardRecentRoundItemView forwardRecentRoundItemView5 = forwardRecentRoundItemView2;
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return forwardRecentRoundItemView5;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardRecentListAdapter", 2, "notifyDataSetChanged() called");
        }
        super.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        }
    }
}
