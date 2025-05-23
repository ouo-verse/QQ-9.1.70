package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section;

import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.AbsMiniAppRvItemSection;
import com.tencent.mobileqq.mini.util.WxMiniAppMigrateAnimUtil;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0006\u0010\u000f\u001a\u00020\u0010J*\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppRvItemScanningLightIconSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "containerView", "Landroid/view/View;", "mIconImageView", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "mItemData", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "mWxTagIv", "Landroid/widget/ImageView;", "currentIconUrl", "", "getViewStubLayoutId", "", "highLight", "", "onBindData", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "position", "", "payload", "", "", "onInitView", "onViewRecycled", "onVisibleChanged", NodeProps.VISIBLE, "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemScanningLightIconSection extends AbsMiniAppRvItemSection {
    private static final String TAG = "MiniAppExpDesktopPart.MiniAppRvItemScanningLightIconSection";
    private View containerView;
    private RoundRectImageView mIconImageView;
    private DesktopAppInfo mItemData;
    private ImageView mWxTagIv;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, WeakReference<MiniAppRvItemScanningLightIconSection>> canHighLightUI = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000RF\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006j\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007`\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppRvItemScanningLightIconSection$Companion;", "", "()V", "TAG", "", "canHighLightUI", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppRvItemScanningLightIconSection;", "Lkotlin/collections/HashMap;", "getCanHighLightUI", "()Ljava/util/HashMap;", "setCanHighLightUI", "(Ljava/util/HashMap;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HashMap<String, WeakReference<MiniAppRvItemScanningLightIconSection>> getCanHighLightUI() {
            return MiniAppRvItemScanningLightIconSection.canHighLightUI;
        }

        public final void setCanHighLightUI(HashMap<String, WeakReference<MiniAppRvItemScanningLightIconSection>> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
            MiniAppRvItemScanningLightIconSection.canHighLightUI = hashMap;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindData$lambda$1(MiniAppRvItemScanningLightIconSection this$0, int i3, DesktopItemInfo desktopItemInfo, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DesktopAppInfo desktopAppInfo = this$0.mItemData;
        Intrinsics.checkNotNull(desktopAppInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
        if (desktopAppInfo.getModuleType() == 1 && i3 == 0 && loadState == LoadState.STATE_SUCCESS) {
            WxMiniAppMigrateAnimUtil.Companion companion = WxMiniAppMigrateAnimUtil.INSTANCE;
            if (companion.isOpenMiniAppScanningLight()) {
                View mRootView = this$0.mRootView;
                Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
                Intrinsics.checkNotNullExpressionValue(option, "option");
                companion.startIconAnim(mRootView, option);
                MiniAppInfo miniAppInfo = ((DesktopAppInfo) desktopItemInfo).mMiniAppInfo;
                QLog.i(TAG, 1, "onBindData setMiniAppScanningLight position" + i3 + " state:" + loadState + " iconUrl:" + (miniAppInfo != null ? miniAppInfo.iconUrl : null));
                return;
            }
            companion.removeMiniAppScanningLight();
            MiniAppInfo miniAppInfo2 = ((DesktopAppInfo) desktopItemInfo).mMiniAppInfo;
            QLog.i(TAG, 1, "onBindData removeMiniAppScanningLight position" + i3 + " state:" + loadState + " iconUrl:" + (miniAppInfo2 != null ? miniAppInfo2.iconUrl : null));
        }
    }

    public final String currentIconUrl() {
        MiniAppInfo miniAppInfo;
        DesktopAppInfo desktopAppInfo = this.mItemData;
        if (desktopAppInfo == null || (miniAppInfo = desktopAppInfo.mMiniAppInfo) == null) {
            return null;
        }
        return miniAppInfo.iconUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return null;
    }

    public final void highLight() {
        int i3;
        WxMiniAppMigrateAnimUtil.INSTANCE.setOpenMiniAppScanningLight(true);
        ViewParent parent = this.mRootView.getParent();
        RecyclerView recyclerView = parent instanceof RecyclerView ? (RecyclerView) parent : null;
        DesktopAppInfo desktopAppInfo = this.mItemData;
        if (recyclerView != null) {
            i3 = recyclerView.indexOfChild(this.mRootView);
        } else {
            i3 = this.mPosition;
        }
        onBindData2((DesktopItemInfo) desktopAppInfo, i3, (List<Object>) new ArrayList());
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(DesktopItemInfo desktopItemInfo, int i3, List list) {
        onBindData2(desktopItemInfo, i3, (List<Object>) list);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onViewRecycled() {
        super.onViewRecycled();
        DesktopAppInfo desktopAppInfo = this.mItemData;
        if (desktopAppInfo != null) {
            canHighLightUI.remove(desktopAppInfo.mMiniAppInfo.appId);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        QUIBadge qUIBadge;
        super.onVisibleChanged(visible);
        if (visible || (qUIBadge = (QUIBadge) getRootView().findViewById(R.id.rlz)) == null) {
            return;
        }
        qUIBadge.setVisibility(8);
    }

    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(final DesktopItemInfo data, final int position, List<Object> payload) {
        if (data instanceof DesktopAppInfo) {
            DesktopAppInfo desktopAppInfo = (DesktopAppInfo) data;
            if (desktopAppInfo.getModuleType() == 1) {
                HashMap<String, WeakReference<MiniAppRvItemScanningLightIconSection>> hashMap = canHighLightUI;
                String str = desktopAppInfo.mMiniAppInfo.appId;
                Intrinsics.checkNotNullExpressionValue(str, "data.mMiniAppInfo.appId");
                hashMap.put(str, new WeakReference<>(this));
            }
        }
        if (data != null && (data instanceof DesktopAppInfo)) {
            DesktopAppInfo desktopAppInfo2 = (DesktopAppInfo) data;
            if (desktopAppInfo2.mMiniAppInfo != null) {
                this.mItemData = desktopAppInfo2;
                Option obtain = Option.obtain();
                MiniAppInfo miniAppInfo = desktopAppInfo2.mMiniAppInfo;
                ImageView imageView = null;
                Option url = obtain.setUrl(miniAppInfo != null ? miniAppInfo.iconUrl : null);
                RoundRectImageView roundRectImageView = this.mIconImageView;
                if (roundRectImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                    roundRectImageView = null;
                }
                Option option = url.setTargetView(roundRectImageView);
                QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                Intrinsics.checkNotNullExpressionValue(option, "option");
                qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section.a
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option2) {
                        MiniAppRvItemScanningLightIconSection.onBindData$lambda$1(MiniAppRvItemScanningLightIconSection.this, position, data, loadState, option2);
                    }
                });
                DesktopAppInfo desktopAppInfo3 = this.mItemData;
                Intrinsics.checkNotNull(desktopAppInfo3);
                if (desktopAppInfo3.mMiniAppInfo.isWxMiniApp()) {
                    ImageView imageView2 = this.mWxTagIv;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mWxTagIv");
                    } else {
                        imageView = imageView2;
                    }
                    imageView.setVisibility(0);
                    return;
                }
                ImageView imageView3 = this.mWxTagIv;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWxTagIv");
                } else {
                    imageView = imageView3;
                }
                imageView.setVisibility(8);
                return;
            }
        }
        QLog.e(TAG, 1, "onBindData data invalid, " + data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.rjn);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.miniapp_items_image)");
            RoundRectImageView roundRectImageView = (RoundRectImageView) findViewById;
            this.mIconImageView = roundRectImageView;
            if (roundRectImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                roundRectImageView = null;
            }
            roundRectImageView.setCornerRadiusAndMode(ViewUtils.dip2px(30.0f), 1);
            View findViewById2 = containerView.findViewById(R.id.f163693ri0);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.mini_app_wx_tag_iv)");
            this.mWxTagIv = (ImageView) findViewById2;
        }
        this.containerView = containerView;
    }
}
