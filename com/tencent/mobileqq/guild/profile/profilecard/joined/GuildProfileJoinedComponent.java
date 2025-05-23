package com.tencent.mobileqq.guild.profile.profilecard.joined;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserJoinedGuildSummary;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.cs;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0017\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010<\u001a\u00020\u0007\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014J&\u0010 \u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00109\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/GuildProfileJoinedComponent;", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/framework/component/AbsGuildProfileComponent;", "", "visibility", "", "setContainerVisibleAwareLoading", "initView", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "guildProfileData", "bindUI", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendChannelInfo;", "list", "bindJoinedItem", "bindJoinedSingleItem", "bindJoinedMultipleItem", "measureSingleJoinedItemNum", "measureMultiJoinedItemNum", "getComponentType", "", "getComponentName", "getContentLayoutId", "Landroid/content/Context;", "context", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/common/app/AppInterface;", "appInterface", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", HippyQQPagView.EventName.ON_LOAD_START, "onLoadFinish", "onInitData", "onUpdateData", "onConfigurationChanged", "Landroid/widget/LinearLayout;", "mContainer", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "mGuildNumView", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "mGuildMoreArraw", "Landroid/widget/ImageView;", "Landroid/widget/RelativeLayout;", "mGuildNumContainer", "Landroid/widget/RelativeLayout;", "mContext", "Landroid/content/Context;", "currentGuildList", "Ljava/util/List;", "", "isLoading", "Z", "I", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/framework/controller/IGuildComponentController;", "componentController", "data", "<init>", "(Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/framework/controller/IGuildComponentController;Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileJoinedComponent extends AbsGuildProfileComponent {
    private static final int MAX_MULTI_GUILD = 6;
    private static final int MAX_SINGLE_GUILD = 3;

    @NotNull
    private static final String TAG = "Guild.profile.GuildProfileJoinedComponent";

    @Nullable
    private List<? extends IGProRecommendChannelInfo> currentGuildList;
    private boolean isLoading;
    private LinearLayout mContainer;
    private Context mContext;
    private ImageView mGuildMoreArraw;
    private RelativeLayout mGuildNumContainer;
    private TextView mGuildNumView;
    private int visibility;
    private static final int ITEM_MARGIN = bi.b(19);
    private static final int SINGLE_ITEM_MARGIN = bi.b(8);
    private static final int ITEM_PADDING = bi.b(20);
    private static final int MULTI_ITEM_WIDTH = bi.b(58);
    private static final int SINGLE_ITEM_WIDTH = bi.b(190);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileJoinedComponent(@NotNull IGuildComponentController componentController, @NotNull GuildProfileData data) {
        super(componentController, data);
        Intrinsics.checkNotNullParameter(componentController, "componentController");
        Intrinsics.checkNotNullParameter(data, "data");
        this.visibility = 8;
    }

    private final void bindJoinedItem(List<? extends IGProRecommendChannelInfo> list) {
        boolean z16;
        List<? extends IGProRecommendChannelInfo> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (list.size() < 3) {
            bindJoinedSingleItem(list);
        } else {
            bindJoinedMultipleItem(list);
        }
    }

    private final void bindJoinedMultipleItem(List<? extends IGProRecommendChannelInfo> list) {
        List<IGProRecommendChannelInfo> take;
        Context context;
        Object last;
        List<IGProRecommendChannelInfo> take2;
        Context context2;
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        int measureMultiJoinedItemNum = measureMultiJoinedItemNum();
        Logger.f235387a.d().d(TAG, 1, "profile_joined_guild multi maxCount:" + measureMultiJoinedItemNum + " list.size:" + list.size());
        if (list.size() >= measureMultiJoinedItemNum) {
            take2 = CollectionsKt___CollectionsKt.take(list, measureMultiJoinedItemNum);
            for (IGProRecommendChannelInfo iGProRecommendChannelInfo : take2) {
                Context context3 = this.mContext;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context2 = null;
                } else {
                    context2 = context3;
                }
                GuildProfileJoinedMultipleItem guildProfileJoinedMultipleItem = new GuildProfileJoinedMultipleItem(context2, null, 0, 6, null);
                guildProfileJoinedMultipleItem.d(iGProRecommendChannelInfo);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                LinearLayout linearLayout2 = this.mContainer;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    linearLayout2 = null;
                }
                linearLayout2.addView(guildProfileJoinedMultipleItem, layoutParams);
            }
            return;
        }
        take = CollectionsKt___CollectionsKt.take(list, measureMultiJoinedItemNum);
        for (IGProRecommendChannelInfo iGProRecommendChannelInfo2 : take) {
            Context context4 = this.mContext;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            } else {
                context = context4;
            }
            GuildProfileJoinedMultipleItem guildProfileJoinedMultipleItem2 = new GuildProfileJoinedMultipleItem(context, null, 0, 6, null);
            guildProfileJoinedMultipleItem2.d(iGProRecommendChannelInfo2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(MULTI_ITEM_WIDTH, -1);
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) take);
            if (!Intrinsics.areEqual(iGProRecommendChannelInfo2, last)) {
                layoutParams2.setMarginEnd(SINGLE_ITEM_MARGIN);
            }
            LinearLayout linearLayout3 = this.mContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                linearLayout3 = null;
            }
            linearLayout3.addView(guildProfileJoinedMultipleItem2, layoutParams2);
        }
    }

    private final void bindJoinedSingleItem(List<? extends IGProRecommendChannelInfo> list) {
        Context context;
        LinearLayout.LayoutParams layoutParams;
        Object last;
        Object last2;
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        for (IGProRecommendChannelInfo iGProRecommendChannelInfo : list) {
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            } else {
                context = context2;
            }
            GuildProfileJoinedSingleItem guildProfileJoinedSingleItem = new GuildProfileJoinedSingleItem(context, null, 0, 6, null);
            guildProfileJoinedSingleItem.c(iGProRecommendChannelInfo);
            int measureSingleJoinedItemNum = measureSingleJoinedItemNum();
            if (list.size() != 1 && measureSingleJoinedItemNum != 2) {
                LinearLayout linearLayout2 = this.mContainer;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    linearLayout2 = null;
                }
                linearLayout2.setWeightSum(2.0f);
                layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                if (!Intrinsics.areEqual(iGProRecommendChannelInfo, last2)) {
                    layoutParams.setMarginEnd(bi.b(8));
                }
            } else {
                layoutParams = new LinearLayout.LayoutParams(SINGLE_ITEM_WIDTH, -1);
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                if (!Intrinsics.areEqual(iGProRecommendChannelInfo, last)) {
                    layoutParams.setMarginEnd(ITEM_MARGIN);
                }
            }
            LinearLayout linearLayout3 = this.mContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                linearLayout3 = null;
            }
            linearLayout3.addView(guildProfileJoinedSingleItem, layoutParams);
        }
    }

    private final void bindUI(final GuildProfileData guildProfileData) {
        IGProUserJoinedGuildSummary joinedGuildSummary;
        ArrayList<IGProRecommendChannelInfo> guildList;
        boolean z16;
        String str;
        IGProUserJoinedGuildSummary joinedGuildSummary2;
        ev userProfileInfo = guildProfileData.getUserProfileInfo();
        if (userProfileInfo != null && (joinedGuildSummary = userProfileInfo.getJoinedGuildSummary()) != null && (guildList = joinedGuildSummary.getGuildList()) != null) {
            this.currentGuildList = guildList;
            if (guildList.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.i(TAG, 1, "joinedGuildList is empty");
                setContainerVisibleAwareLoading(8);
                return;
            }
            setContainerVisibleAwareLoading(0);
            TextView textView = this.mGuildNumView;
            RelativeLayout relativeLayout = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildNumView");
                textView = null;
            }
            ev userProfileInfo2 = guildProfileData.getUserProfileInfo();
            if (userProfileInfo2 == null || (joinedGuildSummary2 = userProfileInfo2.getJoinedGuildSummary()) == null || (str = joinedGuildSummary2.getJoinedCountStr()) == null) {
                str = "";
            }
            textView.setText(str);
            RelativeLayout relativeLayout2 = this.mGuildNumContainer;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildNumContainer");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildProfileJoinedComponent.bindUI$lambda$0(GuildProfileJoinedComponent.this, guildProfileData, view);
                }
            });
            bindJoinedItem(this.currentGuildList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindUI$lambda$0(GuildProfileJoinedComponent this$0, GuildProfileData guildProfileData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildProfileData, "$guildProfileData");
        GuildProfileJoinedFragment.Companion companion = GuildProfileJoinedFragment.INSTANCE;
        Context context = this$0.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        companion.a(context, guildProfileData);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView() {
        Context context;
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            context = fragment.getContext();
        } else {
            context = null;
        }
        if (context == null) {
            return;
        }
        this.mContext = context;
        View findViewById = this.mViewContainer.findViewById(R.id.b8q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mViewContainer.findViewById(R.id.container)");
        this.mContainer = (LinearLayout) findViewById;
        View findViewById2 = this.mViewContainer.findViewById(R.id.f165588wt3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mViewContainer.findViewById(R.id.guild_num)");
        this.mGuildNumView = (TextView) findViewById2;
        View findViewById3 = this.mViewContainer.findViewById(R.id.ezw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mViewContainer.findViewById(R.id.more_arrow)");
        this.mGuildMoreArraw = (ImageView) findViewById3;
        View findViewById4 = this.mViewContainer.findViewById(R.id.f165589wt4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mViewContainer.findViewB\u2026R.id.guild_num_container)");
        this.mGuildNumContainer = (RelativeLayout) findViewById4;
        this.mViewContainer.setVisibility(8);
    }

    private final int measureMultiJoinedItemNum() {
        return ((bi.d() - (ITEM_PADDING * 2)) + ITEM_MARGIN) / (MULTI_ITEM_WIDTH + SINGLE_ITEM_MARGIN);
    }

    private final int measureSingleJoinedItemNum() {
        int d16 = bi.d() - (ITEM_PADDING * 2);
        int i3 = ITEM_MARGIN;
        return (d16 + i3) / (SINGLE_ITEM_WIDTH + i3);
    }

    private final void setContainerVisibleAwareLoading(int visibility) {
        this.visibility = visibility;
        if (!this.isLoading) {
            this.mViewContainer.setVisibility(visibility);
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    @NotNull
    protected View createView(@Nullable Context context) {
        LinearLayout root = cs.g(LayoutInflater.from(context)).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(LayoutInflater.from(context)).getRoot()");
        return root;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    @NotNull
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getComponentType() {
        return 1007;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getContentLayoutId() {
        return R.layout.f168147f23;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onConfigurationChanged() {
        QLog.i(TAG, 1, "onConfigurationChanged");
        bindJoinedItem(this.currentGuildList);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onCreate(@Nullable Fragment fragment, @Nullable AppInterface appInterface, @Nullable Bundle savedInstanceState) {
        super.onCreate(fragment, appInterface, savedInstanceState);
        initView();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadFinish() {
        this.isLoading = false;
        setContainerVisibleAwareLoading(this.visibility);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadStart() {
        this.isLoading = true;
        this.mViewContainer.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onInitData(@NotNull GuildProfileData guildProfileData) {
        Intrinsics.checkNotNullParameter(guildProfileData, "guildProfileData");
        super.onInitData(guildProfileData);
        bindUI(guildProfileData);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onUpdateData(@NotNull GuildProfileData guildProfileData) {
        Intrinsics.checkNotNullParameter(guildProfileData, "guildProfileData");
        super.onUpdateData(guildProfileData);
        bindUI(guildProfileData);
    }
}
