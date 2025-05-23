package com.tencent.ad.tangram.views.form.textbox;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.views.xijing.AdTextData;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdFormItemTextBoxData extends AdFormItemData {
    private static final String TAG = "AdFormItemTextBoxData";
    public String regex;
    public int lines = 1;
    public int regexType = Integer.MIN_VALUE;

    @NonNull
    public AdTextData content = new AdTextData();

    @Override // com.tencent.ad.tangram.views.form.framework.AdFormItemData
    public boolean isValid() {
        return super.isValid();
    }

    @Override // com.tencent.ad.tangram.views.form.framework.AdFormItemData
    @Nullable
    public AdFormError validate() {
        if (!isValid()) {
            AdLog.e(TAG, "validate error");
            return new AdFormError(3, -1, null);
        }
        if (this.required && TextUtils.isEmpty(getResult())) {
            return new AdFormError(5, -1, this.title.text);
        }
        if (!TextUtils.isEmpty(this.regex) && !TextUtils.isEmpty(getResult()) && !getResult().matches(this.regex)) {
            return new AdFormError(6, -1, this.title.text);
        }
        return new AdFormError(2, -1, this.title.text);
    }

    @Override // com.tencent.ad.tangram.views.form.framework.AdFormItemData
    @NonNull
    public String getResult() {
        return TextUtils.isEmpty(this.content.text) ? "" : this.content.text;
    }
}
