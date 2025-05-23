package com.tencent.square.debugger;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000b\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/square/debugger/a;", "", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "c", "(Landroid/widget/LinearLayout;)V", ParseCommon.CONTAINER, "Landroid/widget/Button;", "b", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "(Landroid/widget/Button;)V", "button", "Landroid/widget/EditText;", "Landroid/widget/EditText;", "()Landroid/widget/EditText;", "d", "(Landroid/widget/EditText;)V", "edittext", "<init>", "()V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private LinearLayout container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Button button;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private EditText edittext;

    /* renamed from: a, reason: from getter */
    public final EditText getEdittext() {
        return this.edittext;
    }

    public final void b(Button button) {
        this.button = button;
    }

    public final void c(LinearLayout linearLayout) {
        this.container = linearLayout;
    }

    public final void d(EditText editText) {
        this.edittext = editText;
    }
}
