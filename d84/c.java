package d84;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.af;
import d84.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\b\rB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Ld84/c;", "", "Ld84/c$a;", "cb", "", "e", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Ld84/c$a;", "", "Lcom/tencent/image/URLDrawable;", "drawable", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface a {
        void a(URLDrawable drawable);
    }

    public c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, a cb5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        this$0.e(cb5);
    }

    private final void e(final a cb5) {
        String a16 = af.f373257a.a(this.context, "zootopia_scene_loading_anim_outer_apng.png");
        if (a16 == null) {
            QLog.e("ZPlanLoadingAnimHelper_", 1, "filePath is null");
            return;
        }
        ApngOptions apngOptions = new ApngOptions();
        int dimension = (int) this.context.getResources().getDimension(R.dimen.f12627z);
        apngOptions.setRequestWidth(dimension);
        apngOptions.setRequestHeight(dimension);
        final URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", apngOptions, a16);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: d84.b
            @Override // java.lang.Runnable
            public final void run() {
                c.f(c.a.this, apngURLDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(a cb5, URLDrawable uRLDrawable) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.a(uRLDrawable);
    }

    public final void c(final a cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ThreadManagerV2.excute(new Runnable() { // from class: d84.a
            @Override // java.lang.Runnable
            public final void run() {
                c.d(c.this, cb5);
            }
        }, 64, null, true);
    }
}
