package com.tencent.comic.api;

import android.app.Application;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"", "tool"})
/* loaded from: classes5.dex */
public interface IQQComicService extends IRuntimeService {
    void beforeLaunchPlugin();

    AppRuntime createComicRuntime(Application application, String str);

    void startUp();
}
