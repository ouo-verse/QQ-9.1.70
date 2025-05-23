package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Geo2AddressResultObject extends BaseObject {
    static IPatchRedirector $redirector_;
    public ReverseAddressResult result;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class ReverseAddressResult extends JsonComposer {
        static IPatchRedirector $redirector_;
        public AdInfo ad_info;
        public String address;
        public AddressComponent address_component;
        public AddressReference address_reference;
        public FormatterAddress formatted_addresses;
        public int poi_count;
        public List<Poi> pois;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class AddressReference extends JsonComposer {
            static IPatchRedirector $redirector_;
            public Area business_area;
            public Area crossroad;
            public Area famous_area;
            public Area landmark_l1;
            public Area landmark_l2;
            public Area ocean;
            public Area street;
            public Area street_number;
            public Area town;
            public Area water;

            /* compiled from: P */
            /* loaded from: classes7.dex */
            public static final class Area extends JsonComposer {
                static IPatchRedirector $redirector_;
                public String _dir_desc;
                public float _distance;

                /* renamed from: id, reason: collision with root package name */
                String f118547id;

                @Json(deserializer = LatLngDeserializer.class, name = "location")
                public LatLng latLng;
                public String title;

                public Area() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }
            }

            public AddressReference() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class FormatterAddress extends JsonComposer {
            static IPatchRedirector $redirector_;
            public String recommend;
            public String rough;

            public FormatterAddress() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public ReverseAddressResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public Geo2AddressResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
