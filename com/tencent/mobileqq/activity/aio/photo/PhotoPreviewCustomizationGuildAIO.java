package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes33.dex */
public class PhotoPreviewCustomizationGuildAIO extends PhotoPreviewCustomizationAIO {
    public static final String Z = "com.tencent.mobileqq.activity.aio.photo.PhotoPreviewCustomizationGuildAIO";
    private boolean S;
    private boolean T;
    private int U;
    private int V;
    private boolean W;
    private int X;
    private int Y;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhotoPreviewCustomizationGuildAIO(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        this.S = false;
        this.U = 9;
        this.V = 1;
        this.X = 0;
        this.Y = 0;
    }

    private boolean c0() {
        int i3;
        TextView textView = v().C;
        return textView == null || textView.getVisibility() == 8 || !d0().getBooleanExtra("key_guild_feed_publish", false) || (i3 = v().i()) < 0 || i3 >= this.C.f184324b.size() || this.f184337i.l(this.C.f184324b.get(i3)) != 1;
    }

    private Intent d0() {
        Intent intent = this.f184197m.getIntent();
        Bundle extras = intent.getExtras();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
        ArrayList<String> arrayList2 = photoCommonBaseData.selectedPhotoList;
        HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData.selectedMediaInfoHashMap;
        HashMap<String, LocalMediaInfo> hashMap2 = photoCommonBaseData.allMediaInfoHashMap;
        HashMap<String, String> hashMap3 = this.C.f184325c;
        boolean z16 = ((com.tencent.mobileqq.activity.photo.album.h) this.f184335f).f184248f == 2;
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
            } else if (hashMap3.containsValue(next)) {
                LocalMediaInfo e06 = e0(next);
                e06.isRwa = z16;
                arrayList.add(e06);
            }
        }
        extras.putBoolean(PeakConstants.GUILD_ALBUM_QUALITY, ((com.tencent.mobileqq.activity.photo.album.h) this.f184335f).f184248f == 2);
        extras.putParcelableArrayList(PeakConstants.GUILD_ALBUM_SELECT_PHOTOS, arrayList);
        extras.putSerializable(QAlbumConstants.KEY_EDIT_PATHS_MAP, hashMap3);
        intent.putExtras(extras);
        return intent;
    }

    private int f0() {
        ArrayList<String> arrayList = this.f184334e.selectedPhotoList;
        if (arrayList.size() > 0) {
            return QAlbumUtil.getMediaType(arrayList.get(0)) == 0 ? 1 : 2;
        }
        return 0;
    }

    private void g0() {
        if (d0().getBooleanExtra("key_guild_feed_publish", false)) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
            if (photoCommonBaseData.filter == null) {
                photoCommonBaseData.filter = MediaFileFilter.getFilter(photoCommonBaseData.showMediaType);
            }
            MediaFileFilter mediaFileFilter = this.f184334e.filter;
            mediaFileFilter.videoSizeLimit = 1610612736L;
            mediaFileFilter.videoMaxDuration = ShortVideoConstants.VIDEO_MAX_DURATION;
            mediaFileFilter.imageMaxHeight = 30000;
            mediaFileFilter.imageMaxWidth = 30000;
        }
    }

    private void h0() {
        if (c0()) {
            return;
        }
        QLog.d("PhotoPreviewCustomizationGuildAIO", 1, "force magicStickBtn use View.GONE from initUI.");
        v().C.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(int i3) {
        v().I.setVisibility(i3);
        v().F.setVisibility(i3);
        v().C.setVisibility(i3);
        v().G.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void B(int i3, int i16, Intent intent) {
        int indexOf;
        super.B(i3, i16, intent);
        if (i16 != -1 || intent == null) {
            return;
        }
        boolean z16 = !intent.getBooleanExtra(PeakConstants.SEND_PICTURE_ORIGIN, false);
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!z16 || stringExtra == null || (indexOf = this.C.f184324b.indexOf(stringExtra)) < 0 || this.f184334e.selectedIndex.contains(Integer.valueOf(indexOf))) {
            return;
        }
        p(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void J() {
        if (d0().getBooleanExtra("key_guild_check_qrcode_image", false)) {
            if (v().i() == -1) {
                QLog.d("PhotoPreviewCustomizationGuildAIO", 1, "submit currentPosition == INVALID_POSITION");
                return;
            }
            Iterator<String> it = this.f184334e.selectedPhotoList.iterator();
            while (it.hasNext()) {
                if (gg1.a.a(it.next())) {
                    ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptQrCodeSendToast();
                    return;
                }
            }
        }
        this.f184197m.setResult(-1, d0());
        this.f184197m.finish();
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public boolean K() {
        return this.T;
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        super.a();
        boolean z16 = this.f184334e.selectedPhotoList.size() > 0;
        v().H.setClickable(z16);
        v().H.setEnabled(z16);
        if (this.S) {
            r();
        }
        h0();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void c(int i3) {
        if (this.S) {
            return;
        }
        this.f184337i.c(i3);
    }

    public LocalMediaInfo e0(String str) {
        LocalMediaInfo k3 = this.f184337i.k(str);
        if (k3 != null) {
            return k3;
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = str;
        localMediaInfo.mMediaType = 0;
        return localMediaInfo;
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void g() {
        super.g();
        boolean z16 = this.f184334e.selectedPhotoList.size() > 0;
        v().H.setClickable(z16);
        v().H.setEnabled(z16);
        h0();
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void j(Intent intent) {
        PhotoCommonBaseData<O> photoCommonBaseData;
        super.j(intent);
        PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184334e;
        if (photoCommonBaseData2 != 0) {
            photoCommonBaseData2.customSendBtnText = this.f184197m.getString(R.string.cud);
        }
        this.S = intent.getBooleanExtra("HIDE_MENU_BAR", false);
        this.T = false;
        this.U = d0().getIntExtra("key_guild_feed_publish_max_photo", 9);
        this.V = d0().getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
        boolean booleanExtra = d0().getBooleanExtra("key_guild_feed_need_mutex_media", true);
        this.W = booleanExtra;
        if (!booleanExtra && (photoCommonBaseData = this.f184334e) != 0 && photoCommonBaseData.selectedPhotoList.size() > 0) {
            this.X = 0;
            this.Y = 0;
            Iterator<String> it = this.f184334e.selectedPhotoList.iterator();
            while (it.hasNext()) {
                int l3 = this.f184337i.l(it.next());
                if (l3 == 0) {
                    this.X++;
                } else if (l3 == 1) {
                    this.Y++;
                }
            }
        }
        QLog.i("PhotoPreviewCustomizationGuildAIO", 1, "initData maxPhotoNum=" + this.U + " maxVideoNum=" + this.V);
        g0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        if (r7 >= r0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(final int i3) {
        int i16;
        int i17;
        if (this.S) {
            return;
        }
        super.k(i3);
        int f06 = f0();
        final int l3 = this.f184337i.l(this.C.f184324b.get(i3));
        final int i18 = 8;
        if (this.W) {
            if (f06 != 0) {
                if (f06 != 1) {
                    i16 = 8;
                }
                if (i16 == 0) {
                    boolean contains = this.f184334e.selectedIndex.contains(Integer.valueOf(i3));
                    int size = this.f184334e.selectedPhotoList.size();
                    if (f06 == 1) {
                        i17 = this.U;
                    } else {
                        i17 = this.V;
                    }
                    if (!contains) {
                    }
                }
                i18 = i16;
            }
            i16 = 0;
            if (i16 == 0) {
            }
            i18 = i16;
        } else if (this.f184334e.selectedIndex.contains(Integer.valueOf(i3)) || ((l3 == 0 && this.X < this.U) || (l3 == 1 && this.Y < this.V))) {
            i18 = 0;
        }
        if (d0().getBooleanExtra("key_guild_feed_publish", false)) {
            v().f184366i.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoPreviewCustomizationGuildAIO.1
                @Override // java.lang.Runnable
                public void run() {
                    PhotoPreviewCustomizationGuildAIO.this.i0(i18);
                    if (l3 == 1) {
                        QLog.d("PhotoPreviewCustomizationGuildAIO", 1, "force magicStickBtn use View.GONE from onGalleryItemSelected, pos: " + i3);
                        PhotoPreviewCustomizationGuildAIO.this.v().C.setVisibility(8);
                    }
                }
            });
        } else {
            i0(i18);
        }
        final TextView textView = v().C;
        Objects.requireNonNull(textView);
        textView.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.q
            @Override // java.lang.Runnable
            public final void run() {
                textView.requestLayout();
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void p(View view) {
        int i3 = v().i();
        if (i3 == -1) {
            QLog.d("PhotoPreviewCustomizationGuildAIO", 1, "onSelectClick currentPosition == INVALID_POSITION");
            return;
        }
        int l3 = this.f184337i.l(this.C.f184324b.get(i3));
        int f06 = f0();
        boolean contains = this.f184334e.selectedIndex.contains(Integer.valueOf(i3));
        int size = this.f184334e.selectedIndex.size();
        if (l3 == 0) {
            if (!this.W) {
                if (contains) {
                    this.X--;
                } else {
                    this.X++;
                }
                super.p(view);
                return;
            }
            if (f06 == 1 || f06 == 0) {
                if (!(!contains && size >= this.U)) {
                    super.p(view);
                    return;
                } else {
                    i0(8);
                    return;
                }
            }
            return;
        }
        if (l3 != 1) {
            return;
        }
        if (!this.W) {
            if (contains) {
                this.Y--;
            } else {
                this.Y++;
            }
            super.p(view);
            return;
        }
        if (f06 == 2 || f06 == 0) {
            if (!(!contains && size >= this.V)) {
                super.p(view);
            } else {
                i0(8);
            }
        }
    }
}
