package ow1;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.guild.util.cw;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mw1.c;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Low1/a;", "Lmw1/c;", "Landroid/view/View;", "view", "Lmw1/b;", "helper", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements c {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f424213d = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0014\u00a8\u0006\u000b"}, d2 = {"ow1/a$a", "Lee0/b;", "Landroid/content/Context;", "context", "", "buttonType", "sizeType", "f", "type", "themeId", h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ow1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C10964a extends ee0.b {
        C10964a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ee0.b
        public int f(@NotNull Context context, int buttonType, int sizeType) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (sizeType != 3) {
                return (int) cw.d(100);
            }
            return super.f(context, buttonType, sizeType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ee0.b
        public int h(@NotNull Context context, int type, int sizeType, int themeId) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (type == 2) {
                return (int) cw.c(0.5f);
            }
            return super.h(context, type, sizeType, themeId);
        }
    }

    a() {
    }

    @Override // mw1.c
    public void a(@NotNull View view, @NotNull mw1.b helper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (!(view instanceof QUIButton)) {
            return;
        }
        ((QUIButton) view).setQUIButtonResHelper(new C10964a());
    }
}
