package ar1;

import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\r\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lar1/g;", "", "", "d", "e", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lir1/a;", "b", "Lir1/a;", "mChanelListSlideUpReportUtil", "ar1/f", "c", "Lar1/f;", "scrollListener", "", "Z", "addedListeners", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ir1.a mChanelListSlideUpReportUtil;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f scrollListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean addedListeners;

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void d() {
        if (this.addedListeners) {
            return;
        }
        this.recyclerView.addOnScrollListener(this.scrollListener);
        this.addedListeners = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void e() {
        this.recyclerView.removeOnScrollListener(this.scrollListener);
        this.addedListeners = false;
    }
}
