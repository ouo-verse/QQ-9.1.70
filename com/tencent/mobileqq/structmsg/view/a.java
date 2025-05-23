package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    public int R0;
    public String S0;
    public String T0;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f290322e = "head";
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        return m(context, view, this.R0, bundle);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return false;
        }
        String a16 = jVar.a("uin");
        String str = "";
        if (a16 == null) {
            a16 = "";
        }
        this.S0 = a16;
        String a17 = jVar.a("nick");
        if (a17 != null) {
            str = a17;
        }
        this.T0 = str;
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "Avatar";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.S0 = objectInput.readUTF();
        this.T0 = objectInput.readUTF();
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "head");
        String str = this.S0;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        xmlSerializer.attribute(null, "uin", str);
        String str3 = this.T0;
        if (str3 != null) {
            str2 = str3;
        }
        xmlSerializer.attribute(null, "nick", str2);
        xmlSerializer.endTag(null, "head");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        String str = this.S0;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
        String str3 = this.T0;
        if (str3 != null) {
            str2 = str3;
        }
        objectOutput.writeUTF(str2);
    }

    public View m(Context context, View view, int i3, Bundle bundle) {
        LinearLayout linearLayout;
        int i16;
        int i17;
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, view, Integer.valueOf(i3), bundle);
        }
        Resources resources = context.getResources();
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
            imageView2 = (ImageView) linearLayout.findViewById(R.id.k5l);
            imageView = (ImageView) linearLayout.findViewById(R.id.k5o);
            textView = (TextView) linearLayout.findViewById(R.id.k5m);
        } else {
            linearLayout = new LinearLayout(context);
            linearLayout.setId(R.id.k5n);
            linearLayout.setOrientation(1);
            int i18 = this.R0;
            if (i18 == 4) {
                i16 = 53;
            } else {
                i16 = 180;
            }
            if (i18 == 4) {
                i17 = 53;
            } else {
                i17 = 135;
            }
            int i19 = bundle.getInt("bundle_args_cover_width", BaseAIOUtils.f(i16, resources));
            int i26 = bundle.getInt("bundle_args_cover_height", BaseAIOUtils.f(i17, resources));
            FrameLayout frameLayout = new FrameLayout(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i19, i26);
            layoutParams.gravity = 1;
            frameLayout.setLayoutParams(layoutParams);
            linearLayout.addView(frameLayout);
            if (i3 == 4) {
                int i27 = bundle.getInt("bundle_args_avatar_width", BaseAIOUtils.f(50.0f, resources));
                int i28 = bundle.getInt("bundle_args_avatar_height", BaseAIOUtils.f(50.0f, resources));
                ImageView imageView3 = new ImageView(context);
                imageView3.setId(R.id.k5l);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i27, i28);
                layoutParams2.gravity = 17;
                frameLayout.addView(imageView3, layoutParams2);
                ImageView imageView4 = new ImageView(context);
                imageView4.setId(R.id.k5o);
                frameLayout.addView(imageView4, new FrameLayout.LayoutParams(-1, -1));
                textView = null;
                imageView = imageView4;
                imageView2 = imageView3;
            } else {
                int i29 = bundle.getInt("bundle_args_avatar_width", BaseAIOUtils.f(80.0f, resources));
                int i36 = bundle.getInt("bundle_args_avatar_height", BaseAIOUtils.f(80.0f, resources));
                ImageView imageView5 = new ImageView(context);
                imageView5.setId(R.id.k5l);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i29, i36);
                layoutParams3.gravity = 17;
                frameLayout.addView(imageView5, layoutParams3);
                ImageView imageView6 = new ImageView(context);
                imageView6.setId(R.id.k5o);
                frameLayout.addView(imageView6, new FrameLayout.LayoutParams(-1, -1));
                TextView textView2 = new TextView(context);
                textView2.setId(R.id.k5m);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(BaseAIOUtils.f(180.0f, resources), -2);
                layoutParams4.gravity = 1;
                layoutParams4.topMargin = BaseAIOUtils.f(5.0f, resources);
                textView2.setLayoutParams(layoutParams4);
                textView2.setGravity(1);
                linearLayout.addView(textView2);
                imageView = imageView6;
                textView = textView2;
                imageView2 = imageView5;
            }
        }
        Drawable defaultFaceDrawable140_140 = BaseImageUtil.getDefaultFaceDrawable140_140();
        if (context instanceof BaseActivity) {
            defaultFaceDrawable140_140 = FaceDrawable.getFaceDrawable(((BaseActivity) context).app, 1, this.S0, 3, defaultFaceDrawable140_140, defaultFaceDrawable140_140);
        }
        imageView2.setImageDrawable(defaultFaceDrawable140_140);
        if (imageView != null) {
            if (i3 == 2) {
                imageView.setImageResource(R.drawable.h2m);
            } else if (i3 == 1) {
                imageView.setImageResource(R.drawable.h2o);
            } else if (i3 == 3) {
                imageView.setImageResource(R.drawable.h2n);
            } else if (i3 == 4) {
                imageView.setImageResource(R.drawable.f162484b51);
            }
        }
        if (textView != null) {
            textView.setText(this.T0);
            textView.setTextSize(2, 20.0f);
            textView.setTextColor(-1);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
        return linearLayout;
    }

    public a(int i3, String str, String str2) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
            return;
        }
        this.R0 = i3;
        this.S0 = str;
        this.T0 = str2;
    }
}
