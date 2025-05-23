package com.tencent.luggage.wxa.rf;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEnumTableID;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public a f139625a = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends com.tencent.luggage.wxa.wd.d {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public c f139626c;

        /* renamed from: d, reason: collision with root package name */
        public int f139627d;

        /* renamed from: e, reason: collision with root package name */
        public String f139628e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f139629f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[0];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }
        }

        public b(c cVar) {
            this(cVar, false);
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            super.a(parcel);
            this.f139627d = parcel.readInt();
            this.f139628e = parcel.readString();
            boolean z16 = true;
            if (1 != parcel.readInt()) {
                z16 = false;
            }
            this.f139629f = z16;
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public int describeContents() {
            return super.describeContents();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void g() {
            super.g();
            f();
            c cVar = this.f139626c;
            if (cVar != null) {
                cVar.a(this.f139627d, this.f139628e);
            }
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            if (!com.tencent.luggage.wxa.tf.d.c()) {
                this.f139627d = GProEnumTableID.ENUMTABLEIDQGROUPFEEDACTOPT;
                this.f139628e = "not support NFC";
            } else if (!com.tencent.luggage.wxa.tf.d.b()) {
                this.f139627d = TVKEventId.PLAYER_STATE_UPDATE_VIEW;
                this.f139628e = "not support HCE";
            } else if (this.f139629f && !com.tencent.luggage.wxa.tf.d.d()) {
                this.f139627d = 13001;
                this.f139628e = "system NFC switch not opened";
            } else {
                this.f139627d = 0;
                this.f139628e = "support HCE and system NFC switch is opened";
            }
            a();
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f139627d);
            parcel.writeString(this.f139628e);
            parcel.writeInt(this.f139629f ? 1 : 0);
        }

        public b(c cVar, boolean z16) {
            this.f139626c = cVar;
            this.f139629f = z16;
        }

        public b(Parcel parcel) {
            this.f139626c = null;
            a(parcel);
        }
    }

    public final void a(a aVar) {
        a(aVar, false);
    }

    public final void a(a aVar, boolean z16) {
        this.f139625a = aVar;
        new b(this, z16).b();
    }

    public final void a(int i3, String str) {
        w.d("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", Integer.valueOf(i3), str);
        if (i3 == 0) {
            a aVar = this.f139625a;
            if (aVar != null) {
                aVar.a(i3, str);
                return;
            }
            return;
        }
        if (w0.c(str)) {
            str = "unknown error";
        }
        a aVar2 = this.f139625a;
        if (aVar2 != null) {
            aVar2.a(i3, str);
        }
    }
}
