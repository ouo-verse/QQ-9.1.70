package co;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import ho.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lco/a;", "Lbo/a;", "", "c", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends bo.a {
    @Override // bo.a
    public void b(Context context, QZoneSchemeBean schemeBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        if (schemeBean.getAttrs() != null && !schemeBean.getAttrs().isEmpty()) {
            String str = schemeBean.getAttrs().get("albumid");
            String str2 = schemeBean.getAttrs().get("lloc");
            String str3 = schemeBean.getAttrs().get("srcurl");
            String str4 = schemeBean.getAttrs().get("taskid");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str4)) {
                QZoneRepairTaskStateBean qZoneRepairTaskStateBean = new QZoneRepairTaskStateBean(null, 1, null);
                Intrinsics.checkNotNull(str4);
                qZoneRepairTaskStateBean.setTaskId(str4);
                Intrinsics.checkNotNull(str);
                qZoneRepairTaskStateBean.setAlbumId(str);
                Intrinsics.checkNotNull(str2);
                qZoneRepairTaskStateBean.setLloc(str2);
                Intrinsics.checkNotNull(str3);
                qZoneRepairTaskStateBean.setSrOriginUrl(str3);
                ArrayList<PhotoInfo> arrayList = new ArrayList<>();
                PhotoInfo photoInfo = new PhotoInfo();
                photoInfo.albumId = qZoneRepairTaskStateBean.getAlbumId();
                photoInfo.lloc = qZoneRepairTaskStateBean.getLloc();
                photoInfo.currentUrl = qZoneRepairTaskStateBean.getSrOriginUrl();
                arrayList.add(photoInfo);
                PhotoParam photoParam = new PhotoParam();
                photoParam.albumid = qZoneRepairTaskStateBean.getAlbumId();
                photoParam.ownerUin = LoginData.getInstance().getUin();
                bo.b bVar = (bo.b) i.t(bo.b.class);
                wn.c cVar = new wn.c();
                cVar.h(photoParam);
                cVar.n(qZoneRepairTaskStateBean);
                cVar.o(arrayList);
                cVar.m(6);
                Unit unit = Unit.INSTANCE;
                bVar.a(context, cVar);
                return;
            }
            QLog.e(c(), 1, "[parseSchemeInner] albumId:" + str + ", lloc" + str2 + ", srcUrl:" + str3 + ", taskId:" + str4);
            return;
        }
        QLog.e(c(), 1, "[parseSchemeInner] attrs:" + schemeBean.getAttrs());
    }

    protected String c() {
        return "QZonePhotoRepairLayerPageParser";
    }
}
