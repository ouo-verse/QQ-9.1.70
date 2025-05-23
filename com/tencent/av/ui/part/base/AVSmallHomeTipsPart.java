package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.m;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.zplan.QAVControllerForZplan;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public class AVSmallHomeTipsPart extends nw.a {

    /* renamed from: e, reason: collision with root package name */
    protected View f76230e = null;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f76231f = null;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<VideoAppInterface> f76232h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<Context> f76233i;

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        z9(getContext(), nw.b.b());
        super.onInitView(view);
        if (this.f76231f == null) {
            View findViewById = view.findViewById(m.g.f76033a);
            this.f76230e = findViewById;
            if (findViewById != null) {
                this.f76231f = (TextView) findViewById.findViewById(m.g.f76034b);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
    }

    @Override // nw.a
    public void z9(Context context, AppInterface appInterface) {
        super.z9(context, appInterface);
        this.f76232h = new WeakReference<>((VideoAppInterface) appInterface);
        this.f76233i = new WeakReference<>(context);
    }

    @Override // nw.a
    public void onDestroy() {
        this.f76230e = null;
        this.f76231f = null;
    }

    public void B9(long j3, View view) {
        WeakReference<VideoAppInterface> weakReference;
        String str;
        if (r.h0() == null || (weakReference = this.f76232h) == null) {
            return;
        }
        String currentUin = weakReference.get().getCurrentUin();
        SessionInfo f16 = n.e().f();
        if (f16 == null) {
            str = "";
        } else {
            str = f16.f73091w;
        }
        String str2 = str;
        QLog.i(this.f421444d, 2, "onClick_SmallHomeEntryTips currentUin " + currentUin + " targetUin " + str2);
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).openSmallHomeGuidePageFromQav(x9(this.f76233i), str2, currentUin, this.f76232h.get().G(n.e().f().f73067q, str2, null), ZootopiaSource.create(Source.QavEntrance, ZootopiaSource.SUB_SOURCE_QAV_C2C_MID), true, n.e().f().f73100y0);
        DataReport.T(null, "dc00898", "", "", "0X800C266", "0X800C266", 1, 0, "", "", "", "");
        QAVControllerForZplan.p().O(x9(this.f76233i), this.f76232h.get());
        if (f16 != null && f16.I2) {
            QAVControllerForZplan.p().R(f16.I0);
        }
        this.f76232h.get().k0(new Object[]{Integer.valueOf(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_TIME_OUT)});
    }

    public void C9() {
        WeakReference<VideoAppInterface> weakReference = this.f76232h;
        if (weakReference == null) {
            QLog.e(this.f421444d, 1, "updateTips_SmallHomeEntry error: app is null.");
            return;
        }
        final VideoAppInterface videoAppInterface = weakReference.get();
        if (videoAppInterface != null && r.h0() != null) {
            final SessionInfo f16 = n.e().f();
            if (f16 == null) {
                QLog.d(this.f421444d, 1, "updateTips_SmallHomeEntry error: sessionInfo is null.");
                return;
            }
            boolean isZPlanAccessible = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(2001L, videoAppInterface.getLongAccountUin());
            if (QLog.isDevelopLevel()) {
                QLog.i(this.f421444d, 2, "updateTips_SmallHomeEntry isConnect: " + f16.z() + " mIsPeerInZplanHome: " + f16.J2 + " isInWhiteList " + isZPlanAccessible);
            }
            if (this.f76230e != null) {
                if (VideoUtil.f(videoAppInterface) && f16.z() && f16.J2 && !f16.I2) {
                    if (this.f76230e.getVisibility() == 8) {
                        DataReport.T(null, "dc00898", "", "", "0X800C264", "0X800C264", 1, 0, "", "", "", "");
                    }
                    this.f76230e.setVisibility(0);
                    TextView textView = this.f76231f;
                    if (textView != null) {
                        textView.setText(String.format(this.f76233i.get().getString(R.string.f1780735o), videoAppInterface.G(f16.f73067q, f16.f73091w, null)));
                    }
                    videoAppInterface.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.base.AVSmallHomeTipsPart.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            VideoAppInterface videoAppInterface2 = videoAppInterface;
                            if (videoAppInterface2 == null || f16.L2) {
                                return;
                            }
                            String currentUin = videoAppInterface2.getCurrentUin();
                            String str = f16.f73091w;
                            ((IZPlanApi) QRoute.api(IZPlanApi.class)).openSmallHomeGuidePageFromQav((Context) AVSmallHomeTipsPart.this.f76233i.get(), str, currentUin, videoAppInterface.G(f16.f73067q, str, null), ZootopiaSource.create(Source.QavEntrance, ZootopiaSource.SUB_SOURCE_QAV_C2C_AUTO), true, f16.f73100y0);
                            f16.L2 = true;
                            videoAppInterface.k0(new Object[]{Integer.valueOf(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_TIME_OUT)});
                        }
                    }, 1000L);
                    return;
                }
                this.f76230e.setVisibility(8);
                return;
            }
            return;
        }
        QLog.e(this.f421444d, 1, "updateTips_SmallHomeEntry error: app is null.");
    }
}
