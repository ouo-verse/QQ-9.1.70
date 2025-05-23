package oc;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxBatchLayerSelectedMediaInfoBean;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\"\u0010\n\u001a\u00020\t2\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006J\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0010\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ \u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050 8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020)0 8\u0006\u00a2\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0 8\u0006\u00a2\u0006\f\n\u0004\b-\u0010\"\u001a\u0004\b.\u0010$\u00a8\u00062"}, d2 = {"Loc/b;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxBatchLayerSelectedMediaInfoBean;", "Lkotlin/collections/ArrayList;", "R1", "selectedList", "", "S1", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "", "W1", "L1", "U1", "selectedItem", "Z1", "clickedItem", "T1", "Lcom/tencent/richframework/gallery/viewmodel/RFWLayerViewModel;", "layerViewModel", "X1", "", "i", "Ljava/util/List;", "P1", "()Ljava/util/List;", "setSelectedMedias", "(Ljava/util/List;)V", "selectedMedias", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "selectedModeChange", BdhLogUtil.LogTag.Tag_Conn, "O1", "selectedClickedItem", "", "D", "N1", "headVisibleChange", "E", "M1", "bottomVisibleChange", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<QZAlbumxBatchLayerSelectedMediaInfoBean> selectedMedias = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Unit> selectedModeChange = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<QZAlbumxBatchLayerSelectedMediaInfoBean> selectedClickedItem = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> headVisibleChange = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Integer> bottomVisibleChange = new MutableLiveData<>();

    public final MutableLiveData<Integer> M1() {
        return this.bottomVisibleChange;
    }

    public final MutableLiveData<Boolean> N1() {
        return this.headVisibleChange;
    }

    public final MutableLiveData<QZAlbumxBatchLayerSelectedMediaInfoBean> O1() {
        return this.selectedClickedItem;
    }

    public final List<QZAlbumxBatchLayerSelectedMediaInfoBean> P1() {
        return this.selectedMedias;
    }

    public final MutableLiveData<Unit> Q1() {
        return this.selectedModeChange;
    }

    public final ArrayList<QZAlbumxBatchLayerSelectedMediaInfoBean> R1() {
        return new ArrayList<>(this.selectedMedias);
    }

    public final void S1(ArrayList<QZAlbumxBatchLayerSelectedMediaInfoBean> selectedList) {
        this.selectedMedias.clear();
        if (selectedList == null || selectedList.isEmpty()) {
            QLog.e(getLogTag(), 1, "initSelectedMedias selectedList is null or empty");
            return;
        }
        QLog.d(getLogTag(), 4, "initSelectedMedias selectedList:" + selectedList.size());
        this.selectedMedias.addAll(selectedList);
    }

    public final void T1(QZAlbumxBatchLayerSelectedMediaInfoBean clickedItem) {
        Intrinsics.checkNotNullParameter(clickedItem, "clickedItem");
        this.selectedClickedItem.setValue(clickedItem);
    }

    public final void X1(QZAlbumxBatchLayerSelectedMediaInfoBean clickedItem, RFWLayerViewModel layerViewModel) {
        Intrinsics.checkNotNullParameter(clickedItem, "clickedItem");
        Intrinsics.checkNotNullParameter(layerViewModel, "layerViewModel");
        UIStateData<RFWLayerState> value = layerViewModel.mRichMediaInfo.getValue();
        RFWLayerState data = value != null ? value.getData() : null;
        if (data == null) {
            return;
        }
        RFWLayerState rFWLayerState = new RFWLayerState();
        rFWLayerState.setMediaSum(data.getMediaSum());
        rFWLayerState.setPositionOffset(data.getPositionOffset());
        rFWLayerState.setRichMediaDataList(data.getRichMediaDataList());
        int selectedPosition = data.getSelectedPosition();
        List<RFWLayerItemMediaInfo> richMediaDataList = data.getRichMediaDataList();
        if (richMediaDataList != null) {
            int i3 = 0;
            for (Object obj : richMediaDataList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                RFWLayerPicInfo layerPicInfo = ((RFWLayerItemMediaInfo) obj).getLayerPicInfo();
                if (Intrinsics.areEqual(layerPicInfo != null ? layerPicInfo.getPicId() : null, clickedItem.getLloc())) {
                    selectedPosition = i3;
                }
                i3 = i16;
            }
        }
        rFWLayerState.setSelectedPosition(selectedPosition);
        UIStateData<RFWLayerState> obtainSuccess = UIStateData.obtainSuccess(true);
        obtainSuccess.setDataList(rFWLayerState);
        layerViewModel.mRichMediaInfo.setValue(obtainSuccess);
    }

    public final ArrayList<QZAlbumxBatchLayerSelectedMediaInfoBean> Z1(QZAlbumxBatchLayerSelectedMediaInfoBean selectedItem) {
        for (QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean : this.selectedMedias) {
            qZAlbumxBatchLayerSelectedMediaInfoBean.j(Intrinsics.areEqual(selectedItem != null ? selectedItem.getLloc() : null, qZAlbumxBatchLayerSelectedMediaInfoBean.getLloc()));
        }
        return new ArrayList<>(this.selectedMedias);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZAlbumxBatchLayerViewModel";
    }

    public final void U1(RFWLayerItemMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            return;
        }
        int i3 = 0;
        int i16 = -1;
        for (Object obj : this.selectedMedias) {
            int i17 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean = (QZAlbumxBatchLayerSelectedMediaInfoBean) obj;
            RFWLayerPicInfo layerPicInfo = mediaInfo.getLayerPicInfo();
            String picId = layerPicInfo != null ? layerPicInfo.getPicId() : null;
            if (!(picId == null || picId.length() == 0)) {
                RFWLayerPicInfo layerPicInfo2 = mediaInfo.getLayerPicInfo();
                if (Intrinsics.areEqual(layerPicInfo2 != null ? layerPicInfo2.getPicId() : null, qZAlbumxBatchLayerSelectedMediaInfoBean.getLloc())) {
                    i16 = i3;
                }
            }
            i3 = i17;
        }
        if (i16 == -1 || i16 >= this.selectedMedias.size()) {
            return;
        }
        this.selectedMedias.remove(i16);
        this.selectedModeChange.postValue(Unit.INSTANCE);
    }

    public final int L1(RFWLayerItemMediaInfo mediaInfo) {
        String str;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String url;
        if (mediaInfo == null) {
            return 0;
        }
        Iterator<T> it = this.selectedMedias.iterator();
        int i3 = 0;
        int i16 = -1;
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i17 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean = (QZAlbumxBatchLayerSelectedMediaInfoBean) next;
            RFWLayerPicInfo layerPicInfo = mediaInfo.getLayerPicInfo();
            String picId = layerPicInfo != null ? layerPicInfo.getPicId() : null;
            if (picId != null && picId.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                RFWLayerPicInfo layerPicInfo2 = mediaInfo.getLayerPicInfo();
                if (Intrinsics.areEqual(layerPicInfo2 != null ? layerPicInfo2.getPicId() : null, qZAlbumxBatchLayerSelectedMediaInfoBean.getLloc())) {
                    i16 = i3;
                }
            }
            i3 = i17;
        }
        if (i16 != -1) {
            return i16 + 1;
        }
        List<QZAlbumxBatchLayerSelectedMediaInfoBean> list = this.selectedMedias;
        QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean2 = new QZAlbumxBatchLayerSelectedMediaInfoBean();
        RFWLayerPicInfo layerPicInfo3 = mediaInfo.getLayerPicInfo();
        String str2 = "";
        if (layerPicInfo3 == null || (str = layerPicInfo3.getPicId()) == null) {
            str = "";
        }
        qZAlbumxBatchLayerSelectedMediaInfoBean2.g(str);
        RFWLayerPicInfo layerPicInfo4 = mediaInfo.getLayerPicInfo();
        if (layerPicInfo4 != null && (currentPicInfo = layerPicInfo4.getCurrentPicInfo()) != null && (url = currentPicInfo.getUrl()) != null) {
            str2 = url;
        }
        qZAlbumxBatchLayerSelectedMediaInfoBean2.k(str2);
        qZAlbumxBatchLayerSelectedMediaInfoBean2.l(mediaInfo.isVideo());
        qZAlbumxBatchLayerSelectedMediaInfoBean2.m(mediaInfo.getLayerVideoInfo() != null ? r11.getVideoDurationSec() : 0);
        qZAlbumxBatchLayerSelectedMediaInfoBean2.j(true);
        list.add(qZAlbumxBatchLayerSelectedMediaInfoBean2);
        this.selectedModeChange.postValue(Unit.INSTANCE);
        return this.selectedMedias.size();
    }

    public final int W1(RFWLayerItemMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            return 0;
        }
        int i3 = 0;
        for (Object obj : this.selectedMedias) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean = (QZAlbumxBatchLayerSelectedMediaInfoBean) obj;
            RFWLayerPicInfo layerPicInfo = mediaInfo.getLayerPicInfo();
            String picId = layerPicInfo != null ? layerPicInfo.getPicId() : null;
            if (!(picId == null || picId.length() == 0)) {
                RFWLayerPicInfo layerPicInfo2 = mediaInfo.getLayerPicInfo();
                if (Intrinsics.areEqual(layerPicInfo2 != null ? layerPicInfo2.getPicId() : null, qZAlbumxBatchLayerSelectedMediaInfoBean.getLloc())) {
                    return i16;
                }
            }
            i3 = i16;
        }
        return 0;
    }
}
