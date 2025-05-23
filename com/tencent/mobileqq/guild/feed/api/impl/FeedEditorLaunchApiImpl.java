package com.tencent.mobileqq.guild.feed.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.core.util.Consumer;
import androidx.core.util.Supplier;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.api.FeedEditorCheckItemResult;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchOptionModel;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchSourceModel;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativepublish.FeedEditorConfiguration;
import com.tencent.mobileqq.guild.feed.nativepublish.launcher.compat.FeedPublishEditorLaunchCompat;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildHomeSections;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import el1.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wh2.ch;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 `2\u00020\u0001:\u0001`B\u0007\u00a2\u0006\u0004\b^\u0010_JF\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J<\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016J\u001d\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0018\u001a\u00020\u001fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J#\u0010$\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J?\u0010'\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J?\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+JM\u00104\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\n\u0012\b\u0012\u0004\u0012\u00020302\u0012\u0006\u0012\u0004\u0018\u00010\u00010.2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010-\u001a\u00020,H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u00105J?\u00106\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u00107J?\u00108\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u00107J2\u0010:\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010>\u001a\u00020=2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010?\u001a\u00020&2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010@\u001a\u00020;2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010A\u001a\u00020&*\u00020=2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J=\u0010B\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u00107J2\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020D0C2\u0006\u0010\t\u001a\u00020\b2\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020D\u0018\u00010CH\u0002J\u008a\u0001\u0010K\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2]\u0010J\u001aY\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(H\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020D\u0018\u00010C\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020&0Gj\u0002`IH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010LJ:\u0010R\u001a\"\u0012\u0004\u0012\u00020\u0017\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020P\u0018\u00010Oj\n\u0012\u0004\u0012\u00020P\u0018\u0001`Q0N2\u0006\u0010\t\u001a\u00020\b2\b\u0010M\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010S\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010U\u001a\u00020&*\u00020=2\u0006\u0010\t\u001a\u00020\bH\u0002J\"\u0010X\u001a\u0002032\u0006\u0010V\u001a\u00020=2\b\u0010W\u001a\u0004\u0018\u00010)2\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010Z\u001a\u00020&2\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010W\u001a\u00020)2\u0006\u0010V\u001a\u00020=H\u0002J\u0018\u0010[\u001a\u00020&2\u0006\u0010W\u001a\u00020)2\u0006\u0010V\u001a\u00020=H\u0002J\u0018\u0010]\u001a\u00020&2\u0006\u0010\\\u001a\u00020\u00172\u0006\u0010V\u001a\u00020=H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/FeedEditorLaunchApiImpl;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/data/s;", "contact", "Lcom/tencent/mobileqq/guild/feed/api/FeedEditorLaunchOptionModel;", "option", "Lcom/tencent/mobileqq/guild/feed/api/b;", "source", "Lorg/json/JSONObject;", "richContentJson", "Lcom/tencent/mobileqq/guild/feed/api/c;", "checkItemListener", "Lcom/tencent/mobileqq/guild/feed/api/d;", "startProcedureAware", "Lkotlinx/coroutines/Job;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "traceId", "Lkotlinx/coroutines/CoroutineScope;", "scope", "y", "", "guildId", "Landroidx/core/util/Supplier;", "Landroid/app/Activity;", "activitySupplier", "Landroidx/core/util/Consumer;", "Lcom/tencent/mobileqq/guild/feed/api/a;", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelId", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "o", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(ILcom/tencent/mobileqq/guild/data/s;Lorg/json/JSONObject;Lcom/tencent/mobileqq/guild/feed/api/FeedEditorLaunchOptionModel;Lcom/tencent/mobileqq/guild/feed/api/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/util/RichContentJsonPreProcessor$b;", "v", "(Lcom/tencent/mobileqq/guild/feed/api/FeedEditorLaunchOptionModel;ILorg/json/JSONObject;Lcom/tencent/mobileqq/guild/data/s;Lcom/tencent/mobileqq/guild/feed/api/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/util/RichContentJsonPreProcessor$a;", "processOption", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "errorCode", "Lkotlin/coroutines/Continuation;", "", "u", "(Lcom/tencent/mobileqq/guild/feed/api/c;Lcom/tencent/mobileqq/guild/feed/util/RichContentJsonPreProcessor$a;)Lkotlin/jvm/functions/Function2;", "L", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/data/s;Lcom/tencent/mobileqq/guild/feed/api/FeedEditorLaunchOptionModel;Lcom/tencent/mobileqq/guild/feed/api/b;Lcom/tencent/mobileqq/guild/feed/api/d;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "K", "editSceneType", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "bean", "Landroid/os/Bundle;", "E", "J", "r", "O", "B", "", "Ljava/io/Serializable;", "extraAttrs", "D", "Lkotlin/Function3;", "channelName", "Lcom/tencent/mobileqq/guild/feed/api/impl/LongFeedEditorIgnitionFun;", "ignition", UserInfo.SEX_FEMALE, "(Lcom/tencent/mobileqq/guild/data/s;Lcom/tencent/mobileqq/guild/feed/api/FeedEditorLaunchOptionModel;Lcom/tencent/mobileqq/guild/feed/api/b;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "p", "w", HippyTKDListViewAdapter.X, "M", "args", "processResult", "N", "scene", "I", "G", "finalRichContentJson", "H", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f217987a = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/FeedEditorLaunchApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildHomeSections;", "kotlin.jvm.PlatformType", "result", "", "a", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildHomeSections;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ch {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Long> f217989b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Long> cancellableContinuation) {
            this.f217989b = cancellableContinuation;
        }

        @Override // wh2.ch
        public final void a(IGProGuildHomeSections iGProGuildHomeSections) {
            Object m476constructorimpl;
            Long l3;
            Object obj;
            CancellableContinuation<Long> cancellableContinuation = this.f217989b;
            try {
                Result.Companion companion = Result.INSTANCE;
                ArrayList<IGProChannel> feedChannels = iGProGuildHomeSections.getFeedChannels();
                Intrinsics.checkNotNullExpressionValue(feedChannels, "result.feedChannels");
                Iterator<T> it = feedChannels.iterator();
                while (true) {
                    l3 = null;
                    if (it.hasNext()) {
                        obj = it.next();
                        if (yl1.i.f450608a.k(((IGProChannel) obj).getHiddenPostChannel())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                IGProChannel iGProChannel = (IGProChannel) obj;
                Result.Companion companion2 = Result.INSTANCE;
                if (iGProChannel != null) {
                    l3 = Long.valueOf(iGProChannel.getChannelId());
                }
                cancellableContinuation.resumeWith(Result.m476constructorimpl(l3));
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion3 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("getGuildHomeSections()  Fails");
                Iterator<T> it5 = bVar.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("FeedEditorLaunchApiImpl", 1, (String) it5.next(), m479exceptionOrNullimpl);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object A(int i3, com.tencent.mobileqq.guild.data.s sVar, JSONObject jSONObject, FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, com.tencent.mobileqq.guild.feed.api.c cVar, Continuation<? super Unit> continuation) {
        FeedEditorLaunchApiImpl$performRichContentJsonCheckItem$1 feedEditorLaunchApiImpl$performRichContentJsonCheckItem$1;
        Object coroutine_suspended;
        int i16;
        int i17;
        com.tencent.mobileqq.guild.feed.api.c cVar2;
        if (continuation instanceof FeedEditorLaunchApiImpl$performRichContentJsonCheckItem$1) {
            feedEditorLaunchApiImpl$performRichContentJsonCheckItem$1 = (FeedEditorLaunchApiImpl$performRichContentJsonCheckItem$1) continuation;
            int i18 = feedEditorLaunchApiImpl$performRichContentJsonCheckItem$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                feedEditorLaunchApiImpl$performRichContentJsonCheckItem$1.label = i18 - Integer.MIN_VALUE;
                FeedEditorLaunchApiImpl$performRichContentJsonCheckItem$1 feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12 = feedEditorLaunchApiImpl$performRichContentJsonCheckItem$1;
                Object obj = feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12.label;
                if (i16 == 0) {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 == 3) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            int i19 = feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12.I$0;
                            cVar2 = (com.tencent.mobileqq.guild.feed.api.c) feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            i17 = i19;
                            if (((RichContentJsonPreProcessor.RichContentProcessResult) obj) != null) {
                                QLog.i("FeedEditorLaunchApiImpl", 1, "[performRichContentJsonCheckItem]: traceId=" + i17 + ", processResult is null, check procedure is stop");
                                return Unit.INSTANCE;
                            }
                            FeedEditorCheckItemResult feedEditorCheckItemResult = new FeedEditorCheckItemResult(0, null);
                            feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12.L$0 = null;
                            feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12.label = 3;
                            if (cVar2.a(feedEditorCheckItemResult, feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (jSONObject == null) {
                        feedEditorLaunchOptionModel.setProcessResult(null);
                        FeedEditorCheckItemResult feedEditorCheckItemResult2 = new FeedEditorCheckItemResult(0, null);
                        feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12.label = 1;
                        if (cVar.a(feedEditorCheckItemResult2, feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12.L$0 = cVar;
                    i17 = i3;
                    feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12.I$0 = i17;
                    feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12.label = 2;
                    obj = v(feedEditorLaunchOptionModel, i3, jSONObject, sVar, cVar, feedEditorLaunchApiImpl$performRichContentJsonCheckItem$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cVar2 = cVar;
                    if (((RichContentJsonPreProcessor.RichContentProcessResult) obj) != null) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        feedEditorLaunchApiImpl$performRichContentJsonCheckItem$1 = new FeedEditorLaunchApiImpl$performRichContentJsonCheckItem$1(this, continuation);
        FeedEditorLaunchApiImpl$performRichContentJsonCheckItem$1 feedEditorLaunchApiImpl$performRichContentJsonCheckItem$122 = feedEditorLaunchApiImpl$performRichContentJsonCheckItem$1;
        Object obj2 = feedEditorLaunchApiImpl$performRichContentJsonCheckItem$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = feedEditorLaunchApiImpl$performRichContentJsonCheckItem$122.label;
        if (i16 == 0) {
        }
        return Unit.INSTANCE;
    }

    private final Object B(final Context context, final com.tencent.mobileqq.guild.data.s sVar, final FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, final FeedEditorLaunchSourceModel feedEditorLaunchSourceModel, final com.tencent.mobileqq.guild.feed.api.d dVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object F = F(sVar, feedEditorLaunchOptionModel, feedEditorLaunchSourceModel, new Function3<String, String, Map<String, ? extends Serializable>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$prepareArgsAndStartLongFeedEditor$ignition$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, Map<String, ? extends Serializable> map) {
                invoke2(str, str2, map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String richContentJson, @NotNull String channelName, @Nullable Map<String, ? extends Serializable> map) {
                int w3;
                int x16;
                Map<String, ? extends Serializable> D;
                Intrinsics.checkNotNullParameter(richContentJson, "richContentJson");
                Intrinsics.checkNotNullParameter(channelName, "channelName");
                com.tencent.mobileqq.guild.feed.api.d dVar2 = com.tencent.mobileqq.guild.feed.api.d.this;
                if (dVar2 != null) {
                    dVar2.b();
                }
                this.J(feedEditorLaunchSourceModel);
                IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
                Context context2 = context;
                String guildId = sVar.getGuildId();
                String channelId = sVar.getChannelId();
                w3 = this.w(feedEditorLaunchSourceModel);
                x16 = this.x(feedEditorLaunchOptionModel);
                D = this.D(feedEditorLaunchSourceModel, map);
                iGuildFeedLauncherApi.launchGuildFeedH5Publish(context2, guildId, channelId, channelName, w3, x16, richContentJson, D);
            }
        }, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (F == coroutine_suspended) {
            return F;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(Context context, int editSceneType, com.tencent.mobileqq.guild.data.s contact, FeedEditorLaunchOptionModel option, FeedEditorLaunchSourceModel source) {
        Bundle E = E(source, r(contact, source), option);
        J(source);
        Object processResult = option.getProcessResult();
        if (!(processResult instanceof RichContentJsonPreProcessor.RichContentProcessResult)) {
            processResult = null;
        }
        N(E, (RichContentJsonPreProcessor.RichContentProcessResult) processResult, source);
        em1.a aVar = em1.a.f396585a;
        FeedPublishEditorLaunchCompat feedPublishEditorLaunchCompat = FeedPublishEditorLaunchCompat.f222113a;
        aVar.h(context, editSceneType, E, feedPublishEditorLaunchCompat.e(feedPublishEditorLaunchCompat.c(), feedPublishEditorLaunchCompat.f("publish new feed from scheme")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Serializable> D(FeedEditorLaunchSourceModel source, Map<String, ? extends Serializable> extraAttrs) {
        Map<String, Serializable> mutableMapOf;
        boolean z16;
        boolean z17 = true;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("launch_request_id", Integer.valueOf(source.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID java.lang.String())));
        String pginSourceName = source.getPginSourceName();
        if (pginSourceName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str = null;
        if (z16) {
            pginSourceName = null;
        }
        if (pginSourceName != null) {
            mutableMapOf.put("sgrp_stream_pgin_source_name", pginSourceName);
        }
        String visitFrom = source.getVisitFrom();
        if (visitFrom.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            str = visitFrom;
        }
        if (str != null) {
            mutableMapOf.put("sgrp_visit_from", str);
        }
        if (extraAttrs != null) {
            mutableMapOf.putAll(extraAttrs);
        }
        return mutableMapOf;
    }

    private final Bundle E(FeedEditorLaunchSourceModel source, GuildFeedBaseInitBean bean, FeedEditorLaunchOptionModel option) {
        boolean z16 = false;
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("launch_request_id", Integer.valueOf(source.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID java.lang.String())), TuplesKt.to(com.tencent.mobileqq.guild.feed.b.f218115a, bean), TuplesKt.to("launch_config", new FeedEditorConfiguration(false, false, false, false, true, true, true, false, 15, null)));
        O(bundleOf, option);
        bundleOf.putInt("launch_redirect_action", x(option));
        bm1.a aVar = bm1.a.f28652a;
        Bundle bundle = bundleOf.getBundle("launch_dlc_bundle");
        if (bundle == null) {
            bundle = new Bundle();
        }
        M(bundle, source);
        Boolean showPostFailToast = option.getShowPostFailToast();
        if (showPostFailToast != null) {
            bundle.putBoolean("show_fail_toast_flag", showPostFailToast.booleanValue());
        }
        Boolean showPostSuccessToast = option.getShowPostSuccessToast();
        if (showPostSuccessToast != null) {
            bundle.putBoolean("show_success_toast_flag", showPostSuccessToast.booleanValue());
        }
        Bundle backToThirdAppExtras = option.getBackToThirdAppExtras();
        if (backToThirdAppExtras != null) {
            bundle.putBundle(JumpGuildParam.EXTRA_BACK_TO_THIRD_APP, backToThirdAppExtras);
        }
        Boolean redirectWithNewTask = option.getRedirectWithNewTask();
        if (redirectWithNewTask != null) {
            bundle.putBoolean("use_new_task_to_launch_redirect_page", redirectWithNewTask.booleanValue());
        }
        Unit unit = Unit.INSTANCE;
        bundleOf.putBundle("launch_dlc_bundle", bundle);
        Integer enterAnim = option.getEnterAnim();
        if (enterAnim != null) {
            bundleOf.putInt("launch_enter_anim_res", enterAnim.intValue());
        }
        Integer exitAnim = option.getExitAnim();
        if (exitAnim != null) {
            bundleOf.putInt("launch_exit_anim_res", exitAnim.intValue());
        }
        HashMap hashMap = new HashMap();
        if (source.getSgrpSharePanelPageSource().length() > 0) {
            z16 = true;
        }
        if (z16) {
            hashMap.put(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, source.getSgrpSharePanelPageSource());
            bundleOf.putSerializable("dt_report_page_param", hashMap);
        }
        return bundleOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object F(com.tencent.mobileqq.guild.data.s sVar, FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, FeedEditorLaunchSourceModel feedEditorLaunchSourceModel, Function3<? super String, ? super String, ? super Map<String, ? extends Serializable>, Unit> function3, Continuation<? super Unit> continuation) {
        FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1 feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1;
        Object coroutine_suspended;
        int i3;
        Function3<? super String, ? super String, ? super Map<String, ? extends Serializable>, Unit> function32;
        ArrayList<LocalMediaInfo> arrayList;
        String str;
        long j3;
        IGProChannelInfo channelInfo;
        String str2;
        MainCoroutineDispatcher e16;
        FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1 feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1;
        long j16;
        if (continuation instanceof FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1) {
            feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1 = (FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1) continuation;
            int i16 = feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.label = i16 - Integer.MIN_VALUE;
                Object obj = feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            j16 = feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.J$0;
                            ResultKt.throwOnFailure(obj);
                            QLog.i("FeedEditorLaunchApiImpl", 1, "[prepareLongFeedRichContent]: cost=" + (System.currentTimeMillis() - j16));
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j17 = feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.J$0;
                    ArrayList<LocalMediaInfo> arrayList2 = (ArrayList) feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$2;
                    str = (String) feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$1;
                    Function3<? super String, ? super String, ? super Map<String, ? extends Serializable>, Unit> function33 = (Function3) feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    j3 = j17;
                    arrayList = arrayList2;
                    function32 = function33;
                } else {
                    ResultKt.throwOnFailure(obj);
                    long currentTimeMillis = System.currentTimeMillis();
                    Object processResult = feedEditorLaunchOptionModel.getProcessResult();
                    if (!(processResult instanceof RichContentJsonPreProcessor.RichContentProcessResult)) {
                        processResult = null;
                    }
                    Pair<String, ArrayList<LocalMediaInfo>> p16 = p(feedEditorLaunchSourceModel, (RichContentJsonPreProcessor.RichContentProcessResult) processResult);
                    String component1 = p16.component1();
                    ArrayList<LocalMediaInfo> component2 = p16.component2();
                    GuildMainFrameUtils guildMainFrameUtils = GuildMainFrameUtils.f227682a;
                    String guildId = sVar.getGuildId();
                    String channelId = sVar.getChannelId();
                    feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$0 = function3;
                    feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$1 = component1;
                    feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$2 = component2;
                    feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.J$0 = currentTimeMillis;
                    feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.label = 1;
                    Object h16 = GuildMainFrameUtils.h(guildMainFrameUtils, guildId, channelId, 0, null, feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1, 12, null);
                    if (h16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function32 = function3;
                    arrayList = component2;
                    obj = h16;
                    str = component1;
                    j3 = currentTimeMillis;
                }
                channelInfo = ((GuildMainFrameUtils.GuildAndChannelInfoRsp) obj).getChannelInfo();
                if (channelInfo == null) {
                    str2 = channelInfo.getChannelName();
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = str2;
                e16 = ae.a().e();
                long j18 = j3;
                feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1 = new FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1(function32, str, str3, arrayList, null);
                feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$0 = null;
                feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$1 = null;
                feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$2 = null;
                feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.J$0 = j18;
                feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.label = 2;
                if (BuildersKt.withContext(e16, feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1, feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                j16 = j18;
                QLog.i("FeedEditorLaunchApiImpl", 1, "[prepareLongFeedRichContent]: cost=" + (System.currentTimeMillis() - j16));
                return Unit.INSTANCE;
            }
        }
        feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1 = new FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1(this, continuation);
        Object obj2 = feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.label;
        if (i3 == 0) {
        }
        channelInfo = ((GuildMainFrameUtils.GuildAndChannelInfoRsp) obj2).getChannelInfo();
        if (channelInfo == null) {
        }
        if (str2 == null) {
        }
        String str32 = str2;
        e16 = ae.a().e();
        long j182 = j3;
        feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1 = new FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1(function32, str, str32, arrayList, null);
        feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$0 = null;
        feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$1 = null;
        feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.L$2 = null;
        feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.J$0 = j182;
        feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1.label = 2;
        if (BuildersKt.withContext(e16, feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1, feedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$1) != coroutine_suspended) {
        }
    }

    private final void G(RichContentJsonPreProcessor.RichContentProcessResult processResult, Bundle args) {
        List<LocalMediaInfo> a16 = processResult.a();
        if (!a16.isEmpty()) {
            String valueOf = String.valueOf(a16.hashCode());
            jj1.b c16 = jj1.b.c();
            Intrinsics.checkNotNullExpressionValue(c16, "getInstance()");
            com.tencent.mobileqq.guild.feed.util.p.a(c16, valueOf, a16);
            bm1.a aVar = bm1.a.f28652a;
            Bundle bundle = args.getBundle("launch_dlc_bundle");
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("local_media_info_list", valueOf);
            Unit unit = Unit.INSTANCE;
            args.putBundle("launch_dlc_bundle", bundle);
        }
    }

    private final void H(String finalRichContentJson, Bundle args) {
        if (com.tencent.mobileqq.guild.util.ch.s0()) {
            String valueOf = String.valueOf(finalRichContentJson.hashCode());
            args.putString("launch_json_feed_store_id", valueOf);
            jj1.b c16 = jj1.b.c();
            Intrinsics.checkNotNullExpressionValue(c16, "getInstance()");
            com.tencent.mobileqq.guild.feed.util.p.a(c16, valueOf, finalRichContentJson);
        } else {
            args.putString("launch_json_feed", finalRichContentJson);
        }
        args.putBoolean("launch_preset_content_flag", true);
    }

    private final void I(int scene, RichContentJsonPreProcessor.RichContentProcessResult processResult, Bundle args) {
        if (scene == 2 && (!processResult.a().isEmpty())) {
            args.putInt("launch_media_lock_size", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(FeedEditorLaunchSourceModel source) {
        boolean z16;
        String pginSourceName = source.getPginSourceName();
        boolean z17 = true;
        if (pginSourceName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str = null;
        if (z16) {
            pginSourceName = null;
        }
        if (pginSourceName != null) {
            com.tencent.mobileqq.guild.report.b.g(pginSourceName, "FeedEditorLaunchApiImpl");
        }
        String visitFrom = source.getVisitFrom();
        if (visitFrom.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            str = visitFrom;
        }
        if (str != null) {
            com.tencent.mobileqq.guild.report.b.i(str, "FeedEditorLaunchApiImpl");
        }
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).initGuildTaskQueueManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object K(Context context, com.tencent.mobileqq.guild.data.s sVar, FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, FeedEditorLaunchSourceModel feedEditorLaunchSourceModel, com.tencent.mobileqq.guild.feed.api.d dVar, Continuation<? super Unit> continuation) {
        String str;
        boolean z16;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        if (sVar != null) {
            str = sVar.getGuildId();
        } else {
            str = null;
        }
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("FeedEditorLaunchApiImpl", 1, "[startEditorDefault]: reqId=" + feedEditorLaunchSourceModel.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID java.lang.String() + ", guildId must not be empty");
            return Unit.INSTANCE;
        }
        if (sVar != null) {
            int feedType = feedEditorLaunchOptionModel.getFeedType();
            if (feedType != 0) {
                if (feedType != 1) {
                    QLog.e("FeedEditorLaunchApiImpl", 1, "[startEditorDefault]: invalid feed type: " + feedEditorLaunchOptionModel.getFeedType());
                } else {
                    if (sVar.getChannelId().length() > 0) {
                        z17 = true;
                    }
                    if (z17) {
                        Object B = B(context, sVar, feedEditorLaunchOptionModel, feedEditorLaunchSourceModel, dVar, continuation);
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (B == coroutine_suspended2) {
                            return B;
                        }
                        return Unit.INSTANCE;
                    }
                    QLog.e("FeedEditorLaunchApiImpl", 1, "[startEditorDefault]: use empty channelId to open long feed editor is not supported yet");
                }
                return Unit.INSTANCE;
            }
            Object withContext = BuildersKt.withContext(ae.a().e(), new FeedEditorLaunchApiImpl$startEditorDefault$2(dVar, this, context, sVar, feedEditorLaunchOptionModel, feedEditorLaunchSourceModel, null), continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (withContext == coroutine_suspended) {
                return withContext;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object L(Context context, com.tencent.mobileqq.guild.data.s sVar, FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, FeedEditorLaunchSourceModel feedEditorLaunchSourceModel, com.tencent.mobileqq.guild.feed.api.d dVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new FeedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2(feedEditorLaunchOptionModel, sVar, this, context, feedEditorLaunchSourceModel, dVar, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(Bundle bundle, FeedEditorLaunchSourceModel feedEditorLaunchSourceModel) {
        boolean z16;
        String pginSourceName = feedEditorLaunchSourceModel.getPginSourceName();
        boolean z17 = true;
        if (pginSourceName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str = null;
        if (z16) {
            pginSourceName = null;
        }
        if (pginSourceName != null) {
            bundle.putString("sgrp_stream_pgin_source_name", pginSourceName);
        }
        String visitFrom = feedEditorLaunchSourceModel.getVisitFrom();
        if (visitFrom.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            str = visitFrom;
        }
        if (str != null) {
            bundle.putString("sgrp_visit_from", str);
        }
    }

    private final boolean N(Bundle args, RichContentJsonPreProcessor.RichContentProcessResult processResult, FeedEditorLaunchSourceModel source) {
        if (processResult == null) {
            QLog.e("FeedEditorLaunchApiImpl", 1, "[supplementPresetRichContent] processResult is null");
            return false;
        }
        int scene = source.getScene();
        RichContentJsonPreProcessor.f223806a.m(processResult, scene);
        String jSONObject = processResult.getRichContentJsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "processResult.apply {\n  \u2026tentJsonObject.toString()");
        I(scene, processResult, args);
        H(jSONObject, args);
        G(processResult, args);
        return true;
    }

    private final void O(Bundle bundle, FeedEditorLaunchOptionModel feedEditorLaunchOptionModel) {
        boolean z16;
        Long topicId = feedEditorLaunchOptionModel.getTopicId();
        String topicName = feedEditorLaunchOptionModel.getTopicName();
        if (topicId != null) {
            if (topicName != null && topicName.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                bundle.putBundle("topic_element_append", BundleKt.bundleOf(TuplesKt.to("topic_id", topicId), TuplesKt.to("topic_name", topicName)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o(final String str, final String str2, Continuation<? super SpeakPermissionType> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        GuildMainFrameUtils.i(str, str2, 0, null, false, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$checkSpeakPermission$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                invoke2(guildAndChannelInfoRsp);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v5, types: [T, com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                IGProChannelInfo channelInfo = rsp.getChannelInfo();
                if (rsp.h() == null) {
                    CancellableContinuation<SpeakPermissionType> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(SpeakPermissionType.PERMISSION_TYPE_SIMPLE_INIT));
                    return;
                }
                if ((str2.length() > 0) && (channelInfo == null || (!channelInfo.isHiddenPostChannel() && channelInfo.getMyTalkPermissionType() != 2))) {
                    CancellableContinuation<SpeakPermissionType> cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(SpeakPermissionType.PERMISSION_TYPE_CHANNEL_LIMIT));
                    return;
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = SpeakPermissionType.PERMISSION_TYPE_NORMAL;
                GuildFeedPublishUtils guildFeedPublishUtils = GuildFeedPublishUtils.f222315a;
                Function1<SpeakPermissionType, Unit> function1 = new Function1<SpeakPermissionType, Unit>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$checkSpeakPermission$2$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SpeakPermissionType speakPermissionType) {
                        invoke2(speakPermissionType);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull SpeakPermissionType it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        objectRef.element = it;
                    }
                };
                String str3 = str;
                String str4 = str2;
                a.Companion.Args args = new a.Companion.Args(str3, str4);
                args.h(2);
                args.f(rsp.h());
                args.g(true);
                args.e(new SpeakPermissionType[]{SpeakPermissionType.PERMISSION_TYPE_GUILD_BANNED});
                Unit unit = Unit.INSTANCE;
                guildFeedPublishUtils.h(function1, str3, str4, args);
                CancellableContinuation<SpeakPermissionType> cancellableContinuation3 = cancellableContinuationImpl;
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuation3.resumeWith(Result.m476constructorimpl(objectRef.element));
            }
        }, 28, null);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final Pair<String, ArrayList<LocalMediaInfo>> p(FeedEditorLaunchSourceModel source, RichContentJsonPreProcessor.RichContentProcessResult result) {
        String jSONObject;
        ArrayList arrayList;
        int scene = source.getScene();
        if (result == null) {
            QLog.w("FeedEditorLaunchApiImpl", 1, "[processRichJsonForLongFeedEditor]: result is null");
            jSONObject = "";
            arrayList = null;
        } else {
            RichContentJsonPreProcessor.f223806a.m(result, scene);
            jSONObject = result.getRichContentJsonObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "result.richContentJsonObject.toString()");
            arrayList = new ArrayList(result.a());
        }
        return TuplesKt.to(jSONObject, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(long j3, Continuation<? super Long> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.S0(IGPSService.class, "")).getGuildHomeSections(j3, new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final GuildFeedBaseInitBean r(com.tencent.mobileqq.guild.data.s contact, FeedEditorLaunchSourceModel source) {
        String str;
        String channelId;
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        String str2 = "";
        if (contact == null || (str = contact.getGuildId()) == null) {
            str = "";
        }
        guildFeedBaseInitBean.setGuildId(str);
        if (contact != null && (channelId = contact.getChannelId()) != null) {
            str2 = channelId;
        }
        guildFeedBaseInitBean.setChannelId(str2);
        guildFeedBaseInitBean.setBusinessType(w(source));
        if (guildFeedBaseInitBean.getBusinessType() == 9) {
            GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
            guildFeedReportSourceInfo.addReportItem("extra_feeds_create_source", "showcase");
            guildFeedReportSourceInfo.addReportItem("extra_feeds_from_activity_id", source.getActivityId());
            guildFeedBaseInitBean.setFeedReportSourceInfo(guildFeedReportSourceInfo);
        }
        return guildFeedBaseInitBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Supplier activitySupplier, String guildId, FeedEditorCheckItemResult feedEditorCheckItemResult) {
        Intrinsics.checkNotNullParameter(activitySupplier, "$activitySupplier");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        int what = feedEditorCheckItemResult.getWhat();
        Object obj = null;
        Integer num = null;
        if (what != 1) {
            if (what != 2) {
                if (what != 3) {
                    if (what == 4) {
                        Object payload = feedEditorCheckItemResult.getPayload();
                        if (payload instanceof Integer) {
                            num = (Integer) payload;
                        }
                        if (num != null && num.intValue() == 1) {
                            yl1.n.z(0, R.string.f144380om);
                            return;
                        }
                        if (num != null && num.intValue() == 2) {
                            yl1.n.z(0, R.string.f145360r_);
                            return;
                        } else {
                            if (num != null && num.intValue() == 3) {
                                yl1.n.A(0, "\u5185\u5bb9\u5df2\u8fc7\u671f\u6216\u88ab\u6e05\u7406");
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                yl1.n.z(0, R.string.f157061lw);
                return;
            }
            yl1.n.z(0, R.string.f157071lx);
            return;
        }
        GuildFeedPublishUtils guildFeedPublishUtils = GuildFeedPublishUtils.f222315a;
        Activity activity = (Activity) activitySupplier.get();
        Object payload2 = feedEditorCheckItemResult.getPayload();
        if (payload2 instanceof SpeakPermissionType) {
            obj = payload2;
        }
        SpeakPermissionType speakPermissionType = (SpeakPermissionType) obj;
        if (speakPermissionType == null) {
            speakPermissionType = SpeakPermissionType.PERMISSION_TYPE_INVALID;
        }
        guildFeedPublishUtils.D(activity, guildId, speakPermissionType);
    }

    private final Function2<Integer, Continuation<? super Boolean>, Object> u(com.tencent.mobileqq.guild.feed.api.c checkItemListener, RichContentJsonPreProcessor.ProcessOption processOption) {
        return new FeedEditorLaunchApiImpl$makeProcessControlCallback$1(checkItemListener, processOption, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object v(FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, int i3, JSONObject jSONObject, com.tencent.mobileqq.guild.data.s sVar, com.tencent.mobileqq.guild.feed.api.c cVar, Continuation<? super RichContentJsonPreProcessor.RichContentProcessResult> continuation) {
        FeedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1 feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1;
        Object coroutine_suspended;
        int i16;
        RichContentJsonPreProcessor.ProcessOption processOption;
        FeedEditorLaunchOptionModel feedEditorLaunchOptionModel2;
        Object l3;
        if (continuation instanceof FeedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1) {
            feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1 = (FeedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1) continuation;
            int i17 = feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1.label = i17 - Integer.MIN_VALUE;
                FeedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1 feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$12 = feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1;
                Object obj = feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$12.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        FeedEditorLaunchOptionModel feedEditorLaunchOptionModel3 = (FeedEditorLaunchOptionModel) feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        l3 = obj;
                        feedEditorLaunchOptionModel2 = feedEditorLaunchOptionModel3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (feedEditorLaunchOptionModel.getFeedType() == 1) {
                        processOption = new RichContentJsonPreProcessor.ProcessOption(feedEditorLaunchOptionModel.getIsPanicModeInMediaFilterStep(), false, 50, 5, false);
                    } else {
                        processOption = new RichContentJsonPreProcessor.ProcessOption(feedEditorLaunchOptionModel.getIsPanicModeInMediaFilterStep(), false, 18, 1, true);
                    }
                    RichContentJsonPreProcessor.ProcessOption processOption2 = processOption;
                    RichContentJsonPreProcessor richContentJsonPreProcessor = RichContentJsonPreProcessor.f223806a;
                    Function2<Integer, Continuation<? super Boolean>, Object> u16 = u(cVar, processOption2);
                    feedEditorLaunchOptionModel2 = feedEditorLaunchOptionModel;
                    feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$12.L$0 = feedEditorLaunchOptionModel2;
                    feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$12.label = 1;
                    l3 = richContentJsonPreProcessor.l(i3, jSONObject, processOption2, u16, feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$12);
                    if (l3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                RichContentJsonPreProcessor.RichContentProcessResult richContentProcessResult = (RichContentJsonPreProcessor.RichContentProcessResult) l3;
                feedEditorLaunchOptionModel2.setProcessResult(richContentProcessResult);
                return richContentProcessResult;
            }
        }
        feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1 = new FeedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1(this, continuation);
        FeedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1 feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$122 = feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$1;
        Object obj2 = feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = feedEditorLaunchApiImpl$outputRichContentMediaNodeProcessResult$122.label;
        if (i16 == 0) {
        }
        RichContentJsonPreProcessor.RichContentProcessResult richContentProcessResult2 = (RichContentJsonPreProcessor.RichContentProcessResult) l3;
        feedEditorLaunchOptionModel2.setProcessResult(richContentProcessResult2);
        return richContentProcessResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int w(FeedEditorLaunchSourceModel source) {
        if (source.getScene() == 1) {
            return 9;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int x(FeedEditorLaunchOptionModel option) {
        int successAction = option.getSuccessAction();
        if (successAction == 1) {
            return 1;
        }
        if (successAction == 2) {
            return 2;
        }
        return 0;
    }

    @NotNull
    public Consumer<FeedEditorCheckItemResult> s(@NotNull final String guildId, @NotNull final Supplier<Activity> activitySupplier) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(activitySupplier, "activitySupplier");
        return new Consumer() { // from class: com.tencent.mobileqq.guild.feed.api.impl.a
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                FeedEditorLaunchApiImpl.t(Supplier.this, guildId, (FeedEditorCheckItemResult) obj);
            }
        };
    }

    @NotNull
    public Job y(int traceId, @NotNull CoroutineScope scope, @Nullable com.tencent.mobileqq.guild.data.s contact, @NotNull FeedEditorLaunchOptionModel option, @Nullable JSONObject richContentJson, @NotNull com.tencent.mobileqq.guild.feed.api.c checkItemListener) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(checkItemListener, "checkItemListener");
        launch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new FeedEditorLaunchApiImpl$performCheckItemOfFeedEditorStartup$1(contact, this, checkItemListener, traceId, richContentJson, option, null), 3, null);
        return launch$default;
    }

    @NotNull
    public Job z(@NotNull Context context, @Nullable com.tencent.mobileqq.guild.data.s contact, @NotNull FeedEditorLaunchOptionModel option, @NotNull FeedEditorLaunchSourceModel source, @Nullable JSONObject richContentJson, @NotNull com.tencent.mobileqq.guild.feed.api.c checkItemListener, @Nullable com.tencent.mobileqq.guild.feed.api.d startProcedureAware) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(checkItemListener, "checkItemListener");
        int i3 = source.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID java.lang.String();
        CoroutineDispatcher c16 = ae.a().c();
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        return y(i3, CoroutineScopeKt.CoroutineScope(c16.plus(Job$default)), contact, option, richContentJson, new FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1(checkItemListener, this, context, contact, option, source, startProcedureAware));
    }
}
