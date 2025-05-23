package com.tencent.guild.api.gift;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.gift.impl.GuildGiftApiImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.vas.IGuildGiftManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u00015\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0002\u001d\u001bB\u0011\b\u0016\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<B\u001b\b\u0016\u0012\u0006\u0010:\u001a\u000209\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u00a2\u0006\u0004\b;\u0010?B#\b\u0016\u0012\u0006\u0010:\u001a\u000209\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\b;\u0010BJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J$\u0010\f\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J*\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\bH\u0002J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020 H\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006D"}, d2 = {"Lcom/tencent/guild/api/gift/GuildGiftView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/guild/api/gift/j;", "", "y", "o", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "guildId", "Lcom/tencent/guild/api/gift/i;", "guildGiftListener", "v", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "mGuildId", "mChannelId", "p", ReportConstant.COSTREPORT_PREFIX, "selfTinyId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "pagFile", "", HippyTKDListViewAdapter.X, "r", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b", "tinyId", "a", "pauseAnim", "resumeAnim", "Landroid/view/View;", "getView", "Lrr0/a;", "d", "Lrr0/a;", "binding", "Landroid/animation/ValueAnimator;", "e", "Landroid/animation/ValueAnimator;", "animator", "f", "Ljava/lang/String;", "sendUin", tl.h.F, "receiveUin", "Lcom/tencent/guild/api/gift/GuildGiftHeadPagView;", "i", "Lcom/tencent/guild/api/gift/GuildGiftHeadPagView;", "pagHeadPagView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/api/gift/i;", "com/tencent/guild/api/gift/GuildGiftView$c", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/guild/api/gift/GuildGiftView$c;", "mPlayArkAnimHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildGiftView extends RelativeLayout implements j {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int E = 3;
    private static boolean F;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private c mPlayArkAnimHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private rr0.a binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator animator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sendUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String receiveUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildGiftHeadPagView pagHeadPagView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i guildGiftListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/api/gift/GuildGiftView$a;", "", "", "GIFT_LEVEL_HIGH_QUALITY", "I", "a", "()I", "setGIFT_LEVEL_HIGH_QUALITY", "(I)V", "", "isPause", "Z", "b", "()Z", "c", "(Z)V", "", "BG_IMAGE_FILENAME", "Ljava/lang/String;", "PIAO_DAI_IMAGE_FILENAME", "", "PLAY_ARK_MSG_DELAY", "J", "PLAY_ARK_MSG_WHAT", "RESUME_PAG_DELAY", "STATIC_PRE_VIEW_IMAGE_FILENAME", "TAG", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.api.gift.GuildGiftView$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GuildGiftView.E;
        }

        public final boolean b() {
            return GuildGiftView.F;
        }

        public final void c(boolean z16) {
            GuildGiftView.F = z16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/api/gift/GuildGiftView$b;", "", "", "a", "", "Ljava/lang/String;", "selfTinyId", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "b", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "Lmqq/util/WeakReference;", "Lcom/tencent/guild/api/gift/GuildGiftView;", "c", "Lmqq/util/WeakReference;", "mView", "view", "<init>", "(Lcom/tencent/guild/api/gift/GuildGiftView;Ljava/lang/String;Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String selfTinyId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem guildMsgItem;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<GuildGiftView> mView;

        public b(@Nullable GuildGiftView guildGiftView, @NotNull String selfTinyId, @NotNull GuildMsgItem guildMsgItem) {
            Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
            Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
            this.selfTinyId = selfTinyId;
            this.guildMsgItem = guildMsgItem;
            this.mView = new WeakReference<>(guildGiftView);
        }

        public final void a() {
            String a16;
            GuildGiftView guildGiftView = this.mView.get();
            if (guildGiftView != null && (a16 = com.tencent.guild.api.gift.c.f112540a.a(this.guildMsgItem)) != null) {
                guildGiftView.x(this.guildMsgItem, a16, this.selfTinyId);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/api/gift/GuildGiftView$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 1) {
                GuildGiftView.this.pagHeadPagView.t();
                GuildGiftView.this.s();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/api/gift/GuildGiftView$d", "Lcom/tencent/guild/api/gift/k;", "", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements k {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildMsgItem f112537b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f112538c;

        d(GuildMsgItem guildMsgItem, String str) {
            this.f112537b = guildMsgItem;
            this.f112538c = str;
        }

        @Override // com.tencent.guild.api.gift.k
        public void a() {
            i iVar = GuildGiftView.this.guildGiftListener;
            if (iVar != null) {
                iVar.P(this.f112537b, this.f112538c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGiftView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        rr0.a g16 = rr0.a.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.sendUin = "";
        this.receiveUin = "";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.pagHeadPagView = new GuildGiftHeadPagView(context2);
        this.mPlayArkAnimHandler = new c();
    }

    private final void o() {
        if (this.pagHeadPagView.getParent() == null) {
            this.binding.f431983d.addView(this.pagHeadPagView);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a A[Catch: Exception -> 0x0010, TRY_LEAVE, TryCatch #0 {Exception -> 0x0010, blocks: (B:16:0x0005, B:18:0x000b, B:4:0x0013, B:8:0x002a), top: B:15:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void p(GuildMsgItem guildMsgItem, String mGuildId, String mChannelId, com.tencent.aio.api.runtime.a aioContext) {
        FragmentActivity activity;
        TextGiftElement c16;
        if (aioContext != null) {
            try {
                Fragment c17 = aioContext.c();
                if (c17 != null) {
                    activity = c17.getActivity();
                    VideoReport.addToDetectionWhitelist(activity);
                    VideoReport.setPageId(this, "pg_sgrp_giftark_native");
                    HashMap hashMap = new HashMap();
                    c16 = com.tencent.guild.api.gift.c.f112540a.c(guildMsgItem);
                    if (c16 != null) {
                        return;
                    }
                    hashMap.put("dt_qq_h5", Long.valueOf(c16.senderUin));
                    hashMap.put("qq_receiver_id", Long.valueOf(c16.receiverUin));
                    hashMap.put("yes_gift_id", Long.valueOf(c16.giftId));
                    hashMap.put("sgrp_channel_id", mGuildId);
                    hashMap.put("sgrp_sub_channel_id", mChannelId);
                    VideoReport.setPageParams(this, new PageParams(hashMap));
                    VideoReport.setElementId(this.binding.f431985f, "em_sgrp_gift_smallpic");
                    VideoReport.setElementId(this.binding.f431981b, "em_sgrp_check_btn");
                    VideoReport.reportEvent("pgin", this, hashMap);
                    VideoReport.reportEvent("imp", this, hashMap);
                    VideoReport.reportEvent("imp", this.binding.f431985f, hashMap);
                    VideoReport.reportEvent("imp", this.binding.f431981b, hashMap);
                    return;
                }
            } catch (Exception e16) {
                QLog.e("GuildGiftView", 1, "initDTReport error " + e16);
                return;
            }
        }
        activity = null;
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(this, "pg_sgrp_giftark_native");
        HashMap hashMap2 = new HashMap();
        c16 = com.tencent.guild.api.gift.c.f112540a.c(guildMsgItem);
        if (c16 != null) {
        }
    }

    private final void q(GuildMsgItem guildMsgItem, String selfTinyId) {
        String a16 = com.tencent.guild.api.gift.c.f112540a.a(guildMsgItem);
        if (a16 == null) {
            return;
        }
        if (!new File(a16).exists() || !x(guildMsgItem, a16, selfTinyId)) {
            GiftResourceLoader.f112513a.d(guildMsgItem, new b(this, selfTinyId, guildMsgItem));
        }
    }

    private final void r() {
        this.mPlayArkAnimHandler.removeMessages(1);
        Message message = new Message();
        message.what = 1;
        this.mPlayArkAnimHandler.sendMessageDelayed(message, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.4f, 1.0f);
        if (ofFloat != null) {
            ofFloat.setStartDelay(2000L);
            ofFloat.setDuration(500L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.guild.api.gift.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GuildGiftView.t(GuildGiftView.this, valueAnimator);
                }
            });
            this.binding.f431985f.setVisibility(0);
            ofFloat.start();
            if (F) {
                ofFloat.pause();
            }
        } else {
            ofFloat = null;
        }
        this.animator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GuildGiftView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.binding.f431985f.setScaleX((valueAnimator.getAnimatedFraction() * 0.6f) + 0.4f);
        this$0.binding.f431985f.setScaleY((valueAnimator.getAnimatedFraction() * 0.6f) + 0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(GuildGiftView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (F) {
            return;
        }
        this$0.o();
        ValueAnimator valueAnimator = this$0.animator;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
        this$0.pagHeadPagView.s();
    }

    private final void v(final com.tencent.aio.api.runtime.a aioContext, final String guildId, final i guildGiftListener) {
        this.binding.f431981b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.api.gift.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildGiftView.w(i.this, aioContext, guildId, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(i iVar, com.tencent.aio.api.runtime.a aVar, String guildId, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        if (iVar != null && iVar.W()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (aVar != null && !z16) {
            ((IGuildGiftManager) QRoute.api(IGuildGiftManager.class)).initGiftPanel(aVar, new GuildGiftApiImpl.a(guildId));
            ((IGuildGiftManager) QRoute.api(IGuildGiftManager.class)).showGiftPanel(aVar.c().getActivity());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x(GuildMsgItem guildMsgItem, String pagFile, String selfTinyId) {
        String str = File.separator;
        String str2 = pagFile + str + "arkBackgroundImage.png";
        if (new File(str2).exists()) {
            this.binding.f431984e.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(str2));
            this.binding.f431982c.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(str2));
        } else {
            this.binding.f431982c.setImageDrawable(new ColorDrawable(Color.parseColor("#FF5FAEFF")));
            this.binding.f431984e.setImageDrawable(new ColorDrawable(Color.parseColor("#FF5FAEFF")));
        }
        String str3 = pagFile + str + "staticPreviewImage.png";
        if (new File(str3).exists()) {
            Drawable dynamicDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(str3);
            this.binding.f431985f.setImageDrawable(dynamicDrawable);
            if (dynamicDrawable == null) {
                QLog.e("GuildGiftView", 1, "imgGift drawable is null");
            }
        } else {
            this.binding.f431985f.setImageDrawable(null);
        }
        String str4 = pagFile + str + "piaodai.pag";
        if (new File(str4).exists()) {
            this.pagHeadPagView.setJumpFile(str4);
            this.pagHeadPagView.setPlayEndListener(new d(guildMsgItem, selfTinyId));
            r();
            return true;
        }
        return false;
    }

    private final void y() {
        this.binding.f431983d.removeAllViews();
        this.animator = null;
    }

    @Override // com.tencent.guild.api.gift.j
    public void a(@NotNull String guildId, @NotNull String tinyId) {
        BaseQQAppInterface baseQQAppInterface;
        boolean z16;
        IQQGuildAvatarApi iQQGuildAvatarApi;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        if (!Intrinsics.areEqual(tinyId, this.sendUin) && !Intrinsics.areEqual(tinyId, this.receiveUin)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null && (iQQGuildAvatarApi = (IQQGuildAvatarApi) baseQQAppInterface.getRuntimeService(IQQGuildAvatarApi.class, "")) != null) {
            str = iQQGuildAvatarApi.getAvatarUrl(baseQQAppInterface, guildId, tinyId);
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d("GuildGiftView", 2, "url is null " + guildId + " " + tinyId);
            return;
        }
        GiftResourceLoader.f112513a.c(str, new GuildGiftView$updateGiftAvatar$1(this, tinyId, str));
    }

    @Override // com.tencent.guild.api.gift.j
    public void b(@NotNull com.tencent.aio.data.msglist.a msgItem, @Nullable com.tencent.aio.api.runtime.a aioContext, @Nullable i guildGiftListener) {
        BaseQQAppInterface baseQQAppInterface;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof GuildMsgItem)) {
            return;
        }
        QLog.d("GuildGiftView", 2, "onBindData");
        y();
        this.guildGiftListener = guildGiftListener;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        String selfUin = ((IGPSService) baseQQAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        com.tencent.guild.api.gift.c cVar = com.tencent.guild.api.gift.c.f112540a;
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        TextGiftElement c16 = cVar.c(guildMsgItem);
        if (c16 != null) {
            String str = c16.paddingTop;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                ImageView imageView = this.binding.f431985f;
                String str2 = c16.paddingTop;
                Intrinsics.checkNotNullExpressionValue(str2, "this.paddingTop");
                imageView.setTranslationY(0 - (Float.parseFloat(str2) * 0.484f));
            }
            if (Intrinsics.areEqual(selfUin, String.valueOf(c16.receiverUin))) {
                this.binding.f431991l.setText("\u6211");
            } else {
                this.binding.f431991l.setText(c16.receiverNick);
            }
            this.binding.f431992m.setText(c16.giftName);
            this.binding.f431990k.setText(cVar.b(c16));
            if (Intrinsics.areEqual(selfUin, String.valueOf(c16.senderUin))) {
                this.binding.f431981b.setBackgroundResource(R.drawable.guild_gift_item_button_continue);
            } else if (Intrinsics.areEqual(selfUin, String.valueOf(c16.receiverUin))) {
                this.binding.f431981b.setBackgroundResource(R.drawable.lmz);
            } else {
                this.binding.f431981b.setBackgroundResource(R.drawable.guild_gift_item_button_metoo);
            }
            this.sendUin = String.valueOf(c16.senderUin);
            this.receiveUin = String.valueOf(c16.receiverUin);
            String str3 = guildMsgItem.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.guildId");
            a(str3, String.valueOf(c16.senderUin));
            String str4 = guildMsgItem.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str4, "msgItem.msgRecord.guildId");
            a(str4, String.valueOf(c16.receiverUin));
            String str5 = guildMsgItem.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str5, "msgItem.msgRecord.guildId");
            v(aioContext, str5, guildGiftListener);
            Intrinsics.checkNotNullExpressionValue(selfUin, "selfUin");
            q(guildMsgItem, selfUin);
            String str6 = guildMsgItem.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str6, "msgItem.msgRecord.guildId");
            String str7 = guildMsgItem.getMsgRecord().channelId;
            Intrinsics.checkNotNullExpressionValue(str7, "msgItem.msgRecord.channelId");
            p(guildMsgItem, str6, str7, aioContext);
            if (!F) {
                o();
            }
        }
    }

    @Override // com.tencent.guild.api.gift.j
    public void pauseAnim() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
        this.pagHeadPagView.r();
    }

    @Override // com.tencent.guild.api.gift.j
    public void resumeAnim() {
        postDelayed(new Runnable() { // from class: com.tencent.guild.api.gift.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildGiftView.u(GuildGiftView.this);
            }
        }, 300L);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGiftView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        rr0.a g16 = rr0.a.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.sendUin = "";
        this.receiveUin = "";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.pagHeadPagView = new GuildGiftHeadPagView(context2);
        this.mPlayArkAnimHandler = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGiftView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        rr0.a g16 = rr0.a.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.sendUin = "";
        this.receiveUin = "";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.pagHeadPagView = new GuildGiftHeadPagView(context2);
        this.mPlayArkAnimHandler = new c();
    }

    @Override // com.tencent.guild.api.gift.j
    @NotNull
    public View getView() {
        return this;
    }
}
