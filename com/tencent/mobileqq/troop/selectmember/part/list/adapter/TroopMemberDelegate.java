package com.tencent.mobileqq.troop.selectmember.part.list.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0002J&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J.\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000fH\u0014R\u0014\u0010\u001d\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001cR\u001b\u0010\"\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/list/adapter/TroopMemberDelegate;", "Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "Lcom/tencent/mobileqq/troop/selectmember/part/list/adapter/TroopMemberDelegate$a;", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "itemData", "holder", "", "l", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", DomainData.DOMAIN_NAME, "member", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "t", "data", "", "payloads", "r", "Z", "isEnableVipGoldName", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "p", "()I", "vipGoldNameColor", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopMemberDelegate extends AbsTroopSelectMemberDelegate<com.tencent.mobileqq.troop.selectmember.bean.a, a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy vipGoldNameColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnableVipGoldName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020)\u00a2\u0006\u0004\b0\u00101R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/list/adapter/TroopMemberDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "E", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "checkBox", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "l", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/ImageView;", "robotMark", "Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", "H", "Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", "memberLevel2", "I", "p", "memberLevel", "Lcom/tencent/mobileqq/troop/honor/widget/TroopHonorView;", "J", "Lcom/tencent/mobileqq/troop/honor/widget/TroopHonorView;", "o", "()Lcom/tencent/mobileqq/troop/honor/widget/TroopHonorView;", "honorView", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "r", "()Landroid/widget/TextView;", "name", "Landroid/view/View;", "L", "Landroid/view/View;", "getDisableCover", "()Landroid/view/View;", "disableCover", "convertView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QUICheckBox checkBox;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final QQProAvatarView avatar;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView robotMark;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TroopMemberNewLevelView memberLevel2;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TroopMemberNewLevelView memberLevel;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TroopHonorView honorView;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final TextView name;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final View disableCover;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View convertView) {
            super(convertView);
            Intrinsics.checkNotNullParameter(convertView, "convertView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) convertView);
                return;
            }
            View findViewById = convertView.findViewById(R.id.axa);
            Intrinsics.checkNotNullExpressionValue(findViewById, "convertView.findViewById(R.id.checkbox)");
            this.checkBox = (QUICheckBox) findViewById;
            View findViewById2 = convertView.findViewById(R.id.a2o);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "convertView.findViewById(R.id.avatar)");
            this.avatar = (QQProAvatarView) findViewById2;
            View findViewById3 = convertView.findViewById(R.id.f7698435);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "convertView.findViewById(R.id.robot_mark)");
            this.robotMark = (ImageView) findViewById3;
            View findViewById4 = convertView.findViewById(R.id.f102625ye);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "convertView.findViewById\u2026.troop_member_new_level2)");
            this.memberLevel2 = (TroopMemberNewLevelView) findViewById4;
            View findViewById5 = convertView.findViewById(R.id.f102615yd);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "convertView.findViewById\u2026d.troop_member_new_level)");
            this.memberLevel = (TroopMemberNewLevelView) findViewById5;
            View findViewById6 = convertView.findViewById(R.id.mbo);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "convertView.findViewById(R.id.troop_honor_view)");
            this.honorView = (TroopHonorView) findViewById6;
            View findViewById7 = convertView.findViewById(R.id.f5e);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "convertView.findViewById(R.id.name)");
            this.name = (TextView) findViewById7;
            View findViewById8 = convertView.findViewById(R.id.bll);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "convertView.findViewById(R.id.disable_cover)");
            this.disableCover = findViewById8;
        }

        @NotNull
        public final QQProAvatarView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QQProAvatarView) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.avatar;
        }

        @NotNull
        public final QUICheckBox m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QUICheckBox) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.checkBox;
        }

        @NotNull
        public final TroopHonorView o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (TroopHonorView) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.honorView;
        }

        @NotNull
        public final TroopMemberNewLevelView p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (TroopMemberNewLevelView) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.memberLevel;
        }

        @NotNull
        public final TroopMemberNewLevelView q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (TroopMemberNewLevelView) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.memberLevel2;
        }

        @NotNull
        public final TextView r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (TextView) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.name;
        }

        @NotNull
        public final ImageView s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.robotMark;
        }
    }

    public TroopMemberDelegate() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isEnableVipGoldName = ar.INSTANCE.b("linkliang", "2024-03-13", "vas_color_name_gold_9030").isEnable(false);
        lazy = LazyKt__LazyJVMKt.lazy(TroopMemberDelegate$vipGoldNameColor$2.INSTANCE);
        this.vipGoldNameColor = lazy;
    }

    private final void l(com.tencent.mobileqq.troop.selectmember.bean.c itemData, a holder) {
        boolean z16;
        List<com.tencent.mobileqq.troop.selectmember.bean.c> value;
        TroopSelectMemberConfig d16 = d();
        boolean z17 = true;
        if (d16 != null && d16.r()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            holder.m().setVisibility(8);
            return;
        }
        holder.m().setVisibility(0);
        if (itemData.b()) {
            holder.m().setEnabled(true);
            QUICheckBox m3 = holder.m();
            LiveData<List<com.tencent.mobileqq.troop.selectmember.bean.c>> f16 = f();
            if (f16 == null || (value = f16.getValue()) == null || !value.contains(itemData)) {
                z17 = false;
            }
            m3.setChecked(z17);
            return;
        }
        holder.m().setChecked(false);
        holder.m().setEnabled(false);
    }

    private final void m(a holder, TroopMemberInfo member) {
        boolean z16;
        ITroopHonorService iTroopHonorService = (ITroopHonorService) bg.l(ITroopHonorService.class);
        if (iTroopHonorService != null && iTroopHonorService.isSupportTroopHonor(member.troopuin)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            List<com.tencent.mobileqq.troop.honor.config.a> convertToHonorList = iTroopHonorService.convertToHonorList(member.honorList, Byte.valueOf(member.mHonorRichFlag));
            if (convertToHonorList != null && convertToHonorList.size() > 0) {
                holder.o().setHonorList(convertToHonorList.subList(0, 1), 2);
                holder.o().setVisibility(0);
                return;
            } else {
                holder.o().setHonorList(null);
                holder.o().setVisibility(8);
                return;
            }
        }
        holder.o().setHonorList(null);
        holder.o().setVisibility(8);
    }

    private final void n(a holder, TroopMemberInfo itemData) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        TroopSelectMemberConfig d16 = d();
        if (d16 != null && d16.l()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            holder.p().setVisibility(8);
            holder.q().setVisibility(8);
            return;
        }
        com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(b(), itemData);
        if (troopMemberRankItem != null) {
            holder.p().setTroopMemberNewLevel(troopMemberRankItem);
        }
        TroopInfo b16 = b();
        if (b16 != null && b16.isHomeworkTroop()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            holder.q().setVisibility(8);
            TroopInfo b17 = b();
            if (b17 != null && b17.isTroopOwner(itemData.memberuin)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                com.tencent.mobileqq.troop.troopmemberlevel.a aVar = new com.tencent.mobileqq.troop.troopmemberlevel.a();
                aVar.f300596g = true;
                aVar.f300595f = false;
                aVar.f300590a = 300;
                aVar.f300593d = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(aVar.f300590a);
                aVar.f300597h = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColor(aVar.f300590a);
                aVar.f300592c = HardCodeUtil.qqStr(R.string.upl);
                holder.q().setTroopMemberNewLevel(aVar);
                return;
            }
            TroopInfo b18 = b();
            if (b18 != null && b18.isTroopAdmin(itemData.memberuin)) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                com.tencent.mobileqq.troop.troopmemberlevel.a aVar2 = new com.tencent.mobileqq.troop.troopmemberlevel.a();
                aVar2.f300596g = true;
                aVar2.f300595f = false;
                aVar2.f300590a = 301;
                aVar2.f300593d = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(aVar2.f300590a);
                aVar2.f300597h = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColor(aVar2.f300590a);
                aVar2.f300592c = HardCodeUtil.qqStr(R.string.upa);
                holder.q().setTroopMemberNewLevel(aVar2);
            }
        }
    }

    private final void o(a holder, TroopMemberInfo member) {
        int color;
        int vipTypeByFlag;
        Resources resources = holder.itemView.getResources();
        TroopSelectMemberConfig d16 = d();
        boolean z16 = false;
        if (d16 != null && !d16.n()) {
            z16 = true;
        }
        if (z16) {
            holder.r().setTextColor(resources.getColor(R.color.qui_common_text_primary));
            return;
        }
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        boolean useDefaultNickColor = IVipDataUtils.INSTANCE.a().getVipDataForFriends(member.memberuin).getUseDefaultNickColor();
        if (!simpleUISwitch && !useDefaultNickColor) {
            if (this.isEnableVipGoldName) {
                color = p();
            } else {
                color = resources.getColor(R.color.skin_red_theme_version2);
            }
            if (((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getBigClubFlag(member.mBigClubVipType) == 0 && (vipTypeByFlag = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getVipTypeByFlag(member.mVipType)) != 1 && vipTypeByFlag != 2 && vipTypeByFlag != 3 && vipTypeByFlag != 4) {
                color = resources.getColor(R.color.qui_common_text_primary);
            }
            holder.r().setTextColor(color);
            return;
        }
        holder.r().setTextColor(resources.getColor(R.color.qui_common_text_primary));
    }

    private final int p() {
        return ((Number) this.vipGoldNameColor.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(TroopMemberDelegate this$0, com.tencent.mobileqq.troop.selectmember.bean.c itemData, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        AbsTroopSelectMemberDelegate.a c16 = this$0.c();
        if (c16 != null) {
            c16.l6(itemData, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a item, @NotNull List<com.tencent.mobileqq.troop.selectmember.bean.a> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if ((item instanceof com.tencent.mobileqq.troop.selectmember.bean.c) && (item.getItemData() instanceof TroopMemberInfo)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a data, @NotNull a holder, final int position, @NotNull List<Object> payloads) {
        TroopMemberInfo troopMemberInfo;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        final com.tencent.mobileqq.troop.selectmember.bean.c cVar = (com.tencent.mobileqq.troop.selectmember.bean.c) data;
        Object itemData = cVar.getItemData();
        if (itemData instanceof TroopMemberInfo) {
            troopMemberInfo = (TroopMemberInfo) itemData;
        } else {
            troopMemberInfo = null;
        }
        if (troopMemberInfo == null) {
            return;
        }
        l(cVar, holder);
        holder.l().x(1, troopMemberInfo.memberuin, null);
        holder.r().setText(troopMemberInfo.nickInfo.getShowName());
        o(holder, troopMemberInfo);
        m(holder, troopMemberInfo);
        ImageView s16 = holder.s();
        ITroopRobotService e16 = e();
        if (e16 != null && e16.isRobotUin(troopMemberInfo.memberuin)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            s16.setVisibility(0);
        } else {
            s16.setVisibility(8);
        }
        n(holder, troopMemberInfo);
        if (cVar.b()) {
            holder.itemView.setEnabled(true);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.selectmember.part.list.adapter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopMemberDelegate.s(TroopMemberDelegate.this, cVar, position, view);
                }
            });
        } else {
            holder.itemView.setOnClickListener(null);
            holder.itemView.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i0w, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new a(itemView);
    }
}
