package com.tencent.comic.api;

import com.tencent.comic.api.plugin.b;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {"", "tool"})
/* loaded from: classes5.dex */
public interface IQQPluginPreloadService extends IRuntimeService {
    void preload(int i3);

    void preload(int i3, int i16);

    void preload(b bVar, int i3);
}
