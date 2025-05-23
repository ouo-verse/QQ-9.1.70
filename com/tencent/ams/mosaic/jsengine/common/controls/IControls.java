package com.tencent.ams.mosaic.jsengine.common.controls;

import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IControls {
    void hideKeyboard();

    void showActionSheet(JSObject jSObject);

    void showAlertDialog(JSObject jSObject);

    void showToast(String str, int i3);

    void vibrate(int i3);
}
