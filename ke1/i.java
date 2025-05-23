package ke1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GameMsgPartner;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GetGameMsgPartnersRsp;
import com.tencent.mobileqq.gamecenter.ui.GameCenterHorizontalScrollView;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0002*-B\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J*\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J*\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\"\u001a\u00020\u000b2\n\u0010!\u001a\u00060 R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010$2\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0002J.\u0010&\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\n\u0010!\u001a\u00060 R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010'\u001a\u00020\u000bJ\u0016\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tR\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0014\u00103\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0014\u00107\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010.R\u0018\u0010:\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R&\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u00140;j\b\u0012\u0004\u0012\u00020\u0014`<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010=R&\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00140;j\b\u0012\u0004\u0012\u00020\u0014`<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010=\u00a8\u0006B"}, d2 = {"Lke1/i;", "", "Landroid/content/Context;", "context", "", "layoutResId", "Landroid/view/ViewGroup;", DomainData.DOMAIN_NAME, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/SgamePartnerSvr$GetGameMsgPartnersRsp;", "cardInfo", "", "y", "B", "scrollX", "i", "position", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/SgamePartnerSvr$GameMsgPartner;", "data", "o", "", "operId", "operType", "t", "tagText", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "partnerData", "fromOpenId", "j", HippyTKDListViewAdapter.X, "Lke1/i$a;", "holder", tl.h.F, "url", "Lcom/tencent/image/URLDrawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "p", "k", "", "a", "Z", "isScrolling", "b", "I", "screenWidth", "c", "cardItemWidth", "d", "cardItemHeight", "e", "cardItemMargin", "f", "cardsContainerPadding", "g", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/SgamePartnerSvr$GetGameMsgPartnersRsp;", "gameCardInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "reportedCardUserIds", "waitReportCardUserIds", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isScrolling;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int screenWidth = ViewUtils.getScreenWidth();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int cardItemWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int cardItemHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int cardItemMargin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int cardsContainerPadding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SgamePartnerSvr$GetGameMsgPartnersRsp gameCardInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> reportedCardUserIds;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> waitReportCardUserIds;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u0003\u0010\u001bR\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u0013\u0010\u001f\u00a8\u0006$"}, d2 = {"Lke1/i$a;", "", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "c", "()Landroid/view/ViewGroup;", "setItemView", "(Landroid/view/ViewGroup;)V", "itemView", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "g", "()Landroid/widget/TextView;", "titleView", "f", "subtitleView", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "genderImage", "e", "rankImage", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarView", "Landroid/widget/Button;", "Landroid/widget/Button;", "()Landroid/widget/Button;", "jumpButton", "view", "<init>", "(Lke1/i;Landroid/view/ViewGroup;)V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ViewGroup itemView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextView titleView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextView subtitleView;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView genderImage;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView rankImage;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final QQProAvatarView avatarView;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Button jumpButton;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ i f412120h;

        public a(@NotNull i iVar, ViewGroup view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f412120h = iVar;
            this.itemView = view;
            View findViewById = view.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
            this.titleView = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.j7y);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.subtitle)");
            this.subtitleView = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.csn);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.gender)");
            this.genderImage = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.f70123kl);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.rank)");
            this.rankImage = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.a2o);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.avatar)");
            this.avatarView = (QQProAvatarView) findViewById5;
            View findViewById6 = view.findViewById(R.id.yao);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.jump)");
            this.jumpButton = (Button) findViewById6;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final QQProAvatarView getAvatarView() {
            return this.avatarView;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final ImageView getGenderImage() {
            return this.genderImage;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final ViewGroup getItemView() {
            return this.itemView;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final Button getJumpButton() {
            return this.jumpButton;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final ImageView getRankImage() {
            return this.rankImage;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final TextView getSubtitleView() {
            return this.subtitleView;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final TextView getTitleView() {
            return this.titleView;
        }
    }

    public i() {
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        this.cardItemWidth = cVar.b(152);
        this.cardItemHeight = cVar.b(177);
        this.cardItemMargin = cVar.b(6);
        this.cardsContainerPadding = cVar.b(6);
        this.reportedCardUserIds = new ArrayList<>();
        this.waitReportCardUserIds = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IGameMsgCardApi) QRoute.api(IGameMsgCardApi.class)).onGameCardRemoved();
        GameCenterUnissoHandler.N2().o3(3, null);
        this$0.t("990027", "20");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void B(ViewGroup rootView) {
        GameCenterHorizontalScrollView gameCenterHorizontalScrollView = (GameCenterHorizontalScrollView) rootView.findViewById(R.id.iig);
        gameCenterHorizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: ke1.e
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i3, int i16, int i17, int i18) {
                i.C(i.this, view, i3, i16, i17, i18);
            }
        });
        gameCenterHorizontalScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: ke1.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean D;
                D = i.D(i.this, view, motionEvent);
                return D;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(i this$0, View view, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isScrolling = true;
        this$0.i(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(i this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this$0.q();
            return false;
        }
        return false;
    }

    private final void h(a holder, SgamePartnerSvr$GameMsgPartner partnerData) {
        String str;
        Integer num;
        int i3;
        String str2;
        String str3;
        boolean z16;
        String str4;
        TextView titleView = holder.getTitleView();
        PBStringField pBStringField = partnerData.nick;
        String str5 = "";
        if (pBStringField == null || (str = pBStringField.get()) == null) {
            str = "";
        }
        titleView.setText(str);
        TextView subtitleView = holder.getSubtitleView();
        PBStringField pBStringField2 = partnerData.rec_tags_text;
        if (pBStringField2 != null && (str4 = pBStringField2.get()) != null) {
            str5 = str4;
        }
        subtitleView.setText(str5);
        ImageView genderImage = holder.getGenderImage();
        PBInt32Field pBInt32Field = partnerData.gender;
        if (pBInt32Field != null) {
            num = Integer.valueOf(pBInt32Field.get());
        } else {
            num = null;
        }
        boolean z17 = true;
        if (num != null && num.intValue() == 1) {
            i3 = R.drawable.mur;
        } else {
            i3 = R.drawable.muq;
        }
        genderImage.setImageResource(i3);
        PBStringField pBStringField3 = partnerData.avatar;
        if (pBStringField3 != null && (str3 = pBStringField3.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(str3, "get()");
            if (str3.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                str3 = null;
            }
            if (str3 != null) {
                QQProAvatarView avatarView = holder.getAvatarView();
                QQProAvatarView.setEnableFrame$default(avatarView, 0, 0, 2, null);
                avatarView.B(str3);
            }
        }
        PBStringField pBStringField4 = partnerData.rank_pic;
        if (pBStringField4 != null && (str2 = pBStringField4.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(str2, "get()");
            if (str2.length() <= 0) {
                z17 = false;
            }
            if (z17) {
                holder.getRankImage().setImageDrawable(m(str2));
                holder.getRankImage().setVisibility(0);
            } else {
                holder.getRankImage().setVisibility(8);
            }
        }
    }

    private final void i(int scrollX) {
        PBRepeatMessageField<SgamePartnerSvr$GameMsgPartner> pBRepeatMessageField;
        List<SgamePartnerSvr$GameMsgPartner> list;
        int coerceAtLeast;
        int coerceAtMost;
        SgamePartnerSvr$GetGameMsgPartnersRsp sgamePartnerSvr$GetGameMsgPartnersRsp = this.gameCardInfo;
        if (sgamePartnerSvr$GetGameMsgPartnersRsp != null && (pBRepeatMessageField = sgamePartnerSvr$GetGameMsgPartnersRsp.partners) != null && (list = pBRepeatMessageField.get()) != null) {
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                SgamePartnerSvr$GameMsgPartner value = (SgamePartnerSvr$GameMsgPartner) obj;
                int i17 = this.cardsContainerPadding;
                int i18 = this.cardItemMargin;
                int i19 = this.cardItemWidth;
                int i26 = ((i17 + i18) + (((i18 * 2) + i19) * i3)) - scrollX;
                int i27 = i19 + i26;
                if (i26 < this.screenWidth && i27 > 0) {
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i26, 0);
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(i27, this.screenWidth);
                    if ((coerceAtMost - coerceAtLeast) / this.cardItemWidth >= 0.7d) {
                        Intrinsics.checkNotNullExpressionValue(value, "value");
                        o(i3, value);
                    }
                }
                i3 = i16;
            }
        }
    }

    private final ViewGroup j(Context context, int position, SgamePartnerSvr$GameMsgPartner partnerData, String fromOpenId) {
        ViewGroup n3 = n(context, R.layout.eat);
        a aVar = new a(this, n3);
        h(aVar, partnerData);
        u(position, aVar, partnerData, fromOpenId);
        return n3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        GameCenterUnissoHandler.N2().o3(2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final URLDrawable m(String url) {
        boolean z16;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        return URLDrawable.getDrawable(url, obtain);
    }

    private final ViewGroup n(Context context, int layoutResId) {
        View inflate = LayoutInflater.from(context).inflate(layoutResId, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) inflate;
    }

    private final void o(int position, SgamePartnerSvr$GameMsgPartner data) {
        String str;
        boolean z16;
        PBStringField pBStringField = data.uid;
        if (pBStringField != null && (str = pBStringField.get()) != null) {
            if (!this.reportedCardUserIds.contains(str) && !this.waitReportCardUserIds.contains(str)) {
                z16 = true;
            } else {
                z16 = false;
            }
            String str2 = null;
            if (!z16) {
                str = null;
            }
            if (str != null) {
                this.waitReportCardUserIds.add(str);
                PBStringField pBStringField2 = data.rec_tags_text;
                if (pBStringField2 != null) {
                    str2 = pBStringField2.get();
                }
                r(position, "990028", "8", str2);
            }
        }
    }

    private final void q() {
        if (this.isScrolling) {
            this.isScrolling = false;
            GameCenterUnissoHandler.N2().o3(2, null);
            s();
        }
    }

    private final void r(int position, String operId, String operType, String tagText) {
        HashMap hashMap = new HashMap();
        hashMap.put("ext3", "1");
        if (tagText == null) {
            tagText = "";
        }
        hashMap.put("ext6", tagText);
        hashMap.put("ext29", String.valueOf(position + 1));
        ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92004", operId, operType, "", hashMap);
    }

    private final void s() {
        if (this.waitReportCardUserIds.size() > 0) {
            GameCenterUnissoHandler.N2().o3(4, this.waitReportCardUserIds);
            this.reportedCardUserIds.addAll(this.waitReportCardUserIds);
            this.waitReportCardUserIds.clear();
        }
    }

    private final void t(String operId, String operType) {
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92004", operId, "", "1", operType, "");
    }

    private final void u(final int position, a holder, final SgamePartnerSvr$GameMsgPartner partnerData, final String fromOpenId) {
        holder.getJumpButton().setOnClickListener(new View.OnClickListener() { // from class: ke1.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.v(fromOpenId, partnerData, this, position, view);
            }
        });
        holder.getItemView().setOnClickListener(new View.OnClickListener() { // from class: ke1.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.w(SgamePartnerSvr$GameMsgPartner.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(String str, SgamePartnerSvr$GameMsgPartner partnerData, i this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(partnerData, "$partnerData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = null;
        GameCenterUnissoHandler.N2().o3(2, null);
        IGameMsgCardApi iGameMsgCardApi = (IGameMsgCardApi) QRoute.api(IGameMsgCardApi.class);
        PBStringField pBStringField = partnerData.openaio_id;
        if (pBStringField != null) {
            str2 = pBStringField.get();
        }
        iGameMsgCardApi.openGameMsgAioInMainProcess(str, str2);
        this$0.r(i3, "990026", "20", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(SgamePartnerSvr$GameMsgPartner partnerData, View view) {
        String str;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(partnerData, "$partnerData");
        String str2 = null;
        GameCenterUnissoHandler.N2().o3(2, null);
        PBStringField pBStringField = partnerData.profile_url;
        if (pBStringField != null && (str = pBStringField.get()) != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str2 = str;
            }
            if (str2 != null) {
                com.tencent.mobileqq.gamecenter.utils.c.o(view.getContext(), str2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x(ViewGroup rootView, SgamePartnerSvr$GetGameMsgPartnersRsp cardInfo) {
        List<SgamePartnerSvr$GameMsgPartner> list;
        String str;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.f164740to2);
        PBRepeatMessageField<SgamePartnerSvr$GameMsgPartner> pBRepeatMessageField = cardInfo.partners;
        if (pBRepeatMessageField != null && (list = pBRepeatMessageField.get()) != null) {
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                SgamePartnerSvr$GameMsgPartner value = (SgamePartnerSvr$GameMsgPartner) obj;
                Context context = linearLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "cardLayout.context");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                PBStringField pBStringField = cardInfo.openaio_id;
                if (pBStringField != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                ViewGroup j3 = j(context, i3, value, str);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cardItemWidth, this.cardItemHeight);
                int i17 = this.cardItemMargin;
                layoutParams.leftMargin = i17;
                layoutParams.rightMargin = i17;
                linearLayout.addView(j3, layoutParams);
                i3 = i16;
            }
        }
    }

    private final void y(ViewGroup rootView, final SgamePartnerSvr$GetGameMsgPartnersRsp cardInfo) {
        String str;
        boolean z16;
        ((LinearLayout) rootView.findViewById(R.id.jp7)).setOnClickListener(new View.OnClickListener() { // from class: ke1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.z(SgamePartnerSvr$GetGameMsgPartnersRsp.this, this, view);
            }
        });
        ((ImageView) rootView.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() { // from class: ke1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.A(i.this, view);
            }
        });
        PBStringField pBStringField = cardInfo.title;
        if (pBStringField != null && (str = pBStringField.get()) != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                str = null;
            }
            if (str != null) {
                ((TextView) rootView.findViewById(R.id.title)).setText(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(SgamePartnerSvr$GetGameMsgPartnersRsp cardInfo, i this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(cardInfo, "$cardInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        PBStringField pBStringField = cardInfo.partner_page_url;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        com.tencent.mobileqq.gamecenter.utils.c.o(context, str);
        GameCenterUnissoHandler.N2().o3(2, null);
        this$0.t("990029", "20");
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final ViewGroup k(@NotNull Context context, @NotNull SgamePartnerSvr$GetGameMsgPartnersRsp cardInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        this.gameCardInfo = cardInfo;
        GameCenterUnissoHandler.N2().o3(1, null);
        ViewGroup n3 = n(context, R.layout.eas);
        n3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        y(n3, cardInfo);
        x(n3, cardInfo);
        B(n3);
        i(0);
        s();
        n3.setOnClickListener(new View.OnClickListener() { // from class: ke1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.l(view);
            }
        });
        t("990025", "8");
        return n3;
    }

    public final void p() {
        this.gameCardInfo = null;
        this.reportedCardUserIds.clear();
        this.waitReportCardUserIds.clear();
    }
}
