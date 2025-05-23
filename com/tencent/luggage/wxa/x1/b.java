package com.tencent.luggage.wxa.x1;

import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends p {
    static final int CTRL_INDEX = -2;
    static final String NAME = "onKeyboardComplete";

    public void a(String str, l lVar) {
        if (!lVar.isRunning()) {
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        hashMap.put("value", str);
        setData(hashMap).setContext(lVar).dispatch();
    }
}
