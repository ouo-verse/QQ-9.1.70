package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes12.dex */
public class DelFileHolderRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    RelativeLayout f209409d;

    /* renamed from: e, reason: collision with root package name */
    Context f209410e;

    public DelFileHolderRelativeLayout(Context context) {
        this(context, null);
    }

    public DelFileHolderRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DelFileHolderRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f209409d = null;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.g6r, this);
        this.f209409d = (RelativeLayout) findViewById(R.id.xaa);
        this.f209410e = context;
    }
}
