package com.tencent.aelight.camera.aebase;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes32.dex */
public class PhotoListCustomizationAECircle extends PhotoListCustomizationDefault {
    private static final int M = uq3.c.s2();
    private static final String[] N = {"video/mp4", "video/3gpp"};
    private int F;
    private Dialog G;
    private int H;
    private int I;
    private int J;
    private int K;
    private boolean L;

    public PhotoListCustomizationAECircle(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        this.F = 0;
        this.H = 3000;
        this.I = 3000;
        this.J = 3600000;
        ms.a.a("PhotoListCustomizationAECircle", "[AE Profiler] PhotoListCustomizationAECircle new");
    }

    private int G0(LocalMediaInfo localMediaInfo) {
        long j3 = localMediaInfo.mDuration;
        if (j3 > this.J || j3 < 2000) {
            return 1;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(12);
                String[] strArr = N;
                if (!extractMetadata.equals(strArr[0])) {
                    if (!extractMetadata.equals(strArr[1])) {
                        mediaMetadataRetriever.release();
                        return 3;
                    }
                }
                return 0;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
                mediaMetadataRetriever.release();
                return 5;
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private void H0(boolean z16) {
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity == null || basePhotoListActivity.isFinishing()) {
            return;
        }
        if (z16) {
            if (this.G == null) {
                ReportDialog reportDialog = new ReportDialog(this.D, R.style.qZoneInputDialog);
                this.G = reportDialog;
                reportDialog.setCancelable(false);
                this.G.setCanceledOnTouchOutside(false);
                this.G.setContentView(R.layout.f168383uh);
            }
            this.G.show();
            return;
        }
        Dialog dialog = this.G;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.G.dismiss();
    }

    private void I0() {
        er.a.c(this.F, this.D, this.f184310e, false);
        this.D.finish();
        H0(false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        AEResUtil.q0();
        super.E(intent);
        int b16 = js.a.B.b();
        if (gq.a.x(this.D.getIntent())) {
            b16 = js.a.D.b();
        }
        AEBaseReportParam.U().O0(b16, null);
        String stringExtra = this.D.getIntent().getStringExtra("intent_key_uid_for_report");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = a.a().getCurrentAccountUin();
            this.D.getIntent().putExtra("intent_key_uid_for_report", stringExtra);
        }
        AEBaseReportParam.U().s1(stringExtra);
        AEBaseReportParam.U().g1();
        AEBaseReportParam.U().h1();
        AEBaseReportParam.U().p1(com.tencent.aelight.camera.ae.config.b.e());
        AEBaseReportParam.U().E0(dr.c.b());
        String stringExtra2 = this.D.getIntent().getStringExtra(AEEditorConstants.ALBUMNAME);
        String stringExtra3 = this.D.getIntent().getStringExtra("albumId");
        if (!TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(stringExtra2)) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            photoCommonBaseData.albumName = stringExtra2;
            photoCommonBaseData.albumId = stringExtra3;
        }
        this.K = this.D.getIntent().getIntExtra(PeakConstants.BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM, 0);
        this.L = this.D.getIntent().getBooleanExtra(PeakConstants.BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO, false);
        ms.a.a("PhotoListCustomizationAECircle", "[AdditionalPick] initData---initialHasPickedNum=" + this.K + ", canPickVideo=" + this.L);
        this.H = 3000;
        this.I = 3000;
        this.J = M;
        if (!TextUtils.isEmpty(intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_FROM_QCIRCLE_SCHEME))) {
            QQToast.makeText(this.D, 0, HardCodeUtil.qqStr(R.string.ylv), 1).show();
        }
        c.h(false, "1");
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        super.G(i3, i16, intent);
        if (i16 == -1 && i3 == 10019) {
            this.D.setResult(-1, intent);
            this.D.finish();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(View view, int i3, CheckBox checkBox) {
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        int mediaType = QAlbumUtil.getMediaType(m06);
        if (m06.selectStatus != 1) {
            int i16 = this.F;
            if (i16 == 1) {
                if (this.f184310e.selectedPhotoList.size() == 1) {
                    if (mediaType == 0) {
                        QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.ynj), 0).show();
                        return;
                    }
                    return;
                } else if (this.f184310e.selectedPhotoList.size() != 0) {
                    ms.a.c("PhotoListCustomizationAECircle", "[error] size > 1 && mDataType = video");
                } else if (mediaType == 0) {
                    this.F = 0;
                }
            } else if (i16 != 0) {
                ms.a.c("PhotoListCustomizationAECircle", "[error] no know mDataType~");
            } else if (mediaType == 0) {
                if (QAlbumUtil.isGif(m06)) {
                    QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.ynh), 0).show();
                    return;
                } else if (m06.mediaWidth >= 20 && m06.mediaHeight >= 20) {
                    if (this.f184310e.selectedPhotoList.size() + this.K >= 9) {
                        QQToast.makeText(this.D, BaseApplicationImpl.sApplication.getResources().getString(R.string.yni, Integer.valueOf(9 - this.K)), 0).show();
                        return;
                    }
                } else {
                    QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.yng), 0).show();
                    return;
                }
            }
        } else {
            int i17 = this.F;
            if (i17 == 1) {
                this.F = 0;
            } else if (i17 != 0) {
                ms.a.c("PhotoListCustomizationAECircle", "[error] no know mDataType~");
            }
        }
        super.J(view, i3, checkBox);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean N(List<LocalMediaInfo> list) {
        return super.N(list);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        this.f184313i.K.setClickable(false);
        I0();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void P(View view) {
        QAlbumUtil.clearSelectItemInfo();
        com.tencent.mobileqq.utils.e.e();
        PresendPicMgr f16 = PresendPicMgr.f();
        if (f16 != null) {
            f16.a(1006);
        }
        Intent intent = this.D.getIntent();
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        m.e(intent, arrayList != null ? arrayList.size() : 0);
        if (!this.C.G) {
            this.D.finish();
            QAlbumUtil.anim(this.D, false, false);
            return;
        }
        Intent intent2 = this.D.getIntent();
        String stringExtra = intent2.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        String stringExtra2 = intent2.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
        if (stringExtra == null) {
            return;
        }
        intent2.setClassName(stringExtra2, stringExtra);
        intent2.removeExtra("PhotoConst.PHOTO_PATHS");
        intent2.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
        intent2.addFlags(603979776);
        if (!intent2.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
            this.D.startActivity(intent2);
        } else {
            intent2.getStringExtra("PhotoConst.PLUGIN_NAME");
            String stringExtra3 = intent2.getStringExtra("PhotoConst.PLUGIN_APK");
            String stringExtra4 = intent2.getStringExtra("PhotoConst.UIN");
            if ("qzone_plugin.apk".equals(stringExtra3)) {
                QzonePluginProxyActivity.setActivityNameToIntent(intent2, stringExtra);
                QZoneHelper.launchQZone(this.D, stringExtra4, intent2, 2);
            }
        }
        this.D.finish();
        QAlbumUtil.anim(this.D, false, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        this.D.startActivityForResult(intent, 10019);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void T() {
        super.T();
        String string = this.D.getString(R.string.fzq);
        int size = this.f184310e.selectedPhotoList.size();
        this.f184313i.K.setText(string + " " + size + "/" + (this.f184310e.maxSelectNum - this.K));
        if (size == 0) {
            this.f184313i.K.setBackgroundResource(R.drawable.skin_aio_album_send_button_disabled);
            this.f184313i.K.setEnabled(false);
        } else {
            this.f184313i.K.setBackgroundResource(R.drawable.f160083a4);
            this.f184313i.K.setEnabled(true);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean a(LocalMediaInfo localMediaInfo, boolean z16) {
        if (QAlbumUtil.isGif(localMediaInfo)) {
            QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.ynh), 0).show();
            return false;
        }
        String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
        if (!this.C.f184293d && mimeType != null && !"image".equals(mimeType[0])) {
            return false;
        }
        int i3 = localMediaInfo.selectStatus;
        if ((i3 == 1 && z16) || (i3 == 2 && !z16)) {
            return false;
        }
        if (i3 == 2 && z16 && this.f184310e.selectedPhotoList.size() + this.K >= 9) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C.f184299j >= 700) {
                QQToast.makeText(this.D, BaseApplicationImpl.sApplication.getResources().getString(R.string.yni, Integer.valueOf(9 - this.K)), 0).show();
                com.tencent.mobileqq.activity.photo.album.g gVar = this.C;
                gVar.f184299j = currentTimeMillis;
                gVar.f184300k = true;
            }
            return false;
        }
        this.C.f184300k = false;
        if (z16) {
            u0(localMediaInfo);
        } else {
            v0(localMediaInfo);
        }
        this.f184313i.t(!z16);
        return true;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public Intent k(View view, int i3) {
        Intent k3 = super.k(view, i3);
        k3.putExtra("choosed_num", this.f184310e.selectedPhotoList.size());
        k3.putExtra("BUNDLE_KEY_INITIAL_PICKED_NUM", this.K);
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int size = this.f184310e.mediaPathsList.size();
        int i16 = i3;
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            String str = this.f184310e.mediaPathsList.get(i18);
            LocalMediaInfo localMediaInfo = this.f184310e.allMediaInfoHashMap.get(str);
            if (QAlbumUtil.getMediaType(localMediaInfo) == 0) {
                arrayList.add(str);
                ArrayList<String> arrayList3 = this.f184310e.selectedPhotoList;
                if (arrayList3 != null && arrayList3.contains(str)) {
                    arrayList2.add(Integer.valueOf(i17));
                }
                if (localMediaInfo.position.intValue() == i3) {
                    i16 = i17;
                }
                i17++;
            }
        }
        this.f184310e.mediaPathsList = arrayList;
        k3.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        k3.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
        k3.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, arrayList2);
        if (QAlbumUtil.getMediaType(m06) == 0) {
            k3.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, i16);
        }
        return k3;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        if (this.f184310e.selectedPhotoList.size() == 0 && this.L) {
            LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
            int G0 = G0(m06);
            if (G0 == 0) {
                this.F = 1;
                this.f184310e.selectedPhotoList.add(m06.path);
                this.f184310e.selectedIndex.add(Integer.valueOf(i3));
                this.f184310e.selectedMediaInfoHashMap.put(m06.path, m06);
                LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f184310e.albumId);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                    QAlbumUtil.sSelectItemPosMap.put(this.f184310e.albumId, linkedHashMap);
                }
                linkedHashMap.put(m06.path, Integer.valueOf(this.f184313i.I.findFirstVisibleItemPosition()));
                HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
                if (!hashMap.containsKey(m06.path)) {
                    PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
                    hashMap.put(m06.path, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
                }
                I0();
                return;
            }
            if (G0 == 1) {
                QQToast.makeText(this.D, String.format(HardCodeUtil.qqStr(R.string.ynf), 2, Integer.valueOf((M / 60) / 1000)), 0).show();
                return;
            }
            if (G0 == 2) {
                QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.ynl), 0).show();
                return;
            }
            if (G0 == 3) {
                QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.ynm), 0).show();
                return;
            } else if (G0 == 4) {
                QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.ynk), 0).show();
                return;
            } else {
                if (G0 != 5) {
                    return;
                }
                QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.ynn), 0).show();
                return;
            }
        }
        QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.ynj), 0).show();
    }
}
