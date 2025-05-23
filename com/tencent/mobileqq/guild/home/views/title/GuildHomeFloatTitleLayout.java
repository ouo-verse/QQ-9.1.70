package com.tencent.mobileqq.guild.home.views.title;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.home.viewmodels.header.CheckinEntryInfo;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.NoticeBubbleInfo;
import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler;
import com.tencent.mobileqq.guild.home.views.title.GuildHomeFloatTitleLayout;
import com.tencent.mobileqq.guild.mainframe.view.GuildChannelNameTextView;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildBannerTitleLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.bh;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001YB\u000f\u0012\u0006\u0010V\u001a\u00020U\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 J\u0016\u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*J\b\u0010-\u001a\u00020\u0005H\u0014J\b\u0010.\u001a\u00020\u0005H\u0014J\u000e\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020/J\u0006\u00102\u001a\u00020\u0005J\u000e\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\rJ\u0012\u00106\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u000105H\u0016J\u0016\u0010;\u001a\u00020\u00052\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209J\u0010\u0010<\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020=R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010NR\u0016\u0010Q\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/title/GuildHomeFloatTitleLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "t", "G", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "visitorColors", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/ImageView;", "imageView", "", "resId", "color", "r", "i", "Landroid/graphics/Bitmap;", "originalBitmap", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/ViewGroup;", "guildBannerTitleLayout", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildChannelNameTextView;", "titleTextView", BdhLogUtil.LogTag.Tag_Conn, "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "k", "v", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler$b;", "guildTitleCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "drag", "Lar1/h;", "dragHandler", "l", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/g;", "data", "E", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "show", "p", DomainData.DOMAIN_NAME, "space", "setTitleTopSpace", "Landroid/view/View;", NodeProps.ON_CLICK, "", c.f123400v, "", "from", "setDefaultTitleAlpha", "w", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/a;", "checkinEntryInfo", "u", "Lvp1/bh;", "d", "Lvp1/bh;", "binding", "e", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "mDragHost", "f", "Lar1/h;", "mDragHandler", h.F, "I", "mPrevTitleTopSpace", "Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler$b;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Z", "mIsInvisibleMode", "D", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "mVisitorColors", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeFloatTitleLayout extends FrameLayout implements View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int F = cx.a(50.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsInvisibleMode;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GuildHomeCoverColors mVisitorColors;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bh binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DragFrameLayout mDragHost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ar1.h mDragHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mPrevTitleTopSpace;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildHomeHeaderTitleJumpHandler.b guildTitleCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildInfo mGuildInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/title/GuildHomeFloatTitleLayout$a;", "", "", "c", "", "dp50", "I", "b", "()I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.views.title.GuildHomeFloatTitleLayout$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c() {
            return Intrinsics.areEqual(DeviceInfoMonitor.getModel(), "vivo X6S A");
        }

        public final int b() {
            return GuildHomeFloatTitleLayout.F;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeFloatTitleLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPrevTitleTopSpace = -1;
        n();
        if (INSTANCE.c()) {
            setLayerType(1, null);
        }
        setClipChildren(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GuildHomeFloatTitleLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestLayout();
    }

    private final void C(IGProGuildInfo guildInfo, final ViewGroup guildBannerTitleLayout, final GuildChannelNameTextView titleTextView) {
        String str;
        int childCount = guildBannerTitleLayout.getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                break;
            }
            View childAt = guildBannerTitleLayout.getChildAt(childCount);
            Intrinsics.checkNotNullExpressionValue(childAt, "guildBannerTitleLayout.getChildAt(i)");
            if (childAt instanceof ImageView) {
                guildBannerTitleLayout.removeView(childAt);
            }
        }
        final List<IGProMedalInfo> k3 = k(guildInfo);
        Iterator<IGProMedalInfo> it = k3.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IGProMedalInfo next = it.next();
            if (next.getOfficialMedalInfoExt().getIsOffical()) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                GuildMedalUtils.f(guildBannerTitleLayout, next, context);
                break;
            }
        }
        guildBannerTitleLayout.post(new Runnable() { // from class: jp1.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeFloatTitleLayout.D(k3, titleTextView, guildBannerTitleLayout);
            }
        });
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
            if (iGProGuildInfo != null) {
                str = iGProGuildInfo.getGuildID();
            } else {
                str = null;
            }
            d16.d("Guild.NewHome.GuildHomeFloatTitleLayout", 2, "updateMedalView " + str + ", medalInfo:" + k3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(List medalInfos, GuildChannelNameTextView titleTextView, ViewGroup guildBannerTitleLayout) {
        int i3;
        Intrinsics.checkNotNullParameter(medalInfos, "$medalInfos");
        Intrinsics.checkNotNullParameter(titleTextView, "$titleTextView");
        Intrinsics.checkNotNullParameter(guildBannerTitleLayout, "$guildBannerTitleLayout");
        Iterator it = medalInfos.iterator();
        boolean z16 = false;
        int i16 = 0;
        while (it.hasNext()) {
            IGProMedalInfo iGProMedalInfo = (IGProMedalInfo) it.next();
            int i17 = i16 + QQGuildUIUtil.f235396d;
            if (iGProMedalInfo.getOfficialMedalInfoExt().getIsOffical()) {
                i3 = QQGuildUIUtil.f235395c;
            } else {
                i3 = QQGuildUIUtil.f235394b;
            }
            i16 = i17 + i3;
        }
        CharSequence ellipsize = TextUtils.ellipsize(titleTextView.getText(), titleTextView.getPaint(), guildBannerTitleLayout.getMeasuredWidth() - i16, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(ellipsize, "null cannot be cast to non-null type kotlin.String");
        String str = (String) ellipsize;
        if (str.length() == 0) {
            z16 = true;
        }
        if (z16) {
            str = "\u2026";
        }
        titleTextView.setText(str);
    }

    private final void F(IGProGuildInfo guildInfo) {
        if (guildInfo.getUserNum() > 0) {
            bh bhVar = null;
            CharSequence b16 = cp1.c.b(cp1.c.f391536a, guildInfo.getUserNum(), null, 2, null);
            bh bhVar2 = this.binding;
            if (bhVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bhVar = bhVar2;
            }
            bhVar.f442460g.setText(b16);
        }
    }

    private final void G(IGProGuildInfo guildInfo) {
        bh bhVar = this.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        GuildChannelNameTextView guildChannelNameTextView = bhVar.f442475v;
        Intrinsics.checkNotNullExpressionValue(guildChannelNameTextView, "binding.titleTv");
        String guildName = guildInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
        GuildChannelNameTextView.setTitleText$default(guildChannelNameTextView, guildName, false, 2, null);
        bh bhVar3 = this.binding;
        if (bhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar3 = null;
        }
        GuildBannerTitleLayout guildBannerTitleLayout = bhVar3.f442457d;
        Intrinsics.checkNotNullExpressionValue(guildBannerTitleLayout, "binding.guildBannerTitleLayout");
        bh bhVar4 = this.binding;
        if (bhVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bhVar2 = bhVar4;
        }
        GuildChannelNameTextView guildChannelNameTextView2 = bhVar2.f442475v;
        Intrinsics.checkNotNullExpressionValue(guildChannelNameTextView2, "binding.titleTv");
        C(guildInfo, guildBannerTitleLayout, guildChannelNameTextView2);
    }

    private final void i() {
        bh bhVar = this.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        bhVar.f442462i.setBackgroundResource(R.drawable.skin_tips_newmessage);
        bh bhVar3 = this.binding;
        if (bhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar3 = null;
        }
        bhVar3.f442468o.setOnClickListener(this);
        bh bhVar4 = this.binding;
        if (bhVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar4 = null;
        }
        bhVar4.f442464k.setOnClickListener(this);
        bh bhVar5 = this.binding;
        if (bhVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar5 = null;
        }
        bhVar5.f442473t.setOnClickListener(this);
        bh bhVar6 = this.binding;
        if (bhVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar6 = null;
        }
        bhVar6.f442471r.setOnClickListener(this);
        bh bhVar7 = this.binding;
        if (bhVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar7 = null;
        }
        bhVar7.f442474u.setOnClickListener(this);
        bh bhVar8 = this.binding;
        if (bhVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar8 = null;
        }
        bhVar8.f442475v.setOnClickListener(this);
        bh bhVar9 = this.binding;
        if (bhVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar9 = null;
        }
        bhVar9.f442466m.setOnClickListener(this);
        bh bhVar10 = this.binding;
        if (bhVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar10 = null;
        }
        bhVar10.f442465l.setOnClickListener(this);
        bh bhVar11 = this.binding;
        if (bhVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bhVar2 = bhVar11;
        }
        bhVar2.f442476w.setOnClickListener(this);
    }

    private final Bitmap j(Bitmap originalBitmap) {
        int i3;
        int i16;
        GuildHomeCoverBelowList.Companion companion = GuildHomeCoverBelowList.INSTANCE;
        float a16 = companion.a() / getMeasuredWidth();
        if (originalBitmap.getHeight() / originalBitmap.getWidth() > a16) {
            i3 = originalBitmap.getWidth();
            i16 = (int) (i3 * a16);
        } else {
            int height = originalBitmap.getHeight();
            i3 = (int) (height / a16);
            i16 = height;
        }
        int width = (originalBitmap.getWidth() - i3) / 2;
        int height2 = (originalBitmap.getHeight() - i16) / 2;
        int measuredHeight = (getMeasuredHeight() * i16) / companion.a();
        Logger logger = Logger.f235387a;
        logger.d().i("Guild.NewHome.GuildHomeFloatTitleLayout", 1, "updateBitmap\uff1aoriginalBitmap(" + originalBitmap.getWidth() + ", " + originalBitmap.getHeight() + ") -> (" + width + "," + height2 + "," + i3 + "," + measuredHeight + ")");
        if (width + i3 <= originalBitmap.getWidth() && height2 + measuredHeight <= originalBitmap.getHeight() && i3 > 0 && measuredHeight > 0) {
            return Bitmap.createBitmap(originalBitmap, width, height2, i3, measuredHeight);
        }
        logger.d().w("Guild.NewHome.GuildHomeFloatTitleLayout", 1, "croppedBitmap invalid! titleSize(" + getMeasuredWidth() + ", " + getMeasuredHeight() + ")");
        return null;
    }

    private final List<IGProMedalInfo> k(IGProGuildInfo guildInfo) {
        boolean z16;
        boolean z17;
        List<IGProMedalInfo> emptyList;
        ArrayList<IGProMedalInfo> medalInfoList = guildInfo.getMedalInfoList();
        if (medalInfoList != null && !medalInfoList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        ArrayList arrayList = new ArrayList();
        for (Object obj : medalInfoList) {
            long expireTime = ((IGProMedalInfo) obj).getExpireTime();
            if (1 <= expireTime && expireTime < serverTime) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                arrayList.add(obj);
            }
        }
        return medalInfoList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(GuildHomeFloatTitleLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
    }

    private final void r(ImageView imageView, int resId, int color) {
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
        imageView.setImageDrawable(GuildUIUtils.y(context, resId, color));
    }

    private final void s(GuildHomeCoverColors visitorColors) {
        int guildNameColor = visitorColors.getGuildNameColor();
        bh bhVar = this.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        ImageView imageView = bhVar.f442464k;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.titleBack");
        r(imageView, R.drawable.qui_chevron_left_icon_white, guildNameColor);
        bh bhVar3 = this.binding;
        if (bhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar3 = null;
        }
        ImageView imageView2 = bhVar3.f442474u;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.titleTipOff");
        r(imageView2, R.drawable.qui_more_icon_white, guildNameColor);
        bh bhVar4 = this.binding;
        if (bhVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar4 = null;
        }
        ImageView imageView3 = bhVar4.f442471r;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.titleSetting");
        r(imageView3, R.drawable.guild_title_more_btn_icon_white, guildNameColor);
        bh bhVar5 = this.binding;
        if (bhVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar5 = null;
        }
        ImageView imageView4 = bhVar5.f442473t;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.titleShare");
        r(imageView4, R.drawable.guild_title_share_btn_icon_white, guildNameColor);
        bh bhVar6 = this.binding;
        if (bhVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bhVar2 = bhVar6;
        }
        ImageView imageView5 = bhVar2.f442468o;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.titleNoticeMsg");
        r(imageView5, R.drawable.guild_title_notice_btn_icon_white, guildNameColor);
        v(visitorColors);
    }

    private final void t(IGProGuildInfo guildInfo) {
        int i3;
        boolean z16;
        int i16;
        int i17;
        boolean z17 = !guildInfo.isMember();
        boolean isVisibleForVisitor = guildInfo.isVisibleForVisitor();
        bh bhVar = this.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        ImageView imageView = bhVar.f442474u;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.titleTipOff");
        int i18 = 8;
        if (z17) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        bh bhVar3 = this.binding;
        if (bhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar3 = null;
        }
        ImageView imageView2 = bhVar3.f442473t;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.titleShare");
        if (z17 && isVisibleForVisitor) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageView2.setVisibility(i16);
        bh bhVar4 = this.binding;
        if (bhVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar4 = null;
        }
        FrameLayout frameLayout = bhVar4.f442472s;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.titleSettingFly");
        if (!z17) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        frameLayout.setVisibility(i17);
        bh bhVar5 = this.binding;
        if (bhVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bhVar2 = bhVar5;
        }
        FrameLayout frameLayout2 = bhVar2.f442469p;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.titleNoticeMsgContainer");
        if (!z17) {
            i18 = 0;
        }
        frameLayout2.setVisibility(i18);
    }

    private final void v(GuildHomeCoverColors visitorColors) {
        boolean z16;
        if (visitorColors.getType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        bh bhVar = this.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        bhVar.f442476w.setTextColor(visitorColors.getGuildNameColor());
        if (z16) {
            bh bhVar3 = this.binding;
            if (bhVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bhVar2 = bhVar3;
            }
            bhVar2.f442477x.setFillColor(getContext().getResources().getColorStateList(R.color.boz), true);
            return;
        }
        bh bhVar4 = this.binding;
        if (bhVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bhVar2 = bhVar4;
        }
        bhVar2.f442477x.setFillColor(getContext().getResources().getColorStateList(R.color.bul), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final GuildHomeFloatTitleLayout this$0, final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Bitmap j3 = this$0.j(bitmap);
        if (j3 == null) {
            Logger.f235387a.d().w("Guild.NewHome.GuildHomeFloatTitleLayout", 1, "updateCoverBitmap getCroppedCoverBitmap fail!");
        }
        UiThreadUtil.runOnUiThreadWithCheck(new Runnable() { // from class: jp1.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeFloatTitleLayout.y(GuildHomeFloatTitleLayout.this, j3, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(GuildHomeFloatTitleLayout this$0, Bitmap bitmap, Bitmap bitmap2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bh bhVar = this$0.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        ImageView imageView = bhVar.f442455b;
        bh bhVar3 = this$0.binding;
        if (bhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bhVar2 = bhVar3;
        }
        Resources resources = bhVar2.f442455b.getResources();
        if (bitmap == null) {
            bitmap = bitmap2;
        }
        imageView.setBackground(new BitmapDrawable(resources, bitmap));
    }

    private final void z(IGProGuildInfo guildInfo) {
        String avatarUrl = guildInfo.getAvatarUrl(100);
        Logger.f235387a.d().d("Guild.NewHome.GuildHomeFloatTitleLayout", 1, "updateGuildIcon newAvatarUrl " + avatarUrl);
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "avatarUrl");
        bh bhVar = this.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        RoundImageView roundImageView = bhVar.f442466m;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.titleGuildIcon");
        v.l(avatarUrl, roundImageView, null, 4, null);
        bh bhVar3 = this.binding;
        if (bhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bhVar2 = bhVar3;
        }
        bhVar2.f442466m.setTag(avatarUrl);
    }

    public final void A(@NotNull IGProGuildInfo guildInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        this.mGuildInfo = guildInfo;
        if (!guildInfo.isVisibleForVisitor() && !guildInfo.isMember() && !guildInfo.getIsBanned()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsInvisibleMode = z16;
        t(guildInfo);
        F(guildInfo);
        G(guildInfo);
        z(guildInfo);
        postDelayed(new Runnable() { // from class: jp1.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeFloatTitleLayout.B(GuildHomeFloatTitleLayout.this);
            }
        }, 100L);
    }

    public final void E(@NotNull NoticeBubbleInfo data) {
        b bVar;
        Intrinsics.checkNotNullParameter(data, "data");
        bh bhVar = this.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        GuildDragTextView guildDragTextView = bhVar.f442470q;
        bh bhVar3 = this.binding;
        if (bhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar3 = null;
        }
        guildDragTextView.setDragViewType(10, bhVar3.f442469p);
        bh bhVar4 = this.binding;
        if (bhVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar4 = null;
        }
        GuildDragTextView guildDragTextView2 = bhVar4.f442470q;
        ar1.h hVar = this.mDragHandler;
        if (hVar != null) {
            bVar = hVar.c();
        } else {
            bVar = null;
        }
        guildDragTextView2.setOnModeChangeListener(bVar);
        bh bhVar5 = this.binding;
        if (bhVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar5 = null;
        }
        bhVar5.f442469p.setTag(data);
        cp1.b bVar2 = cp1.b.f391535a;
        bh bhVar6 = this.binding;
        if (bhVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar6 = null;
        }
        GuildDragTextView guildDragTextView3 = bhVar6.f442470q;
        Intrinsics.checkNotNullExpressionValue(guildDragTextView3, "binding.titleNoticeMsgCount");
        bVar2.a(data, guildDragTextView3, R.drawable.guild_page_feed_msg_gray_unread_bg, R.color.qui_common_fill_allblack_medium, "headerAboveList msgTab title");
        bh bhVar7 = this.binding;
        if (bhVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bhVar2 = bhVar7;
        }
        bhVar2.f442468o.setTag(data);
    }

    public final void l(@NotNull DragFrameLayout drag, @NotNull ar1.h dragHandler) {
        Intrinsics.checkNotNullParameter(drag, "drag");
        Intrinsics.checkNotNullParameter(dragHandler, "dragHandler");
        this.mDragHost = drag;
        this.mDragHandler = dragHandler;
    }

    public final void m(@NotNull GuildHomeHeaderTitleJumpHandler.b guildTitleCallback) {
        Intrinsics.checkNotNullParameter(guildTitleCallback, "guildTitleCallback");
        this.guildTitleCallback = guildTitleCallback;
    }

    public final void n() {
        bh g16 = bh.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026xt), this, true\n        )");
        this.binding = g16;
        postDelayed(new Runnable() { // from class: jp1.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeFloatTitleLayout.o(GuildHomeFloatTitleLayout.this);
            }
        }, 50L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ar1.h hVar;
        super.onAttachedToWindow();
        DragFrameLayout dragFrameLayout = this.mDragHost;
        if (dragFrameLayout != null && (hVar = this.mDragHandler) != null) {
            hVar.a(dragFrameLayout);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        boolean areEqual;
        boolean areEqual2;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (!o.c("fastClickGuard")) {
            bh bhVar = this.binding;
            bh bhVar2 = null;
            if (bhVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bhVar = null;
            }
            if (Intrinsics.areEqual(v3, bhVar.f442464k)) {
                GuildHomeHeaderTitleJumpHandler.b bVar = this.guildTitleCallback;
                if (bVar != null) {
                    bVar.onBackClick(v3);
                }
            } else {
                bh bhVar3 = this.binding;
                if (bhVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bhVar3 = null;
                }
                if (Intrinsics.areEqual(v3, bhVar3.f442473t)) {
                    GuildHomeHeaderTitleJumpHandler.b bVar2 = this.guildTitleCallback;
                    if (bVar2 != null) {
                        bVar2.a(v3);
                    }
                } else {
                    bh bhVar4 = this.binding;
                    if (bhVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bhVar4 = null;
                    }
                    if (Intrinsics.areEqual(v3, bhVar4.f442471r)) {
                        GuildHomeHeaderTitleJumpHandler.b bVar3 = this.guildTitleCallback;
                        if (bVar3 != null) {
                            bVar3.b(v3);
                        }
                    } else {
                        bh bhVar5 = this.binding;
                        if (bhVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            bhVar5 = null;
                        }
                        if (Intrinsics.areEqual(v3, bhVar5.f442474u)) {
                            GuildHomeHeaderTitleJumpHandler.b bVar4 = this.guildTitleCallback;
                            if (bVar4 != null) {
                                bVar4.f(v3);
                            }
                        } else {
                            bh bhVar6 = this.binding;
                            if (bhVar6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                bhVar6 = null;
                            }
                            if (Intrinsics.areEqual(v3, bhVar6.f442476w)) {
                                GuildHomeHeaderTitleJumpHandler.b bVar5 = this.guildTitleCallback;
                                if (bVar5 != null) {
                                    bVar5.c(v3);
                                }
                            } else {
                                bh bhVar7 = this.binding;
                                if (bhVar7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                    bhVar7 = null;
                                }
                                if (Intrinsics.areEqual(v3, bhVar7.f442468o)) {
                                    GuildHomeHeaderTitleJumpHandler.b bVar6 = this.guildTitleCallback;
                                    if (bVar6 != null) {
                                        bVar6.d(v3);
                                    }
                                } else {
                                    bh bhVar8 = this.binding;
                                    if (bhVar8 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                                        bhVar8 = null;
                                    }
                                    if (Intrinsics.areEqual(v3, bhVar8.f442475v)) {
                                        areEqual = true;
                                    } else {
                                        bh bhVar9 = this.binding;
                                        if (bhVar9 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                                            bhVar9 = null;
                                        }
                                        areEqual = Intrinsics.areEqual(v3, bhVar9.f442466m);
                                    }
                                    if (areEqual) {
                                        areEqual2 = true;
                                    } else {
                                        bh bhVar10 = this.binding;
                                        if (bhVar10 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                                        } else {
                                            bhVar2 = bhVar10;
                                        }
                                        areEqual2 = Intrinsics.areEqual(v3, bhVar2.f442465l);
                                    }
                                    if (areEqual2) {
                                        GuildHomeHeaderTitleJumpHandler.b bVar7 = this.guildTitleCallback;
                                        if (bVar7 != null) {
                                            bVar7.e(v3, this.mGuildInfo);
                                        }
                                    } else {
                                        Logger.f235387a.d().w("Guild.NewHome.GuildHomeFloatTitleLayout", 1, "onClick unExpectedView:" + v3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ar1.h hVar;
        super.onDetachedFromWindow();
        DragFrameLayout dragFrameLayout = this.mDragHost;
        if (dragFrameLayout != null && (hVar = this.mDragHandler) != null) {
            hVar.b(dragFrameLayout);
        }
    }

    public final void p(boolean show) {
        int i3;
        bh bhVar = this.binding;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        ImageView imageView = bhVar.f442462i;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.redDot");
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void q(@NotNull GuildHomeCoverColors visitorColors) {
        Intrinsics.checkNotNullParameter(visitorColors, "visitorColors");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.NewHome.GuildHomeFloatTitleLayout", 1, "tintColor visitorColors:" + visitorColors);
        }
        this.mVisitorColors = visitorColors;
        s(visitorColors);
        bh bhVar = this.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        bhVar.f442455b.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{g.a(visitorColors.getMainColor(), 85), visitorColors.getMainColor()}));
        bh bhVar3 = this.binding;
        if (bhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar3 = null;
        }
        bhVar3.f442475v.setTextColor(visitorColors.getGuildNameColor());
        bh bhVar4 = this.binding;
        if (bhVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bhVar2 = bhVar4;
        }
        bhVar2.f442460g.setTextColor(visitorColors.getOnlineMemberColor());
    }

    public final void setDefaultTitleAlpha(float alpha, @NotNull String from) {
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        boolean z18;
        IGProGuildInfo iGProGuildInfo;
        Intrinsics.checkNotNullParameter(from, "from");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.GuildHomeFloatTitleLayout", "setDefaultTitleAlpha alpha:" + alpha + " from:" + from);
        }
        if (this.mIsInvisibleMode) {
            return;
        }
        bh bhVar = this.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        bhVar.f442455b.setAlpha(alpha);
        bh bhVar3 = this.binding;
        if (bhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar3 = null;
        }
        bhVar3.f442456c.setAlpha(alpha);
        bh bhVar4 = this.binding;
        if (bhVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar4 = null;
        }
        bhVar4.f442461h.setAlpha(alpha);
        bh bhVar5 = this.binding;
        if (bhVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar5 = null;
        }
        ImageView imageView = bhVar5.f442455b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.containerBg");
        bh bhVar6 = this.binding;
        if (bhVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar6 = null;
        }
        boolean z19 = true;
        if (bhVar6.f442455b.getAlpha() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        bh bhVar7 = this.binding;
        if (bhVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar7 = null;
        }
        FrameLayout frameLayout = bhVar7.f442456c;
        bh bhVar8 = this.binding;
        if (bhVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar8 = null;
        }
        if (bhVar8.f442455b.getAlpha() == 0.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        int i17 = 4;
        if (!z17) {
            i16 = 0;
        } else {
            i16 = 4;
        }
        frameLayout.setVisibility(i16);
        bh bhVar9 = this.binding;
        if (bhVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar9 = null;
        }
        LinearLayout linearLayout = bhVar9.f442461h;
        bh bhVar10 = this.binding;
        if (bhVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar10 = null;
        }
        if (bhVar10.f442455b.getAlpha() == 0.0f) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            i17 = 0;
        }
        linearLayout.setVisibility(i17);
        bh bhVar11 = this.binding;
        if (bhVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar11 = null;
        }
        if (bhVar11.f442461h.getAlpha() != 0.0f) {
            z19 = false;
        }
        if (!z19) {
            bh bhVar12 = this.binding;
            if (bhVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bhVar2 = bhVar12;
            }
            if (bhVar2.f442475v.getMeasuredWidth() == 0 && (iGProGuildInfo = this.mGuildInfo) != null) {
                G(iGProGuildInfo);
            }
        }
    }

    public final void setTitleTopSpace(int space) {
        if (this.mPrevTitleTopSpace != space) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.NewHome.GuildHomeFloatTitleLayout", 2, "setTitleTopSpace: " + this.mPrevTitleTopSpace + " -> " + space);
            }
        }
        bh bhVar = this.binding;
        bh bhVar2 = null;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        LinearLayout linearLayout = bhVar.f442465l;
        bh bhVar3 = this.binding;
        if (bhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar3 = null;
        }
        ViewGroup.LayoutParams layoutParams = bhVar3.f442465l.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = space;
        linearLayout.setLayoutParams(marginLayoutParams);
        bh bhVar4 = this.binding;
        if (bhVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar4 = null;
        }
        bhVar4.f442463j.getLayoutParams().height = F + space;
        bh bhVar5 = this.binding;
        if (bhVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bhVar2 = bhVar5;
        }
        bhVar2.f442463j.requestLayout();
        this.mPrevTitleTopSpace = space;
    }

    public final void u(@NotNull CheckinEntryInfo checkinEntryInfo) {
        Intrinsics.checkNotNullParameter(checkinEntryInfo, "checkinEntryInfo");
        bh bhVar = this.binding;
        if (bhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bhVar = null;
        }
        bhVar.f442476w.setText("\u65e5\u7a0b");
    }

    public final void w(@Nullable final Bitmap originalBitmap) {
        if (originalBitmap == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: jp1.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeFloatTitleLayout.x(GuildHomeFloatTitleLayout.this, originalBitmap);
            }
        }, 16, null, false);
    }
}
