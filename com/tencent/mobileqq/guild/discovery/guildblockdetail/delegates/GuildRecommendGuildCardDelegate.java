package com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.base.extension.t;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.discovery.DiscoveryConstants$PageFrom;
import com.tencent.mobileqq.guild.discovery.avblockdetail.delegate.GuildBaseItemDelegate;
import com.tencent.mobileqq.guild.discovery.avblockdetail.model.GuildRecommendCardItem;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate;
import com.tencent.mobileqq.guild.discovery.mine.util.OpenChannelUtil;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.main.topchannel.widget.ChannelStatusView;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.q;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ax;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.bq;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.adapterdelegates.n;
import com.tencent.mobileqq.guild.widget.shadow.GuildShadowLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProItemCbData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import gh1.ExposeModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jh1.ExtraData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003./0B)\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010(\u001a\u00020$\u00a2\u0006\u0004\b+\u0010,J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0015H\u0014R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b&\u0010'\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/delegate/GuildBaseItemDelegate;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem;", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$RecommendGuildViewHolder;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "v", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, HippyTKDListViewAdapter.X, "holder", "", "payloads", "", "w", "o", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", tl.h.F, "Lgh1/b;", "e", "Lgh1/b;", "getExposeHelper", "()Lgh1/b;", "exposeHelper", "Ljh1/a;", "f", "Ljh1/a;", "getExtraData", "()Ljh1/a;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;", "getStyles", "()Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;", "styles", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "<init>", "(Lgh1/b;Ljh1/a;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;)V", "i", "a", "RecommendGuildViewHolder", "Styles", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildRecommendGuildCardDelegate extends GuildBaseItemDelegate<GuildRecommendCardItem, RecommendGuildViewHolder> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gh1.b exposeHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ExtraData extraData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Styles styles;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final int f216655m = bi.b(10);
    private static final int C = bi.b(8);
    private static final int D = bi.a(6.7f);
    private static final int E = bi.a(5.3f);
    private static int F = bi.b(4);
    private static float G = 0.96f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B4\u0012\u0006\u0010:\u001a\u000206\u0012\u0006\u0010@\u001a\u00020;\u0012\u0007\u0010\u0091\u0001\u001a\u00020U\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010B\u001a\u00020\r\u00a2\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003J$\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J6\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J6\u0010#\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00122\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0018\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH\u0002J&\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH\u0002J \u00100\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020.J\u001e\u00101\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016J\u001e\u00103\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u00102\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020\rH\u0016R\u0017\u0010:\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b*\u00107\u001a\u0004\b8\u00109R\u0017\u0010@\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010(R\u0018\u0010D\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010CR\u001c\u0010H\u001a\n F*\u0004\u0018\u00010E0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010GR\u001c\u0010L\u001a\n F*\u0004\u0018\u00010I0I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010P\u001a\n F*\u0004\u0018\u00010M0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010T\u001a\n F*\u0004\u0018\u00010Q0Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001c\u0010X\u001a\n F*\u0004\u0018\u00010U0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u001c\u0010Y\u001a\n F*\u0004\u0018\u00010Q0Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010SR\u001f\u0010[\u001a\n F*\u0004\u0018\u00010U0U8\u0006\u00a2\u0006\f\n\u0004\b1\u0010W\u001a\u0004\bJ\u0010ZR\u001c\u0010]\u001a\n F*\u0004\u0018\u00010Q0Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010SR\u001c\u0010\b\u001a\n F*\u0004\u0018\u00010M0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010OR\u001c\u0010_\u001a\n F*\u0004\u0018\u00010Q0Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010SR\u001c\u0010`\u001a\n F*\u0004\u0018\u00010M0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010OR\u001c\u0010d\u001a\n F*\u0004\u0018\u00010a0a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001c\u0010h\u001a\n F*\u0004\u0018\u00010e0e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u001c\u0010j\u001a\n F*\u0004\u0018\u00010M0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010OR\u001c\u0010l\u001a\n F*\u0004\u0018\u00010M0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010OR\u001c\u0010!\u001a\n F*\u0004\u0018\u00010M0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010OR\u001c\u0010o\u001a\n F*\u0004\u0018\u00010m0m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010nR\u001c\u0010r\u001a\n F*\u0004\u0018\u00010p0p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010qR\u001c\u0010s\u001a\n F*\u0004\u0018\u00010p0p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010qR#\u0010x\u001a\n F*\u0004\u0018\u00010t0t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bN\u0010wR\u0014\u0010{\u001a\u00020y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010zR\u0016\u0010}\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010(R#\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b\u000f\u0010-\u001a\u0004\b~\u0010\u007f\"\u0005\b\\\u0010\u0080\u0001R'\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0081\u0001\u0010<\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R)\u0010\u008c\u0001\u001a\u00030\u0086\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0005\bV\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010\u0090\u0001\u001a\u00030\u008d\u00018\u0006\u00a2\u0006\u000e\n\u0005\b\u001a\u0010\u008e\u0001\u001a\u0005\bR\u0010\u008f\u0001\u00a8\u0006\u0094\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$RecommendGuildViewHolder;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/delegate/GuildBaseItemDelegate$a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/n;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "T", "", "guildName", "Lkotlin/Function1;", "", "block", "b0", "", "isLeftItem", "f0", "a0", "guildId", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfoList", "name", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;", "styles", "d0", "H", "i0", "tagText", "k0", "j0", "channelStatus", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendLabel;", "tagList", "guildProfile", "guildNameLines", "Y", BdhLogUtil.LogTag.Tag_Req, "text", "size", "", "Z", "N", "E", "", "", "I", "", "scale", "y", "P", "joined", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.VISIBLE, "onVisibleChanged", "Lgh1/b;", "Lgh1/b;", "getExposeHelper", "()Lgh1/b;", "exposeHelper", "Ljh1/a;", UserInfo.SEX_FEMALE, "Ljh1/a;", "getExtraData", "()Ljh1/a;", WadlProxyConsts.EXTRA_DATA, "G", "isChangeItemViewSize", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem;", "mCardItem", "Lcom/tencent/mobileqq/guild/widget/shadow/GuildShadowLayout;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/guild/widget/shadow/GuildShadowLayout;", "shadowLayout", "Landroid/widget/RelativeLayout;", "J", "Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "topTagText", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "guildCover", "Landroid/view/View;", "M", "Landroid/view/View;", "guildCoverMask", "guildIcon", "()Landroid/view/View;", "guildIconBg", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "guildMedalIcon", ExifInterface.LATITUDE_SOUTH, "guildStatus", "guildRelationTag", "Landroid/widget/LinearLayout;", "U", "Landroid/widget/LinearLayout;", "guildTagContainer", "Lcom/tencent/mobileqq/guild/main/topchannel/widget/ChannelStatusView;", "V", "Lcom/tencent/mobileqq/guild/main/topchannel/widget/ChannelStatusView;", "guildChannelStatus", "W", "guildNormalText", "X", "guildNormalText2", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "joinGuildBtn", "Landroid/animation/Animator;", "Landroid/animation/Animator;", "scaleOutAnimator", "scaleInAnimator", "Landroid/graphics/drawable/Drawable;", "c0", "Lkotlin/Lazy;", "()Landroid/graphics/drawable/Drawable;", "onlineCircleDrawable", "Lcom/tencent/mobileqq/guild/api/impl/GuildDTReportApiImpl;", "Lcom/tencent/mobileqq/guild/api/impl/GuildDTReportApiImpl;", "reportApi", "e0", "isNightTheme", "getGuildNameLines", "()I", "(I)V", "g0", "getScale", "()F", "setScale", "(F)V", "Lcom/tencent/mobileqq/guild/theme/d;", "h0", "Lcom/tencent/mobileqq/guild/theme/d;", "()Lcom/tencent/mobileqq/guild/theme/d;", "setThemeChangeCallback", "(Lcom/tencent/mobileqq/guild/theme/d;)V", "themeChangeCallback", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "serviceObserver", "itemView", "<init>", "(Lgh1/b;Ljh1/a;Landroid/view/View;Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* loaded from: classes13.dex */
    public static final class RecommendGuildViewHolder extends GuildBaseItemDelegate.a implements n {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final gh1.b exposeHelper;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ExtraData extraData;

        /* renamed from: G, reason: from kotlin metadata */
        private final boolean isChangeItemViewSize;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private GuildRecommendCardItem mCardItem;

        /* renamed from: I, reason: from kotlin metadata */
        private final GuildShadowLayout shadowLayout;

        /* renamed from: J, reason: from kotlin metadata */
        private final RelativeLayout container;

        /* renamed from: K, reason: from kotlin metadata */
        private final TextView topTagText;

        /* renamed from: L, reason: from kotlin metadata */
        private final ImageView guildCover;

        /* renamed from: M, reason: from kotlin metadata */
        private final View guildCoverMask;

        /* renamed from: N, reason: from kotlin metadata */
        private final ImageView guildIcon;

        /* renamed from: P, reason: from kotlin metadata */
        private final View guildIconBg;

        /* renamed from: Q, reason: from kotlin metadata */
        private final ImageView guildMedalIcon;

        /* renamed from: R, reason: from kotlin metadata */
        private final TextView guildName;

        /* renamed from: S, reason: from kotlin metadata */
        private final ImageView guildStatus;

        /* renamed from: T, reason: from kotlin metadata */
        private final TextView guildRelationTag;

        /* renamed from: U, reason: from kotlin metadata */
        private final LinearLayout guildTagContainer;

        /* renamed from: V, reason: from kotlin metadata */
        private final ChannelStatusView guildChannelStatus;

        /* renamed from: W, reason: from kotlin metadata */
        private final TextView guildNormalText;

        /* renamed from: X, reason: from kotlin metadata */
        private final TextView guildNormalText2;

        /* renamed from: Y, reason: from kotlin metadata */
        private final TextView guildProfile;

        /* renamed from: Z, reason: from kotlin metadata */
        private final QUIButton joinGuildBtn;

        /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
        private final Animator scaleOutAnimator;

        /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
        private final Animator scaleInAnimator;

        /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy onlineCircleDrawable;

        /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildDTReportApiImpl reportApi;

        /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
        private boolean isNightTheme;

        /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
        private int guildNameLines;

        /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
        private float scale;

        /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.mobileqq.guild.theme.d themeChangeCallback;

        /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GPServiceObserver serviceObserver;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$RecommendGuildViewHolder$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onAddGuildNotInfo", "onRemoveGuild", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a extends GPServiceObserver {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Styles f216669e;

            a(Styles styles) {
                this.f216669e = styles;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
            protected void onAddGuildNotInfo(@Nullable String guildId) {
                GuildRecommendCardItem guildRecommendCardItem;
                if (guildId != null && (guildRecommendCardItem = RecommendGuildViewHolder.this.mCardItem) != null) {
                    RecommendGuildViewHolder recommendGuildViewHolder = RecommendGuildViewHolder.this;
                    Styles styles = this.f216669e;
                    if (Intrinsics.areEqual(guildId, guildRecommendCardItem.getGuildId())) {
                        recommendGuildViewHolder.i0(guildRecommendCardItem, styles);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
            public void onRemoveGuild(@Nullable String guildId) {
                GuildRecommendCardItem guildRecommendCardItem;
                if (guildId != null && (guildRecommendCardItem = RecommendGuildViewHolder.this.mCardItem) != null) {
                    RecommendGuildViewHolder recommendGuildViewHolder = RecommendGuildViewHolder.this;
                    Styles styles = this.f216669e;
                    if (Intrinsics.areEqual(guildId, guildRecommendCardItem.getGuildId())) {
                        recommendGuildViewHolder.i0(guildRecommendCardItem, styles);
                    }
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$RecommendGuildViewHolder$b", "Lcom/tencent/mobileqq/guild/theme/d;", "", "onThemeChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class b implements com.tencent.mobileqq.guild.theme.d {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Styles f216671e;

            b(Styles styles) {
                this.f216671e = styles;
            }

            @Override // com.tencent.mobileqq.guild.theme.d
            public void onThemeChanged() {
                View guildIconBg = RecommendGuildViewHolder.this.getGuildIconBg();
                GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
                Context context = RecommendGuildViewHolder.this.getGuildIconBg().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "guildIconBg.context");
                guildIconBg.setBackground(guildUIUtils.p(context, this.f216671e.getGuildIconBgColor(), 100, 8.8f, 0.0f));
            }
        }

        public /* synthetic */ RecommendGuildViewHolder(gh1.b bVar, ExtraData extraData, View view, Styles styles, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(bVar, extraData, view, styles, (i3 & 16) != 0 ? true : z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void B(RecommendGuildViewHolder this$0, GuildRecommendCardItem item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (!o.c("fastClickGuard")) {
                if (!q.l() && GuildJumpUtil.f(item.getGuildId(), "JoinGuildSuccessDialog")) {
                    ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoConversationGuild(this$0.itemView.getContext(), new JumpGuildParam(item.getGuildId(), ""));
                } else {
                    GuildJumpUtil.z(this$0.itemView.getContext(), item.getGuildId(), null, new GuildAppReportSourceInfo(OpenChannelUtil.f216755a.c(this$0.extraData.getTabType(), this$0.extraData.getPageFrom()), ""), null, 20, null);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void C(final RecommendGuildViewHolder this$0, final GuildRecommendCardItem item, final Styles styles, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(styles, "$styles");
            JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
            jumpParam.d(!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected());
            jumpParam.c(true);
            com.tencent.mobileqq.guild.channel.joinchannel.h.a(this$0.itemView.getContext(), GuildRecommendGuildCardDelegate.INSTANCE.e(this$0.extraData.getTabType(), this$0.extraData.getPageFrom(), item, this$0.extraData.getMainSource(), this$0.extraData.getSubSource()), jumpParam, "Guild.discovery.recommend.GuildRecommendChildPicDelegate", new bv() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.c
                @Override // vh2.bv
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.D(GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this, item, styles, i3, str, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(RecommendGuildViewHolder this$0, GuildRecommendCardItem item, Styles styles, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(styles, "$styles");
            if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
                this$0.A(item, true, styles);
                item.setJoinGuildFlag(2);
                this$0.N(item);
                return;
            }
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(this$0.itemView.getContext(), i3, str, iGProSecurityResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void E(GuildRecommendCardItem item, int guildNameLines) {
            this.reportApi.setElementExposureAllAndClickPolicy(this.itemView, "em_sgrp_discover_channel_card");
            VideoReport.setElementParams(this.itemView, I(item, guildNameLines));
            VideoReport.setElementReuseIdentifier(this.itemView, "itemView-" + item.hashCode());
            VideoReport.reportEvent("imp", this.itemView, I(item, guildNameLines));
            this.reportApi.setElementClickParams(this.joinGuildBtn, "em_sgrp_discover_channel_card_join_btn", I(item, guildNameLines));
            VideoReport.setElementReuseIdentifier(this.joinGuildBtn, "joinGuildBtn-" + item.hashCode());
            VideoReport.reportEvent("imp", this.joinGuildBtn, I(item, guildNameLines));
            VideoReport.setElementClickPolicy(this.joinGuildBtn, ClickPolicy.REPORT_ALL);
        }

        private final String H(String name, String guildId) {
            return name + "_" + guildId;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0113  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0105  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Map<String, Object> I(GuildRecommendCardItem item, int guildNameLines) {
            String str;
            String str2;
            Map<String, Object> mutableMapOf;
            int i3;
            boolean z16;
            Object obj = "";
            if (item.getFriendJoinedNum() <= 0) {
                str = "";
            } else {
                str = String.valueOf(item.getFriendJoinedNum());
            }
            if (guildNameLines <= 1) {
                if (item.getChannelStatusText().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    str2 = item.getChannelStatusText();
                    if (guildNameLines <= 1 && !item.getWuJiTags().isEmpty()) {
                        obj = item.getWuJiTags();
                    }
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_channel_id", item.getGuildId()), TuplesKt.to("sgrp_category_type", item.getCurCategoryName()), TuplesKt.to("sgrp_channel_category", item.getCurCategoryName()), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, item.getTraceId()), TuplesKt.to("sgrp_user_place", Integer.valueOf(item.getItemCategoryPosition())), TuplesKt.to("sgrp_channel_tags", str2), TuplesKt.to("sgrp_relationship_tags", str), TuplesKt.to("sgrp_state_tags", obj));
                    mutableMapOf.put("sgrp_user_place_card", Integer.valueOf(item.getItemCategoryPosition()));
                    if (!(!item.getTagList().isEmpty())) {
                        i3 = 0;
                        for (IGProRecommendLabel iGProRecommendLabel : item.getTagList()) {
                            if (iGProRecommendLabel.getBussiLabelType() == 1) {
                                mutableMapOf.put("sgrp_search_tag1", iGProRecommendLabel.getLabelName());
                                i3++;
                            }
                            if (iGProRecommendLabel.getBussiLabelType() == 2 && guildNameLines == 1) {
                                mutableMapOf.put("sgrp_search_tag2", iGProRecommendLabel.getLabelName());
                                i3++;
                            }
                        }
                    } else {
                        i3 = 0;
                    }
                    if (!item.getMedalInfoList().isEmpty()) {
                        List<IGProMedalInfo> t16 = GuildMedalUtils.t(new ArrayList(item.getMedalInfoList()), 0, 2, null);
                        StringBuffer stringBuffer = new StringBuffer();
                        if (!t16.isEmpty()) {
                            i3++;
                            for (IGProMedalInfo iGProMedalInfo : t16) {
                                if (!TextUtils.isEmpty(iGProMedalInfo.getName())) {
                                    stringBuffer.append(iGProMedalInfo.getName());
                                    stringBuffer.append(",");
                                }
                            }
                            mutableMapOf.put("sgrp_search_tag4", stringBuffer);
                        }
                    }
                    mutableMapOf.put("sgrp_search_tag_count", Integer.valueOf(i3));
                    mutableMapOf.putAll(item.getDtParams());
                    return mutableMapOf;
                }
            }
            str2 = "";
            if (guildNameLines <= 1) {
                obj = item.getWuJiTags();
            }
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_channel_id", item.getGuildId()), TuplesKt.to("sgrp_category_type", item.getCurCategoryName()), TuplesKt.to("sgrp_channel_category", item.getCurCategoryName()), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, item.getTraceId()), TuplesKt.to("sgrp_user_place", Integer.valueOf(item.getItemCategoryPosition())), TuplesKt.to("sgrp_channel_tags", str2), TuplesKt.to("sgrp_relationship_tags", str), TuplesKt.to("sgrp_state_tags", obj));
            mutableMapOf.put("sgrp_user_place_card", Integer.valueOf(item.getItemCategoryPosition()));
            if (!(!item.getTagList().isEmpty())) {
            }
            if (!item.getMedalInfoList().isEmpty()) {
            }
            mutableMapOf.put("sgrp_search_tag_count", Integer.valueOf(i3));
            mutableMapOf.putAll(item.getDtParams());
            return mutableMapOf;
        }

        private final Drawable K() {
            return (Drawable) this.onlineCircleDrawable.getValue();
        }

        private final void N(GuildRecommendCardItem item) {
            ArrayList<String> arrayListOf;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            Companion companion = GuildRecommendGuildCardDelegate.INSTANCE;
            GuildJumpUtil.n(context, companion.e(this.extraData.getTabType(), this.extraData.getPageFrom(), item, this.extraData.getMainSource(), this.extraData.getSubSource()));
            IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(item.getGuildId());
            iGPSService.reportUserViewGuild(arrayListOf, mh1.a.c(mh1.a.f416777a, this.extraData.getPageFrom(), null, 2, null), Companion.c(companion, this.extraData.getTabType(), this.extraData.getPageFrom(), null, 4, null), 2, new em() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.g
                @Override // wh2.em
                public final void onResult(int i3, String str) {
                    GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.O(i3, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void O(int i3, String str) {
            if (i3 != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str2 = "reportUserViewGuild failed result: " + i3 + ", errMsg: " + str;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.discovery.recommend.GuildRecommendChildPicDelegate", 1, (String) it.next(), null);
                }
            }
        }

        private final void R(String guildProfile) {
            boolean z16;
            int roundToInt;
            if (guildProfile.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.guildTagContainer.setVisibility(0);
                this.guildProfile.setVisibility(0);
                TextView textView = this.guildProfile;
                roundToInt = MathKt__MathJVMKt.roundToInt(13 / this.scale);
                textView.setText(Z(guildProfile, roundToInt));
                TextView guildName = this.guildName;
                Intrinsics.checkNotNullExpressionValue(guildName, "guildName");
                t.g(guildName, 0, 0, 0, GuildRecommendGuildCardDelegate.f216655m, 0, 0, 55, null);
                LinearLayout guildTagContainer = this.guildTagContainer;
                Intrinsics.checkNotNullExpressionValue(guildTagContainer, "guildTagContainer");
                t.g(guildTagContainer, 0, 0, 0, GuildRecommendGuildCardDelegate.C, 0, 0, 55, null);
                return;
            }
            TextView guildName2 = this.guildName;
            Intrinsics.checkNotNullExpressionValue(guildName2, "guildName");
            t.g(guildName2, 0, 0, 0, GuildRecommendGuildCardDelegate.D, 0, 0, 55, null);
            LinearLayout guildTagContainer2 = this.guildTagContainer;
            Intrinsics.checkNotNullExpressionValue(guildTagContainer2, "guildTagContainer");
            t.g(guildTagContainer2, 0, 0, 0, GuildRecommendGuildCardDelegate.E, 0, 0, 55, null);
            this.guildProfile.setVisibility(4);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        private final void T(final GuildRecommendCardItem item) {
            this.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.e
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean U;
                    U = GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.U(GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this, view, motionEvent);
                    return U;
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.W(GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean U(RecommendGuildViewHolder this$0, View view, MotionEvent motionEvent) {
            Integer num;
            boolean z16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (motionEvent != null) {
                num = Integer.valueOf(motionEvent.getAction());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                this$0.scaleInAnimator.start();
            } else {
                boolean z17 = true;
                if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 4)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && (num == null || num.intValue() != 3)) {
                    z17 = false;
                }
                if (z17) {
                    this$0.scaleOutAnimator.start();
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void W(RecommendGuildViewHolder this$0, GuildRecommendCardItem item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (!o.c("fastClickGuard")) {
                this$0.N(item);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void Y(int channelStatus, List<? extends IGProRecommendLabel> tagList, String guildProfile, int guildNameLines, Styles styles) {
            int roundToInt;
            int roundToInt2;
            int roundToInt3;
            ax.a(this.guildStatus, channelStatus, false);
            this.guildTagContainer.setVisibility(0);
            this.guildRelationTag.setVisibility(8);
            this.guildNormalText.setVisibility(8);
            this.guildNormalText2.setVisibility(8);
            this.guildProfile.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            if (!tagList.isEmpty()) {
                for (IGProRecommendLabel iGProRecommendLabel : tagList) {
                    if (iGProRecommendLabel.getBussiLabelType() == 1 && !TextUtils.isEmpty(iGProRecommendLabel.getLabelName())) {
                        this.guildRelationTag.setVisibility(0);
                        if (iGProRecommendLabel.getLabelType() != 17) {
                            this.guildRelationTag.setCompoundDrawablePadding(GuildRecommendGuildCardDelegate.E);
                            K().setBounds(0, 0, K().getIntrinsicWidth(), K().getIntrinsicHeight());
                            this.guildRelationTag.setCompoundDrawables(K(), null, null, null);
                        } else {
                            this.guildRelationTag.setCompoundDrawables(null, null, null, null);
                        }
                        this.guildRelationTag.setText(iGProRecommendLabel.getLabelName());
                    }
                    if (iGProRecommendLabel.getBussiLabelType() == 2) {
                        arrayList.add(iGProRecommendLabel);
                        this.guildNormalText.setVisibility(0);
                        if (iGProRecommendLabel.getLabelType() == 2) {
                            bq bqVar = bq.f235472a;
                            TextView guildNormalText = this.guildNormalText;
                            Intrinsics.checkNotNullExpressionValue(guildNormalText, "guildNormalText");
                            String labelName = iGProRecommendLabel.getLabelName();
                            Intrinsics.checkNotNullExpressionValue(labelName, "label.labelName");
                            int blue = styles.getBlue();
                            GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
                            Context context = this.guildNormalText.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "guildNormalText.context");
                            bqVar.e(guildNormalText, labelName, blue, guildUIUtils.p(context, styles.getBlue(), 12, 3.0f, 0.5f));
                        } else {
                            bq bqVar2 = bq.f235472a;
                            TextView guildNormalText2 = this.guildNormalText;
                            Intrinsics.checkNotNullExpressionValue(guildNormalText2, "guildNormalText");
                            String labelName2 = iGProRecommendLabel.getLabelName();
                            Intrinsics.checkNotNullExpressionValue(labelName2, "label.labelName");
                            bqVar2.b(guildNormalText2, labelName2, styles.getGray(), styles.getGrayBg());
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                R(guildProfile);
            }
            if (guildNameLines > 1) {
                this.guildRelationTag.setVisibility(8);
                TextView guildName = this.guildName;
                Intrinsics.checkNotNullExpressionValue(guildName, "guildName");
                roundToInt3 = MathKt__MathJVMKt.roundToInt(GuildRecommendGuildCardDelegate.D / this.scale);
                t.g(guildName, 0, 0, 0, roundToInt3, 0, 0, 55, null);
                return;
            }
            TextView guildName2 = this.guildName;
            Intrinsics.checkNotNullExpressionValue(guildName2, "guildName");
            roundToInt = MathKt__MathJVMKt.roundToInt(GuildRecommendGuildCardDelegate.D / this.scale);
            t.g(guildName2, 0, 0, 0, roundToInt, 0, 0, 55, null);
            LinearLayout guildTagContainer = this.guildTagContainer;
            Intrinsics.checkNotNullExpressionValue(guildTagContainer, "guildTagContainer");
            roundToInt2 = MathKt__MathJVMKt.roundToInt(GuildRecommendGuildCardDelegate.E / this.scale);
            t.g(guildTagContainer, 0, 0, 0, roundToInt2, 0, 0, 55, null);
        }

        private final CharSequence Z(String text, int size) {
            QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(text, size);
            Intrinsics.checkNotNullExpressionValue(qQText, "api(IGuildEmotionCodecAp\u2026ava).toQQText(text, size)");
            return qQText;
        }

        private final void a0() {
            this.guildChannelStatus.getLayoutParams().height = ViewUtils.dpToPx(19.0f);
            this.guildChannelStatus.getRoot().getLayoutParams().height = ViewUtils.dpToPx(19.0f);
        }

        private final void b0(final String guildName, final Function1<? super Integer, Unit> block) {
            this.guildName.setText(guildName);
            this.itemView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.h
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.c0(Function1.this, this, guildName);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c0(Function1 block, RecommendGuildViewHolder this$0, String guildName) {
            Intrinsics.checkNotNullParameter(block, "$block");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(guildName, "$guildName");
            block.invoke(Integer.valueOf(this$0.guildName.getLineCount()));
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.discovery.recommend.GuildRecommendChildPicDelegate", "updateGuildName lineCount:" + this$0.guildName.getLineCount() + " " + guildName);
            }
        }

        private final void d0(String guildId, List<? extends IGProMedalInfo> medalInfoList, final String name, final GuildRecommendCardItem item, final Styles styles) {
            String H = H(name, guildId);
            if (Intrinsics.areEqual(this.guildName.getTag(), H)) {
                return;
            }
            this.guildName.setTag(H);
            final List<IGProMedalInfo> s16 = GuildMedalUtils.s(new ArrayList(medalInfoList), 1);
            if (s16.isEmpty()) {
                P(item.getGuildName(), item, styles);
            } else {
                this.guildName.setText(name);
                this.guildName.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.e0(name, s16, this, item, styles);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e0(String name, List validMediaList, final RecommendGuildViewHolder this$0, final GuildRecommendCardItem item, final Styles styles) {
            Intrinsics.checkNotNullParameter(name, "$name");
            Intrinsics.checkNotNullParameter(validMediaList, "$validMediaList");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(styles, "$styles");
            GuildMedalUtils guildMedalUtils = GuildMedalUtils.f235347a;
            TextView guildName = this$0.guildName;
            Intrinsics.checkNotNullExpressionValue(guildName, "guildName");
            GuildMedalUtils.w(guildMedalUtils, name, validMediaList, guildName, null, 0, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate$RecommendGuildViewHolder$updateGuildNameAndMedalIcon$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String ellipsizeGuildName) {
                    Intrinsics.checkNotNullParameter(ellipsizeGuildName, "ellipsizeGuildName");
                    GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this.P(ellipsizeGuildName, item, styles);
                }
            }, 24, null);
        }

        private final void f0(boolean isLeftItem) {
            if (!this.isChangeItemViewSize) {
                return;
            }
            if (isLeftItem) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                t.g(itemView, GuildRecommendGuildCardDelegate.f216655m, 0, 0, 0, 0, 0, 60, null);
            } else {
                View itemView2 = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                t.g(itemView2, 0, GuildRecommendGuildCardDelegate.f216655m, 0, 0, 0, 0, 60, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i0(GuildRecommendCardItem item, Styles styles) {
            if (ch.j0(item.getGuildId())) {
                this.joinGuildBtn.setVisibility(0);
                A(item, false, styles);
            } else {
                A(item, true, styles);
            }
        }

        private final void j0() {
            if (this.isChangeItemViewSize) {
                GuildShadowLayout shadowLayout = this.shadowLayout;
                Intrinsics.checkNotNullExpressionValue(shadowLayout, "shadowLayout");
                GuildShadowLayout.setShadowLayoutAttrs$default(shadowLayout, 0.0f, 0.0f, 4.0f, 3, null);
                this.itemView.getLayoutParams().height = ViewUtils.dpToPx(210.0f);
            }
            this.guildCover.getLayoutParams().height = ViewUtils.dpToPx(62.0f / this.scale);
            this.guildCoverMask.getLayoutParams().height = ViewUtils.dpToPx(62.0f / this.scale);
            ViewGroup.LayoutParams layoutParams = this.guildIcon.getLayoutParams();
            layoutParams.width = ViewUtils.dpToPx(48.0f / this.scale);
            layoutParams.height = ViewUtils.dpToPx(48.0f / this.scale);
            ViewGroup.LayoutParams layoutParams2 = this.guildIconBg.getLayoutParams();
            layoutParams2.width = ViewUtils.dpToPx(52.0f / this.scale);
            layoutParams2.height = ViewUtils.dpToPx(52.0f / this.scale);
            ViewGroup.LayoutParams layoutParams3 = this.guildIconBg.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.setMargins(0, -ViewUtils.dpToPx(40.0f), 0, 0);
            this.guildIconBg.setLayoutParams(layoutParams4);
            this.guildName.setTextSize(2, 14.0f / this.scale);
            ViewGroup.LayoutParams layoutParams5 = this.guildName.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
            layoutParams6.setMargins(ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(0.0f), ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(0.0f));
            this.guildName.setLayoutParams(layoutParams6);
            ViewGroup.LayoutParams layoutParams7 = this.guildTagContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
            layoutParams8.setMargins(ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(-2.0f), ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(0.0f));
            this.guildTagContainer.setLayoutParams(layoutParams8);
            this.guildChannelStatus.getLayoutParams().height = ViewUtils.dpToPx(16.0f / this.scale);
            this.guildChannelStatus.getRoot().getLayoutParams().height = ViewUtils.dpToPx(16.0f / this.scale);
            ViewGroup.LayoutParams layoutParams9 = this.guildChannelStatus.getCom.tencent.qq.effect.engine.QEffectType.LOTTIE_TAG java.lang.String().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams9.width = ViewUtils.dpToPx(11.0f / this.scale);
            layoutParams9.height = ViewUtils.dpToPx(11.0f / this.scale);
            this.guildChannelStatus.getCom.tencent.qq.effect.engine.QEffectType.LOTTIE_TAG java.lang.String().setLayoutParams(layoutParams9);
            this.guildChannelStatus.getText().setTextSize(2, 11.0f / this.scale);
            this.guildNormalText.getLayoutParams().height = ViewUtils.dpToPx(16.0f / this.scale);
            this.guildNormalText.setTextSize(2, 11.0f / this.scale);
            this.guildNormalText2.getLayoutParams().height = ViewUtils.dpToPx(16.0f / this.scale);
            this.guildNormalText2.setTextSize(2, 11.0f / this.scale);
            this.guildProfile.setTextSize(2, 12.0f / this.scale);
            this.guildRelationTag.setTextSize(2, 12.0f / this.scale);
            ViewGroup.LayoutParams layoutParams10 = this.guildRelationTag.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams10, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) layoutParams10;
            layoutParams11.setMargins(0, 0, 0, ViewUtils.dpToPx(7.0f));
            this.guildRelationTag.setLayoutParams(layoutParams11);
        }

        private final void k0(String tagText) {
            boolean z16;
            if (tagText.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.topTagText.setVisibility(8);
            } else {
                this.topTagText.setVisibility(0);
                this.topTagText.setText(tagText);
            }
        }

        public static /* synthetic */ void z(RecommendGuildViewHolder recommendGuildViewHolder, GuildRecommendCardItem guildRecommendCardItem, Styles styles, float f16, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                f16 = 1.0f;
            }
            recommendGuildViewHolder.y(guildRecommendCardItem, styles, f16);
        }

        public final void A(@NotNull final GuildRecommendCardItem item, boolean joined, @NotNull final Styles styles) {
            boolean z16;
            float f16;
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(styles, "styles");
            if (this.scale > 1.0f) {
                if (joined) {
                    f16 = 22.0f;
                } else {
                    f16 = 24.0f;
                }
                int dpToPx = ViewUtils.dpToPx(f16);
                QUIButton joinGuildBtn = this.joinGuildBtn;
                Intrinsics.checkNotNullExpressionValue(joinGuildBtn, "joinGuildBtn");
                t.g(joinGuildBtn, dpToPx, dpToPx, 0, 0, 0, 0, 60, null);
            }
            if (joined) {
                this.joinGuildBtn.setText("\u53bb\u9891\u9053");
                this.joinGuildBtn.setType(styles.getJoinedBtnType());
                this.joinGuildBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.B(GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this, item, view);
                    }
                });
                return;
            }
            String joinGuildSig = item.getJoinGuildSig();
            boolean z17 = false;
            if (joinGuildSig != null) {
                if (joinGuildSig.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "joinGuildSig is empty: " + item.getGuildId();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.discovery.recommend.GuildRecommendChildPicDelegate", 1, (String) it.next(), null);
                }
            }
            this.joinGuildBtn.setText("\u52a0\u5165");
            this.joinGuildBtn.setType(styles.getJoinBtnType());
            this.joinGuildBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.C(GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this, item, styles, view);
                }
            });
        }

        /* renamed from: J, reason: from getter */
        public final View getGuildIconBg() {
            return this.guildIconBg;
        }

        @NotNull
        /* renamed from: L, reason: from getter */
        public final GPServiceObserver getServiceObserver() {
            return this.serviceObserver;
        }

        @NotNull
        /* renamed from: M, reason: from getter */
        public final com.tencent.mobileqq.guild.theme.d getThemeChangeCallback() {
            return this.themeChangeCallback;
        }

        public final void P(@NotNull String name, @NotNull final GuildRecommendCardItem item, @NotNull final Styles styles) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(styles, "styles");
            b0(name, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate$RecommendGuildViewHolder$setGuildName$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this.Y(item.getChannelStatus(), item.getTagList(), item.getGuildProfile(), i3, styles);
                    GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this.E(item, i3);
                    GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this.Q(i3);
                }
            });
        }

        public final void Q(int i3) {
            this.guildNameLines = i3;
        }

        @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.n
        public void onVisibleChanged(boolean visible) {
            String str;
            if (visible && this.mCardItem != null) {
                gh1.b bVar = this.exposeHelper;
                GuildRecommendCardItem guildRecommendCardItem = this.mCardItem;
                Intrinsics.checkNotNull(guildRecommendCardItem);
                String itemId = guildRecommendCardItem.getItemId();
                GuildRecommendCardItem guildRecommendCardItem2 = this.mCardItem;
                Intrinsics.checkNotNull(guildRecommendCardItem2);
                IGProItemCbData callback = guildRecommendCardItem2.getRecommendExtra().getCallback();
                byte[] bArr = null;
                if (callback != null) {
                    str = callback.getStatData();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                GuildRecommendCardItem guildRecommendCardItem3 = this.mCardItem;
                Intrinsics.checkNotNull(guildRecommendCardItem3);
                IGProItemCbData callback2 = guildRecommendCardItem3.getRecommendExtra().getCallback();
                if (callback2 != null) {
                    bArr = callback2.getCbExtData();
                }
                if (bArr == null) {
                    bArr = new byte[0];
                }
                bVar.i(new ExposeModel(itemId, str, bArr));
            }
            GuildRecommendCardItem guildRecommendCardItem4 = this.mCardItem;
            if (guildRecommendCardItem4 != null && this.guildNameLines > 0 && !visible) {
                View view = this.itemView;
                Intrinsics.checkNotNull(guildRecommendCardItem4);
                VideoReport.reportEvent("imp_end", view, I(guildRecommendCardItem4, this.guildNameLines));
                QUIButton qUIButton = this.joinGuildBtn;
                GuildRecommendCardItem guildRecommendCardItem5 = this.mCardItem;
                Intrinsics.checkNotNull(guildRecommendCardItem5);
                VideoReport.reportEvent("imp_end", qUIButton, I(guildRecommendCardItem5, this.guildNameLines));
            }
        }

        public final void y(@NotNull GuildRecommendCardItem item, @NotNull Styles styles, float scale) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(styles, "styles");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.discovery.recommend.GuildRecommendChildPicDelegate", "item=" + item);
            }
            this.scale = scale;
            this.mCardItem = item;
            T(item);
            if (!this.extraData.getIsStandalonePage() && !DiscoveryConstants$PageFrom.INSTANCE.a(this.extraData.getPageFrom()) && item.isShowInGuildRecommendTab()) {
                j0();
                k0(item.getTopTagText());
            } else {
                if (new dh1.b().a(dh1.a.f393835a.a()) == 2) {
                    f0(item.isLeftItem());
                }
                a0();
            }
            if (!this.isChangeItemViewSize) {
                j0();
            }
            d0(item.getGuildId(), item.getMedalInfoList(), item.getGuildName(), item, styles);
            v vVar = v.f235697a;
            String guildCoverUrl = item.getGuildCoverUrl();
            ImageView guildCover = this.guildCover;
            Intrinsics.checkNotNullExpressionValue(guildCover, "guildCover");
            vVar.j(guildCoverUrl, guildCover, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate$RecommendGuildViewHolder$bind$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Option option) {
                    invoke2(option);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Option loadImage) {
                    Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
                    loadImage.setFailedDrawableColor(GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                    loadImage.setLoadingDrawableColor(GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                    loadImage.setRequestHeight(ViewUtils.dpToPx(73.3f));
                }
            });
            boolean b16 = GuildThemeManager.f235286a.b();
            if (this.isNightTheme != b16) {
                this.isNightTheme = b16;
                com.tencent.mobileqq.guild.theme.c.a(this.itemView);
            }
            if (b16) {
                this.guildCoverMask.setVisibility(0);
            } else {
                this.guildCoverMask.setVisibility(8);
            }
            String guildIconUrl = item.getGuildIconUrl();
            ImageView guildIcon = this.guildIcon;
            Intrinsics.checkNotNullExpressionValue(guildIcon, "guildIcon");
            vVar.j(guildIconUrl, guildIcon, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate$RecommendGuildViewHolder$bind$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Option option) {
                    invoke2(option);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Option loadImage) {
                    Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
                    loadImage.setFailedDrawableColor(GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                    loadImage.setLoadingDrawableColor(GuildRecommendGuildCardDelegate.RecommendGuildViewHolder.this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                }
            });
            i0(item, styles);
            TextView topTagText = this.topTagText;
            Intrinsics.checkNotNullExpressionValue(topTagText, "topTagText");
            oh1.a.a(topTagText, styles.getTagTextColor());
            TextView guildName = this.guildName;
            Intrinsics.checkNotNullExpressionValue(guildName, "guildName");
            oh1.a.a(guildName, styles.getTitleColor());
            TextView guildRelationTag = this.guildRelationTag;
            Intrinsics.checkNotNullExpressionValue(guildRelationTag, "guildRelationTag");
            oh1.a.a(guildRelationTag, styles.getSubTitleColor());
            TextView guildProfile = this.guildProfile;
            Intrinsics.checkNotNullExpressionValue(guildProfile, "guildProfile");
            oh1.a.a(guildProfile, styles.getSubTitleColor());
            this.container.setBackgroundResource(styles.getContainerDrawable());
            View view = this.guildIconBg;
            GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "guildIconBg.context");
            view.setBackground(guildUIUtils.p(context, styles.getGuildIconBgColor(), 100, 8.8f, 0.0f));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecommendGuildViewHolder(@NotNull gh1.b exposeHelper, @NotNull ExtraData extraData, @NotNull final View itemView, @NotNull final Styles styles, boolean z16) {
            super(itemView);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(exposeHelper, "exposeHelper");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(styles, "styles");
            this.exposeHelper = exposeHelper;
            this.extraData = extraData;
            this.isChangeItemViewSize = z16;
            this.shadowLayout = (GuildShadowLayout) this.itemView.findViewById(R.id.f84054l8);
            this.container = (RelativeLayout) this.itemView.findViewById(R.id.b8q);
            this.topTagText = (TextView) this.itemView.findViewById(R.id.jb7);
            this.guildCover = (ImageView) this.itemView.findViewById(R.id.wv9);
            this.guildCoverMask = this.itemView.findViewById(R.id.wv_);
            this.guildIcon = (ImageView) this.itemView.findViewById(R.id.wva);
            this.guildIconBg = this.itemView.findViewById(R.id.wvb);
            this.guildMedalIcon = (ImageView) this.itemView.findViewById(R.id.wvc);
            this.guildName = (TextView) this.itemView.findViewById(R.id.wvd);
            this.guildStatus = (ImageView) this.itemView.findViewById(R.id.vvo);
            this.guildRelationTag = (TextView) this.itemView.findViewById(R.id.wvp);
            this.guildTagContainer = (LinearLayout) this.itemView.findViewById(R.id.wv7);
            this.guildChannelStatus = (ChannelStatusView) this.itemView.findViewById(R.id.wv6);
            this.guildNormalText = (TextView) this.itemView.findViewById(R.id.wvn);
            this.guildNormalText2 = (TextView) this.itemView.findViewById(R.id.wvo);
            this.guildProfile = (TextView) this.itemView.findViewById(R.id.wve);
            this.joinGuildBtn = (QUIButton) this.itemView.findViewById(R.id.wvm);
            View view = this.itemView;
            Companion companion = GuildRecommendGuildCardDelegate.INSTANCE;
            this.scaleOutAnimator = ve1.a.a(view, companion.a(), 1.0f);
            this.scaleInAnimator = ve1.a.a(this.itemView, 1.0f, companion.a());
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate$RecommendGuildViewHolder$onlineCircleDrawable$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Drawable invoke() {
                    return itemView.getResources().getDrawable(styles.getStateDescPointDrawable());
                }
            });
            this.onlineCircleDrawable = lazy;
            this.reportApi = new GuildDTReportApiImpl();
            this.isNightTheme = GuildThemeManager.f235286a.b();
            this.scale = 1.0f;
            this.themeChangeCallback = new b(styles);
            this.serviceObserver = new a(styles);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B{\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011j\u0002\b\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$Styles;", "", "tagTextColor", "", "titleColor", "subTitleColor", "containerDrawable", "guildIconBgColor", "stateDescPointDrawable", "stateDescTextColor", "blue", "gray", "grayBg", "joinBtnType", "joinedBtnType", "(Ljava/lang/String;IIIIIIIIIIIII)V", "getBlue", "()I", "getContainerDrawable", "getGray", "getGrayBg", "getGuildIconBgColor", "getJoinBtnType", "getJoinedBtnType", "getStateDescPointDrawable", "getStateDescTextColor", "getSubTitleColor", "getTagTextColor", "getTitleColor", "TOKEN", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum Styles {
        TOKEN(R.color.qui_common_text_allwhite_primary, R.color.qui_common_text_primary, R.color.qui_common_text_secondary_light, R.drawable.qui_common_fill_light_secondary_bg_corner_8, R.color.qui_common_fill_light_secondary, R.drawable.guild_token_recommend_circle_0cce6d_6dp, R.color.qui_common_text_allwhite_primary, R.color.qui_common_brand_standard, R.color.qui_common_text_secondary_light, R.drawable.guild_token_theme_collection_label_normal_bg, 0, 1);

        private final int blue;
        private final int containerDrawable;
        private final int gray;
        private final int grayBg;
        private final int guildIconBgColor;
        private final int joinBtnType;
        private final int joinedBtnType;
        private final int stateDescPointDrawable;
        private final int stateDescTextColor;
        private final int subTitleColor;
        private final int tagTextColor;
        private final int titleColor;

        Styles(@ColorRes int i3, @ColorRes int i16, @ColorRes int i17, @DrawableRes int i18, @ColorRes int i19, @DrawableRes int i26, @ColorRes int i27, @ColorRes int i28, @ColorRes int i29, @DrawableRes int i36, int i37, int i38) {
            this.tagTextColor = i3;
            this.titleColor = i16;
            this.subTitleColor = i17;
            this.containerDrawable = i18;
            this.guildIconBgColor = i19;
            this.stateDescPointDrawable = i26;
            this.stateDescTextColor = i27;
            this.blue = i28;
            this.gray = i29;
            this.grayBg = i36;
            this.joinBtnType = i37;
            this.joinedBtnType = i38;
        }

        public final int getBlue() {
            return this.blue;
        }

        public final int getContainerDrawable() {
            return this.containerDrawable;
        }

        public final int getGray() {
            return this.gray;
        }

        public final int getGrayBg() {
            return this.grayBg;
        }

        public final int getGuildIconBgColor() {
            return this.guildIconBgColor;
        }

        public final int getJoinBtnType() {
            return this.joinBtnType;
        }

        public final int getJoinedBtnType() {
            return this.joinedBtnType;
        }

        public final int getStateDescPointDrawable() {
            return this.stateDescPointDrawable;
        }

        public final int getStateDescTextColor() {
            return this.stateDescTextColor;
        }

        public final int getSubTitleColor() {
            return this.subTitleColor;
        }

        public final int getTagTextColor() {
            return this.tagTextColor;
        }

        public final int getTitleColor() {
            return this.titleColor;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002JB\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tJ2\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tJ \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\tR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001dR\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u001dR\u0014\u0010'\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$a;", "", "", "state", "", "d", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "tabType", "pageFrom", "", "guildId", "channelId", "joinGuildSig", "mainSource", "subSource", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "f", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "e", "b", "", "ITEM_VIEW_SCALE_RATIO", UserInfo.SEX_FEMALE, "a", "()F", "setITEM_VIEW_SCALE_RATIO", "(F)V", "DP_10", "I", "DP_5_3", "DP_6_7", "DP_8", "GUILD_STATE_KAIHEI", "GUILD_STATE_LIVE", "GUILD_STATE_VOICE", "GUILD_STATE_WORLD", "GUILD_STATUS_PADDING_HORIZONTAL", "MIN_GUILD_NAME_LINES", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String c(Companion companion, DiscoverTabType discoverTabType, int i3, String str, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                str = "";
            }
            return companion.b(discoverTabType, i3, str);
        }

        public static /* synthetic */ JumpGuildParam g(Companion companion, DiscoverTabType discoverTabType, int i3, String str, String str2, String str3, String str4, String str5, int i16, Object obj) {
            String str6;
            String str7;
            if ((i16 & 32) != 0) {
                str6 = "";
            } else {
                str6 = str4;
            }
            if ((i16 & 64) != 0) {
                str7 = "";
            } else {
                str7 = str5;
            }
            return companion.f(discoverTabType, i3, str, str2, str3, str6, str7);
        }

        public final float a() {
            return GuildRecommendGuildCardDelegate.G;
        }

        @NotNull
        public final String b(@NotNull DiscoverTabType tabType, int pageFrom, @NotNull String subSource) {
            Intrinsics.checkNotNullParameter(tabType, "tabType");
            Intrinsics.checkNotNullParameter(subSource, "subSource");
            if (pageFrom != 8) {
                int i3 = 9;
                if (pageFrom != 9) {
                    ch1.c cVar = ch1.c.f30841a;
                    boolean z16 = true;
                    if (tabType.getTabType() == 3) {
                        i3 = 1;
                    }
                    String a16 = cVar.a(pageFrom, tabType, i3);
                    if (a16.length() <= 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        a16 = null;
                    }
                    if (a16 == null) {
                        return "discover_category_recommend";
                    }
                    return a16;
                }
            }
            return subSource;
        }

        public final boolean d(int state) {
            if (state == 1 || state == 4 || state == 8 || state == 9) {
                return true;
            }
            return false;
        }

        @NotNull
        public final JumpGuildParam e(@NotNull DiscoverTabType tabType, int pageFrom, @NotNull GuildRecommendCardItem item, @NotNull String mainSource, @NotNull String subSource) {
            Intrinsics.checkNotNullParameter(tabType, "tabType");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(mainSource, "mainSource");
            Intrinsics.checkNotNullParameter(subSource, "subSource");
            JumpGuildParam jumpGuildParam = new JumpGuildParam(item.getGuildId(), "", item.getJoinGuildSig(), mh1.a.f416777a.b(pageFrom, mainSource), b(tabType, pageFrom, subSource));
            jumpGuildParam.setReportSourceInfo(new GuildAppReportSourceInfo(OpenChannelUtil.f216755a.c(tabType, pageFrom), ""));
            return jumpGuildParam;
        }

        @NotNull
        public final JumpGuildParam f(@NotNull DiscoverTabType tabType, int pageFrom, @NotNull String guildId, @NotNull String channelId, @NotNull String joinGuildSig, @NotNull String mainSource, @NotNull String subSource) {
            Intrinsics.checkNotNullParameter(tabType, "tabType");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(joinGuildSig, "joinGuildSig");
            Intrinsics.checkNotNullParameter(mainSource, "mainSource");
            Intrinsics.checkNotNullParameter(subSource, "subSource");
            JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, channelId, joinGuildSig, mh1.a.f416777a.b(pageFrom, mainSource), b(tabType, pageFrom, subSource));
            jumpGuildParam.setReportSourceInfo(new GuildAppReportSourceInfo(OpenChannelUtil.f216755a.c(tabType, pageFrom), ""));
            return jumpGuildParam;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/discovery/guildblockdetail/delegates/GuildRecommendGuildCardDelegate$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecommendGuildViewHolder f216672d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f216673e;

        b(RecommendGuildViewHolder recommendGuildViewHolder, View view) {
            this.f216672d = recommendGuildViewHolder;
            this.f216673e = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            GuildThemeManager.h(this.f216672d.getThemeChangeCallback());
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            this.f216673e.removeOnAttachStateChangeListener(this);
            GuildThemeManager.j(this.f216672d.getThemeChangeCallback());
        }
    }

    public /* synthetic */ GuildRecommendGuildCardDelegate(gh1.b bVar, ExtraData extraData, LifecycleOwner lifecycleOwner, Styles styles, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, extraData, lifecycleOwner, (i3 & 8) != 0 ? Styles.TOKEN : styles);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void g(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.g(holder);
        if (holder instanceof RecommendGuildViewHolder) {
            ((IGPSService) ch.R0(IGPSService.class)).addObserver(((RecommendGuildViewHolder) holder).getServiceObserver());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
        if (holder instanceof RecommendGuildViewHolder) {
            ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(((RecommendGuildViewHolder) holder).getServiceObserver());
        }
    }

    @Override // com.tencent.mobileqq.guild.discovery.avblockdetail.delegate.GuildBaseItemDelegate
    public int o() {
        return R.layout.f168157f41;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.discovery.avblockdetail.model.a item, @NotNull List<com.tencent.mobileqq.guild.discovery.avblockdetail.model.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GuildRecommendCardItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull GuildRecommendCardItem item, @NotNull RecommendGuildViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if ((!payloads.isEmpty()) && Intrinsics.areEqual(payloads.get(0), item.getGuildId())) {
            holder.A(item, true, this.styles);
        } else {
            RecommendGuildViewHolder.z(holder, item, this.styles, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public RecommendGuildViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View p16 = p(parent);
        RecommendGuildViewHolder recommendGuildViewHolder = new RecommendGuildViewHolder(this.exposeHelper, this.extraData, p16, this.styles, false, 16, null);
        p16.addOnAttachStateChangeListener(new b(recommendGuildViewHolder, p16));
        return recommendGuildViewHolder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRecommendGuildCardDelegate(@NotNull gh1.b exposeHelper, @NotNull ExtraData extraData, @NotNull LifecycleOwner viewLifecycleOwner, @NotNull Styles styles) {
        super(viewLifecycleOwner);
        Intrinsics.checkNotNullParameter(exposeHelper, "exposeHelper");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(styles, "styles");
        this.exposeHelper = exposeHelper;
        this.extraData = extraData;
        this.styles = styles;
    }
}
