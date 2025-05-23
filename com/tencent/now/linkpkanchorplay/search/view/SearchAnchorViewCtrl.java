package com.tencent.now.linkpkanchorplay.search.view;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.component.core.log.LogUtil;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.search.model.SearchDataModel;
import com.tencent.now.linkpkanchorplay.search.view.SearchResultView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002SW\u0018\u0000 \u000f2\u00020\u0001:\u0002_`B/\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0002R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010.\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b9\u0010:R#\u0010@\u001a\n =*\u0004\u0018\u00010<0<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b>\u0010?R#\u0010C\u001a\n =*\u0004\u0018\u00010<0<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010.\u001a\u0004\bB\u0010?R\u0016\u0010F\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010.\u001a\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010MR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020P0O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010XR\u0014\u0010\\\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010[\u00a8\u0006a"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl;", "Lcom/tencent/component/core/thread/ThreadCenter$HandlerKeyable;", "", "y", "N", UserInfo.SEX_FEMALE, "B", "", "actionId", "Landroid/view/KeyEvent;", "event", "", "H", "r", "O", "P", "K", "contentType", "M", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "J", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "e", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "Landroidx/lifecycle/ViewModelStoreOwner;", "f", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwne", "Landroidx/lifecycle/LifecycleOwner;", tl.h.F, "Landroidx/lifecycle/LifecycleOwner;", "lifeCycleOwner", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$a;", "i", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$a;", "cancelListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/EditText;", "Lkotlin/Lazy;", "w", "()Landroid/widget/EditText;", "searchEdit", "Landroid/widget/ImageView;", "D", "t", "()Landroid/widget/ImageView;", "clearBtn", "Landroid/widget/TextView;", "E", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/TextView;", "cancelBtn", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "u", "()Landroid/widget/FrameLayout;", "historyViewContainer", "G", "v", "resultViewContainer", "", "Ljava/lang/String;", "searchWord", "Lbn3/a;", "I", HippyTKDListViewAdapter.X, "()Lbn3/a;", "searchViewModel", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchResultView;", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchResultView;", "resultView", "Landroidx/lifecycle/Observer;", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel$c;", "Landroidx/lifecycle/Observer;", "resultObserver", "com/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$e", "L", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$e;", "textWatcher", "com/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$c", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$c;", "editorActionListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "searchRunnable", "<init>", "(Landroid/content/Context;Lcom/tencent/now/linkpkanchorplay/invite/model/a;Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$a;)V", "a", "b", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class SearchAnchorViewCtrl implements ThreadCenter.HandlerKeyable {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchEdit;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy clearBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy cancelBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy historyViewContainer;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy resultViewContainer;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String searchWord;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private SearchResultView resultView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Observer<SearchDataModel.SearchResult> resultObserver;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final e textWatcher;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final c editorActionListener;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Runnable searchRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorTabPageContext pageContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelStoreOwner viewModelStoreOwne;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifeCycleOwner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a cancelListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$a;", "", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$c", "Landroid/widget/TextView$OnEditorActionListener;", "Landroid/widget/TextView;", "view", "", "actionId", "Landroid/view/KeyEvent;", "event", "", "onEditorAction", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements TextView.OnEditorActionListener {
        c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(@Nullable TextView view, int actionId, @Nullable KeyEvent event) {
            boolean z16 = true;
            if (actionId == 3) {
                UIUtil.c(ul3.b.d(), SearchAnchorViewCtrl.this.w().getWindowToken());
                SearchAnchorViewCtrl.this.x().S1(SearchAnchorViewCtrl.this.searchWord);
                SearchAnchorViewCtrl.this.O();
            } else if (SearchAnchorViewCtrl.this.H(actionId, event)) {
                SearchAnchorViewCtrl.this.x().S1(SearchAnchorViewCtrl.this.searchWord);
                UIUtil.c(ul3.b.d(), SearchAnchorViewCtrl.this.w().getWindowToken());
            } else {
                z16 = false;
            }
            EventCollector.getInstance().onEditorAction(view, actionId, event);
            return z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$d", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchResultView$b;", "", "extra", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements SearchResultView.b {
        d() {
        }

        @Override // com.tencent.now.linkpkanchorplay.search.view.SearchResultView.b
        public void a(@NotNull String extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
            SearchAnchorViewCtrl.this.x().T1(SearchAnchorViewCtrl.this.searchWord, extra);
        }
    }

    public SearchAnchorViewCtrl(@NotNull Context context, @NotNull AnchorTabPageContext pageContext, @NotNull ViewModelStoreOwner viewModelStoreOwne, @NotNull LifecycleOwner lifeCycleOwner, @NotNull a cancelListener) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(viewModelStoreOwne, "viewModelStoreOwne");
        Intrinsics.checkNotNullParameter(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(cancelListener, "cancelListener");
        this.context = context;
        this.pageContext = pageContext;
        this.viewModelStoreOwne = viewModelStoreOwne;
        this.lifeCycleOwner = lifeCycleOwner;
        this.cancelListener = cancelListener;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ffi, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026search_anchor_view, null)");
        this.rootView = inflate;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: com.tencent.now.linkpkanchorplay.search.view.SearchAnchorViewCtrl$searchEdit$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                View view;
                view = SearchAnchorViewCtrl.this.rootView;
                return (EditText) view.findViewById(R.id.f80824ci);
            }
        });
        this.searchEdit = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.now.linkpkanchorplay.search.view.SearchAnchorViewCtrl$clearBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = SearchAnchorViewCtrl.this.rootView;
                return (ImageView) view.findViewById(R.id.uxw);
            }
        });
        this.clearBtn = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.now.linkpkanchorplay.search.view.SearchAnchorViewCtrl$cancelBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = SearchAnchorViewCtrl.this.rootView;
                return (TextView) view.findViewById(R.id.aou);
            }
        });
        this.cancelBtn = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.now.linkpkanchorplay.search.view.SearchAnchorViewCtrl$historyViewContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View view;
                view = SearchAnchorViewCtrl.this.rootView;
                return (FrameLayout) view.findViewById(R.id.f80984cy);
            }
        });
        this.historyViewContainer = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.now.linkpkanchorplay.search.view.SearchAnchorViewCtrl$resultViewContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View view;
                view = SearchAnchorViewCtrl.this.rootView;
                return (FrameLayout) view.findViewById(R.id.f81144dd);
            }
        });
        this.resultViewContainer = lazy5;
        this.searchWord = "";
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<bn3.a>() { // from class: com.tencent.now.linkpkanchorplay.search.view.SearchAnchorViewCtrl$searchViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final bn3.a invoke() {
                ViewModelStoreOwner viewModelStoreOwner;
                viewModelStoreOwner = SearchAnchorViewCtrl.this.viewModelStoreOwne;
                return (bn3.a) new ViewModelProvider(viewModelStoreOwner).get(bn3.a.class);
            }
        });
        this.searchViewModel = lazy6;
        bn3.a searchViewModel = x();
        Intrinsics.checkNotNullExpressionValue(searchViewModel, "searchViewModel");
        this.resultView = new SearchResultView(context, pageContext, searchViewModel, lifeCycleOwner, new d());
        this.resultObserver = new Observer() { // from class: com.tencent.now.linkpkanchorplay.search.view.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchAnchorViewCtrl.I(SearchAnchorViewCtrl.this, (SearchDataModel.SearchResult) obj);
            }
        };
        this.textWatcher = new e();
        this.editorActionListener = new c();
        this.searchRunnable = new Runnable() { // from class: com.tencent.now.linkpkanchorplay.search.view.b
            @Override // java.lang.Runnable
            public final void run() {
                SearchAnchorViewCtrl.L(SearchAnchorViewCtrl.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(SearchAnchorViewCtrl this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIUtil.c(ul3.b.d(), this$0.w().getWindowToken());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void B() {
        w().setFocusable(true);
        w().requestFocus();
        w().addTextChangedListener(this.textWatcher);
        w().setOnEditorActionListener(this.editorActionListener);
        w().setHint(fn3.c.h(this.context, this.pageContext.getCurSelectInviteType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(SearchAnchorViewCtrl this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(SearchAnchorViewCtrl this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
        this$0.cancelListener.a();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void F() {
        x().Q1().observe(this.lifeCycleOwner, this.resultObserver);
        x().R1().observe(this.lifeCycleOwner, new Observer() { // from class: com.tencent.now.linkpkanchorplay.search.view.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchAnchorViewCtrl.G(SearchAnchorViewCtrl.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(SearchAnchorViewCtrl this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w().setText(it);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.searchWord = it;
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H(int actionId, KeyEvent event) {
        if (actionId != 4 && actionId != 6 && (event == null || event.getKeyCode() != 66 || event.getAction() != 0)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(SearchAnchorViewCtrl this$0, SearchDataModel.SearchResult searchResult) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (searchResult != null) {
            if (this$0.searchWord.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this$0.M(1);
            }
        }
    }

    private final void K() {
        this.resultView.e();
        x().T1(this.searchWord, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(SearchAnchorViewCtrl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
    }

    private final void M(int contentType) {
        if (contentType != 1) {
            if (contentType == 2) {
                u().setVisibility(0);
                v().setVisibility(8);
                return;
            }
            return;
        }
        LogUtil.i("SearchDataModel", "showContentPanel", new Object[0]);
        u().setVisibility(8);
        v().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        M(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        P();
        ThreadCenter.postDelayedUITask(this, this.searchRunnable, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        ThreadCenter.removeUITask(this, this.searchRunnable);
    }

    private final void r() {
        w().setText("");
        w().getPaint().setFakeBoldText(false);
        P();
        N();
    }

    private final TextView s() {
        Object value = this.cancelBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cancelBtn>(...)");
        return (TextView) value;
    }

    private final ImageView t() {
        Object value = this.clearBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-clearBtn>(...)");
        return (ImageView) value;
    }

    private final FrameLayout u() {
        return (FrameLayout) this.historyViewContainer.getValue();
    }

    private final FrameLayout v() {
        return (FrameLayout) this.resultViewContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText w() {
        Object value = this.searchEdit.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-searchEdit>(...)");
        return (EditText) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final bn3.a x() {
        return (bn3.a) this.searchViewModel.getValue();
    }

    private final void y() {
        FrameLayout u16 = u();
        Context context = this.context;
        bn3.a searchViewModel = x();
        Intrinsics.checkNotNullExpressionValue(searchViewModel, "searchViewModel");
        u16.addView(new SearchHistoryView(context, searchViewModel, this.lifeCycleOwner));
        u().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.search.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAnchorViewCtrl.z(SearchAnchorViewCtrl.this, view);
            }
        });
        v().addView(this.resultView);
        v().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.search.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAnchorViewCtrl.A(SearchAnchorViewCtrl.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(SearchAnchorViewCtrl this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIUtil.c(ul3.b.d(), this$0.w().getWindowToken());
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final View C() {
        new FrameLayout.LayoutParams(-1, -2).gravity = 80;
        this.rootView.setVisibility(0);
        B();
        t().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.search.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAnchorViewCtrl.D(SearchAnchorViewCtrl.this, view);
            }
        });
        s().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.search.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAnchorViewCtrl.E(SearchAnchorViewCtrl.this, view);
            }
        });
        F();
        y();
        N();
        com.tencent.report.a.f364907a.f(this.rootView, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, zm3.a.f452778a.b());
        return this.rootView;
    }

    public final void J() {
        x().S1(this.searchWord);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$e", "Landroid/text/TextWatcher;", "", "p0", "", "p1", "p2", "p3", "", "beforeTextChanged", "onTextChanged", "Landroid/text/Editable;", "editable", "afterTextChanged", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "editable");
            Selection.setSelection(editable, editable.length());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence p06, int p16, int p26, int p36) {
            boolean endsWith$default;
            boolean endsWith$default2;
            String valueOf = String.valueOf(p06);
            SearchAnchorViewCtrl.this.searchWord = valueOf;
            boolean z16 = false;
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(valueOf, "\n", false, 2, null);
            if (endsWith$default) {
                StringsKt__StringsJVMKt.replace$default(SearchAnchorViewCtrl.this.searchWord, "\n", "", false, 4, (Object) null);
                SearchAnchorViewCtrl.this.w().setSelection(SearchAnchorViewCtrl.this.searchWord.length());
                SearchAnchorViewCtrl.this.w().setText(SearchAnchorViewCtrl.this.searchWord);
                SearchAnchorViewCtrl.this.w().getPaint().setFakeBoldText(true);
            } else {
                endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(valueOf, " ", false, 2, null);
                if (endsWith$default2) {
                    return;
                }
            }
            if (valueOf.length() == 0) {
                z16 = true;
            }
            if (z16) {
                SearchAnchorViewCtrl.this.P();
                SearchAnchorViewCtrl.this.N();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence p06, int p16, int p26, int p36) {
        }
    }
}
