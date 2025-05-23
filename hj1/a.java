package hj1;

import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lhj1/a;", "", "", "exception", "", "a", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f405185a = new a();

    a() {
    }

    public final int a(@NotNull Throwable exception) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (exception instanceof SSLPeerUnverifiedException) {
            return 12;
        }
        if (exception instanceof UnknownHostException) {
            return 9;
        }
        if (exception instanceof SSLHandshakeException) {
            return 15;
        }
        if (exception instanceof IllegalStateException) {
            String stackTraceString = Log.getStackTraceString(exception);
            Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(exception)");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString, (CharSequence) "Connection is not open", false, 2, (Object) null);
            if (contains$default) {
                return 50007;
            }
            return 5;
        }
        if (exception instanceof SocketException) {
            return 6;
        }
        if (exception instanceof SocketTimeoutException) {
            return 7;
        }
        if (exception instanceof FileNotFoundException) {
            return 1;
        }
        if (exception instanceof IOException) {
            return b(exception);
        }
        if (exception instanceof Exception) {
            return 4;
        }
        if (exception instanceof OutOfMemoryError) {
            return 3;
        }
        if (exception instanceof JSONException) {
            return -6;
        }
        return -1;
    }

    public final int b(@NotNull Throwable exception) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        Intrinsics.checkNotNullParameter(exception, "exception");
        String stackTraceString = Log.getStackTraceString(exception);
        Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(exception)");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString, (CharSequence) "Canceled", false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString, (CharSequence) "No space left on device", false, 2, (Object) null);
            if (!contains$default2) {
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString, (CharSequence) "Network is unreachable", false, 2, (Object) null);
                if (!contains$default3) {
                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString, (CharSequence) "No route to host", false, 2, (Object) null);
                    if (!contains$default4) {
                        contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) stackTraceString, (CharSequence) "Connection refused", false, 2, (Object) null);
                        if (!contains$default5) {
                            return 2;
                        }
                        return 50006;
                    }
                    return 50005;
                }
                return 50004;
            }
            return 50003;
        }
        return -5;
    }
}
