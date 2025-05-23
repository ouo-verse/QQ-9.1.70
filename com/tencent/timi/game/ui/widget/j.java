package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

/* compiled from: P */
/* loaded from: classes26.dex */
public class j extends b {
    public j(Context context, int i3) {
        super(context, i3);
        P();
    }

    private void P() {
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
