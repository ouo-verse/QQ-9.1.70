package com.tencent.timi.game.emo.ui.panel.hot;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ch4.j;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.emo.data.HotPicEmoInfo;
import com.tencent.timi.game.emo.ui.panel.hot.SearchAndHotPicItemView;
import com.tencent.timi.game.utils.l;
import fh4.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xg4.a;
import xg4.k;
import xg4.m;
import xg4.n;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001\tBA\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b(\u0010)J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u0017\u0010\u000e\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000bR$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006+"}, d2 = {"Lcom/tencent/timi/game/emo/ui/panel/hot/SearchAndHotPicItemView;", "Landroid/widget/LinearLayout;", "Lch4/j;", "", "position", "", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "totalDataList", "", "a", "d", "I", "getColumnNum", "()I", "columnNum", "Lxg4/m;", "e", "Lxg4/m;", "getParam", "()Lxg4/m;", "param", "Lxg4/a;", "f", "Lxg4/a;", "getPanelItemData", "()Lxg4/a;", "panelItemData", h.F, "mItemSize", "Ljava/util/ArrayList;", "Lcom/tencent/image/URLImageView;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "viewList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILxg4/m;Lxg4/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class SearchAndHotPicItemView extends LinearLayout implements j {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int columnNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m param;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a panelItemData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mItemSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<URLImageView> viewList;
    private static final int C = b.b(2);

    public /* synthetic */ SearchAndHotPicItemView(Context context, AttributeSet attributeSet, int i3, int i16, m mVar, a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 1 : i16, mVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SearchAndHotPicItemView this$0, HotPicEmoInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        n callback = this$0.param.getCallback();
        if (callback != null) {
            callback.o2(new k(this$0.panelItemData, info));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // ch4.j
    public void a(int position, @NotNull List<? extends EmotionSearchItem> totalDataList) {
        Intrinsics.checkNotNullParameter(totalDataList, "totalDataList");
        int i3 = this.columnNum;
        int i16 = position * i3;
        int i17 = (i3 + i16) - 1;
        if (i16 > i17) {
            return;
        }
        while (true) {
            int i18 = i16 % this.columnNum;
            if (i16 >= totalDataList.size()) {
                this.viewList.get(i18).setVisibility(8);
            } else {
                boolean z16 = false;
                this.viewList.get(i18).setVisibility(0);
                EmotionSearchItem emotionSearchItem = totalDataList.get(i16);
                this.viewList.get(i18).setOnClickListener(null);
                String emoURL = emotionSearchItem.getEmoURL();
                if (emoURL == null) {
                    emoURL = "";
                }
                if (emoURL.length() == 0) {
                    z16 = true;
                }
                if (z16) {
                    this.viewList.get(i18).setVisibility(8);
                    l.e("SearchAndHotPicItemView_", "pos:" + position + " data:" + emotionSearchItem + " url is empty, can not show");
                } else {
                    URLImageView uRLImageView = this.viewList.get(i18);
                    Intrinsics.checkNotNullExpressionValue(uRLImageView, "viewList[viewIndex]");
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = new ColorDrawable(16052712);
                    obtain.mFailedDrawable = new ColorDrawable(16052712);
                    obtain.mPlayGifImage = true;
                    Unit unit = Unit.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026rue\n                    }");
                    com.tencent.timi.game.utils.b.g(uRLImageView, emoURL, obtain);
                    final HotPicEmoInfo hotPicEmoInfo = new HotPicEmoInfo();
                    hotPicEmoInfo.a(emoURL);
                    this.viewList.get(i18).setOnClickListener(new View.OnClickListener() { // from class: ch4.l
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SearchAndHotPicItemView.c(SearchAndHotPicItemView.this, hotPicEmoInfo, view);
                        }
                    });
                }
            }
            if (i16 != i17) {
                i16++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchAndHotPicItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16, @NotNull m param, @NotNull a panelItemData) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(panelItemData, "panelItemData");
        this.columnNum = i16;
        this.param = param;
        this.panelItemData = panelItemData;
        this.viewList = new ArrayList<>();
        setOrientation(0);
        this.mItemSize = (ScreenUtils.getAppScreenWidth() - (C * (i16 - 1))) / i16;
        int i17 = 0;
        while (i17 < i16) {
            int i18 = this.mItemSize;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i18, i18);
            layoutParams.leftMargin = i17 == 0 ? 0 : C / 2;
            layoutParams.rightMargin = i17 == this.columnNum + (-1) ? 0 : C / 2;
            URLImageView uRLImageView = new URLImageView(context);
            uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            uRLImageView.setAdjustViewBounds(false);
            this.viewList.add(uRLImageView);
            addView(uRLImageView, layoutParams);
            i17++;
        }
        setPadding(0, C, 0, 0);
    }
}
