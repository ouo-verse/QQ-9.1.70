package com.tencent.lbssearch;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ark.ark;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.param.Address2GeoParam;
import com.tencent.lbssearch.object.param.DistrictChildrenParam;
import com.tencent.lbssearch.object.param.DistrictSearchParam;
import com.tencent.lbssearch.object.param.ExploreParam;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.MatrixParam;
import com.tencent.lbssearch.object.param.ParamObject;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.param.SearchIDParam;
import com.tencent.lbssearch.object.param.SearchParam;
import com.tencent.lbssearch.object.param.StreetViewParam;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.param.TranslateParam;
import com.tencent.lbssearch.object.result.Address2GeoResultObject;
import com.tencent.lbssearch.object.result.DistanceMatrixResultObject;
import com.tencent.lbssearch.object.result.DistrictResultObject;
import com.tencent.lbssearch.object.result.ExploreResultObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.SearchDetailResultObject;
import com.tencent.lbssearch.object.result.SearchResultObject;
import com.tencent.lbssearch.object.result.StreetViewResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.lbssearch.object.result.TranslateResultObject;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.internal.ho;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TencentSearch implements UrlConstant {
    static IPatchRedirector $redirector_;
    private final String mApiKey;
    private final Context mContext;
    private boolean mIsDebuggable;
    private final String mSecretKey;

    public TencentSearch(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private <T extends BaseObject> void doHttpGet(String str, ParamObject paramObject, Class<T> cls, HttpResponseListener<T> httpResponseListener) {
        if (!TencentMapInitializer.getAgreePrivacy()) {
            if (httpResponseListener != null) {
                httpResponseListener.onFailure(-1, "\u8bf7\u786e\u4fdd\u9690\u79c1\u653f\u7b56\u5df2\u53d6\u5f97\u7528\u6237\u540c\u610f", null);
                return;
            }
            return;
        }
        if (paramObject != null && paramObject.checkParams()) {
            String str2 = this.mApiKey;
            if (TextUtils.isEmpty(str2)) {
                str2 = Util.getMetaKey(this.mContext, "TencentMapSDK");
                if (TextUtils.isEmpty(str2)) {
                    if (httpResponseListener != null) {
                        httpResponseListener.onFailure(-1, "\u8bf7\u7533\u8bf7\u5e76\u586b\u5199\u5f00\u53d1\u8005\u5bc6\u94a5", null);
                        return;
                    }
                    return;
                }
            }
            RequestParams buildParameters = paramObject.buildParameters();
            if (buildParameters != null) {
                buildParameters.add("key", str2);
                buildParameters.add("output", ark.ARKMETADATA_JSON);
            } else {
                buildParameters = new RequestParams();
            }
            RequestParams requestParams = buildParameters;
            if (!TextUtils.isEmpty(ho.d())) {
                requestParams.add("__suid", ho.d());
            }
            if (!TextUtils.isEmpty(ho.e())) {
                requestParams.add("__duid", ho.e());
            }
            requestParams.add("__pf", "android");
            requestParams.add("__chan", "search");
            requestParams.add("__pid", Util.getRawAppName(this.mContext));
            requestParams.add("__psv", Util.getAppVersion(this.mContext));
            requestParams.add("__ver", "1.0.0");
            requestParams.setDebuggable(this.mIsDebuggable);
            HttpProvider.get(this.mContext, str, requestParams, cls, this.mSecretKey, httpResponseListener);
            return;
        }
        if (this.mIsDebuggable) {
            Log.e("search", "wrong parameter");
        }
        if (httpResponseListener != null) {
            httpResponseListener.onFailure(-1, "\u53c2\u6570\u7f3a\u5c11\u5fc5\u8981\u5b57\u6bb5", null);
        }
    }

    public void address2geo(Address2GeoParam address2GeoParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) address2GeoParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.GEOCODER_URL, address2GeoParam, Address2GeoResultObject.class, httpResponseListener);
        }
    }

    public void detail(SearchIDParam searchIDParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) searchIDParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.SEARCH_DETAIL_URL, searchIDParam, SearchDetailResultObject.class, httpResponseListener);
        }
    }

    public void explore(ExploreParam exploreParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) exploreParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.EXPLORE_URL, exploreParam, ExploreResultObject.class, httpResponseListener);
        }
    }

    public void geo2address(Geo2AddressParam geo2AddressParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) geo2AddressParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.GEOCODER_URL, geo2AddressParam, Geo2AddressResultObject.class, httpResponseListener);
        }
    }

    public void getDistanceMatrix(MatrixParam matrixParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) matrixParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.DISTANCE_MATRIX, matrixParam, DistanceMatrixResultObject.class, httpResponseListener);
        }
    }

    public void getDistrictChildren(DistrictChildrenParam districtChildrenParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) districtChildrenParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.DISTRICT_CHILDREN_URL, districtChildrenParam, DistrictResultObject.class, httpResponseListener);
        }
    }

    public void getDistrictList(HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.DISTRICT_LIST_URL, new DistrictChildrenParam(), DistrictResultObject.class, httpResponseListener);
        }
    }

    public void getDistrictSearch(DistrictSearchParam districtSearchParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) districtSearchParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.DISTRICT_SEARCH_URL, districtSearchParam, DistrictResultObject.class, httpResponseListener);
        }
    }

    public void getRoutePlan(RoutePlanningParam routePlanningParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) routePlanningParam, (Object) httpResponseListener);
        } else {
            doHttpGet(routePlanningParam.getUrl(), routePlanningParam, routePlanningParam.getResultClass(), httpResponseListener);
        }
    }

    public void getpano(StreetViewParam streetViewParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) streetViewParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.GETPANO_URL, streetViewParam, StreetViewResultObject.class, httpResponseListener);
        }
    }

    public void search(SearchParam searchParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) searchParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.SEARCH_URL, searchParam, SearchResultObject.class, httpResponseListener);
        }
    }

    public void setDebuggable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mIsDebuggable = z16;
        }
    }

    public void suggestion(SuggestionParam suggestionParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) suggestionParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.SUGGESTOIN_URL, suggestionParam, SuggestionResultObject.class, httpResponseListener);
        }
    }

    public void translate(TranslateParam translateParam, HttpResponseListener httpResponseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) translateParam, (Object) httpResponseListener);
        } else {
            doHttpGet(UrlConstant.TRANSLATE_URL, translateParam, TranslateResultObject.class, httpResponseListener);
        }
    }

    public TencentSearch(Context context, String str) {
        this(context, null, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
    }

    public TencentSearch(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, str, str2);
            return;
        }
        this.mIsDebuggable = false;
        this.mContext = context;
        this.mApiKey = str;
        this.mSecretKey = str2;
        ho.a(context, str, context.getPackageName(), "");
    }
}
