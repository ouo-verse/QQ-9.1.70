package com.tencent.mobileqq.emoticonview.searchemo;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quishimmer.QUIShimmerController;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonCompositeInfo;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoFooterView;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchTextComposeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ^2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003^_`B?\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u0006\u00100\u001a\u00020\rJ\u0006\u00101\u001a\u000202J\b\u00103\u001a\u00020\rH\u0002J\b\u00104\u001a\u00020\u000bH\u0016J\u0016\u00105\u001a\n\u0012\u0004\u0012\u00020$\u0018\u0001062\u0006\u00107\u001a\u00020\u000bJ \u00108\u001a\b\u0012\u0004\u0012\u00020$062\u0006\u00109\u001a\u00020\u000b2\b\b\u0002\u0010:\u001a\u00020\u000bH\u0002J\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0006\u0010?\u001a\u000202J\u0018\u0010@\u001a\u0002022\u0006\u0010A\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u000bH\u0016J\u0018\u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u000bH\u0016J\u001e\u0010F\u001a\u0002022\u0006\u00107\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020$J\u0010\u0010I\u001a\u0002022\u0006\u0010A\u001a\u00020\u0002H\u0016J\u0018\u0010J\u001a\u0002022\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u000bH\u0002J\u0010\u0010N\u001a\u0002022\u0006\u0010O\u001a\u00020$H\u0002J\u0018\u0010P\u001a\u0002022\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u000bH\u0002J2\u0010Q\u001a\u0002022\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001a062\f\u0010S\u001a\b\u0012\u0004\u0012\u00020(062\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020\rJ\u0018\u0010V\u001a\u0002022\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u000bH\u0016J\u0018\u0010W\u001a\u0002022\u0006\u0010X\u001a\u00020Y2\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010Z\u001a\u000202H\u0002J\u0016\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\rR\u0014\u0010\u0013\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010)\u001a\n +*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter$VH;", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$SearchEmoLinearLayoutCb;", "mAppRuntime", "Lmqq/app/AppRuntime;", "mContext", "Landroid/content/Context;", "mBigErrorContainer", "Lcom/tencent/mobileqq/emoticonview/searchemo/BigErrorContainer;", "mFromType", "", "mIsComposite", "", "mCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;", "mInfoAndActionCb", "Lcom/tencent/mobileqq/emoticonview/searchemo/InfoAndActionCb;", "(Lmqq/app/AppRuntime;Landroid/content/Context;Lcom/tencent/mobileqq/emoticonview/searchemo/BigErrorContainer;IZLcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;Lcom/tencent/mobileqq/emoticonview/searchemo/InfoAndActionCb;)V", "lastCompositeImgIndex", "getLastCompositeImgIndex", "()I", "lastRecommendImgIndex", "getLastRecommendImgIndex", "mData", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "mFirstCompositeDataIndex", "mFirstRecommendDataIndex", "mFirstRecommendItemType", "mFooterView", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoFooterView;", "mIsMultipleType", "mLastCompositeImgIndex", "mLastRecommendImgIndex", "mSearchWord", "", "mShimmerController", "Lcom/tencent/biz/qui/quishimmer/QUIShimmerController;", "mViewTypeList", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter$ViewTypeInfo;", "rightArrowDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getRightArrowDrawable", "()Landroid/graphics/drawable/Drawable;", "rightArrowDrawable$delegate", "Lkotlin/Lazy;", "checkDataContainEmotion", "destroy", "", "emotionListIsEmpty", "getItemCount", "getItemKeyByPosition", "", com.tencent.luggage.wxa.c8.c.G, "getItemKeyByPositionInner", "row", "startIndex", "getItemViewType", "position", "getTypeface", "Landroid/graphics/Typeface;", "hideBigErrorContainer", "onBindViewHolder", "holder", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "onItemDisplay", "col", "key", "onViewRecycled", "reportForSend", "emotionInfo", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "index", "reportMoreBtn", "eventId", "send", "setDataForOuter", "data", "viewTypeList", "searchWord", "isMultipleType", "subItemClickHappened", "subItemLongClickHappened", "view", "Landroid/view/View;", "updateFirstIndex", "updateLoadingStatus", "loadingStatus", "isComposite", "Companion", "VH", "ViewTypeInfo", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchEmoticonListAdapter extends RecyclerView.Adapter<VH> implements SearchEmoLinearLayout.SearchEmoLinearLayoutCb {
    static IPatchRedirector $redirector_ = null;
    private static final int COMPOSITE_TITLE_COLUMN_COUNT = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int FOOTER_COLUMN_COUNT = 1;
    private static final int IMG_COLUMN_COUNT = 4;
    public static final int IMG_HEIGHT_SPACE = 2;
    public static final int ITEM_TYPE_COMPOSITE_IMG = 4;
    public static final int ITEM_TYPE_COMPOSITE_TITLE = 2;
    public static final int ITEM_TYPE_FOOTER = 1;
    public static final int ITEM_TYPE_NORMAL_IMG = 5;
    public static final int ITEM_TYPE_RECOMMEND_TITLE = 3;
    private static final int RECOMMEND_TITLE_COLUMN_COUNT = 1;

    @NotNull
    private static final String TAG = "SearchEmoticonListAdapter";

    @Nullable
    private AppRuntime mAppRuntime;

    @NotNull
    private final BigErrorContainer mBigErrorContainer;

    @NotNull
    private IEmoticonEventCallback mCallback;

    @NotNull
    private final Context mContext;

    @NotNull
    private final List<EmotionPanelData> mData;
    private int mFirstCompositeDataIndex;
    private int mFirstRecommendDataIndex;
    private int mFirstRecommendItemType;

    @Nullable
    private SearchEmoFooterView mFooterView;
    private final int mFromType;

    @NotNull
    private final InfoAndActionCb mInfoAndActionCb;
    private final boolean mIsComposite;
    private boolean mIsMultipleType;
    private int mLastCompositeImgIndex;
    private int mLastRecommendImgIndex;

    @NotNull
    private String mSearchWord;

    @Nullable
    private QUIShimmerController mShimmerController;

    @NotNull
    private final List<ViewTypeInfo> mViewTypeList;

    /* renamed from: rightArrowDrawable$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy rightArrowDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter$Companion;", "", "()V", "COMPOSITE_TITLE_COLUMN_COUNT", "", "FOOTER_COLUMN_COUNT", "IMG_COLUMN_COUNT", "IMG_HEIGHT_SPACE", "ITEM_TYPE_COMPOSITE_IMG", "ITEM_TYPE_COMPOSITE_TITLE", "ITEM_TYPE_FOOTER", "ITEM_TYPE_NORMAL_IMG", "ITEM_TYPE_RECOMMEND_TITLE", "RECOMMEND_TITLE_COLUMN_COUNT", "TAG", "", "viewTypeToMaxDataCount", "viewType", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int viewTypeToMaxDataCount(int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, viewType)).intValue();
            }
            if (viewType == 1 || viewType == 2 || viewType == 3) {
                return 1;
            }
            if (viewType == 4 || viewType == 5) {
                return 4;
            }
            return 0;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "contentViews", "", "Lcom/tencent/image/URLImageView;", "getContentViews", "()[Lcom/tencent/image/URLImageView;", "setContentViews", "([Lcom/tencent/image/URLImageView;)V", "[Lcom/tencent/image/URLImageView;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class VH extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        public URLImageView[] contentViews;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            }
        }

        @NotNull
        public final URLImageView[] getContentViews() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (URLImageView[]) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            URLImageView[] uRLImageViewArr = this.contentViews;
            if (uRLImageViewArr != null) {
                return uRLImageViewArr;
            }
            Intrinsics.throwUninitializedPropertyAccessException("contentViews");
            return null;
        }

        public final void setContentViews(@NotNull URLImageView[] uRLImageViewArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLImageViewArr);
            } else {
                Intrinsics.checkNotNullParameter(uRLImageViewArr, "<set-?>");
                this.contentViews = uRLImageViewArr;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter$ViewTypeInfo;", "", "viewType", "", "actDataCount", "(II)V", "getActDataCount", "()I", "setActDataCount", "(I)V", "getViewType", "setViewType", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class ViewTypeInfo {
        static IPatchRedirector $redirector_;
        private int actDataCount;
        private int viewType;

        public ViewTypeInfo(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.viewType = i3;
                this.actDataCount = i16;
            }
        }

        public final int getActDataCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.actDataCount;
        }

        public final int getViewType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.viewType;
        }

        public final void setActDataCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.actDataCount = i3;
            }
        }

        public final void setViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.viewType = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23575);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SearchEmoticonListAdapter(@Nullable AppRuntime appRuntime, @NotNull Context mContext, @NotNull BigErrorContainer mBigErrorContainer, int i3, boolean z16, @NotNull IEmoticonEventCallback mCallback, @NotNull InfoAndActionCb mInfoAndActionCb) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mBigErrorContainer, "mBigErrorContainer");
        Intrinsics.checkNotNullParameter(mCallback, "mCallback");
        Intrinsics.checkNotNullParameter(mInfoAndActionCb, "mInfoAndActionCb");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, mContext, mBigErrorContainer, Integer.valueOf(i3), Boolean.valueOf(z16), mCallback, mInfoAndActionCb);
            return;
        }
        this.mAppRuntime = appRuntime;
        this.mContext = mContext;
        this.mBigErrorContainer = mBigErrorContainer;
        this.mFromType = i3;
        this.mIsComposite = z16;
        this.mCallback = mCallback;
        this.mInfoAndActionCb = mInfoAndActionCb;
        this.mData = new ArrayList();
        this.mViewTypeList = new ArrayList();
        this.mSearchWord = "";
        this.mFirstRecommendItemType = -1;
        this.mFirstRecommendDataIndex = -1;
        this.mFirstCompositeDataIndex = -1;
        boolean z17 = mContext instanceof LifecycleOwner;
        if (z17) {
            QUIShimmerController endPoint = new QUIShimmerController("SearchEmotionDialog").setEndPoint(mContext.getResources().getDisplayMetrics().widthPixels, mContext.getResources().getDisplayMetrics().heightPixels);
            endPoint.startShimmer();
            this.mShimmerController = endPoint;
        }
        QLog.i(TAG, 1, "use shimmer isLifecycleOwner:" + z17);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoticonListAdapter$rightArrowDrawable$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoticonListAdapter.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                Context context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context = SearchEmoticonListAdapter.this.mContext;
                Drawable drawable = context.getResources().getDrawable(R.drawable.jlt);
                drawable.setBounds(new Rect(0, 0, ViewUtils.dip2px(15.0f), ViewUtils.dip2px(15.0f)));
                return drawable;
            }
        });
        this.rightArrowDrawable = lazy;
    }

    private final boolean emotionListIsEmpty() {
        Iterator<ViewTypeInfo> it = this.mViewTypeList.iterator();
        while (it.hasNext()) {
            if (it.next().getViewType() != 1) {
                return false;
            }
        }
        return true;
    }

    private final List<String> getItemKeyByPositionInner(int row, int startIndex) {
        HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 4; i3++) {
            int i16 = (4 * row) + startIndex + i3;
            if (i16 < this.mData.size()) {
                EmotionPanelData emotionPanelData = this.mData.get(i16);
                if (emotionPanelData instanceof HotPicSearchEmoticonInfo) {
                    hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emotionPanelData;
                } else {
                    hotPicSearchEmoticonInfo = null;
                }
                if (hotPicSearchEmoticonInfo == null) {
                    break;
                }
                arrayList.add(hotPicSearchEmoticonInfo.mSearchItem.getEmoMd5());
            }
        }
        return arrayList;
    }

    static /* synthetic */ List getItemKeyByPositionInner$default(SearchEmoticonListAdapter searchEmoticonListAdapter, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        return searchEmoticonListAdapter.getItemKeyByPositionInner(i3, i16);
    }

    private final Drawable getRightArrowDrawable() {
        return (Drawable) this.rightArrowDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$10$lambda$5(SearchEmoticonListAdapter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mInfoAndActionCb.clickCompositeTitle();
        this$0.reportMoreBtn("dt_clck");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void reportForSend(EmoticonInfo emotionInfo, int index) {
        HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo;
        int i3;
        String str;
        int i16;
        EmojiHotPicSearchTextComposeInfo emojiHotPicSearchTextComposeInfo = null;
        if (emotionInfo instanceof HotPicSearchEmoticonInfo) {
            hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emotionInfo;
        } else {
            hotPicSearchEmoticonInfo = null;
        }
        if (hotPicSearchEmoticonInfo == null) {
            return;
        }
        int i17 = this.mFromType;
        int i18 = 2;
        if (i17 != 1) {
            if (i17 != 2) {
                i3 = 0;
            } else {
                i3 = 1;
            }
        } else {
            i3 = 2;
        }
        EmotionSearchItem emotionSearchItem = hotPicSearchEmoticonInfo.mSearchItem;
        if (emotionSearchItem != null) {
            str = emotionSearchItem.getEmoMd5();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = str;
        EmotionSearchItem emotionSearchItem2 = hotPicSearchEmoticonInfo.mSearchItem;
        if (emotionSearchItem2 != null) {
            emojiHotPicSearchTextComposeInfo = emotionSearchItem2.textComposeInfo;
        }
        if (emojiHotPicSearchTextComposeInfo == null) {
            i18 = 1;
        }
        if (this.mIsMultipleType) {
            if (index >= this.mFirstRecommendDataIndex) {
                i16 = index - 2;
            } else {
                i16 = index - 1;
            }
        } else {
            i16 = index;
        }
        ReportController.o(this.mAppRuntime, "dc00898", "", "", "0X800C528", "0X800C528", i3, 0, String.valueOf(i18), String.valueOf(i16 + 1), str2, this.mSearchWord);
    }

    private final void reportMoreBtn(String eventId) {
        Map<String, Object> map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null && (map = pageInfo.pageParams) != null) {
            linkedHashMap.putAll(map);
        }
        linkedHashMap.remove("qq_pgid");
        linkedHashMap.put("dt_pgid", EmotionDaTongReportUtil.PG_BAS_MAGNIFYING_GLASS_EMOJI_SEARCH);
        linkedHashMap.put("dt_eid", EmotionDaTongReportUtil.EM_BAS_MORE_OPTIONS_BTN);
        VideoReport.reportEvent(eventId, linkedHashMap);
    }

    private final void send(EmoticonInfo emotionInfo, int index) {
        this.mCallback.sendEmotion(emotionInfo);
        this.mInfoAndActionCb.sendEmotionHappened();
        reportForSend(emotionInfo, index);
    }

    private final void updateFirstIndex() {
        this.mFirstRecommendDataIndex = -1;
        this.mFirstCompositeDataIndex = -1;
        if (!this.mIsMultipleType) {
            return;
        }
        Iterator<EmotionPanelData> it = this.mData.iterator();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i17 = i16 + 1;
            EmotionPanelData next = it.next();
            if (next instanceof HotPicSearchEmoticonCompositeInfo) {
                if (this.mFirstCompositeDataIndex == -1) {
                    this.mFirstCompositeDataIndex = i16;
                }
            } else if (next instanceof HotPicSearchEmoticonInfo) {
                this.mFirstRecommendDataIndex = i16;
                break;
            }
            i16 = i17;
        }
        Iterator<ViewTypeInfo> it5 = this.mViewTypeList.iterator();
        while (it5.hasNext()) {
            int i18 = i3 + 1;
            if (it5.next().getViewType() == 5) {
                this.mFirstRecommendItemType = i3;
                return;
            }
            i3 = i18;
        }
    }

    public final boolean checkDataContainEmotion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Iterator<T> it = this.mData.iterator();
        while (it.hasNext()) {
            if (((EmotionPanelData) it.next()) instanceof HotPicSearchEmoticonCompositeInfo) {
                return true;
            }
        }
        return false;
    }

    public final void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QUIShimmerController qUIShimmerController = this.mShimmerController;
        if (qUIShimmerController != null) {
            qUIShimmerController.stopShimmer();
        }
        QUIShimmerController qUIShimmerController2 = this.mShimmerController;
        if (qUIShimmerController2 != null) {
            qUIShimmerController2.clearAllTargetObserver();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (Object obj : this.mData) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            EmotionPanelData emotionPanelData = (EmotionPanelData) obj;
            if (emotionPanelData instanceof HotPicSearchEmoticonCompositeInfo) {
                i3 = i17;
            } else if (emotionPanelData instanceof HotPicSearchEmoticonInfo) {
                i16 = i17;
            }
            i17 = i18;
        }
        this.mLastCompositeImgIndex = i3;
        this.mLastRecommendImgIndex = i16;
        return this.mViewTypeList.size();
    }

    @Nullable
    public final List<String> getItemKeyByPosition(int pos) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this, pos);
        }
        int itemViewType = getItemViewType(pos);
        if (itemViewType != 4 && itemViewType != 5) {
            return null;
        }
        if (!this.mIsMultipleType) {
            return getItemKeyByPositionInner$default(this, pos, 0, 2, null);
        }
        if (itemViewType == 4) {
            i3 = pos - 1;
        } else {
            i3 = pos - this.mFirstRecommendItemType;
        }
        if (itemViewType == 4) {
            i16 = this.mFirstCompositeDataIndex;
        } else {
            i16 = this.mFirstRecommendDataIndex;
        }
        return getItemKeyByPositionInner(i3, i16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, position)).intValue();
        }
        if (position >= this.mViewTypeList.size()) {
            return 3;
        }
        return this.mViewTypeList.get(position).getViewType();
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout.SearchEmoLinearLayoutCb
    public int getLastCompositeImgIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.mLastCompositeImgIndex;
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout.SearchEmoLinearLayoutCb
    public int getLastRecommendImgIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.mLastRecommendImgIndex;
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout.SearchEmoLinearLayoutCb
    @Nullable
    public Typeface getTypeface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Typeface) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mInfoAndActionCb.getTypeface();
    }

    public final void hideBigErrorContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        SearchEmoFooterView searchEmoFooterView = this.mFooterView;
        if (searchEmoFooterView != null) {
            searchEmoFooterView.hideBigErrorContainer();
        }
    }

    public final void onItemDisplay(int pos, int col, @NotNull String key) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(pos), Integer.valueOf(col), key);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        int itemViewType = getItemViewType(pos);
        if (itemViewType != 4 && itemViewType != 5) {
            return;
        }
        int i18 = this.mFromType;
        if (i18 != 1) {
            if (i18 != 2) {
                i3 = 0;
            } else {
                i3 = 1;
            }
        } else {
            i3 = 2;
        }
        if (this.mIsMultipleType) {
            if (itemViewType == 4) {
                i16 = pos - 1;
            } else {
                i16 = pos - 2;
            }
        } else {
            i16 = pos;
        }
        int i19 = (i16 * 4) + col;
        if (itemViewType != 4) {
            i17 = 1;
        }
        ReportController.o(this.mAppRuntime, "dc00898", "", "", "0X800C527", "0X800C527", i3, 0, String.valueOf(i17), String.valueOf(i19 + 1), key, this.mSearchWord);
    }

    public final void setDataForOuter(@NotNull List<? extends EmotionPanelData> data, @NotNull List<ViewTypeInfo> viewTypeList, @NotNull String searchWord, boolean isMultipleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, viewTypeList, searchWord, Boolean.valueOf(isMultipleType));
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewTypeList, "viewTypeList");
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        this.mData.clear();
        this.mData.addAll(data);
        this.mViewTypeList.clear();
        this.mViewTypeList.addAll(viewTypeList);
        this.mSearchWord = searchWord;
        this.mIsMultipleType = isMultipleType;
        updateFirstIndex();
        notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout.SearchEmoLinearLayoutCb
    public void subItemClickHappened(@NotNull EmoticonInfo emotionInfo, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) emotionInfo, index);
        } else {
            Intrinsics.checkNotNullParameter(emotionInfo, "emotionInfo");
            send(emotionInfo, index);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout.SearchEmoLinearLayoutCb
    public void subItemLongClickHappened(@NotNull View view, @NotNull EmoticonInfo emotionInfo) {
        HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, (Object) emotionInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(emotionInfo, "emotionInfo");
        InfoAndActionCb infoAndActionCb = this.mInfoAndActionCb;
        if (emotionInfo instanceof HotPicSearchEmoticonInfo) {
            hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emotionInfo;
        } else {
            hotPicSearchEmoticonInfo = null;
        }
        infoAndActionCb.showAddCustomPopup(view, hotPicSearchEmoticonInfo);
    }

    public final void updateLoadingStatus(int loadingStatus, boolean isComposite) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(loadingStatus), Boolean.valueOf(isComposite));
            return;
        }
        SearchEmoFooterView searchEmoFooterView = this.mFooterView;
        if (searchEmoFooterView != null) {
            searchEmoFooterView.notifyStatusChanged(loadingStatus, emotionListIsEmpty(), isComposite);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull VH holder, int position) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.getItemViewType() == 2 && (textView = (TextView) holder.itemView.findViewById(R.id.zej)) != null) {
            textView.setText(this.mInfoAndActionCb.getCurSearchWords());
        }
        if (holder.getItemViewType() == 5 || holder.getItemViewType() == 4) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getEmotionView position = " + position + "; view from inflater");
            }
            View view = holder.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout");
            SearchEmoLinearLayout searchEmoLinearLayout = (SearchEmoLinearLayout) view;
            searchEmoLinearLayout.setFocusable(false);
            searchEmoLinearLayout.setClickable(false);
            searchEmoLinearLayout.setDescendantFocusability(262144);
            searchEmoLinearLayout.setFocusableInTouchMode(false);
            searchEmoLinearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            searchEmoLinearLayout.setOrientation(0);
            searchEmoLinearLayout.setPadding(0, ViewUtils.dip2px(2.0f), 0, 0);
            searchEmoLinearLayout.updateUI(position, this.mData, this.mViewTypeList, holder.getItemViewType() == 5 ? this.mLastRecommendImgIndex : this.mLastCompositeImgIndex, this.mIsMultipleType, this.mFirstRecommendDataIndex);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public VH onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (VH) iPatchRedirector.redirect((short) 7, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            SearchEmoFooterView searchEmoFooterView = this.mFooterView;
            if (searchEmoFooterView == null) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.f167931e70, (ViewGroup) null);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.emoticonview.searchemo.SearchEmoFooterView");
                searchEmoFooterView = (SearchEmoFooterView) inflate;
                searchEmoFooterView.setBigErrorContainer(this.mBigErrorContainer);
                searchEmoFooterView.setBackgroundColor(0);
                searchEmoFooterView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                searchEmoFooterView.notifyStatusChanged(this.mInfoAndActionCb.getLoadingStatus(), emotionListIsEmpty(), this.mIsComposite);
                searchEmoFooterView.setFooterViewCb(new SearchEmoFooterView.FooterViewCb() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoticonListAdapter$onCreateViewHolder$footerView$1$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoticonListAdapter.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoFooterView.FooterViewCb
                    public void onClick() {
                        InfoAndActionCb infoAndActionCb;
                        boolean z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            infoAndActionCb = SearchEmoticonListAdapter.this.mInfoAndActionCb;
                            z16 = SearchEmoticonListAdapter.this.mIsComposite;
                            infoAndActionCb.clickFooterView(z16);
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
                this.mFooterView = searchEmoFooterView;
            }
            return new VH(searchEmoFooterView);
        }
        if (viewType != 2) {
            if (viewType == 3) {
                View recommendTitle = LayoutInflater.from(this.mContext).inflate(R.layout.f167935e74, (ViewGroup) null);
                recommendTitle.setLayoutParams(new RecyclerView.LayoutParams(-1, ViewUtils.dip2px(38.0f)));
                Intrinsics.checkNotNullExpressionValue(recommendTitle, "recommendTitle");
                return new VH(recommendTitle);
            }
            if (viewType != 4) {
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                return new VH(new SearchEmoLinearLayout(context, INSTANCE.viewTypeToMaxDataCount(5), this, this.mShimmerController));
            }
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            return new VH(new SearchCompositeEmoLinearLayout(context2, INSTANCE.viewTypeToMaxDataCount(4), this, this.mShimmerController));
        }
        View compositeTitle = LayoutInflater.from(this.mContext).inflate(R.layout.e6y, (ViewGroup) null);
        compositeTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchEmoticonListAdapter.onCreateViewHolder$lambda$10$lambda$5(SearchEmoticonListAdapter.this, view);
            }
        });
        compositeTitle.setLayoutParams(new RecyclerView.LayoutParams(-1, ViewUtils.dip2px(70.0f)));
        TextView textView = (TextView) compositeTitle.findViewById(R.id.zei);
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(textView, "findViewById<TextView>(R\u2026d.more_composite_emotion)");
            textView.setCompoundDrawables(null, null, getRightArrowDrawable(), null);
            textView.setCompoundDrawablePadding(getRightArrowDrawable() != null ? ViewUtils.dip2px(9.0f) : 0);
        }
        TextView textView2 = (TextView) compositeTitle.findViewById(R.id.zej);
        if (textView2 != null) {
            Intrinsics.checkNotNullExpressionValue(textView2, "findViewById<TextView>(R\u2026site_emotion_search_word)");
            textView2.setText(this.mInfoAndActionCb.getCurSearchWords());
        }
        TextView textView3 = (TextView) compositeTitle.findViewById(R.id.zek);
        if (textView3 != null) {
            Intrinsics.checkNotNullExpressionValue(textView3, "findViewById<TextView>(R\u2026_composite_emotion_title)");
            textView3.setText(this.mContext.getString(R.string.f224386is) + "-");
        }
        reportMoreBtn("dt_imp");
        Intrinsics.checkNotNullExpressionValue(compositeTitle, "compositeTitle");
        return new VH(compositeTitle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull VH holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled((SearchEmoticonListAdapter) holder);
        View view = holder.itemView;
        SearchEmoLinearLayout searchEmoLinearLayout = view instanceof SearchEmoLinearLayout ? (SearchEmoLinearLayout) view : null;
        if (searchEmoLinearLayout != null) {
            searchEmoLinearLayout.cleanShimmerForSubItem();
        }
    }
}
