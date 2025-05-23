package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.business.ap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private static String f202522a = "open_connect_virtual_account_config";

    public static ap a() {
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        if (!iUnitedConfigManager.isSwitchOn(f202522a, true)) {
            QLog.i("OpenSdkRandomProcessor", 1, "loadConfig switchOn: false");
            return new ap();
        }
        String loadAsString = iUnitedConfigManager.loadAsString(f202522a, "");
        if (loadAsString == null || loadAsString.isEmpty()) {
            QLog.e("OpenSdkRandomProcessor", 1, "loadConfig configContent is null or empty");
            loadAsString = "\n   {\n\t\"random_list\": [{\n\t\t\t\"nick\": \"\u535a\u58eb\",\n\t\t\t\"headid\":\"1001_7811637de55f8b6e06759692767bf3c1\",\n\t\t\t\"url\": \"https://thirdqq.qlogo.cn/bqqthird?key=ralGotSn72RTzARgBJvAbia2Bmf4Me46Ng2uNIVg1YiajngAaGBI2ZdoNTP1HuicibZWjDNLW8hREM5VO8YNzqSyaZiaQibmQ9u3HT&s=0\"\n\t\t},\n\t\t{\n\t\t\t\"nick\": \"\u706b\u72d0\u72f8\",\n\t\t\t\"headid\":\"1001_d02a8a5fa9d48fafa3cece21712c57fb\",\n\t\t\t\"url\": \"https://thirdqq.qlogo.cn/bqqthird?key=ralGotSn72RTzARgBJvAbia2Bmf4Me46Ng2uNIVg1YiahFzyicmWzP0SywdJd6NWeiaKDibhHXtAxdvrSeWOgLO27LjXicWOnxMmKM&s=0\"\n\t\t},\n\t\t{\n\t\t\t\"nick\": \"\u80d6\u80d6\",\n\t\t\t\"headid\":\"1001_588b6f2744040ca8088523892be24b72\",\n\t\t\t\"url\": \"https://thirdqq.qlogo.cn/bqqthird?key=ralGotSn72RTzARgBJvAbia2Bmf4Me46Ng2uNIVg1Yiag4EeeGxoqic1icK8zxDdwpH3NnhVJicWNhgpLqicBZmr4WA83I10VVZsEy&s=0\"\n\t\t},\n\t\t{\n\t\t\t\"nick\": \"\u52ff\u5fd8\u6211\",\n\t\t\t\"headid\":\"1001_8d4e9b2607f824d3855317afd17907ef\",\n\t\t\t\"url\": \"https://thirdqq.qlogo.cn/bqqthird?key=ralGotSn72RTzARgBJvAbia2Bmf4Me46Ng2uNIVg1Yiaia4JxnB73Rd4UZ6iaRxfkQjbPOuI4MwRdZoBpcGyQGyXVWRrV3gjTNEo&s=0\"\n\t\t},\n\t\t{\n\t\t\t\"nick\": \"\u85b0\u8863\u8349\",\n\t\t\t\"headid\":\"1001_ce209bb943e5d560ea94e4a0274ea6ee\",\n\t\t\t\"url\": \"https://thirdqq.qlogo.cn/bqqthird?key=ralGotSn72RTzARgBJvAbia2Bmf4Me46Ng2uNIVg1YiahUrx2aHxEbHOg9WsEdyH1zwZbT02A1GHw7ZZqlDdpGNxfMdWPm95dJ&s=0\"\n\t\t},\n\t\t{\n\t\t\t\"nick\": \"\u8ffd\u98ce\u5c11\u5e74\",\n\t\t\t\"headid\":\"1001_637ce3965d644875ec1d134360d63dc4\",\n\t\t\t\"url\": \"https://thirdqq.qlogo.cn/bqqthird?key=ralGotSn72RTzARgBJvAbia2Bmf4Me46Ng2uNIVg1YiaiafKseoLichoia8Owzd2bTC1b9O9icZfaYX7t82bSoItrbFAstSgFUwwkC&s=0\"\n\t\t},\n\t\t{\n\t\t\t\"nick\": \"\u5471\u5471\",\n\t\t\t\"headid\":\"1001_cc35254957a78908cd1f49f2a819e810\",\n\t\t\t\"url\": \"https://thirdqq.qlogo.cn/bqqthird?key=ralGotSn72RTzARgBJvAbia2Bmf4Me46Ng2uNIVg1YiahujicJagPX5XHWdjuVO2icjyIWVVDcU5EpBRIzfOloGNDMGS2N3ib8Bjc&s=0\"\n\t\t},\n\t\t{\n\t\t\t\"nick\": \"QQ\u5c11\u5e74\",\n\t\t\t\"headid\":\"1001_48a39250363bcb56f48fa77a063cb162\",\n\t\t\t\"url\": \"https://thirdqq.qlogo.cn/bqqthird?key=ralGotSn72RTzARgBJvAbia2Bmf4Me46Ng2uNIVg1YiahGsdcR6pPibnte6SL5QULBcyUjrW37MBSHCibLK1R2qFuoR54QGQV6Bf&s=0\"\n\t\t},\n\t\t{\n\t\t\t\"nick\": \"\u5c0f\u9ec4\u9c7c\",\n\t\t\t\"headid\":\"1001_3c7e743372525cdd8a41b175233cd3a8\",\n\t\t\t\"url\": \"https://thirdqq.qlogo.cn/bqqthird?key=ralGotSn72RTzARgBJvAbia2Bmf4Me46Ng2uNIVg1YiahU0TWEo3ribY84wwRIAuUAfibclibyxy1u2OVKZWaVWukAMP6nmiam27He&s=0\"\n\t\t},\n\t\t{\n\t\t\t\"nick\": \"\u96c5\u5178\u5a1c\",\n\t\t\t\"headid\":\"1001_80818afad8378f74bf7066462f3142a4\",\n\t\t\t\"url\": \"https://thirdqq.qlogo.cn/bqqthird?key=ralGotSn72RTzARgBJvAbia2Bmf4Me46Ng2uNIVg1YiahosKPsmVBIYVH5xwxEjFsibIK4urdicpR9Ne1UO0lL0e4BuFzUlpYsZ7&s=0\"\n\t\t}\n\t]\n}\n";
        }
        try {
            ap.a aVar = new ap.a();
            aVar.onParse(loadAsString);
            ap apVar = new ap(loadAsString, aVar);
            QLog.i("OpenSdkRandomProcessor", 2, "loadConfig config: " + aVar);
            return apVar;
        } catch (Exception e16) {
            QLog.e("OpenSdkRandomProcessor", 1, "loadConfig exception: ", e16);
            return new ap();
        }
    }
}
