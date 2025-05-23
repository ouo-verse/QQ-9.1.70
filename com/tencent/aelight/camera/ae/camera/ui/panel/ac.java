package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0002\u0014\u0015B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001f\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/ac;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem;", "appliedFilter", "", "N1", "M1", "Landroidx/lifecycle/MediatorLiveData;", "i", "Landroidx/lifecycle/MediatorLiveData;", "_selectedFilter", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "L1", "()Landroidx/lifecycle/LiveData;", "selectedFilter", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ac extends ViewModel {
    private static final Map<String, LutMappingData> D;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MediatorLiveData<QIMFilterCategoryItem> _selectedFilter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<QIMFilterCategoryItem> selectedFilter;

    static {
        Map<String, LutMappingData> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("\u84dd\u5c9b", new LutMappingData(0.01125f, 0.005f, 80)), TuplesKt.to("\u5976\u8336", new LutMappingData(0.01125f, 0.005f, 80)), TuplesKt.to("\u7126\u7cd6", new LutMappingData(0.010625f, 0.0075f, 80)), TuplesKt.to("\u871c\u6843\u7c89", new LutMappingData(0.010625f, 0.0075f, 80)), TuplesKt.to("\u98ce\u666f/\u5c0f\u6a3d", new LutMappingData(0.00875f, 0.011875f, 80)), TuplesKt.to("\u65b0\u9510/\u62cd\u7acb\u5f97", new LutMappingData(0.01125f, 0.005f, 80)), TuplesKt.to("\u65b0\u9510/\u83f2\u6797", new LutMappingData(0.01125f, 0.005f, 80)));
        D = mapOf;
    }

    public ac() {
        MediatorLiveData<QIMFilterCategoryItem> mediatorLiveData = new MediatorLiveData<>();
        this._selectedFilter = mediatorLiveData;
        Intrinsics.checkNotNull(mediatorLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem?>");
        this.selectedFilter = mediatorLiveData;
    }

    public final LiveData<QIMFilterCategoryItem> L1() {
        return this.selectedFilter;
    }

    public final void M1() {
        QIMFilterCategoryItem value = this._selectedFilter.getValue();
        if (value == null) {
            return;
        }
        this._selectedFilter.postValue(value);
    }

    public final void N1(QIMFilterCategoryItem appliedFilter) {
        this._selectedFilter.postValue(appliedFilter);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/ac$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "getK1", "()F", "k1", "b", "getK2", "k2", "c", "I", "getSeekThreshold", "()I", "seekThreshold", "<init>", "(FFI)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.panel.ac$b, reason: from toString */
    /* loaded from: classes32.dex */
    public static final /* data */ class LutMappingData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final float k1;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float k2;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int seekThreshold;

        public LutMappingData(float f16, float f17, int i3) {
            this.k1 = f16;
            this.k2 = f17;
            this.seekThreshold = i3;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.k1) * 31) + Float.floatToIntBits(this.k2)) * 31) + this.seekThreshold;
        }

        public String toString() {
            return "LutMappingData(k1=" + this.k1 + ", k2=" + this.k2 + ", seekThreshold=" + this.seekThreshold + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LutMappingData)) {
                return false;
            }
            LutMappingData lutMappingData = (LutMappingData) other;
            return Float.compare(this.k1, lutMappingData.k1) == 0 && Float.compare(this.k2, lutMappingData.k2) == 0 && this.seekThreshold == lutMappingData.seekThreshold;
        }
    }
}
