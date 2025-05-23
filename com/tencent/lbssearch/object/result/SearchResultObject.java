package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SearchResultObject extends BaseObject {
    static IPatchRedirector $redirector_;
    public int count;
    public List<SearchResultData> data;
    public List<SuggestionResultObject.SubPoi> sub_pois;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class SearchResultData extends JsonComposer {
        static IPatchRedirector $redirector_;
        public AdInfo ad_info;
        public String address;
        public String category;
        public String category_code;

        @Json(name = "_distance")
        public double distance;

        /* renamed from: id, reason: collision with root package name */
        public String f118548id;

        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public Pano pano;
        public String tel;
        public String title;
        public String type;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Pano extends JsonComposer {
            static IPatchRedirector $redirector_;
            public int heading;

            /* renamed from: id, reason: collision with root package name */
            public String f118549id;
            public int pitch;
            public int zoom;

            public Pano() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public SearchResultData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public SearchResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
