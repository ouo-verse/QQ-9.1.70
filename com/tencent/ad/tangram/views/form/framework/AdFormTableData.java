package com.tencent.ad.tangram.views.form.framework;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.AdFormError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AdFormTableData implements Serializable {
    private static final String TAG = "AdFormTableData";
    public int borderWidth;
    public int borderCornerRadius = 0;
    public int borderColor = 0;
    public int borderColorError = 0;

    @NonNull
    private List<AdFormItemData> items = new ArrayList();

    public boolean addItem(@Nullable AdFormItemData adFormItemData) {
        List<AdFormItemData> list;
        if (adFormItemData != null && adFormItemData.isValid() && (list = this.items) != null) {
            return list.add(adFormItemData);
        }
        return false;
    }

    @Nullable
    public AdFormItemData getItem(int i3) {
        if (isValid() && i3 >= 0 && i3 < getSize()) {
            return this.items.get(i3);
        }
        return null;
    }

    public int getSize() {
        if (isValid()) {
            return this.items.size();
        }
        return 0;
    }

    public boolean isValid() {
        boolean z16;
        List<AdFormItemData> list = this.items;
        if (list != null && !list.isEmpty() && this.borderCornerRadius >= 0 && this.borderWidth >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        for (AdFormItemData adFormItemData : this.items) {
            if (adFormItemData == null || !adFormItemData.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public AdFormError validate() {
        if (!isValid()) {
            AdLog.e(TAG, "validate error");
            return new AdFormError(3, -1, null);
        }
        for (int i3 = 0; i3 < getSize(); i3++) {
            AdFormItemData item = getItem(i3);
            if (item == null) {
                AdLog.e(TAG, "validate error " + i3);
                return new AdFormError(3, i3, null);
            }
            AdFormError validate = item.validate();
            if (validate == null) {
                AdLog.e(TAG, "validate error " + i3);
                return new AdFormError(3, i3, item.title.text);
            }
            validate.index = i3;
            if (validate.type != 2) {
                return validate;
            }
        }
        return new AdFormError(2, -1, null);
    }
}
