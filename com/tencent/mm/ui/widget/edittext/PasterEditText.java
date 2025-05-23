package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes9.dex */
public class PasterEditText extends EditText {

    /* renamed from: a, reason: collision with root package name */
    public Context f153250a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f153251b;

    /* renamed from: c, reason: collision with root package name */
    public int f153252c;

    /* renamed from: d, reason: collision with root package name */
    public int f153253d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f153254e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f153255f;

    /* renamed from: g, reason: collision with root package name */
    public int f153256g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f153257h;

    /* renamed from: i, reason: collision with root package name */
    public String f153258i;

    /* renamed from: j, reason: collision with root package name */
    public List f153259j;

    /* renamed from: k, reason: collision with root package name */
    public LinkedList f153260k;

    /* renamed from: l, reason: collision with root package name */
    public List f153261l;

    /* renamed from: m, reason: collision with root package name */
    public OnPrivateIMECommandListener f153262m;

    /* loaded from: classes9.dex */
    public interface TextPasteListener {
        void onTextPaste(Editable editable, CharSequence charSequence, int i3, int i16);
    }

    public PasterEditText(Context context) {
        super(context);
        this.f153251b = false;
        this.f153252c = 0;
        this.f153253d = 0;
        this.f153254e = "";
        this.f153255f = "";
        this.f153256g = 0;
        this.f153257h = false;
        this.f153258i = "";
        this.f153259j = new ArrayList();
        this.f153260k = new LinkedList();
        this.f153261l = Collections.synchronizedList(new LinkedList());
        this.f153262m = null;
        this.f153250a = context;
        a();
    }

    public void _setOnPrivateIMECommandListener(OnPrivateIMECommandListener onPrivateIMECommandListener) {
        this.f153262m = onPrivateIMECommandListener;
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher textWatcher) {
        this.f153260k.add(textWatcher);
    }

    public void addTextPasteListener(TextPasteListener textPasteListener) {
        this.f153261l.add(textPasteListener);
    }

    public CharSequence getPasterContent() {
        return this.f153255f;
    }

    public int getPasterLen() {
        return this.f153256g;
    }

    public boolean getSimilarPasteChange() {
        return this.f153257h;
    }

    public String getSimilarPasteSeqStr() {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < 3 && i3 < this.f153259j.size(); i3++) {
            if (i3 != 0) {
                sb5.append(",");
            }
            sb5.append(this.f153259j.get(i3));
        }
        return sb5.toString();
    }

    @Override // android.widget.TextView
    public boolean onPrivateIMECommand(String str, Bundle bundle) {
        OnPrivateIMECommandListener onPrivateIMECommandListener = this.f153262m;
        if (onPrivateIMECommandListener != null) {
            return onPrivateIMECommandListener.onPrivateIMECommand(str, bundle);
        }
        return super.onPrivateIMECommand(str, bundle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        if (i3 == 16908322) {
            this.f153251b = true;
            return super.onTextContextMenuItem(i3);
        }
        if (i3 == 16908321) {
            return super.onTextContextMenuItem(i3);
        }
        return super.onTextContextMenuItem(i3);
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(TextWatcher textWatcher) {
        this.f153260k.remove(textWatcher);
    }

    public void removeTextPasteListener(TextPasteListener textPasteListener) {
        this.f153261l.remove(textPasteListener);
    }

    public void resetSimilarPasteChange() {
        this.f153257h = false;
        this.f153259j.clear();
        this.f153258i = "";
    }

    public final void a() {
        super.addTextChangedListener(new TextWatcher() { // from class: com.tencent.mm.ui.widget.edittext.PasterEditText.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (PasterEditText.this.f153251b) {
                    PasterEditText.this.f153251b = false;
                    PasterEditText pasterEditText = PasterEditText.this;
                    pasterEditText.f153256g = pasterEditText.f153253d;
                    PasterEditText pasterEditText2 = PasterEditText.this;
                    pasterEditText2.f153255f = pasterEditText2.f153254e;
                    Iterator it = PasterEditText.this.f153261l.iterator();
                    while (it.hasNext()) {
                        ((TextPasteListener) it.next()).onTextPaste(editable, PasterEditText.this.f153254e, PasterEditText.this.f153252c, PasterEditText.this.f153253d);
                    }
                }
                int length = editable.length() - PasterEditText.this.f153258i.length();
                if (!PasterEditText.this.f153257h && length >= 10) {
                    PasterEditText.this.f153257h = true;
                }
                if (length >= 10) {
                    PasterEditText.this.f153259j.add(Integer.valueOf(length));
                }
                PasterEditText.this.f153258i = editable.toString();
                Iterator it5 = PasterEditText.this.f153260k.iterator();
                while (it5.hasNext()) {
                    ((TextWatcher) it5.next()).afterTextChanged(editable);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                Iterator it = PasterEditText.this.f153260k.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).beforeTextChanged(charSequence, i3, i16, i17);
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                PasterEditText.this.f153252c = i3;
                PasterEditText.this.f153253d = i17;
                PasterEditText.this.f153254e = charSequence.subSequence(i3, i3 + i17);
                Iterator it = PasterEditText.this.f153260k.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(charSequence, i3, i16, i17);
                }
            }
        });
    }

    public PasterEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f153251b = false;
        this.f153252c = 0;
        this.f153253d = 0;
        this.f153254e = "";
        this.f153255f = "";
        this.f153256g = 0;
        this.f153257h = false;
        this.f153258i = "";
        this.f153259j = new ArrayList();
        this.f153260k = new LinkedList();
        this.f153261l = Collections.synchronizedList(new LinkedList());
        this.f153262m = null;
        this.f153250a = context;
        a();
    }

    public PasterEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153251b = false;
        this.f153252c = 0;
        this.f153253d = 0;
        this.f153254e = "";
        this.f153255f = "";
        this.f153256g = 0;
        this.f153257h = false;
        this.f153258i = "";
        this.f153259j = new ArrayList();
        this.f153260k = new LinkedList();
        this.f153261l = Collections.synchronizedList(new LinkedList());
        this.f153262m = null;
        a();
    }
}
