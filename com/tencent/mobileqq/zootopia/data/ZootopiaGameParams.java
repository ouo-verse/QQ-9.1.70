package com.tencent.mobileqq.zootopia.data;

import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B\u00a5\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\tR\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0016\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zootopia/data/ZootopiaGameParams;", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "Ljava/io/Serializable;", "Lorg/json/JSONObject;", "toJsonObject", "", VirtualAppProxy.KEY_GAME_ID, "I", "getGameId", "()I", "", "scriptType", "Ljava/lang/String;", "getScriptType", "()Ljava/lang/String;", "mapType", "getMapType", "runScript", "getRunScript", IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, "getGameTeamParams", "setGameTeamParams", "(Ljava/lang/String;)V", "gameName", "openId", "token", "pakPath", "mapId", "version", "name", "icon", "sceneType", "", "showGameHealthyLoading", "", "", "ueParams", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "loadingParams", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;)V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaGameParams extends ZootopiaEnterParams {
    public static final String SCRIPT_TYPE_LUA = "lua";
    public static final String SCRIPT_TYPE_TS = "ts";
    private final int gameId;
    private String gameTeamParams;
    private final int mapType;
    private final String runScript;
    private final String scriptType;

    public /* synthetic */ ZootopiaGameParams(int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, String str7, String str8, int i17, boolean z16, int i18, String str9, String str10, Map map, ZootopiaMapLoadingParams zootopiaMapLoadingParams, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, str3, str4, str5, i16, str6, str7, str8, i17, z16, i18, str9, (i19 & 16384) != 0 ? "" : str10, (32768 & i19) != 0 ? null : map, (i19 & 65536) != 0 ? null : zootopiaMapLoadingParams);
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final String getGameTeamParams() {
        return this.gameTeamParams;
    }

    public final int getMapType() {
        return this.mapType;
    }

    public final String getRunScript() {
        return this.runScript;
    }

    public final String getScriptType() {
        return this.scriptType;
    }

    public final void setGameTeamParams(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameTeamParams = str;
    }

    @Override // com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams
    public JSONObject toJsonObject() {
        JSONObject jsonObject = super.toJsonObject();
        jsonObject.put("GameId", this.gameId);
        jsonObject.put("GameName", getProjectName());
        jsonObject.put("ScriptType", this.scriptType);
        jsonObject.put(ZootopiaEnterParams.KEY_TOKEN, getAccessToken());
        if (this.gameTeamParams.length() > 0) {
            jsonObject.put(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, this.gameTeamParams);
        }
        jsonObject.put("MapType", this.mapType);
        jsonObject.put("RunScript", this.runScript);
        return jsonObject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaGameParams(int i3, String gameName, String scriptType, String openId, String token, String pakPath, int i16, String version, String name, String icon, int i17, boolean z16, int i18, String runScript, String gameTeamParams, Map<String, ? extends Object> map, ZootopiaMapLoadingParams zootopiaMapLoadingParams) {
        super(7, ZootopiaEnterParams.ZPLAN_APP_ID, openId, token, pakPath, i16, version, name, gameName, icon, i17, z16, map, false, null, zootopiaMapLoadingParams, null, null, null, 0L, null, null, 4153344, null);
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        Intrinsics.checkNotNullParameter(scriptType, "scriptType");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(pakPath, "pakPath");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(runScript, "runScript");
        Intrinsics.checkNotNullParameter(gameTeamParams, "gameTeamParams");
        this.gameId = i3;
        this.scriptType = scriptType;
        this.mapType = i18;
        this.runScript = runScript;
        this.gameTeamParams = gameTeamParams;
    }
}
