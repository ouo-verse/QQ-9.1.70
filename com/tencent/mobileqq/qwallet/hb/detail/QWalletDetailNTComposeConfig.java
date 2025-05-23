package com.tencent.mobileqq.qwallet.hb.detail;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/aq;", "", "", "toString", "", "hashCode", "other", "", "equals", "supportNTCompose", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "switchHbDetailFragment", "c", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.hb.detail.aq, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class QWalletDetailNTComposeConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final QWalletDetailNTComposeConfig f277350b = new QWalletDetailNTComposeConfig(0, 0);

    @SerializedName("support_nt_compose")
    @Nullable
    private final Integer supportNTCompose;

    @SerializedName("switch_hb_detail_fragment")
    @Nullable
    private final Integer switchHbDetailFragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/aq$a;", "", "Lcom/tencent/mobileqq/qwallet/hb/detail/aq;", "DEFAULT", "Lcom/tencent/mobileqq/qwallet/hb/detail/aq;", "a", "()Lcom/tencent/mobileqq/qwallet/hb/detail/aq;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.hb.detail.aq$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QWalletDetailNTComposeConfig a() {
            return QWalletDetailNTComposeConfig.f277350b;
        }

        Companion() {
        }
    }

    public QWalletDetailNTComposeConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Integer getSupportNTCompose() {
        return this.supportNTCompose;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getSwitchHbDetailFragment() {
        return this.switchHbDetailFragment;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QWalletDetailNTComposeConfig)) {
            return false;
        }
        QWalletDetailNTComposeConfig qWalletDetailNTComposeConfig = (QWalletDetailNTComposeConfig) other;
        if (Intrinsics.areEqual(this.supportNTCompose, qWalletDetailNTComposeConfig.supportNTCompose) && Intrinsics.areEqual(this.switchHbDetailFragment, qWalletDetailNTComposeConfig.switchHbDetailFragment)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Integer num = this.supportNTCompose;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i16 = hashCode * 31;
        Integer num2 = this.switchHbDetailFragment;
        if (num2 != null) {
            i3 = num2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "QWalletDetailNTComposeConfig(supportNTCompose=" + this.supportNTCompose + ", switchHbDetailFragment=" + this.switchHbDetailFragment + ")";
    }

    public QWalletDetailNTComposeConfig(@Nullable Integer num, @Nullable Integer num2) {
        this.supportNTCompose = num;
        this.switchHbDetailFragment = num2;
    }

    public /* synthetic */ QWalletDetailNTComposeConfig(Integer num, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2);
    }
}
