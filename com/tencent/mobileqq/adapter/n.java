package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendFaceApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n extends j {
    static IPatchRedirector $redirector_;
    QQAppInterface F;
    private Context G;
    CardHandler H;
    private List<b> I;
    private TroopManager J;
    private com.tencent.mobileqq.app.n K;
    private boolean L;
    private c M;
    private View.OnClickListener N;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                n.this.M.b(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f187219a;

        /* renamed from: b, reason: collision with root package name */
        public int f187220b;

        /* renamed from: c, reason: collision with root package name */
        public String f187221c;

        /* renamed from: d, reason: collision with root package name */
        public RecentUser f187222d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        boolean a(String str, int i3);

        void b(View view);
    }

    public n(Context context, QQAppInterface qQAppInterface, XListView xListView, List<RecentUser> list, c cVar) {
        super(context, qQAppInterface, xListView, 1, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, xListView, list, cVar);
            return;
        }
        this.I = new ArrayList();
        this.N = new a();
        o(qQAppInterface);
        this.G = context;
        this.M = cVar;
        n(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(ArrayList arrayList) {
        this.I = arrayList;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(List list) {
        final ArrayList<b> m3 = m(list);
        if (m3 != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.adapter.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.k(m3);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.I.size();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return this.I.get(i3);
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0139  */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View] */
    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        k kVar;
        ForwardRecentItemView forwardRecentItemView;
        Drawable avatarDrawable;
        Drawable drawable;
        ResultRecord resultRecord;
        boolean z16;
        ForwardRecentItemView forwardRecentItemView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            forwardRecentItemView2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (view == null) {
                ForwardRecentItemView forwardRecentItemView3 = new ForwardRecentItemView(this.G);
                kVar = new k();
                forwardRecentItemView3.setTag(kVar);
                forwardRecentItemView = forwardRecentItemView3;
            } else {
                ForwardRecentItemView forwardRecentItemView4 = (ForwardRecentItemView) view;
                kVar = (k) forwardRecentItemView4.getTag();
                forwardRecentItemView = forwardRecentItemView4;
            }
            b bVar = (b) getItem(i3);
            kVar.f187210d = bVar.f187221c;
            kVar.f187211e = bVar.f187220b;
            kVar.f187212f = forwardRecentItemView.f187013m;
            if (bVar.f187222d.getType() != 10014 && bVar.f187222d.getType() != 10027) {
                if (AppConstants.DATALINE_PC_UIN.equals(bVar.f187221c)) {
                    avatarDrawable = this.G.getResources().getDrawable(R.drawable.qfile_dataline_pc_recent);
                } else if (bVar.f187222d.getType() == 1046) {
                    avatarDrawable = ((IMatchFriendFaceApi) QRoute.api(IMatchFriendFaceApi.class)).getMatchFriendFaceDrawable(this.F, Long.parseLong(bVar.f187221c));
                } else {
                    drawable = new BitmapDrawable(c(bVar.f187220b, bVar.f187221c));
                    boolean a16 = this.M.a(bVar.f187221c, bVar.f187222d.getType());
                    resultRecord = forwardRecentItemView.J;
                    if (resultRecord == null) {
                        resultRecord = new ResultRecord();
                    }
                    resultRecord.init(bVar.f187221c, bVar.f187219a, bVar.f187222d.getType(), bVar.f187222d.troopUin, "");
                    if (bVar.f187222d.getType() != 3000) {
                        DiscussionInfo h16 = this.K.h(bVar.f187221c);
                        if (h16 != null && !h16.hasRenamed()) {
                            forwardRecentItemView.a(bVar.f187219a, String.valueOf(this.K.q(bVar.f187221c)), drawable, resultRecord, this.L, a16);
                        } else {
                            forwardRecentItemView.a(bVar.f187219a, null, drawable, resultRecord, this.L, a16);
                        }
                    } else {
                        TroopInfo k3 = this.J.k(bVar.f187221c);
                        if (k3 != null && !k3.hasSetTroopName() && k3.getMemberNumClient() > 0) {
                            forwardRecentItemView.a(bVar.f187219a, String.valueOf(k3.getMemberNumClient()), drawable, resultRecord, this.L, a16);
                        } else {
                            if (k3 == null && com.tencent.mobileqq.troop.utils.k.l(this.F, bVar.f187221c)) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            forwardRecentItemView.b(bVar.f187219a, "", drawable, resultRecord, this.L, a16, z16);
                        }
                    }
                    if (bVar.f187222d.getType() == 10027) {
                        resultRecord.type = 10027;
                    }
                    forwardRecentItemView.setOnClickListener(this.N);
                    forwardRecentItemView2 = forwardRecentItemView;
                }
            } else {
                avatarDrawable = ((IQQGuildService) this.F.getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(bVar.f187222d.troopUin, 100, null, true);
            }
            drawable = avatarDrawable;
            boolean a162 = this.M.a(bVar.f187221c, bVar.f187222d.getType());
            resultRecord = forwardRecentItemView.J;
            if (resultRecord == null) {
            }
            resultRecord.init(bVar.f187221c, bVar.f187219a, bVar.f187222d.getType(), bVar.f187222d.troopUin, "");
            if (bVar.f187222d.getType() != 3000) {
            }
            if (bVar.f187222d.getType() == 10027) {
            }
            forwardRecentItemView.setOnClickListener(this.N);
            forwardRecentItemView2 = forwardRecentItemView;
        }
        ForwardRecentItemView forwardRecentItemView5 = forwardRecentItemView2;
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return forwardRecentItemView5;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x0077. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<b> m(List<RecentUser> list) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
        }
        String str2 = null;
        if (list == null) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList<>(list.size());
        int i3 = 0;
        while (i3 < list.size()) {
            RecentUser recentUser = list.get(i3);
            b bVar = new b();
            String str3 = recentUser.uin;
            int type = recentUser.getType();
            int i16 = 1;
            if (type != 0) {
                if (type != 1) {
                    if (type != 1000 && type != 1001) {
                        if (type != 1008) {
                            if (type != 1046) {
                                if (type != 3000) {
                                    if (type != 6002) {
                                        if (type != 10002 && type != 10004 && type != 10008 && type != 10010) {
                                            if (type != 10014) {
                                                if (type != 10027) {
                                                    switch (type) {
                                                        case 1003:
                                                        case 1004:
                                                        case 1005:
                                                            break;
                                                        case 1006:
                                                            String m06 = com.tencent.mobileqq.utils.ac.m0(this.F, str3);
                                                            PhoneContact queryContactByCodeNumber = ((IPhoneContactService) this.F.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(str3);
                                                            if (queryContactByCodeNumber != null) {
                                                                str = queryContactByCodeNumber.name;
                                                            } else if (m06 != null) {
                                                                str = com.tencent.mobileqq.utils.ac.g(this.F, m06, true);
                                                            } else {
                                                                str = str3;
                                                            }
                                                            i16 = 11;
                                                            break;
                                                        default:
                                                            switch (type) {
                                                                case 1020:
                                                                case 1022:
                                                                case 1023:
                                                                case 1024:
                                                                case 1025:
                                                                    break;
                                                                case 1021:
                                                                    str = com.tencent.mobileqq.utils.ac.g(this.F, str3, true);
                                                                    break;
                                                                default:
                                                                    str = str2;
                                                                    break;
                                                            }
                                                    }
                                                } else {
                                                    IGProGuildInfo guildInfo = ((IGPSService) this.F.getRuntimeService(IGPSService.class, "")).getGuildInfo(recentUser.uin);
                                                    if (guildInfo != null) {
                                                        str = guildInfo.getGuildName();
                                                    } else {
                                                        str = str2;
                                                    }
                                                    i16 = 117;
                                                }
                                            } else {
                                                IGPSService iGPSService = (IGPSService) this.F.getRuntimeService(IGPSService.class, "");
                                                IGProGuildInfo guildInfo2 = iGPSService.getGuildInfo(recentUser.troopUin);
                                                IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str3);
                                                if (guildInfo2 != null && channelInfo != null) {
                                                    str = guildInfo2.getGuildName() + "|" + channelInfo.getChannelName();
                                                }
                                                str = str2;
                                            }
                                        }
                                    } else {
                                        str = recentUser.displayName;
                                        i16 = 104;
                                    }
                                } else {
                                    DiscussionInfo h16 = this.K.h(str3);
                                    if (h16 != null && !h16.isHidden()) {
                                        if (TextUtils.isEmpty(h16.discussionName)) {
                                            str = recentUser.displayName;
                                        } else {
                                            str = h16.discussionName;
                                        }
                                        if (TextUtils.isEmpty(str)) {
                                            str = this.G.getResources().getString(R.string.as8);
                                        }
                                        i16 = 101;
                                    }
                                    i3++;
                                    str2 = null;
                                }
                            } else {
                                str = recentUser.displayName;
                                i16 = 202;
                            }
                        } else {
                            PublicAccountInfo publicAccountInfo = (PublicAccountInfo) ((IPublicAccountDataManager) this.F.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(str3);
                            if (publicAccountInfo != null) {
                                str = publicAccountInfo.name;
                            }
                            str = str2;
                        }
                    }
                } else {
                    TroopInfo k3 = this.J.k(str3);
                    if (k3 != null) {
                        str = k3.getTroopDisplayName();
                    } else {
                        str = recentUser.displayName;
                    }
                    i16 = 4;
                    if (str == null || str.trim().equals("")) {
                        str = str3;
                    }
                }
                if (AppConstants.DATALINE_PC_UIN.equals(str3)) {
                    str = HardCodeUtil.qqStr(R.string.cf5);
                }
                if (TextUtils.isEmpty(str)) {
                    str = str3;
                }
                bVar.f187219a = str;
                bVar.f187220b = i16;
                bVar.f187221c = str3;
                bVar.f187222d = recentUser;
                arrayList.add(bVar);
                i3++;
                str2 = null;
            }
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str3);
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            aVar.c(0);
            aVar.d(uidFromUin);
            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            if (type != 1000 && type != 1020) {
                if (type == 1004) {
                    nameWithConfig = com.tencent.mobileqq.utils.ac.n(this.F, recentUser.troopUin, str3);
                }
                z16 = 1;
            } else {
                z16 = 1;
                nameWithConfig = com.tencent.mobileqq.utils.ac.j0(this.F, str3, this.J.G(recentUser.troopUin), recentUser.troopUin, true, null);
            }
            if (nameWithConfig == null || "".equals(nameWithConfig)) {
                nameWithConfig = com.tencent.mobileqq.utils.ac.g(this.F, str3, z16);
            }
            if (!TextUtils.isEmpty(nameWithConfig) && !nameWithConfig.equals(com.tencent.mobileqq.filemanager.fileassistant.util.h.g(this.F))) {
                str = nameWithConfig;
            } else {
                str = recentUser.displayName;
            }
            i16 = z16;
            if (AppConstants.DATALINE_PC_UIN.equals(str3)) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            bVar.f187219a = str;
            bVar.f187220b = i16;
            bVar.f187221c = str3;
            bVar.f187222d = recentUser;
            arrayList.add(bVar);
            i3++;
            str2 = null;
        }
        return arrayList;
    }

    public void n(final List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.adapter.l
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.l(list);
                }
            }, 32, null, false);
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardRecentListAdapter", 2, "notifyDataSetChanged() called");
        }
        super.notifyDataSetChanged();
    }

    public void o(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.F = qQAppInterface;
        this.H = (CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        this.J = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        this.K = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    }

    public void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.L = z16;
        }
    }
}
