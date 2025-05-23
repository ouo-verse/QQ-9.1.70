package com.tencent.ad.tangram.views.form.framework;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TableLayout;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.textbox.AdFormItemTextBoxData;
import com.tencent.ad.tangram.views.form.textbox.AdFormItemTextBoxView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdFormTableView extends TableLayout {
    private static final String TAG = "AdFormTableView";

    @Nullable
    private AdFormTableData data;

    @Nullable
    private ViewTreeObserver.OnGlobalLayoutListener layoutListener;

    public AdFormTableView(Context context, AdFormTableData adFormTableData, WeakReference<AdFormErrorListener> weakReference) {
        super(context);
        init(context, adFormTableData, weakReference);
    }

    @Nullable
    private Drawable getBackground(int i3) {
        AdFormTableData adFormTableData = this.data;
        if (adFormTableData != null && adFormTableData.isValid() && this.data.getSize() == getChildCount()) {
            int size = this.data.getSize();
            if (i3 != -1) {
                size++;
            }
            Drawable[] drawableArr = new Drawable[size];
            for (int i16 = 0; i16 < this.data.getSize(); i16++) {
                AdFormItemData item = this.data.getItem(i16);
                if (item == null) {
                    AdLog.e(TAG, "getBackground error");
                    return null;
                }
                AdFormTableData adFormTableData2 = this.data;
                float[] drawableRadii = getDrawableRadii(adFormTableData2.borderCornerRadius, i16, adFormTableData2.getSize());
                AdFormTableData adFormTableData3 = this.data;
                drawableArr[i16] = getDrawable(drawableRadii, adFormTableData3.borderWidth, adFormTableData3.borderColor, item.backgroundColor);
            }
            if (i3 != -1) {
                AdFormItemData item2 = this.data.getItem(i3);
                if (item2 == null) {
                    AdLog.e(TAG, "getBackground error");
                    return null;
                }
                AdFormTableData adFormTableData4 = this.data;
                float[] drawableRadii2 = getDrawableRadii(adFormTableData4.borderCornerRadius, i3, adFormTableData4.getSize());
                AdFormTableData adFormTableData5 = this.data;
                drawableArr[size - 1] = getDrawable(drawableRadii2, adFormTableData5.borderWidth, adFormTableData5.borderColorError, item2.backgroundColor);
            }
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            for (int i17 = 0; i17 < this.data.getSize(); i17++) {
                View childAt = getChildAt(i17);
                if (childAt == null) {
                    AdLog.e(TAG, "getBackground error");
                    return null;
                }
                layerDrawable.setLayerInset(i17, 0, childAt.getTop() - this.data.borderWidth, 0, (getHeight() - childAt.getBottom()) - this.data.borderWidth);
            }
            if (i3 != -1) {
                View childAt2 = getChildAt(i3);
                if (childAt2 == null) {
                    AdLog.e(TAG, "getBackground error");
                    return null;
                }
                layerDrawable.setLayerInset(size - 1, 0, childAt2.getTop() - this.data.borderWidth, 0, (getHeight() - childAt2.getBottom()) - this.data.borderWidth);
            }
            return layerDrawable;
        }
        AdLog.e(TAG, "getBackground error");
        return null;
    }

    @NonNull
    private static Drawable getDrawable(float[] fArr, int i3, int i16, int i17) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setStroke(i3, i16);
        gradientDrawable.setColor(i17);
        return gradientDrawable;
    }

    @Nullable
    private static float[] getDrawableRadii(int i3, int i16, int i17) {
        if (i16 >= 0 && i16 < i17 && i17 > 0) {
            if (i17 == 1) {
                float f16 = i3;
                return new float[]{f16, f16, f16, f16, f16, f16, f16, f16};
            }
            if (i16 == 0) {
                float f17 = i3;
                return new float[]{f17, f17, f17, f17, 0.0f, 0.0f, 0.0f, 0.0f};
            }
            if (i16 == i17 - 1) {
                float f18 = i3;
                return new float[]{0.0f, 0.0f, 0.0f, 0.0f, f18, f18, f18, f18};
            }
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        return null;
    }

    private void init(@Nullable Context context, @Nullable AdFormTableData adFormTableData, WeakReference<AdFormErrorListener> weakReference) {
        View view;
        if (context != null && adFormTableData != null && adFormTableData.isValid()) {
            this.data = adFormTableData;
            setColumnShrinkable(1, true);
            setColumnStretchable(1, true);
            for (int i3 = 0; i3 < adFormTableData.getSize(); i3++) {
                AdFormItemData item = adFormTableData.getItem(i3);
                if (item instanceof AdFormItemTextBoxData) {
                    view = new AdFormItemTextBoxView(context, (AdFormItemTextBoxData) AdFormItemTextBoxData.class.cast(item), weakReference);
                } else {
                    view = null;
                }
                if (view == null) {
                    AdLog.e(TAG, "init error");
                } else {
                    TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(-2, -2);
                    if (i3 == adFormTableData.getSize() - 1) {
                        int i16 = adFormTableData.borderWidth;
                        layoutParams.setMargins(i16, i16, i16, i16);
                    } else {
                        int i17 = adFormTableData.borderWidth;
                        layoutParams.setMargins(i17, i17, i17, 0);
                    }
                    addView(view, layoutParams);
                }
            }
            resetBackground();
            return;
        }
        AdLog.e(TAG, "init error");
    }

    @TargetApi(16)
    private void resetBackground() {
        if (this.layoutListener != null && getViewTreeObserver() != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.layoutListener);
            this.layoutListener = null;
        }
        this.layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.ad.tangram.views.form.framework.AdFormTableView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AdFormTableView.this.showError(-1);
                AdFormTableView.this.post(new Runnable() { // from class: com.tencent.ad.tangram.views.form.framework.AdFormTableView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AdFormTableView.this.layoutListener != null && AdFormTableView.this.getViewTreeObserver() != null) {
                            AdFormTableView.this.getViewTreeObserver().removeOnGlobalLayoutListener(AdFormTableView.this.layoutListener);
                            AdFormTableView.this.layoutListener = null;
                        }
                    }
                });
            }
        };
        if (getViewTreeObserver() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.layoutListener);
        }
    }

    public void reset() {
        resetBackground();
        AdFormTableData adFormTableData = this.data;
        if (adFormTableData != null && adFormTableData.isValid() && this.data.getSize() == getChildCount()) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) != null && (getChildAt(i3) instanceof AdFormItemView)) {
                    ((AdFormItemView) AdFormItemView.class.cast(getChildAt(i3))).reset();
                } else {
                    AdLog.e(TAG, "reset error");
                }
            }
            return;
        }
        AdLog.e(TAG, "reset error");
    }

    @TargetApi(16)
    public void showError(int i3) {
        setBackground(getBackground(i3));
    }
}
