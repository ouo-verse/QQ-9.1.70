package com.tencent.mobileqq.location.ui;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.SearchResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.map.tools.Util;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class LocationPoiDataFromMapHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private TencentMap f241483a;

    /* renamed from: b, reason: collision with root package name */
    private final LatLng f241484b;

    /* renamed from: c, reason: collision with root package name */
    private final String f241485c;

    /* renamed from: d, reason: collision with root package name */
    private final List<LocationRoom.Venue> f241486d;

    /* renamed from: e, reason: collision with root package name */
    private int f241487e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f241488f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f241489g;

    /* renamed from: h, reason: collision with root package name */
    private a f241490h;

    /* loaded from: classes15.dex */
    public interface a {
        void onUpdate(List<LocationRoom.Venue> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationPoiDataFromMapHelper(TencentMap tencentMap, LatLng latLng, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tencentMap, latLng, str);
            return;
        }
        this.f241486d = new ArrayList(20);
        this.f241487e = 1;
        this.f241488f = true;
        this.f241483a = tencentMap;
        this.f241484b = latLng;
        this.f241485c = str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(int i3, int i16) {
        if (i3 > i16 && i16 < 200) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(LatLng latLng, int i3) {
        new OkHttpClient().newCall(new Request.Builder().url("https://apis.map.qq.com/ws/place/v1/explore?boundary=nearby(" + latLng.latitude + "," + latLng.longitude + ",1000,1)&policy=2&page_size=20&page_index=" + i3 + "&key=" + Util.getMetaKey(MobileQQ.sMobileQQ.getBaseContext(), "TencentMapSDK")).build()).enqueue(new Callback(i3) { // from class: com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.2
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f241494a;

            {
                this.f241494a = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPoiDataFromMapHelper.this, i3);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    LocationPoiDataFromMapHelper.this.f241489g = false;
                    if (QLog.isDevelopLevel()) {
                        QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onFailure: mVenueList size = " + LocationPoiDataFromMapHelper.this.f241486d.size() + ", mHashMore = " + LocationPoiDataFromMapHelper.this.f241488f);
                    }
                    if (LocationPoiDataFromMapHelper.this.f241490h != null) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    LocationPoiDataFromMapHelper.this.f241490h.onUpdate(LocationPoiDataFromMapHelper.this.f241486d);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) call, (Object) iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) call, (Object) response);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    if (jSONObject.has("count")) {
                        i16 = jSONObject.optInt("count");
                    } else {
                        i16 = -1;
                    }
                    String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
                    if (jSONObject.has("data")) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (optJSONArray.length() != 0) {
                            LocationPoiDataFromMapHelper.this.f241487e++;
                        }
                        for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                            LocationRoom.Venue venue = new LocationRoom.Venue();
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i17);
                            JSONObject optJSONObject = jSONObject2.optJSONObject("location");
                            venue.f241271f = jSONObject2.optString("title");
                            venue.f241272h = jSONObject2.optString("address");
                            venue.f241274m = jSONObject2.optDouble("_distance");
                            venue.f241273i = new LatLng(optJSONObject.optDouble(QCircleSchemeAttr.Polymerize.LAT), optJSONObject.optDouble("lng"));
                            venue.f241270e = account;
                            LocationPoiDataFromMapHelper.this.f241486d.add(venue);
                        }
                    }
                    LocationPoiDataFromMapHelper locationPoiDataFromMapHelper = LocationPoiDataFromMapHelper.this;
                    locationPoiDataFromMapHelper.f241488f = locationPoiDataFromMapHelper.m(i16, this.f241494a * 20);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                response.body().close();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.2.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            LocationPoiDataFromMapHelper.this.f241490h.onUpdate(LocationPoiDataFromMapHelper.this.f241486d);
                        }
                    }
                });
            }
        });
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch next: mKeyWord = " + this.f241485c + " latLng = " + this.f241484b + ", page = " + this.f241487e + ", isSearching = " + this.f241489g + ", hasMore = " + this.f241488f);
        }
        if (!this.f241488f) {
            return false;
        }
        this.f241489g = true;
        TencentSearch tencentSearch = new TencentSearch(BaseApplication.getContext());
        String cityName = this.f241483a.getCityName(this.f241484b);
        if (!TextUtils.isEmpty(cityName) && cityName.lastIndexOf("\u5e02") == cityName.length() - 1) {
            cityName = cityName.substring(0, cityName.length() - 1);
        }
        HttpResponseListener<BaseObject> httpResponseListener = new HttpResponseListener<BaseObject>() { // from class: com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationPoiDataFromMapHelper.this);
                }
            }

            @Override // com.tencent.map.tools.net.http.HttpResponseListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(int i3, BaseObject baseObject) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) baseObject);
                    return;
                }
                boolean z16 = false;
                LocationPoiDataFromMapHelper.this.f241489g = false;
                String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
                if (baseObject instanceof Geo2AddressResultObject) {
                    LocationPoiDataFromMapHelper.this.f241486d.add(LocationRoom.Venue.a(account, ((Geo2AddressResultObject) baseObject).result, LocationPoiDataFromMapHelper.this.f241484b));
                    LocationPoiDataFromMapHelper locationPoiDataFromMapHelper = LocationPoiDataFromMapHelper.this;
                    locationPoiDataFromMapHelper.n(locationPoiDataFromMapHelper.f241484b, LocationPoiDataFromMapHelper.this.f241487e);
                    return;
                }
                if (baseObject instanceof SuggestionResultObject) {
                    SuggestionResultObject suggestionResultObject = (SuggestionResultObject) baseObject;
                    if (suggestionResultObject.data != null) {
                        LocationPoiDataFromMapHelper.this.f241487e++;
                        Iterator<SuggestionResultObject.SuggestionData> it = suggestionResultObject.data.iterator();
                        while (it.hasNext()) {
                            LocationPoiDataFromMapHelper.this.f241486d.add(LocationRoom.Venue.c(account, it.next()));
                        }
                        LocationPoiDataFromMapHelper locationPoiDataFromMapHelper2 = LocationPoiDataFromMapHelper.this;
                        if (suggestionResultObject.count >= locationPoiDataFromMapHelper2.f241487e * 20) {
                            z16 = true;
                        }
                        locationPoiDataFromMapHelper2.f241488f = z16;
                    }
                } else if (baseObject instanceof SearchResultObject) {
                    SearchResultObject searchResultObject = (SearchResultObject) baseObject;
                    if (searchResultObject.data != null) {
                        LocationPoiDataFromMapHelper.this.f241487e++;
                        Iterator<SearchResultObject.SearchResultData> it5 = searchResultObject.data.iterator();
                        while (it5.hasNext()) {
                            LocationPoiDataFromMapHelper.this.f241486d.add(LocationRoom.Venue.b(account, it5.next()));
                        }
                        LocationPoiDataFromMapHelper locationPoiDataFromMapHelper3 = LocationPoiDataFromMapHelper.this;
                        if (searchResultObject.count >= locationPoiDataFromMapHelper3.f241487e * 20) {
                            z16 = true;
                        }
                        locationPoiDataFromMapHelper3.f241488f = z16;
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onSuccess: mVenueList size = " + LocationPoiDataFromMapHelper.this.f241486d.size() + ", mHashMore = " + LocationPoiDataFromMapHelper.this.f241488f);
                }
                if (LocationPoiDataFromMapHelper.this.f241490h != null) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                LocationPoiDataFromMapHelper.this.f241490h.onUpdate(LocationPoiDataFromMapHelper.this.f241486d);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.map.tools.net.http.HttpResponseListener
            public void onFailure(int i3, String str, Throwable th5) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    LocationPoiDataFromMapHelper.this.f241489g = false;
                    if (QLog.isDevelopLevel()) {
                        QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onFailure: mVenueList size = " + LocationPoiDataFromMapHelper.this.f241486d.size() + ", mHashMore = " + LocationPoiDataFromMapHelper.this.f241488f);
                    }
                    if (LocationPoiDataFromMapHelper.this.f241490h != null) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.1.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    LocationPoiDataFromMapHelper.this.f241490h.onUpdate(LocationPoiDataFromMapHelper.this.f241486d);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 3, this, Integer.valueOf(i3), str, th5);
            }
        };
        if (TextUtils.isEmpty(this.f241485c)) {
            int i3 = this.f241487e;
            if (i3 <= 1) {
                tencentSearch.geo2address(new Geo2AddressParam(this.f241484b).getPoi(false).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(20).setPageIndex(this.f241487e)), httpResponseListener);
            } else {
                n(this.f241484b, i3);
            }
        } else {
            tencentSearch.suggestion(new SuggestionParam(this.f241485c, cityName).location(this.f241484b).policy(SuggestionParam.Policy.DEF).pageSize(20).pageIndex(this.f241487e), httpResponseListener);
        }
        return true;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f241488f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(a aVar) {
        this.f241490h = aVar;
    }
}
