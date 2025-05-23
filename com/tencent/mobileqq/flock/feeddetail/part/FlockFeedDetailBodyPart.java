package com.tencent.mobileqq.flock.feeddetail.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.layer.bean.FlockLayerInitBean;
import com.tencent.mobileqq.flock.publish.event.FlockPublishFinishEvent;
import com.tencent.mobileqq.flock.widget.FlockBlankView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 l2\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001mB\u0007\u00a2\u0006\u0004\bj\u0010kJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\r\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\t\u0010\u0019\u001a\u00020\u0018H\u0096\u0001J\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\u0019\u0010 \u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\u0019\u0010!\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\u0019\u0010\"\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\u0019\u0010$\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001dH\u0096\u0001J\u0012\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001dH\u0016J\u001c\u00100\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00101\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u00103\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0016J$\u00107\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050504j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000505`6H\u0016R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR#\u0010^\u001a\n Y*\u0004\u0018\u00010X0X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0014\u0010a\u001a\u00020\u00108\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020\u00108\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bb\u0010`R\u0014\u0010e\u001a\u00020\u00108\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bd\u0010`R\u0014\u0010g\u001a\u00020\u00108\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bf\u0010`R\u0014\u0010i\u001a\u00020\u00108\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bh\u0010`\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/part/FlockFeedDetailBodyPart;", "Lcom/tencent/mobileqq/flock/base/b;", "Lcom/tencent/mobileqq/flock/feeddetail/ioc/b;", "Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "it", "F9", "uiStateData", "E9", "K9", "J9", "", NodeProps.VISIBLE, "N9", "H9", "C9", "Ly45/b;", "feed", "G9", "", "y8", "Landroid/content/Context;", "context", "Lkotlin/Pair;", "", "Z5", "C8", "Z8", ICustomDataEditor.NUMBER_PARAM_2, "S4", "tagId", "j3", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/ImageView;", "clickView", "index", "w0", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "e", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "rvFeedDetail", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/mobileqq/flock/feeddetail/adapter/a;", "i", "Lcom/tencent/mobileqq/flock/feeddetail/adapter/a;", "headerAdapter", "Lcom/tencent/mobileqq/flock/feeddetail/adapter/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/flock/feeddetail/adapter/c;", "mediaListAdapter", "Lcom/tencent/mobileqq/flock/feeddetail/adapter/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/flock/feeddetail/adapter/e;", "publishTimeAdapter", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "llContentContainer", "Lcom/tencent/mobileqq/flock/widget/FlockBlankView;", "E", "Lcom/tencent/mobileqq/flock/widget/FlockBlankView;", "flockBlankView", "Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "D9", "()Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "vm", ICustomDataEditor.STRING_ARRAY_PARAM_8, "()Z", "isParticipantClickable", "c6", "isPoiClickable", "t3", "isPublisherClickable", "T1", "isTopicClickable", ICustomDataEditor.STRING_PARAM_1, "isTopicVisible", "<init>", "()V", "G", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedDetailBodyPart extends com.tencent.mobileqq.flock.base.b implements com.tencent.mobileqq.flock.feeddetail.ioc.b, com.tencent.mobileqq.flock.feedcommon.ioc.b, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.flock.feeddetail.adapter.e publishTimeAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout llContentContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private FlockBlankView flockBlankView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.flock.feeddetail.ioc.a f210080d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView rvFeedDetail;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.flock.feeddetail.adapter.a headerAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.flock.feeddetail.adapter.c mediaListAdapter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/part/FlockFeedDetailBodyPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailBodyPart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28618);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockFeedDetailBodyPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f210080d = new com.tencent.mobileqq.flock.feeddetail.ioc.a();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feeddetail.viewmodel.a>() { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailBodyPart$vm$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedDetailBodyPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.flock.feeddetail.viewmodel.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) FlockFeedDetailBodyPart.this.getViewModel(com.tencent.mobileqq.flock.feeddetail.viewmodel.a.class) : (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.vm = lazy;
    }

    private final void C9() {
        this.headerAdapter = new com.tencent.mobileqq.flock.feeddetail.adapter.a();
        com.tencent.mobileqq.flock.feeddetail.adapter.c cVar = new com.tencent.mobileqq.flock.feeddetail.adapter.c();
        cVar.setHasStableIds(true);
        this.mediaListAdapter = cVar;
        this.publishTimeAdapter = new com.tencent.mobileqq.flock.feeddetail.adapter.e();
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[3];
        com.tencent.mobileqq.flock.feeddetail.adapter.a aVar = this.headerAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerAdapter");
            aVar = null;
        }
        adapterArr[0] = aVar;
        com.tencent.mobileqq.flock.feeddetail.adapter.c cVar2 = this.mediaListAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            cVar2 = null;
        }
        adapterArr[1] = cVar2;
        com.tencent.mobileqq.flock.feeddetail.adapter.e eVar = this.publishTimeAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishTimeAdapter");
            eVar = null;
        }
        adapterArr[2] = eVar;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.rvFeedDetail;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvFeedDetail");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    private final com.tencent.mobileqq.flock.feeddetail.viewmodel.a D9() {
        return (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) this.vm.getValue();
    }

    private final void E9(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> uiStateData) {
        K9(uiStateData);
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flockBlankView");
            flockBlankView = null;
        }
        flockBlankView.c();
        N9(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> it) {
        int state = it.getState();
        if (state != 2 && state != 3) {
            if (state == 4) {
                E9(it);
            }
        } else {
            H9(it);
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.finishRefresh();
    }

    private final void G9(y45.b feed) {
        String str;
        com.tencent.mobileqq.flock.feeddetail.bean.a data;
        y45.b a16;
        if (feed != null) {
            String str2 = feed.f449366a;
            UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> value = D9().R1().getValue();
            SmartRefreshLayout smartRefreshLayout = null;
            if (value != null && (data = value.getData()) != null && (a16 = data.a()) != null) {
                str = a16.f449366a;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str2, str)) {
                SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
                if (smartRefreshLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                } else {
                    smartRefreshLayout = smartRefreshLayout2;
                }
                smartRefreshLayout.autoRefresh();
            }
        }
    }

    private final void H9(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> uiStateData) {
        ArrayList arrayListOf;
        J9();
        N9(true);
        com.tencent.mobileqq.flock.feeddetail.adapter.a aVar = this.headerAdapter;
        com.tencent.mobileqq.flock.feeddetail.adapter.e eVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerAdapter");
            aVar = null;
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uiStateData.getData());
        aVar.setItems(arrayListOf);
        com.tencent.mobileqq.flock.feeddetail.adapter.c cVar = this.mediaListAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            cVar = null;
        }
        y45.i[] iVarArr = uiStateData.getData().a().f449375j;
        Intrinsics.checkNotNullExpressionValue(iVarArr, "uiStateData.data.feed.images");
        ArrayList arrayList = new ArrayList(iVarArr.length);
        for (y45.i it : iVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(new com.tencent.mobileqq.flock.feeddetail.bean.b(it));
        }
        cVar.setItems(arrayList);
        com.tencent.mobileqq.flock.feeddetail.adapter.e eVar2 = this.publishTimeAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishTimeAdapter");
        } else {
            eVar = eVar2;
        }
        com.tencent.mobileqq.flock.feeddetail.bean.a data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        eVar.k0(data);
        if (!uiStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.flock.feeddetail.part.c
                @Override // java.lang.Runnable
                public final void run() {
                    FlockFeedDetailBodyPart.I9(FlockFeedDetailBodyPart.this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(FlockFeedDetailBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.rvFeedDetail;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvFeedDetail");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void J9() {
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flockBlankView");
            flockBlankView = null;
        }
        flockBlankView.b();
    }

    private final void K9(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> uiStateData) {
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flockBlankView");
            flockBlankView = null;
        }
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setBackgroundColorType(0).setImageType(13);
        String msg2 = uiStateData.getMsg();
        Intrinsics.checkNotNullExpressionValue(msg2, "uiStateData.msg");
        flockBlankView.setErrorViewBuilder(imageType.setTitle(msg2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(FlockFeedDetailBodyPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.D9().refresh();
    }

    private final void N9(boolean visible) {
        int i3;
        LinearLayout linearLayout = this.llContentContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llContentContainer");
            linearLayout = null;
        }
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
    }

    private final void initData() {
        LiveData<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>> R1 = D9().R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>, Unit> function1 = new Function1<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>, Unit>() { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailBodyPart$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedDetailBodyPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                FlockFeedDetailBodyPart flockFeedDetailBodyPart = FlockFeedDetailBodyPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                flockFeedDetailBodyPart.F9(it);
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.feeddetail.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockFeedDetailBodyPart.L9(Function1.this, obj);
            }
        });
        D9().refresh();
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    @Nullable
    public String C8(@NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) feed);
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        return this.f210080d.C8(feed);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void S4(@NotNull Context context, @NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.f210080d.S4(context, feed);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f210080d.T1();
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    @NotNull
    public Pair<Integer, Integer> Z5(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Pair) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f210080d.Z5(context);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void Z8(@NotNull Context context, @NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.f210080d.Z8(context, feed);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean a8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f210080d.a8();
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean c6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f210080d.c6();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FlockPublishFinishEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 19, (Object) this);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void j3(@NotNull Context context, int tagId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, tagId);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f210080d.j3(context, tagId);
        }
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void n2(@NotNull Context context, @NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.f210080d.n2(context, feed);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        PartIOCKt.registerIoc(this, this, com.tencent.mobileqq.flock.feedcommon.ioc.b.class);
        PartIOCKt.registerIoc(this, this, com.tencent.mobileqq.flock.feeddetail.ioc.b.class);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.f86434rn);
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
            smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.flock.feeddetail.part.a
                @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
                public final void onRefresh(IRefreshLayout iRefreshLayout) {
                    FlockFeedDetailBodyPart.M9(FlockFeedDetailBodyPart.this, iRefreshLayout);
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<SmartRefres\u2026          }\n            }");
            this.refreshLayout = smartRefreshLayout;
            View findViewById2 = rootView.findViewById(R.id.f789548g);
            RecyclerView recyclerView = (RecyclerView) findViewById2;
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext()));
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<RecyclerVie\u2026er(context)\n            }");
            this.rvFeedDetail = recyclerView;
            C9();
            View findViewById3 = rootView.findViewById(R.id.ynv);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ll_content_container)");
            this.llContentContainer = (LinearLayout) findViewById3;
            View findViewById4 = rootView.findViewById(R.id.vb_);
            FlockBlankView flockBlankView = (FlockBlankView) findViewById4;
            flockBlankView.d();
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<FlockBlankV\u2026adingView()\n            }");
            this.flockBlankView = flockBlankView;
            initData();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) event);
        } else if (event instanceof FlockPublishFinishEvent) {
            G9(((FlockPublishFinishEvent) event).getFeed());
        }
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean s1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f210080d.s1();
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean t3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f210080d.t3();
    }

    @Override // com.tencent.mobileqq.flock.feeddetail.ioc.b
    public void w0(@NotNull ImageView clickView, int index) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) clickView, index);
            return;
        }
        Intrinsics.checkNotNullParameter(clickView, "clickView");
        com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        com.tencent.mobileqq.flock.feeddetail.adapter.c cVar = this.mediaListAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            cVar = null;
        }
        List<com.tencent.mobileqq.flock.feeddetail.bean.b> items = cVar.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "mediaListAdapter.items");
        List<com.tencent.mobileqq.flock.feeddetail.bean.b> list = items;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.mobileqq.flock.feeddetail.bean.b) it.next()).e());
        }
        aVar.c(activity, new FlockLayerInitBean(index, clickView, arrayList));
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    @NotNull
    public String y8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f210080d.y8();
    }
}
