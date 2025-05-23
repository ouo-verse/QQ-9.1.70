package com.tencent.mobileqq.zplan.aio.panel.page;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.aio.panel.page.util.ActionInfoExtKt;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt;
import com.tencent.mobileqq.zplan.utils.g;
import com.tencent.mobileqq.zplan.utils.o;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;
import ku4.i;
import ku4.j;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0002\u0014\u0007B)\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a\u00a2\u0006\u0004\b)\u0010*J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\u0014\u0010\"R\u001a\u0010(\u001a\u00020$8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/EmoticonPageBuilder;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/a;", "", "data", "", "source", "Lcom/tencent/mobileqq/zplan/aio/panel/page/a;", "b", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/zplan/aio/panel/page/EmoticonPageBuilder$b;", "e", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "", "d", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonAdapter;", "c", "Lkotlin/jvm/functions/Function0;", "adapterBuilder", "Ljava/lang/Class;", "Lku4/d;", "Ljava/lang/Class;", "()Ljava/lang/Class;", "dataClass", "", "I", "getPageType", "()I", "pageType", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class EmoticonPageBuilder implements com.tencent.mobileqq.zplan.aio.panel.panel.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function0<ZPlanEmoticonAdapter> adapterBuilder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Class<ku4.d> dataClass;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int pageType;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/EmoticonPageBuilder$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelListView;", "E", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelListView;", "l", "()Lcom/tencent/mobileqq/emoticonview/EmotionPanelListView;", "view", "<init>", "(Lcom/tencent/mobileqq/emoticonview/EmotionPanelListView;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final EmotionPanelListView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionPanelListView view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        /* renamed from: l, reason: from getter */
        public final EmotionPanelListView getView() {
            return this.view;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmoticonPageBuilder(CoroutineScope scope, Context context, Function0<? extends ZPlanEmoticonAdapter> function0) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        this.scope = scope;
        this.context = context;
        this.adapterBuilder = function0;
        this.dataClass = ku4.d.class;
        this.pageType = 1;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    public Class<ku4.d> a() {
        return this.dataClass;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(2:3|(18:5|6|(1:(1:9)(2:52|53))(2:54|(1:56))|10|11|12|13|(1:15)(1:48)|16|(1:18)|19|(1:21)(1:47)|(1:23)(1:46)|24|(4:27|(4:29|(1:31)(1:35)|32|33)(4:36|(1:38)(1:41)|39|40)|34|25)|42|43|44))|57|6|(0)(0)|10|11|12|13|(0)(0)|16|(0)|19|(0)(0)|(0)(0)|24|(1:25)|42|43|44) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0096, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
    
        com.tencent.qphone.base.util.QLog.e("EmoticonPageBuilder", 1, "onCreatePage, read file:" + r13.getFile().getAbsolutePath() + " content exception", r0);
        r13 = new byte[0];
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(Object obj, String str, Continuation<? super a> continuation) {
        EmoticonPageBuilder$onCreatePage$1 emoticonPageBuilder$onCreatePage$1;
        Object coroutine_suspended;
        int i3;
        byte[] bArr;
        int collectionSizeOrDefault;
        ZPlanActionInfo d16;
        if (continuation instanceof EmoticonPageBuilder$onCreatePage$1) {
            emoticonPageBuilder$onCreatePage$1 = (EmoticonPageBuilder$onCreatePage$1) continuation;
            int i16 = emoticonPageBuilder$onCreatePage$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                emoticonPageBuilder$onCreatePage$1.label = i16 - Integer.MIN_VALUE;
                Object obj2 = emoticonPageBuilder$onCreatePage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = emoticonPageBuilder$onCreatePage$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.aio_avatar.nano.AllEmotionConfig");
                    ku4.d dVar = (ku4.d) obj;
                    QLog.i("EmoticonPageBuilder", 1, "onCreatePage, staticCfgUrl: " + dVar.f413093a);
                    o h16 = SknNetworkUtilKt.h(SknNetworkUtilKt.a(com.tencent.mobileqq.zplan.utils.e.f335814a), 0L, 0, 3, null);
                    Panel.Companion companion = Panel.INSTANCE;
                    Context context = this.context;
                    String str2 = dVar.f413093a;
                    Intrinsics.checkNotNullExpressionValue(str2, "data.staticCfgUrl");
                    com.tencent.mobileqq.zplan.utils.f d17 = companion.d(context, str2);
                    emoticonPageBuilder$onCreatePage$1.L$0 = obj;
                    emoticonPageBuilder$onCreatePage$1.label = 1;
                    obj2 = h16.a(d17, emoticonPageBuilder$onCreatePage$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    obj = emoticonPageBuilder$onCreatePage$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.utils.DownloadRsp.Success");
                g.c cVar = (g.c) obj2;
                bArr = FilesKt__FileReadWriteKt.readBytes(cVar.getFile());
                i iVar = new i();
                if (!(bArr.length != 0)) {
                    SknNetworkUtilKt.c(bArr, iVar);
                }
                boolean enableEmoticonStickerIdConfigFromAllConfig = ZPlanQQMC.INSTANCE.enableEmoticonStickerIdConfigFromAllConfig();
                Panel.Companion companion2 = Panel.INSTANCE;
                ku4.b[] bVarArr = iVar.f413110a;
                Intrinsics.checkNotNullExpressionValue(bVarArr, "staticConfigs.cfgs");
                ku4.d dVar2 = (ku4.d) obj;
                i iVar2 = dVar2.f413094b;
                ku4.b[] bVarArr2 = iVar2 == null ? iVar2.f413110a : null;
                ku4.b[] bVarArr3 = bVarArr2 != null ? new ku4.b[0] : bVarArr2;
                int i17 = dVar2.f413095c;
                int[] iArr = dVar2.f413096d;
                Intrinsics.checkNotNullExpressionValue(iArr, "data.sortIds");
                List<ku4.b> o16 = companion2.o(bVarArr, bVarArr3, i17, iArr, new Function1<ku4.b, Integer>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.EmoticonPageBuilder$onCreatePage$items$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Integer invoke(ku4.b bVar) {
                        return Integer.valueOf(bVar.f413070a);
                    }
                });
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(o16, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (ku4.b it : o16) {
                    if (enableEmoticonStickerIdConfigFromAllConfig) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        j jVar = dVar2.f413097e;
                        d16 = ActionInfoExtKt.e(it, jVar != null ? jVar.f413111a : null);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        j jVar2 = dVar2.f413097e;
                        d16 = ActionInfoExtKt.d(it, jVar2 != null ? jVar2.f413111a : null);
                    }
                    arrayList.add(d16);
                }
                return new a(arrayList, dVar2.f413098f);
            }
        }
        emoticonPageBuilder$onCreatePage$1 = new EmoticonPageBuilder$onCreatePage$1(this, continuation);
        Object obj22 = emoticonPageBuilder$onCreatePage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = emoticonPageBuilder$onCreatePage$1.label;
        if (i3 != 0) {
        }
        Intrinsics.checkNotNull(obj22, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.utils.DownloadRsp.Success");
        g.c cVar2 = (g.c) obj22;
        bArr = FilesKt__FileReadWriteKt.readBytes(cVar2.getFile());
        i iVar3 = new i();
        if (!(bArr.length != 0)) {
        }
        boolean enableEmoticonStickerIdConfigFromAllConfig2 = ZPlanQQMC.INSTANCE.enableEmoticonStickerIdConfigFromAllConfig();
        Panel.Companion companion22 = Panel.INSTANCE;
        ku4.b[] bVarArr4 = iVar3.f413110a;
        Intrinsics.checkNotNullExpressionValue(bVarArr4, "staticConfigs.cfgs");
        ku4.d dVar22 = (ku4.d) obj;
        i iVar22 = dVar22.f413094b;
        if (iVar22 == null) {
        }
        if (bVarArr2 != null) {
        }
        int i172 = dVar22.f413095c;
        int[] iArr2 = dVar22.f413096d;
        Intrinsics.checkNotNullExpressionValue(iArr2, "data.sortIds");
        List<ku4.b> o162 = companion22.o(bVarArr4, bVarArr3, i172, iArr2, new Function1<ku4.b, Integer>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.EmoticonPageBuilder$onCreatePage$items$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(ku4.b bVar) {
                return Integer.valueOf(bVar.f413070a);
            }
        });
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(o162, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        while (r12.hasNext()) {
        }
        return new a(arrayList2, dVar22.f413098f);
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    public void d(RecyclerView.ViewHolder viewHolder, StateFlow<? extends Page> source) {
        ZPlanEmoticonAdapter zPlanEmoticonAdapter;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(source, "source");
        b bVar = (b) viewHolder;
        EmotionPanelListView view = bVar.getView();
        if (view.getAdapter() == null) {
            Function0<ZPlanEmoticonAdapter> function0 = this.adapterBuilder;
            if (function0 == null || (zPlanEmoticonAdapter = function0.invoke()) == null) {
                zPlanEmoticonAdapter = null;
            } else {
                zPlanEmoticonAdapter.L = ViewUtils.dpToPx(5.5f);
                zPlanEmoticonAdapter.setCurrentListView(bVar.getView());
                zPlanEmoticonAdapter.C();
                zPlanEmoticonAdapter.E(true);
            }
            view.setAdapter((ListAdapter) zPlanEmoticonAdapter);
        }
        CorountineFunKt.e(this.scope, "zplan_EmotionPage_\u66f4\u65b0\u8868\u60c5tab\u6570\u636e", null, null, null, new EmoticonPageBuilder$onBind$1$2(view, source, null), 14, null);
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b c(RecyclerView parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        EmotionPanelListView emotionPanelListView = new EmotionPanelListView(parent.getContext());
        emotionPanelListView.setDivider(null);
        emotionPanelListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        emotionPanelListView.setEnableExtendPanle(false);
        emotionPanelListView.setOnScrollListener(new c(emotionPanelListView));
        return new b(emotionPanelListView);
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    public int getPageType() {
        return this.pageType;
    }

    public /* synthetic */ EmoticonPageBuilder(CoroutineScope coroutineScope, Context context, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, context, (i3 & 4) != 0 ? null : function0);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/page/EmoticonPageBuilder$c", "Landroid/widget/AbsListView$OnScrollListener;", "Landroid/widget/AbsListView;", "view", "", HippyTKDListViewAdapter.SCROLL_STATE, "", "onScrollStateChanged", "firstVisibleItem", "visibleItemCount", "totalItemCount", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements AbsListView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EmotionPanelListView f331229d;

        c(EmotionPanelListView emotionPanelListView) {
            this.f331229d = emotionPanelListView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            QLog.i("EmoticonPageBuilder", 1, "onScrollStateChanged, state: " + scrollState);
            if (scrollState == 0) {
                ListAdapter adapter = this.f331229d.getAdapter();
                ZPlanEmoticonAdapter zPlanEmoticonAdapter = adapter instanceof ZPlanEmoticonAdapter ? (ZPlanEmoticonAdapter) adapter : null;
                if (zPlanEmoticonAdapter != null) {
                    zPlanEmoticonAdapter.L();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }
    }
}
