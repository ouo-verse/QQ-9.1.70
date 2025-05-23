package com.tencent.luggage.wxa.uj;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.mini.api.MiniConst;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final String f142499a;

    /* renamed from: b, reason: collision with root package name */
    public final String f142500b;

    /* renamed from: c, reason: collision with root package name */
    public final String f142501c;

    /* renamed from: d, reason: collision with root package name */
    public final String f142502d;

    /* renamed from: e, reason: collision with root package name */
    public final String f142503e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f142504f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f142505g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f142506h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f142507i;

    /* renamed from: j, reason: collision with root package name */
    public String f142508j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f142498k = new a(null);

    @NotNull
    public static final Parcelable.Creator<k> CREATOR = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final k a(String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            try {
                JSONObject jSONObject = new JSONObject(jsonStr);
                String mobile = jSONObject.optString(DeviceType.DeviceCategory.MOBILE);
                String showMobile = jSONObject.optString("show_mobile");
                boolean optBoolean = jSONObject.optBoolean("need_auth", true);
                boolean optBoolean2 = jSONObject.optBoolean("allow_send_sms", true);
                String encryptedData = jSONObject.optString(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA);
                String iv5 = jSONObject.optString("iv");
                boolean optBoolean3 = jSONObject.optBoolean("is_wechat", false);
                boolean optBoolean4 = jSONObject.optBoolean("is_check", false);
                String cloud_id = jSONObject.optString("cloud_id", "");
                String data = jSONObject.optString("data", "");
                Intrinsics.checkNotNullExpressionValue(mobile, "mobile");
                Intrinsics.checkNotNullExpressionValue(showMobile, "showMobile");
                Intrinsics.checkNotNullExpressionValue(encryptedData, "encryptedData");
                Intrinsics.checkNotNullExpressionValue(iv5, "iv");
                Intrinsics.checkNotNullExpressionValue(cloud_id, "cloud_id");
                Intrinsics.checkNotNullExpressionValue(data, "data");
                return new k(mobile, showMobile, encryptedData, iv5, cloud_id, optBoolean, optBoolean2, optBoolean3, optBoolean4, data);
            } catch (JSONException unused) {
                w.b("MicroMsg.PhoneItem", "jsonStr:%s", jsonStr);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new k(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k[] newArray(int i3) {
            return new k[i3];
        }
    }

    public k(String mobile, String showMobile, String encryptedData, String iv5, String cloud_id, boolean z16, boolean z17, boolean z18, boolean z19, String data) {
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(showMobile, "showMobile");
        Intrinsics.checkNotNullParameter(encryptedData, "encryptedData");
        Intrinsics.checkNotNullParameter(iv5, "iv");
        Intrinsics.checkNotNullParameter(cloud_id, "cloud_id");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f142499a = mobile;
        this.f142500b = showMobile;
        this.f142501c = encryptedData;
        this.f142502d = iv5;
        this.f142503e = cloud_id;
        this.f142504f = z16;
        this.f142505g = z17;
        this.f142506h = z18;
        this.f142507i = z19;
        this.f142508j = data;
    }

    public final boolean a() {
        return this.f142505g;
    }

    public final String b() {
        return this.f142503e;
    }

    public final String c() {
        return this.f142508j;
    }

    public final String d() {
        return this.f142501c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f142502d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (Intrinsics.areEqual(kVar.f142499a, this.f142499a) && kVar.f142506h == this.f142506h) {
                return true;
            }
            return false;
        }
        return super.equals(obj);
    }

    public final String f() {
        return this.f142499a;
    }

    public final boolean g() {
        return this.f142504f;
    }

    public final String h() {
        return this.f142500b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.f142499a.hashCode() * 31) + this.f142500b.hashCode()) * 31) + this.f142501c.hashCode()) * 31) + this.f142502d.hashCode()) * 31) + this.f142503e.hashCode()) * 31;
        boolean z16 = this.f142504f;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.f142505g;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.f142506h;
        int i26 = z18;
        if (z18 != 0) {
            i26 = 1;
        }
        int i27 = (i19 + i26) * 31;
        boolean z19 = this.f142507i;
        if (!z19) {
            i3 = z19 ? 1 : 0;
        }
        return ((i27 + i3) * 31) + this.f142508j.hashCode();
    }

    public final boolean i() {
        return this.f142507i;
    }

    public final boolean j() {
        return this.f142506h;
    }

    public final String k() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(DeviceType.DeviceCategory.MOBILE, this.f142499a);
        jSONObject.put("show_mobile", this.f142500b);
        jSONObject.put("need_auth", this.f142504f);
        jSONObject.put("allow_send_sms", this.f142505g);
        jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, this.f142501c);
        jSONObject.put("iv", this.f142502d);
        jSONObject.put("cloud_id", this.f142503e);
        jSONObject.put("is_wechat", this.f142506h);
        jSONObject.put("is_check", this.f142507i);
        jSONObject.put("data", this.f142508j);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public String toString() {
        return "PhoneItem(mobile=" + this.f142499a + ", showMobile=" + this.f142500b + ", encryptedData=" + this.f142501c + ", iv=" + this.f142502d + ", cloud_id=" + this.f142503e + ", needAuth=" + this.f142504f + ", allowSendSms=" + this.f142505g + ", isWechat=" + this.f142506h + ", isCheck=" + this.f142507i + ", data=" + this.f142508j + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f142499a);
        out.writeString(this.f142500b);
        out.writeString(this.f142501c);
        out.writeString(this.f142502d);
        out.writeString(this.f142503e);
        out.writeInt(this.f142504f ? 1 : 0);
        out.writeInt(this.f142505g ? 1 : 0);
        out.writeInt(this.f142506h ? 1 : 0);
        out.writeInt(this.f142507i ? 1 : 0);
        out.writeString(this.f142508j);
    }

    public final void a(boolean z16) {
        this.f142507i = z16;
    }

    public final void b(boolean z16) {
        this.f142506h = z16;
    }
}
