package com.tencent.qqnt.qwallet.aio.pay;

import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0013\u0010\fR\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\t\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "b", tl.h.F, "subtitle", "d", "type", "Z", "e", "()Z", "f", "(Z)V", "isShowMask", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "g", "(Ljava/lang/Integer;)V", "stateIconResId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqnt.qwallet.aio.pay.g, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class PaymentData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String subtitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isShowMask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @DrawableRes
    @Nullable
    private Integer stateIconResId;

    public PaymentData(@NotNull String title, @NotNull String subtitle, @NotNull String type, boolean z16) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(type, "type");
        this.title = title;
        this.subtitle = subtitle;
        this.type = type;
        this.isShowMask = z16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getStateIconResId() {
        return this.stateIconResId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsShowMask() {
        return this.isShowMask;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentData)) {
            return false;
        }
        PaymentData paymentData = (PaymentData) other;
        if (Intrinsics.areEqual(this.title, paymentData.title) && Intrinsics.areEqual(this.subtitle, paymentData.subtitle) && Intrinsics.areEqual(this.type, paymentData.type) && this.isShowMask == paymentData.isShowMask) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.isShowMask = z16;
    }

    public final void g(@Nullable Integer num) {
        this.stateIconResId = num;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subtitle = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.type.hashCode()) * 31;
        boolean z16 = this.isShowMask;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "PaymentData(title=" + this.title + ", subtitle=" + this.subtitle + ", type=" + this.type + ", isShowMask=" + this.isShowMask + ")";
    }
}
