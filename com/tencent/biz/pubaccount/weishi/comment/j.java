package com.tencent.biz.pubaccount.weishi.comment;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class j implements TextWatcher {

    /* renamed from: d, reason: collision with root package name */
    private final CommentEditText f80592d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f80593e;

    /* renamed from: f, reason: collision with root package name */
    private int f80594f = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f80595h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f80596i = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f80597m = -1;
    private String C = "";

    public j(CommentEditText commentEditText) {
        this.f80592d = commentEditText;
        this.f80593e = commentEditText.getContext();
    }

    private int a(CharSequence charSequence, int i3) {
        x.i("WSCommentTextChangedListener", "[WSCommentTextChangedListener.java][findAtSymbol] str:" + ((Object) charSequence));
        return k.e(charSequence, i3, c(), b(), this.f80596i, this.f80597m, this.C);
    }

    private boolean d(String str, boolean z16) {
        x.i("WSCommentTextChangedListener", "[WSCommentTextChangedListener.java][isMatchAt] atCode:" + str);
        return k.g(str, z16, b(), this.f80596i, this.f80597m, this.C);
    }

    private void f() {
        this.C = "";
        this.f80596i = -1;
        this.f80597m = -1;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        SpannableStringBuilder spannableStringBuilder;
        x.b("WSCommentTextChangedListener", "[WSCommentTextChangedListener.java][afterTextChanged] s:" + ((Object) editable));
        if (editable == null) {
            return;
        }
        this.f80592d.removeTextChangedListener(this);
        if (editable.length() > 140) {
            QQToast.makeText(this.f80593e, HardCodeUtil.qqStr(R.string.kt5) + 140 + HardCodeUtil.qqStr(R.string.kt6), 0).show();
            int i3 = this.f80594f;
            editable.delete(i3, this.f80595h + i3);
        } else {
            String obj = editable.toString();
            int i16 = this.f80594f;
            int indexOf = obj.substring(i16, this.f80595h + i16).indexOf(47);
            if (indexOf < 0 || indexOf >= r0.length() - 1) {
                spannableStringBuilder = null;
            } else {
                spannableStringBuilder = new SpannableStringBuilder(editable.toString());
                com.tencent.biz.subscribe.comment.g.c(this.f80592d.getContext(), spannableStringBuilder);
            }
            if (spannableStringBuilder != null) {
                int selectionEnd = this.f80592d.getSelectionEnd();
                try {
                    this.f80592d.setText(spannableStringBuilder);
                } catch (ArrayIndexOutOfBoundsException unused) {
                    this.f80592d.setText(editable.toString());
                    selectionEnd = editable.toString().length();
                }
                this.f80592d.setSelection(selectionEnd);
            }
            this.f80595h = 0;
            this.f80594f = 0;
        }
        this.f80592d.addTextChangedListener(this);
    }

    abstract List<WSCommentFriendBaseInfo> b();

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        x.b("WSCommentTextChangedListener", "[WSCommentTextChangedListener.java][beforeTextChanged] s:" + ((Object) charSequence) + ", start:" + i3 + ", count:" + i16 + ", after:" + i17);
        if ((i16 == 1 || i16 == 2) && i17 == 0) {
            try {
                int a16 = a(charSequence, i3 + i16);
                this.f80596i = a16;
                if (a16 == -1) {
                    f();
                } else {
                    this.f80597m = i3;
                    this.C = charSequence.toString().substring(this.f80596i, this.f80597m + i16);
                }
            } catch (Exception unused) {
                f();
            }
        }
    }

    abstract int c();

    abstract void e();

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        x.b("WSCommentTextChangedListener", "[WSCommentTextChangedListener.java][onTextChanged] s:" + ((Object) charSequence) + ", start:" + i3 + ", count:" + i17 + ", before:" + i16);
        if (charSequence == null) {
            f();
            return;
        }
        this.f80592d.removeTextChangedListener(this);
        if (i17 == 1 && i16 == 0 && charSequence.toString().substring(i3, i3 + 1).equals("@")) {
            x.b("WSCommentTextChangedListener", "\u8f93\u5165@\u547c\u8d77\u597d\u53cb\u9009\u62e9\u5668");
            e();
        }
        if (d(this.C, true)) {
            this.f80592d.getEditableText().delete(this.f80596i, this.f80597m);
            this.f80594f = this.f80596i;
            this.f80595h = 0;
        } else {
            this.f80594f = i3;
            this.f80595h = i17;
        }
        f();
        this.f80592d.addTextChangedListener(this);
    }
}
