package com.tencent.tedger.outapi.beans;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static String a(long j3) {
        if (j3 == 0) {
            return FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
        }
        if (j3 == -100) {
            return "\u8fd4\u56de\u6570\u636e\u4e0d\u5408\u6cd5";
        }
        if (j3 == -101) {
            return "\u884c\u4e3a\u6570\u636e\u4e3a\u7a7a";
        }
        if (j3 == -102) {
            return "\u672a\u66dd\u5149feed\u5217\u8868\u4e3a\u7a7a";
        }
        if (j3 == -103) {
            return "\u5f00\u542f\u91cd\u6392\u5931\u8d25";
        }
        if (j3 == -108) {
            return "\u83b7\u53d6\u7528\u6237\u4fe1\u606f\u9519\u8bef";
        }
        if (j3 == -109) {
            return "\u83b7\u53d6\u7528\u6237\u6837\u672c\u4fe1\u606f\u9519\u8bef";
        }
        if (j3 == -104) {
            return "\u7aef\u6392\u73af\u5883\u6ca1\u6709\u521d\u59cb\u5316\u597d";
        }
        if (j3 == -105) {
            return "\u7aef\u6392\u63d0\u53d6\u7279\u5f81\u5931\u8d25";
        }
        if (j3 == -106) {
            return "\u63a8\u7406\u5931\u8d25";
        }
        if (j3 == -107) {
            return "\u63a8\u7406\u540e\u91cd\u6392\u5931\u8d25";
        }
        if (j3 == -110) {
            return "SDK\u5b58\u5728\u4e92\u65a5\u4efb\u52a1";
        }
        if (j3 == -999) {
            return "\u53c2\u6570\u975e\u6cd5";
        }
        if (j3 == -111) {
            return "\u914d\u7f6e\u672a\u6253\u5f00";
        }
        if (j3 == -112) {
            return "\u4e91\u7aef\u8fd4\u56de\u5217\u8868\u4e3a\u7a7a";
        }
        if (j3 == -113) {
            return "\u4e91\u7aef\u8fd4\u56de\u8d85\u65f6";
        }
        if (j3 == -114) {
            return "SDK\u5d29\u6e83";
        }
        if (j3 == -115) {
            return "\u8d85\u8fc7\u6700\u5927\u91cd\u8bd5\u6b21\u6570";
        }
        if (j3 == -888) {
            return "SDK\u5df2\u9500\u6bc1";
        }
        return WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN;
    }
}
