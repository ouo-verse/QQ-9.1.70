package com.tencent.luggage.wxa.ve;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.PhoneNumberUtils;
import androidx.core.content.ContextCompat;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = 72;

    @Deprecated
    @NotNull
    public static final String NAME = "chooseContact";

    /* renamed from: a, reason: collision with root package name */
    public static final a f143398a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements LuggageActivityHelper.h {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f143400b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f143401c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f143402d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f143403e;

        public b(com.tencent.luggage.wxa.xd.d dVar, Activity activity, JSONObject jSONObject, int i3) {
            this.f143400b = dVar;
            this.f143401c = activity;
            this.f143402d = jSONObject;
            this.f143403e = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
        
            r4 = kotlin.collections.ArraysKt___ArraysKt.firstOrNull(r5);
         */
        @Override // com.tencent.luggage.util.LuggageActivityHelper.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(String[] strArr, int[] iArr) {
            boolean z16;
            Integer firstOrNull;
            if (iArr != null && firstOrNull != null && firstOrNull.intValue() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                d.this.a(this.f143400b, this.f143401c, this.f143402d, this.f143403e);
            } else {
                this.f143400b.a(this.f143403e, d.this.makeReturnJson("fail:system permission denied"));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null || jSONObject == null) {
            return;
        }
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(dVar.getContext());
        if (a16 == null) {
            a(dVar, i3);
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            if (ContextCompat.checkSelfPermission(a16, QQPermissionConstants.Permission.READ_CONTACTS) == 0) {
                a(dVar, a16, jSONObject, i3);
                return;
            } else {
                LuggageActivityHelper.FOR(a16).checkRequestPermission(dVar, QQPermissionConstants.Permission.READ_CONTACTS, new b(dVar, a16, jSONObject, i3));
                return;
            }
        }
        a(dVar, a16, jSONObject, i3);
    }

    public static final void a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
        dVar.a(i3, "fail:internal error invalid android context");
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, Activity activity, JSONObject jSONObject, int i3) {
        LuggageActivityHelper FOR = LuggageActivityHelper.FOR(activity);
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("vnd.android.cursor.dir/phone_v2");
        FOR.startActivityForResult(intent, new c(dVar, i3, this));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements LuggageActivityHelper.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f143404a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f143405b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f143406c;

        public c(com.tencent.luggage.wxa.xd.d dVar, int i3, d dVar2) {
            this.f143404a = dVar;
            this.f143405b = i3;
            this.f143406c = dVar2;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            String str;
            boolean z16;
            w.d("Luggage.Common.JsApiChooseContactNew", "onActivityResult appId[" + this.f143404a.getAppId() + "], resultCode[" + i3 + ']');
            boolean z17 = true;
            if (i3 != -1) {
                if (i3 != 0 && i3 != 1) {
                    this.f143404a.a(this.f143405b, this.f143406c.makeReturnJson("fail:system error"));
                    return;
                } else {
                    this.f143404a.a(this.f143405b, this.f143406c.makeReturnJson("fail cancel"));
                    return;
                }
            }
            String str2 = null;
            Uri data = intent != null ? intent.getData() : null;
            if (data == null) {
                a(this.f143404a);
                return;
            }
            ContentResolver contentResolver = this.f143404a.getContext().getContentResolver();
            if (contentResolver == null) {
                a(this.f143404a, this.f143405b, this.f143406c);
                return;
            }
            Cursor query = ContactsMonitor.query(contentResolver, data, new String[]{StepCounterConstants.BEACON_PARAM_KEY_DATA1}, null, null, null);
            if (query != null) {
                com.tencent.luggage.wxa.xd.d dVar = this.f143404a;
                try {
                    if (!query.moveToFirst()) {
                        w.b("Luggage.Common.JsApiChooseContactNew", "onActivityResult appId[" + dVar.getAppId() + "] cursor empty");
                        str = null;
                        CloseableKt.closeFinally(query, null);
                    }
                    do {
                        str = com.tencent.luggage.wxa.ve.c.b(query.getString(0));
                        if (str != null && str.length() != 0) {
                            z16 = false;
                            if (!z16 && PhoneNumberUtils.isGlobalPhoneNumber(str)) {
                                break;
                            }
                        }
                        z16 = true;
                        if (!z16) {
                            break;
                            break;
                        }
                    } while (query.moveToNext());
                    str = null;
                    CloseableKt.closeFinally(query, null);
                } finally {
                }
            } else {
                str = null;
            }
            query = ContactsMonitor.query(contentResolver, data, new String[]{"display_name"}, null, null, null);
            if (query != null) {
                try {
                    String string = query.moveToFirst() ? query.getString(0) : "";
                    CloseableKt.closeFinally(query, null);
                    str2 = string;
                } finally {
                }
            }
            String str3 = str2 != null ? str2 : "";
            if (str != null && str.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                com.tencent.luggage.wxa.xd.d dVar2 = this.f143404a;
                int i16 = this.f143405b;
                d dVar3 = this.f143406c;
                HashMap hashMap = new HashMap();
                hashMap.put(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, str);
                hashMap.put(CommonConstant.KEY_DISPLAY_NAME, str3);
                Unit unit = Unit.INSTANCE;
                dVar2.a(i16, dVar3.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                return;
            }
            this.f143404a.a(this.f143405b, this.f143406c.makeReturnJson("fail"));
        }

        public static final void a(com.tencent.luggage.wxa.xd.d dVar) {
            w.b("Luggage.Common.JsApiChooseContactNew", "onActivityResult appId[" + dVar.getAppId() + "] NULL contactUri");
        }

        public static final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, d dVar2) {
            w.b("Luggage.Common.JsApiChooseContactNew", "onActivityResult appId[" + dVar.getAppId() + "] NULL ContentResolver");
            dVar.a(i3, dVar2.makeReturnJson("fail:internal error invalid android context"));
        }
    }
}
