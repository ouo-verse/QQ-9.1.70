package com.tencent.mobileqq.wink.editor.filter;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.view.BorderView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.LutFilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0000\u00a2\u0006\u0004\bh\u0010iJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007J\u0014\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J0\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u000fJ\u001c\u0010\u001c\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017J\u0010\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017J$\u0010\"\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\u000fH\u0016J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#J\u001a\u0010(\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020)H\u0016R\u001c\u0010.\u001a\n +*\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001f\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00101R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0003038\u0006\u00a2\u0006\f\n\u0004\b;\u00105\u001a\u0004\b<\u00107R\u001c\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u00101R\u001f\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>038\u0006\u00a2\u0006\f\n\u0004\bA\u00105\u001a\u0004\bB\u00107R(\u0010I\u001a\u0004\u0018\u00010\u00032\b\u0010D\u001a\u0004\u0018\u00010\u00038\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\"\u0010O\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010V\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00030\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010[R\u0018\u0010c\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\"\u0010g\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010J\u001a\u0004\be\u0010L\"\u0004\bf\u0010N\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/af;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/wink/editor/filter/h;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "U1", "", "filterMaterials", "c2", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "e2", "Lcom/tencent/mobileqq/wink/editor/dr;", "winkTavCutDelegate", "", "W", "k0", "Z1", "Lcom/tencent/mobileqq/wink/editor/filter/an;", "currentFilterVideoItem", "b2", "O1", "Lcom/tencent/videocut/model/FilterModel;", "S1", "model", "isAllClip", "g2", "W1", "R1", "N1", "filterModel", ICustomDataEditor.STRING_ARRAY_PARAM_2, "needRefresh", "d0", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$Direction;", "direction", "f2", "", "intensity", "n0", "", "getLogTag", "kotlin.jvm.PlatformType", "i", "Ljava/lang/String;", "TAG", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_filterMaterialLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "filterMaterialLiveData", "D", "_filterMaterialFromSwipeLiveData", "E", "P1", "filterMaterialFromSwipeLiveData", "Lcom/tencent/mobileqq/wink/editor/filter/g;", UserInfo.SEX_FEMALE, "_curFilterModelLiveData", "G", "M1", "curFilterModelLiveData", "<set-?>", "H", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "L1", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "curFilterMaterial", "I", "getCurIndex", "()I", "X1", "(I)V", "curIndex", "J", "Z", "getHasAutoFilter", "()Z", "setHasAutoFilter", "(Z)V", "hasAutoFilter", "K", "Lcom/tencent/videocut/model/FilterModel;", "curFilterModel", "L", "Ljava/util/List;", "Ljava/util/ArrayList;", "M", "Ljava/util/ArrayList;", "swipeMaterialList", "N", "P", "Lcom/tencent/mobileqq/wink/editor/filter/an;", "mCurrentVideoItem", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "T1", "d2", "filterRangeMode", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class af extends BaseViewModel implements h {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MetaMaterial> filterMaterialLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<MetaMaterial> _filterMaterialFromSwipeLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MetaMaterial> filterMaterialFromSwipeLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<g> _curFilterModelLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<g> curFilterModelLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial curFilterMaterial;

    /* renamed from: I, reason: from kotlin metadata */
    private int curIndex;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean hasAutoFilter;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private FilterModel curFilterModel;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private List<MetaMaterial> filterMaterials;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<MetaMaterial> swipeMaterialList;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private List<? extends MediaClip> mediaClips;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private an mCurrentVideoItem;

    /* renamed from: Q, reason: from kotlin metadata */
    private int filterRangeMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String TAG = af.class.getSimpleName();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<MetaMaterial> _filterMaterialLiveData;

    public af() {
        MutableLiveData<MetaMaterial> mutableLiveData = new MutableLiveData<>();
        this._filterMaterialLiveData = mutableLiveData;
        this.filterMaterialLiveData = mutableLiveData;
        MutableLiveData<MetaMaterial> mutableLiveData2 = new MutableLiveData<>();
        this._filterMaterialFromSwipeLiveData = mutableLiveData2;
        this.filterMaterialFromSwipeLiveData = mutableLiveData2;
        MutableLiveData<g> mutableLiveData3 = new MutableLiveData<>();
        this._curFilterModelLiveData = mutableLiveData3;
        this.curFilterModelLiveData = mutableLiveData3;
        this.swipeMaterialList = new ArrayList<>();
        this.mediaClips = new ArrayList();
        this.filterRangeMode = 102;
    }

    private final void U1(MetaMaterial material) {
        Map<String, Object> mParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(mParams, "mParams");
        mParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_FILTER_ITEM);
        mParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME, material.f30533id);
        mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_CATEGORY, com.tencent.mobileqq.wink.editor.c.o(material));
        mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_SLIDING_VALUE, Integer.valueOf(f.i(material)));
        VideoReport.reportEvent("ev_xsj_left_right_slide", null, mParams);
    }

    @Nullable
    /* renamed from: L1, reason: from getter */
    public final MetaMaterial getCurFilterMaterial() {
        return this.curFilterMaterial;
    }

    @NotNull
    public final LiveData<g> M1() {
        return this.curFilterModelLiveData;
    }

    @Nullable
    /* renamed from: N1, reason: from getter */
    public final FilterModel getCurFilterModel() {
        return this.curFilterModel;
    }

    @Nullable
    /* renamed from: O1, reason: from getter */
    public final an getMCurrentVideoItem() {
        return this.mCurrentVideoItem;
    }

    @NotNull
    public final LiveData<MetaMaterial> P1() {
        return this.filterMaterialFromSwipeLiveData;
    }

    @NotNull
    public final LiveData<MetaMaterial> Q1() {
        return this.filterMaterialLiveData;
    }

    @Nullable
    public final FilterModel R1(@Nullable MetaMaterial material) {
        if (material == null) {
            return null;
        }
        String a06 = com.tencent.mobileqq.wink.editor.c.a0(material);
        String str = material.f30533id;
        Intrinsics.checkNotNullExpressionValue(str, "material.id");
        String f16 = WinkEditorResourceManager.a1().f1(material);
        Intrinsics.checkNotNullExpressionValue(f16, "getInstance().getLutPath(material)");
        LutFilterModel lutFilterModel = new LutFilterModel(a06, str, f16, f.i(material), com.tencent.mobileqq.wink.editor.c.o(material), null, null, 96, null);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return new FilterModel(uuid, lutFilterModel, null, 0L, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, null, 0 == true ? 1 : 0, 108, null);
    }

    @Nullable
    public final FilterModel S1() {
        FilterModel filterModel = this.curFilterModel;
        if (filterModel != null) {
            return FilterModel.copy$default(filterModel, null, null, null, 0L, Long.valueOf(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH), null, null, 103, null);
        }
        return null;
    }

    /* renamed from: T1, reason: from getter */
    public final int getFilterRangeMode() {
        return this.filterRangeMode;
    }

    @Override // com.tencent.mobileqq.wink.editor.filter.h
    public boolean W(@Nullable dr winkTavCutDelegate, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        String O0 = WinkEditorResourceManager.a1().O0(material);
        if (com.tencent.mobileqq.wink.flow.c.b(material) && !TextUtils.isEmpty(O0) && new File(O0).exists()) {
            return true;
        }
        return false;
    }

    public void W1(@Nullable dr winkTavCutDelegate, @Nullable MetaMaterial material) {
        if (material == null) {
            this.curFilterMaterial = null;
            this.curFilterModel = null;
            this._filterMaterialLiveData.postValue(null);
            this._curFilterModelLiveData.postValue(null);
            return;
        }
        this.curFilterMaterial = material;
        if (f.r(material)) {
            return;
        }
        this.curFilterModel = R1(material);
        this._filterMaterialLiveData.postValue(this.curFilterMaterial);
        MutableLiveData<g> mutableLiveData = this._curFilterModelLiveData;
        FilterModel filterModel = this.curFilterModel;
        Intrinsics.checkNotNull(filterModel);
        MetaMaterial metaMaterial = this.curFilterMaterial;
        Intrinsics.checkNotNull(metaMaterial);
        mutableLiveData.postValue(new g(filterModel, metaMaterial, false, 4, null));
    }

    public final void X1(int i3) {
        this.curIndex = i3;
    }

    public final void Z1(@Nullable MetaMaterial material) {
        this.curFilterMaterial = material;
    }

    public final void a2(@Nullable FilterModel filterModel) {
        this.curFilterModel = filterModel;
    }

    public final void b2(@Nullable an currentFilterVideoItem) {
        this.mCurrentVideoItem = currentFilterVideoItem;
    }

    public final void c2(@NotNull List<MetaMaterial> filterMaterials) {
        Intrinsics.checkNotNullParameter(filterMaterials, "filterMaterials");
        this.filterMaterials = filterMaterials;
    }

    @Override // com.tencent.mobileqq.wink.editor.filter.h
    public void d0(@Nullable dr winkTavCutDelegate, @Nullable MetaMaterial material, boolean needRefresh) {
        W1(winkTavCutDelegate, material);
    }

    public final void d2(int i3) {
        this.filterRangeMode = i3;
    }

    public final void e2(@NotNull List<? extends MediaClip> mediaClips) {
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        this.mediaClips = mediaClips;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        if (com.tencent.mobileqq.wink.editor.c.K(r7) != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        if (com.tencent.mobileqq.wink.editor.c.K(r7) == 0) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f2(@NotNull BorderView.Direction direction) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(direction, "direction");
        List<MetaMaterial> list = this.filterMaterials;
        if (list == null) {
            return;
        }
        this.swipeMaterialList.clear();
        int size = list.size() - 1;
        List<MetaMaterial> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (f.r((MetaMaterial) it.next())) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        this.hasAutoFilter = z16;
        if (this.curFilterMaterial == null) {
            this.swipeMaterialList.addAll(list);
        }
        if (this.curIndex == 0) {
            if (direction == BorderView.Direction.Left) {
                this.curIndex = 1;
                i3 = this.hasAutoFilter;
            } else {
                this.curIndex = list.size();
                i3 = size;
            }
        } else {
            if (direction == BorderView.Direction.Right) {
                MetaMaterial metaMaterial = this.curFilterMaterial;
                if (metaMaterial != null) {
                    if (this.hasAutoFilter) {
                        Intrinsics.checkNotNull(metaMaterial);
                        if (com.tencent.mobileqq.wink.editor.c.K(metaMaterial) != 1) {
                            MetaMaterial metaMaterial2 = this.curFilterMaterial;
                            Intrinsics.checkNotNull(metaMaterial2);
                        }
                    }
                    if (!this.hasAutoFilter) {
                        MetaMaterial metaMaterial3 = this.curFilterMaterial;
                        Intrinsics.checkNotNull(metaMaterial3);
                    }
                    MetaMaterial metaMaterial4 = this.curFilterMaterial;
                    Intrinsics.checkNotNull(metaMaterial4);
                    i3 = com.tencent.mobileqq.wink.editor.c.K(metaMaterial4) - 1;
                }
                W1(null, null);
                this.curIndex = 0;
                return;
            }
            MetaMaterial metaMaterial5 = this.curFilterMaterial;
            if (metaMaterial5 != null) {
                Intrinsics.checkNotNull(metaMaterial5);
                if (com.tencent.mobileqq.wink.editor.c.K(metaMaterial5) != list.size() - 1) {
                    MetaMaterial metaMaterial6 = this.curFilterMaterial;
                    Intrinsics.checkNotNull(metaMaterial6);
                    i3 = com.tencent.mobileqq.wink.editor.c.K(metaMaterial6) + 1;
                }
            }
            W1(null, null);
            this.curIndex = 0;
            return;
        }
        if (i3 <= size && i3 >= 0) {
            MetaMaterial metaMaterial7 = list.get(i3);
            if (W(null, metaMaterial7)) {
                this._filterMaterialFromSwipeLiveData.postValue(metaMaterial7);
                U1(metaMaterial7);
            }
        }
    }

    @Nullable
    public final List<MediaClip> g2(@Nullable List<? extends MediaClip> mediaClips, @Nullable FilterModel model, boolean isAllClip) {
        int collectionSizeOrDefault;
        af afVar;
        String str;
        String str2;
        if (mediaClips == null) {
            return null;
        }
        List<? extends MediaClip> list = mediaClips;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list) {
            if (!isAllClip) {
                ResourceModel resourceModel = mediaClip.resource;
                if (resourceModel != null) {
                    str = resourceModel.id;
                    afVar = this;
                } else {
                    afVar = this;
                    str = null;
                }
                an anVar = afVar.mCurrentVideoItem;
                if (anVar != null) {
                    str2 = anVar.getId();
                } else {
                    str2 = null;
                }
                if (!Intrinsics.areEqual(str, str2)) {
                    arrayList.add(mediaClip);
                }
            }
            mediaClip = MediaClip.copy$default(mediaClip, null, null, model, null, null, null, null, 123, null);
            arrayList.add(mediaClip);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return TAG;
    }

    @Override // com.tencent.mobileqq.wink.editor.filter.h
    public void k0(@Nullable dr winkTavCutDelegate) {
        W1(winkTavCutDelegate, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.filter.h
    public void n0(@Nullable dr winkTavCutDelegate, int intensity) {
        LutFilterModel lutFilterModel;
        MetaMaterial metaMaterial = this.curFilterMaterial;
        if (metaMaterial != null) {
            Intrinsics.checkNotNull(metaMaterial);
            if (f.r(metaMaterial)) {
                return;
            }
        }
        MetaMaterial metaMaterial2 = this.curFilterMaterial;
        if (metaMaterial2 != null) {
            f.A(metaMaterial2, intensity);
        }
        an anVar = this.mCurrentVideoItem;
        if (anVar != null) {
            anVar.l(Integer.valueOf(intensity));
        }
        FilterModel filterModel = this.curFilterModel;
        if (filterModel != null && (lutFilterModel = filterModel.lut) != null) {
            this.curFilterModel = FilterModel.copy$default(filterModel, null, LutFilterModel.copy$default(lutFilterModel, null, null, null, Float.valueOf(intensity), null, null, null, 119, null), null, null, null, null, null, 125, null);
            this._curFilterModelLiveData.postValue(new g(filterModel, this.curFilterMaterial, true));
        }
    }
}
