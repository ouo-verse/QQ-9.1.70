package com.tencent.mobileqq.search.util;

import android.app.Activity;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchDaTongApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static long f285092a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static String f285093b = "";

    public static void a(View view, int i3) {
        VideoReport.setPageParams(view, "search_result_source", String.valueOf(i3));
    }

    public static void b(View view, List<com.tencent.mobileqq.search.model.v> list) {
        if (view != null && list != null && !list.isEmpty()) {
            com.tencent.mobileqq.search.model.v vVar = list.get(list.size() - 1);
            if ((vVar instanceof lo2.m) && ((lo2.m) vVar).P()) {
                VideoReport.setElementId(view, "em_result_node");
                VideoReport.setElementParam(view, "result_node_position", "0");
                VideoReport.setElementParam(view, "result_display_type", "1");
                VideoReport.setElementParam(view, "search_node_type", String.valueOf(21));
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
                VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
                VideoReport.reportEvent("imp", view, null);
                VideoReport.resetElementParams(view);
            }
        }
    }

    public static Map<String, String> c(com.tencent.mobileqq.search.model.v vVar) {
        if (vVar instanceof com.tencent.mobileqq.search.model.z) {
            return ((com.tencent.mobileqq.search.model.z) vVar).y();
        }
        return null;
    }

    public static String d(com.tencent.mobileqq.search.model.v vVar) {
        return ((ISearchDaTongApi) QRoute.api(ISearchDaTongApi.class)).getDisplayType(vVar);
    }

    public static String e(com.tencent.mobileqq.search.model.v vVar) {
        if (vVar instanceof com.tencent.mobileqq.search.model.z) {
            int x16 = ((com.tencent.mobileqq.search.model.z) vVar).x();
            if (x16 == 6) {
                return "1";
            }
            if (x16 == 7) {
                return "2";
            }
            if (x16 == 13) {
                return "3";
            }
            if (x16 == 16) {
                return "6";
            }
            if (x16 == 15) {
                return ((ISearchDaTongApi) QRoute.api(ISearchDaTongApi.class)).getFavoritDocType(vVar);
            }
            if (x16 == 9) {
                return "20";
            }
            if (x16 == 11) {
                return "21";
            }
            if (x16 == 14) {
                return "22";
            }
            if (x16 == 17) {
                return "23";
            }
            if (x16 == 18) {
                return "15";
            }
            if (x16 == 22) {
                return "17";
            }
            if (x16 == 23) {
                return "25";
            }
            if (x16 == 24) {
                return "31";
            }
            if (x16 == 25) {
                return "32";
            }
            if (x16 == 26) {
                return WadlProxyConsts.OPER_TYPE_APK_SIGN;
            }
            if (x16 == 27) {
                return WadlProxyConsts.OPER_TYPE_MONITOR;
            }
            return "24";
        }
        return "24";
    }

    private static String f(int i3) {
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return "4";
        }
        return String.valueOf(i3);
    }

    public static JSONObject g(com.tencent.mobileqq.search.model.v vVar) {
        try {
            if (vVar instanceof com.tencent.mobileqq.search.model.z) {
                return ((com.tencent.mobileqq.search.model.z) vVar).A();
            }
            return null;
        } catch (Exception e16) {
            QLog.d("SearchDaTong", 1, "getExtraInfo " + e16);
            return null;
        }
    }

    public static String h(com.tencent.mobileqq.search.model.v vVar) {
        int i3;
        if (vVar instanceof com.tencent.mobileqq.search.model.x) {
            i3 = ((com.tencent.mobileqq.search.model.x) vVar).k();
        } else if (vVar instanceof com.tencent.mobileqq.search.model.z) {
            i3 = ((com.tencent.mobileqq.search.model.z) vVar).x();
        } else {
            i3 = 0;
        }
        return String.valueOf(i3);
    }

    public static String i(Object obj) {
        if (obj == null) {
            return "3";
        }
        int searchHistoryType = ((ISearchDaTongApi) QRoute.api(ISearchDaTongApi.class)).getSearchHistoryType(obj);
        if (searchHistoryType != 0) {
            if (searchHistoryType != 1) {
                if (searchHistoryType != 3 && searchHistoryType != 1000) {
                    switch (searchHistoryType) {
                        case 10023:
                            return "4";
                        case 10024:
                            return "5";
                        case 10025:
                            return "6";
                        default:
                            return "3";
                    }
                }
            } else {
                return "2";
            }
        }
        return "1";
    }

    public static String j(int i3) {
        switch (i3) {
            case 101:
                return "2";
            case 102:
                return "4";
            case 103:
                return "3";
            case 104:
                return "1";
            case 105:
                return "5";
            case 106:
                return "7";
            case 107:
                return "8";
            default:
                return "6";
        }
    }

    public static String k() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f285092a > 2000) {
            f285093b = UUID.randomUUID().toString();
        }
        f285092a = currentTimeMillis;
        return f285093b;
    }

    public static void l(Activity activity, View view, int i3) {
        if (activity != null && view != null) {
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(view, "pg_search_activation");
            HashMap hashMap = new HashMap();
            hashMap.put("source_entrance_type", f(i3));
            hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
            VideoReport.setPageParams(view, new PageParams(hashMap));
        }
    }

    public static void m(Activity activity, View view, int i3, String str, String str2, int i16) {
        if (activity != null && view != null) {
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(view, "pg_search_result");
            VideoReport.setPageParams(view, "source_entrance_type", f(i3));
            VideoReport.setPageParams(view, "search_trace_id", str);
            VideoReport.setPageParams(view, "search_query_text", str2);
            VideoReport.setPageParams(view, "result_source_type", String.valueOf(i16));
            QLog.i("SearchDaTong", 1, "setResultPageParam resultSourceType=" + i16 + ",text=" + cq.w(str2, 2) + ",source=" + i3);
        }
    }

    public static void n(Activity activity, View view) {
        if (activity != null && view != null) {
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(view, "pg_search_activation_setting");
            VideoReport.setElementId(view, "em_bas_search_setup_panel");
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }
}
