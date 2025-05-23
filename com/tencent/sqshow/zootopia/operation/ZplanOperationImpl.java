package com.tencent.sqshow.zootopia.operation;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaFaceAdListData;
import com.tencent.sqshow.zootopia.operation.facead.ZplanFaceAdManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u000fB\u001b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/ZplanOperationImpl;", "", "Lcom/tencent/sqshow/zootopia/data/i;", "faceAdList", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroid/view/ViewGroup;", "fragmentContainer", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Landroid/os/Bundle;", "arguments", "", "c", "d", "a", "Landroid/content/res/Configuration;", "newConfig", "", "e", "g", h.F, "f", "Lcom/tencent/sqshow/zootopia/operation/facead/ZplanFaceAdManager;", "Lkotlin/Lazy;", "b", "()Lcom/tencent/sqshow/zootopia/operation/facead/ZplanFaceAdManager;", "faceAdManager", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/sqshow/zootopia/operation/facead/c;", "lifeCycleDispatcher", "<init>", "(Landroid/app/Activity;Lcom/tencent/sqshow/zootopia/operation/facead/c;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanOperationImpl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy faceAdManager;

    public ZplanOperationImpl(final Activity activity, final com.tencent.sqshow.zootopia.operation.facead.c cVar) {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZplanFaceAdManager>() { // from class: com.tencent.sqshow.zootopia.operation.ZplanOperationImpl$faceAdManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanFaceAdManager invoke() {
                return new ZplanFaceAdManager(activity, cVar);
            }
        });
        this.faceAdManager = lazy;
    }

    private final ZplanFaceAdManager b() {
        return (ZplanFaceAdManager) this.faceAdManager.getValue();
    }

    public boolean a() {
        return b().k();
    }

    public boolean c(ZootopiaFaceAdListData faceAdList, FragmentManager fragmentManager, ViewGroup fragmentContainer, ZootopiaSource sourceCurrent, Bundle arguments) {
        Intrinsics.checkNotNullParameter(faceAdList, "faceAdList");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        QLog.i("ZplanOperation", 1, "ZplanOperationImpl#handleFaceAd -  " + faceAdList.a().size() + ", fragmentManager = " + fragmentManager + ", fragmentContainer = " + fragmentContainer);
        return b().n(faceAdList, fragmentManager, fragmentContainer, sourceCurrent, arguments);
    }

    public boolean d() {
        return b().p();
    }

    public void e(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        b().t(newConfig);
    }

    public void f() {
        b().u();
    }

    public void g() {
        b().v();
    }

    public void h() {
        b().w();
    }
}
