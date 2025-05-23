package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ai extends u {
    static IPatchRedirector $redirector_;
    String Y0;
    String Z0;

    /* renamed from: a1, reason: collision with root package name */
    String f290578a1;

    /* renamed from: b1, reason: collision with root package name */
    String f290579b1;

    /* renamed from: c1, reason: collision with root package name */
    private URLDrawableDownListener.Adapter f290580c1;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends URLDrawableDownListener.Adapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ai.this);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            super.onLoadCancelled(view, uRLDrawable);
            if (QLog.isColorLevel()) {
                QLog.d(ai.this.Y0, 2, "onLoadCancelled");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
                return;
            }
            super.onLoadFailed(view, uRLDrawable, th5);
            if (QLog.isColorLevel()) {
                QLog.d(ai.this.Y0, 2, "onLoadFailed ,cause = " + th5);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, uRLDrawable, interruptedException);
                return;
            }
            super.onLoadInterrupted(view, uRLDrawable, interruptedException);
            if (QLog.isColorLevel()) {
                QLog.d(ai.this.Y0, 2, "onLoadInterrupted");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            if (view == null) {
                return;
            }
            view.setBackgroundDrawable(null);
            if (view instanceof ImageView) {
                URLImageView uRLImageView = (URLImageView) view;
                uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                uRLImageView.setImageDrawable(uRLDrawable);
                view.requestLayout();
            }
            if (QLog.isColorLevel()) {
                QLog.d(ai.this.Y0, 2, "onLoadSuccessed");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        URLImageView f290582a;

        /* renamed from: b, reason: collision with root package name */
        LinearLayout f290583b;

        /* renamed from: c, reason: collision with root package name */
        TextView f290584c;

        /* renamed from: d, reason: collision with root package name */
        SingleLineTextView f290585d;

        /* renamed from: e, reason: collision with root package name */
        RelativeLayout f290586e;

        /* renamed from: f, reason: collision with root package name */
        RelativeLayout f290587f;

        /* renamed from: g, reason: collision with root package name */
        LinearLayout f290588g;

        /* renamed from: h, reason: collision with root package name */
        TextView f290589h;

        /* renamed from: i, reason: collision with root package name */
        RelativeLayout f290590i;

        /* renamed from: j, reason: collision with root package name */
        ImageView f290591j;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ai.this);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (!ai.this.u()) {
                    return;
                }
                this.f290584c.setTextColor(-1);
                LinearLayout linearLayout = this.f290583b;
                linearLayout.setBackground(ContextCompat.getDrawable(linearLayout.getContext(), R.drawable.k7l));
            }
        }
    }

    public ai() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.Y0 = "StructMsgItemLayoutNew2";
        this.Z0 = "";
        this.f290578a1 = "";
        this.f290579b1 = "";
        this.f290580c1 = new a();
    }

    private String K(String str, int i3) {
        StringBuilder sb5 = new StringBuilder();
        int length = str.length();
        String str2 = "";
        int i16 = 0;
        int i17 = 0;
        while (i16 < length && i17 < i3) {
            int codePointAt = str.codePointAt(i16);
            if (codePointAt <= 65535 && codePointAt != 20) {
                str2 = str.substring(i16, i16 + 1);
                if (i17 < i3 - 1) {
                    sb5.append(str2);
                }
                i17++;
            } else {
                int i18 = i16 + 1;
                if (i18 < length) {
                    str2 = str.substring(i16, i16 + 2);
                    if (i17 < i3 - 1) {
                        sb5.append(str2);
                    }
                    i17++;
                    i16 = i18;
                }
            }
            i16++;
        }
        if (i17 == i3) {
            if (i16 < length) {
                sb5.append((CharSequence) Html.fromHtml("&hellip;"));
            } else {
                sb5.append(str2);
            }
        }
        return sb5.toString();
    }

    public static String L(AbsShareMsg absShareMsg, String str) {
        StructMsgForGeneralShare structMsgForGeneralShare;
        List<AbsStructMsgElement> list;
        com.tencent.mobileqq.structmsg.a aVar;
        ArrayList<AbsStructMsgElement> arrayList;
        if (str.equals("cover")) {
            if (!TextUtils.isEmpty(absShareMsg.mContentCover)) {
                return absShareMsg.mContentCover;
            }
        } else if (str.equals("title")) {
            if (!TextUtils.isEmpty(absShareMsg.mContentTitle)) {
                return absShareMsg.mContentTitle;
            }
        } else if (str.equals("summary") && !TextUtils.isEmpty(absShareMsg.mContentSummary)) {
            return absShareMsg.mContentSummary;
        }
        String str2 = "";
        if ((absShareMsg instanceof StructMsgForGeneralShare) && (list = (structMsgForGeneralShare = (StructMsgForGeneralShare) absShareMsg).mStructMsgItemLists) != null && !list.isEmpty()) {
            for (AbsStructMsgElement absStructMsgElement : structMsgForGeneralShare.mStructMsgItemLists) {
                if ((absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a) && (arrayList = (aVar = (com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0) != null && !arrayList.isEmpty()) {
                    Iterator<AbsStructMsgElement> it = aVar.U0.iterator();
                    while (it.hasNext()) {
                        AbsStructMsgElement next = it.next();
                        if (str.equals("cover") && (next instanceof c)) {
                            str2 = StructMsgForGeneralShare.getCoverForChatHistory(next);
                        } else if (str.equals("title") && (next instanceof StructMsgItemTitle)) {
                            str2 = StructMsgForGeneralShare.getTitleForChatHistory(next);
                        } else if (str.equals("summary") && (next instanceof ap)) {
                            str2 = StructMsgForGeneralShare.getSummary(next);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        break;
                    }
                }
            }
        }
        return str2;
    }

    void M() {
        MessageRecord messageRecord;
        AbsStructMsg absStructMsg = this.P0;
        if (absStructMsg != null && (messageRecord = absStructMsg.message) != null && (messageRecord instanceof MessageForStructing)) {
            AbsShareMsg absShareMsg = (AbsShareMsg) com.tencent.mobileqq.structmsg.i.d(messageRecord.msgData);
            this.f290578a1 = L(absShareMsg, "title");
            this.Z0 = L(absShareMsg, "cover");
            this.f290579b1 = L(absShareMsg, "summary");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.structmsg.a
    public boolean u() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean u16 = super.u();
        if (this.P0.mMsgServiceID == 83) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (u16 && z16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.structmsg.view.u, com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        int i3;
        float f16;
        boolean z16;
        View view2 = view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, view, bundle);
        }
        b bVar = new b();
        Resources resources = context.getResources();
        if (view2 != null && (view2 instanceof RelativeLayout) && view2.findViewById(R.id.alg) != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        } else {
            view2 = LayoutInflater.from(context).inflate(R.layout.f168426vt, (ViewGroup) null);
            bVar.f290582a = (URLImageView) view2.findViewById(R.id.bat);
            bVar.f290583b = (LinearLayout) view2.findViewById(R.id.b9t);
            bVar.f290584c = (TextView) view2.findViewById(R.id.title);
            bVar.f290585d = (SingleLineTextView) view2.findViewById(R.id.j8_);
            bVar.f290586e = (RelativeLayout) view2.findViewById(R.id.alg);
            bVar.f290587f = (RelativeLayout) view2.findViewById(R.id.f164079jf);
            bVar.f290588g = (LinearLayout) view2.findViewById(R.id.b3r);
            bVar.f290589h = (TextView) view2.findViewById(R.id.f164078je);
            bVar.f290590i = (RelativeLayout) view2.findViewById(R.id.amr);
            bVar.f290591j = (ImageView) view2.findViewById(R.id.amj);
            view2.setTag(bVar);
        }
        b bVar2 = bVar;
        View view3 = view2;
        M();
        boolean z17 = bundle.getBoolean("isSend", true);
        BubbleViewLayout bubbleViewLayout = (BubbleViewLayout) view3.findViewById(R.id.alg);
        int i16 = this.P0.mMsgServiceID;
        if (i16 != 114 && i16 != 116) {
            bubbleViewLayout.e(!QQTheme.isNowSimpleUI());
            i3 = 19;
        } else {
            bubbleViewLayout.e(false);
            i3 = 9;
        }
        if (QQTheme.isNowSimpleUI()) {
            f16 = 8.0f;
        } else {
            f16 = 15.0f;
        }
        bubbleViewLayout.setRadius(f16);
        bubbleViewLayout.f315477i = z17;
        AbsStructMsg absStructMsg = this.P0;
        int i17 = absStructMsg.mMsgServiceID;
        if (i17 != 151 && i17 != 156 && !TextUtils.isEmpty(absStructMsg.mMsgActionData)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z17) {
            float f17 = i3;
            bVar2.f290584c.setPadding(BaseAIOUtils.f(9.0f, resources), 0, BaseAIOUtils.f(f17, resources), 0);
            bVar2.f290585d.setPadding(BaseAIOUtils.f(9.0f, resources), BaseAIOUtils.f(3.0f, resources), BaseAIOUtils.f(f17, resources), 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) bVar2.f290586e.getLayoutParams();
            if (z16) {
                marginLayoutParams.setMargins(BaseAIOUtils.f(18.0f, resources), 0, 0, 0);
                ((RelativeLayout.LayoutParams) bVar2.f290590i.getLayoutParams()).addRule(9);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar2.f290588g.getLayoutParams();
                layoutParams.addRule(9);
                layoutParams.setMargins(BaseAIOUtils.f(18.0f, resources), 0, 0, 0);
                bVar2.f290588g.setPadding(BaseAIOUtils.f(19.5f, resources), 0, BaseAIOUtils.f(10.0f, resources), 0);
            } else {
                marginLayoutParams.setMargins(0, 0, 0, 0);
            }
        } else {
            float f18 = i3;
            bVar2.f290584c.setPadding(BaseAIOUtils.f(f18, resources), 0, BaseAIOUtils.f(9.0f, resources), 0);
            bVar2.f290585d.setPadding(BaseAIOUtils.f(f18, resources), BaseAIOUtils.f(3.0f, resources), BaseAIOUtils.f(9.0f, resources), 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) bVar2.f290586e.getLayoutParams();
            if (z16) {
                marginLayoutParams2.setMargins(0, 0, BaseAIOUtils.f(18.0f, resources), 0);
                ((RelativeLayout.LayoutParams) bVar2.f290590i.getLayoutParams()).addRule(11);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar2.f290588g.getLayoutParams();
                layoutParams2.addRule(11);
                layoutParams2.setMargins(0, 0, BaseAIOUtils.f(18.0f, resources), 0);
                bVar2.f290588g.setPadding(BaseAIOUtils.f(10.0f, resources), 0, BaseAIOUtils.f(19.5f, resources), 0);
            } else {
                marginLayoutParams2.setMargins(0, 0, 0, 0);
            }
        }
        Drawable drawable = resources.getDrawable(R.drawable.h2r);
        if (!TextUtils.isEmpty(this.Z0)) {
            try {
                URLDrawable drawable2 = URLDrawable.getDrawable(new URL(this.Z0), BaseAIOUtils.f(249.0f, resources), BaseAIOUtils.f(139.0f, resources), drawable, drawable, true);
                bVar2.f290582a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                if (drawable2 != null && drawable2.getStatus() == 2) {
                    drawable2.restartDownload();
                }
                if (drawable2 != null && drawable2.getStatus() == 1) {
                    bVar2.f290582a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    bVar2.f290582a.setBackgroundDrawable(null);
                } else {
                    bVar2.f290582a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    bVar2.f290582a.setURLDrawableDownListener(this.f290580c1);
                }
                bVar2.f290582a.setImageDrawable(drawable2);
            } catch (MalformedURLException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(this.Y0, 2, "getView, error: " + e16.getMessage());
                }
                bVar2.f290582a.setImageDrawable(drawable);
                bVar2.f290582a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
        } else {
            bVar2.f290582a.setImageDrawable(drawable);
            bVar2.f290582a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI)) {
            String str = this.f290578a1 + "  ";
            this.f290578a1 = str;
            bVar2.f290584c.setText(Html.fromHtml(str));
        } else {
            bVar2.f290584c.setText(this.f290578a1);
        }
        String str2 = this.f290579b1;
        if (str2 != null && !TextUtils.isEmpty(str2.trim()) && !this.f290579b1.trim().equals("")) {
            bVar2.f290585d.setVisibility(0);
            bVar2.f290585d.setText(this.f290579b1);
        } else {
            bVar2.f290585d.setVisibility(8);
        }
        bVar2.a();
        if (z16) {
            int f19 = ((((int) (BaseChatItemLayout.f178058p0 * 0.8f)) - BaseAIOUtils.f(19.5f, resources)) - BaseAIOUtils.f(10.0f, resources)) - BaseAIOUtils.f(13.0f, resources);
            bVar2.f290589h.setMaxWidth(f19);
            int f26 = f19 / BaseAIOUtils.f(14.0f, resources);
            String str3 = this.P0.mMsgActionData;
            if (str3.length() > f26) {
                str3 = K(str3, f26);
            }
            bVar2.f290589h.setText(new QQTextBuilder(str3, 3, 15));
            bVar2.f290587f.setVisibility(0);
        } else {
            bVar2.f290587f.setVisibility(8);
            bVar2.f290590i.setOnClickListener(null);
            bVar2.f290588g.setOnClickListener(null);
        }
        return view3;
    }
}
