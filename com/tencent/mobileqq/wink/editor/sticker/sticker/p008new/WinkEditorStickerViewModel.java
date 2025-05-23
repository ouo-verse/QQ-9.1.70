package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorStickerResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.editor.sticker.sticker.RecentStickerData;
import com.tencent.mobileqq.wink.editor.sticker.sticker.h;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.Size;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008f\u0001B\u0011\u0012\u0006\u0010A\u001a\u00020>\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001JF\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J.\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0011j\b\u0012\u0004\u0012\u00020\u000f`\u00122\u0006\u0010\u000e\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0002J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\b2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0011j\b\u0012\u0004\u0012\u00020\b`\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u001e\u0010 \u001a\u00020\f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001f\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020!H\u0016J&\u0010#\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0006\u0010$\u001a\u00020\u0016J6\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u0007J\u001e\u0010,\u001a\u00020\u00162\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\nJ\u000e\u0010/\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\nJ\b\u00100\u001a\u00020\u0016H\u0014J\u0016\u00102\u001a\u00020\u00162\u0006\u0010)\u001a\u00020!2\u0006\u00101\u001a\u00020\nJ\u0006\u00103\u001a\u00020\u0016J\u0006\u00104\u001a\u00020\u0016J\u0006\u00105\u001a\u00020\u0016J\u000e\u00107\u001a\u00020\u00162\u0006\u00106\u001a\u00020%J\u000e\u00109\u001a\u00020\u00162\u0006\u00108\u001a\u00020!J\u0016\u0010<\u001a\u00020\u00162\u0006\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020!J\u0006\u0010=\u001a\u00020\u0016R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR \u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR#\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070J8\u0006\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\f0F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010HR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020\f0J8\u0006\u00a2\u0006\f\n\u0004\bR\u0010L\u001a\u0004\bS\u0010NR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u001d\u0010_\u001a\b\u0012\u0004\u0012\u00020V0Z8\u0006\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R$\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0011j\b\u0012\u0004\u0012\u00020\f`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u001e\u0010h\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010`R\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR \u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020p0\u00070o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\"\u0010~\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0017\u0010\u0080\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010`R\u0018\u0010\u0082\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010yR\u0018\u0010\u0084\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010yR)\u0010\u008b\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001\u00a8\u0006\u0090\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorStickerViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editType", "Lcom/tencent/videocut/model/Size;", "containerSize", "renderSize", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "categoryList", "", "selectTopTabIndex", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/a;", "f2", "columnNum", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "mates", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i2", "root", "result", "", "m2", ICustomDataEditor.STRING_PARAM_2, "I2", "y2", "B2", "initData", "k2", "cates", "stickerDisplayCount", "l2", "", "getLogTag", Constants.MMCCID, "H2", "", "videoMode", "datas", "j2", "tabCateId", "position", WadlProxyConsts.KEY_MATERIAL, "r2", "x2", "index", "t2", "onCleared", c.G, "u2", "w2", SemanticAttributes.DbSystemValues.H2, "v2", "anim", "g2", "keyword", "C2", "isUserInput", "text", NowProxyConstants.AccountInfoKey.A2, Constants.BASE_IN_PLUGIN_VERSION, "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/b;", "i", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/b;", "dataSource", "Lkotlinx/coroutines/CoroutineScope;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_stickerData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "o2", "()Landroidx/lifecycle/LiveData;", "stickerData", "E", "_stickerSearchData", UserInfo.SEX_FEMALE, "q2", "stickerSearchData", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/d;", "G", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_stickerMenuEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "H", "Lkotlinx/coroutines/flow/SharedFlow;", "p2", "()Lkotlinx/coroutines/flow/SharedFlow;", "stickerMenuEvent", "I", "Ljava/util/ArrayList;", "currentData", "J", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "searchInitData", "K", "Ljava/util/List;", "lastSearchData", "L", "lastSearchDataStickerPage", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/h;", "M", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/h;", "recentStickerManager", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/RecentStickerData;", "N", "Landroidx/lifecycle/Observer;", "recentStickerObserver", "Lkotlinx/coroutines/Job;", "P", "Lkotlinx/coroutines/Job;", "searchJob", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "getHasSelectedSticker", "()Z", "F2", "(Z)V", "hasSelectedSticker", BdhLogUtil.LogTag.Tag_Req, "currentTopTabIndex", ExifInterface.LATITUDE_SOUTH, "searchOpened", "T", "firstEnter", "U", "Ljava/lang/String;", ICustomDataEditor.NUMBER_PARAM_2, "()Ljava/lang/String;", "E2", "(Ljava/lang/String;)V", "currentText", "<init>", "(Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/b;)V", "V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorStickerViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<StickerListData>> _stickerData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<StickerListData>> stickerData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<StickerListData> _stickerSearchData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<StickerListData> stickerSearchData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<d> _stickerMenuEvent;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<d> stickerMenuEvent;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<StickerListData> currentData;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private MetaCategory searchInitData;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private List<MetaCategory> lastSearchData;

    /* renamed from: L, reason: from kotlin metadata */
    private int lastSearchDataStickerPage;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final h recentStickerManager;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Observer<List<RecentStickerData>> recentStickerObserver;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Job searchJob;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean hasSelectedSticker;

    /* renamed from: R, reason: from kotlin metadata */
    private int currentTopTabIndex;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean searchOpened;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean firstEnter;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private String currentText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b dataSource;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope;

    public WinkEditorStickerViewModel(@NotNull b dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.dataSource = dataSource;
        this.viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        MutableLiveData<List<StickerListData>> mutableLiveData = new MutableLiveData<>();
        this._stickerData = mutableLiveData;
        this.stickerData = mutableLiveData;
        MutableLiveData<StickerListData> mutableLiveData2 = new MutableLiveData<>();
        this._stickerSearchData = mutableLiveData2;
        this.stickerSearchData = mutableLiveData2;
        MutableSharedFlow<d> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._stickerMenuEvent = MutableSharedFlow$default;
        this.stickerMenuEvent = MutableSharedFlow$default;
        this.currentData = new ArrayList<>();
        this.recentStickerManager = new h();
        this.recentStickerObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorStickerViewModel.z2(WinkEditorStickerViewModel.this, (List) obj);
            }
        };
        s2();
        this.firstEnter = true;
        this.currentText = "";
    }

    private final void B2() {
        List emptyList;
        MetaCategory y26 = y2();
        if (y26 != null) {
            Intrinsics.checkNotNullExpressionValue(y26.subCategories, "searchData.subCategories");
            if (!r0.isEmpty()) {
                MutableLiveData<StickerListData> mutableLiveData = this._stickerSearchData;
                ArrayList<MetaCategory> arrayList = y26.subCategories;
                Intrinsics.checkNotNullExpressionValue(arrayList, "searchData.subCategories");
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                mutableLiveData.postValue(new StickerListData(y26, arrayList, emptyList, 0, false, false, 56, null));
            }
        }
    }

    private final void I2() {
        WinkEditorResourceManager.a1().D1().removeObserver(this.recentStickerObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<StickerListData> f2(WinkEditorViewModel.EditMode editType, Size containerSize, Size renderSize, List<MetaCategory> categoryList, int selectTopTabIndex) {
        Size size;
        Size size2;
        int collectionSizeOrDefault;
        boolean z16;
        int i3;
        ArrayList arrayList = new ArrayList();
        boolean z17 = false;
        int i16 = 0;
        for (MetaCategory metaCategory : categoryList) {
            int i17 = i16 + 1;
            ArrayList<MetaCategory> arrayList2 = new ArrayList<>();
            ArrayList<MetaCategory> bottomCategories = metaCategory.subCategories;
            m2(metaCategory, arrayList2);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            for (MetaCategory metaCategory2 : arrayList2) {
                MetaCategory b16 = com.tencent.mobileqq.wink.editor.c.b(metaCategory2);
                if (Intrinsics.areEqual(b16.f30532id, "qq_favorite_sticker") && b16.materials.isEmpty()) {
                    ArrayList<MetaMaterial> arrayList4 = b16.materials;
                    MetaMaterial metaMaterial = new MetaMaterial();
                    metaMaterial.f30533id = "qq_favor_empty_id";
                    arrayList4.add(metaMaterial);
                } else {
                    if (Intrinsics.areEqual(metaCategory2.f30532id, "qq_small_sticker")) {
                        i3 = 6;
                    } else {
                        i3 = 4;
                    }
                    List<MetaMaterial> list = b16.materials;
                    Intrinsics.checkNotNullExpressionValue(list, "newCate.materials");
                    b16.materials = i2(i3, list);
                }
                arrayList3.add(b16);
            }
            Intrinsics.checkNotNullExpressionValue(bottomCategories, "bottomCategories");
            if (selectTopTabIndex == i16) {
                z16 = true;
            } else {
                z16 = false;
            }
            arrayList.add(new StickerListData(metaCategory, arrayList3, bottomCategories, 0, false, z16, 24, null));
            i16 = i17;
        }
        if (editType == WinkEditorViewModel.EditMode.Video) {
            size = containerSize;
            size2 = renderSize;
            z17 = true;
        } else {
            size = containerSize;
            size2 = renderSize;
        }
        return j2(size, size2, z17, arrayList);
    }

    private final ArrayList<MetaMaterial> i2(int columnNum, List<MetaMaterial> mates) {
        IntRange until;
        int collectionSizeOrDefault;
        int size = mates.size() % columnNum;
        ArrayList<MetaMaterial> arrayList = new ArrayList<>(mates);
        if (size != 0) {
            until = RangesKt___RangesKt.until(0, columnNum - size);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                arrayList2.add(com.tencent.mobileqq.wink.editor.c.f1());
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StickerListData k2(MetaCategory initData) {
        Object obj;
        ArrayList<MetaMaterial> arrayListOf;
        List<MetaCategory> listOfNotNull;
        List emptyList;
        ArrayList<MetaCategory> arrayList = initData.subCategories;
        Intrinsics.checkNotNullExpressionValue(arrayList, "initData.subCategories");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "1000291")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MetaCategory metaCategory = new MetaCategory();
        metaCategory.f30532id = "sticker_search_empty_id";
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "sticker_search_empty_id";
        Unit unit = Unit.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(metaMaterial);
        metaCategory.materials = arrayListOf;
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new MetaCategory[]{metaCategory, (MetaCategory) obj});
        MetaCategory i3 = WinkEditorStickerResourceManager.f318326a.i(listOfNotNull);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new StickerListData(i3, listOfNotNull, emptyList, 0, false, false, 56, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StickerListData l2(List<MetaCategory> cates, int stickerDisplayCount) {
        int collectionSizeOrDefault;
        List<MetaCategory> flatten;
        List emptyList;
        List listOf;
        List take;
        ArrayList<MetaMaterial> arrayListOf;
        List<MetaCategory> list = cates;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            MetaCategory b16 = com.tencent.mobileqq.wink.editor.c.b((MetaCategory) it.next());
            if (!Intrinsics.areEqual(b16.f30532id, "SEARCH_STICKER")) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
            } else if (b16.materials.size() > stickerDisplayCount) {
                ArrayList<MetaMaterial> arrayList2 = b16.materials;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "copy.materials");
                take = CollectionsKt___CollectionsKt.take(arrayList2, stickerDisplayCount);
                b16.materials = new ArrayList<>(take);
                MetaCategory metaCategory = new MetaCategory();
                metaCategory.f30532id = "search_load_more_id";
                MetaMaterial metaMaterial = new MetaMaterial();
                metaMaterial.f30533id = "search_load_more_id";
                Unit unit = Unit.INSTANCE;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(metaMaterial);
                metaCategory.materials = arrayListOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MetaCategory[]{b16, metaCategory});
            } else {
                ArrayList<MetaMaterial> arrayList3 = b16.materials;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "copy.materials");
                b16.materials = i2(4, arrayList3);
                listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
            }
            arrayList.add(listOf);
        }
        flatten = CollectionsKt__IterablesKt.flatten(arrayList);
        MetaCategory i3 = WinkEditorStickerResourceManager.f318326a.i(flatten);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new StickerListData(i3, flatten, emptyList, 0, false, false, 56, null);
    }

    private final void m2(MetaCategory root, ArrayList<MetaCategory> result) {
        ArrayList<MetaCategory> arrayList = root.subCategories;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<MetaCategory> it = root.subCategories.iterator();
            while (it.hasNext()) {
                MetaCategory subCategory = it.next();
                Intrinsics.checkNotNullExpressionValue(subCategory, "subCategory");
                m2(subCategory, result);
            }
            return;
        }
        result.add(root);
    }

    private final void s2() {
        WinkEditorResourceManager.a1().D1().observeForever(this.recentStickerObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MetaCategory y2() {
        MetaCategory metaCategory = this.searchInitData;
        if (metaCategory == null) {
            return null;
        }
        MetaCategory b16 = com.tencent.mobileqq.wink.editor.c.b(metaCategory);
        ArrayList<MetaCategory> arrayList = b16.subCategories;
        Intrinsics.checkNotNullExpressionValue(arrayList, "copy.subCategories");
        CollectionsKt__MutableCollectionsKt.removeAll((List) arrayList, (Function1) new Function1<MetaCategory, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorStickerViewModel$prepareSearchInitData$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(MetaCategory metaCategory2) {
                boolean z16;
                boolean z17 = false;
                if (Intrinsics.areEqual(metaCategory2.f30532id, "1000290")) {
                    ArrayList<MetaMaterial> arrayList2 = metaCategory2.materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "cate.materials");
                    if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                        Iterator<T> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            if (!(!Intrinsics.areEqual(((MetaMaterial) it.next()).f30533id, "sticker_search_hot_text"))) {
                                z16 = false;
                                break;
                            }
                        }
                    }
                    z16 = true;
                    if (z16) {
                        z17 = true;
                    }
                }
                return Boolean.valueOf(z17);
            }
        });
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(WinkEditorStickerViewModel this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.f(this$0.getTAG(), "recentStickerObserver: data = " + it.size());
        h hVar = this$0.recentStickerManager;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        hVar.g(it);
    }

    public final void A2(boolean isUserInput, @NotNull String text) {
        String str;
        Intrinsics.checkNotNullParameter(text, "text");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        if (isUserInput) {
            str = "1";
        } else {
            str = "2";
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_SEARCH_QUERY_SOURCE, str);
        params.put("xsj_query_text", text);
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_START_SEARCH);
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", params);
    }

    public final void C2(@NotNull String keyword) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorStickerViewModel$search$1(this, keyword, null), 3, null);
        this.searchJob = launch$default;
    }

    public final void D2() {
        Object obj;
        List<MetaCategory> list = this.lastSearchData;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "SEARCH_STICKER")) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((MetaCategory) obj) != null) {
                this.lastSearchDataStickerPage++;
                MutableLiveData<StickerListData> mutableLiveData = this._stickerSearchData;
                List<MetaCategory> list2 = this.lastSearchData;
                Intrinsics.checkNotNull(list2);
                mutableLiveData.postValue(l2(list2, (this.lastSearchDataStickerPage + 1) * 12));
            }
        }
    }

    public final void E2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentText = str;
    }

    public final void F2(boolean z16) {
        this.hasSelectedSticker = z16;
    }

    public final void G2(@NotNull final WinkEditorViewModel.EditMode editType, @Nullable final Size containerSize, @Nullable final Size renderSize) {
        Intrinsics.checkNotNullParameter(editType, "editType");
        this.dataSource.b(new Function1<com.tencent.mobileqq.wink.editor.model.b, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorStickerViewModel$startObserveData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.wink.editor.model.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.mobileqq.wink.editor.model.b bVar) {
                Object obj;
                int i3;
                List f26;
                int i16;
                Object orNull;
                boolean z16;
                ArrayList arrayList;
                boolean z17;
                ArrayList arrayList2;
                ArrayList arrayList3;
                MutableLiveData mutableLiveData;
                if (bVar != null && bVar.a() != null) {
                    ArrayList arrayList4 = new ArrayList(bVar.a());
                    Iterator it = arrayList4.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it.next();
                            if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "search_default")) {
                                break;
                            }
                        }
                    }
                    MetaCategory metaCategory = (MetaCategory) obj;
                    arrayList4.remove(metaCategory);
                    WinkEditorStickerViewModel.this.searchInitData = metaCategory;
                    WinkEditorStickerViewModel winkEditorStickerViewModel = WinkEditorStickerViewModel.this;
                    WinkEditorViewModel.EditMode editMode = editType;
                    Size size = containerSize;
                    Size size2 = renderSize;
                    i3 = winkEditorStickerViewModel.currentTopTabIndex;
                    f26 = winkEditorStickerViewModel.f2(editMode, size, size2, arrayList4, i3);
                    i16 = WinkEditorStickerViewModel.this.currentTopTabIndex;
                    orNull = CollectionsKt___CollectionsKt.getOrNull(f26, i16);
                    StickerListData stickerListData = (StickerListData) orNull;
                    z16 = WinkEditorStickerViewModel.this.firstEnter;
                    int i17 = -1;
                    if (z16 && stickerListData != null) {
                        Iterator<MetaCategory> it5 = stickerListData.d().iterator();
                        int i18 = 0;
                        while (true) {
                            if (!it5.hasNext()) {
                                break;
                            }
                            if (Intrinsics.areEqual(it5.next().f30532id, "100020815")) {
                                i17 = i18;
                                break;
                            }
                            i18++;
                        }
                        stickerListData.l(i17 + 1);
                        stickerListData.m(true);
                    } else if (stickerListData != null) {
                        stickerListData.l(-1);
                    }
                    arrayList = WinkEditorStickerViewModel.this.currentData;
                    if (!Intrinsics.areEqual(f26, arrayList)) {
                        arrayList2 = WinkEditorStickerViewModel.this.currentData;
                        arrayList2.clear();
                        arrayList3 = WinkEditorStickerViewModel.this.currentData;
                        arrayList3.addAll(f26);
                        mutableLiveData = WinkEditorStickerViewModel.this._stickerData;
                        mutableLiveData.postValue(f26);
                    }
                    z17 = WinkEditorStickerViewModel.this.searchOpened;
                    if (z17) {
                        WinkEditorStickerViewModel.this.g2(false);
                        WinkEditorStickerViewModel.this.x2(0);
                    }
                    WinkEditorStickerViewModel.this.firstEnter = false;
                    return;
                }
                b.c(WinkEditorStickerViewModel.this.getTAG(), "empty data: requestData");
            }
        });
    }

    public final void H2() {
        this.dataSource.a();
    }

    public final void g2(boolean anim) {
        if (this.searchOpened) {
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorStickerViewModel$cancelSearch$1(this, anim, null), 3, null);
            v2();
            this.searchOpened = false;
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorStickerViewModel";
    }

    public final void h2() {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorStickerViewModel$clearSearchWord$1(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<StickerListData> j2(@Nullable Size containerSize, @Nullable Size renderSize, boolean videoMode, @NotNull List<StickerListData> datas) {
        boolean z16;
        int collectionSizeOrDefault;
        boolean z17;
        boolean z18;
        boolean z19;
        Integer num;
        Intrinsics.checkNotNullParameter(datas, "datas");
        if (containerSize != null && renderSize != null && ((num = containerSize.height) == null || num.intValue() != 0)) {
            Integer num2 = renderSize.height;
            Intrinsics.checkNotNull(num2);
            int intValue = num2.intValue();
            Intrinsics.checkNotNull(containerSize.height);
            if (((intValue - r5.intValue()) * 1.0f) / containerSize.height.intValue() > QzoneConfig.getWinkEditorFrameStickerThreshold() * 2) {
                z16 = true;
                boolean z26 = !videoMode;
                b.f(getTAG(), "filterSticker: filterFrameSticker = " + z16 + ", filterWatermarkSticker = " + z26);
                ArrayList<StickerListData> arrayList = new ArrayList();
                for (Object obj : datas) {
                    StickerListData stickerListData = (StickerListData) obj;
                    if (!videoMode && Intrinsics.areEqual(stickerListData.getTabType().f30532id, "qq_sticker")) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (z19) {
                        arrayList.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (StickerListData stickerListData2 : arrayList) {
                    List<MetaCategory> d16 = stickerListData2.d();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : d16) {
                        MetaCategory metaCategory = (MetaCategory) obj2;
                        if ((z16 && Intrinsics.areEqual("\u8fb9\u6846", metaCategory.name)) || (z26 && Intrinsics.areEqual(WinkMaterialViewModel.WATERMARK_CAT_ID, metaCategory.f30532id))) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (z18) {
                            arrayList3.add(obj2);
                        }
                    }
                    List<MetaCategory> j3 = stickerListData2.j();
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj3 : j3) {
                        MetaCategory metaCategory2 = (MetaCategory) obj3;
                        if ((z16 && Intrinsics.areEqual("\u8fb9\u6846", metaCategory2.name)) || (z26 && Intrinsics.areEqual(WinkMaterialViewModel.WATERMARK_CAT_ID, metaCategory2.f30532id))) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (z17) {
                            arrayList4.add(obj3);
                        }
                    }
                    arrayList2.add(StickerListData.c(stickerListData2, null, arrayList4, arrayList3, 0, false, false, 57, null));
                }
                return arrayList2;
            }
        }
        z16 = false;
        boolean z262 = !videoMode;
        b.f(getTAG(), "filterSticker: filterFrameSticker = " + z16 + ", filterWatermarkSticker = " + z262);
        ArrayList<StickerListData> arrayList5 = new ArrayList();
        while (r2.hasNext()) {
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10);
        ArrayList arrayList22 = new ArrayList(collectionSizeOrDefault);
        while (r5.hasNext()) {
        }
        return arrayList22;
    }

    @NotNull
    /* renamed from: n2, reason: from getter */
    public final String getCurrentText() {
        return this.currentText;
    }

    @NotNull
    public final LiveData<List<StickerListData>> o2() {
        return this.stickerData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        I2();
        CoroutineScopeKt.cancel$default(this.viewModelScope, null, 1, null);
    }

    @NotNull
    public final SharedFlow<d> p2() {
        return this.stickerMenuEvent;
    }

    @NotNull
    public final LiveData<StickerListData> q2() {
        return this.stickerSearchData;
    }

    public final void r2(@NotNull String tabCateId, int position, @NotNull MetaMaterial material) {
        IntRange until;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(tabCateId, "tabCateId");
        Intrinsics.checkNotNullParameter(material, "material");
        this.hasSelectedSticker = true;
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorStickerViewModel$insertRecentSticker$1(this, null), 3, null);
        b.f(getTAG(), "insertRecentSticker tabCateId : " + tabCateId + "\uff0c cate = " + com.tencent.mobileqq.wink.editor.c.o(material));
        if (Intrinsics.areEqual(tabCateId, "common_sticker") || Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(material), "1000291") || (Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(material), "SEARCH_STICKER") && Intrinsics.areEqual(tabCateId, "search_default"))) {
            ArrayList<MetaMaterial> c16 = this.recentStickerManager.c(material);
            ArrayList arrayList = new ArrayList(c16);
            Iterator<StickerListData> it = this.currentData.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().getTabType().f30532id, "common_sticker")) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 == -1) {
                return;
            }
            int size = arrayList.size() % 4;
            if (size != 0) {
                until = RangesKt___RangesKt.until(0, 4 - size);
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<Integer> it5 = until.iterator();
                while (it5.hasNext()) {
                    ((IntIterator) it5).nextInt();
                    arrayList2.add(com.tencent.mobileqq.wink.editor.c.f1());
                }
                arrayList.addAll(arrayList2);
            }
            StickerListData stickerListData = this.currentData.get(i3);
            h.Companion companion = h.INSTANCE;
            StickerListData a16 = stickerListData.a(companion.d(arrayList));
            ArrayList arrayList3 = new ArrayList(this.currentData);
            arrayList3.set(i3, a16);
            if (!Intrinsics.areEqual(this.currentData, arrayList3)) {
                this.currentData.clear();
                this.currentData.addAll(arrayList3);
                this._stickerData.postValue(arrayList3);
            }
            companion.m(c16);
        }
    }

    public final void t2(int index) {
        boolean z16;
        List<MetaCategory> d16 = this.currentData.get(this.currentTopTabIndex).d();
        if (index <= 0) {
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorStickerViewModel$onBottomTabSelected$1(this, null), 3, null);
            return;
        }
        Iterator<T> it = d16.subList(0, index).iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ArrayList<MetaCategory> arrayList = ((MetaCategory) it.next()).subCategories;
            int i16 = 1;
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                i16 = arrayList.size();
            }
            i3 += i16;
        }
        this.currentData.get(this.currentTopTabIndex).l(index);
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorStickerViewModel$onBottomTabSelected$2(this, ac.c(this.currentData.get(this.currentTopTabIndex).j(), i3), null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u2(@NotNull String tabCateId, int pos) {
        StickerListData stickerListData;
        String e16;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(tabCateId, "tabCateId");
        Iterator<StickerListData> it = this.currentData.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getTabType().f30532id, tabCateId)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1 || (e16 = (stickerListData = this.currentData.get(i3)).e(pos)) == null) {
            return;
        }
        Iterator<MetaCategory> it5 = stickerListData.d().iterator();
        int i16 = 0;
        while (true) {
            if (it5.hasNext()) {
                MetaCategory next = it5.next();
                boolean z18 = true;
                if (!Intrinsics.areEqual(next.f30532id, e16)) {
                    ArrayList<MetaCategory> subCategories = next.subCategories;
                    if (subCategories != null) {
                        Intrinsics.checkNotNullExpressionValue(subCategories, "subCategories");
                        if (!subCategories.isEmpty()) {
                            Iterator<T> it6 = subCategories.iterator();
                            while (it6.hasNext()) {
                                if (Intrinsics.areEqual(((MetaCategory) it6.next()).f30532id, e16)) {
                                    z17 = true;
                                    break;
                                }
                            }
                        }
                        z17 = false;
                        if (z17) {
                            z16 = true;
                            if (!z16) {
                                z18 = false;
                            }
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                }
                if (z18) {
                    break;
                } else {
                    i16++;
                }
            } else {
                i16 = -1;
                break;
            }
        }
        if (i16 != -1) {
            stickerListData.l(i16);
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorStickerViewModel$onContentScrolled$1$1(this, i3, i16, null), 3, null);
        }
    }

    public final void v2() {
        Job job;
        Job job2 = this.searchJob;
        boolean z16 = false;
        if (job2 != null && job2.isActive()) {
            z16 = true;
        }
        if (z16 && (job = this.searchJob) != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void w2() {
        if (!this.searchOpened) {
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorStickerViewModel$onSearchTap$1(this, null), 3, null);
            B2();
            this.searchOpened = true;
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [T, camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory] */
    public final void x2(int position) {
        boolean z16;
        if (this.currentTopTabIndex == position) {
            return;
        }
        this.currentTopTabIndex = position;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Iterator<StickerListData> it = this.currentData.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            StickerListData next = it.next();
            if (i3 == position) {
                z16 = true;
            } else {
                z16 = false;
            }
            next.n(z16);
            if (next.getSelected()) {
                objectRef.element = next.getTabType();
            }
            i3 = i16;
        }
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorStickerViewModel$onTopTabSelect$1(this, objectRef, position, null), 3, null);
    }
}
