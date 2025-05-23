package com.tencent.mobileqq.wink.pubcover.template;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.pubcover.WinkCoverBgSelectListView;
import com.tencent.mobileqq.wink.pubcover.WinkCoverSelectViewModel;
import com.tencent.mobileqq.wink.view.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001Y\u0018\u0000 k2\u00020\u0001:\u0002lmB\t\b\u0016\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J*\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\u0015\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0014J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010!\u001a\u00020\u000bH\u0016R\u0014\u0010$\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R&\u0010.\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00100R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00100R\u0018\u0010;\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR$\u0010T\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010-R\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0017\u0010b\u001a\u00020]8\u0006\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0017\u0010h\u001a\u00020c8\u0006\u00a2\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/template/WinkCoverTemplateMenuPart;", "Lcom/tencent/mobileqq/wink/editor/d;", "", "initViewModel", "", "show", "Ca", "za", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Ba", "", "position", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "pa", "progress", "isFont", "Da", "Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceDownloader$d;", "qa", "forceUpdate", "Fa", "", "strFolder", "xa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "onInitView", "onDismiss", "Landroid/os/Bundle;", "args", "L9", "B9", "D", "I", "FONT_DOWNLOAD_MAX_PROGRESS", "Lcom/tencent/mobileqq/wink/pubcover/template/c;", "E", "Lcom/tencent/mobileqq/wink/pubcover/template/c;", "mWinkMaterialPanelCategoryAdapter", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "mWinkMaterialPanelCategoryAdapterList", "G", "Z", "mIsCategoryClick", "Lcom/tencent/mobileqq/wink/pubcover/template/l;", "H", "Lcom/tencent/mobileqq/wink/pubcover/template/l;", "mWinkCoverTemplateMenuViewModel", "isDisableTemplate", "J", "isStopLoading", "K", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "applyingMetaMaterial", "Lcom/tencent/mobileqq/wink/pubcover/WinkCoverSelectViewModel;", "L", "Lcom/tencent/mobileqq/wink/pubcover/WinkCoverSelectViewModel;", "mWinkEditorViewModel", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "M", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", "Landroid/widget/ImageView;", "N", "Landroid/widget/ImageView;", "mClearBtn", "P", "Landroid/view/View;", "mPlayerParentView", "Lcom/tencent/mobileqq/wink/pubcover/WinkCoverBgSelectListView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/pubcover/WinkCoverBgSelectListView;", "mCoverBgSelectView", "Landroidx/viewpager2/widget/ViewPager2;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager", ExifInterface.LATITUDE_SOUTH, "mViewPagerDataList", "Lcom/tencent/mobileqq/wink/pubcover/template/a;", "T", "Lcom/tencent/mobileqq/wink/pubcover/template/a;", "mWinkCoverCategoryViewPagerAdapter", "com/tencent/mobileqq/wink/pubcover/template/WinkCoverTemplateMenuPart$e", "U", "Lcom/tencent/mobileqq/wink/pubcover/template/WinkCoverTemplateMenuPart$e;", "mApplyMaterialOnlineTask", "Lcom/tencent/mobileqq/wink/view/x$b;", "V", "Lcom/tencent/mobileqq/wink/view/x$b;", "getMItemListener", "()Lcom/tencent/mobileqq/wink/view/x$b;", "mItemListener", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "W", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "getMOnPageChangeCallback", "()Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "mOnPageChangeCallback", "<init>", "()V", "X", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkCoverTemplateMenuPart extends com.tencent.mobileqq.wink.editor.d {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.pubcover.template.c mWinkMaterialPanelCategoryAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsCategoryClick;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private l mWinkCoverTemplateMenuViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isDisableTemplate;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isStopLoading;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial applyingMetaMaterial;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private WinkCoverSelectViewModel mWinkEditorViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TimelineViewModelV2 timelineViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ImageView mClearBtn;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private View mPlayerParentView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private WinkCoverBgSelectListView mCoverBgSelectView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ViewPager2 mViewPager;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private a mWinkCoverCategoryViewPagerAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private final int FONT_DOWNLOAD_MAX_PROGRESS = 20;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ArrayList<MetaCategory> mWinkMaterialPanelCategoryAdapterList = new ArrayList<>();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<MetaCategory> mViewPagerDataList = new ArrayList<>();

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final e mApplyMaterialOnlineTask = new e();

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final x.b mItemListener = new f();

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final ViewPager2.OnPageChangeCallback mOnPageChangeCallback = new g();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/template/WinkCoverTemplateMenuPart$b;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroid/support/v7/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "space", "e", "column", "<init>", "(II)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int space;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int column;

        public b(int i3, int i16) {
            this.space = i3;
            this.column = i16;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @Nullable View view, @NotNull RecyclerView parent, @Nullable RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(parent, "parent");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            int i3 = this.space;
            int i16 = this.column;
            int i17 = ((i16 + 1) * i3) / i16;
            int i18 = childAdapterPosition % i16;
            int i19 = i18 + 1;
            outRect.left = (i3 * i19) - (i18 * i17);
            outRect.right = (i17 * i19) - (i19 * i3);
            if (childAdapterPosition >= i16) {
                outRect.top = i3;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/pubcover/template/WinkCoverTemplateMenuPart$c", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f325578a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkCoverTemplateMenuPart f325579b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f325580c;

        c(MetaMaterial metaMaterial, WinkCoverTemplateMenuPart winkCoverTemplateMenuPart, int i3) {
            this.f325578a = metaMaterial;
            this.f325579b = winkCoverTemplateMenuPart;
            this.f325580c = i3;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            if (!isSuccess) {
                this.f325579b.za();
            } else {
                WinkEditorResourceManager.a1().i0(this.f325578a);
                this.f325579b.Ba(this.f325578a);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
            this.f325579b.Da(progress, this.f325578a, this.f325580c, true);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/pubcover/template/WinkCoverTemplateMenuPart$d", "Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceDownloader$d;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "a", "I", "fontCount", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int fontCount;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkCoverTemplateMenuPart f325582b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f325583c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f325584d;

        d(String[] strArr, WinkCoverTemplateMenuPart winkCoverTemplateMenuPart, MetaMaterial metaMaterial, int i3) {
            int i16;
            this.f325582b = winkCoverTemplateMenuPart;
            this.f325583c = metaMaterial;
            this.f325584d = i3;
            if (strArr != null) {
                i16 = strArr.length;
            } else {
                i16 = 0;
            }
            this.fontCount = i16;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean isSuccess) {
            if (this.f325582b.isStopLoading) {
                this.f325582b.isStopLoading = false;
                return;
            }
            if (!isSuccess) {
                this.f325582b.za();
            } else {
                if (this.fontCount <= 0) {
                    this.f325582b.Ba(this.f325583c);
                    return;
                }
                WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
                MetaMaterial metaMaterial = this.f325583c;
                a16.h0(metaMaterial, this.f325582b.pa(metaMaterial, this.f325584d));
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int progress) {
            this.f325582b.Da(progress, this.f325583c, this.f325584d, false);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/pubcover/template/WinkCoverTemplateMenuPart$e", "Lcom/tencent/mobileqq/wink/flow/b;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "a", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends com.tencent.mobileqq.wink.flow.b {
        e() {
        }

        private final void a(int position, MetaMaterial material) {
            if (TextUtils.isEmpty(material.packageUrl)) {
                a aVar = WinkCoverTemplateMenuPart.this.mWinkCoverCategoryViewPagerAdapter;
                if (aVar != null) {
                    aVar.notifyDataSetChanged();
                    return;
                }
                return;
            }
            String m3 = WinkEditorResourceManager.a1().m(material);
            Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
            if (!WinkCoverTemplateMenuPart.this.xa(m3)) {
                if (!NetworkUtil.isNetworkAvailable()) {
                    QQToast.makeText(WinkCoverTemplateMenuPart.this.getContext(), 1, WinkCoverTemplateMenuPart.this.getContext().getString(R.string.ynb), 0).show();
                    return;
                } else {
                    WinkEditorResourceManager.a1().f(material, WinkCoverTemplateMenuPart.this.qa(material, position));
                    return;
                }
            }
            if (WinkEditorResourceManager.a1().o2(material)) {
                WinkEditorResourceManager.a1().i0(material);
                WinkCoverTemplateMenuPart.this.Ba(material);
            } else {
                WinkEditorResourceManager.a1().h0(material, WinkCoverTemplateMenuPart.this.pa(material, position));
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void Q(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            if (!WinkCoverTemplateMenuPart.this.isDisableTemplate) {
                WinkCoverTemplateMenuPart.this.applyingMetaMaterial = material;
                a(position, material);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/pubcover/template/WinkCoverTemplateMenuPart$f", "Lcom/tencent/mobileqq/wink/view/x$b;", "Lcom/tencent/mobileqq/wink/view/x$a;", "categoryItemVH", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "", "b", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements x.b {
        f() {
        }

        @Override // com.tencent.mobileqq.wink.view.x.b
        public void a(@NotNull x.a categoryItemVH, int position, @Nullable MetaCategory category) {
            Intrinsics.checkNotNullParameter(categoryItemVH, "categoryItemVH");
            WinkCoverTemplateMenuPart.this.mIsCategoryClick = true;
            ViewPager2 viewPager2 = WinkCoverTemplateMenuPart.this.mViewPager;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(position, true);
            }
        }

        @Override // com.tencent.mobileqq.wink.view.x.b
        public void b(@NotNull x.a categoryItemVH, int position, @Nullable MetaCategory category) {
            Intrinsics.checkNotNullParameter(categoryItemVH, "categoryItemVH");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/pubcover/template/WinkCoverTemplateMenuPart$g", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g extends ViewPager2.OnPageChangeCallback {
        g() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            com.tencent.mobileqq.wink.pubcover.template.c cVar;
            super.onPageSelected(position);
            if (WinkCoverTemplateMenuPart.this.mWinkMaterialPanelCategoryAdapter != null && (cVar = WinkCoverTemplateMenuPart.this.mWinkMaterialPanelCategoryAdapter) != null) {
                cVar.B(position);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(WinkCoverTemplateMenuPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Ga(this$0, null, false, 2, null);
        QQToast.makeText(this$0.getContext(), 1, this$0.getContext().getString(R.string.f215185ux), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ba(MetaMaterial material) {
        String m3 = WinkEditorResourceManager.a1().m(material);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
        com.tencent.mobileqq.wink.editor.c.D1(material, m3);
        com.tencent.mobileqq.wink.editor.c.s1(material, 100);
        Ga(this, material, false, 2, null);
    }

    private final void Ca(boolean show) {
        WinkCoverBgSelectListView winkCoverBgSelectListView = this.mCoverBgSelectView;
        if (winkCoverBgSelectListView != null) {
            winkCoverBgSelectListView.setListViewShow(!show);
        }
        if (show) {
            WinkCoverBgSelectListView winkCoverBgSelectListView2 = this.mCoverBgSelectView;
            if (winkCoverBgSelectListView2 != null) {
                winkCoverBgSelectListView2.b();
            }
            View view = this.mPlayerParentView;
            if (view != null) {
                view.setTranslationY((-getContext().getResources().getDimensionPixelSize(R.dimen.f159631dk1)) - getContext().getResources().getDimensionPixelSize(R.dimen.f159632dk2));
                return;
            }
            return;
        }
        WinkCoverBgSelectListView winkCoverBgSelectListView3 = this.mCoverBgSelectView;
        if (winkCoverBgSelectListView3 != null) {
            winkCoverBgSelectListView3.e();
        }
        View view2 = this.mPlayerParentView;
        if (view2 != null) {
            view2.setTranslationY(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Da(int progress, final MetaMaterial material, int position, boolean isFont) {
        String str;
        final int i3;
        int i16 = this.FONT_DOWNLOAD_MAX_PROGRESS;
        boolean z16 = false;
        if (1 <= progress && progress < 101) {
            z16 = true;
        }
        if (z16) {
            MetaMaterial metaMaterial = this.applyingMetaMaterial;
            if (metaMaterial != null) {
                str = metaMaterial.f30533id;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, material.f30533id)) {
                if (isFont) {
                    i3 = ((int) ((i16 / 100.0f) * progress)) + (100 - i16);
                } else {
                    i3 = (int) (((100 - i16) / 100.0f) * progress);
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.template.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkCoverTemplateMenuPart.Ea(MetaMaterial.this, i3, this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(MetaMaterial material, int i3, WinkCoverTemplateMenuPart this$0) {
        Intrinsics.checkNotNullParameter(material, "$material");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.editor.c.s1(material, i3);
        a aVar = this$0.mWinkCoverCategoryViewPagerAdapter;
        if (aVar != null) {
            aVar.j0(material);
        }
    }

    private final void Fa(MetaMaterial material, boolean forceUpdate) {
        String str;
        l lVar;
        if (material == null) {
            a aVar = this.mWinkCoverCategoryViewPagerAdapter;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            l lVar2 = this.mWinkCoverTemplateMenuViewModel;
            if (lVar2 != null) {
                l.R1(lVar2, null, false, 2, null);
                return;
            }
            return;
        }
        if (forceUpdate) {
            l lVar3 = this.mWinkCoverTemplateMenuViewModel;
            if (lVar3 != null) {
                l.R1(lVar3, material, false, 2, null);
                return;
            }
            return;
        }
        String str2 = material.f30533id;
        MetaMaterial metaMaterial = this.applyingMetaMaterial;
        if (metaMaterial != null) {
            str = metaMaterial.f30533id;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str2, str) && (lVar = this.mWinkCoverTemplateMenuViewModel) != null) {
            l.R1(lVar, material, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Ga(WinkCoverTemplateMenuPart winkCoverTemplateMenuPart, MetaMaterial metaMaterial, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        winkCoverTemplateMenuPart.Fa(metaMaterial, z16);
    }

    private final void initViewModel() {
        this.mWinkCoverTemplateMenuViewModel = (l) getViewModel(l.class);
        this.timelineViewModel = (TimelineViewModelV2) getViewModel(TimelineViewModelV2.class);
        this.mWinkEditorViewModel = (WinkCoverSelectViewModel) getViewModel(WinkCoverSelectViewModel.class);
        WinkEditorResourceManager.a1().E0().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.pubcover.template.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkCoverTemplateMenuPart.wa(WinkCoverTemplateMenuPart.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResDownLoadListener pa(MetaMaterial material, int position) {
        return new c(material, this, position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkEditorResourceDownloader.d qa(MetaMaterial material, int position) {
        return new d(WinkEditorResourceManager.a1().T0(material), this, material, position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(final WinkCoverTemplateMenuPart this$0, View view) {
        MetaMaterial metaMaterial;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l lVar = this$0.mWinkCoverTemplateMenuViewModel;
        if (lVar != null) {
            metaMaterial = lVar.getBeforeMetaMaterial();
        } else {
            metaMaterial = null;
        }
        this$0.Fa(metaMaterial, true);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.template.i
            @Override // java.lang.Runnable
            public final void run() {
                WinkCoverTemplateMenuPart.sa(WinkCoverTemplateMenuPart.this);
            }
        }, 100L);
        this$0.x9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(WinkCoverTemplateMenuPart this$0) {
        Map<String, WinkStickerModel> O1;
        TimelineViewModelV2 timelineViewModelV2;
        dr C2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l lVar = this$0.mWinkCoverTemplateMenuViewModel;
        if (lVar != null && (O1 = lVar.O1()) != null && (timelineViewModelV2 = this$0.timelineViewModel) != null && (C2 = timelineViewModelV2.C2()) != null) {
            C2.B(O1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(WinkCoverTemplateMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(WinkCoverTemplateMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Ga(this$0, null, false, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(WinkCoverTemplateMenuPart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str == null) {
            a aVar = this$0.mWinkCoverCategoryViewPagerAdapter;
            if (aVar != null) {
                aVar.m0(null);
            }
            ImageView imageView = this$0.mClearBtn;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.l6y);
                return;
            }
            return;
        }
        a aVar2 = this$0.mWinkCoverCategoryViewPagerAdapter;
        if (aVar2 != null) {
            aVar2.m0(str);
        }
        ImageView imageView2 = this$0.mClearBtn;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.l6z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(WinkCoverTemplateMenuPart this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list == null) {
            return;
        }
        this$0.mWinkMaterialPanelCategoryAdapterList.clear();
        this$0.mViewPagerDataList.clear();
        List list2 = list;
        this$0.mWinkMaterialPanelCategoryAdapterList.addAll(list2);
        this$0.mViewPagerDataList.addAll(list2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MetaCategory metaCategory = (MetaCategory) it.next();
            ArrayList<MetaMaterial> materials = metaCategory.materials;
            if (materials != null) {
                Intrinsics.checkNotNullExpressionValue(materials, "materials");
                for (MetaMaterial metaMaterial : materials) {
                    if (metaMaterial != null) {
                        com.tencent.mobileqq.wink.editor.c.n1(metaMaterial, false);
                        com.tencent.mobileqq.wink.editor.c.G1(metaMaterial, true);
                        String str = metaCategory.f30532id;
                        Intrinsics.checkNotNullExpressionValue(str, "category.id");
                        com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, str);
                        String str2 = metaCategory.name;
                        Intrinsics.checkNotNullExpressionValue(str2, "category.name");
                        com.tencent.mobileqq.wink.editor.c.p1(metaMaterial, str2);
                    }
                }
            }
        }
        com.tencent.mobileqq.wink.pubcover.template.c cVar = this$0.mWinkMaterialPanelCategoryAdapter;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        a aVar = this$0.mWinkCoverCategoryViewPagerAdapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean xa(String strFolder) {
        return new File(strFolder).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void za() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.template.j
            @Override // java.lang.Runnable
            public final void run() {
                WinkCoverTemplateMenuPart.Aa(WinkCoverTemplateMenuPart.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.u_m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        dr C2;
        MetaMaterial metaMaterial;
        super.L9(args);
        Ca(true);
        l lVar = this.mWinkCoverTemplateMenuViewModel;
        Map<String, WinkStickerModel> map = null;
        if (lVar != null) {
            if (lVar != null) {
                metaMaterial = lVar.getCurrentMeatMaterial();
            } else {
                metaMaterial = null;
            }
            lVar.T1(metaMaterial);
        }
        l lVar2 = this.mWinkCoverTemplateMenuViewModel;
        if (lVar2 != null) {
            TimelineViewModelV2 timelineViewModelV2 = this.timelineViewModel;
            if (timelineViewModelV2 != null && (C2 = timelineViewModelV2.C2()) != null) {
                map = C2.m();
            }
            lVar2.U1(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        LiveData<String> L1;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        ViewPager2 viewPager2 = (ViewPager2) rootView.findViewById(R.id.f788848_);
        this.mWinkCoverCategoryViewPagerAdapter = new a(this.mViewPagerDataList, this.mApplyMaterialOnlineTask, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.pubcover.template.WinkCoverTemplateMenuPart$initAfterInflation$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkCoverTemplateMenuPart.Ga(WinkCoverTemplateMenuPart.this, null, false, 2, null);
            }
        });
        viewPager2.registerOnPageChangeCallback(this.mOnPageChangeCallback);
        viewPager2.setAdapter(this.mWinkCoverCategoryViewPagerAdapter);
        viewPager2.setOrientation(0);
        viewPager2.setVisibility(0);
        viewPager2.setOffscreenPageLimit(3);
        this.mViewPager = viewPager2;
        ((ImageView) rootView.findViewById(R.id.f6436361)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.pubcover.template.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkCoverTemplateMenuPart.ra(WinkCoverTemplateMenuPart.this, view);
            }
        });
        ((ImageView) rootView.findViewById(R.id.f6437362)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.pubcover.template.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkCoverTemplateMenuPart.ta(WinkCoverTemplateMenuPart.this, view);
            }
        });
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f6435360);
        this.mClearBtn = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.pubcover.template.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkCoverTemplateMenuPart.ua(WinkCoverTemplateMenuPart.this, view);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f7887489);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        com.tencent.mobileqq.wink.pubcover.template.c cVar = new com.tencent.mobileqq.wink.pubcover.template.c(this.mWinkMaterialPanelCategoryAdapterList, this.mItemListener);
        this.mWinkMaterialPanelCategoryAdapter = cVar;
        recyclerView.setAdapter(cVar);
        l lVar = this.mWinkCoverTemplateMenuViewModel;
        if (lVar != null && (L1 = lVar.L1()) != null) {
            L1.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.pubcover.template.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkCoverTemplateMenuPart.va(WinkCoverTemplateMenuPart.this, (String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        Ca(false);
        super.onDismiss();
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mPlayerParentView = rootView.findViewById(R.id.f25870c0);
        this.mCoverBgSelectView = (WinkCoverBgSelectListView) rootView.findViewById(R.id.f11732715);
        initViewModel();
    }
}
