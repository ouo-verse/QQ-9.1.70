package com.tencent.mobileqq.vasgift.api.impl.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IQQLiveBeaconReportApi;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQGiftSendGiftReportHelper {
    public static void a(boolean z16, SendGiftReportData sendGiftReportData) {
        String str;
        if (z16) {
            str = "send_gift_combo_over";
        } else {
            str = "send_gift";
        }
        ((IQQLiveBeaconReportApi) QRoute.api(IQQLiveBeaconReportApi.class)).newReportTask().a(str).addKeyValue("giftId", sendGiftReportData.f311447d).addKeyValue("giftName", sendGiftReportData.f311448e).addKeyValue("comboCountSeq", sendGiftReportData.f311449f).addKeyValue("allComboCount", sendGiftReportData.f311450h).addKeyValue("comboCount", sendGiftReportData.f311451i).addKeyValue("errorCode", sendGiftReportData.f311452m).addKeyValue("errorMsg", sendGiftReportData.C).addKeyValue("costTime", sendGiftReportData.D).addKeyValue("receiverId", sendGiftReportData.E).addKeyValue("senderId", sendGiftReportData.F).send();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class SendGiftReportData implements Parcelable {
        public static final Parcelable.Creator<SendGiftReportData> CREATOR = new a();
        public String C;
        public long D;
        public long E;
        public long F;

        /* renamed from: d, reason: collision with root package name */
        public int f311447d;

        /* renamed from: e, reason: collision with root package name */
        public String f311448e;

        /* renamed from: f, reason: collision with root package name */
        public long f311449f;

        /* renamed from: h, reason: collision with root package name */
        public int f311450h;

        /* renamed from: i, reason: collision with root package name */
        public int f311451i;

        /* renamed from: m, reason: collision with root package name */
        public long f311452m;

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a implements Parcelable.Creator<SendGiftReportData> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SendGiftReportData createFromParcel(Parcel parcel) {
                return new SendGiftReportData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SendGiftReportData[] newArray(int i3) {
                return new SendGiftReportData[i3];
            }
        }

        public SendGiftReportData(String str) {
            this.f311447d = 0;
            this.f311448e = "";
            this.f311449f = 0L;
            this.f311450h = 0;
            this.f311451i = 0;
            this.f311452m = -1L;
            this.D = 0L;
            this.E = 0L;
            this.F = 0L;
            this.C = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SendGiftReportData{giftId='" + this.f311447d + "', giftName='" + this.f311448e + "', comboCountSeq=" + this.f311449f + ", allComboCount=" + this.f311450h + ", comboCount=" + this.f311451i + ", errorCode=" + this.f311452m + ", errorMsg='" + this.C + "', costTime=" + this.D + ", receiverId=" + this.E + ", senderId=" + this.F + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f311447d);
            parcel.writeString(this.f311448e);
            parcel.writeLong(this.f311449f);
            parcel.writeInt(this.f311450h);
            parcel.writeInt(this.f311451i);
            parcel.writeLong(this.f311452m);
            parcel.writeString(this.C);
            parcel.writeLong(this.D);
            parcel.writeLong(this.E);
            parcel.writeLong(this.F);
        }

        public SendGiftReportData(int i3, String str, long j3, int i16, int i17, long j16, long j17, long j18) {
            this.f311452m = -1L;
            this.C = "";
            this.f311447d = i3;
            this.f311448e = str;
            this.f311449f = j3;
            this.f311450h = i16;
            this.f311451i = i17;
            this.D = j16;
            this.E = j17;
            this.F = j18;
        }

        protected SendGiftReportData(Parcel parcel) {
            this.f311447d = 0;
            this.f311448e = "";
            this.f311449f = 0L;
            this.f311450h = 0;
            this.f311451i = 0;
            this.f311452m = -1L;
            this.C = "";
            this.D = 0L;
            this.E = 0L;
            this.F = 0L;
            this.f311447d = parcel.readInt();
            this.f311448e = parcel.readString();
            this.f311449f = parcel.readLong();
            this.f311450h = parcel.readInt();
            this.f311451i = parcel.readInt();
            this.f311452m = parcel.readLong();
            this.C = parcel.readString();
            this.D = parcel.readLong();
            this.E = parcel.readLong();
            this.F = parcel.readLong();
        }
    }
}
