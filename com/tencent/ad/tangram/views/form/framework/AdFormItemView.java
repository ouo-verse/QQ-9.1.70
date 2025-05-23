package com.tencent.ad.tangram.views.form.framework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.AdFormError;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AdFormItemView extends TableRow {
    private static final String TAG = "AdFormItemView";

    @Nullable
    private AdFormItemData data;
    private WeakReference<AdFormErrorListener> listener;

    public AdFormItemView(@NonNull Context context, AdFormItemData adFormItemData, WeakReference<AdFormErrorListener> weakReference) {
        super(context);
        this.listener = weakReference;
        init(context, adFormItemData);
    }

    @Nullable
    private View createTitleView(Context context) {
        String str;
        if (getData() != null && getData().isValid()) {
            if (getData().required) {
                str = getData().title.text;
            } else {
                str = getData().title.text + "(\u9009\u586b)";
            }
            TextView textView = new TextView(context);
            textView.setGravity(16);
            textView.setText(str);
            textView.setTextColor(getData().title.color);
            textView.setTextSize(0, getData().title.size);
            return textView;
        }
        AdLog.e(TAG, "createTitleView error");
        return null;
    }

    private void init(@NonNull Context context, @Nullable AdFormItemData adFormItemData) {
        if (adFormItemData != null && adFormItemData.isValid()) {
            this.data = adFormItemData;
            initViews(context);
        } else {
            AdLog.e(TAG, "init error");
        }
    }

    private void initViews(@NonNull Context context) {
        if (getData() != null && getData().isValid()) {
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(-2, -2);
            View createTitleView = createTitleView(context);
            if (createTitleView == null) {
                AdLog.e(TAG, "initViews error");
                createTitleView = new FrameLayout(context);
            }
            addView(createTitleView, layoutParams);
            createTitleView.setPadding(getData().titlePaddingLeft, getData().paddingTop, getData().titlePaddingRight, getData().paddingBottom);
            TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(-1, -2);
            View createContentView = createContentView(context);
            if (createContentView == null) {
                AdLog.e(TAG, "initViews error");
                createContentView = new FrameLayout(context);
            }
            addView(createContentView, layoutParams2);
            createContentView.setPadding(getData().contentPaddingLeft, getData().paddingTop, getData().contentPaddingRight, getData().paddingBottom);
            return;
        }
        AdLog.e(TAG, "initViews error");
    }

    @Nullable
    protected abstract View createContentView(Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public AdFormItemData getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getIndex() {
        if (!(getParent() instanceof TableLayout)) {
            AdLog.e(TAG, "getIndex error");
            return -1;
        }
        return ((TableLayout) getParent()).indexOfChild(this);
    }

    public abstract void reset();

    /* JADX INFO: Access modifiers changed from: protected */
    public void showError(AdFormError adFormError) {
        WeakReference<AdFormErrorListener> weakReference = this.listener;
        if (weakReference != null && weakReference.get() != null) {
            this.listener.get().onError(adFormError);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean validate() {
        if (getData() != null && getData().isValid()) {
            AdFormError validate = getData().validate();
            if (validate == null) {
                AdLog.e(TAG, "validate error");
                return false;
            }
            validate.index = getIndex();
            int i3 = validate.type;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 5) {
                return false;
            }
            showError(validate);
            return false;
        }
        AdLog.e(TAG, "validate error");
        return false;
    }
}
