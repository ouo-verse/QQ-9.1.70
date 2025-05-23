package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneResLoader extends QRouteApi {
    public static final int INVALID_RES_ID = -1;
    public static final int TYPE_AIO_PIC_TENCENT_FOLDER_NOT_EXIST_TOAST = 1;
    public static final int TYPE_QQSTR_LOOPQUEU_3A326EF8 = 2;
    public static final int TYPE_QQSTR_LOOPQUEU_8920D273 = 3;
    public static final int TYPE_QQSTR_QZONEEMO_0DBF8D59 = 5;
    public static final int TYPE_QQSTR_QZONEEMO_EBCA573C = 4;

    String getString(String str);

    int getStringId(int i3);

    int getStringId(String str);
}
