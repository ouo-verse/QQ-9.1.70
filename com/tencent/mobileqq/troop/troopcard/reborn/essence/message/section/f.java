package com.tencent.mobileqq.troop.troopcard.reborn.essence.message.section;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.troopcard.reborn.essence.ClickMsgFeedEvent;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.EssenceMsgContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J*\u0010\u001a\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00072\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010*R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/section/f;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/section/c;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/a;", "", "msg", "", "B", "", "faceIndex", "y", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/EssenceMsgContent;", "content", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/graphics/drawable/GradientDrawable;", "D", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "f", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "senderAvatarView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "senderNickView", "i", "sendTimeView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "shadowView", "dividerLine", "Landroid/text/SpannableStringBuilder;", "Landroid/text/SpannableStringBuilder;", "textMsg", "", "E", "Z", "isOverflowing", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f extends c<com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private View dividerLine;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final SpannableStringBuilder textMsg;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isOverflowing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView senderAvatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView senderNickView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView sendTimeView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View shadowView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/section/f$a;", "", "", "ITEM_MAX_HEIGHT", UserInfo.SEX_FEMALE, "PIC_MAX_HEIGHT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.essence.message.section.f$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/essence/message/section/f$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LinearLayout linearLayout = f.this.container;
                View view = null;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    linearLayout = null;
                }
                linearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int a16 = com.tencent.qqnt.base.utils.c.f353052a.a(200.0f);
                f fVar = f.this;
                LinearLayout linearLayout2 = fVar.container;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    linearLayout2 = null;
                }
                if (linearLayout2.getHeight() >= a16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                fVar.isOverflowing = z16;
                if (f.this.isOverflowing) {
                    LinearLayout linearLayout3 = f.this.container;
                    if (linearLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                        linearLayout3 = null;
                    }
                    ViewGroup.LayoutParams layoutParams = linearLayout3.getLayoutParams();
                    layoutParams.height = a16;
                    LinearLayout linearLayout4 = f.this.container;
                    if (linearLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                        linearLayout4 = null;
                    }
                    linearLayout4.setLayoutParams(layoutParams);
                    View view2 = f.this.shadowView;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
                        view2 = null;
                    }
                    view2.setVisibility(0);
                    View view3 = f.this.shadowView;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
                    } else {
                        view = view3;
                    }
                    view.setBackground(f.this.D());
                    return;
                }
                View view4 = f.this.shadowView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shadowView");
                } else {
                    view = view4;
                }
                view.setVisibility(8);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57109);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.textMsg = new SpannableStringBuilder("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(LoadState loadState, Option op5) {
        r01.c cVar;
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        Intrinsics.checkNotNullParameter(op5, "op");
        if (loadState.isFinishSuccess()) {
            Animatable animatable = op5.getAnimatable();
            if (animatable instanceof r01.c) {
                cVar = (r01.c) animatable;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.start();
            }
        }
    }

    private final void B(String msg2) {
        this.textMsg.append((CharSequence) msg2);
    }

    private final void C() {
        boolean z16;
        if (this.textMsg.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView = new TextView(this.mRootView.getContext());
            textView.setText(new QQText(this.textMsg, 16, 12));
            textView.setTextSize(14.0f);
            textView.setTextColor(ContextCompat.getColor(this.mRootView.getContext(), R.color.qui_common_text_primary));
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout = this.container;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                linearLayout = null;
            }
            linearLayout.addView(textView);
            this.textMsg.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GradientDrawable D() {
        ArrayList arrayListOf;
        int[] intArray;
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(GuildUIUtils.f235378a.E(this.mRootView.getContext().getColor(R.color.qui_common_bg_bottom_light), 0.0f)), Integer.valueOf(this.mRootView.getContext().getColor(R.color.qui_common_bg_bottom_light)));
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayListOf);
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, intArray);
        gradientDrawable.setShape(0);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this_apply.a().jumpUrl;
        Intrinsics.checkNotNullExpressionValue(str, "essenceMsgInfo.jumpUrl");
        simpleEventBus.dispatchEvent(new ClickMsgFeedEvent(str));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y(int faceIndex) {
        SpannableStringBuilder spannableStringBuilder = this.textMsg;
        QRouteApi api = QRoute.api(IEmojiSpanService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IEmojiSpanService::class.java)");
        spannableStringBuilder.append(IEmojiSpanService.a.a((IEmojiSpanService) api, 1, faceIndex, 0, true, 0, 16, null));
    }

    private final void z(EssenceMsgContent content) {
        C();
        RoundRectImageView roundRectImageView = new RoundRectImageView(this.mRootView.getContext(), null, 0, 6, null);
        roundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundRectImageView.setAdjustViewBounds(true);
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        roundRectImageView.setCornerRadiusAndMode(cVar.a(4.0f), 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, cVar.a(120.0f));
        layoutParams.gravity = 8388611;
        roundRectImageView.setLayoutParams(layoutParams);
        Option option = Option.obtain().setTargetView(roundRectImageView).setUrl(content.imageUrl).setRegionScaleType(ImageView.ScaleType.CENTER_CROP);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.message.section.e
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                f.A(loadState, option2);
            }
        });
        LinearLayout linearLayout = this.container;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            linearLayout = null;
        }
        linearLayout.addView(roundRectImageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data != null) {
            QQProAvatarView qQProAvatarView = this.senderAvatarView;
            View view = null;
            if (qQProAvatarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("senderAvatarView");
                qQProAvatarView = null;
            }
            qQProAvatarView.B(data.a().senderAvatar);
            TextView textView = this.senderNickView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("senderNickView");
                textView = null;
            }
            textView.setText(new QQText(data.a().senderNick, 1, 12));
            TextView textView2 = this.sendTimeView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendTimeView");
                textView2 = null;
            }
            textView2.setText(com.tencent.mobileqq.troop.troopcard.utils.c.f299954a.a(data.a().senderTime));
            ArrayList<EssenceMsgContent> arrayList = data.a().msgContent;
            Intrinsics.checkNotNullExpressionValue(arrayList, "this.essenceMsgInfo.msgContent");
            for (EssenceMsgContent it : arrayList) {
                if (!this.isOverflowing) {
                    int i3 = it.msgType;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                z(it);
                            }
                        } else {
                            y(it.faceIndex);
                        }
                    } else {
                        String str = it.text;
                        Intrinsics.checkNotNullExpressionValue(str, "it.text");
                        B(str);
                    }
                }
            }
            C();
            View mRootView = this.mRootView;
            Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
            TriggerRunnerKt.c(mRootView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.message.section.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    f.G(com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a.this, view2);
                }
            }, 1, null);
            if (data.b()) {
                View view2 = this.dividerLine;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dividerLine");
                } else {
                    view = view2;
                }
                view.setVisibility(8);
            }
            TroopCardDtHelper.k(p(), data.a().groupCode + "_" + data.a().msgSeq + "_" + data.a().msgRandom, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f11920768};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.troopcard.reborn.essence.message.section.c, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        super.onInitView(containerView);
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.f101735w0);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.troop_essence_msg_mix)");
            this.container = (LinearLayout) findViewById;
            View findViewById2 = containerView.findViewById(R.id.f101245uo);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.troop_avatar)");
            this.senderAvatarView = (QQProAvatarView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.f10359611);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.troop_sender_nick)");
            this.senderNickView = (TextView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.f10360612);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.troop_sender_time)");
            this.sendTimeView = (TextView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.f101755w2);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.troop_essence_msg_shadow_bg)");
            this.shadowView = findViewById5;
            View findViewById6 = containerView.findViewById(R.id.f164999bn3);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.divider_line)");
            this.dividerLine = findViewById6;
            b bVar = new b();
            LinearLayout linearLayout = this.container;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                linearLayout = null;
            }
            linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(bVar);
        }
    }
}
