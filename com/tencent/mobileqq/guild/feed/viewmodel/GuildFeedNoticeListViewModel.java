package com.tencent.mobileqq.guild.feed.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.util.GuildNoticeKtKt;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.FirstViewDirectMsgNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAvChannelStateMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBeaconEventModel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBeaconStageModel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckInNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDeleteInteractReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedNoticesReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedNoticesRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTopFeedMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProManagerNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUPdateFeedInteractSwitchReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteFeedInteractNoticeCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedNoticesCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpdateFeedInteractBlockedStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildInteractiveNotificationCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import ij1.GuildNoticeNode;
import ij1.n;
import ij1.p;
import ij1.s;
import ij1.t;
import ij1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedNoticeListViewModel extends BaseViewModel {
    private String C;
    private GuildFeedBaseInitBean D;
    private n E;
    private t F;
    private s G;
    private IKernelGProGuildMsgListener H;

    /* renamed from: i, reason: collision with root package name */
    protected final MutableLiveData<UIStateData<List<v<?>>>> f224023i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private List<v<?>> f224024m = Collections.synchronizedList(new ArrayList());
    private int I = 1;
    private int J = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements IKernelGProGuildMsgListener {
        a() {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onBeaconReportCount(GProBeaconEventModel gProBeaconEventModel, GProBeaconStageModel gProBeaconStageModel) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.a(this, gProBeaconEventModel, gProBeaconStageModel);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onBeaconReportStage(GProBeaconEventModel gProBeaconEventModel, ArrayList arrayList) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.b(this, gProBeaconEventModel, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onFeedEventUpdate(FirstViewDirectMsgNotifyInfo firstViewDirectMsgNotifyInfo) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.c(this, firstViewDirectMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildAvChannelOpenUpdate(GProAvChannelStateMsg gProAvChannelStateMsg) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.d(this, gProAvChannelStateMsg);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildCheckInNotify(GProCheckInNotifyInfo gProCheckInNotifyInfo) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.e(this, gProCheckInNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildHelperNotifySwitchUpdate(HashMap hashMap) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.f(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildInteractiveUpdate(GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
            QLog.d("GuildFeedNoticeListViewModel", 1, "onGuildInteractiveUpdate  item.getGuildId()=" + guildInteractiveNotificationItem.getGuildId() + "   mFeedBaseBean.getGuildId()=" + GuildFeedNoticeListViewModel.this.D.getGuildId() + "   item.getType()=" + guildInteractiveNotificationItem.getType());
            if (guildInteractiveNotificationItem.updateFrom == 0 && guildInteractiveNotificationItem.getGuildId().equals(GuildFeedNoticeListViewModel.this.D.getGuildId()) && guildInteractiveNotificationItem.getType() == 2) {
                GuildFeedNoticeListViewModel.this.I2(guildInteractiveNotificationItem);
                GuildFeedNoticeListViewModel.this.J2(guildInteractiveNotificationItem);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildManagerEventUpdate(GProManagerNotice gProManagerNotice) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.h(this, gProManagerNotice);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildNewPostEvent(GProNewPostAndSystemPromptNotifyFeedEventData gProNewPostAndSystemPromptNotifyFeedEventData) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.i(this, gProNewPostAndSystemPromptNotifyFeedEventData);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildScheduleNotify(GProScheduleNotifyInfo gProScheduleNotifyInfo) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.j(this, gProScheduleNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildTopFeedUpdate(GProGuildTopFeedMsg gProGuildTopFeedMsg) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.k(this, gProGuildTopFeedMsg);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onMsgAbstractUpdate(ArrayList arrayList) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.l(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onUnreadCntAfterFirstView(HashMap hashMap) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.m(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onUnreadCntUpdate(HashMap hashMap) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.n(this, hashMap);
        }
    }

    private void D2(String str, int i3) {
        if (p2(str)) {
            QLog.e("GuildFeedNoticeListViewModel", 1, "invalid guildId:" + str);
            return;
        }
        QLog.i("GuildFeedNoticeListViewModel", 2, "reportRead -- guildId:" + str + ",type:" + i3);
        if (i3 == 1) {
            GuildNoticeKtKt.b(str, 6, null);
        } else if (i3 == 2) {
            GuildNoticeKtKt.b(str, 7, null);
        } else if (i3 == 3) {
            GuildNoticeKtKt.b(str, 13, null);
        }
    }

    private void E2(o oVar, GProGetFeedNoticesReq gProGetFeedNoticesReq, final boolean z16) {
        oVar.getFeedNotices(gProGetFeedNoticesReq, true, new IGProGetFeedNoticesCallback() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.e
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedNoticesCallback
            public final void onResult(int i3, String str, boolean z17, int i16, GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
                GuildFeedNoticeListViewModel.this.u2(z16, i3, str, z17, i16, gProGetFeedNoticesRsp);
            }
        });
    }

    private void F2(boolean z16, boolean z17) {
        o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 == null) {
            return;
        }
        GProGetFeedNoticesReq gProGetFeedNoticesReq = new GProGetFeedNoticesReq();
        gProGetFeedNoticesReq.pageNum = 10;
        if (z16 && !TextUtils.isEmpty(this.C)) {
            gProGetFeedNoticesReq.attachInfo = this.C;
        }
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.D;
        if (guildFeedBaseInitBean != null) {
            if (!TextUtils.isEmpty(guildFeedBaseInitBean.getGuildId())) {
                gProGetFeedNoticesReq.guildID = Long.parseLong(this.D.getGuildId());
            }
            if (!TextUtils.isEmpty(this.D.getChannelId())) {
                gProGetFeedNoticesReq.channelID = Long.parseLong(this.D.getChannelId());
            }
            if (this.D.getAttrs().containsKey("service_type")) {
                gProGetFeedNoticesReq.serviceType = ((Integer) this.D.getAttrs().get("service_type")).intValue();
            }
        }
        com.tencent.mobileqq.guild.feed.performance.report.g.h(z16, z17);
        A2(UIStateData.obtainLoading());
        E2(c16, gProGetFeedNoticesReq, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
        QLog.i("GuildFeedNoticeListViewModel", 1, "updateGuildNoticeRedPoint item:" + guildInteractiveNotificationItem.toString());
        n nVar = this.E;
        if (nVar != null && nVar.getGuildNoticeNode().f(guildInteractiveNotificationItem)) {
            B2(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2(GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
        QLog.d("GuildFeedNoticeListViewModel", 1, "updateGuildNoticeSummary item:" + guildInteractiveNotificationItem);
        n nVar = this.E;
        if (nVar != null && nVar.getGuildNoticeNode().e(guildInteractiveNotificationItem)) {
            B2(0);
        }
    }

    private GProDeleteInteractReq X1(GProStNotice gProStNotice) {
        GProDeleteInteractReq gProDeleteInteractReq = new GProDeleteInteractReq();
        gProDeleteInteractReq.psvFeedId = gProStNotice.psvFeed.idd;
        if (!TextUtils.isEmpty(this.D.getGuildId())) {
            gProDeleteInteractReq.guildId = Long.parseLong(this.D.getGuildId());
        }
        if (!TextUtils.isEmpty(this.D.getChannelId())) {
            gProDeleteInteractReq.channelId = Long.parseLong(this.D.getChannelId());
        }
        return gProDeleteInteractReq;
    }

    private GProUPdateFeedInteractSwitchReq Z1(GProStNotice gProStNotice, boolean z16) {
        int i3;
        GProUPdateFeedInteractSwitchReq gProUPdateFeedInteractSwitchReq = new GProUPdateFeedInteractSwitchReq();
        if (!TextUtils.isEmpty(this.D.getGuildId())) {
            gProUPdateFeedInteractSwitchReq.guildId = Long.parseLong(this.D.getGuildId());
        }
        if (!TextUtils.isEmpty(this.D.getChannelId())) {
            gProUPdateFeedInteractSwitchReq.channelId = Long.parseLong(this.D.getChannelId());
        }
        gProUPdateFeedInteractSwitchReq.feedId = gProStNotice.origineFeed.idd;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        gProUPdateFeedInteractSwitchReq.operateType = i3;
        return gProUPdateFeedInteractSwitchReq;
    }

    private void a2() {
        int indexOf = this.f224024m.indexOf(this.F);
        int indexOf2 = this.f224024m.indexOf(this.G);
        if (indexOf != -1 && indexOf2 != -1 && indexOf2 - indexOf <= 1) {
            this.f224024m.remove(indexOf2);
            A2(UIStateData.obtainDelete().setData(false, this.f224024m).setPos(indexOf2));
            this.f224024m.remove(indexOf);
            A2(UIStateData.obtainDelete().setData(false, this.f224024m).setPos(indexOf));
        }
    }

    private void c2() {
        if (g2() != null) {
            g2().getGuildInteractiveNotification(this.D.getGuildId(), 2, new IGuildInteractiveNotificationCallback() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.g
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildInteractiveNotificationCallback
                public final void onResult(int i3, String str, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
                    GuildFeedNoticeListViewModel.this.s2(i3, str, guildInteractiveNotificationItem);
                }
            });
        }
    }

    private s e2() {
        if (this.G == null) {
            this.G = new s("\u65b0\u6d88\u606f\u7ed3\u675f");
        }
        return this.G;
    }

    private o f2() {
        return com.tencent.mobileqq.guild.feed.util.l.c();
    }

    private uh2.c g2() {
        IGProSession iGProSession = (IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "");
        if (iGProSession.getGProGuildMsgService() == null) {
            return null;
        }
        return iGProSession.getGProGuildMsgService();
    }

    private t i2() {
        if (this.F == null) {
            this.F = new t("\u65b0\u6d88\u606f");
        }
        return this.F;
    }

    private void j2(v<?> vVar, int i3) {
        Iterator<v<?>> it = this.f224024m.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            if (it.next() instanceof ij1.a) {
                i16++;
            }
        }
        if (i16 <= 1) {
            this.f224024m.clear();
            this.f224024m.add(this.E);
            A2(UIStateData.obtainEmpty().setData(false, this.f224024m));
        } else {
            this.f224024m.remove(vVar);
            A2(UIStateData.obtainDelete().setData(false, this.f224024m).setPos(i3));
            a2();
        }
    }

    private void k2(final boolean z16, final GProGetFeedNoticesRsp gProGetFeedNoticesRsp, final boolean z17) {
        if (q2(z16)) {
            return;
        }
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedNoticeListViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedNoticeListViewModel.this.x2(gProGetFeedNoticesRsp);
                GuildFeedNoticeListViewModel.this.z2(gProGetFeedNoticesRsp, z17, z16, GuildFeedNoticeListViewModel.this.y2(gProGetFeedNoticesRsp));
            }
        });
    }

    private void l2(String str, boolean z16) {
        for (v<?> vVar : this.f224024m) {
            if (vVar instanceof ij1.a) {
                GProStNotice gProStNotice = (GProStNotice) vVar.b();
                if (TextUtils.equals(str, gProStNotice.origineFeed.idd)) {
                    gProStNotice.isCloseInteract = !z16;
                }
            }
        }
        A2(UIStateData.obtainModify().setData(false, this.f224024m).setPos(-1));
    }

    private boolean m2() {
        if (this.J > 0) {
            return true;
        }
        return false;
    }

    private void n2(List<v<?>> list) {
        if (this.D.getBusinessType() != 19) {
            return;
        }
        if (list.isEmpty()) {
            list.add(0, new p(""));
        }
        if (this.E == null) {
            this.E = new n(new GuildNoticeNode(), this.I);
            c2();
        }
        list.add(0, this.E);
    }

    private void o2(List<v<?>> list) {
        int i3;
        ArrayList arrayList = new ArrayList(this.f224024m);
        if (!arrayList.isEmpty() && m2()) {
            boolean z16 = arrayList.get(0) instanceof n;
            int size = arrayList.size();
            if (z16) {
                i3 = this.J + 2;
            } else {
                i3 = this.J + 1;
            }
            if (i3 < size && (arrayList.get(i3) instanceof s)) {
                return;
            }
            int size2 = list.size() + size;
            if (i3 >= size && i3 <= size2) {
                QLog.i("GuildFeedNoticeListViewModel", 2, "endItemPosition:" + i3 + " totalSize:" + size2);
                list.add(i3 - size, new s("\u65b0\u6d88\u606f\u7ed3\u675f"));
            }
        }
    }

    private boolean p2(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "0")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(v vVar, int i3, int i16, String str) {
        if (i16 == 0) {
            j2(vVar, i3);
            return;
        }
        QLog.e("GuildFeedNoticeListViewModel", 1, "[deleteNotice] failed result=" + i16 + " msg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2(int i3, String str, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
        if (i3 != 0) {
            QLog.w("GuildFeedNoticeListViewModel", 1, "fetchGuildInteractiveNotification failed result=" + i3 + " msg=" + str);
            if (i3 == -10) {
                QLog.d("GuildFeedNoticeListViewModel", 1, "GuildNoticeHandler result $noticeType SDK_CLIENT_RETURN_NULL_OBJECT");
                n nVar = this.E;
                if (nVar != null) {
                    nVar.getGuildNoticeNode().a();
                    return;
                }
                return;
            }
            QLog.d("GuildFeedNoticeListViewModel", 2, "GuildNoticeHandler $noticeType error: $error");
            return;
        }
        QLog.i("GuildFeedNoticeListViewModel", 2, "guildId=" + this.D.getGuildId() + " unreadType=" + guildInteractiveNotificationItem.unreadType + " redCount=" + guildInteractiveNotificationItem.count + " abstract=" + guildInteractiveNotificationItem.managerAbstract);
        I2(guildInteractiveNotificationItem);
        J2(guildInteractiveNotificationItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(int i3, String str, boolean z16, boolean z17, int i16, GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
        boolean z18;
        if (i3 == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        QLog.d("GuildFeedNoticeListViewModel", 1, "requestFeedNotices onReceive: dispatch Success:" + z18 + " | retCode:" + i3 + " | retMessage:" + str + " | isLoadMore:" + z16 + " | isCache:" + z17 + " | unreadCnt:" + i16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("unreadCnt:");
        sb5.append(i16);
        QLog.i("GuildFeedNoticeListViewModel", 4, sb5.toString());
        this.J = i16;
        if (z18 && !z17) {
            D2(this.D.getGuildId(), 1);
        }
        long j3 = i3;
        com.tencent.mobileqq.guild.feed.performance.report.g.g(z18, z16, j3, str, gProGetFeedNoticesRsp);
        if (z18 && gProGetFeedNoticesRsp != null) {
            k2(z17, gProGetFeedNoticesRsp, z16);
        } else {
            A2(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(final boolean z16, final int i3, final String str, final boolean z17, final int i16, final GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedNoticeListViewModel.this.t2(i3, str, z16, z17, i16, gProGetFeedNoticesRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2(GProStNotice gProStNotice, boolean z16, int i3, String str) {
        if (i3 == 0) {
            l2(gProStNotice.origineFeed.idd, z16);
            return;
        }
        QLog.e("GuildFeedNoticeListViewModel", 1, "[switchReceiveNotification] failed result=" + i3 + " msg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x2(GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
        if (gProGetFeedNoticesRsp == null) {
            return;
        }
        this.C = gProGetFeedNoticesRsp.attachInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y2(GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
        if (gProGetFeedNoticesRsp == null) {
            return true;
        }
        return gProGetFeedNoticesRsp.isFinish;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2(GProGetFeedNoticesRsp gProGetFeedNoticesRsp, boolean z16, boolean z17, boolean z18) {
        ArrayList<v<?>> e16 = ij1.c.e(gProGetFeedNoticesRsp.notices);
        if (!z16) {
            this.f224024m.clear();
            if (m2() && !e16.isEmpty()) {
                e16.add(0, i2());
                if (this.J + 1 <= e16.size()) {
                    e16.add(this.J + 1, e2());
                }
            }
            n2(e16);
        } else {
            o2(e16);
        }
        this.f224024m.addAll(e16);
        if (d2() > 0) {
            A2(UIStateData.obtainSuccess(z17).setData(z16, e16).setFinish(z18));
        } else {
            A2(UIStateData.obtainEmpty().setLoadMore(z16).setFinish(z18));
        }
    }

    protected void A2(final UIStateData<List<v<?>>> uIStateData) {
        com.tencent.mobileqq.guild.feed.performance.report.g.i(uIStateData);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedNoticeListViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedNoticeListViewModel.this.f224023i.setValue(uIStateData);
            }
        });
    }

    protected void B2(int i3) {
        boolean z16;
        if (this.f224023i.getValue() != null && this.f224023i.getValue().getIsFinish()) {
            z16 = true;
        } else {
            z16 = false;
        }
        A2(UIStateData.obtainModify().setPos(i3).setFinish(z16));
    }

    public void C2(boolean z16) {
        F2(false, z16);
    }

    public void G2(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        this.D = guildFeedBaseInitBean;
    }

    public void H2(int i3, final boolean z16) {
        if (ArrayUtils.isOutOfArrayIndex(i3, this.f224024m)) {
            QLog.e("GuildFeedNoticeListViewModel", 1, "switchReceiveNotification invalid position:" + i3);
            return;
        }
        v<?> vVar = this.f224024m.get(i3);
        if (vVar instanceof ij1.a) {
            final GProStNotice gProStNotice = (GProStNotice) vVar.b();
            f2().updateFeedInteractBlockedStatus(Z1(gProStNotice, z16), new IGProUpdateFeedInteractBlockedStatusCallback() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.i
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpdateFeedInteractBlockedStatusCallback
                public final void onResult(int i16, String str) {
                    GuildFeedNoticeListViewModel.this.v2(gProStNotice, z16, i16, str);
                }
            });
        }
    }

    public void b2(final int i3) {
        if (ArrayUtils.isOutOfArrayIndex(i3, this.f224024m)) {
            QLog.e("GuildFeedNoticeListViewModel", 1, "deleteNotice invalid position:" + i3);
            return;
        }
        final v<?> vVar = this.f224024m.get(i3);
        if (vVar instanceof ij1.a) {
            f2().deleteFeedInteractNotice(X1((GProStNotice) vVar.b()), new IGProDeleteFeedInteractNoticeCallback() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.h
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteFeedInteractNoticeCallback
                public final void onResult(int i16, String str) {
                    GuildFeedNoticeListViewModel.this.r2(vVar, i3, i16, str);
                }
            });
        }
    }

    public int d2() {
        return this.f224024m.size();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedNoticeListViewModel";
    }

    public MutableLiveData<UIStateData<List<v<?>>>> h2() {
        return this.f224023i;
    }

    public void loadMore() {
        F2(true, false);
    }

    public void onCreate() {
        if (g2() != null) {
            this.H = new a();
            g2().addKernelGProGuildMsgListener(this.H);
        }
    }

    public void onDestroy() {
        D2(this.D.getGuildId(), 3);
        if (g2() != null) {
            g2().z(this.H);
        }
    }

    protected boolean q2(boolean z16) {
        if (z16 && d2() > 0) {
            return true;
        }
        return false;
    }

    public void w2() {
        ArrayList arrayList = new ArrayList();
        if (!p2(this.D.getGuildId())) {
            arrayList.add(Long.valueOf(Long.parseLong(this.D.getGuildId())));
        }
        n nVar = this.E;
        if (nVar == null) {
            return;
        }
        nVar.getGuildNoticeNode().b();
        B2(0);
        D2(this.D.getGuildId(), 2);
    }
}
