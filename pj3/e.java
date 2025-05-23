package pj3;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.lite.util.ZPlanFilamentLoadSoUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lpj3/e;", "Ldl0/d;", "Ljava/lang/ref/WeakReference;", "Lgl0/b;", "callbackRef", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e implements dl0.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"pj3/e$a", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements gl0.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<gl0.b> f426332a;

        a(WeakReference<gl0.b> weakReference) {
            this.f426332a = weakReference;
        }

        @Override // gl0.b
        public void a(boolean isSuccess, boolean downloadSo, int errCode, String errMsg) {
            gl0.b bVar = this.f426332a.get();
            if (bVar != null) {
                bVar.a(isSuccess, downloadSo, errCode, errMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(WeakReference callbackRef) {
        Intrinsics.checkNotNullParameter(callbackRef, "$callbackRef");
        try {
            bl0.a aVar = bl0.a.f28591a;
            ZPlanFilamentLoadSoUtil.INSTANCE.downloadAndLoadSoReal(new a(callbackRef));
        } catch (Exception e16) {
            gl0.b bVar = (gl0.b) callbackRef.get();
            if (bVar != null) {
                bVar.a(false, false, -1, "Unexpected exception when loading zplan_service library: " + e16.getMessage());
            }
        } catch (UnsatisfiedLinkError e17) {
            gl0.b bVar2 = (gl0.b) callbackRef.get();
            if (bVar2 != null) {
                bVar2.a(false, false, -1, "Failed to load zplan_service library: " + e17.getMessage());
            }
        }
    }

    @Override // dl0.d
    public void a(final WeakReference<gl0.b> callbackRef) {
        Intrinsics.checkNotNullParameter(callbackRef, "callbackRef");
        ThreadManagerV2.excute(new Runnable() { // from class: pj3.d
            @Override // java.lang.Runnable
            public final void run() {
                e.c(callbackRef);
            }
        }, 16, null, true);
    }
}
