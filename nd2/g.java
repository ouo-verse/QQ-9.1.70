package nd2;

import com.tencent.mobileqq.data.entitymanager.FindTableNameInterceptorChain;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.util.ArrayUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g extends j {

    /* renamed from: a, reason: collision with root package name */
    static final String[] f419966a = {"WhiteListItem", "TroopAIOCommonAppInfo", "TroopVideoUrlEntity", "FreshNewsInfo", "GodListConfig", "GodEntity", "DatingSig", "DatingFeedInfo", "OpenTroopInfo", "TroopStorySnapListEntity", "SearchHistoryEntity", "TroopTopicDetailInfo", "MiniAppInfo", "QZoneMsgEntityNew", "TroopMemberInfo", "ShowExternalTroop", "CommonlyUsedTroop", TroopInfo.TAG, "TroopInfoExt", "MatchFriendData", "DesktopCardEntity", "NotificationRecommendTroopItem"};

    private boolean c(String str, int i3) {
        if (str.startsWith("RedPacketData_") && i3 < 214) {
            return true;
        }
        return ArrayUtils.contains(f419966a, str);
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        FindTableNameInterceptorChain findTableNameInterceptorChain = (FindTableNameInterceptorChain) chain;
        String a16 = a(chain);
        if (c(a16, findTableNameInterceptorChain.oldVersion)) {
            findTableNameInterceptorChain.f203156db.execSQL(TableBuilder.dropSQLStatement(a16));
            return null;
        }
        return chain.proceed();
    }
}
