package com.tencent.mobileqq.wink.publish.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;

/* compiled from: P */
/* loaded from: classes21.dex */
public class n extends BaseViewModel {

    /* renamed from: m, reason: collision with root package name */
    public static final String f326056m = UploadConstants.TAG + "FSJurisdictionViewModel";

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<Boolean> f326057i = new MutableLiveData<>();

    public LiveData<Boolean> L1() {
        return this.f326057i;
    }

    public boolean M1() {
        Boolean value = this.f326057i.getValue();
        if (value != null && !value.booleanValue()) {
            return false;
        }
        return true;
    }

    public void N1(Boolean bool) {
        this.f326057i.setValue(bool);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return f326056m;
    }
}
