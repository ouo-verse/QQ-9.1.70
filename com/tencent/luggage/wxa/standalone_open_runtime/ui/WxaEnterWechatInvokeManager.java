package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.fa.b;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.standalone_open_runtime.report.KVReport_CALL_TRANSFER_API_10054;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.v3.f;
import com.tencent.luggage.wxa.v3.m;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class WxaEnterWechatInvokeManager {

    /* renamed from: a, reason: collision with root package name */
    public static final WxaEnterWechatInvokeManager f140737a = new WxaEnterWechatInvokeManager();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f140738b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WxaEnterWechatInvokeManager$invoke$invokeContext$1 f140739a;

        public a(WxaEnterWechatInvokeManager$invoke$invokeContext$1 wxaEnterWechatInvokeManager$invoke$invokeContext$1) {
            this.f140739a = wxaEnterWechatInvokeManager$invoke$invokeContext$1;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(String str) {
            boolean contains$default;
            if (str == null) {
                str = "";
            }
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, false, 2, (Object) null);
            if (contains$default) {
                String b16 = this.f140739a.b();
                if (b16 == null || b16.length() == 0) {
                    return;
                }
                Context c16 = z.c();
                Intent intent = new Intent();
                WxaEnterWechatInvokeManager$invoke$invokeContext$1 wxaEnterWechatInvokeManager$invoke$invokeContext$1 = this.f140739a;
                Context c17 = z.c();
                String b17 = wxaEnterWechatInvokeManager$invoke$invokeContext$1.b();
                Intrinsics.checkNotNull(b17);
                intent.setClassName(c17, b17);
                intent.putExtra("com.tencent.luggage.container.BaseContainerActivity.INTENT_KEY_BRING_TO_FRONT", true);
                intent.addFlags(268435456);
                b.a(c16, intent);
                c16.startActivity(intent);
            }
        }
    }

    static {
        KVReport_CALL_TRANSFER_API_10054.f140728i.a();
        f140738b = new AtomicInteger(1);
    }

    public final void a(String wxaAppID, Context context, String api, Function0 args) {
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!f.c()) {
            com.tencent.luggage.wxa.d7.a.f124128a.a((d) null, R.string.zvu);
            return;
        }
        m mVar = m.f143124a;
        if (!mVar.c()) {
            com.tencent.luggage.wxa.d7.a.f124128a.a((d) null, R.string.zvt);
            return;
        }
        WxaEnterWechatInvokeManager$invoke$invokeContext$1 wxaEnterWechatInvokeManager$invoke$invokeContext$1 = new WxaEnterWechatInvokeManager$invoke$invokeContext$1(wxaAppID, context);
        com.tencent.luggage.wxa.v3.d dVar = new com.tencent.luggage.wxa.v3.d();
        dVar.f143055a = wxaEnterWechatInvokeManager$invoke$invokeContext$1;
        dVar.f143056b = api;
        dVar.f143057c = (String) args.invoke();
        dVar.f143058d = f140738b.getAndIncrement();
        dVar.f143059e = 1;
        mVar.a(dVar).a(new a(wxaEnterWechatInvokeManager$invoke$invokeContext$1));
    }
}
