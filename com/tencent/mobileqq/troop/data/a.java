package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(int i3) {
        if (i3 != 8 && i3 != 10 && i3 != 9) {
            return false;
        }
        return true;
    }

    public static boolean b(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    public static String c(int i3) {
        switch (i3) {
            case 0:
                return "SCANNING";
            case 1:
                return "UPLOADING";
            case 2:
                return "UPLOAD_SUSPEND";
            case 3:
                return "UPLOAD_INTERRUPT";
            case 4:
                return "FORWARDING";
            case 5:
                return "FORWARD_FAILED";
            case 6:
                return "UPLOADED";
            case 7:
                return "NOT_DOWNLOAD";
            case 8:
                return "DOWNLOADING";
            case 9:
                return "DOWNLOAD_SUSPEND";
            case 10:
                return "DOWNLOAD_INTERRUPT";
            case 11:
                return "DOWNLOADED";
            case 12:
                return "DELETED";
            case 13:
                return "OTHER_UPLOADING";
            default:
                return "";
        }
    }

    public static int d(String str) {
        if (str.equals("SCANNING")) {
            return 0;
        }
        if (str.equals("UPLOADING")) {
            return 1;
        }
        if (str.equals("UPLOAD_SUSPEND")) {
            return 2;
        }
        if (str.equals("UPLOAD_INTERRUPT")) {
            return 3;
        }
        if (str.equals("FORWARDING")) {
            return 4;
        }
        if (str.equals("FORWARD_FAILED")) {
            return 5;
        }
        if (str.equals("UPLOADED")) {
            return 6;
        }
        if (str.equals("NOT_DOWNLOAD")) {
            return 7;
        }
        if (str.equals("DOWNLOADING")) {
            return 8;
        }
        if (str.equals("DOWNLOAD_SUSPEND")) {
            return 9;
        }
        if (str.equals("DOWNLOAD_INTERRUPT")) {
            return 10;
        }
        if (str.equals("DOWNLOADED")) {
            return 11;
        }
        if (str.equals("DELETED")) {
            return 12;
        }
        if (str.equals("OTHER_UPLOADING")) {
            return 13;
        }
        return -1;
    }
}
