package com.tencent.aelight.camera.aioeditor.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LockedCategory implements Parcelable {
    public static final Parcelable.Creator<LockedCategory> CREATOR = new a();
    public boolean C = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f66691d;

    /* renamed from: e, reason: collision with root package name */
    public String f66692e;

    /* renamed from: f, reason: collision with root package name */
    public String f66693f;

    /* renamed from: h, reason: collision with root package name */
    public String f66694h;

    /* renamed from: i, reason: collision with root package name */
    private String f66695i;

    /* renamed from: m, reason: collision with root package name */
    public int f66696m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<LockedCategory> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LockedCategory createFromParcel(Parcel parcel) {
            return new LockedCategory(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LockedCategory[] newArray(int i3) {
            return new LockedCategory[i3];
        }
    }

    public LockedCategory(JSONObject jSONObject) {
        this.f66691d = true;
        this.f66692e = null;
        this.f66693f = null;
        this.f66694h = null;
        this.f66695i = null;
        this.f66692e = jSONObject.optString("comboId");
        this.f66693f = jSONObject.optString("introduceUrl");
        this.f66694h = jSONObject.optString("backgroundUrl");
        this.f66695i = jSONObject.optString("expire_date");
        this.f66696m = jSONObject.optInt("unlock_type", 1);
        this.f66691d = true;
    }

    public boolean a() {
        try {
            return new Date(NetConnInfoCenter.getServerTimeMillis()).after(new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT).parse(this.f66695i.toString()));
        } catch (ParseException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("LockedCategory", 2, e16, new Object[0]);
            }
            return true;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "LockedCategory:" + this.f66692e + "," + this.f66696m + "," + this.f66695i + "," + this.f66693f + ",";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f66692e);
        parcel.writeString(this.f66693f);
        parcel.writeString(this.f66694h);
        parcel.writeString(this.f66695i);
        parcel.writeByte(this.f66691d ? (byte) 1 : (byte) 0);
    }

    public LockedCategory(Parcel parcel) {
        this.f66691d = true;
        this.f66692e = null;
        this.f66693f = null;
        this.f66694h = null;
        this.f66695i = null;
        this.f66692e = parcel.readString();
        this.f66693f = parcel.readString();
        this.f66694h = parcel.readString();
        this.f66695i = parcel.readString();
        this.f66691d = parcel.readByte() != 0;
    }
}
