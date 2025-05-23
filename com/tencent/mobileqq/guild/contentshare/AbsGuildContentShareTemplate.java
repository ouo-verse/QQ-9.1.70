package com.tencent.mobileqq.guild.contentshare;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.util.VasColorUtil;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\u0011\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H&J \u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u0002H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u0006\u0010\u0012\u001a\u00020\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0011J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0004J\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0004J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016R\u0014\u0010#\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R#\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/AbsGuildContentShareTemplate;", "Lcom/tencent/mobileqq/guild/contentshare/f;", "", DomainData.DOMAIN_NAME, "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/guild/contentshare/g;", "d", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/contentshare/d;", "shareData", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "j", "e", "Landroid/view/ViewGroup;", "k", "", "i", "f", "()Ljava/lang/Integer;", "type", "g", "Landroid/widget/ImageView;", "imageView", "", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "view", "", "radius", "l", "b", "a", "I", WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE, "Lkotlin/Lazy;", tl.h.F, "()Landroid/util/SparseArray;", "componentList", "", "c", "Z", "isBgReady", "needUpdateContentMaskLayout", "<init>", "(I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class AbsGuildContentShareTemplate implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int templateType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy componentList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isBgReady;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needUpdateContentMaskLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/contentshare/AbsGuildContentShareTemplate$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f216299a;

        a(float f16) {
            this.f216299a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (outline == null || view == null) {
                return;
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f216299a);
        }
    }

    public AbsGuildContentShareTemplate(int i3) {
        Lazy lazy;
        this.templateType = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SparseArray<g>>() { // from class: com.tencent.mobileqq.guild.contentshare.AbsGuildContentShareTemplate$componentList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SparseArray<g> invoke() {
                return AbsGuildContentShareTemplate.this.d();
            }
        });
        this.componentList = lazy;
    }

    private final SparseArray<g> h() {
        return (SparseArray) this.componentList.getValue();
    }

    private final void n() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.contentshare.a
            @Override // java.lang.Runnable
            public final void run() {
                AbsGuildContentShareTemplate.o(AbsGuildContentShareTemplate.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(AbsGuildContentShareTemplate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup k3 = this$0.k();
        if (k3 != null) {
            Integer f16 = this$0.f();
            if (f16 != null) {
                int intValue = f16.intValue();
                k3.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{VasColorUtil.getColorWithAlpha(0.0f, intValue), VasColorUtil.getColorWithAlpha(1.0f, intValue)}));
            }
            k3.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.guild.contentshare.f
    public void a() {
        this.isBgReady = true;
        if (this.needUpdateContentMaskLayout) {
            n();
        }
    }

    @Override // com.tencent.mobileqq.guild.contentshare.f
    public void b() {
        if (this.isBgReady) {
            n();
        } else {
            this.needUpdateContentMaskLayout = true;
        }
    }

    @NotNull
    public abstract SparseArray<g> d();

    public abstract void e();

    @Nullable
    public final Integer f() {
        g g16 = g(0);
        if (g16 instanceof e) {
            return Integer.valueOf(((e) g16).getBackgroundColor());
        }
        return null;
    }

    @Nullable
    public final g g(int type) {
        return h().get(type);
    }

    /* renamed from: i, reason: from getter */
    public final int getTemplateType() {
        return this.templateType;
    }

    @NotNull
    public abstract View j(@NotNull Context context, @NotNull d shareData, @NotNull View parent);

    @Nullable
    public abstract ViewGroup k();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(@Nullable View view, float radius) {
        if (view != null) {
            view.setOutlineProvider(new a(radius));
        }
        if (view != null) {
            view.setClipToOutline(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(@NotNull ImageView imageView, @NotNull String url) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(url, "url");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(url, options)");
        imageView.setImageDrawable(drawable2);
    }
}
