package com.tencent.icgame.game.liveroom.impl.room.followguide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JB\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0018R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideDialogUtil;", "", "Landroid/app/Activity;", "context", "Lcom/tencent/mobileqq/icgame/api/room/IAudienceRoom;", "liveRoom", "", "from", "Landroid/app/Dialog;", "f", "Landroid/content/Context;", tl.h.F, "e", "dialog", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "i", "view", "", "isAsync", "", IECDtReport.ACTION_IDENTIFIER, "elementID", "", "businessParams", "c", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "b", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "Lfu0/c;", "Lkotlin/Lazy;", "g", "()Lfu0/c;", "liveRoomService", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class FollowGuideDialogUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FollowGuideDialogUtil f115323a = new FollowGuideDialogUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IAegisLogApi mAegisLog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy liveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideDialogUtil$a", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements IQQLiveFollowCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Dialog f115326a;

        a(Dialog dialog) {
            this.f115326a = dialog;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            FollowGuideDialogUtil.mAegisLog.i("ICGameFollowGuideDialogUtil", 1, "setViewData doFollowAnchor onFail errCode=" + errCode + ",errMsg=" + errMsg);
            this.f115326a.dismiss();
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            FollowGuideDialogUtil.mAegisLog.i("ICGameFollowGuideDialogUtil", 1, "setViewData doFollowAnchor onSuccess");
            this.f115326a.dismiss();
        }
    }

    static {
        Lazy lazy;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        mAegisLog = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.icgame.game.liveroom.impl.room.followguide.FollowGuideDialogUtil$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        liveRoomService = lazy;
    }

    FollowGuideDialogUtil() {
    }

    public static /* synthetic */ void d(FollowGuideDialogUtil followGuideDialogUtil, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i3 & 4) != 0) {
            str = null;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            map = new HashMap();
        }
        followGuideDialogUtil.c(view, z17, str3, str2, map);
    }

    private final Dialog e(Context context, IAudienceRoom liveRoom, int from) {
        View view = LayoutInflater.from(context).inflate(R.layout.fay, (ViewGroup) null);
        ReportDialog reportDialog = new ReportDialog(context, R.style.a0f);
        reportDialog.requestWindowFeature(1);
        reportDialog.setCanceledOnTouchOutside(true);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        i(reportDialog, view, liveRoom, from);
        reportDialog.setContentView(view);
        Window window = reportDialog.getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = uu0.a.a(224.0f);
        window.setAttributes(attributes);
        return reportDialog;
    }

    @JvmStatic
    @NotNull
    public static final Dialog f(@NotNull Activity context, @NotNull IAudienceRoom liveRoom, int from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(liveRoom, "liveRoom");
        if (context.getResources().getConfiguration().orientation == 1) {
            return f115323a.e(context, liveRoom, from);
        }
        return f115323a.h(context, liveRoom, from);
    }

    private final fu0.c g() {
        Object value = liveRoomService.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-liveRoomService>(...)");
        return (fu0.c) value;
    }

    private final Dialog h(Context context, IAudienceRoom liveRoom, int from) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.faz, (ViewGroup) null);
        ReportDialog reportDialog = new ReportDialog(context, R.style.a0h);
        reportDialog.requestWindowFeature(1);
        reportDialog.setCanceledOnTouchOutside(true);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        i(reportDialog, rootView, liveRoom, from);
        reportDialog.setContentView(rootView);
        Window window = reportDialog.getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 5;
        attributes.width = uu0.a.a(244.0f);
        attributes.height = -1;
        window.setAttributes(attributes);
        return reportDialog;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void i(final Dialog dialog, View rootView, final IAudienceRoom liveRoom, int from) {
        boolean z16;
        LiveInfo roomLiveInfo;
        String str;
        LiveAnchorInfo liveAnchorInfo;
        LiveAnchorInfo liveAnchorInfo2;
        String str2;
        boolean z17;
        View findViewById = rootView.findViewById(R.id.snr);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.soq);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.vcn);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById3;
        LiveInfo roomLiveInfo2 = liveRoom.getRoomLiveInfo();
        boolean z18 = true;
        if (roomLiveInfo2 != null && (liveAnchorInfo2 = roomLiveInfo2.anchorInfo) != null && (str2 = liveAnchorInfo2.headUrl) != null) {
            if (str2.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (z16) {
                    imageView.setImageDrawable(URLDrawable.getDrawable(liveRoom.getRoomLiveInfo().anchorInfo.headUrl));
                }
                roomLiveInfo = liveRoom.getRoomLiveInfo();
                if (roomLiveInfo == null && (liveAnchorInfo = roomLiveInfo.anchorInfo) != null) {
                    str = liveAnchorInfo.nickName;
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z18 = false;
                }
                if (!z18 && str.length() > 12) {
                    String str3 = liveRoom.getRoomLiveInfo().anchorInfo.nickName;
                    Intrinsics.checkNotNullExpressionValue(str3, "liveRoom.roomLiveInfo.anchorInfo.nickName");
                    String substring = str3.substring(0, 12);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    str = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                RFWTypefaceUtil.setNumberTypeface(textView2, false);
                textView.setText(str);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.followguide.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FollowGuideDialogUtil.j(IAudienceRoom.this, dialog, view);
                    }
                });
                HashMap hashMap = new HashMap();
                hashMap.put("icgame_focus_page_casue", String.valueOf(from));
                d(this, textView2, false, null, "em_icgame_focus_page", hashMap, 6, null);
            }
        }
        z16 = false;
        if (z16) {
        }
        roomLiveInfo = liveRoom.getRoomLiveInfo();
        if (roomLiveInfo == null) {
        }
        str = null;
        if (str != null) {
            z18 = false;
        }
        if (!z18) {
            String str32 = liveRoom.getRoomLiveInfo().anchorInfo.nickName;
            Intrinsics.checkNotNullExpressionValue(str32, "liveRoom.roomLiveInfo.anchorInfo.nickName");
            String substring2 = str32.substring(0, 12);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            str = substring2 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        RFWTypefaceUtil.setNumberTypeface(textView2, false);
        textView.setText(str);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.followguide.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FollowGuideDialogUtil.j(IAudienceRoom.this, dialog, view);
            }
        });
        HashMap hashMap2 = new HashMap();
        hashMap2.put("icgame_focus_page_casue", String.valueOf(from));
        d(this, textView2, false, null, "em_icgame_focus_page", hashMap2, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(IAudienceRoom liveRoom, Dialog dialog, View view) {
        IQQLiveFollowMsgService iQQLiveFollowMsgService;
        LiveInfo roomLiveInfo;
        LiveAnchorInfo liveAnchorInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(liveRoom, "$liveRoom");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        IQQLiveSDK f16 = f115323a.g().f();
        if (f16 != null) {
            iQQLiveFollowMsgService = f16.getFollowMsgService();
        } else {
            iQQLiveFollowMsgService = null;
        }
        IQQLiveFollowMsgService iQQLiveFollowMsgService2 = iQQLiveFollowMsgService;
        if (iQQLiveFollowMsgService2 != null && (roomLiveInfo = liveRoom.getRoomLiveInfo()) != null && (liveAnchorInfo = roomLiveInfo.anchorInfo) != null) {
            TGLiveFollowManager.f115307a.f(iQQLiveFollowMsgService2, liveAnchorInfo.getAnchorUid(), liveRoom.getRoomInfo().getRoomId(), new a(dialog));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void c(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ru0.a) qx0.a.b(ru0.a.class)).a(view, isAsync, identifier, elementID, businessParams);
    }
}
