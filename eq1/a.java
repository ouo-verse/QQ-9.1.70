package eq1;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.guild.jump.api.IJumpParserApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a implements IJumpParserApi.b {

    /* renamed from: a, reason: collision with root package name */
    private final BaseQQAppInterface f396990a;

    /* renamed from: b, reason: collision with root package name */
    private final IJumpParserApi.a f396991b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f396992c;

    /* renamed from: d, reason: collision with root package name */
    private final String f396993d;

    /* renamed from: e, reason: collision with root package name */
    private final String f396994e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, String> f396995f;

    public a(BaseQQAppInterface baseQQAppInterface, Context context, JumpParserResult jumpParserResult, IJumpParserApi.a aVar) {
        this.f396990a = baseQQAppInterface;
        this.f396992c = context;
        this.f396993d = jumpParserResult.getAction();
        this.f396994e = jumpParserResult.getServer();
        this.f396995f = jumpParserResult.getParamMap();
        this.f396991b = aVar;
    }

    @Override // com.tencent.mobileqq.guild.jump.api.IJumpParserApi.b
    public boolean a() {
        String str;
        QLog.i("Guild.jump.GuildRobotJumpAction", 1, "doAction: action=" + this.f396993d);
        if (TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION.equals(this.f396993d)) {
            String str2 = null;
            if (this.f396995f.containsKey("gc")) {
                str = this.f396995f.get("gc");
            } else {
                str = null;
            }
            if (this.f396995f.containsKey("robot_uin")) {
                str2 = this.f396995f.get("robot_uin");
            }
            if (str != null && str2 != null) {
                ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).jumpPermissionSettingPage(this.f396990a, BaseApplication.getContext(), str2, str);
            }
        }
        return true;
    }
}
