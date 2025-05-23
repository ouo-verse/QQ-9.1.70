package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bt2.a;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class s extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    static HashMap<Integer, ColorDrawable> Z0;

    /* renamed from: a1, reason: collision with root package name */
    static ColorDrawable f290665a1;
    AnimationDrawable X0;
    public int Y0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements a.InterfaceC0150a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f290666a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f290667b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f290668c;

        a(String str, String str2, b bVar) {
            this.f290666a = str;
            this.f290667b = str2;
            this.f290668c = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, s.this, str, str2, bVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        BubbleImageView f290670a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f290671b;

        /* renamed from: c, reason: collision with root package name */
        TextView f290672c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f290673d;

        /* renamed from: e, reason: collision with root package name */
        TextView f290674e;

        /* renamed from: f, reason: collision with root package name */
        String f290675f;

        /* renamed from: g, reason: collision with root package name */
        String f290676g;

        /* renamed from: h, reason: collision with root package name */
        String f290677h;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            Z0 = new HashMap<>();
            f290665a1 = new ColorDrawable(Color.parseColor("#8C6CF5"));
        }
    }

    public s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.Y0 = -1;
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag(this.Y0);
            if (tag instanceof b) {
                b bVar = (b) tag;
                if (TextUtils.isEmpty(bVar.f290675f)) {
                    QLog.e("Q.robot.StructMsg", 2, "onClick failed , resid empty!");
                } else {
                    String str = bVar.f290675f;
                    String str2 = bVar.f290677h;
                    bt2.a a16 = bt2.a.a();
                    if (a16.b(bVar.f290675f)) {
                        bt2.a.a().g(str2, bVar.f290675f, bVar.f290676g);
                    } else {
                        a16.f(bVar.f290675f, new a(str2, str, bVar));
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 28;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "layout28";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        String str = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.ak5, (ViewGroup) null);
            bVar = new b();
            BubbleImageView bubbleImageView = (BubbleImageView) view.findViewById(R.id.a87);
            bVar.f290670a = bubbleImageView;
            bubbleImageView.setRadius(13.0f);
            bVar.f290671b = (ImageView) view.findViewById(R.id.j17);
            bVar.f290672c = (TextView) view.findViewById(R.id.f166895iz1);
            bVar.f290674e = (TextView) view.findViewById(R.id.jp6);
            bVar.f290673d = (ImageView) view.findViewById(R.id.f166894iz0);
            view.setTag(this.Y0, bVar);
            view.setOnClickListener(this);
        } else {
            bVar = (b) view.getTag(this.Y0);
        }
        ColorDrawable colorDrawable = Z0.get(Integer.valueOf(this.S0));
        if (colorDrawable == null && this.S0 != 0) {
            colorDrawable = new ColorDrawable(this.S0);
            Z0.put(Integer.valueOf(this.S0), colorDrawable);
        }
        if (colorDrawable == null) {
            colorDrawable = f290665a1;
        }
        bVar.f290670a.setImageDrawable(colorDrawable);
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        String str2 = null;
        while (it.hasNext()) {
            AbsStructMsgElement next = it.next();
            String str3 = next.f290322e;
            if ("title".equals(str3)) {
                bVar.f290674e.setText(((StructMsgItemTitle) next).X0);
            } else if ("picture".equals(str3)) {
                String str4 = ((c) next).S0;
                try {
                    if (!TextUtils.isEmpty(str4)) {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mRequestWidth = (int) com.tencent.mobileqq.utils.al.a(context, 62.5f);
                        obtain.mRequestHeight = (int) com.tencent.mobileqq.utils.al.a(context, 115.0f);
                        bVar.f290671b.setImageDrawable(URLDrawable.getDrawable(str4, obtain));
                        bVar.f290671b.setVisibility(0);
                    }
                } catch (Exception e16) {
                    QLog.e("Q.robot.StructMsg", 1, e16, new Object[0]);
                    bVar.f290671b.setVisibility(4);
                }
            }
            if (TextUtils.isEmpty(str)) {
                StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) next.P0;
                String str5 = structMsgForGeneralShare.animResId;
                String str6 = structMsgForGeneralShare.atMembers;
                bVar.f290677h = String.valueOf(structMsgForGeneralShare.uniseq);
                str = str5;
                str2 = str6;
            }
        }
        bVar.f290675f = str;
        bVar.f290676g = str2;
        if (bt2.a.a().d(bVar.f290677h)) {
            if (this.X0 == null) {
                this.X0 = (AnimationDrawable) context.getResources().getDrawable(R.drawable.e66);
            }
            bVar.f290673d.setImageDrawable(this.X0);
            if (!this.X0.isRunning()) {
                this.X0.start();
            }
        } else {
            bVar.f290673d.setImageResource(R.drawable.e65);
        }
        return view;
    }
}
