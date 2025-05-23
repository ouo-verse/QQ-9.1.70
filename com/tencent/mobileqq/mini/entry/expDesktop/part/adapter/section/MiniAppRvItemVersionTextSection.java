package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.AbsMiniAppRvItemSection;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J*\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppRvItemVersionTextSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "mVersionTypeMark", "Landroid/widget/TextView;", "getViewStubLayoutId", "", "onBindData", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "position", "", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemVersionTextSection extends AbsMiniAppRvItemSection {
    private static final String TAG = "MiniAppRvItemVersionTextSection";
    private TextView mVersionTypeMark;

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
        MiniAppInfo miniAppInfo;
        if (data != null && (data instanceof DesktopAppInfo) && (miniAppInfo = ((DesktopAppInfo) data).mMiniAppInfo) != null) {
            Integer valueOf = miniAppInfo != null ? Integer.valueOf(miniAppInfo.verType) : null;
            if ((valueOf != null && valueOf.intValue() == 0) || (valueOf != null && valueOf.intValue() == 4)) {
                TextView textView = this.mVersionTypeMark;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                TextView textView2 = this.mVersionTypeMark;
                if (textView2 == null) {
                    return;
                }
                textView2.setText(HardCodeUtil.qqStr(R.string.o6u));
                return;
            }
            if (valueOf != null && valueOf.intValue() == 1) {
                TextView textView3 = this.mVersionTypeMark;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                TextView textView4 = this.mVersionTypeMark;
                if (textView4 == null) {
                    return;
                }
                textView4.setText(HardCodeUtil.qqStr(R.string.f172192o73));
                return;
            }
            TextView textView5 = this.mVersionTypeMark;
            if (textView5 == null) {
                return;
            }
            textView5.setVisibility(8);
            return;
        }
        QLog.e(TAG, 1, "onBindData data invalid, " + data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            this.mVersionTypeMark = (TextView) containerView.findViewById(R.id.rjr);
        }
    }
}
