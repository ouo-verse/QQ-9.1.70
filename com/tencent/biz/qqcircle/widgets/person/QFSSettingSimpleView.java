package com.tencent.biz.qqcircle.widgets.person;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSFormSimpleItem;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSettingSimpleView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private QFSFormSimpleItem f93717d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93718e;

    /* renamed from: f, reason: collision with root package name */
    private View f93719f;

    /* renamed from: h, reason: collision with root package name */
    private int f93720h;

    public QFSSettingSimpleView(@NonNull Context context) {
        this(context, null);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gn6, (ViewGroup) this, true);
        this.f93717d = (QFSFormSimpleItem) inflate.findViewById(R.id.f487120q);
        this.f93718e = (TextView) inflate.findViewById(R.id.f487320s);
        this.f93719f = inflate.findViewById(R.id.f487220r);
    }

    public void b(boolean z16) {
        this.f93717d.showArrow(z16);
    }

    public void setBgType(int i3) {
        this.f93720h = i3;
        this.f93717d.setBgType(i3);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.f93717d.setOnClickListener(onClickListener);
    }

    public void setHint(CharSequence charSequence) {
        int i3;
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f93718e;
            if (this.f93720h == 0) {
                i3 = 4;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
            return;
        }
        this.f93718e.setVisibility(0);
        this.f93718e.setText(charSequence);
        if (charSequence instanceof SpannableString) {
            this.f93718e.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void setIsNeedGap(boolean z16) {
        int i3;
        View view = this.f93719f;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public void setLeftIcon(int i3) {
        QFSFormSimpleItem qFSFormSimpleItem = this.f93717d;
        if (qFSFormSimpleItem == null) {
            return;
        }
        if (i3 == 0) {
            qFSFormSimpleItem.setLeftIcon(null);
        } else {
            qFSFormSimpleItem.setLeftIcon(getContext().getDrawable(i3), cx.a(20.0f), cx.a(20.0f));
        }
    }

    public void setRightText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f93717d.setRightText("");
        } else {
            this.f93717d.setRightText(str);
        }
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f93717d.setLeftText("");
        } else {
            this.f93717d.setLeftText(str);
        }
    }

    public QFSSettingSimpleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSSettingSimpleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public QFSSettingSimpleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        a(context);
    }
}
