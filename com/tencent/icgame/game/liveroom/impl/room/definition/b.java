package com.tencent.icgame.game.liveroom.impl.room.definition;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static EnterRoomInfo.VideoDefinition f115203a = EnterRoomInfo.VideoDefinition.FHD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f115204a;

        static {
            int[] iArr = new int[EnterRoomInfo.VideoDefinition.values().length];
            f115204a = iArr;
            try {
                iArr[EnterRoomInfo.VideoDefinition.ORIGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f115204a[EnterRoomInfo.VideoDefinition.FHD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f115204a[EnterRoomInfo.VideoDefinition.SD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f115204a[EnterRoomInfo.VideoDefinition.HD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f115204a[EnterRoomInfo.VideoDefinition.SHD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f115204a[EnterRoomInfo.VideoDefinition.THFD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static ILiveAudienceTPPlayerRoom a(long j3) {
        fu0.c cVar = (fu0.c) qx0.a.b(fu0.c.class);
        if (cVar == null) {
            QLog.w("ICGameDefinitionSwitchHelper", 1, "get room service fail! " + j3);
            return null;
        }
        IAudienceRoom N = cVar.N(j3);
        if (N == null) {
            QLog.w("ICGameDefinitionSwitchHelper", 1, "get audience room fail!" + j3);
            return null;
        }
        if (!(N instanceof ILiveAudienceTPPlayerRoom)) {
            QLog.w("ICGameDefinitionSwitchHelper", 1, "get audience room not player room!" + j3);
            return null;
        }
        return (ILiveAudienceTPPlayerRoom) N;
    }

    public static List<EnterRoomInfo.VideoDefinition> b(long j3) {
        ILiveAudienceTPPlayerRoom a16 = a(j3);
        if (a16 == null) {
            QLog.w("ICGameDefinitionSwitchHelper", 1, "get audience room fail!");
            return new ArrayList();
        }
        List<EnterRoomInfo.VideoDefinition> definitionList = a16.getDefinitionList();
        if (definitionList != null && !definitionList.isEmpty()) {
            return definitionList;
        }
        QLog.w("ICGameDefinitionSwitchHelper", 1, "get room definition list fail!");
        return new ArrayList();
    }

    public static EnterRoomInfo.VideoDefinition c(long j3) {
        ILiveAudienceTPPlayerRoom a16 = a(j3);
        if (a16 == null) {
            return EnterRoomInfo.VideoDefinition.FHD;
        }
        EnterRoomInfo.VideoDefinition videoDefinition = a16.getVideoDefinition();
        if (videoDefinition == EnterRoomInfo.VideoDefinition.ORIGIN) {
            return EnterRoomInfo.VideoDefinition.FHD;
        }
        return videoDefinition;
    }

    public static EnterRoomInfo.VideoDefinition d(long j3, EnterRoomInfo.VideoDefinition videoDefinition) {
        ILiveAudienceTPPlayerRoom a16 = a(j3);
        if (a16 == null) {
            return videoDefinition;
        }
        EnterRoomInfo.VideoDefinition videoDefinition2 = a16.getVideoDefinition();
        if (videoDefinition2 == null) {
            return videoDefinition;
        }
        if (videoDefinition2 == EnterRoomInfo.VideoDefinition.ORIGIN) {
            return EnterRoomInfo.VideoDefinition.FHD;
        }
        return videoDefinition2;
    }

    public static String e(EnterRoomInfo.VideoDefinition videoDefinition) {
        switch (a.f115204a[videoDefinition.ordinal()]) {
            case 1:
            case 2:
                return "\u84dd\u5149";
            case 3:
                return "\u6807\u6e05";
            case 4:
                return "\u9ad8\u6e05";
            case 5:
                return "\u8d85\u6e05";
            case 6:
                return "\u8d85\u84dd\u5149";
            default:
                return "\u672a\u77e5";
        }
    }

    public static EnterRoomInfo.VideoDefinition f() {
        return k(qt0.a.c("USER_SELECT_DEFINITON_LEVEL", f115203a.level));
    }

    public static EnterRoomInfo.VideoDefinition g(String str) {
        EnterRoomInfo.VideoDefinition videoDefinition = EnterRoomInfo.VideoDefinition.FHD;
        try {
            d a16 = d.a();
            long parseLong = Long.parseLong(str);
            IQQLiveSDK l3 = mu0.a.k().l();
            if (l3 != null && l3.getAppRuntime() != null && l3.getAppRuntime().getApplicationContext() != null) {
                videoDefinition = a16.b(l3.getAppRuntime().getApplicationContext(), parseLong);
                g.d("ICGameDefinitionSwitchHelper", "getSpecialRoomVideoDefinition roomId:" + str + "definition " + videoDefinition);
                return videoDefinition;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            g.d("ICGameDefinitionSwitchHelper", "getSpecialRoomVideoDefinition roomId:" + str + "error " + e16.getMessage());
        }
        return videoDefinition;
    }

    private static String h(boolean z16, EnterRoomInfo.VideoDefinition videoDefinition, Bundle bundle) {
        int i3 = a.f115204a[videoDefinition.ordinal()];
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return null;
                    }
                    return i(z16, "flv_720", "rtmp_720", bundle);
                }
                return i(z16, "flv_540", "rtmp_540", bundle);
            }
            return i(z16, "flv_360", "rtmp_360", bundle);
        }
        return i(z16, "flv_1080", "rtmp_1080", bundle);
    }

    private static String i(boolean z16, String str, String str2, Bundle bundle) {
        String str3;
        if (z16) {
            str3 = bundle.getString(str, null);
        } else {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            return bundle.getString(str2, null);
        }
        return str3;
    }

    public static String j(long j3, String str, LiveRoomExtraInfo liveRoomExtraInfo) {
        Bundle bundle;
        if (liveRoomExtraInfo != null && (bundle = liveRoomExtraInfo.E) != null) {
            String string = bundle.getString("level");
            if (TextUtils.isEmpty(string) || string.equalsIgnoreCase(String.valueOf(EnterRoomInfo.VideoDefinition.ORIGIN.level))) {
                string = String.valueOf(f().level);
            }
            EnterRoomInfo.VideoDefinition f16 = f();
            if (d.a().d(j3)) {
                f16 = g(String.valueOf(j3));
            }
            if (!String.valueOf(f16.level).equalsIgnoreCase(string)) {
                g.d("ICGameDefinitionSwitchHelper", "definition is diff, local = " + f16 + " out put int " + string);
                return "";
            }
            boolean z16 = liveRoomExtraInfo.E.getBoolean("is_use_flv");
            String h16 = h(z16, f16, bundle);
            if (!TextUtils.isEmpty(h16)) {
                str = h16;
            }
            QLog.i("ICGameDefinitionSwitchHelper", 1, "getVideoUrl roomId:" + j3 + " definition:" + f16 + " isUseFlv:" + z16 + " url:" + str);
        }
        return str;
    }

    public static EnterRoomInfo.VideoDefinition k(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return EnterRoomInfo.VideoDefinition.ORIGIN;
                        }
                        return EnterRoomInfo.VideoDefinition.THFD;
                    }
                    return EnterRoomInfo.VideoDefinition.FHD;
                }
                return EnterRoomInfo.VideoDefinition.SHD;
            }
            return EnterRoomInfo.VideoDefinition.HD;
        }
        return EnterRoomInfo.VideoDefinition.SD;
    }

    public static boolean l(long j3) {
        if (a(j3) == null) {
            return false;
        }
        return true;
    }

    public static void m(EnterRoomInfo.VideoDefinition videoDefinition) {
        qt0.a.e("USER_SELECT_DEFINITON_LEVEL", videoDefinition.level);
    }
}
