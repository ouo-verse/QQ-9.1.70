package mw;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.fragment.invite.dav.NTVideoInviteBusinessController;
import com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment;

/* compiled from: P */
/* loaded from: classes38.dex */
public class n implements m {

    /* renamed from: a, reason: collision with root package name */
    NTVideoInviteBusinessController f417703a;

    public n(VideoInviteBaseFragment videoInviteBaseFragment) {
        this.f417703a = new NTVideoInviteBusinessController(videoInviteBaseFragment);
    }

    @Override // mw.m
    public int a() {
        return this.f417703a.c();
    }

    @Override // mw.m
    public String b() {
        return this.f417703a.h();
    }

    @Override // mw.m
    public boolean c() {
        return this.f417703a.f();
    }

    @Override // mw.m
    public void d() {
        this.f417703a.n();
    }

    @Override // mw.m
    public void e() {
        this.f417703a.a();
    }

    @Override // mw.m
    public boolean f() {
        return this.f417703a.e();
    }

    @Override // mw.m
    public void g(int i3) {
        this.f417703a.q(i3);
    }

    @Override // mw.m
    public int getOnlineStatus() {
        return this.f417703a.g();
    }

    @Override // mw.m
    public String getPeerUin() {
        return this.f417703a.i();
    }

    @Override // mw.m
    public SessionInfo getSessionInfo() {
        return this.f417703a.j();
    }

    @Override // mw.m
    public void h(long j3) {
        this.f417703a.m(j3);
    }

    @Override // mw.m
    public void i(long j3, String str) {
        this.f417703a.l(j3, str);
    }

    @Override // mw.m
    public void j(long j3, boolean z16) {
        this.f417703a.k(j3, z16);
    }

    @Override // mw.m
    public void k() {
        this.f417703a.b();
    }
}
