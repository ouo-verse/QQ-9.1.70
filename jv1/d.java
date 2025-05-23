package jv1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.guild.e;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.adapter.itemdata.h;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.chats.view.widget.GuildSummaryLayout;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006\u001c"}, d2 = {"Ljv1/d;", "Lcom/tencent/qqnt/chats/inject/summary/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/widget/ImageView;", "imageView", "", "d", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e;", "info", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "summaryRedPrefixView", "f", "summaryGrayPrefixView", "c", "summaryCenterView", "e", "Landroid/content/Context;", "context", "", "state", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/view/View;", "view", "a", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends com.tencent.qqnt.chats.inject.summary.a {
    private final Drawable b(Context context, int state) {
        Integer valueOf;
        QLog.i("GuildSummaryProcessor", 1, "getDrawableBySummaryState state: " + state);
        if (state != 0) {
            if (state != 1) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(R.drawable.bwf);
            }
        } else {
            valueOf = Integer.valueOf(R.drawable.bwe);
        }
        if (valueOf == null) {
            return null;
        }
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), valueOf.intValue(), null);
        if (drawable == null) {
            return null;
        }
        int dip2px = ViewUtils.dip2px(16.0f);
        drawable.setBounds(0, 0, dip2px, dip2px);
        return drawable;
    }

    private final void c(g.e info, SingleLineTextView summaryGrayPrefixView) {
        boolean z16;
        Object valueOf;
        Long valueOf2 = Long.valueOf(e.b(info));
        if (valueOf2.longValue() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            valueOf2 = null;
        }
        if (valueOf2 != null) {
            long longValue = valueOf2.longValue();
            if (longValue > 999) {
                valueOf = "999+";
            } else {
                valueOf = Long.valueOf(longValue);
            }
            summaryGrayPrefixView.setText("[" + valueOf + "\u6761]");
            ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            summaryGrayPrefixView.setTextColor(chatsColorCache.g(context).getDefaultColor());
            summaryGrayPrefixView.setVisibility(0);
            return;
        }
        summaryGrayPrefixView.setVisibility(8);
    }

    private final void d(g item, ImageView imageView) {
        Context context = imageView.getContext();
        if (h.a(item)) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildSummaryProcessor", 1, "hasDraft: true, item uid: " + item.k());
            }
            com.tencent.qqnt.chats.utils.c cVar = com.tencent.qqnt.chats.utils.c.f355544a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            imageView.setImageDrawable(cVar.b(context, 4));
            imageView.setVisibility(0);
            return;
        }
        imageView.setVisibility(8);
    }

    private final void e(g item, SingleLineTextView summaryCenterView) {
        int i3;
        Context context = summaryCenterView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "summaryCenterView.context");
        Drawable b16 = b(context, item.s().sendStatus);
        summaryCenterView.setCompoundDrawables(b16, null);
        if (b16 != null) {
            i3 = ViewUtils.dpToPx(2.0f);
        } else {
            i3 = 0;
        }
        summaryCenterView.setCompoundDrawablePadding(i3);
        summaryCenterView.setText(e.a(item.v()));
        ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
        BaseApplication context2 = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        summaryCenterView.setTextColor(chatsColorCache.g(context2).getDefaultColor());
    }

    private final void f(g.e info, SingleLineTextView summaryRedPrefixView) {
        if (TextUtils.isEmpty(info.e())) {
            summaryRedPrefixView.setVisibility(8);
            return;
        }
        summaryRedPrefixView.setVisibility(0);
        summaryRedPrefixView.setText(info.e());
        Integer d16 = info.d();
        if (d16 != null) {
            summaryRedPrefixView.setTextColor(ColorStateList.valueOf(d16.intValue()));
        }
    }

    @Override // com.tencent.qqnt.chats.inject.summary.a
    public void a(@NotNull g item, @NotNull View view) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof GuildSummaryLayout)) {
            return;
        }
        GuildSummaryLayout guildSummaryLayout = (GuildSummaryLayout) view;
        d(item, guildSummaryLayout.c());
        f(item.v(), guildSummaryLayout.e());
        c(item.v(), guildSummaryLayout.b());
        e(item, guildSummaryLayout.d());
    }
}
