package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.i;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationReadInJoy extends PhotoPreviewCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String K;
    private boolean G;
    private boolean H;
    private boolean I;
    private Dialog J;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68976);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            K = PhotoPreviewCustomizationReadInJoy.class.getName();
        }
    }

    PhotoPreviewCustomizationReadInJoy(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
            return;
        }
        this.G = false;
        this.H = false;
        this.I = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void C(View view, int i3, Bundle bundle, int i16, Intent intent) {
        Intent startEditPic;
        String stringExtra;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, Integer.valueOf(i3), bundle, Integer.valueOf(i16), intent);
            return;
        }
        int i18 = v().i();
        if (i18 != -1) {
            i iVar = this.C;
            iVar.f184264w = iVar.f184324b.get(i18);
        }
        if (this.C.f184264w != null) {
            ReportController.o(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
            if (this.C.f184258q) {
                boolean z16 = this.G;
                if (!z16 && !this.I && !this.H) {
                    HashMap<String, Object> hashMap = new HashMap<>(1);
                    HashMap<String, LocalMediaInfo> hashMap2 = this.f184334e.selectedMediaInfoHashMap;
                    if (hashMap2 != null && hashMap2.get(this.C.f184264w) != null) {
                        hashMap.put(AEEditorConstants.PARAM_LOCALMEDIAINFO, this.f184334e.selectedMediaInfoHashMap.get(this.C.f184264w));
                    }
                    startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic((Activity) this.f184197m, this.C.f184264w, true, true, true, true, true, i16, w(), 4, hashMap);
                } else {
                    if (z16 && (i17 = v().i()) < this.C.f184324b.size()) {
                        i iVar2 = this.C;
                        iVar2.f184264w = iVar2.f184324b.get(i17);
                    }
                    startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(this.f184197m, this.C.f184264w, true, true, true, true, true, 8, w(), 0);
                }
            } else {
                startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic((Activity) this.f184197m, this.C.f184264w, true, true, true, true, true, 2, w(), 4, new Bundle());
            }
            startEditPic.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184335f).f184248f);
            i iVar3 = this.C;
            if (iVar3.B) {
                startEditPic.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1040);
            } else {
                startEditPic.putExtra(PeakConstants.SEND_BUSINESS_TYPE, iVar3.E);
            }
            startEditPic.putExtra(PeakConstants.READINJOY_DELETE_PIC, v().i());
            this.f184197m.startActivity(startEditPic);
            this.f184197m.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
            v().C.setClickable(false);
            Intent intent2 = this.f184197m.getIntent();
            if (intent2 != null && intent2.hasExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_EDITBTN_REPORT_ACTION_NAME) && (stringExtra = intent2.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_EDITBTN_REPORT_ACTION_NAME)) != null) {
                ReportController.o(null, "CliOper", "", "", stringExtra, stringExtra, 0, 0, "", "", "", "");
            }
        }
        LpReportInfo_pf00064.allReport(603, 4, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.J();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.a();
        if (this.G) {
            v().J.setVisibility(8);
            v().H.setVisibility(8);
        }
        if (this.G) {
            this.f184197m.findViewById(R.id.bfr).setVisibility(0);
            this.f184197m.findViewById(R.id.bfr).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationReadInJoy.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        if (PhotoPreviewCustomizationReadInJoy.this.J == null) {
                            PhotoPreviewCustomizationReadInJoy photoPreviewCustomizationReadInJoy = PhotoPreviewCustomizationReadInJoy.this;
                            photoPreviewCustomizationReadInJoy.J = DialogUtil.createCenterTextDialog(((PhotoPreviewCustomizationDefault) photoPreviewCustomizationReadInJoy).f184197m, 0, ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationReadInJoy.this).f184197m.getString(R.string.gtd), null, ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationReadInJoy.this).f184197m.getString(R.string.gtb), ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationReadInJoy.this).f184197m.getString(R.string.gtc), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i3) {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                        return;
                                    }
                                    Intent intent = new Intent();
                                    intent.putExtra(PeakConstants.READINJOY_DELETE_PIC, PhotoPreviewCustomizationReadInJoy.this.v().i());
                                    ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationReadInJoy.this).f184197m.setResult(-1, intent);
                                    ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationReadInJoy.this).f184197m.finish();
                                    PhotoPreviewCustomizationReadInJoy.this.J.dismiss();
                                }
                            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy.1.2
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i3) {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                    } else {
                                        PhotoPreviewCustomizationReadInJoy.this.J.dismiss();
                                    }
                                }
                            });
                            PhotoPreviewCustomizationReadInJoy.this.J.setCanceledOnTouchOutside(false);
                        }
                        PhotoPreviewCustomizationReadInJoy.this.J.show();
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
        if ((this.C.f184263v || this.f184334e.isSingleMode) && !this.G) {
            v().C.setVisibility(8);
        }
        if (this.H) {
            v().C.setVisibility(0);
            if (this.C.f184324b.size() > 1 && this.f184334e.selectedPhotoList.size() > 1) {
                v().C.setEnabled(false);
                return;
            } else {
                v().C.setEnabled(true);
                return;
            }
        }
        if (this.I) {
            v().C.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void g() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.g();
        ArrayList<String> arrayList = this.f184334e.selectedPhotoList;
        if (arrayList != null && arrayList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !this.C.f184263v && !this.f184334e.isSingleMode && this.G) {
            v().C.setEnabled(true);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void j(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        super.j(intent);
        this.G = intent.getBooleanExtra("from_readinjoy_ugc_deliver", false);
        this.H = intent.getBooleanExtra("from_readinjoy_ugc_deliver_preview", false);
        this.I = intent.getBooleanExtra("from_readinjoy_ugc", false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }
}
