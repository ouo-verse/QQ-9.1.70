package com.tencent.ecommerce.repo.register;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\u001c\u0010 R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017\u00a8\u0006("}, d2 = {"Lcom/tencent/ecommerce/repo/register/ECaptcha;", "Landroid/os/Parcelable;", "Lorg/json/JSONObject;", "c", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "randStr", "e", "k", "ticket", "f", "I", "a", "()I", "(I)V", "errorCode", h.F, "getErrorMessage", "g", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class ECaptcha implements Parcelable {
    public static final Parcelable.Creator<ECaptcha> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String randStr;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String ticket;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int errorCode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String errorMessage;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static class a implements Parcelable.Creator<ECaptcha> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ECaptcha createFromParcel(Parcel parcel) {
            return new ECaptcha(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ECaptcha[] newArray(int i3) {
            return new ECaptcha[i3];
        }
    }

    public ECaptcha() {
        this(null, null, 0, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: b, reason: from getter */
    public final String getRandStr() {
        return this.randStr;
    }

    public final JSONObject c() {
        return new JSONObject().put("user_ip", "").put("ticket", this.ticket).put("rand_str", this.randStr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getTicket() {
        return this.ticket;
    }

    public final void f(int i3) {
        this.errorCode = i3;
    }

    public final void g(String str) {
        this.errorMessage = str;
    }

    public int hashCode() {
        String str = this.randStr;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ticket;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.errorCode) * 31;
        String str3 = this.errorMessage;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void j(String str) {
        this.randStr = str;
    }

    public final void k(String str) {
        this.ticket = str;
    }

    public String toString() {
        return " randStr = " + this.randStr + ", ticket = " + this.ticket + ", errorCode = " + this.errorCode + ", errorMessage = " + this.errorMessage;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(this.randStr);
        parcel.writeString(this.ticket);
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMessage);
    }

    public ECaptcha(String str, String str2, int i3, String str3) {
        this.randStr = str;
        this.ticket = str2;
        this.errorCode = i3;
        this.errorMessage = str3;
    }

    public /* synthetic */ ECaptcha(String str, String str2, int i3, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECaptcha)) {
            return false;
        }
        ECaptcha eCaptcha = (ECaptcha) other;
        return Intrinsics.areEqual(this.randStr, eCaptcha.randStr) && Intrinsics.areEqual(this.ticket, eCaptcha.ticket) && this.errorCode == eCaptcha.errorCode && Intrinsics.areEqual(this.errorMessage, eCaptcha.errorMessage);
    }
}
