package com.tencent.aelight.camera.aioeditor.takevideo.mosaic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005R\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/h;", "Landroidx/lifecycle/ViewModel;", "", "O1", "N1", "", "unDoSize", "redoSize", "", "P1", "i", "I", "_unDoSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_reDoSize", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_showUndoLiveData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "showUndoLiveData", "E", "_showRedoLiveData", UserInfo.SEX_FEMALE, "L1", "showRedoLiveData", "<init>", "()V", "G", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class h extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _showUndoLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<Boolean> showUndoLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _showRedoLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Boolean> showRedoLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int _unDoSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int _reDoSize;

    public h() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._showUndoLiveData = mutableLiveData;
        this.showUndoLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._showRedoLiveData = mutableLiveData2;
        this.showRedoLiveData = mutableLiveData2;
    }

    public final LiveData<Boolean> L1() {
        return this.showRedoLiveData;
    }

    public final LiveData<Boolean> M1() {
        return this.showUndoLiveData;
    }

    public final boolean N1() {
        return this._reDoSize != 0;
    }

    public final boolean O1() {
        return this._unDoSize != 0;
    }

    public final void P1(int unDoSize, int redoSize) {
        this._unDoSize = unDoSize;
        this._reDoSize = redoSize;
        this._showUndoLiveData.postValue(Boolean.valueOf((unDoSize == 0 || redoSize == 30) ? false : true));
        this._showRedoLiveData.postValue(Boolean.valueOf(redoSize != 0));
    }
}
