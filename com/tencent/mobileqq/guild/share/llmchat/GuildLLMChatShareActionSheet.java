package com.tencent.mobileqq.guild.share.llmchat;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.share.GuildLLMChatShareScreenshot;
import com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareActionSheet;
import com.tencent.mobileqq.guild.share.q;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.GuildForwardUtilKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.i;
import com.tencent.mobileqq.sharepanel.j;
import com.tencent.mobileqq.sharepanel.k;
import com.tencent.mobileqq.sharepanel.l;
import com.tencent.mobileqq.sharepanel.m;
import com.tencent.mobileqq.sharepanel.n;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u0001:\u000225B\u0007\u00a2\u0006\u0004\bA\u0010BJ*\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\"H\u0002J\n\u0010)\u001a\u0004\u0018\u00010\u0013H\u0002J\u0016\u0010,\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*J\u000e\u0010-\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareActionSheet;", "", "", "showError", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/share/b;", "", "callback", "v", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, UserInfo.SEX_FEMALE, "E", BdhLogUtil.LogTag.Tag_Conn, "N", "Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareActionSheet$b;", "shareParam", "Landroid/content/Intent;", "y", "D", "", "itemAction", "H", "Landroidx/fragment/app/FragmentActivity;", EventKey.ACT, "K", "G", "p", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "t", "shareActionSheet", "B", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", "Lcom/tencent/mobileqq/guild/share/llmchat/d;", "arkReq", "I", "M", "", "errorMsg", "L", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "a", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "pageSource", "b", "Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareActionSheet$b;", "c", "Ljava/lang/String;", "Lcom/tencent/mobileqq/guild/share/llmchat/FetchLLMShareArkInfo;", "d", "Lcom/tencent/mobileqq/guild/share/llmchat/FetchLLMShareArkInfo;", "arkInfoFetcher", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "e", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "task", "<init>", "()V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLLMChatShareActionSheet {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildSharePageSource pageSource = GuildSharePageSource.AI_CARD_SHOOT;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareParam shareParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String errorMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FetchLLMShareArkInfo arkInfoFetcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b task;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020'\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u0017\u0010\fR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\t\u0010\"R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b \u0010\fR\u0017\u0010+\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u001c\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareActionSheet$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "b", "j", "title", "c", "desc", "d", "iconUrl", "getTailIcon", "tailIcon", "f", "getTailDescription", "tailDescription", "g", "brandDescription", h.F, "llmTip", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "i", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "()Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "adapter", "pictureIconUrl", "k", "pictureTitleName", "", "l", "J", "()J", "pictureMaxWaitTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;Ljava/lang/String;Ljava/lang/String;J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareActionSheet$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class ShareParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String jumpUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String desc;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String iconUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tailIcon;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tailDescription;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String brandDescription;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String llmTip;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> adapter;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String pictureIconUrl;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String pictureTitleName;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
        private final long pictureMaxWaitTime;

        public ShareParam(@NotNull String jumpUrl, @NotNull String title, @NotNull String desc, @NotNull String iconUrl, @NotNull String tailIcon, @NotNull String tailDescription, @NotNull String brandDescription, @NotNull String llmTip, @NotNull GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> adapter, @NotNull String pictureIconUrl, @NotNull String pictureTitleName, long j3) {
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(tailIcon, "tailIcon");
            Intrinsics.checkNotNullParameter(tailDescription, "tailDescription");
            Intrinsics.checkNotNullParameter(brandDescription, "brandDescription");
            Intrinsics.checkNotNullParameter(llmTip, "llmTip");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(pictureIconUrl, "pictureIconUrl");
            Intrinsics.checkNotNullParameter(pictureTitleName, "pictureTitleName");
            this.jumpUrl = jumpUrl;
            this.title = title;
            this.desc = desc;
            this.iconUrl = iconUrl;
            this.tailIcon = tailIcon;
            this.tailDescription = tailDescription;
            this.brandDescription = brandDescription;
            this.llmTip = llmTip;
            this.adapter = adapter;
            this.pictureIconUrl = pictureIconUrl;
            this.pictureTitleName = pictureTitleName;
            this.pictureMaxWaitTime = j3;
        }

        @NotNull
        public final GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> a() {
            return this.adapter;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getBrandDescription() {
            return this.brandDescription;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShareParam)) {
                return false;
            }
            ShareParam shareParam = (ShareParam) other;
            if (Intrinsics.areEqual(this.jumpUrl, shareParam.jumpUrl) && Intrinsics.areEqual(this.title, shareParam.title) && Intrinsics.areEqual(this.desc, shareParam.desc) && Intrinsics.areEqual(this.iconUrl, shareParam.iconUrl) && Intrinsics.areEqual(this.tailIcon, shareParam.tailIcon) && Intrinsics.areEqual(this.tailDescription, shareParam.tailDescription) && Intrinsics.areEqual(this.brandDescription, shareParam.brandDescription) && Intrinsics.areEqual(this.llmTip, shareParam.llmTip) && Intrinsics.areEqual(this.adapter, shareParam.adapter) && Intrinsics.areEqual(this.pictureIconUrl, shareParam.pictureIconUrl) && Intrinsics.areEqual(this.pictureTitleName, shareParam.pictureTitleName) && this.pictureMaxWaitTime == shareParam.pictureMaxWaitTime) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getLlmTip() {
            return this.llmTip;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getPictureIconUrl() {
            return this.pictureIconUrl;
        }

        /* renamed from: h, reason: from getter */
        public final long getPictureMaxWaitTime() {
            return this.pictureMaxWaitTime;
        }

        public int hashCode() {
            return (((((((((((((((((((((this.jumpUrl.hashCode() * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.tailIcon.hashCode()) * 31) + this.tailDescription.hashCode()) * 31) + this.brandDescription.hashCode()) * 31) + this.llmTip.hashCode()) * 31) + this.adapter.hashCode()) * 31) + this.pictureIconUrl.hashCode()) * 31) + this.pictureTitleName.hashCode()) * 31) + androidx.fragment.app.a.a(this.pictureMaxWaitTime);
        }

        @NotNull
        /* renamed from: i, reason: from getter */
        public final String getPictureTitleName() {
            return this.pictureTitleName;
        }

        @NotNull
        /* renamed from: j, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public String toString() {
            return "ShareParam(jumpUrl=" + this.jumpUrl + ", title=" + this.title + ", desc=" + this.desc + ", iconUrl=" + this.iconUrl + ", tailIcon=" + this.tailIcon + ", tailDescription=" + this.tailDescription + ", brandDescription=" + this.brandDescription + ", llmTip=" + this.llmTip + ", adapter=" + this.adapter + ", pictureIconUrl=" + this.pictureIconUrl + ", pictureTitleName=" + this.pictureTitleName + ", pictureMaxWaitTime=" + this.pictureMaxWaitTime + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareActionSheet$c", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements j {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f235031b;

        c(FragmentActivity fragmentActivity) {
            this.f235031b = fragmentActivity;
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Logger.f235387a.d().a("Guild.share.GuildLLMChatShareActionSheet", 1, "onShareChannelClick");
            switch (channelId.hashCode()) {
                case -791575966:
                    if (channelId.equals("weixin")) {
                        GuildLLMChatShareActionSheet.this.H(9, this.f235031b);
                        return;
                    }
                    return;
                case -393543490:
                    if (channelId.equals("qqfriend")) {
                        GuildLLMChatShareActionSheet.this.C(this.f235031b);
                        return;
                    }
                    return;
                case -304161157:
                    if (channelId.equals("qzoneshuoshuo")) {
                        GuildLLMChatShareActionSheet.this.G(this.f235031b);
                        return;
                    }
                    return;
                case 154627506:
                    if (channelId.equals("weixincircle")) {
                        GuildLLMChatShareActionSheet.this.H(10, this.f235031b);
                        return;
                    }
                    return;
                case 1083130618:
                    if (channelId.equals("redbook")) {
                        GuildLLMChatShareActionSheet.this.F(this.f235031b);
                        return;
                    }
                    return;
                case 2024098531:
                    if (channelId.equals("qqchannel")) {
                        GuildLLMChatShareActionSheet.this.D(this.f235031b);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            Logger.f235387a.d().a("Guild.share.GuildLLMChatShareActionSheet", 1, "onAppendActionClick " + actionId);
            if (Intrinsics.areEqual(actionId, "generate_share_image")) {
                GuildLLMChatShareActionSheet.this.x(this.f235031b);
            } else if (Intrinsics.areEqual(actionId, WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK)) {
                GuildLLMChatShareActionSheet.this.p(this.f235031b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareActionSheet$d", "Lcom/tencent/mobileqq/sharepanel/k;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements k {
        d() {
        }

        @Override // com.tencent.mobileqq.sharepanel.k
        public void a() {
            Logger.f235387a.d().a("Guild.share.GuildLLMChatShareActionSheet", 1, "onSharePanelDismiss");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareActionSheet$e", "Lcom/tencent/mobileqq/sharepanel/i;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements i {
        e() {
        }

        @Override // com.tencent.mobileqq.sharepanel.i
        public void a() {
            Logger.f235387a.d().a("Guild.share.GuildLLMChatShareActionSheet", 1, "onSharePanelCancel");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareActionSheet$f", "Lcom/tencent/mobileqq/sharepanel/l;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements l {
        f() {
        }

        @Override // com.tencent.mobileqq.sharepanel.l
        public void a() {
            Logger.f235387a.d().a("Guild.share.GuildLLMChatShareActionSheet", 1, "onSharePanelShow");
        }
    }

    private final void A(ShareActionSheet shareActionSheet) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        intent.putExtra("forward_type", -1).putExtra("is_ark_display_share", true).putExtra(ForwardRecentActivity.SELECTION_MODE, 2).putExtras(bundle);
        shareActionSheet.setIntentForStartForwardRecentActivity(intent);
    }

    private final void B(ShareActionSheet shareActionSheet) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        arrayList.add(171);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(3);
        arrayList.add(218);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(153);
        arrayList2.add(1);
        bg bgVar = bg.f302144a;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(((Number) it.next()).intValue()));
        }
        ArrayList n3 = bgVar.n(arrayList3);
        bg bgVar2 = bg.f302144a;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(((Number) it5.next()).intValue()));
        }
        shareActionSheet.setActionSheetItems(n3, bgVar2.n(arrayList4));
        shareActionSheet.setRowVisibility(0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(final Activity activity) {
        v(true, new Function1<com.tencent.mobileqq.guild.share.b, Unit>() { // from class: com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareActionSheet$shareArkToFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.share.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.guild.share.b it) {
                boolean N;
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.mobileqq.guild.share.util.d dVar = com.tencent.mobileqq.guild.share.util.d.f235123a;
                String templateData = it.getTemplateData();
                Intrinsics.checkNotNullExpressionValue(templateData, "it.templateData");
                Intent b16 = dVar.b(templateData);
                N = GuildLLMChatShareActionSheet.this.N();
                if (!N) {
                    b16.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                    b16.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, false);
                } else {
                    b16.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
                    GuildLLMChatShareActionSheet.ShareParam shareParam = GuildLLMChatShareActionSheet.this.shareParam;
                    if (shareParam != null) {
                        GuildForwardUtilKt.m(b16, new SharePublishGuildFeedParam.LinkTypeParam(shareParam.getJumpUrl(), shareParam.getIconUrl(), shareParam.getTitle(), shareParam.getBrandDescription()));
                    }
                }
                RouteUtils.startActivityForResult(activity, b16, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Activity activity) {
        ShareParam u16 = u();
        if (u16 == null) {
            return;
        }
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, y(u16), -1);
    }

    private final void E(final ShareActionSheetBuilder.ActionSheetItem item, final Activity activity) {
        v(true, new Function1<com.tencent.mobileqq.guild.share.b, Unit>() { // from class: com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareActionSheet$shareLinkSpecialFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.share.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.guild.share.b it) {
                GuildLLMChatShareActionSheet.ShareParam u16;
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.mobileqq.guild.share.util.d dVar = com.tencent.mobileqq.guild.share.util.d.f235123a;
                String templateData = it.getTemplateData();
                Intrinsics.checkNotNullExpressionValue(templateData, "it.templateData");
                Intent b16 = dVar.b(templateData);
                b16.putExtra("key_direct_show_uin_type", ShareActionSheetBuilder.ActionSheetItem.this.uinType);
                b16.putExtra("key_direct_show_uin", ShareActionSheetBuilder.ActionSheetItem.this.uin);
                b16.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                b16.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, false);
                u16 = this.u();
                if (u16 != null) {
                    GuildForwardUtilKt.m(b16, new SharePublishGuildFeedParam.LinkTypeParam(u16.getJumpUrl(), u16.getIconUrl(), u16.getTitle(), u16.getBrandDescription()));
                }
                RouteUtils.startActivityForResult(activity, b16, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(final Activity activity) {
        final ShareParam u16 = u();
        if (u16 == null) {
            return;
        }
        GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> a16 = u16.a();
        GuildAISearchConfBean.Companion companion = GuildAISearchConfBean.INSTANCE;
        GuildSearchLLMChatPictureGenerator.f217767a.o(activity, new GuildSearchLLMChatPictureGenerator.GeneratorParam(a16, companion.a().getIconUrl(), "", true, companion.a().getCom.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants.KEY_PAGE_TITLE java.lang.String(), u16.getTitle(), 5000L, u16.getLlmTip()), new Function3<Boolean, View, Bitmap, Unit>() { // from class: com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareActionSheet$sharePictureToXHS$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, View view, Bitmap bitmap) {
                invoke(bool.booleanValue(), view, bitmap);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable View view, @Nullable Bitmap bitmap) {
                if (z16 && bitmap != null) {
                    m02.d.f415923a.s(activity, ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).createCacheFile(bitmap).getAbsolutePath(), u16.getTitle(), "");
                    return;
                }
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "sharePictureToXHS startGenerate error " + z16 + " " + bitmap;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().b("Guild.share.GuildLLMChatShareActionSheet", 1, (String) it.next(), null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(Activity activity) {
        ArrayList<String> arrayListOf;
        ShareParam u16 = u();
        if (u16 == null) {
            return;
        }
        IShareActionHelper iShareActionHelper = (IShareActionHelper) QRoute.api(IShareActionHelper.class);
        com.tencent.mobileqq.sharehelper.d dVar = new com.tencent.mobileqq.sharehelper.d();
        dVar.n(u16.getBrandDescription());
        dVar.j("");
        dVar.p(new Regex("\\R+").replace(u16.getTitle(), " "));
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(u16.getIconUrl());
        dVar.l(arrayListOf);
        dVar.o(u16.getJumpUrl());
        dVar.i(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
        dVar.m(-1);
        Unit unit = Unit.INSTANCE;
        iShareActionHelper.doShareToQZoneWithLink("guildShare", activity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(int itemAction, Activity activity) {
        ShareParam u16 = u();
        if (u16 == null) {
            return;
        }
        ((IShareActionHelper) QRoute.api(IShareActionHelper.class)).doShareLinkToWeChat("guildShare", itemAction, u16.getJumpUrl(), activity, String.valueOf(NetConnInfoCenter.getServerTimeMillis()), u16.getDesc(), u16.getPictureTitleName() + "\uff1a" + u16.getTitle(), u16.getIconUrl(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(GuildLLMChatShareActionSheet this$0, Activity activity, View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        boolean z16 = true;
        Logger.f235387a.d().a("Guild.share.GuildLLMChatShareActionSheet", 1, "ItemClickListenerV3 item:" + item + " view:" + view);
        Intrinsics.checkNotNullExpressionValue(item, "item");
        this$0.z(item, activity);
        if (this$0.shareParam == null) {
            String str = this$0.errorMsg;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = false;
                }
            }
            if (z16) {
                g.f(-1, "\u6570\u636e\u51c6\u5907\u4e2d");
                return;
            }
        }
        if (shareActionSheet != null) {
            shareActionSheet.dismiss();
        }
    }

    private final void K(FragmentActivity act) {
        com.tencent.mobileqq.sharepanel.f createSharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(act, "pindao_aisearchh5");
        createSharePanel.k0(new n() { // from class: com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareActionSheet$showShareActionV2$1
            @Override // com.tencent.mobileqq.sharepanel.n
            public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull final m callback) {
                Intrinsics.checkNotNullParameter(targetList, "targetList");
                Intrinsics.checkNotNullParameter(callback, "callback");
                Logger.f235387a.d().a("Guild.share.GuildLLMChatShareActionSheet", 1, "prepareForwardData");
                final GuildLLMChatShareActionSheet guildLLMChatShareActionSheet = GuildLLMChatShareActionSheet.this;
                guildLLMChatShareActionSheet.v(true, new Function1<com.tencent.mobileqq.guild.share.b, Unit>() { // from class: com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareActionSheet$showShareActionV2$1$prepareForwardData$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.share.b bVar) {
                        invoke2(bVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.mobileqq.guild.share.b it) {
                        GuildLLMChatShareActionSheet.ShareParam u16;
                        Intrinsics.checkNotNullParameter(it, "it");
                        com.tencent.mobileqq.guild.share.util.d dVar = com.tencent.mobileqq.guild.share.util.d.f235123a;
                        String templateData = it.getTemplateData();
                        Intrinsics.checkNotNullExpressionValue(templateData, "it.templateData");
                        Intent b16 = dVar.b(templateData);
                        u16 = GuildLLMChatShareActionSheet.this.u();
                        if (u16 != null) {
                            GuildForwardUtilKt.m(b16, new SharePublishGuildFeedParam.LinkTypeParam(u16.getJumpUrl(), u16.getIconUrl(), u16.getTitle(), u16.getBrandDescription()));
                        }
                        callback.a(b16);
                    }
                });
            }
        });
        createSharePanel.d0(new com.tencent.mobileqq.guild.share.g(act, GuildSharePageSource.AI_CARD_SHOOT, null, null, 12, null).b());
        createSharePanel.t0(new c(act));
        createSharePanel.n0(new d());
        createSharePanel.i0(new e());
        createSharePanel.e0(new f());
        createSharePanel.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N() {
        boolean useNewSharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("pindao_aisearchh5");
        Logger.f235387a.d().d("Guild.share.GuildLLMChatShareActionSheet", 1, "[useNewSharePanel] useNewPanel " + useNewSharePanel);
        return useNewSharePanel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Activity activity) {
        ClipboardManager clipboardManager;
        ShareParam u16 = u();
        if (u16 == null) {
            return;
        }
        Object systemService = activity.getSystemService("clipboard");
        if (systemService instanceof ClipboardManager) {
            clipboardManager = (ClipboardManager) systemService;
        } else {
            clipboardManager = null;
        }
        if (clipboardManager != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText("group_pro_url", u16.getJumpUrl()));
        }
        g.f(2, "\u590d\u5236\u6210\u529f");
    }

    private final ShareActionSheetV2.Param q(Context context) {
        List listOf;
        int collectionSizeOrDefault;
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        final q qVar = new q();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{153, 1});
        List list = listOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(((Number) it.next()).intValue()));
        }
        qVar.e(arrayList);
        param.actionSheetRender = new ShareActionSheetV2.l() { // from class: com.tencent.mobileqq.guild.share.llmchat.b
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.l
            public final void b(ActionSheet actionSheet) {
                GuildLLMChatShareActionSheet.r(q.this, this, actionSheet);
            }
        };
        param.itemRender = new ShareActionSheetV2.m() { // from class: com.tencent.mobileqq.guild.share.llmchat.c
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.m
            public final void a(View view, ImageView imageView, TextView textView, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
                GuildLLMChatShareActionSheet.s(q.this, view, imageView, textView, actionSheetItem);
            }
        };
        return param;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(q shareDtReportHelper, GuildLLMChatShareActionSheet this$0, ActionSheet actionSheet) {
        String str;
        GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> a16;
        AiChatSession m06;
        a.AnswerItem e16;
        GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> a17;
        AiChatSession m07;
        Intrinsics.checkNotNullParameter(shareDtReportHelper, "$shareDtReportHelper");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildSharePageSource guildSharePageSource = this$0.pageSource;
        ShareParam shareParam = this$0.shareParam;
        String str2 = null;
        if (shareParam != null && (a17 = shareParam.a()) != null && (m07 = a17.m0()) != null) {
            str = m07.getSessionId();
        } else {
            str = null;
        }
        ShareParam shareParam2 = this$0.shareParam;
        if (shareParam2 != null && (a16 = shareParam2.a()) != null && (m06 = a16.m0()) != null && (e16 = m06.e()) != null) {
            str2 = e16.getMessageId();
        }
        shareDtReportHelper.b(actionSheet, guildSharePageSource, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(q shareDtReportHelper, View view, ImageView imageView, TextView nickView, ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        Intrinsics.checkNotNullParameter(shareDtReportHelper, "$shareDtReportHelper");
        Intrinsics.checkNotNullExpressionValue(nickView, "nickView");
        Intrinsics.checkNotNullExpressionValue(sheetItem, "sheetItem");
        shareDtReportHelper.a(view, imageView, nickView, sheetItem);
    }

    private final ShareActionSheet t(Context context) {
        ShareActionSheet shareActionSheet = ShareActionSheetFactory.create(q(context));
        Intrinsics.checkNotNullExpressionValue(shareActionSheet, "shareActionSheet");
        B(shareActionSheet);
        A(shareActionSheet);
        if (shareActionSheet.getExtras() == null) {
            shareActionSheet.setExtras(BundleKt.bundleOf(TuplesKt.to("no_need_report", Boolean.TRUE)));
        } else {
            shareActionSheet.getExtras().putBoolean("no_need_report", true);
        }
        return shareActionSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ShareParam u() {
        boolean z16;
        String str;
        boolean isBlank;
        ShareParam shareParam = this.shareParam;
        if (shareParam == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("handleItemClick failed: shareParam is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().b("Guild.share.GuildLLMChatShareActionSheet", 1, (String) it.next(), null);
            }
            String str2 = this.errorMsg;
            if (str2 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        str = "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                    } else {
                        str = this.errorMsg;
                    }
                    g.f(1, str);
                    return null;
                }
            }
            z16 = true;
            if (!z16) {
            }
            g.f(1, str);
            return null;
        }
        return shareParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(boolean showError, Function1<? super com.tencent.mobileqq.guild.share.b, Unit> callback) {
        Job f16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.task;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = null;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
            Logger logger = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("cancel the previous show");
            Iterator<T> it = bVar3.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.share.GuildLLMChatShareActionSheet", 1, (String) it.next(), null);
            }
        }
        CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f17 != null) {
            bVar2 = CorountineFunKt.e(f17, "Guild.share.GuildLLMChatShareActionSheet_share panel", null, null, Boolean.TRUE, new GuildLLMChatShareActionSheet$fetchArkInfo$2(this, showError, callback, null), 6, null);
        }
        this.task = bVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void w(GuildLLMChatShareActionSheet guildLLMChatShareActionSheet, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        guildLLMChatShareActionSheet.v(z16, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Activity activity) {
        ShareParam u16 = u();
        if (u16 == null) {
            return;
        }
        GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> a16 = u16.a();
        String pictureIconUrl = u16.getPictureIconUrl();
        String pictureTitleName = u16.getPictureTitleName();
        long pictureMaxWaitTime = u16.getPictureMaxWaitTime();
        new GuildLLMChatShareScreenshot(activity, GuildSharePageSource.AI_CARD_SHOOT, new GuildSearchLLMChatPictureGenerator.GeneratorParam(a16, pictureIconUrl, u16.getJumpUrl(), false, pictureTitleName, u16.getTitle(), pictureMaxWaitTime, u16.getLlmTip())).m();
    }

    private final Intent y(ShareParam shareParam) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", -1);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, shareParam.getJumpUrl());
        intent.putExtra(AppConstants.Key.GUILD_SHARE_TEXT_WITH_COMPATIBLE_H5_CARD, true);
        intent.putExtra("title", shareParam.getTitle());
        intent.putExtra("desc", shareParam.getBrandDescription());
        intent.putExtra("image_url", shareParam.getIconUrl());
        intent.putExtra("detail_url", shareParam.getJumpUrl());
        intent.putExtra("isFromShare", true);
        GuildForwardUtilKt.m(intent, new SharePublishGuildFeedParam.LinkTypeParam(shareParam.getJumpUrl(), shareParam.getIconUrl(), shareParam.getTitle(), shareParam.getBrandDescription()));
        return intent;
    }

    private final void z(ShareActionSheetBuilder.ActionSheetItem item, Activity activity) {
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "handleItemClick item:" + item;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().b("Guild.share.GuildLLMChatShareActionSheet", 1, (String) it.next(), null);
        }
        int i3 = item.action;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9 && i3 != 10) {
                        if (i3 != 72) {
                            if (i3 != 73) {
                                if (i3 != 153) {
                                    if (i3 != 171) {
                                        if (i3 != 218) {
                                            Logger logger2 = Logger.f235387a;
                                            Logger.b bVar2 = new Logger.b();
                                            String str2 = "not support action " + item.action;
                                            if (str2 instanceof String) {
                                                bVar2.a().add(str2);
                                            }
                                            Iterator<T> it5 = bVar2.a().iterator();
                                            while (it5.hasNext()) {
                                                Logger.f235387a.d().e("Guild.share.GuildLLMChatShareActionSheet", 1, (String) it5.next(), null);
                                            }
                                            g.f(0, "\u6682\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
                                            return;
                                        }
                                        F(activity);
                                        return;
                                    }
                                    D(activity);
                                    return;
                                }
                                x(activity);
                                return;
                            }
                        } else {
                            E(item, activity);
                            return;
                        }
                    } else {
                        H(i3, activity);
                        return;
                    }
                } else {
                    G(activity);
                    return;
                }
            }
            C(activity);
            return;
        }
        p(activity);
    }

    public final void I(@NotNull final Activity activity, @NotNull ShareReqData arkReq) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arkReq, "arkReq");
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.share.GuildLLMChatShareActionSheet", 1, "show Param:" + this.shareParam);
            }
            Intent intent = activity.getIntent();
            if (intent != null) {
                intent.putExtra("big_brother_source_key", "biz_src_jc_qqstation");
            }
            Intent intent2 = activity.getIntent();
            if (intent2 != null) {
                intent2.putExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, this.pageSource);
            }
            this.arkInfoFetcher = new FetchLLMShareArkInfo(arkReq.a());
            if ((activity instanceof FragmentActivity) && N()) {
                K((FragmentActivity) activity);
            } else {
                ShareActionSheet t16 = t(activity);
                t16.setItemClickListenerV3(new ShareActionSheet.c() { // from class: com.tencent.mobileqq.guild.share.llmchat.a
                    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
                    public final void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                        GuildLLMChatShareActionSheet.J(GuildLLMChatShareActionSheet.this, activity, view, actionSheetItem, shareActionSheet);
                    }
                });
                t16.show();
            }
            w(this, false, null, 3, null);
            return;
        }
        Logger.f235387a.d().a("Guild.share.GuildLLMChatShareActionSheet", 1, "show with invalid activity: " + activity);
    }

    public final void L(@NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.errorMsg = errorMsg;
    }

    public final void M(@NotNull ShareParam shareParam) {
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        this.shareParam = shareParam;
    }
}
