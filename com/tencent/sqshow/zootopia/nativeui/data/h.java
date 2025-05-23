package com.tencent.sqshow.zootopia.nativeui.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0016\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/h;", "", "", "a", "Z", "f", "()Z", "k", "(Z)V", "showTitleBar", "b", "c", "i", "showHistoryBar", "d", "j", "showRecommendBar", "e", "setShowSaveBar", "showSaveBar", "g", "showCategoryBar", tl.h.F, "showCreateRoleBubble", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean showTitleBar = true;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean showHistoryBar = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean showRecommendBar = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean showSaveBar = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean showCategoryBar = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showCreateRoleBubble = true;

    /* renamed from: a, reason: from getter */
    public final boolean getShowCategoryBar() {
        return this.showCategoryBar;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getShowCreateRoleBubble() {
        return this.showCreateRoleBubble;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getShowHistoryBar() {
        return this.showHistoryBar;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getShowRecommendBar() {
        return this.showRecommendBar;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getShowSaveBar() {
        return this.showSaveBar;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getShowTitleBar() {
        return this.showTitleBar;
    }

    public final void g(boolean z16) {
        this.showCategoryBar = z16;
    }

    public final void h(boolean z16) {
        this.showCreateRoleBubble = z16;
    }

    public final void i(boolean z16) {
        this.showHistoryBar = z16;
    }

    public final void j(boolean z16) {
        this.showRecommendBar = z16;
    }

    public final void k(boolean z16) {
        this.showTitleBar = z16;
    }
}
