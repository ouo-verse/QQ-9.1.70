package com.tencent.mobileqq.zplan.entry.impl.entry;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.avatar.impl.fragment.ZPlanAvatarSubSceneFragment;
import com.tencent.mobileqq.zplan.utils.UEDownloadSource;
import com.tencent.mobileqq.zplan.utils.ab;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.ZootopiaTransparentActivity;
import com.tencent.sqshow.zootopia.nativeui.view.customerface.ZPlanPinchFaceFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/entry/impl/entry/SubSceneAvatarEntry;", "Lqh3/a;", "", "f", "", "d", "", "getSceneType", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/os/Bundle;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SubSceneAvatarEntry extends qh3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Bundle bundle;

    public SubSceneAvatarEntry(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        this.context = context;
        this.source = source;
        this.bundle = bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        if (this.source.getMainSource() == Source.AIGCPreview) {
            ZootopiaActivity.Companion.c(ZootopiaActivity.INSTANCE, this.context, ZPlanAvatarSubSceneFragment.class, this.source, this.bundle, false, 16, null);
            Activity b16 = bb.f335811a.b(this.context);
            if (b16 == null) {
                b16 = Foreground.getTopActivity();
            }
            if (b16 != null) {
                b16.overridePendingTransition(R.anim.f154373ju, 0);
                return;
            }
            return;
        }
        ZootopiaTransparentActivity.INSTANCE.a(this.context, ZPlanAvatarSubSceneFragment.class, this.source, this.bundle);
        Activity b17 = bb.f335811a.b(this.context);
        if (b17 == null) {
            b17 = Foreground.getTopActivity();
        }
        if (b17 != null) {
            b17.overridePendingTransition(R.anim.f154374jv, 0);
        }
    }

    @Override // qh3.b
    public void c() {
        Bundle bundle = this.bundle;
        boolean z16 = bundle != null ? bundle.getBoolean("onlyMakeupMode") : false;
        boolean enableUseFilamentPinchFace = ZPlanQQMC.INSTANCE.enableUseFilamentPinchFace();
        if (!z16 || !enableUseFilamentPinchFace) {
            if (z16) {
                ab.a(this.context, UEDownloadSource.MakeFace, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.entry.impl.entry.SubSceneAvatarEntry$doJump$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SubSceneAvatarEntry.this.f();
                    }
                });
                return;
            } else {
                f();
                return;
            }
        }
        ZootopiaTransparentActivity.INSTANCE.a(this.context, ZPlanPinchFaceFragment.class, this.source, this.bundle);
        Activity b16 = bb.f335811a.b(this.context);
        if (b16 == null) {
            b16 = Foreground.getTopActivity();
        }
        if (b16 != null) {
            b16.overridePendingTransition(R.anim.f154374jv, 0);
        }
    }

    @Override // qh3.b
    public boolean d() {
        return true;
    }

    @Override // qh3.b
    public int getSceneType() {
        return 1;
    }
}
