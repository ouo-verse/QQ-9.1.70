package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class t extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        View f290679a;

        /* renamed from: b, reason: collision with root package name */
        TextView f290680b;

        /* renamed from: c, reason: collision with root package name */
        TextView f290681c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f290682d;

        /* renamed from: e, reason: collision with root package name */
        boolean f290683e;

        /* renamed from: f, reason: collision with root package name */
        int f290684f;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void E(Context context, RelativeLayout relativeLayout, Resources resources, a aVar) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.skin_tips_dot_small);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.leftMargin = BaseAIOUtils.f(239.0f, resources);
        layoutParams.topMargin = BaseAIOUtils.f(10.0f, resources);
        aVar.f290682d = imageView;
        imageView.setVisibility(4);
        relativeLayout.addView(imageView, layoutParams);
    }

    private void F(Context context, RelativeLayout relativeLayout, Resources resources, a aVar) {
        TextView textView = new TextView(context);
        textView.setId(R.id.i0o);
        textView.setTextColor(Color.parseColor("#777777"));
        textView.setTextSize(1, 14.0f);
        textView.setGravity(16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BaseAIOUtils.f(25.0f, resources));
        layoutParams.topMargin = BaseAIOUtils.f(83.0f, resources);
        layoutParams.leftMargin = BaseAIOUtils.f(30.0f, resources);
        aVar.f290681c = textView;
        relativeLayout.addView(textView, layoutParams);
    }

    private void G(Context context, RelativeLayout relativeLayout, Resources resources, a aVar) {
        TextView textView = new TextView(context);
        textView.setId(R.id.i0p);
        textView.setText(R.string.f7y);
        textView.setTextSize(1, 22.0f);
        textView.setTextColor(-1);
        textView.setGravity(16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BaseAIOUtils.f(75.0f, resources));
        layoutParams.leftMargin = BaseAIOUtils.f(60.0f, resources);
        layoutParams.topMargin = BaseAIOUtils.f(8.0f, resources);
        aVar.f290680b = textView;
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 29;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "layout29";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        RelativeLayout relativeLayout;
        a aVar;
        boolean z16;
        Object obj;
        MessageRecord messageRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        ReceiptMsgManager n3 = ReceiptMsgManager.n();
        Resources resources = context.getResources();
        if (view == null) {
            relativeLayout = new RelativeLayout(context);
            aVar = new a();
            relativeLayout.setTag(-1, aVar);
            relativeLayout.setId(R.id.i0n);
            aVar.f290679a = relativeLayout;
            G(context, relativeLayout, resources, aVar);
            F(context, relativeLayout, resources, aVar);
            E(context, relativeLayout, resources, aVar);
            z16 = true;
        } else {
            relativeLayout = (RelativeLayout) view;
            aVar = (a) relativeLayout.getTag(-1);
            z16 = false;
        }
        AbsStructMsg absStructMsg = this.P0;
        if (absStructMsg != null && (messageRecord = absStructMsg.message) != null) {
            boolean isSend = messageRecord.isSend();
            Iterator<AbsStructMsgElement> it = this.U0.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                AbsStructMsgElement next = it.next();
                if ("type".equals(next.f290322e) && (next instanceof au)) {
                    i3 = ((au) next).R0;
                }
            }
            if (isSend != aVar.f290683e || i3 != aVar.f290684f || z16) {
                relativeLayout.setBackgroundDrawable(new BitmapDrawable(resources, n3.m(resources, isSend, i3)));
                aVar.f290683e = isSend;
                aVar.f290684f = i3;
            }
            if (isSend) {
                aVar.f290681c.setText(R.string.f7x);
                aVar.f290682d.setVisibility(4);
            } else if ("1".equals(ReceiptMsgManager.r(this.P0.message))) {
                aVar.f290681c.setText(R.string.f7v);
                aVar.f290682d.setVisibility(4);
            } else {
                aVar.f290681c.setText(R.string.f7w);
                aVar.f290682d.setVisibility(0);
            }
            if (!isSend && MobileQQ.sProcessId == 1) {
                ReceiptMsgManager.n().g((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), this.P0.message);
            }
            return relativeLayout;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout29", 2, "getView but parentMsg or message is null");
        }
        if (QLog.isDebugVersion()) {
            Object[] objArr = new Object[2];
            AbsStructMsg absStructMsg2 = this.P0;
            objArr[0] = absStructMsg2;
            if (absStructMsg2 == null) {
                obj = "-";
            } else {
                obj = absStructMsg2.message;
            }
            objArr[1] = obj;
            throw new IllegalStateException(String.format("getView but parentMsg or message is null, %s / %s", objArr));
        }
        return relativeLayout;
    }
}
