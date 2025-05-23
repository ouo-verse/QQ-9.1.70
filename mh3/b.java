package mh3;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.record.model.Source;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nh3.ZPlanEmoticonReportData;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001c\u0010\u0014\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004R(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R.\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00101\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00104\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\"\u0010:\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010A\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010D\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u00105\u001a\u0004\bB\u00107\"\u0004\bC\u00109R\"\u0010G\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u00105\u001a\u0004\bE\u00107\"\u0004\bF\u00109R\"\u0010M\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010T\u001a\u00020N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S\u00a8\u0006W"}, d2 = {"Lmh3/b;", "", "", "d", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", h.F, "i", "j", "g", "k", "l", "Lnh3/b;", "data", ReportConstant.COSTREPORT_PREFIX, "", "Lcom/tencent/mobileqq/zplan/model/e;", "allData", "limit", DomainData.DOMAIN_NAME, "emotionID", "c", "", "recordType", "p", "r", "e", "", "a", "Ljava/util/List;", "getFirstScreenEmotionId", "()Ljava/util/List;", "setFirstScreenEmotionId", "(Ljava/util/List;)V", "firstScreenEmotionId", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "getFinishedEmotionData", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinishedEmotionData", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "finishedEmotionData", "I", "getFirstScreenEmotionCount", "()I", "setFirstScreenEmotionCount", "(I)V", "firstScreenEmotionCount", "getFirstFinishedEmotionId", "setFirstFinishedEmotionId", "firstFinishedEmotionId", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setAppearanceKey", "(Ljava/lang/String;)V", "appearanceKey", "Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "setUserInfo", "(Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;)V", ITVKPlayerEventListener.KEY_USER_INFO, "getLastEnterVersion", "setLastEnterVersion", "lastEnterVersion", "o", "setFirstEnter", "isFirstEnter", "Z", "getShouldReportFirstScreenData", "()Z", "t", "(Z)V", "shouldReportFirstScreenData", "", "J", "getStartRecordTime", "()J", "setStartRecordTime", "(J)V", "startRecordTime", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: l, reason: collision with root package name */
    private static final String f416781l = AppSetting.f99551k;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int firstScreenEmotionCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZPlanUserInfo userInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean shouldReportFirstScreenData;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<Integer> firstScreenEmotionId = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<Integer, ZPlanEmoticonReportData> finishedEmotionData = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile int firstFinishedEmotionId = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String appearanceKey = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String lastEnterVersion = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String isFirstEnter = "2";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long startRecordTime = System.currentTimeMillis();

    public b() {
        ThreadManagerV2.excute(new Runnable() { // from class: mh3.a
            @Override // java.lang.Runnable
            public final void run() {
                b.b(b.this);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b this$0) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str3 = "";
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("zplan_is_the_first_time_enter", "");
        this$0.lastEnterVersion = string;
        boolean z16 = true;
        if (string.length() == 0) {
            str = "1";
        } else if (!Intrinsics.areEqual(this$0.lastEnterVersion, f416781l)) {
            str = "0";
        } else {
            str = "2";
        }
        this$0.isFirstEnter = str;
        IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
        String currentAppVersion = f416781l;
        Intrinsics.checkNotNullExpressionValue(currentAppVersion, "currentAppVersion");
        iZPlanMMKVApi.setString("zplan_is_the_first_time_enter", currentAppVersion);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String currentUin = peekAppRuntime.getCurrentUin();
        if (currentUin != null && currentUin.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
        String currentUin2 = peekAppRuntime.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin2, "app.currentUin");
        ZPlanUserInfo l3 = ZplanDataRepository.l(zplanDataRepository, currentUin2, false, 2, null);
        this$0.userInfo = l3;
        if (l3 != null && (str2 = l3.appearanceKey) != null) {
            str3 = str2;
        }
        this$0.appearanceKey = str3;
    }

    private final boolean d() {
        Iterator<Integer> it = this.firstScreenEmotionId.iterator();
        while (it.hasNext()) {
            if (!this.finishedEmotionData.containsKey(Integer.valueOf(it.next().intValue()))) {
                return false;
            }
        }
        return true;
    }

    private final int g() {
        Iterator<Map.Entry<Integer, ZPlanEmoticonReportData>> it = this.finishedEmotionData.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(Source.CLOUD_CACHE.name(), it.next().getValue().getRecorderType())) {
                i3++;
            }
        }
        return i3;
    }

    private final int h() {
        Iterator<Integer> it = this.firstScreenEmotionId.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (this.finishedEmotionData.containsKey(Integer.valueOf(intValue))) {
                String name = Source.CLOUD_CACHE.name();
                ZPlanEmoticonReportData zPlanEmoticonReportData = this.finishedEmotionData.get(Integer.valueOf(intValue));
                if (Intrinsics.areEqual(name, zPlanEmoticonReportData != null ? zPlanEmoticonReportData.getRecorderType() : null)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    private final int i() {
        Iterator<Integer> it = this.firstScreenEmotionId.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (this.finishedEmotionData.containsKey(Integer.valueOf(intValue))) {
                String name = Source.LOCAL_CACHE.name();
                ZPlanEmoticonReportData zPlanEmoticonReportData = this.finishedEmotionData.get(Integer.valueOf(intValue));
                if (Intrinsics.areEqual(name, zPlanEmoticonReportData != null ? zPlanEmoticonReportData.getRecorderType() : null)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    private final int j() {
        Iterator<Integer> it = this.firstScreenEmotionId.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (this.finishedEmotionData.containsKey(Integer.valueOf(intValue))) {
                String name = Source.LOCAL_RECORD.name();
                ZPlanEmoticonReportData zPlanEmoticonReportData = this.finishedEmotionData.get(Integer.valueOf(intValue));
                if (Intrinsics.areEqual(name, zPlanEmoticonReportData != null ? zPlanEmoticonReportData.getRecorderType() : null)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    private final int k() {
        Iterator<Map.Entry<Integer, ZPlanEmoticonReportData>> it = this.finishedEmotionData.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(Source.LOCAL_CACHE.name(), it.next().getValue().getRecorderType())) {
                i3++;
            }
        }
        return i3;
    }

    private final int l() {
        Iterator<Map.Entry<Integer, ZPlanEmoticonReportData>> it = this.finishedEmotionData.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(Source.LOCAL_RECORD.name(), it.next().getValue().getRecorderType())) {
                i3++;
            }
        }
        return i3;
    }

    private final void q() {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        ZPlanEmoticonReportData zPlanEmoticonReportData = this.finishedEmotionData.containsKey(Integer.valueOf(this.firstFinishedEmotionId)) ? this.finishedEmotionData.get(Integer.valueOf(this.firstFinishedEmotionId)) : null;
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_emote_first_emote_loading_time", String.valueOf(zPlanEmoticonReportData != null ? Long.valueOf(zPlanEmoticonReportData.a()) : null));
        if (zPlanEmoticonReportData == null || (str = zPlanEmoticonReportData.getRecorderType()) == null) {
            str = "3";
        }
        hashMap.put("zplan_first_emote_record_type", String.valueOf(p(str)));
        hashMap.put("zplan_first_screen_cnt", String.valueOf(this.firstScreenEmotionCount));
        hashMap.put("zplan_cloud_recording_cnt", String.valueOf(h()));
        hashMap.put("zplan_local_recording_cnt", String.valueOf(j()));
        hashMap.put("zplan_cache_cnt", String.valueOf(i()));
        hashMap.put("zplan_dress_up_key", this.appearanceKey);
        ZPlanUserInfo zPlanUserInfo = this.userInfo;
        boolean z16 = false;
        if (zPlanUserInfo != null && zPlanUserInfo.hasCustomDressUp()) {
            z16 = true;
        }
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("zplan_is_dress_up_user", str2);
        hashMap.put("zplan_is_the_first_time_enter", this.isFirstEnter);
        hashMap.put("zplan_emote_first_screen_loading_time", String.valueOf(System.currentTimeMillis() - this.startRecordTime));
        VideoReport.reportEvent("ev_zplan_emote_page", hashMap);
    }

    private final void s(ZPlanEmoticonReportData data) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_emote_single_emote_loading_time", String.valueOf(data.a()));
        hashMap.put("zplan_first_emote_record_type", String.valueOf(p(data.getRecorderType())));
        hashMap.put("zplan_dress_up_key", this.appearanceKey);
        ZPlanUserInfo zPlanUserInfo = this.userInfo;
        boolean z16 = false;
        if (zPlanUserInfo != null && zPlanUserInfo.hasCustomDressUp()) {
            z16 = true;
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("zplan_is_dress_up_user", str);
        hashMap.put("zplan_is_the_first_time_enter", this.isFirstEnter);
        VideoReport.reportEvent("ev_zplan_single_emote_loading_success", hashMap);
    }

    public final void c(int emotionID, ZPlanEmoticonReportData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!this.finishedEmotionData.containsKey(Integer.valueOf(emotionID))) {
            s(data);
        }
        this.finishedEmotionData.put(Integer.valueOf(emotionID), data);
        if (this.firstFinishedEmotionId == -1) {
            this.firstFinishedEmotionId = emotionID;
        }
        if (d() && this.shouldReportFirstScreenData) {
            q();
            this.shouldReportFirstScreenData = false;
        }
    }

    public final void e() {
        this.finishedEmotionData.clear();
        this.firstFinishedEmotionId = -1;
        this.isFirstEnter = "2";
        this.shouldReportFirstScreenData = false;
    }

    /* renamed from: f, reason: from getter */
    public final String getAppearanceKey() {
        return this.appearanceKey;
    }

    /* renamed from: m, reason: from getter */
    public final ZPlanUserInfo getUserInfo() {
        return this.userInfo;
    }

    public final void n(List<ZPlanActionInfo> allData, int limit) {
        List<ZPlanActionInfo> arrayList;
        Intrinsics.checkNotNullParameter(allData, "allData");
        if (allData.size() > limit) {
            arrayList = allData.subList(0, limit);
        } else {
            arrayList = new ArrayList(allData);
        }
        this.firstScreenEmotionId.clear();
        Iterator<ZPlanActionInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            this.firstScreenEmotionId.add(Integer.valueOf(it.next().getId()));
        }
        this.firstScreenEmotionCount = limit;
        this.startRecordTime = System.currentTimeMillis();
    }

    /* renamed from: o, reason: from getter */
    public final String getIsFirstEnter() {
        return this.isFirstEnter;
    }

    public final int p(String recordType) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        if (Intrinsics.areEqual(recordType, Source.CLOUD_CACHE.name())) {
            return 1;
        }
        if (Intrinsics.areEqual(recordType, Source.LOCAL_RECORD.name())) {
            return 2;
        }
        Intrinsics.areEqual(recordType, Source.LOCAL_CACHE.name());
        return 3;
    }

    public final void r() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_cloud_recording_cnt", String.valueOf(g()));
        hashMap.put("zplan_local_recording_cnt", String.valueOf(l()));
        hashMap.put("zplan_cache_cnt", String.valueOf(k()));
        hashMap.put("zplan_dress_up_key", this.appearanceKey);
        ZPlanUserInfo zPlanUserInfo = this.userInfo;
        boolean z16 = false;
        if (zPlanUserInfo != null && zPlanUserInfo.hasCustomDressUp()) {
            z16 = true;
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("zplan_is_dress_up_user", str);
        hashMap.put("zplan_is_the_first_time_enter", this.isFirstEnter);
        hashMap.put("zlan_load_suc_emote_cnt", String.valueOf(this.finishedEmotionData.size()));
        VideoReport.reportEvent("ev_zplan_emote_user_leave", hashMap);
    }

    public final void t(boolean z16) {
        this.shouldReportFirstScreenData = z16;
    }
}
