package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.luggage.wxa.ga.a;
import com.tencent.luggage.wxa.lo.f;
import com.tencent.luggage.wxa.n3.q;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/luggage/ui/WxaAlertActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "finish", "<init>", "()V", "b", "a", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class WxaAlertActivity extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.ui.WxaAlertActivity$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.ui.WxaAlertActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class RunnableC5973a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q.a f120293a;

            public RunnableC5973a(q.a aVar) {
                this.f120293a = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(z.c(), this.f120293a.c() + '\n' + this.f120293a.b(), 1).show();
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, q.a alertParams) {
            Intrinsics.checkNotNullParameter(alertParams, "alertParams");
            Intent putExtra = new Intent().setClass(z.c(), WxaAlertActivity.class).putExtra("KEY_ALERT_PARCEL", alertParams);
            try {
                if ((context instanceof Activity) && !((Activity) context).isFinishing() && !((Activity) context).isDestroyed()) {
                    Activity activity = (Activity) context;
                    com.tencent.luggage.wxa.fa.b.a(activity, putExtra);
                    activity.startActivity(putExtra);
                } else {
                    putExtra.addFlags(268435456);
                    Context c16 = z.c();
                    com.tencent.luggage.wxa.fa.b.a(c16, putExtra);
                    c16.startActivity(putExtra);
                }
            } catch (ActivityNotFoundException unused) {
                c0.a(new RunnableC5973a(alertParams));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            WxaAlertActivity.this.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            WxaAlertActivity.this.finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void finish() {
        if (!isDestroyed() && !isFinishing()) {
            super.finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        q.a aVar;
        Intent intent;
        setTheme(R.style.adn);
        super.onCreate(savedInstanceState);
        try {
            intent = getIntent();
        } catch (Throwable unused) {
        }
        if (intent != null) {
            aVar = (q.a) intent.getParcelableExtra("KEY_ALERT_PARCEL");
            if (aVar == null && aVar.a()) {
                f.g(this);
                overridePendingTransition(0, 0);
                new MMAlertDialog.Builder(this).setTitle(aVar.c()).setMsg(aVar.b()).setCancelable(false).setPositiveBtnText(R.string.f170383z25).setPositiveBtnListener(new b()).setOnDismissListener(new c()).show();
                return;
            }
            finish();
        }
        aVar = null;
        if (aVar == null) {
        }
        finish();
    }
}
