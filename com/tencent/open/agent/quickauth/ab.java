package com.tencent.open.agent.quickauth;

import java.util.HashMap;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/open/agent/quickauth/ab;", "", "", "isOidb", "", "a", "", "code", "isSuccess", "b", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ab f340393a = new ab();

    ab() {
    }

    public final void a(boolean isOidb) {
        String str;
        HashMap hashMap = new HashMap();
        if (isOidb) {
            str = "2";
        } else {
            str = "1";
        }
        hashMap.put("api_type", str);
        com.tencent.mobileqq.inject.v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "WebQuickAuth", hashMap);
    }

    public final void b(boolean isOidb, int code, boolean isSuccess) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        if (isOidb) {
            str = "2";
        } else {
            str = "1";
        }
        hashMap.put("api_type", str);
        if (isSuccess) {
            str2 = "true";
        } else {
            str2 = "false";
        }
        hashMap.put("result_type", str2);
        hashMap.put("code", String.valueOf(code));
        com.tencent.mobileqq.inject.v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "WebQuickAuthFinish", hashMap);
    }
}
