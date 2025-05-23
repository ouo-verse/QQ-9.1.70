package com.tencent.qqmini.sdk.launcher.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class BaseGameLoadingView extends RelativeLayout {
    public BaseGameLoadingView(Context context) {
        this(context, null);
    }

    public abstract void hide();

    public abstract BaseGameLoadingView initUIData(MiniAppInfo miniAppInfo);

    public abstract void setProgressInt(float f16);

    public abstract void setProgressTxt(String str);

    public abstract void show(ViewGroup viewGroup);

    public BaseGameLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseGameLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
