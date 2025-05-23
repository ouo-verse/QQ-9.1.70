package com.tencent.mobileqq.aio.robot.sendmsg;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.MainThread;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgUIState;
import com.tencent.mobileqq.aio.input.sendmsg.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.input.api.IInputSettingApi;
import com.tencent.util.InputMethodUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001)B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0004\u00a2\u0006\u0004\b'\u0010!J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u000e\u001a\u00020\u0007*\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0015\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0014\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0003H\u0016R\"\u0010\"\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVBDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", "t", "Landroid/widget/EditText;", "editText", "r", "", "isEnterSendMsg", "i", "v", "", "errMsg", "k", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "binding", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "state", "l", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "j", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "p", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "e", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "mBinding", "<init>", "f", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotAIOSendMsgVBDelegate implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.adorn.e mBinding;

    public RobotAIOSendMsgVBDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
    }

    private final void i(EditText editText, boolean z16) {
        int i3;
        if (z16) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        editText.setImeOptions(i3);
    }

    private final void k(String errMsg) {
        boolean z16;
        if (errMsg != null && errMsg.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("RobotAIOSendMsgVBDelegate", 1, "handleRecallFailed no toast");
            return;
        }
        com.tencent.mobileqq.aio.input.adorn.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        QQToast.makeText(eVar.getRoot().getContext(), errMsg, 0).show();
    }

    private final void r(EditText editText) {
        editText.getInputExtras(true).putInt(InputMethodUtil.FLAG_SOGOU_EXPRESSION, 1);
        i(editText, ((IInputSettingApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IInputSettingApi.class)).isEnterSendMsg());
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.b
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean s16;
                s16 = RobotAIOSendMsgVBDelegate.s(RobotAIOSendMsgVBDelegate.this, textView, i3, keyEvent);
                return s16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(RobotAIOSendMsgVBDelegate this$0, TextView textView, int i3, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 4) {
            this$0.o(a.C7284a.f189864d);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        QUIButton qUIButton;
        com.tencent.mobileqq.aio.input.adorn.e eVar = this.mBinding;
        com.tencent.mobileqq.aio.input.adorn.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        View d16 = eVar.d();
        d16.setEnabled(false);
        d16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotAIOSendMsgVBDelegate.u(RobotAIOSendMsgVBDelegate.this, view);
            }
        });
        if (d16 instanceof QUIButton) {
            qUIButton = (QUIButton) d16;
        } else {
            qUIButton = null;
        }
        if (qUIButton != null) {
            qUIButton.setType(0);
        }
        com.tencent.mobileqq.aio.input.adorn.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar3;
        }
        r(eVar2.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(RobotAIOSendMsgVBDelegate this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o(a.C7284a.f189864d);
        com.tencent.mobileqq.aio.utils.b.f194119a.k("em_aio_textbox_send_button");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v() {
        com.tencent.mobileqq.aio.input.adorn.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        QQToast.makeText(eVar.getRoot().getContext(), R.string.c8h, 0).show();
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        c.a.b(this);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        com.tencent.mobileqq.aio.input.adorn.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        i(eVar.a(), ((IInputSettingApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IInputSettingApi.class)).isEnterSendMsg());
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        c.a.a(this, inputUIState);
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{AIOSendMsgUIState.ShowInputOverLengthToast.class, AIOSendMsgUIState.RecallFailedState.class});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: j, reason: from getter and merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b M() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOSendMsgUIState.ShowInputOverLengthToast) {
            v();
        } else if (state instanceof AIOSendMsgUIState.RecallFailedState) {
            k(((AIOSendMsgUIState.RecallFailedState) state).a());
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new RobotAIOSendMsgVBDelegate$onViewParentPrepared$1(this, null), 2, null);
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void o(@NotNull at.a aVar) {
        c.a.f(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHost = bVar;
    }
}
