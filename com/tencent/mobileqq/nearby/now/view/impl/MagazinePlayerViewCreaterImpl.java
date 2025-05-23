package com.tencent.mobileqq.nearby.now.view.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.a;
import com.tencent.mobileqq.nearby.now.view.IMagazinePlayerViewCreater;
import com.tencent.mobileqq.nearby.now.view.MagazinePlayerView;
import com.tencent.mobileqq.nearby.now.view.d;

/* loaded from: classes33.dex */
public class MagazinePlayerViewCreaterImpl implements IMagazinePlayerViewCreater {
    @Override // com.tencent.mobileqq.nearby.now.view.IMagazinePlayerViewCreater
    public d create(Context context, a aVar, AppInterface appInterface) {
        return new MagazinePlayerView(context, aVar, (QQAppInterface) appInterface);
    }
}
