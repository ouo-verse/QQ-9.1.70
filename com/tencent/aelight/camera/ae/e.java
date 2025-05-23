package com.tencent.aelight.camera.ae;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.aelight.camera.ae.MaterialDownloadState;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J&\u0010\f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000eR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR&\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001d0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u001f\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u00198\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010#R\u001f\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u00198\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010#R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010#R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198F\u00a2\u0006\u0006\u001a\u0004\b,\u0010#R#\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001d0\u00198F\u00a2\u0006\u0006\u001a\u0004\b.\u0010#\u00a8\u00062"}, d2 = {"Lcom/tencent/aelight/camera/ae/e;", "Landroidx/lifecycle/ViewModel;", "", "type", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "", "forceUpdate", "", "T1", "isDownloading", "success", "W1", "M1", "", "videoPath", "b2", "key", "value", "X1", "L1", "friendContent", "Z1", LocalPhotoFaceInfo.SCORE, ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_materialVideoGuide", "Lkotlin/Pair;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_materialEvent", "Lcom/tencent/aelight/camera/ae/r;", BdhLogUtil.LogTag.Tag_Conn, "P1", "()Landroidx/lifecycle/MutableLiveData;", "materialState", "Lcom/tencent/aelight/camera/ae/MaterialDownloadState;", "D", "N1", "materialDownloadState", "E", "R1", "musicPause", "Q1", "materialVideoGuide", "O1", "materialEvent", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class e extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> _materialVideoGuide = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Pair<String, String>> _materialEvent = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<r> materialState = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<MaterialDownloadState> materialDownloadState = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> musicPause = new MutableLiveData<>();

    public final void L1() {
        this.materialState.postValue(null);
    }

    public final AEMaterialMetaData M1(int type) {
        r value;
        r value2 = this.materialState.getValue();
        boolean z16 = false;
        if (value2 != null && value2.getType() == type) {
            z16 = true;
        }
        if (!z16 || (value = this.materialState.getValue()) == null) {
            return null;
        }
        return value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
    }

    public final MutableLiveData<MaterialDownloadState> N1() {
        return this.materialDownloadState;
    }

    public final MutableLiveData<Pair<String, String>> O1() {
        return this._materialEvent;
    }

    public final MutableLiveData<r> P1() {
        return this.materialState;
    }

    public final MutableLiveData<String> Q1() {
        return this._materialVideoGuide;
    }

    public final MutableLiveData<Boolean> R1() {
        return this.musicPause;
    }

    public final void T1(int type, AEMaterialMetaData material, boolean forceUpdate) {
        this.materialState.postValue(new r(material, type, forceUpdate));
    }

    public final void X1(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this._materialEvent.postValue(new Pair<>(key, value));
    }

    public final void Z1(String friendContent) {
        Intrinsics.checkNotNullParameter(friendContent, "friendContent");
        r value = this.materialState.getValue();
        AEMaterialMetaData aEMaterialMetaData = value != null ? value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() : null;
        if (aEMaterialMetaData == null) {
            return;
        }
        aEMaterialMetaData.friendContent = friendContent;
    }

    public final void a2(String score) {
        Intrinsics.checkNotNullParameter(score, "score");
        r value = this.materialState.getValue();
        AEMaterialMetaData aEMaterialMetaData = value != null ? value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() : null;
        if (aEMaterialMetaData == null) {
            return;
        }
        aEMaterialMetaData.score = score;
    }

    public final void b2(String videoPath) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        this._materialVideoGuide.postValue(videoPath);
    }

    public final void W1(AEMaterialMetaData material, boolean isDownloading, boolean success) {
        MaterialDownloadState.DownLoadState downLoadState;
        if (isDownloading) {
            downLoadState = MaterialDownloadState.DownLoadState.DOWN_LOADING;
        } else if (success) {
            downLoadState = MaterialDownloadState.DownLoadState.FINISH;
        } else {
            downLoadState = MaterialDownloadState.DownLoadState.ERROR_BREAK;
        }
        MaterialDownloadState materialDownloadState = new MaterialDownloadState(material, null, 2, null);
        materialDownloadState.c(downLoadState);
        this.materialDownloadState.postValue(materialDownloadState);
    }

    public static /* synthetic */ void U1(e eVar, int i3, AEMaterialMetaData aEMaterialMetaData, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        eVar.T1(i3, aEMaterialMetaData, z16);
    }

    public final void S1(int i3, AEMaterialMetaData aEMaterialMetaData) {
        U1(this, i3, aEMaterialMetaData, false, 4, null);
    }
}
