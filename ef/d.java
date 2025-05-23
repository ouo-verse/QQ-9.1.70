package ef;

import android.app.Activity;
import android.app.Dialog;
import com.qzone.reborn.intimate.bean.QZIntimateSettingItemBean;
import com.qzone.util.ar;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$Setting;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0004\n\u0002\b\u0006\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0001\u001a\f\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0005*\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0005\u001a\f\u0010\t\u001a\u00020\b*\u0004\u0018\u00010\u0000\u001a\u0014\u0010\n\u001a\u00020\b*\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\b\u001a\u0016\u0010\u000f\u001a\u00020\u000e*\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f\u001a\u0016\u0010\u0011\u001a\u00020\u0010*\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f\u001a\n\u0010\u0014\u001a\u00020\u0013*\u00020\u0012\u001a\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015*\b\u0012\u0004\u0012\u00020\u00120\u0015\u001a\u0013\u0010\u0017\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a\u0013\u0010\u0019\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0019\u0010\u0018\"\u0015\u0010\u001c\u001a\u00020\u0005*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0015\u0010\u001c\u001a\u00020\b*\u00020\u001d8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0015\u0010!\u001a\u00020\u0005*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001b\"\u0015\u0010!\u001a\u00020\b*\u00020\u001d8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001f\u00a8\u0006#"}, d2 = {"", "", "k", RemoteHandleConst.PARAM_DEFAULT_VALUE, "l", "", "i", "j", "", "g", h.F, "Landroid/app/Dialog;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "f", "", "e", "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$Setting;", "Lcom/qzone/reborn/intimate/bean/QZIntimateSettingItemBean;", "o", "", "p", DomainData.DOMAIN_NAME, "(Ljava/lang/Long;)J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "(I)I", "dp", "", "a", "(Ljava/lang/Number;)F", "d", "sp", "c", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {
    public static final float a(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return ar.e(number.floatValue());
    }

    public static final float c(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return ar.v(number.floatValue());
    }

    public static final QZIntimateSettingItemBean o(GeneralSigninPB$Setting generalSigninPB$Setting) {
        Intrinsics.checkNotNullParameter(generalSigninPB$Setting, "<this>");
        QZIntimateSettingItemBean qZIntimateSettingItemBean = new QZIntimateSettingItemBean();
        String str = generalSigninPB$Setting.name.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.name.get()");
        qZIntimateSettingItemBean.setKey(str);
        String str2 = generalSigninPB$Setting.desc.get();
        Intrinsics.checkNotNullExpressionValue(str2, "this.desc.get()");
        qZIntimateSettingItemBean.setName(str2);
        String str3 = generalSigninPB$Setting.value.get();
        Intrinsics.checkNotNullExpressionValue(str3, "this.value.get()");
        qZIntimateSettingItemBean.setValue(str3);
        return qZIntimateSettingItemBean;
    }

    public static final List<QZIntimateSettingItemBean> p(List<GeneralSigninPB$Setting> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<GeneralSigninPB$Setting> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(o(it.next()));
        }
        return arrayList;
    }

    public static final int b(int i3) {
        return ar.e(i3);
    }

    public static final int d(int i3) {
        return ar.v(i3);
    }

    public static final float g(String str) {
        return h(str, 0.0f);
    }

    public static final int i(String str) {
        return j(str, 0);
    }

    public static final float h(String str, float f16) {
        if (str == null || str.length() == 0) {
            return f16;
        }
        try {
            return Float.parseFloat(str);
        } catch (Throwable unused) {
            return f16;
        }
    }

    public static final int j(String str, int i3) {
        if (str == null || str.length() == 0) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static final long k(String str) {
        return l(str, 0L);
    }

    public static final long l(String str, long j3) {
        if (str == null || str.length() == 0) {
            return j3;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return j3;
        }
    }

    public static final void f(Dialog dialog, Activity activity) {
        if (dialog != null && activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            try {
                dialog.show();
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        String valueOf = String.valueOf(dialog != null ? dialog.getClass().getSimpleName() : null);
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        objArr[0] = "show dialog when activity(" + (dialog != null ? dialog.getOwnerActivity() : null) + ") is finish!";
        RFWLog.e(valueOf, i3, objArr);
    }

    public static final long m(Long l3) {
        if (l3 == null) {
            return 0L;
        }
        if (l3.toString().length() == 10) {
            return l3.longValue() * 1000;
        }
        return l3.longValue();
    }

    public static final long n(Long l3) {
        if (l3 == null) {
            return 0L;
        }
        if (l3.toString().length() == 13) {
            return l3.longValue() / 1000;
        }
        return l3.longValue();
    }

    public static final boolean e(Dialog dialog, Activity activity) {
        if (dialog != null && activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            try {
                dialog.show();
                return true;
            } catch (Exception e16) {
                RFWLog.e(dialog.getClass().getSimpleName(), RFWLog.USR, "show dialog exception is " + e16);
                return false;
            }
        }
        String valueOf = String.valueOf(dialog != null ? dialog.getClass().getSimpleName() : null);
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        objArr[0] = "show dialog when activity(" + (dialog != null ? dialog.getOwnerActivity() : null) + ") is finish!";
        RFWLog.e(valueOf, i3, objArr);
        return false;
    }
}
