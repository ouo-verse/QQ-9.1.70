package km0;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 >2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\"\u0010 \u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010-\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b\u000f\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,RJ\u0010;\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040302j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000403`48\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006?"}, d2 = {"Lkm0/g;", "Lcom/tencent/freesia/IConfigData;", "", "timeStr", "", tl.h.F, "content", "j", "", "i", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "CONTENT_KEY", "e", "TAG", "", "f", "I", "()I", "setAmsRealTimeSelectOrderLimit", "(I)V", "amsRealTimeSelectOrderLimit", "getAmsRealTimeSelectOrderColdLimit", "setAmsRealTimeSelectOrderColdLimit", "amsRealTimeSelectOrderColdLimit", "setAmsRealTimeSelectOrderWarmLimit", "amsRealTimeSelectOrderWarmLimit", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "setAmsRealTimeSelectOrderDuration", "amsRealTimeSelectOrderDuration", BdhLogUtil.LogTag.Tag_Conn, "J", "b", "()J", "setAmsRealTimeSelectOrderDelayTime", "(J)V", "amsRealTimeSelectOrderDelayTime", "D", "Z", "()Z", "setAmsRealTimeSelectOrderResourceDownloadEnable", "(Z)V", "amsRealTimeSelectOrderResourceDownloadEnable", "E", "a", "setAmsOlympicShowLimitEnable", "amsOlympicShowLimitEnable", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "getAmsRealTimeSelectOrderShowTimeStartList", "()Ljava/util/ArrayList;", "setAmsRealTimeSelectOrderShowTimeStartList", "(Ljava/util/ArrayList;)V", "amsRealTimeSelectOrderShowTimeStartList", "<init>", "()V", "G", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g implements IConfigData {

    /* renamed from: D, reason: from kotlin metadata */
    private boolean amsRealTimeSelectOrderResourceDownloadEnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int amsRealTimeSelectOrderLimit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int amsRealTimeSelectOrderColdLimit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int amsRealTimeSelectOrderWarmLimit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String CONTENT_KEY = "realTimeSplashContent";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "RealTimeSplashConfigData";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int amsRealTimeSelectOrderDuration = 10000;

    /* renamed from: C, reason: from kotlin metadata */
    private long amsRealTimeSelectOrderDelayTime = 1500;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean amsOlympicShowLimitEnable = true;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Pair<Long, Long>> amsRealTimeSelectOrderShowTimeStartList = new ArrayList<>();

    private final long h(String timeStr) {
        boolean z16;
        Date parse;
        if (timeStr.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(timeStr)) == null) {
            return 0L;
        }
        return parse.getTime();
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAmsOlympicShowLimitEnable() {
        return this.amsOlympicShowLimitEnable;
    }

    /* renamed from: b, reason: from getter */
    public final long getAmsRealTimeSelectOrderDelayTime() {
        return this.amsRealTimeSelectOrderDelayTime;
    }

    /* renamed from: c, reason: from getter */
    public final int getAmsRealTimeSelectOrderDuration() {
        return this.amsRealTimeSelectOrderDuration;
    }

    /* renamed from: d, reason: from getter */
    public final int getAmsRealTimeSelectOrderLimit() {
        return this.amsRealTimeSelectOrderLimit;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getAmsRealTimeSelectOrderResourceDownloadEnable() {
        return this.amsRealTimeSelectOrderResourceDownloadEnable;
    }

    /* renamed from: f, reason: from getter */
    public final int getAmsRealTimeSelectOrderWarmLimit() {
        return this.amsRealTimeSelectOrderWarmLimit;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getCONTENT_KEY() {
        return this.CONTENT_KEY;
    }

    public final boolean i() {
        if (this.amsRealTimeSelectOrderShowTimeStartList.isEmpty()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Pair<Long, Long>> it = this.amsRealTimeSelectOrderShowTimeStartList.iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            if (next.getFirst().longValue() <= currentTimeMillis && currentTimeMillis <= next.getSecond().longValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final g j(@Nullable String content) {
        boolean z16;
        boolean z17;
        boolean z18;
        g gVar = new g();
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(this.TAG, 1, "data is null");
            return gVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            JSONArray optJSONArray = jSONObject.optJSONArray("amsRealTimeSelectOrderShowTimeList");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject2 = new JSONObject(optJSONArray.get(i3).toString());
                    ArrayList<Pair<Long, Long>> arrayList = this.amsRealTimeSelectOrderShowTimeStartList;
                    String optString = jSONObject2.optString("start", "");
                    Intrinsics.checkNotNullExpressionValue(optString, "config.optString(REAL_TI\u2026_SHOW_TIME_START_KEY, \"\")");
                    Long valueOf = Long.valueOf(h(optString));
                    String optString2 = jSONObject2.optString("end", "");
                    Intrinsics.checkNotNullExpressionValue(optString2, "config.optString(REAL_TI\u2026AD_SHOW_TIME_END_KEY, \"\")");
                    arrayList.add(new Pair<>(valueOf, Long.valueOf(h(optString2))));
                }
            }
            this.amsRealTimeSelectOrderLimit = jSONObject.optInt("amsRealTimeSelectOrderLimit", 0);
            this.amsRealTimeSelectOrderColdLimit = jSONObject.optInt("amsRealTimeSelectOrderColdLimit", 0);
            this.amsRealTimeSelectOrderWarmLimit = jSONObject.optInt("amsRealTimeSelectOrderWarmLimit", 0);
            this.amsRealTimeSelectOrderDuration = jSONObject.optInt("amsRealTimeSelectOrderDuration", 10) * 1000;
            this.amsRealTimeSelectOrderDelayTime = jSONObject.optInt("amsRealTimeSelectOrderDelayTime", 1500);
            if (jSONObject.optInt("amsRealTimeSelectOrderResourceDownloadEnable", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.amsRealTimeSelectOrderResourceDownloadEnable = z17;
            if (jSONObject.optInt("amsOlympicShowLimitEnable", 1) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.amsOlympicShowLimitEnable = z18;
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, th5, new Object[0]);
        }
        return this;
    }
}
