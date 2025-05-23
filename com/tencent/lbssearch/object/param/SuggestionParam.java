package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.map.tools.Util;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes7.dex */
public class SuggestionParam implements ParamObject {
    static IPatchRedirector $redirector_ = null;
    private static final String FILTER = "filter";
    private static final String KEYWORD = "keyword";
    private static final String REGION = "region";
    private String addressFormat;
    private String filter;
    private int isGetSubPois;
    private String keyword;
    private LatLng location;
    private int pageIndex;
    private int pageSize;
    private int policy;
    private String region;
    private int regionFix;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class AddressFormat {
        private static final /* synthetic */ AddressFormat[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final AddressFormat SHORT;
        public String value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55326);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            AddressFormat addressFormat = new AddressFormat("SHORT", 0, Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT);
            SHORT = addressFormat;
            $VALUES = new AddressFormat[]{addressFormat};
        }

        AddressFormat(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.value = str2;
            }
        }

        public static AddressFormat valueOf(String str) {
            return (AddressFormat) Enum.valueOf(AddressFormat.class, str);
        }

        public static AddressFormat[] values() {
            return (AddressFormat[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Policy {
        private static final /* synthetic */ Policy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Policy DEF;
        public static final Policy O2O;
        public static final Policy TRIP_END;
        public static final Policy TRIP_START;
        public int value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59782);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Policy policy = new Policy("DEF", 0, 0);
            DEF = policy;
            Policy policy2 = new Policy("O2O", 1, 1);
            O2O = policy2;
            Policy policy3 = new Policy("TRIP_START", 2, 10);
            TRIP_START = policy3;
            Policy policy4 = new Policy("TRIP_END", 3, 11);
            TRIP_END = policy4;
            $VALUES = new Policy[]{policy, policy2, policy3, policy4};
        }

        Policy(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static Policy valueOf(String str) {
            return (Policy) Enum.valueOf(Policy.class, str);
        }

        public static Policy[] values() {
            return (Policy[]) $VALUES.clone();
        }
    }

    public SuggestionParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public SuggestionParam addressFormat(AddressFormat addressFormat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SuggestionParam) iPatchRedirector.redirect((short) 9, (Object) this, (Object) addressFormat);
        }
        this.addressFormat = addressFormat.value;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (RequestParams) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        if (!TextUtils.isEmpty(this.keyword)) {
            requestParams.add(KEYWORD, this.keyword);
        }
        if (!TextUtils.isEmpty(this.region)) {
            requestParams.add("region", this.region);
        }
        if (!TextUtils.isEmpty(this.filter)) {
            requestParams.add("filter", this.filter);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.regionFix);
        requestParams.add("region_fix", sb5.toString());
        if (this.location != null) {
            requestParams.add("location", this.location.latitude + "," + this.location.longitude);
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(this.isGetSubPois);
        requestParams.add("get_subpois", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(this.policy);
        requestParams.add("policy", sb7.toString());
        if (!TextUtils.isEmpty(this.addressFormat)) {
            requestParams.add("address_format", this.addressFormat);
        }
        int i16 = this.pageIndex;
        if (i16 > 0 && i16 <= 20 && (i3 = this.pageSize) > 0 && i3 <= 20) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(this.pageIndex);
            requestParams.add(ThemeDIYDownloader.HEADER_PAGEINDEX, sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(this.pageSize);
            requestParams.add("page_size", sb9.toString());
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.keyword) && !TextUtils.isEmpty(this.region)) {
            return true;
        }
        return false;
    }

    public SuggestionParam filter(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SuggestionParam) iPatchRedirector.redirect((short) 5, (Object) this, (Object) strArr);
        }
        this.filter = Util.filterBuilder(strArr);
        return this;
    }

    public SuggestionParam getSubPois(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SuggestionParam) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        this.isGetSubPois = z16 ? 1 : 0;
        return this;
    }

    public SuggestionParam keyword(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SuggestionParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.keyword = str;
        return this;
    }

    public SuggestionParam location(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SuggestionParam) iPatchRedirector.redirect((short) 7, (Object) this, (Object) latLng);
        }
        this.location = latLng;
        return this;
    }

    public SuggestionParam pageIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SuggestionParam) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        this.pageIndex = i3;
        return this;
    }

    public SuggestionParam pageSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SuggestionParam) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        this.pageSize = i3;
        return this;
    }

    public SuggestionParam policy(Policy policy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SuggestionParam) iPatchRedirector.redirect((short) 10, (Object) this, (Object) policy);
        }
        this.policy = policy.value;
        return this;
    }

    public SuggestionParam region(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SuggestionParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        this.region = str;
        return this;
    }

    public SuggestionParam regionFix(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SuggestionParam) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        this.regionFix = z16 ? 1 : 0;
        return this;
    }

    public SuggestionParam(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            this.keyword = str;
            this.region = str2;
        }
    }
}
