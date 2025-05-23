package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.o;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ah extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    protected boolean X0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class a extends o.a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        public LinearLayout f290573f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f290574g;

        /* renamed from: h, reason: collision with root package name */
        public TextView f290575h;

        /* renamed from: i, reason: collision with root package name */
        public ImageView f290576i;

        /* renamed from: j, reason: collision with root package name */
        public TextView f290577j;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "layoutMicro";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    @TargetApi(16)
    public View y(Context context, View view, Bundle bundle) {
        a aVar;
        LinearLayout linearLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        this.X0 = bundle.getBoolean("pre_dialog", false);
        Resources resources = context.getResources();
        AbsShareMsg absShareMsg = (AbsShareMsg) this.P0;
        int f16 = BaseAIOUtils.f(10.0f, resources);
        if (view == null) {
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(1);
            aVar = new a();
            linearLayout2.setTag(R.id.f166666h55, aVar);
            ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -2;
            }
            linearLayout2.setLayoutParams(layoutParams);
            TextView textView = new TextView(context);
            textView.setSingleLine(true);
            textView.setCompoundDrawablePadding(f16);
            textView.setGravity(16);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(-16777216);
            textView.setTextSize(2, 16.0f);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView.setPadding(f16, f16, f16, f16);
            linearLayout2.addView(textView);
            TextView textView2 = new TextView(context);
            textView2.setTextColor(-16777216);
            textView2.setMaxLines(2);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextSize(2, 12.0f);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView2.setPadding(f16, 0, f16, f16);
            linearLayout2.addView(textView2);
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(BaseChatItemLayout.f178058p0, (int) (BaseChatItemLayout.N * 0.468d));
            layoutParams2.gravity = 1;
            imageView.setLayoutParams(layoutParams2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            linearLayout2.addView(imageView);
            TextView textView3 = new TextView(context);
            textView3.setTextColor(-7829368);
            textView3.setTextSize(2, 12.0f);
            textView3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView3.setCompoundDrawablePadding(BaseAIOUtils.f(5.0f, resources));
            Drawable drawable = resources.getDrawable(R.drawable.buj);
            drawable.setBounds(0, 0, BaseAIOUtils.f(18.0f, resources), BaseAIOUtils.f(10.0f, resources));
            textView3.setCompoundDrawables(drawable, null, null, null);
            textView3.setPadding(f16, f16, f16, f16);
            linearLayout2.addView(textView3);
            aVar.f290574g = textView;
            aVar.f290575h = textView2;
            aVar.f290576i = imageView;
            aVar.f290577j = textView3;
            aVar.f290573f = linearLayout2;
            linearLayout = linearLayout2;
        } else {
            LinearLayout linearLayout3 = (LinearLayout) view;
            aVar = (a) linearLayout3.getTag(R.id.f166666h55);
            linearLayout = linearLayout3;
        }
        if (this.X0) {
            linearLayout.setPadding(f16, f16, f16, f16);
        } else {
            linearLayout.setPadding(0, 0, 0, 0);
        }
        if (this.P0 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsgItemLayoutMicro", 2, "getView but parentMsg or message is null");
            }
            return linearLayout;
        }
        int f17 = BaseAIOUtils.f(24.0f, resources);
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = f17;
            obtain.mRequestHeight = f17;
            URLDrawable drawable2 = URLDrawable.getDrawable(absShareMsg.mContentCover, obtain);
            drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
            drawable2.setBounds(0, 0, f17, f17);
            aVar.f290574g.setCompoundDrawables(drawable2, null, null, null);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsgItemLayoutMicro", 2, "getTitleView fail e=" + th5.getMessage());
            }
        }
        aVar.f290574g.setText(absShareMsg.mContentTitle);
        aVar.f290575h.setText(absShareMsg.mContentSummary);
        aVar.f290577j.setText(HardCodeUtil.qqStr(R.string.twd));
        if (!TextUtils.isEmpty(absShareMsg.mMsg_I_ActionData)) {
            try {
                aVar.f290576i.setImageDrawable(URLDrawable.getDrawable(absShareMsg.mMsg_I_ActionData, (URLDrawable.URLDrawableOptions) null));
            } catch (IllegalArgumentException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsgItemLayoutMicro", 2, "getView fail");
                }
            }
        } else {
            aVar.f290576i.setImageDrawable(null);
        }
        return linearLayout;
    }
}
