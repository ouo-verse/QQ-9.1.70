package com.tencent.mobileqq.search.searchdetail.content.view;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.search.searchdetail.multimedia.o;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import hp2.ag;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn2.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0014\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchGuildGuildFeedItemLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "z0", "", "title", "B0", "text", "A0", "content", "setTitleAndContent", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "icon", "setAuthAvatarInfo", "", "", "picList", "setPicList", "Lhp2/ag;", "d", "Lhp2/ag;", "getBinding", "()Lhp2/ag;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QSearchGuildGuildFeedItemLayout extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ag binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QSearchGuildGuildFeedItemLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A0(CharSequence text) {
        if (text instanceof Spannable) {
            j jVar = j.f431768a;
            TextView textView = this.binding.f405567h;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvContent");
            jVar.s(textView, (Spannable) text);
            return;
        }
        this.binding.f405567h.setText(text);
    }

    private final void B0(CharSequence title) {
        this.binding.f405568i.setVisibility(0);
        this.binding.f405567h.setMaxLines(1);
        this.binding.f405567h.setEllipsize(TextUtils.TruncateAt.END);
        this.binding.f405568i.setText(title);
    }

    private final void z0() {
        this.binding.f405568i.setVisibility(8);
        this.binding.f405567h.setMaxLines(2);
        this.binding.f405567h.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void setAuthAvatarInfo(@NotNull SearchIcon icon) {
        boolean z16;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(icon, "icon");
        ag agVar = this.binding;
        String str = icon.iconLink;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            ab.d(agVar.f405563d.s(), ViewUtils.dpToPx(5.0f));
            String uin = icon.uin;
            if (uin != null) {
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
                if (longOrNull != null) {
                    agVar.f405563d.w(1, String.valueOf(longOrNull.longValue()));
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            ab.d(agVar.f405563d.s(), ViewUtils.dpToPx(12.0f));
            o oVar = o.f284545a;
            ImageView s16 = agVar.f405563d.s();
            String str2 = icon.iconLink;
            Intrinsics.checkNotNullExpressionValue(str2, "icon.iconLink");
            o.g(oVar, "QSearchGuildGuildFeedItemLayout", s16, str2, null, 8, null);
        }
        agVar.f405566g.setText(icon.title.text);
        TextView textView = agVar.f405561b;
        o oVar2 = o.f284545a;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = icon.timestamp * 1000;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(oVar2.b(currentTimeMillis, j3, context));
    }

    public final void setPicList(@NotNull List<String> picList) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(picList, "picList");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) picList);
        String str = (String) firstOrNull;
        if (str == null) {
            this.binding.f405564e.setVisibility(8);
            this.binding.f405562c.setVisibility(8);
            return;
        }
        ag agVar = this.binding;
        agVar.f405564e.setVisibility(0);
        if (picList.size() > 1) {
            agVar.f405562c.setVisibility(0);
        } else {
            agVar.f405562c.setVisibility(8);
        }
        o oVar = o.f284545a;
        ImageView ivThumbnail = agVar.f405564e;
        Intrinsics.checkNotNullExpressionValue(ivThumbnail, "ivThumbnail");
        o.g(oVar, "QSearchGuildGuildFeedItemLayout", ivThumbnail, str, null, 8, null);
    }

    public final void setTitleAndContent(@NotNull CharSequence title, @NotNull CharSequence content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        if (title.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            z0();
        } else {
            B0(title);
        }
        A0(content);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QSearchGuildGuildFeedItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QSearchGuildGuildFeedItemLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QSearchGuildGuildFeedItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ag f16 = ag.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        ImageView ivThumbnail = f16.f405564e;
        Intrinsics.checkNotNullExpressionValue(ivThumbnail, "ivThumbnail");
        ab.d(ivThumbnail, ViewUtils.dpToPx(4.0f));
        View grayPlaceHolder = f16.f405562c;
        Intrinsics.checkNotNullExpressionValue(grayPlaceHolder, "grayPlaceHolder");
        ab.d(grayPlaceHolder, ViewUtils.dpToPx(4.0f));
        this.binding = f16;
    }
}
