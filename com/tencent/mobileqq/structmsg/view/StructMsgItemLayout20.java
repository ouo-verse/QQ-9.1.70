package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import com.tencent.widget.SingleLineTextView;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StructMsgItemLayout20 extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    String X0;
    boolean Y0;
    String Z0;

    /* renamed from: a1, reason: collision with root package name */
    String f290451a1;

    /* renamed from: b1, reason: collision with root package name */
    String f290452b1;

    /* renamed from: c1, reason: collision with root package name */
    boolean f290453c1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public SingleLineTextView f290456a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f290457b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f290458c;

        /* renamed from: d, reason: collision with root package name */
        public View f290459d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f290460e;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(Context context, View view, boolean z16) {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, view, Boolean.valueOf(z16));
                return;
            }
            if (context != null && view != null) {
                if (z16) {
                    i3 = R.color.cmg;
                } else {
                    i3 = R.color.cmf;
                }
                view.setBackgroundColor(ContextCompat.getColor(context, i3));
                if (z16) {
                    i16 = R.color.bi8;
                } else {
                    i16 = R.color.bi7;
                }
                this.f290460e.setTextColor(ContextCompat.getColor(context, i16));
                if (z16) {
                    i17 = R.drawable.l_5;
                } else {
                    i17 = R.drawable.l_4;
                }
                this.f290460e.setBackgroundResource(i17);
                if (z16) {
                    i18 = R.drawable.l_7;
                } else {
                    i18 = R.drawable.l_6;
                }
                this.f290458c.setBackgroundResource(i18);
                if (z16) {
                    i19 = R.color.bi_;
                } else {
                    i19 = R.color.bi9;
                }
                this.f290458c.setTextColor(ContextCompat.getColor(context, i19));
            }
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.f290460e.setVisibility(0);
            this.f290458c.setVisibility(8);
            this.f290459d.setVisibility(8);
            this.f290457b.setVisibility(8);
            this.f290456a.setVisibility(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class b extends IPublicAccountObserver.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        a f290461a;

        public b(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            } else {
                this.f290461a = aVar;
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            a aVar = this.f290461a;
            if (aVar != null) {
                aVar.f290459d.setVisibility(8);
                this.f290461a.f290458c.setVisibility(0);
                if (z16) {
                    this.f290461a.f290458c.setBackgroundDrawable(null);
                    this.f290461a.f290458c.setText(HardCodeUtil.qqStr(R.string.tw5));
                    this.f290461a.f290458c.setEnabled(false);
                }
            }
        }
    }

    public StructMsgItemLayout20() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    View E(View view, Context context, String str) {
        int i3;
        View view2;
        a aVar;
        try {
            i3 = Integer.parseInt(this.X0);
        } catch (Exception unused) {
            QLog.e("StructMsgItemLayout20", 1, "content type:" + this.X0);
            i3 = 0;
        }
        if (view == null) {
            aVar = new a();
            view2 = View.inflate(context, R.layout.bbs, null);
            aVar.f290456a = (SingleLineTextView) view2.findViewById(R.id.f5e);
            aVar.f290457b = (ImageView) view2.findViewById(R.id.icon);
            aVar.f290458c = (TextView) view2.findViewById(R.id.cgs);
            aVar.f290459d = view2.findViewById(R.id.loading);
            aVar.f290460e = (TextView) view2.findViewById(R.id.t6s);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        aVar.f290456a.setText(str);
        if (i3 == 1) {
            aVar.f290457b.setVisibility(8);
            aVar.f290456a.setTextColor(Color.parseColor("#777777"));
            aVar.f290456a.setTextSize(14.0f);
            aVar.f290456a.setCompoundDrawables(null, null);
            aVar.f290458c.setText(this.f290451a1);
            aVar.f290458c.setEnabled(true);
            aVar.f290458c.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.f160508in));
            view2.setTag(R.id.h2x, this.f290327h);
            aVar.f290458c.setTag(R.id.h2x, this.f290327h);
            aVar.f290460e.setTag(R.id.h2x, this.f290327h);
        } else if (i3 == 0) {
            aVar.f290457b.setVisibility(0);
            Drawable drawable = context.getResources().getDrawable(R.drawable.f160830com);
            if (!TextUtils.isEmpty(this.Z0)) {
                int f16 = BaseAIOUtils.f(40.0f, context.getResources());
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                URLDrawable drawable2 = URLDrawable.getDrawable(this.Z0, obtain);
                if (drawable2.getStatus() == 2) {
                    drawable2.restartDownload();
                }
                drawable2.setTag(com.tencent.mobileqq.urldrawable.a.c(f16, f16, f16 / 2));
                drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306324d);
                aVar.f290457b.setImageDrawable(drawable2);
            } else {
                aVar.f290457b.setImageDrawable(drawable);
            }
            if (this.Y0) {
                Drawable drawable3 = context.getResources().getDrawable(R.drawable.br7);
                aVar.f290456a.setCompoundDrawablePadding(BaseAIOUtils.f(3.0f, context.getResources()));
                drawable3.setBounds(0, 0, BaseAIOUtils.f(15.0f, context.getResources()), BaseAIOUtils.f(15.0f, context.getResources()));
                aVar.f290456a.setCompoundDrawables(null, drawable3);
            } else {
                aVar.f290456a.setCompoundDrawables(null, null);
            }
            aVar.f290456a.setTextColor(Color.parseColor("#000000"));
            aVar.f290456a.setTextSize(17.0f);
            aVar.f290458c.setTag(aVar);
            if (((IPublicAccountDataManager) ((BaseActivity) context).app.getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(Long.parseLong(this.f290452b1)))) {
                aVar.f290458c.setBackgroundDrawable(null);
                aVar.f290458c.setText(HardCodeUtil.qqStr(R.string.tvv));
                aVar.f290458c.setEnabled(false);
            } else {
                aVar.f290458c.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.f160508in));
                aVar.f290458c.setText(HardCodeUtil.qqStr(R.string.f171699ka2));
                aVar.f290458c.setEnabled(true);
            }
            view2.setTag(R.id.h2z, this.f290452b1);
            aVar.f290458c.setTag(R.id.h2z, this.f290452b1);
            aVar.f290460e.setTag(R.id.h2z, this.f290452b1);
        }
        int f17 = BaseAIOUtils.f(17.0f, context.getResources());
        int f18 = BaseAIOUtils.f(16.0f, context.getResources());
        aVar.f290458c.setPadding(f18, 0, f18, 0);
        aVar.f290458c.post(new Runnable(f17, aVar) { // from class: com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f290454d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f290455e;

            {
                this.f290454d = f17;
                this.f290455e = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, StructMsgItemLayout20.this, Integer.valueOf(f17), aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int width = this.f290454d + this.f290455e.f290458c.getWidth();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f290455e.f290456a.getLayoutParams();
                layoutParams.rightMargin = width;
                this.f290455e.f290456a.setLayoutParams(layoutParams);
            }
        });
        view2.setOnClickListener(this);
        aVar.f290458c.setOnClickListener(this);
        aVar.f290460e.setOnClickListener(this);
        if (this.f290453c1) {
            aVar.b();
        } else {
            aVar.f290460e.setVisibility(8);
        }
        aVar.a(context, view2, u());
        return view2;
    }

    void F() {
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(this.F);
            this.X0 = jSONObject.optString("contentType");
            if (jSONObject.optInt("isCert") == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.Y0 = z16;
            this.Z0 = jSONObject.optString("faceUrl");
            this.f290451a1 = jSONObject.optString(TuxUIConstants.POP_BTN_TEXT);
            this.f290452b1 = jSONObject.optString(IPublicAccountBrowser.KEY_PUB_UIN);
            this.f290453c1 = jSONObject.optBoolean("isBigJumpBtn", false);
        } catch (Exception e16) {
            QLog.e("StructMsgItemLayout20", 1, "Exception:" + e16);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) jVar)).booleanValue();
        }
        super.d(jVar);
        F();
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.a, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectInput);
        } else {
            super.i(objectInput);
            F();
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement, android.view.View.OnClickListener
    public void onClick(View view) {
        QQAppInterface qQAppInterface;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int parseInt = Integer.parseInt(this.X0);
            Context context = view.getContext();
            if (context instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) context;
                ChatFragment chatFragment = baseActivity.getChatFragment();
                if (chatFragment != null) {
                    qQAppInterface = chatFragment.ph();
                } else {
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    if (runtime instanceof QQAppInterface) {
                        qQAppInterface = (QQAppInterface) runtime;
                    } else {
                        qQAppInterface = null;
                    }
                }
                QQAppInterface qQAppInterface2 = qQAppInterface;
                if (qQAppInterface2 != null) {
                    EcshopReportHandler ecshopReportHandler = (EcshopReportHandler) qQAppInterface2.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
                    if (parseInt == 1) {
                        if (!"1".equals(this.H0)) {
                            String str = (String) view.getTag(R.id.h2x);
                            if (!TextUtils.isEmpty(str)) {
                                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                                intent.putExtra("url", str);
                                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                                intent.putExtra("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(this.M0));
                                context.startActivity(intent);
                            }
                        }
                    } else if (parseInt == 0) {
                        String str2 = (String) view.getTag(R.id.h2z);
                        if (view.getId() == R.id.as9) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("source", 115);
                            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfile(intent2, qQAppInterface2, baseActivity, str2, -5);
                            try {
                                AbsStructMsg absStructMsg = this.P0;
                                ecshopReportHandler.H2(134247086, absStructMsg.uin, absStructMsg.message.getExtInfoFromExtStr(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID), null, null, Long.parseLong(str2), false);
                            } catch (Exception unused) {
                            }
                        } else if (view.getId() == R.id.cgs) {
                            a aVar = (a) view.getTag();
                            aVar.f290458c.setVisibility(4);
                            aVar.f290459d.setVisibility(0);
                            IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
                            iPublicAccountObserver.setOnCallback(new b(aVar));
                            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(qQAppInterface2, baseActivity, str2, iPublicAccountObserver, true, 3);
                        }
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
        return 20;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "Layout20";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        LinearLayout linearLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
            if (linearLayout.getChildCount() == this.U0.size()) {
                Iterator<AbsStructMsgElement> it = this.U0.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AbsStructMsgElement next = it.next();
                    next.O0 = this.O0;
                    if ("content".equals(next.f290322e)) {
                        E(linearLayout.getChildAt(i3), context, ((com.tencent.mobileqq.structmsg.view.b) next).X0);
                        break;
                    }
                    i3++;
                }
                return linearLayout;
            }
        }
        linearLayout = new LinearLayout(context);
        Iterator<AbsStructMsgElement> it5 = this.U0.iterator();
        while (it5.hasNext()) {
            AbsStructMsgElement next2 = it5.next();
            next2.O0 = this.O0;
            if ("content".equals(next2.f290322e) && (next2 instanceof com.tencent.mobileqq.structmsg.view.b)) {
                linearLayout.addView(E(null, context, ((com.tencent.mobileqq.structmsg.view.b) next2).X0), new LinearLayout.LayoutParams(-1, -2));
            }
        }
        return linearLayout;
    }
}
