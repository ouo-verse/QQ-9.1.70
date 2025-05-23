package km0;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 %2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0005\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"\u0004\b!\u0010\u001e\u00a8\u0006&"}, d2 = {"Lkm0/b;", "Lcom/tencent/freesia/IConfigData;", "", "content", "f", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "CONTENT_KEY", "", "e", "D", "a", "()D", "setBannerAioPullJumpProcess", "(D)V", "bannerAioPullJumpProcess", "", "J", "b", "()J", "setBannerRequestDelay", "(J)V", "bannerRequestDelay", "", tl.h.F, "Z", "()Z", "setCanShowTabAmsBanner", "(Z)V", "canShowTabAmsBanner", "i", "setCanShowTabAmsBannerGuide", "canShowTabAmsBannerGuide", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String CONTENT_KEY = "amsBannerAdConfig";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private double bannerAioPullJumpProcess = 0.1d;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long bannerRequestDelay = 5000;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean canShowTabAmsBanner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean canShowTabAmsBannerGuide;

    @NotNull
    private static final String C = "AmsBannerAdConfigData";

    /* renamed from: a, reason: from getter */
    public final double getBannerAioPullJumpProcess() {
        return this.bannerAioPullJumpProcess;
    }

    /* renamed from: b, reason: from getter */
    public final long getBannerRequestDelay() {
        return this.bannerRequestDelay;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCONTENT_KEY() {
        return this.CONTENT_KEY;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getCanShowTabAmsBanner() {
        return this.canShowTabAmsBanner;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getCanShowTabAmsBannerGuide() {
        return this.canShowTabAmsBannerGuide;
    }

    @NotNull
    public final b f(@Nullable String content) {
        boolean z16;
        boolean z17;
        boolean z18;
        b bVar = new b();
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(C, 1, "data is null");
            return bVar;
        }
        QLog.e(C, 1, "data is " + content);
        try {
            JSONObject jSONObject = new JSONObject(content);
            if (jSONObject.optInt("amsBannerSwitch", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.canShowTabAmsBanner = z17;
            if (jSONObject.optInt("amsBannerPullJumpEnable", 0) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.canShowTabAmsBannerGuide = z18;
            this.bannerRequestDelay = jSONObject.optLong("amsBannerRequestDelay", 5000L);
            double optDouble = jSONObject.optDouble("amsBannerPullJumpProcess", 0.1d);
            this.bannerAioPullJumpProcess = optDouble;
            if (optDouble > 0.11d) {
                this.bannerAioPullJumpProcess = 0.11d;
            }
        } catch (JSONException e16) {
            QLog.e(C, 1, e16, new Object[0]);
        }
        return this;
    }
}
