package com.tencent.mobileqq.stt;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes18.dex */
public interface ISttManagerService extends IRuntimeService {
    boolean isTranslating(MessageForPtt messageForPtt);

    boolean needAuotoChange(MessageForPtt messageForPtt);

    void onSttResultPush(byte[] bArr);

    Long queryVideoSubtitle(String str, String str2, int i3, String str3, a aVar);

    void setListener(a aVar);

    Long translate(MessageForPtt messageForPtt, int i3);

    Long translate(MessageForPtt messageForPtt, int i3, a aVar);

    Long translateVideoSubtitle(MessageForPtt messageForPtt, String str, a aVar);
}
