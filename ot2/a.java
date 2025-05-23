package ot2;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopNotificationRepoApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lot2/a;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends ax {
    public a(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0018, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        Integer intOrNull;
        Integer intOrNull2;
        Intent intent = new Intent();
        intent.addFlags(67108864);
        String str = this.f307441f.get("tab");
        int intValue = (str == null || intOrNull2 == null) ? 0 : intOrNull2.intValue();
        intent.putExtra("tab", intValue);
        String str2 = this.f307441f.get("key_from");
        int intValue2 = (str2 == null || intOrNull == null) ? 0 : intOrNull.intValue();
        intent.putExtra("key_from", intValue2);
        String str3 = this.f307441f.get(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE);
        if (str3 == null) {
            str3 = "";
        }
        intent.putExtra(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, str3);
        int notificationUnreadCount = ((ITroopNotificationRepoApi) QRoute.api(ITroopNotificationRepoApi.class)).getNotificationUnreadCount();
        intent.putExtra(ILaunchTroopSysMsgUIUtilApi.KEY_HAS_RED, notificationUnreadCount > 0);
        QLog.i("TroopNotificationJumpAction", 1, "[doAction]  unReadCount = " + notificationUnreadCount + " extras = " + intent.getExtras());
        ((ILaunchTroopSysMsgUIUtilApi) QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).launchTroopNotificationFragment(intent);
        return true;
    }
}
