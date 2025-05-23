package l23;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Ll23/b;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "k", "", "v", "()J", "resId", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends BaseLebaPluginItem {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"l23/b$a", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "g", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends DefaultClickProcessor {
        a() {
        }

        @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
        public void g(@NotNull Activity activity, @NotNull DefaultClickProcessor.a item) {
            String str;
            PBStringField pBStringField;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(item, "item");
            if (item.d()) {
                IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IR\u2026AIN\n                    )");
                BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) runtimeService).getAppInfoByPath(String.valueOf(b.this.v()));
                if (appInfoByPath != null && (pBStringField = appInfoByPath.buffer) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String link = new JSONObject(new JSONObject(jSONObject.optString("msg")).optString(jSONObject.optString("_show_mission"))).optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                        IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
                        Intrinsics.checkNotNullExpressionValue(link, "link");
                        iVasHybridRoute.openSchema(activity, link);
                        return;
                    } catch (Exception e16) {
                        QLog.e("LebaPluginQQReader", 1, e16, new Object[0]);
                    }
                }
            }
            super.g(activity, item);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public DefaultClickProcessor k() {
        return new a();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        return 769L;
    }
}
