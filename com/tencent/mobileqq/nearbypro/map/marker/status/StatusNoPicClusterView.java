package com.tencent.mobileqq.nearbypro.map.marker.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.nearbypro.base.f;
import com.tencent.mobileqq.nearbypro.utils.d;
import com.tencent.mobileqq.nearbypro.utils.i;
import com.tencent.mobileqq.nearbypro.utils.t;
import com.tencent.mobileqq.nearbypro.utils.u;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import hb2.a;
import hb2.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xa2.j;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\u0010B\u001d\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\u001e\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0000H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/marker/status/StatusNoPicClusterView;", "Landroid/widget/FrameLayout;", "Lhb2/a;", "", "e", "", "content", "g", "c", "url", "f", "", TPReportKeys.Common.COMMON_ONLINE, h.F, "Lhb2/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "b", "Lxa2/j;", "d", "Lxa2/j;", "binding", "Lxp4/a;", "Lxp4/a;", "curData", "Lcom/tencent/mobileqq/nearbypro/part/a;", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/nearbypro/part/a;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class StatusNoPicClusterView extends FrameLayout implements a {

    /* renamed from: i, reason: collision with root package name */
    private static final int f253456i = d.b(7);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private j binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private xp4.a curData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.nearbypro.part.a host;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusNoPicClusterView(@NotNull Context context, @Nullable com.tencent.mobileqq.nearbypro.part.a aVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.host = aVar;
        e();
    }

    private final String c(String content) {
        if (content.length() > 6) {
            StringBuffer stringBuffer = new StringBuffer(content);
            stringBuffer.insert(content.offsetByCodePoints(0, (content.codePointCount(0, content.length()) / 2) + 1), "\n");
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "contentBuilder.toString()");
            return stringBuffer2;
        }
        return content;
    }

    private final void e() {
        u uVar = u.f253961a;
        com.tencent.mobileqq.nearbypro.part.a aVar = this.host;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        j e16 = j.e(uVar.a(aVar, context, R.layout.fnt, this, "StatusNoPicClusterView"));
        Intrinsics.checkNotNullExpressionValue(e16, "bind(\n             host.\u2026             )\n         )");
        this.binding = e16;
        if (e16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            e16 = null;
        }
        e16.f447620f.setCornerRadiusAndMode(f253456i, 1);
    }

    private final void f(String url) {
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("StatusNoPicClusterView", "setStatusPic url=" + url);
        }
        Option url2 = Option.obtain().setUrl(url);
        j jVar = this.binding;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            jVar = null;
        }
        Option option = url2.setTargetView(jVar.f447620f).setNeedFilterUrl(false).setFailDrawable(BaseImageUtil.getDefaultFaceDrawable()).setLoadingDrawable(BaseImageUtil.getDefaultFaceDrawable());
        f<Option, IPicLoadStateListener, IPicLoader> f16 = com.tencent.mobileqq.nearbypro.base.j.f();
        Intrinsics.checkNotNullExpressionValue(option, "option");
        f.a.a(f16, option, null, 2, null);
    }

    private final void g(String content) {
        boolean z16;
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("StatusNoPicClusterView", "setStatusTxt content=" + content);
        }
        j jVar = this.binding;
        j jVar2 = null;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            jVar = null;
        }
        jVar.f447622h.setText(c(content));
        j jVar3 = this.binding;
        if (jVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            jVar2 = jVar3;
        }
        TextView textView = jVar2.f447622h;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.statusText");
        if (content.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        t.a(textView, z16);
    }

    @Override // hb2.a
    public void a(@NotNull b item) {
        Intrinsics.checkNotNullParameter(item, "item");
        boolean z16 = true;
        if (!i.h(item.getData(), this.curData)) {
            String str = item.getData().f448299d;
            Intrinsics.checkNotNullExpressionValue(str, "item.data.text");
            g(str);
            if (item.getData().f448302g != 1) {
                z16 = false;
            }
            h(z16);
            String str2 = item.getData().f448300e.f431881d;
            Intrinsics.checkNotNullExpressionValue(str2, "item.data.statusInfo.icon");
            f(str2);
            this.curData = item.getData();
        }
    }

    public final void h(boolean online) {
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("StatusNoPicClusterView", "updateOnlineStatus online=" + online);
        }
        j jVar = this.binding;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            jVar = null;
        }
        ImageView imageView = jVar.f447618d;
        Boolean valueOf = Boolean.valueOf(online);
        imageView.setVisibility(0);
        if (((View) au.a(valueOf, imageView)) == null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusNoPicClusterView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        e();
    }

    @Override // hb2.a
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public StatusNoPicClusterView d() {
        return this;
    }
}
