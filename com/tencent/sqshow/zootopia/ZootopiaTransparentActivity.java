package com.tencent.sqshow.zootopia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/ZootopiaTransparentActivity;", "Lcom/tencent/sqshow/zootopia/ZootopiaActivity;", "", "N2", "doFinish", "", "isWrapContent", "<init>", "()V", "g0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaTransparentActivity extends ZootopiaActivity {

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J<\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007JD\u0010\u0011\u001a\u00020\f\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/ZootopiaTransparentActivity$a;", "", "Landroidx/fragment/app/Fragment;", "T", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "fragClazz", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "from", "Landroid/os/Bundle;", "bundle", "", "a", "Landroid/app/Activity;", "", "requestCode", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.ZootopiaTransparentActivity$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final <T extends Fragment> void a(Context context, Class<T> fragClazz, ZootopiaSource from, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fragClazz, "fragClazz");
            Intrinsics.checkNotNullParameter(from, "from");
            Intent a16 = ZootopiaActivity.INSTANCE.a(context, ZootopiaTransparentActivity.class, fragClazz, from, bundle);
            if (!(context instanceof Activity)) {
                a16.addFlags(268435456);
            }
            context.startActivity(a16);
        }

        @JvmStatic
        public final <T extends Fragment> void b(Activity context, Class<T> fragClazz, int requestCode, ZootopiaSource from, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fragClazz, "fragClazz");
            Intrinsics.checkNotNullParameter(from, "from");
            context.startActivityForResult(ZootopiaActivity.INSTANCE.a(context, ZootopiaTransparentActivity.class, fragClazz, from, bundle), requestCode);
        }

        Companion() {
        }
    }

    private final void N2() {
        Window window = getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView == null) {
            return;
        }
        decorView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.ZootopiaActivity
    public void doFinish() {
        N2();
        ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).setPreRecordShareListener(null);
        super.doFinish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.ZootopiaActivity, com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }
}
