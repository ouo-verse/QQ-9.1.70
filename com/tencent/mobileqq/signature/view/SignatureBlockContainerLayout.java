package com.tencent.mobileqq.signature.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.signature.SignTextEditFragment;
import com.tencent.mobileqq.signature.topic.c;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SignatureBlockContainerLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private TextView C;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f288477d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.mobileqq.signature.topic.a f288478e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.signature.topic.b f288479f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f288480h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f288481i;

    /* renamed from: m, reason: collision with root package name */
    public XListView f288482m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f288483d;

        a(Context context) {
            this.f288483d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureBlockContainerLayout.this, (Object) context);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                c.i(this.f288483d, "https://ti.qq.com/signature/searchtopic?_wv=3&&_wwv=128", 17);
                com.tencent.mobileqq.signature.report.a.c().r(102);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SignatureBlockContainerLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 == 1) {
            this.f288482m.setVisibility(8);
            this.C.setVisibility(0);
        } else if (i3 == 0) {
            this.C.setVisibility(8);
            this.f288482m.setVisibility(0);
        } else if (i3 == 2) {
            this.f288482m.setVisibility(8);
            this.C.setVisibility(0);
        }
    }

    public void b(int i3, SignTextEditFragment signTextEditFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) signTextEditFragment);
            return;
        }
        if (i3 == ShopHalfScreenFloatingView.f288467x0 && signTextEditFragment != null) {
            if (this.f288479f == null) {
                com.tencent.mobileqq.signature.topic.b bVar = new com.tencent.mobileqq.signature.topic.b(this);
                this.f288479f = bVar;
                signTextEditFragment.f288349o0.addRequestRecommendTopicObserver(bVar);
            }
            if (this.f288478e == null) {
                this.f288478e = new com.tencent.mobileqq.signature.topic.a(signTextEditFragment.getContext(), this.f288482m, signTextEditFragment);
            }
            this.f288482m.setAdapter((ListAdapter) this.f288478e);
            this.f288482m.setVisibility(0);
            signTextEditFragment.f288349o0.requestRecommendTopicList();
        }
    }

    public SignatureBlockContainerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SignatureBlockContainerLayout(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    @SuppressLint({"WrongViewCast"})
    public SignatureBlockContainerLayout(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.hgc, (ViewGroup) null);
        this.f288477d = relativeLayout;
        addView(relativeLayout);
        this.f288480h = (TextView) findViewById(R.id.uqo);
        this.f288481i = (TextView) findViewById(R.id.f95685fn);
        this.f288482m = (XListView) findViewById(R.id.sde);
        this.C = (TextView) findViewById(R.id.f95315en);
        this.f288480h.setOnClickListener(new a(context));
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(this.f288481i, false);
            AccessibilityUtil.p(this.f288480h, this.f288481i.getText());
        }
    }
}
