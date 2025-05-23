package id3;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.event.api.Event;
import com.tencent.qphone.base.util.QLog;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004\u00a8\u0006\t"}, d2 = {"Lid3/b;", "", "Lcom/tencent/mobileqq/zplan/event/api/Event;", "event", "", "b", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"id3/b$b", "Lrh3/b;", "", "onSuccess", "", "errorCode", "", "msg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: id3.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10520b implements rh3.b {
        C10520b() {
        }

        @Override // rh3.b
        public void onFailed(int errorCode, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e("BaseEventReportHelper_", 1, "onFailed errorCode:" + errorCode + ", msg:" + msg2);
        }

        @Override // rh3.b
        public void onSuccess() {
            QLog.i("BaseEventReportHelper_", 1, "report onSuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Event event) {
        Intrinsics.checkNotNullParameter(event, "$event");
        ((rh3.a) i.INSTANCE.a(rh3.a.class)).report(event, new C10520b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(final Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ThreadManagerV2.excute(new Runnable() { // from class: id3.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(Event.this);
            }
        }, 128, null, false);
    }
}
