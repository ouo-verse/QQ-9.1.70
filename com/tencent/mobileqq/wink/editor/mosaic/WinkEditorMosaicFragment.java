package com.tencent.mobileqq.wink.editor.mosaic;

import android.os.Bundle;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.videocut.model.MediaClip;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0014J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R#\u0010\u0019\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/WinkEditorMosaicFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "qh", "Landroid/view/View;", "contentView", "registerDaTongReportPageId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "getStatusBarColor", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "onBackEvent", "La73/a;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "ph", "()La73/a;", "mosaicViewModel", "<init>", "()V", "E", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorMosaicFragment extends ImmersivePartFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mosaicViewModel;

    @NotNull
    public Map<Integer, View> D = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J>\u0010\u000b\u001a\u00020\n2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u00042\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/WinkEditorMosaicFragment$a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/videocut/model/MediaClip;", "Lkotlin/collections/ArrayList;", "mediaClips", "Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicData;", "mosaicDataList", "", "selectIndex", "Lcom/tencent/mobileqq/wink/editor/mosaic/WinkEditorMosaicFragment;", "a", "", "KEY_IS_CANCEL", "Ljava/lang/String;", "KEY_MEDIA_CLIP", "KEY_MEDIA_MOSAIC", "KEY_MEDIA_MOSAIC_RESULT", "KEY_SELECT_INDEX", "MMKV_KEY_SHOW_TOAST", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.mosaic.WinkEditorMosaicFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkEditorMosaicFragment a(@NotNull ArrayList<MediaClip> mediaClips, @NotNull ArrayList<MosaicData> mosaicDataList, int selectIndex) {
            Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
            Intrinsics.checkNotNullParameter(mosaicDataList, "mosaicDataList");
            WinkEditorMosaicFragment winkEditorMosaicFragment = new WinkEditorMosaicFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("KEY_MEDIA_CLIP", mediaClips);
            bundle.putSerializable("KEY_MEDIA_MOSAIC", mosaicDataList);
            bundle.putInt("KEY_SELECT_INDEX", selectIndex);
            winkEditorMosaicFragment.setArguments(bundle);
            return winkEditorMosaicFragment;
        }

        Companion() {
        }
    }

    public WinkEditorMosaicFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a73.a>() { // from class: com.tencent.mobileqq.wink.editor.mosaic.WinkEditorMosaicFragment$mosaicViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a73.a invoke() {
                return (a73.a) WinkEditorMosaicFragment.this.getViewModel(a73.a.class);
            }
        });
        this.mosaicViewModel = lazy;
    }

    private final a73.a ph() {
        return (a73.a) this.mosaicViewModel.getValue();
    }

    private final void qh() {
        if (!QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeBool("MMKV_KEY_SHOW_TOAST" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), false)) {
            ra3.a.a(getContext(), "\u624b\u6307\u6d82\u62b9\u9700\u906e\u6321\u7684\u533a\u57df");
            QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeBool("MMKV_KEY_SHOW_TOAST" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), true);
        }
    }

    private final void registerDaTongReportPageId(View contentView) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_XSJ_MOSAIC_FUNCTION_PAGE);
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    public void _$_clearFindViewByIdCache() {
        this.D.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ph().Z1(getArguments());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WinkEditorMosaicContentPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hdp;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return super.onBackEvent();
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        registerDaTongReportPageId(view);
        qh();
    }
}
