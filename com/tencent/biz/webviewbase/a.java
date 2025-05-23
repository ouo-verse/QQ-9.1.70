package com.tencent.biz.webviewbase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: p, reason: collision with root package name */
    static volatile boolean f97274p = false;

    /* renamed from: q, reason: collision with root package name */
    static volatile boolean f97275q = false;

    /* renamed from: f, reason: collision with root package name */
    View f97281f;

    /* renamed from: k, reason: collision with root package name */
    Context f97286k;

    /* renamed from: l, reason: collision with root package name */
    ImageView f97287l;

    /* renamed from: m, reason: collision with root package name */
    ImageView f97288m;

    /* renamed from: a, reason: collision with root package name */
    boolean f97276a = false;

    /* renamed from: b, reason: collision with root package name */
    int f97277b = R.drawable.h8d;

    /* renamed from: c, reason: collision with root package name */
    int f97278c = -1;

    /* renamed from: d, reason: collision with root package name */
    String f97279d = "";

    /* renamed from: e, reason: collision with root package name */
    int f97280e = 360000;

    /* renamed from: g, reason: collision with root package name */
    String f97282g = "";

    /* renamed from: h, reason: collision with root package name */
    int f97283h = 0;

    /* renamed from: i, reason: collision with root package name */
    String f97284i = "";

    /* renamed from: j, reason: collision with root package name */
    String f97285j = "";

    /* renamed from: n, reason: collision with root package name */
    BroadcastReceiver f97289n = new b();

    /* renamed from: o, reason: collision with root package name */
    t f97290o = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.webviewbase.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class ViewOnClickListenerC0990a implements View.OnClickListener {
        ViewOnClickListenerC0990a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.f97274p = true;
            a.this.h(false);
            a.this.e(view.getContext());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (QQAppInterface.BROADCAST_NEW_MESSAGE_NOFITY.equals(intent.getAction())) {
                a.f97274p = false;
                a.f97275q = true;
                a.this.h(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c extends t {
        c() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
            if (QLog.isColorLevel()) {
                QLog.d("AIOBanner", 2, "-->onBindedToClient");
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
            if (QLog.isColorLevel()) {
                QLog.d("AIOBanner", 2, "-->onDisconnectWithService");
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOBanner", 2, "-->onPushMsg");
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOBanner", 2, "-->onResponse");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private a f97294a;

        public d(View view) {
            a aVar = new a();
            this.f97294a = aVar;
            if (view != null) {
                aVar.f97281f = view;
                aVar.f97286k = view.getContext();
            }
        }

        public a a() {
            this.f97294a.d();
            return this.f97294a;
        }

        public d b(Bundle bundle) {
            int i3 = bundle.getInt("switch_aio_btn_res");
            a aVar = this.f97294a;
            if (i3 == 0) {
                i3 = R.drawable.h8d;
            }
            aVar.f97277b = i3;
            int i16 = bundle.getInt("banner_icon_res");
            a aVar2 = this.f97294a;
            if (i16 == 0) {
                i16 = -1;
            }
            aVar2.f97278c = i16;
            int i17 = bundle.getInt("banner_timeout");
            a aVar3 = this.f97294a;
            if (i17 == 0) {
                i17 = 360000;
            }
            aVar3.f97280e = i17;
            String string = bundle.getString("banner_txt");
            a aVar4 = this.f97294a;
            String str = "";
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            aVar4.f97279d = string;
            String string2 = bundle.getString("action");
            a aVar5 = this.f97294a;
            if (TextUtils.isEmpty(string2)) {
                string2 = "";
            }
            aVar5.f97284i = string2;
            String string3 = bundle.getString("category");
            a aVar6 = this.f97294a;
            if (TextUtils.isEmpty(string3)) {
                string3 = "";
            }
            aVar6.f97285j = string3;
            String string4 = bundle.getString("target_activity_name");
            a aVar7 = this.f97294a;
            if (!TextUtils.isEmpty(string4)) {
                str = string4;
            }
            aVar7.f97282g = str;
            this.f97294a.f97283h = bundle.getInt("start_flags");
            this.f97294a.f97276a = bundle.getBoolean("enable_switch");
            return this;
        }
    }

    a() {
    }

    void a() {
        if (this.f97286k != null && this.f97276a) {
            View view = this.f97281f;
            if (view instanceof RelativeLayout) {
                ImageView imageView = new ImageView(this.f97286k);
                this.f97287l = imageView;
                imageView.setImageDrawable(this.f97286k.getResources().getDrawable(R.drawable.skin_tips_dot));
                ImageView imageView2 = new ImageView(this.f97286k);
                this.f97288m = imageView2;
                imageView2.setImageDrawable(this.f97286k.getResources().getDrawable(this.f97277b));
                this.f97288m.setOnClickListener(new ViewOnClickListenerC0990a());
                RelativeLayout relativeLayout = new RelativeLayout(this.f97286k);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13, -1);
                relativeLayout.addView(this.f97288m, layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(x.c(this.f97286k, 8.0f), x.c(this.f97286k, 8.0f));
                layoutParams2.addRule(10, -1);
                layoutParams2.addRule(11, -1);
                layoutParams2.setMargins(0, x.c(this.f97286k, 4.0f), x.c(this.f97286k, 4.0f), 0);
                relativeLayout.addView(this.f97287l, layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(x.c(this.f97286k, 36.0f), x.c(this.f97286k, 36.0f));
                layoutParams3.addRule(0, R.id.f166811ie3);
                layoutParams3.addRule(15, -1);
                layoutParams3.setMargins(0, 0, x.c(this.f97286k, 4.0f), 0);
                ((RelativeLayout) view).addView(relativeLayout, layoutParams3);
                this.f97287l.setVisibility(8);
            }
        }
    }

    void b() {
        try {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.f97290o);
            if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(this.f97286k.getApplicationContext());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOBanner", 2, "bind messenger service error:" + e16.toString());
            }
        }
    }

    public void c(int i3, Object... objArr) {
        switch (i3) {
            case Conversation.MSG_BROWSER_BAR_SHOW /* 1134041 */:
            case Conversation.MSG_BROWSER_BAR_HIDE /* 1134042 */:
                Bundle a16 = com.tencent.mobileqq.emosm.a.a("ipc_jump_to_conversation", "", this.f97290o.key, null);
                a16.putInt("banner_msg", i3);
                a16.putCharSequence("banner_tips", this.f97279d);
                a16.putInt("banner_icon", this.f97278c);
                a16.putInt("banner_timeout", this.f97280e);
                a16.putCharSequence(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, this.f97282g);
                a16.putInt(WadlProxyConsts.FLAGS, this.f97283h);
                a16.putCharSequence("action", this.f97284i);
                a16.putCharSequence("category", this.f97285j);
                g(a16);
                return;
            default:
                switch (i3) {
                    case 1135042:
                        h(((Boolean) objArr[0]).booleanValue());
                        return;
                    case 1135043:
                    case 1135044:
                    case 1135045:
                        i(i3, objArr);
                        return;
                    default:
                        return;
                }
        }
    }

    void d() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f97276a) {
            b();
            f();
            a();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOBanner", 2, "init for switch aio cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    void e(Context context) {
        c(Conversation.MSG_BROWSER_BAR_SHOW, new Object[0]);
        Intent intent = new Intent();
        intent.setComponent(SplashActivity.getAliasComponent(context));
        intent.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
        intent.setFlags(335544320);
        intent.putExtra("tab_index", 0);
        context.startActivity(intent);
    }

    void f() {
        this.f97286k.registerReceiver(this.f97289n, new IntentFilter(QQAppInterface.BROADCAST_NEW_MESSAGE_NOFITY));
    }

    void g(Bundle bundle) {
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOBanner", 2, "messenger service is not connected!");
                return;
            }
            return;
        }
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(bundle);
    }

    void h(boolean z16) {
        int i3;
        ImageView imageView = this.f97287l;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    void i(int i3, Object... objArr) {
        switch (i3) {
            case 1135043:
                if (f97274p) {
                    h(false);
                    return;
                } else {
                    if (f97275q && !f97274p) {
                        h(true);
                        return;
                    }
                    return;
                }
            case 1135044:
                if (objArr.length >= 1) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        this.f97279d = str;
                        return;
                    }
                    return;
                }
                return;
            case 1135045:
                if (objArr.length < 1) {
                    return;
                }
                this.f97278c = ((Integer) objArr[0]).intValue();
                return;
            default:
                return;
        }
    }
}
