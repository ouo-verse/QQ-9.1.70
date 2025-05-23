package com.tencent.mobileqq.search.business.addcontact.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.business.addcontact.views.SearchHistoryContainer;
import com.tencent.mobileqq.search.util.MmkvKeys;
import com.tencent.mobileqq.search.util.ab;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \"2\u00020\u0001:\n#$%&'(\r)*\u0013B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR&\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R<\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u00168F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer;", "Landroidx/recyclerview/widget/RecyclerView;", "", "showAll", "", "O", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "M", "L", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$f;", "f", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$f;", "itemAdapter", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$b;", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "items", "Lkotlin/Function1;", "", "value", "getOnHistorySearchItemClickCallback", "()Lkotlin/jvm/functions/Function1;", "setOnHistorySearchItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "onHistorySearchItemClickCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "a", "b", "c", "SearchHistoryActionDelegate", "d", "e", "SearchHistoryItemDelegate", "g", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchHistoryContainer extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private f itemAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<b> items;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isShowMore", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.search.business.addcontact.views.SearchHistoryContainer$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(SearchHistoryContainer this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.R();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z16) {
            List emptyList;
            if (z16) {
                SearchHistoryContainer.this.O(true);
                return;
            }
            ab.f(MmkvKeys.MMKV_KEY_FIND_USER_AND_GROUP_SEARCH_HISTORY_KEY);
            SearchHistoryContainer.this.items.clear();
            f fVar = SearchHistoryContainer.this.itemAdapter;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                fVar = null;
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            final SearchHistoryContainer searchHistoryContainer = SearchHistoryContainer.this;
            fVar.setItems(emptyList, new Runnable() { // from class: com.tencent.mobileqq.search.business.addcontact.views.d
                @Override // java.lang.Runnable
                public final void run() {
                    SearchHistoryContainer.AnonymousClass2.b(SearchHistoryContainer.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B@\u0012%\u0010\u001d\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014j\u0002`\u0018\u0012\u0010\u0010$\u001a\f\u0012\u0004\u0012\u00020\b0\u001ej\u0002`\u001f\u00a2\u0006\u0004\b%\u0010&J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R6\u0010\u001d\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014j\u0002`\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR!\u0010$\u001a\f\u0012\u0004\u0012\u00020\b0\u001ej\u0002`\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$SearchHistoryActionDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$d;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$b;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShowMore", "Lcom/tencent/mobileqq/search/business/addcontact/views/OnAction;", "d", "Lkotlin/jvm/functions/Function1;", "getOnAction", "()Lkotlin/jvm/functions/Function1;", "onAction", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/search/business/addcontact/views/OnGetHistoryCount;", "e", "Lkotlin/jvm/functions/Function0;", "getOnGetHistoryCount", "()Lkotlin/jvm/functions/Function0;", "onGetHistoryCount", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class SearchHistoryActionDelegate extends AbsListItemAdapterDelegate<SearchHistoryActionItem, b, e> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<Boolean, Unit> onAction;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<Integer> onGetHistoryCount;

        /* JADX WARN: Multi-variable type inference failed */
        public SearchHistoryActionDelegate(@NotNull Function1<? super Boolean, Unit> onAction, @NotNull Function0<Integer> onGetHistoryCount) {
            Intrinsics.checkNotNullParameter(onAction, "onAction");
            Intrinsics.checkNotNullParameter(onGetHistoryCount, "onGetHistoryCount");
            this.onAction = onAction;
            this.onGetHistoryCount = onGetHistoryCount;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public boolean j(@NotNull b item, @NotNull List<b> items, int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(items, "items");
            return item instanceof SearchHistoryActionItem;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void l(@NotNull SearchHistoryActionItem item, @NotNull e holder, @NotNull List<Object> payloads) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            holder.n(item);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
        @NotNull
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public e d(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return e.INSTANCE.a(parent, this.onAction, this.onGetHistoryCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B!\u0012\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0015\u00a2\u0006\u0004\b$\u0010%J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014J.\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\t\u001a\u00020\bH\u0014R)\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR.\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$SearchHistoryItemDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$g;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$b;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "v", "holder", "", "payloads", "", "r", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function2;", "", "d", "Lkotlin/jvm/functions/Function2;", "getOnRemoveKeyword", "()Lkotlin/jvm/functions/Function2;", "onRemoveKeyword", "Lkotlin/Function1;", "e", "Lkotlin/jvm/functions/Function1;", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "w", "(Lkotlin/jvm/functions/Function1;)V", "onItemClick", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class SearchHistoryItemDelegate extends AbsListItemAdapterDelegate<SearchHistoryTextItem, b, h> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function2<String, Integer, Unit> onRemoveKeyword;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Function1<? super String, Unit> onItemClick;

        /* JADX WARN: Multi-variable type inference failed */
        public SearchHistoryItemDelegate(@NotNull Function2<? super String, ? super Integer, Unit> onRemoveKeyword) {
            Intrinsics.checkNotNullParameter(onRemoveKeyword, "onRemoveKeyword");
            this.onRemoveKeyword = onRemoveKeyword;
            this.onItemClick = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.search.business.addcontact.views.SearchHistoryContainer$SearchHistoryItemDelegate$onItemClick$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(SearchHistoryItemDelegate this$0, SearchHistoryTextItem item, h holder, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            this$0.onRemoveKeyword.invoke(item.getText(), Integer.valueOf(holder.getAdapterPosition()));
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void u(SearchHistoryItemDelegate this$0, SearchHistoryTextItem item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onItemClick.invoke(item.getText());
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public boolean j(@NotNull b item, @NotNull List<b> items, int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(items, "items");
            return item instanceof SearchHistoryTextItem;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void l(@NotNull SearchHistoryTextItem item, @NotNull h holder, @NotNull List<Object> payloads) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public void m(@NotNull final SearchHistoryTextItem item, @NotNull final h holder, @NotNull List<Object> payloads, int position) {
            Map mapOf;
            Map mapOf2;
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            QLog.i("SearchHistoryContainer", 1, "onBindViewHolder: " + item);
            holder.getTextView().setText(item.getText());
            TextView textView = holder.getTextView();
            String valueOf = String.valueOf(item.hashCode());
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("serial_number", Integer.valueOf(position)));
            if1.a.b(textView, "em_bas_search_historical_entry", valueOf, mapOf, null, null, null, null, null, 248, null);
            ImageView closeView = holder.getCloseView();
            String valueOf2 = String.valueOf(item.hashCode());
            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("serial_number", Integer.valueOf(position)));
            if1.a.b(closeView, "em_bas_history_deletion", valueOf2, mapOf2, null, null, null, null, null, 248, null);
            holder.getCloseView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.business.addcontact.views.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHistoryContainer.SearchHistoryItemDelegate.t(SearchHistoryContainer.SearchHistoryItemDelegate.this, item, holder, view);
                }
            });
            holder.getTextView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.business.addcontact.views.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHistoryContainer.SearchHistoryItemDelegate.u(SearchHistoryContainer.SearchHistoryItemDelegate.this, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
        @NotNull
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public h d(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return h.INSTANCE.a(parent);
        }

        public final void w(@NotNull Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onItemClick = function1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bb\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$b;", "", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$c;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$b;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class c extends DiffUtil.ItemCallback<b> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull b oldItem, @NotNull b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull b oldItem, @NotNull b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$d;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "showMore", "<init>", "(Z)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.business.addcontact.views.SearchHistoryContainer$d, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class SearchHistoryActionItem implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean showMore;

        public SearchHistoryActionItem(boolean z16) {
            this.showMore = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShowMore() {
            return this.showMore;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SearchHistoryActionItem) && this.showMore == ((SearchHistoryActionItem) other).showMore) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.showMore;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "SearchHistoryActionItem(showMore=" + this.showMore + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001\"BH\u0012\u0006\u0010\u0003\u001a\u00020\u0019\u0012%\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`\u000b\u0012\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R3\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isShowMore", "Lcom/tencent/mobileqq/search/business/addcontact/views/OnAction;", "E", "Lkotlin/jvm/functions/Function1;", "onAction", "Lkotlin/Function0;", "", "Lcom/tencent/mobileqq/search/business/addcontact/views/OnGetHistoryCount;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function0;", "onGetHistoryCount", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "H", "Landroid/view/View;", TtmlNode.TAG_LAYOUT, "I", "historyCount", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "J", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e extends RecyclerView.ViewHolder {

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Function1<Boolean, Unit> onAction;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final Function0<Integer> onGetHistoryCount;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final View layout;

        /* renamed from: I, reason: from kotlin metadata */
        private int historyCount;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JG\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022%\u0010\u000b\u001a!\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n2\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$e$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isShowMore", "", "Lcom/tencent/mobileqq/search/business/addcontact/views/OnAction;", "onAction", "Lkotlin/Function0;", "", "Lcom/tencent/mobileqq/search/business/addcontact/views/OnGetHistoryCount;", "onGetHistoryCount", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$e;", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.business.addcontact.views.SearchHistoryContainer$e$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final e a(@NotNull ViewGroup parent, @NotNull Function1<? super Boolean, Unit> onAction, @NotNull Function0<Integer> onGetHistoryCount) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(onAction, "onAction");
                Intrinsics.checkNotNullParameter(onGetHistoryCount, "onGetHistoryCount");
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hpk, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026tion_item, parent, false)");
                return new e(inflate, onAction, onGetHistoryCount);
            }

            Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(@NotNull View item, @NotNull Function1<? super Boolean, Unit> onAction, @NotNull Function0<Integer> onGetHistoryCount) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(onAction, "onAction");
            Intrinsics.checkNotNullParameter(onGetHistoryCount, "onGetHistoryCount");
            this.onAction = onAction;
            this.onGetHistoryCount = onGetHistoryCount;
            View findViewById = this.itemView.findViewById(R.id.jfb);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.text)");
            this.textView = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.tiu);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(co\u2026h.api.R.id.button_action)");
            this.layout = findViewById2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map o(e this$0, String str) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("historical_term_number", Integer.valueOf(this$0.historyCount)));
            return mutableMapOf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(e this$0, boolean z16, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.historyCount = this$0.onGetHistoryCount.invoke().intValue();
            this$0.onAction.invoke(Boolean.valueOf(z16));
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void n(@NotNull SearchHistoryActionItem item) {
            String str;
            Intrinsics.checkNotNullParameter(item, "item");
            final boolean showMore = item.getShowMore();
            if (showMore) {
                this.textView.setText("\u5168\u90e8\u641c\u7d22\u8bb0\u5f55");
                str = "em_bas_all_search_history";
            } else {
                this.textView.setText("\u6e05\u9664\u641c\u7d22\u8bb0\u5f55");
                str = "em_bas_clear_history";
            }
            this.historyCount = this.onGetHistoryCount.invoke().intValue();
            if1.a.b(this.layout, str, String.valueOf(item.hashCode()), null, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.search.business.addcontact.views.e
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str2) {
                    Map o16;
                    o16 = SearchHistoryContainer.e.o(SearchHistoryContainer.e.this, str2);
                    return o16;
                }
            }, 124, null);
            this.layout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.business.addcontact.views.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHistoryContainer.e.p(SearchHistoryContainer.e.this, showMore, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B|\u0012:\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b\u0012%\u0010\u0019\u001a!\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\u0011j\u0002`\u0014\u0012\u0010\u0010 \u001a\f\u0012\u0004\u0012\u00020\b0\u001aj\u0002`\u001b\u00a2\u0006\u0004\b2\u00103RK\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR6\u0010\u0019\u001a!\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\u0011j\u0002`\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R!\u0010 \u001a\f\u0012\u0004\u0012\u00020\b0\u001aj\u0002`\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R<\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u00112\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$f;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$b;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "keyword", "", "index", "", "Lcom/tencent/mobileqq/search/business/addcontact/views/OnRemoveKeyword;", "I", "Lkotlin/jvm/functions/Function2;", "getOnRemoveKeyword", "()Lkotlin/jvm/functions/Function2;", "onRemoveKeyword", "Lkotlin/Function1;", "", "isShowMore", "Lcom/tencent/mobileqq/search/business/addcontact/views/OnAction;", "J", "Lkotlin/jvm/functions/Function1;", "getOnAction", "()Lkotlin/jvm/functions/Function1;", "onAction", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/search/business/addcontact/views/OnGetHistoryCount;", "K", "Lkotlin/jvm/functions/Function0;", "getOnGetHistoryCount", "()Lkotlin/jvm/functions/Function0;", "onGetHistoryCount", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$SearchHistoryItemDelegate;", "L", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$SearchHistoryItemDelegate;", "getSearchHistoryDelegate", "()Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$SearchHistoryItemDelegate;", "searchHistoryDelegate", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$SearchHistoryActionDelegate;", "M", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$SearchHistoryActionDelegate;", "getSearchHistoryActionDelegate", "()Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$SearchHistoryActionDelegate;", "searchHistoryActionDelegate", "value", "getOnItemClick", "k0", "(Lkotlin/jvm/functions/Function1;)V", "onItemClick", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<b> {

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final Function2<String, Integer, Unit> onRemoveKeyword;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final Function1<Boolean, Unit> onAction;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final Function0<Integer> onGetHistoryCount;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final SearchHistoryItemDelegate searchHistoryDelegate;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private final SearchHistoryActionDelegate searchHistoryActionDelegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(@NotNull Function2<? super String, ? super Integer, Unit> onRemoveKeyword, @NotNull Function1<? super Boolean, Unit> onAction, @NotNull Function0<Integer> onGetHistoryCount) {
            super(new c());
            Intrinsics.checkNotNullParameter(onRemoveKeyword, "onRemoveKeyword");
            Intrinsics.checkNotNullParameter(onAction, "onAction");
            Intrinsics.checkNotNullParameter(onGetHistoryCount, "onGetHistoryCount");
            this.onRemoveKeyword = onRemoveKeyword;
            this.onAction = onAction;
            this.onGetHistoryCount = onGetHistoryCount;
            SearchHistoryItemDelegate searchHistoryItemDelegate = new SearchHistoryItemDelegate(onRemoveKeyword);
            this.searchHistoryDelegate = searchHistoryItemDelegate;
            SearchHistoryActionDelegate searchHistoryActionDelegate = new SearchHistoryActionDelegate(onAction, onGetHistoryCount);
            this.searchHistoryActionDelegate = searchHistoryActionDelegate;
            this.f236209m.c(searchHistoryItemDelegate);
            this.f236209m.c(searchHistoryActionDelegate);
        }

        public final void k0(@NotNull Function1<? super String, Unit> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.searchHistoryDelegate.w(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$g;", "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "<init>", "(Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.business.addcontact.views.SearchHistoryContainer$g, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class SearchHistoryTextItem implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String text;

        public SearchHistoryTextItem(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SearchHistoryTextItem) && Intrinsics.areEqual(this.text, ((SearchHistoryTextItem) other).text)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        @NotNull
        public String toString() {
            return "SearchHistoryTextItem(text=" + this.text + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "closeView", "Landroid/view/View;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Landroid/view/View;)V", "G", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class h extends RecyclerView.ViewHolder {

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageView closeView;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$h$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/search/business/addcontact/views/SearchHistoryContainer$h;", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.business.addcontact.views.SearchHistoryContainer$h$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final h a(@NotNull ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hpl, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026text_item, parent, false)");
                return new h(inflate);
            }

            Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(@NotNull View item) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            View findViewById = this.itemView.findViewById(R.id.f124997kv);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(co\u2026earch.api.R.id.word_text)");
            this.textView = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.azb);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(co\u2026arch.api.R.id.close_icon)");
            this.closeView = (ImageView) findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getCloseView() {
            return this.closeView;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchHistoryContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.items = new ArrayList<>();
        setItemAnimator(null);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.itemAdapter = new f(new Function2<String, Integer, Unit>() { // from class: com.tencent.mobileqq.search.business.addcontact.views.SearchHistoryContainer.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
                invoke(str, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String keyword, int i3) {
                Object obj;
                Intrinsics.checkNotNullParameter(keyword, "keyword");
                ab.g(MmkvKeys.MMKV_KEY_FIND_USER_AND_GROUP_SEARCH_HISTORY_KEY, keyword);
                Iterator it = SearchHistoryContainer.this.items.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (((b) obj) instanceof SearchHistoryActionItem) {
                            break;
                        }
                    }
                }
                b bVar = (b) obj;
                if (bVar == null) {
                    SearchHistoryContainer.this.O(false);
                } else if (bVar instanceof SearchHistoryActionItem) {
                    SearchHistoryContainer.this.O(!((SearchHistoryActionItem) bVar).getShowMore());
                }
            }
        }, new AnonymousClass2(), new Function0<Integer>() { // from class: com.tencent.mobileqq.search.business.addcontact.views.SearchHistoryContainer.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ab.f284985a.d(MmkvKeys.MMKV_KEY_FIND_USER_AND_GROUP_SEARCH_HISTORY_KEY).size());
            }
        });
        post(new Runnable() { // from class: com.tencent.mobileqq.search.business.addcontact.views.a
            @Override // java.lang.Runnable
            public final void run() {
                SearchHistoryContainer.F(SearchHistoryContainer.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(SearchHistoryContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(boolean showAll) {
        int collectionSizeOrDefault;
        List take;
        int collectionSizeOrDefault2;
        f fVar = null;
        if (getAdapter() == null) {
            f fVar2 = this.itemAdapter;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                fVar2 = null;
            }
            setAdapter(fVar2);
        }
        List<String> d16 = ab.f284985a.d(MmkvKeys.MMKV_KEY_FIND_USER_AND_GROUP_SEARCH_HISTORY_KEY);
        if (!showAll) {
            this.items.clear();
            ArrayList<b> arrayList = this.items;
            take = CollectionsKt___CollectionsKt.take(d16, 2);
            List list = take;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new SearchHistoryTextItem((String) it.next()));
            }
            arrayList.addAll(arrayList2);
            if (d16.size() > 2) {
                this.items.add(new SearchHistoryActionItem(true));
            }
        } else {
            this.items.clear();
            ArrayList<b> arrayList3 = this.items;
            List<String> list2 = d16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                arrayList4.add(new SearchHistoryTextItem((String) it5.next()));
            }
            arrayList3.addAll(arrayList4);
            if (d16.size() > 2) {
                this.items.add(new SearchHistoryActionItem(false));
            }
        }
        f fVar3 = this.itemAdapter;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
        } else {
            fVar = fVar3;
        }
        fVar.setItems(Util.toImmutableList(this.items), new Runnable() { // from class: com.tencent.mobileqq.search.business.addcontact.views.b
            @Override // java.lang.Runnable
            public final void run() {
                SearchHistoryContainer.P(SearchHistoryContainer.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(SearchHistoryContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        boolean z16;
        f fVar = this.itemAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
            fVar = null;
        }
        int i3 = 0;
        if (fVar.getNUM_BACKGOURND_ICON() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        int c16 = x.c(getContext(), i3);
        setPadding(c16, c16, c16, c16);
        QLog.i("SearchHistoryContainer", 1, "updatePadding(" + c16 + ")");
        post(new Runnable() { // from class: com.tencent.mobileqq.search.business.addcontact.views.c
            @Override // java.lang.Runnable
            public final void run() {
                SearchHistoryContainer.S(SearchHistoryContainer.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(SearchHistoryContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestLayout();
    }

    public final void L() {
        QLog.i("SearchHistoryContainer", 1, "[" + System.identityHashCode(this) + "] forceDetachedFromWindow isAttachedToWindow=" + isAttachedToWindow());
        if (isAttachedToWindow()) {
            onDetachedFromWindow();
        }
    }

    public final void M() {
        VideoReport.setElementId(this, "em_bas_search_history");
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
    }

    public final void Q() {
        Object obj;
        Iterator<T> it = this.items.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((b) obj) instanceof SearchHistoryActionItem) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        b bVar = (b) obj;
        boolean z16 = false;
        if (bVar != null && (bVar instanceof SearchHistoryActionItem) && !((SearchHistoryActionItem) bVar).getShowMore()) {
            z16 = true;
        }
        O(z16);
        VideoReport.traversePage(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        QLog.i("SearchHistoryContainer", 1, "[" + System.identityHashCode(this) + "] onAttachedToWindow");
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        QLog.i("SearchHistoryContainer", 1, "[" + System.identityHashCode(this) + "] onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    public final void setOnHistorySearchItemClickCallback(@NotNull Function1<? super String, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        f fVar = this.itemAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
            fVar = null;
        }
        fVar.k0(value);
    }
}
