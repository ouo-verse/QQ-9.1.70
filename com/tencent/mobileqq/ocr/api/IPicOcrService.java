package com.tencent.mobileqq.ocr.api;

import com.tencent.mobileqq.gallery.picocr.c;
import com.tencent.mobileqq.ocr.req.a;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IPicOcrService extends IRuntimeService {
    void putOcrResult(String str, c cVar);

    void requestOcr(a aVar, com.tencent.mobileqq.gallery.picocr.a aVar2);
}
