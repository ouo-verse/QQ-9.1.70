package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.AbsMiniAppRvItemSection;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J*\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppRvItemNameSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "mItemData", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "mMiniAppNameTv", "Landroid/widget/TextView;", "getViewStubLayoutId", "", "onBindData", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "position", "", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemNameSection extends AbsMiniAppRvItemSection {
    private static final String TAG = "MiniAppExpDesktopPart.MiniAppRvItemIconSection";
    private DesktopAppInfo mItemData;
    private TextView mMiniAppNameTv;

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
            String str = miniAppInfo != null ? miniAppInfo.name : null;
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                if (str.length() <= 5) {
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
                    MiniAppInfo miniAppInfo2 = desktopAppInfo.mMiniAppInfo;
                    textView2.setText(miniAppInfo2 != null ? miniAppInfo2.name : null);
                    return;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intrinsics.checkNotNull(str);
            if (str.length() > 5) {
                TextView textView3 = this.mMiniAppNameTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMiniAppNameTv");
                    textView3 = null;
                }
                textView3.setVisibility(0);
                TextView textView4 = this.mMiniAppNameTv;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMiniAppNameTv");
                    textView4 = null;
                }
                MiniAppInfo miniAppInfo3 = desktopAppInfo.mMiniAppInfo;
                String str2 = miniAppInfo3 != null ? miniAppInfo3.name : null;
                Intrinsics.checkNotNull(str2);
                String substring = str2.substring(0, 4);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                textView4.setText(substring + MiniBoxNoticeInfo.APPNAME_SUFFIX);
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
            View findViewById = containerView.findViewById(R.id.rjq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.miniapp_items_text)");
            this.mMiniAppNameTv = (TextView) findViewById;
        }
    }
}
