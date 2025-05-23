package com.tencent.mobileqq.config;

import android.content.Intent;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface k {
    boolean a(AppRuntime appRuntime, int[] iArr);

    void b(int[] iArr, FromServiceMsg fromServiceMsg);

    int[] c();

    void d(AppRuntime appRuntime, ConfigurationService$RespGetConfig configurationService$RespGetConfig, Intent intent, int[] iArr, boolean z16);

    void e(AppRuntime appRuntime, List<Integer> list);

    void f(AppRuntime appRuntime, Intent intent, ConfigurationService$ReqGetConfig configurationService$ReqGetConfig, int[] iArr, List<ConfigurationService$ConfigSeq> list, List<Integer> list2, String str);

    void g(AppRuntime appRuntime, ConfigurationService$RespGetConfig configurationService$RespGetConfig, List<Integer> list, Intent intent, int[] iArr, boolean z16);

    void h(ConfigurationService$RespGetConfig configurationService$RespGetConfig);
}
