package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ConfigSeq;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class v {
    public static void a(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        nn2.a.f420531b = qQAppInterface.getCurrentAccountUin();
        int i3 = configurationService$Config.version.get();
        int h16 = nn2.a.h(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin());
        QLog.i("search_manager_configSearchConfigServlet", 1, "handleSearchNetEntryConfig, version: " + i3 + " localVersion: " + h16);
        if (i3 == h16) {
            return;
        }
        nn2.a.n(qQAppInterface.getApp(), i3, qQAppInterface.getCurrentAccountUin());
        nn2.a.m(qQAppInterface.getApp(), configurationService$Config, qQAppInterface.getCurrentUin());
    }

    public static void b(QQAppInterface qQAppInterface, ConfigurationService$ConfigSeq configurationService$ConfigSeq) {
        int h16 = nn2.a.h(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin());
        configurationService$ConfigSeq.version.set(h16);
        QLog.i("search_manager_configSearchConfigServlet", 1, "onGetSearchEntryConfig v=" + h16);
    }

    public static void c(ConfigurationService$ConfigSeq configurationService$ConfigSeq) {
        int l3 = w.l();
        configurationService$ConfigSeq.version.set(l3);
        QLog.i("search_manager_configSearchConfigServlet", 1, "onGetSearchUrlSearchConfig v=" + l3);
    }
}
