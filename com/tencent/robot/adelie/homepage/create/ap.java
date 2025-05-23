package com.tencent.robot.adelie.homepage.create;

import android.content.Intent;
import com.google.gson.Gson;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"Landroid/content/Intent;", "from", "Lcom/tencent/robot/adelie/homepage/create/ao;", "a", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ap {
    @NotNull
    public static final StartupParams a(@Nullable Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (intent == null) {
            return new StartupParams(null, null, null, null, null, 31, null);
        }
        String stringExtra = intent.getStringExtra(ISchemeApi.KEY_REFERER);
        String str6 = "";
        if (stringExtra == null) {
            str = "";
        } else {
            str = stringExtra;
        }
        String stringExtra2 = intent.getStringExtra(ISchemeApi.KEY_PAGE_DATA);
        if (stringExtra2 != null) {
            str2 = URLDecoder.decode(stringExtra2, "UTF-8");
        } else {
            str2 = null;
        }
        String str7 = str2;
        if (str7 == null) {
            str3 = "";
        } else {
            str3 = str7;
        }
        try {
            PageDataInfo pageDataInfo = (PageDataInfo) new Gson().fromJson(str3, PageDataInfo.class);
            QLog.i("AdelieCreationFragment", 1, "pageDataInfo: " + pageDataInfo);
            str4 = pageDataInfo.getTpl_info();
            try {
                str5 = pageDataInfo.getActivity_id();
            } catch (Throwable th5) {
                th = th5;
                str5 = "";
            }
            try {
                str6 = pageDataInfo.getActivity_name();
            } catch (Throwable th6) {
                th = th6;
                QLog.i("AdelieCreationFragment", 1, "parse page data error=" + th);
                return new StartupParams(str, str7, str4, str5, str6);
            }
        } catch (Throwable th7) {
            th = th7;
            str4 = "";
            str5 = str4;
        }
        return new StartupParams(str, str7, str4, str5, str6);
    }
}
