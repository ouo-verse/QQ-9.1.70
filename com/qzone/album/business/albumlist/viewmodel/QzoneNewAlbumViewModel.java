package com.qzone.album.business.albumlist.viewmodel;

import NS_MOBILE_MATERIAL.MaterialItem;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import com.qzone.album.data.model.MaterialCateCacheData;
import com.qzone.album.data.model.PublicShareCacheData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneQueryAlbumRequest;
import com.qzone.common.account.LoginData;
import com.qzone.feed.utils.h;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneNewAlbumViewModel extends ViewModel {
    private AlbumCacheData D;
    public AlbumCacheData E;
    private PublicShareCacheData F;
    private int G;
    private MaterialCateCacheData H;
    public int K;
    public String L;
    public int Q;
    public int R;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<AlbumCacheData> f42388i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    protected MutableLiveData<Integer> f42389m = new MutableLiveData<>();
    private MutableLiveData<PublicShareCacheData> C = new MutableLiveData<>();
    private ArrayList<MaterialItem> I = new ArrayList<>();
    public int J = 1;
    public int M = 0;
    public String N = "";
    public int P = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements AbsCompatRequest.a {
        a() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            AlbumSocialInfoCacheData albumSocialInfoCacheData;
            if (sVar.a() == null || !sVar.getSucceed() || !(sVar.getData() instanceof QZoneQueryAlbumRequest.a) || (albumSocialInfoCacheData = ((QZoneQueryAlbumRequest.a) sVar.getData()).f43972a) == null || albumSocialInfoCacheData.albumPublicShareData == null) {
                return;
            }
            QzoneNewAlbumViewModel.this.C.postValue(albumSocialInfoCacheData.albumPublicShareData);
        }
    }

    public QzoneNewAlbumViewModel() {
        QZLog.d("[PhotoAlbum]QzoneNewAlbumViewModel", 1, "init QzoneNewAlbumViewModel...");
    }

    private int P1(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return 1;
                    }
                    return 12;
                }
                return 11;
            }
            return 9;
        }
        return 8;
    }

    private void S1() {
        AlbumCacheData albumCacheData = this.D;
        if (albumCacheData == null || !albumCacheData.isSharingAlbum()) {
            return;
        }
        com.qzone.album.base.Service.a W = com.qzone.album.base.Service.a.W();
        String str = this.L;
        AlbumCacheData albumCacheData2 = this.D;
        W.g1(str, albumCacheData2.albumname, albumCacheData2.ownerUin, true, false, null, new a());
    }

    public void M1(Intent intent) {
        if (this.F != null) {
            return;
        }
        if (intent.getBooleanExtra("hasInviteTroopSetting", false)) {
            PublicShareCacheData publicShareCacheData = new PublicShareCacheData();
            this.F = publicShareCacheData;
            publicShareCacheData.cover = intent.getStringExtra("inviteTroopCover");
            this.F.desc = intent.getStringExtra("inviteTroopDesc");
            this.F.h5url = intent.getStringExtra("inviteTroopH5Url");
            this.F.schema = intent.getStringExtra("inviteTroopSchema");
            return;
        }
        S1();
    }

    public AlbumCacheData N1() {
        return this.D;
    }

    public MutableLiveData<AlbumCacheData> O1() {
        return this.f42388i;
    }

    public PublicShareCacheData Q1() {
        return this.F;
    }

    public MutableLiveData<PublicShareCacheData> R1() {
        return this.C;
    }

    public MutableLiveData<Integer> T1() {
        return this.f42389m;
    }

    public void U1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AlbumCacheData x16 = AlbumCacheDataManager.J().x(LoginData.getInstance().getUin(), str);
        this.E = AlbumCacheDataManager.J().x(LoginData.getInstance().getUin(), str);
        if (QZLog.isColorLevel() && x16 != null) {
            QZLog.d("[PhotoAlbum]QzoneNewAlbumViewModel", 2, "loadDataFromCache sexual:" + x16.sexual);
        }
        if (x16 != null) {
            MaterialItem materialItem = x16.albumTemplate;
            if (materialItem != null) {
                this.G = materialItem.iItemId;
                this.I.add(materialItem);
            }
            this.J = h.a(x16.albumrights);
        }
        MaterialCateCacheData K = AlbumCacheDataManager.J().K();
        this.H = K;
        if (K != null) {
            this.I.addAll(K.vecItem);
        }
        this.f42388i.postValue(x16);
        b2(x16);
        if (x16 != null) {
            this.K = x16.albumtype;
        }
    }

    public void W1(Intent intent) {
        this.R = intent.getIntExtra("QZoneNewAlbumActivity.key_choose_type", 0);
        AlbumCacheData albumCacheData = new AlbumCacheData();
        albumCacheData.ownerUin = com.qzone.album.env.common.a.m().s();
        albumCacheData.albumrights = 1;
        albumCacheData.albumtype = P1(this.R);
        albumCacheData.createSharingUin = com.qzone.album.env.common.a.m().s();
        this.M = 1;
        int i3 = albumCacheData.albumtype;
        this.P = i3;
        this.N = albumCacheData.albumname;
        this.K = i3;
        Z1(albumCacheData);
    }

    public void X1(final String str, String str2) {
        com.qzone.album.base.Service.a.W().e1(str, "", new AbsCompatRequest.a() { // from class: com.qzone.album.business.albumlist.viewmodel.QzoneNewAlbumViewModel.1
            @Override // com.qzone.album.protocol.AbsCompatRequest.a
            public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str3) {
                if (!sVar.getSucceed()) {
                    QzoneNewAlbumViewModel.this.f42389m.postValue(9);
                }
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(new Runnable() { // from class: com.qzone.album.business.albumlist.viewmodel.QzoneNewAlbumViewModel.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        QzoneNewAlbumViewModel.this.U1(str);
                        QzoneNewAlbumViewModel.this.f42389m.postValue(10);
                    }
                });
            }
        });
    }

    public void Z1(AlbumCacheData albumCacheData) {
        this.D = albumCacheData;
    }

    public void a2(PublicShareCacheData publicShareCacheData) {
        this.F = publicShareCacheData;
    }

    public void b2(AlbumCacheData albumCacheData) {
        if (albumCacheData != null) {
            int i3 = albumCacheData.albumrights;
            this.M = i3;
            this.Q = i3;
            this.N = albumCacheData.albumname;
            int i16 = albumCacheData.albumtype;
            this.P = i16;
            if (i16 == 1 || i16 == 0) {
                this.P = 1;
            }
        }
    }
}
