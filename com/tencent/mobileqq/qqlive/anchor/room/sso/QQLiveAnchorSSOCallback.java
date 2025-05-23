package com.tencent.mobileqq.qqlive.anchor.room.sso;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;

/* compiled from: P */
@Keep
/* loaded from: classes17.dex */
public interface QQLiveAnchorSSOCallback<T extends QQLiveAnchorDataBase> {
    @Keep
    void onResult(T t16);
}
