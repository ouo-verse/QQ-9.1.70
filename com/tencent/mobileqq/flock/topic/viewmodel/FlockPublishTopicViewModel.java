package com.tencent.mobileqq.flock.topic.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b55.d;
import b55.f;
import b55.g;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.flock.topic.request.FlockGetTagSelectListRequest;
import com.tencent.mobileqq.flock.topic.request.FlockSearchTagRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\tH\u0002J,\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0016R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R)\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR&\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019R)\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u001b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001fR2\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0&j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R'\u00102\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00040+j\u0002`-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/flock/topic/viewmodel/FlockPublishTopicViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "S1", "success", "", "retCode", "", "errMsg", "Lb55/d;", "rsp", FeedManager.LOAD_MORE, "W1", "query", "X1", "Lb55/f;", "U1", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lb55/g;", "i", "Landroidx/lifecycle/MutableLiveData;", "_tagListData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "tagListData", BdhLogUtil.LogTag.Tag_Conn, "_searchListData", "D", "Q1", "searchListData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "E", "Ljava/util/HashMap;", "attachInfo", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/flock/topic/viewmodel/RefreshRequest;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "P1", "()Lkotlin/jvm/functions/Function1;", "refreshFunc", "<init>", "()V", "G", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishTopicViewModel extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<g>>> _searchListData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<g>>> searchListData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, String> attachInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Function1<Object, Unit> refreshFunc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<g>>> _tagListData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<g>>> tagListData;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/flock/topic/viewmodel/FlockPublishTopicViewModel$a;", "", "", "KEY_RESULT_FOR_TOPIC", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.topic.viewmodel.FlockPublishTopicViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockPublishTopicViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<UIStateData<List<g>>> mutableLiveData = new MutableLiveData<>();
        this._tagListData = mutableLiveData;
        this.tagListData = mutableLiveData;
        MutableLiveData<UIStateData<List<g>>> mutableLiveData2 = new MutableLiveData<>();
        this._searchListData = mutableLiveData2;
        this.searchListData = mutableLiveData2;
        this.attachInfo = new HashMap<>();
        this.refreshFunc = new Function1<Object, Unit>() { // from class: com.tencent.mobileqq.flock.topic.viewmodel.FlockPublishTopicViewModel$refreshFunc$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishTopicViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Object param) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, param);
                    return;
                }
                Intrinsics.checkNotNullParameter(param, "param");
                if (param instanceof Boolean) {
                    FlockPublishTopicViewModel.this.S1(((Boolean) param).booleanValue());
                } else if (param instanceof String) {
                    FlockPublishTopicViewModel.this.X1((String) param);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(final boolean isLoadMore) {
        if (!isLoadMore) {
            this.attachInfo.clear();
        }
        FlockGetTagSelectListRequest flockGetTagSelectListRequest = new FlockGetTagSelectListRequest(this.attachInfo);
        QLog.d(getLogTag(), 1, "getTagSelectListRequest | attachInfo: " + this.attachInfo + " isLoadMore:" + isLoadMore);
        sendRequest(flockGetTagSelectListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.topic.viewmodel.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                FlockPublishTopicViewModel.T1(FlockPublishTopicViewModel.this, isLoadMore, baseRequest, z16, j3, str, (d) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(FlockPublishTopicViewModel this$0, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, d dVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W1(z17, j3, str, dVar, z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        r4 = kotlin.collections.ArraysKt___ArraysKt.toList(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void U1(boolean success, long retCode, String errMsg, f rsp) {
        List list;
        QLog.d("FlockPublishTopicViewModel", 1, "handleSearchListResponse... success:" + success + " retCode:" + retCode + " errMsg:" + errMsg);
        if (success && retCode == 0) {
            if (rsp != null && (r4 = rsp.f27971a) != null && list != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                if (arrayList.isEmpty()) {
                    this._searchListData.postValue(UIStateData.obtainEmpty().setData(false, arrayList).setFinish(true));
                    return;
                } else {
                    this._searchListData.postValue(UIStateData.obtainSuccess(false).setData(false, arrayList).setFinish(true));
                    return;
                }
            }
            return;
        }
        this._searchListData.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        r4 = kotlin.collections.ArraysKt___ArraysKt.toList(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void W1(boolean success, long retCode, String errMsg, d rsp, boolean loadMore) {
        Map<String, String> map;
        List list;
        ArrayList arrayList;
        Collection collection;
        QLog.d("FlockPublishTopicViewModel", 1, "handleTagSelectListResponse... success:" + success + " retCode:" + retCode + " errMsg:" + errMsg);
        if (success && retCode == 0) {
            if (rsp != null && (r4 = rsp.f27967a) != null && list != null) {
                if (loadMore) {
                    UIStateData<List<g>> value = this._tagListData.getValue();
                    arrayList = null;
                    if (value != null) {
                        collection = (List) value.getData();
                    } else {
                        collection = null;
                    }
                    if (collection instanceof ArrayList) {
                        arrayList = (ArrayList) collection;
                    }
                } else {
                    arrayList = new ArrayList();
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(list);
                this._tagListData.postValue(UIStateData.obtainSuccess(false).setData(loadMore, arrayList).setFinish(rsp.f27969c));
            }
            if (rsp != null && (map = rsp.f27968b) != null) {
                this.attachInfo = (HashMap) map;
                return;
            }
            return;
        }
        this._tagListData.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(String query) {
        FlockSearchTagRequest flockSearchTagRequest = new FlockSearchTagRequest(query);
        QLog.d(getLogTag(), 1, "searchQueryRequest | query: " + query);
        sendRequest(flockSearchTagRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.topic.viewmodel.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                FlockPublishTopicViewModel.Z1(FlockPublishTopicViewModel.this, baseRequest, z16, j3, str, (f) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(FlockPublishTopicViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U1(z16, j3, str, fVar);
    }

    @NotNull
    public final Function1<Object, Unit> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Function1) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.refreshFunc;
    }

    @NotNull
    public final LiveData<UIStateData<List<g>>> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.searchListData;
    }

    @NotNull
    public final LiveData<UIStateData<List<g>>> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tagListData;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "FlockPublishTopicViewModel";
    }
}
