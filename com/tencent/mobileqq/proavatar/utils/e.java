package com.tencent.mobileqq.proavatar.utils;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/proavatar/utils/e;", "", "Lcom/tencent/mobileqq/data/Setting;", "setting", "Lorg/json/JSONObject;", "b", "", "jsonStr", "a", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f259721a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33970);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f259721a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final Setting a(@NotNull String jsonStr) {
        boolean z16;
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        boolean z17 = false;
        if (jsonStr.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(jsonStr);
        try {
            Setting setting = new Setting();
            String string = jSONObject.getString("url");
            setting.url = string;
            if (string == null || string.length() == 0) {
                z17 = true;
            }
            if (z17) {
                return null;
            }
            setting.zplanFaceBgUrl = jSONObject.getString(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_BG_URL);
            setting.apngFaceFlag = (byte) jSONObject.getInt(FaceConstant.AvatarInfoBuilderKeys.APNG_FACE_FLAG);
            setting.headImgTimestamp = jSONObject.getLong(FaceConstant.AvatarInfoBuilderKeys.HEAD_IMG_TIMESTAMP);
            setting.staticZplanFaceFlag = (byte) jSONObject.getInt(FaceConstant.AvatarInfoBuilderKeys.STATIC_ZPLAN_FACE_FLAG);
            setting.zplanFaceClipPercent = jSONObject.getInt(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_CLIP_PERCENT);
            setting.uin = jSONObject.getString("uin");
            setting.bUsrType = (byte) jSONObject.getInt("bUsrType");
            setting.updateTimestamp = jSONObject.getLong("updateTimestamp");
            setting.bFaceFlags = (byte) jSONObject.getInt("bFaceFlags");
            return setting;
        } catch (JSONException e16) {
            QLog.e("SettingUtils", 1, "parseFromJson jsonException ", e16);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final JSONObject b(@NotNull Setting setting) {
        boolean z16;
        Intrinsics.checkNotNullParameter(setting, "setting");
        String str = setting.url;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = setting.url;
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("url", str2);
            String str4 = setting.zplanFaceBgUrl;
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_BG_URL, str4);
            jSONObject.put(FaceConstant.AvatarInfoBuilderKeys.APNG_FACE_FLAG, Byte.valueOf(setting.apngFaceFlag));
            jSONObject.put(FaceConstant.AvatarInfoBuilderKeys.HEAD_IMG_TIMESTAMP, setting.headImgTimestamp);
            jSONObject.put(FaceConstant.AvatarInfoBuilderKeys.STATIC_ZPLAN_FACE_FLAG, Byte.valueOf(setting.staticZplanFaceFlag));
            jSONObject.put(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_CLIP_PERCENT, setting.zplanFaceClipPercent);
            String str5 = setting.uin;
            if (str5 != null) {
                str3 = str5;
            }
            jSONObject.put("uin", str3);
            jSONObject.put("bUsrType", Byte.valueOf(setting.bUsrType));
            jSONObject.put("updateTimestamp", setting.updateTimestamp);
            jSONObject.put("bFaceFlags", Byte.valueOf(setting.bFaceFlags));
            return jSONObject;
        } catch (JSONException e16) {
            QLog.e("SettingUtils", 1, "toJson jsonException ", e16);
            return null;
        }
    }
}
