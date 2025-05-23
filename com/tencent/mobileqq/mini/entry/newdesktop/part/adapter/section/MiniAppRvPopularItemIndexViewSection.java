package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.TagInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0014J*\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppRvPopularItemIndexViewSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "mIndexImgView", "Landroid/widget/ImageView;", "mIndexTxtView", "Landroid/widget/TextView;", "mSubTextView", "getViewStubLayoutId", "", "onBindData", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "position", "", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvPopularItemIndexViewSection extends AbsMiniAppRvItemSection {
    private static final String TAG = "MiniAppRvPopularItemIndexViewSection";
    private ImageView mIndexImgView;
    private TextView mIndexTxtView;
    private TextView mSubTextView;

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
        Drawable drawable;
        if (!(data instanceof DesktopAppInfo)) {
            QLog.i(TAG, 1, "onBindData data is not DesktopAppInfo!");
            return;
        }
        Resources resources = BaseApplication.getContext().getResources();
        TextView textView = null;
        if (position == 0) {
            drawable = ResourcesCompat.getDrawable(resources, R.drawable.mf_, null);
        } else if (position != 1) {
            drawable = position != 2 ? null : ResourcesCompat.getDrawable(resources, R.drawable.mfb, null);
        } else {
            drawable = ResourcesCompat.getDrawable(resources, R.drawable.mfa, null);
        }
        if (position != 0 && position != 1 && position != 2) {
            ImageView imageView = this.mIndexImgView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIndexImgView");
                imageView = null;
            }
            imageView.setVisibility(8);
            TextView textView2 = this.mIndexTxtView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIndexTxtView");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.mIndexTxtView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIndexTxtView");
                textView3 = null;
            }
            textView3.setText(String.valueOf(position + 1));
        } else {
            TextView textView4 = this.mIndexTxtView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIndexTxtView");
                textView4 = null;
            }
            textView4.setVisibility(8);
            ImageView imageView2 = this.mIndexImgView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIndexImgView");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            ImageView imageView3 = this.mIndexImgView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIndexImgView");
                imageView3 = null;
            }
            imageView3.setImageDrawable(drawable);
        }
        DesktopAppInfo desktopAppInfo = (DesktopAppInfo) data;
        MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
        if (miniAppInfo != null) {
            TagInfo tagInfo = miniAppInfo.tagInfo;
            if (tagInfo != null && !TextUtils.isEmpty(tagInfo.tagText)) {
                TextView textView5 = this.mSubTextView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSubTextView");
                } else {
                    textView = textView5;
                }
                textView.setText(desktopAppInfo.mMiniAppInfo.tagInfo.tagText);
                return;
            }
            TextView textView6 = this.mSubTextView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubTextView");
            } else {
                textView = textView6;
            }
            textView.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.rjo);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.miniapp_items_index_txt_view)");
            this.mIndexTxtView = (TextView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.rgf);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.mini_app_index_pic_view)");
            this.mIndexImgView = (ImageView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.rjp);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.miniapp_items_sub_text)");
            this.mSubTextView = (TextView) findViewById3;
        }
    }
}
