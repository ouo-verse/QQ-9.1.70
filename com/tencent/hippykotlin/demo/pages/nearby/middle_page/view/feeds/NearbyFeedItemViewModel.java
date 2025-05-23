package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeData;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.model.NearbySsoDoLikeRequestModel$Companion;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.UserSelfBaseInfo;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import defpackage.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import p35.ac;
import p35.n;
import s35.af;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyFeedItemViewModel extends BaseComposeCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedItemViewModel.class, "showAvatar", "getShowAvatar()Z", 0)};
    public final MutableState commentCount$delegate;
    public final n feed;
    public final boolean isOnlyText;
    public int likeNumber;
    public boolean meLiked;
    public float offsetY;
    public final Function2<n, e, Unit> onReportClick;
    public final Function2<n, Float, Unit> onReportExpose;
    public final Function1<n, Unit> onShowActionMenu;
    public final ReadWriteProperty showAvatar$delegate;
    public final FastClickUtils fastClickUtils = new FastClickUtils(200);
    public final FastClickUtils likeFastClickUtils = new FastClickUtils(1100);
    public NBPLikeData likeData = new NBPLikeData();

    /* JADX WARN: Multi-variable type inference failed */
    public NearbyFeedItemViewModel(n nVar, Function1<? super n, Unit> function1, Function2<? super n, ? super Float, Unit> function2, Function2<? super n, ? super e, Unit> function22) {
        MutableState mutableStateOf$default;
        this.feed = nVar;
        this.onShowActionMenu = function1;
        this.onReportExpose = function2;
        this.onReportClick = function22;
        ac acVar = nVar.E;
        this.meLiked = acVar != null && acVar.f425122h == 1;
        this.likeNumber = acVar != null ? acVar.f425120e : 0;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(nVar.G), null, 2, null);
        this.commentCount$delegate = mutableStateOf$default;
        this.showAvatar$delegate = c.a(Boolean.FALSE);
        this.isOnlyText = nVar.f425198m.isEmpty();
        NBPLikeData nBPLikeData = this.likeData;
        ac acVar2 = nVar.E;
        nBPLikeData.updateLiked(acVar2 != null && acVar2.f425122h == 1);
        NBPLikeData nBPLikeData2 = this.likeData;
        ac acVar3 = nVar.E;
        nBPLikeData2.updateNumber(acVar3 != null ? acVar3.f425120e : 0);
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(1373973421, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewModel.1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1373973421, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewModel.<anonymous> (NearbyFeedItemViewModel.kt:60)");
                }
                NearbyFeedItemViewKt.NearbyFeedItemView(NearbyFeedItemViewModel.this, composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }

    public final void onClickContent() {
        String str;
        if (this.fastClickUtils.isFastDoubleClick()) {
            return;
        }
        reportClick(0);
        String str2 = this.feed.f425193d;
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        String valueOf = String.valueOf(userDataManager.getUserSelfInfo().tid);
        String str3 = userDataManager.getUserSelfInfo().nickName;
        String str4 = userDataManager.getUserSelfInfo().avatarUrl;
        KLog kLog = KLog.INSTANCE;
        StringBuilder a16 = j.a("onItemViewClick: ", str2, ", ", valueOf, ", ");
        a16.append(str3);
        a16.append(", ");
        a16.append(str4);
        kLog.i("NearbyFeedItemViewModel", a16.toString());
        af afVar = this.feed.f425194e;
        if (afVar == null || (str = Long.valueOf(afVar.f433207e).toString()) == null) {
            str = "0";
        }
        NBPJumpUtil.jumpArticleFeedDetailPage$default(str, str2, new UserSelfBaseInfo(2, valueOf, str3, str4), 8, this.feed, null, Boolean.TRUE, 32);
    }

    public final void onClickLike() {
        if (this.likeFastClickUtils.isFastDoubleClick()) {
            return;
        }
        reportClick(1);
        boolean z16 = !this.meLiked;
        this.meLiked = z16;
        if (z16) {
            this.likeNumber++;
        } else {
            this.likeNumber--;
        }
        NBPLikeData.updateData$default(this.likeData, this.likeNumber, Boolean.valueOf(z16));
        NearbySsoDoLikeRequestModel$Companion.requestLikeStatusFeed$default(z16, this.feed.f425193d);
    }

    public final void onClickUser() {
        String str;
        Long longOrNull;
        if (this.fastClickUtils.isFastDoubleClick()) {
            return;
        }
        reportClick(0);
        af afVar = this.feed.f425194e;
        if (afVar == null || (str = StrangerUtilsKt.getUserId(afVar, 2)) == null) {
            str = "0";
        }
        String str2 = str;
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
        boolean isHostTid = userDataManager.isHostTid(Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L));
        KLog.INSTANCE.i("NearbyFeedItemViewModel", "onClickUser: " + isHostTid + ", " + str2);
        NBPJumpUtil.INSTANCE.jumpPersonaPage(2, str2, isHostTid, false, HomepageSource.POI_MIDDLE_PAGE, this.feed.f425193d);
    }

    public final void onLongPressContent() {
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onLongClickContent "), this.feed.f425193d, KLog.INSTANCE, "NearbyFeedItemViewModel");
        this.onShowActionMenu.invoke(this.feed);
        reportClick(0);
    }

    public final void reportClick(int i3) {
        this.onReportClick.invoke(this.feed, RoleCardKt$$ExternalSyntheticOutline0.m("nearby_click_area", i3));
    }
}
