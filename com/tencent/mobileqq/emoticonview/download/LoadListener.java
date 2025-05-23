package com.tencent.mobileqq.emoticonview.download;

import com.tencent.rlottie.AXrLottieDrawable;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface LoadListener {
    void onFail(Throwable th5);

    void onLottieResLoading(String str);

    void onSuccess(AXrLottieDrawable aXrLottieDrawable);
}
