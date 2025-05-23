package com.tencent.state.square.chatland.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.state.SquareRuntime;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.view.CommonDialog;
import com.tencent.state.view.CommonDialogData;
import com.tencent.state.view.CommonDialogReportParams;
import com.tencent.state.view.ContentStyle;
import com.tencent.state.view.ResStyle;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u0015J4\u0010\u001e\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u0015J$\u0010 \u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u0015J4\u0010!\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u0015J,\u0010#\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u0015J,\u0010$\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandDialogTips;", "", "()V", "BG_RES_ID", "", "CLEAN_BG_RES_ID", "LOGO_IMG_HEIGHT_DP", "LOGO_IMG_URL", "", "LOGO_IMG_WIDTH_DP", "TAG", "WELCOME_IMG_URL", "getSceneName", "isBackClick", "", "loadImage", "", "context", "Landroid/content/Context;", "url", "done", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "onBeforeInitReport", "dialog", "Landroid/app/Dialog;", "view", "Landroid/view/View;", "showEndInteractionConfirm", "callback", "showLeaveConfirmTip", "appId", "showRoomFullTip", "showSwitchRoomConfirmTip", "isMeSeated", "showTAHaveLeaveTip", "showWelcomeTip", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandDialogTips {
    private static final int LOGO_IMG_HEIGHT_DP = 150;
    private static final String LOGO_IMG_URL = "https://cdn.meta.qq.com/chat_land/v2/vas_square_chatland_logo.webp";
    private static final int LOGO_IMG_WIDTH_DP = 150;
    private static final String TAG = "ChatLandDialogTips";
    private static final String WELCOME_IMG_URL = "https://cdn.meta.qq.com/chat_land/v2/vas_square_chatland_logo_welcome.webp";
    public static final ChatLandDialogTips INSTANCE = new ChatLandDialogTips();
    private static final int BG_RES_ID = R.drawable.grz;
    private static final int CLEAN_BG_RES_ID = R.drawable.f159800gs0;

    ChatLandDialogTips() {
    }

    public static final /* synthetic */ void access$onBeforeInitReport(ChatLandDialogTips chatLandDialogTips, Dialog dialog, View view) {
        chatLandDialogTips.onBeforeInitReport(dialog, view);
    }

    private final String getSceneName(boolean isBackClick) {
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            return "";
        }
        if (isBackClick) {
            return "\u52a8\u6001\u5e7f\u573a";
        }
        return "\u5f53\u524d\u804a\u5929\u533a\u57df";
    }

    private final void loadImage(Context context, String url, Function1<? super Drawable, Unit> done) {
        ImageLoader loader = ImageService.INSTANCE.getLoader();
        if (loader != null) {
            loader.loadImage(url, new ImageSize(150, 150), new ChatLandDialogTips$loadImage$1(context, done));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBeforeInitReport(Dialog dialog, View view) {
        Map<String, Object> mutableMapOf;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(view.getContext())));
        squareReporter.setPageInfo(dialog, view, checkNearby, mutableMapOf);
    }

    public final void showRoomFullTip(final Context context, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (context != null) {
            loadImage(context, LOGO_IMG_URL, new Function1<Drawable, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandDialogTips$showRoomFullTip$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Drawable logo) {
                    int i3;
                    Intrinsics.checkNotNullParameter(logo, "logo");
                    Context context2 = context;
                    ChatLandDialogTips chatLandDialogTips = ChatLandDialogTips.INSTANCE;
                    i3 = ChatLandDialogTips.BG_RES_ID;
                    CommonDialog commonDialog = new CommonDialog(context2, new CommonDialogData(new ResStyle(null, null, logo, 0, 0, null, null, null, Integer.valueOf(i3), 250, null), "\u8fd9\u4e2a\u5730\u65b9\u4eba\u6ee1\u5566", "\u53d6\u6d88", "\u5207\u6362", null, new ContentStyle("\u53bb\u5176\u4ed6\u6709\u7a7a\u4f4d\u7684\u5730\u65b9\u770b\u770b\u5427~", 0.0f, 0, false, 17, null, Integer.valueOf(ViewExtensionsKt.dip(context, -23)), 46, null), null, false, null, false, 960, null));
                    commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandDialogTips$showRoomFullTip$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i16) {
                            callback.invoke(Boolean.valueOf(i16 == 2));
                        }
                    });
                    commonDialog.show();
                }
            });
        }
    }

    public final void showSwitchRoomConfirmTip(final Context context, final int appId, boolean isMeSeated, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (context != null) {
            if (!isMeSeated) {
                callback.invoke(Boolean.TRUE);
            } else {
                loadImage(context, LOGO_IMG_URL, new Function1<Drawable, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandDialogTips$showSwitchRoomConfirmTip$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                        invoke2(drawable);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Drawable logo) {
                        int i3;
                        Map mapOf;
                        Map mapOf2;
                        Intrinsics.checkNotNullParameter(logo, "logo");
                        Context context2 = context;
                        ChatLandDialogTips chatLandDialogTips = ChatLandDialogTips.INSTANCE;
                        i3 = ChatLandDialogTips.BG_RES_ID;
                        ResStyle resStyle = new ResStyle(null, null, logo, 0, 0, null, null, null, Integer.valueOf(i3), 250, null);
                        ContentStyle contentStyle = new ContentStyle("\u5c06\u79bb\u5f00\u5f53\u524d\u804a\u5929\uff0c\u5207\u6362\u5230\u65b0\u7684\u5730\u65b9", 0.0f, 0, false, 17, null, Integer.valueOf(ViewExtensionsKt.dip(context, -23)), 46, null);
                        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "cancel"), TuplesKt.to(2, TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_TYPE, "switch_plot"), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(appId)));
                        CommonDialog commonDialog = new CommonDialog(context2, new CommonDialogData(resStyle, "\u8981\u6362\u4e00\u4e2a\u5730\u65b9\u5417\uff1f", "\u53d6\u6d88", "\u5207\u6362", null, contentStyle, null, false, new CommonDialogReportParams(SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_POPUP, SquareReportConst.Key.KEY_ZPLAN_POPUP_CLICK_TYPE, mapOf, mapOf2, new ChatLandDialogTips$showSwitchRoomConfirmTip$1$dialog$1(chatLandDialogTips)), false, 704, null));
                        commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandDialogTips$showSwitchRoomConfirmTip$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i16) {
                                callback.invoke(Boolean.valueOf(i16 == 2));
                            }
                        });
                        commonDialog.show();
                    }
                });
            }
        }
    }

    public final void showWelcomeTip(final Context context, final int appId, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (context != null) {
            loadImage(context, WELCOME_IMG_URL, new Function1<Drawable, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandDialogTips$showWelcomeTip$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Drawable logo) {
                    int i3;
                    Map mapOf;
                    Map mapOf2;
                    Intrinsics.checkNotNullParameter(logo, "logo");
                    Context context2 = context;
                    ChatLandDialogTips chatLandDialogTips = ChatLandDialogTips.INSTANCE;
                    i3 = ChatLandDialogTips.BG_RES_ID;
                    ResStyle resStyle = new ResStyle(null, null, logo, 0, 0, null, null, null, Integer.valueOf(i3), 250, null);
                    ContentStyle contentStyle = new ContentStyle("\u4f60\u53ef\u4ee5\u5728\u8fd9\u91cc\u9047\u89c1\u4e0d\u540c\u7684\u670b\u53cb\uff0c\u548c\u6709\u8da3\u7684\u7075\u9b42\u4e00\u8d77\u804a\u5929", 0.0f, 0, false, 0, null, Integer.valueOf(ViewExtensionsKt.dip(context, -10)), 62, null);
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "talk_later"), TuplesKt.to(2, "go_to_see"));
                    mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_TYPE, "plot_online"), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(appId)));
                    CommonDialog commonDialog = new CommonDialog(context2, new CommonDialogData(resStyle, "\u5e7f\u573a\u804a\u5929\u533a\u57df\u5f00\u653e\u5566", "\u4ee5\u540e\u518d\u8bf4", "\u53bb\u770b\u770b", null, contentStyle, null, false, new CommonDialogReportParams(SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_POPUP, SquareReportConst.Key.KEY_ZPLAN_POPUP_CLICK_TYPE, mapOf, mapOf2, new ChatLandDialogTips$showWelcomeTip$1$dialog$1(chatLandDialogTips)), false, 704, null));
                    commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandDialogTips$showWelcomeTip$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i16) {
                            callback.invoke(Boolean.valueOf(i16 == 2));
                        }
                    });
                    commonDialog.show();
                }
            });
        }
    }

    public final void showEndInteractionConfirm(Context context, final Function1<? super Boolean, Unit> callback) {
        Map mapOf;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (context != null) {
            ResStyle resStyle = new ResStyle(null, null, null, 0, 0, null, null, null, Integer.valueOf(CLEAN_BG_RES_ID), 254, null);
            ContentStyle contentStyle = new ContentStyle("\u662f\u5426\u7ed3\u675f\u5f53\u524d\u5408\u4f53\uff1f", 17.0f, 0, false, 17, Integer.valueOf(ViewExtensionsKt.dip(context, 0)), Integer.valueOf(ViewExtensionsKt.dip(context, -26)), 12, null);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "cancel"), TuplesKt.to(2, MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM));
            emptyMap = MapsKt__MapsKt.emptyMap();
            CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(resStyle, "", "\u53d6\u6d88", "\u786e\u8ba4\u7ed3\u675f", null, contentStyle, null, false, new CommonDialogReportParams(SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_INTER_END_DIALOG, SquareReportConst.Key.KEY_ZPLAN_POPUP_CLICK_TYPE, mapOf, emptyMap, new ChatLandDialogTips$showEndInteractionConfirm$dialog$1(this)), true, 192, null));
            commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandDialogTips$showEndInteractionConfirm$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    Function1.this.invoke(Boolean.valueOf(i3 == 2));
                }
            });
            commonDialog.show();
        }
    }

    public final void showTAHaveLeaveTip(Context context, int appId, final Function1<? super Boolean, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (context != null) {
            ResStyle resStyle = new ResStyle(null, null, null, 0, 0, null, null, null, Integer.valueOf(CLEAN_BG_RES_ID), 254, null);
            ContentStyle contentStyle = new ContentStyle("\u4ed6\u5df2\u7ecf\u79bb\u5f00\u4e86\u8fd9\u91cc\uff0c\u8981\u53bb\u5176\u4ed6\u5730\u65b9\u627e\u5230\u4ed6\u5417\uff1f", 0.0f, 0, false, 0, null, Integer.valueOf(ViewExtensionsKt.dip(context, -26)), 62, null);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "cancel"), TuplesKt.to(2, TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_TYPE, "track_other"), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(appId)));
            CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(resStyle, "\u5c0f\u63d0\u793a", "\u53d6\u6d88", "\u79bb\u5f00\u804a\u5929", null, contentStyle, null, false, new CommonDialogReportParams(SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_POPUP, SquareReportConst.Key.KEY_ZPLAN_POPUP_CLICK_TYPE, mapOf, mapOf2, new ChatLandDialogTips$showTAHaveLeaveTip$dialog$1(this)), false, 704, null));
            commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandDialogTips$showTAHaveLeaveTip$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    Function1.this.invoke(Boolean.valueOf(i3 == 2));
                }
            });
            commonDialog.show();
        }
    }

    public final void showLeaveConfirmTip(Context context, int appId, boolean isBackClick, final Function1<? super Boolean, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (context != null) {
            ResStyle resStyle = new ResStyle(null, null, null, 0, 0, null, null, null, Integer.valueOf(BG_RES_ID), 250, null);
            String str = "\u662f\u5426\u79bb\u5f00" + getSceneName(isBackClick) + '\uff1f';
            ContentStyle contentStyle = new ContentStyle("\u79bb\u5f00\u540e\u5c06\u4e0d\u518d\u6536\u5230\u804a\u5929\u6d88\u606f", 0.0f, 0, false, 17, null, Integer.valueOf(ViewExtensionsKt.dip(context, -23)), 46, null);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "cancel"), TuplesKt.to(2, "withdraw"));
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_TYPE, "withdraw_plot"), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(appId)));
            CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(resStyle, str, "\u6682\u4e0d", "\u786e\u8ba4\u79bb\u5f00", null, contentStyle, null, false, new CommonDialogReportParams(SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_POPUP, SquareReportConst.Key.KEY_ZPLAN_POPUP_CLICK_TYPE, mapOf, mapOf2, new ChatLandDialogTips$showLeaveConfirmTip$dialog$1(this)), false, 704, null));
            commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandDialogTips$showLeaveConfirmTip$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    Function1.this.invoke(Boolean.valueOf(i3 == 2));
                }
            });
            commonDialog.show();
        }
    }
}
