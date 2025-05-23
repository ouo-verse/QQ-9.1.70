package com.tencent.ecommerce.biz.orders.address;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.core.view.ViewKt;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b!\u0010\"J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0010R\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/g;", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "", "d", "Ljava/lang/String;", "preValue", "e", "I", "cursor", "Landroid/widget/EditText;", "f", "Landroid/widget/EditText;", "editView", h.F, "textLengthLimit", "i", "overLengthToast", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "clearBtn", "<init>", "(Landroid/widget/EditText;ILjava/lang/String;Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g implements TextWatcher {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String preValue = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int cursor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final EditText editView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int textLengthLimit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String overLengthToast;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final View clearBtn;

    public g(EditText editText, int i3, String str, View view) {
        this.editView = editText;
        this.textLengthLimit = i3;
        this.overLengthToast = str;
        this.clearBtn = view;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s16) {
        if (s16.length() > this.textLengthLimit) {
            i.f101155b.d(this.overLengthToast, ECToastIcon.ICON_ERROR, 0);
            this.editView.removeTextChangedListener(this);
            this.editView.setText(this.preValue);
            this.editView.setSelection(this.cursor);
            this.editView.addTextChangedListener(this);
            return;
        }
        View view = this.clearBtn;
        if (view != null) {
            ViewKt.setVisible(view, s16.length() > 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
        this.preValue = s16.toString();
        this.cursor = start;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s16, int start, int before, int count) {
    }
}
