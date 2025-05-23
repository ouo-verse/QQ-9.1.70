package ay3;

import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lay3/a;", "", "", "b", "Ljava/lang/Boolean;", "sCompressVideoWithAsyncMode", "a", "()Z", "isCompressVideoWithAsyncMode", "<init>", "()V", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f27350a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean sCompressVideoWithAsyncMode;

    a() {
    }

    public final boolean a() {
        if (sCompressVideoWithAsyncMode == null) {
            sCompressVideoWithAsyncMode = Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_video_compress_mode", false));
        }
        return Intrinsics.areEqual(sCompressVideoWithAsyncMode, Boolean.TRUE);
    }
}
