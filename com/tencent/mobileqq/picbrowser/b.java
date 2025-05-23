package com.tencent.mobileqq.picbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.galleryactivity.d;
import com.tencent.common.galleryactivity.e;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends com.tencent.common.galleryactivity.c {
    static IPatchRedirector $redirector_;
    protected PicBrowserGalleryAdapter K;
    protected PicBrowserActivity L;
    protected c M;
    private boolean N;
    protected boolean P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f258922d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f258923e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f258924f;

        a(ActionSheet actionSheet, File file, String str) {
            this.f258922d = actionSheet;
            this.f258923e = file;
            this.f258924f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, actionSheet, file, str);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            this.f258922d.dismiss();
            if (i3 == 0) {
                Activity activity = ((com.tencent.common.galleryactivity.c) b.this).F;
                File file = this.f258923e;
                com.tencent.mobileqq.activity.aio.photo.c.n(activity, file, Utils.Crc64String(file.getAbsolutePath()));
            } else if (i3 == 1) {
                b.this.Q(this.f258924f);
            }
        }
    }

    public b(PicBrowserActivity picBrowserActivity, e eVar) {
        super(picBrowserActivity, eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) picBrowserActivity, (Object) eVar);
            return;
        }
        this.N = false;
        this.P = false;
        this.L = picBrowserActivity;
        this.M = (c) eVar;
        Intent intent = picBrowserActivity.getIntent();
        if (intent != null) {
            this.P = intent.getBooleanExtra("is_forbid_action_sheet", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(String str) {
        if (!new File(str).exists()) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.L, ForwardRecentActivity.class);
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra("key_flag_from_plugin", true);
        this.L.startActivityForResult(intent, 1001);
    }

    public boolean N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.P;
    }

    public void O(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.P = z16;
        }
    }

    protected void P(int i3) {
        String str;
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (!this.P && !this.L.isFinishing()) {
            if (this.M.getItem(i3) != null && this.M.getItem(i3).f258907e != null) {
                if (!TextUtils.isEmpty(this.M.getItem(i3).f258907e.f258919h)) {
                    str = this.M.getItem(i3).f258907e.f258919h;
                    file = new File(this.M.getItem(i3).f258907e.f258919h);
                } else {
                    str = AbsDownloader.getFilePath(this.M.getItem(i3).f258907e.f258917e);
                    file = AbsDownloader.getFile(this.M.getItem(i3).f258907e.f258917e);
                }
            } else {
                str = "";
                file = null;
            }
            if (file == null) {
                return;
            }
            ActionSheet create = ActionSheet.create(this.L);
            create.addButton(HardCodeUtil.qqStr(R.string.p6j));
            create.addButton("\u53d1\u9001\u7ed9QQ\u597d\u53cb");
            create.addCancelButton(HardCodeUtil.qqStr(R.string.j6l));
            create.setOnButtonClickListener(new a(create, file, str));
            create.show();
        }
    }

    @Override // com.tencent.common.galleryactivity.m
    public void i(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.i(i3, i16, intent);
        }
    }

    @Override // com.tencent.common.galleryactivity.m
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.k();
        }
    }

    @Override // com.tencent.common.galleryactivity.m
    public boolean l(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (82 == keyEvent.getKeyCode()) {
            P(this.M.getSelectedIndex());
            return true;
        }
        return super.l(i3, keyEvent);
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.common.galleryactivity.m
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        c cVar = this.M;
        if (cVar instanceof c) {
            cVar.e();
            this.N = true;
        }
        super.m();
    }

    @Override // com.tencent.common.galleryactivity.m
    public void n() {
        PicBrowserGalleryAdapter picBrowserGalleryAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if ((this.M instanceof c) && this.N && (picBrowserGalleryAdapter = this.K) != null) {
            picBrowserGalleryAdapter.notifyDataSetChanged();
        }
        this.N = false;
        super.n();
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.common.galleryactivity.h
    public void onExitAnimationEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onExitAnimationEnd();
            this.L.F2();
        }
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        P(i3);
        return super.onItemLongClick(adapterView, view, i3, j3);
    }

    @Override // com.tencent.common.galleryactivity.c
    protected d q(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        if (this.K == null) {
            this.K = new PicBrowserGalleryAdapter(context);
        }
        return this.K;
    }

    @Override // com.tencent.common.galleryactivity.c
    protected RelativeLayout s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (RelativeLayout) LayoutInflater.from(this.F).inflate(R.layout.axy, (ViewGroup) null);
    }

    @Override // com.tencent.common.galleryactivity.c
    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        PicBrowserImage b16 = this.M.b();
        if (b16 != null) {
            b16.thubmRect = (Rect) this.L.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
            b16.isImgCenterCropMode = this.L.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
        }
    }
}
