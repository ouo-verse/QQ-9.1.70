package com.tencent.richframework.gallery.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J\u0016\u0010\f\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0014R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "uiStateData", "onChanged", "layerState", "updateLayerState", "Lcom/tencent/richframework/gallery/viewmodel/RFWLayerViewModel;", "mLayerViewModel", "Lcom/tencent/richframework/gallery/viewmodel/RFWLayerViewModel;", "getMLayerViewModel", "()Lcom/tencent/richframework/gallery/viewmodel/RFWLayerViewModel;", "setMLayerViewModel", "(Lcom/tencent/richframework/gallery/viewmodel/RFWLayerViewModel;)V", "", "mSelectedPosition", "I", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mCurrentSelectedItem", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "<init>", "()V", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class RFWLayerBasePart extends Part implements Observer<UIStateData<RFWLayerState>> {

    @JvmField
    @Nullable
    public RFWLayerItemMediaInfo mCurrentSelectedItem;
    public RFWLayerViewModel mLayerViewModel;

    @JvmField
    public int mSelectedPosition;

    @NotNull
    public final RFWLayerViewModel getMLayerViewModel() {
        RFWLayerViewModel rFWLayerViewModel = this.mLayerViewModel;
        if (rFWLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayerViewModel");
        }
        return rFWLayerViewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(RFWLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(RFWLayerViewModel::class.java)");
        RFWLayerViewModel rFWLayerViewModel = (RFWLayerViewModel) viewModel;
        this.mLayerViewModel = rFWLayerViewModel;
        if (rFWLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayerViewModel");
        }
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = rFWLayerViewModel.mRichMediaInfo;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        mutableLiveData.observe(partHost.getHostLifecycleOwner(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(@NotNull UIStateData<RFWLayerState> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        if (uiStateData.getData() != null) {
            this.mCurrentSelectedItem = uiStateData.getData().getSelectedItemMedia();
            this.mSelectedPosition = uiStateData.getData().getSelectedPosition();
            RFWLayerState data = uiStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
            updateLayerState(data);
        }
    }
}
