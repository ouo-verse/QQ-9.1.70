package com.tencent.mobileqq.mini.qbox;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001b\u0010\t\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/mini/qbox/QBoxConfBean;", "", "", "data", "", "transferSizeData", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "parse", "([Lcom/tencent/mobileqq/config/ai;)Lcom/tencent/mobileqq/mini/qbox/QBoxConfBean;", "loadingAnimUrl", "Ljava/lang/String;", "getLoadingAnimUrl", "()Ljava/lang/String;", "setLoadingAnimUrl", "(Ljava/lang/String;)V", "", "widthDP", UserInfo.SEX_FEMALE, "getWidthDP", "()F", "setWidthDP", "(F)V", "heightDP", "getHeightDP", "setHeightDP", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QBoxConfBean {
    public static final float DEFAULT_HEIGHT_DP = 128.0f;
    public static final float DEFAULT_WIDTH_DP = 128.0f;
    private static final String TAG = "QBoxConfBean";
    private String loadingAnimUrl = "";
    private float widthDP = 128.0f;
    private float heightDP = 128.0f;

    public final float getHeightDP() {
        return this.heightDP;
    }

    public final String getLoadingAnimUrl() {
        return this.loadingAnimUrl;
    }

    public final float getWidthDP() {
        return this.widthDP;
    }

    public final QBoxConfBean parse(ai[] confFiles) {
        Intrinsics.checkNotNullParameter(confFiles, "confFiles");
        for (ai aiVar : confFiles) {
            try {
                JSONObject jSONObject = new JSONObject(aiVar.f202268b);
                String optString = jSONObject.optString("loading_anim", null);
                if (optString != null) {
                    this.loadingAnimUrl = optString;
                }
                String optString2 = jSONObject.optString("loading_size", null);
                if (optString2 != null) {
                    transferSizeData(optString2);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "parse exception:" + e16);
            }
        }
        return this;
    }

    public final void setHeightDP(float f16) {
        this.heightDP = f16;
    }

    public final void setLoadingAnimUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loadingAnimUrl = str;
    }

    public final void setWidthDP(float f16) {
        this.widthDP = f16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        r2 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r10, '*', 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void transferSizeData(String data) {
        int indexOf$default;
        if (!(data == null || data.length() == 0) && indexOf$default > 0 && indexOf$default < data.length() - 1) {
            this.widthDP = Integer.parseInt(data.subSequence(0, indexOf$default).toString()) / 2.0f;
            float parseInt = Integer.parseInt(data.subSequence(indexOf$default + 1, data.length()).toString()) / 2.0f;
            this.heightDP = parseInt;
            if (this.widthDP < 0.0f) {
                this.widthDP = 128.0f;
            }
            if (parseInt < 0.0f) {
                this.heightDP = 128.0f;
            }
        }
    }
}
