package com.tencent.mobileqq.profilecard.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QidView extends FrameLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String TEXT_COLOR_SIMPLE = "#FFFFFF";
    private static final String TEXT_COLOR_VIP = "#6E3C06";
    private final ImageView icon;
    private final TextView nameView;

    public QidView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void update(String str, boolean z16, boolean z17, boolean z18) {
        Drawable drawable;
        int i3;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        Resources resources = getResources();
        if (TextUtils.isEmpty(str)) {
            if (z17) {
                setVisibility(8);
            } else {
                this.icon.setImageDrawable(resources.getDrawable(R.drawable.kuh));
                this.nameView.setVisibility(8);
            }
        } else {
            setVisibility(0);
            if (z16) {
                drawable = resources.getDrawable(R.drawable.kul);
                i3 = R.drawable.kuk;
                str2 = TEXT_COLOR_VIP;
            } else {
                drawable = resources.getDrawable(R.drawable.kuj);
                i3 = R.drawable.kui;
                str2 = TEXT_COLOR_SIMPLE;
            }
            this.icon.setImageDrawable(drawable);
            this.nameView.setBackgroundResource(i3);
            this.nameView.setText(str);
            this.nameView.setTextColor(Color.parseColor(str2));
            this.nameView.setVisibility(0);
        }
        if (z18) {
            setAlpha(0.7f);
        } else {
            setAlpha(1.0f);
        }
    }

    public QidView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QidView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        View.inflate(context, R.layout.f168844h13, this);
        this.nameView = (TextView) findViewById(R.id.f5e);
        this.icon = (ImageView) findViewById(R.id.icon);
    }
}
