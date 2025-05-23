package com.tencent.mobileqq.uftransfer.task.utils;

import android.util.SparseIntArray;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f305665a;

    /* renamed from: b, reason: collision with root package name */
    private static final SparseIntArray f305666b;

    /* renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f305667c;

    /* renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f305668d;

    /* renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f305669e;

    /* renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f305670f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42750);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        f305665a = sparseIntArray;
        sparseIntArray.put(0, 0);
        sparseIntArray.put(1, 9004);
        sparseIntArray.put(2, 9004);
        sparseIntArray.put(3, 9045);
        sparseIntArray.put(4, 9052);
        sparseIntArray.put(5, FileMsg.RESULT_CODE_HTTP_SERVER_OTHER);
        sparseIntArray.put(6, 9052);
        sparseIntArray.put(7, 9005);
        sparseIntArray.put(8, 9003);
        sparseIntArray.put(9, 4606);
        sparseIntArray.put(10, 4606);
        sparseIntArray.put(11, 9001);
        sparseIntArray.put(12, 9052);
        sparseIntArray.put(13, 9009);
        sparseIntArray.put(16, 9009);
        sparseIntArray.put(14, FileMsg.RESULT_CODE_HTTP_SERVER_OTHER);
        sparseIntArray.put(15, FileMsg.RESULT_CODE_HTTP_SERVER_OTHER);
        sparseIntArray.put(17, 9001);
        sparseIntArray.put(18, 9052);
        sparseIntArray.put(19, 9001);
        sparseIntArray.put(20, 9001);
        sparseIntArray.put(30, FileMsg.RESULT_CODE_MSF_TIMEOUT);
        sparseIntArray.put(31, 9006);
        sparseIntArray.put(32, 9042);
        sparseIntArray.put(33, AppConstants.RichMediaErrorCode.ERROR_USER_CANCEL);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f305666b = sparseIntArray2;
        sparseIntArray2.put(0, 0);
        sparseIntArray2.put(1, 3);
        sparseIntArray2.put(2, 9);
        sparseIntArray2.put(3, 3);
        sparseIntArray2.put(4, 3);
        sparseIntArray2.put(5, 3);
        sparseIntArray2.put(6, 3);
        sparseIntArray2.put(10, 3);
        sparseIntArray2.put(12, 3);
        sparseIntArray2.put(13, 3);
        sparseIntArray2.put(14, 3);
        sparseIntArray2.put(15, 3);
        sparseIntArray2.put(16, 3);
        sparseIntArray2.put(18, 3);
        sparseIntArray2.put(9, 4);
        sparseIntArray2.put(19, 4);
        sparseIntArray2.put(20, 4);
        sparseIntArray2.put(17, 9);
        sparseIntArray2.put(11, 9);
        sparseIntArray2.put(7, 10);
        sparseIntArray2.put(8, 7);
        sparseIntArray2.put(30, 2);
        sparseIntArray2.put(31, 1);
        sparseIntArray2.put(32, 5);
        sparseIntArray2.put(33, 8);
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        f305667c = sparseIntArray3;
        sparseIntArray3.put(0, 0);
        sparseIntArray3.put(1, 307);
        sparseIntArray3.put(2, 901);
        sparseIntArray3.put(3, 300);
        sparseIntArray3.put(4, 307);
        sparseIntArray3.put(5, 309);
        sparseIntArray3.put(6, 308);
        sparseIntArray3.put(7, 10);
        sparseIntArray3.put(8, 707);
        sparseIntArray3.put(9, 4);
        sparseIntArray3.put(10, 4);
        sparseIntArray3.put(11, 9);
        sparseIntArray3.put(12, 309);
        sparseIntArray3.put(13, 312);
        sparseIntArray3.put(14, 309);
        sparseIntArray3.put(15, 309);
        sparseIntArray3.put(16, 300);
        sparseIntArray3.put(17, 905);
        sparseIntArray3.put(18, 307);
        sparseIntArray3.put(19, 4);
        sparseIntArray3.put(20, 4);
        sparseIntArray3.put(30, 2);
        sparseIntArray3.put(31, 103);
        sparseIntArray3.put(32, 503);
        sparseIntArray3.put(33, 8);
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        f305668d = sparseIntArray4;
        sparseIntArray4.put(0, 0);
        sparseIntArray4.put(1, 106);
        sparseIntArray4.put(2, 106);
        sparseIntArray4.put(3, 1);
        sparseIntArray4.put(4, 1);
        sparseIntArray4.put(5, 1);
        sparseIntArray4.put(6, 1);
        sparseIntArray4.put(7, 102);
        sparseIntArray4.put(8, 203);
        sparseIntArray4.put(9, 1);
        sparseIntArray4.put(10, 1);
        sparseIntArray4.put(11, 102);
        sparseIntArray4.put(12, 1);
        sparseIntArray4.put(13, 1);
        sparseIntArray4.put(14, 1);
        sparseIntArray4.put(15, 1);
        sparseIntArray4.put(16, 1);
        sparseIntArray4.put(17, 1);
        sparseIntArray4.put(18, 1);
        sparseIntArray4.put(19, 1);
        sparseIntArray4.put(20, 1);
        sparseIntArray4.put(30, 103);
        sparseIntArray4.put(31, 103);
        sparseIntArray4.put(32, 102);
        sparseIntArray4.put(33, 1);
        SparseIntArray sparseIntArray5 = new SparseIntArray();
        f305669e = sparseIntArray5;
        sparseIntArray5.put(0, 0);
        sparseIntArray5.put(1, 100);
        sparseIntArray5.put(2, 7);
        sparseIntArray5.put(3, -97);
        sparseIntArray5.put(4, 101);
        sparseIntArray5.put(5, 101);
        sparseIntArray5.put(6, 101);
        sparseIntArray5.put(7, 112);
        sparseIntArray5.put(8, 6);
        sparseIntArray5.put(9, 104);
        sparseIntArray5.put(10, 104);
        sparseIntArray5.put(11, 112);
        sparseIntArray5.put(12, 101);
        sparseIntArray5.put(13, 111);
        sparseIntArray5.put(14, 101);
        sparseIntArray5.put(15, 101);
        sparseIntArray5.put(16, 101);
        sparseIntArray5.put(17, 112);
        sparseIntArray5.put(18, 101);
        sparseIntArray5.put(19, 101);
        sparseIntArray5.put(20, 101);
        sparseIntArray5.put(30, 101);
        sparseIntArray5.put(31, 101);
        sparseIntArray5.put(32, 6);
        sparseIntArray5.put(33, 112);
        SparseIntArray sparseIntArray6 = new SparseIntArray();
        f305670f = sparseIntArray6;
        sparseIntArray6.put(0, 0);
        sparseIntArray6.put(1, 31);
        sparseIntArray6.put(100, 31);
        sparseIntArray6.put(101, 31);
        sparseIntArray6.put(102, 31);
        sparseIntArray6.put(2, 30);
        sparseIntArray6.put(3, 5);
        sparseIntArray6.put(300, 5);
        sparseIntArray6.put(301, 5);
        sparseIntArray6.put(302, 5);
        sparseIntArray6.put(303, 5);
        sparseIntArray6.put(304, 5);
        sparseIntArray6.put(305, 5);
        sparseIntArray6.put(313, 5);
        sparseIntArray6.put(309, 5);
        sparseIntArray6.put(306, 2);
        sparseIntArray6.put(901, 2);
        sparseIntArray6.put(4, 1);
        sparseIntArray6.put(307, 1);
        sparseIntArray6.put(308, 1);
        sparseIntArray6.put(312, 13);
        sparseIntArray6.put(5, 32);
        sparseIntArray6.put(501, 32);
        sparseIntArray6.put(502, 32);
        sparseIntArray6.put(503, 32);
        sparseIntArray6.put(504, 32);
        sparseIntArray6.put(701, 32);
        sparseIntArray6.put(702, 32);
        sparseIntArray6.put(7, 11);
        sparseIntArray6.put(700, 11);
        sparseIntArray6.put(703, 11);
        sparseIntArray6.put(704, 11);
        sparseIntArray6.put(707, 8);
        sparseIntArray6.put(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK, 8);
        sparseIntArray6.put(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES, 8);
        sparseIntArray6.put(710, 8);
        sparseIntArray6.put(8, 33);
        sparseIntArray6.put(9, 17);
        sparseIntArray6.put(902, 17);
        sparseIntArray6.put(904, 17);
        sparseIntArray6.put(10, 7);
        sparseIntArray6.put(11, 11);
        sparseIntArray6.put(12, 11);
    }

    public static int a(int i3) {
        return f305670f.get(i3, i3);
    }

    public static int b(int i3) {
        return f305665a.get(i3, i3);
    }

    public static int c(int i3) {
        return f305666b.get(i3, i3);
    }

    public static int d(int i3) {
        return f305669e.get(i3, i3);
    }

    public static int e(int i3) {
        return f305667c.get(i3, i3);
    }

    public static int f(int i3) {
        return f305668d.get(i3, i3);
    }
}
