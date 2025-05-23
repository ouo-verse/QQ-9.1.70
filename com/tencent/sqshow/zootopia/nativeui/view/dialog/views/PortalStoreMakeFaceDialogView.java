package com.tencent.sqshow.zootopia.nativeui.view.dialog.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.event.SwitchAvatarViewportEvent;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewMode;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PortalStorePanelAllData;
import com.tencent.sqshow.zootopia.nativeui.ue.r;
import com.tencent.sqshow.zootopia.nativeui.ue.t;
import com.tencent.sqshow.zootopia.nativeui.view.customerface.MakeFaceExitHelper;
import com.tencent.sqshow.zootopia.widget.ZPlanAverageLinearLayout;
import h94.FinishAIMakeFaceData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import n74.bv;
import s94.FaceControlPointData;
import s94.FaceInfoSyncData;
import t74.u;
import uv4.av;
import uv4.ax;
import z94.a;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001\"B/\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\r\u0012\u0006\u0010+\u001a\u00020$\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b-\u0010\u0014R\u001b\u00102\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010/\u001a\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006C"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/PortalStoreMakeFaceDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/BaseSubPanelDialogView;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/sqshow/zootopia/avatar/event/SwitchAvatarViewportEvent;", "Lz94/a;", "Lcom/tencent/sqshow/zootopia/nativeui/ue/r;", "", "U", "X", "T", "V", "Y", "Z", "", "P", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "w", "", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "onDismiss", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Ls94/b;", "data", "c", "Ls94/c;", "faceData", "b", "a", "o", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "D", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", WadlProxyConsts.CHANNEL, "", "E", "MAKE_FACE_PERCENT", "Lkotlin/Lazy;", "W", "()F", "VIEW_HEIGHT", "Lcom/tencent/sqshow/zootopia/nativeui/view/customerface/g;", "G", "Lcom/tencent/sqshow/zootopia/nativeui/view/customerface/g;", "faceItemAdapter", "Ln74/bv;", "H", "Ln74/bv;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "I", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreMakeFaceDialogView extends BaseSubPanelDialogView implements SimpleEventReceiver<SwitchAvatarViewportEvent>, z94.a, r {

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: E, reason: from kotlin metadata */
    private final float MAKE_FACE_PERCENT;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy VIEW_HEIGHT;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.view.customerface.g faceItemAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private bv binding;

    public /* synthetic */ PortalStoreMakeFaceDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar);
    }

    private final void T() {
        com.tencent.sqshow.zootopia.nativeui.view.customerface.g gVar;
        List<ax> list;
        MutableLiveData<PortalStorePanelAllData> e16;
        PortalStorePanelAllData value;
        com.tencent.sqshow.zootopia.nativeui.data.repo.p dataControllerV1 = this.channel.getDataControllerV1();
        av faceEditorCfg = (dataControllerV1 == null || (e16 = dataControllerV1.e()) == null || (value = e16.getValue()) == null) ? null : value.getFaceEditorCfg();
        if (faceEditorCfg == null || (gVar = this.faceItemAdapter) == null) {
            return;
        }
        ax[] axVarArr = faceEditorCfg.f440237a;
        Intrinsics.checkNotNullExpressionValue(axVarArr, "it.slots");
        list = ArraysKt___ArraysKt.toList(axVarArr);
        gVar.p(list);
    }

    private final void U() {
        bv bvVar = this.binding;
        if (bvVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bvVar = null;
        }
        LinearLayout root = bvVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.channel.getReporter().a(root, "pg_zplan_avatar_sculpt");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V() {
        t avatarFaceController = this.channel.getAvatarFaceController();
        if (avatarFaceController != null) {
            avatarFaceController.j(FaceControlPointData.INSTANCE.a(), this.channel);
        }
        this.channel.Y(false);
        com.tencent.sqshow.zootopia.nativeui.view.customerface.g gVar = this.faceItemAdapter;
        if (gVar != null) {
            gVar.g();
        }
        bv bvVar = this.binding;
        if (bvVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bvVar = null;
        }
        bvVar.f418940d.l();
        Z();
    }

    private final float W() {
        return ((Number) this.VIEW_HEIGHT.getValue()).floatValue();
    }

    private final void X() {
        qu4.j jVar;
        bv bvVar = this.binding;
        bv bvVar2 = null;
        if (bvVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bvVar = null;
        }
        ViewGroup.LayoutParams layoutParams = bvVar.f418939c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).height = (int) W();
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.channel;
        qu4.a k3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.k();
        jVar2.W((k3 == null || (jVar = k3.f429573b) == null) ? null : bj3.a.j(jVar));
        this.channel.R(com.tencent.sqshow.zootopia.nativeui.ue.q.f371395a.b(this.channel.getEngineApi()));
        t avatarFaceController = this.channel.getAvatarFaceController();
        Intrinsics.checkNotNull(avatarFaceController);
        avatarFaceController.a(this);
        this.channel.Y(true);
        bv bvVar3 = this.binding;
        if (bvVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bvVar3 = null;
        }
        bvVar3.f418940d.g(this.channel);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.faceItemAdapter = new com.tencent.sqshow.zootopia.nativeui.view.customerface.g(context, this.channel);
        bv bvVar4 = this.binding;
        if (bvVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bvVar2 = bvVar4;
        }
        ZPlanAverageLinearLayout zPlanAverageLinearLayout = bvVar2.f418938b;
        com.tencent.sqshow.zootopia.nativeui.view.customerface.g gVar = this.faceItemAdapter;
        Intrinsics.checkNotNull(gVar);
        zPlanAverageLinearLayout.setAdapter(gVar);
        T();
    }

    private final void Y() {
        SimpleEventBus.getInstance().registerReceiver(this);
        z94.c.f452180e.b(this);
    }

    private final void Z() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        z94.c.f452180e.c(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected boolean F() {
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView
    public int P() {
        return 1;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public boolean a() {
        MakeFaceExitHelper makeFaceExitHelper = MakeFaceExitHelper.f371595a;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.channel;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        makeFaceExitHelper.c(jVar, context, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.PortalStoreMakeFaceDialogView$handleBackEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel;
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel2;
                mChannel = PortalStoreMakeFaceDialogView.this.getMChannel();
                if (mChannel.getNativeViewMode() == AvatarNativeViewMode.ONLY_MAKE_FACE) {
                    PortalStoreMakeFaceDialogView.this.V();
                    mChannel2 = PortalStoreMakeFaceDialogView.this.getMChannel();
                    Activity attachedActivity = mChannel2.getAttachedActivity();
                    if (attachedActivity != null) {
                        attachedActivity.finish();
                        return;
                    }
                    return;
                }
                PortalStoreMakeFaceDialogView.this.o();
            }
        });
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.r
    public void b(s94.c faceData) {
        Intrinsics.checkNotNullParameter(faceData, "faceData");
        this.channel.t().postValue(faceData);
    }

    @Override // z94.a
    public void c(FaceInfoSyncData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        t avatarFaceController = this.channel.getAvatarFaceController();
        if (avatarFaceController != null) {
            avatarFaceController.c(data, true);
        }
    }

    @Override // z94.a
    public void d(FinishAIMakeFaceData finishAIMakeFaceData) {
        a.C11666a.b(this, finishAIMakeFaceData);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SwitchAvatarViewportEvent>> getEventClass() {
        ArrayList<Class<SwitchAvatarViewportEvent>> arrayList = new ArrayList<>();
        arrayList.add(SwitchAvatarViewportEvent.class);
        return arrayList;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        Y();
        bv g16 = bv.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.binding = g16;
        U();
        X();
        bv bvVar = this.binding;
        if (bvVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bvVar = null;
        }
        LinearLayout root = bvVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public void o() {
        super.o();
        this.channel.W(null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView, com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void onDismiss() {
        super.onDismiss();
        V();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QLog.d("PortalStoreMakeFaceDialogView", 1, "onReceiveEvent:" + event);
        if (event instanceof SwitchAvatarViewportEvent) {
            int viewportType = ((SwitchAvatarViewportEvent) event).getViewportType();
            QLog.d("PortalStoreMakeFaceDialogView", 1, "targetType:" + viewportType);
            if (viewportType == 1) {
                o();
            }
        }
    }

    public final void setChannel(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.channel = jVar;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public Object w() {
        bv bvVar = this.binding;
        if (bvVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bvVar = null;
        }
        LinearLayout root = bvVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreMakeFaceDialogView(final Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(context, attributeSet, i3, channel);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.MAKE_FACE_PERCENT = 0.07f;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.PortalStoreMakeFaceDialogView$VIEW_HEIGHT$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float f16;
                float coerceAtLeast;
                f16 = PortalStoreMakeFaceDialogView.this.MAKE_FACE_PERCENT;
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f16 * u.INSTANCE.b(context), PortalStoreMakeFaceDialogView.this.getResources().getDimension(R.dimen.f11103v));
                return Float.valueOf(coerceAtLeast);
            }
        });
        this.VIEW_HEIGHT = lazy;
    }
}
