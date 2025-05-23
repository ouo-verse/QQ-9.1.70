package com.tencent.mobileqq.zplan.aio.panel.entrance;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aio.panel.entrance.view.SpaceEntranceBackground;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import fi3.bp;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 92\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002:;B1\u0012\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d\u0012\u0006\u0010&\u001a\u00020#\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110'\u00a2\u0006\u0004\b7\u00108J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016R \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b/\u00100R!\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b2\u00103*\u0004\b4\u00105\u00a8\u0006=\u00b2\u0006\u000e\u0010<\u001a\u00020\u00118\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/entrance/SpaceEntrancesAdapter;", "Lug3/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/aio/panel/entrance/SpaceEntrancesAdapter$b;", "Landroid/content/Context;", "context", "Landroid/view/View;", "anchorView", "", "y0", "Landroid/text/Spanned;", "s0", "bubbleSpanText", "Lcom/tencent/mobileqq/activity/aio/zplan/g;", "p0", "r0", "q0", "", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "x0", "getItemCount", "holder", "position", "u0", "k", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/tencent/mobileqq/zplan/aio/panel/entrance/SpaceEntrance;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/StateFlow;", "dataSource", "Lkotlinx/coroutines/CoroutineScope;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/channels/ReceiveChannel;", "D", "Lkotlinx/coroutines/channels/ReceiveChannel;", "drawerIsOpened", "E", "Lcom/tencent/mobileqq/activity/aio/zplan/g;", "guideBubble", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "COUPLE_SPACE_ENTRANCE_BUBBLE_NEED_SHOW_MMKV_KEY", "t0", "()Ljava/util/List;", "getValue$delegate", "(Lcom/tencent/mobileqq/zplan/aio/panel/entrance/SpaceEntrancesAdapter;)Ljava/lang/Object;", "value", "<init>", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/ReceiveChannel;)V", "G", "a", "b", "isOpened", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SpaceEntrancesAdapter extends RecyclerView.Adapter<b> implements ug3.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: D, reason: from kotlin metadata */
    private final ReceiveChannel<Boolean> drawerIsOpened;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.aio.zplan.g guideBubble;

    /* renamed from: F, reason: from kotlin metadata */
    private final String COUPLE_SPACE_ENTRANCE_BUBBLE_NEED_SHOW_MMKV_KEY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final StateFlow<List<SpaceEntrance>> dataSource;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrancesAdapter$1", f = "SpaceEntrancesAdapter.kt", i = {0}, l = {71}, m = "invokeSuspend", n = {"isOpened$delegate"}, s = {"L$0"})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrancesAdapter$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(SpaceEntrancesAdapter.class, "isOpened", "<v#0>", 0))};
        Object L$0;
        Object L$1;
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrancesAdapter$1$a */
        /* loaded from: classes35.dex */
        public static final class a extends ObservableProperty<Boolean> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ SpaceEntrancesAdapter f331121b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, SpaceEntrancesAdapter spaceEntrancesAdapter) {
                super(obj);
                this.f331121b = spaceEntrancesAdapter;
            }

            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                String str;
                Intrinsics.checkNotNullParameter(property, "property");
                boolean booleanValue = newValue.booleanValue();
                if (oldValue.booleanValue() != booleanValue) {
                    for (SpaceEntrance spaceEntrance : this.f331121b.t0()) {
                        if (booleanValue) {
                            str = "dt_imp";
                        } else {
                            str = "dt_imp_end";
                        }
                        k.b(str, spaceEntrance.getReportElementId());
                    }
                }
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        private static final void a(ReadWriteProperty<Object, Boolean> readWriteProperty, boolean z16) {
            readWriteProperty.setValue(null, $$delegatedProperties[0], Boolean.valueOf(z16));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0049 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
        /* JADX WARN: Type inference failed for: r1v8, types: [kotlin.properties.ReadWriteProperty] */
        /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.properties.ReadWriteProperty] */
        /* JADX WARN: Type inference failed for: r4v10, types: [kotlin.properties.ReadWriteProperty] */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004a -> B:8:0x004f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            AnonymousClass1 anonymousClass1;
            a aVar;
            Object receive;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Delegates delegates = Delegates.INSTANCE;
                anonymousClass1 = this;
                aVar = new a(Boxing.boxBoolean(false), SpaceEntrancesAdapter.this);
                ReceiveChannel receiveChannel = SpaceEntrancesAdapter.this.drawerIsOpened;
                anonymousClass1.L$0 = aVar;
                anonymousClass1.L$1 = aVar;
                anonymousClass1.label = 1;
                receive = receiveChannel.receive(anonymousClass1);
                if (receive == coroutine_suspended) {
                }
            } else if (i3 == 1) {
                ?? r16 = (ReadWriteProperty) this.L$1;
                ?? r46 = (ReadWriteProperty) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    a aVar2 = r46;
                    a aVar3 = r16;
                    Object obj2 = coroutine_suspended;
                    AnonymousClass1 anonymousClass12 = this;
                    try {
                        try {
                            a(aVar3, ((Boolean) obj).booleanValue());
                            ReceiveChannel receiveChannel2 = SpaceEntrancesAdapter.this.drawerIsOpened;
                            anonymousClass1.L$0 = aVar;
                            anonymousClass1.L$1 = aVar;
                            anonymousClass1.label = 1;
                            receive = receiveChannel2.receive(anonymousClass1);
                            if (receive == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            aVar2 = aVar;
                            obj2 = coroutine_suspended;
                            anonymousClass12 = anonymousClass1;
                            obj = receive;
                            aVar3 = aVar2;
                            a(aVar3, ((Boolean) obj).booleanValue());
                            anonymousClass1 = anonymousClass12;
                            coroutine_suspended = obj2;
                            aVar = aVar2;
                            ReceiveChannel receiveChannel22 = SpaceEntrancesAdapter.this.drawerIsOpened;
                            anonymousClass1.L$0 = aVar;
                            anonymousClass1.L$1 = aVar;
                            anonymousClass1.label = 1;
                            receive = receiveChannel22.receive(anonymousClass1);
                            if (receive == coroutine_suspended) {
                            }
                        } catch (CancellationException unused) {
                            r46 = aVar;
                            a(r46, false);
                            return Unit.INSTANCE;
                        }
                        anonymousClass1 = anonymousClass12;
                        coroutine_suspended = obj2;
                        aVar = aVar2;
                    } catch (CancellationException unused2) {
                        r46 = aVar2;
                        a(r46, false);
                        return Unit.INSTANCE;
                    }
                } catch (CancellationException unused3) {
                    a(r46, false);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/entrance/SpaceEntrancesAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lfi3/bp;", "E", "Lfi3/bp;", "l", "()Lfi3/bp;", "binding", "<init>", "(Lfi3/bp;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final bp binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bp binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        /* renamed from: l, reason: from getter */
        public final bp getBinding() {
            return this.binding;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpaceEntrancesAdapter(StateFlow<? extends List<SpaceEntrance>> dataSource, CoroutineScope scope, ReceiveChannel<Boolean> drawerIsOpened) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(drawerIsOpened, "drawerIsOpened");
        this.dataSource = dataSource;
        this.scope = scope;
        this.drawerIsOpened = drawerIsOpened;
        this.COUPLE_SPACE_ENTRANCE_BUBBLE_NEED_SHOW_MMKV_KEY = "COUPLE_SPACE_ENTRANCE_BUBBLE_NEED_SHOW";
        CorountineFunKt.e(scope, "zplan_SpaceEntrancesAdapters_\u76d1\u63a7\u62bd\u5c49\u9875\u5f00\u5173", null, null, null, new AnonymousClass1(null), 14, null);
    }

    private final boolean o0() {
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            return false;
        }
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean(this.COUPLE_SPACE_ENTRANCE_BUBBLE_NEED_SHOW_MMKV_KEY + "_" + e16, true);
    }

    private final com.tencent.mobileqq.activity.aio.zplan.g p0(Context context, Spanned bubbleSpanText) {
        com.tencent.mobileqq.activity.aio.zplan.g gVar = new com.tencent.mobileqq.activity.aio.zplan.g(context);
        TextView b16 = gVar.b();
        if (b16 != null) {
            b16.setText(bubbleSpanText);
            b16.setTextSize(12.0f);
            b16.setVisibility(0);
        }
        return gVar;
    }

    private final void r0(View anchorView) {
        View contentView;
        anchorView.measure(View.MeasureSpec.makeMeasureSpec(anchorView.getLayoutParams().width, 1073741824), View.MeasureSpec.makeMeasureSpec(anchorView.getLayoutParams().height, 1073741824));
        com.tencent.mobileqq.activity.aio.zplan.g gVar = this.guideBubble;
        if (gVar == null || (contentView = gVar.getContentView()) == null) {
            return;
        }
        contentView.measure(-2, -2);
        int measuredWidth = (contentView.getMeasuredWidth() / 2) - (anchorView.getMeasuredWidth() / 2);
        int measuredHeight = contentView.getMeasuredHeight() + anchorView.getMeasuredHeight() + ViewUtils.f352270a.b(7);
        QLog.i("SpaceEntrancesAdapter", 1, "showAsDropDownBubble, offset: x: " + measuredWidth + ", y: " + measuredHeight);
        com.tencent.mobileqq.activity.aio.zplan.g gVar2 = this.guideBubble;
        if (gVar2 != null) {
            gVar2.showAsDropDown(anchorView, -measuredWidth, -measuredHeight);
        }
    }

    private final Spanned s0() {
        Spanned fromHtml;
        String zPlanCoupleIntimateGuideBubbleRichText = ZPlanQQMC.INSTANCE.getZPlanCoupleIntimateGuideBubbleRichText();
        QLog.i("SpaceEntrancesAdapter", 1, "getBubbleRichTextSpanned, htmlText: " + zPlanCoupleIntimateGuideBubbleRichText);
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(zPlanCoupleIntimateGuideBubbleRichText, 63);
            Intrinsics.checkNotNullExpressionValue(fromHtml, "{\n            Html.fromH\u2026L_MODE_COMPACT)\n        }");
            return fromHtml;
        }
        Spanned fromHtml2 = Html.fromHtml(zPlanCoupleIntimateGuideBubbleRichText);
        Intrinsics.checkNotNullExpressionValue(fromHtml2, "{\n            @Suppress(\u2026mHtml(htmlText)\n        }");
        return fromHtml2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SpaceEntrance> t0() {
        return this.dataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(SpaceEntrancesAdapter this$0, SpaceEntrance item, bp this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        CorountineFunKt.e(this$0.scope, "zplan_SpaceEntranceAdapter_\u70b9\u51fb\u52a8\u753b", Boolean.TRUE, null, null, new SpaceEntrancesAdapter$onBindViewHolder$1$1$1(this_apply, this$0, item, view, null), 12, null);
        k.b("dt_clck", item.getReportElementId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(SpaceEntrancesAdapter this$0, bp this_apply) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Context context = this_apply.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        SpaceEntranceBackground zplanPanelSpaceEntranceBg = this_apply.f399137b;
        Intrinsics.checkNotNullExpressionValue(zplanPanelSpaceEntranceBg, "zplanPanelSpaceEntranceBg");
        this$0.y0(context, zplanPanelSpaceEntranceBg);
    }

    private final void y0(Context context, View anchorView) {
        if (!o0()) {
            QLog.i("SpaceEntrancesAdapter", 1, "triggerGuideBubble failed, checkNeedShowBubble false.");
            return;
        }
        String e16 = bb.f335811a.e();
        if (e16 != null) {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(this.COUPLE_SPACE_ENTRANCE_BUBBLE_NEED_SHOW_MMKV_KEY + "_" + e16, false);
        }
        this.guideBubble = p0(context, s0());
        r0(anchorView);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.j
            @Override // java.lang.Runnable
            public final void run() {
                SpaceEntrancesAdapter.z0(SpaceEntrancesAdapter.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(SpaceEntrancesAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return t0().size();
    }

    @Override // ug3.a
    public void k() {
        q0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final bp binding = holder.getBinding();
        final SpaceEntrance spaceEntrance = t0().get(position);
        binding.f399138c.setBackground(AppCompatResources.getDrawable(binding.getRoot().getContext(), spaceEntrance.getDrawableRes()));
        binding.f399139d.setText(spaceEntrance.getText());
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpaceEntrancesAdapter.v0(SpaceEntrancesAdapter.this, spaceEntrance, binding, view);
            }
        });
        if (position == 0) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.i
                @Override // java.lang.Runnable
                public final void run() {
                    SpaceEntrancesAdapter.w0(SpaceEntrancesAdapter.this, binding);
                }
            }, 500L);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bp g16 = bp.g(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026parent.context)\n        )");
        b bVar = new b(g16);
        bVar.getBinding().f399139d.setTextColor(-1);
        bVar.getBinding().f399138c.setZ(1.0f);
        return bVar;
    }

    private final void q0() {
        QLog.i("SpaceEntrancesAdapter", 1, "bubble dismiss.");
        com.tencent.mobileqq.activity.aio.zplan.g gVar = this.guideBubble;
        if (gVar != null) {
            gVar.dismiss();
        }
    }
}
