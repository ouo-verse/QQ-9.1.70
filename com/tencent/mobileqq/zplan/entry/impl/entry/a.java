package com.tencent.mobileqq.zplan.entry.impl.entry;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\nB!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/entry/impl/entry/a;", "Lqh3/c;", "", "e", "", "f", "", "getPageId", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/os/Bundle;)V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends qh3.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Bundle bundle;

    public a(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        this.context = context;
        this.source = source;
        this.bundle = bundle;
    }

    private final void e() {
        QLog.i("AIGCCreationPageEntry", 1, "gotoCreationPage");
        if (!f()) {
            Context context = this.context;
            if (context != null) {
                QQToast.makeText(context, 0, "\u5185\u5b58\u4e0d\u8db3\uff0c\u6682\u4e0d\u652f\u6301\u8be5\u529f\u80fd", 0).show();
            }
            QLog.i("AIGCCreationPageEntry", 1, "gotoCreationPage HW is not supported!");
            return;
        }
        Bundle bundle = this.bundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (Intrinsics.areEqual(this.source.getSubSource(), "0")) {
            bundle.putString("AIGC_ENTRY_SOURCE", "1");
        } else {
            bundle.putString("AIGC_ENTRY_SOURCE", this.source.getSubSource());
        }
        if (!bundle.containsKey("subPageId")) {
            bundle.putInt("subPageId", 2);
        }
        new b(this.context, this.source, bundle).c();
    }

    private final boolean f() {
        long c16 = com.tencent.mobileqq.utils.m.c() / 1048576;
        int i3 = Build.VERSION.SDK_INT;
        QLog.i("AIGCCreationPageEntry", 1, "HW info memoryMB: " + c16 + ", sdk: " + i3);
        return c16 > 4096 || i3 > 26;
    }

    @Override // qh3.b
    public void c() {
        e();
    }

    @Override // qh3.c, qh3.b
    public int getPageId() {
        return 18;
    }
}
