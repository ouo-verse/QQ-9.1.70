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
public class ExploreResultObject extends BaseObject {
    static IPatchRedirector $redirector_;
    public int count;
    public List<SearchResultData> data;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class SearchResultData extends JsonComposer {
        static IPatchRedirector $redirector_;
        public AdInfo ad_info;
        public String address;
        public String category;

        @Json(name = "_distance")
        public double distance;

        /* renamed from: id, reason: collision with root package name */
        public String f118546id;

        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String title;
        public String type;

        public SearchResultData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ExploreResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
