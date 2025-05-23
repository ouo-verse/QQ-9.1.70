package com.tencent.av.ui.part.invite;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.utils.ba;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import mw.m;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends Part {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f76453d = null;

    /* renamed from: e, reason: collision with root package name */
    private TextView f76454e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f76455f;

    /* renamed from: h, reason: collision with root package name */
    private m f76456h;

    public g(boolean z16) {
        this.f76455f = z16;
    }

    private void x9() {
        ImageView imageView = this.f76453d;
        if (imageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        int screenWidth = ba.getScreenWidth(getContext());
        if (screenWidth <= 320) {
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.a4t);
            layoutParams.width = getContext().getResources().getDimensionPixelSize(R.dimen.a4p);
            layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.a4p);
        } else if (screenWidth <= 480) {
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.a4u);
            layoutParams.width = getContext().getResources().getDimensionPixelSize(R.dimen.a4q);
            layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.a4q);
        } else {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.cyz);
            layoutParams.topMargin = dimensionPixelSize;
            if (this.f76455f) {
                layoutParams.topMargin = dimensionPixelSize + getContext().getResources().getDimensionPixelSize(R.dimen.f159341cz0);
            }
            layoutParams.width = getContext().getResources().getDimensionPixelSize(R.dimen.a4s);
            layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.a4s);
        }
        this.f76453d.setLayoutParams(layoutParams);
    }

    private void z9() {
        ba.setAccText(this.f76454e, this.f76456h.b() + getContext().getString(R.string.f170486sm));
    }

    public void A9(String str) {
        TextView textView = this.f76454e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void B9(VideoAppInterface videoAppInterface, int i3, String str, String str2, Bitmap bitmap) {
        QavUpdateAvatarViewHelper.f().h(videoAppInterface, this.f76453d, new ew.a(i3, str, str2, true), bitmap);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            QLog.e("AVInviteHeadAndNamePart", 1, "onInitView rootView is null");
            return;
        }
        if (this.f76455f) {
            this.f76454e = (TextView) view.findViewById(R.id.ksf);
            this.f76453d = (ImageView) view.findViewById(R.id.kse);
        } else {
            this.f76454e = (TextView) view.findViewById(R.id.a2g);
            this.f76453d = (ImageView) view.findViewById(R.id.a2d);
        }
        x9();
        TextView textView = this.f76454e;
        if (textView != null) {
            textView.setTextColor(-1);
        }
        this.f76456h = (m) RFWIocAbilityProvider.g().getIocInterface(m.class, getPartRootView(), null);
        z9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f76454e = null;
        this.f76453d = null;
    }
}
