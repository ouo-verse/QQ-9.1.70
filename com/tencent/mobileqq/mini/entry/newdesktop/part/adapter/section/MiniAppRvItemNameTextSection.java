package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0014J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J*\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppRvItemNameTextSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "mMiniAppNameTv", "Landroid/widget/TextView;", "getLogTag", "", "getViewStubLayoutId", "", "isGdtAd", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "position", "", "onBindData", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemNameTextSection extends AbsMiniAppRvItemSection {
    private TextView mMiniAppNameTv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppRvItemNameTextSection";
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
        DesktopAppInfo desktopAppInfo;
        MiniAppInfo miniAppInfo;
        if (data != null && (data instanceof DesktopAppInfo) && (miniAppInfo = (desktopAppInfo = (DesktopAppInfo) data).mMiniAppInfo) != null) {
            if (!TextUtils.isEmpty(miniAppInfo != null ? miniAppInfo.name : null)) {
                TextView textView = this.mMiniAppNameTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMiniAppNameTv");
                    textView = null;
                }
                textView.setVisibility(0);
                TextView textView2 = this.mMiniAppNameTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMiniAppNameTv");
                    textView2 = null;
                }
                textView2.setTextSize(13.0f);
                TextView textView3 = this.mMiniAppNameTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMiniAppNameTv");
                    textView3 = null;
                }
                MiniAppInfo miniAppInfo2 = desktopAppInfo.mMiniAppInfo;
                textView3.setText(miniAppInfo2 != null ? miniAppInfo2.name : null);
                TextView textView4 = this.mMiniAppNameTv;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMiniAppNameTv");
                    textView4 = null;
                }
                textView4.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_primary));
            }
            if (isGdtAd(desktopAppInfo, position)) {
                Drawable drawable = ResourcesCompat.getDrawable(getRootView().getContext().getResources(), R.drawable.ioc, null);
                TextView textView5 = this.mMiniAppNameTv;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMiniAppNameTv");
                    textView5 = null;
                }
                textView5.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            TextView textView6 = this.mMiniAppNameTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMiniAppNameTv");
                textView6 = null;
            }
            textView6.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        QLog.d(getTAG(), 1, "onBindData data is error!");
    }

    private final boolean isGdtAd(DesktopAppInfo data, int position) {
        return (data != null && data.mModuleType == 1) && data.mMiniAppInfo.isGdtMiniAppAd && (5 == position || 6 == position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.rjq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.miniapp_items_text)");
            this.mMiniAppNameTv = (TextView) findViewById;
        }
    }
}
