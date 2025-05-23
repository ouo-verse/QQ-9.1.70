package com.tencent.robot.slash.dialog.content.list.vbdelegate.heightmeasure;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.SlashListUIState;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.heightmeasure.SlashListHeightProvideUIState;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u64.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\f\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00028\u0000`\u00072\u00020\bB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001f\u0010\u001bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016R\"\u0010\u001c\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00028\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/heightmeasure/a;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/e;", "Lcom/tencent/robot/widget/list/vb/ICommonListVMDelegate;", "Lcom/tencent/mvi/base/route/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "", "b", "(Lcom/tencent/mvi/api/runtime/b;Z)V", "intent", "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "call", "", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/robot/widget/list/vb/e;", "()Lcom/tencent/robot/widget/list/vb/e;", "f", "(Lcom/tencent/robot/widget/list/vb/e;)V", "mHost", "Lcom/tencent/mvi/api/runtime/b;", "mContext", "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a<C extends b> implements e<com.tencent.robot.widget.list.vb.a, CommonListUIState, C, com.tencent.robot.widget.list.vb.e>, com.tencent.mvi.base.route.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.robot.widget.list.vb.e mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private C mContext;

    public a(@NotNull com.tencent.robot.widget.list.vb.e mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull com.tencent.robot.widget.list.vb.a aVar) {
        e.a.a(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void b(@NotNull C context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        C c16 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        context.e().d(c.c(Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.DisplayModeChange.class)), this);
        C c17 = this.mContext;
        if (c17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            c16 = c17;
        }
        c16.e().d(c.c(Reflection.getOrCreateKotlinClass(CommonListMsgIntent.SubmitListMsgIntent.class)), this);
    }

    @Nullable
    public Void c() {
        return null;
    }

    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof BottomSheetDialogAdornMsgIntent.DisplayModeChange) {
            g(new SlashListUIState.DisplayModeState(((BottomSheetDialogAdornMsgIntent.DisplayModeChange) i3).getNewMode()));
        } else if (i3 instanceof CommonListMsgIntent.SubmitListMsgIntent) {
            g(new SlashListHeightProvideUIState.SetItemCount(((CommonListMsgIntent.SubmitListMsgIntent) i3).b().size()));
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public com.tencent.robot.widget.list.vb.e getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    public /* bridge */ /* synthetic */ Class<? extends com.tencent.robot.widget.list.vb.a> d0() {
        return (Class) c();
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull com.tencent.robot.widget.list.vb.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.robot.widget.list.vb.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.mHost = eVar;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull CommonListUIState commonListUIState) {
        e.a.b(this, commonListUIState);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        C c16 = this.mContext;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            c16 = null;
        }
        c16.e().b(c.c(Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.DisplayModeChange.class)), this);
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        return a.C9235a.a(this);
    }
}
