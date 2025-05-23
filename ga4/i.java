package ga4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lga4/i;", "Lga4/f;", "", "d", "f", "Lga4/g;", "dialogView", "e", "g", "b", "", "a", "Lmqq/util/WeakReference;", "Lga4/h;", "dismissListener", "c", "", "orientation", tl.h.F, "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "mContainer", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "mShowingDialog", "Lmqq/util/WeakReference;", "mDismissListener", "<init>", "(Landroid/view/ViewGroup;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup mContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LinkedList<g> mShowingDialog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WeakReference<h> mDismissListener;

    public i(ViewGroup mContainer) {
        Intrinsics.checkNotNullParameter(mContainer, "mContainer");
        this.mContainer = mContainer;
        this.mShowingDialog = new LinkedList<>();
    }

    @Override // ga4.f
    public boolean a() {
        g peekFirst = this.mShowingDialog.peekFirst();
        if (peekFirst == null) {
            return false;
        }
        QLog.i("PanelDialogController_", 1, "handleBackEvent currentTop:" + peekFirst);
        if (peekFirst.a()) {
            return true;
        }
        g(peekFirst);
        return true;
    }

    @Override // ga4.f
    public void b(g dialogView) {
        Intrinsics.checkNotNullParameter(dialogView, "dialogView");
        QLog.i("PanelDialogController_", 1, "hideImmediately dialogView:" + dialogView);
        this.mContainer.removeView(dialogView.getView());
        this.mShowingDialog.remove(dialogView);
    }

    @Override // ga4.f
    public void c(WeakReference<h> dismissListener) {
        Intrinsics.checkNotNullParameter(dismissListener, "dismissListener");
        this.mDismissListener = dismissListener;
    }

    @Override // ga4.f
    public void d() {
        g pollFirst = this.mShowingDialog.pollFirst();
        if (pollFirst == null) {
            return;
        }
        g(pollFirst);
    }

    @Override // ga4.f
    public void e(g dialogView) {
        h hVar;
        Intrinsics.checkNotNullParameter(dialogView, "dialogView");
        View view = dialogView.getView();
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            this.mContainer.addView(view);
        } else if (!Intrinsics.areEqual(viewGroup, this.mContainer)) {
            viewGroup.removeView(view);
            this.mContainer.addView(view);
        }
        dialogView.onShow();
        WeakReference<h> weakReference = this.mDismissListener;
        if (weakReference != null && (hVar = weakReference.get()) != null) {
            hVar.b(dialogView);
        }
        this.mShowingDialog.push(dialogView);
    }

    @Override // ga4.f
    public void f() {
        while (this.mShowingDialog.size() > 0) {
            d();
        }
    }

    @Override // ga4.f
    public void g(g dialogView) {
        h hVar;
        Intrinsics.checkNotNullParameter(dialogView, "dialogView");
        QLog.i("PanelDialogController_", 1, "dismiss dialogView:" + dialogView);
        dialogView.onDismiss();
        WeakReference<h> weakReference = this.mDismissListener;
        if (weakReference == null || (hVar = weakReference.get()) == null) {
            return;
        }
        hVar.a(dialogView);
    }

    public void h(int orientation) {
        List list;
        list = CollectionsKt___CollectionsKt.toList(this.mShowingDialog);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((g) it.next()).e(orientation);
        }
    }
}
