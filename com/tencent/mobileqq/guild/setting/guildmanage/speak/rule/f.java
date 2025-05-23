package com.tencent.mobileqq.guild.setting.guildmanage.speak.rule;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J*\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/f;", "", "", "gId", "", "atAllNum", "atOnlineNum", "atRoleNum", "", "d", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f234307a = new f();

    f() {
    }

    @JvmStatic
    public static final boolean b(@Nullable String gId, int atAllNum, int atOnlineNum, int atRoleNum) {
        boolean d16 = d(gId, atAllNum, atOnlineNum, atRoleNum);
        if (d16) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.c();
                }
            });
        }
        return d16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptAtSendToast();
    }

    @JvmStatic
    public static final boolean d(@Nullable String gId, int atAllNum, int atOnlineNum, int atRoleNum) {
        String atRemainNum = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getAtRemainNum(gId);
        if (!Intrinsics.areEqual(atRemainNum, "")) {
            JSONObject jSONObject = new JSONObject(atRemainNum);
            if (atAllNum + atRoleNum + atOnlineNum > 0 && jSONObject.optInt("atNotifyNum", 3) == 0) {
                return true;
            }
        }
        return false;
    }
}
