package com.tencent.av.ui.part.mav;

import android.app.Activity;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cw.e;
import nw.b;

/* loaded from: classes32.dex */
public class AVInviteUserNoticePart extends Part {

    /* renamed from: d, reason: collision with root package name */
    InviteUserNoticeRunnable f76541d = new InviteUserNoticeRunnable();

    /* loaded from: classes32.dex */
    class InviteUserNoticeRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        int f76542d = 0;

        /* renamed from: e, reason: collision with root package name */
        String f76543e = null;

        InviteUserNoticeRunnable() {
        }

        public void a(int i3, String str) {
            this.f76542d = i3;
            this.f76543e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AVActivity aVActivity = (AVActivity) AVInviteUserNoticePart.this.getActivity();
            if (aVActivity != null) {
                aVActivity.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.part.mav.AVInviteUserNoticePart.InviteUserNoticeRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String format;
                        if (InviteUserNoticeRunnable.this.f76542d == 1) {
                            format = String.format(BaseApplication.getContext().getString(R.string.daz), InviteUserNoticeRunnable.this.f76543e);
                        } else {
                            format = String.format(BaseApplication.getContext().getString(R.string.f171222db0), InviteUserNoticeRunnable.this.f76543e, InviteUserNoticeRunnable.this.f76542d + "");
                        }
                        e.p(b.b(), 3012, format);
                    }
                });
            } else if (QLog.isColorLevel()) {
                QLog.e("AVInviteUserNoticePart", 2, "onInviteUserNotice-->Can not get AVActivity");
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.f76541d != null) {
            getMainHandler().removeCallbacks(this.f76541d);
            this.f76541d = null;
        }
    }

    public void x9(int i3, String str) {
        VideoAppInterface b16 = b.b();
        if (QLog.isColorLevel()) {
            QLog.d("AVInviteUserNoticePart", 2, "onInviteUserNotice --> Count = " + i3 + " ,firstName = " + str);
        }
        if (b16 != null) {
            SessionInfo f16 = n.e().f();
            if (QAVHrMeeting.k(b16.F(String.valueOf(f16.P0)))) {
                str = r.h0().U(b16.getCurrentAccountUin(), String.valueOf(f16.P0), f16.S0);
            }
            this.f76541d.a(i3, str);
            getMainHandler().postDelayed(this.f76541d, 500L);
        }
    }
}
