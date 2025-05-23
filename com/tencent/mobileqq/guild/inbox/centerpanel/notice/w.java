package com.tencent.mobileqq.guild.inbox.centerpanel.notice;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.GuildNoticeKtKt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeDealResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.qqguildsdk.data.cq;
import com.tencent.mobileqq.qqguildsdk.data.genc.et;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.FirstViewDirectMsgNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAvChannelStateMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBeaconEventModel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBeaconStageModel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckInNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTopFeedMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProManagerNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener;
import com.tencent.util.Pair;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import vh2.bo;
import vh2.bu;

/* compiled from: P */
/* loaded from: classes13.dex */
public class w extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    private final MutableLiveData<Integer> C;
    private final MutableLiveData<Integer> D;
    private final Set<String> E;
    private final MutableLiveData<Boolean> F;
    private int G;
    private IKernelGProGuildMsgListener H;
    private com.tencent.mobileqq.guild.inbox.centerpanel.notice.b I;
    private int J;
    private final GPServiceObserver K;
    private IGPSService L;
    private IGuildInboxRedService M;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<List<co>> f226214i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<Boolean> f226215m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            if (w.this.E.contains(str)) {
                w.this.I.b(str);
                w.this.f226214i.postValue((List) w.this.f226214i.getValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildUserAvatarUrlUpdate(String str, String str2) {
            List list = (List) w.this.f226214i.getValue();
            if (list != null && !list.isEmpty()) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    co.b bVar = ((co) list.get(i3)).f265891g;
                    if (bVar != null && bVar.f265908a == 2 && TextUtils.equals(String.valueOf(bVar.f265909b), str2)) {
                        w.this.C.setValue(Integer.valueOf(i3));
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(String str) {
            List list = (List) w.this.f226214i.getValue();
            if (list != null && !list.isEmpty()) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    co coVar = (co) list.get(i3);
                    if (TextUtils.equals(String.valueOf(coVar.f265902r), str)) {
                        w.this.C.setValue(Integer.valueOf(i3));
                    } else if (!coVar.f265892h.isEmpty()) {
                        co.h hVar = coVar.f265892h.get(0);
                        if (hVar.f265924a == 2 && TextUtils.equals(String.valueOf(hVar.f265925b), str)) {
                            w.this.C.setValue(Integer.valueOf(i3));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements IKernelGProGuildMsgListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f226217a;

        b(String str) {
            this.f226217a = str;
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
            if (this.f226217a.equals(guildInteractiveNotificationItem.getGuildId()) && guildInteractiveNotificationItem.getType() == 2) {
                w.this.X1(true, this.f226217a);
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

    public w() {
        super(new wy1.a());
        this.f226214i = new MutableLiveData<>();
        Boolean bool = Boolean.FALSE;
        this.f226215m = new MutableLiveData<>(bool);
        this.C = new MutableLiveData<>(0);
        this.D = new MutableLiveData<>();
        this.E = new HashSet();
        this.F = new MutableLiveData<>(bool);
        this.G = 0;
        this.I = new com.tencent.mobileqq.guild.inbox.centerpanel.notice.b();
        this.J = 0;
        this.K = new a();
    }

    private uh2.c Z1() {
        IGProSession iGProSession = (IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "");
        if (iGProSession.getGProGuildMsgService() == null) {
            return null;
        }
        return iGProSession.getGProGuildMsgService();
    }

    private void addListener() {
        this.L.addObserver(this.K);
    }

    @Nullable
    private co d2(String str) {
        List<co> value = this.f226214i.getValue();
        if (value != null && !value.isEmpty()) {
            for (co coVar : value) {
                if (TextUtils.equals(str, coVar.f265885a)) {
                    return coVar;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l2(co coVar, int i3, String str) {
        if (i3 != 0) {
            QLog.e("Guild.C2C.GuildNoticeViewModel", 1, "deleteGuildNotice error=", Integer.valueOf(i3), " errMsg=", str);
            return;
        }
        QLog.d("Guild.C2C.GuildNoticeViewModel", 2, "deleteGuildNotice success: noticeId=" + coVar.f265885a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void m2(String str, int i3, String str2, int i16, boolean z16, int i17, List list) {
        if (i3 != 0) {
            QLog.e("Guild.C2C.GuildNoticeViewModel", 1, "onInitGetGuildNoticeList error=", Integer.valueOf(i3), " errMsg=", str2);
        }
        if (list == null) {
            list = new ArrayList();
        }
        this.G = i16;
        if (i17 > 0) {
            this.J = i17;
            QLog.i("Guild.C2C.GuildNoticeViewModel", 4, "unreadCnt:" + i17);
            if (i3 == 0) {
                s2(str);
            }
        }
        this.f226214i.setValue(list);
        t2(list);
        this.F.setValue(Boolean.valueOf(z16));
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildNoticeViewModel", 2, "onInitGetGuildNoticeList listOffset=", Integer.valueOf(i16), " isEnd=", Boolean.valueOf(z16), " data size=", Integer.valueOf(list.size()), " unreadCnt=", Integer.valueOf(i17));
        }
        this.f226215m.setValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit n2(Context context, co coVar, com.tencent.mobileqq.guild.mainframe.i iVar, GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildNoticeViewModel", 2, "handleClickGuestGuild ", guildAndChannelInfoRsp);
        }
        if (guildAndChannelInfoRsp.k() != 0) {
            if (guildAndChannelInfoRsp.k() == 784010) {
                QQToastUtil.showQQToast(1, "\u8be5\u9891\u9053\u5df2\u89e3\u6563");
            } else {
                SecurityTipHelperKt.z(context, guildAndChannelInfoRsp.k(), guildAndChannelInfoRsp.e());
            }
            return null;
        }
        i2(coVar, iVar, context);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(String str, int i3, String str2, GuildNoticeDealResult guildNoticeDealResult) {
        int i16 = 2;
        if (i3 != 0) {
            QLog.e("Guild.C2C.GuildNoticeViewModel", 1, "handleNoticeButtonClick error, result", Integer.valueOf(i3), " errMsg:", str2, " dealResult", guildNoticeDealResult);
            if (i3 != -93 && i3 != 1002) {
                if (!TextUtils.isEmpty(str2)) {
                    QQToastUtil.showQQToast(1, str2);
                    return;
                }
                return;
            }
            QQToastUtil.showQQToast(1, R.string.f1514417p);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildNoticeViewModel", 2, "handleNoticeButtonClick dealResult:", guildNoticeDealResult);
        }
        if (!TextUtils.isEmpty(guildNoticeDealResult.getDealWording())) {
            if (guildNoticeDealResult.getDealCode() != 0) {
                i16 = 1;
            }
            QQToastUtil.showQQToast(i16, guildNoticeDealResult.getDealWording());
        }
        List<co> value = this.f226214i.getValue();
        co d26 = d2(str);
        if (value != null && d26 != null) {
            int indexOf = value.indexOf(d26);
            value.remove(indexOf);
            value.add(indexOf, guildNoticeDealResult.getGuildNotice());
            this.C.setValue(Integer.valueOf(indexOf));
            return;
        }
        QLog.e("Guild.C2C.GuildNoticeViewModel", 1, "handleNoticeButtonClick can't find target notice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(int i3, String str, boolean z16, int i16, boolean z17, List list) {
        if (i3 != 0) {
            QLog.e("Guild.C2C.GuildNoticeViewModel", 1, "getMoreNoticeList error,result:", Integer.valueOf(i3), " errMsg:", str);
            this.f226215m.setValue(Boolean.FALSE);
            return;
        }
        this.F.setValue(Boolean.valueOf(z17));
        this.G = i16;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildNoticeViewModel", 2, "onGetMore listOffset=", Integer.valueOf(i16), " isEnd=", Boolean.valueOf(z17), " size=" + list.size());
        }
        this.f226215m.setValue(Boolean.FALSE);
        if (z16) {
            this.f226214i.setValue(list);
            t2(list);
            return;
        }
        List<co> value = this.f226214i.getValue();
        if (value == null) {
            this.f226214i.setValue(list);
            t2(list);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            co coVar = (co) it.next();
            if (!value.contains(coVar)) {
                value.add(coVar);
            }
        }
        t2(value);
        this.f226214i.setValue(value);
    }

    private void t2(List<co> list) {
        for (co coVar : list) {
            this.E.add(coVar.f265890f);
            if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.GuildNoticeViewModel", 2, "recordGuildIds notice =", coVar);
            }
        }
    }

    public void U1(int i3) {
        List<co> value = this.f226214i.getValue();
        if (value != null && i3 < value.size()) {
            final co coVar = value.get(i3);
            ArrayList arrayList = new ArrayList(value);
            boolean remove = arrayList.remove(coVar);
            if (remove && this.L != null) {
                QLog.d("Guild.C2C.GuildNoticeViewModel", 2, "deleteGuildNotice noticeId=" + coVar.f265885a + ", notice=" + coVar);
                et etVar = new et();
                etVar.b(this.L.convert2GWGProNotice(coVar));
                this.L.deleteSystemNoticeMessage(etVar, new wh2.v() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.u
                    @Override // wh2.v
                    public final void onDeleteSystemNoticeMessageResult(int i16, String str) {
                        w.l2(co.this, i16, str);
                    }
                });
                t2(arrayList);
                this.D.setValue(Integer.valueOf(i3));
                return;
            }
            QLog.e("Guild.C2C.GuildNoticeViewModel", 1, "deleteGuildNotice failed, noticeId=" + coVar.f265885a + ", removed=" + remove + ", service=" + this.L);
        }
    }

    public void W1(String str, Function1<? super IGProGuildInfo, Unit> function1) {
        this.I.a(str, function1);
    }

    public void X1(boolean z16, final String str) {
        this.L.initGetNoticeList(6, str, z16, new bu() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.r
            @Override // vh2.bu
            public final void a(int i3, String str2, int i16, boolean z17, int i17, List list) {
                w.this.m2(str, i3, str2, i16, z17, i17, list);
            }
        });
    }

    public MutableLiveData<List<co>> a2() {
        return this.f226214i;
    }

    public MutableLiveData<Boolean> b2() {
        return this.F;
    }

    public MutableLiveData<Integer> c2() {
        return this.C;
    }

    public LiveData<Integer> e2() {
        return this.D;
    }

    public int f2() {
        return this.J;
    }

    public void g2(final co coVar, final com.tencent.mobileqq.guild.mainframe.i iVar, final Context context) {
        GuildMainFrameUtils.g(coVar.f265890f, "", 0, "", false, new Function1() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n26;
                n26 = w.this.n2(context, coVar, iVar, (GuildMainFrameUtils.GuildAndChannelInfoRsp) obj);
                return n26;
            }
        });
    }

    public void h2(final String str, String str2) {
        this.L.dealNotice(str, str2, new vh2.j() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.t
            @Override // vh2.j
            public final void a(int i3, String str3, GuildNoticeDealResult guildNoticeDealResult) {
                w.this.o2(str, i3, str3, guildNoticeDealResult);
            }
        });
    }

    public void i2(co coVar, com.tencent.mobileqq.guild.mainframe.i iVar, Context context) {
        if (!coVar.f265895k.isEmpty()) {
            return;
        }
        QLog.d("Guild.C2C.GuildNoticeViewModel", 2, "handleNoticeItemClick ", coVar);
        if (TextUtils.isEmpty(coVar.f265896l)) {
            return;
        }
        Pair<String, String> b16 = QQGuildJumpSource.b(246619, "Guild.C2C.GuildNoticeViewModel");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(coVar.f265890f, "", coVar.f265896l, b16.first, b16.second);
        if (ch.j0(jumpGuildParam.guildId)) {
            GuildJumpUtil.n(iVar.getActivity(), jumpGuildParam);
        } else {
            GuildJumpUtil.y(context, jumpGuildParam.guildId, null, null, null);
        }
    }

    public void initData() {
        this.L = (IGPSService) ch.R0(IGPSService.class);
        this.M = (IGuildInboxRedService) ch.R0(IGuildInboxRedService.class);
        addListener();
    }

    public boolean j2() {
        return this.F.getValue().booleanValue();
    }

    public MutableLiveData<Boolean> k2() {
        return this.f226215m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        if (Z1() != null && this.H != null) {
            Z1().z(this.H);
        }
        super.onCleared();
    }

    public void q2(String str) {
        if (this.f226215m.getValue() != null && this.f226215m.getValue().booleanValue()) {
            return;
        }
        this.f226215m.setValue(Boolean.TRUE);
        this.L.getMoreNoticeList(6, str, this.G, new bo() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.s
            @Override // vh2.bo
            public final void a(int i3, String str2, boolean z16, int i16, boolean z17, List list) {
                w.this.p2(i3, str2, z16, i16, z17, list);
            }
        });
    }

    public void r2(String str) {
        if (this.H == null) {
            this.H = new b(str);
        }
        if (Z1() != null) {
            Z1().addKernelGProGuildMsgListener(this.H);
        }
    }

    public void removeListener() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildNoticeViewModel", 2, "removeListener");
        }
        this.L.deleteObserver(this.K);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s2(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.i("Guild.C2C.GuildNoticeViewModel", 2, "reportRead -- guildId:" + str + ",type:7");
        GuildNoticeKtKt.b(str, 7, null);
    }

    public void u2(String str) {
        boolean z16;
        boolean z17 = false;
        if (this.f226214i.getValue() != null && !this.f226214i.getValue().isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        cq noticeRedPoint = this.M.getNoticeRedPoint(6);
        if (z16 || noticeRedPoint.f265932b > 0) {
            z17 = true;
        }
        X1(z17, str);
    }
}
