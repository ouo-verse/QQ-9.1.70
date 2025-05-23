package com.tencent.mobileqq.aio.reserve1.toptip;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqui.widget.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NetStateTipsBar extends com.tencent.qqnt.aio.toptips.a implements INetEventHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.qqnt.aio.toptips.c f193398d;

    /* renamed from: e, reason: collision with root package name */
    private final View.OnClickListener f193399e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f193400f;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetStateTipsBar.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Context context = NetStateTipsBar.this.f193398d.a().c().getContext();
                if (VersionUtils.isHoneycomb()) {
                    context.startActivity(new Intent("android.settings.SETTINGS"));
                } else {
                    context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public NetStateTipsBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f193399e = new a();
            this.f193400f = new Runnable() { // from class: com.tencent.mobileqq.aio.reserve1.toptip.NetStateTipsBar.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NetStateTipsBar.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!AppNetConnInfo.isNetSupport() && NetStateTipsBar.this.f193398d != null && NetStateTipsBar.this.f193398d.b() != NetStateTipsBar.this.getType()) {
                        NetStateTipsBar.this.f193398d.e(NetStateTipsBar.this);
                    }
                }
            };
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public View a(Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) objArr);
        }
        Context context = this.f193398d.a().c().getContext();
        if (context == null) {
            return null;
        }
        TipsBar tipsBar = new TipsBar(context);
        tipsBar.setBarType(4);
        tipsBar.setTipsText(context.getString(R.string.f207785ay));
        tipsBar.setTipsIcon(context.getResources().getDrawable(R.drawable.common_banner_tips_warning));
        tipsBar.setOnClickListener(this.f193399e);
        return tipsBar;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new int[0];
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(com.tencent.qqnt.aio.toptips.c cVar, int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, cVar, Integer.valueOf(i3), objArr);
            return;
        }
        if (i3 != 1004) {
            if (i3 == 1005) {
                this.f193398d = cVar;
                onNetChangeEvent(AppNetConnInfo.isNetSupport());
                AppNetConnInfo.registerNetChangeReceiver(this.f193398d.a().c().getContext(), this);
                return;
            }
            return;
        }
        AppNetConnInfo.unregisterNetEventHandler(this);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f193400f);
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 32;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
    public void onNetChangeEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else if (z16) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f193400f);
            this.f193398d.h(this);
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.f193400f, 6000L);
        }
    }
}
