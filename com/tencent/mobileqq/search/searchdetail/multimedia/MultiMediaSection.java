package com.tencent.mobileqq.search.searchdetail.multimedia;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateNineBoxGridItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchEnumJumpType;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import feedcloud.FeedCloudMeta$StFeed;
import hp2.am;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J(\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J(\u0010\u001d\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J&\u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u001bJ\u001e\u0010$\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001bJ\u0010\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\tH\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/multimedia/MultiMediaSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/n;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "jump", "", "Z", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "", "b0", "a0", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "y", "data", "", "position", "", "", "payload", "Y", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "moreJumpInfo", "", "", "extensionMap", "d", "", "guildId", "docId", "likeStatus", "currentTraceId", "d0", "e0", NodeProps.VISIBLE, "onVisibleChanged", "onViewRecycled", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/NetSearchMultiMediaCard;", "D", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/NetSearchMultiMediaCard;", IndividuationUrlHelper.UrlId.CARD_HOME, "Landroid/view/View$OnLayoutChangeListener;", "E", "Landroid/view/View$OnLayoutChangeListener;", "layoutChangeListener", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class MultiMediaSection extends BaseSearchTemplateSection<NetSearchTemplateNineBoxGridItem> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private NetSearchMultiMediaCard card;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener layoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.a
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            MultiMediaSection.c0(MultiMediaSection.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
        }
    };

    private final boolean Z(SearchJump jump) {
        if (jump == null || jump.type != QSearchEnumJumpType.JUMP_TYPE_CIRCLE_USER.getType()) {
            return false;
        }
        return true;
    }

    private final boolean a0(SearchJump jump) {
        if (jump == null) {
            return false;
        }
        QLog.d("QQSearch.NetDetail.MultiMediaSection", 4, "isVideoJump:" + jump.type);
        if (jump.type != QSearchEnumJumpType.JUMP_TYPE_CIRCLE_FEED_DETAIL.getType()) {
            return false;
        }
        return true;
    }

    private final void b0(FeedCloudMeta$StFeed stFeed) {
        Context context;
        am binding;
        ConstraintLayout root;
        QLog.d("QQSearch.NetDetail.MultiMediaSection", 4, "jumpVideoPersonalPage");
        NetSearchMultiMediaCard netSearchMultiMediaCard = this.card;
        if (netSearchMultiMediaCard != null && (binding = netSearchMultiMediaCard.getBinding()) != null && (root = binding.getRoot()) != null) {
            context = root.getContext();
        } else {
            context = null;
        }
        if (context == null) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(stFeed.poster.f398463id.get());
        com.tencent.biz.qqcircle.launcher.c.d0(context, qCircleInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(MultiMediaSection this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        NetSearchMultiMediaCard netSearchMultiMediaCard;
        float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i17 - i3 != i27 - i19 && (netSearchMultiMediaCard = this$0.card) != null) {
            if (netSearchMultiMediaCard != null) {
                f16 = netSearchMultiMediaCard.v();
            } else {
                f16 = 0.0f;
            }
            netSearchMultiMediaCard.R(f16);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull final NetSearchTemplateNineBoxGridItem data, int position, @Nullable List<Object> payload) {
        Object obj;
        SearchText searchText;
        Intrinsics.checkNotNullParameter(data, "data");
        String str = null;
        if (payload != null) {
            obj = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) payload);
        } else {
            obj = null;
        }
        if (Intrinsics.areEqual(obj, com.tencent.mobileqq.search.searchdetail.content.model.a.INSTANCE.a())) {
            SearchIcon contentIcon = data.getContentIcon();
            if (contentIcon != null && (searchText = contentIcon.title) != null) {
                str = searchText.text;
            }
            if (str == null) {
                str = String.valueOf(hashCode());
            }
            QLog.d("QQSearch.NetDetail.MultiMediaSection", 4, "doOnBindData only for changePlayState  pos=" + position + " title:" + str);
            NetSearchMultiMediaCard netSearchMultiMediaCard = this.card;
            if (netSearchMultiMediaCard != null) {
                netSearchMultiMediaCard.x(data);
                return;
            }
            return;
        }
        NetSearchMultiMediaCard netSearchMultiMediaCard2 = this.card;
        if (netSearchMultiMediaCard2 != null) {
            netSearchMultiMediaCard2.d0(data, position);
        }
        NetSearchMultiMediaCard netSearchMultiMediaCard3 = this.card;
        if (netSearchMultiMediaCard3 != null) {
            netSearchMultiMediaCard3.P(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.MultiMediaSection$doOnBindData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = MultiMediaSection.this.getDtReportIoc();
                    if (dtReportIoc != null) {
                        dtReportIoc.a(data);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection, com.tencent.mobileqq.search.searchdetail.content.base.g
    public void d(@Nullable SearchJump moreJumpInfo, @Nullable Map<String, String> extensionMap) {
        NetSearchTemplateNineBoxGridItem contentModel;
        FeedCloudMeta$StFeed singleVideoData;
        if (Z(moreJumpInfo)) {
            NetSearchMultiMediaCard netSearchMultiMediaCard = this.card;
            if (netSearchMultiMediaCard != null && (contentModel = netSearchMultiMediaCard.getContentModel()) != null && (singleVideoData = contentModel.getSingleVideoData()) != null) {
                b0(singleVideoData);
                return;
            }
            return;
        }
        if (a0(moreJumpInfo)) {
            NetSearchMultiMediaCard netSearchMultiMediaCard2 = this.card;
            if (netSearchMultiMediaCard2 != null) {
                netSearchMultiMediaCard2.J(moreJumpInfo);
                return;
            }
            return;
        }
        super.d(moreJumpInfo, extensionMap);
    }

    public final void d0(long guildId, @NotNull String docId, int likeStatus, @NotNull String currentTraceId) {
        Intrinsics.checkNotNullParameter(docId, "docId");
        Intrinsics.checkNotNullParameter(currentTraceId, "currentTraceId");
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc != null) {
            dtReportIoc.h(guildId, docId, likeStatus, currentTraceId);
        }
    }

    public final void e0(long guildId, @NotNull String docId, @NotNull String currentTraceId) {
        Intrinsics.checkNotNullParameter(docId, "docId");
        Intrinsics.checkNotNullParameter(currentTraceId, "currentTraceId");
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc != null) {
            dtReportIoc.e(guildId, docId, currentTraceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        am binding;
        ConstraintLayout root;
        super.onDestroy();
        NetSearchMultiMediaCard netSearchMultiMediaCard = this.card;
        if (netSearchMultiMediaCard != null && (binding = netSearchMultiMediaCard.getBinding()) != null && (root = binding.getRoot()) != null) {
            root.removeOnLayoutChangeListener(this.layoutChangeListener);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        NetSearchMultiMediaCard netSearchMultiMediaCard = this.card;
        if (netSearchMultiMediaCard != null) {
            netSearchMultiMediaCard.Q(visible);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        View view;
        ConstraintLayout root;
        boolean z16;
        if (containerView != null) {
            view = containerView.findViewById(R.id.zjl);
        } else {
            view = null;
        }
        if (view == null) {
            if (containerView == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.e("QQSearch.NetDetail.MultiMediaSection", 1, "onInitView failed for rootView got null,container null:" + z16);
            return;
        }
        am e16 = am.e(view);
        Intrinsics.checkNotNullExpressionValue(e16, "bind(rootView)");
        NetSearchMultiMediaCard netSearchMultiMediaCard = new NetSearchMultiMediaCard(e16, this);
        this.card = netSearchMultiMediaCard;
        am binding = netSearchMultiMediaCard.getBinding();
        if (binding != null && (root = binding.getRoot()) != null) {
            root.addOnLayoutChangeListener(this.layoutChangeListener);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onViewRecycled() {
    }
}
