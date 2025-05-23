package com.tencent.robot.aio.helper;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.AIOInputMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.nativeinterface.MenuInfo;
import com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordMsgIntent;
import com.tencent.robot.bottombar.RobotBottomSubMenuMsgIntent;
import com.tencent.robot.menu.RobotMenuBusinessDelegate;
import g34.b;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\t*\u0001)\b\u0007\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/robot/aio/helper/a;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "b", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lg34/b;", "e", "Lg34/b;", "mDialogManagerApi", "f", "Z", "mIsFetching", "Lcom/tencent/qqnt/kernel/nativeinterface/MenuInfo;", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/MenuInfo;", "mMenuInfo", "", "i", "J", "mRobotUin", "com/tencent/robot/aio/helper/a$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/aio/helper/a$b;", "mAction", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes25.dex */
public final class a implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g, com.tencent.aio.api.runtime.emitter.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private g34.b mDialogManagerApi;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFetching;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MenuInfo mMenuInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mRobotUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/a$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent msgIntent) {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            a.this.b(msgIntent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(MsgIntent msgIntent) {
        boolean z16;
        boolean z17;
        boolean z18;
        g34.b bVar = null;
        if (msgIntent instanceof RobotBottomSubMenuMsgIntent.ShowRobotMenuDialog) {
            g34.b bVar2 = this.mDialogManagerApi;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            } else {
                bVar = bVar2;
            }
            bVar.c(((RobotBottomSubMenuMsgIntent.ShowRobotMenuDialog) msgIntent).getDataSource());
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) {
            ((InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) msgIntent).b(onBackEvent());
            return;
        }
        if (msgIntent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            z16 = true;
        } else {
            z16 = msgIntent instanceof RobotInputPttRecordMsgIntent.OnPttRecordModeChanged;
        }
        if (z16) {
            z17 = true;
        } else {
            z17 = msgIntent instanceof InputEvent.SendVoiceInputStatusEvent;
        }
        if (z17) {
            z18 = true;
        } else {
            z18 = msgIntent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent;
        }
        if (z18) {
            g34.b bVar3 = this.mDialogManagerApi;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
                bVar3 = null;
            }
            b.a.a(bVar3, false, 1, null);
            return;
        }
        if (msgIntent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            if (((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) msgIntent).b()) {
                g34.b bVar4 = this.mDialogManagerApi;
                if (bVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
                    bVar4 = null;
                }
                b.a.a(bVar4, false, 1, null);
                return;
            }
            return;
        }
        if ((msgIntent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) && ((KeyboardMsgIntent.OnKeyboardStateChanged) msgIntent).b()) {
            g34.b bVar5 = this.mDialogManagerApi;
            if (bVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            } else {
                bVar = bVar5;
            }
            bVar.b(true);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.M1;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.robot.bottombar.RobotBottomSubMenuMsgIntent.ShowRobotMenuDialog");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.DispatchKeyBackEventInPreIme");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordMsgIntent.OnPttRecordModeChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.SendVoiceInputStatusEvent");
        hashSet.add("com.tencent.robot.aio.input.styleconfig.InputStyleConfigMsgIntent.OnInputStyleConfigChanged");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.OnFullScreenModeChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotBottomSubMenuHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        g34.b bVar = this.mDialogManagerApi;
        g34.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            bVar = null;
        }
        if (bVar.a()) {
            g34.b bVar3 = this.mDialogManagerApi;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            } else {
                bVar2 = bVar3;
            }
            bVar2.b(true);
            return true;
        }
        g34.b bVar4 = this.mDialogManagerApi;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            bVar4 = null;
        }
        if (bVar4.r()) {
            g34.b bVar5 = this.mDialogManagerApi;
            if (bVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
                bVar5 = null;
            }
            b.a.a(bVar5, false, 1, null);
        }
        return false;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        AIOParam g16 = a16.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        this.mRobotUin = su3.c.a(g16);
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        aVar2.e().f(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        ml3.a a17 = aVar3.b().a(com.tencent.aio.api.runtime.emitter.a.class);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar4 = null;
        }
        LifecycleOwner d16 = aVar4.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mAIOContext.lifecycleOwner");
        a17.b(this, d16);
        com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar5 = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar5.e().k(AIOInputMsgIntent.GetInputDialogAnchor.f189144d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.input.edit.AIOInputMsgResult.GetInputDialogAnchor");
        View a18 = ((d.e) k3).a();
        com.tencent.aio.api.runtime.a aVar6 = this.mAIOContext;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar6 = null;
        }
        com.tencent.aio.api.runtime.a aVar7 = this.mAIOContext;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar7;
        }
        this.mDialogManagerApi = new j24.b(aVar6, new RobotMenuBusinessDelegate(aVar, a18));
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        this.mRobotUin = 0L;
        com.tencent.aio.api.runtime.a aVar = null;
        this.mMenuInfo = null;
        this.mIsFetching = false;
        g34.b bVar = this.mDialogManagerApi;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            bVar = null;
        }
        bVar.onDestroy();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        aVar2.e().i(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar3;
        }
        aVar.b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
