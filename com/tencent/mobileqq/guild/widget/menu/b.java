package com.tencent.mobileqq.guild.widget.menu;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/menu/b;", "Lcom/tencent/mobileqq/guild/widget/menu/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "b", "view", "", "c", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements c {
    @Override // com.tencent.mobileqq.guild.widget.menu.c
    @Nullable
    public View a(@NotNull ViewGroup parent, @NotNull BaseMenuEntry item) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(item, "item");
        TextView textView = (TextView) parent.findViewById(item.getId());
        if (textView != null) {
            textView.setVisibility(0);
            c(textView, item);
            return textView;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.widget.menu.c
    @NotNull
    public View b(@NotNull ViewGroup parent, @NotNull BaseMenuEntry item) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(item, "item");
        TextView textView = new TextView(parent.getContext());
        textView.setGravity(17);
        textView.setTextSize(16.0f);
        textView.setId(item.getId());
        c(textView, item);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildTvMenuCreator", "[createView]--entry:" + item + "]");
        }
        return textView;
    }

    public void c(@NotNull View view, @NotNull BaseMenuEntry item) {
        BaseMenuEntry baseMenuEntry;
        int color;
        int color2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(item, "item");
        if (!(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        Object tag = textView.getTag();
        if (tag instanceof BaseMenuEntry) {
            baseMenuEntry = (BaseMenuEntry) tag;
        } else {
            baseMenuEntry = null;
        }
        if (Intrinsics.areEqual(baseMenuEntry, item)) {
            return;
        }
        textView.setLayoutParams(new LinearLayout.LayoutParams(item.getWidth(), item.getHeight()));
        Integer textColor = item.getTextColor();
        if (textColor != null) {
            color = textColor.intValue();
        } else {
            color = textView.getContext().getColor(item.getTextColorId());
        }
        textView.setTextColor(color);
        Integer bgColor = item.getBgColor();
        if (bgColor != null) {
            color2 = bgColor.intValue();
        } else {
            color2 = textView.getContext().getColor(item.getBackgroundId());
        }
        textView.setBackgroundColor(color2);
        if (item.getText() != null) {
            textView.setText(item.getText());
        } else {
            textView.setText(item.getTextId());
        }
        textView.setTag(item);
    }
}
