package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface IAppSettingService extends IBaseService {
    String buildNum() throws NoSuchMethodException;

    int getAppId() throws NoSuchMethodException;

    String getPublishVersionString() throws NoSuchMethodException;

    String getReportVersionName() throws NoSuchMethodException;

    String getSubVersion() throws NoSuchMethodException;

    String getVersion() throws NoSuchMethodException;

    boolean isDebugVersion() throws NoSuchMethodException;

    boolean isGrayVersion() throws NoSuchMethodException;

    boolean isPublicVersion() throws NoSuchMethodException;
}
