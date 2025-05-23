package com.tencent.ad.tangram.views.form;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.views.form.framework.AdFormTableData;
import com.tencent.ad.tangram.views.xijing.AdButtonData;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import com.tencent.biz.common.util.WebViewConstants;
import java.io.Serializable;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public class AdFormData implements Serializable {
    private static final String TAG = "AdFormData";
    public int buttonHeight;
    public AdTextData title;
    public String tokenForUpload;
    public long formId = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    public int padding = 0;
    public int backgroundColor = 0;

    @NonNull
    public AdFormTableData table = new AdFormTableData();

    @NonNull
    public AdButtonData button = new AdButtonData();

    @Nullable
    public AdFormItemData getItem(int i3) {
        if (isValid()) {
            return this.table.getItem(i3);
        }
        return null;
    }

    public int getSize() {
        if (isValid()) {
            return this.table.getSize();
        }
        return 0;
    }

    public boolean isValid() {
        AdTextData adTextData;
        AdFormTableData adFormTableData;
        AdButtonData adButtonData;
        if (this.formId != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && this.padding >= 0 && (((adTextData = this.title) == null || (adTextData.isValid() && !TextUtils.isEmpty(this.title.text))) && (adFormTableData = this.table) != null && adFormTableData.isValid() && (adButtonData = this.button) != null && adButtonData.isValid() && this.buttonHeight > 0)) {
            return true;
        }
        return false;
    }

    @Nullable
    public AdFormError validate() {
        if (!isValid()) {
            AdLog.e(TAG, "validate error");
            return new AdFormError(3, -1, null);
        }
        return this.table.validate();
    }
}
