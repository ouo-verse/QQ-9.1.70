package com.tencent.ecommerce.biz.orders.realname.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002R\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/widgets/CreateRealNameLayout;", "Landroid/widget/LinearLayout;", "", h.F, "e", "Landroid/widget/EditText;", "d", "f", "g", "", "isChecked", "j", "i", "Landroid/widget/EditText;", "realNameView", "realNameIdView", "Landroid/widget/CheckBox;", "Landroid/widget/CheckBox;", "protocolCheckBox", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "protocolView", "submitBtn", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/orders/realname/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "getSubmitClickListener", "()Lkotlin/jvm/functions/Function1;", "setSubmitClickListener", "(Lkotlin/jvm/functions/Function1;)V", "submitClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class CreateRealNameLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private EditText realNameView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private EditText realNameIdView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CheckBox protocolCheckBox;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView protocolView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView submitBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Function1<? super RealNameAccount, Unit> submitClickListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/realname/widgets/CreateRealNameLayout$initProtocolView$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CreateRealNameLayout.a(CreateRealNameLayout.this).setChecked(!CreateRealNameLayout.a(CreateRealNameLayout.this).isChecked());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged", "com/tencent/ecommerce/biz/orders/realname/widgets/CreateRealNameLayout$initProtocolView$2$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            CreateRealNameLayout.this.j(z16);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/realname/widgets/CreateRealNameLayout$initSubmitBtn$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CreateRealNameLayout.this.i();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public CreateRealNameLayout(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.cpv, (ViewGroup) this, true);
        h();
    }

    public static final /* synthetic */ CheckBox a(CreateRealNameLayout createRealNameLayout) {
        CheckBox checkBox = createRealNameLayout.protocolCheckBox;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protocolCheckBox");
        }
        return checkBox;
    }

    private final void d(EditText editText) {
        editText.setOnEditorActionListener(new b(editText));
    }

    private final void h() {
        e();
        f();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        boolean isBlank;
        boolean isBlank2;
        EditText editText = this.realNameView;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realNameView");
        }
        String obj = editText.getText().toString();
        EditText editText2 = this.realNameIdView;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realNameIdView");
        }
        String obj2 = editText2.getText().toString();
        isBlank = StringsKt__StringsJVMKt.isBlank(obj);
        if (!isBlank) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(obj2);
            if (isBlank2) {
                i.e(i.f101155b, R.string.wpl, null, 0, 6, null);
                return;
            }
            if (obj2.length() != 18) {
                i.e(i.f101155b, R.string.wpj, null, 0, 6, null);
                return;
            }
            CheckBox checkBox = this.protocolCheckBox;
            if (checkBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("protocolCheckBox");
            }
            if (!checkBox.isChecked()) {
                i.e(i.f101155b, R.string.wha, null, 0, 6, null);
                return;
            }
            Function1<? super RealNameAccount, Unit> function1 = this.submitClickListener;
            if (function1 != null) {
                function1.invoke(new RealNameAccount("", obj, obj2));
                return;
            }
            return;
        }
        i.e(i.f101155b, R.string.wpk, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(boolean isChecked) {
        Drawable drawable;
        CheckBox checkBox = this.protocolCheckBox;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protocolCheckBox");
        }
        if (isChecked) {
            drawable = ECSkin.INSTANCE.getDrawable(R.drawable.e6v);
        } else {
            drawable = ECSkin.INSTANCE.getDrawable(R.drawable.e5s);
        }
        checkBox.setBackground(drawable);
    }

    public final void setSubmitClickListener(Function1<? super RealNameAccount, Unit> function1) {
        this.submitClickListener = function1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements TextView.OnEditorActionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f103755d;

        b(EditText editText) {
            this.f103755d = editText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16;
            if (i3 == 6) {
                SoftKeyboardStateHelper.INSTANCE.b(this.f103755d);
                z16 = true;
            } else {
                z16 = false;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    private final void e() {
        Object[] plus;
        EditText editText = (EditText) findViewById(R.id.nyl);
        this.realNameView = editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realNameView");
        }
        d(editText);
        EditText editText2 = (EditText) findViewById(R.id.nym);
        this.realNameIdView = editText2;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realNameIdView");
        }
        d(editText2);
        EditText editText3 = this.realNameIdView;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realNameIdView");
        }
        plus = ArraysKt___ArraysJvmKt.plus((com.tencent.ecommerce.base.ktx.h[]) editText3.getFilters(), new com.tencent.ecommerce.base.ktx.h(18, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.realname.widgets.CreateRealNameLayout$initContentView$$inlined$doOnReachMaxLength$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i.e(i.f101155b, R.string.wpj, null, 0, 6, null);
            }
        }));
        editText3.setFilters((InputFilter[]) plus);
    }

    private final void f() {
        TextView textView = (TextView) findViewById(R.id.f163118oe2);
        textView.setOnClickListener(new c());
        Unit unit = Unit.INSTANCE;
        this.protocolView = textView;
        CheckBox checkBox = (CheckBox) findViewById(R.id.o1v);
        checkBox.setOnCheckedChangeListener(new d());
        this.protocolCheckBox = checkBox;
    }

    private final void g() {
        TextView textView = (TextView) findViewById(R.id.oef);
        textView.setOnClickListener(new e());
        Unit unit = Unit.INSTANCE;
        this.submitBtn = textView;
    }
}
