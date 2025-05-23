package com.tencent.mobileqq.guild.discoveryv2.content.view.specialactivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.token.c;
import com.tencent.mobileqq.guild.discoveryv2.content.view.specialactivity.SpecialActivityCardView;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.t;
import com.tencent.mobileqq.guild.util.w;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.al;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/view/specialactivity/SpecialActivityCardView;", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "Lcom/tencent/mobileqq/guild/util/t;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/specialactivity/SpecialActivityCardView$a;", "activeData", "", "setData", "Lvp1/al;", BdhLogUtil.LogTag.Tag_Conn, "Lvp1/al;", "binding", "D", "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/specialactivity/SpecialActivityCardView$a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SpecialActivityCardView extends RadiusFrameLayout implements t {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private al binding;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private CardData activeData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/view/specialactivity/SpecialActivityCardView$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "coverUrl", "b", "c", "name", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.view.specialactivity.SpecialActivityCardView$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CardData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String coverUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String jumpUrl;

        public CardData(@NotNull String coverUrl, @NotNull String name, @NotNull String jumpUrl) {
            Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            this.coverUrl = coverUrl;
            this.name = name;
            this.jumpUrl = jumpUrl;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getCoverUrl() {
            return this.coverUrl;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CardData)) {
                return false;
            }
            CardData cardData = (CardData) other;
            if (Intrinsics.areEqual(this.coverUrl, cardData.coverUrl) && Intrinsics.areEqual(this.name, cardData.name) && Intrinsics.areEqual(this.jumpUrl, cardData.jumpUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.coverUrl.hashCode() * 31) + this.name.hashCode()) * 31) + this.jumpUrl.hashCode();
        }

        @NotNull
        public String toString() {
            return "CardData(coverUrl=" + this.coverUrl + ", name=" + this.name + ", jumpUrl=" + this.jumpUrl + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpecialActivityCardView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(SpecialActivityCardView this$0, Context context, View view) {
        String str;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (!o.c("fastClickGuard")) {
            CardData cardData = this$0.activeData;
            String str2 = null;
            if (cardData != null) {
                str = cardData.getJumpUrl();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                Activity activity = (Activity) context;
                CardData cardData2 = this$0.activeData;
                if (cardData2 != null) {
                    str2 = cardData2.getJumpUrl();
                }
                GuildJumpUtil.w(activity, str2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setData(@NotNull CardData activeData) {
        Intrinsics.checkNotNullParameter(activeData, "activeData");
        if (Intrinsics.areEqual(this.activeData, activeData)) {
            return;
        }
        this.activeData = activeData;
        this.binding.f442253c.setText(activeData.getName());
        String coverUrl = activeData.getCoverUrl();
        ImageView imageView = this.binding.f442252b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.cover");
        w.c(this, coverUrl, imageView, null, null, null, new ColorDrawable(getResources().getColor(R.color.f157116k8)), null, 92, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpecialActivityCardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SpecialActivityCardView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpecialActivityCardView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        al f16 = al.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setCornerRadius(QQGuildUIUtil.f(12.0f));
        c.e(this, null, 2, null);
        setOnClickListener(new View.OnClickListener() { // from class: ei1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpecialActivityCardView.g(SpecialActivityCardView.this, context, view);
            }
        });
    }
}
