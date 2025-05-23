package com.tencent.robot.aio.input.inputbar.pttrecord;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.api.ability.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAudioRecordTouchEventApi;
import com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordUIState;
import com.tencent.robot.aio.input.inputbar.pttrecord.a;
import com.tencent.robot.aio.input.styleconfig.InputStyleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 62$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u00017B\u000f\u0012\u0006\u0010*\u001a\u00020\u0004\u00a2\u0006\u0004\b5\u0010)J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010\u001d\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001c\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\tH\u0016R\"\u0010*\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010+R\u0016\u0010-\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010+R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00101R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/b;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState$InputStyleConfigChangedState;", "state", "", "i", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState$FullScreenModeChangedState;", h.F, "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState$SetPttRecordModeState;", "j", "", "expectToDisplayPttRecord", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "l", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "f", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "e", "", "Ljava/lang/Class;", "getObserverStates", "binding", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "k", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/input/adorn/b;", "g", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "r", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Z", "mIsPttRecordMode", "mIsFullScreenMode", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "mInputStyleType", "Landroid/widget/TextView;", "mPttRecordTextView", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "mBinding", "<init>", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPttRecordMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private InputStyleType mInputStyleType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mPttRecordTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.inputbar.viewbinding.a mBinding;

    public b(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mInputStyleType = InputStyleType.STYLE_DEFAULT;
    }

    private final ConstraintLayout.LayoutParams e() {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = cVar.b(12);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = cVar.b(12);
        layoutParams.leftToRight = R.id.f772243s;
        layoutParams.bottomToBottom = 0;
        layoutParams.rightToLeft = R.id.f766842b;
        layoutParams.validate();
        return layoutParams;
    }

    private final TextView f(Context context) {
        TextView textView = new TextView(context);
        textView.setId(R.id.f7734444);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        textView.setGravity(17);
        textView.setIncludeFontPadding(true);
        textView.setMaxLines(1);
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        textView.setMinHeight(cVar.b(36));
        textView.setPadding(cVar.b(11), cVar.b(6), cVar.b(11), cVar.b(6));
        textView.setText(R.string.z78);
        textView.setTextColor(context.getColorStateList(R.color.qui_common_text_primary));
        textView.setTextSize(2, 17.0f);
        textView.setVisibility(0);
        textView.setLayoutParams(e());
        return textView;
    }

    private final void h(RobotInputPttRecordUIState.FullScreenModeChangedState state) {
        if (state.getIsFullScreenMode() == this.mIsFullScreenMode) {
            return;
        }
        boolean isFullScreenMode = state.getIsFullScreenMode();
        this.mIsFullScreenMode = isFullScreenMode;
        QLog.i("RobotInputPttRecordVBDelegate", 1, "handleInputStyleConfigChangedState " + isFullScreenMode);
        t(this.mIsPttRecordMode);
    }

    private final void i(RobotInputPttRecordUIState.InputStyleConfigChangedState state) {
        if (this.mInputStyleType == state.getInputStyleConfig().getInputStyleType()) {
            return;
        }
        InputStyleType inputStyleType = state.getInputStyleConfig().getInputStyleType();
        this.mInputStyleType = inputStyleType;
        QLog.i("RobotInputPttRecordVBDelegate", 1, "handleInputStyleConfigChangedState " + inputStyleType);
        t(this.mIsPttRecordMode);
    }

    private final void j(RobotInputPttRecordUIState.SetPttRecordModeState state) {
        if (this.mIsPttRecordMode == state.getIsPttRecordMode()) {
            return;
        }
        QLog.i("RobotInputPttRecordVBDelegate", 1, "handleSetPttRecordMode " + state.getIsPttRecordMode());
        t(state.getIsPttRecordMode());
    }

    private final void l() {
        QLog.i("RobotInputPttRecordVBDelegate", 1, "hidePttRecordView");
        TextView textView = this.mPttRecordTextView;
        if (textView != null && textView.getParent() != null) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar = null;
            }
            aVar.getRoot().removeView(this.mPttRecordTextView);
        }
    }

    private final boolean m() {
        ViewParent viewParent;
        TextView textView = this.mPttRecordTextView;
        if (textView != null) {
            viewParent = textView.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            return true;
        }
        return false;
    }

    private final void s() {
        QLog.i("RobotInputPttRecordVBDelegate", 1, "showPttRecordView");
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = null;
        if (this.mPttRecordTextView == null) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.mBinding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar2 = null;
            }
            Context context = aVar2.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
            this.mPttRecordTextView = f(context);
        }
        TextView textView = this.mPttRecordTextView;
        if (textView != null) {
            textView.setTextColor(textView.getContext().getColorStateList(R.color.qui_common_text_primary));
            textView.setBackground(ContextCompat.getDrawable(textView.getContext(), R.drawable.qui_aio_input_immersive_bg));
            if (textView.getParent() == null) {
                com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    aVar = aVar3;
                }
                aVar.getRoot().addView(textView);
            }
        }
    }

    private final void t(boolean expectToDisplayPttRecord) {
        if (!this.mIsFullScreenMode && com.tencent.robot.aio.input.styleconfig.c.a(this.mInputStyleType)) {
            if (expectToDisplayPttRecord) {
                s();
            } else {
                l();
            }
        } else {
            l();
        }
        boolean m3 = m();
        if (m3 != this.mIsPttRecordMode) {
            this.mIsPttRecordMode = m3;
            p(new a.PttRecordModeChangedMviIntent(this.mPttRecordTextView, m3));
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        c.a.b(this);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        c.a.a(this, inputUIState);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        c.a.e(this, reuseParam);
        this.mIsPttRecordMode = false;
        this.mIsFullScreenMode = false;
        l();
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: g, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull d dVar) {
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{RobotInputPttRecordUIState.InputStyleConfigChangedState.class, RobotInputPttRecordUIState.FullScreenModeChangedState.class, RobotInputPttRecordUIState.SetPttRecordModeState.class});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotInputPttRecordUIState.InputStyleConfigChangedState) {
            i((RobotInputPttRecordUIState.InputStyleConfigChangedState) state);
        } else if (state instanceof RobotInputPttRecordUIState.FullScreenModeChangedState) {
            h((RobotInputPttRecordUIState.FullScreenModeChangedState) state);
        } else if (state instanceof RobotInputPttRecordUIState.SetPttRecordModeState) {
            j((RobotInputPttRecordUIState.SetPttRecordModeState) state);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void p(@NotNull at.a aVar) {
        c.a.f(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
        ((IAudioRecordTouchEventApi) QRoute.api(IAudioRecordTouchEventApi.class)).destroy();
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHost = bVar;
    }
}
