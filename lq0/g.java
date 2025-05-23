package lq0;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 \n2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u0011"}, d2 = {"Llq0/g;", "", "", "a", "I", "b", "()I", "e", "(I)V", "pageCount", "d", "columnCount", "c", "f", "panelPaddingLRDP", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int pageCount = 8;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int columnCount = 4;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int panelPaddingLRDP = 20;

    /* renamed from: a, reason: from getter */
    public final int getColumnCount() {
        return this.columnCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getPageCount() {
        return this.pageCount;
    }

    /* renamed from: c, reason: from getter */
    public final int getPanelPaddingLRDP() {
        return this.panelPaddingLRDP;
    }

    public final void d(int i3) {
        this.columnCount = i3;
    }

    public final void e(int i3) {
        this.pageCount = i3;
    }

    public final void f(int i3) {
        this.panelPaddingLRDP = i3;
    }
}
