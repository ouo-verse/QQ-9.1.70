package com.tencent.mobileqq.search.searchdetail.searchbox;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.searchbox.k;
import com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp2.a;
import rp2.c;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ+\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0003J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0017J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0017\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001d\u0010=\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R \u0010A\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u00070\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/SearchHistoryPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "searchLayout", "", "block", "M9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "onPartResume", "onPartPause", "onPartStop", "", "action", "", "args", "getMessage", "handleBroadcastMessage", "onPartDestroy", "Landroid/view/ViewStub;", "d", "Landroid/view/ViewStub;", "V9", "()Landroid/view/ViewStub;", "X9", "(Landroid/view/ViewStub;)V", "vtSearchLayout", "Landroidx/recyclerview/widget/LinearLayoutManager;", "e", "Landroidx/recyclerview/widget/LinearLayoutManager;", "T9", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "W9", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "linearLayoutManager", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/c;", "f", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/c;", "localHistoryAdapter", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/views/OverScrollRecyclerViewWithHeaderFooter;", tl.h.F, "Lcom/tencent/mobileqq/search/searchdetail/searchbox/views/OverScrollRecyclerViewWithHeaderFooter;", "searchRecycleView", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/v;", "i", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/v;", "suggestAdapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "searchLayoutInflated", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/SearchBoxViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/searchdetail/searchbox/k$b;", "U9", "()Lcom/tencent/mobileqq/search/searchdetail/searchbox/SearchBoxViewModel;", "roomViewModel", "Lrp2/a;", "D", "Lkotlin/jvm/functions/Function1;", "adapterItemEventListener", "<init>", "()V", "E", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchHistoryPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final k.b roomViewModel = new k.b();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function1<rp2.a, Unit> adapterItemEventListener = new Function1<rp2.a, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart$adapterItemEventListener$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(rp2.a aVar) {
            invoke2(aVar);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        
            r3 = r2.this$0.U9();
         */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2(@NotNull rp2.a event) {
            SearchBoxViewModel U9;
            SearchBoxViewModel U92;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof a.C11153a) {
                SearchHistoryPart.this.broadcastMessage("MESSAGE_UPDATETEXT", ((a.C11153a) event).getWordChangeEvent());
                SearchHistoryPart.this.M9(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart$adapterItemEventListener$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.setVisibility(8);
                        VideoReport.traverseExposure();
                    }
                });
            } else {
                if (event instanceof a.b) {
                    U92 = SearchHistoryPart.this.U9();
                    if (U92 != null) {
                        U92.b2(((a.b) event).getKeyWordData());
                        return;
                    }
                    return;
                }
                if (!(event instanceof a.c) || U9 == null) {
                    return;
                }
                U9.Z1();
            }
        }
    };

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ViewStub vtSearchLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public LinearLayoutManager linearLayoutManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c localHistoryAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OverScrollRecyclerViewWithHeaderFooter searchRecycleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private v suggestAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View searchLayoutInflated;
    static final /* synthetic */ KProperty<Object>[] F = {Reflection.property1(new PropertyReference1Impl(SearchHistoryPart.class, "roomViewModel", "getRoomViewModel()Lcom/tencent/mobileqq/search/searchdetail/searchbox/SearchBoxViewModel;", 0))};

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/search/searchdetail/searchbox/SearchHistoryPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 1) {
                SearchHistoryPart.this.broadcastMessage("MESSAGE_ON_LIST_SCROLL", null);
            }
            if (newState == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public final void M9(final Function1<? super View, Unit> block) {
        View view = this.searchLayoutInflated;
        if (view == null) {
            V9().setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.p
                @Override // android.view.ViewStub.OnInflateListener
                public final void onInflate(ViewStub viewStub, View view2) {
                    SearchHistoryPart.N9(SearchHistoryPart.this, block, viewStub, view2);
                }
            });
            View inflate = V9().inflate();
            this.searchLayoutInflated = inflate;
            if (inflate != null) {
                inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.q
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        boolean S9;
                        S9 = SearchHistoryPart.S9(view2, motionEvent);
                        return S9;
                    }
                });
                return;
            }
            return;
        }
        if (view != null) {
            block.invoke(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(final SearchHistoryPart this$0, Function1 block, ViewStub viewStub, View view) {
        String str;
        LiveData<c.SearchHistoryKeywordData> S1;
        LiveData<List<c.SearchSuggestKeywordData>> U1;
        LiveData<List<c.SearchHistoryKeywordData>> T1;
        SearchBoxViewModel U9;
        Intent intent;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(block, "$block");
        boolean z16 = true;
        QLog.i("QQSearch.NetDetail.SearchHistoryPart", 1, "inflate the search list");
        View findViewById = view.findViewById(R.id.yfi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "inflated.findViewById(R.id.layout_search)");
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) view.findViewById(R.id.f790148m);
        this$0.searchRecycleView = overScrollRecyclerViewWithHeaderFooter;
        if (overScrollRecyclerViewWithHeaderFooter != null) {
            overScrollRecyclerViewWithHeaderFooter.setOverScrollMode(2);
        }
        this$0.W9(new LinearLayoutManager(this$0.getContext()));
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this$0.searchRecycleView;
        if (overScrollRecyclerViewWithHeaderFooter2 != null) {
            overScrollRecyclerViewWithHeaderFooter2.setLayoutManager(this$0.T9());
        }
        Activity activity = this$0.getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("keyword");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16 && (U9 = this$0.U9()) != null) {
            U9.W1();
        }
        SearchBoxViewModel U92 = this$0.U9();
        if (U92 != null && (T1 = U92.T1()) != null) {
            LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
            final Function1<List<? extends c.SearchHistoryKeywordData>, Unit> function1 = new Function1<List<? extends c.SearchHistoryKeywordData>, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart$ensureInflated$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends c.SearchHistoryKeywordData> list) {
                    invoke2((List<c.SearchHistoryKeywordData>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<c.SearchHistoryKeywordData> it) {
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3;
                    Function1 function12;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter5;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter6;
                    RecyclerView.Adapter adapter;
                    c cVar;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter7;
                    if (it.isEmpty()) {
                        overScrollRecyclerViewWithHeaderFooter7 = SearchHistoryPart.this.searchRecycleView;
                        if (overScrollRecyclerViewWithHeaderFooter7 != null) {
                            overScrollRecyclerViewWithHeaderFooter7.setVisibility(4);
                        }
                    } else {
                        overScrollRecyclerViewWithHeaderFooter3 = SearchHistoryPart.this.searchRecycleView;
                        if (overScrollRecyclerViewWithHeaderFooter3 != null) {
                            overScrollRecyclerViewWithHeaderFooter3.setVisibility(0);
                        }
                    }
                    SearchHistoryPart searchHistoryPart = SearchHistoryPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    function12 = SearchHistoryPart.this.adapterItemEventListener;
                    searchHistoryPart.localHistoryAdapter = new c(it, function12);
                    overScrollRecyclerViewWithHeaderFooter4 = SearchHistoryPart.this.searchRecycleView;
                    if (overScrollRecyclerViewWithHeaderFooter4 != null) {
                        cVar = SearchHistoryPart.this.localHistoryAdapter;
                        overScrollRecyclerViewWithHeaderFooter4.setAdapter(cVar);
                    }
                    overScrollRecyclerViewWithHeaderFooter5 = SearchHistoryPart.this.searchRecycleView;
                    if (overScrollRecyclerViewWithHeaderFooter5 != null && (adapter = overScrollRecyclerViewWithHeaderFooter5.getAdapter()) != null) {
                        adapter.notifyDataSetChanged();
                    }
                    overScrollRecyclerViewWithHeaderFooter6 = SearchHistoryPart.this.searchRecycleView;
                    VideoReport.traversePage(overScrollRecyclerViewWithHeaderFooter6);
                }
            };
            T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.r
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SearchHistoryPart.O9(Function1.this, obj);
                }
            });
        }
        SearchBoxViewModel U93 = this$0.U9();
        if (U93 != null && (U1 = U93.U1()) != null) {
            LifecycleOwner lifecycleOwner2 = this$0.getPartHost().getLifecycleOwner();
            final Function1<List<? extends c.SearchSuggestKeywordData>, Unit> function12 = new Function1<List<? extends c.SearchSuggestKeywordData>, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart$ensureInflated$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends c.SearchSuggestKeywordData> list) {
                    invoke2((List<c.SearchSuggestKeywordData>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<c.SearchSuggestKeywordData> it) {
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3;
                    Function1 function13;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter5;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter6;
                    RecyclerView.Adapter adapter;
                    v vVar;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter7;
                    if (it.isEmpty()) {
                        overScrollRecyclerViewWithHeaderFooter7 = SearchHistoryPart.this.searchRecycleView;
                        if (overScrollRecyclerViewWithHeaderFooter7 != null) {
                            overScrollRecyclerViewWithHeaderFooter7.setVisibility(4);
                        }
                    } else {
                        overScrollRecyclerViewWithHeaderFooter3 = SearchHistoryPart.this.searchRecycleView;
                        if (overScrollRecyclerViewWithHeaderFooter3 != null) {
                            overScrollRecyclerViewWithHeaderFooter3.setVisibility(0);
                        }
                    }
                    Object broadcastGetMessage = SearchHistoryPart.this.broadcastGetMessage("MESSAGE_GET_CURRENT_KEYWORD", null);
                    String str2 = broadcastGetMessage instanceof String ? (String) broadcastGetMessage : null;
                    if (str2 == null) {
                        QLog.e("QQSearch.NetDetail.SearchHistoryPart", 1, "empty keyword in search bar");
                        return;
                    }
                    Object broadcastGetMessage2 = SearchHistoryPart.this.broadcastGetMessage("getPageSessionId", "");
                    String str3 = broadcastGetMessage2 instanceof String ? (String) broadcastGetMessage2 : null;
                    String str4 = str3 != null ? str3 : "";
                    SearchHistoryPart searchHistoryPart = SearchHistoryPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    function13 = SearchHistoryPart.this.adapterItemEventListener;
                    searchHistoryPart.suggestAdapter = new v(it, str2, str4, function13);
                    overScrollRecyclerViewWithHeaderFooter4 = SearchHistoryPart.this.searchRecycleView;
                    if (overScrollRecyclerViewWithHeaderFooter4 != null) {
                        vVar = SearchHistoryPart.this.suggestAdapter;
                        overScrollRecyclerViewWithHeaderFooter4.setAdapter(vVar);
                    }
                    overScrollRecyclerViewWithHeaderFooter5 = SearchHistoryPart.this.searchRecycleView;
                    if (overScrollRecyclerViewWithHeaderFooter5 != null && (adapter = overScrollRecyclerViewWithHeaderFooter5.getAdapter()) != null) {
                        adapter.notifyDataSetChanged();
                    }
                    overScrollRecyclerViewWithHeaderFooter6 = SearchHistoryPart.this.searchRecycleView;
                    VideoReport.traversePage(overScrollRecyclerViewWithHeaderFooter6);
                }
            };
            U1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.s
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SearchHistoryPart.P9(Function1.this, obj);
                }
            });
        }
        SearchBoxViewModel U94 = this$0.U9();
        if (U94 != null && (S1 = U94.S1()) != null) {
            LifecycleOwner lifecycleOwner3 = this$0.getPartHost().getLifecycleOwner();
            final Function1<c.SearchHistoryKeywordData, Unit> function13 = new Function1<c.SearchHistoryKeywordData, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart$ensureInflated$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(c.SearchHistoryKeywordData searchHistoryKeywordData) {
                    invoke2(searchHistoryKeywordData);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
                
                    r4 = r3.this$0.searchRecycleView;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(c.SearchHistoryKeywordData it) {
                    c cVar;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3;
                    cVar = SearchHistoryPart.this.localHistoryAdapter;
                    boolean z17 = false;
                    if (cVar != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        if (cVar.o0(it)) {
                            z17 = true;
                        }
                    }
                    if (!z17 || overScrollRecyclerViewWithHeaderFooter3 == null) {
                        return;
                    }
                    overScrollRecyclerViewWithHeaderFooter3.setVisibility(4);
                }
            };
            S1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.t
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SearchHistoryPart.Q9(Function1.this, obj);
                }
            });
        }
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this$0.searchRecycleView;
        if (overScrollRecyclerViewWithHeaderFooter3 != null) {
            overScrollRecyclerViewWithHeaderFooter3.E(new OverScrollRecyclerViewWithHeaderFooter.i() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.u
                @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.i
                public final void a(RecyclerView recyclerView, int i3, int i16) {
                    SearchHistoryPart.R9(SearchHistoryPart.this, recyclerView, i3, i16);
                }
            });
        }
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4 = this$0.searchRecycleView;
        if (overScrollRecyclerViewWithHeaderFooter4 != null) {
            overScrollRecyclerViewWithHeaderFooter4.addOnScrollListener(new b());
        }
        block.invoke(findViewById);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(SearchHistoryPart this$0, RecyclerView recyclerView, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("MESSAGE_ON_LIST_SCROLL", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S9(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchBoxViewModel U9() {
        return this.roomViewModel.getValue(this, F[0]);
    }

    @NotNull
    public final LinearLayoutManager T9() {
        LinearLayoutManager linearLayoutManager = this.linearLayoutManager;
        if (linearLayoutManager != null) {
            return linearLayoutManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
        return null;
    }

    @NotNull
    public final ViewStub V9() {
        ViewStub viewStub = this.vtSearchLayout;
        if (viewStub != null) {
            return viewStub;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vtSearchLayout");
        return null;
    }

    public final void W9(@NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "<set-?>");
        this.linearLayoutManager = linearLayoutManager;
    }

    public final void X9(@NotNull ViewStub viewStub) {
        Intrinsics.checkNotNullParameter(viewStub, "<set-?>");
        this.vtSearchLayout = viewStub;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        boolean z16;
        if (Intrinsics.areEqual(action, "MESSAGE_GET_IS_CONTAINER_SHOEING")) {
            View view = this.searchLayoutInflated;
            if (view == null) {
                return Boolean.FALSE;
            }
            if (view != null) {
                if (view.getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            }
            return null;
        }
        return super.getMessage(action, args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -2098594167) {
                if (hashCode != -1617718368) {
                    if (hashCode == 1272129915 && action.equals("MESSAGE_HIDE_SEARCH_FRAME")) {
                        Logger.f235387a.d().i("QQSearch.NetDetail.SearchHistoryPart", 1, "MESSAGE_HIDE_SEARCH_FRAME");
                        M9(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart$handleBroadcastMessage$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                invoke2(view);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull View it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                it.setVisibility(8);
                                VideoReport.traverseExposure();
                            }
                        });
                        return;
                    }
                } else if (action.equals("MESSAGE_SHOW_SEARCH_FRAME")) {
                    Logger.f235387a.d().i("QQSearch.NetDetail.SearchHistoryPart", 1, "MESSAGE_SHOW_SEARCH_FRAME");
                    M9(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart$handleBroadcastMessage$4
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.setVisibility(0);
                        }
                    });
                    return;
                }
            } else if (action.equals("MESSAGE_CHANGE_LOCAL_HISTORY")) {
                M9(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart$handleBroadcastMessage$5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.setVisibility(0);
                    }
                });
                SearchBoxViewModel U9 = U9();
                if (U9 != null) {
                    U9.W1();
                    return;
                }
                return;
            }
        }
        super.handleBroadcastMessage(action, args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @SuppressLint({"ClickableViewAccessibility"})
    public void onInitView(@Nullable View rootView) {
        String str;
        boolean isBlank;
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.f1205379t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.vt_layout_search)");
        X9((ViewStub) findViewById);
        Bundle arguments = getHostFragment().getArguments();
        String str2 = "";
        if (arguments != null) {
            str = arguments.getString("keyword", "");
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str2);
        if (isBlank) {
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchHistoryPart", 1, "keyword is blank show view");
            M9(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart$onInitView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    SearchBoxViewModel U9;
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.setVisibility(0);
                    U9 = SearchHistoryPart.this.U9();
                    if (U9 != null) {
                        U9.W1();
                    }
                }
            });
            return;
        }
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchHistoryPart", 1, "onInitView " + cq.w(str2, 2));
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.searchRecycleView;
        if (overScrollRecyclerViewWithHeaderFooter != null) {
            overScrollRecyclerViewWithHeaderFooter.clearOnScrollListeners();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        View view = this.searchLayoutInflated;
        if (view != null && view.getVisibility() == 0) {
            broadcastMessage("MESSAGE_SHOW_KEYBOARD", "");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        super.onPartStart(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
    }
}
