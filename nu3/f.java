package nu3;

import android.util.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lnu3/f;", "Lee4/a;", "", "tag", "message", "", "v", "d", "i", "w", "e", "", "t", "<init>", "()V", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f implements ee4.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lnu3/f$a;", "", "", "a", "", "HEAD", "Ljava/lang/String;", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: nu3.f$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final void a() {
            ee4.b.g(3);
            ee4.b.h(new f());
        }
    }

    @Override // ee4.a
    public void d(String tag, String message) {
        QMLog.d("WS_" + tag, message);
    }

    @Override // ee4.a
    public void e(String tag, String message) {
        QMLog.e("WS_" + tag, message);
    }

    @Override // ee4.a
    public void i(String tag, String message) {
        QMLog.i("WS_" + tag, message);
    }

    @Override // ee4.a
    public void w(String tag, String message) {
        QMLog.w("WS_" + tag, message);
    }

    @Override // ee4.a
    public void e(String tag, String message, Throwable t16) {
        QMLog.e("WS_" + tag, message, t16);
    }

    @Override // ee4.a
    public void v(String tag, String message) {
        if (message == null) {
            message = "null";
        }
        Log.v(tag, message);
    }
}
