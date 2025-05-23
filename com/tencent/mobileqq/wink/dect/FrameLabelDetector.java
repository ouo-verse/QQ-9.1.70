package com.tencent.mobileqq.wink.dect;

import com.gyailib.library.GYAIVideoClassify;
import com.gyailib.library.GYVideoClassifyResult;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.hippy.qq.adapter.image.decoder.ImageDetector;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b&\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00028DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/dect/FrameLabelDetector;", "Lcom/tencent/mobileqq/wink/dect/c;", "Lcom/gyailib/library/GYAIVideoClassify;", h.F, "", "f", "", "e", "b", "Z", "inited", "c", "Lkotlin/Lazy;", "i", "()Lcom/gyailib/library/GYAIVideoClassify;", "videoClassifier", "<init>", "()V", "d", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class FrameLabelDetector implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final List<AEResInfo> f318189e;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean inited;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy videoClassifier;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\"\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/dect/FrameLabelDetector$a;", "", "Lcom/gyailib/library/GYVideoClassifyResult;", "classifyResult", "", "", "b", "c", "", "a", "DEVICE_CONFIG_ARM", "Ljava/lang/String;", "FACE_DIR", "GENDER_AGE_DIR", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "kotlin.jvm.PlatformType", "REQUIRED_BUNDLES", "Ljava/util/List;", "SCENE_DIR", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.dect.FrameLabelDetector$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            Iterator it = FrameLabelDetector.f318189e.iterator();
            boolean z16 = true;
            while (it.hasNext()) {
                if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist((AEResInfo) it.next())) {
                    z16 = false;
                }
            }
            if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AE_RES_BASE_PACKAGE)) {
                return false;
            }
            return z16;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
        
            r8 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{", "}, false, 0, 6, (java.lang.Object) null);
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<String> b(@NotNull GYVideoClassifyResult classifyResult) {
            List<String> emptyList;
            List<String> split$default;
            Intrinsics.checkNotNullParameter(classifyResult, "classifyResult");
            String str = classifyResult.classifyName;
            if (str == null || split$default == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            return split$default;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
        
            r8 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<String> c(@NotNull GYVideoClassifyResult classifyResult) {
            List<String> emptyList;
            List<String> split$default;
            Intrinsics.checkNotNullParameter(classifyResult, "classifyResult");
            String str = classifyResult.classifyType;
            if (str == null || split$default == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            return split$default;
        }

        Companion() {
        }
    }

    static {
        List<AEResInfo> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AEResInfo[]{AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE, AEResInfo.LIGHT_RES_BUNDLE_SCENE});
        f318189e = listOf;
    }

    public FrameLabelDetector() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GYAIVideoClassify>() { // from class: com.tencent.mobileqq.wink.dect.FrameLabelDetector$videoClassifier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GYAIVideoClassify invoke() {
                GYAIVideoClassify h16;
                FrameLabelDetector.this.inited = true;
                h16 = FrameLabelDetector.this.h();
                return h16;
            }
        });
        this.videoClassifier = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        Intrinsics.checkNotNullExpressionValue(RFWApplication.getApplication(), "getApplication()");
        if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AE_RES_BASE_PACKAGE)) {
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).peakRequestAEBaseRes();
        }
        for (AEResInfo aEResInfo : f318189e) {
            if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aEResInfo)) {
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GYAIVideoClassify h() {
        Map<String, String> mapOf;
        try {
            Result.Companion companion = Result.INSTANCE;
            GYAIVideoClassify gYAIVideoClassify = new GYAIVideoClassify();
            SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
            sDKDeviceConfig.setDevice("ARM");
            gYAIVideoClassify.initInstance(sDKDeviceConfig);
            SDKModelConfig sDKModelConfig = new SDKModelConfig();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("scene-dir", ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir("SCENE_CLASSIFY")), TuplesKt.to("face-dir", ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir("FACE_AGENT")), TuplesKt.to("feature-dir", ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(LightConstants.AgentType.FACE_STATIC_FEATURE_AGENT)));
            sDKModelConfig.modelPaths = mapOf;
            QLog.d(ImageDetector.TAG, 4, "set up model result = " + gYAIVideoClassify.setupWithModel(sDKModelConfig));
            return gYAIVideoClassify;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            if (Result.m482isFailureimpl(Result.m476constructorimpl(ResultKt.createFailure(th5)))) {
                QLog.e(ImageDetector.TAG, 1, "FrameLabelDetector init failure");
                return null;
            }
            return null;
        }
    }

    public void e() {
        GYAIVideoClassify i3;
        if (this.inited && (i3 = i()) != null) {
            i3.cleanupModelData();
        }
    }

    public final boolean f() {
        if (INSTANCE.a()) {
            return true;
        }
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.dect.a
            @Override // java.lang.Runnable
            public final void run() {
                FrameLabelDetector.g();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final GYAIVideoClassify i() {
        return (GYAIVideoClassify) this.videoClassifier.getValue();
    }
}
