package com.tencent.state.square.chatland.component;

import com.tencent.state.map.Location;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.CommonDataParserKt;
import com.tencent.state.template.data.Decorator;
import com.tencent.state.template.data.RoomConfig;
import com.tencent.state.template.service.VasSquareRoomService;
import fs4.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"/\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000j\u0002`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lkotlin/Function1;", "", "Lfs4/r;", "Lcom/tencent/state/template/data/RoomConfig;", "Lcom/tencent/state/template/data/RoomConfParser;", "ChatLandRoomConfParser", "Lkotlin/jvm/functions/Function1;", "getChatLandRoomConfParser", "()Lkotlin/jvm/functions/Function1;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandRoomComponentKt {
    private static final Function1<r[], RoomConfig> ChatLandRoomConfParser = new Function1<r[], RoomConfig>() { // from class: com.tencent.state.square.chatland.component.ChatLandRoomComponentKt$ChatLandRoomConfParser$1
        @Override // kotlin.jvm.functions.Function1
        public final RoomConfig invoke(r[] confs) {
            r rVar;
            Intrinsics.checkNotNullParameter(confs, "confs");
            int length = confs.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    rVar = null;
                    break;
                }
                rVar = confs[i3];
                if (Intrinsics.areEqual(rVar.f400570a, "room_object")) {
                    break;
                }
                i3++;
            }
            if (rVar == null) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "No TerminalConf has key 'room_object'", null, 4, null);
                return null;
            }
            try {
                byte[] bArr = rVar.f400571b;
                Intrinsics.checkNotNullExpressionValue(bArr, "conf.`val`");
                JSONObject jSONObject = new JSONObject(new String(bArr, Charsets.UTF_8));
                Decorator parseTableDecorator = CommonDataParserKt.parseTableDecorator(jSONObject.optJSONObject("background"));
                Decorator parseTableDecorator2 = CommonDataParserKt.parseTableDecorator(jSONObject.optJSONObject("refresh_panel"));
                Location parseThemePanelConfig = CommonDataParserKt.parseThemePanelConfig(jSONObject.optJSONObject("theme_refresh_panel"));
                Intrinsics.checkNotNull(parseTableDecorator);
                return new RoomConfig(parseTableDecorator.getImage(), CommonDataParserKt.parseConfig(jSONObject), CommonDataParserKt.parseDecorators(jSONObject.optJSONArray("decorator_attatched"), parseTableDecorator.getImage().getSize()), CommonDataParserKt.parseBuildings(jSONObject.optJSONArray("buildings"), parseTableDecorator.getImage().getSize()), null, null, null, null, parseTableDecorator.getLocation(), parseTableDecorator2, parseThemePanelConfig);
            } catch (Throwable th5) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "parse TerminalConf failed: " + th5.getMessage(), null, 4, null);
                return null;
            }
        }
    };

    public static final Function1<r[], RoomConfig> getChatLandRoomConfParser() {
        return ChatLandRoomConfParser;
    }
}
