package com.tencent.aelight.camera.qqstory.api;

import android.content.Context;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ICaptureVideoFilterManager extends QRouteApi {
    FilterDesc getFilterDesc(String str);

    String getQQFilterConfigpath();

    String getQQFilterResPath();

    int getQQShortVideoFilterConfigVersion(Context context);

    FilterCategoryItem getSelectFilterCategoryItem();

    boolean needShowRedDot(int i3, int i16, String str);

    void updateQQShortVideoFilterConfig(Context context, String str, int i3);
}
