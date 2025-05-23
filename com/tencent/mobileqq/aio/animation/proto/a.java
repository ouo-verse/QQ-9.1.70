package com.tencent.mobileqq.aio.animation.proto;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.animation.data.b;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IOidbApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/proto/a;", "", "", "key", "value", "Lcom/tencent/mobileqq/aio/animation/proto/Cmd0x127a_0$Info;", "a", "", "ruleType", "b", "Lmqq/app/AppRuntime;", "app", "", "troopOrDiscussion", "Lcom/tencent/mobileqq/aio/animation/data/b;", "message", "", "Lcom/tencent/mobileqq/aio/animation/config/a;", "rulesMatched", "", "c", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f188147a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/animation/proto/a$a", "Lcom/tencent/qqnt/aio/adapter/api/IOidbApi$a;", "", "errorCode", "", "data", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "a", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.proto.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7237a implements IOidbApi.a {
        static IPatchRedirector $redirector_;

        C7237a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.adapter.api.IOidbApi.a
        public void a(int errorCode, @Nullable byte[] data, @Nullable Bundle extraData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, extraData);
                return;
            }
            if (QLog.isColorLevel()) {
                if (data != null) {
                    z16 = true;
                }
                QLog.d("ReportEddInfoByProtoHelper", 1, "onResult, errorCode:" + errorCode + ", data:" + z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29819);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f188147a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Cmd0x127a_0$Info a(String key, String value) {
        Cmd0x127a_0$Info cmd0x127a_0$Info = new Cmd0x127a_0$Info();
        cmd0x127a_0$Info.key.set(key);
        cmd0x127a_0$Info.value.set(value);
        return cmd0x127a_0$Info;
    }

    private final int b(int ruleType) {
        switch (ruleType) {
            case 7:
            case 8:
            case 9:
                return -1;
            case 10:
                return 2;
            case 11:
                return 3;
            default:
                return 1;
        }
    }

    public final void c(@NotNull AppRuntime app, boolean troopOrDiscussion, @Nullable b message, @NotNull List<com.tencent.mobileqq.aio.animation.config.a> rulesMatched) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, Boolean.valueOf(troopOrDiscussion), message, rulesMatched);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(rulesMatched, "rulesMatched");
        String str3 = "ReportEddInfoByProtoHelper";
        if (message != null && !rulesMatched.isEmpty()) {
            if (!TextUtils.equals(message.getSenderUid(), app.getCurrentUid())) {
                QLog.i("ReportEddInfoByProtoHelper", 1, "message sendUin is not mine, return");
                return;
            }
            if (TextUtils.isEmpty(message.getPeerUid())) {
                QLog.i("ReportEddInfoByProtoHelper", 1, "message friendUin is null, return");
                return;
            }
            Cmd0x127a_0$ReportReq cmd0x127a_0$ReportReq = new Cmd0x127a_0$ReportReq();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            ArrayList arrayList = new ArrayList();
            int size = rulesMatched.size();
            while (i3 < size) {
                com.tencent.mobileqq.aio.animation.config.a aVar = rulesMatched.get(i3);
                int b16 = b(aVar.r());
                if (b16 == -1) {
                    str2 = str3;
                } else {
                    Cmd0x127a_0$Flow cmd0x127a_0$Flow = new Cmd0x127a_0$Flow();
                    PBStringField pBStringField = cmd0x127a_0$Flow.scope;
                    if (troopOrDiscussion) {
                        str = "c2g";
                    } else {
                        str = "c2c";
                    }
                    pBStringField.set(str);
                    cmd0x127a_0$Flow.action.set("msg_surprise");
                    str2 = str3;
                    cmd0x127a_0$Flow.target.set(message.getPeerUin());
                    cmd0x127a_0$Flow.time.set(currentTimeMillis);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(a("type", String.valueOf(b16)));
                    arrayList2.add(a("id", String.valueOf(aVar.h())));
                    arrayList2.add(a("keyword", aVar.o()));
                    cmd0x127a_0$Flow.info.set(arrayList2);
                    arrayList.add(cmd0x127a_0$Flow);
                }
                i3++;
                str3 = str2;
            }
            String str4 = str3;
            if (arrayList.size() <= 0) {
                QLog.i(str4, 1, "flowArrayList size is 0, return");
                return;
            }
            cmd0x127a_0$ReportReq.flows.set(arrayList);
            if (QLog.isColorLevel()) {
                QLog.i(str4, 1, "start sendOIDBRequest");
            }
            try {
                IOidbApi iOidbApi = (IOidbApi) QRoute.api(IOidbApi.class);
                byte[] byteArray = cmd0x127a_0$ReportReq.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "reportReq.toByteArray()");
                iOidbApi.sendOIDBRequest(app, byteArray, "OidbSvcTrpcTcp.0x127a_0", 4730, 0, new C7237a());
                return;
            } catch (Exception e16) {
                QLog.i(str4, 1, "[reportEggInfoByProto] exception: " + e16);
                return;
            }
        }
        QLog.i("ReportEddInfoByProtoHelper", 1, "illegal params, return");
    }
}
