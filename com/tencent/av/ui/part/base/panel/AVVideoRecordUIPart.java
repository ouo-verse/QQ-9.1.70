package com.tencent.av.ui.part.base.panel;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.m;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.QLog;
import mw.k;

/* loaded from: classes32.dex */
public class AVVideoRecordUIPart extends e {

    /* renamed from: h, reason: collision with root package name */
    protected RecordInfo f76346h;

    public AVVideoRecordUIPart(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void C9(long j3) {
        RecordInfo recordInfo = this.f76346h;
        if (recordInfo != null) {
            recordInfo.k(j3, nw.b.b(), getActivity());
        }
    }

    public void D9(long j3) {
        mw.h hVar = (mw.h) RFWIocAbilityProvider.g().getIocInterface(mw.h.class, getPartRootView(), null);
        if (hVar != null && hVar.f1(j3, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, null, null)) {
            C9(j3);
            ((k) RFWIocAbilityProvider.g().getIocInterface(k.class, getPartRootView(), null)).updateBtn(j3, 33554431);
            A9(j3, m.e.f76019f);
            QLog.w("AVVideoRecordUIPart", 1, "onClick_Record, seq[" + j3 + "] has Permission");
            return;
        }
        QLog.w("AVVideoRecordUIPart", 1, "onClick_Record, seq[" + j3 + "] has not Permission");
    }

    public void E9() {
        RecordInfo recordInfo = this.f76346h;
        if (recordInfo != null) {
            recordInfo.l();
        }
    }

    public void F9(Context context, SessionInfo sessionInfo, Object obj, long j3) {
        rw.a M = ((QavPanel) obj).M(m.e.f76019f);
        if (M == null) {
            QLog.w("AVVideoRecordUIPart", 1, "updateBtn_Record, null, seq[" + j3 + "]");
            return;
        }
        int i3 = sessionInfo.f73035i;
        boolean z16 = false;
        if (i3 != 3 && i3 != 4 && i3 != 1) {
            boolean isEnableRecord = ((AVActivity) context).isEnableRecord();
            if (!isEnableRecord) {
                QLog.w("AVVideoRecordUIPart", 1, "updateBtn_Record, !isEnableRecord, seq[" + j3 + "]");
            } else if (!sessionInfo.N || !sessionInfo.O) {
                QLog.w("AVVideoRecordUIPart", 1, "updateBtn_Record, sessionInfo.localHasVideo, seq[" + sessionInfo.N + "][sessionInfo.remoteHasVideo=" + sessionInfo.O + "]");
            }
            z16 = isEnableRecord;
        } else {
            QLog.w("AVVideoRecordUIPart", 1, "updateBtn_Record, \u573a\u666f\u4e0d\u652f\u6301, seq[" + j3 + "]");
        }
        RecordInfo recordInfo = this.f76346h;
        if (recordInfo != null) {
            M.l(recordInfo.f76349c);
        }
        M.n(z16);
    }

    public void G9(Object obj) {
        QavPanel qavPanel = (QavPanel) obj;
        int i3 = m.l.G;
        qavPanel.setViewVisibility(i3, 8);
        RecordInfo recordInfo = this.f76346h;
        if (recordInfo == null) {
            return;
        }
        if (recordInfo.f76349c == R.drawable.dcu) {
            qavPanel.setImgBtnDrawable(i3, R.drawable.n6n);
        } else {
            qavPanel.setImgBtnDrawable(i3, this.f76346h.f76349c);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f76346h = new RecordInfo();
    }

    @Override // com.tencent.av.ui.part.base.panel.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f76346h = null;
    }

    /* loaded from: classes32.dex */
    public static class RecordInfo {

        /* renamed from: a, reason: collision with root package name */
        private int f76347a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f76348b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f76349c = R.drawable.dcu;

        /* renamed from: d, reason: collision with root package name */
        private VideoAppInterface f76350d = null;

        /* renamed from: e, reason: collision with root package name */
        private AVActivity f76351e = null;

        /* renamed from: f, reason: collision with root package name */
        Runnable f76352f = new Runnable() { // from class: com.tencent.av.ui.part.base.panel.AVVideoRecordUIPart.RecordInfo.1
            @Override // java.lang.Runnable
            public void run() {
                if (RecordInfo.this.f76351e == null || RecordInfo.this.f76350d == null || RecordInfo.this.f76351e.I0 == null || RecordInfo.this.f76351e.I0.p() == null || RecordInfo.this.f76347a != 1) {
                    return;
                }
                RecordInfo.this.f76348b++;
                int i3 = RecordInfo.this.f76348b;
                int i16 = R.drawable.dcv;
                if (i3 >= 3) {
                    RecordInfo.this.f76347a = 2;
                    RecordInfo.this.f76349c = R.drawable.dcv;
                    RecordInfo.this.f76351e.I0.i1(-1026L, 33554431);
                    RecordInfo.this.f76351e.I0.p().X0(-1026L, 0, false);
                    QavRecordButtonView qavRecordButtonView = (QavRecordButtonView) RecordInfo.this.f76351e.findViewById(R.id.i3q);
                    if (qavRecordButtonView != null) {
                        qavRecordButtonView.callOnClick();
                    }
                    RecordInfo.this.f76350d.k0(new Object[]{8001, "OnRecord"});
                    RecordInfo.this.f76348b = 0;
                    RecordInfo.this.f76347a = 0;
                    return;
                }
                RecordInfo recordInfo = RecordInfo.this;
                if (recordInfo.f76348b == 1) {
                    i16 = R.drawable.dcw;
                }
                recordInfo.f76349c = i16;
                RecordInfo.this.f76351e.I0.i1(-1025L, 33554431);
                RecordInfo.this.f76350d.M().postDelayed(RecordInfo.this.f76352f, 1000L);
            }
        };

        void i(long j3, AVActivity aVActivity) {
            QLog.w("RecordInfo", 1, "onClick_Record, start, seq[" + j3 + "]");
            this.f76347a = 1;
            this.f76349c = R.drawable.dcx;
            this.f76351e = aVActivity;
            this.f76350d.M().postDelayed(this.f76352f, 1000L);
        }

        void j(long j3) {
            QLog.w("RecordInfo", 1, "onClick_Record, cancel, seq[" + j3 + "]");
            l();
        }

        void l() {
            this.f76349c = R.drawable.dcu;
            this.f76347a = 0;
            this.f76348b = 0;
            this.f76350d = null;
            this.f76351e = null;
        }

        public void k(long j3, AppInterface appInterface, Activity activity) {
            if (appInterface != null && activity != null) {
                this.f76350d = (VideoAppInterface) appInterface;
                AVActivity aVActivity = (AVActivity) activity;
                int i3 = this.f76347a;
                if (i3 == 0) {
                    i(j3, aVActivity);
                    return;
                } else {
                    if (i3 == 1) {
                        j(j3);
                        return;
                    }
                    return;
                }
            }
            QLog.d("RecordInfo", 1, "onClick_Record error. app or act is null.");
        }
    }
}
