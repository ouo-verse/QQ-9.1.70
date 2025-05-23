package com.tencent.now.app.music.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import pp.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MusicSettingMenuItem extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f338061d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f338062e;

    public MusicSettingMenuItem(Context context) {
        this(context, null);
        b();
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArray = null;
        try {
            typedArray = getContext().obtainStyledAttributes(attributeSet, a.f426709g3);
            int resourceId = typedArray.getResourceId(a.f426718h3, -1);
            String string = typedArray.getString(a.i3);
            if (resourceId != -1) {
                this.f338061d.setImageResource(resourceId);
            }
            if (!TextUtils.isEmpty(string)) {
                this.f338062e.setText(string);
            }
        } catch (Throwable th5) {
            try {
                QLog.e("MusicSettingMenuItem", 1, "[initAttrsParams] fail, ", th5);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    private void b() {
        View inflate = View.inflate(getContext(), R.layout.hq8, this);
        this.f338061d = (ImageView) inflate.findViewById(R.id.eq5);
        this.f338062e = (TextView) inflate.findViewById(R.id.eqc);
    }

    public void setMenuIcon(int i3) {
        this.f338061d.setImageResource(i3);
    }

    public void setText(int i3) {
        this.f338062e.setText(i3);
    }

    public void setTextColor(int i3) {
        this.f338062e.setTextColor(i3);
    }

    public void setMenuIcon(Drawable drawable) {
        this.f338061d.setImageDrawable(drawable);
    }

    public MusicSettingMenuItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b();
        a(attributeSet);
    }

    public MusicSettingMenuItem(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b();
        a(attributeSet);
    }
}
