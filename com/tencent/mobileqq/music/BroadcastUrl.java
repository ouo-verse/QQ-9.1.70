package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BroadcastUrl implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<BroadcastUrl> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public Map<Byte, String> f251834d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<BroadcastUrl> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BroadcastUrl createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (BroadcastUrl) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new BroadcastUrl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BroadcastUrl[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BroadcastUrl[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new BroadcastUrl[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36937);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public BroadcastUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f251834d = null;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static BroadcastUrl a(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastUrl broadcastUrl) {
        BroadcastUrl broadcastUrl2 = new BroadcastUrl();
        broadcastUrl2.f251834d = broadcastUrl.mapBroadcastUrl;
        return broadcastUrl2;
    }

    public static BroadcastUrl b(String str) {
        BroadcastUrl broadcastUrl = new BroadcastUrl();
        try {
            JSONObject jSONObject = new JSONObject(str);
            broadcastUrl.f251834d = new HashMap();
            JSONObject jSONObject2 = jSONObject.getJSONObject("mapBroadcastUrl");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                broadcastUrl.f251834d.put(Byte.valueOf((byte) Integer.parseInt(str2)), jSONObject2.getString(str2));
            }
        } catch (Exception unused) {
        }
        return broadcastUrl;
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
            return;
        }
        Map<Byte, String> map = this.f251834d;
        if (map != null) {
            parcel.writeInt(map.size());
            for (Byte b16 : this.f251834d.keySet()) {
                parcel.writeByte(b16.byteValue());
                parcel.writeString(this.f251834d.get(b16));
            }
            return;
        }
        parcel.writeInt(0);
    }

    public BroadcastUrl(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f251834d = null;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            if (this.f251834d == null) {
                this.f251834d = new HashMap();
            }
            for (int i3 = 0; i3 < readInt; i3++) {
                this.f251834d.put(Byte.valueOf(parcel.readByte()), parcel.readString());
            }
        }
    }
}
