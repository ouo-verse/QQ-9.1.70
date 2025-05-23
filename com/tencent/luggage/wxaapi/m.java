package com.tencent.luggage.wxaapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface m extends WxaAppCustomActionSheetDelegate {
    void handleCustomAction(@NonNull String str, int i3, int i16, @Nullable JSONObject jSONObject, @NonNull WxaAppCustomActionSheetDelegate.a aVar, @NonNull WxaAppCustomActionSheetDelegate.ActionType actionType, @Nullable Map<String, Object> map);
}
