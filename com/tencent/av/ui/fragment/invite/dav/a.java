package com.tencent.av.ui.fragment.invite.dav;

import android.app.Activity;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private VideoInviteBaseFragment f75747a;

    private boolean b() {
        return this.f75747a instanceof NTVideoInviteLockFragment;
    }

    public VideoInviteBaseFragment a(boolean z16) {
        if (this.f75747a == null || z16 != b()) {
            this.f75747a = null;
            if (z16) {
                this.f75747a = new NTVideoInviteLockFragment();
            } else {
                this.f75747a = new NTVideoInviteFullFragment();
            }
        }
        return this.f75747a;
    }

    public void c(Activity activity) {
        VideoInviteBaseFragment videoInviteBaseFragment = this.f75747a;
        if (videoInviteBaseFragment != null) {
            videoInviteBaseFragment.Jh(true);
        }
    }
}
