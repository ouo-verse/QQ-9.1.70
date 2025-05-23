package com.tencent.timi.game.liveroom.impl.room.livewebdialog;

import android.view.View;
import android.widget.PopupWindow;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qqlive.webview.LiveWebDialogEvent;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f extends PopupWindow implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private LiveWebViewContainer f377897d;

    /* renamed from: e, reason: collision with root package name */
    private String f377898e;

    public f(View view, int i3, int i16) {
        this(view, i3, i16, false);
    }

    private boolean a(LiveWebDialogEvent liveWebDialogEvent) {
        if (liveWebDialogEvent.getHashKey() == 0) {
            return true;
        }
        LiveWebViewContainer liveWebViewContainer = this.f377897d;
        if (liveWebViewContainer != null && liveWebViewContainer.getWebView() != null && this.f377897d.getWebView().hashCode() == liveWebDialogEvent.getHashKey()) {
            return true;
        }
        return false;
    }

    public void b(String str) {
        this.f377898e = str;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().dispatchEvent(new LiveWebDialogEvent("hide_status", this.f377898e, this.f377897d.getWebView().hashCode()));
        lj4.a.c(hashCode(), false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(LiveWebDialogEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof LiveWebDialogEvent) {
            LiveWebDialogEvent liveWebDialogEvent = (LiveWebDialogEvent) simpleBaseEvent;
            if (liveWebDialogEvent.getCmd().compareTo("hide") == 0 && a(liveWebDialogEvent)) {
                dismiss();
            } else if (liveWebDialogEvent.getCmd().compareTo(UIJsPlugin.EVENT_HIDE_LOADING) == 0 && a(liveWebDialogEvent)) {
                this.f377897d.i();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        super.showAtLocation(view, i3, i16, i17);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        SimpleEventBus.getInstance().dispatchEvent(new LiveWebDialogEvent("show_status", this.f377898e, this.f377897d.getWebView().hashCode()));
        lj4.a.c(hashCode(), true);
    }

    public f(View view, int i3, int i16, boolean z16) {
        super(view, i3, i16, z16);
        this.f377898e = "";
        if (view instanceof LiveWebViewContainer) {
            this.f377897d = (LiveWebViewContainer) view;
        }
    }
}
