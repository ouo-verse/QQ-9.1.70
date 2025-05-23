package com.tencent.av.ui.part.mav;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.zplan.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dx.GAudioZPlanStatus;
import java.util.ArrayList;
import nw.b;

/* loaded from: classes32.dex */
public class AVSmallHomeTipsPart extends com.tencent.av.ui.part.base.AVSmallHomeTipsPart {
    private void D9() {
        if (getContext() != null) {
            getContext().sendBroadcast(new Intent("tencent.video.v2q.ACTION_DISSMISS_SMALL_HOME_GUIDE"));
        }
    }

    @Override // com.tencent.av.ui.part.base.AVSmallHomeTipsPart
    public void B9(long j3, View view) {
        String currentUin = b.b().getCurrentUin();
        GAudioZPlanStatus b16 = e.b(r.h0().Y());
        if (b16 == null) {
            QLog.i("AVSmallHomeTipsPart", 2, "onClick_SmallHomeEntryTips targetGAudioStatus is null");
            return;
        }
        QLog.i("AVSmallHomeTipsPart", 2, "onClick_SmallHomeEntryTips currentUin " + currentUin + " targetUin " + b16.getTargetUin());
        n.e().f().M2 = b16.getTargetUin();
        n.e().f().N2 = b16.getTimeStamp();
        super.B9(j3, view);
    }

    @Override // com.tencent.av.ui.part.base.AVSmallHomeTipsPart
    public void C9() {
        ArrayList<com.tencent.av.e> Y = r.h0().Y();
        if (this.f76230e != null) {
            final VideoAppInterface b16 = b.b();
            if (VideoUtil.f(b16)) {
                if (e.c(Y)) {
                    if (this.f76231f != null) {
                        final GAudioZPlanStatus b17 = e.b(Y);
                        final SessionInfo f16 = n.e().f();
                        if (b17 != null && !TextUtils.isEmpty(b17.getTargetUin()) && !f16.I2) {
                            if (this.f76230e.getVisibility() == 8) {
                                ReportController.o(null, "dc00898", "", "", "0X800C264", "0X800C264", 2, 0, "", "", "", "");
                            }
                            this.f76230e.setVisibility(0);
                            this.f76231f.setText(String.format(BaseApplication.getContext().getString(R.string.f1780835p), b16.G(0, b17.getTargetUin(), ""), Integer.valueOf(e.a(Y))));
                            b16.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.mav.AVSmallHomeTipsPart.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    VideoAppInterface videoAppInterface = b16;
                                    if (videoAppInterface == null || f16.L2) {
                                        return;
                                    }
                                    String currentUin = videoAppInterface.getCurrentUin();
                                    String targetUin = b17.getTargetUin();
                                    ((IZPlanApi) QRoute.api(IZPlanApi.class)).openSmallHomeGuidePageFromQav(AVSmallHomeTipsPart.this.getContext(), targetUin, currentUin, b16.G(f16.f73067q, targetUin, null), ZootopiaSource.create(Source.QavEntrance, ZootopiaSource.SUB_SOURCE_QAV_GROUP_AUTO), true, f16.f73100y0);
                                    f16.L2 = true;
                                    b16.k0(new Object[]{Integer.valueOf(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_TIME_OUT)});
                                }
                            }, 1000L);
                            return;
                        }
                        this.f76230e.setVisibility(8);
                        D9();
                        return;
                    }
                    return;
                }
                this.f76230e.setVisibility(8);
                D9();
                return;
            }
            this.f76230e.setVisibility(8);
            D9();
        }
    }
}
