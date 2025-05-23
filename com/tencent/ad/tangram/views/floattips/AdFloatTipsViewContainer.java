package com.tencent.ad.tangram.views.floattips;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public class AdFloatTipsViewContainer extends LinearLayout {
    public static final String TAG = "AdFloatTipsViewContainer";

    @Nullable
    private View appTipsView;

    @Nullable
    private View industrialView;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {
        public String iconUrl;
        public String text;
        public int textSize = 28;
        public int textColor = -5196866;
        public int backgroundColor = 0;
        public int iconSize = 28;
    }

    public AdFloatTipsViewContainer(Context context, Params params, Params params2) {
        super(context);
        initView();
        initChildViews(params, params2);
    }

    private void initChildViews(@Nullable Params params, @Nullable Params params2) {
        AdLog.i(TAG, "[initChildViews]");
        if (params != null) {
            AdFloatTipsView adFloatTipsView = new AdFloatTipsView(getContext(), params);
            this.appTipsView = adFloatTipsView;
            addView(adFloatTipsView);
        }
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        addView(view);
        if (params2 != null) {
            AdFloatTipsView adFloatTipsView2 = new AdFloatTipsView(getContext(), params2);
            this.industrialView = adFloatTipsView2;
            addView(adFloatTipsView2);
        }
    }

    private void initView() {
        AdLog.i(TAG, "[initView]");
        setGravity(16);
    }

    @Nullable
    public View getAppTipsView() {
        return this.appTipsView;
    }

    @Nullable
    public View getIndustrialView() {
        return this.industrialView;
    }

    public void onRecycle() {
        AdLog.i(TAG, "[onRecycle]");
        removeAllViews();
    }

    public void resetTipsView(Params params, Params params2) {
        AdLog.i(TAG, "[resetTipsView]");
        onRecycle();
        initChildViews(params, params2);
    }
}
