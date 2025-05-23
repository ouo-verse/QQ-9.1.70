package com.tencent.mobileqq.qqexpand.bean.feed;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class MiniAppRecommInfo extends b implements Serializable, Parcelable {
    public static final Parcelable.Creator<MiniAppRecommInfo> CREATOR = new a();
    public List<MiniApp> appInfoList;
    public long cacheValidTime;
    public String headDesc;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class MiniApp implements Parcelable {
        public static final Parcelable.Creator<MiniApp> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public String f263468d;

        /* renamed from: e, reason: collision with root package name */
        public String f263469e;

        /* renamed from: f, reason: collision with root package name */
        public String f263470f;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f263471h;

        /* renamed from: i, reason: collision with root package name */
        public INTERFACE$StApiAppInfo f263472i;

        /* renamed from: m, reason: collision with root package name */
        public int f263473m;

        /* compiled from: P */
        /* loaded from: classes16.dex */
        class a implements Parcelable.Creator<MiniApp> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MiniApp createFromParcel(Parcel parcel) {
                return new MiniApp(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public MiniApp[] newArray(int i3) {
                return new MiniApp[i3];
            }
        }

        public MiniApp() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int i16;
            parcel.writeString(this.f263468d);
            parcel.writeString(this.f263469e);
            parcel.writeString(this.f263470f);
            byte[] bArr = this.f263471h;
            if (bArr != null) {
                i16 = bArr.length;
            } else {
                i16 = -1;
            }
            parcel.writeInt(i16);
            parcel.writeByteArray(this.f263471h);
        }

        protected MiniApp(Parcel parcel) {
            this.f263468d = parcel.readString();
            this.f263469e = parcel.readString();
            this.f263470f = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                try {
                    byte[] bArr = new byte[readInt];
                    this.f263471h = bArr;
                    parcel.readByteArray(bArr);
                    INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
                    iNTERFACE$StApiAppInfo.mergeFrom(this.f263471h);
                    this.f263472i = iNTERFACE$StApiAppInfo;
                } catch (Throwable th5) {
                    QLog.e("MiniAppRecommInfo", 1, "", th5);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<MiniAppRecommInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MiniAppRecommInfo createFromParcel(Parcel parcel) {
            return new MiniAppRecommInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MiniAppRecommInfo[] newArray(int i3) {
            return new MiniAppRecommInfo[i3];
        }
    }

    public MiniAppRecommInfo() {
        this.headDesc = HardCodeUtil.qqStr(R.string.o85);
        this.appInfoList = new ArrayList();
        this.cacheValidTime = (System.currentTimeMillis() / 1000) + 3600;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.headDesc);
        parcel.writeTypedList(this.appInfoList);
        parcel.writeLong(this.cacheValidTime);
    }

    protected MiniAppRecommInfo(Parcel parcel) {
        this.headDesc = HardCodeUtil.qqStr(R.string.o85);
        this.appInfoList = new ArrayList();
        this.cacheValidTime = (System.currentTimeMillis() / 1000) + 3600;
        this.headDesc = parcel.readString();
        this.appInfoList = parcel.createTypedArrayList(MiniApp.CREATOR);
        this.cacheValidTime = parcel.readLong();
    }
}
