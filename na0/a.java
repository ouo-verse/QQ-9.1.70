package na0;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.DrawableRes;
import com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer;
import com.tencent.biz.qqcircle.publish.plusentry.helper.PlusEntryExp;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0004J\u0012\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0004R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lna0/a;", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/BasePlusEntryComposer;", "Lcom/tencent/biz/qqcircle/publish/plusentry/helper/PlusEntryExp;", "exp", "i", "", "id", "Landroid/graphics/drawable/Drawable;", "j", "k", "", "d", "()Ljava/lang/String;", "logTag", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "Landroid/view/View;", "plusEntryLayout", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "f", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class a extends BasePlusEntryComposer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        super(partHost, plusEntryLayout);
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer
    @NotNull
    public String d() {
        return "PlusEntry-BasePlusEntryNormalComposer";
    }

    @NotNull
    public final a i(@NotNull PlusEntryExp exp) {
        Intrinsics.checkNotNullParameter(exp, "exp");
        if (g().x2()) {
            return new j(getPartHost(), getPlusEntryLayout());
        }
        if (g().v2()) {
            return new b(getPartHost(), getPlusEntryLayout());
        }
        if (exp == PlusEntryExp.DEFAULT) {
            return new d(getPartHost(), getPlusEntryLayout());
        }
        if (exp == PlusEntryExp.EXP_B) {
            return new e(getPartHost(), getPlusEntryLayout());
        }
        if (exp == PlusEntryExp.EXP_C) {
            return new f(getPartHost(), getPlusEntryLayout());
        }
        if (exp == PlusEntryExp.EXP_D) {
            return new g(getPartHost(), getPlusEntryLayout());
        }
        if (exp == PlusEntryExp.EXP_E) {
            return new h(getPartHost(), getPlusEntryLayout());
        }
        return new a(getPartHost(), getPlusEntryLayout());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Drawable j(@DrawableRes int id5) {
        Drawable drawable = c().getResources().getDrawable(id5);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDrawable(id)");
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Drawable k(@DrawableRes int id5) {
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(id5);
        Intrinsics.checkNotNullExpressionValue(drawable, "getInstance().getDrawable(id)");
        return drawable;
    }
}
