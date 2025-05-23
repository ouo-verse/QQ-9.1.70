package com.tencent.mobileqq.guild.feed.api.impl;

import android.os.Bundle;
import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.util.bg;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.api.IPublishApi;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.qphone.base.util.QLog;
import ij1.GuildMediaUploadTaskInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001.\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000245B\u0013\b\u0007\u0012\b\b\u0002\u0010(\u001a\u00020'\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J1\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0002\b\fH\u0082\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001J\u0019\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010!\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%0$2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\"H\u0016R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiWinkImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedMediaUploadServiceApi;", "", "", "fileId", "Lcom/tencent/mobileqq/guild/data/g;", "mediaInfo", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "winkPublishParams", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/winkpublish/api/IPublishApi;", "Lkotlin/ExtensionFunctionType;", "block", "withPublishApiCatchingRun", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/api/f;", "listener", "", "subscribeTaskChangeListener", "unsubscribeAllTaskChangeListener", "unsubscribeTaskChangeListener", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "createUploadMediaTask", "pauseUploadMediaTask", "resumeUploadMediaTask", "removeUploadMediaTask", "localMediaInfo", "extraInfo", "restoreUploadMediaTask", "", "fileIdSet", "", "Lcom/tencent/mobileqq/guild/data/o;", "batchGetUploadMediaTaskInfoList", "Lcom/tencent/mobileqq/guild/feed/api/impl/q;", "observable", "Lcom/tencent/mobileqq/guild/feed/api/impl/q;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiWinkImpl$b;", "taskProxyMap", "Ljava/util/concurrent/ConcurrentHashMap;", "com/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiWinkImpl$e", "winkListener", "Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiWinkImpl$e;", "<init>", "(Lcom/tencent/mobileqq/guild/feed/api/impl/q;)V", "Companion", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedMediaUploadServiceApiWinkImpl implements IGuildFeedMediaUploadServiceApi {
    public static final int BUSINESS_TYPE_GUILD = 2;

    @NotNull
    public static final String TAG = "GuildFeedMediaUploadServiceApiWinkImpl";

    @NotNull
    private final q observable;

    @NotNull
    private final ConcurrentHashMap<String, b> taskProxyMap;

    @NotNull
    private final e winkListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiWinkImpl$b;", "", "Lij1/m;", "a", "resume", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a {
            @Nullable
            public static GuildMediaUploadTaskInfo a(@NotNull b bVar) {
                return bVar.getF218057a();
            }
        }

        @Nullable
        /* renamed from: a */
        GuildMediaUploadTaskInfo getF218057a();

        @Nullable
        GuildMediaUploadTaskInfo resume();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiWinkImpl$c", "Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiWinkImpl$b;", "Lij1/m;", "a", "resume", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkPublishParams f218051b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.data.g f218052c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f218053d;

        c(WinkPublishParams winkPublishParams, com.tencent.mobileqq.guild.data.g gVar, String str) {
            this.f218051b = winkPublishParams;
            this.f218052c = gVar;
            this.f218053d = str;
        }

        @Override // com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl.b
        @Nullable
        /* renamed from: a */
        public GuildMediaUploadTaskInfo getF218057a() {
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x006e  */
        @Override // com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl.b
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public GuildMediaUploadTaskInfo resume() {
            String stackTraceToString;
            GuildMediaUploadTaskInfo guildMediaUploadTaskInfo;
            MediaParams mediaParams;
            Pair pair;
            boolean z16;
            Object firstOrNull;
            TaskInfo addTaskR;
            WinkPublishParams winkPublishParams = this.f218051b;
            Long l3 = null;
            try {
                QRouteApi api = QRoute.api(IPublishApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IPublishApi::class.java)");
                addTaskR = ((IPublishApi) api).addTaskR(winkPublishParams);
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                String str = "withPublishApiCatchingRun: " + stackTraceToString;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e(GuildFeedMediaUploadServiceApiWinkImpl.TAG, 1, (String) it.next(), null);
                }
            }
            if (addTaskR != null) {
                guildMediaUploadTaskInfo = com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.l.d(addTaskR);
                if (guildMediaUploadTaskInfo == null) {
                    WinkPublishParams winkPublishParams2 = this.f218051b;
                    com.tencent.mobileqq.guild.data.g gVar = this.f218052c;
                    List<MediaParams> mediaParamsList = winkPublishParams2.getMediaParamsList();
                    if (mediaParamsList != null) {
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mediaParamsList);
                        mediaParams = (MediaParams) firstOrNull;
                    } else {
                        mediaParams = null;
                    }
                    String str2 = "";
                    if (mediaParams instanceof ImageParams) {
                        ImageParams imageParams = (ImageParams) mediaParams;
                        pair = new Pair(Long.valueOf(imageParams.getFileSize()), bg.f223884a.a(imageParams.getLocalPath()));
                    } else if (mediaParams instanceof VideoParams) {
                        VideoParams videoParams = (VideoParams) mediaParams;
                        pair = new Pair(Long.valueOf(videoParams.getFileSize()), bg.f223884a.a(videoParams.getLocalPath()));
                    } else {
                        pair = new Pair(0L, "");
                    }
                    long longValue = ((Number) pair.component1()).longValue();
                    String str3 = (String) pair.component2();
                    guildMediaUploadTaskInfo.y(longValue);
                    if (str3 != null) {
                        str2 = str3;
                    }
                    guildMediaUploadTaskInfo.w(str2);
                    Bundle transParams = winkPublishParams2.getTransParams();
                    if (transParams != null) {
                        z16 = transParams.getBoolean("key_original_pic", true);
                    } else {
                        z16 = true;
                    }
                    guildMediaUploadTaskInfo.z(z16);
                    Bundle transParams2 = winkPublishParams2.getTransParams();
                    boolean z17 = false;
                    if (transParams2 != null) {
                        z17 = transParams2.getBoolean("key_is_gif", false);
                    }
                    guildMediaUploadTaskInfo.u(z17);
                    guildMediaUploadTaskInfo.B(longValue);
                    guildMediaUploadTaskInfo.v(gVar);
                } else {
                    guildMediaUploadTaskInfo = null;
                }
                String str4 = this.f218053d;
                Logger.a d16 = Logger.f235387a.d();
                if (guildMediaUploadTaskInfo != null) {
                    l3 = Long.valueOf(com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.l.i(guildMediaUploadTaskInfo));
                }
                d16.i(GuildFeedMediaUploadServiceApiWinkImpl.TAG, 1, "createUploadMediaTask: " + str4 + " taskId:" + l3);
                return guildMediaUploadTaskInfo;
            }
            guildMediaUploadTaskInfo = null;
            if (guildMediaUploadTaskInfo == null) {
            }
            String str42 = this.f218053d;
            Logger.a d162 = Logger.f235387a.d();
            if (guildMediaUploadTaskInfo != null) {
            }
            d162.i(GuildFeedMediaUploadServiceApiWinkImpl.TAG, 1, "createUploadMediaTask: " + str42 + " taskId:" + l3);
            return guildMediaUploadTaskInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lij1/m;", "a", "()Lij1/m;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    static final class d implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildMediaUploadTaskInfo f218054a;

        d(GuildMediaUploadTaskInfo guildMediaUploadTaskInfo) {
            this.f218054a = guildMediaUploadTaskInfo;
        }

        @Override // com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl.b
        @Nullable
        /* renamed from: a */
        public final GuildMediaUploadTaskInfo getF218057a() {
            return this.f218054a;
        }

        @Override // com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl.b
        @Nullable
        public GuildMediaUploadTaskInfo resume() {
            return b.a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiWinkImpl$e", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "winkTask", "", "onTaskChange", "", "preState", "Lij1/m;", "guildMediaUploadTaskInfo", "j", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e extends ITaskListener.Stub {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lij1/m;", "a", "()Lij1/m;"}, k = 3, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a implements b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ GuildMediaUploadTaskInfo f218056a;

            a(GuildMediaUploadTaskInfo guildMediaUploadTaskInfo) {
                this.f218056a = guildMediaUploadTaskInfo;
            }

            @Override // com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl.b
            @Nullable
            /* renamed from: a */
            public final GuildMediaUploadTaskInfo getF218057a() {
                return this.f218056a;
            }

            @Override // com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl.b
            @Nullable
            public GuildMediaUploadTaskInfo resume() {
                return b.a.a(this);
            }
        }

        e() {
        }

        public final void j(int preState, @NotNull GuildMediaUploadTaskInfo guildMediaUploadTaskInfo) {
            Intrinsics.checkNotNullParameter(guildMediaUploadTaskInfo, "guildMediaUploadTaskInfo");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(GuildFeedMediaUploadServiceApiWinkImpl.TAG, "onTaskChange: " + guildMediaUploadTaskInfo);
            }
            GuildFeedMediaUploadServiceApiWinkImpl.this.taskProxyMap.put(guildMediaUploadTaskInfo.getFileId(), new a(guildMediaUploadTaskInfo));
            GuildFeedMediaUploadServiceApiWinkImpl.this.observable.a(guildMediaUploadTaskInfo, preState);
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(@Nullable TaskInfo winkTask) {
            GuildMediaUploadTaskInfo guildMediaUploadTaskInfo;
            if (winkTask != null && winkTask.getBusinessType() == 2) {
                b bVar = (b) GuildFeedMediaUploadServiceApiWinkImpl.this.taskProxyMap.get(com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.l.f(winkTask));
                if (bVar != null) {
                    guildMediaUploadTaskInfo = bVar.getF218057a();
                } else {
                    guildMediaUploadTaskInfo = null;
                }
                if (guildMediaUploadTaskInfo == null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    String str = "onTaskChange error: " + guildMediaUploadTaskInfo + " " + winkTask;
                    if (str instanceof String) {
                        bVar2.a().add(str);
                    }
                    Iterator<T> it = bVar2.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e(GuildFeedMediaUploadServiceApiWinkImpl.TAG, 1, (String) it.next(), null);
                    }
                    return;
                }
                int state = guildMediaUploadTaskInfo.getState();
                GuildMediaUploadTaskInfo d16 = com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.l.d(winkTask);
                d16.y(guildMediaUploadTaskInfo.getOriginSize());
                d16.w(guildMediaUploadTaskInfo.getMd5());
                d16.z(guildMediaUploadTaskInfo.getIsRaw());
                d16.u(guildMediaUploadTaskInfo.getCom.tencent.mtt.hippy.dom.node.NodeProps.CUSTOM_PROP_ISGIF java.lang.String());
                d16.B(guildMediaUploadTaskInfo.getOriginSize());
                d16.C((winkTask.getUploadProgress() * guildMediaUploadTaskInfo.getOriginSize()) / 100);
                d16.v(guildMediaUploadTaskInfo.getLocalMediaInfo());
                j(state, d16);
            }
        }
    }

    @JvmOverloads
    public GuildFeedMediaUploadServiceApiWinkImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final WinkPublishParams winkPublishParams(String fileId, com.tencent.mobileqq.guild.data.g mediaInfo) {
        List list;
        com.tencent.mobileqq.guild.util.i iVar = com.tencent.mobileqq.guild.util.i.f235563a;
        if (iVar.e(mediaInfo)) {
            list = com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.l.g(mediaInfo, mediaInfo.getIsRaw());
        } else if (iVar.f(mediaInfo)) {
            list = com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.l.j(mediaInfo);
        } else {
            list = null;
        }
        List list2 = list;
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_original_pic", mediaInfo.getIsRaw());
        bundle.putBoolean("key_is_gif", Intrinsics.areEqual("image/gif", mediaInfo.getMimeType()));
        bundle.putString("key_js_task_id", fileId);
        bundle.putBoolean("key_is_undo", false);
        Unit unit = Unit.INSTANCE;
        return new WinkPublishParams(2, fileId, fileId, true, 23, list2, null, null, bundle, null, 704, null);
    }

    private final <R> R withPublishApiCatchingRun(Function1<? super IPublishApi, ? extends R> block) {
        String stackTraceToString;
        try {
            QRouteApi api = QRoute.api(IPublishApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IPublishApi::class.java)");
            return block.invoke(api);
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            String str = "withPublishApiCatchingRun: " + stackTraceToString;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    @NotNull
    public Map<String, com.tencent.mobileqq.guild.data.o> batchGetUploadMediaTaskInfoList(@NotNull Set<String> fileIdSet) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(fileIdSet, "fileIdSet");
        ConcurrentHashMap<String, b> concurrentHashMap = this.taskProxyMap;
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, b>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            GuildMediaUploadTaskInfo f218057a = it.next().getValue().getF218057a();
            if (f218057a != null) {
                arrayList.add(f218057a);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : arrayList) {
            linkedHashMap.put(((GuildMediaUploadTaskInfo) obj).getFileId(), obj);
        }
        return linkedHashMap;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean createUploadMediaTask(@NotNull String fileId, @NotNull com.tencent.mobileqq.guild.data.g mediaInfo) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (this.taskProxyMap.containsKey(fileId)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("createUploadMediaTask error: fileId already exists");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
            return true;
        }
        QLog.i(TAG, 1, "createUploadMediaTask, " + fileId + ", localMedia = " + mediaInfo);
        this.taskProxyMap.put(fileId, new c(winkPublishParams(fileId, mediaInfo), mediaInfo, fileId));
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        String stackTraceToString;
        try {
            QRouteApi api = QRoute.api(IPublishApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IPublishApi::class.java)");
            ((IPublishApi) api).addTaskListenerStrong(2, this.winkListener);
            Unit unit = Unit.INSTANCE;
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            String str = "withPublishApiCatchingRun: " + stackTraceToString;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        String stackTraceToString;
        try {
            QRouteApi api = QRoute.api(IPublishApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IPublishApi::class.java)");
            ((IPublishApi) api).removeTaskListener(2, this.winkListener);
            Unit unit = Unit.INSTANCE;
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            String str = "withPublishApiCatchingRun: " + stackTraceToString;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean pauseUploadMediaTask(@NotNull String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean removeUploadMediaTask(@NotNull String fileId) {
        GuildMediaUploadTaskInfo guildMediaUploadTaskInfo;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        try {
            b bVar = this.taskProxyMap.get(fileId);
            if (bVar != null) {
                guildMediaUploadTaskInfo = bVar.getF218057a();
            } else {
                guildMediaUploadTaskInfo = null;
            }
            if (guildMediaUploadTaskInfo == null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("removeUploadMediaTask error: taskInfo is null");
                Iterator<T> it = bVar2.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
                }
                this.taskProxyMap.remove(fileId);
                return false;
            }
            try {
                QRouteApi api = QRoute.api(IPublishApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IPublishApi::class.java)");
                ((IPublishApi) api).cancelTaskWithId(2, com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.l.i(guildMediaUploadTaskInfo));
                Unit unit = Unit.INSTANCE;
            } catch (Exception e16) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar3 = new Logger.b();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                String str = "withPublishApiCatchingRun: " + stackTraceToString;
                if (str instanceof String) {
                    bVar3.a().add(str);
                }
                Iterator<T> it5 = bVar3.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e(TAG, 1, (String) it5.next(), null);
                }
            }
            Logger logger3 = Logger.f235387a;
            Logger.b bVar4 = new Logger.b();
            String str2 = "removeUploadMediaTask: " + fileId;
            if (str2 instanceof String) {
                bVar4.a().add(str2);
            }
            Iterator<T> it6 = bVar4.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it6.next(), null);
            }
            return true;
        } finally {
            this.taskProxyMap.remove(fileId);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public synchronized boolean restoreUploadMediaTask(@NotNull String fileId, @NotNull com.tencent.mobileqq.guild.data.g localMediaInfo, @Nullable Object extraInfo) {
        final GuildMediaProgressState guildMediaProgressState;
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        QLog.i(TAG, 1, "restoreUploadMediaTask, " + fileId + ", localMedia = " + localMediaInfo);
        if (this.taskProxyMap.containsKey(fileId)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("restoreUploadMediaTask error: fileId already exists");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
            return true;
        }
        if (extraInfo instanceof GuildMediaProgressState) {
            guildMediaProgressState = (GuildMediaProgressState) extraInfo;
        } else {
            guildMediaProgressState = null;
        }
        if (guildMediaProgressState == null) {
            return false;
        }
        if (guildMediaProgressState.getUploadTaskId() == 0) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("restoreUploadMediaTask error: uploadTaskId is 0");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it5.next(), null);
            }
            createUploadMediaTask(fileId, localMediaInfo);
            return true;
        }
        final GuildMediaUploadTaskInfo a16 = com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.k.f223157a.a(guildMediaProgressState);
        a16.v(localMediaInfo);
        Logger.f235387a.d().i(TAG, 1, "restoreUploadMediaTask uploadTask: " + com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.l.i(a16));
        this.taskProxyMap.put(fileId, new b() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl$restoreUploadMediaTask$4
            @Override // com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl.b
            @NotNull
            /* renamed from: a, reason: from getter */
            public GuildMediaUploadTaskInfo getF218057a() {
                return GuildMediaUploadTaskInfo.this;
            }

            @Override // com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl.b
            @Nullable
            public GuildMediaUploadTaskInfo resume() {
                String stackTraceToString;
                GuildFeedMediaUploadServiceApiWinkImpl.e eVar;
                GuildFeedMediaUploadServiceApiWinkImpl guildFeedMediaUploadServiceApiWinkImpl = this;
                GuildMediaProgressState guildMediaProgressState2 = guildMediaProgressState;
                final GuildMediaUploadTaskInfo guildMediaUploadTaskInfo = GuildMediaUploadTaskInfo.this;
                try {
                    QRouteApi api = QRoute.api(IPublishApi.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(IPublishApi::class.java)");
                    Logger.f235387a.d().i(GuildFeedMediaUploadServiceApiWinkImpl.TAG, 1, "resumeTaskWithId uploadTask: " + com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.l.i(guildMediaUploadTaskInfo));
                    eVar = guildFeedMediaUploadServiceApiWinkImpl.winkListener;
                    final WeakReference weakReference = new WeakReference(eVar);
                    ((IPublishApi) api).resumeTaskWithId(2, guildMediaProgressState2.getUploadTaskId(), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiWinkImpl$restoreUploadMediaTask$4$resume$1$2
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
                            GuildMediaUploadTaskInfo k3;
                            Logger logger3 = Logger.f235387a;
                            GuildMediaUploadTaskInfo guildMediaUploadTaskInfo2 = guildMediaUploadTaskInfo;
                            Logger.b bVar3 = new Logger.b();
                            String str = "resumeTaskWithId resumeFailed: " + com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.l.i(guildMediaUploadTaskInfo2);
                            if (str instanceof String) {
                                bVar3.a().add(str);
                            }
                            Iterator<T> it6 = bVar3.a().iterator();
                            while (it6.hasNext()) {
                                Logger.f235387a.d().e(GuildFeedMediaUploadServiceApiWinkImpl.TAG, 1, (String) it6.next(), null);
                            }
                            GuildFeedMediaUploadServiceApiWinkImpl.e eVar2 = weakReference.get();
                            if (eVar2 != null) {
                                int state = guildMediaUploadTaskInfo.getState();
                                k3 = r3.k((r52 & 1) != 0 ? r3.getFileId() : null, (r52 & 2) != 0 ? r3.getState() : 0, (r52 & 4) != 0 ? r3.type : 0, (r52 & 8) != 0 ? r3.clientKey : null, (r52 & 16) != 0 ? r3.traceId : null, (r52 & 32) != 0 ? r3.uploadProgress : 0, (r52 & 64) != 0 ? r3.getCoverUrl() : null, (r52 & 128) != 0 ? r3.businessType : 0, (r52 & 256) != 0 ? r3.feedId : null, (r52 & 512) != 0 ? r3.feedTime : 0L, (r52 & 1024) != 0 ? r3.mediaInfo : null, (r52 & 2048) != 0 ? r3.getErrCode() : 0, (r52 & 4096) != 0 ? r3.getErrMsg() : null, (r52 & 8192) != 0 ? r3.transParams : null, (r52 & 16384) != 0 ? r3.getTotalFileSize() : 0L, (r52 & 32768) != 0 ? r3.getTotalUploadFileSize() : 0L, (r52 & 65536) != 0 ? r3.internalId : 0L, (r52 & 131072) != 0 ? r3.getOriginSize() : 0L, (r52 & 262144) != 0 ? r3.getMd5() : null, (r52 & 524288) != 0 ? r3.getIsRaw() : false, (r52 & 1048576) != 0 ? r3.getCom.tencent.mtt.hippy.dom.node.NodeProps.CUSTOM_PROP_ISGIF java.lang.String() : false, (r52 & 2097152) != 0 ? guildMediaUploadTaskInfo.getLocalMediaInfo() : null);
                                k3.A(3);
                                k3.t("resume fail from winkApi");
                                k3.s(-1001);
                                Unit unit = Unit.INSTANCE;
                                eVar2.j(state, k3);
                            }
                        }
                    });
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e16) {
                    Logger logger3 = Logger.f235387a;
                    Logger.b bVar3 = new Logger.b();
                    stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                    String str = "withPublishApiCatchingRun: " + stackTraceToString;
                    if (str instanceof String) {
                        bVar3.a().add(str);
                    }
                    Iterator<T> it6 = bVar3.a().iterator();
                    while (it6.hasNext()) {
                        Logger.f235387a.d().e(GuildFeedMediaUploadServiceApiWinkImpl.TAG, 1, (String) it6.next(), null);
                    }
                }
                return GuildMediaUploadTaskInfo.this;
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean resumeUploadMediaTask(@NotNull String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        b bVar = this.taskProxyMap.get(fileId);
        if (bVar == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("resumeUploadMediaTask error: winkPublishParams is null");
            Iterator<T> it = bVar2.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
            return false;
        }
        GuildMediaUploadTaskInfo resume = bVar.resume();
        if (resume == null) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("resumeUploadMediaTask error: taskInfo is null");
            Iterator<T> it5 = bVar3.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it5.next(), null);
            }
            return false;
        }
        this.taskProxyMap.put(fileId, new d(resume));
        this.observable.a(resume, resume.getState());
        Logger logger3 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d(TAG, "resumeUploadMediaTask: " + resume);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public void subscribeTaskChangeListener(@NotNull com.tencent.mobileqq.guild.feed.api.f listener, @NotNull String fileId) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        this.observable.b(listener, fileId);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public void unsubscribeAllTaskChangeListener(@NotNull com.tencent.mobileqq.guild.feed.api.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.observable.c(listener);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public void unsubscribeTaskChangeListener(@NotNull com.tencent.mobileqq.guild.feed.api.f listener, @NotNull String fileId) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        this.observable.d(listener, fileId);
    }

    @JvmOverloads
    public GuildFeedMediaUploadServiceApiWinkImpl(@NotNull q observable) {
        Intrinsics.checkNotNullParameter(observable, "observable");
        this.observable = observable;
        this.taskProxyMap = new ConcurrentHashMap<>();
        this.winkListener = new e();
    }

    public /* synthetic */ GuildFeedMediaUploadServiceApiWinkImpl(q qVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new q() : qVar);
    }
}
