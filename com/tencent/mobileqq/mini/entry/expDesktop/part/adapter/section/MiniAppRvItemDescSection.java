package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.TagInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.AbsMiniAppRvItemSection;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J*\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppRvItemDescSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "mItemData", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "mMiniAppDescTv", "Landroid/widget/TextView;", "getViewStubLayoutId", "", "onBindData", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "position", "", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemDescSection extends AbsMiniAppRvItemSection {
    private static final String TAG = "MiniAppExpDesktopPart.MiniAppExtDesktopDescSection";
    private DesktopAppInfo mItemData;
    private TextView mMiniAppDescTv;

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
        DesktopAppInfo desktopAppInfo;
        MiniAppInfo miniAppInfo;
        if (data != null && (data instanceof DesktopAppInfo) && (miniAppInfo = (desktopAppInfo = (DesktopAppInfo) data).mMiniAppInfo) != null) {
            this.mItemData = desktopAppInfo;
            if (miniAppInfo != null) {
                TagInfo tagInfo = miniAppInfo.tagInfo;
                TextView textView = null;
                if (TextUtils.isEmpty(tagInfo != null ? tagInfo.tagText : null)) {
                    TextView textView2 = this.mMiniAppDescTv;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMiniAppDescTv");
                    } else {
                        textView = textView2;
                    }
                    textView.setVisibility(8);
                    return;
                }
                TextView textView3 = this.mMiniAppDescTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMiniAppDescTv");
                    textView3 = null;
                }
                textView3.setVisibility(0);
                TextView textView4 = this.mMiniAppDescTv;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMiniAppDescTv");
                    textView4 = null;
                }
                TagInfo tagInfo2 = miniAppInfo.tagInfo;
                textView4.setText(tagInfo2 != null ? tagInfo2.tagText : null);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "onBindData data invalid, " + data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.rjm);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.miniapp_items_app_desc_tv)");
            this.mMiniAppDescTv = (TextView) findViewById;
        }
    }
}
