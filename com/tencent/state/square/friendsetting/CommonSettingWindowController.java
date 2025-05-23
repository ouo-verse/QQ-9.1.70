package com.tencent.state.square.friendsetting;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.square.databinding.VasSquareItemAvatarBinding;
import com.tencent.state.square.databinding.VasSquareQzoneFeedBubbleBinding;
import com.tencent.state.square.friendsetting.SquareSettingWindow;
import com.tencent.state.square.holder.AvatarViewHolder;
import com.tencent.state.square.holder.TroopViewHolder;
import com.tencent.state.square.layout.IDynamicLayoutComponent;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.AvatarOnlineStatusSimpleBubble;
import com.tencent.state.view.BubbleStickersBanner;
import com.tencent.state.view.SquareImageView;
import is4.b;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import wx4.d;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 B2\u00020\u0001:\u0001BB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001b\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\t\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010#J\u001b\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\t\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010#J\u001b\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\t\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010#J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\t\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010#J\u001b\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\t\u001a\u00020(H\u0002\u00a2\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\u0015J\u001b\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\t\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010#J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J5\u0010.\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00032#\u0010/\u001a\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0002J\u0018\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\rH\u0002J\u0018\u00106\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00062\u0006\u00107\u001a\u00020\rH\u0002J\u0018\u00108\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\rH\u0002J \u00109\u001a\u00020\u00072\u000e\u0010:\u001a\n\u0012\u0002\b\u00030;j\u0002`<2\u0006\u0010=\u001a\u00020>H\u0002J6\u0010?\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010:\u001a\n\u0012\u0002\b\u00030;j\u0002`<2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\rJ\u0010\u0010A\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006C"}, d2 = {"Lcom/tencent/state/square/friendsetting/CommonSettingWindowController;", "", GetAdInfoRequest.SOURCE_FROM, "", "gotoInteraction", "Lkotlin/Function1;", "Lcom/tencent/state/map/MapItem;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "data", "hasClick", "", "itemType", "", "reporter", "Lcom/tencent/state/square/IReporter;", "service", "Lcom/tencent/state/square/friendsetting/SettingService;", "squareView", "Lcom/tencent/state/square/SquareView;", "tipsController", "Lcom/tencent/state/square/friendsetting/SettingTipsController;", "window", "Lcom/tencent/state/square/friendsetting/SquareSettingWindow;", "closeToMe", "context", "Landroid/content/Context;", "dismiss", "doCloseToMeAndLocate", "uin", "doRealCloseToMe", "fixedOrCancel", "getFriendAvatarItemConfigArray", "", "Lcom/tencent/state/square/friendsetting/SquareSettingWindow$FloatItemConfig;", "(Lcom/tencent/state/map/MapItem;)[Lcom/tencent/state/square/friendsetting/SquareSettingWindow$FloatItemConfig;", "getHostItemConfigArray", "getItemConfigArray", "getMayKnowUserEntranceItemConfigArray", "getStrangerAvatarItemConfigArray", "Lcom/tencent/state/square/data/SquareAvatarItem;", "(Lcom/tencent/state/square/data/SquareAvatarItem;)[Lcom/tencent/state/square/friendsetting/SquareSettingWindow$FloatItemConfig;", "getTipsController", "getTroopItemConfigArray", "hide", "initWindow", "locateToNewLocation", "endCallback", "Lkotlin/ParameterName;", "name", "success", "report", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "flag", "reportFriend", "pressType", "reportTroop", "setBubbleAlpha", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", c.f123400v, "", "show", "type", "showOrBaned", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CommonSettingWindowController {
    private static final String TAG = "FriendSettingController";
    private MapItem data;
    private final Function1<MapItem, Unit> gotoInteraction;
    private boolean hasClick;
    private int itemType;
    private final IReporter reporter;
    private final SettingService service;
    private final String sourceFrom;
    private SquareView squareView;
    private final SettingTipsController tipsController;
    private SquareSettingWindow window;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonSettingWindowController(String sourceFrom, Function1<? super MapItem, Unit> gotoInteraction) {
        Intrinsics.checkNotNullParameter(sourceFrom, "sourceFrom");
        Intrinsics.checkNotNullParameter(gotoInteraction, "gotoInteraction");
        this.sourceFrom = sourceFrom;
        this.gotoInteraction = gotoInteraction;
        this.itemType = 1;
        this.service = new SettingService();
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        this.tipsController = new SettingTipsController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeToMe(Context context) {
        final String uin;
        MapItem mapItem = this.data;
        if (mapItem == null || (uin = mapItem.getUin()) == null) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "closeToMe " + uin);
        if (this.itemType == 1) {
            this.tipsController.showCloseToMeTipsIfNeed(context, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$closeToMe$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    CommonSettingWindowController.this.doCloseToMeAndLocate(uin);
                }
            });
        } else {
            this.tipsController.showTroopCloseToMeTipsFirst(context, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$closeToMe$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    CommonSettingWindowController.this.doCloseToMeAndLocate(uin);
                }
            });
        }
        MapItem mapItem2 = this.data;
        if (mapItem2 != null) {
            report(mapItem2, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doCloseToMeAndLocate(final String uin) {
        locateToNewLocation(uin, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$doCloseToMeAndLocate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                CommonSettingWindowController.this.doRealCloseToMe(uin);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doRealCloseToMe(final String uin) {
        Long longOrNull;
        final SquareView squareView = this.squareView;
        if (squareView != null) {
            ISquareViewUpdater updater = squareView.getUpdater();
            PlaceInfo doAvatarCloseToMe = updater != null ? updater.doAvatarCloseToMe(uin) : null;
            if (doAvatarCloseToMe == null) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "closeToMe local failed " + uin, null, 4, null);
                ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
                Context context = squareView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "squareView.context");
                ICommonUtils.DefaultImpls.showToast$default(commonUtils, context, R.string.xcd, 0, 4, (Object) null);
                return;
            }
            if (this.itemType == 1) {
                ISquareViewUpdater updater2 = squareView.getUpdater();
                if (updater2 != null) {
                    updater2.setAvatarFixed(uin, true);
                }
                ICommonUtils commonUtils2 = SquareBase.INSTANCE.getConfig().getCommonUtils();
                Context context2 = squareView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "squareView.context");
                commonUtils2.showToast(context2, R.string.xd5, 2);
            } else {
                ICommonUtils commonUtils3 = SquareBase.INSTANCE.getConfig().getCommonUtils();
                Context context3 = squareView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "squareView.context");
                commonUtils3.showToast(context3, R.string.xd_, 2);
            }
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                SettingService settingService = this.service;
                b bVar = new b();
                bVar.f408677a = longValue;
                bVar.f408678b = doAvatarCloseToMe.getArea();
                bVar.f408679c = doAvatarCloseToMe.getRank();
                Unit unit = Unit.INSTANCE;
                settingService.setFixed(bVar, this.itemType == 4, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$doRealCloseToMe$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                        invoke(bool.booleanValue(), num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, int i3) {
                        int i16;
                        SettingService settingService2;
                        ISquareViewUpdater updater3;
                        i16 = CommonSettingWindowController.this.itemType;
                        if (i16 == 1) {
                            settingService2 = CommonSettingWindowController.this.service;
                            settingService2.report(SquareReportConst.CustomEventId.EVENT_ID_FIXED_FRIEND, uin, 2, d.INSTANCE.b(z16), i3, SquareReportConst.Param.EM_STATE_SQUARE);
                            if (!z16 && (updater3 = squareView.getUpdater()) != null) {
                                updater3.setAvatarFixed(uin, z16);
                            }
                        }
                        SquareBaseKt.getSquareLog().i("FriendSettingController", "closeToMe request " + uin + " result " + z16);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0.getUin());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void fixedOrCancel(final Context context) {
        Long longOrNull;
        Long longOrNull2;
        ISquareViewUpdater updater;
        ISquareViewUpdater updater2;
        MapItem mapItem = this.data;
        if (!(mapItem instanceof SquareAvatarItem)) {
            mapItem = null;
        }
        final SquareAvatarItem squareAvatarItem = (SquareAvatarItem) mapItem;
        if (squareAvatarItem == null || longOrNull == null) {
            return;
        }
        final long longValue = longOrNull.longValue();
        if (squareAvatarItem.getExtra().getIsFixed()) {
            SquareBaseKt.getSquareLog().i(TAG, "cancel fixed " + longValue);
            SquareView squareView = this.squareView;
            if (squareView != null && (updater2 = squareView.getUpdater()) != null) {
                updater2.setAvatarFixed(squareAvatarItem.getUin(), false);
            }
            SquareBase.INSTANCE.getConfig().getCommonUtils().showToast(context, R.string.xcb, 2);
            this.service.cancelFixed(longValue, false, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$fixedOrCancel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                    invoke(bool.booleanValue(), num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x0046, code lost:
                
                    r10 = r8.this$0.squareView;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(boolean z16, int i3) {
                    SettingService settingService;
                    SquareView squareView2;
                    ISquareViewUpdater updater3;
                    SquareBaseKt.getSquareLog().i("FriendSettingController", "cancel fixed " + longValue + " result " + z16);
                    settingService = CommonSettingWindowController.this.service;
                    settingService.report(SquareReportConst.CustomEventId.EVENT_ID_FIXED_FRIEND, squareAvatarItem.getUin(), 0, d.INSTANCE.b(z16), i3, SquareReportConst.Param.EM_STATE_SQUARE);
                    if (z16 || squareView2 == null || (updater3 = squareView2.getUpdater()) == null) {
                        return;
                    }
                    updater3.setAvatarFixed(squareAvatarItem.getUin(), !z16);
                }
            });
            reportFriend(squareAvatarItem, 5);
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "fixed " + longValue);
        this.tipsController.showFixedTipsIfNeed(context, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$fixedOrCancel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SquareBase.INSTANCE.getConfig().getCommonUtils().showToast(context, R.string.xcr, 2);
            }
        });
        SquareView squareView2 = this.squareView;
        if (squareView2 != null && (updater = squareView2.getUpdater()) != null) {
            updater.setAvatarFixed(squareAvatarItem.getUin(), true);
        }
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(squareAvatarItem.getUin());
        if (longOrNull2 != null) {
            long longValue2 = longOrNull2.longValue();
            SettingService settingService = this.service;
            b bVar = new b();
            bVar.f408678b = squareAvatarItem.getLocation().getArea();
            bVar.f408679c = squareAvatarItem.getLocation().getRank();
            bVar.f408677a = longValue2;
            Unit unit = Unit.INSTANCE;
            settingService.setFixed(bVar, false, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$fixedOrCancel$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                    invoke(bool.booleanValue(), num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x0046, code lost:
                
                    r9 = r8.this$0.squareView;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(boolean z16, int i3) {
                    SettingService settingService2;
                    SquareView squareView3;
                    ISquareViewUpdater updater3;
                    SquareBaseKt.getSquareLog().i("FriendSettingController", "fixed request " + longValue + " result " + z16);
                    settingService2 = CommonSettingWindowController.this.service;
                    settingService2.report(SquareReportConst.CustomEventId.EVENT_ID_FIXED_FRIEND, squareAvatarItem.getUin(), 1, d.INSTANCE.b(z16), i3, SquareReportConst.Param.EM_STATE_SQUARE);
                    if (z16 || squareView3 == null || (updater3 = squareView3.getUpdater()) == null) {
                        return;
                    }
                    updater3.setAvatarFixed(squareAvatarItem.getUin(), false);
                }
            });
            reportFriend(squareAvatarItem, 3);
        }
    }

    private final SquareSettingWindow.FloatItemConfig[] getHostItemConfigArray(MapItem data) {
        if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
            return new SquareSettingWindow.FloatItemConfig[0];
        }
        return new SquareSettingWindow.FloatItemConfig[]{new SquareSettingWindow.FloatItemConfig(R.drawable.i_c, new SquareSettingWindow.FloatItemTextStyle("\u8bbe\u7f6e\u62cd\u4e00\u62cd", 0.0f, 0, 6, null), R.drawable.gsp, 6)};
    }

    private final SquareSettingWindow.FloatItemConfig[] getItemConfigArray(MapItem data) {
        SquareAvatarExtra extra;
        int i3 = this.itemType;
        if (i3 != 1) {
            if (i3 == 4) {
                return getTroopItemConfigArray(data);
            }
            if (i3 != 7) {
                return new SquareSettingWindow.FloatItemConfig[0];
            }
            return getMayKnowUserEntranceItemConfigArray(data);
        }
        boolean z16 = data instanceof SquareAvatarItem;
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (!z16 ? null : data);
        if (((squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null) ? null : extra.getRelationType()) == RelationType.STRANGER) {
            return getStrangerAvatarItemConfigArray((SquareAvatarItem) data);
        }
        SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) (z16 ? data : null);
        if (squareAvatarItem2 != null && squareAvatarItem2.isMe()) {
            return getHostItemConfigArray(data);
        }
        return getFriendAvatarItemConfigArray(data);
    }

    private final SquareSettingWindow.FloatItemConfig[] getStrangerAvatarItemConfigArray(SquareAvatarItem data) {
        String str;
        String str2;
        if (!SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
            return getFriendAvatarItemConfigArray(data);
        }
        SquareSettingWindow.FloatItemConfig[] floatItemConfigArr = new SquareSettingWindow.FloatItemConfig[3];
        if (data.getLocation().getRank() == 1) {
            str = "\u5df2\u8d34\u8fd1";
        } else {
            str = "\u8d34\u8fd1\u6211";
        }
        floatItemConfigArr[0] = new SquareSettingWindow.FloatItemConfig(R.drawable.iaz, new SquareSettingWindow.FloatItemTextStyle(str, 0.0f, 0, 6, null), R.drawable.gsp, 1);
        int i3 = data.getExtra().getIsFixed() ? R.drawable.iay : R.drawable.f159821ib0;
        if (data.getExtra().getIsFixed()) {
            str2 = "\u53d6\u6d88\u56fa\u5b9a";
        } else {
            str2 = "\u56fa\u5b9a";
        }
        floatItemConfigArr[1] = new SquareSettingWindow.FloatItemConfig(i3, new SquareSettingWindow.FloatItemTextStyle(str2, 0.0f, 0, 6, null), R.drawable.gsp, 2);
        floatItemConfigArr[2] = new SquareSettingWindow.FloatItemConfig(R.drawable.f159824ib3, new SquareSettingWindow.FloatItemTextStyle("\u79fb\u9664", 0.0f, 0, 6, null), R.drawable.gsp, 3);
        return floatItemConfigArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hide(final Context context) {
        Long longOrNull;
        Long longOrNull2;
        ISquareViewUpdater updater;
        final MapItem mapItem = this.data;
        if (mapItem != null) {
            int i3 = this.itemType;
            if (i3 == 1) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(mapItem.getUin());
                if (longOrNull == null) {
                    return;
                }
                final long longValue = longOrNull.longValue();
                this.tipsController.showHideTipsIfNeed(context, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$hide$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SquareView squareView;
                        SettingService settingService;
                        ISquareViewUpdater updater2;
                        SquareBase.INSTANCE.getConfig().getCommonUtils().showToast(context, R.string.xcu, 2);
                        squareView = CommonSettingWindowController.this.squareView;
                        if (squareView != null && (updater2 = squareView.getUpdater()) != null) {
                            updater2.hide(mapItem.getUin());
                        }
                        settingService = CommonSettingWindowController.this.service;
                        settingService.hide(longValue, mapItem.getUnitType(), new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$hide$1.1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                                invoke(bool.booleanValue(), num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16, int i16) {
                                SettingService settingService2;
                                SquareBaseKt.getSquareLog().i("FriendSettingController", "hide " + mapItem.getUin() + " result " + z16);
                                settingService2 = CommonSettingWindowController.this.service;
                                settingService2.report(SquareReportConst.CustomEventId.EVENT_ID_HIDE_FRIEND, mapItem.getUin(), 1, d.INSTANCE.b(z16), i16, SquareReportConst.Param.EM_STATE_SQUARE);
                            }
                        });
                    }
                });
            } else if (i3 == 4) {
                longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(mapItem.getUin());
                if (longOrNull2 == null) {
                    return;
                }
                long longValue2 = longOrNull2.longValue();
                this.tipsController.showTroopHideTipsFirst(context, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$hide$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SquareBase.INSTANCE.getConfig().getCommonUtils().showToast(context, R.string.xdh, 2);
                    }
                });
                SquareView squareView = this.squareView;
                if (squareView != null && (updater = squareView.getUpdater()) != null) {
                    updater.hide(mapItem.getUin());
                }
                this.service.cancelFixed(longValue2, true, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$hide$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                        invoke(bool.booleanValue(), num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, int i16) {
                        SquareBaseKt.getSquareLog().i("FriendSettingController", "cancelFixed " + MapItem.this.getUin() + " result " + z16);
                    }
                });
            } else if (i3 == 7) {
                this.tipsController.showMayKnowEntranceHideDialog(context, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$hide$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SquareView squareView2;
                        SettingService settingService;
                        ISquareViewUpdater updater2;
                        squareView2 = CommonSettingWindowController.this.squareView;
                        if (squareView2 != null && (updater2 = squareView2.getUpdater()) != null) {
                            updater2.hide(mapItem.getUin());
                        }
                        settingService = CommonSettingWindowController.this.service;
                        settingService.hideMayKnowEntrance(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$hide$4.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16) {
                                SquareBaseKt.getSquareLog().i("FriendSettingController", "hideMayKnowEntrance result " + z16);
                            }
                        });
                    }
                });
            }
            report(mapItem, 2);
        }
    }

    private final void initWindow(final Context context) {
        SquareSettingWindow squareSettingWindow = new SquareSettingWindow(context);
        squareSettingWindow.setClickListener(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$initWindow$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:31:0x00b4, code lost:
            
                r9 = r8.this$0.window;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(int i3) {
                SquareSettingWindow squareSettingWindow2;
                MapItem mapItem;
                Location location;
                int i16;
                Function1 function1;
                MapItem mapItem2;
                MapItem mapItem3;
                Function1 function12;
                MapItem mapItem4;
                MapItem mapItem5;
                boolean z16 = true;
                CommonSettingWindowController.this.hasClick = true;
                switch (i3) {
                    case 1:
                        mapItem = CommonSettingWindowController.this.data;
                        if (mapItem == null || (location = mapItem.getLocation()) == null || location.getRank() != 1) {
                            CommonSettingWindowController.this.closeToMe(context);
                            break;
                        } else {
                            ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
                            Context context2 = context;
                            i16 = CommonSettingWindowController.this.itemType;
                            ICommonUtils.DefaultImpls.showToast$default(commonUtils, context2, i16 == 1 ? R.string.xcs : R.string.xda, 0, 4, (Object) null);
                            z16 = false;
                            break;
                        }
                        break;
                    case 2:
                        CommonSettingWindowController.this.fixedOrCancel(context);
                        break;
                    case 3:
                        CommonSettingWindowController.this.hide(context);
                        break;
                    case 4:
                        CommonSettingWindowController.this.showOrBaned(context);
                        break;
                    case 5:
                        function1 = CommonSettingWindowController.this.gotoInteraction;
                        mapItem2 = CommonSettingWindowController.this.data;
                        function1.invoke(mapItem2);
                        mapItem3 = CommonSettingWindowController.this.data;
                        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (mapItem3 instanceof SquareAvatarItem ? mapItem3 : null);
                        if (squareAvatarItem != null) {
                            CommonSettingWindowController.this.reportFriend(squareAvatarItem, 8);
                            break;
                        }
                        break;
                    case 6:
                        function12 = CommonSettingWindowController.this.gotoInteraction;
                        mapItem4 = CommonSettingWindowController.this.data;
                        function12.invoke(mapItem4);
                        mapItem5 = CommonSettingWindowController.this.data;
                        SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) (mapItem5 instanceof SquareAvatarItem ? mapItem5 : null);
                        if (squareAvatarItem2 != null) {
                            CommonSettingWindowController.this.reportFriend(squareAvatarItem2, 9);
                            break;
                        }
                        break;
                }
                if (!z16 || squareSettingWindow2 == null) {
                    return;
                }
                squareSettingWindow2.dismiss();
            }
        });
        Unit unit = Unit.INSTANCE;
        this.window = squareSettingWindow;
    }

    private final void locateToNewLocation(String uin, Function1<? super Boolean, Unit> endCallback) {
        IDynamicLayoutComponent iDynamicLayoutComponent;
        SquareView squareView = this.squareView;
        if (squareView == null || (iDynamicLayoutComponent = (IDynamicLayoutComponent) squareView.getComponent(IDynamicLayoutComponent.class)) == null) {
            return;
        }
        squareView.getManipulator().locateTo(iDynamicLayoutComponent.findMoveToIndex(uin), endCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void report(MapItem item, int flag) {
        if (this.itemType == 1) {
            reportFriend(item, flag);
        } else {
            reportTroop(item, flag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportFriend(MapItem data, int pressType) {
        Object firstOrNull;
        Resource lookFront;
        if (data instanceof SquareAvatarItem) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, this.sourceFrom);
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) data;
            int i3 = 1;
            linkedHashMap.put("zplan_zhutai_ketai", Integer.valueOf(!squareAvatarItem.isMe() ? 1 : 0));
            OnlineStatus onlineStatus = squareAvatarItem.getExtra().getOnlineStatus();
            linkedHashMap.put(SquareReportConst.Key.KEY_STATE_ID, Integer.valueOf(onlineStatus != null ? onlineStatus.getTopStatusId() : 0));
            Integer richStatusId = SquareResourceManagerKt.getRichStatusId(squareAvatarItem);
            linkedHashMap.put(SquareReportConst.Key.KEY_RICH_STATE_ID, Integer.valueOf(richStatusId != null ? richStatusId.intValue() : 0));
            linkedHashMap.put("zplan_other_user_qq", data.getUin());
            SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) data;
            if (squareAvatarItem2.isDefault()) {
                i3 = 2;
            } else {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) squareAvatarItem2.getActions());
                AvatarAction avatarAction = (AvatarAction) firstOrNull;
                if (avatarAction != null && (lookFront = avatarAction.getLookFront()) != null && lookFront.getIsDefault()) {
                    i3 = 0;
                }
            }
            linkedHashMap.put(SquareReportConst.Key.KEY_AVATAR_TYPE, Integer.valueOf(i3));
            linkedHashMap.put(SquareReportConst.Key.KEY_PRESS_TYPE, Integer.valueOf(pressType));
            this.reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_AVATAR_LONG_CLICK, linkedHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportTroop(MapItem item, int flag) {
        if (!(item instanceof SquareTroopItem)) {
            item = null;
        }
        SquareTroopItem squareTroopItem = (SquareTroopItem) item;
        if (squareTroopItem != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, this.sourceFrom);
            linkedHashMap.put("zplan_other_user_qq", squareTroopItem.getUin());
            linkedHashMap.put(SquareReportConst.Key.KEY_PRESS_TYPE, Integer.valueOf(flag));
            this.reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_TROOP_LONG_CLICK, linkedHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBubbleAlpha(MapViewHolder<?> vh5, float alpha) {
        if (vh5 instanceof AvatarViewHolder) {
            VasSquareItemAvatarBinding binding = ((AvatarViewHolder) vh5).getBinding();
            AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = binding.squareAvatarBubble;
            Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "it.squareAvatarBubble");
            avatarOnlineStatusSimpleBubble.setAlpha(alpha);
            BubbleStickersBanner bubbleStickersBanner = binding.stickersBanner;
            Intrinsics.checkNotNullExpressionValue(bubbleStickersBanner, "it.stickersBanner");
            bubbleStickersBanner.setAlpha(alpha);
            SquareImageView squareImageView = binding.iconNewStatus;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "it.iconNewStatus");
            squareImageView.setAlpha(alpha);
            RelativeLayout relativeLayout = binding.avatarPttMessage;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "it.avatarPttMessage");
            relativeLayout.setAlpha(alpha);
            LinearLayout linearLayout = binding.avatarMessage;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "it.avatarMessage");
            linearLayout.setAlpha(alpha);
            VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding = binding.squareAvatarFeedsBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding, "it.squareAvatarFeedsBubble");
            LinearLayout mContainer = vasSquareQzoneFeedBubbleBinding.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "it.squareAvatarFeedsBubble.root");
            mContainer.setAlpha(alpha);
            return;
        }
        if (vh5 instanceof TroopViewHolder) {
            RelativeLayout relativeLayout2 = ((TroopViewHolder) vh5).getBinding().troopRootView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "vh.binding.troopRootView");
            relativeLayout2.setAlpha(alpha);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0.getUin());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showOrBaned(final Context context) {
        Long longOrNull;
        MapItem mapItem = this.data;
        if (!(mapItem instanceof SquareTroopItem)) {
            mapItem = null;
        }
        final SquareTroopItem squareTroopItem = (SquareTroopItem) mapItem;
        if (squareTroopItem == null || longOrNull == null) {
            return;
        }
        this.service.setPrivacyMode(longOrNull.longValue(), !squareTroopItem.getIsBaned(), new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$showOrBaned$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                invoke(bool.booleanValue(), num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3) {
                SquareView squareView;
                ISquareViewUpdater updater;
                SquareView squareView2;
                ISquareViewUpdater updater2;
                if (z16) {
                    if (squareTroopItem.getIsBaned()) {
                        squareView2 = CommonSettingWindowController.this.squareView;
                        if (squareView2 != null && (updater2 = squareView2.getUpdater()) != null) {
                            updater2.showTroopMessage(squareTroopItem.getUin());
                        }
                        ICommonUtils.DefaultImpls.showToast$default(SquareBase.INSTANCE.getConfig().getCommonUtils(), context, R.string.xdj, 0, 4, (Object) null);
                        CommonSettingWindowController.this.reportTroop(squareTroopItem, 7);
                        return;
                    }
                    squareView = CommonSettingWindowController.this.squareView;
                    if (squareView != null && (updater = squareView.getUpdater()) != null) {
                        updater.foldTroopMessage(squareTroopItem.getUin());
                    }
                    ICommonUtils.DefaultImpls.showToast$default(SquareBase.INSTANCE.getConfig().getCommonUtils(), context, R.string.xdi, 0, 4, (Object) null);
                    CommonSettingWindowController.this.reportTroop(squareTroopItem, 6);
                    return;
                }
                ICommonUtils.DefaultImpls.showToast$default(SquareBase.INSTANCE.getConfig().getCommonUtils(), context, R.string.xde, 0, 4, (Object) null);
            }
        });
    }

    public final void dismiss() {
        SquareSettingWindow squareSettingWindow = this.window;
        if (squareSettingWindow == null || !squareSettingWindow.isShowing()) {
            return;
        }
        squareSettingWindow.dismiss();
    }

    public final SettingTipsController getTipsController() {
        return this.tipsController;
    }

    public final void show(SquareView squareView, final MapViewHolder<?> vh5, final MapItem data, Context context, int type) {
        Number number;
        Intrinsics.checkNotNullParameter(squareView, "squareView");
        Intrinsics.checkNotNullParameter(vh5, "vh");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        this.hasClick = false;
        this.data = data;
        this.squareView = squareView;
        this.itemType = type;
        if (this.window == null) {
            initWindow(context);
        }
        SquareSettingWindow squareSettingWindow = this.window;
        if (squareSettingWindow != null) {
            squareSettingWindow.updateItem(getItemConfigArray(data));
        }
        SquareSettingWindow squareSettingWindow2 = this.window;
        if (squareSettingWindow2 != null) {
            squareSettingWindow2.updateItemAlpha(1, data.getLocation().getRank() == 1 ? 0.6f : 1.0f);
        }
        View view = vh5.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "vh.itemView");
        RectF viewLocation$default = BaseMapView.getViewLocation$default(squareView, view, null, 2, null);
        setBubbleAlpha(vh5, 0.0f);
        SquareSettingWindow squareSettingWindow3 = this.window;
        if (squareSettingWindow3 != null) {
            squareSettingWindow3.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.state.square.friendsetting.CommonSettingWindowController$show$1
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    boolean z16;
                    z16 = CommonSettingWindowController.this.hasClick;
                    if (!z16) {
                        CommonSettingWindowController.this.report(data, 4);
                    }
                    CommonSettingWindowController.this.setBubbleAlpha(vh5, 1.0f);
                }
            });
        }
        float width = (this.window != null ? r8.getWidth() : 0) - viewLocation$default.width();
        float currentZoomRatio = squareView.getCurrentZoomRatio();
        if (currentZoomRatio == 1.4f) {
            number = Float.valueOf(viewLocation$default.height() / 4);
        } else if (currentZoomRatio == 1.0f) {
            if (data.getType() == 7) {
                number = Integer.valueOf(ViewExtensionsKt.dip(context, -40));
            } else {
                number = Float.valueOf(viewLocation$default.height() / 4);
            }
        } else {
            number = 0;
        }
        SquareSettingWindow squareSettingWindow4 = this.window;
        if (squareSettingWindow4 != null) {
            squareSettingWindow4.showAtLocation(squareView.getContainer(), 0, (int) (((int) viewLocation$default.left) - (width / 2)), ((int) viewLocation$default.top) + number.intValue());
        }
        report(data, 0);
    }

    private final SquareSettingWindow.FloatItemConfig[] getMayKnowUserEntranceItemConfigArray(MapItem data) {
        return new SquareSettingWindow.FloatItemConfig[]{new SquareSettingWindow.FloatItemConfig(R.drawable.f159824ib3, new SquareSettingWindow.FloatItemTextStyle("\u79fb\u9664", 0.0f, 0, 6, null), R.drawable.gsp, 3)};
    }

    private final SquareSettingWindow.FloatItemConfig[] getFriendAvatarItemConfigArray(MapItem data) {
        String str;
        String str2;
        IntRange until;
        Object[] sliceArray;
        SquareSettingWindow.FloatItemConfig[] floatItemConfigArr = new SquareSettingWindow.FloatItemConfig[4];
        floatItemConfigArr[0] = new SquareSettingWindow.FloatItemConfig(R.drawable.f159823ib2, new SquareSettingWindow.FloatItemTextStyle("\u62cd\u4e00\u62cd", 0.0f, -16777216, 2, null), R.drawable.gsq, 5);
        if (data.getLocation().getRank() == 1) {
            str = "\u5df2\u8d34\u8fd1";
        } else {
            str = "\u8d34\u8fd1\u6211";
        }
        floatItemConfigArr[1] = new SquareSettingWindow.FloatItemConfig(R.drawable.iaz, new SquareSettingWindow.FloatItemTextStyle(str, 0.0f, 0, 6, null), R.drawable.gsp, 1);
        boolean z16 = data instanceof SquareAvatarItem;
        int i3 = (z16 && ((SquareAvatarItem) data).getExtra().getIsFixed()) ? R.drawable.iay : R.drawable.f159821ib0;
        if (z16 && ((SquareAvatarItem) data).getExtra().getIsFixed()) {
            str2 = "\u53d6\u6d88\u56fa\u5b9a";
        } else {
            str2 = "\u56fa\u5b9a";
        }
        floatItemConfigArr[2] = new SquareSettingWindow.FloatItemConfig(i3, new SquareSettingWindow.FloatItemTextStyle(str2, 0.0f, 0, 6, null), R.drawable.gsp, 2);
        floatItemConfigArr[3] = new SquareSettingWindow.FloatItemConfig(R.drawable.f159824ib3, new SquareSettingWindow.FloatItemTextStyle("\u79fb\u9664", 0.0f, 0, 6, null), R.drawable.gsp, 3);
        if (!SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
            return floatItemConfigArr;
        }
        until = RangesKt___RangesKt.until(1, 4);
        sliceArray = ArraysKt___ArraysKt.sliceArray(floatItemConfigArr, until);
        return (SquareSettingWindow.FloatItemConfig[]) sliceArray;
    }

    private final SquareSettingWindow.FloatItemConfig[] getTroopItemConfigArray(MapItem data) {
        String str;
        String str2;
        SquareSettingWindow.FloatItemConfig[] floatItemConfigArr = new SquareSettingWindow.FloatItemConfig[3];
        if (data.getLocation().getRank() == 1) {
            str = "\u5df2\u8d34\u8fd1";
        } else {
            str = "\u8d34\u8fd1\u6211";
        }
        floatItemConfigArr[0] = new SquareSettingWindow.FloatItemConfig(R.drawable.iaz, new SquareSettingWindow.FloatItemTextStyle(str, 0.0f, 0, 6, null), R.drawable.gsp, 1);
        floatItemConfigArr[1] = new SquareSettingWindow.FloatItemConfig(R.drawable.f159824ib3, new SquareSettingWindow.FloatItemTextStyle("\u79fb\u9664", 0.0f, 0, 6, null), R.drawable.gsp, 3);
        boolean z16 = data instanceof SquareTroopItem;
        int i3 = (z16 && ((SquareTroopItem) data).getIsBaned()) ? R.drawable.f159825ib4 : R.drawable.f159822ib1;
        if (z16 && ((SquareTroopItem) data).getIsBaned()) {
            str2 = "\u663e\u793a\u6d88\u606f";
        } else {
            str2 = "\u6536\u8d77\u6d88\u606f";
        }
        floatItemConfigArr[2] = new SquareSettingWindow.FloatItemConfig(i3, new SquareSettingWindow.FloatItemTextStyle(str2, 0.0f, 0, 6, null), R.drawable.gsp, 4);
        return floatItemConfigArr;
    }
}
