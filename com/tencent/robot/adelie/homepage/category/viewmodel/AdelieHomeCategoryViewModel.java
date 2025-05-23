package com.tencent.robot.adelie.homepage.category.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotGuideInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCard;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardType;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardsRsp;
import com.tencent.qqnt.kernel.nativeinterface.RobotTabInfo;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.adelie.homepage.category.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.robot.qqmc.RobotQQMC;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u000e\u0018\u0000 *2\u00020\u0001:\u0002+,B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017R\"\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00100\u00100\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0017\u0010'\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006-"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/viewmodel/AdelieHomeCategoryViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "U1", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTabInfo;", "categories", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/PageDataType;", "pageDataType", "N1", "categoryInfo", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/AdelieHomeCategoryViewModel$PageDataWrapper;", "R1", "", "getLogTag", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/c;", "O1", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/e;", "Q1", "W1", "T1", "S1", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "M1", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "_category", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "_pageDataMap", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTabInfo;", "P1", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotTabInfo;", "firstPageCategoryInfo", "<init>", "()V", "D", "a", "PageDataWrapper", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeCategoryViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final RobotTabInfo firstPageCategoryInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Category> _category;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, PageDataWrapper> _pageDataMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012<\u0010.\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00170\u0006\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00020$\u00a2\u0006\u0004\b=\u0010>J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\t\u0010\u0011\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"RM\u0010.\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00170\u0006\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00020$8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00108R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00108R\u0016\u0010<\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00108\u00a8\u0006?"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/viewmodel/AdelieHomeCategoryViewModel$PageDataWrapper;", "", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCard;", "originalList", "", "tabName", "tabId", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/a;", "l", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "g", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTabInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTabInfo;", "j", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotTabInfo;", "tabInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/e;", "b", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "recommondPageData", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "categories", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/PageDataType;", "pageDataType", "c", "Lkotlin/jvm/functions/Function2;", tl.h.F, "()Lkotlin/jvm/functions/Function2;", "fillCategoryHooker", "", "d", "[B", "pagingCookie", "e", "Ljava/lang/String;", "dataVersion", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadMoreing", "hasNextPage", "refreshing", "refreshDone", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RobotTabInfo;Landroidx/lifecycle/MutableLiveData;Lkotlin/jvm/functions/Function2;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class PageDataWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RobotTabInfo tabInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MutableLiveData<RecommondPageData> recommondPageData;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Function2<List<RobotTabInfo>, PageDataType, Unit> fillCategoryHooker;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private byte[] pagingCookie;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String dataVersion;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private AtomicBoolean loadMoreing;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private AtomicBoolean hasNextPage;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private AtomicBoolean refreshing;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private AtomicBoolean refreshDone;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes25.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f366053a;

            static {
                int[] iArr = new int[RobotRecommendCardType.values().length];
                try {
                    iArr[RobotRecommendCardType.KEMPTY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RobotRecommendCardType.KHOTROBOT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RobotRecommendCardType.KROLESUBJECTROBOT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RobotRecommendCardType.KTOOLROBOT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f366053a = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PageDataWrapper(@NotNull RobotTabInfo tabInfo, @NotNull MutableLiveData<RecommondPageData> recommondPageData, @NotNull Function2<? super List<RobotTabInfo>, ? super PageDataType, Unit> fillCategoryHooker) {
            Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
            Intrinsics.checkNotNullParameter(recommondPageData, "recommondPageData");
            Intrinsics.checkNotNullParameter(fillCategoryHooker, "fillCategoryHooker");
            this.tabInfo = tabInfo;
            this.recommondPageData = recommondPageData;
            this.fillCategoryHooker = fillCategoryHooker;
            this.pagingCookie = new byte[0];
            this.dataVersion = "";
            this.loadMoreing = new AtomicBoolean(false);
            this.hasNextPage = new AtomicBoolean(true);
            this.refreshing = new AtomicBoolean(false);
            this.refreshDone = new AtomicBoolean(false);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageDataWrapper)) {
                return false;
            }
            PageDataWrapper pageDataWrapper = (PageDataWrapper) other;
            if (Intrinsics.areEqual(this.tabInfo, pageDataWrapper.tabInfo) && Intrinsics.areEqual(this.recommondPageData, pageDataWrapper.recommondPageData) && Intrinsics.areEqual(this.fillCategoryHooker, pageDataWrapper.fillCategoryHooker)) {
                return true;
            }
            return false;
        }

        public final void g(@NotNull LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            this.recommondPageData.removeObservers(lifecycleOwner);
        }

        @NotNull
        public final Function2<List<RobotTabInfo>, PageDataType, Unit> h() {
            return this.fillCategoryHooker;
        }

        public int hashCode() {
            return (((this.tabInfo.hashCode() * 31) + this.recommondPageData.hashCode()) * 31) + this.fillCategoryHooker.hashCode();
        }

        @NotNull
        public final MutableLiveData<RecommondPageData> i() {
            return this.recommondPageData;
        }

        @NotNull
        /* renamed from: j, reason: from getter */
        public final RobotTabInfo getTabInfo() {
            return this.tabInfo;
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
        
            if (r1 == null) goto L6;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void k() {
            List emptyList;
            T t16;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            RecommondPageData value = this.recommondPageData.getValue();
            if (value != null) {
                List<com.tencent.robot.adelie.homepage.category.viewmodel.a> a16 = value.a();
                t16 = a16;
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            t16 = emptyList;
            objectRef.element = t16;
            if (this.refreshing.get()) {
                this.recommondPageData.setValue(new RecommondPageData(PageDataType.REFRESHING, (List) objectRef.element, false, false, null, 16, null));
                QLog.e("AdelieHomeCategoryViewModel", 1, "loadMorePageData refreshing tabInfo:" + this.tabInfo);
                return;
            }
            if (!this.refreshDone.get()) {
                this.recommondPageData.setValue(new RecommondPageData(PageDataType.REFRESHING, (List) objectRef.element, false, false, null, 16, null));
                QLog.e("AdelieHomeCategoryViewModel", 1, "loadMorePageData refresh not done tabInfo:" + this.tabInfo);
                return;
            }
            if (this.loadMoreing.get()) {
                this.recommondPageData.setValue(new RecommondPageData(PageDataType.LOADMOREING, (List) objectRef.element, false, false, null, 16, null));
                QLog.e("AdelieHomeCategoryViewModel", 1, "loadMorePageData requesting tabInfo:" + this.tabInfo);
                return;
            }
            if (!this.hasNextPage.get()) {
                this.recommondPageData.setValue(new RecommondPageData(PageDataType.NO_NEXT_PAGE, (List) objectRef.element, false, true, null, 16, null));
                QLog.e("AdelieHomeCategoryViewModel", 1, "loadMorePageData no next page tabInfo:" + this.tabInfo);
                return;
            }
            this.loadMoreing.set(true);
            QLog.i("AdelieHomeCategoryViewModel", 1, "loadMorePageData start " + this.tabInfo);
            AdelieUtils adelieUtils = AdelieUtils.f365929a;
            byte[] bArr = this.pagingCookie;
            String str = this.dataVersion;
            String str2 = this.tabInfo.tabId;
            Intrinsics.checkNotNullExpressionValue(str2, "tabInfo.tabId");
            adelieUtils.H(bArr, str, str2, true, false, new Function3<Boolean, String, RobotRecommendCardsRsp, Unit>() { // from class: com.tencent.robot.adelie.homepage.category.viewmodel.AdelieHomeCategoryViewModel$PageDataWrapper$loadMorePageData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str3, RobotRecommendCardsRsp robotRecommendCardsRsp) {
                    invoke(bool.booleanValue(), str3, robotRecommendCardsRsp);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r13v20, types: [java.util.List, T] */
                public final void invoke(boolean z16, @NotNull String errMsg, @NotNull RobotRecommendCardsRsp rsp) {
                    AtomicBoolean atomicBoolean;
                    AtomicBoolean atomicBoolean2;
                    List plus;
                    AtomicBoolean atomicBoolean3;
                    AtomicBoolean atomicBoolean4;
                    ?? emptyList2;
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    atomicBoolean = AdelieHomeCategoryViewModel.PageDataWrapper.this.loadMoreing;
                    atomicBoolean.getAndSet(false);
                    QLog.i("AdelieHomeCategoryViewModel", 1, "loadMorePageData end " + AdelieHomeCategoryViewModel.PageDataWrapper.this.getTabInfo() + " success:" + z16 + ", hasNextPage:" + rsp.haveNextPage);
                    if (z16) {
                        Function2<List<RobotTabInfo>, PageDataType, Unit> h16 = AdelieHomeCategoryViewModel.PageDataWrapper.this.h();
                        ArrayList<RobotTabInfo> arrayList = rsp.tabs;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.tabs");
                        h16.invoke(arrayList, PageDataType.LOADMORE_ERROR);
                        AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper = AdelieHomeCategoryViewModel.PageDataWrapper.this;
                        byte[] bArr2 = rsp.pagingCookie;
                        Intrinsics.checkNotNullExpressionValue(bArr2, "rsp.pagingCookie");
                        pageDataWrapper.pagingCookie = bArr2;
                        AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper2 = AdelieHomeCategoryViewModel.PageDataWrapper.this;
                        String str3 = rsp.dataVersion;
                        Intrinsics.checkNotNullExpressionValue(str3, "rsp.dataVersion");
                        pageDataWrapper2.dataVersion = str3;
                        boolean z17 = !rsp.haveNextPage;
                        atomicBoolean2 = AdelieHomeCategoryViewModel.PageDataWrapper.this.hasNextPage;
                        atomicBoolean2.set(!z17);
                        if (rsp.isRefresh) {
                            atomicBoolean3 = AdelieHomeCategoryViewModel.PageDataWrapper.this.refreshDone;
                            atomicBoolean3.getAndSet(true);
                            atomicBoolean4 = AdelieHomeCategoryViewModel.PageDataWrapper.this.refreshing;
                            atomicBoolean4.getAndSet(false);
                            Ref.ObjectRef<List<a>> objectRef2 = objectRef;
                            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                            objectRef2.element = emptyList2;
                        }
                        AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper3 = AdelieHomeCategoryViewModel.PageDataWrapper.this;
                        ArrayList<RobotRecommendCard> arrayList2 = rsp.cards;
                        Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.cards");
                        String str4 = AdelieHomeCategoryViewModel.PageDataWrapper.this.getTabInfo().name;
                        Intrinsics.checkNotNullExpressionValue(str4, "tabInfo.name");
                        String str5 = AdelieHomeCategoryViewModel.PageDataWrapper.this.getTabInfo().tabId;
                        Intrinsics.checkNotNullExpressionValue(str5, "tabInfo.tabId");
                        plus = CollectionsKt___CollectionsKt.plus((Collection) objectRef.element, (Iterable) pageDataWrapper3.l(arrayList2, str4, str5));
                        AdelieHomeCategoryViewModel.PageDataWrapper.this.i().setValue(new RecommondPageData(PageDataType.BACKEND, plus, false, z17, null, 16, null));
                        QLog.i("AdelieHomeCategoryViewModel", 1, "loadMorePageData recommondPageData setValue " + AdelieHomeCategoryViewModel.PageDataWrapper.this.i().getValue());
                        return;
                    }
                    AdelieHomeCategoryViewModel.PageDataWrapper.this.i().setValue(new RecommondPageData(PageDataType.LOADMORE_ERROR, objectRef.element, false, false, null, 16, null));
                }
            });
        }

        @NotNull
        public final List<com.tencent.robot.adelie.homepage.category.viewmodel.a> l(@NotNull List<RobotRecommendCard> originalList, @NotNull String tabName, @NotNull String tabId) {
            int i3;
            boolean z16;
            Intrinsics.checkNotNullParameter(originalList, "originalList");
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            Intrinsics.checkNotNullParameter(tabId, "tabId");
            ArrayList arrayList = new ArrayList();
            for (RobotRecommendCard robotRecommendCard : originalList) {
                RobotRecommendCardType robotRecommendCardType = robotRecommendCard.cardType;
                if (robotRecommendCardType == null) {
                    i3 = -1;
                } else {
                    i3 = a.f366053a[robotRecommendCardType.ordinal()];
                }
                boolean z17 = true;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                QLog.e("AdelieHomeCategoryViewModel", 1, "unknown type");
                            } else {
                                ArrayList<RobotRecommendCardInfo> arrayList2 = robotRecommendCard.cards;
                                if (arrayList2 != null && !arrayList2.isEmpty()) {
                                    z17 = false;
                                }
                                if (!z17) {
                                    RobotRecommendCardInfo robotRecommendCardInfo = robotRecommendCard.cards.get(0);
                                    Intrinsics.checkNotNullExpressionValue(robotRecommendCardInfo, "robotRecommendCard.cards[0]");
                                    arrayList.add(new ToolDelegateData(robotRecommendCardInfo));
                                }
                            }
                        } else {
                            ArrayList<RobotRecommendCardInfo> arrayList3 = robotRecommendCard.cards;
                            if (arrayList3 != null && !arrayList3.isEmpty()) {
                                z17 = false;
                            }
                            if (!z17) {
                                RobotRecommendCardInfo robotRecommendCardInfo2 = robotRecommendCard.cards.get(0);
                                Intrinsics.checkNotNullExpressionValue(robotRecommendCardInfo2, "robotRecommendCard.cards[0]");
                                arrayList.add(new RoleDelegateData(robotRecommendCardInfo2));
                            }
                        }
                    } else {
                        ArrayList<RobotRecommendCardInfo> arrayList4 = robotRecommendCard.cards;
                        Intrinsics.checkNotNullExpressionValue(arrayList4, "robotRecommendCard.cards");
                        arrayList.add(new HotDelegateData(arrayList4));
                    }
                } else {
                    ArrayList<RobotRecommendCardInfo> arrayList5 = robotRecommendCard.cards;
                    Intrinsics.checkNotNullExpressionValue(arrayList5, "robotRecommendCard.cards");
                    for (RobotRecommendCardInfo robotRecommendCardInfo3 : arrayList5) {
                        if (robotRecommendCardInfo3 != null) {
                            ArrayList<RobotCoreInfo> arrayList6 = robotRecommendCardInfo3.robots;
                            if (arrayList6 != null && !arrayList6.isEmpty()) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (!z16) {
                                ArrayList<RobotCoreInfo> arrayList7 = robotRecommendCardInfo3.robots;
                                Intrinsics.checkNotNullExpressionValue(arrayList7, "cardInfo.robots");
                                for (RobotCoreInfo robotCoreInfo : arrayList7) {
                                    if (robotCoreInfo != null) {
                                        arrayList.add(new RegularDelegateData(robotCoreInfo, tabName, tabId));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        }

        public final void m() {
            List<com.tencent.robot.adelie.homepage.category.viewmodel.a> emptyList;
            RecommondPageData value = this.recommondPageData.getValue();
            if (value == null || (emptyList = value.a()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            final List<com.tencent.robot.adelie.homepage.category.viewmodel.a> list = emptyList;
            if (this.refreshing.get()) {
                this.recommondPageData.setValue(new RecommondPageData(PageDataType.REFRESHING, list, true, false, null, 16, null));
                return;
            }
            this.refreshing.getAndSet(true);
            this.dataVersion = "";
            this.pagingCookie = new byte[0];
            QLog.i("AdelieHomeCategoryViewModel", 1, "refreshPageData start " + this.tabInfo);
            AdelieUtils adelieUtils = AdelieUtils.f365929a;
            byte[] bArr = this.pagingCookie;
            String str = this.dataVersion;
            String str2 = this.tabInfo.tabId;
            Intrinsics.checkNotNullExpressionValue(str2, "tabInfo.tabId");
            adelieUtils.H(bArr, str, str2, true, false, new Function3<Boolean, String, RobotRecommendCardsRsp, Unit>() { // from class: com.tencent.robot.adelie.homepage.category.viewmodel.AdelieHomeCategoryViewModel$PageDataWrapper$refreshPageData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str3, RobotRecommendCardsRsp robotRecommendCardsRsp) {
                    invoke(bool.booleanValue(), str3, robotRecommendCardsRsp);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull String errMsg, @NotNull RobotRecommendCardsRsp rsp) {
                    AtomicBoolean atomicBoolean;
                    AtomicBoolean atomicBoolean2;
                    AtomicBoolean atomicBoolean3;
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    QLog.i("AdelieHomeCategoryViewModel", 1, "refreshPageData end " + AdelieHomeCategoryViewModel.PageDataWrapper.this.getTabInfo() + " success:" + z16 + ", hasNextPage:" + rsp.haveNextPage);
                    atomicBoolean = AdelieHomeCategoryViewModel.PageDataWrapper.this.refreshing;
                    atomicBoolean.getAndSet(false);
                    if (z16) {
                        Function2<List<RobotTabInfo>, PageDataType, Unit> h16 = AdelieHomeCategoryViewModel.PageDataWrapper.this.h();
                        ArrayList<RobotTabInfo> arrayList = rsp.tabs;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.tabs");
                        h16.invoke(arrayList, PageDataType.CACHE);
                        AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper = AdelieHomeCategoryViewModel.PageDataWrapper.this;
                        byte[] bArr2 = rsp.pagingCookie;
                        Intrinsics.checkNotNullExpressionValue(bArr2, "rsp.pagingCookie");
                        pageDataWrapper.pagingCookie = bArr2;
                        AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper2 = AdelieHomeCategoryViewModel.PageDataWrapper.this;
                        String str3 = rsp.dataVersion;
                        Intrinsics.checkNotNullExpressionValue(str3, "rsp.dataVersion");
                        pageDataWrapper2.dataVersion = str3;
                        boolean z17 = !rsp.haveNextPage;
                        ArrayList<RobotGuideInfo> arrayList2 = rsp.guides;
                        atomicBoolean2 = AdelieHomeCategoryViewModel.PageDataWrapper.this.hasNextPage;
                        atomicBoolean2.set(!z17);
                        AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper3 = AdelieHomeCategoryViewModel.PageDataWrapper.this;
                        ArrayList<RobotRecommendCard> arrayList3 = rsp.cards;
                        Intrinsics.checkNotNullExpressionValue(arrayList3, "rsp.cards");
                        String str4 = AdelieHomeCategoryViewModel.PageDataWrapper.this.getTabInfo().name;
                        Intrinsics.checkNotNullExpressionValue(str4, "tabInfo.name");
                        String str5 = AdelieHomeCategoryViewModel.PageDataWrapper.this.getTabInfo().tabId;
                        Intrinsics.checkNotNullExpressionValue(str5, "tabInfo.tabId");
                        List<a> l3 = pageDataWrapper3.l(arrayList3, str4, str5);
                        if (!arrayList2.isEmpty() && !RobotQQMC.INSTANCE.disableHomePageRobotGuideView()) {
                            AdelieHomeCategoryViewModel.PageDataWrapper.this.i().setValue(new RecommondPageData(PageDataType.BACKEND, l3, true, z17, arrayList2.get(0)));
                        } else {
                            AdelieHomeCategoryViewModel.PageDataWrapper.this.i().setValue(new RecommondPageData(PageDataType.BACKEND, l3, true, z17, null));
                        }
                        QLog.i("AdelieHomeCategoryViewModel", 1, "refreshPageData recommondPageData setValue " + AdelieHomeCategoryViewModel.PageDataWrapper.this.i().getValue());
                        atomicBoolean3 = AdelieHomeCategoryViewModel.PageDataWrapper.this.refreshDone;
                        atomicBoolean3.getAndSet(true);
                        return;
                    }
                    Function2<List<RobotTabInfo>, PageDataType, Unit> h17 = AdelieHomeCategoryViewModel.PageDataWrapper.this.h();
                    ArrayList<RobotTabInfo> arrayList4 = rsp.tabs;
                    Intrinsics.checkNotNullExpressionValue(arrayList4, "rsp.tabs");
                    PageDataType pageDataType = PageDataType.REFRESH_ERROR;
                    h17.invoke(arrayList4, pageDataType);
                    AdelieHomeCategoryViewModel.PageDataWrapper.this.i().setValue(new RecommondPageData(pageDataType, list, true, false, null, 16, null));
                }
            });
        }

        public final void n() {
            QLog.i("AdelieHomeCategoryViewModel", 1, "requestLocalCachePageData start " + this.tabInfo + " at " + System.currentTimeMillis());
            AdelieUtils adelieUtils = AdelieUtils.f365929a;
            byte[] bArr = this.pagingCookie;
            String str = this.dataVersion;
            String str2 = this.tabInfo.tabId;
            Intrinsics.checkNotNullExpressionValue(str2, "tabInfo.tabId");
            adelieUtils.H(bArr, str, str2, true, true, new Function3<Boolean, String, RobotRecommendCardsRsp, Unit>() { // from class: com.tencent.robot.adelie.homepage.category.viewmodel.AdelieHomeCategoryViewModel$PageDataWrapper$requestLocalCachePageData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str3, RobotRecommendCardsRsp robotRecommendCardsRsp) {
                    invoke(bool.booleanValue(), str3, robotRecommendCardsRsp);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull String errMsg, @NotNull RobotRecommendCardsRsp rsp) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    QLog.i("AdelieHomeCategoryViewModel", 1, "requestLocalCachePageData end " + AdelieHomeCategoryViewModel.PageDataWrapper.this.getTabInfo() + " success:" + z16 + " at " + System.currentTimeMillis());
                    if (z16) {
                        Function2<List<RobotTabInfo>, PageDataType, Unit> h16 = AdelieHomeCategoryViewModel.PageDataWrapper.this.h();
                        ArrayList<RobotTabInfo> arrayList = rsp.tabs;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.tabs");
                        PageDataType pageDataType = PageDataType.CACHE;
                        h16.invoke(arrayList, pageDataType);
                        AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper = AdelieHomeCategoryViewModel.PageDataWrapper.this;
                        ArrayList<RobotRecommendCard> arrayList2 = rsp.cards;
                        Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.cards");
                        String str3 = AdelieHomeCategoryViewModel.PageDataWrapper.this.getTabInfo().name;
                        Intrinsics.checkNotNullExpressionValue(str3, "tabInfo.name");
                        String str4 = AdelieHomeCategoryViewModel.PageDataWrapper.this.getTabInfo().tabId;
                        Intrinsics.checkNotNullExpressionValue(str4, "tabInfo.tabId");
                        AdelieHomeCategoryViewModel.PageDataWrapper.this.i().setValue(new RecommondPageData(pageDataType, pageDataWrapper.l(arrayList2, str3, str4), true, false, null, 16, null));
                        QLog.i("AdelieHomeCategoryViewModel", 1, "requestLocalCachePageData setValue " + AdelieHomeCategoryViewModel.PageDataWrapper.this.i().getValue());
                    }
                    AdelieHomeCategoryViewModel.PageDataWrapper.this.m();
                }
            });
        }

        @NotNull
        public String toString() {
            return "PageDataWrapper(tabInfo=" + this.tabInfo + ", recommondPageData=" + this.recommondPageData + ", fillCategoryHooker=" + this.fillCategoryHooker + ")";
        }
    }

    public AdelieHomeCategoryViewModel() {
        List listOf;
        CategoryType categoryType = CategoryType.LOADING;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new RobotTabInfo());
        this._category = new MutableLiveData<>(new Category(categoryType, listOf));
        this._pageDataMap = new LinkedHashMap();
        RobotTabInfo robotTabInfo = new RobotTabInfo();
        robotTabInfo.tabId = "0";
        robotTabInfo.name = "\u63a8\u8350";
        this.firstPageCategoryInfo = robotTabInfo;
        QLog.i("AdelieHomeCategoryViewModel", 1, "construct new " + this);
        U1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1(List<RobotTabInfo> categories, PageDataType pageDataType) {
        CategoryType categoryType;
        CategoryType categoryType2 = null;
        if (categories.isEmpty()) {
            if (pageDataType == PageDataType.REFRESH_ERROR) {
                Category value = this._category.getValue();
                if (value != null) {
                    categoryType2 = value.getType();
                }
                if (categoryType2 == CategoryType.LOADING) {
                    QLog.i("AdelieHomeCategoryViewModel", 1, "fillCategoryInfoIfNeed categories:" + categories);
                    this._category.postValue(new Category(CategoryType.ERROR, categories));
                    return;
                }
                return;
            }
            return;
        }
        Category value2 = this._category.getValue();
        if (value2 != null) {
            categoryType = value2.getType();
        } else {
            categoryType = null;
        }
        if (categoryType != CategoryType.LOADING) {
            Category value3 = this._category.getValue();
            if (value3 != null) {
                categoryType2 = value3.getType();
            }
            if (categoryType2 != CategoryType.ERROR) {
                return;
            }
        }
        QLog.i("AdelieHomeCategoryViewModel", 1, "fillCategoryInfoIfNeed categories:" + categories);
        this._category.postValue(new Category(CategoryType.BACKEND, categories));
    }

    private final synchronized PageDataWrapper R1(RobotTabInfo categoryInfo) {
        PageDataWrapper pageDataWrapper;
        Map<String, PageDataWrapper> map = this._pageDataMap;
        String str = categoryInfo.tabId;
        Intrinsics.checkNotNullExpressionValue(str, "categoryInfo.tabId");
        pageDataWrapper = map.get(str);
        if (pageDataWrapper == null) {
            pageDataWrapper = new PageDataWrapper(categoryInfo, new MutableLiveData(RecommondPageData.INSTANCE.a()), new AdelieHomeCategoryViewModel$getPageDataWrapper$1$1(this));
            map.put(str, pageDataWrapper);
        }
        return pageDataWrapper;
    }

    private final void U1() {
        QLog.i("AdelieHomeCategoryViewModel", 1, "requestCategory start");
        W1(this.firstPageCategoryInfo);
    }

    public final void M1(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this._category.removeObservers(lifecycleOwner);
        Iterator<T> it = this._pageDataMap.values().iterator();
        while (it.hasNext()) {
            ((PageDataWrapper) it.next()).g(lifecycleOwner);
        }
    }

    @NotNull
    public final LiveData<Category> O1() {
        return this._category;
    }

    @NotNull
    /* renamed from: P1, reason: from getter */
    public final RobotTabInfo getFirstPageCategoryInfo() {
        return this.firstPageCategoryInfo;
    }

    @NotNull
    public final LiveData<RecommondPageData> Q1(@NotNull RobotTabInfo categoryInfo) {
        Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
        return R1(categoryInfo).i();
    }

    public final void S1(@NotNull RobotTabInfo categoryInfo) {
        Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
        R1(categoryInfo).k();
    }

    public final void T1(@NotNull RobotTabInfo categoryInfo) {
        Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
        R1(categoryInfo).m();
    }

    public final void W1(@NotNull RobotTabInfo categoryInfo) {
        Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
        R1(categoryInfo).n();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "AdelieHomeCategoryViewModel";
    }
}
