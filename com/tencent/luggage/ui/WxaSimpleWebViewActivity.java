package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.luggage.wxa.fa.b;
import com.tencent.luggage.wxa.g6.r;
import com.tencent.luggage.wxa.g6.s;
import com.tencent.luggage.wxa.k6.o;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/ui/WxaSimpleWebViewActivity;", "Lcom/tencent/luggage/wxa/g6/s;", "Lcom/tencent/luggage/wxa/g6/r;", "createPage", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public class WxaSimpleWebViewActivity extends s {

    /* renamed from: S, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.ui.WxaSimpleWebViewActivity$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String str) {
            if (context == null) {
                context = z.c();
            }
            Intent putExtra = new Intent(context, (Class<?>) WxaSimpleWebViewActivity.class).putExtra("KEY_URL", str);
            if (!(context instanceof Activity)) {
                putExtra.addFlags(268435456);
            }
            b.a(context, putExtra);
            context.startActivity(putExtra);
        }
    }

    @Override // com.tencent.luggage.wxa.g6.s
    @NotNull
    public r createPage() {
        return new o(this);
    }

    @Override // com.tencent.mm.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.luggage.wxa.g6.s, com.tencent.mm.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
