package com.tencent.mobileqq.activity.photo.albumlogicImp.view;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.c;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.activity.photo.album.photolist.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PhotoGridView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    PhotoListSceneBase f184446a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.photo.albumlogicImp.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class ViewOnClickListenerC7195a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        ViewOnClickListenerC7195a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                f<? extends OtherCommonData> fVar = a.this.f184446a.f184278h;
                if (fVar != null) {
                    fVar.P(view);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(PhotoListSceneBase photoListSceneBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) photoListSceneBase);
        } else {
            this.f184446a = photoListSceneBase;
        }
    }

    public static ColorStateList b(int i3, int i16, int i17, int i18) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]}, new int[]{i16, i17, i3, i17, i18, i3});
    }

    private boolean c() {
        return QQTheme.isDefaultTheme();
    }

    private boolean d() {
        return QQTheme.isNowSimpleUI();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.c
    public void a() {
        PeakFragmentActivity peakFragmentActivity;
        ColorStateList b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        PhotoListSceneBase photoListSceneBase = this.f184446a;
        if (photoListSceneBase == null || (peakFragmentActivity = photoListSceneBase.f184275d) == null) {
            return;
        }
        if (c()) {
            View view = this.f184446a.C;
            if (view != null) {
                view.setBackgroundColor(-1);
            }
            View view2 = this.f184446a.D;
            if (view2 != null) {
                view2.setBackgroundColor(-1);
            }
            TextView textView = this.f184446a.M;
            if (textView != null) {
                textView.setTextColor(-16777216);
            }
        }
        PhotoListSceneBase photoListSceneBase2 = this.f184446a;
        photoListSceneBase2.Q = new com.tencent.mobileqq.activity.photo.album.photolist.c(photoListSceneBase2.f184278h);
        PhotoListSceneBase photoListSceneBase3 = this.f184446a;
        PhotoGridView photoGridView = photoListSceneBase3.H;
        if (photoGridView != null) {
            photoGridView.setAdapter(photoListSceneBase3.Q);
        }
        View view3 = this.f184446a.C;
        if (view3 != null) {
            View findViewById = view3.findViewById(com.tencent.mobileqq.R.id.xzh);
            if (findViewById != null) {
                findViewById.setOnClickListener(new ViewOnClickListenerC7195a());
            }
            View findViewById2 = this.f184446a.C.findViewById(com.tencent.mobileqq.R.id.sjg);
            if (findViewById2 != null) {
                findViewById2.setBackgroundColor(peakFragmentActivity.getResources().getColor(com.tencent.mobileqq.R.color.skin_color_ffe6e6e6));
            }
        }
        TextView textView2 = this.f184446a.L;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (this.f184446a.P != null && (QQTheme.isDefaultTheme() || QQTheme.isNowSimpleUI())) {
            if (QQTheme.isNowThemeSimpleNight()) {
                this.f184446a.P.setBackgroundResource(com.tencent.mobileqq.R.drawable.ktc);
            } else {
                this.f184446a.P.setBackgroundResource(com.tencent.mobileqq.R.drawable.ktb);
            }
        }
        e();
        if (this.f184446a.H != null) {
            int dip2px = ViewUtils.dip2px(1.0f);
            this.f184446a.H.setPadding(dip2px, dip2px, dip2px, 0);
        }
        if (QQTheme.isNowSimpleUI()) {
            this.f184446a.M.setTextColor(peakFragmentActivity.getResources().getColor(com.tencent.mobileqq.R.color.skin_album_title_color));
        }
        if (c() || d() || QQTheme.isNowThemeIsNight()) {
            if (QQTheme.isNowThemeIsNight()) {
                b16 = b(Color.parseColor("#ffffffff"), Color.parseColor("#7fffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#66ffffff"));
            } else {
                b16 = b(Color.parseColor("#ff000000"), Color.parseColor("#7f000000"), Color.parseColor("#ff000000"), Color.parseColor("#66000000"));
            }
            TextView textView3 = this.f184446a.J;
            if (textView3 != null) {
                textView3.setTextColor(b16);
            }
            View view4 = this.f184446a.D;
            if (view4 == null) {
                return;
            }
            TextView textView4 = (TextView) view4.findViewById(com.tencent.mobileqq.R.id.ekt);
            if (textView4 != null) {
                textView4.setTextColor(b16);
            }
            TextView textView5 = (TextView) this.f184446a.D.findViewById(com.tencent.mobileqq.R.id.f166661h24);
            TextView textView6 = (TextView) this.f184446a.D.findViewById(com.tencent.mobileqq.R.id.h1z);
            if (textView5 != null) {
                textView5.setTextColor(b16);
            }
            if (textView6 != null) {
                textView6.setTextColor(b16);
            }
        }
        View view5 = this.f184446a.D;
        if (view5 != null) {
            view5.setPadding(0, 0, 0, view5.getPaddingBottom());
            View findViewById3 = this.f184446a.D.findViewById(com.tencent.mobileqq.R.id.sje);
            if (findViewById3 != null) {
                findViewById3.setBackgroundColor(peakFragmentActivity.getResources().getColor(com.tencent.mobileqq.R.color.skin_color_ffe6e6e6));
            }
        }
    }

    public void e() {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        PhotoListSceneBase photoListSceneBase = this.f184446a;
        if (photoListSceneBase == null || photoListSceneBase.N == null) {
            return;
        }
        int currentTextColor = photoListSceneBase.M.getCurrentTextColor();
        this.f184446a.N.getBackground().setColorFilter(currentTextColor, PorterDuff.Mode.SRC_ATOP);
        View view = this.f184446a.C;
        if (view != null && (imageView = (ImageView) view.findViewById(com.tencent.mobileqq.R.id.xzh)) != null && "1103".equals(QQTheme.getCurrentThemeId())) {
            imageView.getDrawable().setColorFilter(currentTextColor, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
