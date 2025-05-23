package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qcircle.api.IQFSPushOpenBoxPopWindowApi;
import com.tencent.mobileqq.qcircle.api.global.QFSPushOpenBoxInfo;
import cooperation.qqcircle.push.QFSPushGetTreasurePopUpWindow;

/* loaded from: classes16.dex */
public class QFSPushOpenBoxPopWindowApiImpl implements IQFSPushOpenBoxPopWindowApi {
    @Override // com.tencent.mobileqq.qcircle.api.IQFSPushOpenBoxPopWindowApi
    public void showPushOpenBoxWindow(Context context, QFSPushOpenBoxInfo qFSPushOpenBoxInfo, View.OnClickListener onClickListener, View view) {
        new QFSPushGetTreasurePopUpWindow(context, qFSPushOpenBoxInfo, onClickListener).show(view);
    }
}
