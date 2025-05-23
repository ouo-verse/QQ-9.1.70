package com.tencent.qq.effect;

import android.content.Context;
import com.tencent.qq.effect.engine.QEffectData;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IQEffect<T extends QEffectData, K> {
    void complete(K k3);

    boolean isGravityEnable();

    void load(Context context, QEffectView qEffectView, IQEffectLoad iQEffectLoad, T t16);

    void pause();

    void play();

    void resume();

    void stop();
}
