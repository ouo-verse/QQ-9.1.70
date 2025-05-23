package com.tencent.biz.qqcircle.widgets.person;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSettingSwitchView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name */
    private FormSwitchItem f93721d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93722e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f93723f;

    /* renamed from: h, reason: collision with root package name */
    private b f93724h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f93725i;

    /* renamed from: m, reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f93726m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            QFSSettingSwitchView.this.f93725i = z16;
            if (QFSSettingSwitchView.this.f93724h != null) {
                QFSSettingSwitchView.this.f93724h.onCheckedChanged(compoundButton, z16);
            }
            QFSSettingSwitchView.this.G0(z16);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void onCheckedChanged(CompoundButton compoundButton, boolean z16);
    }

    public QFSSettingSwitchView(@NonNull Context context) {
        this(context, null);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private String C0(boolean z16) {
        if (z16) {
            return getContext().getString(R.string.f181313df);
        }
        return getContext().getString(R.string.f181303de);
    }

    private void E0(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.g4x, (ViewGroup) this, true);
        this.f93722e = (TextView) findViewById(R.id.f55572i_);
        this.f93721d = (FormSwitchItem) findViewById(R.id.f913454x);
        this.f93723f = (TextView) findViewById(R.id.kbk);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.A5);
        String string = obtainStyledAttributes.getString(y91.a.D5);
        String string2 = obtainStyledAttributes.getString(y91.a.C5);
        int i3 = obtainStyledAttributes.getInt(y91.a.B5, 0);
        obtainStyledAttributes.recycle();
        this.f93721d.setBgType(i3);
        setTitle(string);
        setHide(string2);
        this.f93721d.setOnCheckedChangeListener(this.f93726m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(boolean z16) {
        this.f93721d.setContentDescription(this.f93721d.getTextView().getText().toString() + "\uff0c" + C0(z16));
        this.f93721d.getTextView().setImportantForAccessibility(2);
        this.f93721d.getSwitch().setImportantForAccessibility(1);
    }

    public Switch D0() {
        return this.f93721d.getSwitch();
    }

    public boolean F0() {
        return this.f93725i;
    }

    public void setBgType(int i3) {
        this.f93721d.setBgType(i3);
    }

    public void setChecked(boolean z16) {
        this.f93725i = z16;
        this.f93721d.setChecked(z16);
        G0(z16);
    }

    public void setCheckedOnly(boolean z16) {
        this.f93721d.setOnCheckedChangeListener(null);
        setChecked(z16);
        this.f93721d.setOnCheckedChangeListener(this.f93726m);
    }

    public void setDesTvVisibility(boolean z16) {
        int i3;
        TextView textView = this.f93723f;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public void setHead(String str) {
        if (this.f93722e == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f93722e.setVisibility(8);
        } else {
            this.f93722e.setVisibility(0);
            this.f93722e.setText(str);
        }
    }

    public void setHide(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f93723f.setVisibility(8);
            return;
        }
        this.f93723f.setVisibility(0);
        this.f93723f.setText(charSequence);
        if (charSequence instanceof SpannableString) {
            this.f93723f.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void setLeftIcon(int i3) {
        FormSwitchItem formSwitchItem = this.f93721d;
        if (formSwitchItem == null) {
            return;
        }
        if (i3 == 0) {
            formSwitchItem.setLeftIcon((Drawable) null);
        } else {
            formSwitchItem.setLeftIcon(getContext().getDrawable(i3), cx.a(20.0f), cx.a(20.0f));
        }
    }

    public void setListener(b bVar) {
        this.f93724h = bVar;
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f93721d.setText(str);
    }

    public QFSSettingSwitchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSSettingSwitchView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93726m = new a();
        E0(context, attributeSet);
    }
}
