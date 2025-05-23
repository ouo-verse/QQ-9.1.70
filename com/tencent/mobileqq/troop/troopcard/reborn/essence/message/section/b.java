package com.tencent.mobileqq.troop.troopcard.reborn.essence.message.section;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopcard.reborn.essence.ClickMsgFeedEvent;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.kernel.nativeinterface.EssenceMsgContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0016\u0010&\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/section/b;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/section/c;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "e", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "senderAvatarView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "senderNickView", h.F, "sendTimeView", "i", "arkTitle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "arkSummary", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "arkImage", "D", "arkName", "E", "Landroid/view/View;", "dividerLine", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends c<com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private RoundRectImageView arkImage;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView arkName;

    /* renamed from: E, reason: from kotlin metadata */
    private View dividerLine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView senderAvatarView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView senderNickView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView sendTimeView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView arkTitle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView arkSummary;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/section/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.essence.message.section.b$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57102);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this_apply.a().jumpUrl;
        Intrinsics.checkNotNullExpressionValue(str, "essenceMsgInfo.jumpUrl");
        simpleEventBus.dispatchEvent(new ClickMsgFeedEvent(str));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1190575t};
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
            View findViewById = containerView.findViewById(R.id.f101245uo);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.troop_avatar)");
            this.senderAvatarView = (QQProAvatarView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.f10359611);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.troop_sender_nick)");
            this.senderNickView = (TextView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.f10360612);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.troop_sender_time)");
            this.sendTimeView = (TextView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.svg);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ark_item_title)");
            this.arkTitle = (TextView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.svf);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ark_item_summary)");
            this.arkSummary = (TextView) findViewById5;
            View findViewById6 = containerView.findViewById(R.id.svd);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ark_item_image)");
            this.arkImage = (RoundRectImageView) findViewById6;
            View findViewById7 = containerView.findViewById(R.id.sve);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.ark_item_name)");
            this.arkName = (TextView) findViewById7;
            View findViewById8 = containerView.findViewById(R.id.f164999bn3);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.divider_line)");
            this.dividerLine = findViewById8;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
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
            EssenceMsgContent essenceMsgContent = data.a().msgContent.get(0);
            TextView textView3 = this.arkTitle;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arkTitle");
                textView3 = null;
            }
            textView3.setText(essenceMsgContent.shareTitle);
            TextView textView4 = this.arkName;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arkName");
                textView4 = null;
            }
            textView4.setText(essenceMsgContent.shareSource);
            TextView textView5 = this.arkSummary;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arkSummary");
                textView5 = null;
            }
            textView5.setText(essenceMsgContent.shareSummary);
            Option obtain = Option.obtain();
            RoundRectImageView roundRectImageView = this.arkImage;
            if (roundRectImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arkImage");
                roundRectImageView = null;
            }
            Option option = obtain.setTargetView(roundRectImageView).setUrl(essenceMsgContent.shareImageUrl).setRegionScaleType(ImageView.ScaleType.CENTER_CROP);
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
            RoundRectImageView roundRectImageView2 = this.arkImage;
            if (roundRectImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arkImage");
                roundRectImageView2 = null;
            }
            roundRectImageView2.setCornerRadiusAndMode(com.tencent.qqnt.base.utils.c.f353052a.a(4.0f), 1);
            View mRootView = this.mRootView;
            Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
            TriggerRunnerKt.c(mRootView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.message.section.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.t(com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a.this, view2);
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
}
