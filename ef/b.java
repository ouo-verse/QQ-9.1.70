package ef;

import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.bean.QZoneSpringLikeInfoBean;
import com.tencent.mobileqq.service.qzone.e;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\u0000\u001a\f\u0010\u000b\u001a\u00020\u0001*\u0004\u0018\u00010\n\u001a\f\u0010\f\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "", h.F, "i", "f", "d", "e", "c", "", "a", "Lcom/qzone/proxy/feedcomponent/model/User;", "g", "j", "Lcom/qzone/reborn/feedx/bean/d;", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {
    public static final boolean c(BusinessFeedData businessFeedData) {
        return d(businessFeedData);
    }

    public static final boolean e(BusinessFeedData businessFeedData) {
        return f(businessFeedData) && businessFeedData != null && businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 2;
    }

    public static final boolean j(BusinessFeedData businessFeedData) {
        CellFeedCommInfo cellFeedCommInfo;
        Map<String, String> map;
        if (!e.f286406a.b() || businessFeedData == null || (cellFeedCommInfo = businessFeedData.cellFeedCommInfo) == null || (map = cellFeedCommInfo.extendInfo) == null) {
            return false;
        }
        String str = map.get("user_info");
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            return new JSONObject(str).optInt("activity_state") == 2;
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
            return false;
        }
    }

    public static final String a(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return "";
        }
        if (!f(businessFeedData) && !d(businessFeedData)) {
            return businessFeedData.getFeedCommInfo().ugckey;
        }
        return businessFeedData.getFeedCommInfo().feedsid;
    }

    public static final boolean d(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().bizId != 3) ? false : true;
    }

    public static final boolean f(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().bizId != 2) ? false : true;
    }

    public static final boolean h(BusinessFeedData businessFeedData) {
        CellUserInfo cellUserInfo;
        User user;
        return (businessFeedData == null || (cellUserInfo = businessFeedData.cellUserInfo) == null || (user = cellUserInfo.user) == null || (user.uin != LoginData.getInstance().getUin() && !Intrinsics.areEqual(businessFeedData.cellUserInfo.user.uid, LoginData.getInstance().getUid()))) ? false : true;
    }

    public static final boolean i(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || (businessFeedData.getFeedCommInfo().bizId != 1 && businessFeedData.getFeedCommInfo().bizId != 0)) ? false : true;
    }

    public static final QZoneSpringLikeInfoBean b(BusinessFeedData businessFeedData) {
        CellFeedCommInfo cellFeedCommInfo;
        Map<String, String> map;
        if (businessFeedData != null && (cellFeedCommInfo = businessFeedData.cellFeedCommInfo) != null && (map = cellFeedCommInfo.extendInfo) != null) {
            String str = map.get("user_info");
            if (str == null || str.length() == 0) {
                return null;
            }
            try {
                String optString = new JSONObject(str).optString("like_config");
                QLog.i("getSpringLikeInfo", 2, "likeInfoString is " + optString);
                if (optString == null || optString.length() == 0) {
                    return null;
                }
                return (QZoneSpringLikeInfoBean) cooperation.plugin.patch.d.b(optString, QZoneSpringLikeInfoBean.class);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
        return null;
    }

    public static final boolean g(User user) {
        if (user == null) {
            return false;
        }
        return user.uin == LoginData.getInstance().getUin() || Intrinsics.areEqual(user.uid, LoginData.getInstance().getUid());
    }
}
