package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseMediaItem;
import com.tencent.mobileqq.troop.widget.RatioImageView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u001b\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWItemLoadImageView;", "Lcom/tencent/mobileqq/troop/widget/RatioImageView;", "", "w", h.F, "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "kotlin.jvm.PlatformType", "o", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseMediaItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "p", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/drawable/ColorDrawable;", "D", "Landroid/graphics/drawable/ColorDrawable;", "placeHolderDrawable", "E", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseMediaItem;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", UserInfo.SEX_FEMALE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWItemLoadImageView extends RatioImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ColorDrawable placeHolderDrawable;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private BaseMediaItem item;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWItemLoadImageView$a;", "", "", "defaultRatio", UserInfo.SEX_FEMALE, "", "maxRequestW", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWItemLoadImageView$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWItemLoadImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.placeHolderDrawable = new ColorDrawable(Color.parseColor("#DEDEDE"));
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URLDrawable.URLDrawableOptions o(int w3, int h16) {
        int roundToInt;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = this.placeHolderDrawable;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        if (w3 > 720) {
            obtain.mRequestWidth = 720;
            roundToInt = MathKt__MathJVMKt.roundToInt(((h16 * 720) * 1.0f) / w3);
            obtain.mRequestHeight = roundToInt;
        } else {
            obtain.mRequestWidth = w3;
            obtain.mRequestHeight = h16;
        }
        return obtain;
    }

    @Override // android.view.View
    protected void onSizeChanged(final int w3, final int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        BaseMediaItem baseMediaItem = this.item;
        if (baseMediaItem != null) {
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.utils.a.f296840a.b(baseMediaItem, this, new Function0<URLDrawable.URLDrawableOptions>(w3, h16) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWItemLoadImageView$onSizeChanged$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $h;
                final /* synthetic */ int $w;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$w = w3;
                    this.$h = h16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, HWItemLoadImageView.this, Integer.valueOf(w3), Integer.valueOf(h16));
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final URLDrawable.URLDrawableOptions invoke() {
                    URLDrawable.URLDrawableOptions o16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (URLDrawable.URLDrawableOptions) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    o16 = HWItemLoadImageView.this.o(this.$w, this.$h);
                    Intrinsics.checkNotNullExpressionValue(o16, "getImageLoadOption(w, h)");
                    return o16;
                }
            });
        }
    }

    public final void p(@NotNull BaseMediaItem item) {
        float f16;
        boolean z16;
        ImageView.ScaleType scaleType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        try {
            f16 = (item.getWidth() * 1.0f) / item.getHeight();
        } catch (Throwable unused) {
            f16 = 0.78669727f;
        }
        boolean z17 = true;
        if (l() == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            setRatio(f16);
        } else {
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.utils.a.f296840a.b(item, this, new Function0<URLDrawable.URLDrawableOptions>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWItemLoadImageView$load$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWItemLoadImageView.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final URLDrawable.URLDrawableOptions invoke() {
                    URLDrawable.URLDrawableOptions o16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (URLDrawable.URLDrawableOptions) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    HWItemLoadImageView hWItemLoadImageView = HWItemLoadImageView.this;
                    o16 = hWItemLoadImageView.o(hWItemLoadImageView.getWidth(), HWItemLoadImageView.this.getHeight());
                    Intrinsics.checkNotNullExpressionValue(o16, "getImageLoadOption(width, height)");
                    return o16;
                }
            });
        }
        if (l() != 0.78669727f) {
            z17 = false;
        }
        if (z17) {
            scaleType = ImageView.ScaleType.CENTER_INSIDE;
        } else {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        setScaleType(scaleType);
    }

    public /* synthetic */ HWItemLoadImageView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
