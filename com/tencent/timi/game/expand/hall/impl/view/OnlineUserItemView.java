package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import com.tencent.timi.game.userinfo.api.view.TimUserGameInfoView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAchievement;
import trpc.yes.common.YesUserRankingOuterClass$UserRanking;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\u0005\u00a2\u0006\u0004\b3\u00104J$\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\rR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010\u0012R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010\u0019R\u0016\u0010\b\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserItemView;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "", "isAnchor", "", com.tencent.luggage.wxa.c8.c.G, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", "", "e", "Ltrpc/yes/common/YesUserRankingOuterClass$UserRanking;", "userRanking", "Lkotlin/Function1;", "cb", "g", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "rankingTv", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "avatarIv", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "decorateIv", "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", tl.h.F, "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", "nickTv", "Lcom/tencent/timi/game/userinfo/api/view/TimUserGameInfoView;", "i", "Lcom/tencent/timi/game/userinfo/api/view/TimUserGameInfoView;", "gameInfoView", "Lcom/tencent/timi/game/widget/MediumBoldTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/widget/MediumBoldTextView;", "anchorTv", BdhLogUtil.LogTag.Tag_Conn, "scoreTv", "D", "sexIv", "", "E", "J", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class OnlineUserItemView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView scoreTv;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView sexIv;

    /* renamed from: E, reason: from kotlin metadata */
    private long uid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView rankingTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AvatarRoundImageView avatarIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView decorateIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AvatarTextView nickTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TimUserGameInfoView gameInfoView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MediumBoldTextView anchorTv;

    public /* synthetic */ OnlineUserItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void e(View view, final boolean z16, int i3, final CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        String valueOf = String.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(bVar, "getService(IReportService::class.java)");
        b.a.a(bVar, view, false, valueOf, "em_yes_online_panel_user_area", null, 18, null);
        VideoReport.setEventDynamicParams(view, new IDynamicParams() { // from class: com.tencent.timi.game.expand.hall.impl.view.af
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map f16;
                f16 = OnlineUserItemView.f(CommonOuterClass$QQUserId.this, z16, str);
                return f16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map f(CommonOuterClass$QQUserId uid, boolean z16, String str) {
        Map mutableMapOf;
        List<YesGameInfoOuterClass$YesGameRoleAchievement> b16;
        boolean z17;
        Intrinsics.checkNotNullParameter(uid, "$uid");
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 == null) {
            return new LinkedHashMap();
        }
        bo4.c g16 = jo4.g.f410756a.g(uid.uid.get(), I0.o1());
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            sb5.append("9999");
        }
        if (g16 != null && (b16 = g16.b()) != null) {
            int i3 = 0;
            for (Object obj : b16) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                YesGameInfoOuterClass$YesGameRoleAchievement yesGameInfoOuterClass$YesGameRoleAchievement = (YesGameInfoOuterClass$YesGameRoleAchievement) obj;
                if (sb5.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    sb5.append(",");
                }
                sb5.append(yesGameInfoOuterClass$YesGameRoleAchievement.type.get());
                i3 = i16;
            }
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("yes_to_uid", String.valueOf(uid.uid.get())), TuplesKt.to("yes_to_yes_uid", nn4.a.a(uid.yes_uid.get())), TuplesKt.to("yes_user_tag_id", sb5.toString()));
        th4.h.a();
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 cb5, CommonOuterClass$QQUserId tmpUid, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullExpressionValue(tmpUid, "tmpUid");
        cb5.invoke(tmpUid);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void g(@NotNull YesUserRankingOuterClass$UserRanking userRanking, int pos, @NotNull final Function1<? super CommonOuterClass$QQUserId, Unit> cb5) {
        int parseColor;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(userRanking, "userRanking");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AvatarRoundImageView avatarRoundImageView = this.avatarIv;
        AvatarRoundImageView avatarRoundImageView2 = null;
        if (avatarRoundImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
            avatarRoundImageView = null;
        }
        avatarRoundImageView.setUserId(userRanking.UInfo.get());
        String str = userRanking.Score.get();
        int i17 = userRanking.RIdx.get();
        final CommonOuterClass$QQUserId tmpUid = userRanking.UInfo.get();
        if (Intrinsics.areEqual(str, "0")) {
            TextView textView = this.rankingTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankingTv");
                textView = null;
            }
            textView.setText("-");
            TextView textView2 = this.rankingTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankingTv");
                textView2 = null;
            }
            textView2.setTextColor(Color.parseColor("#BCBCC2"));
        } else {
            TextView textView3 = this.rankingTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankingTv");
                textView3 = null;
            }
            textView3.setText(String.valueOf(i17));
            TextView textView4 = this.rankingTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankingTv");
                textView4 = null;
            }
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        parseColor = Color.parseColor("#BCBCC2");
                    } else {
                        ImageView imageView = this.decorateIv;
                        if (imageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("decorateIv");
                            imageView = null;
                        }
                        imageView.setImageResource(R.drawable.o9v);
                        parseColor = Color.parseColor("#FF9900");
                    }
                } else {
                    ImageView imageView2 = this.decorateIv;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("decorateIv");
                        imageView2 = null;
                    }
                    imageView2.setImageResource(R.drawable.o9u);
                    parseColor = Color.parseColor("#A7AFDF");
                }
            } else {
                ImageView imageView3 = this.decorateIv;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("decorateIv");
                    imageView3 = null;
                }
                imageView3.setImageResource(R.drawable.o9t);
                parseColor = Color.parseColor("#FF9900");
            }
            textView4.setTextColor(parseColor);
        }
        AvatarTextView avatarTextView = this.nickTv;
        if (avatarTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickTv");
            avatarTextView = null;
        }
        avatarTextView.setUserId(tmpUid);
        TextView textView5 = this.scoreTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreTv");
            textView5 = null;
        }
        textView5.setText(userRanking.Score.get());
        TimUserGameInfoView timUserGameInfoView = this.gameInfoView;
        if (timUserGameInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameInfoView");
            timUserGameInfoView = null;
        }
        Intrinsics.checkNotNullExpressionValue(tmpUid, "tmpUid");
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null) {
            i3 = I0.o1();
        } else {
            i3 = -1;
        }
        timUserGameInfoView.setUserId(tmpUid, i3);
        ImageView imageView4 = this.decorateIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorateIv");
            imageView4 = null;
        }
        if (userRanking.RIdx.get() > 3 && !Intrinsics.areEqual(str, "0")) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        imageView4.setVisibility(i16);
        this.uid = userRanking.UInfo.uid.get();
        bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = tmpUid.get();
        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "tmpUid.get()");
        dVar.I3(commonOuterClass$QQUserId, new a(tmpUid));
        gh4.e I02 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I02 != null) {
            List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> speakingPosList = ((fm4.g) mm4.b.b(fm4.g.class)).K0(I02.ue()).n();
            Intrinsics.checkNotNullExpressionValue(speakingPosList, "speakingPosList");
            Iterator<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> it = speakingPosList.iterator();
            while (it.hasNext() && !ll4.b.a(it.next().user_id, tmpUid)) {
            }
            MediumBoldTextView mediumBoldTextView = this.anchorTv;
            if (mediumBoldTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anchorTv");
                mediumBoldTextView = null;
            }
            mediumBoldTextView.setVisibility(8);
            ImageView imageView5 = this.sexIv;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sexIv");
                imageView5 = null;
            }
            imageView5.setVisibility(0);
            e(this, false, pos, tmpUid);
            AvatarRoundImageView avatarRoundImageView3 = this.avatarIv;
            if (avatarRoundImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
                avatarRoundImageView3 = null;
            }
            e(avatarRoundImageView3, false, pos, tmpUid);
        }
        AvatarRoundImageView avatarRoundImageView4 = this.avatarIv;
        if (avatarRoundImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
        } else {
            avatarRoundImageView2 = avatarRoundImageView4;
        }
        avatarRoundImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineUserItemView.h(Function1.this, tmpUid, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineUserItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        TextView textView = new TextView(getContext());
        this.rankingTv = textView;
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        textView.setTextSize(1, 21.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.leftMargin = fh4.b.b(16);
        Unit unit = Unit.INSTANCE;
        addView(textView, layoutParams);
        FrameLayout frameLayout = new FrameLayout(getContext());
        AvatarRoundImageView avatarRoundImageView = new AvatarRoundImageView(frameLayout.getContext());
        this.avatarIv = avatarRoundImageView;
        avatarRoundImageView.setNeedDrawSex(false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(fh4.b.b(42), fh4.b.b(42));
        layoutParams2.leftMargin = fh4.b.b(3);
        layoutParams2.gravity = 16;
        frameLayout.addView(avatarRoundImageView, layoutParams2);
        ImageView imageView = new ImageView(frameLayout.getContext());
        this.decorateIv = imageView;
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(fh4.b.b(48), fh4.b.b(62));
        layoutParams3.leftMargin = fh4.b.b(37);
        layoutParams3.gravity = 16;
        addView(frameLayout, layoutParams3);
        ImageView imageView2 = new ImageView(getContext());
        this.sexIv = imageView2;
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(fh4.b.b(16), fh4.b.b(16));
        layoutParams4.leftMargin = fh4.b.b(66);
        layoutParams4.topMargin = fh4.b.b(37);
        addView(imageView2, layoutParams4);
        MediumBoldTextView mediumBoldTextView = new MediumBoldTextView(getContext());
        this.anchorTv = mediumBoldTextView;
        mediumBoldTextView.setText("\u4e3b\u6301\u4eba");
        mediumBoldTextView.setIncludeFontPadding(false);
        mediumBoldTextView.setSingleLine();
        mediumBoldTextView.setGravity(17);
        mediumBoldTextView.setTextSize(1, 8.0f);
        mediumBoldTextView.setTextColor(Color.parseColor("#FFFFFF"));
        mediumBoldTextView.setBackgroundResource(R.drawable.lso);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(fh4.b.b(28), fh4.b.b(13));
        layoutParams5.leftMargin = fh4.b.b(47);
        layoutParams5.bottomMargin = fh4.b.b(8);
        layoutParams5.gravity = 80;
        addView(mediumBoldTextView, layoutParams5);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        AvatarTextView avatarTextView = new AvatarTextView(linearLayout.getContext());
        this.nickTv = avatarTextView;
        avatarTextView.setIncludeFontPadding(false);
        avatarTextView.setSingleLine();
        avatarTextView.setTextSize(1, 14.0f);
        avatarTextView.setTextColor(Color.parseColor("#000000"));
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 16;
        linearLayout.addView(avatarTextView, layoutParams6);
        Context context = linearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TimUserGameInfoView timUserGameInfoView = new TimUserGameInfoView(context);
        this.gameInfoView = timUserGameInfoView;
        timUserGameInfoView.setRoleTextColor(Color.parseColor("#7D7D7D"));
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = 16;
        layoutParams7.leftMargin = fh4.b.b(4);
        linearLayout.addView(timUserGameInfoView, layoutParams7);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams8.gravity = 16;
        layoutParams8.leftMargin = fh4.b.b(93);
        addView(linearLayout, layoutParams8);
        TextView textView2 = new TextView(getContext());
        this.scoreTv = textView2;
        textView2.setIncludeFontPadding(false);
        textView2.setSingleLine();
        textView2.setTextSize(1, 14.0f);
        textView2.setTextColor(Color.parseColor("#000000"));
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams9.gravity = 21;
        layoutParams9.rightMargin = fh4.b.b(16);
        addView(textView2, layoutParams9);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/expand/hall/impl/view/OnlineUserItemView$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<IUserInfo> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f376994b;

        a(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            this.f376994b = commonOuterClass$QQUserId;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            boolean z16;
            int i3;
            if (result != null) {
                z16 = result.k(OnlineUserItemView.this.uid);
            } else {
                z16 = false;
            }
            if (result != null && z16) {
                ImageView imageView = OnlineUserItemView.this.sexIv;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sexIv");
                    imageView = null;
                }
                if (Intrinsics.areEqual(result.m(this.f376994b), "\u5973")) {
                    i3 = R.drawable.ovs;
                } else {
                    i3 = R.drawable.ovt;
                }
                imageView.setImageResource(i3);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
        }
    }
}
