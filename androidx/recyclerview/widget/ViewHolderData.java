package androidx.recyclerview.widget;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Landroidx/recyclerview/widget/ViewHolderData;", "", "totalHeight", "", "totalCount", "(II)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "getTotalHeight", "setTotalHeight", "add", "", "itemHeight", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ViewHolderData {
    private int totalCount;
    private int totalHeight;

    public ViewHolderData(int i3, int i16) {
        this.totalHeight = i3;
        this.totalCount = i16;
    }

    public final void add(int itemHeight) {
        this.totalHeight += itemHeight;
        this.totalCount++;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final int getTotalHeight() {
        return this.totalHeight;
    }

    public final void setTotalCount(int i3) {
        this.totalCount = i3;
    }

    public final void setTotalHeight(int i3) {
        this.totalHeight = i3;
    }
}
