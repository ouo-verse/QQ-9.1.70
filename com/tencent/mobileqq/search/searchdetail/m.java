package com.tencent.mobileqq.search.searchdetail;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\b\u0010\t\u001a\u00020\u0007H\u0014R\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/m;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Landroid/os/Bundle;", "fragmentArgs", "", "init", "onCleared", "i", "Landroidx/lifecycle/ViewModelStore;", "_viewModelStore", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "L1", "()I", "setUserSource", "(I)V", "userSource", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class m extends ViewModel implements ViewModelStoreOwner {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewModelStore _viewModelStore = new ViewModelStore();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int userSource;

    /* renamed from: L1, reason: from getter */
    public final int getUserSource() {
        return this.userSource;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    /* renamed from: getViewModelStore, reason: from getter */
    public ViewModelStore get_viewModelStore() {
        return this._viewModelStore;
    }

    public final void init(@Nullable Bundle fragmentArgs) {
        if (fragmentArgs != null) {
            this.userSource = fragmentArgs.getInt("user_source");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this._viewModelStore.clear();
    }
}
