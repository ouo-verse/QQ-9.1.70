package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qwallet.widget.QQWalletTransferBubbleView;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    protected String X0;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void E(Context context, AbsStructMsgElement absStructMsgElement, Bundle bundle, ViewGroup viewGroup) {
        c cVar = (c) absStructMsgElement;
        if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout19", 2, "logo url = " + cVar.S0);
        }
        if (TextUtils.isEmpty(cVar.S0)) {
            return;
        }
        try {
            new URL(cVar.S0);
            Resources resources = context.getResources();
            int f16 = BaseAIOUtils.f(44.0f, resources);
            URLImageView uRLImageView = new URLImageView(context);
            uRLImageView.setAdjustViewBounds(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, BaseAIOUtils.f(16.0f, resources), BaseAIOUtils.f(18.0f, resources), BaseAIOUtils.f(14.0f, resources));
            layoutParams.addRule(11);
            layoutParams.width = f16;
            layoutParams.height = f16;
            uRLImageView.setLayoutParams(layoutParams);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = f16;
            obtain.mRequestHeight = f16;
            URLDrawable drawable = URLDrawable.getDrawable(cVar.S0, obtain);
            drawable.setAutoDownload(true);
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            uRLImageView.setImageDrawable(drawable);
            uRLImageView.setId(R.id.j4j);
            viewGroup.addView(uRLImageView);
        } catch (MalformedURLException unused) {
        }
    }

    private void F(Context context, AbsStructMsgElement absStructMsgElement, Bundle bundle, QQWalletTransferBubbleView qQWalletTransferBubbleView) {
        int parseColor;
        try {
            parseColor = Color.parseColor(((ao) absStructMsgElement).M());
        } catch (Exception unused) {
            parseColor = Color.parseColor(TipsElementData.DEFAULT_COLOR);
        }
        qQWalletTransferBubbleView.setBubbleBackground(R.drawable.qvip_pay_aio_transfer_bottom_bg, parseColor, true);
        Resources resources = context.getResources();
        View view = (TextView) absStructMsgElement.c(context, null, bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(BaseAIOUtils.f(19.0f, resources), 0, 0, 0);
        layoutParams.addRule(15);
        view.setLayoutParams(layoutParams);
        qQWalletTransferBubbleView.addView(view);
    }

    private void G(Context context, AbsStructMsgElement absStructMsgElement, Bundle bundle, ViewGroup viewGroup, boolean z16) {
        Resources resources = context.getResources();
        TextView textView = (TextView) absStructMsgElement.c(context, null, bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(BaseAIOUtils.f(19.0f, resources), BaseAIOUtils.f(4.5f, resources), 0, 0);
        layoutParams.addRule(3, R.id.j4k);
        if (z16) {
            layoutParams.addRule(0, R.id.j4j);
            layoutParams.addRule(9);
        }
        textView.setLayoutParams(layoutParams);
        textView.setSingleLine();
        viewGroup.addView(textView);
    }

    private void H(Context context, AbsStructMsgElement absStructMsgElement, Bundle bundle, ViewGroup viewGroup, boolean z16) {
        Resources resources = context.getResources();
        TextView textView = (TextView) absStructMsgElement.c(context, null, bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(BaseAIOUtils.f(19.0f, resources), BaseAIOUtils.f(11.0f, resources), 0, 0);
        if (z16) {
            layoutParams.addRule(0, R.id.j4j);
            layoutParams.addRule(9);
        }
        textView.setLayoutParams(layoutParams);
        textView.setSingleLine();
        textView.setId(R.id.j4k);
        viewGroup.addView(textView);
    }

    @Override // com.tencent.mobileqq.structmsg.a, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar)).booleanValue();
        }
        boolean d16 = super.d(jVar);
        if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout19", 2, "from xml");
        }
        this.X0 = jVar.a("bgColor");
        return d16;
    }

    @Override // com.tencent.mobileqq.structmsg.a, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectInput);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout19", 2, "read external");
        }
        super.i(objectInput);
        this.X0 = objectInput.readUTF();
    }

    @Override // com.tencent.mobileqq.structmsg.a, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) xmlSerializer);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout19", 2, "to xml");
        }
        if (!TextUtils.isEmpty(this.X0)) {
            xmlSerializer.attribute(null, "url", this.X0);
        }
        super.k(xmlSerializer);
    }

    @Override // com.tencent.mobileqq.structmsg.a, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectOutput);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout19", 2, "write external");
        }
        super.l(objectOutput);
        String str = this.X0;
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 19;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "Layout19";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        LinearLayout linearLayout;
        int parseColor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
            linearLayout.removeAllViews();
        } else {
            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, BaseAIOUtils.f(3.0f, resources), 0, 0);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setId(R.id.j4i);
        }
        QQWalletTransferBubbleView qQWalletTransferBubbleView = new QQWalletTransferBubbleView(context);
        qQWalletTransferBubbleView.setLayoutParams(new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(74.0f, resources)));
        try {
            parseColor = Color.parseColor(this.X0);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsgItemLayout19", 2, "parse item bg color failure, color = " + this.X0);
            }
            parseColor = Color.parseColor("#18b4ed");
        }
        qQWalletTransferBubbleView.setBubbleBackground(R.drawable.qvip_pay_aio_transfer_bg, parseColor, true);
        linearLayout.addView(qQWalletTransferBubbleView);
        QQWalletTransferBubbleView qQWalletTransferBubbleView2 = new QQWalletTransferBubbleView(context);
        qQWalletTransferBubbleView2.setLayoutParams(new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(25.0f, resources)));
        linearLayout.addView(qQWalletTransferBubbleView2);
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            AbsStructMsgElement next = it.next();
            if (next instanceof c) {
                E(context, next, bundle, qQWalletTransferBubbleView);
                z16 = true;
            }
        }
        int size = this.U0.size();
        for (int i3 = 0; i3 < size; i3++) {
            AbsStructMsgElement absStructMsgElement = this.U0.get(i3);
            if (absStructMsgElement instanceof StructMsgItemTitle) {
                H(context, absStructMsgElement, bundle, qQWalletTransferBubbleView, z16);
            } else if (absStructMsgElement instanceof ap) {
                G(context, absStructMsgElement, bundle, qQWalletTransferBubbleView, z16);
            } else if (absStructMsgElement instanceof ao) {
                F(context, absStructMsgElement, bundle, qQWalletTransferBubbleView2);
            }
        }
        return linearLayout;
    }
}
