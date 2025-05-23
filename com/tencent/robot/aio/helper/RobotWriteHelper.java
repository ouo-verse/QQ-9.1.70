package com.tencent.robot.aio.helper;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.input.AIOInputMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import com.tencent.robot.adelie.homepage.utils.StoryUtils;
import com.tencent.robot.aio.input.RobotWriteMsgIntent;
import com.tencent.robot.slash.api.IRobotSlashApi;
import d74.a;
import java.util.HashSet;
import java.util.Set;
import kotlin.C11736d;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\t*\u0001#\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/robot/aio/helper/RobotWriteHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", tl.h.F, "g", "e", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "", "onBackEvent", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Ld74/a;", "Ld74/a;", "mDialogManagerApi", "f", "Ljava/lang/String;", "mRobotUid", "Z", "mIsFetching", "com/tencent/robot/aio/helper/RobotWriteHelper$b", "i", "Lcom/tencent/robot/aio/helper/RobotWriteHelper$b;", "mAction1", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes25.dex */
public final class RobotWriteHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g, com.tencent.aio.api.runtime.emitter.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private d74.a mDialogManagerApi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFetching;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mRobotUid = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction1 = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/RobotWriteHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            RobotWriteHelper.this.h(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final void e() {
        this.mRobotUid = "";
        this.mIsFetching = false;
        d74.a aVar = this.mDialogManagerApi;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            aVar = null;
        }
        aVar.onDestroy();
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        aVar3.e().i(this, this.mAction1);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar4;
        }
        aVar2.b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    private final void g() {
        if (this.mIsFetching) {
            QLog.d("RobotWriteHelper", 1, "[fetchRobotStoryBoardData] isFetching return");
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.ci7, 0).show();
            return;
        }
        this.mIsFetching = true;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L, 1, null));
        StoryUtils.f366640a.m(this.mRobotUid, 4, "", false, new Function3<Boolean, String, QueryHalfViewDataRsp, Unit>() { // from class: com.tencent.robot.aio.helper.RobotWriteHelper$fetchRobotStoryBoardData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, QueryHalfViewDataRsp queryHalfViewDataRsp) {
                invoke(bool.booleanValue(), str, queryHalfViewDataRsp);
                return Unit.INSTANCE;
            }

            public final void invoke(final boolean z16, @NotNull final String errMsg, @NotNull final QueryHalfViewDataRsp rsp) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                if (QLog.isColorLevel()) {
                    QLog.i("RobotWriteHelper", 1, "fetchRobotStoryHalfViewData success: " + z16 + ", errMsg:" + errMsg);
                }
                final RobotWriteHelper robotWriteHelper = RobotWriteHelper.this;
                C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.aio.helper.RobotWriteHelper$fetchRobotStoryBoardData$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        com.tencent.aio.api.runtime.a aVar2;
                        RobotWriteHelper.this.mIsFetching = false;
                        aVar2 = RobotWriteHelper.this.mAIOContext;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                            aVar2 = null;
                        }
                        aVar2.e().h(new RobotWriteMsgIntent.GetBotWriteResponseMsgIntent(z16, errMsg, rsp));
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(MsgIntent intent) {
        d74.a aVar = null;
        if (intent instanceof RobotWriteMsgIntent.ShowRobotWriteDialog) {
            d74.a aVar2 = this.mDialogManagerApi;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            } else {
                aVar = aVar2;
            }
            aVar.showDialog();
            return;
        }
        if (intent instanceof InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) {
            ((InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) intent).b(onBackEvent());
            return;
        }
        if (intent instanceof AIOMsgSendEvent.AfterSendMsg) {
            d74.a aVar3 = this.mDialogManagerApi;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
                aVar3 = null;
            }
            a.C10165a.a(aVar3, false, 1, null);
            return;
        }
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            if (((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent).b()) {
                d74.a aVar4 = this.mDialogManagerApi;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
                    aVar4 = null;
                }
                a.C10165a.a(aVar4, false, 1, null);
                return;
            }
            return;
        }
        if (intent instanceof RobotWriteMsgIntent.RequestBotWriteMsgIntent) {
            g();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.K1;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.robot.aio.input.RobotWriteMsgIntent.ShowRobotWriteDialog");
        hashSet.add("com.tencent.robot.aio.input.RobotWriteMsgIntent.RequestBotWriteMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.DispatchKeyBackEventInPreIme");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.AfterSendMsg");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotWriteHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{3, 12};
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        d74.a aVar = this.mDialogManagerApi;
        d74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            aVar = null;
        }
        if (aVar.a()) {
            d74.a aVar3 = this.mDialogManagerApi;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            } else {
                aVar2 = aVar3;
            }
            aVar2.b(true);
            return true;
        }
        d74.a aVar4 = this.mDialogManagerApi;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            aVar4 = null;
        }
        if (aVar4.r()) {
            d74.a aVar5 = this.mDialogManagerApi;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
                aVar5 = null;
            }
            a.C10165a.a(aVar5, false, 1, null);
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
        this.mRobotUid = a16.g().r().c().j();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        aVar2.e().f(this, this.mAction1);
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
        IRobotSlashApi iRobotSlashApi = (IRobotSlashApi) QRoute.api(IRobotSlashApi.class);
        com.tencent.aio.api.runtime.a aVar6 = this.mAIOContext;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar6;
        }
        this.mDialogManagerApi = iRobotSlashApi.createRobotWriteManager(aVar, a18);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 12) {
            e();
        }
    }
}
