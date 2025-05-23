package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.timer.TimerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.l;
import r25.b;
import r25.c;
import r25.e;
import v25.a;
import v25.p;

/* loaded from: classes31.dex */
public final class NearbyFDPUserFeedsCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedsCardViewModel.class, "nickName", "getNickName()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedsCardViewModel.class, PhotoCategorySummaryInfo.AVATAR_URL, "getAvatarUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedsCardViewModel.class, "avatarDressBorderUrl", "getAvatarDressBorderUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedsCardViewModel.class, "showGreetingBtn", "getShowGreetingBtn()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedsCardViewModel.class, "showOtherCityTipBar", "getShowOtherCityTipBar()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedsCardViewModel.class, "contentModel", "getContentModel()Lcom/tencent/hippykotlin/demo/pages/nearby/feed_detail/view_model/UserFeedsCard/NearbyFDPUserFeedTimelineItemViewModel;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedsCardViewModel.class, "buttonText", "getButtonText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPUserFeedsCardViewModel.class, "cardDidAppear", "getCardDidAppear()Z", 0)};
    public final ReadWriteProperty avatarDressBorderUrl$delegate;
    public final ReadWriteProperty avatarUrl$delegate;
    public final ReadWriteProperty buttonText$delegate;
    public final ReadWriteProperty cardDidAppear$delegate;
    public final List<Function0<Unit>> cardDidAppearLazyTask;
    public final ReadWriteProperty contentModel$delegate;
    public final a fromFeed;
    public final boolean fromFollowingTab;
    public final p fromPerson;
    public final l fromStatusFeed;
    public final String fromThemeId;
    public final boolean hasFollowedHost;
    public final QQNearbyModule.UserInfo hostUser;
    public int index;
    public final ReadWriteProperty nickName$delegate;
    public final Function1<l, Unit> onShowFeedActionSheet;
    public final ReadWriteProperty showGreetingBtn$delegate;
    public final ReadWriteProperty showOtherCityTipBar$delegate;
    public final Lazy tinyId$delegate;

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0139, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r4 != null ? r4.getTid() : null) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0154, code lost:
    
        if (r0.hasFollowedHost != false) goto L89;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NearbyFDPUserFeedsCardViewModel(p pVar, a aVar, l lVar, QQNearbyModule.UserInfo userInfo, String str, boolean z16, boolean z17, Function1<? super l, Unit> function1) {
        Lazy lazy;
        String str2;
        e eVar;
        e eVar2;
        String str3;
        e eVar3;
        e eVar4;
        List<b> list;
        e eVar5;
        e eVar6;
        Object obj;
        c cVar;
        String str4;
        this.fromPerson = pVar;
        this.fromFeed = aVar;
        this.fromStatusFeed = lVar;
        this.hostUser = userInfo;
        this.fromThemeId = str;
        this.fromFollowingTab = z16;
        this.hasFollowedHost = z17;
        this.onShowFeedActionSheet = function1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel$tinyId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                long j3;
                e eVar7;
                NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel = NearbyFDPUserFeedsCardViewModel.this;
                p pVar2 = nearbyFDPUserFeedsCardViewModel.fromPerson;
                if (pVar2 != null) {
                    j3 = pVar2.f440880d;
                } else {
                    a aVar2 = nearbyFDPUserFeedsCardViewModel.fromFeed;
                    if (aVar2 != null) {
                        j3 = aVar2.f440825e;
                    } else {
                        l lVar2 = nearbyFDPUserFeedsCardViewModel.fromStatusFeed;
                        j3 = (lVar2 == null || (eVar7 = lVar2.f418093e) == null) ? 0L : eVar7.f430610d;
                    }
                }
                return Long.valueOf(j3);
            }
        });
        this.tinyId$delegate = lazy;
        String str5 = "";
        this.nickName$delegate = c01.c.a("");
        this.avatarUrl$delegate = c01.c.a("");
        this.avatarDressBorderUrl$delegate = c01.c.a("");
        this.showGreetingBtn$delegate = c01.c.a(Boolean.TRUE);
        Boolean bool = Boolean.FALSE;
        this.showOtherCityTipBar$delegate = c01.c.a(bool);
        this.contentModel$delegate = c01.c.a(null);
        this.buttonText$delegate = c01.c.a("\u5173\u6ce8");
        this.cardDidAppear$delegate = c01.c.a(bool);
        this.cardDidAppearLazyTask = new ArrayList();
        if ((pVar == null || (str2 = pVar.f440882f) == null) && ((lVar == null || (eVar2 = lVar.f418093e) == null || (str2 = eVar2.J) == null) && (aVar == null || (eVar = aVar.R) == null || (str2 = eVar.J) == null))) {
            str2 = "";
        }
        setNickName(str2);
        if ((pVar == null || (str3 = pVar.f440883h) == null) && ((lVar == null || (eVar4 = lVar.f418093e) == null || (str3 = eVar4.L) == null) && (aVar == null || (eVar3 = aVar.R) == null || (str3 = eVar3.L) == null))) {
            str3 = "";
        }
        setAvatarUrl(str3);
        if ((pVar == null || (list = pVar.D) == null) && (lVar == null || (eVar6 = lVar.f418093e) == null || (list = eVar6.I) == null)) {
            list = (aVar == null || (eVar5 = aVar.R) == null) ? null : eVar5.I;
        }
        boolean z18 = true;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((b) obj).f430598d == 1001) {
                        break;
                    }
                }
            }
            b bVar = (b) obj;
            if (bVar != null && (cVar = bVar.f430600f) != null && (str4 = cVar.f430604h) != null) {
                str5 = str4;
            }
        }
        setAvatarDressBorderUrl(str5);
        long tinyId = getTinyId();
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        if (tinyId == userDataManager.getUserSelfInfo().getTid()) {
            setNickName(userDataManager.getUserSelfInfo().getNickName());
            setAvatarUrl(userDataManager.getUserSelfInfo().getAvatarUrl());
            setAvatarDressBorderUrl(userDataManager.getUserSelfInfo().getAvatarDressBorderUrl());
        }
        if (!this.fromFollowingTab) {
            String valueOf = String.valueOf(getTinyId());
            QQNearbyModule.UserInfo userInfo2 = this.hostUser;
        } else {
            String valueOf2 = String.valueOf(getTinyId());
            QQNearbyModule.UserInfo userInfo3 = this.hostUser;
            if (!Intrinsics.areEqual(valueOf2, userInfo3 != null ? userInfo3.getTid() : null)) {
            }
            z18 = false;
        }
        setShowGreetingBtn(z18);
        if (this.hasFollowedHost) {
            setButtonText("\u5df2\u5173\u6ce8");
        }
        if (this.fromFeed != null || this.fromStatusFeed != null) {
            setContentModel(new NearbyFDPUserFeedTimelineItemViewModel(this.fromFeed, this.fromStatusFeed, getTinyId(), this.fromThemeId, this.fromFollowingTab));
        }
        TimerKt.d(10, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel = NearbyFDPUserFeedsCardViewModel.this;
                nearbyFDPUserFeedsCardViewModel.getClass();
                k.b((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_HOMEPAGE_FOLLOW_STATUS_CHANGED", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel$registerHomepageFollowStatusChangeEvent$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar7) {
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar8 = eVar7;
                        if (eVar8 != null) {
                            String p16 = eVar8.p("accountId");
                            boolean f16 = eVar8.f("doFollow");
                            KLog.INSTANCE.i("NearbyFDPUserFeedsCardViewModel", "homepage changed followStatus id:" + p16 + ", doFollow: " + f16);
                            if (f16 && Intrinsics.areEqual(p16, String.valueOf(NearbyFDPUserFeedsCardViewModel.this.getTinyId()))) {
                                NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel2 = NearbyFDPUserFeedsCardViewModel.this;
                                if (!Intrinsics.areEqual((String) nearbyFDPUserFeedsCardViewModel2.buttonText$delegate.getValue(nearbyFDPUserFeedsCardViewModel2, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[6]), "\u5df2\u5173\u6ce8")) {
                                    NearbyFDPUserFeedsCardViewModel.this.setButtonText("\u5df2\u5173\u6ce8");
                                    final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel3 = NearbyFDPUserFeedsCardViewModel.this;
                                    TimerKt.d(1200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel$registerHomepageFollowStatusChangeEvent$1.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            NearbyFDPUserFeedsCardViewModel.this.setShowGreetingBtn(true);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                            }
                            if (!f16 && Intrinsics.areEqual(p16, String.valueOf(NearbyFDPUserFeedsCardViewModel.this.getTinyId()))) {
                                NearbyFDPUserFeedsCardViewModel.this.setButtonText("\u5173\u6ce8");
                                NearbyFDPUserFeedsCardViewModel.this.setShowGreetingBtn(false);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                return Unit.INSTANCE;
            }
        });
    }

    public final NearbyFDPUserFeedTimelineItemViewModel getContentModel() {
        return (NearbyFDPUserFeedTimelineItemViewModel) this.contentModel$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final String getNickName() {
        return (String) this.nickName$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final long getTinyId() {
        return ((Number) this.tinyId$delegate.getValue()).longValue();
    }

    public final void setAvatarDressBorderUrl(String str) {
        this.avatarDressBorderUrl$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final void setAvatarUrl(String str) {
        this.avatarUrl$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final void setButtonText(String str) {
        this.buttonText$delegate.setValue(this, $$delegatedProperties[6], str);
    }

    public final void setContentModel(NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel) {
        this.contentModel$delegate.setValue(this, $$delegatedProperties[5], nearbyFDPUserFeedTimelineItemViewModel);
    }

    public final void setNickName(String str) {
        this.nickName$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setShowGreetingBtn(boolean z16) {
        this.showGreetingBtn$delegate.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z16));
    }

    public /* synthetic */ NearbyFDPUserFeedsCardViewModel(p pVar, a aVar, l lVar, QQNearbyModule.UserInfo userInfo, String str, boolean z16, boolean z17, Function1 function1, int i3) {
        this((i3 & 1) != 0 ? null : pVar, (i3 & 2) != 0 ? null : aVar, (i3 & 4) != 0 ? null : lVar, (i3 & 8) != 0 ? null : userInfo, str, (i3 & 32) != 0 ? false : z16, (i3 & 64) != 0 ? false : z17, function1);
    }
}
