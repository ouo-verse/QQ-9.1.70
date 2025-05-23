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
public class b implements k {
    @Override // com.tencent.mobileqq.config.k
    public boolean a(AppRuntime appRuntime, int[] iArr) {
        return false;
    }

    @Override // com.tencent.mobileqq.config.k
    public int[] c() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.config.k
    public void h(ConfigurationService$RespGetConfig configurationService$RespGetConfig) {
    }

    @Override // com.tencent.mobileqq.config.k
    public void b(int[] iArr, FromServiceMsg fromServiceMsg) {
    }

    @Override // com.tencent.mobileqq.config.k
    public void e(AppRuntime appRuntime, List<Integer> list) {
    }

    @Override // com.tencent.mobileqq.config.k
    public void d(AppRuntime appRuntime, ConfigurationService$RespGetConfig configurationService$RespGetConfig, Intent intent, int[] iArr, boolean z16) {
    }

    @Override // com.tencent.mobileqq.config.k
    public void f(AppRuntime appRuntime, Intent intent, ConfigurationService$ReqGetConfig configurationService$ReqGetConfig, int[] iArr, List<ConfigurationService$ConfigSeq> list, List<Integer> list2, String str) {
    }

    @Override // com.tencent.mobileqq.config.k
    public void g(AppRuntime appRuntime, ConfigurationService$RespGetConfig configurationService$RespGetConfig, List<Integer> list, Intent intent, int[] iArr, boolean z16) {
    }
}
