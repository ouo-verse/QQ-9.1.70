package com.tencent.state.square.components.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import com.tencent.state.square.detail.EntranceSource;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.detail.SubScene;
import com.tencent.state.square.holder.AvatarViewHolder;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.square.pickfriend.service.PickFriendEntryInfoData;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.utils.TimeFormatUtils;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J,\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareQuickPublishEntryComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "data", "Lcom/tencent/state/square/pickfriend/service/PickFriendEntryInfoData;", "bindView", "", "gotoDetail", "url", "", "vh", "Lcom/tencent/state/square/holder/AvatarViewHolder;", "handleClick", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "scaleToMeCenter", "onDone", "Lkotlin/Function1;", "shouldTipsShow", "", "Companion", "JumpInfo", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareQuickPublishEntryComponent extends SquareBaseComponent {
    private static final String SQUARE_PERSONAL_CENTER = "squarePersonalCenter";
    private static final String TAG = "SquareQuickPublishEntryComponent";
    private VasSquareFragmentSquareBinding binding;
    private final FastClickUtils clickUtils = new FastClickUtils(800);
    private PickFriendEntryInfoData data;

    private final void bindView() {
        LinearLayout linearLayout;
        TextView textView;
        FrameLayout frameLayout;
        PickFriendEntryInfoData pickFriendEntryInfoData = this.data;
        if (pickFriendEntryInfoData != null) {
            VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
            if (vasSquareFragmentSquareBinding != null && (frameLayout = vasSquareFragmentSquareBinding.quickPublishEntry) != null) {
                ViewExtensionsKt.setVisibility(frameLayout, true);
            }
            VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding2 = this.binding;
            if (vasSquareFragmentSquareBinding2 != null && (textView = vasSquareFragmentSquareBinding2.quickPublishEntryTipsText) != null) {
                textView.setText(pickFriendEntryInfoData.getTitle());
            }
            ImageLoader loader = ImageService.INSTANCE.getLoader();
            if (loader != null) {
                String iconUrl = pickFriendEntryInfoData.getIconUrl();
                VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding3 = this.binding;
                loader.displayImage(iconUrl, vasSquareFragmentSquareBinding3 != null ? vasSquareFragmentSquareBinding3.quickPublishEntryBtn : null);
            }
            if (shouldTipsShow()) {
                VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding4 = this.binding;
                if (vasSquareFragmentSquareBinding4 != null && (linearLayout = vasSquareFragmentSquareBinding4.quickPublishEntryTips) != null) {
                    ViewExtensionsKt.setVisibility(linearLayout, true);
                }
                SquareBaseKt.getSquareLog().i(TAG, "shouldTipsShow, true");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void gotoDetail(String url, AvatarViewHolder vh5) {
        VasBaseFragment fragment;
        Context context;
        int indexOf$default;
        SquareFragment squareFragment;
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) vh5.getData();
        if (squareAvatarItem == null || (fragment = getFragment()) == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url, SQUARE_PERSONAL_CENTER, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            try {
                JumpInfo fromUrl = JumpInfo.INSTANCE.fromUrl(url);
                if (fromUrl == null || (squareFragment = getSquareFragment()) == null) {
                    return;
                }
                MainScene mainScene = MainScene.SQUARE;
                SubScene subScene = SubScene.UNKNOWN;
                String subReferer = fromUrl.getSubReferer();
                if (subReferer == null) {
                    QBaseActivity activity = getActivity();
                    subReferer = activity != null ? SquareGroupReportComponentKt.getSourceFrom(activity) : null;
                }
                if (subReferer == null) {
                    subReferer = "";
                }
                squareFragment.doGotoDetailPage(squareAvatarItem, new EntranceSource(mainScene, subScene, subReferer), true, fromUrl.getStatusId(), fromUrl.getRichStatusId(), fromUrl.getActionId(), (r17 & 64) != 0 ? null : null);
                return;
            } catch (Throwable unused) {
                SquareBaseKt.getSquareRouter().routeLink(context, new EntranceLink(url, 2));
                return;
            }
        }
        SquareBaseKt.getSquareRouter().routeLink(context, new EntranceLink(url, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleClick() {
        final String jumpUrl;
        LinearLayout linearLayout;
        if (this.clickUtils.isFastDoubleClick()) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "handleClick, data: " + this.data);
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding != null && (linearLayout = vasSquareFragmentSquareBinding.quickPublishEntryTips) != null) {
            ViewExtensionsKt.setVisibility(linearLayout, false);
        }
        IMMKV.DefaultImpls.encodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.QuickPublishEntry.LAST_CLICK_TIME, System.currentTimeMillis(), null, false, 12, null);
        PickFriendEntryInfoData pickFriendEntryInfoData = this.data;
        if (pickFriendEntryInfoData == null || (jumpUrl = pickFriendEntryInfoData.getJumpUrl()) == null) {
            return;
        }
        scaleToMeCenter(new Function1<AvatarViewHolder, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareQuickPublishEntryComponent$handleClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AvatarViewHolder avatarViewHolder) {
                invoke2(avatarViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AvatarViewHolder it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareQuickPublishEntryComponent.this.gotoDetail(jumpUrl, it);
            }
        });
    }

    private final void scaleToMeCenter(final Function1<? super AvatarViewHolder, Unit> onDone) {
        final SquareView mapView = getMapView();
        if (mapView != null) {
            final Integer meIndex = mapView.getMeIndex();
            if (meIndex == null) {
                SquareBaseKt.getSquareLog().i(TAG, "scaleToMeCenter, meIndex is null");
                return;
            }
            MapViewHolder<?> viewHolder = mapView.getViewHolder(meIndex.intValue());
            if (!(viewHolder instanceof AvatarViewHolder)) {
                viewHolder = null;
            }
            AvatarViewHolder avatarViewHolder = (AvatarViewHolder) viewHolder;
            if (avatarViewHolder == null) {
                IMapViewManipulator.DefaultImpls.locateToMe$default(mapView.getManipulator(), 0, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareQuickPublishEntryComponent$scaleToMeCenter$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        MapViewHolder<?> viewHolder2 = SquareView.this.getViewHolder(meIndex.intValue());
                        if (!(viewHolder2 instanceof AvatarViewHolder)) {
                            viewHolder2 = null;
                        }
                        AvatarViewHolder avatarViewHolder2 = (AvatarViewHolder) viewHolder2;
                        if (avatarViewHolder2 == null || !avatarViewHolder2.onScaleToDetail()) {
                            return;
                        }
                        onDone.invoke(avatarViewHolder2);
                    }
                }, 1, null);
            } else if (avatarViewHolder.onScaleToDetail()) {
                onDone.invoke(avatarViewHolder);
            }
        }
    }

    private final boolean shouldTipsShow() {
        return !TimeFormatUtils.INSTANCE.isToday(IMMKV.DefaultImpls.decodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.QuickPublishEntry.LAST_CLICK_TIME, 0L, null, false, 12, null));
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        SquareImageView squareImageView;
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        VasSquareFragmentSquareBinding bind = VasSquareFragmentSquareBinding.bind(v3);
        this.binding = bind;
        if (bind != null && (frameLayout = bind.quickPublishEntry) != null) {
            ViewExtensionsKt.setVisibility(frameLayout, false);
        }
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding != null && (squareImageView = vasSquareFragmentSquareBinding.quickPublishEntryBtn) != null) {
            squareImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.components.fragment.SquareQuickPublishEntryComponent$onFragmentViewCreated$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SquareQuickPublishEntryComponent.this.handleClick();
                }
            });
        }
        this.data = new PickFriendEntryInfoData("https://cdn.meta.qq.com/square/icons/add_status.png", "\u5f00\u542f\u4f60\u7684\u6175\u61d2\u751f\u6d3b", "mqqapi://zplan/squarePersonalCenter?src_type=app&version=1.0&subReferer=em_square_guide_bubble&needOpenStatusPanel=1&scene=1");
        bindView();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JH\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareQuickPublishEntryComponent$JumpInfo;", "", "url", "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "", DetailMeFragmentConfig.CURRENT_RICH_ID, "actionId", "subReferer", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getActionId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRichStatusId", "getStatusId", "getSubReferer", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tencent/state/square/components/fragment/SquareQuickPublishEntryComponent$JumpInfo;", "equals", "", "other", "hashCode", "toString", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class JumpInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer actionId;
        private final Integer richStatusId;
        private final Integer statusId;
        private final String subReferer;
        private final String url;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareQuickPublishEntryComponent$JumpInfo$Companion;", "", "()V", WadlProxyConsts.FROM_URL, "Lcom/tencent/state/square/components/fragment/SquareQuickPublishEntryComponent$JumpInfo;", "url", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes38.dex */
        public static final class Companion {
            Companion() {
            }

            public final JumpInfo fromUrl(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                try {
                    Uri parse = Uri.parse(url);
                    String queryParameter = parse.getQueryParameter(DetailMeFragmentConfig.CURRENT_STATUS_ID);
                    Integer valueOf = queryParameter != null ? Integer.valueOf(Integer.parseInt(queryParameter)) : null;
                    String queryParameter2 = parse.getQueryParameter(DetailMeFragmentConfig.CURRENT_RICH_ID);
                    Integer valueOf2 = queryParameter2 != null ? Integer.valueOf(Integer.parseInt(queryParameter2)) : null;
                    String queryParameter3 = parse.getQueryParameter("actionId");
                    return new JumpInfo(url, valueOf, valueOf2, queryParameter3 != null ? Integer.valueOf(Integer.parseInt(queryParameter3)) : null, parse.getQueryParameter("subReferer"));
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), SquareQuickPublishEntryComponent.TAG, "fromUrl, err: " + th5, null, 4, null);
                    return null;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public JumpInfo(String url, Integer num, Integer num2, Integer num3, String str) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.statusId = num;
            this.richStatusId = num2;
            this.actionId = num3;
            this.subReferer = str;
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getStatusId() {
            return this.statusId;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getRichStatusId() {
            return this.richStatusId;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getActionId() {
            return this.actionId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getSubReferer() {
            return this.subReferer;
        }

        public final JumpInfo copy(String url, Integer statusId, Integer richStatusId, Integer actionId, String subReferer) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new JumpInfo(url, statusId, richStatusId, actionId, subReferer);
        }

        public final Integer getActionId() {
            return this.actionId;
        }

        public final Integer getRichStatusId() {
            return this.richStatusId;
        }

        public final Integer getStatusId() {
            return this.statusId;
        }

        public final String getSubReferer() {
            return this.subReferer;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.url;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.statusId;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.richStatusId;
            int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.actionId;
            int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 31;
            String str2 = this.subReferer;
            return hashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "JumpInfo(url=" + this.url + ", statusId=" + this.statusId + ", richStatusId=" + this.richStatusId + ", actionId=" + this.actionId + ", subReferer=" + this.subReferer + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JumpInfo)) {
                return false;
            }
            JumpInfo jumpInfo = (JumpInfo) other;
            return Intrinsics.areEqual(this.url, jumpInfo.url) && Intrinsics.areEqual(this.statusId, jumpInfo.statusId) && Intrinsics.areEqual(this.richStatusId, jumpInfo.richStatusId) && Intrinsics.areEqual(this.actionId, jumpInfo.actionId) && Intrinsics.areEqual(this.subReferer, jumpInfo.subReferer);
        }

        public static /* synthetic */ JumpInfo copy$default(JumpInfo jumpInfo, String str, Integer num, Integer num2, Integer num3, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = jumpInfo.url;
            }
            if ((i3 & 2) != 0) {
                num = jumpInfo.statusId;
            }
            Integer num4 = num;
            if ((i3 & 4) != 0) {
                num2 = jumpInfo.richStatusId;
            }
            Integer num5 = num2;
            if ((i3 & 8) != 0) {
                num3 = jumpInfo.actionId;
            }
            Integer num6 = num3;
            if ((i3 & 16) != 0) {
                str2 = jumpInfo.subReferer;
            }
            return jumpInfo.copy(str, num4, num5, num6, str2);
        }
    }
}
