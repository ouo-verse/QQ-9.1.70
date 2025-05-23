package com.tencent.mobileqq.stt.sub.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes18.dex */
public interface IVideoSubtitleManager extends IRuntimeService {
    void getVideoSubtitle(MessageRecord messageRecord, String str, String str2, int i3, a aVar);

    void getVideoSubtitle(String str, int i3, long j3, String str2, String str3, int i16, a aVar);

    boolean isCacheDisabled();

    boolean isSkipQueryServerCache();

    void setCacheDisabled(boolean z16);

    void setSkipQueryServerCache(boolean z16);
}
