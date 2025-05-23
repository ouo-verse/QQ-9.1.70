package com.tencent.mobileqq.wink.inspirationlibrary.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.api.IQQWinkFragmentLoader;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.QQWinkConfigKt;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.inspirationlibrary.part.WinkInspirationBottomNavigationPart;
import com.tencent.mobileqq.wink.inspirationlibrary.part.WinkInspirationTemplateUtils;
import com.tencent.mobileqq.wink.inspirationlibrary.part.view.WinkInspirationTemplateCategoryView;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u001e2\u00020\u0001:\u0004\u001f !\u000fB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart;", "Lp53/b;", "", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "pages", "", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart$c;", "B9", "targetPage", "", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/wink/QQWinkConfig;", "d", "Lcom/tencent/mobileqq/wink/QQWinkConfig;", "winkConfig", "", "", "e", "Lkotlin/Lazy;", "z9", "()Ljava/util/Map;", "coverMap", "f", "A9", "titleDescMap", "<init>", "(Lcom/tencent/mobileqq/wink/QQWinkConfig;)V", tl.h.F, "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkInspirationBottomNavigationPart extends p53.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQWinkConfig winkConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy coverMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy titleDescMap;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart$d;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart$c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getDataList", "()Ljava/util/List;", "dataList", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart;", "getPart", "()Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart;", "part", "D", "I", "itemWidthPx", "E", "itemHeightPx", "<init>", "(Ljava/util/List;Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    private static final class b extends RecyclerView.Adapter<d> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final WinkInspirationBottomNavigationPart part;

        /* renamed from: D, reason: from kotlin metadata */
        private final int itemWidthPx;

        /* renamed from: E, reason: from kotlin metadata */
        private final int itemHeightPx;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<NavigationData> dataList;

        public b(@NotNull List<NavigationData> dataList, @NotNull WinkInspirationBottomNavigationPart part) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(part, "part");
            this.dataList = dataList;
            this.part = part;
            WinkInspirationTemplateUtils.Companion companion = WinkInspirationTemplateUtils.INSTANCE;
            WinkInspirationTemplateUtils.Companion.SIZE size = WinkInspirationTemplateUtils.Companion.SIZE.EXP_NORMAL;
            int e16 = companion.e(size);
            this.itemWidthPx = e16;
            this.itemHeightPx = companion.a(e16, size);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.dataList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.n(this.dataList.get(position), position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i5s, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            d dVar = new d(itemView, this.part);
            ViewGroup.LayoutParams layoutParams = dVar.getItemCover().getLayoutParams();
            layoutParams.width = this.itemWidthPx;
            layoutParams.height = this.itemHeightPx;
            dVar.getItemCover().setLayoutParams(layoutParams);
            dVar.getItemCover().setCorner(ViewUtils.dip2px(8.0f));
            return dVar;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "a", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "b", "()Lcom/tencent/mobileqq/wink/QQWinkPage;", "page", "Ljava/lang/String;", "()Ljava/lang/String;", "coverUrl", "c", "titleDesc", "<init>", "(Lcom/tencent/mobileqq/wink/QQWinkPage;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.inspirationlibrary.part.WinkInspirationBottomNavigationPart$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class NavigationData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final QQWinkPage page;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String coverUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String titleDesc;

        public NavigationData(@NotNull QQWinkPage page, @NotNull String coverUrl, @NotNull String titleDesc) {
            Intrinsics.checkNotNullParameter(page, "page");
            Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
            Intrinsics.checkNotNullParameter(titleDesc, "titleDesc");
            this.page = page;
            this.coverUrl = coverUrl;
            this.titleDesc = titleDesc;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getCoverUrl() {
            return this.coverUrl;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final QQWinkPage getPage() {
            return this.page;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getTitleDesc() {
            return this.titleDesc;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigationData)) {
                return false;
            }
            NavigationData navigationData = (NavigationData) other;
            if (this.page == navigationData.page && Intrinsics.areEqual(this.coverUrl, navigationData.coverUrl) && Intrinsics.areEqual(this.titleDesc, navigationData.titleDesc)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.page.hashCode() * 31) + this.coverUrl.hashCode()) * 31) + this.titleDesc.hashCode();
        }

        @NotNull
        public String toString() {
            return "NavigationData(page=" + this.page + ", coverUrl=" + this.coverUrl + ", titleDesc=" + this.titleDesc + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart$c;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "p", "", "index", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart;", "E", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart;", "getPart", "()Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart;", "part", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "itemCover", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "itemTitle", "H", "itemDesc", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final WinkInspirationBottomNavigationPart part;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final RoundCornerImageView itemCover;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView itemTitle;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView itemDesc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull View itemView, @NotNull WinkInspirationBottomNavigationPart part) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(part, "part");
            this.part = part;
            View findViewById = itemView.findViewById(R.id.bat);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.cover)");
            this.itemCover = (RoundCornerImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.title)");
            this.itemTitle = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.bg6);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.desc)");
            this.itemDesc = (TextView) findViewById3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(d this$0, NavigationData data, View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.part.C9(data.getPage());
            WinkHomeReportHelper winkHomeReportHelper = WinkHomeReportHelper.f326257a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            winkHomeReportHelper.e(it, winkHomeReportHelper.b().get(data.getPage()));
            EventCollector.getInstance().onViewClicked(it);
        }

        private final void q(NavigationData data) {
            boolean z16;
            if (data.getCoverUrl().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.e("WinkInspirationBottomNavigationPart", 1, "name:" + data.getPage().getPageName() + ", cover url is empty.");
                this.itemCover.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                return;
            }
            QQPicLoader.f201806a.d().loadImage(Option.obtain().setUrl(data.getCoverUrl()).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a).setRequestWidth(this.itemCover.getLayoutParams().width).setRequestHeight(this.itemCover.getLayoutParams().height).setTargetView(this.itemCover), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.c
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    WinkInspirationBottomNavigationPart.d.r(WinkInspirationBottomNavigationPart.d.this, loadState, option);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(d this$0, LoadState loadState, Option option) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
                QLog.e("WinkInspirationBottomNavigationPart", 1, " staticCover err, state:" + loadState);
                this$0.itemCover.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void n(@NotNull final NavigationData data, int index) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.itemTitle.setText(data.getPage().getPageName());
            this.itemDesc.setText(data.getTitleDesc());
            q(data);
            this.itemCover.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkInspirationBottomNavigationPart.d.o(WinkInspirationBottomNavigationPart.d.this, data, view);
                }
            });
            Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FUNCTION_BUTTON_NAME, data.getPage().getPageName());
            map.put("xsj_item_index", Integer.valueOf(index + 1));
            VideoReport.setElementId(this, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY_FUNCTION_ITEM);
            VideoReport.setElementParams(this, map);
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final RoundCornerImageView getItemCover() {
            return this.itemCover;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f322998a;

        static {
            int[] iArr = new int[QQWinkPage.values().length];
            try {
                iArr[QQWinkPage.WangZheReport.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QQWinkPage.MemoryAlbum.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[QQWinkPage.TextVideo.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f322998a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationBottomNavigationPart$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends RecyclerView.OnScrollListener {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    public WinkInspirationBottomNavigationPart(@NotNull QQWinkConfig winkConfig) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(winkConfig, "winkConfig");
        this.winkConfig = winkConfig;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, String>>() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.WinkInspirationBottomNavigationPart$coverMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, String> invoke() {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(QQWinkPage.TextVideo.getPageName(), "https://qq-video.cdn-go.cn/ios/latest/defaultmode/9095/lingganku/qvideo_lingganku_img_wenzishipin.png");
                linkedHashMap.put(QQWinkPage.MemoryAlbum.getPageName(), "https://qq-video.cdn-go.cn/ios/latest/defaultmode/9095/lingganku/qvideo_lingganku_img_huiyi.png");
                linkedHashMap.put(QQWinkPage.WangZheReport.getPageName(), "https://qq-video.cdn-go.cn/ios/latest/defaultmode/9095/lingganku/qvideo_lingganku_img_wangzhe.png");
                return linkedHashMap;
            }
        });
        this.coverMap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, String>>() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.WinkInspirationBottomNavigationPart$titleDescMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, String> invoke() {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(QQWinkPage.TextVideo.getPageName(), "\u4e00\u952e\u751f\u6210\u52a8\u6001\u6d77\u62a5");
                linkedHashMap.put(QQWinkPage.MemoryAlbum.getPageName(), "\u5bfb\u627e\u9650\u5b9a\u56de\u5fc6");
                linkedHashMap.put(QQWinkPage.WangZheReport.getPageName(), "\u4e13\u5c5e\u9ad8\u5149\u65f6\u523b");
                return linkedHashMap;
            }
        });
        this.titleDescMap = lazy2;
    }

    private final Map<String, String> A9() {
        return (Map) this.titleDescMap.getValue();
    }

    private final List<NavigationData> B9(List<? extends QQWinkPage> pages) {
        ArrayList arrayList = new ArrayList();
        for (QQWinkPage qQWinkPage : pages) {
            if (z9().containsKey(qQWinkPage.getPageName())) {
                String str = z9().get(qQWinkPage.getPageName());
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                String str3 = A9().get(qQWinkPage.getPageName());
                if (str3 != null) {
                    str2 = str3;
                }
                arrayList.add(new NavigationData(qQWinkPage, str, str2));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C9(QQWinkPage targetPage) {
        int i3 = e.f322998a[targetPage.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    IQQWinkFragmentLoader iQQWinkFragmentLoader = (IQQWinkFragmentLoader) QRoute.api(IQQWinkFragmentLoader.class);
                    Activity activity = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    iQQWinkFragmentLoader.openTextVideoFragment(activity);
                    return;
                }
                return;
            }
            MemoryAlbumPreviewFragment.Companion companion = MemoryAlbumPreviewFragment.INSTANCE;
            Activity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            companion.a(activity2);
            return;
        }
        IQQWinkFragmentLoader iQQWinkFragmentLoader2 = (IQQWinkFragmentLoader) QRoute.api(IQQWinkFragmentLoader.class);
        Activity activity3 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity3, "activity");
        iQQWinkFragmentLoader2.openWangZheReportFragment(activity3);
    }

    private final Map<String, String> z9() {
        return (Map) this.coverMap.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        List<QQWinkPage> b16 = QQWinkConfigKt.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : b16) {
            if (this.winkConfig.g().contains((QQWinkPage) obj)) {
                arrayList.add(obj);
            }
        }
        List<NavigationData> B9 = B9(arrayList);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f122887f6);
        b bVar = new b(B9, this);
        recyclerView.setItemViewCacheSize(4);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        recyclerView.setAdapter(bVar);
        recyclerView.addItemDecoration(new WinkInspirationTemplateCategoryView.c());
        recyclerView.addOnScrollListener(new f());
        C9(this.winkConfig.getInitPage());
    }
}
