package com.tencent.mobileqq.flock.feedlist.viewmodel;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flock.feedlist.request.GetGroupFeedListRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R+\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/viewmodel/c;", "Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "", "success", "", "retCode", "", "errMsg", "Lz45/f;", "rsp", FeedManager.LOAD_MORE, "", "d2", "getLogTag", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "W1", "<set-?>", "J", "Lkotlin/properties/ReadWriteProperty;", "c2", "()J", "f2", "(J)V", "groupId", "<init>", "()V", "K", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    static final /* synthetic */ KProperty<Object>[] L;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty groupId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/viewmodel/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedlist.viewmodel.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            L = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(c.class, "groupId", "getGroupId()J", 0))};
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.groupId = Delegates.INSTANCE.notNull();
        }
    }

    private final void d2(boolean success, long retCode, String errMsg, z45.f rsp, boolean loadMore) {
        y45.b[] bVarArr;
        boolean z16;
        HashMap<String, String> hashMap;
        if (success && retCode == 0) {
            if (rsp != null && (bVarArr = rsp.f451905a) != null) {
                ArrayList arrayList = new ArrayList(bVarArr.length);
                for (y45.b it : bVarArr) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(new com.tencent.mobileqq.flock.feeddetail.bean.a(it));
                }
                if (rsp.f451906b == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Map<String, String> map = rsp.f451908d;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(c this$0, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, z45.f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d2(z17, j3, str, fVar, z16);
    }

    @Override // com.tencent.mobileqq.flock.feedlist.viewmodel.a
    public void W1(final boolean isLoadMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isLoadMore);
            return;
        }
        super.W1(isLoadMore);
        GetGroupFeedListRequest getGroupFeedListRequest = new GetGroupFeedListRequest(c2(), O1());
        QLog.d(getTAG(), 1, "GetGroupFeedListRequest | groupId:" + c2() + " attachInfo: " + O1() + " isLoadMore:" + isLoadMore);
        sendRequest(getGroupFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.feedlist.viewmodel.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.e2(c.this, isLoadMore, baseRequest, z16, j3, str, (z45.f) obj);
            }
        });
    }

    public final long c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return ((Number) this.groupId.getValue(this, L[0])).longValue();
    }

    public final void f2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.groupId.setValue(this, L[0], Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.flock.feedlist.viewmodel.a, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return super.getTAG() + "_FlockGetGroupFeedListViewModel";
    }
}
