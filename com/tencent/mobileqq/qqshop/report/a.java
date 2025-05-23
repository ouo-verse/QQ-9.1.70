package com.tencent.mobileqq.qqshop.report;

import com.tencent.mobileqq.ecshop.utils.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqshop.message.d;
import com.tencent.mobileqq.qqshop.report.beacon.b;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqshop/report/a;", "", "", "opName", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "c", QQPermissionConstants.Permission.AUIDO_GROUP, "b", "a", "opType", "d", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f274706a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40596);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f274706a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(String opName, MsgRecord msgRecord) {
        String str;
        boolean z16;
        HashMap<String, String> hashMapOf;
        boolean z17;
        Object obj;
        d dVar = d.f274478a;
        String n3 = dVar.n(msgRecord);
        int d16 = dVar.d(msgRecord);
        if (dVar.x(msgRecord)) {
            str = "1";
        } else {
            str = "0";
        }
        String t16 = dVar.t(msgRecord);
        if (n3 != null && n3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (msgRecord != null) {
                obj = Integer.valueOf(msgRecord.msgType);
            } else {
                obj = "msg null";
            }
            n3 = "msgType=" + obj;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("op_in", String.valueOf(d16)), TuplesKt.to("ext2", str), TuplesKt.to("op_type", n3), TuplesKt.to("ext23", t16));
        JSONObject r16 = dVar.r(msgRecord);
        c cVar = c.f203952a;
        String optString = r16.optString("report");
        Intrinsics.checkNotNullExpressionValue(optString, "qggWebExtJson.optString(\"report\")");
        for (Map.Entry<String, String> entry : cVar.b(optString).entrySet()) {
            if (entry.getKey().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                hashMapOf.put(entry.getKey(), entry.getValue());
            }
        }
        b.f274709a.b(opName, hashMapOf);
    }

    public final void a(@NotNull MsgRecord record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) record);
        } else {
            Intrinsics.checkNotNullParameter(record, "record");
            c("qgg_push_arrive", record);
        }
    }

    public final void b(@NotNull MsgRecord record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) record);
        } else {
            Intrinsics.checkNotNullParameter(record, "record");
            c("qgg_push_click", record);
        }
    }

    public final void d(@Nullable String opType) {
        HashMap<String, String> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("op_type", opType));
            b.f274709a.b("gouwu_top_click", hashMapOf);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) opType);
        }
    }
}
