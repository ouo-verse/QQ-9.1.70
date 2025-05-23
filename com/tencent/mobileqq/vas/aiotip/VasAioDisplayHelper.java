package com.tencent.mobileqq.vas.aiotip;

import android.text.TextUtils;
import com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.aiotip.VasAioDisplayHelper$scrollListener$2;
import com.tencent.mobileqq.vas.aiotip.api.IVasAioTipService;
import com.tencent.mobileqq.vas.api.IFontHelper;
import com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent;
import com.tencent.mobileqq.vas.font.magic.IVasMagicFontManager;
import com.tencent.mobileqq.vas.frequency.IFrequencyCheckApi;
import com.tencent.mobileqq.vas.pendant.api.IPendantManager;
import com.tencent.mobileqq.vas.perception.api.IVipFileUploadPerceptionBuild;
import com.tencent.mobileqq.vas.perception.api.IVipPerceptionProxy;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IUnreadCountChangeApi;
import com.tencent.qqnt.msg.d;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\n*\u0001#\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/aiotip/VasAioDisplayHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/qqnt/msg/d;", "msgRecord", "", "triggerRoamMsgTips", "", "peerUid", "", "chatType", "", "peerUin", "unreadMsgKeyWord", "value", "tryNickCoverDetect", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/main/businesshelper/b;", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "", "isDestroyed", "Z", "com/tencent/mobileqq/vas/aiotip/VasAioDisplayHelper$scrollListener$2$a", "scrollListener$delegate", "Lkotlin/Lazy;", "getScrollListener", "()Lcom/tencent/mobileqq/vas/aiotip/VasAioDisplayHelper$scrollListener$2$a;", "scrollListener", "<init>", "()V", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes20.dex */
public final class VasAioDisplayHelper implements h {

    @NotNull
    private static final String TAG = "VasAioDisplayHelper";
    private boolean isDestroyed;

    @Nullable
    private CompletableJob job;

    @Nullable
    private com.tencent.aio.main.businesshelper.b param;

    @Nullable
    private CoroutineScope scope;

