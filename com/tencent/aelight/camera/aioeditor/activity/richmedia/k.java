package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k extends u {

    /* renamed from: d, reason: collision with root package name */
    private QzEditVideoPartManager f66465d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f66466e;

    /* renamed from: f, reason: collision with root package name */
    private View f66467f;

    /* renamed from: h, reason: collision with root package name */
    private View f66468h;

    /* renamed from: i, reason: collision with root package name */
    private View f66469i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f66470m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!k.this.f66465d.A0) {
                k.this.r0();
            } else if (k.this.f66465d.R0) {
                ToastUtil.a().b(R.string.gpo);
                k.this.f66465d.R0 = false;
                k.this.f66468h.setSelected(false);
                k.this.f66465d.M0 = false;
                k.this.f66465d.v1(3008);
            } else {
                ToastUtil.a().b(R.string.gpq);
                k.this.f66465d.R0 = true;
                k.this.f66468h.setSelected(true);
                k.this.f66465d.M0 = true;
                k.this.f66465d.v1(3007);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            id0.a.n("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
            if (!k.this.f66465d.S0) {
                k.this.s0();
            } else {
                k.this.f66465d.S0 = false;
                k.this.f66469i.setSelected(false);
                k.this.f66465d.v1(3003);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            k.this.q0("an_yuanshipin");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            k.this.f66465d.S0 = true;
            k.this.f66469i.setSelected(true);
            k.this.f66465d.v1(3002);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            k.this.f66465d.S0 = false;
            k.this.f66469i.setSelected(false);
        }
    }

    public k(QzEditVideoPartManager qzEditVideoPartManager, Activity activity) {
        super(qzEditVideoPartManager);
        this.f66470m = false;
        this.f66465d = qzEditVideoPartManager;
        this.f66466e = activity;
        this.f66470m = SlideShowPhotoListManager.n().m() == 22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(String str) {
        String string = getResources().getString(R.string.gln);
        QZoneHelper.forwardOpenQzoneVip2(this.f66466e, QZoneHelper.UserInfo.getInstance(), str, QQStoryContext.h().f(), "", 1010, string, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        DialogUtil.createCustomDialog(this.f66466e, 230).setMessage(R.string.gp7).setPositiveButton(R.string.gd5, new d()).setNegativeButton(R.string.hkb, new c()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        DialogUtil.createCustomDialog(this.f66466e, 230).setMessage(R.string.gp8).setPositiveButton(R.string.gd5, new f()).setNegativeButton(R.string.a8j, new e()).show();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1010 && i16 == -1) {
            ToastUtil.a().b(R.string.gia);
            this.f66465d.A0 = true;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        p0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
        QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
    }

    private void p0() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewSure(R.id.rsr);
        this.f66467f = LayoutInflater.from(getContext()).inflate(R.layout.bkd, (ViewGroup) relativeLayout, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, LiuHaiUtils.sNotchHeight, 0, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        this.f66468h = this.f66467f.findViewById(R.id.hgk);
        this.f66469i = this.f66467f.findViewById(R.id.hgj);
        if (this.f66470m) {
            this.f66468h.setVisibility(8);
            this.f66469i.setVisibility(8);
        } else {
            this.f66468h.setOnClickListener(new a());
            this.f66469i.setOnClickListener(new b());
        }
        relativeLayout.addView(this.f66467f, layoutParams);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (i3 != 0) {
            if (i3 != 11) {
                if (i3 != 4) {
                    if (i3 != 5 && i3 != 6) {
                        return;
                    }
                }
            }
            View view = this.f66467f;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.f66467f;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }
}
