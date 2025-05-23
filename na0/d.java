package na0;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.publish.plusentry.composer.normal.theme.PlusEntryTheme;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.cn;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0017J\b\u0010\n\u001a\u00020\bH\u0017J\b\u0010\u000b\u001a\u00020\bH\u0017J\b\u0010\f\u001a\u00020\bH\u0017J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0005J\u001a\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\bH\u0004J\b\u0010\u0013\u001a\u00020\u0004H\u0017J\b\u0010\u0014\u001a\u00020\u0004H\u0017J\b\u0010\u0015\u001a\u00020\u0004H\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006/"}, d2 = {"Lna0/d;", "Lna0/a;", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/normal/theme/PlusEntryTheme;", "theme", "", HippyTKDListViewAdapter.X, "b", "a", "", DomainData.DOMAIN_NAME, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "id", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Drawable;", "drawable", "color", "w", ReportConstant.COSTREPORT_PREFIX, "u", "t", "Landroid/widget/ImageView;", "g", "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "ivNormal", "Landroidx/lifecycle/Observer;", tl.h.F, "Landroidx/lifecycle/Observer;", "getQTabThemeObserver", "()Landroidx/lifecycle/Observer;", "setQTabThemeObserver", "(Landroidx/lifecycle/Observer;)V", "qTabThemeObserver", "", "d", "()Ljava/lang/String;", "logTag", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "Landroid/view/View;", "plusEntryLayout", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "i", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class d extends a {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ImageView ivNormal;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Observer<PlusEntryTheme> qTabThemeObserver;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f419552a;

        static {
            int[] iArr = new int[PlusEntryTheme.values().length];
            try {
                iArr[PlusEntryTheme.Dark.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlusEntryTheme.WhiteDefault.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlusEntryTheme.WhiteColor.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f419552a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        super(partHost, plusEntryLayout);
        ImageView imageView;
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        View findViewById = plusEntryLayout.findViewById(R.id.f501924q);
        if (findViewById != null) {
            imageView = (ImageView) findViewById.findViewById(R.id.f502624x);
        } else {
            imageView = null;
        }
        this.ivNormal = imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(d this$0, PlusEntryTheme theme) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.d(), 1, "qTabTheme data changed, theme:" + theme);
        Intrinsics.checkNotNullExpressionValue(theme, "theme");
        this$0.x(theme);
    }

    private final void x(PlusEntryTheme theme) {
        int i3 = b.f419552a[theme.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    t();
                    return;
                }
                return;
            }
            u();
            return;
        }
        s();
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.a
    public void a() {
        super.a();
        Observer<PlusEntryTheme> observer = this.qTabThemeObserver;
        if (observer != null) {
            g().g2().removeObserver(observer);
        }
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.a
    public void b() {
        super.b();
        LiveData<PlusEntryTheme> g26 = g().g2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Observer<PlusEntryTheme> observer = new Observer() { // from class: na0.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.v(d.this, (PlusEntryTheme) obj);
            }
        };
        this.qTabThemeObserver = observer;
        Unit unit = Unit.INSTANCE;
        g26.observe(lifecycleOwner, observer);
    }

    @Override // na0.a, com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer
    @NotNull
    public String d() {
        return "PlusEntry-QTabPlusEntryNormalComposer";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ColorInt
    public final int m(int id5) {
        return c().getResources().getColor(id5);
    }

    @DrawableRes
    public int n() {
        return R.drawable.qvideo_skin_icon_tab_publish_clicked_dark;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    protected ImageView getIvNormal() {
        return this.ivNormal;
    }

    @ColorRes
    public int p() {
        return R.color.qui_common_brand_standard;
    }

    @DrawableRes
    public int q() {
        return n();
    }

    @DrawableRes
    public int r() {
        return R.drawable.qvideo_skin_icon_tab_publish_clicked_default;
    }

    @CallSuper
    public void s() {
        ImageView ivNormal = getIvNormal();
        if (ivNormal != null) {
            ivNormal.setImageDrawable(j(n()));
        }
    }

    @CallSuper
    public void t() {
        ImageView ivNormal = getIvNormal();
        if (ivNormal != null) {
            ivNormal.setImageDrawable(w(j(q()), m(p())));
        }
    }

    @CallSuper
    public void u() {
        ImageView ivNormal = getIvNormal();
        if (ivNormal != null) {
            ivNormal.setImageDrawable(j(r()));
        }
    }

    @NotNull
    protected final Drawable w(@NotNull Drawable drawable, @ColorInt int color) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Drawable f16 = cn.f(drawable);
        if (f16 == null) {
            return drawable;
        }
        f16.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        return f16;
    }
}
