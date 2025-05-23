package com.tencent.mobileqq.profilecard.vas.misc;

import android.graphics.Color;
import com.heytap.databaseengine.apiv2.health.HeytapHealthParams;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/misc/VasProfileTemplatePreloadHelper;", "", "()V", "BACKGROUND", "", HeytapHealthParams.BODY, "HEADER", "TAG", "TITLE_STYLE", "URL_PREFIX", "initDiyData", "", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class VasProfileTemplatePreloadHelper {

    @NotNull
    public static final String BACKGROUND = "bg";

    @NotNull
    public static final String BODY = "body";

    @NotNull
    public static final String HEADER = "header";

    @NotNull
    public static final VasProfileTemplatePreloadHelper INSTANCE = new VasProfileTemplatePreloadHelper();

    @NotNull
    public static final String TAG = "VasProfileTemplatePreloadHelper";

    @NotNull
    public static final String TITLE_STYLE = "ts";

    @NotNull
    public static final String URL_PREFIX = "path";

    VasProfileTemplatePreloadHelper() {
    }

    public final boolean initDiyData(@NotNull ProfileCardInfo cardInfo) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        cardInfo.removeBusinessInfo(VasDiyData.class);
        String str = cardInfo.card.diyComplicatedInfo;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(TAG, 1, " diy info is null!");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String urlPrefix = jSONObject.optString("path", "");
            Object opt = jSONObject.opt(BACKGROUND);
            if (opt != null) {
                Object opt2 = jSONObject.opt("header");
                if (opt2 != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("body");
                    if (optJSONObject != null) {
                        try {
                            i3 = Color.parseColor(optJSONObject.optString("c"));
                        } catch (IllegalArgumentException unused) {
                            i3 = -16777216;
                        }
                        int i16 = i3;
                        int optInt = optJSONObject.optInt("ts", 0);
                        Intrinsics.checkNotNullExpressionValue(urlPrefix, "urlPrefix");
                        cardInfo.putBusinessInfo(new VasDiyData(urlPrefix, optInt, i16, opt2, optJSONObject, opt));
                        return true;
                    }
                    throw new JSONException("json have no body!! " + jSONObject);
                }
                throw new JSONException("json have no header!! " + jSONObject);
            }
            throw new JSONException("json have no background!! " + jSONObject);
        } catch (Exception e16) {
            QLog.e(TAG, 1, " diy info is null!", e16);
            return false;
        }
    }
}
