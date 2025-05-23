package com.tencent.ad.tangram.views.form;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.form.framework.AdFormCommitListener;
import com.tencent.ad.tangram.views.form.framework.AdFormCommitUtil;
import com.tencent.ad.tangram.views.form.framework.AdFormErrorListener;
import com.tencent.ad.tangram.views.form.framework.AdFormTableView;
import com.tencent.ad.tangram.views.form.framework.AdFormUpdateRegexUtil;
import com.tencent.ad.tangram.views.xijing.AdButtonView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdFormView extends LinearLayout implements AdFormCommitListener, AdFormErrorListener {
    private static final String TAG = "GdtFormView";

    /* renamed from: ad, reason: collision with root package name */
    @Nullable
    private Ad f61347ad;

    @NonNull
    private View.OnClickListener buttonListener;

    @Nullable
    private AdFormData data;
    private int errorIndex;
    private WeakReference<AdFormViewListener> listener;
    private AdFormTableView tableView;

    public AdFormView(Context context, Ad ad5, AdFormData adFormData) {
        super(context);
        this.errorIndex = -1;
        this.buttonListener = new View.OnClickListener() { // from class: com.tencent.ad.tangram.views.form.AdFormView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (AdFormView.this.validate()) {
                    AdFormView.this.commit();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        init(context, ad5, adFormData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commit() {
        AdFormCommitUtil.commitAsync(getContext(), getAd(), getData(), new WeakReference(this));
    }

    private void init(Context context, @Nullable Ad ad5, @Nullable AdFormData adFormData) {
        if (ad5 != null && ad5.isValid() && adFormData != null && adFormData.isValid()) {
            this.f61347ad = ad5;
            this.data = adFormData;
            AdFormUpdateRegexUtil.updateAsync(new WeakReference(getData()));
            initViews(context);
            return;
        }
        AdLog.e(TAG, "init error");
    }

    private void initViews(Context context) {
        boolean z16;
        AdFormData adFormData = this.data;
        if (adFormData != null && adFormData.isValid()) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            setBackgroundColor(getData().backgroundColor);
            setOrientation(1);
            if (getData().title != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                TextView textView = new TextView(context);
                textView.setText(getData().title.text);
                textView.setTextColor(getData().title.color);
                textView.setTextSize(0, getData().title.size);
                textView.setTypeface(null, 1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                addView(textView, layoutParams);
            }
            this.tableView = new AdFormTableView(context, getData().table, new WeakReference(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            if (z16) {
                layoutParams2.setMargins(0, getData().padding, 0, 0);
            }
            addView(this.tableView, layoutParams2);
            View adButtonView = new AdButtonView(context, getData().button);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getData().buttonHeight);
            layoutParams3.setMargins(0, getData().padding, 0, 0);
            addView(adButtonView, layoutParams3);
            adButtonView.setOnClickListener(this.buttonListener);
            return;
        }
        AdLog.e(TAG, "initViews error");
    }

    private void notifyCommitted(boolean z16, AdFormError adFormError) {
        WeakReference<AdFormViewListener> weakReference = this.listener;
        if (weakReference != null && weakReference.get() != null) {
            this.listener.get().onCommitted(z16, adFormError);
        }
    }

    private void reset() {
        AdFormTableView adFormTableView = this.tableView;
        if (adFormTableView == null) {
            AdLog.e(TAG, "reset error");
        } else {
            adFormTableView.reset();
        }
    }

    private void showLoading(boolean z16) {
        if (getData() != null && getData().isValid()) {
            if (z16) {
                if (AdProgressDialog.getInstance().isShowing(getContext())) {
                    return;
                }
                AdProgressDialog.Params params = new AdProgressDialog.Params();
                params.yOffset = AdUIUtils.dp2px(44.0f, getResources());
                params.cancelable = false;
                params.message = "\u6b63\u5728" + getData().button.text.text;
                return;
            }
            AdProgressDialog.getInstance().dismiss();
            return;
        }
        AdLog.e(TAG, "showLoading error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validate() {
        if (getData() != null && getData().isValid()) {
            AdFormError validate = getData().validate();
            if (validate == null) {
                AdLog.e(TAG, "validate error");
            } else {
                if (validate.type == 2) {
                    return true;
                }
                onError(validate);
            }
        } else {
            AdLog.e(TAG, "validate error");
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.views.form.framework.AdFormCommitListener
    public void afterCommit(@Nullable AdFormError adFormError) {
        boolean z16 = false;
        showLoading(false);
        onError(adFormError);
        if (adFormError != null && adFormError.type == 1) {
            z16 = true;
        }
        if (z16) {
            reset();
        }
        notifyCommitted(z16, adFormError);
    }

    @Override // com.tencent.ad.tangram.views.form.framework.AdFormCommitListener
    public void beforeCommit() {
        showLoading(true);
    }

    @Nullable
    protected Ad getAd() {
        return this.f61347ad;
    }

    @Nullable
    protected AdFormData getData() {
        return this.data;
    }

    @Override // com.tencent.ad.tangram.views.form.framework.AdFormErrorListener
    public void onError(@Nullable AdFormError adFormError) {
        if (adFormError != null && getData() != null && getData().isValid()) {
            int i3 = adFormError.type;
            if (i3 == 1) {
                this.errorIndex = -1;
                this.tableView.showError(-1);
                AdToast.getInstance().show(getContext(), 2, getData().button.text.text + "\u6210\u529f", 0);
                return;
            }
            if (i3 == 4) {
                this.errorIndex = -1;
                this.tableView.showError(-1);
                AdToast.getInstance().show(getContext(), 1, getData().button.text.text + "\u5931\u8d25", 0);
                return;
            }
            if (i3 == 7) {
                this.errorIndex = -1;
                this.tableView.showError(-1);
                AdToast.getInstance().show(getContext(), 1, "\u4f60\u5df2\u63d0\u4ea4\u6210\u529f\uff0c\u8bf7\u52ff\u91cd\u590d\u63d0\u4ea4", 0);
                return;
            }
            if (i3 == 2) {
                int i16 = adFormError.index;
                if (i16 == -1 || i16 == this.errorIndex) {
                    this.errorIndex = -1;
                    this.tableView.showError(-1);
                    return;
                }
                return;
            }
            if (adFormError.index != -1 && !TextUtils.isEmpty(adFormError.toString())) {
                int i17 = adFormError.index;
                this.errorIndex = i17;
                this.tableView.showError(i17);
                AdToast.getInstance().show(getContext(), 1, adFormError.toString(), 0);
                return;
            }
            AdLog.e(TAG, "onError error");
            return;
        }
        AdLog.e(TAG, "onError error");
    }

    public void setListener(WeakReference<AdFormViewListener> weakReference) {
        this.listener = weakReference;
    }
}
