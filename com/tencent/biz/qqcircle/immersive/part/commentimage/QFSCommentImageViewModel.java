package com.tencent.biz.qqcircle.immersive.part.commentimage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentPicInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentPicInfoSet;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLike;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ \u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0016R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R&\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020.0-0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010%R)\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020.0-0'8\u0006\u00a2\u0006\f\n\u0004\b1\u0010)\u001a\u0004\b2\u0010+R\u0018\u00106\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u00020.8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u00020.8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u00108R\u0011\u0010>\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010A\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b?\u0010@\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006D"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "info", "Lcom/tencent/biz/qqcircle/requests/QCircleDoLikeRequest;", "O1", "T", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "b2", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/biz/qqcircle/beans/QCircleCommentPicLayerBean;", "bean", "", "Z1", "", "feedId", "fakeCommentId", "Lfeedcloud/FeedCloudMeta$StComment;", "comment", "c2", "", "index", ICustomDataEditor.STRING_ARRAY_PARAM_2, "P1", "getLogTag", "i", "I", "_currentIndex", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "U1", "()Ljava/util/List;", "infos", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_currentInfoLiveData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "currentInfoLiveData", "Lkotlin/Pair;", "", "E", "_likeLiveData", UserInfo.SEX_FEMALE, "X1", "likeLiveData", "G", "Lcom/tencent/biz/qqcircle/beans/QCircleCommentPicLayerBean;", "initBean", "T1", "()Z", "haveSaveOperate", "S1", "haveEmojiOperate", "W1", "()I", "initialIndex", "R1", "()Ljava/lang/String;", "fromHashCode", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSCommentImageViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<QFSCommentImageInfo> _currentInfoLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<QFSCommentImageInfo> currentInfoLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<String, Boolean>> _likeLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Pair<String, Boolean>> likeLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QCircleCommentPicLayerBean initBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int _currentIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QFSCommentImageInfo> infos = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b2\u000e\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\r0\rH\n\u00a2\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "T", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "success", "", "retCode", "", "errMsg", "", "rsp", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class a<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<T> f87880a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSCommentImageViewModel f87881b;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super T> cancellableContinuation, QFSCommentImageViewModel qFSCommentImageViewModel) {
            this.f87880a = cancellableContinuation;
            this.f87881b = qFSCommentImageViewModel;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            if (!this.f87880a.isActive()) {
                QLog.d(this.f87881b.getTAG(), 1, "[sendRequestSuspend] cont is not active");
                return;
            }
            if (z16 && j3 == 0 && obj != null) {
                this.f87880a.resumeWith(Result.m476constructorimpl(obj));
                return;
            }
            QLog.w(this.f87881b.getTAG(), 1, "[sendRequestSuspend] success=" + z16 + ", retCode=" + j3 + ", errMsg=" + str);
            CancellableContinuation<T> cancellableContinuation = this.f87880a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException(str))));
        }
    }

    public QFSCommentImageViewModel() {
        MutableLiveData<QFSCommentImageInfo> mutableLiveData = new MutableLiveData<>();
        this._currentInfoLiveData = mutableLiveData;
        this.currentInfoLiveData = mutableLiveData;
        MutableLiveData<Pair<String, Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this._likeLiveData = mutableLiveData2;
        this.likeLiveData = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QCircleDoLikeRequest O1(QFSCommentImageInfo info) {
        FeedCloudMeta$StLike feedCloudMeta$StLike;
        int i3;
        FeedCloudMeta$StFeed j3 = info.j();
        if (j3 == null) {
            QLog.w(getTAG(), 1, "[createLikeRequest] no feed found");
            return null;
        }
        if (info.u()) {
            if (info.getStReply() != null) {
                feedCloudMeta$StLike = info.getStReply().likeInfo;
                Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StLike, "info.stReply.likeInfo");
                i3 = 6;
            } else {
                feedCloudMeta$StLike = info.getStComment().likeInfo;
                Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StLike, "info.stComment.likeInfo");
                i3 = 4;
            }
        } else if (info.getStReply() != null) {
            feedCloudMeta$StLike = info.getStReply().likeInfo;
            Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StLike, "info.stReply.likeInfo");
            i3 = 5;
        } else {
            feedCloudMeta$StLike = info.getStComment().likeInfo;
            Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StLike, "info.stComment.likeInfo");
            i3 = 3;
        }
        return new QCircleDoLikeRequest(j3, i3, feedCloudMeta$StLike, info.getStComment(), info.getStReply(), false, (QCircleInitBean) this.initBean);
    }

    private final boolean S1() {
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.initBean;
        if (qCircleCommentPicLayerBean != null) {
            return qCircleCommentPicLayerBean.getNeedAddImageOperate();
        }
        return false;
    }

    private final boolean T1() {
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.initBean;
        if (qCircleCommentPicLayerBean != null) {
            return qCircleCommentPicLayerBean.needSaveOperate();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object b2(BaseRequest baseRequest, Continuation<? super T> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        sendRequest(baseRequest, new a(cancellableContinuationImpl, this));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void P1(@NotNull QFSCommentImageInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        QLog.d(getTAG(), 1, "[doLike] id=" + info.l());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new QFSCommentImageViewModel$doLike$1(this, info, null), 3, null);
    }

    @NotNull
    public final LiveData<QFSCommentImageInfo> Q1() {
        return this.currentInfoLiveData;
    }

    @NotNull
    public final String R1() {
        String str;
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.initBean;
        if (qCircleCommentPicLayerBean != null) {
            str = qCircleCommentPicLayerBean.getFromHashCode();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final List<QFSCommentImageInfo> U1() {
        return this.infos;
    }

    public final int W1() {
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.initBean;
        if (qCircleCommentPicLayerBean != null) {
            return qCircleCommentPicLayerBean.getStartPreviewIndex();
        }
        return 0;
    }

    @NotNull
    public final LiveData<Pair<String, Boolean>> X1() {
        return this.likeLiveData;
    }

    public final void Z1(@NotNull QCircleCommentPicLayerBean bean) {
        ArrayList<QFSCommentPicInfo> arrayList;
        ArrayList<QFSCommentPicInfo> arrayList2;
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.infos.clear();
        this.initBean = bean;
        Integer num = null;
        QFSCommentPicInfoSet qFSCommentPicInfoSet = (QFSCommentPicInfoSet) uq3.k.a().g("mmkv_key_pic_info_set", QFSCommentPicInfoSet.class, null);
        if (qFSCommentPicInfoSet != null && (arrayList2 = qFSCommentPicInfoSet.infos) != null) {
            for (QFSCommentPicInfo qFSCommentPicInfo : arrayList2) {
                FeedCloudMeta$StComment comment = qFSCommentPicInfo.getComment();
                if (comment != null) {
                    Intrinsics.checkNotNullExpressionValue(comment, "comment");
                    String feedId = qFSCommentPicInfo.getFeedId();
                    if (feedId == null) {
                        feedId = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(feedId, "picInfo.feedId ?: \"\"");
                    }
                    this.infos.add(new QFSCommentImageInfo(feedId, comment, qFSCommentPicInfo.getReply(), qFSCommentPicInfo.getImage(), T1(), S1(), false, 64, null));
                }
            }
        }
        String tag = getTAG();
        int W1 = W1();
        if (qFSCommentPicInfoSet != null && (arrayList = qFSCommentPicInfoSet.infos) != null) {
            num = Integer.valueOf(arrayList.size());
        }
        QLog.d(tag, 1, "[parseBean] initialIndex=" + W1 + ", old size=" + num + ", new size=" + this.infos.size());
        a2(W1());
    }

    public final void a2(int index) {
        boolean z16 = false;
        if (index >= 0 && index < this.infos.size()) {
            z16 = true;
        }
        if (z16) {
            this._currentIndex = index;
            this._currentInfoLiveData.postValue(this.infos.get(index));
            return;
        }
        QLog.w(getTAG(), 1, "[selectImageInfo] invalid index: " + index + ", info size=" + this.infos.size());
    }

    public final void c2(@NotNull String feedId, @NotNull String fakeCommentId, @Nullable FeedCloudMeta$StComment comment) {
        boolean isBlank;
        boolean isBlank2;
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(fakeCommentId, "fakeCommentId");
        if (QLog.isDebugVersion()) {
            QLog.d(getTAG(), 1, "[updateFakeComment]");
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(feedId);
        if (!isBlank) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(fakeCommentId);
            if (!isBlank2 && comment != null) {
                Iterator<T> it = this.infos.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        QFSCommentImageInfo qFSCommentImageInfo = (QFSCommentImageInfo) obj;
                        if (Intrinsics.areEqual(qFSCommentImageInfo.getStComment().f398447id.get(), fakeCommentId) && Intrinsics.areEqual(feedId, qFSCommentImageInfo.getFeedId())) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                QFSCommentImageInfo qFSCommentImageInfo2 = (QFSCommentImageInfo) obj;
                if (qFSCommentImageInfo2 != null) {
                    String str = comment.f398447id.get();
                    QLog.d(getTAG(), 1, "[updateFakeComment] find fake comment, feedId=" + feedId + ", fakeId=" + fakeCommentId + ", realId=" + str);
                    qFSCommentImageInfo2.w(comment);
                    return;
                }
                return;
            }
        }
        QLog.d(getTAG(), 1, "[updateFakeComment] invalid params, feedId=" + feedId + ", fakeId=" + fakeCommentId);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentImageViewModel";
    }
}
