package com.qzone.reborn.albumx.common.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b&\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH&J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R \u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u001b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010\u001e\u001a\u0004\b*\u0010 R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020(0\"8\u0006\u00a2\u0006\f\n\u0004\b,\u0010$\u001a\u0004\b-\u0010&R \u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b/\u0010\u001e\u001a\u0004\b0\u0010 R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0\"8\u0006\u00a2\u0006\f\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&R$\u0010:\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u001c8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/qzone/reborn/albumx/common/viewmodel/c;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "Landroid/content/Intent;", "intent", "", "T1", AEEditorConstants.ALBUMNAME, "d2", "albumDesc", "c2", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "albumCover", "b2", "", "isStickTop", "e2", "U1", "W1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "Z1", "X1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroidx/lifecycle/MutableLiveData;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "_editAlbumInfo", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "editAlbumInfo", "Lcom/qzone/reborn/albumx/common/viewmodel/n;", BdhLogUtil.LogTag.Tag_Conn, "R1", "_editAlbumResult", "D", "N1", "editAlbumResult", "E", "S1", "_showLoading", UserInfo.SEX_FEMALE, "P1", UIJsPlugin.EVENT_SHOW_LOADING, "<set-?>", "G", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean;", "O1", "()Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean;", "initBean", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class c extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<EditAlbumResult> _editAlbumResult;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<EditAlbumResult> editAlbumResult;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _showLoading;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Boolean> showLoading;

    /* renamed from: G, reason: from kotlin metadata */
    private CommonAlbumEditInitBean initBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<CommonAlbumEditInitBean> _editAlbumInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<CommonAlbumEditInitBean> editAlbumInfo;

    public c() {
        MutableLiveData<CommonAlbumEditInitBean> mutableLiveData = new MutableLiveData<>();
        this._editAlbumInfo = mutableLiveData;
        this.editAlbumInfo = mutableLiveData;
        MutableLiveData<EditAlbumResult> mutableLiveData2 = new MutableLiveData<>();
        this._editAlbumResult = mutableLiveData2;
        this.editAlbumResult = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._showLoading = mutableLiveData3;
        this.showLoading = mutableLiveData3;
    }

    public final LiveData<CommonAlbumEditInitBean> M1() {
        return this.editAlbumInfo;
    }

    public final LiveData<EditAlbumResult> N1() {
        return this.editAlbumResult;
    }

    public final CommonAlbumEditInitBean O1() {
        CommonAlbumEditInitBean commonAlbumEditInitBean = this.initBean;
        if (commonAlbumEditInitBean != null) {
            return commonAlbumEditInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final LiveData<Boolean> P1() {
        return this.showLoading;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<CommonAlbumEditInitBean> Q1() {
        return this._editAlbumInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<EditAlbumResult> R1() {
        return this._editAlbumResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<Boolean> S1() {
        return this._showLoading;
    }

    public boolean U1() {
        return false;
    }

    public abstract boolean W1();

    public abstract void X1(Activity activity, int requestCode);

    public abstract void Z1(Activity activity, int requestCode);

    public abstract void a2(Activity activity, int requestCode);

    public final void b2(CommonStMedia albumCover) {
        CommonAlbumEditInitBean commonAlbumEditInitBean;
        Intrinsics.checkNotNullParameter(albumCover, "albumCover");
        MutableLiveData<CommonAlbumEditInitBean> mutableLiveData = this._editAlbumInfo;
        CommonAlbumEditInitBean value = mutableLiveData.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "value");
            commonAlbumEditInitBean = value.copy((r22 & 1) != 0 ? value.bizId : null, (r22 & 2) != 0 ? value.albumId : null, (r22 & 4) != 0 ? value.albumName : null, (r22 & 8) != 0 ? value.albumDesc : null, (r22 & 16) != 0 ? value.albumCover : albumCover, (r22 & 32) != 0 ? value.isStickTop : false, (r22 & 64) != 0 ? value.albumInfo : null, (r22 & 128) != 0 ? value.hasTopRight : false, (r22 & 256) != 0 ? value.hasDeleteRight : false, (r22 & 512) != 0 ? value.isEmptyAlbum : false);
        } else {
            commonAlbumEditInitBean = null;
        }
        mutableLiveData.postValue(commonAlbumEditInitBean);
    }

    public final void c2(String albumDesc) {
        CommonAlbumEditInitBean commonAlbumEditInitBean;
        Intrinsics.checkNotNullParameter(albumDesc, "albumDesc");
        MutableLiveData<CommonAlbumEditInitBean> mutableLiveData = this._editAlbumInfo;
        CommonAlbumEditInitBean value = mutableLiveData.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "value");
            commonAlbumEditInitBean = value.copy((r22 & 1) != 0 ? value.bizId : null, (r22 & 2) != 0 ? value.albumId : null, (r22 & 4) != 0 ? value.albumName : null, (r22 & 8) != 0 ? value.albumDesc : albumDesc, (r22 & 16) != 0 ? value.albumCover : null, (r22 & 32) != 0 ? value.isStickTop : false, (r22 & 64) != 0 ? value.albumInfo : null, (r22 & 128) != 0 ? value.hasTopRight : false, (r22 & 256) != 0 ? value.hasDeleteRight : false, (r22 & 512) != 0 ? value.isEmptyAlbum : false);
        } else {
            commonAlbumEditInitBean = null;
        }
        mutableLiveData.postValue(commonAlbumEditInitBean);
    }

    public final void d2(String albumName) {
        CommonAlbumEditInitBean commonAlbumEditInitBean;
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        MutableLiveData<CommonAlbumEditInitBean> mutableLiveData = this._editAlbumInfo;
        CommonAlbumEditInitBean value = mutableLiveData.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "value");
            commonAlbumEditInitBean = value.copy((r22 & 1) != 0 ? value.bizId : null, (r22 & 2) != 0 ? value.albumId : null, (r22 & 4) != 0 ? value.albumName : albumName, (r22 & 8) != 0 ? value.albumDesc : null, (r22 & 16) != 0 ? value.albumCover : null, (r22 & 32) != 0 ? value.isStickTop : false, (r22 & 64) != 0 ? value.albumInfo : null, (r22 & 128) != 0 ? value.hasTopRight : false, (r22 & 256) != 0 ? value.hasDeleteRight : false, (r22 & 512) != 0 ? value.isEmptyAlbum : false);
        } else {
            commonAlbumEditInitBean = null;
        }
        mutableLiveData.postValue(commonAlbumEditInitBean);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "CommonAlbumEditAlbumViewModel";
    }

    public final void e2(boolean isStickTop) {
        CommonAlbumEditInitBean commonAlbumEditInitBean;
        MutableLiveData<CommonAlbumEditInitBean> mutableLiveData = this._editAlbumInfo;
        CommonAlbumEditInitBean value = mutableLiveData.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "value");
            commonAlbumEditInitBean = value.copy((r22 & 1) != 0 ? value.bizId : null, (r22 & 2) != 0 ? value.albumId : null, (r22 & 4) != 0 ? value.albumName : null, (r22 & 8) != 0 ? value.albumDesc : null, (r22 & 16) != 0 ? value.albumCover : null, (r22 & 32) != 0 ? value.isStickTop : isStickTop, (r22 & 64) != 0 ? value.albumInfo : null, (r22 & 128) != 0 ? value.hasTopRight : false, (r22 & 256) != 0 ? value.hasDeleteRight : false, (r22 & 512) != 0 ? value.isEmptyAlbum : false);
        } else {
            commonAlbumEditInitBean = null;
        }
        mutableLiveData.postValue(commonAlbumEditInitBean);
    }

    public final void T1(Intent intent) {
        CommonAlbumEditInitBean copy;
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(parcelableExtra, "null cannot be cast to non-null type com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean");
        this.initBean = (CommonAlbumEditInitBean) parcelableExtra;
        CommonAlbumEditInitBean O1 = O1();
        MutableLiveData<CommonAlbumEditInitBean> mutableLiveData = this._editAlbumInfo;
        copy = O1.copy((r22 & 1) != 0 ? O1.bizId : null, (r22 & 2) != 0 ? O1.albumId : null, (r22 & 4) != 0 ? O1.albumName : null, (r22 & 8) != 0 ? O1.albumDesc : null, (r22 & 16) != 0 ? O1.albumCover : null, (r22 & 32) != 0 ? O1.isStickTop : false, (r22 & 64) != 0 ? O1.albumInfo : null, (r22 & 128) != 0 ? O1.hasTopRight : false, (r22 & 256) != 0 ? O1.hasDeleteRight : false, (r22 & 512) != 0 ? O1.isEmptyAlbum : false);
        mutableLiveData.postValue(copy);
    }
}
