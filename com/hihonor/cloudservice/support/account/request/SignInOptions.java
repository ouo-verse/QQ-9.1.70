package com.hihonor.cloudservice.support.account.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.cloudservice.support.api.entity.auth.PermissionInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SignInOptions extends AbstractSignInOptions {
    public static final SignInOptions M = new e2.a().c().d().a();
    public static final Parcelable.Creator<SignInOptions> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SignInOptions> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SignInOptions createFromParcel(Parcel parcel) {
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SignInOptions[] newArray(int i3) {
            return new SignInOptions[i3];
        }
    }

    public SignInOptions(Set<Scope> set, Set<PermissionInfo> set2, String str, String str2, String str3, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, String str4, String str5) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2), str, str2, str3, z16, z17, z18, z19, z26, str4, str5);
    }

    @Override // com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        SignInOptions signInOptions = (SignInOptions) obj;
        if (g(this.f36228d, signInOptions.f36228d) && g(this.f36229e, signInOptions.f36229e)) {
            return true;
        }
        return false;
    }

    @Override // com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions
    public int hashCode() {
        int hashCode;
        ArrayList<Scope> arrayList = this.f36228d;
        int i3 = 0;
        if (arrayList == null) {
            hashCode = 0;
        } else {
            hashCode = arrayList.hashCode();
        }
        int i16 = (hashCode + 31) * 31;
        ArrayList<PermissionInfo> arrayList2 = this.f36229e;
        if (arrayList2 != null) {
            i3 = arrayList2.hashCode();
        }
        return i16 + i3;
    }

    public SignInOptions(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str, String str2, String str3, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, String str4, String str5) {
        super(arrayList, arrayList2, str, str2, str3, z16, z17, z18, z19, z26, str4, str5);
    }
}
