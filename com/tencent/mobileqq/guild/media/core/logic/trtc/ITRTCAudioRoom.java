package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.tencent.mobileqq.guild.media.core.data.MediaRoomStatus;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.logic.EnterTrtcRoomReq;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public interface ITRTCAudioRoom extends h, d, j, n, f, l {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class TRTCVolumeInfo implements Parcelable {

        /* renamed from: d, reason: collision with root package name */
        public String f228504d;

        /* renamed from: e, reason: collision with root package name */
        public int f228505e;

        /* renamed from: f, reason: collision with root package name */
        public int f228506f;

        /* renamed from: h, reason: collision with root package name */
        private static final Pools.SynchronizedPool<TRTCVolumeInfo> f228503h = new Pools.SynchronizedPool<>(200);
        public static final Parcelable.Creator<TRTCVolumeInfo> CREATOR = new a();

        /* compiled from: P */
        /* loaded from: classes14.dex */
        class a implements Parcelable.Creator<TRTCVolumeInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TRTCVolumeInfo createFromParcel(Parcel parcel) {
                TRTCVolumeInfo tRTCVolumeInfo = new TRTCVolumeInfo();
                tRTCVolumeInfo.f228504d = parcel.readString();
                tRTCVolumeInfo.f228505e = parcel.readInt();
                tRTCVolumeInfo.f228506f = parcel.readInt();
                return tRTCVolumeInfo;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TRTCVolumeInfo[] newArray(int i3) {
                return new TRTCVolumeInfo[i3];
            }
        }

        private void a() {
            this.f228504d = "";
            this.f228505e = 0;
            this.f228506f = 0;
        }

        public static TRTCVolumeInfo c(TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo) {
            TRTCVolumeInfo acquire = f228503h.acquire();
            if (acquire == null) {
                acquire = new TRTCVolumeInfo();
            }
            acquire.f228504d = tRTCVolumeInfo.userId;
            acquire.f228505e = tRTCVolumeInfo.volume;
            acquire.f228506f = tRTCVolumeInfo.vad;
            return acquire;
        }

        public static ArrayList<TRTCVolumeInfo> e(List<TRTCCloudDef.TRTCVolumeInfo> list) {
            ArrayList<TRTCVolumeInfo> arrayList = new ArrayList<>();
            Iterator<TRTCCloudDef.TRTCVolumeInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(c(it.next()));
            }
            return arrayList;
        }

        public static void j(List<TRTCVolumeInfo> list) {
            if (list == null) {
                return;
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).g();
            }
        }

        public TRTCVolumeInfo b() {
            TRTCVolumeInfo acquire = f228503h.acquire();
            if (acquire == null) {
                acquire = new TRTCVolumeInfo();
            }
            acquire.f228504d = this.f228504d;
            acquire.f228505e = this.f228505e;
            acquire.f228506f = this.f228506f;
            return acquire;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean f(TRTCVolumeInfo tRTCVolumeInfo) {
            if (tRTCVolumeInfo == null || !TextUtils.equals(this.f228504d, tRTCVolumeInfo.f228504d) || this.f228505e != tRTCVolumeInfo.f228505e || this.f228506f != tRTCVolumeInfo.f228506f) {
                return false;
            }
            return true;
        }

        public void g() {
            a();
            f228503h.release(this);
        }

        public String toString() {
            return "TRTCVolumeInfo {userId='" + this.f228504d + "', volume=" + this.f228505e + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f228504d);
            parcel.writeInt(this.f228505e);
            parcel.writeInt(this.f228506f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void onCallback(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        void a(String str, int i3, String str2);

        void b(String str, int i3, String str2, boolean z16);

        void c(String str, int i3, ArrayList<TRTCVolumeInfo> arrayList, int i16);

        void d(String str, int i3, int i16, String str2);

        void e(String str, int i3, int i16, String str2);

        void f(String str, int i3, String str2, boolean z16);

        void g(String str, int i3, String str2);

        void h(String str, int i3, String str2, int i16, int i17);

        void i(String str, int i3, TRTCQuality tRTCQuality, ArrayList<TRTCQuality> arrayList);
    }

    /* synthetic */ void A();

    /* synthetic */ void B();

    void E(String str);

    /* synthetic */ void F(b bVar);

    void I(a aVar);

    /* synthetic */ void K();

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.d
    /* synthetic */ void a();

    /* synthetic */ void b(int i3);

    /* synthetic */ void c(List<MediaRoomStatus> list);

    /* synthetic */ void d();

    /* synthetic */ void e(String str);

    /* synthetic */ void f(String str, a aVar);

    /* synthetic */ void i(boolean z16);

    /* synthetic */ boolean isInited();

    /* synthetic */ ArrayList<MediaRoomStatus> j();

    void k(@NonNull EnterTrtcRoomReq enterTrtcRoomReq, a aVar);

    /* synthetic */ void l(String str);

    /* synthetic */ void m(EnterTrtcRoomReq enterTrtcRoomReq, a aVar);

    /* synthetic */ void muteRemoteAudio(String str, boolean z16);

    /* synthetic */ void o();

    /* synthetic */ int q();

    /* synthetic */ void r(Context context, String str, a aVar);

    /* synthetic */ void setRemoteAudioVolume(String str, int i3);

    /* synthetic */ void w(String str, Surface surface);

    /* synthetic */ void y(Context context);

    /* synthetic */ boolean z(String str, int i3);
}
