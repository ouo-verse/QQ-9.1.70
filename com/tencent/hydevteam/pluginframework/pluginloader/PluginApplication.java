package com.tencent.hydevteam.pluginframework.pluginloader;

import com.tencent.hydevteam.common.annotation.API;
import java.util.Set;

@API
/* loaded from: classes7.dex */
public interface PluginApplication {
    @API
    void onPluginLoaded(String str, Set<String> set);
}
