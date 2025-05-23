package com.tencent.qqnt.miniaio.input;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.miniaio.input.MiniAIOInputUIState;
import com.tencent.qqnt.miniaio.input.a;
import com.tencent.widget.PatchedButton;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.ad;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u00020\u0007B\u000f\u0012\u0006\u0010,\u001a\u00020\u0004\u00a2\u0006\u0004\b;\u0010+J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0014\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016JP\u0010&\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0016R\"\u0010,\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006<"}, d2 = {"Lcom/tencent/qqnt/miniaio/input/f;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/qqnt/miniaio/input/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Landroid/view/View$OnLayoutChangeListener;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", NodeProps.REQUEST_FOCUS, HippyTKDListViewAdapter.X, "Landroid/text/Editable;", "inputText", "t", "binding", ReportConstant.COSTREPORT_PREFIX, "", "Ljava/lang/Class;", "getObserverStates", "state", "l", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "Landroid/view/View;", "v", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "j", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "w", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "Lw71/ad;", "f", "Lw71/ad;", "mBinding", tl.h.F, "Z", "requestFocusAndShowSoft", "i", "I", "mInputHeight", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class f implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.qqnt.miniaio.input.viewbinding.a>, View.OnLayoutChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ad mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean requestFocusAndShowSoft;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mInputHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                f.this.t(s16);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) s16);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    public f(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
            this.requestFocusAndShowSoft = true;
        }
    }

    private final void k() {
        this.requestFocusAndShowSoft = false;
        ad adVar = this.mBinding;
        if (adVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            adVar = null;
        }
        adVar.f444727c.requestFocus();
    }

    private final void m() {
        ad adVar = this.mBinding;
        ad adVar2 = null;
        if (adVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            adVar = null;
        }
        LinearLayout root = adVar.getRoot();
        root.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        root.addOnLayoutChangeListener(this);
        ad adVar3 = this.mBinding;
        if (adVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            adVar3 = null;
        }
        AIOEditText initView$lambda$4 = adVar3.f444727c;
        Intrinsics.checkNotNullExpressionValue(initView$lambda$4, "initView$lambda$4");
        initView$lambda$4.addTextChangedListener(new a());
        initView$lambda$4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.qqnt.miniaio.input.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                f.n(f.this, view, z16);
            }
        });
        initView$lambda$4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.miniaio.input.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.o(f.this, view);
            }
        });
        initView$lambda$4.setEditableFactory(((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getInputQQTextBuilder());
        initView$lambda$4.setImeOptions(268435457);
        ad adVar4 = this.mBinding;
        if (adVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            adVar4 = null;
        }
        final ImageView imageView = adVar4.f444726b;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.miniaio.input.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.p(imageView, this, view);
            }
        });
        ad adVar5 = this.mBinding;
        if (adVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            adVar2 = adVar5;
        }
        adVar2.getRoot().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.qqnt.miniaio.input.e
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                f.r(f.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(f this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && this$0.requestFocusAndShowSoft) {
            ad adVar = this$0.mBinding;
            if (adVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                adVar = null;
            }
            adVar.f444726b.setSelected(false);
            this$0.v(new a.C9651a(false));
        }
        this$0.requestFocusAndShowSoft = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ad adVar = this$0.mBinding;
        if (adVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            adVar = null;
        }
        adVar.f444726b.setSelected(false);
        this$0.v(new a.C9651a(false));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ImageView this_apply, f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_apply.setSelected(!this_apply.isSelected());
        this$0.v(new a.C9651a(this_apply.isSelected()));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(f this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i29 = i18 - i16;
        if (i29 != this$0.mInputHeight) {
            this$0.mInputHeight = i29;
            this$0.v(new a.c(i3, i16, i17, i18));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(Editable inputText) {
        boolean isBlank;
        if (inputText == null) {
            return;
        }
        ad adVar = this.mBinding;
        if (adVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            adVar = null;
        }
        PatchedButton patchedButton = adVar.f444728d;
        isBlank = StringsKt__StringsJVMKt.isBlank(inputText);
        boolean z16 = true;
        boolean z17 = !isBlank;
        if (inputText.length() <= 0) {
            z16 = false;
        }
        patchedButton.setEnabled(z17 | z16);
    }

    private final void x(boolean requestFocus) {
        ad adVar = null;
        if (requestFocus) {
            ad adVar2 = this.mBinding;
            if (adVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                adVar2 = null;
            }
            adVar2.f444727c.requestFocus();
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        ad adVar3 = this.mBinding;
        if (adVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            adVar = adVar3;
        }
        inputMethodManager.showSoftInput(adVar.f444727c, 0);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            c.a.b(this);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        c.a.e(this, reuseParam);
        ad adVar = this.mBinding;
        ad adVar2 = null;
        if (adVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            adVar = null;
        }
        Editable text = adVar.f444727c.getText();
        if (text != null) {
            text.clear();
        }
        ad adVar3 = this.mBinding;
        if (adVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            adVar2 = adVar3;
        }
        adVar2.f444726b.setSelected(false);
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Bundle) iPatchRedirector.redirect((short) 11, (Object) this, (Object) dVar);
        }
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{MiniAIOInputUIState.UnselectEmoBtn.class, MiniAIOInputUIState.ShowKeyboard.class, MiniAIOInputUIState.AfterInputEmoji.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof MiniAIOInputUIState.ShowKeyboard) {
            x(true);
            return;
        }
        if (state instanceof MiniAIOInputUIState.UnselectEmoBtn) {
            ad adVar = this.mBinding;
            if (adVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                adVar = null;
            }
            adVar.f444726b.setSelected(false);
            return;
        }
        if (state instanceof MiniAIOInputUIState.AfterInputEmoji) {
            k();
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            c.a.d(this);
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(@NotNull View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, v3, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom), Integer.valueOf(oldLeft), Integer.valueOf(oldTop), Integer.valueOf(oldRight), Integer.valueOf(oldBottom));
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        int i3 = right - left;
        int i16 = bottom - top;
        int[] iArr = new int[2];
        v3.getLocationInWindow(iArr);
        int i17 = iArr[0];
        int i18 = iArr[1];
        v(new f.c(i17, i18, i3 + i17, i16 + i18));
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.qqnt.miniaio.input.viewbinding.a binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        this.mContext = context;
        this.mBinding = binding.e();
        m();
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void v(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
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
