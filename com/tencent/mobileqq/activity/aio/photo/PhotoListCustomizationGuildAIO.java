package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes33.dex */
public class PhotoListCustomizationGuildAIO extends PhotoListCustomizationAIO {
    public static final String V = "com.tencent.mobileqq.activity.aio.photo.PhotoListCustomizationGuildAIO";
    private boolean U;

    PhotoListCustomizationGuildAIO(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        this.U = ABTestUtil.getVideoEditABTest();
    }

    private void T0(com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3, int i16) {
        int V0;
        int X0 = X0();
        if (X0 == 0) {
            aVar.F.setClickable(true);
            aVar.F.setAlpha(1.0f);
            aVar.J.setVisibility(0);
            return;
        }
        if (X0 != i16) {
            aVar.F.setAlpha(0.3f);
            aVar.F.setClickable(false);
            aVar.J.setVisibility(8);
            return;
        }
        int i17 = this.f184313i.Q.m0(i3).selectStatus;
        int size = this.f184310e.selectedPhotoList.size();
        if (i16 == 1) {
            V0 = this.f184310e.maxSelectNum;
        } else {
            V0 = V0();
        }
        if (size >= V0 && i17 == 2) {
            aVar.F.setAlpha(0.3f);
            aVar.F.setClickable(false);
            aVar.J.setVisibility(8);
        } else {
            aVar.F.setAlpha(1.0f);
            aVar.F.setClickable(true);
            aVar.J.setVisibility(0);
        }
    }

    private Intent U0() {
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

    private List<Integer> W0(int i3) {
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

    private int X0() {
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (arrayList.size() > 0) {
            return QAlbumUtil.getMediaType(arrayList.get(0)) == 0 ? 1 : 2;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public com.tencent.mobileqq.activity.photo.album.photolist.a A(com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3) {
        com.tencent.mobileqq.activity.photo.album.photolist.a A = super.A(aVar, i3);
        T0(aVar, i3, 2);
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
            QLog.e("QQAlbum", 2, e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public boolean E0() {
        return this.U;
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        super.F();
        if (U0().getBooleanExtra("key_always_show_bottom_bar", false)) {
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
    public void J(View view, int i3, CheckBox checkBox) {
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        int mediaType = QAlbumUtil.getMediaType(m06);
        int X0 = X0();
        int i16 = m06.selectStatus;
        int size = this.f184310e.selectedPhotoList.size();
        if (mediaType == 0) {
            if (X0 == 1 || X0 == 0) {
                if (i16 == 2 && size >= this.f184310e.maxSelectNum) {
                    return;
                }
                super.J(view, i3, checkBox);
                Y0(size, i16);
                return;
            }
            return;
        }
        if (mediaType != 1) {
            return;
        }
        if (X0 == 2 || X0 == 0) {
            if (i16 == 2 && size >= V0()) {
                return;
            }
            super.J(view, i3, checkBox);
            Z0(size, i16);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        Intent U0 = U0();
        U0.putExtra(PeakConstants.GUILD_ALBUM_QUALITY, ((com.tencent.mobileqq.activity.photo.album.h) this.f184311f).f184248f == 2);
        this.D.setResult(-1, U0);
        this.D.finish();
        QAlbumUtil.anim(this.D, false, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        if (this.I) {
            this.D.startActivityForResult(intent, 10017);
        } else {
            this.D.startActivityForResult(intent, 10014);
        }
    }

    public int V0() {
        return 1;
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean a(LocalMediaInfo localMediaInfo, boolean z16) {
        int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
        int X0 = X0();
        int i3 = localMediaInfo.selectStatus;
        int size = this.f184310e.selectedPhotoList.size();
        if (mediaType != 0) {
            if (mediaType != 1 || (X0 != 2 && X0 != 0)) {
                return false;
            }
            if (i3 != 2 || size < V0()) {
                return super.a(localMediaInfo, z16);
            }
            return false;
        }
        if (X0 != 1 && X0 != 0) {
            return false;
        }
        if (i3 == 2 && size >= this.f184310e.maxSelectNum) {
            return false;
        }
        boolean a16 = super.a(localMediaInfo, z16);
        Y0(size, i3);
        return a16;
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

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public com.tencent.mobileqq.activity.photo.album.photolist.a z(com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3) {
        com.tencent.mobileqq.activity.photo.album.photolist.a z16 = super.z(aVar, i3);
        T0(aVar, i3, 1);
        return z16;
    }

    private void a1() {
        Iterator<Integer> it = W0(0).iterator();
        while (it.hasNext()) {
            this.f184313i.Q.notifyItemChanged(it.next().intValue());
        }
    }

    private void b1() {
        Iterator<Integer> it = W0(1).iterator();
        while (it.hasNext()) {
            this.f184313i.Q.notifyItemChanged(it.next().intValue());
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06 != null) {
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
    }

    private void Y0(int i3, int i16) {
        if (i3 == 0 || (i3 == 1 && i16 == 1)) {
            b1();
        }
        int i17 = this.f184310e.maxSelectNum;
        if ((i3 == i17 - 1 && i16 == 2) || (i3 == i17 && i16 == 1)) {
            a1();
        }
    }

    private void Z0(int i3, int i16) {
        if (i3 == 0 || (i3 == 1 && i16 == 1)) {
            a1();
        }
        if ((i3 == V0() - 1 && i16 == 2) || (i3 == V0() && i16 == 1)) {
            b1();
        }
    }
}
