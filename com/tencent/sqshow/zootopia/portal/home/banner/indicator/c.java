package com.tencent.sqshow.zootopia.portal.home.banner.indicator;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\t\b\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\bB)\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0010\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/c;", "", "", "a", "I", "b", "()I", "setLeftMargin", "(I)V", "leftMargin", "d", "setTopMargin", "topMargin", "c", "setRightMargin", "rightMargin", "setBottomMargin", "bottomMargin", "<init>", "()V", "marginSize", "(IIII)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int leftMargin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int topMargin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int rightMargin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int bottomMargin;

    public c() {
        this(ra4.a.f431010a.b());
    }

    /* renamed from: a, reason: from getter */
    public final int getBottomMargin() {
        return this.bottomMargin;
    }

    /* renamed from: b, reason: from getter */
    public final int getLeftMargin() {
        return this.leftMargin;
    }

    /* renamed from: c, reason: from getter */
    public final int getRightMargin() {
        return this.rightMargin;
    }

    /* renamed from: d, reason: from getter */
    public final int getTopMargin() {
        return this.topMargin;
    }

    public c(int i3) {
        this(i3, i3, i3, i3);
    }

    public c(int i3, int i16, int i17, int i18) {
        this.leftMargin = i3;
        this.topMargin = i16;
        this.rightMargin = i17;
        this.bottomMargin = i18;
    }
}
