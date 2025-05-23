package com.tencent.mobileqq.qqlive.anchor.live;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a implements View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static a f270629f;

    /* renamed from: d, reason: collision with root package name */
    private QQLiveAnchorRoomInfo f270630d;

    /* renamed from: e, reason: collision with root package name */
    private final IAegisLogApi f270631e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f270629f = null;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270630d = new QQLiveAnchorRoomInfo();
            this.f270631e = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    public static a a() {
        if (f270629f == null) {
            synchronized (a.class) {
                if (f270629f == null) {
                    f270629f = new a();
                }
            }
        }
        return f270629f;
    }

    public QQLiveAnchorRoomInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQLiveAnchorRoomInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f270630d;
    }

    public void c(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorRoomInfo);
            return;
        }
        this.f270631e.i("AnchorLiveHelper", 1, "setRoomInfo roomInfo:" + qQLiveAnchorRoomInfo);
        this.f270630d = qQLiveAnchorRoomInfo;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        BeautyProcessor.n().J(motionEvent, view.getWidth(), view.getHeight());
        return false;
    }
}
