package com.tencent.robot.adelie.kuikly.module;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotStatus;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.adelie.kuikly.database.AdelieKuiklyDatabase;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.qqmc.RobotQQMC;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import e24.KuiklyData;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&JI\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016JI\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0017J;\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042%\u0010\f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006H\u0002J9\u0010\u000f\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042%\u0010\f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006H\u0002J9\u0010\u0010\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042%\u0010\f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0003J\b\u0010\u0014\u001a\u00020\u0002H\u0002J?\u0010\u0015\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0016\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0017\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J?\u0010\u0019\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u001a\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u001b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0003J?\u0010\u001c\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010 \u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J3\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00022!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\n0\u0006H\u0002J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010$\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002\u00a8\u0006)"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/module/AdelieKuiklyBaseModule;", "Li01/e;", "", "method", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "y", "w", "H", "", "D", "t", "r", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "J", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "K", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "L", "M", "robotUin", "p", "O", "N", "<init>", "()V", "d", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieKuiklyBaseModule extends i01.e {
    private final void A(String params, final Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call saveStringToDB params is null, return");
            if (callback != null) {
                r.c(callback, "params is null", null, 2, null);
                return;
            }
            return;
        }
        final String optString = new JSONObject(params).optString("key");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.module.f
            @Override // java.lang.Runnable
            public final void run() {
                AdelieKuiklyBaseModule.B(optString, callback);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(String key, Function1 function1) {
        String str;
        try {
            e24.a c16 = AdelieKuiklyDatabase.INSTANCE.a().c();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            KuiklyData a16 = c16.a(key);
            if (a16 != null) {
                str = a16.getDataValue();
            } else {
                str = null;
            }
            if (function1 != null) {
                r.d(function1, str);
            }
        } catch (Throwable th5) {
            if (function1 != null) {
                r.c(function1, String.valueOf(th5.getMessage()), null, 2, null);
            }
        }
    }

    private final String C(String params) {
        boolean z16;
        boolean z17 = false;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call getStringFromCache params is null, return");
            return null;
        }
        JSONObject jSONObject = new JSONObject(params);
        String key = jSONObject.optString("key");
        String optString = jSONObject.optString(RemoteHandleConst.PARAM_DEFAULT_VALUE);
        Intrinsics.checkNotNullExpressionValue(key, "key");
        if (key.length() == 0) {
            z17 = true;
        }
        if (z17) {
            return optString;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_ADELIE);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_ADELIE)");
        return fromV2.getString(key, optString);
    }

    private final boolean D(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call isQQMCSwitchOn params is null, return");
            return false;
        }
        JSONObject jSONObject = new JSONObject(params);
        String key = jSONObject.optString("key");
        boolean optBoolean = jSONObject.optBoolean(RemoteHandleConst.PARAM_DEFAULT_VALUE);
        RobotQQMC robotQQMC = RobotQQMC.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(key, "key");
        return robotQQMC.isSwitchOn(key, optBoolean);
    }

    private final void E(String params, Function1<Object, Unit> callback) {
        boolean z16;
        String str;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call isQQMCSwitchOn params is null, return");
            if (callback != null) {
                r.c(callback, "params is null", null, 2, null);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String key = jSONObject.optString("key");
        boolean optBoolean = jSONObject.optBoolean(RemoteHandleConst.PARAM_DEFAULT_VALUE);
        RobotQQMC robotQQMC = RobotQQMC.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(key, "key");
        boolean isSwitchOn = robotQQMC.isSwitchOn(key, optBoolean);
        if (callback != null) {
            if (isSwitchOn) {
                str = "1";
            } else {
                str = "0";
            }
            r.d(callback, str);
        }
    }

    private final void F(String params, final Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call saveStringToDB params is null, return");
            if (callback != null) {
                r.c(callback, "params is null", null, 2, null);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        final String optString = jSONObject.optString("key");
        final String optString2 = jSONObject.optString("value");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.module.b
            @Override // java.lang.Runnable
            public final void run() {
                AdelieKuiklyBaseModule.G(optString, optString2, callback);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(String key, String value, Function1 function1) {
        try {
            e24.a c16 = AdelieKuiklyDatabase.INSTANCE.a().c();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            c16.b(new KuiklyData(key, value, new byte[0]));
            r.e(function1, null, 1, null);
        } catch (Throwable th5) {
            if (function1 != null) {
                r.c(function1, String.valueOf(th5.getMessage()), null, 2, null);
            }
        }
    }

    private final void H(Object params, final Function1<Object, Unit> callback) {
        Object[] objArr;
        boolean z16;
        final String str;
        final byte[] bArr;
        if (params instanceof Object[]) {
            objArr = (Object[]) params;
        } else {
            objArr = null;
        }
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        QLog.i("AdelieKuiklyBaseModule", 1, "handleSetByteArrayCache key:" + str);
        Object obj2 = objArr[1];
        if (obj2 instanceof byte[]) {
            bArr = (byte[]) obj2;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.module.e
            @Override // java.lang.Runnable
            public final void run() {
                AdelieKuiklyBaseModule.I(str, bArr, callback);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(String key, byte[] byteArray, Function1 function1) {
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(byteArray, "$byteArray");
        try {
            AdelieKuiklyDatabase.INSTANCE.a().c().b(new KuiklyData(key, "", byteArray));
            r.e(function1, null, 1, null);
        } catch (Throwable th5) {
            r.c(function1, String.valueOf(th5.getMessage()), null, 2, null);
        }
    }

    private final void J(String params, Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17 = false;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call setStringToCache params is null, return");
            if (callback != null) {
                r.c(callback, "params is null", null, 2, null);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String key = jSONObject.optString("key");
        String optString = jSONObject.optString("value");
        Intrinsics.checkNotNullExpressionValue(key, "key");
        if (key.length() == 0) {
            z17 = true;
        }
        if (z17) {
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_ADELIE);
        fromV2.remove(key);
        fromV2.putString(key, optString);
    }

    private final void K(String params, Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17 = false;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call share params is null, return");
            if (callback != null) {
                r.c(callback, "params is null", null, 2, null);
                return;
            }
            return;
        }
        String uin = new JSONObject(params).optString("uin");
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        if (uin.length() == 0) {
            z17 = true;
        }
        if (z17) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call share uin is null, return");
            if (callback != null) {
                r.c(callback, "share uin is null", null, 2, null);
                return;
            }
            return;
        }
        p(uin, new AdelieKuiklyBaseModule$handleShareRobot$1(this, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L(GroupRobotProfile robotProfile) {
        String str;
        boolean z16;
        String str2;
        boolean z17;
        String str3;
        boolean z18;
        String str4;
        boolean z19;
        boolean z26;
        RobotBaseInfo robotBaseInfo;
        RobotBaseInfo robotBaseInfo2;
        RobotBaseInfo robotBaseInfo3;
        RobotBaseInfo robotBaseInfo4;
        String str5 = null;
        if (robotProfile != null && (robotBaseInfo4 = robotProfile.robotData) != null) {
            str = Long.valueOf(robotBaseInfo4.robotUin).toString();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (robotProfile != null && (robotBaseInfo3 = robotProfile.robotData) != null) {
                str2 = Long.valueOf(robotBaseInfo3.appid).toString();
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (robotProfile == null || (robotBaseInfo2 = robotProfile.robotData) == null || (str3 = robotBaseInfo2.name) == null) {
                    str3 = null;
                }
                if (str3 != null && str3.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    if (robotProfile == null || (robotBaseInfo = robotProfile.robotData) == null || (str4 = robotBaseInfo.robotAvatar) == null) {
                        str4 = null;
                    }
                    if (str4 != null && str4.length() != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (!z19) {
                        if (robotProfile != null) {
                            str5 = robotProfile.jumpUrl;
                        }
                        if (str5 != null && str5.length() != 0) {
                            z26 = false;
                        } else {
                            z26 = true;
                        }
                        if (!z26) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M(GroupRobotProfile robotProfile) {
        RobotStatus robotStatus;
        RobotStatus robotStatus2;
        RobotBaseInfo robotBaseInfo;
        RobotBaseInfo robotBaseInfo2;
        RobotBaseInfo robotBaseInfo3;
        RobotStatus robotStatus3 = null;
        if (robotProfile != null && (robotBaseInfo3 = robotProfile.robotData) != null) {
            robotStatus = robotBaseInfo3.robotStatus;
        } else {
            robotStatus = null;
        }
        if (robotStatus != RobotStatus.KBANNED) {
            if (robotProfile != null && (robotBaseInfo2 = robotProfile.robotData) != null) {
                robotStatus2 = robotBaseInfo2.robotStatus;
            } else {
                robotStatus2 = null;
            }
            if (robotStatus2 != RobotStatus.KOFFLINE) {
                if (robotProfile != null && (robotBaseInfo = robotProfile.robotData) != null) {
                    robotStatus3 = robotBaseInfo.robotStatus;
                }
                if (robotStatus3 != RobotStatus.KDELETED) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void N(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String eventName = jSONObject.optString("event_name", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("report_param");
        if (optJSONObject != null) {
            Intrinsics.checkNotNullExpressionValue(eventName, "eventName");
            com.tencent.robot.adelie.homepage.utils.d.b("0AND0YAG6R40RLM6", eventName, CommonExKt.m(optJSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(GroupRobotProfile robotProfile) {
        Long l3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String l16;
        String l17;
        RobotBaseInfo robotBaseInfo = robotProfile.robotData;
        String str9 = null;
        if (robotBaseInfo != null) {
            l3 = Long.valueOf(robotBaseInfo.robotUin);
        } else {
            l3 = null;
        }
        QLog.i("AdelieKuiklyBaseModule", 1, "showRobotShareActionSheet robotUin = " + l3);
        if (getActivity() == null) {
            QLog.i("AdelieKuiklyBaseModule", 1, "showRobotShareActionSheet activity is null");
            return;
        }
        RobotBaseInfo robotBaseInfo2 = robotProfile.robotData;
        if (robotBaseInfo2 == null || (l17 = Long.valueOf(robotBaseInfo2.robotUin).toString()) == null) {
            str = "";
        } else {
            str = l17;
        }
        RobotBaseInfo robotBaseInfo3 = robotProfile.robotData;
        if (robotBaseInfo3 == null || (l16 = Long.valueOf(robotBaseInfo3.appid).toString()) == null) {
            str2 = "";
        } else {
            str2 = l16;
        }
        RobotBaseInfo robotBaseInfo4 = robotProfile.robotData;
        String str10 = robotBaseInfo4.name;
        if (str10 == null) {
            str3 = "";
        } else {
            str3 = str10;
        }
        if (robotBaseInfo4 != null) {
            str4 = robotBaseInfo4.desc;
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        if (robotBaseInfo4 != null) {
            str9 = robotBaseInfo4.robotAvatar;
        }
        if (str9 == null) {
            str6 = "";
        } else {
            str6 = str9;
        }
        String str11 = robotProfile.jumpUrl;
        if (str11 == null) {
            str7 = "";
        } else {
            str7 = str11;
        }
        boolean z16 = robotBaseInfo4.allowedAddC2C;
        String str12 = robotBaseInfo4.robotUid;
        if (str12 == null) {
            str8 = "";
        } else {
            str8 = str12;
        }
        RobotInfo robotInfo = new RobotInfo(str2, str3, str5, str6, str7, str, null, z16, str8, 64, null);
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        new com.tencent.robot.share.k(activity, robotInfo, "bot_manage", null, 8, null).l();
    }

    private final void p(final String robotUin, final Function1<? super GroupRobotProfile, Unit> callback) {
        QLog.i("AdelieKuiklyBaseModule", 1, "fetchRobotProfile robotUin = " + robotUin);
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfoFromServer(robotUin, null, new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.adelie.kuikly.module.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                AdelieKuiklyBaseModule.q(robotUin, callback, i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String robotUin, Function1 callback, int i3, String str, GroupRobotProfile robotProfile) {
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("AdelieKuiklyBaseModule", 1, "fetchRobotProfile callback robotUin = " + robotUin + " result = " + i3 + " errMsg = " + str);
        Intrinsics.checkNotNullExpressionValue(robotProfile, "robotProfile");
        callback.invoke(robotProfile);
    }

    private final String r() {
        String currentUin;
        String p16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (currentUin = peekAppRuntime.getCurrentUin()) == null) {
            return "";
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(currentUin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uid, "AdelieKuiklyBaseModule");
        if (friendsSimpleInfoWithUid == null || (p16 = friendsSimpleInfoWithUid.p()) == null) {
            return "";
        }
        return p16;
    }

    @RequiresApi(19)
    private final String t(String params) {
        boolean z16;
        boolean z17 = false;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        byte[] bArr = null;
        if (z16) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call getQQMCConfig params is null, return");
            return null;
        }
        JSONObject jSONObject = new JSONObject(params);
        String key = jSONObject.optString("key");
        String optString = jSONObject.optString(RemoteHandleConst.PARAM_DEFAULT_VALUE);
        try {
            IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            bArr = iUnitedConfigManager.loadRawConfig(key, new byte[0]);
        } catch (Throwable th5) {
            QLog.e("AdelieKuiklyBaseModule", 1, "loadRawConfig " + key + " fail.", th5);
        }
        if (bArr != null) {
            if (bArr.length == 0) {
                z17 = true;
            }
            if (!z17) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                return new String(bArr, UTF_8);
            }
            return optString;
        }
        return optString;
    }

    private final void u(String params, final Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call saveStringToDB params is null, return");
            if (callback != null) {
                r.c(callback, "params is null", null, 2, null);
                return;
            }
            return;
        }
        final String optString = new JSONObject(params).optString("key");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.module.c
            @Override // java.lang.Runnable
            public final void run() {
                AdelieKuiklyBaseModule.v(optString, callback);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(String key, Function1 function1) {
        try {
            e24.a c16 = AdelieKuiklyDatabase.INSTANCE.a().c();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            c16.c(key);
            if (function1 != null) {
                r.e(function1, null, 1, null);
            }
        } catch (Throwable th5) {
            if (function1 != null) {
                r.c(function1, String.valueOf(th5.getMessage()), null, 2, null);
            }
        }
    }

    private final void w(Object params, final Function1<Object, Unit> callback) {
        Object[] objArr;
        boolean z16;
        final String str;
        QLog.i("AdelieKuiklyBaseModule", 1, "handleGetByteArrayCacheAsync start at " + System.currentTimeMillis());
        if (params instanceof Object[]) {
            objArr = (Object[]) params;
        } else {
            objArr = null;
        }
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        QLog.i("AdelieKuiklyBaseModule", 1, "handleGetByteArrayCacheAsync key:" + str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.module.a
            @Override // java.lang.Runnable
            public final void run() {
                AdelieKuiklyBaseModule.x(str, callback);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(String key, Function1 function1) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(key, "$key");
        try {
            KuiklyData a16 = AdelieKuiklyDatabase.INSTANCE.a().c().a(key);
            if (a16 != null) {
                bArr = a16.getByteArray();
            } else {
                bArr = null;
            }
            QLog.i("AdelieKuiklyBaseModule", 1, "handleGetByteArrayCacheAsync end at " + System.currentTimeMillis());
            if (function1 != null) {
                if (!(bArr instanceof Object)) {
                    bArr = null;
                }
                function1.invoke(bArr);
            }
        } catch (Throwable th5) {
            r.c(function1, String.valueOf(th5.getMessage()), null, 2, null);
        }
    }

    private final Object y(Object params, Function1<Object, Unit> callback) {
        Object[] objArr;
        boolean z16;
        String str;
        if (params instanceof Object[]) {
            objArr = (Object[]) params;
        } else {
            objArr = null;
        }
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        Object obj = objArr[0];
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        QLog.i("AdelieKuiklyBaseModule", 1, "handleGetByteArrayCacheSync key:" + str);
        try {
            KuiklyData a16 = AdelieKuiklyDatabase.INSTANCE.a().c().a(str);
            if (a16 == null) {
                return null;
            }
            return a16.getByteArray();
        } catch (Throwable th5) {
            r.c(callback, String.valueOf(th5.getMessage()), null, 2, null);
            return null;
        }
    }

    @RequiresApi(19)
    private final void z(String params, Function1<Object, Unit> callback) {
        boolean z16;
        byte[] bArr;
        boolean z17 = false;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyBaseModule", 1, "call getQQMCConfig params is null, return");
            if (callback != null) {
                r.d(callback, "{}");
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String key = jSONObject.optString("key");
        String optString = jSONObject.optString(RemoteHandleConst.PARAM_DEFAULT_VALUE);
        try {
            IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            bArr = iUnitedConfigManager.loadRawConfig(key, new byte[0]);
        } catch (Throwable th5) {
            QLog.e("AdelieKuiklyBaseModule", 1, "loadRawConfig " + key + " fail.", th5);
            bArr = null;
        }
        if (bArr != null) {
            if (bArr.length == 0) {
                z17 = true;
            }
            if (!z17) {
                if (callback != null) {
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    r.d(callback, new String(bArr, UTF_8));
                    return;
                }
                return;
            }
        }
        if (callback != null) {
            r.d(callback, optString);
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -452740619) {
            if (hashCode != 1360438483) {
                if (hashCode == 1371410434 && method.equals("getByteArrayCacheSync")) {
                    return y(params, callback);
                }
            } else if (method.equals("setByteArrayCache")) {
                H(params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("getByteArrayCacheAsync")) {
            w(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // i01.e, i01.a
    @RequiresApi(19)
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1800127029:
                if (method.equals("shareRobot")) {
                    K(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1691698125:
                if (method.equals("isQQMCSwitchOn")) {
                    E(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1222183247:
                if (method.equals("getStringFromCache")) {
                    return C(params);
                }
                break;
            case -1134157005:
                if (method.equals("deleteFromDB")) {
                    u(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 102323864:
                if (method.equals("reportBeacon")) {
                    N(params);
                    return Unit.INSTANCE;
                }
                break;
            case 161340969:
                if (method.equals("getQQMCConfigSync")) {
                    return t(params);
                }
                break;
            case 257678132:
                if (method.equals("setStringToCache")) {
                    J(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 963800391:
                if (method.equals("saveStringToDB")) {
                    F(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 1005794926:
                if (method.equals("getQQMCConfig")) {
                    z(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 1333242767:
                if (method.equals("getStringFromDB")) {
                    A(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 1382218094:
                if (method.equals("isQQMCSwitchOnSync")) {
                    return Boolean.valueOf(D(params));
                }
                break;
            case 1523476313:
                if (method.equals("getCurrentUserName")) {
                    return r();
                }
                break;
        }
        return super.call(method, params, callback);
    }
}
