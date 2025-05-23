package com.tencent.luggage.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.ka.i;
import com.tencent.luggage.wxa.qa.f;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.va.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.Reflect;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u0011B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u0006H\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/luggage/util/PresentationActivityHelper;", "Lcom/tencent/luggage/util/LuggageActivityHelper;", "Landroid/content/Intent;", "intent", "Lcom/tencent/luggage/util/LuggageActivityHelper$d;", "cb", "", IAELaunchRecorder.MILESTONE_START_ACTIVITY, "startActivityForResultThrows", "cleanUpWhenDismissed", "cleanUp", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "Companion", "a", "b", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class PresentationActivityHelper extends LuggageActivityHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "WMPF.WMPFActivityHelper";
    private byte _hellAccFlag_;

    /* renamed from: com.tencent.luggage.util.PresentationActivityHelper$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: com.tencent.luggage.util.PresentationActivityHelper$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class RunnableC5976a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f120373a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Intent f120374b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Intent f120375c;

            public RunnableC5976a(int i3, Intent intent, Intent intent2) {
                this.f120373a = i3;
                this.f120374b = intent;
                this.f120375c = intent2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PresentationActivityHelper.INSTANCE.a(this.f120373a, this.f120374b, this.f120375c);
            }
        }

        /* renamed from: com.tencent.luggage.util.PresentationActivityHelper$a$b */
        /* loaded from: classes5.dex */
        public static final class b implements i {

            /* renamed from: a, reason: collision with root package name */
            public static final b f120376a = new b();

            @Override // com.tencent.luggage.wxa.ka.i
            public final void a(e eVar) {
                w.d(PresentationActivityHelper.TAG, "invoke success");
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i3, Intent source, Intent intent) {
            Object obj;
            boolean z16;
            Intrinsics.checkNotNullParameter(source, "source");
            if (!c0.b()) {
                c0.a(new RunnableC5976a(i3, source, intent));
                return;
            }
            String stringExtra = source.getStringExtra("Luggage.LuggageActivityHelperproc_name");
            if (!w0.c(stringExtra)) {
                int intExtra = source.getIntExtra("Luggage.LuggageActivityHelperinstance_id", 0);
                int intExtra2 = source.getIntExtra("Luggage.LuggageActivityHelperreq_code", 0);
                String i16 = z.i();
                if (Intrinsics.areEqual(i16, stringExtra)) {
                    Iterator<T> it = LuggageActivityHelper.sHelpers.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (((Activity) obj).hashCode() == intExtra) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    Activity activity = (Activity) obj;
                    if (activity != null) {
                        Reflect.on(activity).call("onActivityResult", Integer.valueOf(intExtra2), Integer.valueOf(i3), intent);
                        ((PresentationActivityHelper) LuggageActivityHelper.FOR(activity, PresentationActivityHelper.class)).onActivityResult(intExtra2, i3, intent);
                        return;
                    }
                    return;
                }
                w.d(PresentationActivityHelper.TAG, "setResult: [%s] -> [%s]", i16, stringExtra);
                Bundle bundle = new Bundle();
                bundle.putInt(QzoneIPCModule.RESULT_CODE, i3);
                bundle.putParcelable("from", source);
                bundle.putParcelable("data", intent);
                f.a(stringExtra, bundle, b.class, b.f120376a);
                return;
            }
            throw new NullPointerException("proc name is null");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/luggage/util/PresentationActivityHelper$b;", "Lcom/tencent/luggage/wxa/ka/e;", "Landroid/os/Bundle;", "Lcom/tencent/luggage/wxa/va/e;", "data", "Lcom/tencent/luggage/wxa/ka/i;", "callback", "", "a", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements com.tencent.luggage.wxa.ka.e<Bundle, e> {
        @Override // com.tencent.luggage.wxa.ka.f
        public void a(Bundle data, i callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(callback, "callback");
            callback.a(e.f143316a);
            Companion companion = PresentationActivityHelper.INSTANCE;
            int i3 = data.getInt(QzoneIPCModule.RESULT_CODE);
            Parcelable parcelable = data.getParcelable("from");
            Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type android.content.Intent");
            Intent intent = (Intent) parcelable;
            Parcelable parcelable2 = data.getParcelable("data");
            companion.a(i3, intent, parcelable2 instanceof Intent ? (Intent) parcelable2 : null);
        }
    }

    public PresentationActivityHelper(@Nullable Activity activity) {
        super(activity);
    }

    @JvmStatic
    public static final void setResult(int i3, @NotNull Intent intent, @Nullable Intent intent2) {
        INSTANCE.a(i3, intent, intent2);
    }

    public final void cleanUpWhenDismissed() {
        super.cleanUp();
    }

    @Override // com.tencent.luggage.util.LuggageActivityHelper
    public void startActivityForResult(@Nullable Intent intent, @Nullable LuggageActivityHelper.d cb5) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int genRandomCodeFor = genRandomCodeFor(this.mActivityResultCallbacks);
        this.mActivityResultCallbacks.put(genRandomCodeFor, cb5);
        Intrinsics.checkNotNull(intent);
        intent.putExtra("Luggage.LuggageActivityHelperproc_name", z.i());
        intent.putExtra("Luggage.LuggageActivityHelperinstance_id", activity.hashCode());
        intent.putExtra("Luggage.LuggageActivityHelperreq_code", genRandomCodeFor);
        com.tencent.luggage.wxa.fa.b.a(activity, intent);
        activity.startActivity(intent);
    }

    @Override // com.tencent.luggage.util.LuggageActivityHelper
    public void startActivityForResultThrows(@Nullable Intent intent, @Nullable LuggageActivityHelper.d cb5) {
        startActivityForResult(intent, cb5);
    }

    @Override // com.tencent.luggage.util.LuggageActivityHelper
    public void cleanUp() {
    }
}
