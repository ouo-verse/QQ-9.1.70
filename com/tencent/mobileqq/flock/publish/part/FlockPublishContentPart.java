package com.tencent.mobileqq.flock.publish.part;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishUIStateViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\fR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "I9", "G9", "Landroid/text/Editable;", "input", "", "E9", "onInitView", "Landroid/widget/EditText;", "C9", "Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "d", "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "uiViewModel", "e", "Landroid/widget/EditText;", "titleInput", "f", "descInput", "Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart;", tl.h.F, "D9", "()Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart;", "keyboardPart", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishContentPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText titleInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText descInput;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy keyboardPart;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/flock/publish/part/FlockPublishContentPart$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f210263e;

        a(EditText editText) {
            this.f210263e = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishContentPart.this, (Object) editText);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                FlockPublishUIStateViewModel F9 = FlockPublishContentPart.this.F9();
                FlockPublishContentPart flockPublishContentPart = FlockPublishContentPart.this;
                Editable text = this.f210263e.getText();
                Intrinsics.checkNotNullExpressionValue(text, "text");
                F9.B2(flockPublishContentPart.E9(text));
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/flock/publish/part/FlockPublishContentPart$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f210265e;

        b(EditText editText) {
            this.f210265e = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishContentPart.this, (Object) editText);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                FlockPublishUIStateViewModel F9 = FlockPublishContentPart.this.F9();
                FlockPublishContentPart flockPublishContentPart = FlockPublishContentPart.this;
                Editable text = this.f210265e.getText();
                Intrinsics.checkNotNullExpressionValue(text, "text");
                F9.D2(flockPublishContentPart.E9(text));
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    public FlockPublishContentPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FlockPublishUIStateViewModel>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishContentPart$uiViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishContentPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FlockPublishUIStateViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FlockPublishUIStateViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FlockPublishContentPart flockPublishContentPart = FlockPublishContentPart.this;
                    Intent intent = flockPublishContentPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.f(flockPublishContentPart, intent);
                }
            });
            this.uiViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FlockPublishKeyboardPart>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishContentPart$keyboardPart$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishContentPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final FlockPublishKeyboardPart invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.mobileqq.flock.publish.a.c(FlockPublishContentPart.this) : (FlockPublishKeyboardPart) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.keyboardPart = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final FlockPublishKeyboardPart D9() {
        return (FlockPublishKeyboardPart) this.keyboardPart.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String E9(Editable input) {
        String b16 = com.tencent.mobileqq.flock.utils.a.b(input.toString());
        Intrinsics.checkNotNullExpressionValue(b16, "encodeQQEmotion(input.toString())");
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FlockPublishUIStateViewModel F9() {
        return (FlockPublishUIStateViewModel) this.uiViewModel.getValue();
    }

    private final void G9(View rootView) {
        EditText editText = (EditText) rootView.findViewById(R.id.vbm);
        Intrinsics.checkNotNullExpressionValue(editText, "this");
        new com.tencent.mobileqq.flock.widget.c(editText, 300, false, true, null, null, 52, null);
        editText.addTextChangedListener(new a(editText));
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.flock.publish.part.f
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                FlockPublishContentPart.H9(FlockPublishContentPart.this, view, z16);
            }
        });
        editText.setText(F9().a2());
        editText.setSelection(editText.getText().length());
        this.descInput = editText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(FlockPublishContentPart this$0, View view, boolean z16) {
        FlockPublishKeyboardPart D9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && (D9 = this$0.D9()) != null) {
            D9.O9(true);
        }
    }

    private final void I9(View rootView) {
        EditText editText = (EditText) rootView.findViewById(R.id.vbv);
        Intrinsics.checkNotNullExpressionValue(editText, "this");
        new com.tencent.mobileqq.flock.widget.c(editText, 15, false, true, " ", null, 32, null);
        editText.addTextChangedListener(new b(editText));
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.flock.publish.part.g
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                FlockPublishContentPart.J9(FlockPublishContentPart.this, view, z16);
            }
        });
        editText.setText(F9().b2());
        editText.setSelection(editText.getText().length());
        this.titleInput = editText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(FlockPublishContentPart this$0, View view, boolean z16) {
        FlockPublishKeyboardPart D9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && (D9 = this$0.D9()) != null) {
            D9.O9(false);
        }
    }

    @Nullable
    public final EditText C9() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EditText) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        EditText editText = this.titleInput;
        boolean z17 = true;
        if (editText != null && editText.isFocused()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return this.titleInput;
        }
        EditText editText2 = this.descInput;
        if (editText2 == null || !editText2.isFocused()) {
            z17 = false;
        }
        if (z17) {
            return this.descInput;
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        I9(rootView);
        G9(rootView);
    }
}
