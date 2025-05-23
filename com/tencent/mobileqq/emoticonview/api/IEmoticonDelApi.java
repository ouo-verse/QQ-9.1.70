package com.tencent.mobileqq.emoticonview.api;

import android.widget.EditText;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoticonDelApi extends QRouteApi {
    void delete(EditText editText);
}
