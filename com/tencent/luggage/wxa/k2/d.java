package com.tencent.luggage.wxa.k2;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends JsApiSetBackgroundAudioState {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends JsApiSetBackgroundAudioState.b {
        public static final Parcelable.Creator<a> CREATOR = new C6355a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.k2.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6355a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(Parcel parcel) {
            super(parcel);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.b, com.tencent.luggage.wxa.wd.d
        public void h() {
            f.a();
            super.h();
        }

        public a(com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            super(aVar, dVar, i3);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState
    public JsApiSetBackgroundAudioState.b b(com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
        return new a(aVar, dVar, i3);
    }
}
