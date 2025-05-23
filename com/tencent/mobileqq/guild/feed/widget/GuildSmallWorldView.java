package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u0001:\u0002<=B'\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020\t\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J&\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J2\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\tJ\"\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\t2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0019J<\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00102\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001d\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fR\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010#R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010.R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010#R\u0018\u00103\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView;", "Landroid/widget/FrameLayout;", "", "url", "e", "", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "targetView", "", "width", "height", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "picLoadListener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b;", "data", "", "", "extraDtParams", "k", "l", "g", "playBtnSize", "Lkotlin/Pair;", "watermarkMargin", "f", "displayData", "needReport", "i", "", "radius", "setRadius", "d", "Landroid/widget/ImageView;", "ivCover", "ivIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvName", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", tl.h.F, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", ParseCommon.CONTAINER, "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "llWatermark", "ivPlayBtn", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b;", "mDisplayData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSmallWorldView extends FrameLayout {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float E = GuildSplitViewUtils.j(GuildSplitViewUtils.f235370a, false, null, 3, null) * 0.75f;

    /* renamed from: C */
    @Nullable
    private b mDisplayData;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private ImageView ivCover;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private ImageView ivIcon;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private TextView tvName;

    /* renamed from: h */
    @NotNull
    private RoundCorneredRelativeLayout container;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private LinearLayout llWatermark;

    /* renamed from: m */
    @NotNull
    private ImageView ivPlayBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$a;", "", "", "CARD_WIDTH", UserInfo.SEX_FEMALE, "a", "()F", "HW_RATIO", "", "RADIUS", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.widget.GuildSmallWorldView$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return GuildSmallWorldView.E;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\t\u000bB\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "urlType", "Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b$b;", "Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b$b;", "c", "()Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b$b;", QCircleScheme.AttrDetail.VIDEO_INFO, "Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b$a;", "Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b$a;", "()Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b$a;", "platformInfo", "<init>", "(ILcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b$b;Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b$a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class b {

        /* renamed from: a, reason: from kotlin metadata */
        private final int urlType;

        /* renamed from: b, reason: from kotlin metadata */
        @NotNull
        private final C7785b com.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String;

        /* renamed from: c, reason: from kotlin metadata */
        @NotNull
        private final a platformInfo;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "platformIconUrl", "b", "platformName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final /* data */ class a {

            /* renamed from: a, reason: from kotlin metadata */
            @NotNull
            private final String platformIconUrl;

            /* renamed from: b, reason: from kotlin metadata */
            @NotNull
            private final String platformName;

            public a(@NotNull String platformIconUrl, @NotNull String platformName) {
                Intrinsics.checkNotNullParameter(platformIconUrl, "platformIconUrl");
                Intrinsics.checkNotNullParameter(platformName, "platformName");
                this.platformIconUrl = platformIconUrl;
                this.platformName = platformName;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final String getPlatformIconUrl() {
                return this.platformIconUrl;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final String getPlatformName() {
                return this.platformName;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof a)) {
                    return false;
                }
                a aVar = (a) other;
                if (Intrinsics.areEqual(this.platformIconUrl, aVar.platformIconUrl) && Intrinsics.areEqual(this.platformName, aVar.platformName)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return (this.platformIconUrl.hashCode() * 31) + this.platformName.hashCode();
            }

            @NotNull
            public String toString() {
                return "iconUrl:" + this.platformIconUrl + ", name:" + this.platformName;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView$b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "coverUrl", "b", WadlProxyConsts.KEY_JUMP_URL, "c", "Z", "()Z", "showPlayButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.widget.GuildSmallWorldView$b$b */
        /* loaded from: classes13.dex */
        public static final /* data */ class C7785b {

            /* renamed from: a, reason: from kotlin metadata */
            @NotNull
            private final String coverUrl;

            /* renamed from: b, reason: from kotlin metadata */
            @NotNull
            private final String com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String;

            /* renamed from: c, reason: from kotlin metadata */
            private final boolean showPlayButton;

            public C7785b(@NotNull String coverUrl, @NotNull String jumpUrl, boolean z16) {
                Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
                Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
                this.coverUrl = coverUrl;
                this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String = jumpUrl;
                this.showPlayButton = z16;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final String getCoverUrl() {
                return this.coverUrl;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final String getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String() {
                return this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String;
            }

            /* renamed from: c, reason: from getter */
            public final boolean getShowPlayButton() {
                return this.showPlayButton;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof C7785b)) {
                    return false;
                }
                C7785b c7785b = (C7785b) other;
                if (Intrinsics.areEqual(this.coverUrl, c7785b.coverUrl) && Intrinsics.areEqual(this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String, c7785b.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String) && this.showPlayButton == c7785b.showPlayButton) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int hashCode = ((this.coverUrl.hashCode() * 31) + this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String.hashCode()) * 31;
                boolean z16 = this.showPlayButton;
                int i3 = z16;
                if (z16 != 0) {
                    i3 = 1;
                }
                return hashCode + i3;
            }

            @NotNull
            public String toString() {
                return "cover:" + this.coverUrl + ", jumpUrl:" + this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String + ", showPlayBtn:" + this.showPlayButton;
            }
        }

        public b(int i3, @NotNull C7785b videoInfo, @NotNull a platformInfo) {
            Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
            Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
            this.urlType = i3;
            this.com.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String = videoInfo;
            this.platformInfo = platformInfo;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final a getPlatformInfo() {
            return this.platformInfo;
        }

        /* renamed from: b, reason: from getter */
        public final int getUrlType() {
            return this.urlType;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final C7785b getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String() {
            return this.com.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.urlType == bVar.urlType && Intrinsics.areEqual(this.com.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String, bVar.com.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String) && Intrinsics.areEqual(this.platformInfo, bVar.platformInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.urlType * 31) + this.com.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String.hashCode()) * 31) + this.platformInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "urlType:" + this.urlType + ", " + this.com.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String + ", " + this.platformInfo;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSmallWorldView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void c(GuildSmallWorldView this$0, View view) {
        b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard") && (bVar = this$0.mDisplayData) != null) {
            Intrinsics.checkNotNull(bVar);
            String str = bVar.getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
            if (TextUtils.isEmpty(str)) {
                QLog.e("GuildSmallWorldView", 1, "ThirdVideoViewOnClick--jumpUrl is null!");
            } else {
                b bVar2 = this$0.mDisplayData;
                boolean z16 = false;
                if (bVar2 != null && bVar2.getUrlType() == 7) {
                    z16 = true;
                }
                if (!z16) {
                    str = this$0.e(str);
                }
                if (!this$0.n(str)) {
                    GuildJumpUtil.w(QBaseActivity.sTopActivity, str);
                }
                QLog.d("GuildSmallWorldView", 1, " jumpUrl is " + str);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String e(String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
            if (!startsWith$default2) {
                return "https://" + url;
            }
            return url;
        }
        return url;
    }

    public static /* synthetic */ void h(GuildSmallWorldView guildSmallWorldView, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = (int) E;
        }
        guildSmallWorldView.g(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(GuildSmallWorldView guildSmallWorldView, b bVar, Map map, IPicLoadStateListener iPicLoadStateListener, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        if ((i3 & 4) != 0) {
            iPicLoadStateListener = null;
        }
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        guildSmallWorldView.i(bVar, map, iPicLoadStateListener, z16);
    }

    private final void k(b data, Map<String, ? extends Object> extraDtParams) {
        if1.a.b(this, "em_sgrp_insert_card_url", data.hashCode() + "#" + hashCode(), l(data, extraDtParams), null, null, null, null, null, 248, null);
    }

    private final Map<String, Object> l(b data, Map<String, ? extends Object> extraDtParams) {
        int i3;
        HashMap hashMap = new HashMap();
        if (extraDtParams != null) {
            hashMap.putAll(extraDtParams);
        }
        switch (data.getUrlType()) {
            case 6:
                i3 = 1;
                break;
            case 7:
                i3 = 2;
                break;
            case 8:
                i3 = 3;
                break;
            case 9:
                i3 = 4;
                break;
            default:
                i3 = -1;
                break;
        }
        hashMap.put("sgrp_url", data.getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String());
        hashMap.put("sgrp_url_type", Integer.valueOf(i3));
        return hashMap;
    }

    private final void m(ImageView imageView, String str, int i3, int i16, IPicLoadStateListener iPicLoadStateListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.mobileqq.guild.picload.e.a().f(Option.obtain().setTargetView(imageView).setUrl(str).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a).setRequestHeight(i16).setRequestWidth(i3), iPicLoadStateListener);
    }

    private final boolean n(String str) {
        QRouteApi api = QRoute.api(IMiniAppService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
        IMiniAppService iMiniAppService = (IMiniAppService) api;
        if (iMiniAppService.isMiniAppUrl(str)) {
            iMiniAppService.startMiniApp(QBaseActivity.sTopActivity, str, 1075, new MiniAppLaunchListener() { // from class: com.tencent.mobileqq.guild.feed.widget.t
                @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
                public final void onLaunchResult(boolean z16, Bundle bundle) {
                    GuildSmallWorldView.o(z16, bundle);
                }
            });
            QLog.d("GuildSmallWorldView", 1, "open by MiniApp ");
            return true;
        }
        return false;
    }

    public final void f(int playBtnSize, @NotNull Pair<Integer, Integer> watermarkMargin) {
        Intrinsics.checkNotNullParameter(watermarkMargin, "watermarkMargin");
        ImageView imageView = this.ivPlayBtn;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = playBtnSize;
            layoutParams.height = playBtnSize;
            imageView.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.llWatermark.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams.leftMargin = watermarkMargin.getFirst().intValue();
            marginLayoutParams.topMargin = watermarkMargin.getSecond().intValue();
            this.llWatermark.setLayoutParams(marginLayoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void g(int width) {
        int i3 = (int) (width * 0.56329113f);
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = this.container;
        ViewGroup.LayoutParams layoutParams = roundCorneredRelativeLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = width;
            layoutParams.height = i3;
            roundCorneredRelativeLayout.setLayoutParams(layoutParams);
            float d16 = cw.d(8);
            this.container.setRadius(d16, d16, d16, d16);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(@NotNull b displayData, @Nullable Map<String, ? extends Object> extraDtParams, @Nullable IPicLoadStateListener picLoadListener, boolean needReport) {
        String str;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(displayData, "displayData");
        this.mDisplayData = displayData;
        b.C7785b c7785b = displayData.getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String();
        b.a platformInfo = displayData.getPlatformInfo();
        b bVar = this.mDisplayData;
        if (bVar != null) {
            str = bVar.toString();
        } else {
            str = null;
        }
        QLog.i("GuildSmallWorldView", 4, "ThirdVideoViewOnClick--" + str);
        m(this.ivCover, c7785b.getCoverUrl(), this.container.getLayoutParams().width, this.container.getLayoutParams().height, picLoadListener);
        if (c7785b.getShowPlayButton()) {
            this.ivPlayBtn.setVisibility(0);
        } else {
            this.ivPlayBtn.setVisibility(8);
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(platformInfo.getPlatformIconUrl());
        if (!isBlank) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(platformInfo.getPlatformName());
            if (!isBlank2) {
                m(this.ivIcon, platformInfo.getPlatformIconUrl(), this.ivIcon.getWidth(), this.ivIcon.getHeight(), picLoadListener);
                this.tvName.setText(platformInfo.getPlatformName());
                this.llWatermark.setVisibility(0);
                if (!needReport) {
                    k(displayData, extraDtParams);
                    return;
                }
                return;
            }
        }
        this.llWatermark.setVisibility(8);
        if (!needReport) {
        }
    }

    public final void setRadius(float radius) {
        this.container.setRadius(radius, radius, radius, radius);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSmallWorldView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildSmallWorldView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSmallWorldView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.f97, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.duw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_cover)");
        this.ivCover = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.dvu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(co\u2026leqq.ad.api.R.id.iv_icon)");
        this.ivIcon = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f110046hg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_platform_name)");
        this.tvName = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f166798ic2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.rl_container)");
        this.container = (RoundCorneredRelativeLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.y6w);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.iv_play_btn)");
        this.ivPlayBtn = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.yri);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.ll_watermark)");
        this.llWatermark = (LinearLayout) findViewById6;
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.widget.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSmallWorldView.c(GuildSmallWorldView.this, view);
            }
        });
    }

    public static final void o(boolean z16, Bundle bundle) {
    }
}
