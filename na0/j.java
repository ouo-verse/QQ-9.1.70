package na0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001\u0004B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0004J\b\u0010\t\u001a\u00020\bH\u0017J\b\u0010\n\u001a\u00020\bH\u0017R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lna0/j;", "Lna0/a;", "", "b", "a", "", "isEnableSkin", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "g", "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "ivNormal", "Landroidx/lifecycle/Observer;", tl.h.F, "Landroidx/lifecycle/Observer;", "getEnableSkinObserver", "()Landroidx/lifecycle/Observer;", "setEnableSkinObserver", "(Landroidx/lifecycle/Observer;)V", "enableSkinObserver", "", "d", "()Ljava/lang/String;", "logTag", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "Landroid/view/View;", "plusEntryLayout", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "i", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class j extends a {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ImageView ivNormal;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Observer<Boolean> enableSkinObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        super(partHost, plusEntryLayout);
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        this.ivNormal = (ImageView) plusEntryLayout.findViewById(R.id.f502624x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(j this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.d(), 1, "finalEnableSkin data changed, ret:" + it);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.q(it.booleanValue());
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.a
    public void a() {
        super.a();
        Observer<Boolean> observer = this.enableSkinObserver;
        if (observer != null) {
            g().a2().removeObserver(observer);
        }
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.a
    public void b() {
        super.b();
        LiveData<Boolean> a26 = g().a2();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        Observer<Boolean> observer = new Observer() { // from class: na0.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                j.p(j.this, (Boolean) obj);
            }
        };
        this.enableSkinObserver = observer;
        Unit unit = Unit.INSTANCE;
        a26.observe(hostLifecycleOwner, observer);
    }

    @Override // na0.a, com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer
    @NotNull
    public String d() {
        return "PlusEntry-RightTopPlusEntryNormalComposer";
    }

    @DrawableRes
    public int m() {
        return R.drawable.nrd;
    }

    @DrawableRes
    public int n() {
        return R.drawable.qvideo_skin_icon_nav_post_plus;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    protected ImageView getIvNormal() {
        return this.ivNormal;
    }

    protected final void q(boolean isEnableSkin) {
        Drawable j3;
        ImageView ivNormal = getIvNormal();
        if (ivNormal != null) {
            if (isEnableSkin) {
                j3 = k(n());
            } else {
                j3 = j(m());
            }
            ivNormal.setImageDrawable(j3);
        }
    }
}
