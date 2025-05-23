package bn3;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.linkpkanchorplay.search.model.SearchDataModel;
import com.tencent.now.linkpkanchorplay.search.model.SearchHistoryData;
import com.tencent.now.linkpkanchorplay.search.model.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\fJ\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\fJ\u0006\u0010\u0013\u001a\u00020\u0005J\b\u0010\u0014\u001a\u00020\u0005H\u0014J\u0006\u0010\u0015\u001a\u00020\u0005R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lbn3/a;", "Landroidx/lifecycle/ViewModel;", "", "keyword", "extra", "", "T1", "S1", "searchLabel", "U1", "Lcom/tencent/now/linkpkanchorplay/search/model/a;", "O1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel$c;", "Q1", "R1", "", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchHistoryData;", "P1", "N1", "onCleared", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "i", "Landroidx/lifecycle/MutableLiveData;", "resultAnchorLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "searchLableLiveData", BdhLogUtil.LogTag.Tag_Conn, "searchHistoryLiveData", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel;", "D", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel;", "searchDataModel", "E", "Lcom/tencent/now/linkpkanchorplay/search/model/a;", "searchHistoryModel", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends ViewModel {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.now.linkpkanchorplay.search.model.a searchHistoryModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<SearchDataModel.SearchResult> resultAnchorLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> searchLableLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<SearchHistoryData>> searchHistoryLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final SearchDataModel searchDataModel = new SearchDataModel();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"bn3/a$a", "Lcom/tencent/now/linkpkanchorplay/search/model/a$b;", "", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchHistoryData;", "dataList", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bn3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C0139a implements a.b {
        C0139a() {
        }

        @Override // com.tencent.now.linkpkanchorplay.search.model.a.b
        public void a(@NotNull List<SearchHistoryData> dataList) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            a.this.searchHistoryLiveData.setValue(dataList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"bn3/a$b", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel$b;", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel$c;", "searchResult", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements SearchDataModel.b {
        b() {
        }

        @Override // com.tencent.now.linkpkanchorplay.search.model.SearchDataModel.b
        public void a(@Nullable SearchDataModel.SearchResult searchResult) {
            if (searchResult != null) {
                a.this.resultAnchorLiveData.setValue(searchResult);
            }
        }
    }

    public a() {
        com.tencent.now.linkpkanchorplay.search.model.a aVar = new com.tencent.now.linkpkanchorplay.search.model.a();
        this.searchHistoryModel = aVar;
        aVar.j(new C0139a());
    }

    public final void N1() {
        this.searchHistoryModel.a();
    }

    @NotNull
    /* renamed from: O1, reason: from getter */
    public final com.tencent.now.linkpkanchorplay.search.model.a getSearchHistoryModel() {
        return this.searchHistoryModel;
    }

    @NotNull
    public final MutableLiveData<List<SearchHistoryData>> P1() {
        return this.searchHistoryLiveData;
    }

    @NotNull
    public final MutableLiveData<SearchDataModel.SearchResult> Q1() {
        return this.resultAnchorLiveData;
    }

    @NotNull
    public final MutableLiveData<String> R1() {
        return this.searchLableLiveData;
    }

    public final void S1(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.searchHistoryModel.i(keyword);
    }

    public final void T1(@NotNull String keyword, @NotNull String extra) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.searchDataModel.c(keyword, new b(), extra);
    }

    public final void U1(@NotNull String searchLabel) {
        Intrinsics.checkNotNullParameter(searchLabel, "searchLabel");
        this.searchLableLiveData.setValue(searchLabel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        onDestroy();
    }

    public final void onDestroy() {
        this.searchHistoryModel.j(null);
        this.searchHistoryModel.f();
        this.searchDataModel.a();
    }
}
