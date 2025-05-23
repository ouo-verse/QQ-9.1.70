package cc4;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcc4/a;", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class a implements PAGView.PAGViewListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "DefaultPAGViewListener";

    /* renamed from: a, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationCancel(PAGView p06) {
        QLog.d(this.TAG, 1, "onAnimationCancel");
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationEnd(PAGView p06) {
        QLog.d(this.TAG, 1, "onAnimationEnd");
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationRepeat(PAGView p06) {
        QLog.d(this.TAG, 1, "onAnimationCancel");
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationStart(PAGView p06) {
        QLog.d(this.TAG, 1, "onAnimationStart");
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationUpdate(PAGView p06) {
    }
}
