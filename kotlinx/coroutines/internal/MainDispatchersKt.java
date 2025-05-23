package kotlinx.coroutines.internal;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\fH\u0000\u001a\f\u0010\r\u001a\u00020\u0003*\u00020\u000eH\u0007\u001a\u001a\u0010\u000f\u001a\u00020\u000e*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0082D\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0013"}, d2 = {"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "getSUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class MainDispatchersKt {

    @NotNull
    private static final String FAST_SERVICE_LOADER_PROPERTY_NAME = "kotlinx.coroutines.fast.service.loader";
    private static final boolean SUPPORT_MISSING = true;

    private static final MissingMainCoroutineDispatcher createMissingDispatcher(Throwable th5, String str) {
        if (SUPPORT_MISSING) {
            return new MissingMainCoroutineDispatcher(th5, str);
        }
        if (th5 == null) {
            throwMissingMainDispatcherException();
            throw new KotlinNothingValueException();
        }
        throw th5;
    }

    public static /* synthetic */ MissingMainCoroutineDispatcher createMissingDispatcher$default(Throwable th5, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            th5 = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        return createMissingDispatcher(th5, str);
    }

    @InternalCoroutinesApi
    public static final boolean isMissing(@NotNull MainCoroutineDispatcher mainCoroutineDispatcher) {
        return mainCoroutineDispatcher instanceof MissingMainCoroutineDispatcher;
    }

    @NotNull
    public static final Void throwMissingMainDispatcherException() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @InternalCoroutinesApi
    @NotNull
    public static final MainCoroutineDispatcher tryCreateDispatcher(@NotNull MainDispatcherFactory mainDispatcherFactory, @NotNull List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th5) {
            return createMissingDispatcher(th5, mainDispatcherFactory.hintOnError());
        }
    }

    private static /* synthetic */ void getSUPPORT_MISSING$annotations() {
    }
}
