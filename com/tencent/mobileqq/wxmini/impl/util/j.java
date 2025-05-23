package com.tencent.mobileqq.wxmini.impl.util;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J0\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0007J\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0007J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/util/j;", "", "", "moduleType", "", "subPage", "location", "e", "", "source", "page", "module", "a", "hostScene", "default", "d", "refer", "c", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f327782a = new j();

    j() {
    }

    @JvmStatic
    public static final int a(String source, String page, String module, int location) {
        String str;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(module, "module");
        if (location <= 99 && location >= 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(location)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        } else {
            str = "00";
        }
        return d(source + page + module + str, 0);
    }

    @JvmStatic
    public static final int e(int moduleType, boolean subPage, int location) {
        String str;
        String str2;
        String str3 = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
        if (!subPage) {
            str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
        } else {
            str = "00";
        }
        String str4 = QQHealthReportApiImpl.MSG_EXPOSE_KEY;
        if (moduleType != 1) {
            if (moduleType != 3) {
                switch (moduleType) {
                    case 18:
                        str4 = "003";
                        break;
                    case 19:
                        str4 = "004";
                        break;
                    case 20:
                        str4 = "005";
                        break;
                    case 21:
                        str4 = "006";
                        break;
                    default:
                        str4 = TVKUpdateInfo.APP_ID;
                        break;
                }
                str2 = str;
                return b(null, str2, str4, location, 1, null);
            }
            if (!subPage) {
                str4 = QQHealthReportApiImpl.MSG_CLICK_KEY;
            } else {
                str3 = "03";
            }
        } else if (subPage) {
            str3 = "02";
        }
        str2 = str3;
        return b(null, str2, str4, location, 1, null);
    }

    @JvmStatic
    public static final int d(String hostScene, int r26) {
        if (hostScene == null || hostScene.length() == 0) {
            return r26;
        }
        try {
            return Integer.parseInt(hostScene);
        } catch (NumberFormatException unused) {
            return r26;
        }
    }

    public static /* synthetic */ int b(String str, String str2, String str3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = "200";
        }
        if ((i16 & 2) != 0) {
            str2 = "00";
        }
        if ((i16 & 4) != 0) {
            str3 = TVKUpdateInfo.APP_ID;
        }
        if ((i16 & 8) != 0) {
            i3 = 0;
        }
        return a(str, str2, str3, i3);
    }

    @JvmStatic
    public static final int c(int refer) {
        if (refer == 1007) {
            return b(null, "04", QQHealthReportApiImpl.MSG_EXPOSE_KEY, 0, 9, null);
        }
        if (refer == 1008) {
            return b(null, "04", QQHealthReportApiImpl.MSG_CLICK_KEY, 0, 9, null);
        }
        if (refer == 1043) {
            return b(null, "04", TVKUpdateInfo.APP_ID, 0, 9, null);
        }
        if (refer != 1075) {
            switch (refer) {
                case 1010:
                    return b("115", "24", QQHealthReportApiImpl.MSG_EXPOSE_KEY, 0, 8, null);
                case 1011:
                    return b(null, "05", QQHealthReportApiImpl.MSG_EXPOSE_KEY, 0, 9, null);
                case 1012:
                    return b(null, "06", QQHealthReportApiImpl.MSG_EXPOSE_KEY, 0, 9, null);
                case 1013:
                    return b(null, "07", QQHealthReportApiImpl.MSG_EXPOSE_KEY, 0, 9, null);
                default:
                    return 0;
            }
        }
        return b(null, "04", "005", 0, 9, null);
    }
}
