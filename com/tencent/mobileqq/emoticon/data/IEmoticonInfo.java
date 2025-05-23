package com.tencent.mobileqq.emoticon.data;

import androidx.annotation.Nullable;
import com.tencent.libra.request.Option;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IEmoticonInfo {
    @Nullable
    String getBigImagePath();

    @Nullable
    String getBigImageURL();

    int getEmoticonType();

    String getName();

    @Nullable
    Option getOption();

    @Nullable
    String getThumbImagePath();

    @Nullable
    String getThumbURL();
}
