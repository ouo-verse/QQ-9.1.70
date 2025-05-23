package com.tencent.mm.ui.widget.pulldown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.bottomsheet.a;
import com.tencent.mm.ui.widget.picker.MMOptionPicker;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001b\u0010\u0018\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001f\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/NestScrollBounceSettingDialog;", "Lcom/google/android/material/bottomsheet/a;", "Landroid/widget/EditText;", "a", "Lkotlin/Lazy;", "getEdtMinDampingFactor", "()Landroid/widget/EditText;", "edtMinDampingFactor", "b", "getEdtMaxDampingFactor", "edtMaxDampingFactor", "c", "getEdtMaxSpringDuration", "edtMaxSpringDuration", "d", "getEdtMinSpringDuration", "edtMinSpringDuration", "e", "getEdtDecelerateRatio", "edtDecelerateRatio", "Landroid/widget/Button;", "f", "getBtnOk", "()Landroid/widget/Button;", "btnOk", "Landroid/view/View;", "kotlin.jvm.PlatformType", "g", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "contentView", "", h.F, "I", "getIndex", "()I", "setIndex", "(I)V", "index", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class NestScrollBounceSettingDialog extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy edtMinDampingFactor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Lazy edtMaxDampingFactor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Lazy edtMaxSpringDuration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Lazy edtMinSpringDuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Lazy edtDecelerateRatio;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Lazy btnOk;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final View contentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestScrollBounceSettingDialog(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: com.tencent.mm.ui.widget.pulldown.NestScrollBounceSettingDialog$edtMinDampingFactor$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                return (EditText) NestScrollBounceSettingDialog.this.getContentView().findViewById(R.id.uxf);
            }
        });
        this.edtMinDampingFactor = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: com.tencent.mm.ui.widget.pulldown.NestScrollBounceSettingDialog$edtMaxDampingFactor$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                return (EditText) NestScrollBounceSettingDialog.this.getContentView().findViewById(R.id.uxd);
            }
        });
        this.edtMaxDampingFactor = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: com.tencent.mm.ui.widget.pulldown.NestScrollBounceSettingDialog$edtMaxSpringDuration$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                return (EditText) NestScrollBounceSettingDialog.this.getContentView().findViewById(R.id.uxe);
            }
        });
        this.edtMaxSpringDuration = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: com.tencent.mm.ui.widget.pulldown.NestScrollBounceSettingDialog$edtMinSpringDuration$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                return (EditText) NestScrollBounceSettingDialog.this.getContentView().findViewById(R.id.uxg);
            }
        });
        this.edtMinSpringDuration = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: com.tencent.mm.ui.widget.pulldown.NestScrollBounceSettingDialog$edtDecelerateRatio$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                return (EditText) NestScrollBounceSettingDialog.this.getContentView().findViewById(R.id.ux6);
            }
        });
        this.edtDecelerateRatio = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Button>() { // from class: com.tencent.mm.ui.widget.pulldown.NestScrollBounceSettingDialog$btnOk$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Button invoke() {
                return (Button) NestScrollBounceSettingDialog.this.getContentView().findViewById(R.id.aip);
            }
        });
        this.btnOk = lazy6;
        View inflate = LayoutInflater.from(context).inflate(R.layout.fem, (ViewGroup) null, false);
        this.contentView = inflate;
        setContentView(inflate);
        EditText edtMinDampingFactor = getEdtMinDampingFactor();
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        edtMinDampingFactor.setText(String.valueOf(nestedBounceParam.getMinDampingFactor()));
        getEdtMaxDampingFactor().setText(String.valueOf(nestedBounceParam.getMaxDampingFactor()));
        getEdtMinSpringDuration().setText(String.valueOf(nestedBounceParam.getMinSpringDuration()));
        getEdtMaxSpringDuration().setText(String.valueOf(nestedBounceParam.getMaxSpringDuration()));
        getEdtDecelerateRatio().setText(String.valueOf(nestedBounceParam.getDecelerateRatio()));
        getBtnOk().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.pulldown.NestScrollBounceSettingDialog.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    NestedBounceParam nestedBounceParam2 = NestedBounceParam.INSTANCE;
                    nestedBounceParam2.setMinDampingFactor((int) Float.parseFloat(NestScrollBounceSettingDialog.this.getEdtMinDampingFactor().getText().toString()));
                    nestedBounceParam2.setMaxDampingFactor((int) Float.parseFloat(NestScrollBounceSettingDialog.this.getEdtMaxDampingFactor().getText().toString()));
                    nestedBounceParam2.setMinSpringDuration((int) Float.parseFloat(NestScrollBounceSettingDialog.this.getEdtMinSpringDuration().getText().toString()));
                    nestedBounceParam2.setMaxSpringDuration((int) Float.parseFloat(NestScrollBounceSettingDialog.this.getEdtMaxSpringDuration().getText().toString()));
                    nestedBounceParam2.setDecelerateRatio(Float.parseFloat(NestScrollBounceSettingDialog.this.getEdtDecelerateRatio().getText().toString()));
                } catch (Throwable unused) {
                }
                NestScrollBounceSettingDialog.this.dismiss();
            }
        });
        final ArrayList arrayList = new ArrayList();
        arrayList.add("default");
        arrayList.add("scale");
        View findViewById = findViewById(R.id.f213600t);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView = (TextView) findViewById;
        int curMode = nestedBounceParam.getCurMode();
        this.index = curMode;
        textView.setText((CharSequence) arrayList.get(curMode));
        View findViewById2 = findViewById(R.id.f213200p);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.Button");
        ((Button) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.pulldown.NestScrollBounceSettingDialog.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                final MMOptionPicker mMOptionPicker = new MMOptionPicker(NestScrollBounceSettingDialog.this.getContext(), (ArrayList<String>) arrayList);
                mMOptionPicker.setSelectedItem(NestScrollBounceSettingDialog.this.getIndex());
                final TextView textView2 = textView;
                final NestScrollBounceSettingDialog nestScrollBounceSettingDialog = NestScrollBounceSettingDialog.this;
                mMOptionPicker.setOnResultListener(new MMOptionPicker.OnResultListener<Object>() { // from class: com.tencent.mm.ui.widget.pulldown.NestScrollBounceSettingDialog.2.1
                    @Override // com.tencent.mm.ui.widget.picker.MMOptionPicker.OnResultListener
                    public void onResult(boolean hasSetResult, @Nullable Object result, @Nullable Object secondResult) {
                        MMOptionPicker.this.hide();
                        if (hasSetResult) {
                            TextView textView3 = textView2;
                            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.CharSequence");
                            textView3.setText((CharSequence) result);
                        }
                        NestedBounceParam.INSTANCE.setCurMode(MMOptionPicker.this.getSelectedItem());
                        nestScrollBounceSettingDialog.setIndex(MMOptionPicker.this.getSelectedItem());
                    }
                });
                mMOptionPicker.show();
            }
        });
    }

    @NotNull
    public final Button getBtnOk() {
        Object value = this.btnOk.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-btnOk>(...)");
        return (Button) value;
    }

    public final View getContentView() {
        return this.contentView;
    }

    @NotNull
    public final EditText getEdtDecelerateRatio() {
        Object value = this.edtDecelerateRatio.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-edtDecelerateRatio>(...)");
        return (EditText) value;
    }

    @NotNull
    public final EditText getEdtMaxDampingFactor() {
        Object value = this.edtMaxDampingFactor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-edtMaxDampingFactor>(...)");
        return (EditText) value;
    }

    @NotNull
    public final EditText getEdtMaxSpringDuration() {
        Object value = this.edtMaxSpringDuration.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-edtMaxSpringDuration>(...)");
        return (EditText) value;
    }

    @NotNull
    public final EditText getEdtMinDampingFactor() {
        Object value = this.edtMinDampingFactor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-edtMinDampingFactor>(...)");
        return (EditText) value;
    }

    @NotNull
    public final EditText getEdtMinSpringDuration() {
        Object value = this.edtMinSpringDuration.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-edtMinSpringDuration>(...)");
        return (EditText) value;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i3) {
        this.index = i3;
    }
}
