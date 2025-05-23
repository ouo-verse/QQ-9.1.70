package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.discoveryv2.widget.GuildLabelsView;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProOfficialMedalInfoExt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0002 #B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0015\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0004R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010@\u001a\u0002098\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010H\u001a\u00020A8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010KR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010M\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents;", "", "", DomainData.DOMAIN_NAME, "", "o", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "i", "", "guildId", "u", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGuild;", "guildInfo", "D", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "w", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", "labels", tl.h.F, "Landroid/view/View;", "containerView", "t", "elementId", "r", "", "attached", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents$b;", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents$b;", "depends", "b", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", HippyTKDListViewAdapter.X, "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "j", "()Landroid/widget/ImageView;", "y", "(Landroid/widget/ImageView;)V", "mGuildAvatar", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "B", "(Landroid/widget/TextView;)V", "mGuildName", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildLabelsView;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildLabelsView;", "l", "()Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildLabelsView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildLabelsView;)V", "mGuildDesc", "Landroid/widget/Button;", "f", "Landroid/widget/Button;", "k", "()Landroid/widget/Button;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/widget/Button;)V", "mGuildBtn", "g", "Ljava/lang/String;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGuild;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents$a$a;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents$a$a;", "gpServiceObserver", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendGuildTitleComponents {

    /* renamed from: k, reason: collision with root package name */
    private static final int f217216k = QQGuildUIUtil.f(14.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b depends;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View containerView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public ImageView mGuildAvatar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public TextView mGuildName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public GuildLabelsView mGuildDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Button mGuildBtn;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IGProContentRecommendGuild guildInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Companion.C7724a gpServiceObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents$b;", "", "Lkotlin/Pair;", "", "b", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a {
            public static boolean a(@NotNull b bVar) {
                return false;
            }
        }

        @NotNull
        Pair<String, String> b();

        boolean c();
    }

    public RecommendGuildTitleComponents(@NotNull b depends) {
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
        this.guildId = "";
        this.gpServiceObserver = new Companion.C7724a(this);
    }

    private final void C() {
        String str;
        Button k3 = k();
        IGProContentRecommendGuild iGProContentRecommendGuild = this.guildInfo;
        if (iGProContentRecommendGuild == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
            iGProContentRecommendGuild = null;
        }
        if (ch.j0(String.valueOf(iGProContentRecommendGuild.getGuildId()))) {
            str = "\u52a0\u5165";
        } else {
            str = "\u53bb\u9891\u9053";
        }
        k3.setText(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049 A[EDGE_INSN: B:12:0x0049->B:13:0x0049 BREAK  A[LOOP:0: B:4:0x0029->B:20:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:0: B:4:0x0029->B:20:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D(IGProContentRecommendGuild guildInfo) {
        CharSequence trim;
        IGProMedalInfo iGProMedalInfo;
        Object obj;
        boolean z16;
        String a16 = com.tencent.mobileqq.guild.util.az.a(guildInfo.getGuildName());
        Intrinsics.checkNotNullExpressionValue(a16, "changeEnterToSpace(guildInfo.guildName)");
        trim = StringsKt__StringsKt.trim((CharSequence) a16);
        m().setText(trim.toString());
        ArrayList<IGProMedalInfo> medals = guildInfo.getMedals();
        if (medals != null) {
            Iterator<T> it = medals.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    IGProOfficialMedalInfoExt officialMedalInfoExt = ((IGProMedalInfo) obj).getOfficialMedalInfoExt();
                    if (officialMedalInfoExt != null) {
                        z16 = true;
                        if (officialMedalInfoExt.getIsOffical()) {
                            if (!z16) {
                                break;
                            }
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            iGProMedalInfo = (IGProMedalInfo) obj;
        } else {
            iGProMedalInfo = null;
        }
        if (iGProMedalInfo == null) {
            m().setCompoundDrawablePadding(0);
            m().setCompoundDrawables(null, null, null, null);
        } else {
            com.tencent.mobileqq.guild.util.an.INSTANCE.e(new WeakReference<>(m()), new Function2<URLDrawable, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildTitleComponents$updateGuildNameAndMedal$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(URLDrawable uRLDrawable, Integer num) {
                    invoke(uRLDrawable, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull URLDrawable urlDrawable, int i3) {
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                    RecommendGuildTitleComponents.this.w(urlDrawable);
                }
            }, f217216k);
        }
    }

    private final void h(List<? extends IGProGuildLabel> labels) {
        if (labels.isEmpty()) {
            Logger.f235387a.d().w("RecommendGuildTitleComponents", 1, "guildInfo.tagList is empty, guild_id: " + this.guildId);
            l().setVisibility(8);
            return;
        }
        l().setVisibility(0);
        GuildLabelsView l3 = l();
        l3.setEmphasizeNumber(this.depends.c());
        l3.setSepHorizontalPadding((int) cw.d(2));
        l3.setLabels(labels);
    }

    private final JumpGuildParam i() {
        Pair<String, String> b16 = this.depends.b();
        IGProContentRecommendGuild iGProContentRecommendGuild = this.guildInfo;
        IGProContentRecommendGuild iGProContentRecommendGuild2 = null;
        if (iGProContentRecommendGuild == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
            iGProContentRecommendGuild = null;
        }
        String valueOf = String.valueOf(iGProContentRecommendGuild.getGuildId());
        IGProContentRecommendGuild iGProContentRecommendGuild3 = this.guildInfo;
        if (iGProContentRecommendGuild3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
        } else {
            iGProContentRecommendGuild2 = iGProContentRecommendGuild3;
        }
        byte[] joinSig = iGProContentRecommendGuild2.getJoinSig();
        Intrinsics.checkNotNullExpressionValue(joinSig, "guildInfo.joinSig");
        return new JumpGuildParam(valueOf, "", new String(joinSig, Charsets.UTF_8), b16.getFirst(), b16.getSecond());
    }

    private final int n() {
        String obj = k().getText().toString();
        if (Intrinsics.areEqual(obj, "\u52a0\u5165")) {
            return 1;
        }
        if (Intrinsics.areEqual(obj, "\u53bb\u9891\u9053")) {
            return 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        final Context context = k().getContext();
        com.tencent.mobileqq.guild.channel.joinchannel.h.a(context, i(), new JoinGuildLogic.JumpParam(), "RecommendGuildTitleComponents", new bv() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.af
            @Override // vh2.bv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                RecommendGuildTitleComponents.p(RecommendGuildTitleComponents.this, context, i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(RecommendGuildTitleComponents this$0, Context context, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
        if (!com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(context, i3, str, iGProSecurityResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map s(RecommendGuildTitleComponents this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", Integer.valueOf(this$0.n())));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String guildId) {
        if (Intrinsics.areEqual(guildId, this.guildId)) {
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(URLDrawable urlDrawable) {
        m().setCompoundDrawables(null, null, urlDrawable, null);
        m().setCompoundDrawablePadding(com.tencent.mobileqq.guild.util.an.INSTANCE.b());
    }

    public final void A(@NotNull GuildLabelsView guildLabelsView) {
        Intrinsics.checkNotNullParameter(guildLabelsView, "<set-?>");
        this.mGuildDesc = guildLabelsView;
    }

    public final void B(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mGuildName = textView;
    }

    @NotNull
    public final ImageView j() {
        ImageView imageView = this.mGuildAvatar;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatar");
        return null;
    }

    @NotNull
    public final Button k() {
        Button button = this.mGuildBtn;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGuildBtn");
        return null;
    }

    @NotNull
    public final GuildLabelsView l() {
        GuildLabelsView guildLabelsView = this.mGuildDesc;
        if (guildLabelsView != null) {
            return guildLabelsView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGuildDesc");
        return null;
    }

    @NotNull
    public final TextView m() {
        TextView textView = this.mGuildName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
        return null;
    }

    public final void q(boolean attached) {
        if (attached) {
            IGPSService d16 = com.tencent.mobileqq.guild.util.at.d();
            if (d16 != null) {
                d16.addObserver(this.gpServiceObserver);
                return;
            }
            return;
        }
        IGPSService d17 = com.tencent.mobileqq.guild.util.at.d();
        if (d17 != null) {
            d17.deleteObserver(this.gpServiceObserver);
        }
    }

    public final void r(@Nullable IGProContentRecommendGuild guildInfo, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (guildInfo == null) {
            return;
        }
        this.guildInfo = guildInfo;
        this.guildId = String.valueOf(guildInfo.getGuildId());
        com.tencent.mobileqq.guild.u.p(guildInfo.getGuildAvatar(), j());
        D(guildInfo);
        ArrayList<IGProGuildLabel> tagList = guildInfo.getTagList();
        Intrinsics.checkNotNullExpressionValue(tagList, "guildInfo.tagList");
        h(tagList);
        C();
        com.tencent.mobileqq.guild.discoveryv2.util.b.b(k(), elementId, String.valueOf(guildInfo.hashCode()), ClickPolicy.REPORT_ALL, null, null, null, Double.valueOf(0.3d), new IDynamicParams() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ag
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map s16;
                s16 = RecommendGuildTitleComponents.s(RecommendGuildTitleComponents.this, str);
                return s16;
            }
        }, 48, null);
    }

    public final void t(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        x(containerView);
        View findViewById = containerView.findViewById(R.id.vzu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.guild_avatar)");
        y((ImageView) findViewById);
        View findViewById2 = containerView.findViewById(R.id.wrw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.guild_name)");
        B((TextView) findViewById2);
        View findViewById3 = containerView.findViewById(R.id.w3i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.guild_desc)");
        A((GuildLabelsView) findViewById3);
        View findViewById4 = containerView.findViewById(R.id.f165444w13);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.guild_btn)");
        z((Button) findViewById4);
        final Button k3 = k();
        final long j3 = 200;
        k3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildTitleComponents$onInitView$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IGProContentRecommendGuild iGProContentRecommendGuild;
                EventCollector.getInstance().onViewClickedBefore(it);
                k3.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                iGProContentRecommendGuild = this.guildInfo;
                if (iGProContentRecommendGuild == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
                    iGProContentRecommendGuild = null;
                }
                if (ch.j0(String.valueOf(iGProContentRecommendGuild.getGuildId()))) {
                    this.o();
                } else {
                    this.v();
                }
                final View view = k3;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildTitleComponents$onInitView$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        FontSettingManager.resetViewSize2Normal(containerView.getContext(), containerView);
    }

    public final void v() {
        Context context = k().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mGuildBtn.context");
        GuildJumpUtil.n(context, i());
    }

    public final void x(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.containerView = view;
    }

    public final void y(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mGuildAvatar = imageView;
    }

    public final void z(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.mGuildBtn = button;
    }
}
