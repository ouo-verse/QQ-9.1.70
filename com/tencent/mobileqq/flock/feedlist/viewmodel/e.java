package com.tencent.mobileqq.flock.feedlist.viewmodel;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flock.feedlist.request.GetMainPageFeedListRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import z45.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R+\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/viewmodel/e;", "Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "", "success", "", "retCode", "", "errMsg", "Lz45/h;", "rsp", FeedManager.LOAD_MORE, "", "e2", "getLogTag", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "W1", "", "<set-?>", "J", "Lkotlin/properties/ReadWriteProperty;", "d2", "()I", "i2", "(I)V", "tabType", "K", "I", "c2", "setRecomType", "recomType", "L", "Z", "f2", "()Z", SemanticAttributes.DbSystemValues.H2, "(Z)V", "isFinish", "<init>", "()V", "M", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    static final /* synthetic */ KProperty<Object>[] N;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty tabType;

    /* renamed from: K, reason: from kotlin metadata */
    private int recomType;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isFinish;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/viewmodel/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedlist.viewmodel.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44176);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            N = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "tabType", "getTabType()I", 0))};
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.tabType = Delegates.INSTANCE.notNull();
            this.recomType = 1;
        }
    }

    private final void e2(boolean success, long retCode, String errMsg, h rsp, boolean loadMore) {
        y45.b[] bVarArr;
        boolean z16;
        HashMap<String, String> hashMap;
        if (success && retCode == 0) {
            if (rsp != null && (bVarArr = rsp.f451913b) != null) {
                ArrayList arrayList = new ArrayList(bVarArr.length);
                for (y45.b it : bVarArr) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(new com.tencent.mobileqq.flock.feeddetail.bean.a(it));
                }
                this.recomType = rsp.f451912a;
                if (rsp.f451914c == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.isFinish = z16;
                Map<String, String> map = rsp.f451916e;
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
    public static final void g2(e this$0, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, h hVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e2(z17, j3, str, hVar, z16);
    }

    @Override // com.tencent.mobileqq.flock.feedlist.viewmodel.a
    public void W1(final boolean isLoadMore) {
        List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, isLoadMore);
            return;
        }
        super.W1(isLoadMore);
        if (!isLoadMore) {
            this.isFinish = false;
        }
        if (this.isFinish && isLoadMore) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            U1(emptyList, true, true, O1(), P1());
            QLog.d(getTAG(), 1, "FlockGetJoinFeedListViewModel skip by loadMore in finish");
            return;
        }
        GetMainPageFeedListRequest getMainPageFeedListRequest = new GetMainPageFeedListRequest(d2(), O1());
        QLog.d(getTAG(), 1, "FlockGetJoinFeedListViewModel | tabType:" + d2() + " attachInfo: " + O1() + " isLoadMore:" + isLoadMore);
        sendRequest(getMainPageFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.feedlist.viewmodel.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                e.g2(e.this, isLoadMore, baseRequest, z16, j3, str, (h) obj);
            }
        });
    }

    public final int c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.recomType;
    }

    public final int d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return ((Number) this.tabType.getValue(this, N[0])).intValue();
    }

    public final boolean f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isFinish;
    }

    @Override // com.tencent.mobileqq.flock.feedlist.viewmodel.a, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return super.getTAG() + "_FlockGetHomePageFeedListViewModel";
    }

    public final void h2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isFinish = z16;
        }
    }

    public final void i2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.tabType.setValue(this, N[0], Integer.valueOf(i3));
        }
    }
}
