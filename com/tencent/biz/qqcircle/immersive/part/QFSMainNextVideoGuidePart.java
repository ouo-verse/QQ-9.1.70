package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSMainNextVideoGuidePart extends u {
    private View C;
    private View D;
    private View E;
    private Runnable F;
    private e30.b G;

    /* renamed from: d, reason: collision with root package name */
    private boolean f87424d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f87425e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f87426f = false;

    /* renamed from: h, reason: collision with root package name */
    private int f87427h = 0;

    /* renamed from: i, reason: collision with root package name */
    private String f87428i = "";

    /* renamed from: m, reason: collision with root package name */
    private TextView f87429m;

    private void A9() {
        VideoReport.setElementId(this.f87428i, QCircleDaTongConstant.ElementId.EM_XSJ_GLIDE_GUIDE_TEXT);
        VideoReport.setElementExposePolicy(this.f87428i, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f87428i, ClickPolicy.REPORT_ALL);
    }

    private void B9() {
        this.f87428i = com.tencent.biz.qqcircle.utils.ai.a(2);
    }

    private void C9(final View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str;
        int i3;
        if (feedCloudMeta$StFeed == null) {
            QLog.d(getTAG(), 1, "[initMantle] stop. ");
            return;
        }
        if (feedCloudMeta$StFeed.feedType.get() != 4 && this.f87425e && (str = this.f87428i) != null && !str.equals("")) {
            if (feedCloudMeta$StFeed.type.get() == 2) {
                i3 = 4000;
            } else if (feedCloudMeta$StFeed.type.get() == 3) {
                i3 = 4800;
            } else {
                i3 = 0;
            }
            this.F = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainNextVideoGuidePart.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSMainNextVideoGuidePart.this.G9(view);
                }
            };
            RFWThreadManager.getUIHandler().postDelayed(this.F, i3);
        }
    }

    private void D9() {
        View view = this.D;
        if (view == null) {
            return;
        }
        view.setBackgroundResource(R.drawable.kji);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.D.getBackground();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    private boolean F9() {
        e30.b bVar = this.G;
        if (bVar == null || bVar.g() == null || this.G.g().dittoFeed == null || this.G.g().dittoFeed.dittoId.get() != 41) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9(View view) {
        String str;
        if (view != null && this.f87425e && !this.f87426f) {
            this.f87426f = true;
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.f47871yg);
            if (viewStub == null) {
                return;
            }
            View inflate = viewStub.inflate();
            this.C = inflate.findViewById(R.id.v8_);
            ((ViewGroup.MarginLayoutParams) inflate.getLayoutParams()).bottomMargin = com.tencent.biz.qqcircle.utils.cx.a(56.0f);
            TextView textView = (TextView) this.C.findViewById(R.id.f45231rb);
            this.f87429m = textView;
            if (textView != null && (str = this.f87428i) != null && !str.equals("")) {
                this.f87429m.setText(this.f87428i);
                A9();
            }
            this.D = (ImageView) this.C.findViewById(R.id.f46731vd);
            D9();
        }
    }

    private void z9() {
        this.f87425e = false;
        View view = this.D;
        if (view != null && this.f87426f) {
            view.setVisibility(8);
        }
        View view2 = this.C;
        if (view2 != null && this.f87426f) {
            view2.setVisibility(8);
        }
    }

    public void E9(View view) {
        e30.b bVar;
        if (QCirclePluginGlobalInfo.F() && (bVar = this.G) != null && bVar.g() != null && !this.f87424d && !F9()) {
            this.f87424d = true;
            QCirclePluginGlobalInfo.b0(false);
            C9(view, this.G.g());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMainNextVideoGuidePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if ("layer_notify_part_update_feed_index".equals(str)) {
            Integer num = (Integer) obj;
            QLog.d("QFSMainNextVideoGuidePart", 1, "[handleBroadcastMessage] position : " + num);
            if (num.intValue() != 0 && (this.f87427h == 0 || num.intValue() != this.f87427h)) {
                z9();
                return;
            } else {
                this.f87427h = num.intValue();
                return;
            }
        }
        if ("layer_notify_part_update_feed".equals(str)) {
            this.G = (e30.b) obj;
            E9(this.E);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.F != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.F);
        }
        z9();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.E = view;
        if (QCirclePluginGlobalInfo.F()) {
            B9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.F != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.F);
        }
        z9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
    }
}
