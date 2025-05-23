package com.tencent.mobileqq.search.searchdetail.content.view;

import android.content.Context;
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
import hp2.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn2.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchGuildGuildTitleLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "", "setTitle", "businessTitle", "setBusinessTitle", "url", "setBadge", "A0", "tag", "Lkotlin/Function1;", "Landroid/view/View;", "callback", "B0", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "icon", "setMainIcon", "Lhp2/z;", "d", "Lhp2/z;", "z0", "()Lhp2/z;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QSearchGuildGuildTitleLayout extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final z binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QSearchGuildGuildTitleLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void A0() {
        this.binding.f405797i.setVisibility(8);
    }

    public final void B0(@NotNull String tag, @NotNull final Function1<? super View, Unit> callback) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(callback, "callback");
        j jVar = j.f431768a;
        TextView textView = this.binding.f405790b;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.btnJoin");
        j.u(jVar, textView, tag, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchGuildGuildTitleLayout$rightButtonClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.invoke(it);
            }
        }, 2, null);
    }

    public final void setBadge(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        z zVar = this.binding;
        zVar.f405797i.setVisibility(0);
        j jVar = j.f431768a;
        ImageView vBadge = zVar.f405797i;
        Intrinsics.checkNotNullExpressionValue(vBadge, "vBadge");
        jVar.n(vBadge, url, ViewUtils.dip2px(12.0f));
    }

    public final void setBusinessTitle(@NotNull String businessTitle) {
        Intrinsics.checkNotNullParameter(businessTitle, "businessTitle");
        this.binding.f405796h.setText(businessTitle);
    }

    public final void setMainIcon(@NotNull SearchIcon icon) {
        boolean z16;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(icon, "icon");
        z zVar = this.binding;
        String str = icon.iconLink;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            ab.d(zVar.f405791c.s(), ViewUtils.dpToPx(5.0f));
            String uin = icon.uin;
            if (uin != null) {
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
                if (longOrNull != null) {
                    zVar.f405791c.w(1, String.valueOf(longOrNull.longValue()));
                    return;
                }
                return;
            }
            return;
        }
        int i3 = icon.iconType;
        if (i3 != 1) {
            if (i3 == 2) {
                ab.d(zVar.f405791c.s(), ViewUtils.dpToPx(5.0f));
            }
        } else {
            ab.d(zVar.f405791c.s(), ViewUtils.dpToPx(19.0f));
        }
        o oVar = o.f284545a;
        ImageView s16 = zVar.f405791c.s();
        String str2 = icon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str2, "icon.iconLink");
        o.g(oVar, "QSearchGuildGuildTitleL", s16, str2, null, 8, null);
    }

    public final void setTitle(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.binding.f405793e.setText(title);
    }

    @NotNull
    /* renamed from: z0, reason: from getter */
    public final z getBinding() {
        return this.binding;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QSearchGuildGuildTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QSearchGuildGuildTitleLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QSearchGuildGuildTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        z f16 = z.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
    }
}
