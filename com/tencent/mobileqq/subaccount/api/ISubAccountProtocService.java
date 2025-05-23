package com.tencent.mobileqq.subaccount.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {""})
/* loaded from: classes18.dex */
public interface ISubAccountProtocService extends IRuntimeService {
    void bindAccount(String str, String str2, String str3);

    void getBindAccount();

    boolean getBindAccountFinish();

    void unBindAccount(String str);
}
