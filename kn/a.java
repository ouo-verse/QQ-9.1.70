package kn;

import android.content.Context;
import com.qzone.reborn.qzmoment.bean.QZMFeedDetailInitBean;
import com.qzone.reborn.qzmoment.bean.QZMFolderInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import ho.i;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends jn.a {
    /* JADX WARN: Removed duplicated region for block: B:13:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // jn.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, QZoneSchemeBean qZoneSchemeBean) {
        long parseLong;
        String str;
        Integer valueOf;
        QZMFeedDetailInitBean qZMFeedDetailInitBean;
        if (qZoneSchemeBean.getAttrs() == null) {
            return;
        }
        String str2 = qZoneSchemeBean.getAttrs().get("id");
        String str3 = qZoneSchemeBean.getAttrs().get("posterId");
        String str4 = qZoneSchemeBean.getAttrs().get("popup");
        String str5 = qZoneSchemeBean.getAttrs().get(WadlProxyConsts.CREATE_TIME);
        if (str5 != null) {
            try {
                parseLong = Long.parseLong(str5);
            } catch (NumberFormatException e16) {
                QLog.e("QZMFeedDetailPageParser", 1, "parseScheme  e = " + e16.getMessage());
            }
            str = qZoneSchemeBean.getAttrs().get("needBackToMomentFeedsPage");
            if (str != null) {
                try {
                    valueOf = Integer.valueOf(Integer.parseInt(str));
                } catch (NumberFormatException e17) {
                    QLog.e("QZMFeedDetailPageParser", 1, "parseScheme  e = " + e17.getMessage());
                }
                qZMFeedDetailInitBean = new QZMFeedDetailInitBean(str2, str3, Long.valueOf(parseLong), str4);
                if (valueOf == null && valueOf.intValue() == 1) {
                    QZMFolderInitBean qZMFolderInitBean = new QZMFolderInitBean();
                    qZMFolderInitBean.setIsNeedToJumpFeedDetailPage(true);
                    qZMFolderInitBean.setFeedDetailInitBean(qZMFeedDetailInitBean);
                    ((jn.b) i.t(jn.b.class)).b(context, qZMFolderInitBean);
                    return;
                }
                ((jn.b) i.t(jn.b.class)).a(context, qZMFeedDetailInitBean);
            }
            valueOf = null;
            qZMFeedDetailInitBean = new QZMFeedDetailInitBean(str2, str3, Long.valueOf(parseLong), str4);
            if (valueOf == null) {
            }
            ((jn.b) i.t(jn.b.class)).a(context, qZMFeedDetailInitBean);
        }
        parseLong = 0;
        str = qZoneSchemeBean.getAttrs().get("needBackToMomentFeedsPage");
        if (str != null) {
        }
        valueOf = null;
        qZMFeedDetailInitBean = new QZMFeedDetailInitBean(str2, str3, Long.valueOf(parseLong), str4);
        if (valueOf == null) {
        }
        ((jn.b) i.t(jn.b.class)).a(context, qZMFeedDetailInitBean);
    }
}
