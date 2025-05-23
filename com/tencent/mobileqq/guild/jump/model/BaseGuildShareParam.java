package com.tencent.mobileqq.guild.jump.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes13.dex */
public class BaseGuildShareParam implements Parcelable {
    public static final Parcelable.Creator<BaseGuildShareParam> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    protected String f226414d;

    /* renamed from: e, reason: collision with root package name */
    protected String f226415e;

    /* renamed from: f, reason: collision with root package name */
    protected Bundle f226416f;

    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<BaseGuildShareParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseGuildShareParam createFromParcel(Parcel parcel) {
            return new BaseGuildShareParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BaseGuildShareParam[] newArray(int i3) {
            return new BaseGuildShareParam[i3];
        }
    }

    public BaseGuildShareParam(String str, String str2) {
        this.f226416f = new Bundle();
        this.f226414d = str;
        this.f226415e = str2;
    }

    public Bundle a() {
        return this.f226416f;
    }

    public void b(Bundle bundle) {
        this.f226416f = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "BaseGuildShareParam{mainSource='" + this.f226414d + "', subSource='" + this.f226415e + "', bundle=" + this.f226416f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f226414d);
        parcel.writeString(this.f226415e);
        parcel.writeBundle(this.f226416f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseGuildShareParam(Parcel parcel) {
        this.f226416f = new Bundle();
        this.f226414d = parcel.readString();
        this.f226415e = parcel.readString();
        try {
            this.f226416f = parcel.readBundle(GuildAppReportSourceInfo.class.getClassLoader());
        } catch (Exception e16) {
            this.f226416f = new Bundle();
            QLog.e("BaseGuildShareParam", 1, "BaseGuildShareParam readBundle error", e16);
        }
    }
}
