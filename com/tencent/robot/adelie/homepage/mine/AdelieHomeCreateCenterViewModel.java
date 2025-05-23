package com.tencent.robot.adelie.homepage.mine;

import a24.CreateCenterPageData;
import a24.a;
import a24.d;
import a24.g;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MyRobotListInfo;
import com.tencent.qqnt.kernel.nativeinterface.MyRobotsListRsp;
import com.tencent.qqnt.kernel.nativeinterface.RobotSummary;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.adelie.homepage.mine.AdelieHomeCreateCenterViewModel;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/AdelieHomeCreateCenterViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "O1", "Lcom/tencent/robot/adelie/homepage/mine/AdelieHomeCreateCenterViewModel$PageDataWrapper;", "M1", "", "getLogTag", "Landroidx/lifecycle/LiveData;", "La24/j;", "L1", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "N1", "P1", "Q1", "i", "Lcom/tencent/robot/adelie/homepage/mine/AdelieHomeCreateCenterViewModel$PageDataWrapper;", "_pageDataWrapper", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "PageDataWrapper", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeCreateCenterViewModel extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PageDataWrapper _pageDataWrapper;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/AdelieHomeCreateCenterViewModel$PageDataWrapper;", "", "", "j", "", "needClearData", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "g", "", "toString", "", "hashCode", "other", "equals", "Landroidx/lifecycle/MutableLiveData;", "La24/j;", "a", "Landroidx/lifecycle/MutableLiveData;", h.F, "()Landroidx/lifecycle/MutableLiveData;", ISchemeApi.KEY_PAGE_DATA, "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFirstSection", "c", "isRefresh", "", "d", "[B", "pagingCookie", "e", "Ljava/lang/String;", "dataVersion", "f", "Z", "isRequesting", "<init>", "(Landroidx/lifecycle/MutableLiveData;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class PageDataWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MutableLiveData<CreateCenterPageData> pageData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicBoolean isFirstSection;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicBoolean isRefresh;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private byte[] pagingCookie;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String dataVersion;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean isRequesting;

        public PageDataWrapper(@NotNull MutableLiveData<CreateCenterPageData> pageData) {
            Intrinsics.checkNotNullParameter(pageData, "pageData");
            this.pageData = pageData;
            this.isFirstSection = new AtomicBoolean(true);
            this.isRefresh = new AtomicBoolean(false);
            this.pagingCookie = new byte[0];
            this.dataVersion = "";
        }

        public static /* synthetic */ void l(PageDataWrapper pageDataWrapper, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            pageDataWrapper.k(z16);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof PageDataWrapper) && Intrinsics.areEqual(this.pageData, ((PageDataWrapper) other).pageData)) {
                return true;
            }
            return false;
        }

        public final void g(@NotNull LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            this.pageData.removeObservers(lifecycleOwner);
            i();
        }

        @NotNull
        public final MutableLiveData<CreateCenterPageData> h() {
            return this.pageData;
        }

        public int hashCode() {
            return this.pageData.hashCode();
        }

        public final void i() {
            QLog.i("AdelieHomeCreateCenterViewModel", 1, "releaseRobotChangeListener");
        }

        public final void j() {
            AdelieUtils.f365929a.U(this.pagingCookie, this.dataVersion, true, new Function3<Integer, String, MyRobotsListRsp, Unit>() { // from class: com.tencent.robot.adelie.homepage.mine.AdelieHomeCreateCenterViewModel$PageDataWrapper$requestCachePageData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, MyRobotsListRsp myRobotsListRsp) {
                    invoke(num.intValue(), str, myRobotsListRsp);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
                
                    if ((!r10.isEmpty()) == true) goto L11;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(int i3, @NotNull String errMsg, @Nullable MyRobotsListRsp myRobotsListRsp) {
                    int collectionSizeOrDefault;
                    int collectionSizeOrDefault2;
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    if (i3 != 0 || myRobotsListRsp == null) {
                        return;
                    }
                    int i16 = 0;
                    boolean z16 = myRobotsListRsp.robots != null;
                    if (z16) {
                        d dVar = new d();
                        String str = myRobotsListRsp.selfNick;
                        Intrinsics.checkNotNullExpressionValue(str, "response.selfNick");
                        dVar.e(str);
                        String str2 = myRobotsListRsp.selfUid;
                        Intrinsics.checkNotNullExpressionValue(str2, "response.selfUid");
                        dVar.f(str2);
                        dVar.g(myRobotsListRsp.selfUin);
                        RobotSummary robotSummary = myRobotsListRsp.summary;
                        if (robotSummary == null) {
                            robotSummary = new RobotSummary();
                        }
                        dVar.h(robotSummary);
                        ArrayList<MyRobotListInfo> arrayList = myRobotsListRsp.robots;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "response.robots");
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                        for (MyRobotListInfo it : arrayList) {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            arrayList2.add(new g(it));
                        }
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                        for (Object obj : arrayList2) {
                            int i17 = i16 + 1;
                            if (i16 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            g gVar = (g) obj;
                            gVar.d(i16);
                            arrayList3.add(gVar);
                            i16 = i17;
                        }
                        AdelieHomeCreateCenterViewModel.PageDataWrapper.this.h().setValue(new CreateCenterPageData(2, dVar, new a(myRobotsListRsp.robotActivity), arrayList3, true, false, true));
                    }
                }
            });
        }

        public final void k(final boolean needClearData) {
            if (this.isRequesting) {
                return;
            }
            this.isRequesting = true;
            AdelieUtils.f365929a.U(this.pagingCookie, this.dataVersion, false, new Function3<Integer, String, MyRobotsListRsp, Unit>() { // from class: com.tencent.robot.adelie.homepage.mine.AdelieHomeCreateCenterViewModel$PageDataWrapper$requestPageData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, MyRobotsListRsp myRobotsListRsp) {
                    invoke(num.intValue(), str, myRobotsListRsp);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String errMsg, @Nullable MyRobotsListRsp myRobotsListRsp) {
                    AtomicBoolean atomicBoolean;
                    AtomicBoolean atomicBoolean2;
                    List<g> emptyList;
                    int collectionSizeOrDefault;
                    List plus;
                    int collectionSizeOrDefault2;
                    AtomicBoolean atomicBoolean3;
                    AtomicBoolean atomicBoolean4;
                    AtomicBoolean atomicBoolean5;
                    List<g> emptyList2;
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    AdelieHomeCreateCenterViewModel.PageDataWrapper.this.isRequesting = false;
                    atomicBoolean = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.isFirstSection;
                    boolean z16 = atomicBoolean.get();
                    QLog.i("AdelieHomeCreateCenterViewModel", 1, "queryMyBots result = " + i3 + ", errMsg = " + errMsg);
                    if (i3 == 0) {
                        atomicBoolean2 = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.isFirstSection;
                        atomicBoolean2.getAndSet(false);
                        if (needClearData) {
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                        } else {
                            CreateCenterPageData value = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.h().getValue();
                            if (value != null && value.getType() == 2) {
                                emptyList = CollectionsKt__CollectionsKt.emptyList();
                            } else {
                                CreateCenterPageData value2 = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.h().getValue();
                                if (value2 == null || (emptyList = value2.b()) == null) {
                                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                                }
                            }
                        }
                        List<g> list = emptyList;
                        if (myRobotsListRsp == null) {
                            MutableLiveData<CreateCenterPageData> h16 = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.h();
                            CreateCenterPageData value3 = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.h().getValue();
                            d header = value3 != null ? value3.getHeader() : null;
                            atomicBoolean5 = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.isRefresh;
                            h16.setValue(new CreateCenterPageData(1, header, null, list, z16, true, atomicBoolean5.get()));
                            return;
                        }
                        AdelieHomeCreateCenterViewModel.PageDataWrapper pageDataWrapper = AdelieHomeCreateCenterViewModel.PageDataWrapper.this;
                        String str = myRobotsListRsp.dataVersion;
                        if (str == null) {
                            str = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str, "rsp.dataVersion ?: \"\"");
                        }
                        pageDataWrapper.dataVersion = str;
                        byte[] bArr = myRobotsListRsp.pagingCookie;
                        if (bArr == null) {
                            bArr = pageDataWrapper.pagingCookie;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(bArr, "rsp.pagingCookie ?: pagingCookie");
                        }
                        pageDataWrapper.pagingCookie = bArr;
                        d dVar = new d();
                        String str2 = myRobotsListRsp.selfNick;
                        Intrinsics.checkNotNullExpressionValue(str2, "rsp.selfNick");
                        dVar.e(str2);
                        String str3 = myRobotsListRsp.selfUid;
                        Intrinsics.checkNotNullExpressionValue(str3, "rsp.selfUid");
                        dVar.f(str3);
                        dVar.g(myRobotsListRsp.selfUin);
                        RobotSummary robotSummary = myRobotsListRsp.summary;
                        if (robotSummary == null) {
                            robotSummary = new RobotSummary();
                        } else {
                            Intrinsics.checkNotNullExpressionValue(robotSummary, "rsp.summary ?: RobotSummary()");
                        }
                        dVar.h(robotSummary);
                        ArrayList<MyRobotListInfo> arrayList = myRobotsListRsp.robots;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "response.robots");
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                        for (MyRobotListInfo it : arrayList) {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            arrayList2.add(new g(it));
                        }
                        plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList2);
                        List list2 = plus;
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                        int i16 = 0;
                        for (Object obj : list2) {
                            int i17 = i16 + 1;
                            if (i16 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            g gVar = (g) obj;
                            gVar.d(i16);
                            arrayList3.add(gVar);
                            i16 = i17;
                        }
                        MutableLiveData<CreateCenterPageData> h17 = pageDataWrapper.h();
                        a aVar = new a(myRobotsListRsp.robotActivity);
                        boolean z17 = !myRobotsListRsp.haveNextPage;
                        atomicBoolean3 = pageDataWrapper.isRefresh;
                        h17.setValue(new CreateCenterPageData(1, dVar, aVar, arrayList3, z16, z17, atomicBoolean3.get()));
                        atomicBoolean4 = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.isRefresh;
                        atomicBoolean4.getAndSet(false);
                        return;
                    }
                    QQToastUtil.showQQToastInUiThread(1, "\u5f53\u524d\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    CreateCenterPageData value4 = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.h().getValue();
                    if (value4 == null || (emptyList2 = value4.b()) == null) {
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    List<g> list3 = emptyList2;
                    int i18 = list3.isEmpty() ? -1 : 1;
                    MutableLiveData<CreateCenterPageData> h18 = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.h();
                    CreateCenterPageData value5 = AdelieHomeCreateCenterViewModel.PageDataWrapper.this.h().getValue();
                    h18.setValue(new CreateCenterPageData(i18, value5 != null ? value5.getHeader() : null, null, list3, z16, true, false));
                }
            });
        }

        public final void m() {
            if (this.isRequesting) {
                return;
            }
            this.isFirstSection.getAndSet(true);
            this.isRefresh.getAndSet(true);
            this.pagingCookie = new byte[0];
            this.dataVersion = "";
            k(true);
            QLog.i("AdelieHomeCreateCenterViewModel", 1, "setupRobotChangeListener");
        }

        @NotNull
        public String toString() {
            return "PageDataWrapper(pageData=" + this.pageData + ")";
        }
    }

    public AdelieHomeCreateCenterViewModel() {
        QLog.i("AdelieHomeCreateCenterViewModel", 1, "construct new " + this);
        O1();
        P1();
    }

    private final synchronized PageDataWrapper M1() {
        PageDataWrapper pageDataWrapper;
        List emptyList;
        if (this._pageDataWrapper == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this._pageDataWrapper = new PageDataWrapper(new MutableLiveData(new CreateCenterPageData(0, null, null, emptyList, true, false, true)));
        }
        pageDataWrapper = this._pageDataWrapper;
        Intrinsics.checkNotNull(pageDataWrapper);
        return pageDataWrapper;
    }

    private final void O1() {
        M1().j();
    }

    @NotNull
    public final LiveData<CreateCenterPageData> L1() {
        return M1().h();
    }

    public final void N1(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        PageDataWrapper pageDataWrapper = this._pageDataWrapper;
        if (pageDataWrapper != null) {
            pageDataWrapper.g(lifecycleOwner);
        }
        this._pageDataWrapper = null;
    }

    public final void P1() {
        PageDataWrapper.l(M1(), false, 1, null);
    }

    public final void Q1() {
        M1().m();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "AdelieHomeCreateCenterViewModel";
    }
}
