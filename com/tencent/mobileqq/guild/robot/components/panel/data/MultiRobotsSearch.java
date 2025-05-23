package com.tencent.mobileqq.guild.robot.components.panel.data;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.guild.aio.input.at.quickAt.search.SearchException;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.BatchBotGetReq;
import com.tencent.qqnt.kernel.nativeinterface.BatchBotGetResponse;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotClientInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatures;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFilter;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotScene;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotClientInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetRobotFunctionsCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes14.dex */
public class MultiRobotsSearch extends uo0.k {

    /* renamed from: m, reason: collision with root package name */
    public static long f232161m = 300000;

    /* renamed from: n, reason: collision with root package name */
    public static int f232162n = 120000;

    /* renamed from: o, reason: collision with root package name */
    public static int f232163o = 3000;

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f232164c;

    /* renamed from: d, reason: collision with root package name */
    private final String f232165d;

    /* renamed from: e, reason: collision with root package name */
    private final String f232166e;

    /* renamed from: f, reason: collision with root package name */
    private final String f232167f;

    /* renamed from: g, reason: collision with root package name */
    private long f232168g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f232169h = false;

    /* renamed from: i, reason: collision with root package name */
    private List<CommonBotFeatures> f232170i;

    /* renamed from: j, reason: collision with root package name */
    private String f232171j;

    /* renamed from: k, reason: collision with root package name */
    private int f232172k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f232173l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends qx1.a<BatchBotGetResponse> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(int i3, String str, BatchBotGetResponse batchBotGetResponse) {
            MultiRobotsSearch.this.e(new SearchException(i3, str, MultiRobotsSearch.this));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(BatchBotGetResponse batchBotGetResponse) {
            ArrayList<CommonBotFeatures> botFeatures = batchBotGetResponse.getBotFeatures();
            if (botFeatures == null) {
                QLog.w("GuildRobotTag:MultiRobotsSearch", 1, "getRobotFunctions|response empty");
                MultiRobotsSearch.this.f232170i = Collections.emptyList();
                MultiRobotsSearch.this.d();
                return;
            }
            MultiRobotsSearch multiRobotsSearch = MultiRobotsSearch.this;
            multiRobotsSearch.f232170i = multiRobotsSearch.B(botFeatures);
            MultiRobotsSearch.this.d();
        }
    }

    public MultiRobotsSearch(AppRuntime appRuntime, List<String> list, String str, String str2, String str3, String str4, int i3, boolean z16) {
        this.f232164c = list;
        this.f232165d = str;
        this.f232166e = str2;
        this.f232167f = str3;
        this.f232171j = str4;
        this.f232172k = i3;
        this.f232173l = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(final int i3, final String str, final BatchBotGetResponse batchBotGetResponse) {
        final a aVar = new a();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.b
            @Override // java.lang.Runnable
            public final void run() {
                qx1.a.this.a(i3, str, batchBotGetResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<CommonBotFeatures> B(List<CommonBotFeatures> list) {
        Sequence asSequence;
        Sequence filter;
        Sequence mapNotNull;
        List<CommonBotFeatures> list2;
        asSequence = CollectionsKt___CollectionsKt.asSequence(list);
        filter = SequencesKt___SequencesKt.filter(asSequence, new Function1() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean x16;
                x16 = MultiRobotsSearch.x((CommonBotFeatures) obj);
                return x16;
            }
        });
        mapNotNull = SequencesKt___SequencesKt.mapNotNull(filter, new Function1() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CommonBotFeatures y16;
                y16 = MultiRobotsSearch.y((CommonBotFeatures) obj);
                return y16;
            }
        });
        list2 = SequencesKt___SequencesKt.toList(mapNotNull);
        return list2;
    }

