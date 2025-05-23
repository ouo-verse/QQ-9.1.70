package com.tencent.comic.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"", "tool"})
/* loaded from: classes5.dex */
public interface IQQComicEmoticonService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(Bundle bundle);
    }

    void uploadComicEmoticon(Bundle bundle, a aVar);
}
