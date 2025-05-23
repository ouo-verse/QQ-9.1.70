package com.hihonor.cloudservice.support.feature.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.cloudservice.support.api.entity.auth.PermissionInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.List;
import q.q.q.w.q.c;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class AbstractSignInOptions implements c.a, Parcelable {
    public static final PermissionInfo I = new PermissionInfo().a("com.hihonor.account.getUID");
    public static final Scope J = new Scope("profile");
    public static final Scope K = new Scope("email");
    public static final Scope L = new Scope("openid");
    protected boolean C;
    protected boolean D;
    protected boolean E;
    protected boolean F;
    protected String G;
    protected String H;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<Scope> f36228d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<PermissionInfo> f36229e;

    /* renamed from: f, reason: collision with root package name */
    protected String f36230f;

    /* renamed from: h, reason: collision with root package name */
    protected String f36231h;

    /* renamed from: i, reason: collision with root package name */
    protected String f36232i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f36233m;

    public AbstractSignInOptions(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str, String str2, String str3, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, String str4, String str5) {
        this.f36228d = arrayList;
        this.f36229e = arrayList2;
        this.f36230f = str;
        this.f36231h = str2;
        this.f36232i = str3;
        this.f36233m = z16;
        this.C = z17;
        this.D = z18;
        this.E = z19;
        this.F = z26;
        this.G = str4;
        this.H = str5;
    }

    public String a() {
        return this.f36230f;
    }

    public String b() {
        return this.f36231h;
    }

    public List<PermissionInfo> c() {
        return this.f36229e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f36232i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractSignInOptions)) {
            return false;
        }
        AbstractSignInOptions abstractSignInOptions = (AbstractSignInOptions) obj;
        if (g(this.f36228d, abstractSignInOptions.f36228d) && g(this.f36229e, abstractSignInOptions.f36229e)) {
            return true;
        }
        return false;
    }

    public List<Scope> f() {
        return this.f36228d;
    }

    public <T> boolean g(ArrayList<T> arrayList, ArrayList<T> arrayList2) {
        if (arrayList == arrayList2) {
            return true;
        }
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        return arrayList.containsAll(arrayList2);
    }

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

    public boolean j() {
        return this.F;
    }

    public boolean k() {
        return this.E;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeList(this.f36228d);
        parcel.writeList(this.f36229e);
    }
}
