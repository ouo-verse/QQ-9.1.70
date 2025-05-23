package com.tencent.av.ui.part.invite;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.camera.AutoFitTextureView;
import com.tencent.av.camera.Camera2Manager;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.utils.DataReport;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import mw.m;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends Part {

    /* renamed from: d, reason: collision with root package name */
    private ImageButton f76438d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.av.camera.c f76439e;

    /* renamed from: f, reason: collision with root package name */
    private m f76440f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f76441h;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.B9();
        }
    }

    public c(boolean z16) {
        this.f76441h = z16;
    }

    private void A9() {
        if (this.f76439e == null) {
            if (VersionUtils.isLOLLIPOP()) {
                this.f76439e = new Camera2Manager();
            } else {
                this.f76439e = new com.tencent.av.camera.a();
            }
        }
        AutoFitTextureView autoFitTextureView = (AutoFitTextureView) getPartRootView().findViewById(R.id.f30370o6);
        if (autoFitTextureView != null) {
            autoFitTextureView.setVisibility(0);
            com.tencent.av.camera.c cVar = this.f76439e;
            if (cVar != null) {
                cVar.a(autoFitTextureView, getActivity());
            }
        }
        z9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B9() {
        com.tencent.av.camera.c cVar = this.f76439e;
        DataReport.T(null, "CliOper", "", "", "0X800BFB1", "0X800BFB1", 0, cVar != null ? cVar.switchCamera() : true ? 2 : 1, "", "", "", "");
    }

    private void z9() {
        ImageButton imageButton = this.f76438d;
        if (imageButton != null) {
            imageButton.setEnabled(true);
            QavPanel.s0(this.f76438d, R.drawable.dae);
            this.f76438d.setVisibility(0);
        }
        View partRootView = getPartRootView();
        if (partRootView == null) {
            QLog.e("AVInviteCameraSwitchPart", 1, "[initUI] error: rootView is null.");
            return;
        }
        ImageView imageView = (ImageView) partRootView.findViewById(this.f76441h ? R.id.kse : R.id.a2d);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) partRootView.findViewById(this.f76441h ? R.id.ksf : R.id.a2g);
        if (textView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.addRule(14, 0);
            layoutParams.setMargins(ViewUtils.dip2px(16.0f), ViewUtils.dip2px(10.0f), 0, 0);
        }
        TextView textView2 = (TextView) partRootView.findViewById(R.id.a2k);
        if (textView2 != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams2.addRule(14, 0);
            layoutParams2.leftMargin = ViewUtils.dip2px(16.0f);
        }
        QLog.d("AVInviteCameraSwitchPart", 1, "openPreviewCamera visible", new Throwable("\u6253\u5370\u5806\u6808"));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            QLog.e("AVInviteCameraSwitchPart", 1, "onInitView rootView is null");
            return;
        }
        this.f76438d = (ImageButton) view.findViewById(m.l.B);
        this.f76440f = (mw.m) RFWIocAbilityProvider.g().getIocInterface(mw.m.class, getPartRootView(), null);
        ImageButton imageButton = this.f76438d;
        if (imageButton != null) {
            imageButton.setOnClickListener(new a());
        }
        if (nw.b.d(this.f76440f.f(), getActivity())) {
            A9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.av.camera.c cVar = this.f76439e;
        if (cVar != null) {
            cVar.release();
            this.f76439e = null;
        }
        ImageButton imageButton = this.f76438d;
        if (imageButton != null) {
            imageButton.setImageDrawable(null);
            this.f76438d = null;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        com.tencent.av.camera.c cVar = this.f76439e;
        if (cVar != null) {
            cVar.release();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        com.tencent.av.camera.c cVar = this.f76439e;
        if (cVar != null) {
            cVar.resume();
        }
    }
}
