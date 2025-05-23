package com.tencent.guild.aio.halfpop.menu;

import androidx.annotation.ColorInt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/p;", "", "", "a", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "d", "(Ljava/lang/Integer;)V", "actionMenuTextColorId", "b", "e", "textMenuTextColorId", "c", "f", "thickLineDividerBgColorId", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @ColorInt
    @Nullable
    private Integer actionMenuTextColorId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @ColorInt
    @Nullable
    private Integer textMenuTextColorId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @ColorInt
    @Nullable
    private Integer thickLineDividerBgColorId;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getActionMenuTextColorId() {
        return this.actionMenuTextColorId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Integer getTextMenuTextColorId() {
        return this.textMenuTextColorId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getThickLineDividerBgColorId() {
        return this.thickLineDividerBgColorId;
    }

    public final void d(@Nullable Integer num) {
        this.actionMenuTextColorId = num;
    }

    public final void e(@Nullable Integer num) {
        this.textMenuTextColorId = num;
    }

    public final void f(@Nullable Integer num) {
        this.thickLineDividerBgColorId = num;
    }
}
