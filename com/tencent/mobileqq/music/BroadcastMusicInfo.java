package com.tencent.mobileqq.music;

import NS_NEXTRADIO_QZONEBGMUSIC.BroadcastForQzone;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BroadcastMusicInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<BroadcastMusicInfo> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public String f251823d;

    /* renamed from: e, reason: collision with root package name */
    public String f251824e;

    /* renamed from: f, reason: collision with root package name */
    public String f251825f;

    /* renamed from: h, reason: collision with root package name */
    public BroadcastAudio f251826h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<BroadcastOneShow> f251827i;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<BroadcastMusicInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BroadcastMusicInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (BroadcastMusicInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new BroadcastMusicInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BroadcastMusicInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BroadcastMusicInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new BroadcastMusicInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            CREATOR = new a();
        }
    }

    public BroadcastMusicInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251823d = "";
        this.f251824e = "";
        this.f251825f = "";
        this.f251826h = null;
        this.f251827i = null;
    }

    public static BroadcastMusicInfo a(BroadcastForQzone broadcastForQzone) {
        BroadcastMusicInfo broadcastMusicInfo = new BroadcastMusicInfo();
        broadcastMusicInfo.f251823d = broadcastForQzone.broadcastID;
        broadcastMusicInfo.f251824e = broadcastForQzone.broadcastName;
        broadcastMusicInfo.f251826h = BroadcastAudio.a(broadcastForQzone.broadcastAudioUrl);
        broadcastMusicInfo.f251827i = new ArrayList<>();
        ArrayList<NS_NEXTRADIO_QZONEBGMUSIC.BroadcastOneShow> arrayList = broadcastForQzone.showList;
        if (arrayList != null) {
            Iterator<NS_NEXTRADIO_QZONEBGMUSIC.BroadcastOneShow> it = arrayList.iterator();
            while (it.hasNext()) {
                broadcastMusicInfo.f251827i.add(BroadcastOneShow.a(it.next()));
            }
        }
        return broadcastMusicInfo;
    }

    public static BroadcastMusicInfo b(String str) {
        BroadcastMusicInfo broadcastMusicInfo = new BroadcastMusicInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            broadcastMusicInfo.f251823d = jSONObject.optString("broadcastID");
            broadcastMusicInfo.f251824e = jSONObject.optString("broadcastName");
            broadcastMusicInfo.f251825f = jSONObject.optString("detailUrl");
            broadcastMusicInfo.f251826h = BroadcastAudio.b(jSONObject.getString("broadcastAudioUrl"));
            JSONArray jSONArray = jSONObject.getJSONArray("showList");
            broadcastMusicInfo.f251827i = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                broadcastMusicInfo.f251827i.add(BroadcastOneShow.b(jSONArray.optString(i3)));
            }
        } catch (Exception unused) {
        }
        return broadcastMusicInfo;
    }

    public static List<SongInfo> g(List<BroadcastMusicInfo> list, boolean z16) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<BroadcastMusicInfo> it = list.iterator();
            while (it.hasNext()) {
                SongInfo f16 = it.next().f(z16);
                if (f16 != null) {
                    arrayList.add(f16);
                }
            }
            return arrayList;
        }
        return null;
    }

    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ArrayList<BroadcastOneShow> arrayList = this.f251827i;
        if (arrayList != null) {
            Iterator<BroadcastOneShow> it = arrayList.iterator();
            while (it.hasNext()) {
                BroadcastOneShow next = it.next();
                long j3 = next.f251830f;
                if (j3 <= currentTimeMillis) {
                    long j16 = next.f251831h;
                    if (j16 > currentTimeMillis) {
                        return j16;
                    }
                } else {
                    return j3;
                }
            }
        }
        return -1L;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    public String e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
        if (z16) {
            return this.f251826h.f251821d.f251834d.get((byte) 0);
        }
        return this.f251826h.f251821d.f251834d.get((byte) 1);
    }

    public SongInfo f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SongInfo) iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
        SongInfo songInfo = new SongInfo();
        try {
            songInfo.f251867d = Long.parseLong(this.f251823d);
            songInfo.f251871i = getTitle();
            songInfo.I = 9;
            songInfo.D = this.f251825f;
            songInfo.f251870h = e(z16);
            songInfo.K = this;
            return songInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getTitle() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ArrayList<BroadcastOneShow> arrayList = this.f251827i;
        if (arrayList != null) {
            Iterator<BroadcastOneShow> it = arrayList.iterator();
            while (it.hasNext()) {
                BroadcastOneShow next = it.next();
                if (next.f251830f <= currentTimeMillis && next.f251831h > currentTimeMillis) {
                    str = this.f251824e + "\uff1a" + next.f251829e;
                    break;
                }
            }
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
            return HardCodeUtil.qqStr(R.string.k3t);
        }
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f251823d);
        parcel.writeString(this.f251824e);
        parcel.writeString(this.f251825f);
        parcel.writeParcelable(this.f251826h, i3);
        parcel.writeList(this.f251827i);
    }

    public BroadcastMusicInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f251823d = "";
        this.f251824e = "";
        this.f251825f = "";
        this.f251826h = null;
        this.f251827i = null;
        this.f251823d = parcel.readString();
        this.f251824e = parcel.readString();
        this.f251825f = parcel.readString();
        this.f251826h = (BroadcastAudio) parcel.readParcelable(BroadcastAudio.class.getClassLoader());
        this.f251827i = parcel.readArrayList(BroadcastOneShow.class.getClassLoader());
    }
}
