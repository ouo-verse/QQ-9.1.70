package cooperation.ad;

import android.os.Handler;
import com.tencent.gdtad.IAdConfigApi;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.ad.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0002\u0007\u000bB\u000f\u0012\u0006\u0010$\u001a\u00020\u000f\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcooperation/ad/c;", "", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcooperation/ad/c$b;", "a", "Lcooperation/ad/c$b;", "mGuardLifeCycleObserver", "", "b", "J", "mLastBackgroundTime", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/activity/home/Conversation;", "kotlin.jvm.PlatformType", "c", "Lmqq/util/WeakReference;", "mWeakConversation", "Lcom/tencent/mobileqq/activity/home/a;", "d", "Lcom/tencent/mobileqq/activity/home/a;", "mAmsAdTabConversationApi", "e", "mLastRequestTime", "f", "mDefaultRequestInternal", "", "g", "Ljava/lang/String;", "mDefaultRequestCookie", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "j", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "entity", "conversation", "<init>", "(Lcom/tencent/mobileqq/activity/home/Conversation;)V", tl.h.F, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mGuardLifeCycleObserver;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long mLastBackgroundTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<Conversation> mWeakConversation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.home.a mAmsAdTabConversationApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mLastRequestTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mDefaultRequestInternal;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mDefaultRequestCookie;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"cooperation/ad/c$c", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "", "msg", "", "onRsp", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cooperation.ad.c$c, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static final class C10100c implements VasAdCallback {
        C10100c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(access.AdGetRsp adGetRsp, c this$0) {
            PBRepeatMessageField<access.ExpInfo> pBRepeatMessageField;
            List<access.ExpInfo> list;
            boolean z16;
            PBInt64Field pBInt64Field;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (adGetRsp != null && (pBInt64Field = adGetRsp.next_req_gap_in_seconds) != null) {
                long j3 = pBInt64Field.get();
                if (j3 > 0) {
                    this$0.mDefaultRequestInternal = j3 * 1000;
                    this$0.j().putLong("ams_banner_req_internal", this$0.mDefaultRequestInternal);
                }
            }
            if (adGetRsp != null && (pBRepeatMessageField = adGetRsp.ext) != null && (list = pBRepeatMessageField.get()) != null) {
                for (access.ExpInfo expInfo : list) {
                    if (expInfo.key.get().equals("last_req_cookie")) {
                        String str = expInfo.value.get();
                        if (str != null && str.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            String str2 = expInfo.value.get();
                            Intrinsics.checkNotNullExpressionValue(str2, "item.value.get()");
                            this$0.mDefaultRequestCookie = str2;
                            return;
                        }
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(qq_ad_get.QQAdGetRsp.AdInfo adInfo, c this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            GdtAd gdtAd = new GdtAd(adInfo);
            this$0.mAmsAdTabConversationApi.e().t(gdtAd);
            this$0.mAmsAdTabConversationApi.b().s(gdtAd);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onRsp(int retCode, @Nullable final access.AdGetRsp adRsp, @NotNull String msg2) {
            final qq_ad_get.QQAdGetRsp.AdInfo adInfo;
            String str;
            access.RetMsg retMsg;
            PBStringField pBStringField;
            qq_ad_get.QQAdGetRsp qQAdGetRsp;
            PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField;
            List<qq_ad_get.QQAdGetRsp.PosAdInfo> list;
            Object firstOrNull;
            PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo> pBRepeatMessageField2;
            List<qq_ad_get.QQAdGetRsp.AdInfo> list2;
            Object firstOrNull2;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (adRsp != null && (qQAdGetRsp = adRsp.qq_ad_get_rsp) != null && (pBRepeatMessageField = qQAdGetRsp.pos_ads_info) != null && (list = pBRepeatMessageField.get()) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo = (qq_ad_get.QQAdGetRsp.PosAdInfo) firstOrNull;
                if (posAdInfo != null && (pBRepeatMessageField2 = posAdInfo.ads_info) != null && (list2 = pBRepeatMessageField2.get()) != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                    adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) firstOrNull2;
                    if (adRsp == null && (retMsg = adRsp.ret_msg) != null && (pBStringField = retMsg.err_msg) != null) {
                        str = pBStringField.get();
                    } else {
                        str = null;
                    }
                    QLog.d("AmsAdBannerManager", 1, "onRsp: code " + retCode + ", msg " + str + " adInfo " + adInfo);
                    final c cVar = c.this;
                    ThreadManagerV2.excute(new Runnable() { // from class: cooperation.ad.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.C10100c.c(access.AdGetRsp.this, cVar);
                        }
                    }, 64, null, false);
                    if (adInfo != null) {
                        QLog.d("AmsAdBannerManager", 1, " adInfo null, cancel show banner");
                        c.this.k();
                        return;
                    } else {
                        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                        final c cVar2 = c.this;
                        uIHandlerV2.post(new Runnable() { // from class: cooperation.ad.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.C10100c.d(qq_ad_get.QQAdGetRsp.AdInfo.this, cVar2);
                            }
                        });
                        return;
                    }
                }
            }
            adInfo = null;
            if (adRsp == null) {
            }
            str = null;
            QLog.d("AmsAdBannerManager", 1, "onRsp: code " + retCode + ", msg " + str + " adInfo " + adInfo);
            final c cVar3 = c.this;
            ThreadManagerV2.excute(new Runnable() { // from class: cooperation.ad.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.C10100c.c(access.AdGetRsp.this, cVar3);
                }
            }, 64, null, false);
            if (adInfo != null) {
            }
        }
    }

    public c(@NotNull Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        WeakReference<Conversation> weakReference = new WeakReference<>(conversation);
        this.mWeakConversation = weakReference;
        this.mAmsAdTabConversationApi = new com.tencent.mobileqq.activity.home.a(weakReference);
        this.mDefaultRequestInternal = j().getLong("ams_banner_req_internal", 10000L);
        this.mDefaultRequestCookie = "";
        if (GuardManager.sInstance != null) {
            b bVar = new b(this);
            this.mGuardLifeCycleObserver = bVar;
            GuardManager.sInstance.registerCallBack(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MMKVOptionEntityV2 j() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        return fromV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAmsAdTabConversationApi.e().s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add("7089842112683046");
        build.setBusiType(70);
        build.setBannerAdPush(this$0.mAmsAdTabConversationApi.e().j());
        build.setLastRequestCookie(this$0.mDefaultRequestCookie);
        this$0.mLastRequestTime = System.currentTimeMillis();
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).requestAd(build, new C10100c());
    }

    public final void k() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.ad.b
            @Override // java.lang.Runnable
            public final void run() {
                c.l(c.this);
            }
        });
    }

    public final void m() {
        GuardManager.sInstance.unregisterCallback(this.mGuardLifeCycleObserver);
    }

    public final void n() {
        boolean z16;
        Conversation conversation = this.mWeakConversation.get();
        if (conversation != null && true == conversation.isForeground()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.d("AmsAdBannerManager", 1, " sendOlympicAdRequest background cancel");
            return;
        }
        if (!((IAdConfigApi) QRoute.api(IAdConfigApi.class)).getCanShowTabAdBanner()) {
            QLog.d("AmsAdBannerManager", 1, " sendOlympicAdRequest switch cancel");
            return;
        }
        if (i.f390099a.c()) {
            QLog.d("AmsAdBannerManager", 1, " sendOlympicAdRequest click cancel");
        } else if (System.currentTimeMillis() - this.mLastRequestTime < this.mDefaultRequestInternal) {
            QLog.d("AmsAdBannerManager", 1, " sendOlympicAdRequest internal cancel");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: cooperation.ad.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.o(c.this);
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcooperation/ad/c$b;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "Lmqq/util/WeakReference;", "Lcooperation/ad/c;", "d", "Lmqq/util/WeakReference;", "mWeakReference", "manager", "<init>", "(Lcooperation/ad/c;)V", "e", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes28.dex */
    public static final class b implements IGuardInterface {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<c> mWeakReference;

        public b(@NotNull c manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            this.mWeakReference = new WeakReference<>(manager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c cVar) {
            cVar.n();
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            WeakReference<c> weakReference = this.mWeakReference;
            if (weakReference == null) {
                QLog.e("AmsAdBannerManagerGuardLifeCycleObserver", 1, "onApplicationForeground   mWeakReference == null");
                return;
            }
            c cVar = weakReference.get();
            if (cVar == null) {
                QLog.e("AmsAdBannerManagerGuardLifeCycleObserver", 1, "onApplicationForeground   manager == null");
                return;
            }
            cVar.k();
            cVar.mLastBackgroundTime = System.currentTimeMillis();
            QLog.d("AmsAdBannerManagerGuardLifeCycleObserver", 1, "onApplicationBackground   | mLastBackgroundTime = " + cVar.mLastBackgroundTime);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            WeakReference<c> weakReference = this.mWeakReference;
            if (weakReference == null) {
                QLog.e("AmsAdBannerManagerGuardLifeCycleObserver", 1, "onApplicationForeground   mWeakReference == null");
                return;
            }
            final c cVar = weakReference.get();
            if (cVar == null) {
                QLog.e("AmsAdBannerManagerGuardLifeCycleObserver", 1, "onApplicationForeground   manager == null");
                return;
            }
            if (cVar.mLastBackgroundTime == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - cVar.mLastBackgroundTime;
            QLog.d("AmsAdBannerManagerGuardLifeCycleObserver", 1, "onApplicationForeground   | curTime = " + currentTimeMillis + " | mLastBackgroundTime: " + cVar.mLastBackgroundTime + " | intervalTime = " + (j3 / 1000));
            if (currentTimeMillis - cVar.mLastBackgroundTime > 5000) {
                ThreadManagerV2.executeDelay(new Runnable() { // from class: cooperation.ad.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.b.b(c.this);
                    }
                }, 16, null, false, ((IAdConfigApi) QRoute.api(IAdConfigApi.class)).getRequestTabAdBannerDelay());
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
        }
    }
}
