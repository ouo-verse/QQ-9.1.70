package com.tenpay.realname;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/tenpay/realname/RealNameSource;", "Landroid/os/Parcelable;", "sourceId", "", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", RealNameSource.EXTRA_KEY_SOURCE_NAME, "(Ljava/lang/String;Ljava/lang/String;)V", "getSourceId", "()Ljava/lang/String;", "getSourceName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "qwallet-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class RealNameSource implements Parcelable {

    @NotNull
    public static final String BUSINESS_PAY = "19";

    @NotNull
    public static final String CLOSE_LOCK_SCREEN = "7";

    @NotNull
    public static final String CREATE_LOCK_SCREEN = "4";

    @NotNull
    public static final String CREATE_QRCODE = "2";

    @NotNull
    public static final String CREATE_SOTER = "3";

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EXTRA_KEY_SOURCE = "realNameSource";

    @NotNull
    public static final String EXTRA_KEY_SOURCE_ID = "sourceId";

    @NotNull
    public static final String EXTRA_KEY_SOURCE_NAME = "sourceName";

    @NotNull
    public static final String FORGET_LOCK_SCREEN = "5";

    @NotNull
    public static final String GRAB_C2C_HB = "12";

    @NotNull
    public static final String GRAB_F2F_HB = "16";

    @NotNull
    public static final String GRAB_GROUP_HB = "13";

    @NotNull
    public static final String GRAB_GUILD_HB = "14";

    @NotNull
    public static final String GRAB_MCH_HB = "15";

    @NotNull
    public static final String ORTHER = "0";

    @NotNull
    public static final String QWALLET_HOME = "1";

    @NotNull
    public static final String SEND_C2C_HB = "8";

    @NotNull
    public static final String SEND_F2F_HB = "11";

    @NotNull
    public static final String SEND_GROUP_HB = "9";

    @NotNull
    public static final String SEND_GUILD_HB = "10";

    @NotNull
    public static final String SEND_PC_HB = "18";

    @NotNull
    private static final Map<String, String> SOURCE_ID_TO_NAME;

    @NotNull
    public static final String TRANSACTION = "17";

    @Nullable
    private final String sourceId;

    @Nullable
    private final String sourceName;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0007J\u001d\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020#2\u0006\u0010$\u001a\u00020%H\u0016\u00a2\u0006\u0002\u0010&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/tenpay/realname/RealNameSource$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tenpay/realname/RealNameSource;", "()V", "BUSINESS_PAY", "", "CLOSE_LOCK_SCREEN", "CREATE_LOCK_SCREEN", "CREATE_QRCODE", "CREATE_SOTER", "EXTRA_KEY_SOURCE", "EXTRA_KEY_SOURCE_ID", "EXTRA_KEY_SOURCE_NAME", "FORGET_LOCK_SCREEN", "GRAB_C2C_HB", "GRAB_F2F_HB", "GRAB_GROUP_HB", "GRAB_GUILD_HB", "GRAB_MCH_HB", "ORTHER", "QWALLET_HOME", "SEND_C2C_HB", "SEND_F2F_HB", "SEND_GROUP_HB", "SEND_GUILD_HB", "SEND_PC_HB", "SOURCE_ID_TO_NAME", "", "TRANSACTION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getSourceName", "sourceId", "newArray", "", "size", "", "(I)[Lcom/tenpay/realname/RealNameSource;", "qwallet-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tenpay.realname.RealNameSource$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion implements Parcelable.Creator<RealNameSource> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String getSourceName(@Nullable String sourceId) {
            Map map = RealNameSource.SOURCE_ID_TO_NAME;
            if (sourceId == null) {
                sourceId = "0";
            }
            String str = (String) map.get(sourceId);
            if (str == null) {
                return "\u5176\u4ed6";
            }
            return str;
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RealNameSource createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RealNameSource(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RealNameSource[] newArray(int size) {
            return new RealNameSource[size];
        }
    }

    static {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("0", "\u5176\u4ed6"), TuplesKt.to("1", "\u94b1\u5305\u9996\u9875\u5b9e\u540d"), TuplesKt.to("2", "\u5f00\u901a\u4ed8\u6b3e\u7801\u7ed1\u5361\u5b9e\u540d"), TuplesKt.to("3", "\u5f00\u901a\u6307\u7eb9/\u9762\u5bb9\u652f\u4ed8\u7ed1\u5361\u5b9e\u540d"), TuplesKt.to("4", "\u8bbe\u7f6e\u624b\u52bf\u89e3\u9501\u5b9e\u540d"), TuplesKt.to("5", "\u5fd8\u8bb0\u624b\u52bf\u89e3\u9501\u5b9e\u540d"), TuplesKt.to("7", "\u5173\u95ed\u89e3\u9501\u8bbe\u7f6e\u5b9e\u540d"), TuplesKt.to("8", "\u53d1c2c\u7ea2\u5305\u7ed1\u5361\u5b9e\u540d"), TuplesKt.to("9", "\u53d1\u7fa4\u7ea2\u5305\u7ed1\u5361\u5b9e\u540d"), TuplesKt.to("10", "\u53d1\u9891\u9053\u7ea2\u5305\u7ed1\u5361\u5b9e\u540d"), TuplesKt.to("11", "\u53d1\u9762\u5bf9\u9762\u7ea2\u5305\u7ed1\u5361\u5b9e\u540d"), TuplesKt.to("12", "\u9886c2c\u7ea2\u5305\u5b9e\u540d"), TuplesKt.to("13", "\u9886\u7fa4\u7ea2\u5305\u5b9e\u540d"), TuplesKt.to("14", "\u9886\u9891\u9053\u7ea2\u5305\u5b9e\u540d"), TuplesKt.to("15", "\u9886\u4f01\u4e1a\u7ea2\u5305\u5b9e\u540d"), TuplesKt.to("16", "\u9886\u9762\u5bf9\u9762\u7ea2\u5305\u5b9e\u540d"), TuplesKt.to("17", "\u8f6c\u8d26\u7ed1\u5361\u5b9e\u540d"), TuplesKt.to("18", "\u652f\u4ed8pc\u7ea2\u5305\u7ed1\u5361\u5b9e\u540d"), TuplesKt.to("19", "\u5546\u4e1a\u652f\u4ed8\u7ed1\u5361\u5b9e\u540d"));
        SOURCE_ID_TO_NAME = mapOf;
    }

    public RealNameSource(@Nullable String str, @Nullable String str2) {
        this.sourceId = str;
        this.sourceName = str2;
    }

    public static /* synthetic */ RealNameSource copy$default(RealNameSource realNameSource, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = realNameSource.sourceId;
        }
        if ((i3 & 2) != 0) {
            str2 = realNameSource.sourceName;
        }
        return realNameSource.copy(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String getSourceName(@Nullable String str) {
        return INSTANCE.getSourceName(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    @NotNull
    public final RealNameSource copy(@Nullable String sourceId, @Nullable String sourceName) {
        return new RealNameSource(sourceId, sourceName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RealNameSource)) {
            return false;
        }
        RealNameSource realNameSource = (RealNameSource) other;
        if (Intrinsics.areEqual(this.sourceId, realNameSource.sourceId) && Intrinsics.areEqual(this.sourceName, realNameSource.sourceName)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getSourceId() {
        return this.sourceId;
    }

    public int hashCode() {
        int hashCode;
        String str = this.sourceId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.sourceName;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "RealNameSource(sourceId=" + this.sourceId + ", sourceName=" + this.sourceName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.sourceId);
        parcel.writeString(this.sourceName);
    }

    public RealNameSource(@Nullable String str) {
        this(str, INSTANCE.getSourceName(str));
    }

    @Nullable
    public final String getSourceName() {
        return this.sourceName;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RealNameSource(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
