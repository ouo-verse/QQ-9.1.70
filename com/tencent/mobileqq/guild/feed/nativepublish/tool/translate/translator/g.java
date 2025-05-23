package com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/g;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;", "Lorg/json/JSONObject;", "publishJson", "Lnm1/b;", "translateInfo", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g implements e {
    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e
    public void a(@NotNull JSONObject publishJson, @NotNull nm1.b translateInfo) {
        zl1.a aVar;
        Intrinsics.checkNotNullParameter(publishJson, "publishJson");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        com.tencent.base.api.runtime.a<zl1.a> a16 = translateInfo.a();
        if (a16 != null) {
            aVar = a16.h();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sceneType", aVar.getSceneType());
        jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, aVar.m());
        jSONObject.put("originJsonFeed", aVar.getJsonFeed());
        Unit unit = Unit.INSTANCE;
        publishJson.put("publishExtra", jSONObject);
        publishJson.put("client_task_id", aVar.m());
    }
}
