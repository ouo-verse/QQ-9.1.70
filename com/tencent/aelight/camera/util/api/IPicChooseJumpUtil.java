package com.tencent.aelight.camera.util.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IPicChooseJumpUtil extends QRouteApi {
    public static final int BACK_TYPE_PIC_LIST = 0;
    public static final int BACK_TYPE_PIC_SINGLE = 1;
    public static final String PIC_BACK_TYPE_RESULT = "pic_back_type_result";
    public static final String PIC_NODE_ID = "pic_choose_in_node_id";
    public static final String PIC_RESULT_BACK_TYPE = "pic_result_back_type";

    void jumpWithSinglePicResult(Activity activity, int i3);
}
