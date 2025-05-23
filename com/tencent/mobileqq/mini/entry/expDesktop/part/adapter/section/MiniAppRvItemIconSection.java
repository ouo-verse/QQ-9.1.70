package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.AbsMiniAppRvItemSection;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J*\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0014J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppRvItemIconSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "mIconImageView", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "mItemData", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "mWxTagIv", "Landroid/widget/ImageView;", "getViewStubLayoutId", "", "onBindData", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "position", "", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemIconSection extends AbsMiniAppRvItemSection {
    private static final String TAG = "MiniAppExpDesktopPart.MiniAppRvItemIconSection";
    private RoundRectImageView mIconImageView;
    private DesktopAppInfo mItemData;
    private ImageView mWxTagIv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(DesktopItemInfo desktopItemInfo, int i3, List list) {
        onBindData2(desktopItemInfo, i3, (List<Object>) list);
    }

    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(DesktopItemInfo data, int position, List<Object> payload) {
        if (data != null && (data instanceof DesktopAppInfo)) {
            DesktopAppInfo desktopAppInfo = (DesktopAppInfo) data;
            if (desktopAppInfo.mMiniAppInfo != null) {
                this.mItemData = desktopAppInfo;
                Context context = getRootView().getContext();
                MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
                ImageView imageView = null;
                Drawable icon = MiniAppUtils.getIcon(context, miniAppInfo != null ? miniAppInfo.iconUrl : null, true);
                RoundRectImageView roundRectImageView = this.mIconImageView;
                if (roundRectImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                    roundRectImageView = null;
                }
                roundRectImageView.setImageDrawable(icon);
                DesktopAppInfo desktopAppInfo2 = this.mItemData;
                Intrinsics.checkNotNull(desktopAppInfo2);
                if (desktopAppInfo2.mMiniAppInfo.isWxMiniApp()) {
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
    }
}
