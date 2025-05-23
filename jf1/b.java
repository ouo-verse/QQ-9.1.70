package jf1;

import android.view.ViewTreeObserver;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u00a8\u0006\u0005"}, d2 = {"Landroid/view/ViewTreeObserver;", "Ljf1/a;", "globalLayoutListener", "", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ViewTreeObserver viewTreeObserver, a aVar) {
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(aVar);
        }
    }
}
