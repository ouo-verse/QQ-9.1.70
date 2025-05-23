package com.tencent.mobileqq.wink.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B5\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\r\u0010\u0010R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/pager/b;", "T", "Lcom/tencent/mobileqq/wink/pager/ResettableLazy;", "", "c", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "pageId", "d", "g", "pageName", "", "e", "Z", h.F, "()Z", "isLightTheme", "needBottomPadding", "i", "j", "(Z)V", "isPrefetched", "Lkotlin/Function0;", "initializer", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b<T> extends ResettableLazy<T> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isLightTheme;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean needBottomPadding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isPrefetched;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull String pageId, @NotNull String pageName, boolean z16, boolean z17, @NotNull Function0<? extends T> initializer) {
        super(initializer);
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.pageId = pageId;
        this.pageName = pageName;
        this.isLightTheme = z16;
        this.needBottomPadding = z17;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getNeedBottomPadding() {
        return this.needBottomPadding;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getPageName() {
        return this.pageName;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsLightTheme() {
        return this.isLightTheme;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsPrefetched() {
        return this.isPrefetched;
    }

    public final void j(boolean z16) {
        this.isPrefetched = z16;
    }
}
