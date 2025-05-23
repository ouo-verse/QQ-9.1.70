package com.tencent.mobileqq.qwallet.setting;

import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedPoint;
import com.tenpay.pay.PayChannelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\tB[\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010)\u001a\u00020\u0007\u0012\b\b\u0002\u0010-\u001a\u00020*\u00a2\u0006\u0004\b.\u0010/J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001e\u0010\fR\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\u001b\u0010\"R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0017\u0010-\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b%\u0010+\u001a\u0004\b\u000e\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qwallet/setting/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "id", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "name", h.F, "subName", "getIcon", "icon", "e", "pv", "f", "i", "url", "g", "settingType", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$RedPoint;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$RedPoint;", "()Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$RedPoint;", "redPoint", "Z", "j", "()Z", "l", "(Z)V", "isOpenLock", "Lcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;", "Lcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;", "()Lcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;", "enumBgRadius", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/qwallet/protocol/Wallet/pb/QWalletHomePage$RedPoint;ZLcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.setting.g, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class SettingDataItem {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final SettingDataItem f279178l = new SettingDataItem(-1, "", "", "", "", "", -1, new QWalletHomePage$RedPoint(), false, null, 768, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String subName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String icon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String pv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int settingType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final QWalletHomePage$RedPoint redPoint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isOpenLock;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final PayChannelUtils.BgRadiusEnum enumBgRadius;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/setting/g$a;", "", "Lcom/tencent/mobileqq/qwallet/setting/g;", "EMPTY_ITEM", "Lcom/tencent/mobileqq/qwallet/setting/g;", "a", "()Lcom/tencent/mobileqq/qwallet/setting/g;", "", "EMPTY_SPACE_ITEM_ID", "I", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.setting.g$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SettingDataItem a() {
            return SettingDataItem.f279178l;
        }

        Companion() {
        }
    }

    public SettingDataItem(int i3, @NotNull String name, @NotNull String subName, @NotNull String icon, @NotNull String pv5, @NotNull String url, int i16, @NotNull QWalletHomePage$RedPoint redPoint, boolean z16, @NotNull PayChannelUtils.BgRadiusEnum enumBgRadius) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(pv5, "pv");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redPoint, "redPoint");
        Intrinsics.checkNotNullParameter(enumBgRadius, "enumBgRadius");
        this.id = i3;
        this.name = name;
        this.subName = subName;
        this.icon = icon;
        this.pv = pv5;
        this.url = url;
        this.settingType = i16;
        this.redPoint = redPoint;
        this.isOpenLock = z16;
        this.enumBgRadius = enumBgRadius;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final PayChannelUtils.BgRadiusEnum getEnumBgRadius() {
        return this.enumBgRadius;
    }

    /* renamed from: c, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPv() {
        return this.pv;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingDataItem)) {
            return false;
        }
        SettingDataItem settingDataItem = (SettingDataItem) other;
        if (this.id == settingDataItem.id && Intrinsics.areEqual(this.name, settingDataItem.name) && Intrinsics.areEqual(this.subName, settingDataItem.subName) && Intrinsics.areEqual(this.icon, settingDataItem.icon) && Intrinsics.areEqual(this.pv, settingDataItem.pv) && Intrinsics.areEqual(this.url, settingDataItem.url) && this.settingType == settingDataItem.settingType && Intrinsics.areEqual(this.redPoint, settingDataItem.redPoint) && this.isOpenLock == settingDataItem.isOpenLock && this.enumBgRadius == settingDataItem.enumBgRadius) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final QWalletHomePage$RedPoint getRedPoint() {
        return this.redPoint;
    }

    /* renamed from: g, reason: from getter */
    public final int getSettingType() {
        return this.settingType;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getSubName() {
        return this.subName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((this.id * 31) + this.name.hashCode()) * 31) + this.subName.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.pv.hashCode()) * 31) + this.url.hashCode()) * 31) + this.settingType) * 31) + this.redPoint.hashCode()) * 31;
        boolean z16 = this.isOpenLock;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.enumBgRadius.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsOpenLock() {
        return this.isOpenLock;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void l(boolean z16) {
        this.isOpenLock = z16;
    }

    @NotNull
    public String toString() {
        return "SettingDataItem(id=" + this.id + ", name=" + this.name + ", subName=" + this.subName + ", icon=" + this.icon + ", pv=" + this.pv + ", url=" + this.url + ", settingType=" + this.settingType + ", redPoint=" + this.redPoint + ", isOpenLock=" + this.isOpenLock + ", enumBgRadius=" + this.enumBgRadius + ")";
    }

    public /* synthetic */ SettingDataItem(int i3, String str, String str2, String str3, String str4, String str5, int i16, QWalletHomePage$RedPoint qWalletHomePage$RedPoint, boolean z16, PayChannelUtils.BgRadiusEnum bgRadiusEnum, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, str3, str4, str5, i16, qWalletHomePage$RedPoint, (i17 & 256) != 0 ? false : z16, (i17 & 512) != 0 ? PayChannelUtils.BgRadiusEnum.BothRound : bgRadiusEnum);
    }
}
