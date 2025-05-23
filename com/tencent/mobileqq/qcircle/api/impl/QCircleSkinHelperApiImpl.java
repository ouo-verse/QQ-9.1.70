package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleSkinHelperApiImpl implements IQCircleSkinHelperApi {
    private static final String TAG = "QCircleSkinHelperApiImpl";

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi
    public int getColor(int i3) {
        return QCircleSkinHelper.getInstance().getColor(i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi
    public Drawable getDrawable(int i3) {
        return QCircleSkinHelper.getInstance().getDrawable(i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi
    public String getUrl(String str) {
        return QCircleSkinHelper.getInstance().getUrl(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi
    public void init(Context context) {
        QCircleSkinHelper.getInstance().init(context);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi
    public void loadResource() {
        QCircleSkinHelper.getInstance().loadResource();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi
    public int getColor(String str) {
        return QCircleSkinHelper.getInstance().getColor(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi
    public Drawable getDrawable(String str) {
        return QCircleSkinHelper.getInstance().getDrawable(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi
    public Drawable getDrawable(String str, Option option) {
        return QCircleSkinHelper.getInstance().getDrawable(str, option);
    }
}
