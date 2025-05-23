package com.tencent.icgame.game.ui.widget;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h extends b {
    public h(Context context, int i3) {
        super(context, i3);
        O();
    }

    private void O() {
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
