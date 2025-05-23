package com.tencent.mobileqq.settingme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.immersive.color.f;
import com.tencent.mobileqq.vas.vipicon.api.IVipNumberDrawable;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001\u0016B\u001b\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0014J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R/\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/settingme/QQSettingMeBackgroundView;", "Landroid/widget/ImageView;", "", "uin", "", "theme", "", "setVipNumberInfo", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/drawable/Drawable;", "dr", "", "verifyDrawable", "<set-?>", "d", "Lkotlin/properties/ReadWriteProperty;", "a", "()Landroid/graphics/drawable/Drawable;", "b", "(Landroid/graphics/drawable/Drawable;)V", "vipNumberDrawable", "Lkotlin/Pair;", "e", "Lkotlin/Pair;", "_vipNumberInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes18.dex */
public final class QQSettingMeBackgroundView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f286778h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReadWriteProperty vipNumberDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<String, Integer> _vipNumberInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/settingme/QQSettingMeBackgroundView$a;", "", "<init>", "()V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.settingme.QQSettingMeBackgroundView$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends ObservableProperty<Drawable> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQSettingMeBackgroundView f286781b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, QQSettingMeBackgroundView qQSettingMeBackgroundView) {
            super(obj);
            this.f286781b = qQSettingMeBackgroundView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj, (Object) qQSettingMeBackgroundView);
            }
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(@NotNull KProperty<?> property, Drawable oldValue, Drawable newValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, property, oldValue, newValue);
                return;
            }
            Intrinsics.checkNotNullParameter(property, "property");
            Drawable drawable = newValue;
            if (!Intrinsics.areEqual(oldValue, drawable)) {
                this.f286781b.invalidate();
                if (drawable != null) {
                    drawable.setCallback(this.f286781b);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28049);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f286778h = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQSettingMeBackgroundView.class, "vipNumberDrawable", "getVipNumberDrawable()Landroid/graphics/drawable/Drawable;", 0))};
        INSTANCE = new Companion(null);
        f.a(new a());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQSettingMeBackgroundView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        Delegates delegates = Delegates.INSTANCE;
        this.vipNumberDrawable = new b(null, this);
        this._vipNumberInfo = TuplesKt.to("", 0);
    }

    private final Drawable a() {
        return (Drawable) this.vipNumberDrawable.getValue(this, f286778h[0]);
    }

    private final void b(Drawable drawable) {
        this.vipNumberDrawable.setValue(this, f286778h[0], drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Drawable a16 = a();
        if (a16 != null) {
            int dpToPx = width - ImmersiveUtils.dpToPx(16.0f);
            int dpToPx2 = height - ImmersiveUtils.dpToPx(34.0f);
            a16.setBounds(dpToPx - ((int) (a16.getIntrinsicWidth() * 0.9f)), dpToPx2 - ((int) (a16.getIntrinsicHeight() * 0.9f)), dpToPx, dpToPx2);
            a16.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) changedView, visibility);
            return;
        }
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            setVipNumberInfo(this._vipNumberInfo.getFirst(), this._vipNumberInfo.getSecond().intValue());
        }
    }

    public final void setVipNumberInfo(@Nullable String uin, int theme) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin, theme);
            return;
        }
        this._vipNumberInfo = TuplesKt.to(uin, Integer.valueOf(theme));
        VipData.VipNumberInfo vipNumberInfo = IVipDataUtils.INSTANCE.a().getVipDataForFriends(uin).getVipNumberInfo(VipData.VipNumberInfo.APPID.Theme, theme);
        if (vipNumberInfo == null) {
            b(null);
        } else {
            b(((IVipNumberDrawable) QRoute.api(IVipNumberDrawable.class)).newBigDrawable(vipNumberInfo.getNumberItemId(), vipNumberInfo.getNumberIdx(), vipNumberInfo.isLongNumber()));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(@NotNull Drawable dr5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) dr5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dr5, "dr");
        if (!super.verifyDrawable(dr5)) {
            return Intrinsics.areEqual(dr5, a());
        }
        return true;
    }
}
