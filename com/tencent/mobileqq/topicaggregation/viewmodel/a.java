package com.tencent.mobileqq.topicaggregation.viewmodel;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b55.g;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.topicaggregation.bean.FlockTopicAggregationInitBean;
import com.tencent.mobileqq.topicaggregation.request.FlockTopicFeedListRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/topicaggregation/viewmodel/a;", "Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "", "success", "", "retCode", "", "errMsg", "Lb55/b;", "rsp", FeedManager.LOAD_MORE, "", "e2", "getLogTag", "Landroid/content/Intent;", "intent", "f2", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "W1", "Lcom/tencent/mobileqq/topicaggregation/bean/FlockTopicAggregationInitBean;", "<set-?>", "J", "Lcom/tencent/mobileqq/topicaggregation/bean/FlockTopicAggregationInitBean;", "c2", "()Lcom/tencent/mobileqq/topicaggregation/bean/FlockTopicAggregationInitBean;", "initBean", "Landroidx/lifecycle/MutableLiveData;", "Lb55/g;", "K", "Landroidx/lifecycle/MutableLiveData;", "_topicInfo", "Landroidx/lifecycle/LiveData;", "L", "Landroidx/lifecycle/LiveData;", "d2", "()Landroidx/lifecycle/LiveData;", "topicInfo", "<init>", "()V", "M", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a extends com.tencent.mobileqq.flock.feedlist.viewmodel.a {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: J, reason: from kotlin metadata */
    private FlockTopicAggregationInitBean initBean;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<g> _topicInfo;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<g> topicInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/topicaggregation/viewmodel/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.topicaggregation.viewmodel.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/topicaggregation/viewmodel/a$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lb55/b;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements VSDispatchObserver.OnVSRspCallBack<b55.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f293463b;

        b(boolean z16) {
            this.f293463b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(@Nullable BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable b55.b rsp) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, request, Boolean.valueOf(isSuccess), Long.valueOf(retCode), errMsg, rsp);
                return;
            }
            String logTag = a.this.getLogTag();
            Boolean bool = null;
            if (request != null) {
                str = request.getTraceId();
            } else {
                str = null;
            }
            if (rsp != null) {
                bool = Boolean.valueOf(rsp.f27964d);
            }
            QLog.d(logTag, 1, "requestFeedList, onReceive, traceId:" + str + ", isSuccess:" + isSuccess + ", retCode:" + retCode + ", errMsg:" + errMsg + ", isFinish: " + bool);
            a.this.e2(isSuccess, retCode, errMsg, rsp, this.f293463b);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50741);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<g> mutableLiveData = new MutableLiveData<>();
        this._topicInfo = mutableLiveData;
        this.topicInfo = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(boolean success, long retCode, String errMsg, b55.b rsp, boolean loadMore) {
        y45.b[] bVarArr;
        HashMap<String, String> hashMap;
        g gVar;
        if (success && retCode == 0) {
            if (!loadMore && rsp != null && (gVar = rsp.f27961a) != null) {
                this._topicInfo.postValue(gVar);
            }
            if (rsp != null && (bVarArr = rsp.f27962b) != null) {
                ArrayList arrayList = new ArrayList(bVarArr.length);
                for (y45.b it : bVarArr) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(new com.tencent.mobileqq.flock.feeddetail.bean.a(it));
                }
                boolean z16 = rsp.f27964d;
                Map<String, String> map = rsp.f27963c;
                if (map instanceof HashMap) {
                    hashMap = (HashMap) map;
                } else {
                    hashMap = null;
                }
                U1(arrayList, loadMore, z16, hashMap, null);
                return;
            }
            return;
        }
        T1(retCode, errMsg, loadMore);
    }

    @Override // com.tencent.mobileqq.flock.feedlist.viewmodel.a
    public void W1(boolean isLoadMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isLoadMore);
            return;
        }
        super.W1(isLoadMore);
        FlockTopicFeedListRequest flockTopicFeedListRequest = new FlockTopicFeedListRequest(c2().getTagId(), 0, O1(), 2, null);
        QLog.d(getLogTag(), 1, "requestFeedList, tagId:" + c2().getTagId() + ", attachInfo: " + O1() + ", isLoadMore:" + isLoadMore);
        sendRequest(flockTopicFeedListRequest, new b(isLoadMore));
    }

    @NotNull
    public final FlockTopicAggregationInitBean c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FlockTopicAggregationInitBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        FlockTopicAggregationInitBean flockTopicAggregationInitBean = this.initBean;
        if (flockTopicAggregationInitBean != null) {
            return flockTopicAggregationInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    @NotNull
    public final LiveData<g> d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.topicInfo;
    }

    public final void f2(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.mobileqq.topicaggregation.bean.FlockTopicAggregationInitBean");
        this.initBean = (FlockTopicAggregationInitBean) serializableExtra;
    }

    @Override // com.tencent.mobileqq.flock.feedlist.viewmodel.a, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return super.getLogTag() + "_FlockTopicAggregationViewModel";
    }
}
