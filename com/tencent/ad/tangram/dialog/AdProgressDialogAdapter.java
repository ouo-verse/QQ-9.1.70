package com.tencent.ad.tangram.dialog;

import android.content.Context;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.dialog.AdProgressDialog;

@AdKeep
/* loaded from: classes3.dex */
public interface AdProgressDialogAdapter {
    void dismiss();

    boolean isShowing(Context context);

    void show(Context context, AdProgressDialog.Params params);
}
