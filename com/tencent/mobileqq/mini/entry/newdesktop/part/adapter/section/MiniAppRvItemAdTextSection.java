package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0014J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J*\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppRvItemAdTextSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "mAdTv", "Landroid/widget/TextView;", "getLogTag", "", "getViewStubLayoutId", "", "isGdtAd", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "position", "", "onBindData", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemAdTextSection extends AbsMiniAppRvItemSection {
    private TextView mAdTv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppRvItemAdTextSection";
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
        if (data != null && (data instanceof DesktopAppInfo)) {
            DesktopAppInfo desktopAppInfo = (DesktopAppInfo) data;
            if (desktopAppInfo.mMiniAppInfo != null) {
                boolean isGdtAd = isGdtAd(desktopAppInfo, position);
                TextView textView = null;
                if (isGdtAd) {
                    TextView textView2 = this.mAdTv;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdTv");
                        textView2 = null;
                    }
                    textView2.setVisibility(0);
                    TextView textView3 = this.mAdTv;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdTv");
                    } else {
                        textView = textView3;
                    }
                    textView.setText(HardCodeUtil.qqStr(R.string.pwo));
                    return;
                }
                TextView textView4 = this.mAdTv;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdTv");
                } else {
                    textView = textView4;
                }
                textView.setVisibility(8);
                return;
            }
        }
        QLog.e(getTAG(), 1, "onBindData data is error!");
    }

    private final boolean isGdtAd(DesktopAppInfo data, int position) {
        return (data != null && data.mModuleType == 1) && data.mMiniAppInfo.isGdtMiniAppAd && (5 == position || 6 == position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.rfd);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.mini_app_ad_text)");
            this.mAdTv = (TextView) findViewById;
        }
    }
}
