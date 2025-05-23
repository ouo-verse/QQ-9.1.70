package com.tencent.mobileqq.qqexpand.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.av.utils.ba;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExtendFriendBottomBarView extends FrameLayout {
    private ArrayList<ImageView> C;
    private QQBlurView D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    boolean f264112d;

    /* renamed from: e, reason: collision with root package name */
    boolean f264113e;

    /* renamed from: f, reason: collision with root package name */
    boolean f264114f;

    /* renamed from: h, reason: collision with root package name */
    private BaseQQAppInterface f264115h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f264116i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f264117m;

    public ExtendFriendBottomBarView(Context context) {
        this(context, null);
    }

    private void a() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBottomBarView", 2, "hideBottomBar ");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f264116i, "translationY", 0.0f, this.E);
        ofFloat.setDuration(500L);
        ofFloat.start();
        if (this.f264114f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.D, "translationY", 0.0f, this.E);
            ofFloat2.setDuration(500L);
            ofFloat2.start();
        }
    }

    private void d() {
        Drawable mutate;
        this.E = x.c(getContext(), 66.0f);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f164626ac4);
        this.f264116i = relativeLayout;
        relativeLayout.setOnTouchListener(ba.f77070d);
        this.f264116i.setTranslationY(this.E);
        QQBlurView qQBlurView = (QQBlurView) findViewById(R.id.ac8);
        this.D = qQBlurView;
        qQBlurView.setTranslationY(this.E);
        this.C = new ArrayList<>();
        this.f264117m = (RelativeLayout) findViewById(R.id.d3o);
        for (int i3 = 0; i3 < this.f264117m.getChildCount(); i3++) {
            ImageView imageView = (ImageView) this.f264117m.getChildAt(i3);
            imageView.setVisibility(8);
            this.C.add(imageView);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.f164475yz);
        Drawable drawable = imageView2.getDrawable();
        if (drawable instanceof SkinnableBitmapDrawable) {
            mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
        } else {
            mutate = drawable.mutate();
        }
        mutate.setColorFilter(-16578534, PorterDuff.Mode.SRC_ATOP);
        imageView2.setImageDrawable(mutate);
    }

    private void e() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBottomBarView", 2, "showBottomBar ");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f264116i, "translationY", this.E, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.start();
        if (this.f264114f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.D, "translationY", this.E, 0.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.start();
        }
        ReportController.o(this.f264115h, "dc00898", "", "", "0X8009E2E", "0X8009E2E", 0, 0, "", "", "", "");
    }

    public void b(BaseQQAppInterface baseQQAppInterface, View view) {
        this.f264115h = baseQQAppInterface;
        if (view != null) {
            c(view);
        }
    }

    void c(View view) {
        boolean z16;
        if (!this.f264114f) {
            if (Build.VERSION.SDK_INT >= 24) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.D.setVisibility(0);
            this.D.j(view);
            QQBlurView qQBlurView = this.D;
            qQBlurView.m(qQBlurView);
            this.D.p(-1);
            this.D.setEnableBlur(z16);
            this.D.k(0);
            this.D.A(8.0f);
            this.D.l(8);
            this.D.setDisableBlurDrawableRes(R.drawable.b8c);
            this.D.x();
            this.D.onResume();
            this.f264114f = true;
        }
    }

    public void f(boolean z16) {
        if (!this.f264113e) {
            this.f264113e = true;
            this.f264112d = z16;
            if (!z16) {
                e();
                return;
            }
            return;
        }
        if (!this.f264112d && z16) {
            a();
        }
        if (this.f264112d && !z16) {
            e();
        }
        if (this.f264112d != z16) {
            this.f264112d = z16;
        }
    }

    public void g(List<String> list) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBottomBarView", 2, String.format("updateUinList uinList=%s", list));
        }
        if (list != null) {
            int size = list.size();
            if (size > 0) {
                int size2 = this.C.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ImageView imageView = this.C.get(i3);
                    if (i3 < size) {
                        str = list.get(i3);
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        imageView.setImageDrawable(((IColdPalaceUtils) QRoute.api(IColdPalaceUtils.class)).getFaceHeadDrawable(this.f264115h, str));
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(8);
                    }
                }
                this.f264117m.setVisibility(0);
                return;
            }
            this.f264117m.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout = this.f264116i;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(onClickListener);
        }
    }

    public ExtendFriendBottomBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExtendFriendBottomBarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        View.inflate(context, R.layout.gwl, this);
        d();
    }
}
