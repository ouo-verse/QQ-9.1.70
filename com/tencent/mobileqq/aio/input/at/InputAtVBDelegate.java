package com.tencent.mobileqq.aio.input.at;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.view.View;
import android.widget.EditText;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.adorn.e;
import com.tencent.mobileqq.aio.input.at.b;
import com.tencent.mobileqq.aio.input.at.business.AtUtils;
import com.tencent.mobileqq.aio.input.at.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006B\u000f\u0012\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b3\u0010$J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R\"\u0010%\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00101\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/InputAtVBDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Lcom/tencent/mobileqq/aio/input/at/d$d;", "vbCmd", "Landroid/os/Bundle;", "k", "i", "Lcom/tencent/mobileqq/aio/input/at/d$e;", "l", "Lcom/tencent/mobileqq/aio/input/at/d$c;", "j", "Lcom/tencent/qqnt/aio/at/c;", "oldAtMemberSpan", "Landroid/text/SpannableString;", "f", "binding", "", "o", "", h.F, "a", "state", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", "d", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "g", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "Landroid/widget/EditText;", "Landroid/widget/EditText;", "mEditText", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "mInputWidthChangeListener", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class InputAtVBDelegate implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, e> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private EditText mEditText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener mInputWidthChangeListener;

    public InputAtVBDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
            this.mInputWidthChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.aio.input.at.c
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    InputAtVBDelegate.n(InputAtVBDelegate.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            };
        }
    }

    private final SpannableString f(com.tencent.qqnt.aio.at.c oldAtMemberSpan) {
        Context context;
        EditText editText;
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        } else {
            context = context2;
        }
        String h16 = oldAtMemberSpan.h();
        String k3 = oldAtMemberSpan.k();
        String i3 = oldAtMemberSpan.i();
        String j3 = oldAtMemberSpan.j();
        EditText editText2 = this.mEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        } else {
            editText = editText2;
        }
        SpannableString r16 = com.tencent.qqnt.aio.at.a.r(context, h16, k3, i3, j3, editText, 0, false, false);
        Intrinsics.checkNotNullExpressionValue(r16, "createAtSpannableStringF\u2026          false\n        )");
        return r16;
    }

    private final Bundle i() {
        Context context;
        EditText editText;
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context2 = null;
        }
        String string = context2.getString(R.string.f1624120c);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.string.list_item_at_all_name)");
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        } else {
            context = context3;
        }
        EditText editText2 = this.mEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        } else {
            editText = editText2;
        }
        CharSequence q16 = com.tencent.qqnt.aio.at.a.q(context, "0", "0", string, string, editText, 0, false);
        if (q16 == null) {
            q16 = "";
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("at_all_span", q16);
        return bundle;
    }

    private final Bundle j(final d.c vbCmd) {
        AtUtils atUtils = AtUtils.f189228a;
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        Editable editableText = editText.getEditableText();
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText3;
        }
        int f16 = atUtils.f(editableText, 0, editText2.length(), new Function1<com.tencent.qqnt.aio.at.c, Boolean>() { // from class: com.tencent.mobileqq.aio.input.at.InputAtVBDelegate$handleGetAtMemberSpanCountVBState$count$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.c.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.qqnt.aio.at.c it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<com.tencent.qqnt.aio.at.c, Boolean> a16 = d.c.this.a();
                return Boolean.valueOf(a16 != null ? a16.invoke(it).booleanValue() : true);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putInt("get_match_at_span_count", f16);
        return bundle;
    }

    private final Bundle k(d.C7258d vbCmd) {
        Context context;
        EditText editText;
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        } else {
            context = context2;
        }
        String b16 = vbCmd.b();
        String c16 = vbCmd.c();
        String d16 = vbCmd.d();
        String d17 = vbCmd.d();
        EditText editText2 = this.mEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        } else {
            editText = editText2;
        }
        CharSequence r16 = com.tencent.qqnt.aio.at.a.r(context, b16, c16, d16, d17, editText, 0, false, vbCmd.a());
        if (r16 == null) {
            r16 = "";
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("at_member_span", r16);
        return bundle;
    }

    private final Bundle l(final d.e vbCmd) {
        AtUtils atUtils = AtUtils.f189228a;
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        Editable editableText = editText.getEditableText();
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText3;
        }
        boolean i3 = atUtils.i(editableText, 0, editText2.length(), new Function1<com.tencent.qqnt.aio.at.c, Boolean>() { // from class: com.tencent.mobileqq.aio.input.at.InputAtVBDelegate$handleGetHasAtMemberSpanVBState$isAtExist$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.e.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.qqnt.aio.at.c it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.k().equals(d.e.this.a()));
            }
        });
        Bundle bundle = new Bundle();
        bundle.putBoolean("has_at_member_span", i3);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(InputAtVBDelegate this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        com.tencent.qqnt.aio.at.c[] cVarArr;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i29 = i27 - i19;
        int i36 = i17 - i3;
        if (i36 != i29 && i36 > 0 && i29 > 0) {
            this$0.r(b.C7252b.f189210d);
            EditText editText = this$0.mEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                editText = null;
            }
            Editable editableText = editText.getEditableText();
            if (editableText != null && (cVarArr = (com.tencent.qqnt.aio.at.c[]) editableText.getSpans(0, editableText.length(), com.tencent.qqnt.aio.at.c.class)) != null) {
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(cVarArr);
                com.tencent.qqnt.aio.at.c cVar = (com.tencent.qqnt.aio.at.c) firstOrNull;
                if (cVar != null) {
                    SpannableString f16 = this$0.f(cVar);
                    int spanStart = editableText.getSpanStart(cVar);
                    int spanEnd = editableText.getSpanEnd(cVar);
                    editableText.removeSpan(cVar);
                    editableText.replace(spanStart, spanEnd, f16);
                }
            }
            this$0.r(b.a.f189209d);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        c.a.b(this);
        View view = this.mRootView;
        EditText editText = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        EditText editText2 = this.mEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText = editText2;
        }
        r(new b.c(view, editText));
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else {
            c.a.e(this, bVar);
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
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
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bundle) iPatchRedirector.redirect((short) 8, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof d.C7258d) {
            return k((d.C7258d) stateCmd);
        }
        if (stateCmd instanceof d.b) {
            return i();
        }
        if (stateCmd instanceof d.e) {
            return l((d.e) stateCmd);
        }
        if (stateCmd instanceof d.c) {
            return j((d.c) stateCmd);
        }
        return new Bundle();
    }

    @Override // com.tencent.input.base.mvicompat.c
    public /* bridge */ /* synthetic */ List<Class<? extends InputUIState>> getObserverStates() {
        return (List) h();
    }

    @Nullable
    public Void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Void) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull e binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        View mRv = binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "it.root");
        this.mRootView = mRv;
        this.mEditText = binding.a();
        Context context = binding.getMRv().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        this.mContext = context;
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.addOnLayoutChangeListener(this.mInputWidthChangeListener);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            c.a.d(this);
        }
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void r(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
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
