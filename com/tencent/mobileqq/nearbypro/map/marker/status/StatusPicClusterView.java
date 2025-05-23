package com.tencent.mobileqq.nearbypro.map.marker.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.utils.PicLoadUtilsKt;
import com.tencent.mobileqq.nearbypro.utils.d;
import com.tencent.mobileqq.nearbypro.utils.q;
import com.tencent.mobileqq.nearbypro.utils.t;
import com.tencent.mobileqq.nearbypro.utils.u;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import hb2.a;
import hb2.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op4.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xa2.i;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001\u0010B\u001d\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\u001e\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0000H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/marker/status/StatusPicClusterView;", "Landroid/widget/FrameLayout;", "Lhb2/a;", "", "c", "", "content", "f", "Lop4/g;", "stImage", "e", "", TPReportKeys.Common.COMMON_ONLINE, "g", "Lhb2/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "b", "Lxa2/i;", "d", "Lxa2/i;", "binding", "Lxp4/a;", "Lxp4/a;", "curData", "Lcom/tencent/mobileqq/nearbypro/part/a;", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/nearbypro/part/a;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class StatusPicClusterView extends FrameLayout implements a {

    /* renamed from: i, reason: collision with root package name */
    private static int f253461i = d.b(80);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private i binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private xp4.a curData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.nearbypro.part.a host;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusPicClusterView(@NotNull Context context, @Nullable com.tencent.mobileqq.nearbypro.part.a aVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.host = aVar;
        c();
    }

    private final void c() {
        u uVar = u.f253961a;
        com.tencent.mobileqq.nearbypro.part.a aVar = this.host;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        i e16 = i.e(uVar.a(aVar, context, R.layout.fnp, this, "StatusPicClusterView"));
        Intrinsics.checkNotNullExpressionValue(e16, "bind(root)");
        this.binding = e16;
        if (e16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            e16 = null;
        }
        RoundRectImageView roundRectImageView = e16.f447611f;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        roundRectImageView.setCornerRadiusAndMode(d.c(7, context2), 1);
    }

    private final void e(g stImage) {
        Option opt = Option.obtain();
        opt.setRequestHeight(f253461i);
        opt.setRequestWidth(f253461i);
        i iVar = this.binding;
        i iVar2 = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            iVar = null;
        }
        opt.setTargetView(iVar.f447611f);
        opt.setLoadingDrawable(PicLoadUtilsKt.b());
        opt.setFailedDrawable(PicLoadUtilsKt.a());
        opt.setAnimatable(null);
        i iVar3 = this.binding;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            iVar2 = iVar3;
        }
        RoundRectImageView roundRectImageView = iVar2.f447611f;
        Intrinsics.checkNotNullExpressionValue(roundRectImageView, "binding.statusImg");
        Intrinsics.checkNotNullExpressionValue(opt, "opt");
        q.e(stImage, roundRectImageView, opt, null, 8, null);
    }

    private final void f(String content) {
        boolean z16;
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("StatusPicClusterView", "setStatusTxt content=" + content);
        }
        i iVar = this.binding;
        i iVar2 = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            iVar = null;
        }
        iVar.f447612g.setText(content);
        i iVar3 = this.binding;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            iVar3 = null;
        }
        TextView textView = iVar3.f447612g;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.statusText");
        boolean z17 = true;
        if (content.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        t.a(textView, z16);
        i iVar4 = this.binding;
        if (iVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            iVar2 = iVar4;
        }
        ImageView imageView = iVar2.f447613h;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.textMasker");
        if (content.length() <= 0) {
            z17 = false;
        }
        t.a(imageView, z17);
    }

    @Override // hb2.a
    public void a(@NotNull b item) {
        Intrinsics.checkNotNullParameter(item, "item");
        boolean z16 = true;
        if (!com.tencent.mobileqq.nearbypro.utils.i.h(item.getData(), this.curData)) {
            g gVar = item.getData().f448301f;
            Intrinsics.checkNotNullExpressionValue(gVar, "item.data.image");
            e(gVar);
            String str = item.getData().f448299d;
            Intrinsics.checkNotNullExpressionValue(str, "item.data.text");
            f(str);
            if (item.getData().f448302g != 1) {
                z16 = false;
            }
            g(z16);
            this.curData = item.getData();
        }
    }

    public final void g(boolean online) {
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("StatusPicClusterView", "updateOnlineStatus online=" + online);
        }
        i iVar = this.binding;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            iVar = null;
        }
        ImageView imageView = iVar.f447610e;
        Boolean valueOf = Boolean.valueOf(online);
        imageView.setVisibility(0);
        if (((View) au.a(valueOf, imageView)) == null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusPicClusterView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        c();
    }

    @Override // hb2.a
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public StatusPicClusterView d() {
        return this;
    }
}