    private void C() {
        ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.getRobotFunctions(new Contact(4, this.f232166e, this.f232165d), v(), new IGetRobotFunctionsCallback() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetRobotFunctionsCallback
            public final void onResult(int i3, String str, BatchBotGetResponse batchBotGetResponse) {
                MultiRobotsSearch.this.A(i3, str, batchBotGetResponse);
            }
        });
    }

    public static void D(xw1.c cVar) {
        QLog.i("GuildRobotTag:MultiRobotsSearch", 1, "setCacheConfig(): " + cVar);
        if (cVar == null) {
            return;
        }
        f232161m = cVar.a().longValue();
        f232162n = cVar.d().intValue();
        f232163o = cVar.c().intValue();
    }

    @NonNull
    private BatchBotGetReq v() {
        Collection mapNotNullTo;
        BatchBotGetReq batchBotGetReq = new BatchBotGetReq();
        mapNotNullTo = CollectionsKt___CollectionsKt.mapNotNullTo(this.f232164c, new ArrayList(), new Function1() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Long longOrNull;
                longOrNull = StringsKt.toLongOrNull((String) obj);
                return longOrNull;
            }
        });
        batchBotGetReq.setTinyids((ArrayList) mapNotNullTo);
        batchBotGetReq.setScene(CommonBotScene.KCHANNEL);
        batchBotGetReq.setFullFetch(true);
        GProGuildRobotClientInfo d16 = sx1.f.d();
        batchBotGetReq.setClientInfo(new CommonBotClientInfo(d16.getPlatform(), d16.getVersion(), d16.getBuildNum()));
        if (this.f232173l) {
            batchBotGetReq.setFilter(CommonBotFilter.KEXCLUDEUNABLESPEAKBOT);
        } else {
            batchBotGetReq.setFilter(CommonBotFilter.KNONE);
        }
        return batchBotGetReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean x(CommonBotFeatures commonBotFeatures) {
        boolean z16;
        CommonBotInfo botInfo = commonBotFeatures.getBotInfo();
        if (botInfo != null && !h34.a.c(botInfo) && !h34.a.g(botInfo)) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CommonBotFeatures y(CommonBotFeatures commonBotFeatures) {
        Collection filterTo;
        Collection filterTo2;
        filterTo = CollectionsKt___CollectionsKt.filterTo(commonBotFeatures.getCommandInfo(), new ArrayList(), new Function1() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(h34.a.b((CommonBotFeatureInfo) obj));
            }
        });
        ArrayList arrayList = (ArrayList) filterTo;
        filterTo2 = CollectionsKt___CollectionsKt.filterTo(commonBotFeatures.getServiceInfo(), new ArrayList(), new Function1() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(h34.a.b((CommonBotFeatureInfo) obj));
            }
        });
        ArrayList arrayList2 = (ArrayList) filterTo2;
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            return null;
        }
        return new CommonBotFeatures(commonBotFeatures.getBotInfo(), arrayList2, arrayList);
    }

    @Override // uo0.k
    public String f() {
        return this.f232165d + Marker.ANY_NON_NULL_MARKER + this.f232166e + ":" + this.f232167f;
    }

    @Override // uo0.k
    public String h() {
        return this.f232171j;
    }

    @Override // uo0.k
    public List<CommonBotFeatures> i() {
        return this.f232170i;
    }

    @Override // uo0.k
    public boolean l() {
        long j3;
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis() - this.f232168g;
        if (this.f232169h) {
            j3 = f232162n;
        } else {
            j3 = f232161m;
        }
        if (currentTimeMillis > j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = ap0.f.needFetchNewData;
        ap0.f.needFetchNewData = false;
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    @Override // uo0.k
    public void m() {
        List<CommonBotFeatures> emptyList;
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:MultiRobotsSearch", 2, "new RobotFunctionSearch start, mRobotIds:" + this.f232164c);
        }
        this.f232168g = System.currentTimeMillis();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f232170i = emptyList;
        this.f232169h = bl.b(this.f232164c);
        C();
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.MultiRobotsSearch.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.e("GuildRobotTag:MultiRobotsSearch", 1, "request timeout");
                MultiRobotsSearch.this.e(new SearchException(1002, "\u7f51\u7edc\u8d85\u65f6", MultiRobotsSearch.this));
            }
        }, f232163o);
    }
}