    /* renamed from: scrollListener$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy scrollListener;

    public VasAioDisplayHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<VasAioDisplayHelper$scrollListener$2.a>() { // from class: com.tencent.mobileqq.vas.aiotip.VasAioDisplayHelper$scrollListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/aiotip/VasAioDisplayHelper$scrollListener$2$a", "Lcom/tencent/aio/api/runtime/emitter/AIOServiceContact$IRecycleViewScrollCallBack;", "", "state", "", "onScrollStateChange", "vas_api_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a implements AIOServiceContact$IRecycleViewScrollCallBack {
                a() {
                }

                @Override // com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack
                public void onScrollStateChange(int state) {
                    if (state != 0) {
                        if (state == 1 || state == 2) {
                            ((IPendantManager) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPendantManager.class)).pause();
                            return;
                        }
                        return;
                    }
                    ((IPendantManager) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPendantManager.class)).resume();
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.scrollListener = lazy;
    }

    private final VasAioDisplayHelper$scrollListener$2.a getScrollListener() {
        return (VasAioDisplayHelper$scrollListener$2.a) this.scrollListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMoveToState$lambda$2(VasAioDisplayHelper this$0) {
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CompletableJob completableJob = this$0.job;
        boolean z16 = false;
        if (completableJob != null && completableJob.isActive()) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        CoroutineScope coroutineScope = this$0.scope;
        if (coroutineScope != null) {
            ((IVasMagicFontManager) QRoute.api(IVasMagicFontManager.class)).setClearMagicFlag();
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), new VasAioDisplayHelper$onMoveToState$1$1$1(this$0, null)), Dispatchers.getIO()), coroutineScope);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new VasAioDisplayHelper$onMoveToState$1$1$2(this$0, null), 3, null);
        }
        com.tencent.aio.main.businesshelper.b bVar = this$0.param;
        if (bVar != null && (a16 = bVar.a()) != null && (g16 = a16.g()) != null) {
            int e16 = g16.r().c().e();
            String peerUid = g16.l().getString("key_peerId", "");
            IVipFileUploadPerceptionBuild iVipFileUploadPerceptionBuild = (IVipFileUploadPerceptionBuild) QRoute.api(IVipFileUploadPerceptionBuild.class);
            Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
            iVipFileUploadPerceptionBuild.addMsgListener(peerUid, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMoveToState$lambda$4(VasAioDisplayHelper this$0) {
        com.tencent.aio.main.businesshelper.b bVar;
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isDestroyed && (bVar = this$0.param) != null && (a16 = bVar.a()) != null && (g16 = a16.g()) != null) {
            int e16 = g16.r().c().e();
            long j3 = 0;
            long j16 = g16.l().getLong("key_peerUin", 0L);
            String peerUid = g16.l().getString("key_peerId", "");
            if (!TextUtils.isEmpty(peerUid) && j16 != 0) {
                IVasAioTipService iVasAioTipService = (IVasAioTipService) QRoute.api(IVasAioTipService.class);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j16);
                iVasAioTipService.tryTriggerExpireAioTips(e16, sb5.toString());
                IFrequencyCheckApi iFrequencyCheckApi = (IFrequencyCheckApi) QRoute.api(IFrequencyCheckApi.class);
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                    j3 = peekAppRuntime.getLongAccountUin();
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append(j16);
                iFrequencyCheckApi.checkAvatarPendantChangedAndTriggerFrequency(j3, sb6.toString(), peerUid);
                ((IVasAioTipService) QRoute.api(IVasAioTipService.class)).tryTriggerMsgRoamAioTipsWhenEnterAio(g16);
                Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
                this$0.unreadMsgKeyWord(peerUid, e16, j16);
                try {
                    ((IVipPerceptionProxy) QRoute.api(IVipPerceptionProxy.class)).sVipExpiredCheck(e16, j16);
                } catch (Exception e17) {
                    QLog.i(TAG, 1, "onMoveToState RESUME " + e17);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerRoamMsgTips(d msgRecord) {
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar != null && (a16 = bVar.a()) != null && (g16 = a16.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null && Intrinsics.areEqual(c16.j(), msgRecord.a().peerUid)) {
            ((IVasAioTipService) QRoute.api(IVasAioTipService.class)).tryTriggerMsgRoamAioTipsWhenSendReceive(msgRecord.a(), new Contact(c16.e(), c16.j(), c16.f()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryNickCoverDetect(d value) {
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar != null && (a16 = bVar.a()) != null && (g16 = a16.g()) != null) {
            String string = g16.l().getString("key_peerId", "");
            if (TextUtils.isEmpty(string)) {
                string = g16.r().c().j();
            }
            if (Intrinsics.areEqual(value.a().peerUid, string)) {
                IFlashNickNameComponent iFlashNickNameComponent = (IFlashNickNameComponent) QRoute.api(IFlashNickNameComponent.class);
                com.tencent.aio.main.businesshelper.b bVar2 = this.param;
                if (bVar2 != null) {
                    aVar = bVar2.a();
                } else {
                    aVar = null;
                }
                iFlashNickNameComponent.nickCoverKeyWordsDetect(value, aVar);
            }
        }
    }

    private final void unreadMsgKeyWord(String peerUid, int chatType, long peerUin) {
        int unreadCount = ((IUnreadCountChangeApi) QRoute.api(IUnreadCountChangeApi.class)).getUnreadCount(peerUid);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "unreadCount : " + unreadCount);
        }
        UnitedProxy unitedProxy = VasNtToggle.VAS_VIP_PERCEPTION_CONFIG;
        int i3 = 99;
        if (unitedProxy.isEnable(true)) {
            i3 = unitedProxy.getJson().optInt("group_keyword_num", 99);
        }
        if (unreadCount > i3) {
            try {
                ((IVipPerceptionProxy) QRoute.api(IVipPerceptionProxy.class)).groupKeyWord(chatType, peerUin);
            } catch (IllegalArgumentException e16) {
                QLog.i(TAG, 1, "onMoveToState CREATE 2 " + e16);
            } catch (IllegalStateException e17) {
                QLog.i(TAG, 1, "onMoveToState CREATE " + e17);
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 27;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = SupervisorJob$default;
        Intrinsics.checkNotNull(SupervisorJob$default);
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.job = null;
        this.scope = null;
        this.param = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        com.tencent.aio.api.runtime.a a16;
        ml3.b b16;
        ml3.a a17;
        com.tencent.aio.api.runtime.a a18;
        ml3.b b17;
        ml3.a a19;
        if (state != 0) {
            if (state != 3) {
                if (state == 12) {
                    ((IVipFileUploadPerceptionBuild) QRoute.api(IVipFileUploadPerceptionBuild.class)).removeMsgListener();
                    ((IFontHelper) QRoute.api(IFontHelper.class)).clearFontListener();
                    this.isDestroyed = true;
                    CompletableJob completableJob = this.job;
                    if (completableJob != null) {
                        Job.DefaultImpls.cancel$default((Job) completableJob, (CancellationException) null, 1, (Object) null);
                    }
                    com.tencent.aio.main.businesshelper.b bVar = this.param;
                    if (bVar != null && (a18 = bVar.a()) != null && (b17 = a18.b()) != null && (a19 = b17.a(AIOServiceContact$IRecycleViewScrollCallBack.class)) != null) {
                        a19.c(getScrollListener());
                        return;
                    }
                    return;
                }
                return;
            }
            y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.aiotip.b
                @Override // java.lang.Runnable
                public final void run() {
                    VasAioDisplayHelper.onMoveToState$lambda$4(VasAioDisplayHelper.this);
                }
            });
            return;
        }
        this.isDestroyed = false;
        CompletableJob completableJob2 = this.job;
        if (completableJob2 != null) {
            completableJob2.start();
        }
        com.tencent.aio.main.businesshelper.b bVar2 = this.param;
        if (bVar2 != null && (a16 = bVar2.a()) != null && (b16 = a16.b()) != null && (a17 = b16.a(AIOServiceContact$IRecycleViewScrollCallBack.class)) != null) {
            a17.a(getScrollListener());
        }
        y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.aiotip.a
            @Override // java.lang.Runnable
            public final void run() {
                VasAioDisplayHelper.onMoveToState$lambda$2(VasAioDisplayHelper.this);
            }
        });
    }

    public boolean withMonitor() {
        return h.a.c(this);
    }
}
