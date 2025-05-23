package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendFooterView extends FrameLayout {
    public ExtendFriendFooterView(Context context) {
        this(context, null);
    }

    public ExtendFriendFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExtendFriendFooterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater.from(context).inflate(R.layout.au9, (ViewGroup) this, true);
    }
}
