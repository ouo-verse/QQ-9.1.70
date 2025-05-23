package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.param.SearchParam;
import com.tencent.map.tools.Util;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes7.dex */
public class ExploreParam implements ParamObject {
    static IPatchRedirector $redirector_ = null;
    private static final String ADDRESS_FORMAT = "address_format";
    private static final String BOUNDARY = "boundary";
    private static final String DISTANCE_ASCE = "_distance";
    private static final String DISTANCE_DESC = "_distance desc";
    private static final String FILTER = "filter";
    private static final String NEARBY = "nearby";
    private static final String ORDERBY = "orderby";
    private static final String PAGE_INDEX = "page_index";
    private static final String PAGE_SIZE = "page_size";
    private static final String POLICY = "policy";
    private static final String SHORT_ADDRESS = "short";
    private boolean address_format;
    private SearchParam.Boundary boundary;
    private boolean distance_order;
    private String filter;
    private int page_index;
    private int page_size;
    private int policy;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Policy {
        private static final /* synthetic */ Policy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Policy DEFAULT;
        public static final Policy SHARE_LOCATION;
        public final int policyValue;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48303);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Policy policy = new Policy("DEFAULT", 0, 1);
            DEFAULT = policy;
            Policy policy2 = new Policy("SHARE_LOCATION", 1, 2);
            SHARE_LOCATION = policy2;
            $VALUES = new Policy[]{policy, policy2};
        }

        Policy(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.policyValue = i16;
            }
        }

        public static Policy valueOf(String str) {
            return (Policy) Enum.valueOf(Policy.class, str);
        }

        public static Policy[] values() {
            return (Policy[]) $VALUES.clone();
        }
    }

    public ExploreParam(SearchParam.Boundary boundary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) boundary);
            return;
        }
        this.distance_order = true;
        this.policy = Policy.DEFAULT.policyValue;
        this.page_size = -1;
        this.page_index = 1;
        this.address_format = false;
        this.boundary = boundary;
    }

    public ExploreParam addressFormat(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ExploreParam) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        this.address_format = z16;
        return this;
    }

    public ExploreParam boundary(SearchParam.Boundary boundary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ExploreParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) boundary);
        }
        this.boundary = boundary;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (RequestParams) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        SearchParam.Boundary boundary = this.boundary;
        if (boundary != null) {
            requestParams.add(BOUNDARY, boundary.toString());
        }
        if (!TextUtils.isEmpty(this.filter)) {
            requestParams.add("filter", this.filter);
        }
        if (this.distance_order) {
            str = DISTANCE_ASCE;
        } else {
            str = DISTANCE_DESC;
        }
        requestParams.add(ORDERBY, str);
        requestParams.add(POLICY, String.valueOf(this.policy));
        int i3 = this.page_size;
        if (i3 > 0) {
            requestParams.add(PAGE_SIZE, String.valueOf(i3));
        }
        int i16 = this.page_index;
        if (i16 > 0) {
            requestParams.add("page_index", String.valueOf(i16));
        }
        if (this.address_format) {
            requestParams.add(ADDRESS_FORMAT, "short");
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.boundary == null) {
            return false;
        }
        return true;
    }

    public ExploreParam filter(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ExploreParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) strArr);
        }
        this.filter = Util.filterBuilder(strArr);
        return this;
    }

    public ExploreParam orderby(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ExploreParam) iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
        this.distance_order = z16;
        return this;
    }

    public ExploreParam pageIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ExploreParam) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        this.page_index = i3;
        return this;
    }

    public ExploreParam pageSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ExploreParam) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        this.page_size = i3;
        return this;
    }

    public ExploreParam policy(Policy policy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ExploreParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) policy);
        }
        this.policy = policy.policyValue;
        return this;
    }

    /* loaded from: classes7.dex */
    public static class Nearby implements SearchParam.Boundary {
        static IPatchRedirector $redirector_;
        private boolean autoExtend;
        private LatLng point;
        private int radius;

        public Nearby() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.autoExtend = true;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public Nearby autoExtend(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Nearby) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.autoExtend = z16;
            return this;
        }

        public Nearby point(LatLng latLng) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Nearby) iPatchRedirector.redirect((short) 3, (Object) this, (Object) latLng);
            }
            this.point = latLng;
            return this;
        }

        public Nearby r(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Nearby) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.radius = i3;
            return this;
        }

        @Override // com.tencent.lbssearch.object.param.SearchParam.Boundary
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return "nearby(" + this.point.latitude + "," + this.point.longitude + "," + this.radius + "," + (this.autoExtend ? 1 : 0) + ")";
        }

        public Nearby(LatLng latLng, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng, i3);
                return;
            }
            this.autoExtend = true;
            this.point = latLng;
            this.radius = i3;
        }
    }
}
