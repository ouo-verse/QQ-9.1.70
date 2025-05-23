package com.tencent.mobileqq.activity.activateFriend;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ActivateFriendViewItem extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    int f177843d;

    /* renamed from: e, reason: collision with root package name */
    ImageView f177844e;

    /* renamed from: f, reason: collision with root package name */
    ImageView f177845f;

    /* renamed from: h, reason: collision with root package name */
    TextView f177846h;

    /* renamed from: i, reason: collision with root package name */
    TextView f177847i;

    /* renamed from: m, reason: collision with root package name */
    boolean f177848m;

    public ActivateFriendViewItem(Context context) {
        this(context, true, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a(Context context, boolean z16, boolean z17) {
        LayoutInflater.from(context).inflate(R.layout.aqi, (ViewGroup) this, true);
        this.f177844e = (ImageView) findViewById(R.id.icon);
        this.f177845f = (ImageView) findViewById(R.id.fqa);
        this.f177846h = (TextView) findViewById(R.id.f5e);
        this.f177847i = (TextView) findViewById(R.id.f164612aa0);
        if (!z17) {
            this.f177846h.setHorizontallyScrolling(false);
            this.f177847i.setHorizontallyScrolling(false);
        }
        if (!z16) {
            Drawable background = findViewById(R.id.d3r).getBackground();
            if (background != null && (background instanceof GradientDrawable)) {
                ((GradientDrawable) background).setColor(-1);
            }
            this.f177846h.setTextColor(-16777216);
        }
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) accessibilityNodeInfo);
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ImageView imageView = this.f177845f;
        if (imageView != null && imageView.getVisibility() != 8) {
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.f177848m);
        }
    }

    public void setBirthday(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            this.f177847i.setVisibility(8);
        } else {
            this.f177847i.setVisibility(0);
            this.f177847i.setText(str);
        }
    }

    public void setChecked(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        this.f177848m = z16;
        if (z16) {
            this.f177845f.setImageResource(R.drawable.ekx);
        } else {
            this.f177845f.setImageResource(R.drawable.ekz);
        }
        String str = "" + ((Object) this.f177846h.getText());
        if (this.f177847i.getVisibility() == 0) {
            str = str + ((Object) this.f177847i.getText());
        }
        setContentDescription(str);
    }

    public void setHead(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
        } else {
            this.f177844e.setImageBitmap(bitmap);
        }
    }

    public void setIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f177843d = i3;
        }
    }

    public void setNickName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f177846h.setText(str);
        }
    }

    public ActivateFriendViewItem(Context context, boolean z16, boolean z17) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.f177848m = true;
            a(context, z16, z17);
        }
    }
}
