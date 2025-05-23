package com.qq.e.comm.plugin.base.ad.clickcomponent.c;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static int a(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1720527741:
                if (str.equals("WXNode")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1393893562:
                if (str.equals("InitialNode")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1293773621:
                if (str.equals("QQMiniGameNode")) {
                    c16 = 2;
                    break;
                }
                break;
            case -930106646:
                if (str.equals("NoClickReportInterceptor")) {
                    c16 = 3;
                    break;
                }
                break;
            case -837520695:
                if (str.equals("CanvasPageNode")) {
                    c16 = 4;
                    break;
                }
                break;
            case -201922427:
                if (str.equals("WebPageNode")) {
                    c16 = 5;
                    break;
                }
                break;
            case 164919403:
                if (str.equals("DirectLauncherNode")) {
                    c16 = 6;
                    break;
                }
                break;
            case 487624282:
                if (str.equals("C2SReportNode")) {
                    c16 = 7;
                    break;
                }
                break;
            case 958446410:
                if (str.equals("AppInstallationStateReport")) {
                    c16 = '\b';
                    break;
                }
                break;
            case 1005595233:
                if (str.equals("VideoFormNode")) {
                    c16 = '\t';
                    break;
                }
                break;
            case 1255090027:
                if (str.equals("AppDownLoadNode")) {
                    c16 = '\n';
                    break;
                }
                break;
            case 1435724807:
                if (str.equals("CGINode")) {
                    c16 = 11;
                    break;
                }
                break;
            case 2131256232:
                if (str.equals("InvalidParamsInterceptor")) {
                    c16 = '\f';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 7;
            case 1:
                return 3;
            case 2:
                return 5;
            case 3:
                return 2;
            case 4:
                return 10;
            case 5:
                return 11;
            case 6:
                return 6;
            case 7:
                return 13;
            case '\b':
                return 4;
            case '\t':
                return 9;
            case '\n':
                return 8;
            case 11:
                return 12;
            case '\f':
                return 1;
            default:
                return 0;
        }
    }
}
