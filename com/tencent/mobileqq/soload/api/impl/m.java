package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IShiply;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.biz.entity.RelatedFileInfo;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\n\u001a\u00020\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/soload/api/impl/m;", "", "", "c", "", "soName", "", "d", "Lorg/json/JSONArray;", "value", "a", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/mobileqq/soload/biz/entity/SoDetailInfo;", "b", "Lorg/json/JSONArray;", "soArray", "Z", "hasSoArrayInited", "", "[Ljava/lang/String;", "forceShiplySoArray", "<init>", "()V", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f288614a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static JSONArray soArray;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean hasSoArrayInited;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] forceShiplySoArray;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20826);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f288614a = new m();
            forceShiplySoArray = new String[]{"brotli", "qqminigamewebaudio", "jingle_peerconnection_so_tenc", "gmcg_webrtc", "PcdnTegTransSdk", "r265_enc", SoLoadConstants.SONAME_TPCORE_MASTER, SoLoadConstants.SONAME_DOWNLOADPROXY, SoLoadConstants.SONAME_TRTC};
        }
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final synchronized void c() {
        String str;
        if (hasSoArrayInited) {
            return;
        }
        if (1 == MobileQQ.sProcessId) {
            soArray = ((IShiply) QRoute.api(IShiply.class)).getJSONArray("so_list_using_shiply_channel", null);
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            JSONArray jSONArray = soArray;
            if (jSONArray == null || (str = jSONArray.toString()) == null) {
                str = "";
            }
            from.encodeString("so_list_using_shiply_channel", str);
            QLog.i("ShiplyHelper", 1, "ensureInitSwitch main process, soArray = " + soArray);
        } else {
            MMKVOptionEntity from2 = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from2, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            String decodeString = from2.decodeString("so_list_using_shiply_channel", "");
            try {
                Result.Companion companion = Result.INSTANCE;
                soArray = new JSONArray(decodeString);
                Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            QLog.i("ShiplyHelper", 1, "ensureInitSwitch sub process " + MobileQQ.sProcessId + ", soArray = " + soArray + ", soArrayStr = " + decodeString);
        }
        hasSoArrayInited = true;
    }

    public final boolean a(@NotNull JSONArray jSONArray, @NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONArray, (Object) value)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (Intrinsics.areEqual(jSONArray.optString(i3), value)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final SoDetailInfo b(@NotNull com.tencent.rdelivery.reshub.api.g result) {
        Unit unit;
        String str = "";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SoDetailInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) result);
        }
        Intrinsics.checkNotNullParameter(result, "result");
        SoDetailInfo soDetailInfo = new SoDetailInfo();
        soDetailInfo.url = result.b();
        soDetailInfo.md5 = result.a();
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(result.d());
            soDetailInfo.ver = jSONObject.optString("so_version", "");
            soDetailInfo.crc = jSONObject.optLong("socrc", -1L);
            JSONObject jsonRelatedFile = jSONObject.optJSONObject("related_file");
            if (jsonRelatedFile != null) {
                Intrinsics.checkNotNullExpressionValue(jsonRelatedFile, "jsonRelatedFile");
                String optString = jsonRelatedFile.optString("url");
                if (optString == null) {
                    optString = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(optString, "it.optString(KEY_RELATED_FILE_URL) ?: \"\"");
                }
                String optString2 = jsonRelatedFile.optString("md5");
                if (optString2 != null) {
                    Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(KEY_RELATED_FILE_MD5) ?: \"\"");
                    str = optString2;
                }
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(str)) {
                    RelatedFileInfo relatedFileInfo = new RelatedFileInfo();
                    soDetailInfo.relatedFileInfo = relatedFileInfo;
                    relatedFileInfo.url = optString;
                    relatedFileInfo.md5 = str;
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        return soDetailInfo;
    }

    public final boolean d(@NotNull String soName) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) soName)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(soName, "soName");
        contains = ArraysKt___ArraysKt.contains(forceShiplySoArray, soName);
        if (contains) {
            if (QLog.isDebugVersion()) {
                QLog.d("ShiplyHelper", 4, "needUseShiplyChannel: force shiply, soName=" + soName);
                return true;
            }
            return true;
        }
        c();
        JSONArray jSONArray = soArray;
        if (jSONArray != null) {
            return f288614a.a(jSONArray, soName);
        }
        return false;
    }
}
