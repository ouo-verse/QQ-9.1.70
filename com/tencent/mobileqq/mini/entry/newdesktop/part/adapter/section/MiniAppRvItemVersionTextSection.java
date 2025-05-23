package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J*\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppRvItemVersionTextSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "mVersionTypeMark", "Landroid/widget/TextView;", "getViewStubLayoutId", "", "onBindData", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "position", "", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemVersionTextSection extends AbsMiniAppRvItemSection {
    private TextView mVersionTypeMark;

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
        MiniAppInfo miniAppInfo;
        if (data == null || !(data instanceof DesktopAppInfo) || (miniAppInfo = ((DesktopAppInfo) data).mMiniAppInfo) == null) {
            return;
        }
        TextView textView = null;
        if (!(miniAppInfo != null && miniAppInfo.verType == 0)) {
            if (!(miniAppInfo != null && miniAppInfo.verType == 4)) {
                if (miniAppInfo != null && miniAppInfo.verType == 1) {
                    TextView textView2 = this.mVersionTypeMark;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVersionTypeMark");
                        textView2 = null;
                    }
                    textView2.setVisibility(0);
                    TextView textView3 = this.mVersionTypeMark;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVersionTypeMark");
                    } else {
                        textView = textView3;
                    }
                    textView.setText(HardCodeUtil.qqStr(R.string.f172192o73));
                    return;
                }
                TextView textView4 = this.mVersionTypeMark;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVersionTypeMark");
                } else {
                    textView = textView4;
                }
                textView.setVisibility(8);
                return;
            }
        }
        TextView textView5 = this.mVersionTypeMark;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVersionTypeMark");
            textView5 = null;
        }
        textView5.setVisibility(0);
        TextView textView6 = this.mVersionTypeMark;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVersionTypeMark");
        } else {
            textView = textView6;
        }
        textView.setText(HardCodeUtil.qqStr(R.string.o6u));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.rjr);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.miniapp_items_version_type_mark)");
            this.mVersionTypeMark = (TextView) findViewById;
        }
    }
}
