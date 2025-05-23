package com.tencent.mobileqq.matchfriend.voicechat;

import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qav.channel.d;
import com.tencent.qav.controller.multi.MultiOperatorImpl;
import com.tencent.qav.controller.multi.c;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends MultiOperatorImpl {
    public a(Context context, long j3, d dVar) {
        super(context, j3, dVar);
    }

    public void O() {
        QQGAudioCtrl qQGAudioCtrl;
        com.tencent.qav.log.a.a("MatchFriendMultiOperatorImpl", "startAudioRecv mHasCallExitRoom\uff1a=" + this.f342376m);
        if (this.f342376m || (qQGAudioCtrl = this.f342381c) == null) {
            return;
        }
        qQGAudioCtrl.startAudioRecv();
    }

    public void P() {
        QQGAudioCtrl qQGAudioCtrl;
        com.tencent.qav.log.a.a("MatchFriendMultiOperatorImpl", "stopAudioRecv mHasCallExitRoom\uff1a=" + this.f342376m);
        if (this.f342376m || (qQGAudioCtrl = this.f342381c) == null) {
            return;
        }
        qQGAudioCtrl.stopAudioRecv();
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl
    protected void s(int i3, boolean z16) {
        com.tencent.qav.log.a.a("MatchFriendMultiOperatorImpl", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s], isCalling[%s]", Integer.valueOf(i3), Boolean.valueOf(this.f342375l), Boolean.valueOf(z16)));
        if (i3 == 2) {
            com.tencent.qav.observer.b.f().d(c.class, 16, Boolean.valueOf(z16));
        } else if (i3 == 1) {
            com.tencent.qav.observer.b.f().d(c.class, 17, Boolean.valueOf(z16));
        }
    }
}
