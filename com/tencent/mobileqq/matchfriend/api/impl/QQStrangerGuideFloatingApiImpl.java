package com.tencent.mobileqq.matchfriend.api.impl;

import android.content.Context;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerGuideFloatingApi;
import com.tencent.mobileqq.matchfriend.reborn.guide.QQStrangerGuideDialog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QQStrangerGuideFloatingApiImpl implements IQQStrangerGuideFloatingApi {
    @Override // com.tencent.mobileqq.matchfriend.api.IQQStrangerGuideFloatingApi
    public void showHalfFloatingView(Context context, com.tencent.mobileqq.matchfriend.api.b bVar) {
        new QQStrangerGuideDialog(context, bVar).show();
    }
}
