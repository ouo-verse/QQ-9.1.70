package com.tencent.mobileqq.guild.discoveryv2.hotlive;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.data.OpenParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetHotLiveRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.bp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cy;
import com.tencent.mobileqq.qqguildsdk.data.genc.dh;
import com.tencent.mobileqq.qqguildsdk.data.genc.t;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import gi1.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.cl;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 =2\u00020\u0001:\u0001>B+\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013\u00a2\u0006\u0004\b;\u0010<J\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010 R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00101R\u001d\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018038F\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e038F\u00a2\u0006\u0006\u001a\u0004\b7\u00105R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\"038F\u00a2\u0006\u0006\u001a\u0004\b9\u00105\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/GuildHotLiveViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/g;", "Z1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "initData", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "e2", "refresh", "d2", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam;", "i", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam;", "c2", "()Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam;", "param", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProHotLiveCard;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "hotLives", "Landroidx/lifecycle/MutableLiveData;", "", "Lgi1/b;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_pageDataLiveData", "Lcom/tencent/mobileqq/guild/util/cn;", "Lcf1/b;", "D", "Lcom/tencent/mobileqq/guild/util/cn;", "_toastEvent", "", "E", "_finishRefreshEvent", UserInfo.SEX_FEMALE, "Z", "isLoading", "", "G", "Ljava/lang/String;", "sessionId", "", "H", "[B", "cookies", "", "I", "refreshNum", "Landroidx/lifecycle/LiveData;", "b2", "()Landroidx/lifecycle/LiveData;", "pageDataLiveData", "getToastEvent", "toastEvent", ICustomDataEditor.STRING_ARRAY_PARAM_2, "finishRefreshEvent", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam;Ljava/util/ArrayList;)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHotLiveViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<gi1.b>> _pageDataLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final cn<cf1.b> _toastEvent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _finishRefreshEvent;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String sessionId;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private byte[] cookies;

    /* renamed from: I, reason: from kotlin metadata */
    private int refreshNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OpenParam param;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ArrayList<IGProHotLiveCard> hotLives;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errorMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetHotLiveRsp;", "rsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetHotLiveRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements cl {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<g> f217448a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHotLiveViewModel f217449b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super g> cancellableContinuation, GuildHotLiveViewModel guildHotLiveViewModel) {
            this.f217448a = cancellableContinuation;
            this.f217449b = guildHotLiveViewModel;
        }

        @Override // wh2.cl
        public final void a(int i3, String errorMsg, IGProGetHotLiveRsp iGProGetHotLiveRsp) {
            List mutableList;
            boolean z16;
            if (i3 == 0) {
                ArrayList arrayList = this.f217449b.hotLives;
                if (arrayList != null) {
                    arrayList.clear();
                }
                ArrayList<IGProRecommendItem> recommendList = iGProGetHotLiveRsp.getRecommendList();
                Intrinsics.checkNotNullExpressionValue(recommendList, "rsp.recommendList");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : recommendList) {
                    if (((IGProRecommendItem) obj).getChannelInfo().getIsWhole() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList2.add(obj);
                    }
                }
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
                Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
                String traceId = iGProGetHotLiveRsp.getExtInfo().getTraceId();
                Intrinsics.checkNotNullExpressionValue(traceId, "rsp.extInfo.traceId");
                g gVar = new g(i3, errorMsg, mutableList, traceId);
                this.f217449b.sessionId = iGProGetHotLiveRsp.getSessionId();
                GuildHotLiveViewModel guildHotLiveViewModel = this.f217449b;
                byte[] cookie = iGProGetHotLiveRsp.getCookie();
                Intrinsics.checkNotNullExpressionValue(cookie, "rsp.cookie");
                guildHotLiveViewModel.cookies = cookie;
                Logger.f235387a.d().i("GuildHotLiveViewModel", 1, "fetchFirstPage: " + gVar);
                this.f217448a.resumeWith(Result.m476constructorimpl(gVar));
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "fetchFirstPage failed: " + i3 + "-" + errorMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildHotLiveViewModel", 1, (String) it.next(), null);
            }
            CancellableContinuation<g> cancellableContinuation = this.f217448a;
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new g(i3, errorMsg, null, null, 12, null)));
        }
    }

    public GuildHotLiveViewModel(@NotNull OpenParam param, @Nullable ArrayList<IGProHotLiveCard> arrayList) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.hotLives = arrayList;
        this._pageDataLiveData = new MutableLiveData<>();
        this._toastEvent = new cn<>();
        this._finishRefreshEvent = new cn<>();
        this.sessionId = "";
        this.cookies = new byte[0];
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Z1(Continuation<? super g> continuation) {
        Continuation intercepted;
        boolean z16;
        int collectionSizeOrDefault;
        ArrayList<cy> n3;
        int i3;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        dh dhVar = new dh();
        t a16 = mh1.b.f416778a.a(getParam().getPageFrom());
        dhVar.d(a16.a());
        dhVar.f(a16.c());
        dhVar.e(a16.b());
        bp bpVar = new bp();
        bpVar.j(dhVar);
        int i16 = this.refreshNum;
        this.refreshNum = i16 + 1;
        bpVar.h(i16);
        bpVar.i(this.sessionId);
        bpVar.f(this.cookies);
        ArrayList arrayList = this.hotLives;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            n3 = new ArrayList<>();
        } else {
            bg bgVar = bg.f302144a;
            ArrayList<IGProHotLiveCard> arrayList2 = this.hotLives;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            for (IGProHotLiveCard iGProHotLiveCard : arrayList2) {
                cy cyVar = new cy();
                cyVar.j(String.valueOf(iGProHotLiveCard.getChannelId()));
                cyVar.h(iGProHotLiveCard.getGuildId());
                cyVar.g(iGProHotLiveCard.getChannelId());
                if (iGProHotLiveCard.getChannelType() == 5) {
                    i3 = 2;
                } else {
                    i3 = 100;
                }
                cyVar.k(i3);
                arrayList3.add(cyVar);
            }
            n3 = bgVar.n(arrayList3);
        }
        bpVar.g(n3);
        Logger.f235387a.d().i("GuildHotLiveViewModel", 1, "fetchFirstPage req: " + bpVar);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getHotLive(bpVar, new b(cancellableContinuationImpl, this));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @NotNull
    public final LiveData<Boolean> a2() {
        return this._finishRefreshEvent;
    }

    @NotNull
    public final LiveData<List<gi1.b>> b2() {
        return this._pageDataLiveData;
    }

    @NotNull
    /* renamed from: c2, reason: from getter */
    public final OpenParam getParam() {
        return this.param;
    }

    public final void d2() {
        List<gi1.b> listOf;
        MutableLiveData<List<gi1.b>> mutableLiveData = this._pageDataLiveData;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new k());
        mutableLiveData.setValue(listOf);
        refresh();
    }

    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b e2() {
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "GuildHotLiveViewModel initData", null, null, Boolean.TRUE, new GuildHotLiveViewModel$updateData$1(this, null), 6, null);
    }

    @NotNull
    public final LiveData<cf1.b> getToastEvent() {
        return this._toastEvent;
    }

    public final void initData() {
        List<gi1.b> listOf;
        MutableLiveData<List<gi1.b>> mutableLiveData = this._pageDataLiveData;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new k());
        mutableLiveData.setValue(listOf);
        e2();
    }

    public final void refresh() {
        if (this.isLoading) {
            Logger.f235387a.d().i("GuildHotLiveViewModel", 1, "refresh current isLoading");
        } else {
            e2();
        }
    }
}
