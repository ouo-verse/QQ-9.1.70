package com.qzone.reborn.albumx.common.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H$J\b\u0010\f\u001a\u00020\u0006H&R\"\u0010\u0014\u001a\u00020\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR,\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u001f0\u001e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R)\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u001f0%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/albumx/common/viewmodel/l;", "Lcom/qzone/reborn/base/n;", "", "U1", "", "getLogTag", "", "R1", "S1", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "T1", "W1", "Q1", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "i", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "O1", "()Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "setLoadInfo", "(Lcom/tencent/biz/richframework/part/block/base/LoadInfo;)V", "loadInfo", "", "Lcom/qzone/reborn/albumx/common/bean/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "N1", "()Ljava/util/List;", "setAllAlbumList", "(Ljava/util/List;)V", "allAlbumList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "_albumListData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "albumListData", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class l extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.h>>> _albumListData;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.h>>> albumListData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<com.qzone.reborn.albumx.common.bean.h> allAlbumList = new ArrayList();

    public l() {
        MutableLiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.h>>> mutableLiveData = new MutableLiveData<>();
        this._albumListData = mutableLiveData;
        this.albumListData = mutableLiveData;
    }

    private final void U1() {
        LoadInfo loadInfo = new LoadInfo();
        this.loadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.loadInfo.setFinish(false);
    }

    public final LiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.h>>> M1() {
        return this.albumListData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<com.qzone.reborn.albumx.common.bean.h> N1() {
        return this.allAlbumList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: O1, reason: from getter */
    public final LoadInfo getLoadInfo() {
        return this.loadInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.h>>> P1() {
        return this._albumListData;
    }

    public abstract boolean Q1();

    public final boolean R1() {
        Object obj;
        Iterator<T> it = this.allAlbumList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((com.qzone.reborn.albumx.common.bean.h) obj).getIsSelect()) {
                break;
            }
        }
        return obj != null;
    }

    public final boolean S1() {
        UIStateData<List<com.qzone.reborn.albumx.common.bean.h>> value = this._albumListData.getValue();
        return value == null || value.getState() == 4;
    }

    protected abstract void W1(boolean isLoadMore);

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "CommonSelectAlbumViewModel";
    }

    public final void T1(boolean isLoadMore) {
        if (!isLoadMore) {
            U1();
        }
        QLog.d(getLogTag(), 1, "requestAlbumList, attachInfo : " + this.loadInfo + ".stringAttachInfo | isLoadMore : " + isLoadMore);
        if (this.loadInfo.getCurrentState() != 4) {
            QLog.w(getLogTag(), 1, "requestAlbumList  mLoadInfo.currentState = " + this.loadInfo + ".currentState");
            return;
        }
        this.loadInfo.setCurrentState(2);
        W1(isLoadMore);
    }
}
