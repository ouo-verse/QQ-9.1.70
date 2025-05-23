package com.tencent.mobileqq.nearbypro.map.marker.personal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.nearbypro.base.f;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import ga2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xa2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\r\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/marker/personal/AreaUserView;", "Landroid/widget/FrameLayout;", "", "a", "", "url", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR, "Lxa2/b;", "d", "Lxa2/b;", "binding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "e", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class AreaUserView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AreaUserView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a();
    }

    private final void a() {
        b g16 = b.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
    }

    public final void setAvatar(@Nullable String url) {
        a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaUserView", "setAvatar url=" + url);
        }
        Option url2 = Option.obtain().setUrl(url);
        b bVar = this.binding;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        Option option = url2.setTargetView(bVar.f447570b).setNeedFilterUrl(false).setFailDrawable(BaseImageUtil.getDefaultFaceDrawable()).setLoadingDrawable(BaseImageUtil.getDefaultFaceDrawable());
        f<Option, IPicLoadStateListener, IPicLoader> f16 = j.f();
        Intrinsics.checkNotNullExpressionValue(option, "option");
        f.a.a(f16, option, null, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AreaUserView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a();
    }
}
