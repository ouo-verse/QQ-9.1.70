package com.tencent.qq.effect;

import android.content.Context;
import com.tencent.qq.effect.engine.QEffectData;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IQEffectLoad<T extends QEffectData> {
    public static final int HTTP_TYPE = 2;
    public static final int LOCAL_TYPE = 1;
    public static final int NO_TYPE = 0;
    public static final int RESID_TYPE = 3;

    void load(Context context, IQEffect iQEffect, T t16);

    void loadFromAsset(Context context, IQEffect iQEffect, String str);

    void loadFromFile(Context context, IQEffect iQEffect, String str);

    void loadFromResource(Context context, IQEffect iQEffect, int i3);
}
