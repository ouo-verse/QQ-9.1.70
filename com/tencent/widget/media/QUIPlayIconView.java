package com.tencent.widget.media;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* loaded from: classes27.dex */
public class QUIPlayIconView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f384796i;

    /* renamed from: m, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f384797m;

    /* renamed from: d, reason: collision with root package name */
    private int f384798d;

    /* renamed from: e, reason: collision with root package name */
    private int f384799e;

    /* renamed from: f, reason: collision with root package name */
    private int f384800f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f384801h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56867);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        f384796i = hashMap;
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        f384797m = hashMap2;
        hashMap.put(0, Integer.valueOf(ViewUtils.dip2px(70.0f)));
        hashMap2.put(0, Integer.valueOf(ViewUtils.dip2px(29.0f)));
        hashMap.put(1, Integer.valueOf(ViewUtils.dip2px(57.0f)));
        hashMap2.put(1, Integer.valueOf(ViewUtils.dip2px(24.0f)));
        hashMap.put(2, Integer.valueOf(ViewUtils.dip2px(44.0f)));
        hashMap2.put(2, Integer.valueOf(ViewUtils.dip2px(24.0f)));
        hashMap.put(3, Integer.valueOf(ViewUtils.dip2px(30.0f)));
        hashMap2.put(3, Integer.valueOf(ViewUtils.dip2px(12.0f)));
    }

    public QUIPlayIconView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            int i3 = this.f384799e;
            layoutParams = new ViewGroup.LayoutParams(i3, i3);
        }
        int i16 = this.f384799e;
        layoutParams.width = i16;
        layoutParams.height = i16;
        setLayoutParams(layoutParams);
    }

    private void b() {
        ImageView imageView = this.f384801h;
        if (imageView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        if (layoutParams == null) {
            int i3 = this.f384800f;
            layoutParams = new FrameLayout.LayoutParams(i3, i3);
            layoutParams.gravity = 17;
        }
        int i16 = this.f384800f;
        layoutParams.width = i16;
        layoutParams.height = i16;
        this.f384801h.setLayoutParams(layoutParams);
    }

    private void c() {
        a();
        b();
    }

    private void d() {
        setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.qui_media_play_view_bg));
    }

    private void e() {
        ImageView imageView = new ImageView(getContext());
        this.f384801h = imageView;
        imageView.setImageDrawable(AppCompatResources.getDrawable(getContext(), R.drawable.qui_play_filled_icon_white));
        int i3 = this.f384800f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        addView(this.f384801h, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int i17 = this.f384799e;
        setMeasuredDimension(i17, i17);
    }

    public void setStyle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        HashMap<Integer, Integer> hashMap = f384796i;
        if (!hashMap.containsKey(Integer.valueOf(i3))) {
            QLog.d("QUIPlayIconView", 1, "error style");
            return;
        }
        this.f384798d = i3;
        this.f384799e = hashMap.get(Integer.valueOf(i3)).intValue();
        this.f384800f = f384797m.get(Integer.valueOf(this.f384798d)).intValue();
        c();
    }

    public QUIPlayIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QUIPlayIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    public QUIPlayIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.X5);
        this.f384798d = obtainStyledAttributes.getInt(jj2.b.Y5, 0);
        obtainStyledAttributes.recycle();
        this.f384799e = f384796i.get(Integer.valueOf(this.f384798d)).intValue();
        this.f384800f = f384797m.get(Integer.valueOf(this.f384798d)).intValue();
        d();
        e();
    }
}
