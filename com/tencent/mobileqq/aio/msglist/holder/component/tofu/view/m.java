package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import com.tencent.mobileqq.aio.msg.ah;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0003H\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ah;", "", "isNowThemeIsNight", "", "b", "Lorg/json/JSONObject;", "c", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class m {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(ah ahVar, boolean z16) {
        JSONObject c16 = c(ahVar.l2());
        if (c16 == null) {
            return null;
        }
        String string = c16.getString("light_bg_url");
        String string2 = c16.getString("night_bg_url");
        if (z16) {
            return string2;
        }
        return string;
    }

    private static final JSONObject c(String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            try {
            } catch (JSONException unused) {
                return null;
            }
        }
        return new JSONObject(str);
    }
}
