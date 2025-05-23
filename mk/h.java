package mk;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StUserAccountBaseMate;
import com.tencent.qqnt.kernel.nativeinterface.StUserAccountEntry;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseCommon$StUserAccountBaseMate;
import qzone.QZoneBaseCommon$StUserAccountEntry;
import qzone.QZoneBaseMeta$StUser;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J \u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\fJ \u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J*\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\f\u00a8\u0006\u001b"}, d2 = {"Lmk/h;", "", "", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "commonExt", "", "g", "", "Lcom/tencent/qqnt/kernel/nativeinterface/StUserAccountEntry;", "accountList", tl.h.F, "Lqzone/QZoneBaseCommon$StCommonExt;", "f", "Lqzone/QZoneBaseCommon$StUserAccountEntry;", "e", "url", "c", "b", "a", "", "Lqzone/QZoneBaseMeta$StUser;", "users", "ownerUin", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f416877a = new h();

    h() {
    }

    public final String d(List<QZoneBaseMeta$StUser> users, long ownerUin, QZoneBaseCommon$StCommonExt commonExt) {
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser;
        PBStringField pBStringField;
        Object obj;
        if (bl.b(users)) {
            return null;
        }
        if (users != null) {
            Iterator<T> it = users.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (ownerUin != f416877a.f(((QZoneBaseMeta$StUser) obj).uid.get(), commonExt)) {
                    break;
                }
            }
            qZoneBaseMeta$StUser = (QZoneBaseMeta$StUser) obj;
        } else {
            qZoneBaseMeta$StUser = null;
        }
        if (qZoneBaseMeta$StUser == null || (pBStringField = qZoneBaseMeta$StUser.uid) == null) {
            return null;
        }
        return pBStringField.get();
    }

    public final String a(String url, StCommonExt commonExt) {
        boolean contains$default;
        String str = url == null ? "" : url;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "uid", false, 2, (Object) null);
        if (!contains$default) {
            return str;
        }
        try {
            String queryParameter = Uri.parse(url).getQueryParameter("uid");
            long g16 = !TextUtils.isEmpty(queryParameter) ? g(queryParameter, commonExt) : 0L;
            if (g16 == 0) {
                return str;
            }
            String b16 = yo.f.b(url, "uin", String.valueOf(g16));
            Intrinsics.checkNotNullExpressionValue(b16, "appendQueryParameter(url, \"uin\", uin.toString())");
            return b16;
        } catch (Exception e16) {
            RFWLog.e("QZoneUidCompatUtils", RFWLog.USR, "parse uid error" + e16);
            return str;
        }
    }

    public final String b(String url, QZoneBaseCommon$StCommonExt commonExt) {
        boolean contains$default;
        String str = url == null ? "" : url;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "uid", false, 2, (Object) null);
        if (!contains$default) {
            return str;
        }
        try {
            String queryParameter = Uri.parse(url).getQueryParameter("uid");
            long f16 = !TextUtils.isEmpty(queryParameter) ? f(queryParameter, commonExt) : 0L;
            if (f16 == 0) {
                return str;
            }
            String b16 = yo.f.b(url, "uin", String.valueOf(f16));
            Intrinsics.checkNotNullExpressionValue(b16, "appendQueryParameter(url, \"uin\", uin.toString())");
            return b16;
        } catch (Exception e16) {
            RFWLog.e("QZoneUidCompatUtils", RFWLog.USR, "parse uid error" + e16);
            return str;
        }
    }

    public final String c(String url, StCommonExt commonExt) {
        boolean contains$default;
        String str = url == null ? "" : url;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "uid", false, 2, (Object) null);
        if (!contains$default) {
            return str;
        }
        try {
            String queryParameter = Uri.parse(url).getQueryParameter("uid");
            long g16 = !TextUtils.isEmpty(queryParameter) ? g(queryParameter, commonExt) : 0L;
            if (g16 == 0) {
                return str;
            }
            String b16 = yo.f.b(url, "uin", String.valueOf(g16));
            Intrinsics.checkNotNullExpressionValue(b16, "appendQueryParameter(url, \"uin\", uin.toString())");
            return b16;
        } catch (Exception e16) {
            RFWLog.e("QZoneUidCompatUtils", RFWLog.USR, "parse uid error" + e16);
            return str;
        }
    }

    public final long f(String uid, QZoneBaseCommon$StCommonExt commonExt) {
        PBRepeatMessageField<QZoneBaseCommon$StUserAccountEntry> pBRepeatMessageField;
        return e(uid, (commonExt == null || (pBRepeatMessageField = commonExt.map_user_account) == null) ? null : pBRepeatMessageField.get());
    }

    public final long g(String uid, StCommonExt commonExt) {
        return h(uid, commonExt != null ? commonExt.mapUserAccount : null);
    }

    public final long e(String uid, List<QZoneBaseCommon$StUserAccountEntry> accountList) {
        Long l3;
        Object obj;
        QZoneBaseCommon$StUserAccountBaseMate qZoneBaseCommon$StUserAccountBaseMate;
        PBUInt64Field pBUInt64Field;
        PBStringField pBStringField;
        if (!(uid == null || uid.length() == 0) && accountList != null) {
            Iterator<T> it = accountList.iterator();
            while (true) {
                l3 = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                QZoneBaseCommon$StUserAccountBaseMate qZoneBaseCommon$StUserAccountBaseMate2 = ((QZoneBaseCommon$StUserAccountEntry) obj).account;
                if (Intrinsics.areEqual((qZoneBaseCommon$StUserAccountBaseMate2 == null || (pBStringField = qZoneBaseCommon$StUserAccountBaseMate2.uid) == null) ? null : pBStringField.get(), uid)) {
                    break;
                }
            }
            QZoneBaseCommon$StUserAccountEntry qZoneBaseCommon$StUserAccountEntry = (QZoneBaseCommon$StUserAccountEntry) obj;
            if (qZoneBaseCommon$StUserAccountEntry != null && (qZoneBaseCommon$StUserAccountBaseMate = qZoneBaseCommon$StUserAccountEntry.account) != null && (pBUInt64Field = qZoneBaseCommon$StUserAccountBaseMate.uin) != null) {
                l3 = Long.valueOf(pBUInt64Field.get());
            }
            if (l3 == null) {
                l3 = Long.valueOf(ef.d.k(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(uid)));
            }
            if (l3.longValue() == 0) {
                RFWLog.d("QZoneUidCompatUtils", RFWLog.USR, "getUinByUid error, cannot find uin by uid: " + uid);
                return 0L;
            }
            return l3.longValue();
        }
        RFWLog.d("QZoneUidCompatUtils", RFWLog.USR, "getUinByUid error, " + uid + ", accountList: " + accountList);
        return 0L;
    }

    public final long h(String uid, List<StUserAccountEntry> accountList) {
        Long l3;
        Object obj;
        StUserAccountBaseMate stUserAccountBaseMate;
        if (!(uid == null || uid.length() == 0) && accountList != null) {
            Iterator<T> it = accountList.iterator();
            while (true) {
                l3 = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                StUserAccountBaseMate stUserAccountBaseMate2 = ((StUserAccountEntry) obj).account;
                if (Intrinsics.areEqual(stUserAccountBaseMate2 != null ? stUserAccountBaseMate2.uid : null, uid)) {
                    break;
                }
            }
            StUserAccountEntry stUserAccountEntry = (StUserAccountEntry) obj;
            if (stUserAccountEntry != null && (stUserAccountBaseMate = stUserAccountEntry.account) != null) {
                l3 = Long.valueOf(stUserAccountBaseMate.uin);
            }
            if (l3 == null) {
                l3 = Long.valueOf(ef.d.k(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(uid)));
            }
            if (l3.longValue() == 0) {
                RFWLog.d("QZoneUidCompatUtils", RFWLog.USR, "getUinByUid error, cannot find uin by uid: " + uid);
                return 0L;
            }
            return l3.longValue();
        }
        RFWLog.d("QZoneUidCompatUtils", RFWLog.USR, "getUinByUid error, " + uid + ", accountList: " + accountList);
        return 0L;
    }
}
