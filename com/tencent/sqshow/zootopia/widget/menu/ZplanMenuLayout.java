package com.tencent.sqshow.zootopia.widget.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u000b\u0010\u0012J\"\u0010\b\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/menu/ZplanMenuLayout;", "Landroid/widget/LinearLayout;", "", "Lcom/tencent/sqshow/zootopia/widget/menu/b;", "menuList", "Lkotlin/Function0;", "", "dissmissHandler", "b", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanMenuLayout extends LinearLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZplanMenuLayout(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ZplanMenuDataItem item, Function0 dissmissHandler, View it) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(dissmissHandler, "$dissmissHandler");
        a actionHandler = item.getActionHandler();
        int id5 = item.getId();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        actionHandler.a(id5, it);
        dissmissHandler.invoke();
    }

    public final void b(List<ZplanMenuDataItem> menuList, final Function0<Unit> dissmissHandler) {
        Intrinsics.checkNotNullParameter(menuList, "menuList");
        Intrinsics.checkNotNullParameter(dissmissHandler, "dissmissHandler");
        for (final ZplanMenuDataItem zplanMenuDataItem : menuList) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.widget.menu.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZplanMenuLayout.c(ZplanMenuDataItem.this, dissmissHandler, view);
                }
            });
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(zplanMenuDataItem.getIconResId());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.a(16.5f), i.a(16.5f));
            layoutParams.gravity = 17;
            layoutParams.topMargin = i.a(12.75f);
            linearLayout.addView(imageView, layoutParams);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = new ZplanExcludeFontPaddingTextView(context);
            if (zplanMenuDataItem.getTextStrId() > 0) {
                zplanExcludeFontPaddingTextView.setText(zplanMenuDataItem.getTextStrId());
            } else {
                String textTitle = zplanMenuDataItem.getTextTitle();
                if (textTitle == null) {
                    textTitle = "";
                }
                zplanExcludeFontPaddingTextView.setText(textTitle);
            }
            zplanExcludeFontPaddingTextView.setGravity(17);
            zplanExcludeFontPaddingTextView.setTextColor(-1);
            zplanExcludeFontPaddingTextView.setTextSize(1, 12.0f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            layoutParams2.topMargin = i.b(6);
            linearLayout.addView(zplanExcludeFontPaddingTextView, layoutParams2);
            addView(linearLayout, new LinearLayout.LayoutParams(i.b(62), i.b(62)));
            zplanMenuDataItem.getActionHandler().b(zplanMenuDataItem.getId(), linearLayout);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZplanMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanMenuLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
    }
}
