package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface IRemoteConfigService extends IBaseService {
    boolean getBoolean(String str, String str2, boolean z16) throws NoSuchMethodException;

    float getFloat(String str, String str2, float f16) throws NoSuchMethodException;

    int getInt(String str, String str2, int i3) throws NoSuchMethodException;

    long getLong(String str, String str2, long j3) throws NoSuchMethodException;

    String getString(String str, String str2, String str3) throws NoSuchMethodException;

    boolean isSwitchOn(String str, boolean z16) throws NoSuchMethodException;
}
