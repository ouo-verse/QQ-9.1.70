package com.tencent.richframework.gallery.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/richframework/gallery/viewmodel/RFWLayerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "mRichMediaInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerViewModel extends ViewModel {

    @JvmField
    @NotNull
    public MutableLiveData<UIStateData<RFWLayerState>> mRichMediaInfo = new MutableLiveData<>();
}
