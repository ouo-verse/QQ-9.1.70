package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_OPERATION.PicInfo;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.HorizontalListView;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationDefault extends com.tencent.mobileqq.activity.photo.album.preview.f<h> {
    static IPatchRedirector $redirector_;
    protected i C;
    protected LocalMediaInfo D;
    protected LocalMediaInfo E;
    protected int F;

    /* renamed from: m, reason: collision with root package name */
    protected BasePhotoPreviewActivity f184197m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationDefault.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationDefault.this);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfo);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(PhotoPreviewCustomizationDefault.this.v().I.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationDefault.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PhotoPreviewCustomizationDefault.this.v().D.toggle();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationDefault.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PhotoPreviewCustomizationDefault.this.C(view, -1, new Bundle(), 2, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationDefault.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PhotoPreviewCustomizationDefault.this.v().H.setClickable(false);
                PhotoPreviewCustomizationDefault.this.J();
                LpReportInfo_pf00064.allReport(603, 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationDefault.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PhotoPreviewCustomizationDefault.this.v().f184363e.onBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public PhotoPreviewCustomizationDefault(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
            return;
        }
        this.F = -1;
        this.f184197m = (BasePhotoPreviewActivity) abstractPhotoPreviewActivity;
        i iVar = new i();
        this.f184336h = iVar;
        this.C = iVar;
    }

    private void y(Intent intent) {
        LocalMediaInfo localMediaInfo;
        if (this.E != null && (localMediaInfo = this.D) != null) {
            intent.putExtra(PeakConstants.VIDEO_EDIT_OLD_MEDIA, (Serializable) localMediaInfo);
            intent.putExtra(PeakConstants.VIDEO_EDIT_NEW_MEDIA, (Serializable) this.E);
            this.f184334e.selectedPhotoList.remove(this.E.path);
            int i3 = this.F;
            if (i3 > -1 && i3 < this.f184334e.selectedIndex.size()) {
                this.f184334e.selectedIndex.remove(this.F);
            }
        }
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    public void B(int i3, int i16, Intent intent) {
        boolean z16;
        String stringExtra;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 != -1 || intent == null || !(!intent.getBooleanExtra(PeakConstants.SEND_PICTURE_ORIGIN, false)) || (stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH")) == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable(stringExtra) { // from class: com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f184198d;

            {
                this.f184198d = stringExtra;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationDefault.this, (Object) stringExtra);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    j.a(new File(this.f184198d).getParent());
                }
            }
        }, 64, null, true);
        if (QLog.isColorLevel()) {
            QLog.i("QQAlbum", 2, "onActivityResultForMultiEdit hasEdit:" + z16 + ", picPath:" + stringExtra);
        }
        String stringExtra2 = intent.getStringExtra(PeakConstants.KEY_MULIT_EDIT_SOURTH_PATH);
        int indexOf = this.C.f184324b.indexOf(stringExtra2);
        if (indexOf >= 0) {
            if (this.C.f184325c.containsValue(stringExtra2)) {
                str = com.tencent.mobileqq.activity.photo.j.d(this.C.f184325c, stringExtra2);
            } else {
                str = stringExtra2;
            }
            this.C.f184325c.put(str, stringExtra);
            this.C.f184324b.add(indexOf, stringExtra);
            this.C.f184324b.remove(indexOf + 1);
            int indexOf2 = this.f184334e.selectedPhotoList.indexOf(stringExtra2);
            this.F = indexOf2;
            if (indexOf2 >= 0) {
                this.f184334e.selectedPhotoList.add(indexOf2, stringExtra);
                this.f184334e.selectedPhotoList.remove(this.F + 1);
            }
            this.f184197m.selectedPhotoAdapter.notifyDataSetChanged();
            RichMediaBrowserInfo richMediaBrowserInfo = new RichMediaBrowserInfo();
            PreviewPictureData previewPictureData = new PreviewPictureData();
            previewPictureData.filePath = stringExtra;
            richMediaBrowserInfo.baseData = previewPictureData;
            this.f184337i.f184341e.updateItem(richMediaBrowserInfo, indexOf);
            this.f184337i.f184341e.setSelectedIndex(indexOf);
            v().notifyDataSetChanged();
            v().scrollToCurrentPosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(View view, int i3, Bundle bundle, int i16, Intent intent) {
        int i17;
        String stringExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, view, Integer.valueOf(i3), bundle, Integer.valueOf(i16), intent);
            return;
        }
        int i19 = v().i();
        if (i19 != -1 && this.C.f184324b.size() > i19) {
            i iVar = this.C;
            iVar.f184264w = iVar.f184324b.get(i19);
            if (this.C.f184264w != null) {
                ReportController.o(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
                if (this.C.f184258q) {
                    Intent editPicActivityIntent = ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toEditPicActivityIntent(this.f184197m, intent, this.C.f184264w, i16, bundle);
                    editPicActivityIntent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184335f).f184248f);
                    i iVar2 = this.C;
                    if (!iVar2.B) {
                        editPicActivityIntent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, iVar2.E);
                    }
                    if (i3 == -1) {
                        this.f184197m.startActivity(editPicActivityIntent);
                    } else {
                        this.f184197m.startActivityForResult(editPicActivityIntent, i3);
                    }
                    if (v().C != null) {
                        v().C.setClickable(false);
                    }
                    Intent intent2 = this.f184197m.getIntent();
                    if (intent2 != null && intent2.hasExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_EDITBTN_REPORT_ACTION_NAME) && (stringExtra = intent2.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_EDITBTN_REPORT_ACTION_NAME)) != null) {
                        ReportController.o(null, "CliOper", "", "", stringExtra, stringExtra, 0, 0, "", "", "", "");
                    }
                    if (A() && (i17 = this.C.G) > 0) {
                        StringBuilder sb5 = new StringBuilder();
                        ArrayList<String> arrayList = this.f184334e.selectedPhotoList;
                        if (arrayList != null) {
                            i18 = arrayList.size();
                        }
                        sb5.append(i18);
                        sb5.append("");
                        ReportController.o(null, "dc00898", "", "", "0X800A06D", "0X800A06D", i17, 0, sb5.toString(), "", "", "");
                    }
                }
                LpReportInfo_pf00064.allReport(603, 4, 1);
            }
        }
    }

    protected void D(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        int indexOf = this.f184334e.selectedIndex.indexOf(Integer.valueOf(i3));
        if (indexOf >= 0) {
            v().I.setChecked(false);
            this.f184334e.selectedIndex.remove(indexOf);
            if (i3 != -1) {
                this.f184334e.selectedPhotoList.remove(this.C.f184324b.get(i3));
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
        }
        g();
        if (this.f184334e.selectedIndex.size() == 0) {
            i iVar3 = this.C;
            if (!iVar3.B) {
                iVar3.D = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        if (this.f184334e.selectedPhotoList.size() >= this.f184334e.maxSelectNum) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C.f184328f >= 700) {
                QQToast.makeText(this.f184197m, v().j(), 1000).show();
                i iVar = this.C;
                iVar.f184328f = currentTimeMillis;
                if (iVar.F) {
                    ReportController.o(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
                }
            }
            v().I.setChecked(false);
            return;
        }
        if (i3 != -1) {
            String str = this.C.f184324b.get(i3);
            if (((h) this.f184335f).f184248f == 2 && F()) {
                return;
            }
            if (this.f184197m.getIntent().getBooleanExtra(PeakConstants.IS_SEND_GIF_SIZE_LIMIT, false) && BaseImageUtil.isGifFile(str) && FileUtils.getFileSizes(str) > 3145728) {
                QQToast.makeText(this.f184197m, "\u56fe\u7247\u6587\u4ef6\u8fc7\u5927", 0).show();
                v().I.setChecked(false);
                return;
            }
            String str2 = this.C.f184324b.get(i3);
            this.f184334e.selectedPhotoList.add(str2);
            HashMap<String, PhotoSendParams> hashMap = this.C.f184252k;
            if (hashMap != null) {
                PhotoSendParams photoSendParams = hashMap.get(str2);
                HashMap<String, PhotoSendParams> hashMap2 = this.C.f184253l;
                if (hashMap2 != null && photoSendParams != null) {
                    hashMap2.put(str2, photoSendParams);
                }
            }
            HashMap<String, PicInfo> hashMap3 = this.C.f184254m;
            if (hashMap3 != null) {
                PicInfo picInfo = hashMap3.get(str2);
                HashMap<String, PicInfo> hashMap4 = this.C.f184255n;
                if (hashMap4 != null && picInfo != null) {
                    hashMap4.put(str2, picInfo);
                }
            }
            this.f184334e.selectedIndex.add(Integer.valueOf(i3));
            v().n(str2);
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return false;
    }

    public void G(Intent intent, boolean z16, ArrayList<String> arrayList) {
        LocalMediaInfo k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, intent, Boolean.valueOf(z16), arrayList);
            return;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str = arrayList.get(i16);
            if (!ImageManager.isNetworkUrl(str)) {
                if (this.f184337i.l(str) == 1 && (k3 = this.f184337i.k(str)) != null) {
                    SendVideoInfo sendVideoInfo = new SendVideoInfo();
                    sendVideoInfo.fileSize = k3.fileSize;
                    sendVideoInfo.duration = k3.mDuration;
                    hashMap.put(Integer.valueOf(i3), sendVideoInfo);
                }
                i3++;
            }
        }
        try {
            if (!hashMap.isEmpty()) {
                intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "put extra Exception");
            }
        }
        if (z16) {
            ((IAlbumUtils) QRoute.api(IAlbumUtils.class)).sendPhoto(this.f184197m, intent, arrayList, this.C.f184253l, ((h) this.f184335f).f184248f, true);
            this.f184197m.setResult(-1);
            this.f184197m.finish();
            return;
        }
        ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).sendPhoto(this.f184197m, intent, arrayList, ((h) this.f184335f).f184248f, this.C.f184256o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return true;
    }

    protected void I(TextView textView) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) textView);
            return;
        }
        Resources resources = this.f184197m.getResources();
        Iterator<String> it = this.f184334e.selectedPhotoList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!QAlbumUtil.isNetUrl(next) && this.f184337i.l(next) == 1) {
                textView.setText(resources.getString(com.tencent.mobileqq.activity.photo.d.f184452e));
            }
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
        String e16 = j.e(this.f184197m, j.f(photoCommonBaseData.selectedPhotoList, photoCommonBaseData.allMediaInfoHashMap, false, this.C.f184253l, photoCommonBaseData.selectedMediaInfoHashMap));
        if (this.f184334e.selectedPhotoList.size() != 0 && !e16.equals("0")) {
            string = resources.getString(com.tencent.mobileqq.activity.photo.d.f184452e) + "(\u5171" + e16 + ")";
        } else {
            string = resources.getString(com.tencent.mobileqq.activity.photo.d.f184452e);
        }
        textView.setText(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (v().C != null) {
            i iVar = this.C;
            if (iVar.f184258q && (!TextUtils.isEmpty(iVar.f184266y) || !TextUtils.isEmpty(this.C.f184267z))) {
                v().C.performClick();
            }
        }
        v().m();
        Intent intent = this.f184197m.getIntent();
        if (this.C.f184256o) {
            v().f184365h.setVisibility(4);
        }
        G(intent, this.f184334e.containNetImage(), v().m());
    }

    public boolean K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return false;
    }

    protected void L() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        float fontLevel = 16.0f / FontSettingManager.getFontLevel();
        if (this.f184197m.getResources().getDisplayMetrics().densityDpi < 400 && !GlobalDisplayMetricsManager.needAdjustDensity(this.f184197m)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (fontLevel < 1.0f || z16) {
            if (z16) {
                fontLevel *= 0.7f;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "need scale,reqWidth:" + v().M + " scale:" + fontLevel);
            }
            if (v().f184367m != null) {
                for (int i3 = 0; i3 < v().f184367m.getChildCount(); i3++) {
                    View childAt = v().f184367m.getChildAt(i3);
                    childAt.setScaleX(fontLevel);
                    childAt.setScaleY(fontLevel);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (i3 == v().f184367m.getChildCount() - 1) {
                        marginLayoutParams.rightMargin = (int) (marginLayoutParams.rightMargin * fontLevel);
                    } else {
                        int i16 = (int) (marginLayoutParams.leftMargin * fontLevel);
                        marginLayoutParams.leftMargin = i16;
                        if (z16 && fontLevel < 1.0f) {
                            marginLayoutParams.leftMargin = (int) (i16 * fontLevel);
                        }
                    }
                    childAt.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        int i3 = ((h) this.f184335f).f184248f;
        if (i3 != 0) {
            if (i3 == 2) {
                if (v().G != null) {
                    I(v().G);
                }
                if (v().F != null) {
                    v().F.setChecked(true);
                    return;
                }
                return;
            }
            return;
        }
        if (v().G != null) {
            v().G.setText(this.f184197m.getString(com.tencent.mobileqq.activity.photo.d.f184452e));
        }
        if (v().F != null) {
            v().F.setChecked(false);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.a();
        Resources resources = this.f184197m.getResources();
        if (!((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("talkback_fix_enable") && v().J != null && v().I != null) {
            v().J.setAccessibilityDelegate(new b());
        }
        v().M = resources.getDisplayMetrics().widthPixels;
        v().N = resources.getDisplayMetrics().heightPixels;
        this.f184197m.selectedPhotoListView = (HorizontalListView) v().f184366i.findViewById(R.id.li_);
        this.f184197m.selectedPhotoListDivider = v().f184366i.findViewById(R.id.li8);
        this.f184197m.initSelectedPhotoAdapter(this, this.f184334e.selectedPhotoList);
        if (A()) {
            HorizontalListView horizontalListView = this.f184197m.selectedPhotoListView;
            if (horizontalListView != null) {
                horizontalListView.setVisibility(0);
            }
            View view = this.f184197m.selectedPhotoListDivider;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        if (this.C.f184323a) {
            if (v().f184365h != null) {
                v().f184365h.setVisibility(0);
            }
            if (v().f184366i != null) {
                v().f184366i.setVisibility(0);
            }
        }
        if (v().D != null) {
            i iVar = this.C;
            if (iVar.A && iVar.f184255n.size() == 0) {
                v().D.setVisibility(0);
                v().E.setVisibility(0);
                v().D.setOnCheckedChangeListener(v());
                v().E.setOnClickListener(new c());
                v().D.setContentDescription("\u95ea\u7167");
                v().E.setContentDescription("\u95ea\u7167");
            }
        }
        if (v().F != null) {
            v().F.setOnCheckedChangeListener(v());
            if (this.C.f184257p) {
                v().F.setVisibility(0);
            } else {
                v().F.setVisibility(8);
            }
        }
        if (v().G != null) {
            if (this.C.f184257p) {
                v().G.setVisibility(0);
            } else {
                v().G.setVisibility(8);
            }
        }
        if (v().C != null) {
            if (this.C.f184258q) {
                v().C.setVisibility(0);
            } else {
                v().C.setVisibility(8);
            }
            v().C.setOnClickListener(new d());
        }
        if (v().H != null) {
            v().H.setOnClickListener(new e());
        }
        g();
        if (v().I != null && (this.C.f184263v || this.f184334e.isSingleMode)) {
            v().I.setVisibility(8);
        }
        if (v().F != null) {
            if (this.C.f184263v || this.f184334e.isSingleMode) {
                v().F.setVisibility(8);
            }
            if (this.C.f184261t == 1001) {
                v().F.setVisibility(8);
            }
        }
        if (v().J != null && (this.C.f184263v || this.f184334e.isSingleMode)) {
            v().J.setVisibility(8);
        }
        if (v().G != null) {
            if (this.C.f184263v || this.f184334e.isSingleMode) {
                v().G.setVisibility(8);
            }
            if (this.C.f184261t == 1001) {
                v().G.setVisibility(8);
            }
        }
        L();
        if (v().C != null) {
            BaseAIOUtils.g(v().C, (int) ((this.f184197m.getResources().getDisplayMetrics().density * 10.0f) + 0.5f));
        }
        View findViewById = v().f184365h.findViewById(R.id.t2t);
        if (findViewById != null) {
            findViewById.setOnClickListener(new f());
        }
        if (QQTheme.isNowSimpleUI()) {
            ColorStateList colorStateList = this.f184197m.getResources().getColorStateList(R.color.f156997h4);
            if (v().G != null) {
                v().G.setTextColor(colorStateList);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.f184197m.getSystemService("layout_inflater");
        View view = null;
        if (layoutInflater != null) {
            view = layoutInflater.inflate(R.layout.gzs, (ViewGroup) null);
            if (TokenResUtils.useTokenRes3()) {
                ((NumberCheckBox) view.findViewById(R.id.iml)).setBackgroundResource(R.drawable.qui_common_check_box_with_text_white_border);
            }
        }
        return view;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.f184197m.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            return null;
        }
        View inflate = layoutInflater.inflate(R.layout.gzq, (ViewGroup) null);
        if (TokenResUtils.useTokenRes4()) {
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ccu);
            CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.h1y);
            if (checkBox != null && checkBox2 != null) {
                Drawable drawable = this.f184197m.getDrawable(R.drawable.qui_common_check_box_white_border);
                Drawable drawable2 = this.f184197m.getDrawable(R.drawable.qui_common_check_box_white_border);
                int dpToPx = ViewUtils.dpToPx(20.0f);
                drawable.setBounds(0, 0, dpToPx, dpToPx);
                drawable2.setBounds(0, 0, dpToPx, dpToPx);
                checkBox.setButtonDrawable((Drawable) null);
                checkBox2.setButtonDrawable((Drawable) null);
                checkBox.setCompoundDrawables(drawable, null, null, null);
                checkBox2.setCompoundDrawables(drawable2, null, null, null);
            }
        }
        return inflate;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void doOnDestroy() {
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        i iVar = this.C;
        if (iVar.f184330h == 103 && (arrayList = iVar.f184324b) != null) {
            try {
                String str = arrayList.get(0);
                if (!TextUtils.isEmpty(str)) {
                    String str2 = str + PeakConstants.SHORT_VIDEO_CAMERA_PREVIEW_CACHE;
                    ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
                    Bitmap f16 = imageCacheHelper.f(str2);
                    imageCacheHelper.m(str2);
                    if (f16 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQAlbum", 2, "recycle short video preview cache");
                        }
                        if (!f16.isRecycled()) {
                            f16.recycle();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        super.doOnResume();
        SmallScreenUtils.A(BaseApplication.getContext(), true);
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
        if (v().C != null) {
            v().C.setClickable(true);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void g() {
        String string;
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Resources resources = this.f184197m.getResources();
        if (this.C.f184257p) {
            string = resources.getString(R.string.cvd);
        } else {
            string = resources.getString(R.string.ctx);
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
        String str = photoCommonBaseData.customSendBtnText;
        if (str != null) {
            string = str;
        }
        ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
        if (arrayList != null && arrayList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (!this.C.f184263v && !this.f184334e.isSingleMode) {
                if (v().H != null) {
                    v().H.setEnabled(true);
                    v().H.setText(string + "(" + this.f184334e.selectedPhotoList.size() + ")");
                }
                M();
            } else if (v().H != null) {
                v().H.setEnabled(true);
                v().H.setText(string);
            }
        } else {
            if (v().H != null) {
                v().H.setText(string);
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
            M();
        }
        boolean contains = this.f184334e.selectedIndex.contains(Integer.valueOf(v().i()));
        if (v().C != null) {
            if (v().i() != -1 && this.C.f184324b.size() > v().i()) {
                if (this.f184337i.l(this.C.f184324b.get(v().i())) == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                boolean isNetUrl = QAlbumUtil.isNetUrl(this.C.f184324b.get(v().i()));
                if (z16 && !contains) {
                    v().C.setEnabled(false);
                } else if (z18) {
                    v().C.setEnabled(K());
                } else {
                    v().C.setEnabled(!isNetUrl);
                }
            } else {
                v().C.setEnabled(false);
            }
        }
        if (this.f184197m.selectedPhotoAdapter != null) {
            if (A()) {
                HorizontalListView horizontalListView = this.f184197m.selectedPhotoListView;
                if (horizontalListView != null && horizontalListView.getVisibility() == 4) {
                    this.f184197m.selectedPhotoListDivider.setVisibility(0);
                    this.f184197m.selectedPhotoListView.setVisibility(0);
                }
                this.f184197m.selectedPhotoAdapter.notifyDataSetChanged();
            } else {
                BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
                if (basePhotoPreviewActivity.selectedPhotoListView != null) {
                    basePhotoPreviewActivity.selectedPhotoListDivider.setVisibility(4);
                    this.f184197m.selectedPhotoListView.setVisibility(4);
                }
            }
        }
        if (v().I != null) {
            if (!contains && this.f184334e.selectedPhotoList.size() >= this.f184334e.maxSelectNum) {
                v().I.setActivated(true);
            } else {
                v().I.setActivated(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            super.h();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void j(Intent intent) {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        if (((h) this.f184335f).f184249h == null && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            ((h) this.f184335f).f184249h = peekAppRuntime.getAccount();
        }
        this.C.f184331i = intent.getBooleanExtra(PeakConstants.USE_URL_PATH, false);
        super.j(intent);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        this.C.C = from.decodeBool("showFlashPic" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), true);
        this.C.A = intent.getBooleanExtra("showFlashPic", false);
        this.C.E = intent.getIntExtra(PeakConstants.SEND_BUSINESS_TYPE, -1);
        this.C.f184259r = intent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
        this.C.f184252k = (HashMap) intent.getSerializableExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM);
        this.C.f184254m = (HashMap) intent.getSerializableExtra(PeakConstants.PHOTO_INFOS);
        this.C.f184325c = (HashMap) intent.getSerializableExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP);
        i iVar = this.C;
        if (iVar.f184325c == null) {
            iVar.f184325c = new HashMap<>();
        }
        this.C.f184255n = new HashMap<>(1);
        i iVar2 = this.C;
        HashMap<String, PicInfo> hashMap = iVar2.f184254m;
        if (hashMap != null) {
            iVar2.f184255n.putAll(hashMap);
        }
        this.C.f184253l = new HashMap<>(1);
        i iVar3 = this.C;
        HashMap<String, PhotoSendParams> hashMap2 = iVar3.f184252k;
        if (hashMap2 != null) {
            iVar3.f184253l.putAll(hashMap2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("aioSendPhotos", 2, "mCanUseURL:" + this.C.f184331i + " mSelectedSendParams size:" + this.C.f184253l.size());
        }
        this.f184334e.filter.videoSizeLimit = intent.getLongExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_SIZE, -1L);
        this.C.f184256o = intent.getBooleanExtra(PeakConstants.IS_WAIT_DEST_RESULT, false);
        this.C.f184257p = intent.getBooleanExtra(PeakConstants.IS_SEND_TO_AIO, false);
        i iVar4 = this.C;
        if (!iVar4.f184258q) {
            iVar4.f184258q = intent.getBooleanExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, false);
        }
        if (PhotoCommonBaseData.FROM_QZONE_PHOTO_LIST.equals(this.C.f184326d)) {
            this.C.f184258q = false;
        }
        i iVar5 = this.C;
        if (iVar5.f184258q) {
            iVar5.f184265x = (HashMap) intent.getSerializableExtra("PasterConstants.pasters_data");
            this.C.f184266y = intent.getStringExtra("PasterConstants.paster_id");
            this.C.f184267z = intent.getStringExtra("PasterConstants.paster_cate_id");
        }
        this.C.f184261t = intent.getIntExtra("uintype", -1);
        this.C.f184262u = intent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
        this.C.f184263v = intent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
        ((h) this.f184335f).f184248f = intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
        this.C.G = intent.getIntExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 0);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void k(int i3) {
        RichMediaBaseData richMediaBaseData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, " onItemSelected position=" + i3);
        }
        super.k(i3);
        RichMediaBrowserInfo item = v().getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null) {
            if (richMediaBaseData.getType() == 100) {
                v().f184364f.setContentDescription("\u7167\u7247" + (i3 + 1));
                return;
            }
            if (item.baseData.getType() == 101) {
                BubblePopupWindow bubblePopupWindow = this.f184197m.popup;
                if (bubblePopupWindow != null) {
                    bubblePopupWindow.dismiss();
                }
                v().f184364f.setContentDescription("\u89c6\u9891" + (i3 + 1));
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (i3 == 10000) {
            B(i3, i16, intent);
        } else {
            j.h(this.f184197m, i3, i16, intent, this.C.f184262u, ((h) this.f184335f).f184249h);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
        if (basePhotoPreviewActivity == null) {
            return;
        }
        Intent intent = basePhotoPreviewActivity.getIntent();
        intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, this.C.E);
        if (PhotoCommonBaseData.FROM_PHOTO_LIST.equals(this.C.f184326d)) {
            BasePhotoPreviewActivity basePhotoPreviewActivity2 = this.f184197m;
            intent.setClass(basePhotoPreviewActivity2, basePhotoPreviewActivity2.getPhotoListActivityClass());
            intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184335f).f184248f);
            if (this.f184334e.isSingleMode) {
                intent.removeExtra("PhotoConst.PHOTO_PATHS");
            } else {
                y(intent);
                intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184334e.selectedPhotoList);
                intent.putExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP, this.C.f184325c);
            }
            intent.putExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM, this.C.f184253l);
            intent.putExtra(PeakConstants.PHOTO_INFOS, this.C.f184255n);
            this.f184197m.startActivity(intent);
        } else if (PhotoCommonBaseData.FROM_QZONE_PHOTO_LIST.equals(this.C.f184326d)) {
            Intent intent2 = new Intent();
            intent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184334e.selectedPhotoList);
            intent2.putExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM, this.C.f184253l);
            intent2.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184335f).f184248f);
            intent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f184334e.selectedMediaInfoHashMap);
            this.f184197m.setResult(-1, intent2);
        }
        if (intent.getBooleanExtra(QAlbumConstants.KEEP_SELECTED_STATUS_AFTER_FINISH, false)) {
            Intent intent3 = new Intent();
            y(intent3);
            intent3.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184334e.selectedPhotoList);
            intent3.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.f184334e.selectedIndex);
            intent3.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184335f).f184248f);
            intent3.putExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP, this.C.f184325c);
            this.f184197m.setResult(-1, intent3);
        }
        this.f184197m.finish();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void p(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
            return;
        }
        this.f184197m.getResources();
        int i3 = v().i();
        if (this.f184334e.selectedIndex.contains(Integer.valueOf(i3))) {
            D(i3);
        } else {
            E(i3);
        }
        LpReportInfo_pf00064.allReport(603, 2);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void q(CompoundButton compoundButton, boolean z16) {
        String stringExtra;
        boolean z17;
        String stringExtra2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, compoundButton, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            if (v().D != null) {
                v().D.setChecked(!z16);
            }
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
            if (j.b(photoCommonBaseData.selectedPhotoList, ((h) this.f184335f).f184250i, photoCommonBaseData.allMediaInfoHashMap, true, photoCommonBaseData.selectedMediaInfoHashMap) > 0) {
                BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
                QQToast.makeText(basePhotoPreviewActivity, basePhotoPreviewActivity.getResources().getString(R.string.cui), 0).show(this.f184197m.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                ((h) this.f184335f).f184248f = 0;
                v().G.setText(this.f184197m.getString(com.tencent.mobileqq.activity.photo.d.f184452e));
                v().F.setChecked(false);
                return;
            }
            if (this.f184334e.selectedPhotoList.isEmpty()) {
                int i3 = v().i();
                if (i3 >= 0 && i3 < this.C.f184324b.size()) {
                    long length = new File(this.C.f184324b.get(i3)).length();
                    if (this.f184337i.l(this.C.f184324b.get(i3)) == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17 && length > ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit()) {
                        BasePhotoPreviewActivity basePhotoPreviewActivity2 = this.f184197m;
                        QQToast.makeText(basePhotoPreviewActivity2, basePhotoPreviewActivity2.getResources().getString(R.string.cui), 0).show(this.f184197m.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        ((h) this.f184335f).f184248f = 0;
                        v().G.setText(this.f184197m.getString(com.tencent.mobileqq.activity.photo.d.f184452e));
                        v().F.setChecked(false);
                        return;
                    }
                    v().o("", 1);
                    this.f184334e.selectedPhotoList.add(this.C.f184324b.get(i3));
                    this.f184334e.selectedIndex.add(Integer.valueOf(i3));
                    v().F.setChecked(true);
                    ((h) this.f184335f).f184248f = 2;
                    I(v().G);
                    g();
                    Intent intent = this.f184197m.getIntent();
                    if (intent != null && intent.hasExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_RAWCHECKBOX_REPORT_ACTION_NAME) && (stringExtra2 = intent.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_RAWCHECKBOX_REPORT_ACTION_NAME)) != null) {
                        ReportController.o(null, "CliOper", "", "", stringExtra2, stringExtra2, 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
                return;
            }
            v().F.setChecked(true);
            ((h) this.f184335f).f184248f = 2;
            I(v().G);
            Intent intent2 = this.f184197m.getIntent();
            if (intent2 != null && intent2.hasExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_RAWCHECKBOX_REPORT_ACTION_NAME) && (stringExtra = intent2.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_RAWCHECKBOX_REPORT_ACTION_NAME)) != null) {
                ReportController.o(null, "CliOper", "", "", stringExtra, stringExtra, 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        if (v().F != null) {
            v().F.setChecked(false);
        }
        if (v().G != null) {
            ((h) this.f184335f).f184248f = 0;
            v().G.setText(this.f184197m.getString(com.tencent.mobileqq.activity.photo.d.f184452e));
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void r() {
        BubblePopupWindow bubblePopupWindow;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        super.r();
        BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
        if (basePhotoPreviewActivity != null && (bubblePopupWindow = basePhotoPreviewActivity.popup) != null) {
            bubblePopupWindow.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public Class s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Class) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.f184197m.getPhotoListActivityClass();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int i3 = this.C.G;
        if (i3 == 1) {
            return 141;
        }
        if (i3 != 2 && i3 != 3) {
            return 99;
        }
        return 143;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.preview.e
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public h u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }

    public void z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            v().f184366i.setVisibility(i3);
        }
    }
}
