package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorDebugInstance;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemType;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J'\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u000e\u001a\u00020\u0005J\b\u0010\u000f\u001a\u00020\u0005H\u0014R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R#\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00198\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001dR \u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0017R#\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150\u00198\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001dR \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0017R#\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150\u00198\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010\u001dR$\u00101\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0015\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\f0\u00038\u0006\u00a2\u0006\f\n\u0004\b4\u0010\u0017\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkAlbumDataViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "T", "Landroidx/lifecycle/MutableLiveData;", "t", "", "W1", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "", IXWebBroadcastListener.STAGE_FINISHED, "U1", "X1", "", "getLogTag", "T1", "onCleared", "", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/data/a;", "i", "Ljava/util/List;", "_allAlbumDataTypeDataList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_allAlbumDataTypeData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "allAlbumDataTypeData", "D", "_allAlbumDataLoadFinished", "E", "P1", "allAlbumDataLoadFinished", UserInfo.SEX_FEMALE, "_previewPageUIData", "G", "S1", "previewPageUIData", "H", "_templateLibTopicUIData", "I", "getTemplateLibTopicUIData", "templateLibTopicUIData", "Landroidx/lifecycle/Observer;", "J", "Landroidx/lifecycle/Observer;", "allAlbumDataTypeDataObserver", "K", "allAlbumDataLoadFinishedObserver", "L", "R1", "()Landroidx/lifecycle/MutableLiveData;", "debugInfo", "Lkotlinx/coroutines/CoroutineScope;", "M", "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "<init>", "()V", "N", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAlbumDataViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<WinkAlbumItemWrapper>> allAlbumDataTypeData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _allAlbumDataLoadFinished;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> allAlbumDataLoadFinished;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<WinkAlbumItemWrapper>> _previewPageUIData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<WinkAlbumItemWrapper>> previewPageUIData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<WinkAlbumItemWrapper>> _templateLibTopicUIData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<WinkAlbumItemWrapper>> templateLibTopicUIData;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Observer<List<WinkAlbumItemWrapper>> allAlbumDataTypeDataObserver;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Observer<Boolean> allAlbumDataLoadFinishedObserver;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> debugInfo;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope mainScope;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<WinkAlbumItemWrapper> _allAlbumDataTypeDataList = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<WinkAlbumItemWrapper>> _allAlbumDataTypeData;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f326616a;

        static {
            int[] iArr = new int[WinkAlbumItemType.values().length];
            try {
                iArr[WinkAlbumItemType.DATA_TYPE_MEMORY_ALBUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WinkAlbumItemType.DATA_TYPE_NEW_ALBUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f326616a = iArr;
        }
    }

    public WinkAlbumDataViewModel() {
        MutableLiveData<List<WinkAlbumItemWrapper>> mutableLiveData = new MutableLiveData<>();
        this._allAlbumDataTypeData = mutableLiveData;
        this.allAlbumDataTypeData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._allAlbumDataLoadFinished = mutableLiveData2;
        this.allAlbumDataLoadFinished = mutableLiveData2;
        MutableLiveData<List<WinkAlbumItemWrapper>> mutableLiveData3 = new MutableLiveData<>();
        this._previewPageUIData = mutableLiveData3;
        this.previewPageUIData = mutableLiveData3;
        MutableLiveData<List<WinkAlbumItemWrapper>> mutableLiveData4 = new MutableLiveData<>();
        this._templateLibTopicUIData = mutableLiveData4;
        this.templateLibTopicUIData = mutableLiveData4;
        this.debugInfo = new MutableLiveData<>();
        this.mainScope = CoroutineScopeKt.MainScope();
        QLog.d("WinkAlbumDataViewModel", 1, "init ");
        WinkAlbumDataSource winkAlbumDataSource = WinkAlbumDataSource.f324204a;
        LiveData<List<WinkAlbumItemWrapper>> w3 = winkAlbumDataSource.w();
        Observer<List<WinkAlbumItemWrapper>> observer = new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAlbumDataViewModel.N1(WinkAlbumDataViewModel.this, (List) obj);
            }
        };
        this.allAlbumDataTypeDataObserver = observer;
        w3.observeForever(observer);
        LiveData<Boolean> v3 = winkAlbumDataSource.v();
        Observer<Boolean> observer2 = new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAlbumDataViewModel.O1(WinkAlbumDataViewModel.this, (Boolean) obj);
            }
        };
        this.allAlbumDataLoadFinishedObserver = observer2;
        v3.observeForever(observer2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(WinkAlbumDataViewModel this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<WinkAlbumItemWrapper> list = this$0._allAlbumDataTypeDataList;
        list.clear();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        list.addAll(it);
        this$0.U1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(WinkAlbumDataViewModel this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MutableLiveData<Boolean> mutableLiveData = this$0._allAlbumDataLoadFinished;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.W1(mutableLiveData, it);
        this$0.U1(it.booleanValue());
        this$0.debugInfo.postValue(WinkNewAlbumCollectorDebugInstance.f324014a.n());
    }

    private final void U1(boolean finished) {
        QLog.d("WinkAlbumDataViewModel", 1, "onAllAlbumDataTypeDataChanged, size:" + this._allAlbumDataTypeDataList.size() + " finished:" + finished);
        W1(this._allAlbumDataTypeData, this._allAlbumDataTypeDataList);
        X1(finished);
    }

    private final <T> void W1(MutableLiveData<T> mutableLiveData, T t16) {
        if (!RFWThreadManager.isMainThread()) {
            BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new WinkAlbumDataViewModel$setValueSafely$1(mutableLiveData, t16, null), 3, null);
        } else {
            mutableLiveData.setValue(t16);
        }
    }

    private final void X1(boolean finished) {
        List plus;
        WinkNewMemoryAlbumResult winkNewAlbum;
        List<WinkAlbumItemWrapper> list = this._allAlbumDataTypeDataList;
        ArrayList arrayList = new ArrayList();
        for (WinkAlbumItemWrapper winkAlbumItemWrapper : list) {
            int i3 = b.f326616a[winkAlbumItemWrapper.getType().ordinal()];
            WinkAlbumItemWrapper winkAlbumItemWrapper2 = null;
            if (i3 != 1) {
                if (i3 == 2 && (winkNewAlbum = winkAlbumItemWrapper.getWinkNewAlbum()) != null) {
                    winkAlbumItemWrapper2 = com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.b.a(winkNewAlbum, WinkAlbumItemType.UI_TYPE_NEW_ALBUM_PREVIEW_ITEM);
                }
            } else {
                s53.a winkMemoryAlbum = winkAlbumItemWrapper.getWinkMemoryAlbum();
                if (winkMemoryAlbum != null) {
                    winkAlbumItemWrapper2 = com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.b.b(winkMemoryAlbum, WinkAlbumItemType.UI_TYPE_MEMORY_ALBUM_PREVIEW_ITEM);
                }
            }
            if (winkAlbumItemWrapper2 != null) {
                arrayList.add(winkAlbumItemWrapper2);
            }
        }
        if (!w83.b.f445025a.N()) {
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends WinkAlbumItemWrapper>) ((Collection<? extends Object>) arrayList), new WinkAlbumItemWrapper(WinkAlbumItemType.UI_TYPE_PREVIEW_FOOTER_ITEM, null, null, 6, null));
        } else {
            plus = finished ? CollectionsKt___CollectionsKt.plus((Collection<? extends WinkAlbumItemWrapper>) ((Collection<? extends Object>) arrayList), new WinkAlbumItemWrapper(WinkAlbumItemType.UI_TYPE_PREVIEW_FOOTER_ITEM_FINISH, null, null, 6, null)) : CollectionsKt___CollectionsKt.plus((Collection<? extends WinkAlbumItemWrapper>) ((Collection<? extends Object>) arrayList), new WinkAlbumItemWrapper(WinkAlbumItemType.UI_TYPE_PREVIEW_FOOTER_ITEM, null, null, 6, null));
        }
        W1(this._previewPageUIData, plus);
    }

    @NotNull
    public final LiveData<Boolean> P1() {
        return this.allAlbumDataLoadFinished;
    }

    @NotNull
    public final LiveData<List<WinkAlbumItemWrapper>> Q1() {
        return this.allAlbumDataTypeData;
    }

    @NotNull
    public final MutableLiveData<String> R1() {
        return this.debugInfo;
    }

    @NotNull
    public final LiveData<List<WinkAlbumItemWrapper>> S1() {
        return this.previewPageUIData;
    }

    public final void T1() {
        U1(false);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkAlbumDataViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Observer<List<WinkAlbumItemWrapper>> observer = this.allAlbumDataTypeDataObserver;
        if (observer != null) {
            WinkAlbumDataSource.f324204a.w().removeObserver(observer);
        }
        Observer<Boolean> observer2 = this.allAlbumDataLoadFinishedObserver;
        if (observer2 != null) {
            WinkAlbumDataSource.f324204a.v().removeObserver(observer2);
        }
    }
}
