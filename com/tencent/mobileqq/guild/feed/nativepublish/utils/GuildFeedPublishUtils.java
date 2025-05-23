package com.tencent.mobileqq.guild.feed.nativepublish.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.guild.aio.util.GuildAIODispatchers;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildRoleGroupApi;
import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishEditPostInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.FeedRichTextConvertTool;
import com.tencent.mobileqq.guild.feed.nativepublish.launcher.compat.FeedPublishEditorLaunchCompat;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.feed.util.af;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.ay;
import com.tencent.mobileqq.guild.feed.util.w;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDelFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDelFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDelFeedCallback;
import el1.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sz1.JoinTimeItem;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bH\u0010IJ\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0010H\u0002JV\u0010#\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!J\u001c\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c2\u0006\u0010%\u001a\u00020$J.\u0010,\u001a\u00020)2\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020$0'j\u0002`(2\u0006\u0010*\u001a\u00020)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0016\u0010/\u001a\u00020)2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nJ\u000e\u00100\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\nJ(\u00102\u001a\u00020)2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u00101\u001a\u00020)JG\u0010;\u001a\u00020)2#\u00108\u001a\u001f\u0012\u0013\u0012\u001104\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u0001032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\n\b\u0002\u0010:\u001a\u0004\u0018\u000109J;\u0010<\u001a\u00020)2#\u00108\u001a\u001f\u0012\u0013\u0012\u001104\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u0001032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nJ \u0010=\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00107\u001a\u000204J\n\u0010?\u001a\u00020>*\u00020>J0\u0010A\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0018\u0010@\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001cR\u0011\u0010D\u001a\u00020)8F\u00a2\u0006\u0006\u001a\u0004\bB\u0010CR\u0011\u0010G\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\bE\u0010F\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GuildFeedPublishUtils;", "", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "bean", "Lkotlin/Function0;", "", "after", "G", "Landroid/app/Activity;", "hostActivity", "", "guildId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", HippyTKDListViewAdapter.X, "y", "l", "feedDetail", "o", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "channelId", "channelName", "", "businessType", "", "Ljava/io/Serializable;", "attr", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "Ljava/lang/Runnable;", "onCallH5Activity", "E", "Lzl1/a;", "param", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "", "switchToH5", "callback", BdhLogUtil.LogTag.Tag_Conn, "mainTaskId1", "mainTaskId2", "u", "w", "isPublishedGuildFeedModify", "j", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "Lkotlin/ParameterName;", "name", "type", "howToToast", "Lel1/a$a$a;", "customArgs", tl.h.F, "k", "D", "", UserInfo.SEX_FEMALE, QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", "()Z", "isUseRestorerV2", "t", "()Ljava/lang/String;", "feedPublishWebUrl", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPublishUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedPublishUtils f222315a = new GuildFeedPublishUtils();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f222319a;

        static {
            int[] iArr = new int[SpeakPermissionType.values().length];
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_REAL_NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_JOIN_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_MUTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_VISITOR_NEED_JOIN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_GUILD_BANNED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f222319a = iArr;
        }
    }

    GuildFeedPublishUtils() {
    }

    private final void B(String guildId) {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return;
        }
        String string = context.getString(R.string.f157271mg, JoinTimeItem.INSTANCE.b(sz1.d.f(guildId).getGuildLimitTime()));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026dLimitTime)\n            )");
        yl1.n.A(0, string);
    }

    private final void G(GuildFeedBaseInitBean bean, Function0<Unit> after) {
        String channelId;
        String guildId = bean.getGuildId();
        if (guildId != null && (channelId = bean.getChannelId()) != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, ae.a().c(), null, new GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1(guildId, channelId, bean, after, null), 2, null);
        }
    }

    public static /* synthetic */ boolean i(GuildFeedPublishUtils guildFeedPublishUtils, Function1 function1, String str, String str2, a.Companion.Args args, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            args = null;
        }
        return guildFeedPublishUtils.h(function1, str, str2, args);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Context context, final GProStFeed feed) {
        DialogUtil.createCustomDialog(context, 230, (String) null, context.getString(R.string.f145550rs), context.getString(R.string.cancel), context.getString(R.string.ajx), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildFeedPublishUtils.m(GProStFeed.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildFeedPublishUtils.n(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GProStFeed feed, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(feed, "$feed");
        f222315a.o(feed);
    }

    private final void o(final GProStFeed feedDetail) {
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            GProStDelFeedReq gProStDelFeedReq = new GProStDelFeedReq();
            gProStDelFeedReq.feed = feedDetail;
            gProStDelFeedReq.src = 0;
            c16.delFeed(gProStDelFeedReq, new IGProDelFeedCallback() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.n
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDelFeedCallback
                public final void onResult(int i3, String str, GProStDelFeedRsp gProStDelFeedRsp) {
                    GuildFeedPublishUtils.p(GProStFeed.this, i3, str, gProStDelFeedRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final GProStFeed feedDetail, final int i3, final String str, GProStDelFeedRsp gProStDelFeedRsp) {
        Intrinsics.checkNotNullParameter(feedDetail, "$feedDetail");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.o
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishUtils.q(i3, str, feedDetail);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int i3, String str, GProStFeed feedDetail) {
        boolean z16;
        Intrinsics.checkNotNullParameter(feedDetail, "$feedDetail");
        if (i3 != 0) {
            if (i3 != 700100) {
                z16 = false;
            } else {
                str = QQGuildUIUtil.r(R.string.f143940nf);
                z16 = true;
            }
            QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.p
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedPublishUtils.r();
                }
            }, 100L);
            z16 = true;
        }
        if (z16) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDeleteEvent(feedDetail.idd, String.valueOf(feedDetail.channelInfo.sign.guildId), String.valueOf(feedDetail.channelInfo.sign.channelId)), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r() {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, 2, context.getString(R.string.ajx) + context.getString(R.string.f145650s2), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Context context, GProStFeed feed) {
        if (!j(QBaseActivity.sTopActivity, String.valueOf(feed.channelInfo.sign.guildId), String.valueOf(feed.channelInfo.sign.channelId), true)) {
            return;
        }
        if (com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(feed.feedType)) {
            y(context, feed);
            return;
        }
        String b16 = new FeedRichTextConvertTool().b(feed);
        if (b16 == null) {
            return;
        }
        jj1.b c16 = jj1.b.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getInstance()");
        String str = feed.idd;
        Intrinsics.checkNotNullExpressionValue(str, "feed.idd");
        com.tencent.mobileqq.guild.feed.util.p.a(c16, str, b16);
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        guildFeedBaseInitBean.setBusinessType(5);
        guildFeedBaseInitBean.setGuildId(String.valueOf(feed.channelInfo.sign.guildId));
        guildFeedBaseInitBean.setChannelId(String.valueOf(feed.channelInfo.sign.channelId));
        guildFeedBaseInitBean.setChannelName(feed.channelInfo.name);
        em1.a aVar = em1.a.f396585a;
        Boolean bool = Boolean.TRUE;
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("launch_feed_id", feed.idd), TuplesKt.to("launch_json_feed_store_id", feed.idd), TuplesKt.to(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedBaseInitBean), TuplesKt.to("launch_published_flag", bool), TuplesKt.to("launch_edit_flag", bool), TuplesKt.to("launch_request_id", Integer.valueOf(context.hashCode())));
        FeedPublishEditorLaunchCompat feedPublishEditorLaunchCompat = FeedPublishEditorLaunchCompat.f222113a;
        aVar.h(context, 5, bundleOf, feedPublishEditorLaunchCompat.e(feedPublishEditorLaunchCompat.f("reedit feed"), feedPublishEditorLaunchCompat.c()));
    }

    private final void y(Context context, GProStFeed feed) {
        GuildFeedPublishEditPostInitBean guildFeedPublishEditPostInitBean = new GuildFeedPublishEditPostInitBean();
        guildFeedPublishEditPostInitBean.setBusinessType(5);
        guildFeedPublishEditPostInitBean.setGuildId(String.valueOf(feed.channelInfo.sign.guildId));
        guildFeedPublishEditPostInitBean.setChannelId(String.valueOf(feed.channelInfo.sign.channelId));
        guildFeedPublishEditPostInitBean.setChannelName(feed.channelInfo.name);
        guildFeedPublishEditPostInitBean.setFeedId(feed.idd);
        guildFeedPublishEditPostInitBean.setPosterTinyId(feed.poster.idd);
        guildFeedPublishEditPostInitBean.setCreateTime(feed.getCreateTime());
        HashMap<String, Serializable> attrs = guildFeedPublishEditPostInitBean.getAttrs();
        Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
        attrs.put("launch_request_id", Integer.valueOf(context.hashCode()));
        GuildFeedLauncher.C(context, guildFeedPublishEditPostInitBean);
    }

    private final void z(Activity hostActivity, String guildId) {
        if (hostActivity == null) {
            yl1.n.z(0, R.string.f157201m_);
            return;
        }
        com.tencent.mobileqq.guild.feed.feedsquare.utils.j jVar = com.tencent.mobileqq.guild.feed.feedsquare.utils.j.f219338a;
        String verifyUrl = sz1.d.f(guildId).getVerifyUrl();
        String string = hostActivity.getString(R.string.f157201m_);
        Intrinsics.checkNotNullExpressionValue(string, "hostActivity.getString(c\u2026k_threshold_aio_auth_tip)");
        String string2 = hostActivity.getString(R.string.f157191m9);
        Intrinsics.checkNotNullExpressionValue(string2, "hostActivity.getString(c\u2026_threshold_aio_auth_jump)");
        jVar.h(hostActivity, verifyUrl, string, string2);
    }

    public final void A(@NotNull final Context context, @NotNull final GProStFeed feed, @Nullable Map<String, ? extends Object> pageParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = feed.feedViolationType;
        String feedViolationText = feed.feedViolationText;
        if (Intrinsics.areEqual(feedViolationText, "")) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(feedViolationText, "feedViolationText");
        new j(context, feedViolationText, null, intRef.element, null, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils$showFeedViolationDialog$dialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i3 = Ref.IntRef.this.element;
                if (i3 == 1) {
                    GuildFeedPublishUtils.f222315a.l(context, feed);
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    GuildFeedPublishUtils.f222315a.x(context, feed);
                }
            }
        }, pageParams, 20, null).show();
    }

    public final boolean C(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean switchToH5, @NotNull Function0<Unit> callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (context.h().getConfiguration().getIsDisableDraft()) {
            return false;
        }
        if (context.h().getIsEditDraft() && !switchToH5) {
            z16 = true;
        } else {
            z16 = false;
        }
        Object obj = new Object();
        com.tencent.mvi.base.route.j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), GuildAIODispatchers.f112358a.e(), null, new GuildFeedPublishUtils$showSaveDraftDialog$$inlined$doOnOneShot$1(e16, null, obj, callback), 2, null);
        context.e().h(new FeedEditorDraftUseCaseMsgIntent.ShowSaveDraftTips("", false, z16, false, obj));
        return true;
    }

    public final void D(@Nullable Activity hostActivity, @NotNull String guildId, @NotNull SpeakPermissionType type) {
        Long l3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(type, "type");
        switch (a.f222319a[type.ordinal()]) {
            case 1:
                return;
            case 2:
                z(hostActivity, guildId);
                return;
            case 3:
                B(guildId);
                return;
            case 4:
            case 5:
            case 6:
                IGProGuildInfo L = ch.L(guildId);
                com.tencent.mobileqq.guild.feed.feedsquare.utils.j jVar = com.tencent.mobileqq.guild.feed.feedsquare.utils.j.f219338a;
                Long l16 = null;
                if (L != null) {
                    l3 = Long.valueOf(L.getShutUpExpireTime());
                } else {
                    l3 = null;
                }
                if (L != null) {
                    l16 = Long.valueOf(L.getMyShutUpExpireTime());
                }
                yl1.n.A(0, jVar.e(l3, l16));
                return;
            case 7:
                yl1.n.z(0, R.string.f158221p1);
                return;
            case 8:
                yl1.n.A(0, "\u9891\u9053\u5df2\u88ab\u5c01\u7981\uff0c\u4e0d\u53ef\u53d1\u5e16");
                return;
            default:
                yl1.n.z(0, R.string.f145470rk);
                return;
        }
    }

    public final void E(@NotNull final Activity activity, @NotNull String guildId, @NotNull String channelId, @NotNull String channelName, int businessType, @NotNull Map<String, ? extends Serializable> attr, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull final Runnable onCallH5Activity) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(attr, "attr");
        Intrinsics.checkNotNullParameter(onCallH5Activity, "onCallH5Activity");
        final GuildFeedPublishInitBean guildFeedPublishInitBean = new GuildFeedPublishInitBean();
        guildFeedPublishInitBean.setGuildId(guildId);
        guildFeedPublishInitBean.setChannelId(channelId);
        String u16 = ax.u();
        guildFeedPublishInitBean.setTinyId(u16);
        af.f223838a.a(guildFeedPublishInitBean, activity);
        GuildFeedBaseInitBean q16 = ax.q(activity);
        if (q16 != null) {
            guildFeedPublishInitBean.setBusinessType(q16.getBusinessType());
            guildFeedPublishInitBean.setTroopUin(q16.getTroopUin());
            guildFeedPublishInitBean.setTroopRole(q16.getTroopRole());
        }
        if (guildFeedPublishInitBean.getBusinessType() == 6) {
            guildFeedPublishInitBean.setUserType(com.tencent.mobileqq.guild.feed.report.f.j(guildId));
        }
        guildFeedPublishInitBean.getAttrs().putAll(attr);
        guildFeedPublishInitBean.setJoinInfoParam(joinInfoParam);
        guildFeedPublishInitBean.setFeedReportSourceInfo(q16.getFeedReportSourceInfo());
        guildFeedPublishInitBean.setNickName(((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildUserDisplayName(guildId, u16));
        if (TextUtils.isEmpty(channelName)) {
            IGProChannelInfo B = ch.B(channelId);
            boolean z16 = false;
            if (B != null && B.isHiddenPostChannel()) {
                z16 = true;
            }
            channelName = "";
            if (!z16) {
                if (B != null) {
                    str = B.getChannelName();
                } else {
                    str = null;
                }
                if (str != null) {
                    channelName = str;
                }
            }
        }
        guildFeedPublishInitBean.setChannelName(channelName);
        HashMap<String, Serializable> attrs = guildFeedPublishInitBean.getAttrs();
        Intrinsics.checkNotNullExpressionValue(attrs, "initBean.attrs");
        attrs.put("is_part_not_selected", Integer.valueOf(TextUtils.isEmpty(guildFeedPublishInitBean.getChannelName()) ? 1 : 0));
        guildFeedPublishInitBean.setBusinessType(businessType);
        G(guildFeedPublishInitBean, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils$switchToH5PublisherNoContent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildFeedLauncher.A(activity, guildFeedPublishInitBean);
                onCallH5Activity.run();
            }
        });
    }

    @NotNull
    public final CharSequence F(@NotNull CharSequence charSequence) {
        CharSequence trimStart;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        trimStart = StringsKt__StringsKt.trimStart(charSequence, '\uff03', '#');
        return trimStart;
    }

    public final boolean h(@Nullable Function1<? super SpeakPermissionType, Unit> howToToast, @NotNull String guildId, @NotNull String channelId, @Nullable a.Companion.Args customArgs) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (GuildInfoManager.q().P(channelId)) {
            boolean L = GuildInfoManager.L(guildId, channelId);
            if (L && howToToast != null) {
                howToToast.invoke(SpeakPermissionType.PERMISSION_TYPE_MUTED);
            }
            return !L;
        }
        if (customArgs == null) {
            customArgs = new a.Companion.Args(guildId, channelId);
            customArgs.h(2);
            customArgs.g(false);
        }
        SpeakPermissionType a16 = new el1.a(customArgs).a();
        SpeakPermissionType speakPermissionType = SpeakPermissionType.PERMISSION_TYPE_NORMAL;
        if (a16 != speakPermissionType) {
            QLog.i("GuildFeedPublishUtils", 1, "checkPublishFeedPermission|type=" + a16);
        }
        if (howToToast != null) {
            howToToast.invoke(a16);
        }
        if (a16 == speakPermissionType) {
            return true;
        }
        return false;
    }

    public final boolean j(@Nullable final Activity hostActivity, @NotNull final String guildId, @NotNull final String channelId, boolean isPublishedGuildFeedModify) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (!i(this, new Function1<SpeakPermissionType, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils$checkSpeakPermission$isThresholdMet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpeakPermissionType speakPermissionType) {
                invoke2(speakPermissionType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpeakPermissionType it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (GuildInfoManager.q().P(channelId)) {
                    String toastText = GuildInfoManager.q().F(guildId, channelId);
                    Intrinsics.checkNotNullExpressionValue(toastText, "toastText");
                    yl1.n.A(0, toastText);
                    return;
                }
                GuildFeedPublishUtils.f222315a.D(hostActivity, guildId, it);
            }
        }, guildId, channelId, null, 8, null)) {
            return false;
        }
        if (!isPublishedGuildFeedModify && GuildInfoManager.q().M(channelId)) {
            yl1.n.z(0, R.string.f145470rk);
            return false;
        }
        return true;
    }

    public final boolean k(@Nullable Function1<? super SpeakPermissionType, Unit> howToToast, @NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        SpeakPermissionType a16 = new el1.a(new a.Companion.Args(guildId, channelId)).a();
        SpeakPermissionType speakPermissionType = SpeakPermissionType.PERMISSION_TYPE_NORMAL;
        if (a16 != speakPermissionType) {
            QLog.i("GuildFeedPublishUtils", 1, "checkVisitFeedPermission|type=" + a16);
        }
        if (howToToast != null) {
            howToToast.invoke(a16);
        }
        if (a16 == speakPermissionType) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Map<String, Serializable> s(@NotNull zl1.a param) {
        Map<String, Serializable> mapOf;
        Intrinsics.checkNotNullParameter(param, "param");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("launch_redirect_action", Integer.valueOf(param.getOnPublishRedirectActionId())), TuplesKt.to("topic_id", zl1.b.f(param)), TuplesKt.to("topic_name", zl1.b.g(param)), TuplesKt.to("is_part_not_selected", Integer.valueOf(zl1.b.l(param))), TuplesKt.to("launch_request_id", Integer.valueOf(param.getExtra().getInt("launch_request_id"))), TuplesKt.to(JumpGuildParam.KEY_JOIN_INFO_PARAM, param.getExtra().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)));
        return mapOf;
    }

    @NotNull
    public final String t() {
        boolean z16;
        String f16 = QQGuildMCParser.INSTANCE.f("103101", "guild_feed_publish_web_url", "");
        if (f16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16 = null;
        }
        if (f16 == null) {
            String c16 = w.c("qqguild", "guild_feed_publish_web_url", ay.f223859a);
            Intrinsics.checkNotNullExpressionValue(c16, "getConfigValue(\n        \u2026WEB_URL_DEFAULT\n        )");
            return c16;
        }
        return f16;
    }

    public final boolean u(@NotNull String mainTaskId1, @NotNull String mainTaskId2) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        Intrinsics.checkNotNullParameter(mainTaskId1, "mainTaskId1");
        Intrinsics.checkNotNullParameter(mainTaskId2, "mainTaskId2");
        if (!TextUtils.isEmpty(mainTaskId1) && !TextUtils.isEmpty(mainTaskId2)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(mainTaskId1, "GuildNativeMain", false, 2, null);
            if (startsWith$default) {
                startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(mainTaskId2, "GuildNativeMain", false, 2, null);
                if (startsWith$default4) {
                    return true;
                }
            }
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(mainTaskId1, "GuildMain", false, 2, null);
            if (startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(mainTaskId2, "GuildMain", false, 2, null);
                if (startsWith$default3) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean v() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102718", true);
    }

    public final boolean w(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(guildId);
        if (guildInfo == null) {
            return false;
        }
        boolean isVisitorOperate = ((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getIsVisitorOperate(guildInfo, 2);
        QLog.i("GuildFeedPublishUtils", 1, "[isVisitorOperate] visitorInteractionAllSwitch = " + guildInfo.getVisitorInteractionAllSwitch());
        if (guildInfo.isMember() || !isVisitorOperate) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DialogInterface dialogInterface, int i3) {
    }
}
