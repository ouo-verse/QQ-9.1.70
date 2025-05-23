package com.tencent.mobileqq.troop.shortcutbar.trooptopic;

import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.icebreak.a;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.trooptopic.m;
import com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.event.IceBreakEvent;
import com.tencent.qqnt.kernel.nativeinterface.ITopicRecallCallback;
import com.tencent.qqnt.kernel.nativeinterface.TopicRecallRsp;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001f\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\u000e\u001a\u00020\u00022\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\"R\"\u0010)\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010.\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010*\u001a\u0004\b\u0013\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcutbar/trooptopic/m;", "Lcom/tencent/mobileqq/troop/shortcutbar/c;", "", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "source", "", "recallId", "r", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/shortcutbar/ShortcutBarInfo;", "Lkotlin/collections/ArrayList;", "infos", "y", "c", "f", "d", "", "o", "b", "e", "a", "u", "Lcom/tencent/mobileqq/activity/aio/rebuild/input/shortcutbar/a;", "Lcom/tencent/mobileqq/activity/aio/rebuild/input/shortcutbar/a;", "getAioShortcutBarContext", "()Lcom/tencent/mobileqq/activity/aio/rebuild/input/shortcutbar/a;", "setAioShortcutBarContext", "(Lcom/tencent/mobileqq/activity/aio/rebuild/input/shortcutbar/a;)V", "aioShortcutBarContext", "Lcom/tencent/mobileqq/troop/shortcutbar/a;", "Lcom/tencent/mobileqq/troop/shortcutbar/a;", "p", "()Lcom/tencent/mobileqq/troop/shortcutbar/a;", "provider", "I", DomainData.DOMAIN_NAME, "()I", "setFormType", "(I)V", "formType", "Ljava/lang/String;", "()Ljava/lang/String;", "setGroupCode", "(Ljava/lang/String;)V", "groupCode", "", "J", "getDefaultShowDuration", "()J", "setDefaultShowDuration", "(J)V", "defaultShowDuration", "Lcom/tencent/mobileqq/troop/troopgag/api/b;", "Lcom/tencent/mobileqq/troop/troopgag/api/b;", "troopGagObserver", "Lcom/tencent/util/MqqWeakReferenceHandler;", "g", "Lcom/tencent/util/MqqWeakReferenceHandler;", "mSubHandler", "Ljava/lang/Runnable;", tl.h.F, "Ljava/lang/Runnable;", "runnable", "<init>", "(Lcom/tencent/mobileqq/activity/aio/rebuild/input/shortcutbar/a;Lcom/tencent/mobileqq/troop/shortcutbar/a;)V", "i", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class m extends com.tencent.mobileqq.troop.shortcutbar.c {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aioShortcutBarContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.shortcutbar.a provider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int formType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String groupCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long defaultShowDuration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.troopgag.api.b troopGagObserver;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MqqWeakReferenceHandler mSubHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable runnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcutbar/trooptopic/m$a;", "", "", "GET_STOP_REQUEST_SECONDS", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcutbar.trooptopic.m$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/shortcutbar/trooptopic/m$b", "Lcom/tencent/mobileqq/troop/troopgag/api/b;", "Lcom/tencent/mobileqq/troop/troopgag/data/a;", "gagStatusInfo", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.troopgag.api.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(m this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.p().h(this$0.n(), null);
        }

        @Override // com.tencent.mobileqq.troop.troopgag.api.b
        protected void a(@NotNull com.tencent.mobileqq.troop.troopgag.data.a gagStatusInfo) {
            com.tencent.mobileqq.troop.troopgag.data.d dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gagStatusInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(gagStatusInfo, "gagStatusInfo");
            if (Intrinsics.areEqual(m.this.o(), gagStatusInfo.f300221a) && gagStatusInfo.f300223c == 2 && (dVar = gagStatusInfo.f300225e) != null) {
                QLog.i("TroopTopicRecommendProcessor", 1, "onTroopGagStatusChange gagStatusInfo  = " + dVar.f300235b + " " + dVar.f300236c);
                if (gagStatusInfo.f300225e.f300235b) {
                    MqqWeakReferenceHandler mqqWeakReferenceHandler = m.this.mSubHandler;
                    if (mqqWeakReferenceHandler != null) {
                        mqqWeakReferenceHandler.removeCallbacks(m.this.runnable);
                    }
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final m mVar = m.this;
                    uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            m.b.d(m.this);
                        }
                    });
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62355);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public m(@NotNull com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aioShortcutBarContext, @NotNull com.tencent.mobileqq.troop.shortcutbar.a provider) {
        Intrinsics.checkNotNullParameter(aioShortcutBarContext, "aioShortcutBarContext");
        Intrinsics.checkNotNullParameter(provider, "provider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioShortcutBarContext, (Object) provider);
            return;
        }
        this.aioShortcutBarContext = aioShortcutBarContext;
        this.provider = provider;
        String f16 = aioShortcutBarContext.f();
        Intrinsics.checkNotNullExpressionValue(f16, "aioShortcutBarContext.peerUin");
        this.groupCode = f16;
        this.defaultShowDuration = 3000L;
        this.troopGagObserver = new b();
        this.runnable = new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.i
            @Override // java.lang.Runnable
            public final void run() {
                m.w(m.this);
            }
        };
    }

    private final void q() {
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.addObserver(this.troopGagObserver);
        }
    }

    private final void r(final int source, final String recallId) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.j
            @Override // java.lang.Runnable
            public final void run() {
                m.s(m.this, source, recallId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(m this$0, int i3, String str) {
        com.tencent.mvi.base.route.k kVar;
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.api.runtime.a a16 = this$0.aioShortcutBarContext.a();
        if (a16 != null && (e16 = a16.e()) != null) {
            kVar = e16.k(IceBreakEvent.GetIceBreakStatus.f356707d);
        } else {
            kVar = null;
        }
        QLog.d("TroopTopicRecommendProcessor", 1, "sendR ice break result " + kVar + "}");
        if (((kVar instanceof a.C8755a) && ((a.C8755a) kVar).a()) || ((ITroopTopicRecommendApi) QRoute.api(ITroopTopicRecommendApi.class)).isTroopAIVoiceChatActive(this$0.aioShortcutBarContext.a())) {
            return;
        }
        this$0.u(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.provider.h(this$0.formType, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(int i3, m this$0, int i16, String str, TopicRecallRsp topicRecallRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.qqnt.e.d(i16)) {
            if (topicRecallRsp.result.aiSubjects.size() > 0) {
                TroopTopicRecommendData troopTopicRecommendData = new TroopTopicRecommendData();
                String str2 = topicRecallRsp.result.iconUrlDark;
                Intrinsics.checkNotNullExpressionValue(str2, "rsp.result.iconUrlDark");
                troopTopicRecommendData.setIconUrlDark(str2);
                String str3 = topicRecallRsp.result.iconUrlDefault;
                Intrinsics.checkNotNullExpressionValue(str3, "rsp.result.iconUrlDefault");
                troopTopicRecommendData.setIconUrlDefault(str3);
                String str4 = topicRecallRsp.result.title;
                Intrinsics.checkNotNullExpressionValue(str4, "rsp.result.title");
                troopTopicRecommendData.setTitle(str4);
                String str5 = topicRecallRsp.result.recallId;
                Intrinsics.checkNotNullExpressionValue(str5, "rsp.result.recallId");
                troopTopicRecommendData.setRecallId(str5);
                troopTopicRecommendData.setDisappearSeconds(topicRecallRsp.result.disappearSeconds);
                troopTopicRecommendData.setStopRequestSeconds(topicRecallRsp.stopRequestSeconds);
                troopTopicRecommendData.setSource(i3);
                troopTopicRecommendData.getAiSubjects().addAll(topicRecallRsp.result.aiSubjects);
                ArrayList<ShortcutBarInfo> arrayList = new ArrayList<>();
                arrayList.add(troopTopicRecommendData);
                this$0.y(arrayList);
            }
            if (topicRecallRsp.stopRequestSeconds > 0) {
                com.tencent.mobileqq.troop.config.a.f294689a.w("get_stop_request_seconds", NetConnInfoCenter.getServerTime() + topicRecallRsp.stopRequestSeconds, true);
            }
            QLog.i("TroopTopicRecommendProcessor", 1, "getTopicRecall groupCode " + this$0.groupCode + "  emptyReason " + topicRecallRsp.emptyReason + " stopRequestSeconds " + topicRecallRsp.stopRequestSeconds);
            return;
        }
        QLog.e("TroopTopicRecommendProcessor", 1, "getTopicRecall groupCode " + this$0.groupCode + " result" + i16 + " err: " + str + "  emptyReason" + topicRecallRsp.emptyReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("TroopTopicRecommendProcessor", 1, "remove delay end , start request");
        this$0.r(1, null);
    }

    private final void x() {
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.mSubHandler;
        if (mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.postDelayed(this.runnable, this.defaultShowDuration);
        }
    }

    private final void y(final ArrayList<ShortcutBarInfo> infos) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.h
                @Override // java.lang.Runnable
                public final void run() {
                    m.z(m.this, infos);
                }
            });
        } else {
            this.provider.h(this.formType, infos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(m this$0, ArrayList infos) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(infos, "$infos");
        this$0.provider.h(this$0.formType, infos);
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        this.mSubHandler = new MqqWeakReferenceHandler(ThreadManagerV2.getQQCommonThreadLooper(), null);
        String f16 = this.aioShortcutBarContext.f();
        Intrinsics.checkNotNullExpressionValue(f16, "aioShortcutBarContext.peerUin");
        this.groupCode = f16;
        this.formType = 6;
        q();
        long k3 = com.tencent.mobileqq.troop.config.a.f294689a.k("get_stop_request_seconds", 0L, true);
        if (NetConnInfoCenter.getServerTime() < k3) {
            QLog.i("TroopTopicRecommendProcessor", 1, "is stop request seconds " + k3);
            return;
        }
        IRuntimeService runtimeService = this.aioShortcutBarContext.d().getRuntimeService(ITroopGagService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "aioShortcutBarContext.ap\u2026nstant.MAIN\n            )");
        boolean z16 = ((ITroopGagService) runtimeService).getSelfGagInfo(this.groupCode, true).f300235b;
        if (z16) {
            QLog.i("TroopTopicRecommendProcessor", 1, "selfGagInfo.isGag " + z16);
            return;
        }
        com.tencent.mobileqq.troop.topicrecommend.b troopExpandInfo = ((ITroopTopicRecommendApi) QRoute.api(ITroopTopicRecommendApi.class)).getTroopExpandInfo(this.groupCode);
        this.defaultShowDuration = troopExpandInfo.a() * 1000;
        if (!troopExpandInfo.b()) {
            QLog.i("TroopTopicRecommendProcessor", 1, "troopExpendInfo  " + troopExpandInfo + " ");
            return;
        }
        ITroopTopicRecommendApi iTroopTopicRecommendApi = (ITroopTopicRecommendApi) QRoute.api(ITroopTopicRecommendApi.class);
        com.tencent.aio.api.runtime.a a16 = this.aioShortcutBarContext.a();
        Intrinsics.checkNotNullExpressionValue(a16, "aioShortcutBarContext.aioContext");
        if (iTroopTopicRecommendApi.isPushAIO(a16)) {
            String string = this.aioShortcutBarContext.a().g().l().getString("recall_id", "");
            QLog.d("TroopTopicRecommendProcessor", 1, "recallId " + string);
            r(2, string);
            return;
        }
        x();
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void b(@Nullable Object o16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, o16);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.mSubHandler;
        if (mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.removeCallbacks(this.runnable);
        }
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.removeObserver(this.troopGagObserver);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void e(@Nullable Object o16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, o16);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.k
                @Override // java.lang.Runnable
                public final void run() {
                    m.t(m.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void f() {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.mSubHandler;
        if (mqqWeakReferenceHandler != null && (runnable = this.runnable) != null && mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.removeCallbacks(runnable);
        }
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.formType;
    }

    @NotNull
    public final String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.groupCode;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcutbar.a p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.troop.shortcutbar.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.provider;
    }

    public final void u(final int source, @Nullable String recallId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, source, (Object) recallId);
        } else {
            ((ITroopTopicRecommendApi) QRoute.api(ITroopTopicRecommendApi.class)).getTopicRecall(this.groupCode, recallId, new ITopicRecallCallback() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.ITopicRecallCallback
                public final void onResult(int i3, String str, TopicRecallRsp topicRecallRsp) {
                    m.v(source, this, i3, str, topicRecallRsp);
                }
            });
        }
    }
}
