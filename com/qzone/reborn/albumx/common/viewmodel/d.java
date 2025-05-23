package com.qzone.reborn.albumx.common.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/albumx/common/viewmodel/d;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "", AppConstants.Key.COLUMN_IS_VALID, "", "N1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "isValidInput", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> isValidInput = new MutableLiveData<>();

    public final MutableLiveData<Boolean> M1() {
        return this.isValidInput;
    }

    public final void N1(boolean isValid) {
        if (Intrinsics.areEqual(this.isValidInput.getValue(), Boolean.valueOf(isValid))) {
            return;
        }
        this.isValidInput.postValue(Boolean.valueOf(isValid));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "CommonAlbumEditTextViewModel";
    }
}
