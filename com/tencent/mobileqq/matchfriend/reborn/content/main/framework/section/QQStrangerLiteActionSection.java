package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.config.b;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$MsgInfo;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$SendInterMsgReq;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$SendInterMsgRsp;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$StImage;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J(\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\u001fH\u0014J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!H\u0014J(\u0010)\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\f2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0014R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001b\u00108\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/QQStrangerLiteActionSection;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/a;", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "feedId", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "feed", "", "emojiId", "Lcom/tencent/mobileqq/matchfriend/reborn/config/b$b;", "emojiConfig", "", "G", "drawable", "M", "Lcom/airbnb/lottie/LottieAnimationView;", "view", "zipUrl", "N", "openId", "traceId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "K", "event", "J", "H", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "D", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "liteActionTv", "e", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "f", "Z", "isLiteAction", tl.h.F, "Lkotlin/Lazy;", "B", "()Ljava/lang/String;", "myOpenId", "<init>", "()V", "i", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerLiteActionSection extends a {

    /* renamed from: m, reason: collision with root package name */
    private static HashMap<String, Boolean> f244297m = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView liteActionTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView lottieView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isLiteAction = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy myOpenId;

    public QQStrangerLiteActionSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.QQStrangerLiteActionSection$myOpenId$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return com.tencent.mobileqq.matchfriend.utils.b.d().j();
            }
        });
        this.myOpenId = lazy;
    }

    private final void A(Context context, String openId, String feedId, String traceId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
        Bundle bundle = new Bundle();
        bundle.putString("quote_feed_id", feedId);
        bundle.putString("recom_trace", traceId);
        Unit unit = Unit.INSTANCE;
        iMatchFriendEntryApi.enterMatchFriendAIO(appInterface, context, openId, 9, bundle);
    }

    private final String B() {
        Object value = this.myOpenId.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-myOpenId>(...)");
        return (String) value;
    }

    private final boolean C(String feedId) {
        Boolean bool = f244297m.get(feedId);
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(QQStrangerLiteActionSection this$0, FeedPB$Feed data, int i3, b.C8009b c8009b, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.G(data, i3, c8009b);
    }

    private final void G(FeedPB$Feed feed, int emojiId, b.C8009b emojiConfig) {
        String lottieUrl;
        Context context = getRootView().getContext();
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(0, q(R.string.x0e));
            return;
        }
        if (!this.isLiteAction) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            A(context, u72.a.g(feed), u72.a.b(feed), u72.a.h(feed));
            H("dt_clck", feed);
            return;
        }
        this.isLiteAction = false;
        f244297m.put(u72.a.b(feed), Boolean.TRUE);
        M(ContextCompat.getDrawable(context, R.drawable.qui_chat_testing));
        TextView textView = this.liteActionTv;
        LottieAnimationView lottieAnimationView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liteActionTv");
            textView = null;
        }
        textView.setText(q(R.string.x2n));
        J("dt_clck", feed);
        H("dt_imp", feed);
        if (emojiConfig != null && (lottieUrl = emojiConfig.getLottieUrl()) != null) {
            if (lottieUrl.length() > 0) {
                LottieAnimationView lottieAnimationView2 = this.lottieView;
                if (lottieAnimationView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                } else {
                    lottieAnimationView = lottieAnimationView2;
                }
                N(lottieAnimationView, lottieUrl);
            }
        }
        K(feed, emojiId);
    }

    private final void H(String event, FeedPB$Feed feed) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_feed_id", u72.a.b(feed)));
        if (Intrinsics.areEqual(event, "dt_imp")) {
            u("em_kl_greet", mapOf);
        } else if (Intrinsics.areEqual(event, "dt_clck")) {
            s("em_kl_greet", mapOf);
        }
    }

    private final void J(String event, FeedPB$Feed feed) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_emoji_id", u72.a.b(feed)));
        if (Intrinsics.areEqual(event, "dt_imp")) {
            u("em_kl_poke_btn", mapOf);
        } else if (Intrinsics.areEqual(event, "dt_clck")) {
            s("em_kl_poke_btn", mapOf);
        }
    }

    private final void K(FeedPB$Feed feed, int emojiId) {
        PBStringField pBStringField;
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) businessHandler;
        InteractiveMsgServicePB$SendInterMsgReq interactiveMsgServicePB$SendInterMsgReq = new InteractiveMsgServicePB$SendInterMsgReq();
        interactiveMsgServicePB$SendInterMsgReq.peer_open_id.set(u72.a.g(feed));
        interactiveMsgServicePB$SendInterMsgReq.scene_id.set(1);
        interactiveMsgServicePB$SendInterMsgReq.inter_emoj_id.set(emojiId);
        InteractiveMsgServicePB$MsgInfo interactiveMsgServicePB$MsgInfo = interactiveMsgServicePB$SendInterMsgReq.msg_info;
        interactiveMsgServicePB$MsgInfo.setHasFlag(true);
        interactiveMsgServicePB$MsgInfo.feed_id.set(u72.a.b(feed));
        interactiveMsgServicePB$MsgInfo.feed_source.set(feed.feed_source.get());
        interactiveMsgServicePB$MsgInfo.content.set(u72.a.d(feed));
        FeedPB$StImage c16 = u72.a.c(feed);
        if (c16 != null && (pBStringField = c16.url) != null && (str = pBStringField.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(str, "get()");
            interactiveMsgServicePB$MsgInfo.pic.set(str);
        }
        interactiveMsgServicePB$MsgInfo.feed_owner_uid.set(u72.a.g(feed));
        aVar.Z0("QQStranger.InteractiveMsgSvr.SsoSendInterMsg", interactiveMsgServicePB$SendInterMsgReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.i
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                QQStrangerLiteActionSection.L(i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(int i3, boolean z16, Object obj) {
        QLog.d("QQStrangerLiteActionSection", 1, "[SsoSendInterMsg] isSuccess=" + z16);
        if (z16 && (obj instanceof byte[])) {
            InteractiveMsgServicePB$SendInterMsgRsp interactiveMsgServicePB$SendInterMsgRsp = new InteractiveMsgServicePB$SendInterMsgRsp();
            try {
                interactiveMsgServicePB$SendInterMsgRsp.mergeFrom((byte[]) obj);
                if (interactiveMsgServicePB$SendInterMsgRsp.rsp_head.ret_code.get() != 0) {
                    return;
                }
                QLog.i("QQStrangerLiteActionSection", 1, "[SsoSendInterMsg],msgId=" + interactiveMsgServicePB$SendInterMsgRsp.msg_id.get() + ",msgTime=" + interactiveMsgServicePB$SendInterMsgRsp.msg_time.get());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerLiteActionSection", 2, "[SsoSendInterMsg] error: ", e16);
            }
        }
    }

    private final void N(final LottieAnimationView view, String zipUrl) {
        new LottieLoader(view.getContext()).fromNetworkWithCacheBitmap(view, zipUrl);
        view.setRepeatCount(0);
        view.setVisibility(0);
        view.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.j
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void onCompositionLoaded(LottieComposition lottieComposition) {
                QQStrangerLiteActionSection.O(LottieAnimationView.this, lottieComposition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(LottieAnimationView view, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(view, "$view");
        view.setVisibility(8);
    }

    private final Drawable z(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.d(4.0f));
        gradientDrawable.setStroke(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.e(1), ContextCompat.getColorStateList(context, R.color.qui_common_border_standard));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.d(4.0f));
        gradientDrawable2.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_overlay_standard_primary));
        gradientDrawable2.setStroke(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.e(1), ContextCompat.getColorStateList(context, R.color.qui_common_border_standard));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(final FeedPB$Feed data, int position, List<Object> payload) {
        String emojiName;
        int convertToLocal;
        Intrinsics.checkNotNullParameter(data, "data");
        LottieAnimationView lottieAnimationView = null;
        if (Intrinsics.areEqual(u72.a.g(data), B())) {
            TextView textView = this.liteActionTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liteActionTv");
                textView = null;
            }
            textView.setVisibility(8);
            LottieAnimationView lottieAnimationView2 = this.lottieView;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            } else {
                lottieAnimationView = lottieAnimationView2;
            }
            lottieAnimationView.setVisibility(8);
            return;
        }
        TextView textView2 = this.liteActionTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liteActionTv");
            textView2 = null;
        }
        textView2.setVisibility(0);
        Context context = getRootView().getContext();
        final int i3 = data.emoji_id.get();
        final b.C8009b c8009b = com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a.c().d().get(Integer.valueOf(i3));
        Drawable faceDrawable = (C(u72.a.b(data)) || !com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.l.INSTANCE.a() || (convertToLocal = QQSysFaceUtil.convertToLocal(i3)) < 0) ? null : QQSysFaceUtil.getFaceDrawable(convertToLocal);
        if (faceDrawable != null) {
            this.isLiteAction = true;
            M(faceDrawable);
            TextView textView3 = this.liteActionTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liteActionTv");
                textView3 = null;
            }
            String emojiName2 = c8009b != null ? c8009b.getEmojiName() : null;
            if (emojiName2 == null || emojiName2.length() == 0) {
                emojiName = q(R.string.x2n);
            } else {
                emojiName = c8009b != null ? c8009b.getEmojiName() : null;
            }
            textView3.setText(emojiName);
            J("dt_imp", data);
        } else {
            this.isLiteAction = false;
            M(ContextCompat.getDrawable(context, R.drawable.qui_chat_testing));
            TextView textView4 = this.liteActionTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liteActionTv");
                textView4 = null;
            }
            textView4.setText(q(R.string.x2n));
            H("dt_imp", data);
        }
        TextView textView5 = this.liteActionTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liteActionTv");
            textView5 = null;
        }
        textView5.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerLiteActionSection.F(QQStrangerLiteActionSection.this, data, i3, c8009b, view);
            }
        }, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.olf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.lite_action)");
        TextView textView = (TextView) findViewById;
        this.liteActionTv = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liteActionTv");
            textView = null;
        }
        Context context = containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        textView.setBackground(z(context));
        View findViewById2 = containerView.findViewById(R.id.ols);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.lottie)");
        this.lottieView = (LottieAnimationView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.or8};
    }

    private final void M(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.e(20), com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.e(20));
        }
        TextView textView = this.liteActionTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liteActionTv");
            textView = null;
        }
        textView.setCompoundDrawablesRelative(drawable, null, null, null);
    }
}
