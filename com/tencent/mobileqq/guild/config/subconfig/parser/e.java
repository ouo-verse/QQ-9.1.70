package com.tencent.mobileqq.guild.config.subconfig.parser;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/e;", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/a;", "", "content", "Ltg1/a;", "parse", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements a {
    @Override // com.tencent.mobileqq.guild.config.subconfig.parser.a
    @Nullable
    public tg1.a parse(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        JSONObject jSONObject = new JSONObject(content);
        if (jSONObject.has("pushNotificationReport")) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildNotificationReportConfigParser", 2, "content: " + content);
            }
            return new GuildNotificationReportBean(jSONObject.optBoolean("pushNotificationReport", true));
        }
        return null;
    }
}
