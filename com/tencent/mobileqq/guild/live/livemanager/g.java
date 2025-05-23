package com.tencent.mobileqq.guild.live.livemanager;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public interface g {
    long c();

    IQQLiveSDK f();

    LiveData<Boolean> g(@NonNull AppRuntime appRuntime);

    boolean h();

    void i();

    void j(String str, String str2);

    LiveData<Boolean> k();
}
