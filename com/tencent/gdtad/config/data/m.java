package com.tencent.gdtad.config.data;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/gdtad/config/data/m;", "Lcom/tencent/freesia/IConfigData;", "", "content", "b", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "lebaShoppingDisclaimerConfigJson", "a", "()Lorg/json/JSONObject;", "configJson", "<init>", "()V", "e", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class m implements IConfigData {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f109151f = "LebaShoppingDisclaimerConfig";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private JSONObject lebaShoppingDisclaimerConfigJson = new JSONObject();

    @NotNull
    /* renamed from: a, reason: from getter */
    public final JSONObject getLebaShoppingDisclaimerConfigJson() {
        return this.lebaShoppingDisclaimerConfigJson;
    }

    @NotNull
    public final m b(@Nullable String content) {
        boolean z16;
        m mVar = new m();
        String str = f109151f;
        QLog.d(str, 1, "content is " + content);
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(str, 1, "data is null");
            return mVar;
        }
        try {
            mVar.lebaShoppingDisclaimerConfigJson = new JSONObject(content);
        } catch (JSONException e16) {
            QLog.e(f109151f, 1, e16, new Object[0]);
        }
        return mVar;
    }
}
