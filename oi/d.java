package oi;

import android.content.Context;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Loi/d;", "Lho/b;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends ho.b {

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, a> f422693b;

    static {
        HashMap<String, a> hashMap = new HashMap<>();
        hashMap.put("homealbum", new pi.c());
        hashMap.put("albumdetail", new pi.a());
        hashMap.put("feeddetail", new pi.b());
        hashMap.put(UinConfigManager.KEY_ADS, new pi.d());
        f422693b = hashMap;
    }

    @Override // ho.b
    public boolean a(Context context, QZoneSchemeBean schemeBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        String pageAction = schemeBean.getPageAction();
        if (pageAction == null || pageAction.length() == 0) {
            QLog.e("GroupAlbumSchemeLauncher", 1, "parseScheme  scheme pageAction == null");
            return false;
        }
        a aVar = f422693b.get(schemeBean.getPageAction());
        if (aVar != null) {
            aVar.a(context, schemeBean);
            return true;
        }
        QLog.e("GroupAlbumSchemeLauncher", 1, "parseScheme  scheme pageAction = " + schemeBean.getPageAction() + " , not find parser in sSchemeParserMap, please register map");
        return false;
    }
}
