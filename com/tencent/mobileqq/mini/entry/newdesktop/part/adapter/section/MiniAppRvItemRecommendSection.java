package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entity.AppBubbleRecordEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J*\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppRvItemRecommendSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "mMiniAppDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "getMMiniAppDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "mMiniAppDesktopViewModel$delegate", "Lkotlin/Lazy;", "mRecommendBadge", "Landroid/widget/ImageView;", "mRecommendBubbleBgIv", "mRecommendBubbleRl", "Landroid/widget/RelativeLayout;", "mRecommendBubbleTextTv", "Landroid/widget/TextView;", "getViewStubLayoutId", "", "onBindData", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "position", "", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemRecommendSection extends AbsMiniAppRvItemSection {
    private static final String TAG = "MiniAppDesktopPart.MiniAppRvItemRecommendSection";

    /* renamed from: mMiniAppDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppDesktopViewModel;
    private ImageView mRecommendBadge;
    private ImageView mRecommendBubbleBgIv;
    private RelativeLayout mRecommendBubbleRl;
    private TextView mRecommendBubbleTextTv;

    public MiniAppRvItemRecommendSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppDeskTopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppRvItemRecommendSection$mMiniAppDesktopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppDeskTopViewModel invoke() {
                ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(MiniAppRvItemRecommendSection.this.getRootView());
                MiniAppDeskTopViewModel miniAppDeskTopViewModel = viewModelStoreOwner != null ? (MiniAppDeskTopViewModel) new ViewModelProvider(viewModelStoreOwner).get(MiniAppDeskTopViewModel.class) : null;
                if (miniAppDeskTopViewModel != null) {
                    Context context = MiniAppRvItemRecommendSection.this.getRootView().getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    miniAppDeskTopViewModel.setContextHashCode(((Activity) context).hashCode());
                }
                return miniAppDeskTopViewModel;
            }
        });
        this.mMiniAppDesktopViewModel = lazy;
    }

    private final MiniAppDeskTopViewModel getMMiniAppDesktopViewModel() {
        return (MiniAppDeskTopViewModel) this.mMiniAppDesktopViewModel.getValue();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(DesktopItemInfo desktopItemInfo, int i3, List list) {
        onBindData2(desktopItemInfo, i3, (List<Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(DesktopItemInfo data, int position, List<Object> payload) {
        AppBubbleRecordEntity appBubbleRecordEntity;
        if (data == null || !(data instanceof DesktopAppInfo)) {
            return;
        }
        DesktopAppInfo desktopAppInfo = (DesktopAppInfo) data;
        if (desktopAppInfo.mMiniAppInfo == null) {
            return;
        }
        RelativeLayout relativeLayout = null;
        if (desktopAppInfo.getModuleType() != 2 && desktopAppInfo.getModuleType() != 1) {
            ImageView imageView = this.mRecommendBadge;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecommendBadge");
                imageView = null;
            }
            imageView.setVisibility(8);
            desktopAppInfo.setRecommendBadgeShow(false);
        } else {
            ImageView imageView2 = this.mRecommendBadge;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecommendBadge");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
            if (!TextUtils.isEmpty(miniAppInfo != null ? miniAppInfo.recommendAppIconUrl : null)) {
                MiniAppInfo miniAppInfo2 = desktopAppInfo.mMiniAppInfo;
                Drawable drawable = MiniAppUtils.getDrawable(miniAppInfo2 != null ? miniAppInfo2.recommendAppIconUrl : null, null);
                ImageView imageView3 = this.mRecommendBadge;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecommendBadge");
                    imageView3 = null;
                }
                imageView3.setImageDrawable(drawable);
                desktopAppInfo.setRecommendBadgeShow(true);
            } else {
                ImageView imageView4 = this.mRecommendBadge;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecommendBadge");
                    imageView4 = null;
                }
                imageView4.setImageDrawable(null);
                desktopAppInfo.setRecommendBadgeShow(false);
            }
        }
        if (desktopAppInfo.getModuleType() != 2 && desktopAppInfo.getModuleType() != 1) {
            RelativeLayout relativeLayout2 = this.mRecommendBubbleRl;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecommendBubbleRl");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setVisibility(8);
            desktopAppInfo.setBubbleShown(false);
            return;
        }
        MiniAppDeskTopViewModel mMiniAppDesktopViewModel = getMMiniAppDesktopViewModel();
        if (mMiniAppDesktopViewModel != null) {
            String str = desktopAppInfo.mMiniAppInfo.appId;
            Intrinsics.checkNotNullExpressionValue(str, "data.mMiniAppInfo.appId");
            int moduleType = desktopAppInfo.getModuleType();
            String str2 = desktopAppInfo.mMiniAppInfo.bubbleText;
            Intrinsics.checkNotNullExpressionValue(str2, "data.mMiniAppInfo.bubbleText");
            appBubbleRecordEntity = mMiniAppDesktopViewModel.miniAppBubbleEnsureBubbleRecord(str, moduleType, str2, desktopAppInfo.mMiniAppInfo.bubbleClickCount);
        } else {
            appBubbleRecordEntity = null;
        }
        boolean z16 = appBubbleRecordEntity != null && appBubbleRecordEntity.shouldShowAppBubble();
        MiniAppInfo miniAppInfo3 = desktopAppInfo.mMiniAppInfo;
        if (!TextUtils.isEmpty(miniAppInfo3 != null ? miniAppInfo3.bubbleText : null) && z16) {
            TextView textView = this.mRecommendBubbleTextTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecommendBubbleTextTv");
                textView = null;
            }
            MiniAppInfo miniAppInfo4 = desktopAppInfo.mMiniAppInfo;
            textView.setText(miniAppInfo4 != null ? miniAppInfo4.bubbleText : null);
            RelativeLayout relativeLayout3 = this.mRecommendBubbleRl;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecommendBubbleRl");
            } else {
                relativeLayout = relativeLayout3;
            }
            relativeLayout.setVisibility(0);
            desktopAppInfo.setBubbleShown(true);
            return;
        }
        RelativeLayout relativeLayout4 = this.mRecommendBubbleRl;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendBubbleRl");
        } else {
            relativeLayout = relativeLayout4;
        }
        relativeLayout.setVisibility(8);
        desktopAppInfo.setBubbleShown(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.rhf);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.mini_app_recommend_mark)");
            this.mRecommendBadge = (ImageView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.rhc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.mini_app_recommend_bubble)");
            this.mRecommendBubbleRl = (RelativeLayout) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.rhd);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.mini_app_recommend_bubble_bg)");
            this.mRecommendBubbleBgIv = (ImageView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.rhe);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.mini_app_recommend_bubble_text)");
            this.mRecommendBubbleTextTv = (TextView) findViewById4;
        }
    }
}
