package com.tencent.mobileqq.now.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* loaded from: classes9.dex */
public class GeneralSharePagerView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    FrameLayout f254343d;

    /* renamed from: e, reason: collision with root package name */
    ImageView f254344e;

    public GeneralSharePagerView(@NonNull Context context) {
        this(context, null);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fpj, this);
        this.f254343d = (FrameLayout) inflate.findViewById(R.id.b_7);
        this.f254344e = (ImageView) inflate.findViewById(R.id.ykt);
    }

    public GeneralSharePagerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
