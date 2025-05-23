package com.tencent.aelight.camera.ae.album.logic;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.camera.ui.watermark.b;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.aj;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.exporter.MovieExporter;
import com.tencent.qcircle.tavcut.util.VideoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.decoder.EncoderWriter;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends AEPhotoListLogicDefault {

    /* renamed from: h0, reason: collision with root package name */
    private static final String[] f62127h0 = {"video/mp4", "video/3gpp"};
    private MovieExporter Z;

    /* renamed from: a0, reason: collision with root package name */
    private aj f62128a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f62129b0;

    /* renamed from: c0, reason: collision with root package name */
    private Dialog f62130c0;

    /* renamed from: d0, reason: collision with root package name */
    private Dialog f62131d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f62132e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f62133f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f62134g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements MovieExporter.VideoCompressListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MovieExporter.VideoCompressListener f62136a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f62137b;

        b(MovieExporter.VideoCompressListener videoCompressListener, String str) {
            this.f62136a = videoCompressListener;
            this.f62137b = str;
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
        public void onCompressCanceled() {
            FileUtils.deleteFile(this.f62137b);
            this.f62136a.onCompressCanceled();
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
        public void onCompressError(AssetExportSession assetExportSession) {
            FileUtils.deleteFile(this.f62137b);
            this.f62136a.onCompressError(assetExportSession);
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
        public void onCompressFinish(String str) {
            this.f62136a.onCompressFinish(str);
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
        public void onCompressStart() {
            this.f62136a.onCompressStart();
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
        public void onCompressing(float f16) {
            this.f62136a.onCompressing(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.album.logic.d$d, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class ViewOnClickListenerC0534d implements View.OnClickListener {
        ViewOnClickListenerC0534d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (d.this.f62131d0 != null) {
                if (d.this.Z != null) {
                    d.this.Z.cancelCompress();
                }
                d.this.f62131d0.dismiss();
                d.this.f62128a0 = null;
                d.this.f62131d0 = null;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public d(com.tencent.aelight.camera.ae.album.fragment.b bVar) {
        super(bVar);
        this.f62129b0 = 0;
        this.f62132e0 = 3000;
        this.f62133f0 = 3000;
        this.f62134g0 = false;
        ms.a.a("PhotoListCustomizationAECircle", "[AE Profiler] PhotoListCustomizationAECircle new");
    }

    private boolean A1(LocalMediaInfo localMediaInfo, int i3, int i16) {
        if (i16 != 1) {
            int i17 = this.f62129b0;
            if (i17 == 1) {
                if (this.f62123f.selectedPhotoList.size() == 1) {
                    if (i3 == 0) {
                        QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), HardCodeUtil.qqStr(R.string.y5m), 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
                    }
                    return true;
                }
                if (this.f62123f.selectedPhotoList.size() != 0) {
                    ms.a.c("PhotoListCustomizationAECircle", "[error] size > 1 && mDataType = video");
                } else if (i3 == 0) {
                    this.f62129b0 = 0;
                }
            } else if (i17 != 0) {
                ms.a.c("PhotoListCustomizationAECircle", "[error] no know mDataType~");
            } else if (i3 == 0) {
                if (((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).y(localMediaInfo)) {
                    QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), HardCodeUtil.qqStr(R.string.y5k), 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
                    return true;
                }
                if (localMediaInfo.mediaWidth >= 20 && localMediaInfo.mediaHeight >= 20) {
                    if (this.f62123f.selectedPhotoList.size() + this.f62125i.initialHasPickedNum >= this.f62123f.maxSelectNum) {
                        QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), BaseApplicationImpl.sApplication.getResources().getString(R.string.y5l, Integer.valueOf(this.f62123f.maxSelectNum)), 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
                        return true;
                    }
                } else {
                    QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), HardCodeUtil.qqStr(R.string.y5e), 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
                    return true;
                }
            }
        } else {
            int i18 = this.f62129b0;
            if (i18 == 1) {
                this.f62129b0 = 0;
            } else if (i18 != 0) {
                ms.a.c("PhotoListCustomizationAECircle", "[error] no know mDataType~");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1(boolean z16) {
        if (this.f62122e.get() == null || ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity() == null || ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().isFinishing()) {
            return;
        }
        if (z16) {
            if (this.f62131d0 == null || this.f62128a0 == null) {
                ReportDialog reportDialog = new ReportDialog(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), R.style.qZoneInputDialog);
                this.f62131d0 = reportDialog;
                reportDialog.setCancelable(false);
                this.f62131d0.setCanceledOnTouchOutside(false);
                this.f62131d0.setContentView(R.layout.dnq);
                ImageView imageView = (ImageView) this.f62131d0.findViewById(R.id.rvn);
                Button button = (Button) this.f62131d0.findViewById(R.id.rp5);
                aj x16 = x1();
                this.f62128a0 = x16;
                imageView.setImageDrawable(x16);
                button.setOnClickListener(new ViewOnClickListenerC0534d());
            }
            this.f62131d0.show();
            return;
        }
        Dialog dialog = this.f62131d0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f62131d0.dismiss();
        this.f62128a0 = null;
        this.f62131d0 = null;
    }

    private void D1(boolean z16) {
        if (this.f62122e.get() == null || ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().isFinishing()) {
            return;
        }
        if (z16) {
            if (this.f62130c0 == null) {
                ReportDialog reportDialog = new ReportDialog(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), R.style.qZoneInputDialog);
                this.f62130c0 = reportDialog;
                reportDialog.setCancelable(false);
                this.f62130c0.setCanceledOnTouchOutside(false);
                this.f62130c0.setContentView(R.layout.f168383uh);
            }
            this.f62130c0.show();
            return;
        }
        Dialog dialog = this.f62130c0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f62130c0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1() {
        er.a.c(this.f62129b0, ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), this.f62123f, true);
        D1(false);
    }

    private void t1(int i3) {
        int o16 = o(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).f62034h.p(i3));
        if (o16 != 0 && o16 != 2) {
            B1(o16);
        } else {
            L0(i3, (AEAbstractPhotoListFragment.g) ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).Q.findViewHolderForAdapterPosition(i3));
        }
    }

    private void u1(int i3) {
        if (this.f62131d0 != null) {
            return;
        }
        if (this.f62123f.selectedPhotoList.size() == 0 && this.f62125i.canPickVideo) {
            LocalMediaInfo p16 = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).f62034h.p(i3);
            int o16 = o(p16);
            if (o16 != 0) {
                if (o16 != 2) {
                    B1(o16);
                    return;
                }
                try {
                    w1(i3, p16);
                    return;
                } catch (Exception e16) {
                    ms.a.c("PhotoListCustomizationAECircle", e16.toString());
                    C1(false);
                    QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), HardCodeUtil.qqStr(R.string.y5o), 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
                    return;
                }
            }
            this.f62129b0 = 1;
            this.f62123f.selectedPhotoList.add(p16.path);
            this.f62123f.selectedIndex.add(Integer.valueOf(i3));
            this.f62123f.selectedMediaInfoHashMap.put(p16.path, p16);
            LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f62123f.albumId);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
                QAlbumUtil.sSelectItemPosMap.put(this.f62123f.albumId, linkedHashMap);
            }
            linkedHashMap.put(p16.path, Integer.valueOf(((GridLayoutManager) ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).Q.getLayoutManager()).findFirstVisibleItemPosition()));
            HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
            if (!hashMap.containsKey(p16.path)) {
                PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
                hashMap.put(p16.path, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
            }
            if (((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                ms.a.f("PhotoListCustomizationAECircle", "updateWMProps onGetLocation");
                com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().k(new a());
            }
            E1();
            this.f62123f.selectedPhotoList.clear();
            com.tencent.aelight.camera.aebase.c.f(this.f62125i.initialHasPickedNum > 0, true, 1, i3, "1");
            return;
        }
        QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), HardCodeUtil.qqStr(R.string.y5m), 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
    }

    private aj x1() {
        if (this.f62122e.get() == null) {
            return null;
        }
        aj ajVar = new aj(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity());
        ajVar.h(BaseAIOUtils.f(50.0f, ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getResources()));
        ajVar.f(true);
        ajVar.o(false);
        ajVar.r(-1);
        ajVar.e(0);
        ajVar.j(-15550475);
        ajVar.l(3);
        ajVar.E = true;
        ajVar.A = 2;
        ajVar.n(true);
        ajVar.i(0);
        ajVar.g(new e());
        return ajVar;
    }

    private String z1(LocalMediaInfo localMediaInfo) {
        String str;
        String c16 = com.tencent.usq.a.c(localMediaInfo.path);
        if (!StringUtil.isEmpty(c16)) {
            str = c16 + ".mp4";
        } else {
            String[] split = localMediaInfo.path.split("/");
            if (split.length > 0) {
                str = split[split.length - 1];
            } else {
                str = "";
            }
        }
        return ar.c.f26765b + File.separator + str;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void D(View view) {
        E1();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void E(View view) {
        QAlbumUtil.clearSelectItemInfo();
        com.tencent.mobileqq.utils.e.e();
        PresendPicMgr f16 = PresendPicMgr.f();
        if (f16 != null) {
            f16.a(1006);
        }
        Intent intent = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent();
        ArrayList<String> arrayList = this.f62123f.selectedPhotoList;
        m.e(intent, arrayList != null ? arrayList.size() : 0);
        if (!this.X.G) {
            ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().finish();
            QAlbumUtil.anim(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), false, false);
        } else {
            Intent intent2 = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent();
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
                ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).startActivity(intent2);
            } else {
                intent2.getStringExtra("PhotoConst.PLUGIN_NAME");
                String stringExtra3 = intent2.getStringExtra("PhotoConst.PLUGIN_APK");
                String stringExtra4 = intent2.getStringExtra("PhotoConst.UIN");
                if ("qzone_plugin.apk".equals(stringExtra3)) {
                    QzonePluginProxyActivity.setActivityNameToIntent(intent2, stringExtra);
                    QZoneHelper.launchQZone(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), stringExtra4, intent2, 2);
                }
            }
            ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().finish();
            QAlbumUtil.anim(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), false, false);
        }
        com.tencent.aelight.camera.ae.report.b.b().z(System.currentTimeMillis() - this.f62121d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault, com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public void I() {
        int i3;
        super.I();
        String string = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getString(R.string.fzq);
        int size = this.f62123f.selectedPhotoList.size() + this.f62125i.initialHasPickedNum;
        if (size != 0) {
            string = string + "(" + size + ")";
        }
        ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).V.setText(string);
        AEAlbumLogicData aEAlbumLogicData = this.f62125i;
        if (aEAlbumLogicData.canMixPhotoAndVideo) {
            i3 = aEAlbumLogicData.minSelectNumForMix;
        } else {
            i3 = aEAlbumLogicData.minSelectNumForNormal;
        }
        if (size < i3) {
            ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).V.setEnabled(false);
        } else {
            ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).V.setEnabled(true);
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault, com.tencent.aelight.camera.ae.album.logic.c.b
    public void e(View view, int i3, CheckBox checkBox) {
        LocalMediaInfo p16 = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).f62034h.p(i3);
        int mediaType = QAlbumUtil.getMediaType(p16);
        int i16 = p16.selectStatus;
        if (this.f62125i.canMixPhotoAndVideo || !A1(p16, mediaType, i16)) {
            super.e(view, i3, checkBox);
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase
    protected boolean h0() {
        return this.f62131d0 != null;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase
    protected void i0() {
        MovieExporter movieExporter = this.Z;
        if (movieExporter != null) {
            movieExporter.cancelCompress();
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase
    public void m0(View view, int i3) {
        if (this.f62125i.canMixPhotoAndVideo) {
            t1(i3);
        } else {
            u1(i3);
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault, com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public void n(Intent intent) {
        super.n(intent);
        String stringExtra = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent().getStringExtra(AEEditorConstants.ALBUMNAME);
        String stringExtra2 = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent().getStringExtra("albumId");
        if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
            PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
            photoCommonBaseData.albumName = stringExtra;
            photoCommonBaseData.albumId = stringExtra2;
        }
        this.f62132e0 = 3000;
        this.f62133f0 = 3000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public int o(LocalMediaInfo localMediaInfo) {
        long j3 = localMediaInfo.mDuration;
        if (j3 > 3600000 || j3 < 2000) {
            return 1;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                String extractMetadata = mediaMetadataRetriever.extractMetadata(12);
                if (parseInt <= this.f62133f0 && parseInt2 <= this.f62132e0) {
                    String[] strArr = f62127h0;
                    if (!extractMetadata.equals(strArr[0])) {
                        if (!extractMetadata.equals(strArr[1])) {
                            mediaMetadataRetriever.release();
                            return 3;
                        }
                    }
                    return 0;
                }
                mediaMetadataRetriever.release();
                return 2;
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

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase
    protected void s0(LocalMediaInfo localMediaInfo, MovieExporter.VideoCompressListener videoCompressListener) {
        MovieExporter movieExporter = this.Z;
        if (movieExporter != null) {
            movieExporter.cancelCompress();
        }
        this.Z = new MovieExporter();
        String z16 = z1(localMediaInfo);
        this.Z.compressVideo(localMediaInfo.path, z16, y1(localMediaInfo), new b(videoCompressListener, z16));
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault, com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public boolean z(List<LocalMediaInfo> list, boolean z16) {
        boolean z17 = super.z(list, z16);
        if (!this.f62134g0) {
            this.f62134g0 = true;
        }
        return z17;
    }

    private void w1(int i3, LocalMediaInfo localMediaInfo) {
        C1(true);
        s0(localMediaInfo, new c(System.currentTimeMillis(), localMediaInfo, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v1(String str, long j3) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(20));
            long parseLong2 = Long.parseLong(mediaMetadataRetriever.extractMetadata(18));
            long parseLong3 = Long.parseLong(mediaMetadataRetriever.extractMetadata(19));
            long parseLong4 = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            ms.a.c("PhotoListCustomizationAECircle", "compress finish!\n outputPath: " + str + "\n outputDuring: " + parseLong4 + "\n outputWidth: " + parseLong2 + "\n outputHeight: " + parseLong3 + "\n outputBitrate: " + parseLong + "\n outputSize: " + FileUtils.getFileSizes(str) + " bytes");
            if (parseLong4 <= j3 + 1000 && parseLong4 >= j3 - 1000) {
                return true;
            }
            ms.a.c("PhotoListCustomizationAECircle", "[checkVideoIsOK] time error");
            return false;
        } catch (NumberFormatException unused) {
            ms.a.c("PhotoListCustomizationAECircle", "[checkVideoIsOK] NumberFormatException");
            return false;
        } catch (IllegalArgumentException unused2) {
            ms.a.c("PhotoListCustomizationAECircle", "[checkVideoIsOK] IllegalArgumentException");
            return false;
        }
    }

    private EncoderWriter.OutputConfig y1(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return null;
        }
        EncoderWriter.OutputConfig outputConfig = new EncoderWriter.OutputConfig();
        dr.d a16 = dr.b.a();
        Size b16 = a16.b(VideoUtil.getVideoSize(localMediaInfo.path));
        outputConfig.VIDEO_BIT_RATE = a16.d();
        outputConfig.VIDEO_TARGET_HEIGHT = b16.getHeight();
        outputConfig.VIDEO_TARGET_WIDTH = b16.getWidth();
        return outputConfig;
    }

    private void B1(int i3) {
        if (i3 == 1) {
            QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), "\u8bf7\u9009\u62e92\u79d2\u52301\u5c0f\u65f6\u4e4b\u95f4\u7684\u89c6\u9891", 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
            return;
        }
        if (i3 == 3) {
            QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), HardCodeUtil.qqStr(R.string.y5p), 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
        } else if (i3 == 4) {
            QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), HardCodeUtil.qqStr(R.string.y5n), 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
        } else {
            if (i3 != 5) {
                return;
            }
            QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), HardCodeUtil.qqStr(R.string.y5q), 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements MovieExporter.VideoCompressListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f62139a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f62140b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f62141c;

        c(long j3, LocalMediaInfo localMediaInfo, int i3) {
            this.f62139a = j3;
            this.f62140b = localMediaInfo;
            this.f62141c = i3;
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
        public void onCompressCanceled() {
            d.this.C1(false);
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
        public void onCompressError(AssetExportSession assetExportSession) {
            d.this.C1(false);
            QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) d.this.f62122e.get()).getActivity(), R.string.y9y, 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) d.this.f62122e.get()).E);
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
        public void onCompressFinish(String str) {
            d.this.C1(false);
            if (d.this.v1(str, this.f62140b.mDuration)) {
                d.this.f62129b0 = 1;
                d.this.f62123f.selectedPhotoList.add(str);
                d.this.f62123f.selectedIndex.add(Integer.valueOf(this.f62141c));
                d.this.f62123f.selectedMediaInfoHashMap.put(str, this.f62140b);
                LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(d.this.f62123f.albumId);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                    QAlbumUtil.sSelectItemPosMap.put(d.this.f62123f.albumId, linkedHashMap);
                }
                linkedHashMap.put(this.f62140b.path, Integer.valueOf(((GridLayoutManager) ((com.tencent.aelight.camera.ae.album.fragment.b) d.this.f62122e.get()).Q.getLayoutManager()).findFirstVisibleItemPosition()));
                HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
                if (!hashMap.containsKey(this.f62140b.path)) {
                    PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = d.this.f62123f;
                    hashMap.put(this.f62140b.path, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
                }
                if (((com.tencent.aelight.camera.ae.album.fragment.b) d.this.f62122e.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || ((com.tencent.aelight.camera.ae.album.fragment.b) d.this.f62122e.get()).getActivity().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    ms.a.f("PhotoListCustomizationAECircle", "updateWMProps onGetLocation");
                    com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().k(new a());
                }
                d.this.E1();
                d.this.f62123f.selectedPhotoList.clear();
                return;
            }
            ms.a.c("PhotoListCustomizationAECircle", "[compressVideoToEdit] compress error");
            onCompressError(null);
            FileUtils.deleteFile(str);
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
        public void onCompressing(float f16) {
            if (d.this.f62131d0 == null || !d.this.f62131d0.isShowing() || d.this.f62128a0 == null) {
                return;
            }
            int i3 = (int) (f16 * 100.0f);
            d.this.f62128a0.i(i3);
            d.this.f62128a0.q(i3 + "%");
        }

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a implements b.c {
            a() {
            }

            @Override // com.tencent.aelight.camera.ae.camera.ui.watermark.b.c
            public void onGetWatermarkDict(Map<String, String> map) {
            }
        }

        @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
        public void onCompressStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements b.c {
        a() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.watermark.b.c
        public void onGetWatermarkDict(Map<String, String> map) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements aj.b {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.aj.b
        public void onProgressCompleted(aj ajVar) {
            if (QLog.isColorLevel()) {
                QLog.i("PhotoListCustomizationAECircle", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + ajVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.aj.b
        public void onProgressChanged(aj ajVar, int i3, int i16) {
        }
    }
}
