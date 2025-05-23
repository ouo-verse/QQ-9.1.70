package com.tencent.timi.game.liveroom.impl.room.livewebdialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.webview.LiveWebDialogEvent;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.util.PopWindowType;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f377892a = false;

    /* renamed from: b, reason: collision with root package name */
    private static Queue<PopupParam> f377893b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private static LiveWebPreloader f377894c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements PopupWindow.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f377895d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.liveroom.impl.room.livewebdialog.a f377896e;

        a(boolean z16, com.tencent.timi.game.liveroom.impl.room.livewebdialog.a aVar) {
            this.f377895d = z16;
            this.f377896e = aVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (this.f377895d) {
                e.f377892a = false;
            }
            com.tencent.timi.game.liveroom.impl.room.livewebdialog.a aVar = this.f377896e;
            if (aVar != null) {
                aVar.onDismiss();
            }
            e.d();
        }
    }

    static /* bridge */ /* synthetic */ PopupParam d() {
        return o();
    }

    public static void e() {
        LiveWebPreloader liveWebPreloader = f377894c;
        if (liveWebPreloader != null) {
            liveWebPreloader.e();
        }
        f377892a = false;
        if (!f377893b.isEmpty()) {
            for (PopupParam popupParam : f377893b) {
                if (popupParam != null && popupParam.getWebView() != null && popupParam.getInnerWebView()) {
                    popupParam.getWebView().destroy();
                }
            }
        }
        f377893b.clear();
        SimpleEventBus.getInstance().dispatchEvent(new LiveWebDialogEvent("hide", "", 0));
    }

    public static LiveWebView f(Activity activity, String str, boolean z16) {
        return LiveWebViewContainer.g(activity, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(boolean z16, com.tencent.timi.game.liveroom.impl.room.livewebdialog.a aVar, DialogInterface dialogInterface) {
        if (z16) {
            f377892a = false;
        }
        if (aVar != null) {
            aVar.onDismiss();
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit h(String str, PopupWindow popupWindow) {
        if (popupWindow instanceof f) {
            ((f) popupWindow).b(str);
            return null;
        }
        return null;
    }

    public static void i(Activity activity, String str) {
        if (f377894c == null) {
            f377894c = new LiveWebPreloader();
        }
        f377894c.j(activity, str);
    }

    public static TouchWebView j(final boolean z16, Activity activity, int i3, boolean z17, Drawable drawable, boolean z18, String str, final String str2, TouchWebView touchWebView, boolean z19, final com.tencent.timi.game.liveroom.impl.room.livewebdialog.a aVar) {
        TouchWebView touchWebView2;
        boolean z26;
        if (activity == null) {
            AegisLogger.e("unknown|live_web_dialog", "showDialog", "hostActivity is null");
            return touchWebView;
        }
        if (TextUtils.isEmpty(str2) && touchWebView == null) {
            AegisLogger.e("unknown|live_web_dialog", "showDialog", "url is null");
            return touchWebView;
        }
        if (touchWebView == null) {
            z26 = true;
            touchWebView2 = f(activity, str2, z18);
        } else {
            touchWebView2 = touchWebView;
            z26 = false;
        }
        if (f377892a && z16) {
            TouchWebView touchWebView3 = touchWebView2;
            f377893b.add(new PopupParam(activity, i3, Boolean.valueOf(z17), drawable, Boolean.valueOf(z18), str, str2, touchWebView2, Boolean.valueOf(z19), aVar, z26));
            AegisLogger.e("unknown|live_web_dialog", "showDialog", "is popuping, add to queue");
            return touchWebView3;
        }
        TouchWebView touchWebView4 = touchWebView2;
        LiveWebViewContainer liveWebViewContainer = new LiveWebViewContainer(activity);
        liveWebViewContainer.setBackgroundColor(0);
        liveWebViewContainer.f(touchWebView4);
        liveWebViewContainer.e(str2);
        if (z18) {
            liveWebViewContainer.setWebBackground(null);
        } else if (drawable != null) {
            liveWebViewContainer.setConnerSize(4);
            touchWebView4.setBackgroundColor(0);
            liveWebViewContainer.setWebBackground(drawable);
        }
        com.tencent.timi.game.liveroom.impl.room.util.h hVar = new com.tencent.timi.game.liveroom.impl.room.util.h();
        hVar.t(false);
        hVar.w(PopWindowType.WEB);
        hVar.u(i3);
        hVar.x(z17);
        hVar.q(R.style.b0e);
        if (z19) {
            LiveWebDialog liveWebDialog = new LiveWebDialog(activity);
            liveWebDialog.uh(liveWebViewContainer, null);
            liveWebDialog.th(hVar);
            liveWebDialog.setTitle(str);
            liveWebDialog.vh(new DialogInterface.OnDismissListener() { // from class: com.tencent.timi.game.liveroom.impl.room.livewebdialog.c
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    e.g(z16, aVar, dialogInterface);
                }
            });
            if (activity instanceof AppActivity) {
                if (z16) {
                    f377892a = true;
                }
                liveWebDialog.show(((AppActivity) activity).getSupportFragmentManager(), "webview_dialog");
            } else {
                AegisLogger.e("unknown|live_web_dialog", "showDialog", "hostActivity is not AppActivity!");
            }
        } else {
            if (z16) {
                f377892a = true;
            }
            com.tencent.timi.game.liveroom.impl.room.util.g.f(activity, liveWebViewContainer, hVar, new Function1() { // from class: com.tencent.timi.game.liveroom.impl.room.livewebdialog.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit h16;
                    h16 = e.h(str2, (PopupWindow) obj);
                    return h16;
                }
            }).setOnDismissListener(new a(z16, aVar));
        }
        return touchWebView4;
    }

    public static void k(Activity activity, int i3, Drawable drawable, String str) {
        j(false, activity, i3, true, drawable, false, "", str, null, false, null);
    }

    public static void l(Activity activity, int i3, Drawable drawable, String str, com.tencent.timi.game.liveroom.impl.room.livewebdialog.a aVar) {
        j(false, activity, i3, true, drawable, true, "", str, null, false, aVar);
    }

    public static void m(Activity activity, int i3, boolean z16, Drawable drawable, TouchWebView touchWebView, com.tencent.timi.game.liveroom.impl.room.livewebdialog.a aVar) {
        j(false, activity, i3, z16, drawable, true, "", "", touchWebView, false, aVar);
    }

    public static void n(boolean z16, Activity activity, boolean z17, Drawable drawable, TouchWebView touchWebView, PopupWindow.OnDismissListener onDismissListener) {
        j(z16, activity, -1, z17, drawable, true, "", "", touchWebView, false, null);
    }

    private static PopupParam o() {
        if (!f377893b.isEmpty()) {
            PopupParam poll = f377893b.poll();
            j(true, poll.getActivity(), poll.getHeight(), poll.getShowAnim().booleanValue(), poll.getBackground(), poll.getTransparentWebViewBg().booleanValue(), poll.getTitle(), poll.getUrl(), poll.getWebView(), poll.getIsUserDialog().booleanValue(), poll.getListener());
            return poll;
        }
        return null;
    }
}
