package com.tenpay.sdk.net.core.comm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010\u0019\u001a\u00020\u0015J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006!"}, d2 = {"Lcom/tenpay/sdk/net/core/comm/SpecialKeyInfo;", "Landroid/os/Parcelable;", "skeyType", "", "skey", "", "effectTime", "", "(ILjava/lang/String;J)V", "getEffectTime", "()J", "getSkey", "()Ljava/lang/String;", "getSkeyType", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", AppConstants.Key.COLUMN_IS_VALID, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class SpecialKeyInfo implements Parcelable {
    private static final int EFFECT_TIME_DURATION = 60000;

    @NotNull
    private static final String SPECIAL_KEY = "skey";

    @NotNull
    private static final String SPECIAL_KEY_TYPE = "skey_type";

    @NotNull
    private static final String TAG = "SpecialKeyInfo";
    private final long effectTime;

    @NotNull
    private final String skey;
    private final int skeyType;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<SpecialKeyInfo> CREATOR = new Creator();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/sdk/net/core/comm/SpecialKeyInfo$Companion;", "", "()V", "EFFECT_TIME_DURATION", "", "SPECIAL_KEY", "", "SPECIAL_KEY_TYPE", "TAG", "getCache", "Lcom/tenpay/sdk/net/core/comm/SpecialKeyInfo;", "saveInfoIfNeed", "", "bundle", "Landroid/os/Bundle;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final SpecialKeyInfo getCache() {
            return (SpecialKeyInfo) g.h("qwallet_special_key_info", SpecialKeyInfo.class, null);
        }

        @JvmStatic
        public final void saveInfoIfNeed(@Nullable Bundle bundle) {
            int i3;
            String string;
            boolean z16;
            String string2;
            if (bundle == null) {
                return;
            }
            try {
                string2 = bundle.getString(SpecialKeyInfo.SPECIAL_KEY_TYPE);
            } catch (NumberFormatException unused) {
            }
            if (string2 != null) {
                i3 = Integer.parseInt(string2);
                string = bundle.getString("skey");
                if (string == null && string.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16 && i3 != 0 && i3 != 2 && i3 != -1) {
                    try {
                        SpecialKeyInfo specialKeyInfo = new SpecialKeyInfo(i3, string, System.currentTimeMillis() + 60000);
                        g.p("qwallet_special_key_info", specialKeyInfo);
                        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, SpecialKeyInfo.TAG, "saveInfoIfNeed finish: " + specialKeyInfo, null, 4, null);
                        return;
                    } catch (Exception e16) {
                        QLog.w(SpecialKeyInfo.TAG, 1, "saveInfoIfNeed error:", e16);
                        return;
                    }
                }
                g.s("qwallet_special_key_info");
            }
            i3 = -1;
            string = bundle.getString("skey");
            if (string == null) {
            }
            z16 = true;
            if (z16) {
            }
            g.s("qwallet_special_key_info");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Creator implements Parcelable.Creator<SpecialKeyInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpecialKeyInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SpecialKeyInfo(parcel.readInt(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpecialKeyInfo[] newArray(int i3) {
            return new SpecialKeyInfo[i3];
        }
    }

    public SpecialKeyInfo(int i3, @NotNull String skey, long j3) {
        Intrinsics.checkNotNullParameter(skey, "skey");
        this.skeyType = i3;
        this.skey = skey;
        this.effectTime = j3;
    }

    public static /* synthetic */ SpecialKeyInfo copy$default(SpecialKeyInfo specialKeyInfo, int i3, String str, long j3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = specialKeyInfo.skeyType;
        }
        if ((i16 & 2) != 0) {
            str = specialKeyInfo.skey;
        }
        if ((i16 & 4) != 0) {
            j3 = specialKeyInfo.effectTime;
        }
        return specialKeyInfo.copy(i3, str, j3);
    }

    @JvmStatic
    public static final void saveInfoIfNeed(@Nullable Bundle bundle) {
        INSTANCE.saveInfoIfNeed(bundle);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSkeyType() {
        return this.skeyType;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSkey() {
        return this.skey;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEffectTime() {
        return this.effectTime;
    }

    @NotNull
    public final SpecialKeyInfo copy(int skeyType, @NotNull String skey, long effectTime) {
        Intrinsics.checkNotNullParameter(skey, "skey");
        return new SpecialKeyInfo(skeyType, skey, effectTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpecialKeyInfo)) {
            return false;
        }
        SpecialKeyInfo specialKeyInfo = (SpecialKeyInfo) other;
        if (this.skeyType == specialKeyInfo.skeyType && Intrinsics.areEqual(this.skey, specialKeyInfo.skey) && this.effectTime == specialKeyInfo.effectTime) {
            return true;
        }
        return false;
    }

    public final long getEffectTime() {
        return this.effectTime;
    }

    @NotNull
    public final String getSkey() {
        return this.skey;
    }

    public final int getSkeyType() {
        return this.skeyType;
    }

    public int hashCode() {
        return (((this.skeyType * 31) + this.skey.hashCode()) * 31) + a.a(this.effectTime);
    }

    public final boolean isValid() {
        if (System.currentTimeMillis() <= this.effectTime) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "SpecialKeyInfo(skeyType=" + this.skeyType + ", skey=" + this.skey + ", effectTime=" + this.effectTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.skeyType);
        parcel.writeString(this.skey);
        parcel.writeLong(this.effectTime);
    }
}
