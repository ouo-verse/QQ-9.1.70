package dh;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.reborn.util.i;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qzone.qzoneReddotMeta$ReddotInfo;
import qzone.qzoneReddotMeta$ReddotList;
import qzone.qzoneReddotMeta$StCount;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020 H\u0002J2\u0010*\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000f0'\u0018\u00010&j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000f0'\u0018\u0001`)J2\u0010+\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000f0'\u0018\u00010&j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000f0'\u0018\u0001`)J2\u0010,\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000f0'\u0018\u00010&j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000f0'\u0018\u0001`)J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\b\u00100\u001a\u0004\u0018\u00010\u0002J\b\u00101\u001a\u0004\u0018\u00010\u0002J\u0006\u00102\u001a\u00020\u0007J\u0006\u00103\u001a\u00020\u0007J\u0006\u00104\u001a\u00020\u0007J\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rJ\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rJ\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rJ\u0006\u00108\u001a\u00020\u0013J\u0006\u00109\u001a\u00020\u0013J\u0006\u0010:\u001a\u00020\u0007J\u0006\u0010;\u001a\u00020\u0007J\u0010\u0010=\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010\u0002J\u0010\u0010>\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010\u0002\u00a8\u0006A"}, d2 = {"Ldh/d;", "", "Ldh/c;", "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "id", "", "c", "b", "passiveTotalNum", "numShouldClear", "O", "", DomainData.DOMAIN_NAME, "", "path", "redDotId", "B", "", "K", "J", "G", "I", "H", "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", BdhLogUtil.LogTag.Tag_Conn, "k", "g", "j", "f", "o", "", "version", "L", "M", WidgetCacheConstellationData.INTERVAL, "N", "Ljava/util/ArrayList;", "Lcom/tencent/util/Pair;", "Lcooperation/qzone/UndealCount/QZoneCountUserInfo;", "Lkotlin/collections/ArrayList;", "r", "w", "t", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "u", "d", "e", "a", ReportConstant.COSTREPORT_PREFIX, "y", "v", "E", UserInfo.SEX_FEMALE, "i", h.F, "redCountInfoBean", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f393812a = new d();

    d() {
    }

    private final c A() {
        return B(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN, 3);
    }

    private final c B(String path, int redDotId) {
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        int i3;
        Object obj;
        qzoneReddotMeta$StCount qzonereddotmeta_stcount;
        PBUInt32Field pBUInt32Field;
        qzoneReddotMeta$StCount qzonereddotmeta_stcount2;
        PBInt64Field pBInt64Field;
        IRedTouchManager C = C();
        if (C == null || (appInfoByPath = C.getAppInfoByPath(path)) == null || appInfoByPath.iNewFlag.get() == 0) {
            return null;
        }
        try {
            List<qzoneReddotMeta$ReddotInfo> list = new qzoneReddotMeta$ReddotList().mergeFrom(appInfoByPath.busi_data.get().toByteArray()).reddot_infos.get();
            Intrinsics.checkNotNullExpressionValue(list, "redDotInfoList.reddot_infos.get()");
            Iterator<T> it = list.iterator();
            while (true) {
                i3 = 0;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((qzoneReddotMeta$ReddotInfo) obj).reddot_id.get() == redDotId) {
                    break;
                }
            }
            qzoneReddotMeta$ReddotInfo qzonereddotmeta_reddotinfo = (qzoneReddotMeta$ReddotInfo) obj;
            long j3 = (qzonereddotmeta_reddotinfo == null || (qzonereddotmeta_stcount2 = qzonereddotmeta_reddotinfo.count) == null || (pBInt64Field = qzonereddotmeta_stcount2.create_time) == null) ? 0L : pBInt64Field.get();
            if (qzonereddotmeta_reddotinfo != null && (qzonereddotmeta_stcount = qzonereddotmeta_reddotinfo.count) != null && (pBUInt32Field = qzonereddotmeta_stcount.count) != null) {
                i3 = pBUInt32Field.get();
            }
            QLog.i("QZoneRedCountInfoManager", 2, "red dot id is " + redDotId + ", create time is " + j3 + ", count is " + i3);
            if (qzonereddotmeta_reddotinfo != null) {
                return b.h(qzonereddotmeta_reddotinfo, qzonereddotmeta_reddotinfo.count.create_time.get());
            }
            return null;
        } catch (Exception e16) {
            QLog.e("QZoneRedCountInfoManager", 1, "exception is " + e16);
            return null;
        }
    }

    private final IRedTouchManager C() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    }

    private final boolean G() {
        c u16 = u();
        return (u16 != null ? u16.getCount() : 0) > 0;
    }

    private final boolean H() {
        return z() > 0;
    }

    private final boolean I() {
        c A = A();
        return (A != null ? A.getCount() : 0) > 0;
    }

    private final boolean J(int redDotId) {
        if (redDotId == 1 || redDotId == 4) {
            return true;
        }
        return false;
    }

    private final boolean K(int redDotId) {
        if (redDotId > 0) {
            return true;
        }
        return false;
    }

    private final void L(long version) {
        QLog.i("QZoneRedCountInfoManager", 2, "active top message banner show interval is " + version);
        i.b().p("KEY_TOP_MESSAGE_BANNER_ACTIVE_SHOW_VERSION", version);
    }

    private final void M(long version) {
        QLog.i("QZoneRedCountInfoManager", 2, "passive top message banner show interval is " + version);
        i.b().p("KEY_TOP_MESSAGE_BANNER_PASSIVE_SHOW_VERSION", version);
    }

    private final void N(long interval) {
        QLog.i("QZoneRedCountInfoManager", 2, "top message banner show interval is " + interval);
        i.b().p("KEY_TOP_MESSAGE_BANNER_SHOW_INTERVAL", interval);
    }

    private final void O(int passiveTotalNum, int numShouldClear) {
        IRedTouchManager C = C();
        if (C == null) {
            return;
        }
        if (numShouldClear <= 0) {
            QLog.i("QZoneRedCountInfoManager", 1, "num should clear is less or equal than 0");
            return;
        }
        if (passiveTotalNum == 0) {
            QLog.i("QZoneRedCountInfoManager", 1, "passive num is 0, no need to update");
            return;
        }
        if (passiveTotalNum < numShouldClear) {
            QLog.i("QZoneRedCountInfoManager", 1, "passive num : " + passiveTotalNum + ", smaller than num should clear : " + numShouldClear);
            C.updateNumberRedInfoByPath("10000.0", 0);
            return;
        }
        QLog.i("QZoneRedCountInfoManager", 1, "passive num : " + passiveTotalNum + ",  num should clear : " + numShouldClear);
        C.updateNumberRedInfoByPath("10000.0", passiveTotalNum - numShouldClear);
    }

    private final void b(int id5) {
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        PBRepeatMessageField<qzoneReddotMeta$ReddotInfo> pBRepeatMessageField;
        List<qzoneReddotMeta$ReddotInfo> list;
        Object obj;
        IRedTouchManager C = C();
        if (C == null || (appInfoByPath = C.getAppInfoByPath("10000.0")) == null) {
            return;
        }
        try {
            qzoneReddotMeta$ReddotList mergeFrom = new qzoneReddotMeta$ReddotList().mergeFrom(appInfoByPath.busi_data.get().toByteArray());
            if (mergeFrom != null && (pBRepeatMessageField = mergeFrom.reddot_infos) != null && (list = pBRepeatMessageField.get()) != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (((qzoneReddotMeta$ReddotInfo) obj).reddot_id.get() == id5) {
                            break;
                        }
                    }
                }
                qzoneReddotMeta$ReddotInfo qzonereddotmeta_reddotinfo = (qzoneReddotMeta$ReddotInfo) obj;
                if (qzonereddotmeta_reddotinfo != null) {
                    QLog.i("QZoneRedCountInfoManager", 1, "clear passive red dot, id is " + id5);
                    mergeFrom.reddot_infos.get().remove(qzonereddotmeta_reddotinfo);
                }
            }
            appInfoByPath.busi_data.set(ByteStringMicro.copyFrom(mergeFrom.toByteArray()));
        } catch (Exception e16) {
            QLog.e("QZoneRedCountInfoManager", 1, "exception is " + e16);
        }
    }

    private final void c(int id5) {
        if (TianshuRedTouch.INSTANCE.j()) {
            c B = B("10000.0", id5);
            int count = B != null ? B.getCount() : 0;
            int D = D();
            QLog.i("QZoneRedCountInfoManager", 1, " id is " + id5 + ", passive total num is " + D + ", num should clear is " + count);
            O(D, count);
            b(id5);
        }
    }

    private final void f() {
        Object obj;
        HashMap hashMap = new HashMap();
        List<c> n3 = n();
        List<c> list = n3;
        if (list == null || list.isEmpty()) {
            QLog.i("QZoneRedCountInfoManager", 2, "[daTongActiveRedCountClickReport] active red count list is null or empty");
            return;
        }
        Iterator<T> it = n3.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            c cVar = (c) obj;
            d dVar = f393812a;
            if (!dVar.J(cVar.getId()) && dVar.K(cVar.getId())) {
                break;
            }
        }
        c cVar2 = (c) obj;
        if (cVar2 != null) {
            hashMap.put("red_dot_id", Integer.valueOf(f393812a.o(cVar2.getId())));
        }
        fo.c.a("ev_bas_space_entry_red_clck", hashMap);
    }

    private final void g() {
        Object obj;
        HashMap hashMap = new HashMap();
        List<c> n3 = n();
        List<c> list = n3;
        if (list == null || list.isEmpty()) {
            QLog.i("QZoneRedCountInfoManager", 2, "[daTongActiveRedCountImpReport] active red count list is null or empty");
            return;
        }
        Iterator<T> it = n3.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            c cVar = (c) obj;
            d dVar = f393812a;
            if (!dVar.J(cVar.getId()) && dVar.K(cVar.getId())) {
                break;
            }
        }
        c cVar2 = (c) obj;
        if (cVar2 != null) {
            hashMap.put("red_dot_id", Integer.valueOf(f393812a.o(cVar2.getId())));
        }
        fo.c.a("ev_bas_space_entry_red_imp", hashMap);
    }

    private final void j() {
        Object obj;
        HashMap hashMap = new HashMap();
        if (D() <= 0) {
            QLog.i("QZoneRedCountInfoManager", 2, "[daTongPassiveRedCountClickReport] total number is less than 0");
            return;
        }
        List<c> s16 = s();
        List<c> list = s16;
        if (list == null || list.isEmpty()) {
            QLog.i("QZoneRedCountInfoManager", 2, "[daTongPassiveRedCountClickReport] passive red count list is null or empty");
            return;
        }
        Iterator<T> it = s16.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((c) obj).getCount() > 0) {
                    break;
                }
            }
        }
        c cVar = (c) obj;
        if (cVar != null) {
            hashMap.put("red_dot_id", Integer.valueOf(f393812a.o(cVar.getId())));
        }
        fo.c.a("ev_bas_space_entry_red_clck", hashMap);
    }

    private final void k() {
        Object obj;
        HashMap hashMap = new HashMap();
        if (D() <= 0) {
            QLog.i("QZoneRedCountInfoManager", 2, "[daTongPassiveRedCountImpReport] total number is less than 0");
            return;
        }
        List<c> s16 = s();
        List<c> list = s16;
        if (list == null || list.isEmpty()) {
            QLog.i("QZoneRedCountInfoManager", 2, "[daTongPassiveRedCountImpReport] passive red count list is null or empty");
            return;
        }
        Iterator<T> it = s16.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((c) obj).getCount() > 0) {
                    break;
                }
            }
        }
        c cVar = (c) obj;
        if (cVar != null) {
            hashMap.put("red_dot_id", Integer.valueOf(f393812a.o(cVar.getId())));
        }
        fo.c.a("ev_bas_space_entry_red_imp", hashMap);
    }

    private final List<c> n() {
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        PBRepeatMessageField<qzoneReddotMeta$ReddotInfo> pBRepeatMessageField;
        List<qzoneReddotMeta$ReddotInfo> list;
        c h16;
        IRedTouchManager C = C();
        if (C == null || (appInfoByPath = C.getAppInfoByPath(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN)) == null || appInfoByPath.iNewFlag.get() == 0) {
            return null;
        }
        ByteStringMicro byteStringMicro = appInfoByPath.busi_data.get();
        try {
            ArrayList arrayList = new ArrayList();
            qzoneReddotMeta$ReddotList mergeFrom = new qzoneReddotMeta$ReddotList().mergeFrom(byteStringMicro.toByteArray());
            if (mergeFrom != null && (pBRepeatMessageField = mergeFrom.reddot_infos) != null && (list = pBRepeatMessageField.get()) != null) {
                for (qzoneReddotMeta$ReddotInfo qzonereddotmeta_reddotinfo : list) {
                    QLog.i("QZoneRedCountInfoManager", 1, "red dot id is " + qzonereddotmeta_reddotinfo.reddot_id.get());
                    d dVar = f393812a;
                    if (!dVar.J(qzonereddotmeta_reddotinfo.reddot_id.get()) && dVar.K(qzonereddotmeta_reddotinfo.reddot_id.get()) && (h16 = b.h(qzonereddotmeta_reddotinfo, qzonereddotmeta_reddotinfo.count.create_time.get())) != null) {
                        QLog.i("QZoneRedCountInfoManager", 1, "add active, red dot id is " + qzonereddotmeta_reddotinfo.reddot_id.get() + ", create time is " + qzonereddotmeta_reddotinfo.count.create_time.get());
                        arrayList.add(h16);
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e("QZoneRedCountInfoManager", 1, "exception is " + e16);
            return null;
        }
    }

    private final int o(int id5) {
        if (id5 != 1) {
            if (id5 != 2) {
                if (id5 == 3) {
                    return 3;
                }
                if (id5 != 4) {
                    if (id5 != 5) {
                        return id5;
                    }
                }
            }
            return 2;
        }
        return 1;
    }

    private final c p() {
        return B("10000.0", 4);
    }

    public final int D() {
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        IRedTouchManager C = C();
        if (C == null || (appInfoByPath = C.getAppInfoByPath("10000.0")) == null || appInfoByPath.iNewFlag.get() == 0) {
            return 0;
        }
        int i3 = appInfoByPath.num.get();
        int z16 = z() + q();
        QLog.i("QZoneRedCountInfoManager", 1, "app info passive num is " + i3 + ", actual passive num is " + z16);
        return z16;
    }

    public final boolean E() {
        if (TianshuRedTouch.INSTANCE.j()) {
            if (G() || I()) {
                return true;
            }
        } else if (QZoneFeedAlertService.getInstance().getSingleUnreadCount(2) > 0) {
            return true;
        }
        return false;
    }

    public final boolean F() {
        if (TianshuRedTouch.INSTANCE.j()) {
            return H();
        }
        return QZoneFeedAlertService.getInstance().getSingleUnreadCount(1) > 0;
    }

    public final void d() {
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(2);
        if (a.f393805d.e()) {
            QLog.w("QZ_QFS_QZoneRedCountInfoManager", 1, "clearQZoneActiveRedCount, hasQcircleDynamicRedDot, no fake dimiss");
            return;
        }
        IRedTouchManager C = C();
        if (C == null) {
            return;
        }
        C.dismissRedTouch(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN);
    }

    public final void h() {
        if (TianshuRedTouch.INSTANCE.j()) {
            j();
            f();
        }
    }

    public final void i() {
        if (TianshuRedTouch.INSTANCE.j()) {
            k();
            g();
        }
    }

    public final int q() {
        if (TianshuRedTouch.INSTANCE.j()) {
            c p16 = p();
            if (p16 != null) {
                return p16.getCount();
            }
            return 0;
        }
        int singleUnreadCount = QZoneFeedAlertService.getInstance().getSingleUnreadCount(73);
        QLog.i("QZoneRedCountInfoManager", 1, "intimate passive count num is " + singleUnreadCount);
        return singleUnreadCount;
    }

    public final ArrayList<Pair<QZoneCountUserInfo, String>> r() {
        List<c> s16 = s();
        if (s16 != null) {
            return b.b(s16);
        }
        return null;
    }

    public final List<c> s() {
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        PBRepeatMessageField<qzoneReddotMeta$ReddotInfo> pBRepeatMessageField;
        List<qzoneReddotMeta$ReddotInfo> list;
        c h16;
        IRedTouchManager C = C();
        if (C == null || (appInfoByPath = C.getAppInfoByPath("10000.0")) == null || appInfoByPath.iNewFlag.get() == 0) {
            return null;
        }
        ByteStringMicro byteStringMicro = appInfoByPath.busi_data.get();
        try {
            ArrayList arrayList = new ArrayList();
            qzoneReddotMeta$ReddotList mergeFrom = new qzoneReddotMeta$ReddotList().mergeFrom(byteStringMicro.toByteArray());
            if (mergeFrom != null && (pBRepeatMessageField = mergeFrom.reddot_infos) != null && (list = pBRepeatMessageField.get()) != null) {
                for (qzoneReddotMeta$ReddotInfo qzonereddotmeta_reddotinfo : list) {
                    QLog.i("QZoneRedCountInfoManager", 1, "[getPassiveRedCountInfoList] | red dot id is " + qzonereddotmeta_reddotinfo.reddot_id.get());
                    if (f393812a.J(qzonereddotmeta_reddotinfo.reddot_id.get()) && (h16 = b.h(qzonereddotmeta_reddotinfo, qzonereddotmeta_reddotinfo.count.create_time.get())) != null) {
                        QLog.i("QZoneRedCountInfoManager", 1, "add passive, red dot id is " + qzonereddotmeta_reddotinfo.reddot_id.get() + ", create time is " + qzonereddotmeta_reddotinfo.count.create_time.get() + ", count is " + qzonereddotmeta_reddotinfo.count.count.get());
                        arrayList.add(h16);
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e("QZoneRedCountInfoManager", 1, "exception is " + e16);
            return null;
        }
    }

    public final ArrayList<Pair<QZoneCountUserInfo, String>> t() {
        List<c> v3 = v();
        if (v3 != null) {
            return b.b(v3);
        }
        return null;
    }

    public final c u() {
        return B(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN, 2);
    }

    public final List<c> v() {
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        PBRepeatMessageField<qzoneReddotMeta$ReddotInfo> pBRepeatMessageField;
        List<qzoneReddotMeta$ReddotInfo> list;
        c h16;
        IRedTouchManager C = C();
        if (C == null || (appInfoByPath = C.getAppInfoByPath(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN)) == null || appInfoByPath.iNewFlag.get() == 0) {
            return null;
        }
        ByteStringMicro byteStringMicro = appInfoByPath.busi_data.get();
        try {
            ArrayList arrayList = new ArrayList();
            qzoneReddotMeta$ReddotList mergeFrom = new qzoneReddotMeta$ReddotList().mergeFrom(byteStringMicro.toByteArray());
            if (mergeFrom != null && (pBRepeatMessageField = mergeFrom.reddot_infos) != null && (list = pBRepeatMessageField.get()) != null) {
                for (qzoneReddotMeta$ReddotInfo qzonereddotmeta_reddotinfo : list) {
                    QLog.i("QZoneRedCountInfoManager", 1, "[getQZoneActiveRedCountInfoList] | red dot id is " + qzonereddotmeta_reddotinfo.reddot_id.get());
                    if (qzonereddotmeta_reddotinfo.reddot_id.get() == 2 && (h16 = b.h(qzonereddotmeta_reddotinfo, qzonereddotmeta_reddotinfo.count.create_time.get())) != null) {
                        QLog.i("QZoneRedCountInfoManager", 1, "add QZONE_ACTIVE, red dot id is " + qzonereddotmeta_reddotinfo.reddot_id.get() + ", create time is " + qzonereddotmeta_reddotinfo.count.create_time.get());
                        arrayList.add(h16);
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e("QZoneRedCountInfoManager", 1, "exception is " + e16);
            return null;
        }
    }

    public final ArrayList<Pair<QZoneCountUserInfo, String>> w() {
        List<c> y16 = y();
        if (y16 != null) {
            return b.b(y16);
        }
        return null;
    }

    public final c x() {
        return B("10000.0", 1);
    }

    public final List<c> y() {
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        PBRepeatMessageField<qzoneReddotMeta$ReddotInfo> pBRepeatMessageField;
        List<qzoneReddotMeta$ReddotInfo> list;
        c h16;
        IRedTouchManager C = C();
        if (C == null || (appInfoByPath = C.getAppInfoByPath("10000.0")) == null || appInfoByPath.iNewFlag.get() == 0) {
            return null;
        }
        ByteStringMicro byteStringMicro = appInfoByPath.busi_data.get();
        try {
            ArrayList arrayList = new ArrayList();
            qzoneReddotMeta$ReddotList mergeFrom = new qzoneReddotMeta$ReddotList().mergeFrom(byteStringMicro.toByteArray());
            if (mergeFrom != null && (pBRepeatMessageField = mergeFrom.reddot_infos) != null && (list = pBRepeatMessageField.get()) != null) {
                for (qzoneReddotMeta$ReddotInfo qzonereddotmeta_reddotinfo : list) {
                    QLog.i("QZoneRedCountInfoManager", 1, "[getQZonePassiveRedCountInfoList] | red dot id is " + qzonereddotmeta_reddotinfo.reddot_id.get());
                    if (qzonereddotmeta_reddotinfo.reddot_id.get() == 1 && (h16 = b.h(qzonereddotmeta_reddotinfo, qzonereddotmeta_reddotinfo.count.create_time.get())) != null) {
                        QLog.i("QZoneRedCountInfoManager", 1, "add QZONE_PASSIVE, red dot id is " + qzonereddotmeta_reddotinfo.reddot_id.get() + ", create time is " + qzonereddotmeta_reddotinfo.count.create_time.get() + ", count is " + qzonereddotmeta_reddotinfo.count.count.get());
                        arrayList.add(h16);
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e("QZoneRedCountInfoManager", 1, "exception is " + e16);
            return null;
        }
    }

    public final int z() {
        int singleUnreadCount;
        if (TianshuRedTouch.INSTANCE.j()) {
            c x16 = x();
            singleUnreadCount = x16 != null ? x16.getCount() : 0;
        } else {
            singleUnreadCount = QZoneFeedAlertService.getInstance().getSingleUnreadCount(1);
        }
        QLog.i("QZoneRedCountInfoManager", 1, "qzone passive count num is " + singleUnreadCount);
        return singleUnreadCount;
    }

    public final void a() {
        c(4);
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(73);
    }

    public final void e() {
        c(1);
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(1);
    }

    public final boolean l(c redCountInfoBean) {
        boolean z16 = false;
        if (redCountInfoBean == null) {
            return false;
        }
        long h16 = i.b().h("KEY_TOP_MESSAGE_BANNER_SHOW_INTERVAL", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - h16;
        QLog.i("QZoneRedCountInfoManager", 2, "last show time is " + h16 + ", current show time is " + currentTimeMillis + ", interval is " + j3);
        long h17 = i.b().h("KEY_TOP_MESSAGE_BANNER_ACTIVE_SHOW_VERSION", 0L);
        boolean z17 = redCountInfoBean.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String() > h17;
        QLog.i("QZoneRedCountInfoManager", 2, "last show version is " + h17 + ", current show version is " + redCountInfoBean.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String());
        if (j3 > 180000 && z17) {
            z16 = true;
        }
        if (z16) {
            N(currentTimeMillis);
            L(redCountInfoBean.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String());
        }
        return z16;
    }

    public final boolean m(c redCountInfoBean) {
        boolean z16 = false;
        if (redCountInfoBean == null) {
            return false;
        }
        long h16 = i.b().h("KEY_TOP_MESSAGE_BANNER_SHOW_INTERVAL", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - h16;
        QLog.i("QZoneRedCountInfoManager", 2, "last show time is " + h16 + ", current show time is " + currentTimeMillis + ", interval is " + j3);
        long h17 = i.b().h("KEY_TOP_MESSAGE_BANNER_PASSIVE_SHOW_VERSION", 0L);
        boolean z17 = redCountInfoBean.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String() > h17;
        QLog.i("QZoneRedCountInfoManager", 2, "last show version is " + h17 + ", current show version is " + redCountInfoBean.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String());
        if (j3 > 180000 && z17) {
            z16 = true;
        }
        if (z16) {
            N(currentTimeMillis);
            M(redCountInfoBean.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String());
        }
        return z16;
    }
}
