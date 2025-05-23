package com.tencent.mobileqq.search.unitsearch.viewmodel;

import android.os.Bundle;
import androidx.annotation.UiThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.coroutine.b;
import com.tencent.mobileqq.search.api.ISearchEntryRuntimeService;
import com.tencent.mobileqq.search.model.DiscoveryResultData;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.model.aj;
import com.tencent.mobileqq.search.util.w;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisResult;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisRspBody;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0007J\b\u0010\u0013\u001a\u00020\u0006H\u0014R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R!\u0010)\u001a\b\u0012\u0004\u0012\u00020 0$8FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b%\u0010&*\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/search/unitsearch/viewmodel/UniteSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "it", "", IProfileCardConst.KEY_FROM_TYPE, "", "P1", "O1", "Landroid/os/Bundle;", "bundle", "init", "Lcom/tencent/common/app/AppInterface;", "app", "S1", "U1", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "W1", "T1", "onCleared", "i", "I", "Q1", "()I", "setMFrom", "(I)V", "mFrom", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getSource", "setSource", "source", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/search/model/c;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_searchDiscoveryResult", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "getSearchDiscoveryResult$delegate", "(Lcom/tencent/mobileqq/search/unitsearch/viewmodel/UniteSearchViewModel;)Ljava/lang/Object;", "searchDiscoveryResult", "<init>", "()V", "D", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class UniteSearchViewModel extends ViewModel {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int source;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mFrom = -1;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<DiscoveryResultData> _searchDiscoveryResult = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final int O1() {
        int i3 = this.mFrom;
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 21) {
            return 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(UfsDisRspBody it, int fromType) {
        QQAppInterface qQAppInterface;
        Object m476constructorimpl;
        int i3 = it.expireTime;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.e("Q.uniteSearch..UniteSearchViewModel", 1, "app is null or not QQAppInterface " + MobileQQ.sMobileQQ.peekAppRuntime() + " ");
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            ArrayList<UfsDisResult> resultItemList = it.resultItems;
            aj.Companion companion2 = aj.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(resultItemList, "resultItemList");
            List<SearchEntryDataModel> c16 = companion2.c(qQAppInterface, resultItemList, fromType);
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch..UniteSearchViewModel", 2, "response data: expireTime:" + i3 + ",modelList :" + c16);
            }
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISearchEntryRuntimeService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
            ((ISearchEntryRuntimeService) runtimeService).updateSearchEntryDataModels(c16);
            w.B(it.tabConfigList);
            UnifySearchHandler.a aVar = new UnifySearchHandler.a();
            aVar.f195174a = companion2.b(resultItemList, fromType);
            this._searchDiscoveryResult.postValue(new DiscoveryResultData(true, c16, Integer.valueOf(fromType), aVar, 0, null, 48, null));
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            this._searchDiscoveryResult.postValue(new DiscoveryResultData(false, null, Integer.valueOf(fromType), null, -1, "", 10, null));
        }
    }

    /* renamed from: Q1, reason: from getter */
    public final int getMFrom() {
        return this.mFrom;
    }

    @NotNull
    public final LiveData<DiscoveryResultData> R1() {
        return this._searchDiscoveryResult;
    }

    public final void S1(@NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
    }

    @UiThread
    @Nullable
    public final b T1() {
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Q.uniteSearch..UniteSearchViewModel requestSearchDiscoveryData", Boolean.FALSE, null, Boolean.TRUE, new UniteSearchViewModel$requestSearchDiscoveryData$1(this, null), 4, null);
    }

    public final void U1(@NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        W1();
        T1();
    }

    @UiThread
    @Nullable
    public final b W1() {
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Q.uniteSearch..UniteSearchViewModel requestSearchDiscoveryDataInCache", Boolean.FALSE, null, null, new UniteSearchViewModel$requestSearchDiscoveryDataInCache$1(this, null), 12, null);
    }

    public final void init(@NotNull Bundle bundle) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            QLog.e("Q.uniteSearch..UniteSearchViewModel", 1, "app is null or not AppInterface " + MobileQQ.sMobileQQ.peekAppRuntime());
            return;
        }
        this.mFrom = bundle.getInt(IProfileCardConst.KEY_FROM_TYPE, -1);
        this.source = bundle.getInt("source", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
    }
}
