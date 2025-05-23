package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"androidx/core/view/MenuKt$iterator$1", "", "Landroid/view/MenuItem;", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, KMutableIterator {
    final /* synthetic */ Menu $this_iterator;
    private int index;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuKt$iterator$1(Menu menu) {
        this.$this_iterator = menu;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index < this.$this_iterator.size()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        Menu menu = this.$this_iterator;
        int i3 = this.index - 1;
        this.index = i3;
        menu.removeItem(i3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public MenuItem next() {
        Menu menu = this.$this_iterator;
        int i3 = this.index;
        this.index = i3 + 1;
        MenuItem item = menu.getItem(i3);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }
}
