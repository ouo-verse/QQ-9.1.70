package com.tencent.mobileqq.icgame.api.heart;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.data.heart.FloatHeart;
import ji2.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IQQLiveFloatHeartService extends IQQLiveModule {
    void addOnReceiveFloatHeartListener(a aVar);

    void removeOnReceiveFloatHeartListener(a aVar);

    void sendFloatHeart(FloatHeart floatHeart);

    void sendFloatHeartEnd();
}
