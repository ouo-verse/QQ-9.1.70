package com.tencent.kuikly.core.views;

import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b2\u0010*J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J)\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\"\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010!\u001a\u00020\u0000H\u0016J\b\u0010\"\u001a\u00020\u0000H\u0016J\b\u0010#\u001a\u00020\u0000H\u0016J\u0010\u0010%\u001a\u00020\u00012\u0006\u0010%\u001a\u00020$H\u0016J\u001a\u0010(\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030&J\u000f\u0010)\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b)\u0010*R\"\u00101\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00063"}, d2 = {"Lcom/tencent/kuikly/core/views/af;", "Lcom/tencent/kuikly/core/base/Attr;", "Lcom/tencent/kuikly/core/base/attr/b;", "", "src", "", "isDotNineImage", "r", "", "byteArraySrc", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/kuikly/core/base/attr/e;", LayoutAttrDefine.CLICK_URI, "b", "placeholder", DomainData.DOMAIN_NAME, "", "blurRadius", tl.h.F, "Lcom/tencent/kuikly/core/base/h;", "color", "t", "", "colorMatrix", "i", "Lcom/tencent/kuikly/core/base/Direction;", "direction", "", "Lcom/tencent/kuikly/core/base/j;", "colorStops", "l", "(Lcom/tencent/kuikly/core/base/Direction;[Lcom/tencent/kuikly/core/base/j;)Lcom/tencent/kuikly/core/base/attr/b;", "p", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/kuikly/core/base/g;", "boxShadow", "", "httpHeaders", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()V", "a", "Z", "j", "()Z", "setShouldWrapper$core_release", "(Z)V", "shouldWrapper", "<init>", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class af extends Attr implements com.tencent.kuikly.core.base.attr.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean shouldWrapper;

    @Override // com.tencent.kuikly.core.base.attr.b
    public com.tencent.kuikly.core.base.attr.b b(com.tencent.kuikly.core.base.attr.e uri, boolean isDotNineImage) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return e(uri.a(getPager().getPageName()), isDotNineImage);
    }

    public com.tencent.kuikly.core.base.attr.b i(float[] colorMatrix) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(colorMatrix, "colorMatrix");
        if (colorMatrix.length == 20) {
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(colorMatrix, (CharSequence) "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            with(CustomAnimation.KeyPath.COLOR_FILTER, joinToString$default);
            return this;
        }
        PagerNotFoundExceptionKt.a("colorMatrix need 20 float");
        return this;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getShouldWrapper() {
        return this.shouldWrapper;
    }

    public final Attr k(Map<String, String> httpHeaders) {
        Intrinsics.checkNotNullParameter(httpHeaders, "httpHeaders");
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {
            eVar.v(entry.getKey(), entry.getValue());
        }
        with("httpHeaders", eVar.toString());
        return this;
    }

    public final com.tencent.kuikly.core.base.attr.b l(Direction direction, com.tencent.kuikly.core.base.j... colorStops) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(colorStops, "colorStops");
        String str = "linear-gradient(" + direction.ordinal();
        for (com.tencent.kuikly.core.base.j jVar : colorStops) {
            str = str + ',' + jVar;
        }
        with("maskLinearGradient", str + ')');
        return this;
    }

    public af n(String placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        with("placeholder", placeholder);
        this.shouldWrapper = true;
        AbstractBaseView<?, ?> view = view();
        ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
        if (imageView != null) {
            imageView.k();
        }
        return this;
    }

    public af o() {
        with("resize", HVideoConstants.ResizeType.RESIZE_CONTAIN);
        return this;
    }

    public af p() {
        with("resize", "cover");
        return this;
    }

    public af q() {
        with("resize", "stretch");
        return this;
    }

    @Override // com.tencent.kuikly.core.base.attr.b
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public af e(String src, boolean isDotNineImage) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(src, "src");
        if (isDotNineImage) {
            q();
        }
        with("dotNineImage", Integer.valueOf(com.tencent.kuikly.core.base.d.b(isDotNineImage)));
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(src, "data:image", false, 2, null);
        if (startsWith$default) {
            String b16 = ag.f118358a.b(src);
            if (getPager().getValueForKey(b16) == null) {
                getPager().setMemoryCache(b16, src);
            }
            with("src", b16);
        } else {
            with("src", src);
        }
        return this;
    }

    public final void s(byte[] byteArraySrc) {
        Intrinsics.checkNotNullParameter(byteArraySrc, "byteArraySrc");
        String a16 = ag.f118358a.a(byteArraySrc);
        if (getPager().getValueForKey(a16) == null) {
            getPager().setMemoryCache(a16, byteArraySrc);
        }
        with("src", a16);
    }

    public com.tencent.kuikly.core.base.attr.b t(com.tencent.kuikly.core.base.h color) {
        if (color == null) {
            with("tintColor", "");
        } else {
            with("tintColor", color.toString());
        }
        return this;
    }

    @Override // com.tencent.kuikly.core.base.Attr
    /* renamed from: boxShadow */
    public Attr mo139boxShadow(com.tencent.kuikly.core.base.g boxShadow) {
        Intrinsics.checkNotNullParameter(boxShadow, "boxShadow");
        this.shouldWrapper = true;
        return super.mo139boxShadow(boxShadow);
    }

    public com.tencent.kuikly.core.base.attr.b h(float blurRadius) {
        with("blurRadius", Float.valueOf(Math.min(Math.max(0.0f, blurRadius), 12.5f)));
        return this;
    }

    public final void m() {
        with("needLoadFailure", 1);
    }
}
