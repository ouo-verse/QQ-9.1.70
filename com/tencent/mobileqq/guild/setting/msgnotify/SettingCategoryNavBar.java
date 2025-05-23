package com.tencent.mobileqq.guild.setting.msgnotify;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.c;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0003B\u0013\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019B\u001d\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u0018\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014R$\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/msgnotify/SettingCategoryNavBar;", "Landroid/widget/LinearLayout;", "", "a", "onFinishInflate", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "navBarList", "e", "Landroid/view/View;", "lineView", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", h.F, "I", "navBarTopPosX", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SettingCategoryNavBar extends LinearLayout {

    /* renamed from: m, reason: collision with root package name */
    private static int f234780m = c.b(38);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<View> navBarList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View lineView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int navBarTopPosX;

    public SettingCategoryNavBar(@Nullable Context context) {
        super(context);
        this.navBarList = new ArrayList<>();
        this.navBarTopPosX = -1;
    }

    private final void a() {
        View findViewById = findViewById(R.id.dpq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.item_container)");
        this.container = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.f87464uf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.split)");
        this.lineView = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lineView");
            findViewById2 = null;
        }
        findViewById2.setVisibility(8);
        setClickable(false);
        setOrientation(1);
        setBackgroundResource(R.drawable.b8c);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public SettingCategoryNavBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.navBarList = new ArrayList<>();
        this.navBarTopPosX = -1;
    }
}
