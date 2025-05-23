package com.tencent.ecommerce.biz.bulletin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ui.SlidingUpDialog;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/bulletin/a;", "", "Landroid/content/Context;", "context", "", "title", "content", "Lcom/tencent/ecommerce/biz/bulletin/BulletinScene;", "scene", "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f101348a = new a();

    a() {
    }

    public final void a(Context context, String title, String content, BulletinScene scene) {
        if (!(context instanceof Activity)) {
            if (!QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().isDebug()) {
                cg0.a.a("BulletinDialogHelper", "showDialog", "context must be Activity, scene=" + scene.scene);
                return;
            }
            throw new IllegalStateException("context must be Activity");
        }
        SlidingUpDialog slidingUpDialog = new SlidingUpDialog((Activity) context, false, 2, null);
        View inflate = LayoutInflater.from(context).inflate(R.layout.coz, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.oce)).setText(title);
        ((TextView) inflate.findViewById(R.id.nus)).setText(content);
        slidingUpDialog.S(inflate, new FrameLayout.LayoutParams(-1, -2));
        slidingUpDialog.show();
    }
}
