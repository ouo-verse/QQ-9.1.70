package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.BubblePopupWindow;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationFastImage extends PhotoPreviewCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String I;
    boolean G;
    int H;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68969);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            I = PhotoPreviewCustomizationFastImage.class.getName();
        }
    }

    protected PhotoPreviewCustomizationFastImage(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
        } else {
            this.H = 1037;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void C(View view, int i3, Bundle bundle, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(i3), bundle, Integer.valueOf(i16), intent);
            return;
        }
        if (this.C.f184264w != null) {
            ReportController.o(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
            if (this.G) {
                ReportController.o(null, "CliOper", "", "", "0X8004D95", "0X8004D95", 0, 0, "", "", "", "");
            }
        }
        if (this.C.B) {
            this.f184197m.getIntent().putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1040);
        }
        super.C(view, i3, bundle, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if ("FromFastImage".equals(this.C.f184326d)) {
            ReportController.o(null, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
            m.l();
        }
        if ("FromCamera".equals(this.C.f184326d)) {
            m.m();
        }
        if (this.C.B) {
            this.f184197m.getIntent().putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1040);
        }
        super.J();
        ReportController.o(null, "CliOper", "", "", "0X8005147", "0X8005147", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.a();
        v().K.setText(R.string.cur);
        v().I.setVisibility(8);
        v().J.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void j(Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        this.C.f184258q = true;
        super.j(intent);
        BinderWarpper binderWarpper = (BinderWarpper) intent.getParcelableExtra(PeakConstants.BINDER_PRESENDSERVICE);
        if (binderWarpper != null) {
            if (PresendPicMgr.g(null) != null) {
                PresendPicMgr.g(null).l();
            }
            PresendPicMgr i3 = PresendPicMgr.i(e.a.j(binderWarpper.binder));
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                str = stringArrayListExtra.get(0);
            } else {
                str = null;
            }
            if (this.f184337i.l(str) != 1) {
                i3.k(str, this.H, 10);
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "  initData , presendMgr = " + i3 + ",picpath = " + str + ",from = " + this.C.f184326d + ",mBusiType = " + this.H);
                }
            }
        }
        this.G = intent.getBooleanExtra("callFromFastImage", false);
        if ("FromFastImage".equals(this.C.f184326d)) {
            m.a();
        }
        if ("FromCamera".equals(this.C.f184326d)) {
            m.b();
        }
        if (intent.getBooleanExtra(PeakConstants.SEND_FLAG, false)) {
            intent.removeExtra(PeakConstants.SEND_FLAG);
            PresendPicMgr g16 = PresendPicMgr.g(null);
            if (g16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "Photo+ send pic,cancel presend!");
                }
                g16.a(1003);
            }
            PhotoUtils.sendPhoto(this.f184197m, intent, this.f184334e.selectedPhotoList, ((h) this.f184335f).f184248f, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        this.C.B = z16;
        if (z16) {
            v().F.setChecked(!z16);
            v().G.setTextColor(Integer.MAX_VALUE);
            return;
        }
        v().G.setTextColor(-1);
        BubblePopupWindow bubblePopupWindow = this.f184197m.popup;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void onBackPressed() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        PresendPicMgr g16 = PresendPicMgr.g(null);
        if (g16 != null) {
            if ("FromCamera".equals(this.C.f184326d)) {
                i3 = 1016;
            } else {
                i3 = 1017;
            }
            g16.a(i3);
        }
        this.f184197m.finish();
    }
}
