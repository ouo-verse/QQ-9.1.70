package com.tencent.mobileqq.hippy;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/hippy/a;", "Lcom/tencent/freesia/IConfigData;", "", "content", "b", "", "d", "Z", "a", "()Z", "setDownloadEnable", "(Z)V", "downloadEnable", "<init>", "()V", "e", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean downloadEnable;

    /* renamed from: a, reason: from getter */
    public final boolean getDownloadEnable() {
        return this.downloadEnable;
    }

    @NotNull
    public final a b(@Nullable String content) {
        boolean z16;
        a aVar = new a();
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("HippyDownloadConfigData", 1, "data is null");
            return aVar;
        }
        try {
            aVar.downloadEnable = new JSONObject(content).optBoolean("downloadEnable");
        } catch (JSONException e16) {
            QLog.e("HippyDownloadConfigData", 1, e16, new Object[0]);
        }
        return aVar;
    }
}
