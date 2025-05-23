package com.tencent.mobileqq.guild.home.schedule.models;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import com.tencent.mobileqq.qqguildsdk.data.cs;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u0013\u001a\u00020\u00068\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00048VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/DayGroupItem;", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcom/tencent/mobileqq/qqguildsdk/data/cs;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/cs;", "()Lcom/tencent/mobileqq/qqguildsdk/data/cs;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "c", "I", "getType", "()I", "type", "d", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "e", "Lkotlin/Lazy;", "a", "()Z", "isToday", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/cs;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class DayGroupItem implements d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final cs item;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isToday;

    public DayGroupItem(@NotNull cs item) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        String c16 = ty1.c.c(item.a());
        Intrinsics.checkNotNullExpressionValue(c16, "parseDateMsgTime(item.dateMs)");
        this.text = c16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.home.schedule.models.DayGroupItem$isToday$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                CalendarEx calendarEx = CalendarEx.f214714a;
                return Boolean.valueOf(CalendarExKt.e(calendarEx.d(DayGroupItem.this.getItem().a()), calendarEx.e()));
            }
        });
        this.isToday = lazy;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    /* renamed from: a */
    public boolean getIsToday() {
        return ((Boolean) this.isToday.getValue()).booleanValue();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final cs getItem() {
        return this.item;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof DayGroupItem) || this.item.a() != ((DayGroupItem) other).item.a()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    @NotNull
    public String getText() {
        return this.text;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.item.a()) * 31) + getType();
    }

    @NotNull
    public String toString() {
        return "DayGroupItem(item=" + this.item + ")";
    }
}
