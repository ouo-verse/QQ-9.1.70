package com.tencent.mobileqq.troop.opensdkhandler;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/opensdkhandler/e;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final e f298082d = new e();

    e() {
        super("BindGroupIPCModule");
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        boolean equals$default;
        boolean equals$default2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i3 = 0;
        equals$default = StringsKt__StringsJVMKt.equals$default(action, "getGuildData", false, 2, null);
        if (!equals$default) {
            equals$default2 = StringsKt__StringsJVMKt.equals$default(action, "callbackToGame", false, 2, null);
            if (equals$default2) {
                if (params != null) {
                    str = params.getString("appId");
                } else {
                    str = null;
                }
                if (params != null) {
                    str2 = params.getString("guildId");
                } else {
                    str2 = null;
                }
                if (params != null) {
                    i3 = params.getInt("code", 0);
                }
                String str6 = "";
                if (params != null) {
                    str3 = params.getString("msg", "");
                } else {
                    str3 = null;
                }
                if (str3 != null) {
                    str6 = str3;
                }
                d.f298075a.f(str, str2, i3, str6);
            }
        } else {
            if (params != null) {
                str4 = params.getString("app_id");
            } else {
                str4 = null;
            }
            if (params != null) {
                str5 = params.getString("guildId");
            } else {
                str5 = null;
            }
            JSONObject h16 = d.f298075a.h(str4, str5);
            if (h16 == null) {
                h16 = new JSONObject();
            }
            Bundle bundle = new Bundle();
            bundle.putString("guildData", h16.toString());
            callbackResult(callbackId, EIPCResult.createResult(0, bundle));
        }
        return null;
    }
}
