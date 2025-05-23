package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SuggestionResultObject extends BaseObject {
    static IPatchRedirector $redirector_;
    public int count;
    public List<SuggestionData> data;
    public List<SubPoi> sub_pois;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class SubPoi extends JsonComposer {
        static IPatchRedirector $redirector_;
        public AdInfo ad_info;
        public String adcode;
        public String address;
        public String category;
        public String category_code;
        public String city;

        /* renamed from: id, reason: collision with root package name */
        public String f118551id;

        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String parent_id;
        public String tel;
        public String title;
        public String type;

        public SubPoi() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class SuggestionData extends JsonComposer {
        static IPatchRedirector $redirector_;
        public float _distance;
        public String adcode;
        public String address;
        public String category;
        public String city;
        public String district;

        /* renamed from: id, reason: collision with root package name */
        public String f118552id;

        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String province;
        public String title;
        public int type;

        public SuggestionData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public SuggestionResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
