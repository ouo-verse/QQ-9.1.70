package com.tencent.icgame.game.liveroom.impl.room.livewebdialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.icgame.game.liveroom.impl.room.util.PopWindowType;
import com.tencent.icgame.game.liveroom.impl.room.util.n;
import com.tencent.icgame.game.liveroom.impl.room.util.o;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.icgame.webview.LiveWebDialogEvent;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f115430a = false;

    /* renamed from: b, reason: collision with root package name */
    private static Queue<PopupParam> f115431b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private static LiveWebPreloader f115432c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements PopupWindow.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f115433d;

        a(boolean z16, com.tencent.icgame.game.liveroom.impl.room.livewebdialog.a aVar) {
            this.f115433d = z16;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (this.f115433d) {
                f.f115430a = false;
            }
            f.e();
        }
    }

    static /* bridge */ /* synthetic */ PopupParam e() {
        return o();
    }

    public static void f() {
        LiveWebPreloader liveWebPreloader = f115432c;
        if (liveWebPreloader != null) {
            liveWebPreloader.d();
        }
        f115430a = false;
        f115431b.clear();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.livewebdialog.e
            @Override // java.lang.Runnable
            public final void run() {
                f.h();
            }
        });
    }

    public static LiveWebView g(Activity activity, String str, boolean z16) {
        return LiveWebViewContainer.g(activity, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h() {
        SimpleEventBus.getInstance().dispatchEvent(new LiveWebDialogEvent("hide", "", 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(boolean z16, com.tencent.icgame.game.liveroom.impl.room.livewebdialog.a aVar, DialogInterface dialogInterface) {
        if (z16) {
            f115430a = false;
        }
        if (aVar != null) {
            aVar.onDismiss();
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit j(String str, PopupWindow popupWindow) {
        if (popupWindow instanceof g) {
            ((g) popupWindow).b(str);
            return null;
        }
        return null;
    }

    public static void k(Activity activity, String str) {
        if (f115432c == null) {
            f115432c = new LiveWebPreloader();
        }
        f115432c.g(activity, str);
    }

    public static void l(Activity activity, int i3, Drawable drawable, String str) {
        m(false, activity, i3, true, drawable, false, "", str, null, false, null);
    }

    public static void m(final boolean z16, Activity activity, int i3, boolean z17, Drawable drawable, boolean z18, String str, final String str2, TouchWebView touchWebView, boolean z19, final com.tencent.icgame.game.liveroom.impl.room.livewebdialog.a aVar) {
        TouchWebView touchWebView2;
        if (activity == null) {
            rt0.a.c("ICGameUnknown|ICGameLive_web_dialog", "showDialog", "hostActivity is null");
            return;
        }
        if (TextUtils.isEmpty(str2) && touchWebView == null) {
            rt0.a.c("ICGameUnknown|ICGameLive_web_dialog", "showDialog", "url is null");
            return;
        }
        if (touchWebView == null) {
            touchWebView2 = g(activity, str2, z18);
        } else {
            touchWebView2 = touchWebView;
        }
        if (f115430a && z16) {
            f115431b.add(new PopupParam(activity, i3, Boolean.valueOf(z17), drawable, Boolean.valueOf(z18), str, str2, touchWebView2, Boolean.valueOf(z19), aVar));
            rt0.a.c("ICGameUnknown|ICGameLive_web_dialog", "showDialog", "is popuping, add to queue");
            return;
        }
        LiveWebViewContainer liveWebViewContainer = new LiveWebViewContainer(activity);
        liveWebViewContainer.setBackgroundColor(0);
        liveWebViewContainer.f(touchWebView2);
        liveWebViewContainer.e(str2);
        if (z18) {
            liveWebViewContainer.setWebBackground(null);
        } else if (drawable != null) {
            liveWebViewContainer.setConnerSize(4);
            touchWebView2.setBackgroundColor(0);
            liveWebViewContainer.setWebBackground(drawable);
        }
        o oVar = new o();
        oVar.t(false);
        oVar.x(PopWindowType.WEB);
        oVar.u(i3);
        oVar.y(z17);
        oVar.q(R.style.b0e);
        if (z19) {
            LiveWebDialog liveWebDialog = new LiveWebDialog(activity);
            liveWebDialog.uh(liveWebViewContainer, null);
            liveWebDialog.th(oVar);
            liveWebDialog.setTitle(str);
            liveWebDialog.vh(new DialogInterface.OnDismissListener(z16, aVar) { // from class: com.tencent.icgame.game.liveroom.impl.room.livewebdialog.c

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ boolean f115428d;

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    f.i(this.f115428d, null, dialogInterface);
                }
            });
            if (activity instanceof AppActivity) {
                if (z16) {
                    f115430a = true;
                }
                liveWebDialog.show(((AppActivity) activity).getSupportFragmentManager(), "webview_dialog");
                return;
            }
            rt0.a.c("ICGameUnknown|ICGameLive_web_dialog", "showDialog", "hostActivity is not AppActivity!");
            return;
        }
        if (z16) {
            f115430a = true;
        }
        n.f(activity, liveWebViewContainer, oVar, new Function1() { // from class: com.tencent.icgame.game.liveroom.impl.room.livewebdialog.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j3;
                j3 = f.j(str2, (PopupWindow) obj);
                return j3;
            }
        }).setOnDismissListener(new a(z16, aVar));
    }

    public static void n(boolean z16, Activity activity, boolean z17, Drawable drawable, TouchWebView touchWebView, PopupWindow.OnDismissListener onDismissListener) {
        m(z16, activity, -1, z17, drawable, true, "", "", touchWebView, false, null);
    }

    private static PopupParam o() {
        if (!f115431b.isEmpty()) {
            PopupParam poll = f115431b.poll();
            Activity activity = poll.getActivity();
            int height = poll.getHeight();
            boolean booleanValue = poll.getShowAnim().booleanValue();
            Drawable background = poll.getBackground();
            boolean booleanValue2 = poll.getTransparentWebViewBg().booleanValue();
            String title = poll.getTitle();
            String url = poll.getUrl();
            TouchWebView webView = poll.getWebView();
            boolean booleanValue3 = poll.getIsUserDialog().booleanValue();
            poll.d();
            m(true, activity, height, booleanValue, background, booleanValue2, title, url, webView, booleanValue3, null);
            return poll;
        }
        return null;
    }
}
