package com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;", "", "Lorg/json/JSONObject;", "publishJson", "Lnm1/b;", "translateInfo", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements e {
    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e
    public void a(@NotNull JSONObject publishJson, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(publishJson, "publishJson");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        if (translateInfo.a() == null) {
            return;
        }
        zl1.a h16 = translateInfo.a().h();
        Intrinsics.checkNotNullExpressionValue(h16, "translateInfo.baseContext.baseParam");
        if (zl1.b.m(h16)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("guild_id", translateInfo.a().h().h());
        jSONObject2.put("channel_id", translateInfo.a().h().a());
        Unit unit = Unit.INSTANCE;
        jSONObject.put("sign", jSONObject2);
        yl1.i iVar = yl1.i.f450608a;
        zl1.a h17 = translateInfo.a().h();
        Intrinsics.checkNotNullExpressionValue(h17, "translateInfo.baseContext.baseParam");
        jSONObject.put("is_square", iVar.l(zl1.b.l(h17)));
        publishJson.put("channelInfo", jSONObject);
    }
}
