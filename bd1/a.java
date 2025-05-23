package bd1;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public int f28282d;

    @SerializedName("gameMsgListUrl")
    public String mGameMsgListUrl = IGameMsgHelperApi.SESSION_URL;

    @SerializedName("gameMsgSettingUrl")
    public String mGameMsgSettingUrl = IGameMsgHelperApi.SESSION_SETTING_URL;

    @SerializedName("gamePrefix")
    public String mPrefix = IGameMsgHelperApi.PREFIX;

    @SerializedName("playerInfoUrl")
    public String mPlayerInfoUrl = "";

    public String toString() {
        return "GameCenterMsgBean{mGameMsgListUrl='" + this.mGameMsgListUrl + "', mGameMsgSettingUrl='" + this.mGameMsgSettingUrl + "', mPrefix='" + this.mPrefix + "', mPlayerInfoUrl='" + this.mPlayerInfoUrl + "', mScreenRecordEnabled=" + this.f28282d + '}';
    }
}
