package com.tencent.mobileqq.zplan.aio.panel.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.aio.panel.item.Identifying;
import com.tencent.mobileqq.zplan.aio.panel.item.NormalItem;
import com.tencent.mobileqq.zplan.aio.panel.item.view.ItemView;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mobileqq.zplan.aio.panel.page.view.PageView;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper;
import com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.SingleItemShoppingCartData;
import com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.ZPlanSingleItemShoppingCartDialogView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002CDB\u001d\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*\u0012\u0006\u00102\u001a\u00020/\u00a2\u0006\u0004\b@\u0010AJ \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0002JJ\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f28\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\t0\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\u0018\u0010%\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R.\u0010;\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001038\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001b\u00104\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b<\u0010=*\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/PageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/PageAdapter$b;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$b;", "holder", "Lcom/tencent/mobileqq/zplan/aio/panel/item/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "o0", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/aio/panel/item/NormalItem;", "y0", "Lcom/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/a;", "itemData", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMessage", "callback", "w0", "id", "z0", "itemId", "sceneType", "", "", "q0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "v0", "getItemCount", "t0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onDetachedFromRecyclerView", "T", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/StateFlow;", "dataSource", "Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", "pageTheme", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$c;", "value", "D", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$c;", "r0", "()Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$c;", "x0", "(Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$c;)V", "selectHandler", "s0", "()Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "getValue$delegate", "(Lcom/tencent/mobileqq/zplan/aio/panel/page/PageAdapter;)Ljava/lang/Object;", "<init>", "(Lkotlinx/coroutines/flow/StateFlow;Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;)V", "E", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PageAdapter extends RecyclerView.Adapter<b> implements Page.b {

    /* renamed from: C, reason: from kotlin metadata */
    private final PageView.Theme pageTheme;

    /* renamed from: D, reason: from kotlin metadata */
    private Page.c selectHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final StateFlow<Page> dataSource;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R/\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR/\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/PageAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView;", "E", "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView;", "l", "()Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lkotlinx/coroutines/Job;", "<set-?>", UserInfo.SEX_FEMALE, "Lkotlin/properties/ReadWriteProperty;", "getLoadIdentifyingJob", "()Lkotlinx/coroutines/Job;", DomainData.DOMAIN_NAME, "(Lkotlinx/coroutines/Job;)V", "loadIdentifyingJob", "G", "getLoadThumbnailJob", "o", "loadThumbnailJob", "H", "getLoadContentJob", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "loadContentJob", "Landroid/widget/RelativeLayout;", TtmlNode.TAG_LAYOUT, "<init>", "(Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView;Landroid/widget/RelativeLayout;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {
        static final /* synthetic */ KProperty<Object>[] I = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "loadIdentifyingJob", "getLoadIdentifyingJob()Lkotlinx/coroutines/Job;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "loadThumbnailJob", "getLoadThumbnailJob()Lkotlinx/coroutines/Job;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "loadContentJob", "getLoadContentJob()Lkotlinx/coroutines/Job;", 0))};

        /* renamed from: E, reason: from kotlin metadata */
        private final ItemView item;

        /* renamed from: F, reason: from kotlin metadata */
        private final ReadWriteProperty loadIdentifyingJob;

        /* renamed from: G, reason: from kotlin metadata */
        private final ReadWriteProperty loadThumbnailJob;

        /* renamed from: H, reason: from kotlin metadata */
        private final ReadWriteProperty loadContentJob;

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a extends ObservableProperty<Job> {
            public a(Object obj) {
                super(obj);
            }

            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Job oldValue, Job newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                Job job = oldValue;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.aio.panel.page.PageAdapter$b$b, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public static final class C9145b extends ObservableProperty<Job> {
            public C9145b(Object obj) {
                super(obj);
            }

            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Job oldValue, Job newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                Job job = oldValue;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class c extends ObservableProperty<Job> {
            public c(Object obj) {
                super(obj);
            }

            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Job oldValue, Job newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                Job job = oldValue;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ItemView item, RelativeLayout layout) {
            super(layout);
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(layout, "layout");
            this.item = item;
            Delegates delegates = Delegates.INSTANCE;
            this.loadIdentifyingJob = new a(null);
            this.loadThumbnailJob = new C9145b(null);
            this.loadContentJob = new c(null);
        }

        /* renamed from: l, reason: from getter */
        public final ItemView getItem() {
            return this.item;
        }

        public final void m(Job job) {
            this.loadContentJob.setValue(this, I[2], job);
        }

        public final void n(Job job) {
            this.loadIdentifyingJob.setValue(this, I[0], job);
        }

        public final void o(Job job) {
            this.loadThumbnailJob.setValue(this, I[1], job);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/page/PageAdapter$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lbw4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<bw4.c> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f331240d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function2<? super Integer, ? super String, Unit> function2) {
            this.f331240d = function2;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(bw4.c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f331240d.invoke(0, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f331240d.invoke(Integer.valueOf(error), message);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PageAdapter(StateFlow<? extends Page> dataSource, PageView.Theme pageTheme) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(pageTheme, "pageTheme");
        this.dataSource = dataSource;
        this.pageTheme = pageTheme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(com.tencent.mobileqq.zplan.aio.panel.item.b item, PageAdapter this$0, ItemView this_apply, int i3, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (item instanceof NormalItem) {
            Context context = this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this$0.y0(context, (NormalItem) item, i3);
        }
    }

    private final Page s0() {
        return this.dataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(PageAdapter this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Page.c cVar = this$0.selectHandler;
        if (cVar != null) {
            cVar.b(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(SingleItemShoppingCartData itemData, Function2<? super Integer, ? super String, Unit> callback) {
        bw4.a aVar = new bw4.a();
        aVar.f29335a = itemData.getId();
        aVar.f29336b = "1";
        va4.a.d(va4.a.f441274a, aVar, new c(callback), 0, 4, null);
    }

    private final void y0(Context context, final NormalItem item, final int position) {
        final SingleItemShoppingCartData singleItemShoppingCartData = new SingleItemShoppingCartData(String.valueOf(item.getId()), item.getText(), item.getPrice(), item.getThumbnailUrl(), item.getIdentifyingUrl());
        new ZPlanSingleItemShoppingCartDialogView(context, singleItemShoppingCartData, new Function1<Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.PageAdapter$showShoppingCart$dialogView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super Boolean, ? extends Unit> function1) {
                invoke2((Function1<? super Boolean, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Function1<? super Boolean, Unit> finishCallback) {
                Intrinsics.checkNotNullParameter(finishCallback, "finishCallback");
                final PageAdapter pageAdapter = PageAdapter.this;
                final SingleItemShoppingCartData singleItemShoppingCartData2 = singleItemShoppingCartData;
                final NormalItem normalItem = item;
                final int i3 = position;
                pageAdapter.w0(singleItemShoppingCartData2, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.PageAdapter$showShoppingCart$dialogView$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                        invoke(num.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i16, String str) {
                        PageView.Theme theme;
                        Map q06;
                        QLog.e("PageAdapter", 1, "sendBuyReqToServer finish, errorCode:" + i16 + ", errorMessage:" + str);
                        boolean z16 = i16 == 0;
                        if (z16) {
                            PageAdapter.this.z0(singleItemShoppingCartData2.getId());
                            QQToastUtil.showQQToastInUiThread(2, "\u8d2d\u4e70\u6210\u529f");
                            normalItem.q(true);
                            PageAdapter.this.T(i3);
                            Page.c selectHandler = PageAdapter.this.getSelectHandler();
                            if (selectHandler != null) {
                                selectHandler.b(i3);
                            }
                            PageAdapter pageAdapter2 = PageAdapter.this;
                            String valueOf = String.valueOf(normalItem.getId());
                            theme = PageAdapter.this.pageTheme;
                            q06 = pageAdapter2.q0(valueOf, theme.getReportSceneType());
                            VideoReport.reportEvent("ev_zplan_purchase_success", q06);
                        } else if (i16 == -10015) {
                            QQToastUtil.showQQToastInUiThread(1, "\u5546\u54c1\u5df2\u62e5\u6709");
                        } else {
                            QQToastUtil.showQQToastInUiThread(1, "\u8d2d\u4e70\u5931\u8d25");
                        }
                        finishCallback.invoke(Boolean.valueOf(z16));
                        ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).setIsShoppingCartShowing(false);
                    }
                });
            }
        }).x();
        ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).setIsShoppingCartShowing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(String id5) {
        QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
        IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) api;
        String str = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_key_has_id_list_mmkv";
        String str2 = iZPlanMMKVApi.getString(str, "") + id5 + "_";
        iZPlanMMKVApi.setString(str, str2);
        QLog.i("PageAdapter", 1, "updateHasListToMMKV:" + str2);
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page.b
    public void T(int position) {
        notifyItemChanged(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return s0().c().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        x0(null);
    }

    /* renamed from: r0, reason: from getter */
    public final Page.c getSelectHandler() {
        return this.selectHandler;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public synchronized void onBindViewHolder(b holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemView item = holder.getItem();
        o0(holder, s0().c().get(position), position);
        item.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PageAdapter.u0(PageAdapter.this, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        ItemView itemView = new ItemView(context, null, 0, 0, 14, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = kotlin.g.c(itemView, this.pageTheme.getBottomMarginDp());
        layoutParams.addRule(14);
        itemView.setLayoutParams(layoutParams);
        itemView.setTheme(this.pageTheme.getItemTheme());
        RelativeLayout relativeLayout = new RelativeLayout(parent.getContext());
        relativeLayout.addView(itemView);
        return new b(itemView, relativeLayout);
    }

    public final void x0(Page.c cVar) {
        this.selectHandler = cVar;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> q0(String itemId, String sceneType) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_purchase_type", "action"), TuplesKt.to("zplan_item_id", itemId), TuplesKt.to("zplan_emote_scene_type", sceneType));
        return mapOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
    
        if (r4.get() == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o0(b holder, final com.tencent.mobileqq.zplan.aio.panel.item.b item, final int position) {
        boolean z16;
        final ItemView item2 = holder.getItem();
        item2.setOnExposeListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.PageAdapter$bind$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.mobileqq.zplan.aio.panel.item.b.this.p(true);
            }
        });
        ImageView loadingView = item2.getIconView().getLoadingView();
        NormalItem normalItem = item instanceof NormalItem ? (NormalItem) item : null;
        if (normalItem != null && (r4 = normalItem.getNeedLoadOnClick()) != null) {
            z16 = true;
        }
        z16 = false;
        loadingView.setVisibility(z16 ? 0 : 8);
        item2.getTextView().setText(item.getText());
        if (item.getIsNeedPay()) {
            item2.getPriceView().setVisibility(0);
            if (item.getHas()) {
                item2.getPriceArea().setVisibility(8);
                item2.getHintTxv().setVisibility(0);
                item2.getTextView().setVisibility(0);
                item2.getBuyBtn().setVisibility(8);
            } else if (item.getSelected()) {
                item2.getBuyBtn().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PageAdapter.p0(com.tencent.mobileqq.zplan.aio.panel.item.b.this, this, item2, position, view);
                    }
                });
                item2.getBuyBtn().setVisibility(0);
                item2.getTextView().setVisibility(8);
                item2.getPriceArea().setVisibility(8);
                item2.getHintTxv().setVisibility(8);
            } else {
                item2.getPriceArea().setVisibility(0);
                item2.getTextView().setVisibility(0);
                item2.getHintTxv().setVisibility(8);
                item2.getBuyBtn().setVisibility(8);
                item2.getGoldTxv().setText(String.valueOf(item.getPrice()));
            }
        } else {
            item2.getPriceView().setVisibility(8);
            item2.getTextView().setVisibility(0);
        }
        item2.getIdentifyingIcon().setBackground(null);
        if (item.getBackgroundColor() != null) {
            item2.getIconView().setBackgroundColor(item2.getResources().getColor(R.color.qui_common_overlay_light, null));
        } else {
            item2.getIconView().setBackground(null);
        }
        item2.getIconView().setClipToOutline(item.getClipToOutline());
        Identifying identifying = item.getIdentifying();
        if (identifying != null) {
            item2.getIdentifyingIcon().getLayoutParams().width = kotlin.g.c(item2, identifying.getWidthDp());
            item2.getIdentifyingIcon().getLayoutParams().height = kotlin.g.c(item2, identifying.getHeightDp());
            com.tencent.mobileqq.qcoroutine.api.coroutine.b e16 = CorountineFunKt.e(item.getScope(), "zplan_PageAdapter_\u83b7\u53d6\u89d2\u6807", null, null, Boolean.TRUE, new PageAdapter$bind$1$3$1(item2, identifying, null), 6, null);
            Intrinsics.checkNotNull(e16);
            holder.n(e16.a());
        } else {
            holder.n(null);
        }
        item2.setSelected(item.getSelected());
        CoroutineScope scope = item.getScope();
        Boolean bool = Boolean.TRUE;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b e17 = CorountineFunKt.e(scope, "zplan_PageAdapter_\u83b7\u53d6\u7f29\u7565\u56fe", null, null, bool, new PageAdapter$bind$1$4(item2, item, null), 6, null);
        Intrinsics.checkNotNull(e17);
        holder.o(e17.a());
        com.tencent.mobileqq.qcoroutine.api.coroutine.b e18 = CorountineFunKt.e(item.getScope(), "zplan_PageAdapter_\u83b7\u53d6\u5176\u4ed6\u8d44\u6e90", null, null, bool, new PageAdapter$bind$1$5(item2, item, null), 6, null);
        Intrinsics.checkNotNull(e18);
        holder.m(e18.a());
    }
}
