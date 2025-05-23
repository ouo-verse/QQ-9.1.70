package com.qzone.publish.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.album.ui.widget.e;
import com.qzone.common.activities.base.QZoneTitleBarActivity;
import com.qzone.common.tool.ReportUtils;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DownloadBoxForTitle {

    /* renamed from: a, reason: collision with root package name */
    private c f52100a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f52101b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f52102c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f52103d;

    /* renamed from: e, reason: collision with root package name */
    private AnimationDrawable f52104e;

    /* renamed from: f, reason: collision with root package name */
    private String f52105f;

    /* renamed from: g, reason: collision with root package name */
    AnimationDrawable f52106g;

    /* renamed from: h, reason: collision with root package name */
    AnimationDrawable f52107h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f52108i;

    /* renamed from: j, reason: collision with root package name */
    DownloadQueue.b f52109j;

    /* renamed from: k, reason: collision with root package name */
    ActionSheet f52110k;

    /* renamed from: l, reason: collision with root package name */
    private ActionSheet.OnButtonClickListener f52111l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ActionSheetHelper.showActionSheet(DownloadBoxForTitle.this.f52100a.zf(), DownloadBoxForTitle.this.f52110k);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements ActionSheet.OnButtonClickListener {
        b() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            ActionSheet actionSheet = DownloadBoxForTitle.this.f52110k;
            if (actionSheet == null) {
                return;
            }
            int i16 = actionSheet.getActionMenuItem(i3).action;
            if (i16 == 207) {
                com.qzone.album.env.common.a.m().V(l.a(R.string.lsa));
                DownloadQueue.j().e();
            } else if (i16 == 208) {
                DownloadBoxForTitle.this.h();
                DownloadQueue.j().C();
            }
            ActionSheetHelper.dismissActionSheet(DownloadBoxForTitle.this.f52100a.zf(), DownloadBoxForTitle.this.f52110k);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface c {
        void Fe(boolean z16);

        ViewGroup G8();

        int bd();

        Handler getHandler();

        Resources getResources();

        boolean i0();

        boolean z();

        Activity zf();
    }

    public DownloadBoxForTitle(c cVar) {
        this.f52106g = null;
        this.f52107h = null;
        this.f52108i = true;
        this.f52109j = new DownloadQueue.b() { // from class: com.qzone.publish.utils.DownloadBoxForTitle.1
            @Override // com.qzone.album.business.downloader.DownloadQueue.b
            public void a() {
                DownloadBoxForTitle.this.f52100a.getHandler().post(new Runnable() { // from class: com.qzone.publish.utils.DownloadBoxForTitle.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadBoxForTitle.this.l();
                    }
                });
            }
        };
        this.f52111l = new b();
        this.f52100a = cVar;
        this.f52106g = (AnimationDrawable) cVar.getResources().getDrawable(R.drawable.ast);
        this.f52107h = (AnimationDrawable) this.f52100a.getResources().getDrawable(R.drawable.asu);
        DownloadQueue.j().a(this.f52109j);
        l();
    }

    private void f() {
        if (this.f52103d == null) {
            ViewGroup G8 = this.f52100a.G8();
            this.f52103d = G8;
            if (G8 == null) {
                return;
            }
        }
        if (this.f52101b == null) {
            ImageView imageView = (ImageView) this.f52103d.findViewById(R.id.f165010bp3);
            this.f52101b = imageView;
            imageView.setMaxHeight((int) this.f52100a.getResources().getDimension(R.dimen.f158719n9));
            if (this.f52100a.bd() != 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f52101b.getLayoutParams();
                layoutParams.width = this.f52100a.bd();
                this.f52101b.setLayoutParams(layoutParams);
            }
            this.f52101b.setImageResource(R.drawable.qzone_skin_download_box_level_0);
            this.f52101b.setOnClickListener(new a());
            QZoneTitleBarActivity.setLayerType(this.f52101b);
            this.f52101b.setVisibility(4);
        }
        if (this.f52102c == null) {
            TextView textView = (TextView) this.f52103d.findViewById(R.id.f165011bp4);
            this.f52102c = textView;
            textView.setVisibility(4);
        }
        try {
            if (this.f52110k == null) {
                this.f52110k = e.a(this.f52100a.zf(), this.f52111l);
            }
        } catch (Throwable th5) {
            QZLog.e("DownloadBoxForTitle", "createDownloadActionSheet Error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("clickCancel", String.valueOf(1));
        ReportUtils.b("batchDownload", hashMap);
    }

    private void k(int i3) {
        ActionSheet actionSheet = this.f52110k;
        if (actionSheet == null) {
            QZLog.w("[PhotoAlbum]downloadPhotoAndVideo", 2, "mDownloadActionSheet == null");
            return;
        }
        if (i3 == 1) {
            this.f52110k.setMainTitle(String.format("%d\u4e2a\u5a92\u4f53\u4e0b\u8f7d\u4e2d", Integer.valueOf(DownloadQueue.j().g())));
        } else if (i3 == 2) {
            this.f52110k.setMainTitle(String.format(l.a(R.string.ls8), Integer.valueOf(DownloadQueue.j().h())));
        } else if (i3 == 3) {
            actionSheet.setMainTitle(String.format(l.a(R.string.ls5), new Object[0]));
        }
        this.f52110k.updateAllButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        f();
        int k3 = DownloadQueue.j().k();
        boolean z16 = QZonePublishQueue.w().F() || QZonePublishQueue.w().A() != 0;
        if (k3 > 0 && !z16 && this.f52108i) {
            this.f52100a.Fe(true);
            this.f52103d.setVisibility(0);
            if (this.f52101b.getVisibility() != 0) {
                this.f52101b.setVisibility(0);
            }
            if (DownloadQueue.j().m()) {
                int i3 = DownloadQueue.j().i();
                i();
                this.f52102c.setBackgroundResource(R.drawable.skin_tips_newmessage);
                this.f52102c.setText(String.valueOf(i3));
                k(1);
            } else if (DownloadQueue.j().l()) {
                j();
                this.f52102c.setBackgroundResource(R.drawable.gcs);
                this.f52102c.setText("");
                k(3);
            } else {
                j();
                this.f52102c.setBackgroundResource(R.drawable.gcr);
                this.f52102c.setText("");
                k(2);
            }
            if (this.f52102c.getVisibility() != 0) {
                this.f52102c.setVisibility(0);
                return;
            }
            return;
        }
        this.f52100a.Fe(false);
        if (this.f52101b.getVisibility() == 0) {
            this.f52101b.setVisibility(4);
        }
        if (this.f52102c.getVisibility() == 0) {
            this.f52102c.setVisibility(4);
        }
        this.f52103d.setVisibility(8);
        ActionSheet actionSheet = this.f52110k;
        if (actionSheet == null || !actionSheet.isShowing()) {
            return;
        }
        this.f52110k.dismiss();
    }

    public DownloadQueue.b e() {
        return this.f52109j;
    }

    public void i() {
        AnimationDrawable animationDrawable = this.f52104e;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.f52104e = null;
        }
        if (!this.f52100a.z() && !this.f52100a.i0()) {
            this.f52104e = this.f52107h;
        } else {
            this.f52104e = this.f52106g;
        }
        ImageView imageView = this.f52101b;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(this.f52104e);
        this.f52104e.start();
    }

    public void j() {
        AnimationDrawable animationDrawable = this.f52104e;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.f52104e = null;
        }
        if (this.f52101b == null) {
            return;
        }
        if (!this.f52100a.z() && !this.f52100a.i0()) {
            if (com.tencent.mobileqq.simpleui.b.c() && SimpleUIUtil.useDarkResource()) {
                this.f52101b.setImageResource(R.drawable.f162468i00);
                return;
            } else {
                this.f52101b.setImageResource(R.drawable.qzone_skin_download_box_level_default_0);
                return;
            }
        }
        this.f52101b.setImageResource(R.drawable.qzone_skin_download_box_level_0);
    }

    public void d() {
        this.f52108i = false;
        l();
    }

    public void g() {
        this.f52108i = true;
        l();
    }

    public DownloadBoxForTitle(c cVar, String str) {
        this(cVar);
        this.f52105f = str;
    }
}
