package com.tencent.zplan.meme.encoder;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.f;
import com.tencent.zplan.meme.model.MemeRecordParams;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0002\"&B\u0007\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002JB\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0006J&\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aJ\"\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00132\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u001cR\u0014\u0010$\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010*\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00103R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0013018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/zplan/meme/encoder/MemeEncodeController;", "", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "recordParams", "", "portraitId", "", "e", "Lcom/tencent/zplan/meme/encoder/IRecordOperator;", "recordOperator", "Lwx4/c;", "d", "", "frameTimeInSec", "targetFrameCount", "outputFilePath", "tempFilePath", "scriptStatisticData", QQWinkConstants.COVER_PATH, "", "i", "", "pixels", "width", "height", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "r", "", "k", "actionCompleted", h.F, "l", DomainData.DOMAIN_NAME, "a", "Ljava/lang/String;", "TAG", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "f", "()Landroid/os/Handler;", "recordHandler", "c", "Lcom/tencent/zplan/meme/encoder/IRecordOperator;", "g", "()Lcom/tencent/zplan/meme/encoder/IRecordOperator;", "o", "(Lcom/tencent/zplan/meme/encoder/IRecordOperator;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/zplan/meme/encoder/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "encoderResMap", "frameRecordEndList", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeEncodeController {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private static final Lazy f385770f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy recordHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IRecordOperator recordOperator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, com.tencent.zplan.meme.encoder.b> encoderResMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, Boolean> frameRecordEndList;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J8\u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/zplan/meme/encoder/MemeEncodeController$a;", "", "Lcom/tencent/zplan/meme/encoder/IRecordOperator;", "Lcom/tencent/zplan/meme/encoder/b;", "resource", "", "portraitId", "", "recordPath", "", "frames", "", "b", "Ljava/util/concurrent/Executor;", "executor$delegate", "Lkotlin/Lazy;", "a", "()Ljava/util/concurrent/Executor;", "executor", "TAG_PREFIX", "Ljava/lang/String;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.meme.encoder.MemeEncodeController$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        public static /* synthetic */ void c(Companion companion, IRecordOperator iRecordOperator, com.tencent.zplan.meme.encoder.b bVar, int i3, String str, List list, int i16, Object obj) {
            String str2;
            List list2;
            if ((i16 & 4) != 0) {
                str2 = null;
            } else {
                str2 = str;
            }
            if ((i16 & 8) != 0) {
                list2 = null;
            } else {
                list2 = list;
            }
            companion.b(iRecordOperator, bVar, i3, str2, list2);
        }

        @Nullable
        public final Executor a() {
            return (Executor) MemeEncodeController.f385770f.getValue();
        }

        public final void b(@NotNull IRecordOperator onRecordDone, @NotNull com.tencent.zplan.meme.encoder.b resource, int i3, @Nullable String str, @Nullable List<String> list) {
            Intrinsics.checkNotNullParameter(onRecordDone, "$this$onRecordDone");
            Intrinsics.checkNotNullParameter(resource, "resource");
            Bundle bundle = new Bundle();
            bundle.putInt("MemeRecordActionStatus", resource.getStatus().toInt());
            bundle.putString("MemeRecordResultPath", str);
            if (list != null) {
                ArrayList<String> arrayList = new ArrayList<>(list.size());
                arrayList.addAll(list);
                bundle.putStringArrayList("MemeRecordFramePathList", arrayList);
            }
            bundle.putBoolean("MemeRecordOccurOOM", resource.getStatistic().getOccurOOM());
            onRecordDone.onRecordDone(resource.k(), i3, bundle);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/zplan/meme/encoder/MemeEncodeController$b;", "", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public interface b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0016R\"\u0010\u0017\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/zplan/meme/encoder/MemeEncodeController$c", "Lwx4/c;", "", "portraitId", "totalFrameCount", "", "scriptStatisticData", "", "f", "Lcom/tencent/zplan/meme/action/ActionStatus;", "status", "e", "b", "path", "realFrameCount", "a", "c", "", "Z", "g", "()Z", "d", "(Z)V", "occurOOM", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements wx4.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean occurOOM;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IRecordOperator f385778b;

        c(IRecordOperator iRecordOperator) {
            this.f385778b = iRecordOperator;
        }

        @Override // wx4.c
        public void a(int portraitId, @NotNull ActionStatus status, @NotNull String path, int realFrameCount) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(path, "path");
            Bundle bundle = new Bundle();
            bundle.putInt("MemeRecordActionStatus", status.toInt());
            bundle.putString("MemeRecordResultPath", path);
            bundle.putInt("MemeRecordRealFrameCount", realFrameCount);
            IRecordOperator iRecordOperator = this.f385778b;
            if (iRecordOperator != null) {
                iRecordOperator.onEncodeEnd(iRecordOperator.getParams().getUniKey(), portraitId, bundle);
            }
        }

        @Override // wx4.c
        public void b(int portraitId) {
            IRecordOperator iRecordOperator = this.f385778b;
            if (iRecordOperator != null) {
                iRecordOperator.onEncodeStart(iRecordOperator.getParams().getUniKey(), portraitId);
            }
        }

        @Override // wx4.c
        public void c(int portraitId, @NotNull ActionStatus status, @NotNull String path) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(path, "path");
            Bundle bundle = new Bundle();
            bundle.putInt("MemeRecordActionStatus", status.toInt());
            bundle.putString("MemeRecordCoverResultPath", path);
            IRecordOperator iRecordOperator = this.f385778b;
            if (iRecordOperator != null) {
                iRecordOperator.onRecordCoverDone(iRecordOperator.getParams().getUniKey(), portraitId, bundle);
            }
        }

        @Override // wx4.c
        public void d(boolean z16) {
            this.occurOOM = z16;
        }

        @Override // wx4.c
        public void e(int portraitId, @NotNull ActionStatus status, @Nullable String scriptStatisticData) {
            Intrinsics.checkNotNullParameter(status, "status");
            Bundle bundle = new Bundle();
            bundle.putInt("MemeRecordActionStatus", status.toInt());
            bundle.putString("MemeRecordScriptStatisticData", scriptStatisticData);
            IRecordOperator iRecordOperator = this.f385778b;
            if (iRecordOperator != null) {
                iRecordOperator.onRecordFrameEnd(iRecordOperator.getParams().getUniKey(), portraitId, bundle);
            }
        }

        @Override // wx4.c
        public void f(int portraitId, int totalFrameCount, @Nullable String scriptStatisticData) {
            Bundle bundle = new Bundle();
            bundle.putInt("MemeRecordTargetFrameCount", totalFrameCount);
            bundle.putString("MemeRecordScriptStatisticData", scriptStatisticData);
            IRecordOperator iRecordOperator = this.f385778b;
            if (iRecordOperator != null) {
                iRecordOperator.onRecordFrameStart(iRecordOperator.getParams().getUniKey(), portraitId, bundle);
            }
        }

        @Override // wx4.c
        /* renamed from: g, reason: from getter */
        public boolean getOccurOOM() {
            return this.occurOOM;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.tencent.zplan.meme.encoder.MemeEncodeController$INSTANCE$executor$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ThreadPoolExecutor invoke() {
                try {
                    int encodeThreadPoolSize = Meme.f385754h.k().getEncodeThreadPoolSize();
                    d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder]", 1, "ThreadPoolExecutor size:" + encodeThreadPoolSize, null, 8, null);
                    }
                    BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(encodeThreadPoolSize, encodeThreadPoolSize, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new Meme.TF("MemeEncoder-SDK-AsyncThread", 9));
                    baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
                    return baseThreadPoolExecutor;
                } catch (OutOfMemoryError e16) {
                    d a17 = LogUtil.f385285b.a();
                    if (a17 != null) {
                        a17.e("[zplan][MemePlayer-SDK][MemeEncoder]", 1, "init ThreadPoolExecutor exception", e16);
                    }
                    return null;
                }
            }
        });
        f385770f = lazy;
    }

    public MemeEncodeController() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.zplan.meme.encoder.MemeEncodeController$recordHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Handler invoke() {
                try {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MemeEncoder-SDK-Handler");
                    baseHandlerThread.start();
                    Handler handler = new Handler(baseHandlerThread.getLooper());
                    d a16 = LogUtil.f385285b.a();
                    if (a16 == null) {
                        return handler;
                    }
                    d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder]", 1, "create new handler:" + handler, null, 8, null);
                    return handler;
                } catch (OutOfMemoryError e16) {
                    d a17 = LogUtil.f385285b.a();
                    if (a17 != null) {
                        a17.e("[zplan][MemePlayer-SDK][MemeEncoder]", 1, "create recordHandler OOM", e16);
                    }
                    return null;
                }
            }
        });
        this.recordHandler = lazy;
        this.encoderResMap = new ConcurrentHashMap<>();
        this.frameRecordEndList = new ConcurrentHashMap<>();
        String str = "[zplan][MemePlayer-SDK][MemeEncoder][@" + Integer.toHexString(hashCode()) + ']';
        this.TAG = str;
        d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, str, 1, "new MemeEncoderControllerImpl", null, 8, null);
        }
    }

    private final wx4.c d(IRecordOperator recordOperator) {
        return new c(recordOperator);
    }

    private final String e(MemeRecordParams recordParams, int portraitId) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(portraitId);
        sb5.append(util.base64_pad_url);
        sb5.append(recordParams.getTaskId());
        return sb5.toString();
    }

    private final Handler f() {
        return (Handler) this.recordHandler.getValue();
    }

    public static /* synthetic */ boolean j(MemeEncodeController memeEncodeController, int i3, float f16, int i16, String str, String str2, String str3, String str4, int i17, Object obj) {
        String str5;
        if ((i17 & 32) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        return memeEncodeController.i(i3, f16, i16, str, str2, str5, str4);
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final IRecordOperator getRecordOperator() {
        return this.recordOperator;
    }

    public final boolean h(int portraitId, boolean actionCompleted, @Nullable String scriptStatisticData) {
        IRecordOperator iRecordOperator = this.recordOperator;
        if (iRecordOperator == null) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, this.TAG, 1, "onRecordFrameEnd fail, operator null, portraitId:" + portraitId, null, 8, null);
            }
            return false;
        }
        String e16 = e(iRecordOperator.getParams(), portraitId);
        com.tencent.zplan.meme.encoder.b bVar = this.encoderResMap.get(e16);
        if (bVar == null) {
            d a17 = LogUtil.f385285b.a();
            if (a17 != null) {
                d.a.b(a17, this.TAG, 1, "onRecordFrameEnd fail, resource null, resMapKey:" + e16, null, 8, null);
            }
            return false;
        }
        this.frameRecordEndList.put(e16, Boolean.valueOf(actionCompleted));
        d a18 = LogUtil.f385285b.a();
        if (a18 != null) {
            d.a.c(a18, this.TAG, 1, "onRecordFrameEnd, key:" + bVar.k() + ", resMapKey:" + e16 + ", complete:" + actionCompleted + ", listener:" + iRecordOperator, null, 8, null);
        }
        bVar.getStatistic().e(portraitId, bVar.getStatus(), scriptStatisticData);
        return true;
    }

    public final boolean i(int portraitId, float frameTimeInSec, int targetFrameCount, @NotNull String outputFilePath, @NotNull String tempFilePath, @Nullable String scriptStatisticData, @NotNull String coverPath) {
        Intrinsics.checkNotNullParameter(outputFilePath, "outputFilePath");
        Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        IRecordOperator iRecordOperator = this.recordOperator;
        if (portraitId >= 0 && frameTimeInSec > 0 && iRecordOperator != null) {
            MemeRecordParams params = iRecordOperator.getParams();
            String e16 = e(params, portraitId);
            wx4.c d16 = d(iRecordOperator);
            this.encoderResMap.put(e16, new com.tencent.zplan.meme.encoder.b(params, portraitId, (int) (1000 * frameTimeInSec), targetFrameCount, outputFilePath, tempFilePath, null, d16, coverPath));
            d16.f(portraitId, targetFrameCount, scriptStatisticData);
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, this.TAG, 1, "onRecordFrameStart, frameTimeInSec:" + frameTimeInSec + ", uniKey:" + params.getUniKey() + ", recordMode:" + params.getRecordMode() + ", encodeResCount:" + this.encoderResMap.size() + " resMapKey:" + e16, null, 8, null);
                return true;
            }
            return true;
        }
        d a17 = LogUtil.f385285b.a();
        if (a17 != null) {
            d.a.d(a17, this.TAG, 1, "onRecordFrameStart return false, portraitId:" + portraitId, null, 8, null);
        }
        return false;
    }

    public final void k(@NotNull Runnable r16) {
        Intrinsics.checkNotNullParameter(r16, "r");
        if (f() == null) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, this.TAG, 1, "onRecordFrame fail, handler null", null, 8, null);
                return;
            }
            return;
        }
        Handler f16 = f();
        if (f16 != null) {
            f16.post(r16);
        }
    }

    public final boolean l(int portraitId) {
        LogUtil logUtil = LogUtil.f385285b;
        d a16 = logUtil.a();
        if (a16 != null) {
            d.a.c(a16, this.TAG, 1, "onPostWriteEncodeFile, portraitId:" + portraitId, null, 8, null);
        }
        IRecordOperator iRecordOperator = this.recordOperator;
        if (iRecordOperator == null) {
            d a17 = logUtil.a();
            if (a17 != null) {
                d.a.b(a17, this.TAG, 1, "onPostWriteEncodeFile fail, operator null, portraitId:" + portraitId, null, 8, null);
            }
            return false;
        }
        String e16 = e(iRecordOperator.getParams(), portraitId);
        if (!this.frameRecordEndList.containsKey(e16)) {
            d a18 = logUtil.a();
            if (a18 != null) {
                d.a.c(a18, this.TAG, 1, "onPostWriteEncodeFile failed for not receive end event. resMapKey:" + e16, null, 8, null);
            }
            return false;
        }
        Boolean bool = this.frameRecordEndList.get(e16);
        com.tencent.zplan.meme.encoder.b bVar = this.encoderResMap.get(e16);
        Handler f16 = f();
        if (f16 == null) {
            d a19 = logUtil.a();
            if (a19 != null) {
                d.a.b(a19, this.TAG, 1, "onRecordFrameEnd fail, handler null, resMapKey:" + e16, null, 8, null);
            }
            return false;
        }
        f16.post(new MemeEncodeController$onPostWriteEncodeFile$1(this, bVar, bool, portraitId, e16, iRecordOperator));
        this.frameRecordEndList.remove(e16);
        return true;
    }

    public final boolean m(int portraitId, @NotNull byte[] pixels, int width, int height) {
        boolean z16;
        Triple triple;
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        boolean z17 = false;
        if (pixels.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && width > 0 && height > 0) {
            IRecordOperator iRecordOperator = this.recordOperator;
            if (iRecordOperator == null) {
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.b(a16, this.TAG, 1, "onRecordFrame fail, operator null, portraitId:" + portraitId, null, 8, null);
                }
                return false;
            }
            String e16 = e(iRecordOperator.getParams(), portraitId);
            com.tencent.zplan.meme.encoder.b bVar = this.encoderResMap.get(e16);
            if (bVar == null) {
                d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.b(a17, this.TAG, 1, "onRecordFrame fail, width:" + width + ", height:" + height + ", resource null", null, 8, null);
                }
                return false;
            }
            if (bVar.getPortraitId() != portraitId) {
                d a18 = LogUtil.f385285b.a();
                if (a18 != null) {
                    d.a.b(a18, this.TAG, 1, "onRecordFrame fail, portraitId:" + portraitId + " not equal to resource:" + bVar.getPortraitId(), null, 8, null);
                }
                return false;
            }
            bVar.a();
            int recordFrameCount = bVar.getRecordFrameCount();
            if (bVar.b().getFlipVertical()) {
                triple = new Triple(f.a(pixels, width, height, height), Integer.valueOf(height), Integer.valueOf(height));
            } else {
                triple = new Triple(pixels, Integer.valueOf(width), Integer.valueOf(height));
            }
            byte[] framePixels = (byte[]) triple.component1();
            int intValue = ((Number) triple.component2()).intValue();
            int intValue2 = ((Number) triple.component3()).intValue();
            try {
                a encoder = bVar.getEncoder();
                Intrinsics.checkNotNullExpressionValue(framePixels, "framePixels");
                z17 = encoder.b(portraitId, framePixels, intValue, intValue2);
            } catch (Exception e17) {
                d a19 = LogUtil.f385285b.a();
                if (a19 != null) {
                    a19.e(this.TAG, 1, "onRecordFrame error in handler", e17);
                }
            } catch (OutOfMemoryError e18) {
                d a26 = LogUtil.f385285b.a();
                if (a26 != null) {
                    a26.e(this.TAG, 1, "onRecordFrame oom in handler", e18);
                }
                bVar.getStatistic().d(true);
            }
            d a27 = LogUtil.f385285b.a();
            if (a27 != null) {
                d.a.a(a27, this.TAG, 1, "onRecordFrameV2 " + bVar.k() + ", resMapKey:" + e16 + ", index:" + recordFrameCount + ", width:" + width + ", height:" + height + " flip:" + bVar.b().getFlipVertical() + ", result:" + z17, null, 8, null);
            }
            return z17;
        }
        d a28 = LogUtil.f385285b.a();
        if (a28 != null) {
            d.a.b(a28, this.TAG, 1, "onRecordFrame fail, width:" + width + ", height:" + height + ", pixels.size:" + pixels.length, null, 8, null);
        }
        return false;
    }

    public final void n() {
        Handler f16;
        Looper looper;
        boolean s16 = Meme.f385754h.p().s();
        d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder]", 1, "quitSafely, recordHandler:" + f() + ", enableQuit:" + s16, null, 8, null);
        }
        if (s16 && (f16 = f()) != null && (looper = f16.getLooper()) != null) {
            looper.quitSafely();
        }
    }

    public final void o(@Nullable IRecordOperator iRecordOperator) {
        this.recordOperator = iRecordOperator;
    }
}
