package ec3;

import android.os.Build;
import com.tencent.mobileqq.zplan.event.api.Event;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0004J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rR\u001a\u0010\u0013\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lec3/b;", "", "", "d", "", "eventCode", "", "errCode", "errMsg", "", "params", "", "c", "Lcom/tencent/mobileqq/zplan/event/api/Event;", "event", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tag", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String tag = "BaseTechAndApiReport";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"ec3/b$b", "Lrh3/b;", "", "onSuccess", "", "errorCode", "", "msg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ec3.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10230b implements rh3.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Event f396090b;

        C10230b(Event event) {
            this.f396090b = event;
        }

        @Override // rh3.b
        public void onFailed(int errorCode, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(b.this.getTag(), 1, "api report# " + this.f396090b.getName() + ", failed\uff01error:" + errorCode + ", message:" + msg2);
        }

        @Override // rh3.b
        public void onSuccess() {
            QLog.i(b.this.getTag(), 1, "api report# " + this.f396090b.getName() + ", succ\uff01");
        }
    }

    public final void a(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Build.VERSION.SDK_INT == 23) {
            QLog.i(getTag(), 1, "api report# " + event.getName() + ", Android M skip!!!");
            return;
        }
        ((rh3.a) i.INSTANCE.a(rh3.a.class)).report(event, new C10230b(event));
    }

    /* renamed from: b, reason: from getter */
    public String getTag() {
        return this.tag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(String eventCode, int errCode, String errMsg, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!d()) {
            QLog.i(getTag(), 1, "finalReport# " + eventCode + ", code= " + errCode + ", params= " + params);
        }
        mb4.c.c(mb4.c.f416532a, eventCode, params, false, 4, null);
        if (errCode != 0) {
            a(new Event(eventCode, 0, errCode, errMsg, params));
        }
    }

    protected boolean d() {
        return false;
    }
}
