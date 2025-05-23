package com.tencent.av.ui.part.invite;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class l extends Part implements ew.b {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f76472d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f76473e;

    @Override // ew.b
    public void D1(ew.a aVar, Drawable drawable) {
        ImageView imageView = this.f76472d;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f76472d.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        View findViewById;
        QLog.d("AudioGaussianBgPart", 1, "onInitView");
        if (view == null) {
            QLog.e("AudioGaussianBgPart", 1, "onInitView rootView is null");
            return;
        }
        super.onInitView(view);
        this.f76472d = (ImageView) view.findViewById(R.id.f11767723);
        this.f76473e = (ImageView) view.findViewById(R.id.f30100nf);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.root_layout);
        Drawable a16 = com.tencent.av.utils.g.a(getActivity().getApplicationContext(), R.drawable.dbb);
        if (relativeLayout != null) {
            if (a16 != null) {
                relativeLayout.setBackgroundDrawable(a16);
            } else {
                relativeLayout.setBackgroundResource(R.drawable.dbb);
            }
        }
        if (!ThemeUtil.isInNightMode(nw.b.b()) || (findViewById = view.findViewById(R.id.m18)) == null) {
            return;
        }
        findViewById.setVisibility(0);
    }

    public void x9(boolean z16) {
        ImageView imageView = this.f76473e;
        if (imageView != null) {
            imageView.setVisibility(z16 ? 0 : 8);
        }
    }
}
