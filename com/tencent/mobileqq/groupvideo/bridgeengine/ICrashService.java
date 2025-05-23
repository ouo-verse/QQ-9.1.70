package com.tencent.mobileqq.groupvideo.bridgeengine;

import android.content.Context;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface ICrashService extends IBaseService {
    void d(String str, String str2) throws NoSuchMethodException;

    void e(String str, String str2) throws NoSuchMethodException;

    void e(String str, String str2, Throwable th5) throws NoSuchMethodException;

    void i(String str, String str2) throws NoSuchMethodException;

    void postCatchedException(Throwable th5) throws NoSuchMethodException;

    void putUserData(Context context, String str, String str2) throws NoSuchMethodException;

    void v(String str, String str2) throws NoSuchMethodException;

    void w(String str, String str2) throws NoSuchMethodException;
}
