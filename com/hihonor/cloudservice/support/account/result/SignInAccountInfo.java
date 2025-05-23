package com.hihonor.cloudservice.support.account.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SignInAccountInfo extends AbstractSignInAccountInfo {
    public static final Parcelable.Creator<SignInAccountInfo> CREATOR = new a();
    public int G;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SignInAccountInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SignInAccountInfo createFromParcel(Parcel parcel) {
            return new SignInAccountInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SignInAccountInfo[] newArray(int i3) {
            return new SignInAccountInfo[i3];
        }
    }

    public SignInAccountInfo(String str, String str2, Set<Scope> set, String str3, String str4, String str5) {
        super(str, str2, set, str3, str4, str5);
    }

    public static SignInAccountInfo f(String str, String str2, Set<Scope> set, String str3, String str4, String str5) {
        return new SignInAccountInfo(str, str2, set, str3, str4, str5);
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public void e(Parcel parcel) {
        super.e(parcel);
        this.G = parcel.readInt();
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInAccountInfo)) {
            return false;
        }
        return b().equals(((SignInAccountInfo) obj).b());
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public int hashCode() {
        return c().hashCode();
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public String toString() {
        return "{photoUriString: " + this.f36235e + ',' + CommonConstant.KEY_ACCOUNT_FLAG + this.G + '}';
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.G);
    }

    public SignInAccountInfo(Parcel parcel) {
        e(parcel);
    }

    public SignInAccountInfo() {
        this.f36236f = new HashSet();
        this.G = 0;
    }
}
