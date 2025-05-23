package bq0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import bq0.GuildHighlightParams;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.guild.aio.input.at.hashtag.ui.k;
import com.tencent.guild.aio.msglist.highlight.TextColoredSpan;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qr1.HashTagJumpParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J \u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J:\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J\"\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#J.\u0010'\u001a\u00020&2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019J\u0016\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0006R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060+j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00105\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u00104R\u0014\u00106\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00104R\u0014\u00107\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00104R\u0014\u00108\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u00104R\u0014\u00109\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u00104\u00a8\u0006<"}, d2 = {"Lbq0/e;", "", "", "channelType", "", "o", "", "sourceChannelId", "jumpChannelId", "Landroid/view/View;", "view", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isSelf", "hasBackground", "e", "textHasBackground", "f", "k", "i", "j", "Lbq0/a;", "params", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "", "textSize", "iconSize", "Lcom/tencent/guild/aio/input/at/hashtag/ui/c;", "d", "isArticleMain", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Landroid/text/method/MovementMethod;", "movement", "p", "Lbq0/a$a;", tl.h.F, "checkSourceChannelIsValid", "factoryName", "g", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "CUT_NICKNAME_MAP", "Lcom/tencent/guild/aio/input/at/hashtag/ui/k;", "c", "Lcom/tencent/guild/aio/input/at/hashtag/ui/k;", "hashTagLinkMovement", "I", "mMarginLeft", "mMarginRight", "mMarginBetween", "HASHTAG_TOP_BOTTOM_PADDING", "HASHTAG_LEFT_RIGHT_PADDING", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f28951a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> CUT_NICKNAME_MAP = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final k hashTagLinkMovement = new k();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int mMarginLeft = x.a(7.0f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final int mMarginRight = x.a(7.0f);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final int mMarginBetween = x.a(2.0f);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final int HASHTAG_TOP_BOTTOM_PADDING = x.a(0.5f);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final int HASHTAG_LEFT_RIGHT_PADDING = x.a(2.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"bq0/e$a", "Lcom/tencent/guild/aio/input/at/hashtag/ui/b;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends com.tencent.guild.aio.input.at.hashtag.ui.b {
        final /* synthetic */ String C;
        final /* synthetic */ String D;
        final /* synthetic */ String E;
        final /* synthetic */ String F;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f28959h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f28960i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ GuildHighlightParams f28961m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g gVar, int i3, int i16, int i17, boolean z16, GuildHighlightParams guildHighlightParams, String str, String str2, String str3, String str4) {
            super(gVar, i3, i16);
            this.f28959h = i17;
            this.f28960i = z16;
            this.f28961m = guildHighlightParams;
            this.C = str;
            this.D = str2;
            this.E = str3;
            this.F = str4;
        }

        @Override // com.tencent.guild.aio.input.at.hashtag.ui.b, android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            boolean z16;
            Intrinsics.checkNotNullParameter(widget, "widget");
            e eVar = e.f28951a;
            if (!eVar.o(this.f28959h) && !GuildUIUtils.f235378a.C() && this.f28961m.d().get() != null) {
                JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) this.f28961m.getExtData().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
                GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) this.f28961m.getExtData().getParcelable("GuildAppReportSourceInfo");
                String sourceChannelId = this.C;
                Intrinsics.checkNotNullExpressionValue(sourceChannelId, "sourceChannelId");
                String jumpChannelId = this.D;
                Intrinsics.checkNotNullExpressionValue(jumpChannelId, "jumpChannelId");
                eVar.q(sourceChannelId, jumpChannelId, widget);
                IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
                Context context = this.f28961m.d().get();
                Intrinsics.checkNotNull(context);
                Context context2 = context;
                String guildId = this.E;
                Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                String jumpChannelId2 = this.D;
                Intrinsics.checkNotNullExpressionValue(jumpChannelId2, "jumpChannelId");
                String sourceChannelId2 = this.C;
                Intrinsics.checkNotNullExpressionValue(sourceChannelId2, "sourceChannelId");
                boolean checkSourceChannelIsValid = this.f28961m.getCheckSourceChannelIsValid();
                String factoryName = this.F;
                Intrinsics.checkNotNullExpressionValue(factoryName, "factoryName");
                boolean g16 = eVar.g(checkSourceChannelIsValid, factoryName);
                String factoryName2 = this.F;
                Intrinsics.checkNotNullExpressionValue(factoryName2, "factoryName");
                if (this.f28961m.getAtType() == 512) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                iGuildMainFrameApi.handleHashTagJump(new HashTagJumpParams(context2, guildId, jumpChannelId2, sourceChannelId2, g16, factoryName2, z16, joinInfoParam, guildAppReportSourceInfo));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"bq0/e$b", "Lcom/tencent/guild/aio/input/at/hashtag/ui/b;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends com.tencent.guild.aio.input.at.hashtag.ui.b {
        final /* synthetic */ GuildHighlightParams C;
        final /* synthetic */ String D;
        final /* synthetic */ String E;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f28962h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f28963i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f28964m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.ObjectRef<g> objectRef, int i3, int i16, String str, String str2, int i17, GuildHighlightParams guildHighlightParams, String str3, String str4) {
            super(objectRef.element, i3, i16);
            this.f28962h = str;
            this.f28963i = str2;
            this.f28964m = i17;
            this.C = guildHighlightParams;
            this.D = str3;
            this.E = str4;
        }

        @Override // com.tencent.guild.aio.input.at.hashtag.ui.b, android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            boolean z16;
            boolean z17;
            Context context;
            Intrinsics.checkNotNullParameter(widget, "widget");
            String str = this.f28962h;
            boolean z18 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str2 = this.f28963i;
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    e eVar = e.f28951a;
                    if (!eVar.o(this.f28964m) && !GuildUIUtils.f235378a.C() && (context = widget.getContext()) != null) {
                        JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) this.C.getExtData().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
                        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) this.C.getExtData().getParcelable("GuildAppReportSourceInfo");
                        String sourceChannelId = this.f28963i;
                        Intrinsics.checkNotNullExpressionValue(sourceChannelId, "sourceChannelId");
                        String jumpChannelId = this.D;
                        Intrinsics.checkNotNullExpressionValue(jumpChannelId, "jumpChannelId");
                        eVar.q(sourceChannelId, jumpChannelId, widget);
                        IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
                        String guildId = this.E;
                        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                        String jumpChannelId2 = this.D;
                        Intrinsics.checkNotNullExpressionValue(jumpChannelId2, "jumpChannelId");
                        String sourceChannelId2 = this.f28963i;
                        Intrinsics.checkNotNullExpressionValue(sourceChannelId2, "sourceChannelId");
                        boolean checkSourceChannelIsValid = this.C.getCheckSourceChannelIsValid();
                        String factoryName = this.f28962h;
                        Intrinsics.checkNotNullExpressionValue(factoryName, "factoryName");
                        boolean g16 = eVar.g(checkSourceChannelIsValid, factoryName);
                        String factoryName2 = this.f28962h;
                        Intrinsics.checkNotNullExpressionValue(factoryName2, "factoryName");
                        if (this.C.getAtType() == 512) {
                            z18 = true;
                        }
                        iGuildMainFrameApi.handleHashTagJump(new HashTagJumpParams(context, guildId, jumpChannelId2, sourceChannelId2, g16, factoryName2, z18, joinInfoParam, guildAppReportSourceInfo));
                    }
                }
            }
        }
    }

    e() {
    }

    private final com.tencent.guild.aio.input.at.hashtag.ui.c d(GuildHighlightParams params, String jumpChannelId, Resources resources, boolean isSelf, float textSize, float iconSize) {
        int color;
        int i3;
        boolean A = UIUtil.f112434a.A();
        ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getGuildInfo(params.getExtData().getString("guildId", ""));
        int l3 = GuildChannelIconUtil.l(GuildChannelIconUtil.f235331a, jumpChannelId, params.getAtType(), null, 4, null);
        if (isSelf) {
            if (A) {
                i3 = R.color.skin_chat_buble_link_mine;
            } else {
                i3 = R.color.qui_common_bubble_host_text_primary;
            }
            color = ResourcesCompat.getColor(resources, i3, null);
        } else {
            color = ResourcesCompat.getColor(resources, R.color.qui_common_text_link, null);
        }
        int i16 = color;
        int a16 = x.a(textSize);
        int a17 = x.a(iconSize);
        int a18 = x.a(4.0f);
        Drawable it = resources.getDrawable(l3);
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.guild.aio.input.at.hashtag.ui.c cVar = new com.tencent.guild.aio.input.at.hashtag.ui.c(guildUIUtils.F(it, i16), a17, a16, mMarginLeft, mMarginRight, mMarginBetween, i16, 0, 1, a18, HASHTAG_TOP_BOTTOM_PADDING, HASHTAG_LEFT_RIGHT_PADDING);
        params.getShowText().setSpan(cVar, params.getStart(), params.getEnd(), 33);
        return cVar;
    }

    private final int e(boolean isSelf, boolean hasBackground) {
        if (hasBackground) {
            return R.color.blz;
        }
        return R.color.f157122bl3;
    }

    private final int f(boolean isSelf, boolean hasBackground, boolean textHasBackground) {
        if (isSelf && hasBackground && !textHasBackground) {
            return com.tencent.guild.aio.msglist.text.util.f.l(com.tencent.guild.aio.msglist.text.util.f.f111944a, false, 1, null);
        }
        return com.tencent.guild.aio.msglist.text.util.f.f(com.tencent.guild.aio.msglist.text.util.f.f111944a, false, 1, null);
    }

    private final int i(boolean isSelf, boolean hasBackground) {
        if (hasBackground) {
            return R.color.blz;
        }
        return R.color.bou;
    }

    private final int j(boolean isSelf, boolean hasBackground) {
        if (isSelf && hasBackground) {
            return R.color.blz;
        }
        return R.color.bov;
    }

    private final int k(boolean isSelf, boolean hasBackground, boolean textHasBackground) {
        if (isSelf && hasBackground && !textHasBackground) {
            return com.tencent.guild.aio.msglist.text.util.f.o(com.tencent.guild.aio.msglist.text.util.f.f111944a, false, 1, null);
        }
        return com.tencent.guild.aio.msglist.text.util.f.f(com.tencent.guild.aio.msglist.text.util.f.f111944a, false, 1, null);
    }

    private final boolean l(boolean isSelf, boolean isArticleMain) {
        if (isArticleMain) {
            return false;
        }
        return isSelf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(int channelType) {
        if (channelType == 5 && ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).guildLiveVideoIsLandScreenState()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String sourceChannelId, String jumpChannelId, View view) {
        IGProChannelInfo channelInfo = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(jumpChannelId);
        IGProChannelInfo channelInfo2 = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(sourceChannelId);
        HashMap hashMap = new HashMap();
        if (channelInfo != null) {
            String guildId = channelInfo.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "infoTarget.guildId");
            hashMap.put("sgrp_to_channel_id", guildId);
            hashMap.put("sgrp_subchannel_type", Integer.valueOf(channelInfo.getType()));
        }
        hashMap.put("sgrp_to_sub_channel_id", jumpChannelId);
        if (channelInfo2 != null) {
            String guildId2 = channelInfo2.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId2, "sourceTarget.guildId");
            hashMap.put("sgrp_channel_id", guildId2);
        }
        hashMap.put("sgrp_sub_channel_id", sourceChannelId);
        w.b(hashMap);
        VideoReport.reportEvent("clck", view, hashMap);
    }

    public final boolean g(boolean checkSourceChannelIsValid, @NotNull String factoryName) {
        Intrinsics.checkNotNullParameter(factoryName, "factoryName");
        if (checkSourceChannelIsValid) {
            return ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).needCheckSourceChannelIsValid(factoryName);
        }
        return checkSourceChannelIsValid;
    }

    @NotNull
    public final GuildHighlightParams.GuildHighlightStyle h(boolean isSelf, boolean hasBackground, boolean textHasBackground, float textSize, float iconSize) {
        GuildHighlightParams.GuildHighlightStyle guildHighlightStyle = new GuildHighlightParams.GuildHighlightStyle(0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 255, null);
        e eVar = f28951a;
        guildHighlightStyle.g(eVar.e(isSelf, hasBackground));
        guildHighlightStyle.i(eVar.f(isSelf, hasBackground, textHasBackground));
        guildHighlightStyle.m(eVar.k(isSelf, hasBackground, textHasBackground));
        guildHighlightStyle.k(eVar.i(isSelf, hasBackground));
        guildHighlightStyle.l(eVar.j(isSelf, hasBackground));
        guildHighlightStyle.j(textSize);
        guildHighlightStyle.h(iconSize);
        return guildHighlightStyle;
    }

    public final void m(@NotNull GuildHighlightParams params) {
        Resources resources;
        int color;
        boolean z16;
        boolean z17;
        int i3;
        String str;
        g d16;
        g hVar;
        Context context;
        Intrinsics.checkNotNullParameter(params, "params");
        TextView textView = params.getTextView();
        if (textView != null && (context = textView.getContext()) != null) {
            resources = context.getResources();
        } else {
            resources = null;
        }
        Resources resources2 = resources;
        if (resources2 == null) {
            return;
        }
        int color2 = resources2.getColor(params.getStyle().getAtBgColorId());
        if (params.getAtTextColor() != 0) {
            color = params.getAtTextColor();
        } else {
            color = resources2.getColor(params.getStyle().getAtTextColorId());
        }
        int i16 = color;
        int a16 = x.a(3.0f);
        int color3 = resources2.getColor(params.getStyle().getHashTagBgColorId());
        int color4 = resources2.getColor(params.getStyle().getHashTagPressedColorId());
        if (params.getAtType() != 16 && params.getAtType() != 512) {
            params.getShowText().setSpan(new ForegroundColorSpan(i16), params.getStart(), params.getEnd(), 33);
        } else {
            boolean z18 = params.getExtData().getBoolean("isSelf", false);
            boolean z19 = params.getExtData().getBoolean("IS_ARTICLE_MAIN", false);
            int i17 = params.getExtData().getInt("CHANNEL_TYPE", 0);
            String string = params.getExtData().getString("guildId", "");
            String jumpChannelId = params.getExtData().getString("jumpChannelId", "");
            String string2 = params.getExtData().getString("sourceChannelId", "");
            String string3 = params.getExtData().getString("factoryName", "");
            boolean z26 = false;
            boolean z27 = params.getExtData().getBoolean("NEW_AT_JUMP_CHANNEL_STYLE", false);
            if (jumpChannelId != null && jumpChannelId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (string2 != null && string2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    if (string3 == null || string3.length() == 0) {
                        z26 = true;
                    }
                    if (!z26) {
                        if (!z27 && i17 != 5 && i17 != 2 && i17 != 1 && i17 != 1000001) {
                            if (color2 == 0 && color3 == 0) {
                                hVar = new TextColoredSpan(i16);
                            } else {
                                hVar = new h(color2, i16, a16, params.getTextView(), params.getStart(), params.getEnd(), ViewUtils.dip2px(1.0f), ViewUtils.dip2px(1.0f));
                            }
                            i3 = 33;
                            params.getShowText().setSpan(hVar, params.getStart(), params.getEnd(), 33);
                            hVar.setBackgroundColor(color3);
                            d16 = hVar;
                            str = jumpChannelId;
                        } else {
                            i3 = 33;
                            Intrinsics.checkNotNullExpressionValue(jumpChannelId, "jumpChannelId");
                            str = jumpChannelId;
                            d16 = d(params, jumpChannelId, resources2, l(z18, z19), params.getStyle().getAtTextSize(), params.getStyle().getAtIconSize());
                        }
                        TextView textView2 = params.getTextView();
                        if (textView2 != null) {
                            textView2.setMovementMethod(hashTagLinkMovement);
                        }
                        TextView textView3 = params.getTextView();
                        if (textView3 != null) {
                            textView3.setOnClickListener(new View.OnClickListener() { // from class: bq0.d
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    e.n(view);
                                }
                            });
                        }
                        VideoReport.setElementId(params.getTextView(), "em_sgrp_sub_channel_link");
                        VideoReport.setElementExposePolicy(params.getTextView(), ExposurePolicy.REPORT_ALL);
                        params.getShowText().setSpan(new a(d16, color4, color3, i17, false, params, string2, str, string, string3), params.getStart(), params.getEnd(), i3);
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [com.tencent.guild.aio.input.at.hashtag.ui.c, T] */
    @Nullable
    public final MovementMethod p(@NotNull GuildHighlightParams params, @NotNull Context context, @Nullable MovementMethod movement) {
        int color;
        Ref.ObjectRef objectRef;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        if (resources == null) {
            return movement;
        }
        if (params.getAtTextColor() != 0) {
            color = params.getAtTextColor();
        } else {
            color = resources.getColor(params.getStyle().getAtTextColorId());
        }
        int color2 = resources.getColor(params.getStyle().getHashTagBgColorId());
        int color3 = resources.getColor(params.getStyle().getHashTagPressedColorId());
        if (params.getAtType() != 16 && params.getAtType() != 512) {
            params.getShowText().setSpan(new ForegroundColorSpan(color), params.getStart(), params.getEnd(), 33);
        } else {
            boolean z16 = false;
            boolean z17 = params.getExtData().getBoolean("isSelf", false);
            boolean z18 = params.getExtData().getBoolean("IS_ARTICLE_MAIN", false);
            int i3 = params.getExtData().getInt("CHANNEL_TYPE", 0);
            String string = params.getExtData().getString("guildId", "");
            String jumpChannelId = params.getExtData().getString("jumpChannelId", "");
            String string2 = params.getExtData().getString("sourceChannelId", "");
            String string3 = params.getExtData().getString("factoryName", "");
            if (jumpChannelId == null || jumpChannelId.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                if (i3 != 1 && i3 != 1000001) {
                    objectRef = objectRef2;
                } else {
                    Intrinsics.checkNotNullExpressionValue(jumpChannelId, "jumpChannelId");
                    objectRef = objectRef2;
                    objectRef.element = d(params, jumpChannelId, resources, l(z17, z18), params.getStyle().getAtTextSize(), params.getStyle().getAtIconSize());
                }
                k kVar = hashTagLinkMovement;
                params.getShowText().setSpan(new b(objectRef, color3, color2, string3, string2, i3, params, jumpChannelId, string), params.getStart(), params.getEnd(), 33);
                return kVar;
            }
        }
        return movement;
    }
}
