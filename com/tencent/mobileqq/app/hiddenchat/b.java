package com.tencent.mobileqq.app.hiddenchat;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi;
import com.tencent.qqnt.chats.data.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<d> f195711a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70294);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f195711a = new ArrayList<>();
        }
    }

    public static SharedPreferences a(Context context, String str) {
        return context.getSharedPreferences("PrefHiddenChat" + str, 4);
    }

    public static boolean b(String str, Context context) {
        if (context != null && !TextUtils.isEmpty(str)) {
            MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
            if (!from.decodeBool("FirstUnReadHiddenChat" + str, false)) {
                from.encodeBool("FirstUnReadHiddenChat" + str, true);
                boolean z16 = a(context, str).getBoolean("show_unread_msg", true);
                ((IHiddenChatApi) QRoute.api(IHiddenChatApi.class)).setShowUnReadNum(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str, z16);
                QLog.d("HiddenChatUtil", 1, "isShowUnreadMsg " + z16);
                return z16;
            }
        }
        return true;
    }

    public static boolean c(Context context, String str, String str2, int i3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return true;
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        boolean decodeBool = from.decodeBool("show_video_msg" + str, false);
        if (!decodeBool) {
            String str3 = "hiddenChatStore" + str + str2 + i3;
            if (from.containsKey(str3)) {
                QLog.d("HiddenChatUtil", 1, "VideoProcess isHiddenChat is " + from.decodeBool(str3, false));
                decodeBool = false;
            } else {
                decodeBool = true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("HiddenChatUtil", 2, String.format("Inner isShowVideoMsg ac[%s], uin[%s], type[%s], show[%s]", str, str2, Integer.valueOf(i3), Boolean.valueOf(decodeBool)));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("HiddenChatUtil", 2, String.format("Outer isShowVideoMsg ac[%s], uin[%s], type[%s], show[%s]", str, str2, Integer.valueOf(i3), Boolean.valueOf(decodeBool)));
        }
        return decodeBool;
    }

    public static boolean d(String str, Context context) {
        if (context == null || TextUtils.isEmpty(str)) {
            return true;
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        if (!from.decodeBool("FirstVideoHiddenChat" + str, false)) {
            from.encodeBool("FirstVideoHiddenChat" + str, true);
            from.encodeBool("show_video_msg" + str, a(context, str).getBoolean("show_video_msg", false));
        }
        return from.decodeBool("show_video_msg" + str, false);
    }

    public static void e(String str, Context context, boolean z16) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ((IHiddenChatApi) QRoute.api(IHiddenChatApi.class)).setShowUnReadNum(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str, z16);
            MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
            if (!from.decodeBool("FirstUnReadHiddenChat" + str, false)) {
                QLog.d("HiddenChatUtil", 1, "setHiddenSession " + z16);
                from.encodeBool("FirstUnReadHiddenChat" + str, true);
            }
            if (QLog.isColorLevel()) {
                QLog.i("HiddenChatUtil", 2, "setHiddenSession ac[" + str + "], open[" + z16 + "]");
            }
        }
    }

    public static void f(String str, Context context, boolean z16) {
        if (context != null && !TextUtils.isEmpty(str)) {
            MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
            from.encodeBool("show_video_msg" + str, z16);
            if (!from.decodeBool("FirstVideoHiddenChat" + str, false)) {
                from.encodeBool("FirstVideoHiddenChat" + str, true);
            }
            if (QLog.isColorLevel()) {
                QLog.i("HiddenChatUtil", 2, "setVideoMsg ac[" + str + "], open[" + z16 + "]");
            }
        }
    }
}
