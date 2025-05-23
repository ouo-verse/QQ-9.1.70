package com.tencent.luggage.wxaapi.internal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.scanner.scanner.ui.BaseScanUI;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.ga.a;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.r;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0002\u0011\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\r\u001a\u00020\u0005H\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/luggage/wxaapi/internal/ui/WxaScanResultDelegateActivity;", "Landroid/app/Activity;", "Lcom/tencent/luggage/util/LuggageActivityHelper$g;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "b", "a", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class WxaScanResultDelegateActivity extends a implements LuggageActivityHelper.g {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxaapi.internal.ui.WxaScanResultDelegateActivity$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxaapi.internal.ui.WxaScanResultDelegateActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class ResultReceiverC6998a extends ResultReceiver {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LuggageActivityHelper.d f146887a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ResultReceiverC6998a(LuggageActivityHelper.d dVar, Handler handler) {
                super(handler);
                this.f146887a = dVar;
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i3, Bundle bundle) {
                Intent intent;
                LuggageActivityHelper.d dVar = this.f146887a;
                if (bundle != null) {
                    intent = (Intent) bundle.getParcelable("KEY_EXTRA_ACTIVITY_RESULT_DATA");
                } else {
                    intent = null;
                }
                dVar.a(i3, intent);
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intent intent = new Intent(context, (Class<?>) BaseScanUI.class);
            intent.putExtra("key_only_from_camera", true);
            return intent;
        }

        public final void a(Context context, LuggageActivityHelper.d callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if ((context instanceof Activity) && (context instanceof LuggageActivityHelper.g)) {
                LuggageActivityHelper.FOR(context).startActivityForResult(a(context), callback);
                return;
            }
            ResultReceiverC6998a resultReceiverC6998a = new ResultReceiverC6998a(callback, b0.a(Looper.getMainLooper()));
            Intent intent = new Intent(context, (Class<?>) WxaScanResultDelegateActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("KEY_EXTRA_RESULT_RECEIVER", resultReceiverC6998a);
            com.tencent.luggage.wxa.fa.b.a(context, intent);
            context.startActivity(intent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        public static final a f146888d = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public final String f146889a;

        /* renamed from: b, reason: collision with root package name */
        public final int f146890b;

        /* renamed from: c, reason: collision with root package name */
        public final int f146891c;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b a(Intent data) {
                Intrinsics.checkNotNullParameter(data, "data");
                String stringExtra = data.getStringExtra("key_scan_result");
                Intrinsics.checkNotNull(stringExtra);
                return new b(stringExtra, com.tencent.luggage.wxa.cn.a.a(w0.b(data.getStringExtra("key_scan_result_code_name"), CommonConstant.RETKEY.QR_CODE)), r.a(data, "key_scan_result_code_version", 0));
            }
        }

        public b(String codeData, int i3, int i16) {
            Intrinsics.checkNotNullParameter(codeData, "codeData");
            this.f146889a = codeData;
            this.f146890b = i3;
            this.f146891c = i16;
        }

        public final String a() {
            return this.f146889a;
        }

        public final int b() {
            return this.f146890b;
        }

        public final int c() {
            return this.f146891c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual(this.f146889a, bVar.f146889a) && this.f146890b == bVar.f146890b && this.f146891c == bVar.f146891c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f146889a.hashCode() * 31) + this.f146890b) * 31) + this.f146891c;
        }

        public String toString() {
            return "ScanResultModel(codeData=" + this.f146889a + ", codeType=" + this.f146890b + ", codeVersion=" + this.f146891c + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c implements LuggageActivityHelper.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f146892a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WxaScanResultDelegateActivity f146893b;

        public c(ResultReceiver resultReceiver, WxaScanResultDelegateActivity wxaScanResultDelegateActivity) {
            this.f146892a = resultReceiver;
            this.f146893b = wxaScanResultDelegateActivity;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            ResultReceiver resultReceiver = this.f146892a;
            Bundle bundle = new Bundle();
            bundle.putParcelable("KEY_EXTRA_ACTIVITY_RESULT_DATA", intent);
            Unit unit = Unit.INSTANCE;
            resultReceiver.send(i3, bundle);
            this.f146893b.finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        LuggageActivityHelper.FOR(this).onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        ResultReceiver resultReceiver;
        setTheme(R.style.ajq);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null && (resultReceiver = (ResultReceiver) intent.getParcelableExtra("KEY_EXTRA_RESULT_RECEIVER")) != null) {
            LuggageActivityHelper.FOR(this).startActivityForResult(INSTANCE.a(this), new c(resultReceiver, this));
        } else {
            finish();
        }
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LuggageActivityHelper.REMOVE(this);
    }
}
