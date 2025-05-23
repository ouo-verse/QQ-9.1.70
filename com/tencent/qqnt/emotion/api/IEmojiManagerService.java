package com.tencent.qqnt.emotion.api;

import com.tencent.image.JobQueue;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.emotion.manager.c;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes24.dex */
public interface IEmojiManagerService extends IRuntimeService {
    boolean downloadAIOEmoticon(Emoticon emoticon, int i3);

    JobQueue getEmoQueue();

    c getEmojiListenerManager();

    void startDownloadEmosmJson(String str, int i3);

    boolean supportExtensionDisplay(Emoticon emoticon);

    boolean tasksFileExists(Emoticon emoticon, int i3);
}
