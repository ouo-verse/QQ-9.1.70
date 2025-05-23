package com.tencent.zplan.luabridge.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import zx4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/h;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleGotoLink", "<init>", "()V", "e", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class h extends LuaBasePlugin {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f385739d = "UrlPlugin";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/h$a;", "", "", "TAG", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.luabridge.plugins.h$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final String a() {
            return h.f385739d;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @LuaEvent("L2N_GotoLink")
    @Nullable
    public final String handleGotoLink(@NotNull LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (TextUtils.isEmpty(argument.getParams())) {
            ZLog.f386189b.d(f385739d, 1, "L2N_GotoLink params empty");
            return argument.fail();
        }
        String link = new JSONObject(argument.getParams()).optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
        if (TextUtils.isEmpty(link)) {
            ZLog.f386189b.d(f385739d, 1, "L2N_GotoLink link empty");
            return argument.fail();
        }
        ZLog.f386189b.i(f385739d, 1, "L2N_GotoLink " + link);
        u uVar = (u) mx4.a.f417748a.a(u.class);
        if (uVar != null) {
            Intrinsics.checkNotNullExpressionValue(link, "link");
            uVar.openUrl(link);
        }
        return argument.ok();
    }
}
