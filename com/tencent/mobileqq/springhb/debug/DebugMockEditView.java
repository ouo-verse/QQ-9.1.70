package com.tencent.mobileqq.springhb.debug;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001b\u0010\u001fB#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\u001b\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\f\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\nR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/springhb/debug/DebugMockEditView;", "Landroid/widget/RelativeLayout;", "", "b", "", "title", "setTitle", "", "editText", "setEditText", "Lkotlin/Function1;", "block", "setSureTextClick", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", "mEditText", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTitleTexView", "Landroid/widget/Button;", "f", "Landroid/widget/Button;", "mSureTextView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class DebugMockEditView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private EditText mEditText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mTitleTexView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Button mSureTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugMockEditView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.hq9, (ViewGroup) this, true);
            b();
        }
    }

    private final void b() {
        View findViewById = findViewById(R.id.ueq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.debug_edit)");
        this.mEditText = (EditText) findViewById;
        View findViewById2 = findViewById(R.id.uey);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.debug_title)");
        this.mTitleTexView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.uex);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.debug_text_sure)");
        this.mSureTextView = (Button) findViewById3;
    }

    public final void setEditText(@NotNull CharSequence editText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) editText);
            return;
        }
        Intrinsics.checkNotNullParameter(editText, "editText");
        EditText editText2 = this.mEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText2 = null;
        }
        editText2.setText(editText);
    }

    public final void setSureTextClick(@NotNull final Function1<? super String, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        b bVar = b.f289046a;
        Button button = this.mSureTextView;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSureTextView");
            button = null;
        }
        final long j3 = 200;
        final Button button2 = button;
        button.setOnClickListener(new View.OnClickListener(button2, j3, this, block) { // from class: com.tencent.mobileqq.springhb.debug.DebugMockEditView$setSureTextClick$$inlined$setSingleClickListener$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f289026d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f289027e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ DebugMockEditView f289028f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Function1 f289029h;

            {
                this.f289026d = button2;
                this.f289027e = j3;
                this.f289028f = this;
                this.f289029h = block;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, button2, Long.valueOf(j3), this, block);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EditText editText;
                EventCollector.getInstance().onViewClickedBefore(it);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    this.f289026d.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    editText = this.f289028f.mEditText;
                    if (editText == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                        editText = null;
                    }
                    String obj = editText.getText().toString();
                    if (!TextUtils.isEmpty(obj)) {
                        this.f289029h.invoke(obj);
                    }
                    View view = this.f289026d;
                    view.postDelayed(new Runnable(view) { // from class: com.tencent.mobileqq.springhb.debug.DebugMockEditView$setSureTextClick$$inlined$setSingleClickListener$1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ View f289030d;

                        {
                            this.f289030d = view;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) view);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                this.f289030d.setClickable(true);
                            }
                        }
                    }, this.f289027e);
                }
                EventCollector.getInstance().onViewClicked(it);
            }
        });
    }

    public final void setTitle(@NotNull String title) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) title);
            return;
        }
        Intrinsics.checkNotNullParameter(title, "title");
        TextView textView = this.mTitleTexView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleTexView");
            textView = null;
        }
        textView.setText(title);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugMockEditView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.hq9, (ViewGroup) this, true);
            b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugMockEditView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.hq9, (ViewGroup) this, true);
            b();
        }
    }
}
