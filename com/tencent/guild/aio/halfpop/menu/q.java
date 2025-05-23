package com.tencent.guild.aio.halfpop.menu;

import android.graphics.ColorFilter;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/q;", "", "", "a", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "f", "(Ljava/lang/Integer;)V", "actionMenuItemBgId", "Landroid/graphics/ColorFilter;", "Landroid/graphics/ColorFilter;", "()Landroid/graphics/ColorFilter;", "e", "(Landroid/graphics/ColorFilter;)V", "actionMenuIconBgColorFilter", "c", "d", tl.h.F, "textMenuItemBgId", "g", "lineDividerBgId", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @DrawableRes
    @Nullable
    private Integer actionMenuItemBgId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ColorFilter actionMenuIconBgColorFilter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @DrawableRes
    @Nullable
    private Integer textMenuItemBgId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @DrawableRes
    @Nullable
    private Integer lineDividerBgId;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final ColorFilter getActionMenuIconBgColorFilter() {
        return this.actionMenuIconBgColorFilter;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Integer getActionMenuItemBgId() {
        return this.actionMenuItemBgId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getLineDividerBgId() {
        return this.lineDividerBgId;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Integer getTextMenuItemBgId() {
        return this.textMenuItemBgId;
    }

    public final void e(@Nullable ColorFilter colorFilter) {
        this.actionMenuIconBgColorFilter = colorFilter;
    }

    public final void f(@Nullable Integer num) {
        this.actionMenuItemBgId = num;
    }

    public final void g(@Nullable Integer num) {
        this.lineDividerBgId = num;
    }

    public final void h(@Nullable Integer num) {
        this.textMenuItemBgId = num;
    }
}
