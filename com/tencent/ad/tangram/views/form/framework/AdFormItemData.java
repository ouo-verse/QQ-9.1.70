package com.tencent.ad.tangram.views.form.framework;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AdFormItemData implements Serializable {
    public AdTextData placeholder;
    public boolean required;
    public int paddingTop = 0;
    public int paddingBottom = 0;
    public int backgroundColor = 0;

    @NonNull
    public AdTextData title = new AdTextData();
    public int titlePaddingLeft = 0;
    public int titlePaddingRight = 0;
    public int contentPaddingLeft = 0;
    public int contentPaddingRight = 0;

    @NonNull
    public abstract Object getResult();

    public boolean isValid() {
        AdTextData adTextData;
        AdTextData adTextData2;
        if (this.paddingTop >= 0 && this.paddingBottom >= 0 && (adTextData = this.title) != null && adTextData.isValid() && !TextUtils.isEmpty(this.title.text) && this.titlePaddingLeft >= 0 && this.titlePaddingRight >= 0 && this.contentPaddingLeft >= 0 && this.contentPaddingRight >= 0 && ((adTextData2 = this.placeholder) == null || adTextData2.isValid())) {
            return true;
        }
        return false;
    }

    @Nullable
    public abstract AdFormError validate();
}
