package com.tencent.mobileqq.activity.photo.albumlogicImp;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.aelight.camera.qqstory.api.IEditPicForQzone;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.i;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoData;
import com.tencent.mobileqq.activity.photo.album.preview.view.c;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqslideshow.ISlideShowController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationQzone extends PhotoPreviewCustomizationDefault implements e {
    static IPatchRedirector $redirector_;
    public static final String P;
    private HashMap<String, Integer> G;
    int H;
    protected boolean I;
    boolean J;
    public boolean K;
    public boolean L;
    boolean M;
    private int N;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68972);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            P = PhotoPreviewCustomizationQzone.class.getName();
        }
    }

    protected PhotoPreviewCustomizationQzone(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
        } else {
            this.H = 0;
            this.N = 0;
        }
    }

    private boolean N(int i3) {
        i iVar;
        ArrayList<String> arrayList;
        if (v() != null && (iVar = this.C) != null && (arrayList = iVar.f184324b) != null && i3 < arrayList.size() && i3 >= 0) {
            return true;
        }
        return false;
    }

    private String O(int i3) {
        if (R() || i3 < 0 || i3 >= this.C.f184324b.size()) {
            return null;
        }
        return this.C.f184324b.get(v().i());
    }

    private int P() {
        if (this.f184334e.selectedPhotoList == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.f184334e.selectedPhotoList.size(); i16++) {
            if (this.f184337i.l(this.f184334e.selectedPhotoList.get(i16)) == 1) {
                i3++;
            }
        }
        return i3;
    }

    private boolean Q() {
        HashMap<String, LocalMediaInfo> hashMap;
        Object[] array;
        Object obj;
        String obj2;
        if (this.N != 0 || (hashMap = this.f184334e.selectedMediaInfoHashMap) == null || hashMap.size() == 0 || (array = this.f184334e.selectedMediaInfoHashMap.keySet().toArray()) == null || array.length == 0 || (obj = array[0]) == null || (obj2 = obj.toString()) == null || QAlbumUtil.getMediaType(this.f184334e.selectedMediaInfoHashMap.get(obj2)) != 1) {
            return false;
        }
        return true;
    }

    private boolean R() {
        i iVar = this.C;
        if (iVar == null || iVar.f184324b == null) {
            return true;
        }
        return false;
    }

    private boolean S() {
        ArrayList<String> arrayList;
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
        if (photoCommonBaseData == 0 || (arrayList = photoCommonBaseData.selectedPhotoList) == null || !arrayList.isEmpty()) {
            return false;
        }
        return true;
    }

    private void W() {
        c v3;
        TextView textView;
        if (!this.K || !Q() || (v3 = v()) == null || (textView = v3.C) == null) {
            return;
        }
        textView.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void C(View view, int i3, Bundle bundle, int i16, Intent intent) {
        LocalMediaInfo localMediaInfo;
        String stringExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(i3), bundle, Integer.valueOf(i16), intent);
            return;
        }
        int i17 = v().i();
        if (i17 != -1) {
            i iVar = this.C;
            iVar.f184264w = iVar.f184324b.get(i17);
        }
        if (this.C.f184264w != null) {
            ReportController.o(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
            Intent intent2 = new Intent();
            HashMap<String, LocalMediaInfo> hashMap = this.f184334e.selectedMediaInfoHashMap;
            if (hashMap != null) {
                localMediaInfo = hashMap.get(this.C.f184264w);
            } else {
                localMediaInfo = null;
            }
            if (this.I && QAlbumUtil.getMediaType(localMediaInfo) == 1 && this.K && this.C.f184258q) {
                new HashMap(1).put(AEEditorConstants.PARAM_LOCALMEDIAINFO, localMediaInfo);
                intent2 = new Intent(BaseApplication.getContext(), (Class<?>) EditLocalVideoActivity.class);
                intent2.putExtras(this.f184197m.getIntent());
                intent2.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
                intent2.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
                intent2.putExtra(PeakConstants.DIRECT_BACK_TO_QZONE, true);
                intent2.putExtra("qzone_plugin_activity_name", QZoneHelper.QQ_PUBLIC_ACCOUNT_PUBLISH_PAGE);
                intent2.putExtra("short_video_refer", getClass().getName());
                intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_ENTRY, 1);
                intent2.putExtra("file_send_path", this.C.f184264w);
                if (localMediaInfo != null) {
                    intent2.putExtra(PeakConstants.VIDEO_SIZE, localMediaInfo.fileSize);
                    intent2.putExtra(ShortVideoConstants.FILE_SEND_DURATION, localMediaInfo.mDuration);
                    intent2.putExtra(ShortVideoConstants.FILE_WIDTH, localMediaInfo.mediaWidth);
                    intent2.putExtra(ShortVideoConstants.FILE_HEIGHT, localMediaInfo.mediaHeight);
                }
            } else if (this.C.f184258q) {
                HashMap<String, Object> hashMap2 = new HashMap<>(1);
                if (v() != null && !R() && S()) {
                    this.f184334e.selectedPhotoList.add(O(v().i()));
                }
                intent2.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184334e.selectedPhotoList);
                HashMap<String, LocalMediaInfo> hashMap3 = this.f184334e.selectedMediaInfoHashMap;
                if (hashMap3 != null && hashMap3.get(this.C.f184264w) != null) {
                    hashMap2.put(AEEditorConstants.PARAM_LOCALMEDIAINFO, this.f184334e.selectedMediaInfoHashMap.get(this.C.f184264w));
                }
                if (this.K) {
                    intent2 = ((IEditPicForQzone) QRoute.api(IEditPicForQzone.class)).newPictureEditIntentWithoutPublish(this.f184197m, this.C.f184264w);
                    intent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184334e.selectedPhotoList);
                    intent2.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184334e.selectedPhotoList);
                } else {
                    intent2 = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic((Activity) this.f184197m, this.C.f184264w, true, true, true, true, true, 3, 99, 4, hashMap2);
                }
            }
            intent2.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184335f).f184248f);
            intent2.putExtra(PeakConstants.SEND_BUSINESS_TYPE, this.C.E);
            this.f184197m.startActivity(intent2);
            this.f184197m.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
            if (v().C != null) {
                v().C.setClickable(false);
            }
            Intent intent3 = this.f184197m.getIntent();
            if (intent3 != null && intent3.hasExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_EDITBTN_REPORT_ACTION_NAME) && (stringExtra = intent3.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_EDITBTN_REPORT_ACTION_NAME)) != null) {
                ReportController.o(null, "CliOper", "", "", stringExtra, stringExtra, 0, 0, "", "", "", "");
            }
        }
        LpReportInfo_pf00064.allReport(603, 4, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void E(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        if (i3 != -1) {
            LocalMediaInfo k3 = this.f184337i.k(this.C.f184324b.get(i3));
            if (this.J) {
                if (!((IQQStoryFlowManager) QRoute.api(IQQStoryFlowManager.class)).isValidMedia(this.f184197m, k3)) {
                    v().I.setChecked(false);
                    return;
                }
                PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
                if (photoCommonBaseData.selectedMediaInfoHashMap == null) {
                    photoCommonBaseData.selectedMediaInfoHashMap = new HashMap<>();
                }
                String str = this.C.f184324b.get(i3);
                this.f184334e.selectedMediaInfoHashMap.put(str, this.f184337i.k(str));
            }
        }
        super.E(i3);
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void J() {
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.L) {
            Intent intent = new Intent();
            intent.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.f184334e.selectedIndex);
            this.f184197m.setResult(-1, intent);
            this.f184197m.finish();
            return;
        }
        ArrayList<String> m3 = v().m();
        if (this.K && (arrayList = this.f184334e.selectedPhotoList) != null && arrayList.isEmpty() && m3 != null && m3.size() == 1) {
            String str = m3.get(0);
            LocalMediaInfo k3 = this.f184337i.k(str);
            if (k3 != null) {
                if (this.G == null) {
                    this.G = new HashMap<>();
                }
                this.G.put(str, Integer.valueOf(k3.panoramaPhotoType));
                HashMap<String, LocalMediaInfo> hashMap = this.f184334e.selectedMediaInfoHashMap;
                if (hashMap != null) {
                    hashMap.clear();
                    this.f184334e.selectedMediaInfoHashMap.put(str, k3);
                }
            }
            if (this.f184337i.l(str) == 1 && !com.tencent.mobileqq.utils.e.d(this.f184197m, P(), k3, this.M)) {
                v().H.setClickable(true);
                return;
            }
        }
        if (m3 != null) {
            m.p(m3.size(), this.C.f184329g);
            m.i(this.f184197m.getIntent(), m3.size(), ((h) this.f184335f).f184248f);
        }
        Intent intent2 = this.f184197m.getIntent();
        if (m3 != null) {
            f.l(m3);
        }
        if (this.K || this.J) {
            intent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f184334e.selectedMediaInfoHashMap);
            intent2.putExtra(PeakConstants.PANORAMA_IMAGES, this.G);
        }
        if (1 == this.H) {
            intent2.putExtra(PeakConstants.KEY_SHOW_TYPE, 1);
        } else {
            intent2.putExtra(PeakConstants.KEY_SHOW_TYPE, 0);
        }
        if (this.J) {
            intent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f184334e.selectedMediaInfoHashMap);
        }
        G(intent2, false, v().m());
        if (intent2.getBooleanExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT, false)) {
            String stringExtra = intent2.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT_ACTION_NAME);
            String stringExtra2 = intent2.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_ALBUM_REPORT_REVERSE2);
            if (stringExtra2 == null) {
                stringExtra2 = intent2.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_CAMERA_REPORT_REVERSE2);
            }
            if (stringExtra2 == null) {
                stringExtra2 = intent2.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT_REVERSE2);
            }
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            String str2 = stringExtra2;
            if (stringExtra != null) {
                ReportController.o(null, "CliOper", "", "", stringExtra, stringExtra, 0, 0, str2, "", "", "");
            }
        }
    }

    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int i3 = v().i();
        if (i3 != -1) {
            String str = this.C.f184324b.get(i3);
            if (this.K) {
                PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
                if (photoCommonBaseData.selectedMediaInfoHashMap == null) {
                    photoCommonBaseData.selectedMediaInfoHashMap = new HashMap<>();
                }
                LocalMediaInfo k3 = this.f184337i.k(str);
                this.f184334e.selectedMediaInfoHashMap.put(str, k3);
                if (this.G == null) {
                    this.G = new HashMap<>();
                }
                if (k3 != null) {
                    this.G.put(str, Integer.valueOf(k3.panoramaPhotoType));
                }
            }
        }
    }

    public void U(SlideItemInfo slideItemInfo) {
        HashMap<String, Integer> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) slideItemInfo);
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.C.f184324b.size()) {
                if (this.C.f184324b.get(i3).equals(slideItemInfo.f94291i)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0 && i3 < this.C.f184324b.size() && (hashMap = this.G) != null) {
            hashMap.remove(this.C.f184324b.get(i3));
        }
    }

    void V(String str) {
        if (this.J) {
            ISlideShowController iSlideShowController = (ISlideShowController) QRoute.api(ISlideShowController.class);
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
            iSlideShowController.onItemsSelectChanged(photoCommonBaseData.selectedPhotoList, photoCommonBaseData.allMediaInfoHashMap);
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).updatePhotoPreviewSelectUI(this.f184334e.selectedPhotoList.indexOf(str));
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.a();
        if (this.J) {
            try {
                ((ISlideShowController) QRoute.api(ISlideShowController.class)).initPhotoPreviewController(this.f184197m, v().f184366i, this);
            } catch (Throwable th5) {
                QLog.e("QQAlbum", 1, "[initUI] error: ", th5);
            }
            if (v().K != null) {
                v().K.setText("");
            }
            if (v().L != null) {
                v().L.setVisibility(8);
            }
            if (v().i() != -1) {
                V(this.C.f184324b.get(v().i()));
            }
            if (this.f184197m.enableLiuHai) {
                RelativeLayout relativeLayout = (RelativeLayout) v().f184364f.findViewById(R.id.jnd);
                ((ViewGroup) relativeLayout.getParent()).removeView(relativeLayout);
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height);
                layoutParams2.addRule(10, -1);
                layoutParams2.topMargin = ViewUtils.dip2px(8.0f);
                ((RelativeLayout) this.f184197m.findViewById(R.id.aas)).addView(relativeLayout, layoutParams2);
            }
        }
        if (v().C != null && this.I) {
            v().C.setVisibility(0);
        }
        TextView textView = v().L;
        if (textView != null) {
            textView.setMinWidth(ViewUtils.dpToPx(40.0f));
            textView.setGravity(1);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (this.J) {
            LayoutInflater layoutInflater = (LayoutInflater) this.f184197m.getSystemService("layout_inflater");
            if (layoutInflater == null) {
                return null;
            }
            View inflate = layoutInflater.inflate(R.layout.f168928b82, (ViewGroup) null);
            inflate.setPadding(0, 0, 0, BaseAIOUtils.f(12.0f, this.f184197m.getResources()));
            return inflate;
        }
        return super.d();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (this.J) {
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).onPhotoPreviewDestroy();
        }
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        super.doOnResume();
        if (this.J) {
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).onResume();
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).setPhotoPreviewController();
            ISlideShowController iSlideShowController = (ISlideShowController) QRoute.api(ISlideShowController.class);
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
            iSlideShowController.onItemsSelectChanged(photoCommonBaseData.selectedPhotoList, photoCommonBaseData.allMediaInfoHashMap);
        }
        W();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void g() {
        String string;
        boolean z16;
        boolean z17;
        ArrayList<String> arrayList;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.g();
        if (this.J) {
            string = this.f184197m.getString(R.string.f171532fv3);
        } else {
            string = this.f184197m.getString(R.string.ctx);
        }
        boolean z19 = true;
        if (this.H == 1) {
            string = this.f184197m.getString(R.string.cuc);
        }
        String str = this.f184334e.customSendBtnText;
        if (str != null) {
            string = str;
        }
        if (v().H != null && (arrayList = this.f184334e.selectedPhotoList) != null && arrayList.size() > 0 && this.H == 1) {
            Button button = v().H;
            if (this.f184334e.selectedPhotoList.size() >= 3) {
                z18 = true;
            } else {
                z18 = false;
            }
            button.setEnabled(z18);
            v().H.setText(string + "(" + this.f184334e.selectedPhotoList.size() + ")");
        }
        if (this.I) {
            if (v().H != null) {
                v().H.setText(string);
                if (this.J) {
                    v().H.setEnabled(false);
                }
            }
            if (v().C != null && this.K && this.C.f184324b != null) {
                v().C.setEnabled(true);
            }
            if (v().F != null) {
                v().F.setOnCheckedChangeListener(null);
                CheckBox checkBox = v().F;
                if (((h) this.f184335f).f184248f == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                checkBox.setChecked(z17);
                v().F.setOnCheckedChangeListener(v());
            }
            if (v().G != null && ((h) this.f184335f).f184248f == 2) {
                v().G.setTextColor(-16734752);
            }
            M();
        }
        if (v().H != null) {
            ArrayList<String> arrayList2 = this.f184334e.selectedPhotoList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.J) {
                    Button button2 = v().H;
                    if (this.f184334e.selectedPhotoList.size() < 2) {
                        z19 = false;
                    }
                    button2.setEnabled(z19);
                    return;
                }
                return;
            }
            if (this.J) {
                v().H.setEnabled(false);
            }
        }
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void i(SlideItemInfo slideItemInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) slideItemInfo);
            return;
        }
        if (slideItemInfo == null) {
            return;
        }
        U(slideItemInfo);
        int i3 = 0;
        while (true) {
            if (i3 < this.C.f184324b.size()) {
                if (this.C.f184324b.get(i3).equals(slideItemInfo.f94291i)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            if (this.f184334e.selectedIndex.contains(Integer.valueOf(i3))) {
                v().I.setChecked(false);
                int indexOf = this.f184334e.selectedIndex.indexOf(Integer.valueOf(i3));
                if (indexOf >= 0) {
                    this.f184334e.selectedPhotoList.remove(this.C.f184324b.get(i3));
                    this.f184334e.selectedIndex.remove(indexOf);
                    i iVar = this.C;
                    HashMap<String, PicInfo> hashMap = iVar.f184255n;
                    if (hashMap != null) {
                        hashMap.remove(iVar.f184324b.get(i3));
                    }
                    i iVar2 = this.C;
                    HashMap<String, PhotoSendParams> hashMap2 = iVar2.f184253l;
                    if (hashMap2 != null) {
                        hashMap2.remove(iVar2.f184324b.get(i3));
                    }
                }
                g();
                V(this.C.f184324b.get(i3));
                return;
            }
            return;
        }
        this.f184334e.selectedPhotoList.remove(slideItemInfo.f94291i);
        g();
        v().n(slideItemInfo.f94291i);
        V(slideItemInfo.f94291i);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void j(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        this.C.f184258q = true;
        f.c("preview create");
        this.C.f184330h = intent.getIntExtra("camera_type", 1);
        this.J = intent.getBooleanExtra("from_qzone_slideshow", false);
        super.j(intent);
        this.G = (HashMap) intent.getSerializableExtra(PeakConstants.PANORAMA_IMAGES);
        this.H = intent.getIntExtra(PeakConstants.KEY_SHOW_TYPE, 0);
        this.I = intent.getBooleanExtra(PeakConstants.QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW, false);
        this.K = intent.getBooleanExtra(PeakConstants.FROM_QZONE, false);
        this.L = intent.getBooleanExtra(PeakConstants.FROM_QZONE_PHOTO_GROUP, false);
        this.M = intent.getBooleanExtra(PeakConstants.FROM_SHUOSHUO, false);
        if (this.J) {
            SlideShowPhotoListManager.n().A(19);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(int i3) {
        String str;
        RichMediaBaseData richMediaBaseData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        super.k(i3);
        this.N = i3;
        if (this.J) {
            RichMediaBrowserInfo item = v().getItem(i3);
            if (item != null && (richMediaBaseData = item.baseData) != null) {
                if (richMediaBaseData.getType() == 100) {
                    str = ((PreviewPictureData) item.baseData).filePath;
                } else if (item.baseData.getType() == 101) {
                    str = ((PreviewVideoData) item.baseData).filePath;
                }
                if (str != null) {
                    v().n(str);
                }
                V(this.C.f184324b.get(i3));
            }
            str = null;
            if (str != null) {
            }
            V(this.C.f184324b.get(i3));
        }
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void m() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        T();
        if (v().i() != -1) {
            str = this.C.f184324b.get(v().i());
            this.f184334e.selectedPhotoList.add(str);
            this.f184334e.selectedIndex.add(Integer.valueOf(v().i()));
            if (this.J) {
                PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
                if (photoCommonBaseData.selectedMediaInfoHashMap == null) {
                    photoCommonBaseData.selectedMediaInfoHashMap = new HashMap<>();
                }
                this.f184334e.selectedMediaInfoHashMap.put(str, this.f184337i.k(str));
            }
        } else {
            str = "";
        }
        v().n(str);
        g();
        V(this.C.f184324b.get(v().i()));
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void n(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        int i3 = 0;
        if (this.J) {
            i iVar = this.C;
            if (!iVar.f184260s) {
                iVar.f184324b.clear();
                this.C.f184324b.addAll(this.f184334e.selectedPhotoList);
                this.f184334e.selectedIndex.clear();
                for (int i16 = 0; i16 < this.f184334e.selectedPhotoList.size(); i16++) {
                    this.f184334e.selectedIndex.add(Integer.valueOf(i16));
                }
                this.f184337i.notifyImageListChanged(this.f184337i.g(), 0);
                this.C.f184260s = true;
            }
        }
        int indexOf = this.C.f184324b.indexOf(str);
        if (indexOf >= 0) {
            i3 = indexOf;
        }
        this.f184337i.browserModel.setSelectedIndex(i3);
        v().scrollToCurrentPosition();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 24747) {
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).onClipFinish(intent, this.f184334e.selectedMediaInfoHashMap);
        } else if (this.J && i16 == -1) {
            this.f184197m.setResult(i16, null);
            this.f184197m.finish();
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (this.C.f184259r && this.J) {
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).setData(((ISlideShowController) QRoute.api(ISlideShowController.class)).getTemp());
        }
        super.onBackPressed();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void p(View view) {
        String str;
        HashMap<String, Integer> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        int i3 = v().i();
        if (this.f184334e.selectedIndex.contains(Integer.valueOf(i3))) {
            if (this.f184334e.selectedIndex.indexOf(Integer.valueOf(i3)) >= 0 && i3 != -1 && (hashMap = this.G) != null) {
                hashMap.remove(this.C.f184324b.get(i3));
            }
        } else {
            if (i3 != -1) {
                str = this.C.f184324b.get(i3);
            } else {
                str = "";
            }
            LocalMediaInfo k3 = this.f184337i.k(str);
            if (this.K && this.C.f184324b != null && this.f184337i.l(str) == 1 && !com.tencent.mobileqq.utils.e.d(this.f184197m, P(), k3, this.J)) {
                v().I.setChecked(false);
                return;
            }
            if (i3 != -1) {
                String str2 = this.C.f184324b.get(i3);
                if (this.K || this.J) {
                    PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
                    if (photoCommonBaseData.selectedMediaInfoHashMap == null) {
                        photoCommonBaseData.selectedMediaInfoHashMap = new HashMap<>();
                    }
                    LocalMediaInfo k16 = this.f184337i.k(str2);
                    this.f184334e.selectedMediaInfoHashMap.put(str2, k16);
                    if (this.G == null) {
                        this.G = new HashMap<>();
                    }
                    if (k16 != null) {
                        this.G.put(str2, Integer.valueOf(k16.panoramaPhotoType));
                    }
                }
            }
        }
        super.p(view);
        if (N(i3)) {
            v().n(this.C.f184324b.get(i3));
        }
        if (this.J && i3 != -1 && N(i3)) {
            V(this.C.f184324b.get(i3));
        }
    }
}
