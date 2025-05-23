package com.tencent.mobileqq.nearby.now.view.impl;

import android.content.Context;
import com.tencent.mobileqq.nearby.now.view.INowViewCreater;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NowViewCreaterImpl implements INowViewCreater {
    @Override // com.tencent.mobileqq.nearby.now.view.INowViewCreater
    public IShortVideoCommentsView createShortVideoCommentsView(Context context) {
        return new ShortVideoCommentsView(context);
    }
}
