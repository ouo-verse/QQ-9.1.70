package km0;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b8\u0018\u0000 D2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\tJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005R\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR&\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010 R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\"R\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\"R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010*\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\"R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00100\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\"R\u0016\u00102\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\"R\u0016\u00103\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\"R\u0016\u00105\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\"R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\"R\u0016\u00109\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\"R\u0016\u0010;\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010\"R\u0016\u0010=\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\"R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010\"R\u0016\u0010A\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010\"\u00a8\u0006E"}, d2 = {"Lkm0/i;", "Lcom/tencent/freesia/IConfigData;", "", "content", "t", "", "o", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", DomainData.DOMAIN_NAME, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "e", "d", "c", "i", "k", "j", "r", tl.h.F, "g", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "CONTENT_KEY", "TAG", "Ljava/util/ArrayList;", "adPriority", "I", "adDailyFrequencyCap", "adWeeklyFrequencyCap", "amsAdDailyFrequencyCap", BdhLogUtil.LogTag.Tag_Conn, "tianshuAdDailyFrequencyCap", "D", "Z", "canHotSplash", "E", "hotTimeLimit", UserInfo.SEX_FEMALE, "canAmsHotSplash", "G", "amsHotSplashLimit", "H", "amsHotSplashBgPreloadLimit", "amsHotBgPreloadDuration", "J", "amsHotShowDuration", "K", "amsPreloadDuration", "L", "amsPreloadLimit", "M", "amsShowAndPreloadDuration", "N", "warmDecodeTimeout", "P", "amsOlympicColdSplashLimit", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "amsNormalSplashLimit", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i implements IConfigData {

    /* renamed from: C, reason: from kotlin metadata */
    private int tianshuAdDailyFrequencyCap;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean canHotSplash;

    /* renamed from: E, reason: from kotlin metadata */
    private int hotTimeLimit;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean canAmsHotSplash;

    /* renamed from: G, reason: from kotlin metadata */
    private int amsHotSplashLimit;

    /* renamed from: H, reason: from kotlin metadata */
    private int amsHotSplashBgPreloadLimit;

    /* renamed from: I, reason: from kotlin metadata */
    private int amsHotBgPreloadDuration;

    /* renamed from: J, reason: from kotlin metadata */
    private int amsHotShowDuration;

    /* renamed from: K, reason: from kotlin metadata */
    private int amsPreloadDuration;

    /* renamed from: L, reason: from kotlin metadata */
    private int amsPreloadLimit;

    /* renamed from: M, reason: from kotlin metadata */
    private int amsShowAndPreloadDuration;

    /* renamed from: N, reason: from kotlin metadata */
    private int warmDecodeTimeout;

    /* renamed from: P, reason: from kotlin metadata */
    private int amsOlympicColdSplashLimit;

    /* renamed from: Q, reason: from kotlin metadata */
    private int amsNormalSplashLimit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String CONTENT_KEY = "splashContent";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "SplashAdConfigData";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Integer> adPriority;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int adDailyFrequencyCap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int adWeeklyFrequencyCap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int amsAdDailyFrequencyCap;

    public i() {
        ArrayList<Integer> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(0, 1, 2, 3, 4);
        this.adPriority = arrayListOf;
        this.adDailyFrequencyCap = 1;
        this.adWeeklyFrequencyCap = 7;
        this.amsAdDailyFrequencyCap = 1;
        this.tianshuAdDailyFrequencyCap = 1;
        this.hotTimeLimit = 600000;
        this.amsHotSplashLimit = 1;
        this.amsHotSplashBgPreloadLimit = 8;
        this.amsHotBgPreloadDuration = 20000;
        this.amsHotShowDuration = 120000;
        this.amsPreloadDuration = 20000;
        this.amsPreloadLimit = 8;
        this.amsShowAndPreloadDuration = 10000;
        this.warmDecodeTimeout = 800;
        this.amsNormalSplashLimit = 1;
    }

    /* renamed from: a, reason: from getter */
    public final int getAmsAdDailyFrequencyCap() {
        return this.amsAdDailyFrequencyCap;
    }

    @NotNull
    public final ArrayList<Integer> b() {
        return this.adPriority;
    }

    /* renamed from: c, reason: from getter */
    public final int getAmsHotBgPreloadDuration() {
        return this.amsHotBgPreloadDuration;
    }

    /* renamed from: d, reason: from getter */
    public final int getAmsHotShowDuration() {
        return this.amsHotShowDuration;
    }

    /* renamed from: e, reason: from getter */
    public final int getAmsHotSplashBgPreloadLimit() {
        return this.amsHotSplashBgPreloadLimit;
    }

    /* renamed from: f, reason: from getter */
    public final int getAmsHotSplashLimit() {
        return this.amsHotSplashLimit;
    }

    /* renamed from: g, reason: from getter */
    public final int getAmsNormalSplashLimit() {
        return this.amsNormalSplashLimit;
    }

    /* renamed from: h, reason: from getter */
    public final int getAmsOlympicColdSplashLimit() {
        return this.amsOlympicColdSplashLimit;
    }

    /* renamed from: i, reason: from getter */
    public final int getAmsPreloadDuration() {
        return this.amsPreloadDuration;
    }

    /* renamed from: j, reason: from getter */
    public final int getAmsShowAndPreloadDuration() {
        return this.amsShowAndPreloadDuration;
    }

    /* renamed from: k, reason: from getter */
    public final int getAmsPreloadLimit() {
        return this.amsPreloadLimit;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getCONTENT_KEY() {
        return this.CONTENT_KEY;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getCanAmsHotSplash() {
        return this.canAmsHotSplash;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getCanHotSplash() {
        return this.canHotSplash;
    }

    /* renamed from: o, reason: from getter */
    public final int getAdDailyFrequencyCap() {
        return this.adDailyFrequencyCap;
    }

    /* renamed from: p, reason: from getter */
    public final int getHotTimeLimit() {
        return this.hotTimeLimit;
    }

    /* renamed from: q, reason: from getter */
    public final int getTianshuAdDailyFrequencyCap() {
        return this.tianshuAdDailyFrequencyCap;
    }

    /* renamed from: r, reason: from getter */
    public final int getWarmDecodeTimeout() {
        return this.warmDecodeTimeout;
    }

    /* renamed from: s, reason: from getter */
    public final int getAdWeeklyFrequencyCap() {
        return this.adWeeklyFrequencyCap;
    }

    @NotNull
    public final i t(@Nullable String content) {
        boolean z16;
        boolean z17;
        boolean z18;
        i iVar = new i();
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(this.TAG, 1, "data is null");
            return iVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            this.adDailyFrequencyCap = jSONObject.optInt("dayLimit", 1);
            this.adWeeklyFrequencyCap = jSONObject.optInt("weekLimit", 7);
            this.amsAdDailyFrequencyCap = jSONObject.optInt("amsDayLimit", 1);
            this.tianshuAdDailyFrequencyCap = jSONObject.optInt("tianshuDayLimit", 1);
            if (jSONObject.optInt("warm", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.canHotSplash = z17;
            this.hotTimeLimit = jSONObject.optInt("warmTime", 600) * 1000;
            if (jSONObject.optInt("warmAms", 0) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.canAmsHotSplash = z18;
            this.amsHotSplashLimit = jSONObject.optInt("warmAmsDayLimit", 1);
            this.amsHotSplashBgPreloadLimit = jSONObject.optInt("warmAmsBgPreload", 8);
            this.amsHotBgPreloadDuration = jSONObject.optInt("warmAmsBgPreloadDuration", 20) * 1000;
            this.amsHotShowDuration = jSONObject.optInt("warmAmsShowDuration", 120) * 1000;
            this.amsPreloadDuration = jSONObject.optInt("amsPreloadDuration", 20) * 1000;
            this.amsPreloadLimit = jSONObject.optInt("amsPreloadLimit", 8);
            this.warmDecodeTimeout = jSONObject.optInt("warmDecodeTimeout", 800);
            this.amsShowAndPreloadDuration = jSONObject.optInt("amsShowAndPreloadDuration", 10) * 1000;
            this.amsOlympicColdSplashLimit = jSONObject.optInt("amsOlympicShowLimit", 0);
            this.amsNormalSplashLimit = jSONObject.optInt("amsNormalShowLimit", 1);
            Object opt = jSONObject.opt("splashPriority");
            if (opt != null) {
                JSONArray jSONArray = (JSONArray) opt;
                if (jSONArray.length() >= this.adPriority.size()) {
                    this.adPriority.clear();
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        ArrayList<Integer> arrayList = this.adPriority;
                        Object obj = jSONArray.get(i3);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                        arrayList.add((Integer) obj);
                    }
                }
            }
            QLog.d(this.TAG, 2, this.adPriority);
        } catch (JSONException e16) {
            QLog.e(this.TAG, 1, e16, new Object[0]);
        }
        return iVar;
    }
}
