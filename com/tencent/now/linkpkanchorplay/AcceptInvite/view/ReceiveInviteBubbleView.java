package com.tencent.now.linkpkanchorplay.AcceptInvite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import fn3.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReceiveInviteBubbleView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f338118d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f338119e;

    public ReceiveInviteBubbleView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.ffb, this);
        this.f338118d = (TextView) findViewById(R.id.f9d);
        this.f338119e = (TextView) findViewById(R.id.f164692ti3);
    }

    public void setInviteBizType(int i3) {
        this.f338119e.setText(c.e(getContext(), i3));
    }

    public void setNickName(String str) {
        this.f338118d.setText(str);
    }

    public ReceiveInviteBubbleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ReceiveInviteBubbleView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }
}
