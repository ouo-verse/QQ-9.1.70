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
public class ActivateFriendGridItem extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    int f177828d;

    /* renamed from: e, reason: collision with root package name */
    ImageView f177829e;

    /* renamed from: f, reason: collision with root package name */
    ImageView f177830f;

    /* renamed from: h, reason: collision with root package name */
    TextView f177831h;

    /* renamed from: i, reason: collision with root package name */
    TextView f177832i;

    /* renamed from: m, reason: collision with root package name */
    boolean f177833m;

    public ActivateFriendGridItem(Context context) {
        this(context, true, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a(Context context, boolean z16, boolean z17) {
        LayoutInflater.from(context).inflate(R.layout.aqh, (ViewGroup) this, true);
        this.f177829e = (ImageView) findViewById(R.id.icon);
        this.f177830f = (ImageView) findViewById(R.id.fqa);
        this.f177831h = (TextView) findViewById(R.id.f5e);
        this.f177832i = (TextView) findViewById(R.id.f164612aa0);
        if (!z17) {
            this.f177831h.setHorizontallyScrolling(false);
            this.f177832i.setHorizontallyScrolling(false);
        }
        if (!z16) {
            Drawable background = findViewById(R.id.d3r).getBackground();
            if (background != null && (background instanceof GradientDrawable)) {
                ((GradientDrawable) background).setColor(-1);
            }
            this.f177831h.setTextColor(-16777216);
        }
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) accessibilityNodeInfo);
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ImageView imageView = this.f177830f;
        if (imageView != null && imageView.getVisibility() != 8) {
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.f177833m);
        }
    }

    public void setBirthday(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            this.f177832i.setVisibility(8);
        } else {
            this.f177832i.setVisibility(0);
            this.f177832i.setText(str);
        }
    }

    public void setCheckViewGone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f177830f.setVisibility(8);
        }
    }

    public void setChecked(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        this.f177833m = z16;
        if (z16) {
            this.f177830f.setImageResource(R.drawable.ekx);
        } else {
            this.f177830f.setImageResource(R.drawable.ekz);
        }
        String str = "" + ((Object) this.f177831h.getText());
        if (this.f177832i.getVisibility() == 0) {
            str = str + ((Object) this.f177832i.getText());
        }
        setContentDescription(str);
    }

    public void setHead(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
        } else {
            this.f177829e.setImageBitmap(bitmap);
        }
    }

    public void setIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f177828d = i3;
        }
    }

    public void setNickName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f177831h.setText(str);
        }
    }

    public ActivateFriendGridItem(Context context, boolean z16, boolean z17) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.f177833m = true;
            a(context, z16, z17);
        }
    }
}
