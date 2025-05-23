package com.tencent.mobileqq.aio.input.gag;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.aio.input.gag.InputGagUIState;
import com.tencent.mobileqq.aio.input.gag.b;
import com.tencent.mobileqq.aio.input.gag.d;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.x;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001?B\u000f\u0012\u0006\u0010-\u001a\u00020\u0004\u00a2\u0006\u0004\b=\u0010,J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\f\u0010\f\u001a\u00020\u000b*\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010!\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030 \u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0003H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u00182\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\u000bH\u0016R\"\u0010-\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u00105R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\t078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010;\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/aio/input/gag/InputGagVBDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", h.F, "", ReportConstant.COSTREPORT_PREFIX, "", "isGagMode", "", "gagWording", "j", "gagView", "t", "l", "enable", "w", "v", "Landroid/os/Bundle;", "k", "binding", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "", "Ljava/lang/Class;", "getObserverStates", "state", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/input/adorn/b;", "i", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "r", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "e", "Ljava/lang/Boolean;", "mIsGagMode", "f", "Ljava/lang/String;", "mGagWording", "Luu3/a;", "Luu3/a;", "mBinding", "Lkotlin/Lazy;", "Lkotlin/Lazy;", "mInputGag", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "gagTextMeasurePaint", "<init>", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class InputGagVBDelegate implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean mIsGagMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mGagWording;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private uu3.a mBinding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<TextView> mInputGag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint gagTextMeasurePaint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/input/gag/InputGagVBDelegate$a;", "", "", "GAG_VIEW_TEXT_SIZE_SP", UserInfo.SEX_FEMALE, "GAG_VIEW_TEXT_SIZE_SP_WHEN_ON_SMALL_SCREEN", "INPUT_GAG_HEIGHT_DP", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.gag.InputGagVBDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55586);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InputGagVBDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Lazy<TextView> lazy;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.input.gag.InputGagVBDelegate$mInputGag$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InputGagVBDelegate.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                uu3.a aVar;
                TextView h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                InputGagVBDelegate inputGagVBDelegate = InputGagVBDelegate.this;
                aVar = inputGagVBDelegate.mBinding;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    aVar = null;
                }
                Context context = aVar.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
                h16 = inputGagVBDelegate.h(context);
                return h16;
            }
        });
        this.mInputGag = lazy;
        this.gagTextMeasurePaint = new Paint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView h(Context context) {
        TextView textView = new TextView(context);
        textView.setId(R.id.xon);
        textView.setFocusable(true);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        s(textView);
        textView.setTextSize(0, TypedValue.applyDimension(2, 16.0f, context.getResources().getDisplayMetrics()));
        textView.setGravity(17);
        textView.setVisibility(8);
        textView.setFocusableInTouchMode(true);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.rightToRight = R.id.input;
        layoutParams.bottomToBottom = R.id.input;
        layoutParams.topToTop = R.id.input;
        layoutParams.leftToLeft = R.id.input;
        layoutParams.validate();
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private final void j(boolean isGagMode, String gagWording) {
        boolean equals$default;
        if (Intrinsics.areEqual(this.mIsGagMode, Boolean.valueOf(isGagMode))) {
            equals$default = StringsKt__StringsJVMKt.equals$default(this.mGagWording, gagWording, false, 2, null);
            if (equals$default) {
                return;
            }
        }
        TextView value = this.mInputGag.getValue();
        uu3.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        ConstraintLayout root = aVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        TextView textView = (TextView) o81.b.b(value, root, 0, 2, null);
        this.mIsGagMode = Boolean.valueOf(isGagMode);
        this.mGagWording = gagWording;
        if (isGagMode) {
            textView.setVisibility(0);
            textView.setText(gagWording);
            t(textView, gagWording);
        } else {
            textView.setVisibility(8);
            textView.setText("");
        }
        l(isGagMode);
        p(new b.a(isGagMode));
    }

    private final Bundle k() {
        Bundle bundle = new Bundle();
        Boolean bool = this.mIsGagMode;
        if (bool != null) {
            bundle.putBoolean("is_gag_mode", bool.booleanValue());
        }
        return bundle;
    }

    private final void l(boolean isGagMode) {
        w(!isGagMode);
        v(isGagMode);
    }

    private final void s(TextView textView) {
        AIOUtil aIOUtil = AIOUtil.f194084a;
        com.tencent.mobileqq.aio.input.themecompat.a aVar = com.tencent.mobileqq.aio.input.themecompat.a.f189924a;
        aIOUtil.G(textView, com.tencent.mobileqq.aio.input.themecompat.a.b(aVar, false, 1, null));
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(com.tencent.mobileqq.aio.input.themecompat.a.e(aVar, context, false, 2, null));
    }

    private final void t(final TextView gagView, final String gagWording) {
        gagView.post(new Runnable() { // from class: com.tencent.mobileqq.aio.input.gag.c
            @Override // java.lang.Runnable
            public final void run() {
                InputGagVBDelegate.u(InputGagVBDelegate.this, gagWording, gagView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(InputGagVBDelegate this$0, String gagWording, TextView gagView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gagWording, "$gagWording");
        Intrinsics.checkNotNullParameter(gagView, "$gagView");
        float f16 = 16.0f;
        this$0.gagTextMeasurePaint.setTextSize(x.a(16.0f));
        if (this$0.gagTextMeasurePaint.measureText(gagWording) > (gagView.getMeasuredWidth() - gagView.getPaddingLeft()) - gagView.getPaddingRight()) {
            f16 = 14.0f;
        }
        gagView.setTextSize(0, TypedValue.applyDimension(2, f16, gagView.getContext().getResources().getDisplayMetrics()));
    }

    private final void v(boolean isGagMode) {
        int i3;
        uu3.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        AIOEditText aIOEditText = aVar.f440053b;
        ViewGroup.LayoutParams layoutParams = aIOEditText.getLayoutParams();
        if (isGagMode) {
            i3 = ViewUtils.f352270a.a(36.0f);
        } else {
            i3 = -2;
        }
        layoutParams.height = i3;
        aIOEditText.requestLayout();
    }

    private final void w(boolean enable) {
        int i3;
        uu3.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        AIOEditText aIOEditText = aVar.f440053b;
        aIOEditText.setEnabled(enable);
        aIOEditText.setFocusable(enable);
        aIOEditText.setFocusableInTouchMode(enable);
        if (enable) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        aIOEditText.setVisibility(i3);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            c.a.b(this);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        TextView value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        Lazy<TextView> lazy = this.mInputGag;
        if (!lazy.isInitialized()) {
            lazy = null;
        }
        if (lazy != null && (value = lazy.getValue()) != null) {
            s(value);
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bundle) iPatchRedirector.redirect((short) 8, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof d.b) {
            return k();
        }
        return new Bundle();
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(InputGagUIState.ChangeInputGagModeUIState.class);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof InputGagUIState.ChangeInputGagModeUIState) {
            InputGagUIState.ChangeInputGagModeUIState changeInputGagModeUIState = (InputGagUIState.ChangeInputGagModeUIState) state;
            j(changeInputGagModeUIState.b(), changeInputGagModeUIState.a());
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
        } else {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.mBinding = binding.getImpl();
        }
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void p(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.mIsGagMode = null;
            this.mGagWording = null;
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }
}
