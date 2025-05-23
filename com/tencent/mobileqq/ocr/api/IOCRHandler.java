package com.tencent.mobileqq.ocr.api;

import com.tencent.mobileqq.app.IBusinessHandler;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes16.dex */
public interface IOCRHandler extends IBusinessHandler, IRuntimeService {
    void batchTranslate(String str, String str2, String str3);

    String getClassName();

    boolean getUSING_TEST_SERVERT();

    void setUSING_TEST_SERVERT(boolean z16);
}
