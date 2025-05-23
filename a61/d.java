package a61;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.aio.data.AIOSession;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.activity.aio.helper.t;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends b {

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f25596b;

    /* renamed from: c, reason: collision with root package name */
    private Context f25597c;

    /* renamed from: d, reason: collision with root package name */
    private View f25598d;

    /* renamed from: e, reason: collision with root package name */
    private l61.d f25599e;

    /* renamed from: f, reason: collision with root package name */
    private MqqHandler f25600f = new MqqHandler(Looper.getMainLooper());

    public d(com.tencent.aio.api.runtime.a aVar, l61.d dVar) {
        this.f25596b = aVar;
        this.f25599e = dVar;
        this.f25597c = aVar.c().requireContext();
        this.f25598d = this.f25596b.c().requireView();
        this.f25575a = new p();
        AIOSession r16 = this.f25596b.g().r();
        this.f25575a.f179563i = r16.c().g();
        this.f25575a.f179557e = Long.toString(this.f25596b.g().l().getLong("key_peerUin", 0L));
        this.f25575a.f179555d = su3.c.c(this.f25596b.g());
    }

    @Override // a61.b
    public int a() {
        return e();
    }

    @Override // a61.b
    public <T extends t> T b(int i3) {
        return null;
    }

    @Override // a61.b
    public l61.d c() {
        return this.f25599e;
    }

    @Override // a61.b
    public int e() {
        return ((m.d) this.f25596b.e().k(AIOTitleEvent.GetTitleHeightEvent.f188488d)).a();
    }

    @Override // a61.b
    public void f() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f25597c.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            View rootView = this.f25599e.a().getRootView();
            inputMethodManager.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
            if (QLog.isColorLevel()) {
                QLog.d("NTAIOContext", 2, "hideSoftInput, ", rootView.getWindowToken());
            }
        }
    }

    public View h() {
        return this.f25598d;
    }

    @Override // a61.b
    public void g(int i3) {
    }
}
