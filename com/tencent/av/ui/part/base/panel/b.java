package com.tencent.av.ui.part.base.panel;

import android.app.Activity;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.m;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends e implements mw.d {
    public b(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void C9(long j3, View view) {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.X0(j3, 0, false);
        }
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity != null) {
            if (aVActivity.f74657h1.r()) {
                aVActivity.f74657h1.y(false);
                com.tencent.av.chatroom.c.e("0X800A8D0");
                return;
            } else if (aVActivity.f74657h1.p()) {
                aVActivity.f74657h1.o(3);
            } else {
                aVActivity.f74657h1.A(0);
            }
        }
        com.tencent.av.chatroom.c.e("0X800A8D0");
    }

    public void D9(long j3) {
        rw.a x95;
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity == null || aVActivity.isDestroyed() || (x95 = x9(m.e.f76020g, j3)) == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null && qavPanel.v0(6)) {
            VideoChatRoomUIContoller videoChatRoomUIContoller = aVActivity.f74657h1;
            if (videoChatRoomUIContoller != null && videoChatRoomUIContoller.r()) {
                x95.l(R.drawable.n7o);
            } else {
                x95.l(R.drawable.n7n);
            }
        }
        if (!f16.f73098x2 && !f16.f73102y2) {
            if (f16.f73035i == 2) {
                if (!f16.z()) {
                    x95.i(false);
                    x95.k(true);
                } else {
                    x95.i(true);
                    x95.k(false);
                    x95.n(true);
                }
            } else {
                x95.i(true);
                x95.k(false);
                x95.n(true);
            }
        } else {
            x95.i(false);
            x95.k(true);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f76368d, 4, "updateBtn_ChatRoom, visible[true]");
        }
    }

    @Override // mw.d
    public void o7(boolean z16) {
        VideoChatRoomUIContoller videoChatRoomUIContoller;
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity == null || (videoChatRoomUIContoller = aVActivity.f74657h1) == null) {
            return;
        }
        int i3 = z16 ? 2 : 0;
        videoChatRoomUIContoller.y(false);
        aVActivity.f74657h1.o(i3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        RFWIocAbilityProvider.g().registerIoc(view, this, mw.d.class);
    }

    @Override // com.tencent.av.ui.part.base.panel.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), mw.d.class);
    }
}
