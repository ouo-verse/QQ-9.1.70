package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes33.dex */
public class PhotoListCustomizationGuildFeed extends PhotoListCustomizationAIO {

    /* renamed from: c0, reason: collision with root package name */
    public static final String f179634c0 = "com.tencent.mobileqq.activity.aio.photo.PhotoListCustomizationGuildFeed";

    /* renamed from: d0, reason: collision with root package name */
    public static final Long f179635d0 = 250000000L;
    private int U;
    private boolean V;
    private int W;
    private int X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f179636a0;

    /* renamed from: b0, reason: collision with root package name */
    private QQProgressDialog f179637b0;

    PhotoListCustomizationGuildFeed(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        this.U = 0;
        this.V = ABTestUtil.getVideoEditABTest();
        this.W = 0;
        this.Y = false;
        this.Z = false;
        this.f179636a0 = false;
    }

    private void b1(final ArrayList<String> arrayList) {
        if (this.f179637b0 == null) {
            BasePhotoListActivity basePhotoListActivity = this.D;
            this.f179637b0 = new QQProgressDialog(basePhotoListActivity, basePhotoListActivity.getTitleBarHeight());
        }
        this.f179637b0.setMessage(R.string.f139090ab);
        this.f179637b0.setCancelable(false);
        this.f179637b0.show();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoListCustomizationGuildFeed.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (PhotoListCustomizationGuildFeed.this.Y && gg1.a.a(str)) {
                        z16 = true;
                    }
                    LocalMediaInfo localMediaInfo = PhotoListCustomizationGuildFeed.this.f184310e.selectedMediaInfoHashMap.get(str);
                    LocalMediaInfo localMediaInfo2 = PhotoListCustomizationGuildFeed.this.f184310e.allMediaInfoHashMap.get(str);
                    if ((localMediaInfo2 != null && localMediaInfo2.mMediaType == 1) || (localMediaInfo != null && localMediaInfo.mMediaType == 1)) {
                        d.a aVar = new d.a();
                        com.tencent.mobileqq.shortvideo.util.d.a(str, aVar);
                        if (localMediaInfo2 != null) {
                            int[] iArr = aVar.f288248a;
                            localMediaInfo2.rotation = iArr[2];
                            localMediaInfo2.mediaWidth = iArr[0];
                            localMediaInfo2.mediaHeight = iArr[1];
                        }
                        if (localMediaInfo != null) {
                            int[] iArr2 = aVar.f288248a;
                            localMediaInfo.rotation = iArr2[2];
                            localMediaInfo.mediaWidth = iArr2[0];
                            localMediaInfo.mediaHeight = iArr2[1];
                        }
                    }
                }
                PhotoListCustomizationGuildFeed.this.p1(z16);
            }
        }, 64, null, true);
    }

    private void c1(com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3, int i16) {
        int g16 = g1();
        if (g16 == 0) {
            aVar.F.setClickable(true);
            aVar.F.setAlpha(1.0f);
            aVar.J.setVisibility(0);
            aVar.M.setVisibility(0);
            return;
        }
        if (g16 != i16 && this.f179636a0) {
            aVar.F.setAlpha(0.3f);
            aVar.F.setClickable(false);
            aVar.J.setVisibility(8);
            aVar.M.setVisibility(8);
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        int i17 = m06.selectStatus;
        int size = this.f184310e.selectedPhotoList.size();
        int i18 = this.f184310e.maxSelectNum;
        if (i17 == 2 && (size >= i18 || ((k1(m06.mMimeType) && size - this.W >= this.U) || (!k1(m06.mMimeType) && this.W >= this.X)))) {
            aVar.F.setAlpha(0.3f);
            aVar.F.setClickable(false);
            aVar.J.setVisibility(8);
            aVar.M.setVisibility(8);
            return;
        }
        aVar.F.setAlpha(1.0f);
        aVar.F.setClickable(true);
        aVar.J.setVisibility(0);
        aVar.M.setVisibility(0);
    }

    private boolean d1(LocalMediaInfo localMediaInfo) {
        if (QAlbumUtil.isGif(localMediaInfo)) {
            try {
                com.tencent.mobileqq.activity.aio.stickerbubble.frame.c cVar = new com.tencent.mobileqq.activity.aio.stickerbubble.frame.c(new File(localMediaInfo.path), false);
                long frameCount = cVar.getFrameCount() * localMediaInfo.mediaHeight * localMediaInfo.mediaWidth;
                if (cVar.getFrameCount() <= 300) {
                    if (frameCount > f179635d0.longValue()) {
                    }
                }
                return false;
            } catch (IOException e16) {
                QLog.e("PhotoListCustomizationGuildFeed", 1, "checkSizeSafe error: " + e16);
                return false;
            }
        }
        if (localMediaInfo.fileSize >= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV || localMediaInfo.mediaHeight > 30000 || localMediaInfo.mediaWidth > 30000) {
            return false;
        }
        return true;
    }

    private Intent e1() {
        Intent intent = this.D.getIntent();
        Bundle extras = intent.getExtras();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        ArrayList<String> arrayList2 = photoCommonBaseData.selectedPhotoList;
        HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData.selectedMediaInfoHashMap;
        HashMap<String, LocalMediaInfo> hashMap2 = photoCommonBaseData.allMediaInfoHashMap;
        boolean z16 = ((com.tencent.mobileqq.activity.photo.album.h) this.f184311f).f184248f == 2;
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            String next = it.next();
            LocalMediaInfo localMediaInfo = hashMap.get(next);
            if (localMediaInfo == null) {
                localMediaInfo = hashMap2.get(next);
            }
            if (localMediaInfo != null) {
                localMediaInfo.isRwa = z16;
                arrayList.add(localMediaInfo);
            }
        }
        extras.putParcelableArrayList(PeakConstants.GUILD_ALBUM_SELECT_PHOTOS, arrayList);
        intent.putExtras(extras);
        return intent;
    }

    private List<Integer> f1(int i3) {
        ArrayList arrayList = new ArrayList();
        List<LocalMediaInfo> n06 = this.f184313i.Q.n0();
        if (n06 != null && n06.size() > 0) {
            for (int i16 = 0; i16 < n06.size(); i16++) {
                LocalMediaInfo localMediaInfo = n06.get(i16);
                if (localMediaInfo != null && n06.get(i16).mMediaType == i3 && localMediaInfo.selectStatus == 2) {
                    arrayList.add(Integer.valueOf(i16));
                }
            }
        }
        return arrayList;
    }

    private int g1() {
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (arrayList.size() > 0) {
            return QAlbumUtil.getMediaType(arrayList.get(0)) == 0 ? 1 : 2;
        }
        return 0;
    }

    private void j1() {
        boolean booleanExtra = e1().getBooleanExtra("key_guild_feed_publish", false);
        this.Z = booleanExtra;
        if (booleanExtra) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            if (photoCommonBaseData.filter == null) {
                photoCommonBaseData.filter = MediaFileFilter.getFilter(photoCommonBaseData.showMediaType);
            }
            this.f184310e.filter.videoMaxDuration = -1L;
        }
    }

    private boolean k1(String str) {
        String[] mimeType = MimeHelper.getMimeType(str);
        if (mimeType != null) {
            return "video".equals(mimeType[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l1(LocalMediaInfo localMediaInfo, boolean z16) {
        return Boolean.valueOf(super.a(localMediaInfo, z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean m1(View view, int i3, CheckBox checkBox) {
        super.J(view, i3, checkBox);
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        Intent e16 = e1();
        e16.putExtra(PeakConstants.GUILD_ALBUM_QUALITY, ((com.tencent.mobileqq.activity.photo.album.h) this.f184311f).f184248f == 2);
        this.D.setResult(-1, e16);
        this.D.finish();
        QAlbumUtil.anim(this.D, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(final boolean z16) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoListCustomizationGuildFeed.2
            @Override // java.lang.Runnable
            public void run() {
                if (((PhotoListCustomizationDefault) PhotoListCustomizationGuildFeed.this).D.isFinishing() || ((PhotoListCustomizationDefault) PhotoListCustomizationGuildFeed.this).D.isDestroyed()) {
                    return;
                }
                PhotoListCustomizationGuildFeed.this.f179637b0.dismiss();
                if (!z16) {
                    PhotoListCustomizationGuildFeed.this.o1();
                } else {
                    ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptQrCodeSendToast();
                }
            }
        });
    }

    private void r1(int i3) {
        int i16;
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity == null || (i16 = this.X) < 1 || i3 != i16) {
            return;
        }
        com.tencent.mobileqq.guild.util.qqui.g.f(-1, String.format(basePhotoListActivity.getString(R.string.w2l), Integer.valueOf(this.X)));
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public com.tencent.mobileqq.activity.photo.album.photolist.a A(com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3) {
        com.tencent.mobileqq.activity.photo.album.photolist.a A = super.A(aVar, i3);
        c1(aVar, i3, 2);
        return A;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public boolean D0() {
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        boolean z16;
        super.E(intent);
        this.f184310e.customSendBtnText = this.D.getString(R.string.cud);
        this.C.A = false;
        this.X = e1().getIntExtra("key_guild_feed_publish_max_photo", this.f184310e.maxSelectNum);
        this.f179636a0 = e1().getBooleanExtra("key_guild_feed_need_mutex_media", false);
        this.Y = e1().getBooleanExtra("key_guild_check_qrcode_image", false);
        try {
            String str = "select_photos_from_" + this.P.f179557e;
            ArrayList arrayList = (ArrayList) this.P.b().get(str);
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            ArrayList<String> arrayList2 = photoCommonBaseData.selectedPhotoList;
            HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData.selectedMediaInfoHashMap;
            if (arrayList == null || arrayList2 == null) {
                z16 = false;
            } else {
                arrayList2.clear();
                Iterator it = arrayList.iterator();
                z16 = false;
                while (it.hasNext()) {
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) it.next();
                    localMediaInfo.selectStatus = 1;
                    arrayList2.add(localMediaInfo.path);
                    boolean z17 = localMediaInfo.isRwa;
                    hashMap.put(localMediaInfo.path, localMediaInfo);
                    z16 = z17;
                }
                this.P.b().remove(str);
            }
            ((com.tencent.mobileqq.activity.photo.album.h) this.f184311f).f184248f = z16 ? 2 : 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("PhotoListCustomizationGuildFeed", 2, e16.getMessage());
        }
        this.C.A = false;
        this.U = Math.max(1, intent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 0));
        j1();
        PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184310e;
        if (photoCommonBaseData2 != 0) {
            this.W = 0;
            Iterator<String> it5 = photoCommonBaseData2.selectedPhotoList.iterator();
            while (it5.hasNext()) {
                if (QAlbumUtil.getMediaType(it5.next()) == 0) {
                    this.W++;
                }
            }
        }
        QLog.d("PhotoListCustomizationGuildFeed", 1, "initData, maxSelectVideoCount = " + this.U);
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public boolean E0() {
        return this.V;
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        super.F();
        if (e1().getBooleanExtra("key_always_show_bottom_bar", false)) {
            this.f184313i.D.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        super.G(i3, i16, intent);
        if (i3 == 10014 && i16 == -1) {
            this.D.setResult(-1, intent);
            this.D.finish();
            QAlbumUtil.anim(this.D, false, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(final View view, final int i3, final CheckBox checkBox) {
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        q1(m06, new zu1.b() { // from class: com.tencent.mobileqq.activity.aio.photo.m
            @Override // zu1.b
            public final Object invoke() {
                Boolean m16;
                m16 = PhotoListCustomizationGuildFeed.this.m1(view, i3, checkBox);
                return m16;
            }
        }, Boolean.FALSE, m06.selectStatus == 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO
    public boolean K0() {
        if (this.Z) {
            return false;
        }
        return super.K0();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        b1(this.f184310e.selectedPhotoList);
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        if (this.I) {
            this.D.startActivityForResult(intent, 10017);
        } else {
            this.D.startActivityForResult(intent, 10014);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean a(final LocalMediaInfo localMediaInfo, final boolean z16) {
        return ((Boolean) q1(localMediaInfo, new zu1.b() { // from class: com.tencent.mobileqq.activity.aio.photo.n
            @Override // zu1.b
            public final Object invoke() {
                Boolean l16;
                l16 = PhotoListCustomizationGuildFeed.this.l1(localMediaInfo, z16);
                return l16;
            }
        }, Boolean.FALSE, z16)).booleanValue();
    }

    protected boolean n1(LocalMediaInfo localMediaInfo, boolean z16) {
        boolean z17;
        int i3;
        if (this.W > this.X) {
            return false;
        }
        int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
        int g16 = g1();
        int i16 = localMediaInfo.selectStatus;
        int size = this.f184310e.selectedPhotoList.size();
        if (size > this.f184310e.maxSelectNum) {
            return false;
        }
        if (mediaType != 0) {
            if (mediaType == 1) {
                if (localMediaInfo.fileSize < 1610612736 && localMediaInfo.mDuration <= ShortVideoConstants.VIDEO_MAX_DURATION) {
                    if (this.f179636a0 && g16 != 2 && g16 != 0) {
                        return false;
                    }
                    if (i16 == 2 && size - this.W >= this.U) {
                        return false;
                    }
                } else {
                    com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f145360r_);
                    return false;
                }
            }
            return true;
        }
        if (localMediaInfo.mediaWidth <= 0 || localMediaInfo.mediaHeight <= 0) {
            com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f144380om);
            z17 = false;
        } else {
            z17 = true;
        }
        if (!d1(localMediaInfo)) {
            com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f145360r_);
            z17 = false;
        }
        if (this.f179636a0 && g16 != 1 && g16 != 0) {
            return false;
        }
        boolean z18 = (i16 != 2 || this.W < this.X) ? z17 : false;
        if (!z18) {
            return z18;
        }
        if (localMediaInfo.selectStatus == 2) {
            if (!z16) {
                return z18;
            }
            this.W++;
            return z18;
        }
        if (z16 || (i3 = this.W) <= 0) {
            return z18;
        }
        this.W = i3 - 1;
        return z18;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void p0(Intent intent) {
        if (this.I) {
            this.D.startActivityForResult(intent, 10018);
        } else {
            this.D.startActivityForResult(intent, 10014);
        }
    }

    public <T> T q1(LocalMediaInfo localMediaInfo, zu1.b<T> bVar, T t16, boolean z16) {
        if (n1(localMediaInfo, z16)) {
            int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
            if (mediaType == 0) {
                T invoke = bVar.invoke();
                h1(this.W, localMediaInfo.selectStatus);
                return invoke;
            }
            if (mediaType == 1) {
                T invoke2 = bVar.invoke();
                i1(this.f184310e.selectedPhotoList.size() - this.W, localMediaInfo.selectStatus);
                return invoke2;
            }
        }
        return t16;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public com.tencent.mobileqq.activity.photo.album.photolist.a z(com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3) {
        com.tencent.mobileqq.activity.photo.album.photolist.a z16 = super.z(aVar, i3);
        c1(aVar, i3, 1);
        return z16;
    }

    private void s1() {
        Iterator<Integer> it = f1(0).iterator();
        while (it.hasNext()) {
            this.f184313i.Q.notifyItemChanged(it.next().intValue());
        }
    }

    private void t1() {
        Iterator<Integer> it = f1(1).iterator();
        while (it.hasNext()) {
            this.f184313i.Q.notifyItemChanged(it.next().intValue());
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06 == null) {
            QLog.e("PhotoListCustomizationGuildFeed", 1, "LocalMediaInfo position " + i3 + " is null!");
            return;
        }
        if (m06.selectStatus != 1) {
            ReportController.o(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", this.f184310e.selectedPhotoList.size() >= this.f184310e.maxSelectNum ? 2 : 1, 0, "", "", "", "");
        }
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (!hashMap.containsKey(m06.path)) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            hashMap.put(m06.path, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
        }
        this.f184313i.s(m06.path);
        if (this.f184310e.isSingleMode) {
            return;
        }
        Intent intent = this.D.getIntent();
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        LocalMediaInfo m07 = this.f184313i.Q.m0(i3);
        intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, m07.position);
        intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
        intent.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.f184310e.selectedIndex);
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        intent.putExtra(QAlbumConstants.SHOW_ALBUM, true);
        com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
        HashMap<String, LocalMediaInfo> hashMap2 = this.f184310e.selectedMediaInfoHashMap;
        if (!hashMap2.containsKey(m07.path)) {
            hashMap2.put(m07.path, m07);
        }
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap2);
        intent.setClass(this.D, Z());
        intent.addFlags(603979776);
        this.D.startActivityForResult(intent, 10014);
        QAlbumUtil.anim(this.D, true, true);
    }

    private void h1(int i3, int i16) {
        if (i3 <= 0 || (i3 == 1 && i16 == 1)) {
            t1();
        }
        int i17 = this.X;
        if ((i3 == i17 - 1 && i16 == 2) || (i3 == i17 && i16 == 1)) {
            r1(i3);
            s1();
            t1();
        }
    }

    private void i1(int i3, int i16) {
        if (i3 <= 0 || (i3 == 1 && i16 == 1)) {
            s1();
        }
        int i17 = this.U;
        if ((i3 == i17 - 1 && i16 == 2) || (i3 == i17 && i16 == 1)) {
            s1();
            t1();
        }
    }
}
