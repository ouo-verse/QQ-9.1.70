package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.map.tools.Util;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes7.dex */
public class SearchParam implements ParamObject {
    static IPatchRedirector $redirector_ = null;
    private static final String ADDED_FIELDS = "added_fields";
    private static final String BOUNDARY = "boundary";
    private static final String CATEGORY_CODE = "category_code";
    private static final String DISTANCE_ASCE = "_distance";
    private static final String DISTANCE_DESC = "_distance desc";
    private static final String FILTER = "filter";
    private static final String GET_SUBPOIS = "get_subpois";
    private static final String KEYWORD = "keyword";
    private static final String NEARBY = "nearby";
    private static final String ORDERBY = "orderby";
    private static final String PAGE_INDEX = "page_index";
    private static final String PAGE_SIZE = "page_size";
    private static final String RECTANGLE = "rectangle";
    private static final String REGION = "region";
    private static final String SUB_TITLE_FORMAT = "sub_title_format";
    private Boundary boundary;
    private boolean distance_order;
    private String filter;
    private boolean get_category_code;
    private int get_subpois;
    private String keyword;
    private int page_index;
    private int page_size;
    private int sub_title_format;

    /* loaded from: classes7.dex */
    public interface Boundary {
        String toString();
    }

    /* loaded from: classes7.dex */
    public static class Rectangle implements Boundary {
        static IPatchRedirector $redirector_;
        private LatLng leftBottom;
        private LatLng rightTop;

        public Rectangle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public Rectangle point(LatLng latLng, LatLng latLng2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Rectangle) iPatchRedirector.redirect((short) 3, (Object) this, (Object) latLng, (Object) latLng2);
            }
            this.leftBottom = latLng;
            this.rightTop = latLng2;
            return this;
        }

        @Override // com.tencent.lbssearch.object.param.SearchParam.Boundary
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "rectangle(" + this.leftBottom.latitude + "," + this.leftBottom.longitude + "," + this.rightTop.latitude + "," + this.rightTop.longitude + ")";
        }

        public Rectangle(LatLng latLng, LatLng latLng2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng, (Object) latLng2);
            } else {
                this.leftBottom = latLng;
                this.rightTop = latLng2;
            }
        }
    }

    public SearchParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.distance_order = true;
        this.page_size = -1;
        this.page_index = 1;
        this.get_subpois = 0;
        this.sub_title_format = 0;
        this.get_category_code = false;
    }

    public SearchParam boundary(Boundary boundary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SearchParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) boundary);
        }
        this.boundary = boundary;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (RequestParams) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        if (!TextUtils.isEmpty(this.keyword)) {
            requestParams.add(KEYWORD, this.keyword);
        }
        Boundary boundary = this.boundary;
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
        int i3 = this.page_size;
        if (i3 > 0) {
            requestParams.add(PAGE_SIZE, String.valueOf(i3));
        }
        int i16 = this.page_index;
        if (i16 > 0) {
            requestParams.add("page_index", String.valueOf(i16));
        }
        requestParams.add(GET_SUBPOIS, String.valueOf(this.get_subpois));
        requestParams.add(SUB_TITLE_FORMAT, String.valueOf(this.sub_title_format));
        if (this.get_category_code) {
            requestParams.add(ADDED_FIELDS, CATEGORY_CODE);
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.keyword) && this.boundary != null) {
            return true;
        }
        return false;
    }

    public SearchParam filter(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SearchParam) iPatchRedirector.redirect((short) 5, (Object) this, (Object) strArr);
        }
        this.filter = Util.filterBuilder(strArr);
        return this;
    }

    public SearchParam getCategoryCode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (SearchParam) iPatchRedirector.redirect((short) 13, (Object) this, z16);
        }
        this.get_category_code = z16;
        return this;
    }

    public SearchParam keyword(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SearchParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.keyword = str;
        return this;
    }

    public SearchParam orderby(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SearchParam) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        this.distance_order = z16;
        return this;
    }

    public SearchParam pageIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SearchParam) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        this.page_index = i3;
        return this;
    }

    public SearchParam pageSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SearchParam) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        this.page_size = i3;
        return this;
    }

    public SearchParam page_index(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SearchParam) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        this.page_index = i3;
        return this;
    }

    public SearchParam page_size(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SearchParam) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        this.page_size = i3;
        return this;
    }

    public SearchParam region(Region region) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (SearchParam) iPatchRedirector.redirect((short) 14, (Object) this, (Object) region);
        }
        return this;
    }

    public SearchParam subPois(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SearchParam) iPatchRedirector.redirect((short) 11, (Object) this, z16);
        }
        this.get_subpois = z16 ? 1 : 0;
        return this;
    }

    public SearchParam subTitleFormat(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SearchParam) iPatchRedirector.redirect((short) 12, (Object) this, z16);
        }
        this.sub_title_format = z16 ? 1 : 0;
        return this;
    }

    /* loaded from: classes7.dex */
    public static class Nearby implements Boundary {
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

    /* loaded from: classes7.dex */
    public static class Region implements Boundary {
        static IPatchRedirector $redirector_;
        private boolean autoExtend;
        private String city;
        private LatLng latLng;

        public Region() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.autoExtend = false;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public Region autoExtend(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Region) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.autoExtend = z16;
            return this;
        }

        public Region center(LatLng latLng) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Region) iPatchRedirector.redirect((short) 5, (Object) this, (Object) latLng);
            }
            this.latLng = latLng;
            return this;
        }

        public Region poi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Region) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.city = str;
            return this;
        }

        @Override // com.tencent.lbssearch.object.param.SearchParam.Boundary
        public String toString() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder("region(");
            sb5.append(this.city);
            sb5.append(",");
            sb5.append(this.autoExtend ? 1 : 0);
            if (this.latLng != null) {
                str = "," + this.latLng.latitude + "," + this.latLng.longitude;
            } else {
                str = "";
            }
            sb5.append(str);
            sb5.append(")");
            return sb5.toString();
        }

        public Region(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                this.autoExtend = false;
                this.city = str;
            }
        }
    }

    public SearchParam(String str, Boundary boundary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) boundary);
            return;
        }
        this.distance_order = true;
        this.page_size = -1;
        this.page_index = 1;
        this.get_subpois = 0;
        this.sub_title_format = 0;
        this.get_category_code = false;
        this.keyword = str;
        this.boundary = boundary;
    }
}
