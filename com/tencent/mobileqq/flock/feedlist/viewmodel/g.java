package com.tencent.mobileqq.flock.feedlist.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flock.feedlist.request.GetSearchRecomFeedListRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import z45.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R&\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R)\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00130\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/viewmodel/g;", "Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "", "success", "", "retCode", "", "errMsg", "Lz45/l;", "rsp", FeedManager.LOAD_MORE, "", "d2", "f2", "e2", "getLogTag", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "W1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lb55/g;", "J", "Landroidx/lifecycle/MutableLiveData;", "_tagListData", "Landroidx/lifecycle/LiveData;", "K", "Landroidx/lifecycle/LiveData;", "c2", "()Landroidx/lifecycle/LiveData;", "tagListData", "<init>", "()V", "L", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<b55.g>>> _tagListData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<b55.g>>> tagListData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/viewmodel/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedlist.viewmodel.g$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44606);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<UIStateData<List<b55.g>>> mutableLiveData = new MutableLiveData<>();
        this._tagListData = mutableLiveData;
        this.tagListData = mutableLiveData;
    }

    private final void d2(boolean success, long retCode, String errMsg, l rsp, boolean loadMore) {
        int[] iArr;
        boolean contains;
        b55.g[] gVarArr;
        boolean contains2;
        y45.b[] bVarArr;
        int collectionSizeOrDefault;
        boolean z16;
        if (success && retCode == 0) {
            if (rsp != null) {
                iArr = rsp.f451926e;
            } else {
                iArr = null;
            }
            boolean z17 = false;
            if (iArr == null) {
                iArr = new int[0];
            }
            int[] iArr2 = iArr;
            String tag = getTAG();
            String arrays = Arrays.toString(iArr2);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            QLog.d(tag, 1, "handleFeedListResponse | isLoadMore:" + loadMore + " mask:" + arrays);
            contains = ArraysKt___ArraysKt.contains(iArr2, 100);
            if (!contains) {
                if (rsp != null && (bVarArr = rsp.f451922a) != null) {
                    ArrayList<y45.b> arrayList = new ArrayList();
                    for (y45.b bVar : bVarArr) {
                        if (!Q1().contains(bVar.f449366a)) {
                            arrayList.add(bVar);
                        }
                    }
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    for (y45.b it : arrayList) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        arrayList2.add(new com.tencent.mobileqq.flock.feeddetail.bean.a(it));
                    }
                    if (rsp.f451923b == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    U1(arrayList2, loadMore, z16, null, rsp.f451924c);
                }
            } else {
                T1(100L, errMsg, loadMore);
            }
            if (rsp != null && (gVarArr = rsp.f451925d) != null) {
                if (gVarArr.length == 0) {
                    z17 = true;
                }
                if (!z17) {
                    contains2 = ArraysKt___ArraysKt.contains(iArr2, 101);
                    if (!contains2) {
                        f2(rsp);
                        return;
                    } else {
                        e2(101L, errMsg);
                        return;
                    }
                }
                return;
            }
            return;
        }
        T1(retCode, errMsg, loadMore);
        e2(retCode, errMsg);
    }

    private final void e2(long retCode, String errMsg) {
        this._tagListData.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode));
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        r4 = kotlin.collections.ArraysKt___ArraysKt.toList(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f2(l rsp) {
        List list;
        if (rsp != null && (r4 = rsp.f451925d) != null && list != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            this._tagListData.postValue(UIStateData.obtainSuccess(false).setData(false, arrayList).setFinish(true));
            return;
        }
        this._tagListData.postValue(UIStateData.obtainError("").setRetCode(101L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(g this$0, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, l lVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d2(z17, j3, str, lVar, z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d  */
    @Override // com.tencent.mobileqq.flock.feedlist.viewmodel.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void W1(final boolean isLoadMore) {
        int[] iArr;
        byte[] P1;
        Boolean bool;
        boolean z16;
        List<b55.g> data;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isLoadMore);
            return;
        }
        if (!isLoadMore) {
            Q1().clear();
        }
        boolean z17 = false;
        if (isLoadMore) {
            UIStateData<List<b55.g>> value = this._tagListData.getValue();
            if (value != null && (data = value.getData()) != null && (!data.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                iArr = new int[]{1};
                GetSearchRecomFeedListRequest getSearchRecomFeedListRequest = new GetSearchRecomFeedListRequest(P1(), iArr);
                String tag = getTAG();
                String arrays = Arrays.toString(iArr);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                P1 = P1();
                if (P1 == null) {
                    if (P1.length == 0) {
                        z17 = true;
                    }
                    bool = Boolean.valueOf(z17);
                } else {
                    bool = null;
                }
                QLog.d(tag, 1, "requestFeedList | isLoadMore:" + isLoadMore + " mask:" + arrays + " attachInfo2 is null:" + bool);
                sendRequest(getSearchRecomFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.feedlist.viewmodel.f
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z18, long j3, String str, Object obj) {
                        g.g2(g.this, isLoadMore, baseRequest, z18, j3, str, (l) obj);
                    }
                });
            }
        }
        iArr = new int[]{1, 2};
        GetSearchRecomFeedListRequest getSearchRecomFeedListRequest2 = new GetSearchRecomFeedListRequest(P1(), iArr);
        String tag2 = getTAG();
        String arrays2 = Arrays.toString(iArr);
        Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
        P1 = P1();
        if (P1 == null) {
        }
        QLog.d(tag2, 1, "requestFeedList | isLoadMore:" + isLoadMore + " mask:" + arrays2 + " attachInfo2 is null:" + bool);
        sendRequest(getSearchRecomFeedListRequest2, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.feedlist.viewmodel.f
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z18, long j3, String str, Object obj) {
                g.g2(g.this, isLoadMore, baseRequest, z18, j3, str, (l) obj);
            }
        });
    }

    @NotNull
    public final LiveData<UIStateData<List<b55.g>>> c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.tagListData;
    }

    @Override // com.tencent.mobileqq.flock.feedlist.viewmodel.a, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return super.getTAG() + "_FlockGetRecomFeedListViewModel";
    }
}
