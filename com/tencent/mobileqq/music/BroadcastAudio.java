package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BroadcastAudio implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<BroadcastAudio> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public BroadcastUrl f251821d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<BroadcastUrl> f251822e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<BroadcastAudio> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BroadcastAudio createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (BroadcastAudio) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new BroadcastAudio(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BroadcastAudio[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BroadcastAudio[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new BroadcastAudio[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36917);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public BroadcastAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f251821d = null;
            this.f251822e = null;
        }
    }

    public static BroadcastAudio a(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastAudio broadcastAudio) {
        BroadcastAudio broadcastAudio2 = new BroadcastAudio();
        broadcastAudio2.f251821d = BroadcastUrl.a(broadcastAudio.masterUrl);
        broadcastAudio2.f251822e = new ArrayList<>();
        ArrayList<NS_NEXTRADIO_QZONEBGMUSIC.BroadcastUrl> arrayList = broadcastAudio.slaveUrl;
        if (arrayList != null) {
            Iterator<NS_NEXTRADIO_QZONEBGMUSIC.BroadcastUrl> it = arrayList.iterator();
            while (it.hasNext()) {
                broadcastAudio2.f251822e.add(BroadcastUrl.a(it.next()));
            }
        }
        return broadcastAudio2;
    }

    public static BroadcastAudio b(String str) {
        BroadcastAudio broadcastAudio = new BroadcastAudio();
        try {
            JSONObject jSONObject = new JSONObject(str);
            broadcastAudio.f251821d = BroadcastUrl.b(jSONObject.getString("masterUrl"));
            JSONArray jSONArray = jSONObject.getJSONArray("slaveUrl");
            broadcastAudio.f251822e = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                broadcastAudio.f251822e.add(BroadcastUrl.b(jSONArray.optString(i3)));
            }
        } catch (Exception unused) {
        }
        return broadcastAudio;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
        } else {
            parcel.writeParcelable(this.f251821d, i3);
            parcel.writeList(this.f251822e);
        }
    }

    public BroadcastAudio(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f251821d = null;
        this.f251822e = null;
        this.f251821d = (BroadcastUrl) parcel.readParcelable(BroadcastUrl.class.getClassLoader());
        this.f251822e = parcel.readArrayList(BroadcastUrl.class.getClassLoader());
    }
}
