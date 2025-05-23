package com.tencent.mobileqq.wink.templatelibrary.meme.viewmodel;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ark.ark;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.templatelibrary.meme.request.WinkMemeCancelTaskRequest;
import com.tencent.mobileqq.wink.templatelibrary.meme.request.WinkMemeGenScriptsRequest;
import com.tencent.mobileqq.wink.templatelibrary.meme.request.WinkMemeQueryRequest;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import feedcloud.FeedCloudSeedsvr$SEAGIQueryRsp;
import feedcloud.FeedCloudSeedsvr$SEAGISubmitRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u73.MemeData;
import u73.RecommendMemeData;
import u73.RecommendText;
import u73.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\b\t*\u0001W\u0018\u0000 ]2\u00020\u0001:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J.\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010*\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0'0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001fR:\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0'0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R(\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00020/0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u001fR4\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00020/0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u001f\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002000\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u001fR(\u0010<\u001a\b\u0012\u0004\u0012\u0002000\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u001f\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000e0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?R2\u0010G\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020Cj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010>R\u0016\u0010T\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u00101R\u0016\u0010V\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u00109R\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/meme/viewmodel/WinkMemeViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "", "initData", "content", "f2", MiniAppGetGameTaskTicketServlet.KEY_TASKID, SemanticAttributes.DbSystemValues.H2, "d2", "U1", "T1", ark.ARKMETADATA_JSON, "", "width", "height", "Landroid/content/Context;", "context", "topic", "W1", "Lu73/f;", "i", "Lu73/f;", "X1", "()Lu73/f;", "setCurrentMemeData", "(Lu73/f;)V", "currentMemeData", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_taskId", BdhLogUtil.LogTag.Tag_Conn, "c2", "()Landroidx/lifecycle/MutableLiveData;", "setTaskIdLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "taskIdLiveData", "Lkotlin/Triple;", "Lu73/h;", "D", "_showTitleInHintView", "E", "b2", "setShowTitleInHintView", "showTitleInHintView", "Lkotlin/Pair;", "", UserInfo.SEX_FEMALE, "_queryResult", "G", ICustomDataEditor.STRING_ARRAY_PARAM_2, "setQueryResult", "queryResult", "H", "_downloadAndSaveFinish", "I", "Z1", "setDownloadAndSaveFinish", "downloadAndSaveFinish", "", "J", "Ljava/util/List;", "remainingIndices", "K", "selectedIndices", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "L", "Ljava/util/HashMap;", "contentToJson", "M", "Ljava/lang/String;", "currentRequestContent", "Lu73/g;", "N", "Lu73/g;", "recommendMemeData", "", "P", "queryInterval", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "estimatedTimeCost", BdhLogUtil.LogTag.Tag_Req, "retryTimes", "com/tencent/mobileqq/wink/templatelibrary/meme/viewmodel/WinkMemeViewModel$queryRunnable$1", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/wink/templatelibrary/meme/viewmodel/WinkMemeViewModel$queryRunnable$1;", "queryRunnable", "<init>", "()V", "T", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMemeViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<String> taskIdLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Triple<RecommendText, RecommendText, RecommendText>> _showTitleInHintView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Triple<RecommendText, RecommendText, RecommendText>> showTitleInHintView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<Boolean, String>> _queryResult;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<Boolean, String>> queryResult;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> _downloadAndSaveFinish;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> downloadAndSaveFinish;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private List<Integer> remainingIndices;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private List<Integer> selectedIndices;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, String> contentToJson;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String currentRequestContent;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private RecommendMemeData recommendMemeData;

    /* renamed from: P, reason: from kotlin metadata */
    private long queryInterval;

    /* renamed from: Q, reason: from kotlin metadata */
    private float estimatedTimeCost;

    /* renamed from: R, reason: from kotlin metadata */
    private int retryTimes;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final WinkMemeViewModel$queryRunnable$1 queryRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MemeData currentMemeData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<String> _taskId;

    /* JADX WARN: Type inference failed for: r0v8, types: [com.tencent.mobileqq.wink.templatelibrary.meme.viewmodel.WinkMemeViewModel$queryRunnable$1] */
    public WinkMemeViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._taskId = mutableLiveData;
        this.taskIdLiveData = mutableLiveData;
        MutableLiveData<Triple<RecommendText, RecommendText, RecommendText>> mutableLiveData2 = new MutableLiveData<>();
        this._showTitleInHintView = mutableLiveData2;
        this.showTitleInHintView = mutableLiveData2;
        MutableLiveData<Pair<Boolean, String>> mutableLiveData3 = new MutableLiveData<>();
        this._queryResult = mutableLiveData3;
        this.queryResult = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._downloadAndSaveFinish = mutableLiveData4;
        this.downloadAndSaveFinish = mutableLiveData4;
        this.remainingIndices = new ArrayList();
        this.selectedIndices = new ArrayList();
        this.contentToJson = new HashMap<>();
        this.currentRequestContent = "";
        this.queryRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.viewmodel.WinkMemeViewModel$queryRunnable$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                MutableLiveData mutableLiveData5;
                long j3;
                mutableLiveData5 = WinkMemeViewModel.this._taskId;
                String str = (String) mutableLiveData5.getValue();
                if (str != null) {
                    WinkMemeViewModel winkMemeViewModel = WinkMemeViewModel.this;
                    winkMemeViewModel.h2(str);
                    j3 = winkMemeViewModel.queryInterval;
                    w53.b.a("WinkMemeViewModel", "queryRunnable... queryInterval:" + j3);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        w53.b.a("WinkMemeViewModel", "success:" + z16 + ", code:" + j3 + ", msg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(WinkMemeViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudSeedsvr$SEAGISubmitRsp feedCloudSeedsvr$SEAGISubmitRsp) {
        long roundToLong;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("WinkMemeViewModel", "requestGenMemeScripts... success:" + z16 + ", code:" + j3 + ", msg:" + str);
        if (z16 && j3 == 0) {
            Intrinsics.checkNotNull(feedCloudSeedsvr$SEAGISubmitRsp, "null cannot be cast to non-null type feedcloud.FeedCloudSeedsvr.SEAGISubmitRsp");
            w53.b.f("WinkMemeViewModel", "id:" + feedCloudSeedsvr$SEAGISubmitRsp.taskID.get() + " queryInterval:" + feedCloudSeedsvr$SEAGISubmitRsp.queryInterval.get() + " estimatedTimeCost:" + feedCloudSeedsvr$SEAGISubmitRsp.estimatedTimeCost.get());
            this$0._taskId.postValue(feedCloudSeedsvr$SEAGISubmitRsp.taskID.get());
            roundToLong = MathKt__MathJVMKt.roundToLong(feedCloudSeedsvr$SEAGISubmitRsp.queryInterval.get() * ((float) 1000));
            this$0.queryInterval = roundToLong;
            this$0.estimatedTimeCost = feedCloudSeedsvr$SEAGISubmitRsp.estimatedTimeCost.get();
            this$0.retryTimes = 0;
            ThreadManagerV2.getUIHandlerV2().postDelayed(this$0.queryRunnable, this$0.queryInterval);
            return;
        }
        this$0._queryResult.postValue(new Pair<>(Boolean.FALSE, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(WinkMemeViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudSeedsvr$SEAGIQueryRsp feedCloudSeedsvr$SEAGIQueryRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("WinkMemeViewModel", "requestQueryMemeResult... success:" + z16 + ", code:" + j3 + ", msg:" + str);
        if (z16 && j3 == 0) {
            Intrinsics.checkNotNull(feedCloudSeedsvr$SEAGIQueryRsp, "null cannot be cast to non-null type feedcloud.FeedCloudSeedsvr.SEAGIQueryRsp");
            w53.b.f("WinkMemeViewModel", "taskStatus:" + feedCloudSeedsvr$SEAGIQueryRsp.taskStatus.get());
            int i3 = feedCloudSeedsvr$SEAGIQueryRsp.taskStatus.get();
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this$0.queryRunnable);
                    this$0.queryInterval = feedCloudSeedsvr$SEAGIQueryRsp.queryInterval.get() * 1000;
                    ThreadManagerV2.getUIHandlerV2().postDelayed(this$0.queryRunnable, this$0.queryInterval);
                    w53.b.f("WinkMemeViewModel", "next queryInterval:" + this$0.queryInterval);
                    return;
                }
                this$0._queryResult.postValue(new Pair<>(Boolean.FALSE, str));
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this$0.queryRunnable);
                return;
            }
            String json = feedCloudSeedsvr$SEAGIQueryRsp.memeOutput.get().jsonData.get().toStringUtf8();
            w53.b.f("WinkMemeViewModel", "json:" + json);
            Intrinsics.checkNotNullExpressionValue(json, "json");
            MemeData memeData = d.b(json).getMemeData();
            this$0.currentMemeData = memeData;
            w53.b.f("WinkMemeViewModel", "currentMemeData:" + memeData);
            this$0._queryResult.postValue(new Pair<>(Boolean.TRUE, json));
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this$0.queryRunnable);
            return;
        }
        int i16 = this$0.retryTimes;
        if (i16 < 2) {
            this$0.retryTimes = i16 + 1;
            ThreadManagerV2.getUIHandlerV2().postDelayed(this$0.queryRunnable, this$0.queryInterval);
        } else {
            this$0._queryResult.postValue(new Pair<>(Boolean.FALSE, "\u670d\u52a1\u5668\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"));
        }
    }

    public final void T1() {
        w53.b.f("WinkMemeViewModel", "cancelQueryMemeRequest...");
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.queryRunnable);
    }

    public final void U1() {
        List<RecommendText> a16;
        Object random;
        IntRange indices;
        List<Integer> mutableList;
        RecommendMemeData recommendMemeData = this.recommendMemeData;
        if (recommendMemeData != null && (a16 = recommendMemeData.a()) != null) {
            if (this.remainingIndices.size() < 3) {
                indices = CollectionsKt__CollectionsKt.getIndices(a16);
                mutableList = CollectionsKt___CollectionsKt.toMutableList(indices);
                this.remainingIndices = mutableList;
                this.selectedIndices.clear();
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 3; i3++) {
                random = CollectionsKt___CollectionsKt.random(this.remainingIndices, Random.INSTANCE);
                int intValue = ((Number) random).intValue();
                arrayList.add(Integer.valueOf(intValue));
                this.remainingIndices.remove(Integer.valueOf(intValue));
            }
            this.selectedIndices.addAll(arrayList);
            w53.b.a("WinkMemeViewModel", "(" + a16.get(((Number) arrayList.get(0)).intValue()).getTitle() + "," + a16.get(((Number) arrayList.get(1)).intValue()).getTitle() + "," + a16.get(((Number) arrayList.get(2)).intValue()).getTitle() + ")");
            this._showTitleInHintView.postValue(new Triple<>(a16.get(((Number) arrayList.get(0)).intValue()), a16.get(((Number) arrayList.get(1)).intValue()), a16.get(((Number) arrayList.get(2)).intValue())));
        }
    }

    public final void W1(@NotNull String json, int width, int height, @NotNull Context context, @NotNull String topic) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(topic, "topic");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WinkMemeViewModel$downloadMaterial$1(json, width, height, context, topic, this, null), 3, null);
    }

    @Nullable
    /* renamed from: X1, reason: from getter */
    public final MemeData getCurrentMemeData() {
        return this.currentMemeData;
    }

    @NotNull
    public final MutableLiveData<Boolean> Z1() {
        return this.downloadAndSaveFinish;
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, String>> a2() {
        return this.queryResult;
    }

    @NotNull
    public final MutableLiveData<Triple<RecommendText, RecommendText, RecommendText>> b2() {
        return this.showTitleInHintView;
    }

    @NotNull
    public final MutableLiveData<String> c2() {
        return this.taskIdLiveData;
    }

    public final void d2(@NotNull String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        w53.b.a("WinkMemeViewModel", "requestCancelMemeResult... taskId\uff1a" + taskId);
        VSNetworkHelper.getInstance().sendRequest(new WinkMemeCancelTaskRequest(1, taskId), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.viewmodel.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                WinkMemeViewModel.e2(baseRequest, z16, j3, str, obj);
            }
        });
    }

    public final void f2(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        w53.b.a("WinkMemeViewModel", "requestGenMemeScripts...");
        this.currentRequestContent = content;
        VSNetworkHelper.getInstance().sendRequest(new WinkMemeGenScriptsRequest(1, content), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.viewmodel.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                WinkMemeViewModel.g2(WinkMemeViewModel.this, baseRequest, z16, j3, str, (FeedCloudSeedsvr$SEAGISubmitRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkMemeViewModel";
    }

    public final void h2(@NotNull String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        w53.b.a("WinkMemeViewModel", "requestQueryMemeResult...");
        VSNetworkHelper.getInstance().sendRequest(new WinkMemeQueryRequest(1, taskId), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.viewmodel.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                WinkMemeViewModel.i2(WinkMemeViewModel.this, baseRequest, z16, j3, str, (FeedCloudSeedsvr$SEAGIQueryRsp) obj);
            }
        });
    }

    public final void initData() {
        boolean z16;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_mao_meme_json_data", "\n        {\n      \"MemeData\":[\n   {\n      \"title\":\"\",\n      \"content\":\"\u9762\u8bd5\u5b98\uff1a\u4f60\u4e3a\u4ec0\u4e48\u9009\u62e9\u6211\u4eec\u516c\u53f8\uff1f\\n\u6211\uff1a\u56e0\u4e3a\u4f60\u4eec\u5728\u62db\u4eba\\n\u9762\u8bd5\u5b98\uff1a\u4f60\u80fd\u4e3a\u516c\u53f8\u5e26\u6765\u4ec0\u4e48\\n\u6211\uff1a\u4e00\u4e2a\u65b0\u5458\u5de5\"\n   },\n   {\n      \"title\":\"\",\n      \"content\":\"\u795e\u79d8\u4eba\uff1a\u8fd9\u91cc\u6709\u7ea2\u84dd\u4e24\u9897\u836f\uff0c\u5982\u679c\u4f60\u9009\u62e9\u5403\u84dd\u8272\u7684\u836f\uff0c\u4f60\u7684\u4eba\u751f\u4f1a\u4fdd\u6301\u4e00\u5982\u65e2\u5f80\u7684\u8fa3\u9e21\\n\u6211\uff1a\u90a3\u5982\u679c\u6211\u9009\u62e9\u5403\u7ea2\u8272\u7684\u836f\u5462\\n\u795e\u79d8\u4eba\uff1a\u4e00\u6837\uff0c\u4e0d\u8fc7\u662f\u8349\u8393\u5473\u7684\"\n   },\n   {\n      \"title\":\"\",\n      \"content\":\"\u533b\u751f\uff1a\u653e\u677e\uff0c\u522b\u7d27\u5f20\u6234\u7ef4\uff0c\u8fd9\u53ea\u662f\u4e00\u6b21\u5c0f\u624b\u672f\u800c\u5df2\u3002\\n\u75c5\u4eba\uff1a\u6211\u4e0d\u53eb\u6234\u7ef4\u3002\\n\u533b\u751f\uff1a\u6211\u77e5\u9053\uff0c\u6211\u53eb\u6234\u7ef4\u3002\"\n   },\n   {\n      \"title\":\"\",\n      \"content\":\"\u8783\u87f9\u51fa\u95e8\u4e0d\u5c0f\u5fc3\u649e\u5012\u4e86\u6ce5\u9cc5\uff0c\u6ce5\u9cc5\u5f88\u751f\u6c14\u5730\u8bf4\uff1a\u201c\u4f60\u662f\u4e0d\u662f\u778e\u554a\uff01\u201d\\n\u8783\u87f9\u8bf4\uff1a\u201c\u4e0d\u662f\u554a\uff0c\u6211\u662f\u8783\u87f9\uff01\u201d\"\n   },\n   {\n      \"title\":\"\",\n      \"content\":\"\u8bb0\u8005\u8857\u5934\u91c7\u8bbf\uff1a\u201c\u5927\u5988\uff0c\u60a8\u89c9\u5f97\u96fe\u973e\u7ed9\u60a8\u7684\u751f\u6d3b\u5e26\u6765\u4e86\u4ec0\u4e48\u5f71\u54cd\uff1f\u201d\\n\u5927\u5988\uff1a\u201c\u5f71\u54cd\u592a\u5927\u4e86\uff01\u9996\u5148\u4f60\u5f97\u770b\u6e05\u695a\uff0c\u6211\u662f\u4f60\u5927\u7237\uff01\"\n   },\n   {\n      \"title\":\"\",\n      \"content\":\"\u513f\u5b50\uff1a\u201c\u5988\uff0c\u6211\u8981\u662f\u8003\u5168\u73ed\u7b2c\u4e00\uff0c\u4f60\u4f1a\u600e\u6837\uff1f\u201d\\n\u5988\u5988\uff1a\u201c\u90a3\u6211\u4f1a\u9ad8\u5174\u6b7b\u7684\uff01\u201d\\n\u513f\u5b50\uff1a\u201c\u5988\u5988\uff0c\u4f60\u8981\u575a\u5f3a\uff0c\u5343\u4e07\u522b\u6b7b\uff0c\u6211\u8003\u4e86\u7b2c\u4e8c\u3002\u201d\"\n   },\n   {\n      \"title\":\"\",\n      \"content\":\"\u5e97\u5458\uff1a\u201c\u5148\u751f\uff0c\u4e70\u4e2a\u6269\u97f3\u5668\u5427\uff0c\u8df3\u697c\u4ef7\u53ea\u8981 10 \u5757\uff01\u201d\\n\u8def\u4eba\uff1a\u201c10 \u5757\uff1f\u600e\u4e48\u8fd9\u4e48\u4fbf\u5b9c\uff1f\u201d\\n\u5e97\u5458\uff1a\u201c\u8df3\u697c\u4ef7\u561b\uff01\u201d\\n\u8def\u4eba\uff1a\u201c\u90a3\u4f60\u4ece\u51e0\u697c\u8df3\u7684\uff1f\u201d\"\n   },\n   {\n      \"title\":\"\",\n      \"content\":\"\u4e08\u592b\uff1a\u201c\u4e3a\u4ec0\u4e48\u6bcf\u6b21\u6211\u5728\u5bb6\u91cc\u5531\u6b4c\uff0c\u4f60\u90fd\u8981\u5230\u9633\u53f0\u4e0a\u53bb\uff1f\u201d\\n\u59bb\u5b50\uff1a\u201c\u6211\u8981\u8ba9\u90bb\u5c45\u4eec\u90fd\u77e5\u9053\uff0c\u6211\u6ca1\u6709\u6253\u4f60\u3002\u201d\"\n   },\n   {\n      \"title\":\"\",\n      \"content\":\"\u6709\u4e00\u5929\uff0c\u4e00\u53ea\u5c0f\u9e2d\u5b50\u8d70\u8fdb\u4e86\u4e00\u5bb6\u5e97\uff0c\u5bf9\u5e97\u4e3b\u8bf4\uff1a\u201c\u4f60\u4eec\u6709\u6ca1\u6709\u9e2d\u98df\uff1f\u201d\\n\u5e97\u4e3b\u56de\u7b54\u8bf4\uff1a\u201c\u5bf9\u4e0d\u8d77\uff0c\u6211\u4eec\u6ca1\u6709\u3002\u201d\\n\u7b2c\u4e8c\u5929\uff0c\u5c0f\u9e2d\u5b50\u53c8\u6765\u4e86\uff0c\u95ee\u540c\u6837\u7684\u95ee\u9898\uff0c\u5e97\u4e3b\u540c\u6837\u7684\u56de\u7b54\u3002\\n\u7b2c\u4e09\u5929\uff0c\u5c0f\u9e2d\u5b50\u53c8\u6765\uff0c\u95ee\uff1a\u201c\u4f60\u4eec\u6709\u6ca1\u6709\u9e2d\u98df\uff1f\u201d\\n\u5e97\u4e3b\u6709\u4e9b\u4e0d\u8010\u70e6\u4e86\uff0c\u56de\u7b54\u8bf4\uff1a\u201c\u6211\u544a\u8bc9\u8fc7\u4f60\uff0c\u6211\u4eec\u6ca1\u6709\u9e2d\u98df\uff0c\u5982\u679c\u4f60\u518d\u6765\u95ee\u6211\uff0c\u6211\u5c31\u7528\u80f6\u5e26\u628a\u4f60\u7684\u5634\u5df4\u5c01\u4f4f\u3002\u201d\\n\u7b2c\u56db\u5929\uff0c\u5c0f\u9e2d\u5b50\u53c8\u6765\u4e86\uff0c\u95ee\uff1a\u201c\u4f60\u4eec\u6709\u6ca1\u6709\u80f6\u5e26\uff1f\u201d\\n\u5e97\u4e3b\u56de\u7b54\uff1a\u201c\u6ca1\u6709\u3002\u201d\\n\u7136\u540e\u5c0f\u9e2d\u5b50\u8bf4\uff1a\u201c\u90a3\u4f60\u4eec\u6709\u6ca1\u6709\u9e2d\u98df\uff1f\u201d\"\n   }\n]\n}\n    ");
        if (loadAsString.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RecommendMemeData c16 = d.c(loadAsString);
            this.recommendMemeData = c16;
            w53.b.a("WinkMemeViewModel", "recommendText:" + c16);
            U1();
        }
    }
}
