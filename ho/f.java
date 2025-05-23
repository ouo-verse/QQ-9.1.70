package ho;

import android.content.Context;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lho/f;", "Lho/b;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends b {
    @Override // ho.b
    public boolean a(Context context, QZoneSchemeBean schemeBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        if (schemeBean.getAttrs() == null) {
            QLog.e("QZoneMoodListNativeLauncher", 1, "parseScheme  schemeBean == null");
            return false;
        }
        long j3 = 0;
        try {
            String str = schemeBean.getAttrs().get("uin");
            if (str != null) {
                j3 = Long.parseLong(str);
            }
        } catch (Exception e16) {
            QLog.e("QZoneMoodListNativeLauncher", 1, "exception is " + e16);
        }
        String str2 = schemeBean.getAttrs().get("nickname");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = schemeBean.getAttrs().get("refer");
        String str4 = str3 != null ? str3 : "";
        String str5 = schemeBean.getAttrs().get("bottomtext");
        String str6 = schemeBean.getAttrs().get("bottomurl");
        String str7 = schemeBean.getAttrs().get("bottomicon");
        String str8 = schemeBean.getAttrs().get("praisebubble");
        QZoneMoodListInitBean qZoneMoodListInitBean = new QZoneMoodListInitBean(j3, str2, str4);
        if (str5 != null) {
            qZoneMoodListInitBean.g(str5);
        }
        if (str6 != null) {
            qZoneMoodListInitBean.j(str6);
        }
        if (str7 != null) {
            qZoneMoodListInitBean.f(str7);
        }
        if (str8 != null) {
            qZoneMoodListInitBean.k(str8);
        }
        i.j().b(context, qZoneMoodListInitBean);
        return true;
    }
}
