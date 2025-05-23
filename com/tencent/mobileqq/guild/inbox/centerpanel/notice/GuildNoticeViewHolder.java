package com.tencent.mobileqq.guild.inbox.centerpanel.notice;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.inbox.centerpanel.GuildNoticeUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.menu.BaseMenuEntry;
import com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\u00020\u0001:\u0001GB\u0017\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010%\u001a\u00020\"\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J(\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0016\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0016\u0010!\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010/R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010/R\u0016\u00102\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010/R\u0016\u00103\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010/R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00105R\u0016\u00108\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010<\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0017\u0010A\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b7\u0010@\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/GuildNoticeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "", "H", "", "guildId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "block", "K", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", UinConfigManager.KEY_ADS, "", "tipStr", "D", "Lcom/tencent/mobileqq/qqguildsdk/data/co$c;", "jumpData", "Landroid/text/SpannableStringBuilder;", TtmlNode.TAG_SPAN, "", "hasImage", "imagePos", "I", "guildNotice", "v", "Lkotlin/Function0;", NodeProps.ON_CLICK, "Landroid/text/style/ClickableSpan;", "L", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "J", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/y;", "E", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/y;", "mCallback", "Lcom/tencent/qqnt/widget/SwipeMenuLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/widget/SwipeMenuLayout;", "mSwipeMenuLayout", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mCover", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTitle", "mTime", "mSubTitle", "mComment", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mAgreeBtn", "M", "mRefuseBtn", "N", "mDealBtn", "P", "mJumpBtn", "Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper;", "()Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper;", "mSwipeMenuHelper", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/y;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNoticeViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final y mCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private SwipeMenuLayout mSwipeMenuLayout;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ImageView mCover;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private TextView mTitle;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private TextView mTime;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private TextView mSubTitle;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private TextView mComment;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private QUIButton mAgreeBtn;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private QUIButton mRefuseBtn;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private QUIButton mDealBtn;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private QUIButton mJumpBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final GuildSwipeMenuItemHelper mSwipeMenuHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/notice/GuildNoticeViewHolder$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f226175d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildNoticeViewHolder f226176e;

        b(Function0<Unit> function0, GuildNoticeViewHolder guildNoticeViewHolder) {
            this.f226175d = function0;
            this.f226176e = guildNoticeViewHolder;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Function0<Unit> function0 = this.f226175d;
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                function0.invoke();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(this.f226176e.mComment.getContext().getColor(R.color.qui_common_text_link));
            ds5.setUnderlineText(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildNoticeViewHolder(@NotNull View itemView, @NotNull y mCallback) {
        super(itemView);
        List<? extends BaseMenuEntry> listOf;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(mCallback, "mCallback");
        this.mCallback = mCallback;
        View findViewById = itemView.findViewById(R.id.f9108548);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.swipe_menu_layout)");
        this.mSwipeMenuLayout = (SwipeMenuLayout) findViewById;
        View findViewById2 = itemView.findViewById(R.id.zsz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.notice_cover)");
        this.mCover = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.h4o);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.notice_title)");
        this.mTitle = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.zto);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.notice_time)");
        this.mTime = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.ztm);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.notice_subtitle)");
        this.mSubTitle = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.zsu);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.notice_comment)");
        this.mComment = (TextView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.zss);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.notice_agree)");
        this.mAgreeBtn = (QUIButton) findViewById7;
        View findViewById8 = itemView.findViewById(R.id.ztk);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.notice_refuse)");
        this.mRefuseBtn = (QUIButton) findViewById8;
        View findViewById9 = itemView.findViewById(R.id.f166426zt0);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.notice_deal)");
        this.mDealBtn = (QUIButton) findViewById9;
        View findViewById10 = itemView.findViewById(R.id.ztc);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.id.notice_jump_btn)");
        this.mJumpBtn = (QUIButton) findViewById10;
        GuildSwipeMenuItemHelper guildSwipeMenuItemHelper = new GuildSwipeMenuItemHelper(this.mSwipeMenuLayout, null, 2, 0 == true ? 1 : 0);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new BaseMenuEntry.b(null));
        guildSwipeMenuItemHelper.n(listOf);
        this.mSwipeMenuHelper = guildSwipeMenuItemHelper;
    }

    private final void A(co guildNotice) {
        Map emptyMap;
        final String str;
        List<co.d> list = guildNotice.f265904t;
        if (list == null) {
            this.mJumpBtn.setVisibility(8);
            Logger.f235387a.d().d("Guild.C2C.GuildNoticeViewHolder", 1, "[bindJumpButton] jumpButtonList is null");
            return;
        }
        if (!list.isEmpty()) {
            co.d dVar = list.get(0);
            if (dVar == null) {
                this.mJumpBtn.setVisibility(8);
                Logger.f235387a.d().d("Guild.C2C.GuildNoticeViewHolder", 1, "[bindJumpButton] jumpButton is null");
                return;
            }
            QUIButton qUIButton = this.mJumpBtn;
            emptyMap = MapsKt__MapsKt.emptyMap();
            ch.W0(qUIButton, "em_sgrp_realname_authentication", emptyMap);
            VideoReport.setElementReuseIdentifier(this.mJumpBtn, String.valueOf(guildNotice.f265885a));
            this.mJumpBtn.setVisibility(0);
            co.e eVar = dVar.f265916a;
            if (eVar != null) {
                this.mJumpBtn.setText(eVar.f265918a);
                if (2 == eVar.f265919b) {
                    this.mJumpBtn.setType(0);
                } else {
                    this.mJumpBtn.setType(2);
                }
            }
            co.g gVar = dVar.f265917b;
            if (gVar != null) {
                int i3 = gVar.f265921a;
                if (1 == i3) {
                    co.f fVar = gVar.f265922b;
                    if (fVar != null && (str = fVar.f265920a) != null) {
                        Intrinsics.checkNotNullExpressionValue(str, "it.paramH5?.url ?: return@let");
                        if (!TextUtils.isEmpty(str)) {
                            this.mJumpBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.l
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    GuildNoticeViewHolder.B(GuildNoticeViewHolder.this, str, view);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (5 == i3) {
                    final String str2 = gVar.f265923c;
                    if (!TextUtils.isEmpty(str2)) {
                        this.mJumpBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.m
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                GuildNoticeViewHolder.C(str2, view);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.mJumpBtn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GuildNoticeViewHolder this$0, String paramH5, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paramH5, "$paramH5");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.mCallback.b(paramH5);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        BaseApplication.getContext().startActivity(intent);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D(final co notice, final CharSequence tipStr) {
        boolean z16;
        boolean z17;
        boolean z18;
        final int coerceAtMost;
        int i3;
        boolean isBlank;
        this.mComment.setTag(notice.f265885a);
        this.mComment.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNoticeViewHolder.E(GuildNoticeViewHolder.this, notice, view);
            }
        });
        List<co.c> list = notice.f265898n;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        final co.c jumpData = notice.f265898n.get(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tipStr);
        String str = jumpData.f265914d;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z17 = false;
                if (z17 && (i3 = jumpData.f265915e) > 0 && i3 < spannableStringBuilder.length()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(jumpData.f265915e, spannableStringBuilder.length() - 1);
                final String str2 = " ";
                if (z18) {
                    spannableStringBuilder.insert(coerceAtMost, " ");
                }
                Intrinsics.checkNotNullExpressionValue(jumpData, "jumpData");
                I(jumpData, spannableStringBuilder, false, coerceAtMost);
                if (z18) {
                    return;
                }
                final Ref.IntRef intRef = new Ref.IntRef();
                DrawableDownloadHelper drawableDownloadHelper = DrawableDownloadHelper.f226160a;
                String str3 = jumpData.f265914d;
                Intrinsics.checkNotNullExpressionValue(str3, "jumpData.iconUrl");
                drawableDownloadHelper.g(str3, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.GuildNoticeViewHolder$bindLinkJump$2
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
                    public final void invoke2(@NotNull Drawable drawable) {
                        Intrinsics.checkNotNullParameter(drawable, "drawable");
                        Ref.IntRef intRef2 = Ref.IntRef.this;
                        int i16 = intRef2.element + 1;
                        intRef2.element = i16;
                        if (i16 <= 1 && Intrinsics.areEqual(this.mComment.getTag(), notice.f265885a)) {
                            Logger logger = Logger.f235387a;
                            Ref.IntRef intRef3 = Ref.IntRef.this;
                            GuildNoticeViewHolder guildNoticeViewHolder = this;
                            if (QLog.isColorLevel()) {
                                logger.d().d("Guild.C2C.GuildNoticeViewHolder", 2, "downloadCallbackTimes " + intRef3.element + " id:" + guildNoticeViewHolder.mComment.getTag());
                            }
                            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(tipStr);
                            spannableStringBuilder2.insert(coerceAtMost, (CharSequence) str2);
                            VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable);
                            int i17 = coerceAtMost;
                            spannableStringBuilder2.setSpan(verticalCenterImageSpan, i17, str2.length() + i17, 17);
                            GuildNoticeViewHolder guildNoticeViewHolder2 = this;
                            co.c jumpData2 = jumpData;
                            Intrinsics.checkNotNullExpressionValue(jumpData2, "jumpData");
                            guildNoticeViewHolder2.I(jumpData2, spannableStringBuilder2, true, coerceAtMost);
                            return;
                        }
                        Logger logger2 = Logger.f235387a;
                        Ref.IntRef intRef4 = Ref.IntRef.this;
                        GuildNoticeViewHolder guildNoticeViewHolder3 = this;
                        co coVar = notice;
                        Logger.b bVar = new Logger.b();
                        String str4 = "downloadCallbackTimes:" + intRef4.element + " tagId:" + guildNoticeViewHolder3.mComment.getTag() + " id:" + coVar.f265885a;
                        if (str4 instanceof String) {
                            bVar.a().add(str4);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("Guild.C2C.GuildNoticeViewHolder", 1, (String) it.next(), null);
                        }
                    }
                });
                return;
            }
        }
        z17 = true;
        if (z17) {
        }
        z18 = false;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(jumpData.f265915e, spannableStringBuilder.length() - 1);
        final String str22 = " ";
        if (z18) {
        }
        Intrinsics.checkNotNullExpressionValue(jumpData, "jumpData");
        I(jumpData, spannableStringBuilder, false, coerceAtMost);
        if (z18) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(GuildNoticeViewHolder this$0, co notice, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(notice, "$notice");
        this$0.mCallback.a(notice);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void H(int position) {
        GuildSwipeMenuItemHelper guildSwipeMenuItemHelper = this.mSwipeMenuHelper;
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        guildSwipeMenuItemHelper.r(itemView, position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(final co.c jumpData, SpannableStringBuilder span, boolean hasImage, int imagePos) {
        int coerceAtMost;
        int coerceAtLeast;
        int coerceAtMost2;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(jumpData.f265913c, span.length() - 1);
        ClickableSpan L = L(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.GuildNoticeViewHolder$bindSpan$webViewJumpTextClickSpan$1
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
                y yVar;
                yVar = GuildNoticeViewHolder.this.mCallback;
                String str = jumpData.f265912b;
                Intrinsics.checkNotNullExpressionValue(str, "jumpData.url");
                yVar.b(str);
            }
        });
        if (!hasImage) {
            imagePos = coerceAtMost;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(imagePos, 0);
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtMost + jumpData.f265911a.length(), span.length());
        span.setSpan(L, coerceAtLeast, coerceAtMost2, 17);
        this.mComment.setText(span);
        this.mComment.setMovementMethod(LinkMovementMethod.getInstance());
        this.mComment.setHighlightColor(0);
    }

    private final boolean J(co guildNotice) {
        Object firstOrNull;
        String str;
        boolean isBlank;
        List<co.h> list = guildNotice.f265894j;
        Intrinsics.checkNotNullExpressionValue(list, "guildNotice.comment");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        co.h hVar = (co.h) firstOrNull;
        if (hVar != null) {
            str = hVar.f265926c;
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(String guildId, Function1<? super IGProGuildInfo, Unit> block) {
        this.mCallback.d(guildId, block);
    }

    private final ClickableSpan L(Function0<Unit> onClick) {
        return new b(onClick, this);
    }

    private final void v(final co guildNotice) {
        int size = guildNotice.f265895k.size();
        if (size != 0) {
            if (size != 1) {
                if (size == 2) {
                    this.mAgreeBtn.setVisibility(0);
                    this.mRefuseBtn.setVisibility(0);
                    this.mDealBtn.setVisibility(8);
                    this.mRefuseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.o
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GuildNoticeViewHolder.x(GuildNoticeViewHolder.this, guildNotice, view);
                        }
                    });
                    this.mAgreeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.p
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GuildNoticeViewHolder.y(GuildNoticeViewHolder.this, guildNotice, view);
                        }
                    });
                    return;
                }
                return;
            }
            this.mAgreeBtn.setVisibility(8);
            this.mRefuseBtn.setVisibility(8);
            this.mDealBtn.setVisibility(0);
            this.mDealBtn.setText(guildNotice.f265895k.get(0).f265906b);
            return;
        }
        this.mAgreeBtn.setVisibility(8);
        this.mRefuseBtn.setVisibility(8);
        this.mDealBtn.setVisibility(8);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNoticeViewHolder.w(GuildNoticeViewHolder.this, guildNotice, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(GuildNoticeViewHolder this$0, co guildNotice, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildNotice, "$guildNotice");
        this$0.mCallback.a(guildNotice);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(GuildNoticeViewHolder this$0, co guildNotice, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildNotice, "$guildNotice");
        y yVar = this$0.mCallback;
        String str = guildNotice.f265885a;
        Intrinsics.checkNotNullExpressionValue(str, "guildNotice.noticeId");
        String str2 = guildNotice.f265895k.get(0).f265907c;
        Intrinsics.checkNotNullExpressionValue(str2, "guildNotice.actionList[0].actionId");
        yVar.c(str, str2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(GuildNoticeViewHolder this$0, co guildNotice, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildNotice, "$guildNotice");
        y yVar = this$0.mCallback;
        String str = guildNotice.f265885a;
        Intrinsics.checkNotNullExpressionValue(str, "guildNotice.noticeId");
        String str2 = guildNotice.f265895k.get(1).f265907c;
        Intrinsics.checkNotNullExpressionValue(str2, "guildNotice.actionList[1].actionId");
        yVar.c(str, str2);
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    /* renamed from: M, reason: from getter */
    public final GuildSwipeMenuItemHelper getMSwipeMenuHelper() {
        return this.mSwipeMenuHelper;
    }

    public final void z(@NotNull co guildNotice, int position) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(guildNotice, "guildNotice");
        GuildNoticeUtils guildNoticeUtils = GuildNoticeUtils.f226106a;
        guildNoticeUtils.l(this.mTitle, guildNotice, new GuildNoticeViewHolder$bindData$1(this));
        ImageView imageView = this.mCover;
        co.b bVar = guildNotice.f265891g;
        String str = guildNotice.f265890f;
        Intrinsics.checkNotNullExpressionValue(str, "guildNotice.guildId");
        guildNoticeUtils.j(imageView, bVar, str, new GuildNoticeViewHolder$bindData$2(this));
        this.mTime.setText(en.p(guildNotice.f265887c * 1000, true, "yy-MM-dd"));
        if (!J(guildNotice)) {
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(guildNoticeUtils.f(guildNotice, true));
            String str2 = guildNotice.f265890f;
            Intrinsics.checkNotNullExpressionValue(str2, "guildNotice.guildId");
            String d16 = GuildNoticeUtils.d(str2, guildNotice.f265903s, String.valueOf(guildNotice.f265902r));
            isBlank = StringsKt__StringsJVMKt.isBlank(d16);
            if (!isBlank) {
                this.mComment.setText(d16);
            } else {
                this.mComment.setText(guildNotice.f265894j.get(0).f265926c);
            }
        } else {
            this.mComment.setText(guildNoticeUtils.f(guildNotice, true));
            this.mSubTitle.setVisibility(8);
        }
        CharSequence text = this.mComment.getText();
        Intrinsics.checkNotNullExpressionValue(text, "mComment.text");
        D(guildNotice, text);
        v(guildNotice);
        A(guildNotice);
        H(position);
    }
}
