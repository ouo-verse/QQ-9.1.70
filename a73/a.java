package a73;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.core.render.util.MatrixTransform;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 H2\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\tJ\u0016\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012R'\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001aj\b\u0012\u0004\u0012\u00020\u0007`\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR2\u0010&\u001a\u0012\u0012\u0004\u0012\u00020!0\u001aj\b\u0012\u0004\u0012\u00020!`\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010%R*\u0010+\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020(0\u001aj\b\u0012\u0004\u0012\u00020(`\u001b0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R-\u00101\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020(0\u001aj\b\u0012\u0004\u0012\u00020(`\u001b0,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120,8\u0006\u00a2\u0006\f\n\u0004\b4\u0010.\u001a\u0004\b5\u00100R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00120'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010*R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00120,8\u0006\u00a2\u0006\f\n\u0004\b9\u0010.\u001a\u0004\b:\u00100R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010*R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\b>\u0010.\u001a\u0004\b?\u00100R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010*R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\bC\u0010.\u001a\u0004\bD\u00100\u00a8\u0006J"}, d2 = {"La73/a;", "Landroidx/lifecycle/ViewModel;", "", "X1", "", "W1", "U1", "Lcom/tencent/videocut/model/MediaClip;", "L1", "", "M1", "Landroid/graphics/Matrix;", "P1", "Landroid/graphics/RectF;", "O1", "Landroid/os/Bundle;", "arguments", "Z1", "", "position", "b2", "result", ICustomDataEditor.STRING_ARRAY_PARAM_2, "unDoSize", "redoSize", "c2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "getMediaClips", "()Ljava/util/ArrayList;", "mediaClips", "Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "N1", "setMosaicList", "(Ljava/util/ArrayList;)V", "mosaicList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/editor/crop/model/a;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_winkCropVideoList", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "winkCropVideoList", "E", "_selectIndex", UserInfo.SEX_FEMALE, "Q1", "selectIndexLiveData", "G", "_controlLiveData", "H", "getControlLiveData", "controlLiveData", "I", "_showUndoLiveData", "J", "S1", "showUndoLiveData", "K", "_showRedoLiveData", "L", "R1", "showRedoLiveData", "<init>", "()V", "M", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<com.tencent.mobileqq.wink.editor.crop.model.a>> _winkCropVideoList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ArrayList<com.tencent.mobileqq.wink.editor.crop.model.a>> winkCropVideoList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _selectIndex;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> selectIndexLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _controlLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> controlLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showUndoLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showUndoLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showRedoLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showRedoLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MediaClip> mediaClips = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<MosaicData> mosaicList = new ArrayList<>();

    public a() {
        MutableLiveData<ArrayList<com.tencent.mobileqq.wink.editor.crop.model.a>> mutableLiveData = new MutableLiveData<>();
        this._winkCropVideoList = mutableLiveData;
        this.winkCropVideoList = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._selectIndex = mutableLiveData2;
        this.selectIndexLiveData = mutableLiveData2;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>();
        this._controlLiveData = mutableLiveData3;
        this.controlLiveData = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._showUndoLiveData = mutableLiveData4;
        this.showUndoLiveData = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this._showRedoLiveData = mutableLiveData5;
        this.showRedoLiveData = mutableLiveData5;
    }

    private final void X1() {
        int collectionSizeOrDefault;
        ArrayList<MediaClip> arrayList = this.mediaClips;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                arrayList2.add(resourceModel);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList<com.tencent.mobileqq.wink.editor.crop.model.a> arrayList3 = new ArrayList<>(collectionSizeOrDefault);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(new com.tencent.mobileqq.wink.editor.crop.model.a((ResourceModel) it5.next()));
        }
        this._winkCropVideoList.postValue(arrayList3);
    }

    @NotNull
    public final MediaClip L1() {
        ArrayList<MediaClip> arrayList = this.mediaClips;
        Integer value = this._selectIndex.getValue();
        if (value == null) {
            value = 0;
        }
        MediaClip mediaClip = arrayList.get(value.intValue());
        Intrinsics.checkNotNullExpressionValue(mediaClip, "mediaClips[_selectIndex.value ?: 0]");
        return mediaClip;
    }

    @NotNull
    public final String M1() {
        String str;
        ArrayList<MediaClip> arrayList = this.mediaClips;
        Integer value = this._selectIndex.getValue();
        if (value == null) {
            value = 0;
        }
        ResourceModel resourceModel = arrayList.get(value.intValue()).resource;
        if (resourceModel == null || (str = resourceModel.path) == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final ArrayList<MosaicData> N1() {
        return this.mosaicList;
    }

    @Nullable
    public final RectF O1() {
        ResourceModel resourceModel;
        com.tencent.videocut.model.RectF rectF;
        MediaClip L1 = L1();
        if (L1 != null && (resourceModel = L1.resource) != null && (rectF = resourceModel.picClipRect) != null) {
            RectF rectF2 = new RectF();
            rectF2.left = rectF.left;
            rectF2.top = rectF.top;
            rectF2.right = rectF.right;
            rectF2.bottom = rectF.bottom;
            return rectF2;
        }
        return null;
    }

    @NotNull
    public final Matrix P1() {
        return MatrixTransform.transListMatrixToMatrix(L1().matrix);
    }

    @NotNull
    public final LiveData<Integer> Q1() {
        return this.selectIndexLiveData;
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        return this.showRedoLiveData;
    }

    @NotNull
    public final LiveData<Boolean> S1() {
        return this.showUndoLiveData;
    }

    @NotNull
    public final LiveData<ArrayList<com.tencent.mobileqq.wink.editor.crop.model.a>> T1() {
        return this.winkCropVideoList;
    }

    public final boolean U1() {
        ArrayList<MosaicData> arrayList = this.mosaicList;
        Integer value = this._selectIndex.getValue();
        if (value == null) {
            value = 0;
        }
        if (arrayList.get(value.intValue()).getUndoPathList().size() == 0) {
            return false;
        }
        return true;
    }

    public final boolean W1() {
        ArrayList<MosaicData> arrayList = this.mosaicList;
        Integer value = this._selectIndex.getValue();
        if (value == null) {
            value = 0;
        }
        if (arrayList.get(value.intValue()).getPathList().size() == 0) {
            return false;
        }
        return true;
    }

    public final void Z1(@Nullable Bundle arguments) {
        ArrayList arrayList;
        Serializable serializable;
        ArrayList arrayList2 = null;
        if (arguments != null) {
            arrayList = arguments.getParcelableArrayList("KEY_MEDIA_CLIP");
        } else {
            arrayList = null;
        }
        if (!(arrayList instanceof ArrayList)) {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mediaClips.clear();
            this.mediaClips.addAll(arrayList);
        }
        if (arguments != null) {
            serializable = arguments.getSerializable("KEY_MEDIA_MOSAIC");
        } else {
            serializable = null;
        }
        if (serializable instanceof ArrayList) {
            arrayList2 = (ArrayList) serializable;
        }
        int i3 = 0;
        if (arrayList2 != null) {
            arguments.remove("KEY_MEDIA_MOSAIC");
            this.mosaicList.clear();
            this.mosaicList.addAll(arrayList2);
        } else {
            int size = this.mediaClips.size();
            for (int i16 = 0; i16 < size; i16++) {
                this.mosaicList.add(new MosaicData(new CopyOnWriteArrayList(), new CopyOnWriteArrayList(), null, 4, null));
            }
        }
        if (arguments != null) {
            i3 = arguments.getInt("KEY_SELECT_INDEX", 0);
        }
        this._selectIndex.postValue(Integer.valueOf(i3));
        X1();
    }

    public final void a2(@Nullable String result) {
        b.a("MosaicViewModel", "saveDoodleBitmapPath... " + this._selectIndex.getValue());
        ArrayList<MosaicData> arrayList = this.mosaicList;
        Integer value = this._selectIndex.getValue();
        if (value == null) {
            value = 0;
        }
        arrayList.get(value.intValue()).setResultPath(result);
    }

    public final void b2(int position) {
        this._selectIndex.postValue(Integer.valueOf(position));
    }

    public final void c2(int unDoSize, int redoSize) {
        boolean z16;
        MutableLiveData<Boolean> mutableLiveData = this._showUndoLiveData;
        boolean z17 = true;
        if (unDoSize != 0 && redoSize != 30) {
            z16 = true;
        } else {
            z16 = false;
        }
        mutableLiveData.postValue(Boolean.valueOf(z16));
        MutableLiveData<Boolean> mutableLiveData2 = this._showRedoLiveData;
        if (redoSize == 0) {
            z17 = false;
        }
        mutableLiveData2.postValue(Boolean.valueOf(z17));
    }
}
