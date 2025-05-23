package com.tencent.ad.tangram.views.floattips;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.floattips.AdFloatTipsViewContainer;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdFloatTipsView extends LinearLayout implements AdImageViewAdapter.Callback {
    public static final String TAG = "AdFloatTipsView";
    private final WeakReference<AdImageViewBuilder.Listener> imageViewlistener;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdFloatTipsView(Context context, @Nullable AdFloatTipsViewContainer.Params params) {
        super(context);
        this.imageViewlistener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.floattips.AdFloatTipsView.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z16) {
                AdFloatTipsView.this.onStopLoad(z16);
            }
        });
        init(params);
    }

    private void init(@Nullable AdFloatTipsViewContainer.Params params) {
        if (params == null) {
            return;
        }
        AdLog.i(TAG, "[init]");
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setBackgroundColor(params.backgroundColor);
        setGravity(16);
        initChildViews(params);
    }

    private void initChildViews(@Nullable AdFloatTipsViewContainer.Params params) {
        View buildImageView;
        AdLog.i(TAG, "[initChildViews]");
        if (params == null) {
            return;
        }
        if (TextUtils.isEmpty(params.iconUrl)) {
            buildImageView = new View(getContext());
        } else {
            AdImageViewBuilder.Params params2 = new AdImageViewBuilder.Params();
            params2.callback = new WeakReference<>(this);
            params2.context = new WeakReference<>(getContext());
            params2.url = params.iconUrl;
            params2.listener = this.imageViewlistener;
            buildImageView = AdImageViewBuilder.getInstance().buildImageView(params2);
            if (buildImageView instanceof ImageView) {
                ((ImageView) buildImageView).setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
        if (buildImageView == null) {
            return;
        }
        int i3 = params.iconSize;
        buildImageView.setLayoutParams(new LinearLayout.LayoutParams(i3, i3));
        addView(buildImageView);
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(AdUIUtils.dp2px(1.5f, getResources()), -1));
        addView(view);
        TextView textView = new TextView(getContext());
        textView.setTextColor(params.textColor);
        textView.setText(params.text);
        textView.setTextSize(0, params.textSize);
        textView.setIncludeFontPadding(false);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(textView);
    }

    @Override // com.tencent.ad.tangram.image.AdImageViewAdapter.Callback
    public void onStopLoad(boolean z16) {
        AdLog.i(TAG, "[onStopLoad] isSuccess=" + z16);
    }
}
