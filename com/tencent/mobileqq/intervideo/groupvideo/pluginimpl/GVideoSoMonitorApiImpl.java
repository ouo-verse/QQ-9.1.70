package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IGVideoSoMonitorApi;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GVideoSoMonitorApiImpl implements IGVideoSoMonitorApi {
    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IGVideoSoMonitorApi
    public boolean isSoFileLegal(File file) {
        return ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).isSoFileLegal(BaseApplication.context.getBaseContext(), file);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IGVideoSoMonitorApi
    public boolean isSoFileRegistered(File file) {
        return ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).isSoFileRegistered(BaseApplication.context.getBaseContext(), file);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IGVideoSoMonitorApi
    public boolean isSoPathLegal(String str) {
        return ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).isSoPathLegal(BaseApplication.context.getBaseContext(), str);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IGVideoSoMonitorApi
    public boolean isSoPathRegistered(String str) {
        return ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).isSoPathRegistered(BaseApplication.context.getBaseContext(), str);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IGVideoSoMonitorApi
    public void registerSoFile(File file) {
        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(BaseApplication.context.getBaseContext(), file);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IGVideoSoMonitorApi
    public void registerSoFilePath(String str) {
        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(BaseApplication.context.getBaseContext(), str);
    }
}
