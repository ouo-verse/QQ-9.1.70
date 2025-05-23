package com.tencent.mobileqq.zplan.avatar.impl.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import jc3.ZPlanSoftInputIns;
import jc3.ZPlanTextInputEvent;
import jc3.a;
import jc3.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000fB'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0012\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J*\u0010\u0016\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J*\u0010\u0018\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010!\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/input/ZPlanUEInputHelperView;", "Landroid/widget/FrameLayout;", "Ljc3/a;", "Landroid/text/TextWatcher;", "", "g", "c", "Landroid/view/Window;", "window", "b", "f", "e", "d", "Ljc3/b;", "instruction", "a", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "Landroid/widget/EditText;", "Landroid/widget/EditText;", "mEditTxt", "", "Z", "mHandlingInput", "Ljc3/b;", "mOpenParams", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUEInputHelperView extends FrameLayout implements a, TextWatcher {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final EditText mEditTxt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mHandlingInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZPlanSoftInputIns mOpenParams;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanUEInputHelperView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void g() {
        String str;
        String initTxt;
        this.mEditTxt.removeTextChangedListener(this);
        EditText editText = this.mEditTxt;
        ZPlanSoftInputIns zPlanSoftInputIns = this.mOpenParams;
        if (zPlanSoftInputIns == null || (str = zPlanSoftInputIns.getInitTxt()) == null) {
            str = "";
        }
        editText.setText(str);
        EditText editText2 = this.mEditTxt;
        ZPlanSoftInputIns zPlanSoftInputIns2 = this.mOpenParams;
        editText2.setSelection((zPlanSoftInputIns2 == null || (initTxt = zPlanSoftInputIns2.getInitTxt()) == null) ? 0 : initTxt.length());
        this.mHandlingInput = true;
        this.mEditTxt.addTextChangedListener(this);
        KeyboardUtils.b(this.mEditTxt);
    }

    @Override // jc3.a
    public void a(ZPlanSoftInputIns instruction) {
        Intrinsics.checkNotNullParameter(instruction, "instruction");
        QLog.i("ZPlanUEInputHelperView_", 1, "handleInputInstruction instruction:" + instruction);
        int action = instruction.getAction();
        if (action == 0) {
            this.mOpenParams = instruction;
            g();
        } else {
            if (action != 1) {
                return;
            }
            c();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s16) {
        String str;
        String reqInfo;
        Editable text = this.mEditTxt.getText();
        String str2 = "";
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        QLog.i("ZPlanUEInputHelperView_", 1, "afterTextChanged text:" + str);
        ZPlanSoftInputIns zPlanSoftInputIns = this.mOpenParams;
        if (zPlanSoftInputIns != null && (reqInfo = zPlanSoftInputIns.getReqInfo()) != null) {
            str2 = reqInfo;
        }
        f.f409790e.m(new ZPlanTextInputEvent(2, str, str2));
    }

    public final void b(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        window.getAttributes().softInputMode = (window.getAttributes().softInputMode & 15) | 48;
    }

    public final void d() {
        c();
    }

    public final void e() {
        f.f409790e.c(this);
    }

    public final void f() {
        f.f409790e.b(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanUEInputHelperView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        this.mOpenParams = null;
        KeyboardUtils.a(this.mEditTxt);
        this.mEditTxt.removeTextChangedListener(this);
        this.mHandlingInput = false;
        this.mEditTxt.setText("");
    }

    public /* synthetic */ ZPlanUEInputHelperView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanUEInputHelperView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        EditText editText = new EditText(context, attributeSet, i3);
        this.mEditTxt = editText;
        addView(editText);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s16, int start, int before, int count) {
    }
}
