package com.tencent.mobileqq.ocr.api;

import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IOCRService extends IRuntimeService {
    void doSougouSearch(String str, String str2, long j3);

    String generateTextSearchSessionID();

    String getAIOText(String str);

    int getConfigVersion();

    OcrConfig getOCRConfig(boolean z16);

    boolean isQZoneSupportOcr(String str);

    boolean isSupportOcr(String str, int i3);

    boolean isSupportOcrAutoTranslate();

    void onGetOCRConfig(boolean z16, OcrConfig ocrConfig);
}
