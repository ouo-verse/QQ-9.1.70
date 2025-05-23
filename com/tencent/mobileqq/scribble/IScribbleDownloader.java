package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes18.dex */
public interface IScribbleDownloader extends IRuntimeService {
    void DownloadFromAio(MessageForScribble messageForScribble);

    void PreDownloadFromMsg(MessageForScribble messageForScribble);

    void checkBDHsessionkey();

    void off();

    void on();

    int removeDownloadedMsg(MessageForScribble messageForScribble);
}
