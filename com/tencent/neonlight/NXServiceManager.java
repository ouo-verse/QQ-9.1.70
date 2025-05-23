package com.tencent.neonlight;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.api.IWinkWeClipApi;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import i83.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJV\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042>\u0010\u000f\u001a:\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001b\u0012\u0019\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0006Jq\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000e0\u00112>\u0010\u000f\u001a:\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001b\u0012\u0019\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0006J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/neonlight/NXServiceManager;", "", "Lcom/tencent/neonlight/NXServiceManager$ModelType;", "modelType", "Lcom/tencent/neonlight/NXServiceManager$DeviceType;", "deviceType", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "", "completion", "b", "Lkotlin/Function1;", "", "progress", "a", "", "feature1", "feature2", "", "c", "<init>", "()V", "DeviceType", "ModelType", "neonlight-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class NXServiceManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NXServiceManager f337884a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/neonlight/NXServiceManager$DeviceType;", "", "(Ljava/lang/String;I)V", PreDownloadConstants.RPORT_KEY_CPU, "GPU", "NPU", "neonlight-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class DeviceType {
        private static final /* synthetic */ DeviceType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final DeviceType CPU;
        public static final DeviceType GPU;
        public static final DeviceType NPU;

        private static final /* synthetic */ DeviceType[] $values() {
            return new DeviceType[]{CPU, GPU, NPU};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42603);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            CPU = new DeviceType(PreDownloadConstants.RPORT_KEY_CPU, 0);
            GPU = new DeviceType("GPU", 1);
            NPU = new DeviceType("NPU", 2);
            $VALUES = $values();
        }

        DeviceType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static DeviceType valueOf(String str) {
            return (DeviceType) Enum.valueOf(DeviceType.class, str);
        }

        public static DeviceType[] values() {
            return (DeviceType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/neonlight/NXServiceManager$ModelType;", "", "(Ljava/lang/String;I)V", "VisualClipSmall", "neonlight-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class ModelType {
        private static final /* synthetic */ ModelType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ModelType VisualClipSmall;

        private static final /* synthetic */ ModelType[] $values() {
            return new ModelType[]{VisualClipSmall};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42609);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                VisualClipSmall = new ModelType("VisualClipSmall", 0);
                $VALUES = $values();
            }
        }

        ModelType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ModelType valueOf(String str) {
            return (ModelType) Enum.valueOf(ModelType.class, str);
        }

        public static ModelType[] values() {
            return (ModelType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/neonlight/NXServiceManager$a", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "neonlight-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements ResDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, Exception, Unit> f337885a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Double, Unit> f337886b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super Boolean, ? super Exception, Unit> function2, Function1<? super Double, Unit> function1) {
            this.f337885a = function2;
            this.f337886b = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2, (Object) function1);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isSuccess);
            } else {
                this.f337885a.invoke(Boolean.valueOf(isSuccess), null);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, progress);
            } else {
                this.f337886b.invoke(Double.valueOf(progress));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/neonlight/NXServiceManager$b", "Li83/i;", "", "onSuccess", "onFail", "neonlight-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements i {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, Exception, Unit> f337887a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super Exception, Unit> function2) {
            this.f337887a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // i83.i
        public void onFail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f337887a.invoke(Boolean.FALSE, null);
            }
        }

        @Override // i83.i
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f337887a.invoke(Boolean.TRUE, null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42655);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f337884a = new NXServiceManager();
        }
    }

    NXServiceManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull ModelType modelType, @NotNull Function1<? super Double, Unit> progress, @NotNull Function2<? super Boolean, ? super Exception, Unit> completion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, modelType, progress, completion);
            return;
        }
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(completion, "completion");
        try {
            if (modelType == ModelType.VisualClipSmall) {
                ((IWinkWeClipApi) QRoute.api(IWinkWeClipApi.class)).preDownloadWeClipModel(new a(completion, progress));
            }
        } catch (Exception e16) {
            QLog.e("NXServiceManager", 1, e16, new Object[0]);
            completion.invoke(Boolean.FALSE, e16);
        }
    }

    public final void b(@NotNull ModelType modelType, @NotNull DeviceType deviceType, @NotNull Function2<? super Boolean, ? super Exception, Unit> completion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, modelType, deviceType, completion);
            return;
        }
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(completion, "completion");
        try {
            if (modelType == ModelType.VisualClipSmall) {
                ((IWinkWeClipApi) QRoute.api(IWinkWeClipApi.class)).preloadWeClipModel(new b(completion));
            }
        } catch (Exception e16) {
            QLog.e("NXServiceManager", 1, e16, new Object[0]);
            completion.invoke(Boolean.FALSE, e16);
        }
    }

    public final float c(@NotNull float[] feature1, @NotNull float[] feature2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this, (Object) feature1, (Object) feature2)).floatValue();
        }
        Intrinsics.checkNotNullParameter(feature1, "feature1");
        Intrinsics.checkNotNullParameter(feature2, "feature2");
        return ((IWinkWeClipApi) QRoute.api(IWinkWeClipApi.class)).getSimilarityFromClipFeature(feature1, feature2);
    }
}
