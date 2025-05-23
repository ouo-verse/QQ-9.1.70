package ek4;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001\nBu\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010$\u001a\u00020 \u0012\b\b\u0002\u0010&\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020\t\u0012\b\b\u0002\u0010)\u001a\u00020\t\u0012\b\b\u0002\u0010,\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u001f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010!\u001a\u0004\b\u0013\u0010\"R\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b\u000f\u0010\"R\u0017\u0010&\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u0017\u0010(\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b%\u0010\rR\u0017\u0010)\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0017\u0010,\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\b'\u0010+\u00a8\u00060"}, d2 = {"Lek4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "k", "()J", "uid", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "enterRoomTips", "c", "f", "payLevel", "d", h.F, "payLevelIcon", "e", "g", "payLevelBgImg", "Z", "l", "()Z", "isSelf", "", UserInfo.SEX_FEMALE, "()F", "iconWidth", "iconHeight", "i", "outDuration", "j", "stayDuration", "inDuration", "I", "()I", "txtColor", "<init>", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;ZFFJJJI)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ek4.a, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class PayLevelEnterRoomInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long uid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String enterRoomTips;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long payLevel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String payLevelIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String payLevelBgImg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSelf;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final float iconWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final float iconHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final long outDuration;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final long stayDuration;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final long inDuration;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final int txtColor;

    public PayLevelEnterRoomInfo(long j3, @NotNull String enterRoomTips, long j16, @NotNull String payLevelIcon, @NotNull String payLevelBgImg, boolean z16, float f16, float f17, long j17, long j18, long j19, int i3) {
        Intrinsics.checkNotNullParameter(enterRoomTips, "enterRoomTips");
        Intrinsics.checkNotNullParameter(payLevelIcon, "payLevelIcon");
        Intrinsics.checkNotNullParameter(payLevelBgImg, "payLevelBgImg");
        this.uid = j3;
        this.enterRoomTips = enterRoomTips;
        this.payLevel = j16;
        this.payLevelIcon = payLevelIcon;
        this.payLevelBgImg = payLevelBgImg;
        this.isSelf = z16;
        this.iconWidth = f16;
        this.iconHeight = f17;
        this.outDuration = j17;
        this.stayDuration = j18;
        this.inDuration = j19;
        this.txtColor = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getEnterRoomTips() {
        return this.enterRoomTips;
    }

    /* renamed from: b, reason: from getter */
    public final float getIconHeight() {
        return this.iconHeight;
    }

    /* renamed from: c, reason: from getter */
    public final float getIconWidth() {
        return this.iconWidth;
    }

    /* renamed from: d, reason: from getter */
    public final long getInDuration() {
        return this.inDuration;
    }

    /* renamed from: e, reason: from getter */
    public final long getOutDuration() {
        return this.outDuration;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayLevelEnterRoomInfo)) {
            return false;
        }
        PayLevelEnterRoomInfo payLevelEnterRoomInfo = (PayLevelEnterRoomInfo) other;
        if (this.uid == payLevelEnterRoomInfo.uid && Intrinsics.areEqual(this.enterRoomTips, payLevelEnterRoomInfo.enterRoomTips) && this.payLevel == payLevelEnterRoomInfo.payLevel && Intrinsics.areEqual(this.payLevelIcon, payLevelEnterRoomInfo.payLevelIcon) && Intrinsics.areEqual(this.payLevelBgImg, payLevelEnterRoomInfo.payLevelBgImg) && this.isSelf == payLevelEnterRoomInfo.isSelf && Float.compare(this.iconWidth, payLevelEnterRoomInfo.iconWidth) == 0 && Float.compare(this.iconHeight, payLevelEnterRoomInfo.iconHeight) == 0 && this.outDuration == payLevelEnterRoomInfo.outDuration && this.stayDuration == payLevelEnterRoomInfo.stayDuration && this.inDuration == payLevelEnterRoomInfo.inDuration && this.txtColor == payLevelEnterRoomInfo.txtColor) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getPayLevel() {
        return this.payLevel;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getPayLevelBgImg() {
        return this.payLevelBgImg;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getPayLevelIcon() {
        return this.payLevelIcon;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((((((androidx.fragment.app.a.a(this.uid) * 31) + this.enterRoomTips.hashCode()) * 31) + androidx.fragment.app.a.a(this.payLevel)) * 31) + this.payLevelIcon.hashCode()) * 31) + this.payLevelBgImg.hashCode()) * 31;
        boolean z16 = this.isSelf;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((((((((a16 + i3) * 31) + Float.floatToIntBits(this.iconWidth)) * 31) + Float.floatToIntBits(this.iconHeight)) * 31) + androidx.fragment.app.a.a(this.outDuration)) * 31) + androidx.fragment.app.a.a(this.stayDuration)) * 31) + androidx.fragment.app.a.a(this.inDuration)) * 31) + this.txtColor;
    }

    /* renamed from: i, reason: from getter */
    public final long getStayDuration() {
        return this.stayDuration;
    }

    /* renamed from: j, reason: from getter */
    public final int getTxtColor() {
        return this.txtColor;
    }

    /* renamed from: k, reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsSelf() {
        return this.isSelf;
    }

    @NotNull
    public String toString() {
        return "PayLevelEnterRoomInfo(uid=" + this.uid + ", enterRoomTips=" + this.enterRoomTips + ", payLevel=" + this.payLevel + ", payLevelIcon=" + this.payLevelIcon + ", payLevelBgImg=" + this.payLevelBgImg + ", isSelf=" + this.isSelf + ", iconWidth=" + this.iconWidth + ", iconHeight=" + this.iconHeight + ", outDuration=" + this.outDuration + ", stayDuration=" + this.stayDuration + ", inDuration=" + this.inDuration + ", txtColor=" + this.txtColor + ")";
    }

    public /* synthetic */ PayLevelEnterRoomInfo(long j3, String str, long j16, String str2, String str3, boolean z16, float f16, float f17, long j17, long j18, long j19, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, j16, str2, str3, (i16 & 32) != 0 ? false : z16, (i16 & 64) != 0 ? 32.0f : f16, (i16 & 128) != 0 ? 16.0f : f17, (i16 & 256) != 0 ? 100L : j17, (i16 & 512) != 0 ? 2000L : j18, (i16 & 1024) != 0 ? 200L : j19, (i16 & 2048) != 0 ? -1 : i3);
    }
}
