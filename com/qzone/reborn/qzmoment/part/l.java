package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.reborn.qzmoment.bean.QZMPublishBean;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import on.e;
import org.light.device.OfflineConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class l extends an.a implements View.OnClickListener, gn.c {

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f58967d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f58968e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f58969f;

    /* renamed from: i, reason: collision with root package name */
    private AnimationDrawable f58971i;

    /* renamed from: m, reason: collision with root package name */
    private on.e f58972m;

    /* renamed from: h, reason: collision with root package name */
    private int f58970h = 0;
    private final e.c C = new a();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements e.c {
        a() {
        }

        @Override // on.e.c
        public void a() {
            l.this.J9(true, false);
        }

        @Override // on.e.c
        public void b() {
            l.this.O9(1);
        }

        @Override // on.e.c
        public void c(boolean z16) {
            l.this.J9(false, z16);
        }
    }

    private AnimationDrawable F9() {
        if (getContext() == null) {
            return null;
        }
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.lf5);
        if (drawable instanceof AnimationDrawable) {
            return (AnimationDrawable) drawable;
        }
        return null;
    }

    private void G9() {
        if (getActivity() == null) {
            QLog.e("QZMFolderPublishBoxPart", 1, "qzm activity is null");
        } else if (getActivity().getIntent() == null) {
            QLog.e("QZMFolderPublishBoxPart", 1, "qzm activity intent is null");
        } else {
            K9(getActivity().getIntent());
        }
    }

    private void H9() {
        if (this.f58970h != 2) {
            return;
        }
        boolean D = this.f58972m.D();
        QLog.d(getTAG(), 1, "handlePublishBoxClick in error state, retry result:", Boolean.valueOf(D));
        if (D) {
            return;
        }
        J9(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I9(int i3) {
        if (this.f58970h == i3) {
            return;
        }
        this.f58970h = i3;
        QLog.d(getTAG(), 1, "updatePublishBoxUIState: ", Integer.valueOf(i3));
        int i16 = this.f58970h;
        if (i16 == 0) {
            this.f58967d.setVisibility(8);
            N9();
            this.f58969f.setVisibility(8);
        } else if (i16 == 1) {
            this.f58967d.setVisibility(0);
            M9();
            this.f58969f.setVisibility(8);
        } else {
            if (i16 != 2) {
                return;
            }
            this.f58967d.setVisibility(0);
            N9();
            this.f58969f.setVisibility(0);
        }
    }

    private void L9() {
        if (OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) <= 3) {
            return;
        }
        String o16 = com.qzone.reborn.configx.g.f53821a.b().o1();
        if (TextUtils.isEmpty(o16) || ((IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class)).isQZoneCameraMaterialReady(o16)) {
            return;
        }
        ((IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class)).preDownloadQZoneCameraMaterialByUrl(o16);
    }

    private void M9() {
        AnimationDrawable animationDrawable = this.f58971i;
        if (animationDrawable == null) {
            AnimationDrawable F9 = F9();
            this.f58971i = F9;
            F9.setColorFilter(getContext().getColor(R.color.qui_common_icon_secondary), PorterDuff.Mode.SRC_ATOP);
        } else {
            animationDrawable.stop();
        }
        this.f58968e.setImageDrawable(this.f58971i);
        this.f58971i.start();
    }

    private void N9() {
        this.f58968e.setImageDrawable(getContext().getDrawable(R.drawable.qui_upload));
        AnimationDrawable animationDrawable = this.f58971i;
        if (animationDrawable == null) {
            return;
        }
        animationDrawable.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O9(final int i3) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.qzmoment.part.k
            @Override // java.lang.Runnable
            public final void run() {
                l.this.I9(i3);
            }
        });
    }

    @Override // gn.c
    public boolean M7() {
        return this.f58970h == 0;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMPublish_QZMFolderPublishBoxPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.jow) {
            H9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f58967d = (FrameLayout) view.findViewById(R.id.jow);
        this.f58968e = (ImageView) view.findViewById(R.id.lvq);
        this.f58969f = (FrameLayout) view.findViewById(R.id.jox);
        this.f58967d.setOnClickListener(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        K9(intent);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        registerIoc(this, gn.c.class);
        this.f58972m = new on.e(this.C);
        ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(activity);
        L9();
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f58972m.A();
    }

    private void K9(Intent intent) {
        if (intent == null || !intent.hasExtra("key_bundle_publish_bean")) {
            return;
        }
        QZMPublishBean qZMPublishBean = (QZMPublishBean) intent.getParcelableExtra("key_bundle_publish_bean");
        this.f58972m.k(qZMPublishBean);
        QLog.d("QZMFolderPublishBoxPart", 1, "parse intent success\uff0creceive publishBean:", qZMPublishBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9(boolean z16, boolean z17) {
        String str;
        int i3 = 0;
        if (!z16 && z17) {
            i3 = 2;
        }
        O9(i3);
        if (z16) {
            str = "\u53d1\u5e03\u6210\u529f";
        } else if (z17) {
            str = "\u53d1\u5e03\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5";
        } else {
            str = "\u53d1\u5e03\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u62cd\u6444";
        }
        c6.a.i(str);
    }
}
