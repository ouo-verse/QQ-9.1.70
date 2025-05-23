package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import v83.e;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00070\u0006J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u000eR&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "L1", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "N1", "Landroidx/lifecycle/LiveData;", "O1", "enable", "res", "", "P1", "M1", "R1", "i", "Landroidx/lifecycle/MutableLiveData;", "dialogLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "enableMemoryAlbumLiveData", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Boolean, Integer>> dialogLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> enableMemoryAlbumLiveData = new MutableLiveData<>();

    private final boolean L1() {
        if (!NetworkUtil.isNetworkAvailable() && !WinkEditorResourceManager.a1().l2("XsjRemberTemplate")) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void Q1(a aVar, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = R.string.f239007la;
        }
        aVar.P1(z16, i3);
    }

    public final void M1(boolean enable) {
        this.enableMemoryAlbumLiveData.postValue(Boolean.valueOf(enable));
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, Integer>> N1() {
        return this.dialogLiveData;
    }

    @NotNull
    public final LiveData<Boolean> O1() {
        return this.enableMemoryAlbumLiveData;
    }

    public final void P1(boolean enable, int res) {
        this.dialogLiveData.postValue(TuplesKt.to(Boolean.valueOf(enable), Integer.valueOf(res)));
    }

    public final void R1() {
        if (e.f441245a.f()) {
            boolean z16 = false;
            if (!L1()) {
                QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.f240327ov), 0).show();
                return;
            }
            z93.e h16 = Wink.INSTANCE.h();
            if (h16 != null) {
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                z16 = h16.a(context);
            }
            if (!z16) {
                w53.b.a(getLogTag(), "return isHasStoragePermission false");
            } else {
                P1(true, R.string.f239007la);
                v83.b.f441239a.i();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "MemoryAlbumPreviewViewModel";
    }
}
