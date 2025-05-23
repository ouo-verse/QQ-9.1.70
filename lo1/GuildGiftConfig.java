package lo1;

import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.gift.module.e;
import com.tencent.mobileqq.guild.gift.module.k;
import com.tencent.mobileqq.guild.gift.module.l;
import com.tencent.mobileqq.guild.gift.module.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sh2.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u00d7\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010 \u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010%\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010/\u0012,\b\u0002\u0010:\u001a&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000205j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`6\u0018\u000104\u0012,\b\u0002\u0010<\u001a&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000205j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`6\u0018\u000104\u0012,\b\u0002\u0010?\u001a&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000205j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`6\u0018\u000104\u0012,\b\u0002\u0010@\u001a&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000205j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`6\u0018\u000104\u0012\b\b\u0002\u0010D\u001a\u00020A\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010E\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010N\u00a2\u0006\u0004\bR\u0010SJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\t\u0010\u0011R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0013\u0010\u001eR\u0019\u0010$\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u001f\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(R\u0019\u0010.\u001a\u0004\u0018\u00010*8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010-R\u0019\u00103\u001a\u0004\u0018\u00010/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b\u001c\u00102R;\u0010:\u001a&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000205j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`6\u0018\u0001048\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b\u0016\u00109R;\u0010<\u001a&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000205j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`6\u0018\u0001048\u0006\u00a2\u0006\f\n\u0004\b,\u00108\u001a\u0004\b;\u00109R;\u0010?\u001a&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000205j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`6\u0018\u0001048\u0006\u00a2\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u00109R;\u0010@\u001a&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000205j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`6\u0018\u0001048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u00108\u001a\u0004\b=\u00109R\u0017\u0010D\u001a\u00020A8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010B\u001a\u0004\b7\u0010CR\u0019\u0010H\u001a\u0004\u0018\u00010E8\u0006\u00a2\u0006\f\n\u0004\b;\u0010F\u001a\u0004\b\u000e\u0010GR\u0019\u0010M\u001a\u0004\u0018\u00010I8\u0006\u00a2\u0006\f\n\u0004\b>\u0010J\u001a\u0004\bK\u0010LR\u0019\u0010Q\u001a\u0004\u0018\u00010N8\u0006\u00a2\u0006\f\n\u0004\bK\u0010O\u001a\u0004\b0\u0010P\u00a8\u0006T"}, d2 = {"Llo1/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", WadlProxyConsts.SCENE_ID, "b", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "secretKey", "c", "channelId", "Lcom/tencent/mobileqq/guild/gift/module/l;", "d", "Lcom/tencent/mobileqq/guild/gift/module/l;", h.F, "()Lcom/tencent/mobileqq/guild/gift/module/l;", "headViewCreator", "Lcom/tencent/mobileqq/guild/gift/module/e;", "e", "Lcom/tencent/mobileqq/guild/gift/module/e;", "()Lcom/tencent/mobileqq/guild/gift/module/e;", "giftDataAdapter", "Llo1/a;", "f", "Llo1/a;", "()Llo1/a;", "giftListDataConfig", "Lcom/tencent/mobileqq/guild/gift/module/k;", "g", "Lcom/tencent/mobileqq/guild/gift/module/k;", "()Lcom/tencent/mobileqq/guild/gift/module/k;", "giftSendListener", "Lcom/tencent/mobileqq/guild/gift/module/c;", "Lcom/tencent/mobileqq/guild/gift/module/c;", "k", "()Lcom/tencent/mobileqq/guild/gift/module/c;", "receivePushModule", "Lcom/tencent/mobileqq/qqgift/mvvm/business/data/a;", "i", "Lcom/tencent/mobileqq/qqgift/mvvm/business/data/a;", "()Lcom/tencent/mobileqq/qqgift/mvvm/business/data/a;", "giftDtParams", "Lkotlin/Function0;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "j", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "giftDtExtPageParams", "o", "sendReqExtData", "l", "p", "sendReqReportExtData", "rechargeUrlExtData", "Lcom/tencent/mobileqq/qqgift/mvvm/business/data/b;", "Lcom/tencent/mobileqq/qqgift/mvvm/business/data/b;", "()Lcom/tencent/mobileqq/qqgift/mvvm/business/data/b;", "panelStyle", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "()Landroid/view/View$OnClickListener;", "emptyPackClickListener", "Lsh2/c$g;", "Lsh2/c$g;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lsh2/c$g;", "tabSelectedListener", "Lcom/tencent/mobileqq/guild/gift/module/m;", "Lcom/tencent/mobileqq/guild/gift/module/m;", "()Lcom/tencent/mobileqq/guild/gift/module/m;", "panelEventListener", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/gift/module/l;Lcom/tencent/mobileqq/guild/gift/module/e;Llo1/a;Lcom/tencent/mobileqq/guild/gift/module/k;Lcom/tencent/mobileqq/guild/gift/module/c;Lcom/tencent/mobileqq/qqgift/mvvm/business/data/a;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/qqgift/mvvm/business/data/b;Landroid/view/View$OnClickListener;Lsh2/c$g;Lcom/tencent/mobileqq/guild/gift/module/m;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: lo1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildGiftConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String secretKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final l headViewCreator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final e giftDataAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final GiftListDataConfig giftListDataConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final k<Object> giftSendListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final com.tencent.mobileqq.guild.gift.module.c receivePushModule;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final com.tencent.mobileqq.qqgift.mvvm.business.data.a giftDtParams;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Function0<HashMap<String, String>> giftDtExtPageParams;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Function0<HashMap<String, String>> sendReqExtData;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Function0<HashMap<String, String>> sendReqReportExtData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Function0<HashMap<String, String>> rechargeUrlExtData;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.mobileqq.qqgift.mvvm.business.data.b panelStyle;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final View.OnClickListener emptyPackClickListener;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final c.g tabSelectedListener;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final m panelEventListener;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildGiftConfig(int i3, @NotNull String secretKey, @NotNull String channelId, @Nullable l lVar, @Nullable e eVar, @Nullable GiftListDataConfig giftListDataConfig, @Nullable k<Object> kVar, @Nullable com.tencent.mobileqq.guild.gift.module.c cVar, @Nullable com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar, @Nullable Function0<? extends HashMap<String, String>> function0, @Nullable Function0<? extends HashMap<String, String>> function02, @Nullable Function0<? extends HashMap<String, String>> function03, @Nullable Function0<? extends HashMap<String, String>> function04, @NotNull com.tencent.mobileqq.qqgift.mvvm.business.data.b panelStyle, @Nullable View.OnClickListener onClickListener, @Nullable c.g gVar, @Nullable m mVar) {
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(panelStyle, "panelStyle");
        this.sceneId = i3;
        this.secretKey = secretKey;
        this.channelId = channelId;
        this.headViewCreator = lVar;
        this.giftDataAdapter = eVar;
        this.giftListDataConfig = giftListDataConfig;
        this.giftSendListener = kVar;
        this.receivePushModule = cVar;
        this.giftDtParams = aVar;
        this.giftDtExtPageParams = function0;
        this.sendReqExtData = function02;
        this.sendReqReportExtData = function03;
        this.rechargeUrlExtData = function04;
        this.panelStyle = panelStyle;
        this.emptyPackClickListener = onClickListener;
        this.tabSelectedListener = gVar;
        this.panelEventListener = mVar;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final View.OnClickListener getEmptyPackClickListener() {
        return this.emptyPackClickListener;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final e getGiftDataAdapter() {
        return this.giftDataAdapter;
    }

    @Nullable
    public final Function0<HashMap<String, String>> d() {
        return this.giftDtExtPageParams;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final com.tencent.mobileqq.qqgift.mvvm.business.data.a getGiftDtParams() {
        return this.giftDtParams;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildGiftConfig)) {
            return false;
        }
        GuildGiftConfig guildGiftConfig = (GuildGiftConfig) other;
        if (this.sceneId == guildGiftConfig.sceneId && Intrinsics.areEqual(this.secretKey, guildGiftConfig.secretKey) && Intrinsics.areEqual(this.channelId, guildGiftConfig.channelId) && Intrinsics.areEqual(this.headViewCreator, guildGiftConfig.headViewCreator) && Intrinsics.areEqual(this.giftDataAdapter, guildGiftConfig.giftDataAdapter) && Intrinsics.areEqual(this.giftListDataConfig, guildGiftConfig.giftListDataConfig) && Intrinsics.areEqual(this.giftSendListener, guildGiftConfig.giftSendListener) && Intrinsics.areEqual(this.receivePushModule, guildGiftConfig.receivePushModule) && Intrinsics.areEqual(this.giftDtParams, guildGiftConfig.giftDtParams) && Intrinsics.areEqual(this.giftDtExtPageParams, guildGiftConfig.giftDtExtPageParams) && Intrinsics.areEqual(this.sendReqExtData, guildGiftConfig.sendReqExtData) && Intrinsics.areEqual(this.sendReqReportExtData, guildGiftConfig.sendReqReportExtData) && Intrinsics.areEqual(this.rechargeUrlExtData, guildGiftConfig.rechargeUrlExtData) && Intrinsics.areEqual(this.panelStyle, guildGiftConfig.panelStyle) && Intrinsics.areEqual(this.emptyPackClickListener, guildGiftConfig.emptyPackClickListener) && Intrinsics.areEqual(this.tabSelectedListener, guildGiftConfig.tabSelectedListener) && Intrinsics.areEqual(this.panelEventListener, guildGiftConfig.panelEventListener)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final GiftListDataConfig getGiftListDataConfig() {
        return this.giftListDataConfig;
    }

    @Nullable
    public final k<Object> g() {
        return this.giftSendListener;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final l getHeadViewCreator() {
        return this.headViewCreator;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int hashCode13 = ((((this.sceneId * 31) + this.secretKey.hashCode()) * 31) + this.channelId.hashCode()) * 31;
        l lVar = this.headViewCreator;
        int i3 = 0;
        if (lVar == null) {
            hashCode = 0;
        } else {
            hashCode = lVar.hashCode();
        }
        int i16 = (hashCode13 + hashCode) * 31;
        e eVar = this.giftDataAdapter;
        if (eVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = eVar.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        GiftListDataConfig giftListDataConfig = this.giftListDataConfig;
        if (giftListDataConfig == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = giftListDataConfig.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        k<Object> kVar = this.giftSendListener;
        if (kVar == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = kVar.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        com.tencent.mobileqq.guild.gift.module.c cVar = this.receivePushModule;
        if (cVar == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = cVar.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar = this.giftDtParams;
        if (aVar == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = aVar.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        Function0<HashMap<String, String>> function0 = this.giftDtExtPageParams;
        if (function0 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = function0.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        Function0<HashMap<String, String>> function02 = this.sendReqExtData;
        if (function02 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = function02.hashCode();
        }
        int i29 = (i28 + hashCode8) * 31;
        Function0<HashMap<String, String>> function03 = this.sendReqReportExtData;
        if (function03 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = function03.hashCode();
        }
        int i36 = (i29 + hashCode9) * 31;
        Function0<HashMap<String, String>> function04 = this.rechargeUrlExtData;
        if (function04 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = function04.hashCode();
        }
        int hashCode14 = (((i36 + hashCode10) * 31) + this.panelStyle.hashCode()) * 31;
        View.OnClickListener onClickListener = this.emptyPackClickListener;
        if (onClickListener == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = onClickListener.hashCode();
        }
        int i37 = (hashCode14 + hashCode11) * 31;
        c.g gVar = this.tabSelectedListener;
        if (gVar == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = gVar.hashCode();
        }
        int i38 = (i37 + hashCode12) * 31;
        m mVar = this.panelEventListener;
        if (mVar != null) {
            i3 = mVar.hashCode();
        }
        return i38 + i3;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final m getPanelEventListener() {
        return this.panelEventListener;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final com.tencent.mobileqq.qqgift.mvvm.business.data.b getPanelStyle() {
        return this.panelStyle;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final com.tencent.mobileqq.guild.gift.module.c getReceivePushModule() {
        return this.receivePushModule;
    }

    @Nullable
    public final Function0<HashMap<String, String>> l() {
        return this.rechargeUrlExtData;
    }

    /* renamed from: m, reason: from getter */
    public final int getSceneId() {
        return this.sceneId;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getSecretKey() {
        return this.secretKey;
    }

    @Nullable
    public final Function0<HashMap<String, String>> o() {
        return this.sendReqExtData;
    }

    @Nullable
    public final Function0<HashMap<String, String>> p() {
        return this.sendReqReportExtData;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final c.g getTabSelectedListener() {
        return this.tabSelectedListener;
    }

    @NotNull
    public String toString() {
        return "GuildGiftConfig(sceneId=" + this.sceneId + ", secretKey=" + this.secretKey + ", channelId=" + this.channelId + ", headViewCreator=" + this.headViewCreator + ", giftDataAdapter=" + this.giftDataAdapter + ", giftListDataConfig=" + this.giftListDataConfig + ", giftSendListener=" + this.giftSendListener + ", receivePushModule=" + this.receivePushModule + ", giftDtParams=" + this.giftDtParams + ", giftDtExtPageParams=" + this.giftDtExtPageParams + ", sendReqExtData=" + this.sendReqExtData + ", sendReqReportExtData=" + this.sendReqReportExtData + ", rechargeUrlExtData=" + this.rechargeUrlExtData + ", panelStyle=" + this.panelStyle + ", emptyPackClickListener=" + this.emptyPackClickListener + ", tabSelectedListener=" + this.tabSelectedListener + ", panelEventListener=" + this.panelEventListener + ")";
    }

    public /* synthetic */ GuildGiftConfig(int i3, String str, String str2, l lVar, e eVar, GiftListDataConfig giftListDataConfig, k kVar, com.tencent.mobileqq.guild.gift.module.c cVar, com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar, Function0 function0, Function0 function02, Function0 function03, Function0 function04, com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar, View.OnClickListener onClickListener, c.g gVar, m mVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) == 0 ? str2 : "", (i16 & 8) != 0 ? null : lVar, (i16 & 16) != 0 ? null : eVar, (i16 & 32) != 0 ? null : giftListDataConfig, (i16 & 64) != 0 ? null : kVar, (i16 & 128) != 0 ? null : cVar, (i16 & 256) != 0 ? null : aVar, (i16 & 512) != 0 ? null : function0, (i16 & 1024) != 0 ? null : function02, (i16 & 2048) != 0 ? null : function03, (i16 & 4096) != 0 ? null : function04, (i16 & 8192) != 0 ? new com.tencent.mobileqq.qqgift.mvvm.business.data.b(true) : bVar, (i16 & 16384) != 0 ? null : onClickListener, (i16 & 32768) != 0 ? null : gVar, (i16 & 65536) == 0 ? mVar : null);
    }
}
