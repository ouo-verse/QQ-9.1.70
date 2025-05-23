package com.tencent.mobileqq.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.SearchResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LocationRoom {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final b f241259a;

    /* renamed from: b, reason: collision with root package name */
    private Venue f241260b;

    /* renamed from: c, reason: collision with root package name */
    private int f241261c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.location.data.a f241262d;

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashMap<String, com.tencent.mobileqq.location.data.a> f241263e;

    /* renamed from: f, reason: collision with root package name */
    private volatile a f241264f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f241265g;

    /* renamed from: h, reason: collision with root package name */
    private volatile CameraPosition f241266h;

    /* renamed from: i, reason: collision with root package name */
    private int f241267i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f241268j;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Venue implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<Venue> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        public SoftReference<Marker> f241269d;

        /* renamed from: e, reason: collision with root package name */
        public String f241270e;

        /* renamed from: f, reason: collision with root package name */
        public String f241271f;

        /* renamed from: h, reason: collision with root package name */
        public String f241272h;

        /* renamed from: i, reason: collision with root package name */
        public LatLng f241273i;

        /* renamed from: m, reason: collision with root package name */
        public double f241274m;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<Venue> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Venue createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Venue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new Venue(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Venue[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Venue[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new Venue[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32868);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
            } else {
                CREATOR = new a();
            }
        }

        public Venue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public static Venue a(String str, Geo2AddressResultObject.ReverseAddressResult reverseAddressResult, LatLng latLng) {
            Venue venue = new Venue();
            venue.f241270e = str;
            Geo2AddressResultObject.ReverseAddressResult.FormatterAddress formatterAddress = reverseAddressResult.formatted_addresses;
            if (formatterAddress == null) {
                venue.f241271f = reverseAddressResult.address;
            } else {
                venue.f241271f = formatterAddress.recommend;
            }
            venue.f241272h = reverseAddressResult.address;
            venue.f241273i = latLng;
            venue.f241274m = 0.0d;
            return venue;
        }

        public static Venue b(String str, SearchResultObject.SearchResultData searchResultData) {
            Venue venue = new Venue();
            venue.f241270e = str;
            venue.f241271f = searchResultData.title;
            venue.f241272h = searchResultData.address;
            venue.f241273i = searchResultData.latLng;
            venue.f241274m = searchResultData.distance;
            return venue;
        }

        public static Venue c(String str, SuggestionResultObject.SuggestionData suggestionData) {
            Venue venue = new Venue();
            venue.f241270e = str;
            venue.f241271f = suggestionData.title;
            venue.f241272h = suggestionData.address;
            venue.f241273i = suggestionData.latLng;
            venue.f241274m = suggestionData._distance;
            return venue;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
            }
            if (obj instanceof Venue) {
                return this.f241273i.equals(((Venue) obj).f241273i);
            }
            return super.equals(obj);
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "Venue{ name = " + this.f241271f + " address: " + this.f241272h + " authorUin: " + this.f241270e + " point: " + this.f241273i + " marker: " + this.f241269d + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, i3);
                return;
            }
            parcel.writeString(this.f241270e);
            parcel.writeString(this.f241271f);
            parcel.writeString(this.f241272h);
            parcel.writeParcelable(this.f241273i, i3);
        }

        protected Venue(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                return;
            }
            this.f241270e = parcel.readString();
            this.f241271f = parcel.readString();
            this.f241272h = parcel.readString();
            this.f241273i = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a();

        void b(String str);

        void c(Venue venue);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f241275a;

        /* renamed from: b, reason: collision with root package name */
        private final String f241276b;

        public b(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            } else {
                this.f241275a = i3;
                this.f241276b = str;
            }
        }

        public boolean a(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str)).booleanValue();
            }
            if (this.f241275a == i3 && this.f241276b.equals(str)) {
                return true;
            }
            return false;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f241275a;
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f241276b;
        }

        public boolean equals(@Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f241275a != bVar.b() || !this.f241276b.equals(bVar.c())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.f241275a + this.f241276b.hashCode();
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "RoomKey{mHashCode='" + hashCode() + ", mSessionType=" + this.f241275a + ", mSessionUin=" + this.f241276b + '}';
        }
    }

    public LocationRoom(b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) str);
            return;
        }
        this.f241261c = -1;
        this.f241265g = false;
        this.f241266h = null;
        this.f241267i = 0;
        this.f241268j = false;
        this.f241259a = bVar;
        this.f241263e = new LinkedHashMap<>();
        this.f241262d = new com.tencent.mobileqq.location.data.a(str, null, 0.0d);
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            this.f241268j = z16;
        }
    }

    public CameraPosition b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (CameraPosition) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.f241266h;
    }

    public List<LatLng> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        ArrayList arrayList = new ArrayList(this.f241263e.size());
        Iterator<com.tencent.mobileqq.location.data.a> it = this.f241263e.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b());
        }
        Venue venue = this.f241260b;
        if (venue != null) {
            arrayList.add(venue.f241273i);
        }
        return arrayList;
    }

    public com.tencent.mobileqq.location.data.a d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.mobileqq.location.data.a) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        return this.f241263e.get(str);
    }

    public List<com.tencent.mobileqq.location.data.a> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        ArrayList arrayList = new ArrayList(this.f241263e.size() + 1);
        arrayList.addAll(this.f241263e.values());
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof LocationRoom)) {
            return false;
        }
        return this.f241259a.equals(((LocationRoom) obj).f241259a);
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f241265g;
    }

    public b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (b) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f241259a;
    }

    public List<LatLng> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (this.f241260b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.f241262d.b());
        arrayList.add(this.f241260b.f241273i);
        return arrayList;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f241261c;
    }

    public com.tencent.mobileqq.location.data.a j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.location.data.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f241262d;
    }

    public List<String> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (List) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(this.f241263e.keySet());
        return arrayList;
    }

    public Venue l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Venue) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f241260b;
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int i3 = this.f241267i;
        this.f241267i = i3 + 1;
        return i3;
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.f241268j;
    }

    public boolean o(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar)).booleanValue();
        }
        return this.f241259a.equals(bVar);
    }

    public void p(CameraPosition cameraPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cameraPosition);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationRoom", 2, "onLeaveMapPage: invoked. lastCameraPosition: " + cameraPosition);
        }
        this.f241264f = null;
        q(false);
        r(null);
        if (((ILocationShareService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ILocationShareService.class, "")).isCurrentUserSharing()) {
            this.f241266h = cameraPosition;
        } else {
            this.f241266h = null;
        }
    }

    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f241265g = z16;
        }
    }

    public void r(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) aVar);
        } else {
            this.f241264f = aVar;
        }
    }

    public void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f241261c = i3;
        }
    }

    public void t(Venue venue) {
        SoftReference<Marker> softReference;
        SoftReference<Marker> softReference2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) venue);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationRoom", 2, "[venue]setVenue invoked. venue: ", venue + " mVenue: " + this.f241260b + " listener: " + this.f241264f);
        }
        if (venue != null) {
            if (venue.equals(this.f241260b)) {
                if (this.f241260b.f241269d == null && this.f241264f != null) {
                    this.f241264f.c(this.f241260b);
                    return;
                }
                return;
            }
            Venue venue2 = this.f241260b;
            if (venue2 != null && (softReference2 = venue2.f241269d) != null) {
                Marker marker = softReference2.get();
                this.f241260b.f241269d = null;
                if (marker != null) {
                    marker.remove();
                }
            }
            this.f241260b = venue;
            if (this.f241264f != null) {
                this.f241264f.c(this.f241260b);
                return;
            }
            return;
        }
        Venue venue3 = this.f241260b;
        if (venue3 != null && (softReference = venue3.f241269d) != null) {
            Marker marker2 = softReference.get();
            this.f241260b.f241269d = null;
            if (marker2 != null) {
                marker2.remove();
            }
            if (this.f241264f != null) {
                this.f241264f.a();
            }
        }
        this.f241260b = null;
    }

    public void u(List<com.tencent.mobileqq.location.data.a> list) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        Iterator<Map.Entry<String, com.tencent.mobileqq.location.data.a>> it = this.f241263e.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mobileqq.location.data.a value = it.next().getValue();
            if (!list.contains(value)) {
                if (this.f241264f != null) {
                    this.f241264f.b(value.d());
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LocationRoom", 2, "updateRoomLocation invoked. remove LocationItem: ", value + " listener: " + this.f241264f);
                }
                it.remove();
            }
        }
        if (this.f241259a.b() == 0 && this.f241263e.size() == 1 && list.size() == 2) {
            this.f241265g = true;
        }
        for (i3 = 0; i3 < list.size(); i3++) {
            com.tencent.mobileqq.location.data.a aVar = list.get(i3);
            if (aVar.equals(this.f241262d)) {
                if (this.f241262d.e() < 0) {
                    com.tencent.mobileqq.location.data.a aVar2 = this.f241262d;
                    int i16 = this.f241267i;
                    this.f241267i = i16 + 1;
                    aVar2.g(i16);
                }
                if (!this.f241263e.containsValue(this.f241262d)) {
                    this.f241263e.put(this.f241262d.d(), this.f241262d);
                }
            } else {
                com.tencent.mobileqq.location.data.a aVar3 = this.f241263e.get(aVar.d());
                if (aVar3 == null) {
                    int i17 = this.f241267i;
                    this.f241267i = i17 + 1;
                    aVar.g(i17);
                    this.f241263e.put(aVar.d(), aVar);
                } else {
                    if (aVar3.e() < 0) {
                        int i18 = this.f241267i;
                        this.f241267i = i18 + 1;
                        aVar3.g(i18);
                    }
                    aVar3.f(aVar.b(), Double.valueOf(aVar.c()));
                }
            }
        }
    }

    public void v(LatLng latLng, Double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) latLng, (Object) d16);
        } else {
            this.f241262d.f(latLng, d16);
        }
    }
}
