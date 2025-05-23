package com.tencent.ecommerce.base.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002J.\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/a;", "", "", "isTrans", "Ljava/lang/Class;", "Landroid/app/Activity;", "b", "Landroid/content/Intent;", "intent", "Landroidx/fragment/app/Fragment;", "cls", "", "c", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "d", "Landroid/content/Context;", "context", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f100882a = new a();

    a() {
    }

    public final Intent a(Context context, Intent intent, Class<? extends Fragment> cls, boolean isTrans) {
        intent.setClass(context, b(isTrans));
        intent.putExtra("public_fragment_class", cls.getName());
        return intent;
    }

    public final void d(Activity activity, Intent intent, Class<? extends Fragment> cls, int requestCode, boolean isTrans) {
        activity.startActivityForResult(a(activity, intent, cls, isTrans), requestCode);
    }

    private final Class<? extends Activity> b(boolean isTrans) {
        if (isTrans) {
            return ECPluginTransActivity.class;
        }
        return ECPluginActivity.class;
    }

    public final void c(Intent intent, Class<? extends Fragment> cls, boolean isTrans) {
        intent.addFlags(268435456);
        wg0.a.a().startActivity(a(wg0.a.a(), intent, cls, isTrans));
    }
}
