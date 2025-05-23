package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import cooperation.peak.PeakConstants;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class ap extends RFWLayerBasePart {
    public int C;
    public int D;
    private Handler E;
    private pk.b F;

    /* renamed from: d, reason: collision with root package name */
    protected PhotoInfo f57984d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f57985e;

    /* renamed from: f, reason: collision with root package name */
    protected ArrayList<PhotoParam> f57986f;

    /* renamed from: h, reason: collision with root package name */
    public int f57987h = 0;

    /* renamed from: i, reason: collision with root package name */
    public PhotoParam f57988i;

    /* renamed from: m, reason: collision with root package name */
    public List<PhotoInfo> f57989m;

    private boolean H9() {
        return lm.a.f414989a.h(this);
    }

    private void initCommonData(Bundle bundle) {
        PhotoParam photoParam = (PhotoParam) bundle.getParcelable("photo_param");
        this.f57988i = photoParam;
        if (photoParam == null) {
            this.f57988i = new PhotoParam();
        }
        this.f57989m = (ArrayList) bundle.getSerializable("picturelist");
        this.f57987h = bundle.getInt(PeakConstants.KEY_SHOW_TYPE, 0);
        this.D = bundle.getInt("mode");
        this.f57986f = bundle.getParcelableArrayList(PictureConst.KEY_PHOTO_PARAM_LIST);
    }

    public Handler A9() {
        if (this.E == null) {
            this.E = new a(this);
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public pk.b B9() {
        if (this.F == null) {
            this.F = (pk.b) RFWIocAbilityProvider.g().getIocInterface(pk.b.class, getPartRootView(), null);
        }
        return this.F;
    }

    public boolean E9() {
        PhotoInfo photoInfo = this.f57984d;
        return photoInfo != null && photoInfo.photoType == 2;
    }

    public boolean F9() {
        PhotoParam photoParam = this.f57988i;
        if (photoParam == null) {
            return false;
        }
        long j3 = photoParam.loginUin;
        return j3 != 0 ? photoParam.ownerUin != j3 : photoParam.ownerUin != LoginData.getInstance().getUin();
    }

    public boolean G9() {
        PhotoParam photoParam = this.f57988i;
        return photoParam != null && photoParam.isOnlyPreView;
    }

    public boolean I9() {
        PhotoParam photoParam = this.f57988i;
        return photoParam != null && photoParam.appid == 4;
    }

    public boolean J9() {
        PhotoParam photoParam = this.f57988i;
        return photoParam != null && photoParam.appid == 422;
    }

    public boolean K9() {
        PhotoParam photoParam = this.f57988i;
        return photoParam != null && photoParam.appid == 311;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean L9() {
        return com.qzone.util.z.b(this.f57984d);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return !H9();
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        Intent intent = activity.getIntent();
        this.E = new a(this);
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        initCommonData(intent.getExtras());
        initIntentData(intent.getExtras());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.f57985e = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        this.f57985e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public final void updateLayerState(RFWLayerState rFWLayerState) {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null && (rFWLayerItemMediaInfo.getExtraData() instanceof PhotoInfo)) {
            this.f57984d = (PhotoInfo) this.mCurrentSelectedItem.getExtraData();
            this.C = rFWLayerState.getSelectedPosition();
        } else {
            this.f57984d = null;
        }
        onLayerStateUpdate(rFWLayerState);
    }

    public boolean x9() {
        PhotoInfo photoInfo = this.f57984d;
        return (photoInfo == null || (photoInfo.opsynflag & 128) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PhotoParam z9(PhotoParam photoParam) {
        ArrayList<PhotoParam> arrayList;
        String str;
        PhotoInfo photoInfo = this.f57984d;
        PhotoParam photoParam2 = new PhotoParam();
        if (photoParam == null) {
            return null;
        }
        if (photoInfo == null) {
            return PhotoParam.getClonePhotoParam(photoParam);
        }
        if (!TextUtils.equals(photoInfo.albumId, photoParam.albumid) && (arrayList = this.f57986f) != null && !arrayList.isEmpty()) {
            Iterator<PhotoParam> it = this.f57986f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PhotoParam next = it.next();
                if (next != null && (str = next.albumid) != null && str.equals(photoInfo.albumId)) {
                    photoParam2 = PhotoParam.getClonePhotoParam(next);
                    break;
                }
            }
        } else {
            photoParam2 = PhotoParam.getClonePhotoParam(photoParam);
        }
        int i3 = photoInfo.appid;
        if (i3 == 311) {
            photoParam2.appid = i3;
            photoParam2.cell_id = photoInfo.pssCellId;
            photoParam2.cell_subId = photoInfo.pssCellSubId;
            String str2 = photoInfo.pssUgcKey;
            photoParam2.feedId = str2;
            photoParam2.ugcKey = str2;
            photoParam2.subid = photoInfo.pssSubId;
            photoParam2.curKey = photoInfo.pssCurLikeKey;
            photoParam2.orgKey = photoInfo.pssOrgLikeKey;
            photoParam2.busi_param = photoInfo.pssBusiParam;
            photoParam2.isLike = photoInfo.pssHasFeedPraise;
            photoParam2.likeNum = photoInfo.praiseCount;
            photoParam2.commentNum = photoInfo.commentCount;
        }
        return photoParam2;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    protected static class a extends WeakReferenceHandler<ap> {
        a(ap apVar) {
            super(apVar);
        }

        @Override // cooperation.qzone.util.WeakReferenceHandler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void handleMessage(ap apVar, Message message) {
            if (message != null) {
                apVar.onHandleMessage(message);
            }
        }
    }

    public int C9(RFWLayerState rFWLayerState) {
        if (rFWLayerState == null) {
            return 1;
        }
        return rFWLayerState.getSelectedPosition() + rFWLayerState.getPositionOffset() + 1;
    }

    public int D9(RFWLayerState rFWLayerState) {
        if (rFWLayerState == null) {
            return 1;
        }
        if (rFWLayerState.getRichMediaDataList() == null) {
            return rFWLayerState.getMediaSum();
        }
        return Math.max(rFWLayerState.getMediaSum(), rFWLayerState.getRichMediaDataList().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initIntentData(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onHandleMessage(Message message) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
    }
}
