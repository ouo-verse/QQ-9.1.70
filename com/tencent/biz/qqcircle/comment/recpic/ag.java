package com.tencent.biz.qqcircle.comment.recpic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.BusinessScene;
import feedcloud.Embedding;
import feedcloud.MultiInferTextRsp;
import feedcloud.PredefinedPipeline;
import feedcloud.TextPipeline;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bJ\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00020\u00190\u0018R&\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00020\u00190\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/ag;", "Lcom/tencent/biz/qqcircle/viewmodels/a;", "", "Lfeedcloud/TextPipeline;", "R1", "", "c2", "Lcom/tencent/biz/qqcircle/comment/recpic/QFSInferTextRequest;", "req", "", "Z1", "", "methodName", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lfeedcloud/MultiInferTextRsp;", "O1", "b2", "getLogTag", "text", "T1", "S1", "feedId", "W1", "X1", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lfeedcloud/Embedding;", "Q1", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "mutableInferResult", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "inferResult", "D", "Z", "isInputRequesting", "E", "isDescRequesting", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ag extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<Embedding>>> inferResult;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isInputRequesting;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isDescRequesting;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<Embedding>>> mutableInferResult;

    public ag() {
        MutableLiveData<UIStateData<List<Embedding>>> mutableLiveData = new MutableLiveData<>();
        this.mutableInferResult = mutableLiveData;
        this.inferResult = mutableLiveData;
    }

    private final VSDispatchObserver.OnVSRspCallBack<MultiInferTextRsp> O1(final String methodName) {
        final long currentTimeMillis = System.currentTimeMillis();
        return new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.comment.recpic.ae
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                ag.P1(methodName, currentTimeMillis, this, baseRequest, z16, j3, str, (MultiInferTextRsp) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(String methodName, long j3, ag this$0, BaseRequest baseRequest, boolean z16, long j16, String str, MultiInferTextRsp multiInferTextRsp) {
        Intrinsics.checkNotNullParameter(methodName, "$methodName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "[" + methodName + "] | onReceive: dispatch Success:" + z16 + " CMD:" + baseRequest.get$cmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j16 + " | retMessage:" + str + " | isCache:" + isProtocolCache + " | cost:" + (System.currentTimeMillis() - j3));
        this$0.isInputRequesting = false;
        this$0.isDescRequesting = false;
        if (z16 && j16 == 0 && multiInferTextRsp != null) {
            this$0.mutableInferResult.postValue(UIStateData.obtainSuccess(isProtocolCache).setData(false, multiInferTextRsp.embeddings).setFinish(true));
        } else {
            this$0.mutableInferResult.postValue(UIStateData.obtainError(str));
        }
    }

    private final List<TextPipeline> R1() {
        ArrayList arrayList = new ArrayList();
        aa aaVar = aa.f83750a;
        if (!aaVar.q()) {
            TextPipeline build = new TextPipeline.a().b(PredefinedPipeline.PREDEFINED_PIPELINE_NOOP).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              \u2026                 .build()");
            arrayList.add(build);
        }
        if (!aaVar.o()) {
            TextPipeline build2 = new TextPipeline.a().b(PredefinedPipeline.PREDEFINED_PIPELINE_JIEBA_TOP3).build();
            Intrinsics.checkNotNullExpressionValue(build2, "Builder()\n              \u2026                 .build()");
            arrayList.add(build2);
        }
        if (aaVar.w() || c2()) {
            TextPipeline build3 = new TextPipeline.a().b(PredefinedPipeline.PREDEFINED_PIPELINE_COMMENT_PROMPT).build();
            Intrinsics.checkNotNullExpressionValue(build3, "Builder()\n              \u2026\n                .build()");
            arrayList.add(build3);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(QFSInferTextRequest req, ag this$0) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.debug.a.b(req, this$0.O1("requestFeedDescFeatureInTestDomain"));
    }

    private final void Z1(final QFSInferTextRequest req) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.af
            @Override // java.lang.Runnable
            public final void run() {
                ag.a2(QFSInferTextRequest.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(QFSInferTextRequest req, ag this$0) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.debug.a.b(req, this$0.O1("requestTextFeatureInTestDomain"));
    }

    private final void b2(QFSInferTextRequest req) {
        VSNetworkHelper.getInstance().sendRequest(req, O1("requestTextFeature"));
    }

    private final boolean c2() {
        return com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_REC_PIC_SWITCH_DOMAIN, 0);
    }

    @NotNull
    public final LiveData<UIStateData<List<Embedding>>> Q1() {
        return this.inferResult;
    }

    public final void S1(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (this.isDescRequesting) {
            QLog.d("QFSRecPicInputViewModel", 1, "[requestFeedDescFeature] is requesting...");
        } else {
            this.isDescRequesting = true;
            b2(new QFSInferTextRequest(text, BusinessScene.BUSINESS_SCENE_FEED_INTRO));
        }
    }

    public final void T1(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (this.isDescRequesting) {
            QLog.d("QFSRecPicInputViewModel", 1, "[requestFeedDescFeatureInTestDomain] is requesting...");
            return;
        }
        this.isDescRequesting = true;
        final QFSInferTextRequest qFSInferTextRequest = new QFSInferTextRequest(text, BusinessScene.BUSINESS_SCENE_FEED_INTRO);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.ad
            @Override // java.lang.Runnable
            public final void run() {
                ag.U1(QFSInferTextRequest.this, this);
            }
        });
    }

    public final void W1(@NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        if (this.isDescRequesting) {
            QLog.d("QFSRecPicInputViewModel", 1, "[requestFeedDescFeature] is requesting...");
            return;
        }
        this.isDescRequesting = true;
        VSNetworkHelper.getInstance().sendRequest(new QFSInferFeedDescRequest(feedId), O1("requestFeedDescFeature"));
    }

    public final void X1(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (this.isInputRequesting) {
            QLog.d("QFSRecPicInputViewModel", 1, "[requestTextFeature] is requesting...");
            return;
        }
        this.isInputRequesting = true;
        List<TextPipeline> R1 = R1();
        if (R1.isEmpty()) {
            QLog.d("QFSRecPicInputViewModel", 1, "[requestTextFeature] pipelines is empty");
        } else if (c2()) {
            Z1(new QFSInferTextRequest(text, R1, BusinessScene.BUSINESS_SCENE_COMMENT));
        } else {
            b2(new QFSInferTextRequest(text, R1, BusinessScene.BUSINESS_SCENE_CUSTOM));
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSRecPicInputViewModel";
    }
}
