package com.tencent.mobileqq.wink.preprocess;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/preprocess/WinkShareQQSignTransFragment;", "Lcom/tencent/mobileqq/wink/preprocess/WinkAvatarShareTransFragment;", "", "str", "Jh", "newAvatarPath", IProfileCardConst.KEY_FROM_TYPE, "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "editDataWrapper", "yh", "oldScriptParams", "Ih", "Bh", "<init>", "()V", "H", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkShareQQSignTransFragment extends WinkAvatarShareTransFragment {
    private final String Jh(String str) {
        boolean z16;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        if (str.length() > 100) {
            String substring = str.substring(0, 100);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str;
    }

    @Override // com.tencent.mobileqq.wink.preprocess.WinkAvatarShareTransFragment
    @NotNull
    public String Bh(@NotNull String fromType) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        return "\u66f4\u65b0\u4e86\u6211\u7684QQ\u7b7e\u540d\uff0c\u5927\u5bb6\u5feb\u6765\u56f4\u89c2\uff5e#QQ\u7b7e\u540d\u89c6\u9891\u6765\u4e86";
    }

    @NotNull
    public final String Ih(@NotNull String oldScriptParams) {
        String str;
        Intent intent;
        Intrinsics.checkNotNullParameter(oldScriptParams, "oldScriptParams");
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.TEMPLATE_SIGN_TEXT);
        } else {
            str = null;
        }
        String valueOf = String.valueOf(str);
        try {
            JSONObject jSONObject = new JSONObject(oldScriptParams);
            jSONObject.put("descriptionForQQ", Jh(valueOf));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        } catch (JSONException e16) {
            w53.b.c("WinkShareQQSignTransFragment", "getNewScriptParams error: " + e16);
            return oldScriptParams;
        }
    }

    @Override // com.tencent.mobileqq.wink.preprocess.WinkAvatarShareTransFragment
    @NotNull
    public WinkEditDataWrapper yh(@NotNull String newAvatarPath, @NotNull String fromType, @NotNull WinkEditDataWrapper editDataWrapper) {
        String str;
        Intrinsics.checkNotNullParameter(newAvatarPath, "newAvatarPath");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(editDataWrapper, "editDataWrapper");
        HashMap<String, String> assetData = editDataWrapper.getEditDatas().get(0).getAssetData();
        if (assetData != null && (str = assetData.get(LightConstants.EventKey.EVENT_SCRIPT_PARAMS)) != null) {
            HashMap<String, String> assetData2 = editDataWrapper.getEditDatas().get(0).getAssetData();
            if (assetData2 != null) {
                assetData2.remove(LightConstants.EventKey.EVENT_SCRIPT_PARAMS);
            }
            HashMap<String, String> assetData3 = editDataWrapper.getEditDatas().get(0).getAssetData();
            if (assetData3 != null) {
                assetData3.put(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, Ih(str));
            }
        }
        return editDataWrapper;
    }
}
