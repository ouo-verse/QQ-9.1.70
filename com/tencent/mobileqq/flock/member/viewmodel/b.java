package com.tencent.mobileqq.flock.member.viewmodel;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.flock.member.request.GetFeedJoinListRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.o;
import z45.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0006R&\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR)\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R2\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/flock/member/viewmodel/b;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "success", "", "retCode", "", "errMsg", "Lz45/d;", "rsp", FeedManager.LOAD_MORE, "", "O1", "S1", "getLogTag", "Landroid/os/Bundle;", "arguments", "P1", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "Q1", "N1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/mobileqq/flock/member/bean/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "_memberListData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "memberListData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "attachInfo", "D", "Ljava/lang/String;", "feedId", "E", "senderId", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, String> attachInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String feedId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String senderId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>>> _memberListData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>>> memberListData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/flock/member/viewmodel/b$a;", "", "", "IS_FINISH", "I", "", "KEY_FEED", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.member.viewmodel.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47881);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>>> mutableLiveData = new MutableLiveData<>();
        this._memberListData = mutableLiveData;
        this.memberListData = mutableLiveData;
        this.attachInfo = new HashMap<>();
        this.feedId = "";
        this.senderId = "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        r3 = kotlin.collections.ArraysKt___ArraysKt.toList(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void O1(boolean success, long retCode, String errMsg, d rsp, boolean loadMore) {
        Map<String, String> map;
        List list;
        int collectionSizeOrDefault;
        ArrayList arrayList;
        Collection collection;
        if (success && retCode == 0) {
            if (rsp != null && (r3 = rsp.f451898a) != null && list != null) {
                List list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    o oVar = ((z45.o) it.next()).f451930a;
                    Intrinsics.checkNotNullExpressionValue(oVar, "it.user");
                    arrayList2.add(new com.tencent.mobileqq.flock.member.bean.a(oVar));
                }
                if (loadMore) {
                    UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>> value = this._memberListData.getValue();
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
                arrayList.addAll(arrayList2);
                MutableLiveData<UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>>> mutableLiveData = this._memberListData;
                boolean z16 = false;
                UIStateData data = UIStateData.obtainSuccess(false).setData(loadMore, arrayList);
                if (rsp.f451899b == 1) {
                    z16 = true;
                }
                mutableLiveData.postValue(data.setFinish(z16));
            }
            if (rsp != null && (map = rsp.f451901d) != null) {
                this.attachInfo = (HashMap) map;
                return;
            }
            return;
        }
        this._memberListData.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(b this$0, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, d dVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O1(z17, j3, str, dVar, z16);
    }

    private final void S1() {
        this.attachInfo.clear();
    }

    @NotNull
    public final LiveData<UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>>> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.memberListData;
    }

    @NotNull
    public final String N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.senderId;
    }

    public final void P1(@Nullable Bundle arguments) {
        byte[] byteArray;
        y45.b d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arguments);
            return;
        }
        if (arguments != null && (byteArray = arguments.getByteArray("key_feed")) != null && (d16 = y45.b.d(byteArray)) != null) {
            String str = d16.f449366a;
            Intrinsics.checkNotNullExpressionValue(str, "it.id");
            this.feedId = str;
            String str2 = d16.f449369d.f449449a;
            Intrinsics.checkNotNullExpressionValue(str2, "it.publisher.id");
            this.senderId = str2;
            Unit unit = Unit.INSTANCE;
        }
        QLog.d("FlockMemberListViewModel", 1, "senderId:" + this.senderId + " feedId:" + this.feedId);
    }

    public final void Q1(final boolean isLoadMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isLoadMore);
            return;
        }
        if (!isLoadMore) {
            S1();
        }
        GetFeedJoinListRequest getFeedJoinListRequest = new GetFeedJoinListRequest(this.feedId, this.attachInfo);
        QLog.d(getTAG(), 1, "requestGetFriendFeedList | feedId:" + this.feedId + " attachInfo: " + this.attachInfo + " isLoadMore:" + isLoadMore);
        sendRequest(getFeedJoinListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.member.viewmodel.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                b.R1(b.this, isLoadMore, baseRequest, z16, j3, str, (d) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "FlockMemberListViewModel";
    }
}
