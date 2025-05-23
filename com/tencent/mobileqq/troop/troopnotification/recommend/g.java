package com.tencent.mobileqq.troop.troopnotification.recommend;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.recommend.api.ITroopFindNewEntranceApi;
import com.tencent.mobileqq.troop.troopnotification.recommend.g;
import com.tencent.mobileqq.troop.utils.ad;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u0004H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/g;", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/t;", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "isForViewType", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g extends t<Object> {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J*\u0010\u000f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0014R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/g$a;", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/s;", "", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "payload", "onBindData", "d", "Landroid/view/View;", "showMoreTroopView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends s<Object> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View showMoreTroopView;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final void q(Context context) {
            Bundle bundle = new Bundle();
            bundle.putString(AppConstants.LeftViewText.LEFTVIEWTEXT, context.getString(R.string.button_back));
            bundle.putString(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, context.getString(R.string.button_back));
            bundle.putInt("tab_index_key", 1);
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPage(context, 2, 4, LaunchMode.standard, bundle);
            ReportController.o(bg.f(), "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).onClickEnterAddFriendAndTroop();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(a this$0, View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (((ITroopFindNewEntranceApi) QRoute.api(ITroopFindNewEntranceApi.class)).canShowNewEntrance()) {
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).jumpRecmmendTroopFrag(it.getContext());
            } else {
                Context context = it.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "it.context");
                this$0.q(context);
            }
            ad adVar = ad.f302002a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            h.a.b(adVar, it, "em_recom_more_result_button", null, null, null, null, 60, null);
            EventCollector.getInstance().onViewClicked(it);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        public void onBindData(@Nullable Object data, int position, @Nullable List<Object> payload) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, data, Integer.valueOf(position), payload);
                return;
            }
            View view = this.showMoreTroopView;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        g.a.r(g.a.this, view2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        public void onInitView(@Nullable View containerView) {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) containerView);
                return;
            }
            if (containerView != null) {
                view = containerView.findViewById(R.id.f10364616);
            } else {
                view = null;
            }
            this.showMoreTroopView = view;
            if (view != null) {
                QUIListItemBackgroundType.Companion companion = QUIListItemBackgroundType.INSTANCE;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "it.context");
                view.setBackground(companion.a(context, 1000, R.color.qui_common_fill_light_primary, 0.0f, 0.0f));
            }
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.i0h;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<Object>>> sections) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, parent, itemView, sections);
            return;
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(a.class);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    protected boolean isForViewType(@NotNull Object item, @NotNull List<Object> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item == TroopNotifyWithRecommendPlaceHolder.SHOW_MORE_TROOP) {
            return true;
        }
        return false;
    }
}
