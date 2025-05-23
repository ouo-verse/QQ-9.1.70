package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.TagInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.ui.MiniAppExpDesktopRankTags;
import com.tencent.mobileqq.mini.entry.expDesktop.ui.MiniAppTagInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.AbsMiniAppRvItemSection;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.utils.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0003J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J*\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppRvRankItemIndexAndTagViewSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopRankTags$OnCurrentTagClickListener;", "()V", "mIndexTxtView", "Landroid/widget/TextView;", "mTagContainer", "Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopRankTags;", "getViewStubLayoutId", "", "onBindData", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "position", "", "payload", "", "", "onCurrentTagClick", "", "view", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "onInitView", "containerView", "Landroid/view/View;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvRankItemIndexAndTagViewSection extends AbsMiniAppRvItemSection implements MiniAppExpDesktopRankTags.OnCurrentTagClickListener {
    private static final int ELDER_MODE_TAG_MAX_ACCOUNT = 2;
    private static final String TAG = "MiniAppRvPopularItemIndexViewSection";
    private TextView mIndexTxtView;
    private MiniAppExpDesktopRankTags mTagContainer;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(DesktopItemInfo desktopItemInfo, int i3, List list) {
        onBindData2(desktopItemInfo, i3, (List<Object>) list);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.ui.MiniAppExpDesktopRankTags.OnCurrentTagClickListener
    public boolean onCurrentTagClick(int position, QUITagView view) {
        return false;
    }

    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(DesktopItemInfo data, int position, List<Object> payload) {
        ArrayList n3;
        int collectionSizeOrDefault;
        if (!(data instanceof DesktopAppInfo)) {
            QLog.i(TAG, 1, "onBindData data is not DesktopAppInfo!");
            return;
        }
        TextView textView = this.mIndexTxtView;
        MiniAppExpDesktopRankTags miniAppExpDesktopRankTags = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndexTxtView");
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView2 = this.mIndexTxtView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndexTxtView");
            textView2 = null;
        }
        textView2.setText(String.valueOf(position + 1));
        DesktopAppInfo desktopAppInfo = (DesktopAppInfo) data;
        MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
        ArrayList<TagInfo> arrayList = miniAppInfo != null ? miniAppInfo.tagList : null;
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size();
        if (SimpleUIUtil.isNowElderMode() && size > 2) {
            bg bgVar = bg.f302144a;
            MiniAppInfo miniAppInfo2 = desktopAppInfo.mMiniAppInfo;
            ArrayList<TagInfo> arrayList2 = miniAppInfo2 != null ? miniAppInfo2.tagList : null;
            Intrinsics.checkNotNull(arrayList2);
            List<TagInfo> subList = arrayList2.subList(0, 2);
            Intrinsics.checkNotNullExpressionValue(subList, "data.mMiniAppInfo?.tagLi\u2026DER_MODE_TAG_MAX_ACCOUNT)");
            n3 = bgVar.n(subList);
        } else {
            bg bgVar2 = bg.f302144a;
            MiniAppInfo miniAppInfo3 = desktopAppInfo.mMiniAppInfo;
            ArrayList<TagInfo> arrayList3 = miniAppInfo3 != null ? miniAppInfo3.tagList : null;
            Intrinsics.checkNotNull(arrayList3);
            n3 = bgVar2.n(arrayList3);
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(n3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        Iterator it = n3.iterator();
        while (it.hasNext()) {
            String str = ((TagInfo) it.next()).tagText;
            Intrinsics.checkNotNullExpressionValue(str, "it.tagText");
            arrayList4.add(new MiniAppTagInfo(str, null, QUITagType.FILL));
        }
        Object[] array = arrayList4.toArray(new MiniAppTagInfo[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        MiniAppTagInfo[] miniAppTagInfoArr = (MiniAppTagInfo[]) array;
        MiniAppExpDesktopRankTags miniAppExpDesktopRankTags2 = this.mTagContainer;
        if (miniAppExpDesktopRankTags2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTagContainer");
        } else {
            miniAppExpDesktopRankTags = miniAppExpDesktopRankTags2;
        }
        miniAppExpDesktopRankTags.setTagArray(miniAppTagInfoArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.rjo);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.miniapp_items_index_txt_view)");
            this.mIndexTxtView = (TextView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.rge);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.mini_a\u2026_recommend_tag_container)");
            MiniAppExpDesktopRankTags miniAppExpDesktopRankTags = (MiniAppExpDesktopRankTags) findViewById2;
            this.mTagContainer = miniAppExpDesktopRankTags;
            MiniAppExpDesktopRankTags miniAppExpDesktopRankTags2 = null;
            if (miniAppExpDesktopRankTags == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTagContainer");
                miniAppExpDesktopRankTags = null;
            }
            miniAppExpDesktopRankTags.setTagSize(QUITagSize.SMALL);
            MiniAppExpDesktopRankTags miniAppExpDesktopRankTags3 = this.mTagContainer;
            if (miniAppExpDesktopRankTags3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTagContainer");
                miniAppExpDesktopRankTags3 = null;
            }
            miniAppExpDesktopRankTags3.setTagMargin(c.f353052a.b(6));
            MiniAppExpDesktopRankTags miniAppExpDesktopRankTags4 = this.mTagContainer;
            if (miniAppExpDesktopRankTags4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTagContainer");
                miniAppExpDesktopRankTags4 = null;
            }
            miniAppExpDesktopRankTags4.setCurrentTagClickListener(this);
            MiniAppExpDesktopRankTags miniAppExpDesktopRankTags5 = this.mTagContainer;
            if (miniAppExpDesktopRankTags5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTagContainer");
            } else {
                miniAppExpDesktopRankTags2 = miniAppExpDesktopRankTags5;
            }
            miniAppExpDesktopRankTags2.setClickable(false);
        }
    }
}
