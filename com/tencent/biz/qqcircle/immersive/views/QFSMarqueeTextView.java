package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMarqueeTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f90399d;

    public QFSMarqueeTextView(Context context) {
        super(context);
        this.f90399d = true;
        a();
    }

    private void a() {
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMarqueeRepeatLimit(-1);
        setSingleLine();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f90399d;
    }

    public void setCanMarquee(boolean z16) {
        this.f90399d = z16;
        setSelected(z16);
    }

    public QFSMarqueeTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f90399d = true;
        a();
    }

    public QFSMarqueeTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90399d = true;
        a();
    }
}
