package com.tencent.mobileqq.guild.discovery.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/BannerIndicator;", "Landroid/widget/LinearLayout;", "", "d", "I", "getSize", "()I", "setSize", "(I)V", "size", "e", "indicatorSize", "f", "indicatorMargin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class BannerIndicator extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int size;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int indicatorSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int indicatorMargin;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerIndicator(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setSize(int i3) {
        this.size = i3;
    }

    public /* synthetic */ BannerIndicator(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        kotlin.g gVar = kotlin.g.f433789a;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.indicatorSize = gVar.b(5.0f, resources);
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        this.indicatorMargin = gVar.b(3.0f, resources2);
        setOrientation(0);
        setGravity(1);
    }
}
