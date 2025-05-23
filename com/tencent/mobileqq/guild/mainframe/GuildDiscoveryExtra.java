package com.tencent.mobileqq.guild.mainframe;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002&'B/\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u00a2\u0006\u0004\b \u0010!B\u0011\b\u0016\u0012\u0006\u0010\"\u001a\u00020\u0000\u00a2\u0006\u0004\b \u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b \u0010$J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0010\u001a\u00020\u0005R\u0017\u0010\u0011\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildDiscoveryExtra;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "other", "", "equals", "", "toString", "getBusinessSource", "entryDiscoveryType", "I", "getEntryDiscoveryType", "()I", "entryDiscoveryState", "getEntryDiscoveryState", "entryGuildTabState", "getEntryGuildTabState", "entryGuildTabStateReportValue", "Ljava/lang/String;", "getEntryGuildTabStateReportValue", "()Ljava/lang/String;", "", "serialVersionUID", "J", "<init>", "(IIILjava/lang/String;)V", "extra", "(Lcom/tencent/mobileqq/guild/mainframe/GuildDiscoveryExtra;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "b", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildDiscoveryExtra implements Parcelable, Serializable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String REPORT_ELEMENT_PARAM_ENTRY_DISCOVER_STATE = "sgrp_entry_discover_state";

    @NotNull
    public static final String REPORT_ELEMENT_PARAM_ENTRY_DISCOVER_TYPE = "sgrp_entry_discover_type";
    private final int entryDiscoveryState;
    private final int entryDiscoveryType;
    private final int entryGuildTabState;

    @NotNull
    private final String entryGuildTabStateReportValue;
    private final long serialVersionUID;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildDiscoveryExtra$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/mainframe/GuildDiscoveryExtra;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/mainframe/GuildDiscoveryExtra;", "", "REPORT_ELEMENT_PARAM_ENTRY_DISCOVER_STATE", "Ljava/lang/String;", "REPORT_ELEMENT_PARAM_ENTRY_DISCOVER_TYPE", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.GuildDiscoveryExtra$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion implements Parcelable.Creator<GuildDiscoveryExtra> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildDiscoveryExtra createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuildDiscoveryExtra(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildDiscoveryExtra[] newArray(int size) {
            return new GuildDiscoveryExtra[size];
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildDiscoveryExtra$b;", "", "", "type", "", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f227250a = new b();

        b() {
        }

        @NotNull
        public final String a(int type) {
            if (type == 0) {
                return "UNKNOWN";
            }
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            if (type != 5) {
                                return "UNKNOWN";
                            }
                            return "NEW_USER_DISCOVER";
                        }
                        return "FLOAT_DIALOG";
                    }
                    return "PUSH";
                }
                return "ICON_CLICK";
            }
            return "TAB";
        }
    }

    public GuildDiscoveryExtra() {
        this(0, 0, 0, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildDiscoveryExtra)) {
            return false;
        }
        GuildDiscoveryExtra guildDiscoveryExtra = (GuildDiscoveryExtra) other;
        if (this.entryDiscoveryType == guildDiscoveryExtra.entryDiscoveryType && this.entryDiscoveryState == guildDiscoveryExtra.entryDiscoveryState && this.entryGuildTabState == guildDiscoveryExtra.entryGuildTabState && Intrinsics.areEqual(this.entryGuildTabStateReportValue, guildDiscoveryExtra.entryGuildTabStateReportValue)) {
            return true;
        }
        return false;
    }

    public final int getBusinessSource() {
        int i3 = this.entryDiscoveryType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return 0;
                        }
                        return 10;
                    }
                    return 8;
                }
                return 7;
            }
            if (this.entryDiscoveryState != 4) {
                return 5;
            }
            return 6;
        }
        int i16 = this.entryGuildTabState;
        if (i16 == 1) {
            return 2;
        }
        if (i16 == 3) {
            return 4;
        }
        if (i16 != 2) {
            return 0;
        }
        return 3;
    }

    public final int getEntryDiscoveryState() {
        return this.entryDiscoveryState;
    }

    public final int getEntryDiscoveryType() {
        return this.entryDiscoveryType;
    }

    public final int getEntryGuildTabState() {
        return this.entryGuildTabState;
    }

    @NotNull
    public final String getEntryGuildTabStateReportValue() {
        return this.entryGuildTabStateReportValue;
    }

    @NotNull
    public String toString() {
        return "GuildDiscoveryExtra\u3010entryDiscoveryType=" + b.f227250a.a(this.entryDiscoveryType) + ", entryDiscoveryState=" + this.entryDiscoveryState + ", entryGuildTabState=" + this.entryGuildTabState + " entryGuildTabStateReportValue=" + this.entryGuildTabStateReportValue + '\u3011';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.entryDiscoveryType);
        parcel.writeInt(this.entryDiscoveryState);
        parcel.writeInt(this.entryGuildTabState);
        parcel.writeString(this.entryGuildTabStateReportValue);
    }

    public GuildDiscoveryExtra(int i3, int i16, int i17, @NotNull String entryGuildTabStateReportValue) {
        Intrinsics.checkNotNullParameter(entryGuildTabStateReportValue, "entryGuildTabStateReportValue");
        this.entryDiscoveryType = i3;
        this.entryDiscoveryState = i16;
        this.entryGuildTabState = i17;
        this.entryGuildTabStateReportValue = entryGuildTabStateReportValue;
        this.serialVersionUID = 362498820763181019L;
    }

    public /* synthetic */ GuildDiscoveryExtra(int i3, int i16, int i17, String str, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 1 : i3, (i18 & 2) != 0 ? 0 : i16, (i18 & 4) != 0 ? 0 : i17, (i18 & 8) != 0 ? "" : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildDiscoveryExtra(@NotNull GuildDiscoveryExtra extra) {
        this(extra.entryDiscoveryType, extra.entryDiscoveryState, extra.entryGuildTabState, extra.entryGuildTabStateReportValue);
        Intrinsics.checkNotNullParameter(extra, "extra");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildDiscoveryExtra(@NotNull Parcel parcel) {
        this(r0, r1, r2, r4 == null ? "" : r4);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        String readString = parcel.readString();
    }
}
