package com.tencent.biz.richframework.part.interfaces;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.Part;
import java.util.List;

/* loaded from: classes5.dex */
public interface IPartHost extends ViewModelStoreOwner {
    @Nullable
    List<Part> assembleParts();

    Activity getHostActivity();

    Context getHostContext();

    LifecycleOwner getHostLifecycleOwner();

    <T extends ViewModel> T getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class<T> cls);

    <T extends ViewModel> T getViewModel(String str, @NonNull Class<T> cls);

    @Deprecated
    Object getViewTagData();

    @Deprecated
    void onPartTimeCostReport(String str, String str2, long j3);
}
