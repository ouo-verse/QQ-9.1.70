package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.aio.utils.InteractiveContentEmotionCodec;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.ViewUtils;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionListPart;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import com.tencent.mobileqq.matchfriend.reborn.guide.manager.util.ScheduleManager;
import com.tencent.mobileqq.nearbypro.api.router.NBPArticleFeedDetailPageSource;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 O2\u00020\u0001:\u0001PB\u0007\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J$\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\u001a\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\u0012\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0015H\u0014J*\u0010.\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020\u00072\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+H\u0014J\b\u00100\u001a\u00020/H\u0014R\u0016\u00103\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00102R\u0016\u0010=\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u00109R\u0016\u0010>\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u00102R\u0016\u0010@\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010A\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u00102R\u0016\u0010B\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u00109R\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010DR\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/ButtonSection;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/a;", "", "L", "M", "N", "D", "", "state", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Y", "", "isVisible", "X", "Z", "a0", "Landroid/widget/TextView;", "textView", "resId", "W", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "view", "", "marginStartDp", "marginEndDp", "b0", BdhLogUtil.LogTag.Tag_Req, UserInfo.SEX_FEMALE, "stringId", "", BdhLogUtil.LogTag.Tag_Conn, "U", "V", "success", "retMsg", "O", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "containerView", "onInitView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "inputData", "position", "", "", "payload", "G", "", "getViewStubLayoutId", "f", "Landroid/view/View;", "primaryActionButton", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "primaryActionIconView", "i", "Landroid/widget/TextView;", "primaryActionTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "secondaryActionButtonBg", "secondaryActionDivider", "secondaryButtonChatRoot", "E", "secondaryActionChatTv", "secondaryButtonQuickReplyRoot", "secondaryActionQuickReplyTv", "H", "I", "currentState", "preState", "Lcom/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManager;", "J", "Lkotlin/Lazy;", "B", "()Lcom/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManager;", "scheduleManager", "<init>", "()V", "K", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ButtonSection extends a {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView secondaryActionDivider;

    /* renamed from: D, reason: from kotlin metadata */
    private View secondaryButtonChatRoot;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView secondaryActionChatTv;

    /* renamed from: F, reason: from kotlin metadata */
    private View secondaryButtonQuickReplyRoot;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView secondaryActionQuickReplyTv;

    /* renamed from: H, reason: from kotlin metadata */
    private int currentState;

    /* renamed from: I, reason: from kotlin metadata */
    private int preState;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy scheduleManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View primaryActionButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView primaryActionIconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView primaryActionTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View secondaryActionButtonBg;

    public ButtonSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ScheduleManager>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.ButtonSection$scheduleManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ScheduleManager invoke() {
                ScheduleManager a16 = m82.a.f416439a.a();
                a16.h(a16, (r15 & 2) != 0 ? Dispatcher.DEFAULT_GROUP_NAME : null, (r15 & 4) != 0 ? "" : "com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.ButtonSection", (r15 & 8) != 0 ? Integer.MIN_VALUE : 0, (r15 & 16) != 0 ? Long.MIN_VALUE : 0L, (r15 & 32) == 0 ? 1 : Integer.MIN_VALUE);
                return a16;
            }
        });
        this.scheduleManager = lazy;
    }

    private final boolean A() {
        if (u.a().b()) {
            return false;
        }
        if (NetworkUtil.isNetworkAvailable()) {
            return true;
        }
        QQToast.makeText(this.mRootView.getContext(), R.string.x0e, 0).show();
        return false;
    }

    private final ScheduleManager B() {
        return (ScheduleManager) this.scheduleManager.getValue();
    }

    private final String C(int stringId) {
        String string = getRootView().getContext().getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "rootView.context.getString(stringId)");
        return string;
    }

    private final void D() {
        int i3;
        if (getData().getIsCommentDeleted()) {
            i3 = 0;
        } else {
            int sceneId = getData().getSceneId();
            i3 = sceneId != 7 ? sceneId != 8 ? 2 : 1 : 3;
        }
        this.currentState = i3;
        this.preState = i3;
        Y();
    }

    private final boolean F() {
        return ScheduleManager.d(B(), this, "com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.ButtonSection", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ButtonSection this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ButtonSection this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(ButtonSection this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N();
    }

    private final void L() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (A()) {
            if (getData().getMsgInfo().getIsFeedDeleted()) {
                QQToast.makeText(this.mRootView.getContext(), R.string.f169691x23, 0).show();
                return;
            }
            Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
            View view = null;
            userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
            if (userinfo_miniinfo == null) {
                return;
            }
            int sceneId = getData().getSceneId();
            if (sceneId == 6) {
                NBPArticleFeedDetailPageSource nBPArticleFeedDetailPageSource = NBPArticleFeedDetailPageSource.INTERACTIVE_NOTIFICATION;
                QQStrangerLiteActionModel data = getData();
                Context context = this.mRootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
                com.tencent.mobileqq.matchfriend.reborn.utils.l.h(nBPArticleFeedDetailPageSource, data, userinfo_miniinfo, context, true);
                return;
            }
            if (sceneId == 7 || sceneId == 8) {
                QQStrangerLiteActionListPart.INSTANCE.b(getData());
                com.tencent.mobileqq.matchfriend.reborn.utils.l lVar = com.tencent.mobileqq.matchfriend.reborn.utils.l.f245486a;
                Context context2 = this.mRootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "mRootView.context");
                String feedId = getData().getMsgInfo().getFeedId();
                String commentId = getData().getMsgInfo().getCommentId();
                String replyId = getData().getMsgInfo().getReplyId();
                String string = this.mRootView.getContext().getString(R.string.x29, getData().getNick());
                Intrinsics.checkNotNullExpressionValue(string, "mRootView.context.getStr\u2026ick\n                    )");
                lVar.j(context2, "com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.ButtonSection", feedId, commentId, replyId, string);
                hashMap.put("interaction_type", Integer.valueOf(getData().getSceneId() == 7 ? 4 : 5));
                a82.a aVar = a82.a.f25717a;
                View view2 = this.primaryActionButton;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("primaryActionButton");
                } else {
                    view = view2;
                }
                aVar.a(view, "em_kl_reply_btn", "dt_clck", hashMap);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void M() {
        View view;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (A()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            View view2 = null;
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface == null) {
                return;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(getData().getMsgInfo().getFeedId())) {
                bundle.putString("quote_feed_id", getData().getMsgInfo().getFeedId());
            }
            String j3 = com.tencent.mobileqq.matchfriend.utils.b.d().j();
            if (j3 == null) {
                j3 = "";
            }
            if ((getData().getMsgInfo().getFeedOwnerUid().length() > 0) && !Intrinsics.areEqual(getData().getMsgInfo().getFeedOwnerUid(), j3)) {
                if (getData().getUserId().length() > 0) {
                    ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMatchFriendAIO(appInterface, this.mRootView.getContext(), getData().getUserId(), 9, bundle);
                    a82.a aVar = a82.a.f25717a;
                    aVar.d(hashMap, getData());
                    hashMap.put("message_id", getData().getMsgId());
                    hashMap.put("have_quic_msg", Integer.valueOf(this.currentState != 3 ? 0 : 1));
                    hashMap.put("interaction_id", Integer.valueOf(getData().getInteractiveOption().getInteractiveId()));
                    hashMap.put("interaction_text", getData().getInteractiveOption().getQuickReplyText());
                    hashMap.put("serial_number", Integer.valueOf(getPosition()));
                    view = this.secondaryButtonChatRoot;
                    if (view != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonChatRoot");
                    } else {
                        view2 = view;
                    }
                    aVar.a(view2, "em_bas_chat_button", "dt_clck", hashMap);
                }
            }
            if (getData().getPeerTinyId() > 0) {
                ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMatchFriendAIO(this.mRootView.getContext(), getData().getPeerTinyId(), "", 9, bundle);
            }
            a82.a aVar2 = a82.a.f25717a;
            aVar2.d(hashMap, getData());
            hashMap.put("message_id", getData().getMsgId());
            hashMap.put("have_quic_msg", Integer.valueOf(this.currentState != 3 ? 0 : 1));
            hashMap.put("interaction_id", Integer.valueOf(getData().getInteractiveOption().getInteractiveId()));
            hashMap.put("interaction_text", getData().getInteractiveOption().getQuickReplyText());
            hashMap.put("serial_number", Integer.valueOf(getPosition()));
            view = this.secondaryButtonChatRoot;
            if (view != null) {
            }
            aVar2.a(view2, "em_bas_chat_button", "dt_clck", hashMap);
        }
    }

    private final void N() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (A()) {
            if (this.currentState == 3) {
                z(1);
            }
            if (this.currentState == 2) {
                z(1);
            }
            if (getData().getInteractiveOption().getQuickReplyText().length() == 0) {
                return;
            }
            R();
            hashMap.put("interaction_id", Integer.valueOf(getData().getInteractiveOption().getInteractiveId()));
            hashMap.put("interaction_text", getData().getInteractiveOption().getQuickReplyText());
            a82.a aVar = a82.a.f25717a;
            View view = this.secondaryButtonQuickReplyRoot;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonQuickReplyRoot");
                view = null;
            }
            aVar.a(view, "em_kl_thanks", "dt_clck", hashMap);
        }
    }

    private final void R() {
        String str;
        final HashMap<String, Object> hashMap = new HashMap<>();
        if (!F()) {
            QLog.i("ButtonSection", 1, "sendQuickMsgAndShowDialogIfNeeded needShowSendQuickReplyMsgDialog false");
            U();
            return;
        }
        hashMap.put("kl_btn_type", "");
        hashMap.put("qq_pgid", "pg_bas_interactive_notification");
        hashMap.put("qq_eid", "em_kl_chat_guide_pop");
        a82.a aVar = a82.a.f25717a;
        View mRootView = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        aVar.a(mRootView, "em_kl_chat_guide_pop", "qq_imp", hashMap);
        if (QQTheme.isNowThemeIsNight()) {
            str = "https://downv6.qq.com/extendfriend/qqstranger_lite_action_quick_reply_dialog_banner_dark.png";
        } else {
            str = "https://downv6.qq.com/extendfriend/qqstranger_lite_action_quick_reply_dialog_banner_light.png";
        }
        DialogUtil.createDialogWithBanner(getRootView().getContext(), 230, str, C(R.string.x2f), C(R.string.x2d), C(R.string.x2c), C(R.string.x2e), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ButtonSection.S(ButtonSection.this, hashMap, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ButtonSection.T(ButtonSection.this, hashMap, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(ButtonSection this$0, HashMap params, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        ScheduleManager.b(this$0.B(), this$0, "com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.ButtonSection", null, 4, null);
        this$0.U();
        params.put("kl_btn_type", 1);
        a82.a aVar = a82.a.f25717a;
        View mRootView = this$0.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        aVar.a(mRootView, "em_kl_chat_guide_pop", "qq_clck", params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(ButtonSection this$0, HashMap params, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        this$0.z(this$0.preState);
        params.put("kl_btn_type", 0);
        a82.a aVar = a82.a.f25717a;
        View mRootView = this$0.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        aVar.a(mRootView, "em_kl_chat_guide_pop", "qq_clck", params);
    }

    private final void U() {
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
        if ((a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null) != null) {
            V();
        } else {
            P(this, false, null, 2, null);
        }
    }

    private final void V() {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ButtonSection$sendQuickReplyReqInternal$1(this, null), 2, null);
    }

    private final void W(TextView textView, int resId) {
        Drawable drawable = ResourcesCompat.getDrawable(textView.getContext().getResources(), resId, null);
        if (drawable != null) {
            drawable.setBounds(0, 0, o.e(16), o.e(16));
        } else {
            drawable = null;
        }
        textView.setCompoundDrawablesRelative(drawable, null, null, null);
        textView.setCompoundDrawablePadding(textView.getContext().getResources().getDimensionPixelSize(R.dimen.f104726));
    }

    private final void X(boolean isVisible) {
        View view;
        View view2;
        if (isVisible) {
            View view3 = this.primaryActionButton;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryActionButton");
                view3 = null;
            }
            view3.setVisibility(0);
            ImageView imageView = this.primaryActionIconView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryActionIconView");
                imageView = null;
            }
            imageView.setVisibility(0);
            TextView textView = this.primaryActionTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryActionTextView");
                textView = null;
            }
            textView.setVisibility(0);
            View view4 = this.secondaryActionButtonBg;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionButtonBg");
                view2 = null;
            } else {
                view2 = view4;
            }
            c0(this, view2, 8.0f, 0.0f, 4, null);
            return;
        }
        View view5 = this.primaryActionButton;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryActionButton");
            view5 = null;
        }
        view5.setVisibility(8);
        ImageView imageView2 = this.primaryActionIconView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryActionIconView");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        TextView textView2 = this.primaryActionTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryActionTextView");
            textView2 = null;
        }
        textView2.setVisibility(8);
        View view6 = this.secondaryActionButtonBg;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryActionButtonBg");
            view = null;
        } else {
            view = view6;
        }
        c0(this, view, 0.0f, 0.0f, 4, null);
    }

    private final void Z(boolean isVisible) {
        TextView textView = null;
        if (isVisible) {
            View view = this.secondaryButtonChatRoot;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonChatRoot");
                view = null;
            }
            view.setVisibility(0);
            TextView textView2 = this.secondaryActionChatTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionChatTv");
            } else {
                textView = textView2;
            }
            W(textView, R.drawable.qui_message_testing);
            textView.setVisibility(0);
            return;
        }
        View view2 = this.secondaryButtonChatRoot;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonChatRoot");
            view2 = null;
        }
        view2.setVisibility(8);
        TextView textView3 = this.secondaryActionChatTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryActionChatTv");
        } else {
            textView = textView3;
        }
        Q(textView);
        textView.setVisibility(8);
    }

    private final void a0(boolean isVisible) {
        View view = null;
        if (isVisible) {
            TextView textView = this.secondaryActionQuickReplyTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionQuickReplyTv");
                textView = null;
            }
            textView.setText(new SpannableString(InteractiveContentEmotionCodec.f243983a.b(getData().getInteractiveOption().getQuickReplyText(), 16)));
            TextView textView2 = this.secondaryActionQuickReplyTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionQuickReplyTv");
                textView2 = null;
            }
            textView2.setVisibility(0);
            View view2 = this.secondaryButtonQuickReplyRoot;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonQuickReplyRoot");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        TextView textView3 = this.secondaryActionQuickReplyTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryActionQuickReplyTv");
            textView3 = null;
        }
        textView3.setVisibility(8);
        View view3 = this.secondaryButtonQuickReplyRoot;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonQuickReplyRoot");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    private final void b0(View view, float marginStartDp, float marginEndDp) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (!(marginStartDp == -1.0f)) {
            layoutParams2.setMarginStart((int) ViewUtils.f244350a.c(marginStartDp));
        }
        if (!(marginEndDp == -1.0f)) {
            layoutParams2.setMarginEnd((int) ViewUtils.f244350a.c(marginEndDp));
        }
        view.setLayoutParams(layoutParams2);
    }

    private final void z(int state) {
        this.preState = this.currentState;
        this.currentState = state;
        Y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindData(QQStrangerLiteActionModel inputData, int position, List<Object> payload) {
        HashMap<String, Object> hashMap = new HashMap<>();
        s(position);
        if (inputData == null) {
            return;
        }
        r(inputData);
        D();
        int sceneId = getData().getSceneId();
        if (sceneId == 6) {
            X(false);
            return;
        }
        if (sceneId != 7 && sceneId != 8) {
            X(false);
            return;
        }
        if (getData().getIsCommentDeleted()) {
            X(false);
        } else {
            X(true);
        }
        ImageView imageView = this.primaryActionIconView;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryActionIconView");
            imageView = null;
        }
        imageView.setImageDrawable(ie0.a.f().o(this.mRootView.getContext(), R.drawable.qui_comment_testing, R.color.qui_common_icon_primary, 1000));
        TextView textView = this.primaryActionTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryActionTextView");
            textView = null;
        }
        textView.setText("\u56de\u590d");
        if (QQStrangerLiteActionListPart.INSTANCE.a(getData().getMsgId(), "em_kl_reply_btn")) {
            a82.a aVar = a82.a.f25717a;
            View view2 = this.primaryActionButton;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryActionButton");
            } else {
                view = view2;
            }
            aVar.a(view, "em_kl_reply_btn", "dt_imp", hashMap);
        }
    }

    private final void Q(TextView textView) {
        textView.setCompoundDrawablesRelative(null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    private final void Y() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        int i3;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!getData().getInteractiveOption().getCanShowQuickReply() && ((i3 = this.currentState) == 3 || i3 == 2)) {
            this.currentState = 1;
        }
        int i16 = this.currentState;
        if (i16 == 1) {
            Z(true);
            a0(false);
            TextView textView5 = this.secondaryActionChatTv;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionChatTv");
                textView = null;
            } else {
                textView = textView5;
            }
            c0(this, textView, 0.0f, 12.0f, 2, null);
            View view = this.secondaryButtonChatRoot;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonChatRoot");
                view = null;
            }
            view.setBackgroundResource(R.drawable.f8e);
            TextView textView6 = this.secondaryActionDivider;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionDivider");
                textView6 = null;
            }
            textView6.setVisibility(8);
            View view2 = this.secondaryActionButtonBg;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionButtonBg");
                view2 = null;
            }
            view2.setVisibility(0);
            a82.a aVar = a82.a.f25717a;
            aVar.d(hashMap, getData());
            hashMap.put("message_id", getData().getMsgId());
            hashMap.put("have_quic_msg", 0);
            hashMap.put("interaction_id", "");
            hashMap.put("interaction_text", "");
            hashMap.put("serial_number", Integer.valueOf(getPosition()));
            View view3 = this.secondaryButtonChatRoot;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonChatRoot");
                view3 = null;
            }
            aVar.a(view3, "em_bas_chat_button", "dt_imp", hashMap);
            return;
        }
        if (i16 == 2) {
            Z(false);
            a0(true);
            TextView textView7 = this.secondaryActionQuickReplyTv;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionQuickReplyTv");
                textView2 = null;
            } else {
                textView2 = textView7;
            }
            c0(this, textView2, 8.0f, 0.0f, 4, null);
            View view4 = this.secondaryButtonQuickReplyRoot;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonQuickReplyRoot");
                view4 = null;
            }
            view4.setBackgroundResource(R.drawable.f8e);
            TextView textView8 = this.secondaryActionDivider;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionDivider");
                textView8 = null;
            }
            textView8.setVisibility(8);
            View view5 = this.secondaryActionButtonBg;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionButtonBg");
                view5 = null;
            }
            view5.setVisibility(0);
            hashMap.put("interaction_id", Integer.valueOf(getData().getInteractiveOption().getInteractiveId()));
            hashMap.put("interaction_text", getData().getInteractiveOption().getQuickReplyText());
            a82.a aVar2 = a82.a.f25717a;
            View view6 = this.secondaryButtonQuickReplyRoot;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonQuickReplyRoot");
                view6 = null;
            }
            aVar2.a(view6, "em_kl_thanks", "dt_imp", hashMap);
            return;
        }
        if (i16 != 3) {
            Z(false);
            a0(false);
            TextView textView9 = this.secondaryActionDivider;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionDivider");
                textView9 = null;
            }
            textView9.setVisibility(8);
            View view7 = this.secondaryActionButtonBg;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryActionButtonBg");
                view7 = null;
            }
            view7.setVisibility(8);
            return;
        }
        Z(true);
        TextView textView10 = this.secondaryActionChatTv;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryActionChatTv");
            textView3 = null;
        } else {
            textView3 = textView10;
        }
        c0(this, textView3, 0.0f, 4.0f, 2, null);
        a0(true);
        TextView textView11 = this.secondaryActionQuickReplyTv;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryActionQuickReplyTv");
            textView4 = null;
        } else {
            textView4 = textView11;
        }
        c0(this, textView4, 4.0f, 0.0f, 4, null);
        View view8 = this.secondaryButtonChatRoot;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonChatRoot");
            view8 = null;
        }
        view8.setBackgroundResource(R.drawable.f88);
        View view9 = this.secondaryButtonQuickReplyRoot;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonQuickReplyRoot");
            view9 = null;
        }
        view9.setBackgroundResource(R.drawable.f8a);
        TextView textView12 = this.secondaryActionDivider;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryActionDivider");
            textView12 = null;
        }
        textView12.setVisibility(0);
        View view10 = this.secondaryActionButtonBg;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryActionButtonBg");
            view10 = null;
        }
        view10.setVisibility(0);
        a82.a aVar3 = a82.a.f25717a;
        aVar3.d(hashMap, getData());
        hashMap.put("message_id", getData().getMsgId());
        hashMap.put("have_quic_msg", 1);
        hashMap.put("interaction_id", Integer.valueOf(getData().getInteractiveOption().getInteractiveId()));
        hashMap.put("interaction_text", getData().getInteractiveOption().getQuickReplyText());
        hashMap.put("serial_number", Integer.valueOf(getPosition()));
        View view11 = this.secondaryButtonChatRoot;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonChatRoot");
            view11 = null;
        }
        aVar3.a(view11, "em_bas_chat_button", "dt_imp", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            this.mRootView = containerView;
            View findViewById = containerView.findViewById(R.id.onw);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.qqs\u2026action_primary_icon_root)");
            this.primaryActionButton = findViewById;
            View view = null;
            if (findViewById == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryActionButton");
                findViewById = null;
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ButtonSection.H(ButtonSection.this, view2);
                }
            });
            View findViewById2 = containerView.findViewById(R.id.onr);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.qqs\u2026ger_lite_action_icon_img)");
            this.primaryActionIconView = (ImageView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.ons);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.qqs\u2026er_lite_action_icon_text)");
            this.primaryActionTextView = (TextView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.f163166oo0);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.qqs\u2026tion_secondary_icon_root)");
            this.secondaryActionButtonBg = findViewById4;
            View findViewById5 = containerView.findViewById(R.id.onz);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById(R.id.qqs\u2026tion_secondary_chat_root)");
            this.secondaryButtonChatRoot = findViewById5;
            if (findViewById5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonChatRoot");
                findViewById5 = null;
            }
            findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ButtonSection.J(ButtonSection.this, view2);
                }
            });
            View findViewById6 = containerView.findViewById(R.id.ony);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.qqs\u2026te_action_secondary_chat)");
            this.secondaryActionChatTv = (TextView) findViewById6;
            View findViewById7 = containerView.findViewById(R.id.osf);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "it.findViewById(R.id.vertical_divider_bar)");
            this.secondaryActionDivider = (TextView) findViewById7;
            View findViewById8 = containerView.findViewById(R.id.f163168oo2);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "it.findViewById(R.id.qqs\u2026condary_quick_reply_root)");
            this.secondaryButtonQuickReplyRoot = findViewById8;
            if (findViewById8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryButtonQuickReplyRoot");
            } else {
                view = findViewById8;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ButtonSection.K(ButtonSection.this, view2);
                }
            });
            View findViewById9 = containerView.findViewById(R.id.f163167oo1);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "it.findViewById(R.id.qqs\u2026on_secondary_quick_reply)");
            this.secondaryActionQuickReplyTv = (TextView) findViewById9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(boolean success, String retMsg) {
        if (success) {
            QQToast.makeText(this.mRootView.getContext(), 2, R.string.x2a, 0).show();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface != null) {
                String currentUid = appInterface.getCurrentUid();
                Intrinsics.checkNotNullExpressionValue(currentUid, "currentUid");
                com.tencent.mobileqq.matchfriend.reborn.utils.h.t(currentUid, getData().getPeerTinyId(), getData().getMsgInfo().getFeedId());
            }
            getData().getInteractiveOption().d(false);
            return;
        }
        if (retMsg.length() > 0) {
            QQToast.makeText(this.mRootView.getContext(), retMsg, 0).show();
        } else {
            QQToast.makeText(this.mRootView.getContext(), R.string.x2b, 0).show();
        }
    }

    static /* synthetic */ void P(ButtonSection buttonSection, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        buttonSection.O(z16, str);
    }

    static /* synthetic */ void c0(ButtonSection buttonSection, View view, float f16, float f17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = -1.0f;
        }
        if ((i3 & 4) != 0) {
            f17 = -1.0f;
        }
        buttonSection.b0(view, f16, f17);
    }
}
