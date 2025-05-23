package com.tencent.timi.game.liveroom.impl.room.medal.supplier;

import android.text.TextUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.ark.ark;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.widget.chat.message.f;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.medal.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sr4.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/supplier/b;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/supplier/BaseMsgMedalInfoSupplier;", "", "uid", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "giftMessage", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", h.F, "", ark.ARKMETADATA_JSON, "", "Lsr4/g;", "k", "Lorg/json/JSONObject;", "medalInfoJson", "i", "Lsr4/g$a;", "j", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "Lcom/tencent/timi/game/liveroom/impl/room/medal/e$a;", "callback", "", "a", "roomId", "", "roomType", "appId", "<init>", "(JILjava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b extends BaseMsgMedalInfoSupplier {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(long j3, int i3, @NotNull String appId) {
        super(j3, i3, appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
    }

    private final com.tencent.mobileqq.qqlive.widget.chat.data.b h(long uid, GiftMessage giftMessage) {
        if (TextUtils.isEmpty(giftMessage.liveExtMsg)) {
            AegisLogger.INSTANCE.d(e(), "getMedalInfoFromMsg", "giftMessage.liveExtMsg is empty");
            return null;
        }
        com.tencent.mobileqq.qqlive.widget.chat.data.b bVar = new com.tencent.mobileqq.qqlive.widget.chat.data.b();
        bVar.f273756a = uid;
        String str = giftMessage.liveExtMsg;
        Intrinsics.checkNotNullExpressionValue(str, "giftMessage.liveExtMsg");
        bVar.f273762g = k(str);
        return bVar;
    }

    private final g i(JSONObject medalInfoJson) {
        g gVar = new g();
        gVar.f434385a = medalInfoJson.optInt("medal_id");
        gVar.f434386b = medalInfoJson.optString("medal_name");
        gVar.f434387c = medalInfoJson.optString("medal_face_small");
        gVar.f434388d = medalInfoJson.optInt("medal_type");
        gVar.f434389e = medalInfoJson.optLong("medal_start_time");
        gVar.f434390f = medalInfoJson.optLong("medal_end_time");
        gVar.f434391g = medalInfoJson.optInt("medal_priority_level");
        gVar.f434392h = medalInfoJson.optString("medal_desc");
        gVar.f434393i = medalInfoJson.optString("medal_url");
        gVar.f434394j = medalInfoJson.optString("medal_face_bigger");
        gVar.f434395k = medalInfoJson.optInt("medal_version");
        gVar.f434396l = medalInfoJson.optInt("medal_index");
        gVar.f434397m = medalInfoJson.optInt("medal_level");
        gVar.f434398n = medalInfoJson.optInt("medal_point");
        gVar.f434399o = medalInfoJson.optLong(AlbumCacheData.CREATE_TIME);
        gVar.f434400p = medalInfoJson.optLong("update_time");
        gVar.f434401q = medalInfoJson.optInt("medal_bg");
        gVar.f434402r = medalInfoJson.optInt("medal_frame");
        gVar.f434403s = medalInfoJson.optString("medal_bg_img");
        gVar.f434404t = medalInfoJson.optLong("medal_uid");
        gVar.f434405u = medalInfoJson.optString("user_nick");
        gVar.f434406v = medalInfoJson.optString("logo_full_url");
        gVar.f434407w = medalInfoJson.optString("fans_medal_bg_img_style");
        gVar.f434408z = medalInfoJson.optString("diamond_medal_bg_img");
        gVar.B = j(medalInfoJson.getJSONObject("layout_style"));
        return gVar;
    }

    private final g.a j(JSONObject json) {
        if (json == null) {
            return null;
        }
        try {
            g.a aVar = new g.a();
            aVar.f434409a = json.optString("id");
            aVar.f434410b = json.optString("bg_img");
            Object[] array = com.tencent.mobileqq.perf.process.config.g.a(json, MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            aVar.f434411c = (String[]) array;
            return aVar;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e(e(), "parseLayoutStyle", "parse error,msg:" + e16.getMessage());
            return null;
        }
    }

    private final List<g> k(String json) {
        List<g> emptyList;
        List<g> emptyList2;
        try {
            JSONArray optJSONArray = new JSONObject(json).optJSONArray("medal_info");
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i(e(), "parseLiveExtMsg", "medalInfoJsonArr=" + optJSONArray);
            }
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        arrayList.add(i(optJSONObject));
                    }
                }
                return arrayList;
            }
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        } catch (JSONException e16) {
            AegisLogger.INSTANCE.e(e(), "parseLiveExtMsg", "parse json error, json=" + json, e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.e
    public void a(@NotNull f msg2, @NotNull e.a callback) {
        List<g> list;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.d)) {
            AegisLogger.INSTANCE.i(e(), "getMedalInfoAsync", "not GiftScreenMsg=" + msg2);
            callback.a(msg2, null);
            return;
        }
        com.tencent.mobileqq.qqlive.widget.chat.message.d dVar = (com.tencent.mobileqq.qqlive.widget.chat.message.d) msg2;
        long j3 = dVar.b().sender;
        com.tencent.mobileqq.qqlive.widget.chat.data.b h16 = h(j3, dVar.b());
        boolean z16 = false;
        if (h16 != null && (list = h16.f273762g) != null && (!list.isEmpty())) {
            z16 = true;
        }
        if (z16) {
            g(msg2, h16);
            callback.a(msg2, h16);
        } else {
            c(j3, msg2, callback);
        }
    }
}
