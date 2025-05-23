package com.tencent.timi.game.emo.ui.panel.sys;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.emo.ui.panel.sys.EmoPicView;
import dh4.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002BA\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b&\u0010'J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u0017\u0010\u000e\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/timi/game/emo/ui/panel/sys/EmoPicView;", "Landroid/widget/LinearLayout;", "Ldh4/b;", "", "position", "", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "totalDataList", "", "a", "d", "I", "getColumnNum", "()I", "columnNum", "Lxg4/m;", "e", "Lxg4/m;", "getPanelCreateParam", "()Lxg4/m;", "panelCreateParam", "Lxg4/a;", "f", "Lxg4/a;", "getPanelItemData", "()Lxg4/a;", "panelItemData", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/emoticonview/EmoticonImageView;", "Lkotlin/collections/ArrayList;", h.F, "Ljava/util/ArrayList;", "viewList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILxg4/m;Lxg4/a;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class EmoPicView extends LinearLayout implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int columnNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m panelCreateParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a panelItemData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<EmoticonImageView> viewList;

    public /* synthetic */ EmoPicView(Context context, AttributeSet attributeSet, int i3, int i16, m mVar, a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 1 : i16, mVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EmoPicView this$0, SystemAndEmojiEmoticonInfo data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        n callback = this$0.panelCreateParam.getCallback();
        if (callback != null) {
            callback.o2(new k(this$0.panelItemData, data));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // dh4.b
    public void a(int position, @NotNull List<? extends SystemAndEmojiEmoticonInfo> totalDataList) {
        Intrinsics.checkNotNullParameter(totalDataList, "totalDataList");
        int i3 = this.columnNum;
        int i16 = position * i3;
        int i17 = (i3 + i16) - 1;
        int size = totalDataList.size();
        if (i16 > i17) {
            return;
        }
        while (true) {
            int i18 = i16 % this.columnNum;
            this.viewList.get(i18).setOnClickListener(null);
            if (i16 >= size) {
                this.viewList.get(i18).setVisibility(8);
            } else {
                final SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = totalDataList.get(i16);
                if (systemAndEmojiEmoticonInfo.code == -1) {
                    this.viewList.get(i18).setVisibility(8);
                } else {
                    this.viewList.get(i18).setVisibility(0);
                    Drawable drawable = systemAndEmojiEmoticonInfo.getDrawable(false);
                    Intrinsics.checkNotNullExpressionValue(drawable, "data.getDrawable(false)");
                    this.viewList.get(i18).setImageDrawable(drawable);
                    this.viewList.get(i18).setOnClickListener(new View.OnClickListener() { // from class: dh4.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            EmoPicView.c(EmoPicView.this, systemAndEmojiEmoticonInfo, view);
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
    public EmoPicView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16, @NotNull m panelCreateParam, @NotNull a panelItemData) {
        super(context, attributeSet, i3);
        int i17;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(panelCreateParam, "panelCreateParam");
        Intrinsics.checkNotNullParameter(panelItemData, "panelItemData");
        this.columnNum = i16;
        this.panelCreateParam = panelCreateParam;
        this.panelItemData = panelItemData;
        this.viewList = new ArrayList<>();
        int a16 = com.tencent.timi.game.utils.b.a(30);
        int appScreenWidth = ((ScreenUtils.getAppScreenWidth() - (com.tencent.timi.game.utils.b.a(18) * 2)) - (a16 * i16)) / (i16 - 1);
        setOrientation(0);
        int i18 = 0;
        while (i18 < i16) {
            EmoticonImageView emoticonImageView = new EmoticonImageView(context);
            int a17 = com.tencent.timi.game.utils.b.a(30) + com.tencent.timi.game.utils.b.a(12);
            if (i18 == 0) {
                i17 = com.tencent.timi.game.utils.b.a(9);
            } else {
                i17 = appScreenWidth / 2;
            }
            int i19 = (appScreenWidth / 2) + (appScreenWidth % 2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a16 + i17 + i19, a17);
            emoticonImageView.setPadding(i17, 0, i19, 0);
            layoutParams.leftMargin = i18 == 0 ? com.tencent.timi.game.utils.b.a(9) : 0;
            addView(emoticonImageView, layoutParams);
            emoticonImageView.setVisibility(8);
            emoticonImageView.setScaleType(ImageView.ScaleType.FIT_START);
            emoticonImageView.setAdjustViewBounds(false);
            this.viewList.add(emoticonImageView);
            i18++;
        }
    }
}
