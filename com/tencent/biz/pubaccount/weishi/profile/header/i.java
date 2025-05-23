package com.tencent.biz.pubaccount.weishi.profile.header;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0003\u0010\u0016\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/header/i;", "", "", "a", "Z", "e", "()Z", "isVisible", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "iconDrawable", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "", "d", "I", "()I", "textColor", "bgDrawable", "<init>", "(ZLandroid/graphics/drawable/Drawable;Ljava/lang/String;ILandroid/graphics/drawable/Drawable;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isVisible;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Drawable iconDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int textColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Drawable bgDrawable;

    public i(boolean z16, Drawable drawable, String text, int i3, Drawable drawable2) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.isVisible = z16;
        this.iconDrawable = drawable;
        this.text = text;
        this.textColor = i3;
        this.bgDrawable = drawable2;
    }

    /* renamed from: a, reason: from getter */
    public final Drawable getBgDrawable() {
        return this.bgDrawable;
    }

    /* renamed from: b, reason: from getter */
    public final Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    /* renamed from: c, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: d, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public /* synthetic */ i(boolean z16, Drawable drawable, String str, int i3, Drawable drawable2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i16 & 2) != 0 ? null : drawable, (i16 & 4) != 0 ? "" : str, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? null : drawable2);
    }
}
