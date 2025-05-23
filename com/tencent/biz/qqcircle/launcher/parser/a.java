package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a {
    private void a(QCircleSchemeBean qCircleSchemeBean, QCircleInitBean qCircleInitBean) {
        if (!qCircleSchemeBean.getAttrs().containsKey(QCircleSchemeAttr.PolymerizeDetail.FPAGE_ID)) {
            return;
        }
        String str = qCircleSchemeBean.getAttrs().get(QCircleSchemeAttr.PolymerizeDetail.FPAGE_ID);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QCircleReportBean qCircleReportBean = new QCircleReportBean();
        qCircleReportBean.setPageId(Integer.parseInt(str));
        qCircleInitBean.setFromReportBean(qCircleReportBean);
    }

    private void c(QCircleInitBean qCircleInitBean, HashMap<String, String> hashMap) {
        String str = hashMap.get("xsj_main_entrance");
        if ("searchbar_entrance".equals(hashMap.get("xsj_sub_entrance"))) {
            qCircleInitBean.setIsMiddlePage(false);
        }
        if (str == null) {
            qCircleInitBean.setIsMiddlePage(false);
        }
    }

    private boolean d(HashMap<String, String> hashMap) {
        if (hashMap == null || !hashMap.containsKey(QCircleSchemeAttr.PolymerizeDetail.FEED_HIDE_BOTTOMBAR)) {
            return false;
        }
        return true;
    }

    private boolean e(HashMap<String, String> hashMap) {
        if (!hashMap.containsKey("getfeedlist")) {
            if (hashMap.containsKey(QCircleReportFirstLogin.SHARE_ENTRANCE) && !TextUtils.equals(hashMap.get(QCircleReportFirstLogin.SHARE_ENTRANCE), "0") && hashMap.containsKey(QCircleReportFirstLogin.SHARE_CATEGORY) && !TextUtils.equals(hashMap.get(QCircleReportFirstLogin.SHARE_CATEGORY), "0")) {
                return true;
            }
            if (hashMap.containsKey(QCircleSchemeAttr.PolymerizeDetail.SHOW_HOME_BTN) && !TextUtils.equals(hashMap.get(QCircleSchemeAttr.PolymerizeDetail.SHOW_HOME_BTN), "0")) {
                return true;
            }
        }
        if (hashMap.containsKey(QCircleSchemeAttr.Detail.IS_MIDDLE_PAGE) && !TextUtils.equals(hashMap.get(QCircleSchemeAttr.Detail.IS_MIDDLE_PAGE), "0")) {
            return true;
        }
        return false;
    }

    private String g(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 51:
                if (str.equals("3")) {
                    c16 = 0;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c16 = 1;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1602:
                if (str.equals("24")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return "3";
            case 1:
                return "4";
            case 2:
                return "5";
            case 3:
                return "12";
            case 4:
                return "11";
            default:
                return "8";
        }
    }

    private String h(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 51:
                if (str.equals("3")) {
                    c16 = 0;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c16 = 1;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1602:
                if (str.equals("24")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 1:
            default:
                return "0";
            case 2:
                return "1";
            case 3:
            case 4:
                return "4";
        }
    }

    private String k(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c16 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c16 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c16 = 2;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c16 = 3;
                    break;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    c16 = 4;
                    break;
                }
                break;
            case 56:
                if (str.equals("8")) {
                    c16 = 5;
                    break;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    c16 = 6;
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c16 = 7;
                    break;
                }
                break;
            case 48690:
                if (str.equals(com.tencent.mobileqq.msf.core.auth.e.f247445e)) {
                    c16 = '\b';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return "12";
            case 1:
            case 5:
                return "13";
            case 2:
                return "1";
            case 3:
                return "14";
            case 4:
                return "6";
            case 6:
            case 7:
                return "11";
            case '\b':
                return com.tencent.mobileqq.msf.core.auth.e.f247445e;
            default:
                return str;
        }
    }

    private String l(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        if (!str2.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_MAIN_PAGE) && !str2.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_SHARE_MAIN_PAGE)) {
            if (!str2.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_CONTENT_DETAIL) && !str2.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_SHARE_CONTENT_DETAIL)) {
                if (!str2.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_TAG_PAGE)) {
                    if (str2.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_PYMK_PAGE)) {
                        return "4";
                    }
                    if (!str2.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_SEARCH)) {
                        return str;
                    }
                }
                return "3";
            }
            return "2";
        }
        return "1";
    }

    private void m(QCircleInitBean qCircleInitBean, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        qCircleInitBean.setIsMiddlePage(e(hashMap));
        c(qCircleInitBean, hashMap);
    }

    private void n(QCircleInitBean qCircleInitBean, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        qCircleInitBean.setNeedHideBottomCommentBtn(d(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(QCircleSchemeBean qCircleSchemeBean, QCircleInitBean qCircleInitBean) {
        if (qCircleSchemeBean != null && qCircleInitBean != null) {
            qCircleInitBean.setAction(qCircleSchemeBean.getSchemeAction());
            qCircleInitBean.setSchemeAttrs(qCircleSchemeBean.getAttrs());
            qCircleInitBean.setSchemeBytes(qCircleSchemeBean.getByteAttrs());
            qCircleInitBean.setSourceIds(qCircleSchemeBean.getSourceIds());
            qCircleInitBean.setEnterTime(qCircleSchemeBean.getEnterTime());
            a(qCircleSchemeBean, qCircleInitBean);
        }
    }

    public abstract void f(Context context, QCircleSchemeBean qCircleSchemeBean);

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(QCircleInitBean qCircleInitBean, HashMap<String, String> hashMap) {
        String str;
        if (qCircleInitBean != null && hashMap != null) {
            String str2 = hashMap.get("key_jump_from");
            String str3 = hashMap.get(QCircleReportFirstLogin.SHARE_CATEGORY);
            String str4 = hashMap.get(QCircleReportFirstLogin.SHARE_ENTRANCE);
            if (str3 != null && str4 != null) {
                str = k(str4);
            } else if (str2 != null) {
                str = g(str2);
                str3 = h(str2);
            } else {
                str2 = hashMap.get("from");
                if ("10".equals(str2)) {
                    str3 = "0";
                    str = "10";
                } else {
                    str = "";
                    if (!"1".equals(str2)) {
                        str3 = "";
                    } else {
                        str3 = l("", hashMap.get("key_scheme"));
                        str = "1";
                    }
                }
            }
            if ("3".equals(str2) || "4".equals(str2) || "10".equals(str2) || (TextUtils.equals(str, "6") && TextUtils.equals(str3, "1"))) {
                qCircleInitBean.setEnableSplash(true);
            }
            qCircleInitBean.setLaunchFrom(str);
            qCircleInitBean.setLaunchId(str3);
            qCircleInitBean.setSchemeAttrs(hashMap);
            m(qCircleInitBean, hashMap);
            n(qCircleInitBean, hashMap);
            return;
        }
        QLog.e("QCircleBaseSchemeParser", 1, "parseLaunchFromParam failed!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(QCircleInitBean qCircleInitBean, HashMap<String, String> hashMap) {
        if (qCircleInitBean != null && hashMap != null) {
            if (hashMap.containsKey("pushid")) {
                qCircleInitBean.setLaunchId(hashMap.get("pushid"));
                return;
            }
            return;
        }
        QLog.e("QCircleBaseSchemeParser", 1, "parsePushIdParam failed!");
    }
}
