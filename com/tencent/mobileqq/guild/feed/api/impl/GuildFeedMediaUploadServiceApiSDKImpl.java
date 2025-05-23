package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiSDKImpl;
import com.tencent.mobileqq.guild.feed.util.az;
import com.tencent.mobileqq.guild.feed.util.bg;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateUploadFileGroupParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadFileGroupInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadFileInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadFileType;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadStatus;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateUploadFileGroupCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransferFileOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener;
import ij1.GuildImageResult;
import ij1.GuildMediaInfo;
import ij1.GuildMediaUploadTaskInfo;
import ij1.GuildVideoResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002>?B\u0013\b\u0007\u0012\b\b\u0002\u0010/\u001a\u00020.\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001J\u0019\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010(\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020,0+2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030)H\u0016R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000209068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00108\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiSDKImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedMediaUploadServiceApi;", "", "", "fileId", "Lcom/tencent/mobileqq/guild/data/g;", "mediaInfo", "", "createUploadFileGroupTask", "generateFileGroupId", "groupId", "getOriginFileIdFromGroupId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileInfo;", "fileInfo", "Lij1/m;", "getTaskInfoFromGProUploadFileInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileGroupInfo;", "fileGroupInfo", "getTaskInfoFromGProUploadFileGroupInfo", "fileGroupId", "taskInfo", "", "preState", "notifyTaskInfoChange", "Lcom/tencent/mobileqq/guild/feed/api/f;", "listener", "subscribeTaskChangeListener", "unsubscribeAllTaskChangeListener", "unsubscribeTaskChangeListener", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "createUploadMediaTask", "pauseUploadMediaTask", "resumeUploadMediaTask", "removeUploadMediaTask", "localMediaInfo", "extraInfo", "restoreUploadMediaTask", "", "fileIdSet", "", "Lcom/tencent/mobileqq/guild/data/o;", "batchGetUploadMediaTaskInfoList", "Lcom/tencent/mobileqq/guild/feed/api/impl/q;", "observable", "Lcom/tencent/mobileqq/guild/feed/api/impl/q;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileUploadListener;", "ntListener", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileUploadListener;", "runtime", "Lmqq/app/AppRuntime;", "", "fileIdToFileGroupIdMap", "Ljava/util/Map;", "Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiSDKImpl$b;", "uploadTaskMap", "<init>", "(Lcom/tencent/mobileqq/guild/feed/api/impl/q;)V", "Companion", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedMediaUploadServiceApiSDKImpl implements IGuildFeedMediaUploadServiceApi {
    private static final long FINISHED_PROGRESS = 100;

    @NotNull
    public static final String TAG = "GuildFeedMediaUploadServiceApiSDKImpl";

    @NotNull
    private final Map<String, String> fileIdToFileGroupIdMap;

    @NotNull
    private final IKernelGuildFileUploadListener ntListener;

    @NotNull
    private final q observable;

    @Nullable
    private volatile AppRuntime runtime;

    @NotNull
    private final Map<String, b> uploadTaskMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b4\u00105J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0006H\u0002J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0002J \u0010\u0019\u001a\u00020\u00122\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00120\u0015J\u001a\u0010\u001b\u001a\u00020\u00122\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00120\u0015J\u001a\u0010\u001c\u001a\u00020\u00122\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00120\u0015R\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\"\u00103\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiSDKImpl$b;", "", "", "fileId", "", "type", "Lcom/tencent/mobileqq/guild/data/g;", "localMediaInfo", "Lij1/m;", "g", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateUploadFileGroupParam;", "f", "fileGroupId", "mediaInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "originalPic", "", ReportConstant.COSTREPORT_PREFIX, "i", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/api/impl/ab;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileGroupInfo;", "callback", "d", "Lcom/tencent/mobileqq/guild/feed/api/impl/aa;", DomainData.DOMAIN_NAME, "p", "a", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "groupId", "b", tl.h.F, "c", "I", "l", "()I", "Lcom/tencent/mobileqq/guild/data/g;", "getLocalMediaInfo", "()Lcom/tencent/mobileqq/guild/data/g;", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateUploadFileGroupParam;", "uploadParam", "Lij1/m;", "k", "()Lij1/m;", "r", "(Lij1/m;)V", "taskResult", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/guild/data/g;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String groupId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String fileId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.data.g localMediaInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private GProCreateUploadFileGroupParam uploadParam;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private GuildMediaUploadTaskInfo taskResult;

        public b(@NotNull String groupId, @NotNull String fileId, int i3, @NotNull com.tencent.mobileqq.guild.data.g localMediaInfo) {
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
            this.groupId = groupId;
            this.fileId = fileId;
            this.type = i3;
            this.localMediaInfo = localMediaInfo;
            this.uploadParam = f();
            this.taskResult = g(fileId, i3, localMediaInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(b this$0, Function1 callback, int i3, String str, GProUploadFileGroupInfo gProUploadFileGroupInfo) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "createFileGroupUpload, result = " + i3 + ", errMsg = " + str + ", info = " + gProUploadFileGroupInfo);
            GProCreateUploadFileGroupParam gProCreateUploadFileGroupParam = this$0.uploadParam;
            if (gProCreateUploadFileGroupParam != null) {
                gProCreateUploadFileGroupParam.fileGroupInfo = gProUploadFileGroupInfo;
            }
            callback.invoke(new ab(i3, str, gProUploadFileGroupInfo));
        }

        private final GProCreateUploadFileGroupParam f() {
            QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "createGProCreateUploadFileGroupParam, " + this.groupId + "-" + this.fileId + "-" + this.type + ", localMedia = " + this.localMediaInfo);
            ArrayList<GProUploadFileInfo> arrayList = new ArrayList<>();
            int i3 = this.type;
            if (i3 == 1) {
                s(this.localMediaInfo.getIsRaw(), this.localMediaInfo);
            } else if (i3 == 2) {
                GProUploadFileInfo m3 = m(this.groupId, this.localMediaInfo);
                if (m3 == null) {
                    QLog.e(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, this.groupId + "-" + this.fileId + " get video cover failed");
                    return null;
                }
                arrayList.add(m3);
            }
            arrayList.add(i(this.groupId, this.fileId, this.localMediaInfo));
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<GProUploadFileInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().fileId);
            }
            GProCreateUploadFileGroupParam gProCreateUploadFileGroupParam = new GProCreateUploadFileGroupParam();
            GProUploadFileGroupInfo gProUploadFileGroupInfo = new GProUploadFileGroupInfo();
            gProUploadFileGroupInfo.fileGroupId = this.groupId;
            gProUploadFileGroupInfo.childFileIds = arrayList2;
            gProCreateUploadFileGroupParam.fileGroupInfo = gProUploadFileGroupInfo;
            gProCreateUploadFileGroupParam.fileParams = arrayList;
            return gProCreateUploadFileGroupParam;
        }

        private final GuildMediaUploadTaskInfo g(String fileId, int type, com.tencent.mobileqq.guild.data.g localMediaInfo) {
            long j3;
            String str;
            String a16;
            long j16 = 0;
            if (localMediaInfo.getFileSize() != 0) {
                j3 = localMediaInfo.getFileSize();
            } else {
                try {
                    j16 = new File(localMediaInfo.getPath()).length();
                } catch (Exception unused) {
                }
                j3 = j16;
            }
            com.tencent.mobileqq.guild.util.i iVar = com.tencent.mobileqq.guild.util.i.f235563a;
            if (!iVar.e(localMediaInfo) || (a16 = bg.f223884a.a(localMediaInfo.getPath())) == null) {
                str = "";
            } else {
                str = a16;
            }
            return new GuildMediaUploadTaskInfo(fileId, -1000, type, "", "", 0, "", 0, "", 0L, null, 0, null, null, 0L, 0L, 0L, j3, str, localMediaInfo.getIsRaw(), iVar.d(localMediaInfo), localMediaInfo, 129024, null);
        }

        private final GProUploadFileInfo i(String fileGroupId, String fileId, com.tencent.mobileqq.guild.data.g mediaInfo) {
            GProUploadFileType gProUploadFileType;
            String path;
            int i3 = this.type;
            boolean z16 = true;
            if (i3 == 1) {
                gProUploadFileType = GProUploadFileType.KPICTURE;
            } else if (i3 == 2) {
                gProUploadFileType = GProUploadFileType.KVIDEO;
            } else {
                gProUploadFileType = GProUploadFileType.KUNKNOWN;
            }
            if (mediaInfo.getIsRaw()) {
                path = mediaInfo.getPath();
            } else {
                if (mediaInfo.getThumbnailPath().length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    path = mediaInfo.getThumbnailPath();
                } else {
                    path = mediaInfo.getPath();
                }
            }
            GProUploadFileInfo gProUploadFileInfo = new GProUploadFileInfo();
            gProUploadFileInfo.fileGroupId = fileGroupId;
            gProUploadFileInfo.fileId = fileId;
            gProUploadFileInfo.fileType = gProUploadFileType;
            gProUploadFileInfo.isOriginal = mediaInfo.getIsRaw();
            gProUploadFileInfo.filePath = path;
            return gProUploadFileInfo;
        }

        private final GProUploadFileInfo m(String fileGroupId, com.tencent.mobileqq.guild.data.g mediaInfo) {
            boolean z16;
            String e16 = az.f223861a.e(GuildFeedMediaUploadServiceApiSDKImpl.TAG, mediaInfo);
            if (e16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.e(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "[getVideoList]: fileGroupId=" + fileGroupId + ", videoCover still empty");
                return null;
            }
            GProUploadFileInfo gProUploadFileInfo = new GProUploadFileInfo();
            gProUploadFileInfo.fileGroupId = fileGroupId;
            gProUploadFileInfo.fileId = UUID.randomUUID().toString();
            gProUploadFileInfo.fileType = GProUploadFileType.KPICTURE;
            gProUploadFileInfo.isOriginal = true;
            gProUploadFileInfo.filePath = e16;
            return gProUploadFileInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(Function1 callback, int i3, String str) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "pauseFileGroupUpload, result = " + i3 + ", errMsg = " + str);
            callback.invoke(new aa(i3, str));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(Function1 callback, int i3, String str) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "resumeFileGroupUpload, result = " + i3 + ", errMsg = " + str);
            callback.invoke(new aa(i3, str));
        }

        private final void s(boolean originalPic, com.tencent.mobileqq.guild.data.g mediaInfo) {
            if (originalPic) {
                return;
            }
            az.f223861a.a(mediaInfo);
        }

        public final void d(@NotNull final Function1<? super ab<GProUploadFileGroupInfo>, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "task doCreate, " + this.groupId + "-" + this.fileId + "-" + this.type);
            if (this.uploadParam == null) {
                callback.invoke(new ab(-1, "", null));
                return;
            }
            uh2.h d16 = com.tencent.mobileqq.guild.feed.util.l.d();
            if (d16 != null) {
                GProCreateUploadFileGroupParam gProCreateUploadFileGroupParam = this.uploadParam;
                Intrinsics.checkNotNull(gProCreateUploadFileGroupParam);
                d16.createFileGroupUpload(gProCreateUploadFileGroupParam, new IGProCreateUploadFileGroupCallback() { // from class: com.tencent.mobileqq.guild.feed.api.impl.t
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateUploadFileGroupCallback
                    public final void onCreateUploadFileGroupResult(int i3, String str, GProUploadFileGroupInfo gProUploadFileGroupInfo) {
                        GuildFeedMediaUploadServiceApiSDKImpl.b.e(GuildFeedMediaUploadServiceApiSDKImpl.b.this, callback, i3, str, gProUploadFileGroupInfo);
                    }
                });
            }
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        @NotNull
        /* renamed from: j, reason: from getter */
        public final String getGroupId() {
            return this.groupId;
        }

        @NotNull
        /* renamed from: k, reason: from getter */
        public final GuildMediaUploadTaskInfo getTaskResult() {
            return this.taskResult;
        }

        /* renamed from: l, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final void n(@NotNull final Function1<? super aa, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "task doPause, " + this.groupId + "-" + this.fileId + "-" + this.type);
            uh2.h d16 = com.tencent.mobileqq.guild.feed.util.l.d();
            if (d16 != null) {
                d16.pauseFileGroupUpload(this.groupId, new IGProTransferFileOperateCallback() { // from class: com.tencent.mobileqq.guild.feed.api.impl.u
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransferFileOperateCallback
                    public final void onResult(int i3, String str) {
                        GuildFeedMediaUploadServiceApiSDKImpl.b.o(Function1.this, i3, str);
                    }
                });
            }
        }

        public final void p(@NotNull final Function1<? super aa, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "task doResume, " + this.groupId + "-" + this.fileId + "-" + this.type);
            uh2.h d16 = com.tencent.mobileqq.guild.feed.util.l.d();
            if (d16 != null) {
                d16.resumeFileGroupUpload(this.groupId, new IGProTransferFileOperateCallback() { // from class: com.tencent.mobileqq.guild.feed.api.impl.s
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransferFileOperateCallback
                    public final void onResult(int i3, String str) {
                        GuildFeedMediaUploadServiceApiSDKImpl.b.q(Function1.this, i3, str);
                    }
                });
            }
        }

        public final void r(@NotNull GuildMediaUploadTaskInfo guildMediaUploadTaskInfo) {
            Intrinsics.checkNotNullParameter(guildMediaUploadTaskInfo, "<set-?>");
            this.taskResult = guildMediaUploadTaskInfo;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f218042a;

        static {
            int[] iArr = new int[GProUploadFileType.values().length];
            try {
                iArr[GProUploadFileType.KVIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GProUploadFileType.KPICTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f218042a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001J\u0017\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096\u0002\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiSDKImpl$d", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/api/impl/ab;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileGroupInfo;", "", "callback", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements Function1<ab<GProUploadFileGroupInfo>, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f218043d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildFeedMediaUploadServiceApiSDKImpl f218044e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f218045f;

        d(b bVar, GuildFeedMediaUploadServiceApiSDKImpl guildFeedMediaUploadServiceApiSDKImpl, String str) {
            this.f218043d = bVar;
            this.f218044e = guildFeedMediaUploadServiceApiSDKImpl;
            this.f218045f = str;
        }

        public void a(@NotNull ab<GProUploadFileGroupInfo> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            int state = this.f218043d.getTaskResult().getState();
            if (callback.getResult() != 0) {
                GuildMediaUploadTaskInfo taskResult = this.f218043d.getTaskResult();
                taskResult.A(3);
                taskResult.s(callback.getResult());
                String errMsg = callback.getErrMsg();
                if (errMsg == null) {
                    errMsg = "create task failed";
                }
                taskResult.t(errMsg);
                this.f218044e.notifyTaskInfoChange(this.f218045f, this.f218043d.getTaskResult(), state);
                return;
            }
            if (callback.b() != null) {
                GuildFeedMediaUploadServiceApiSDKImpl guildFeedMediaUploadServiceApiSDKImpl = this.f218044e;
                GProUploadFileGroupInfo b16 = callback.b();
                Intrinsics.checkNotNull(b16);
                GuildMediaUploadTaskInfo taskInfoFromGProUploadFileGroupInfo = guildFeedMediaUploadServiceApiSDKImpl.getTaskInfoFromGProUploadFileGroupInfo(b16);
                if (taskInfoFromGProUploadFileGroupInfo != null) {
                    this.f218044e.notifyTaskInfoChange(this.f218045f, taskInfoFromGProUploadFileGroupInfo, state);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ab<GProUploadFileGroupInfo> abVar) {
            a(abVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J0\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\t2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiSDKImpl$e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileUploadListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileInfo;", "fileInfo", "", "onFileCalcHashSuccess", "onFileUploadStatusChanged", "", "fileGroupId", "", "totalFileSize", "totalUploadSize", "onFileGroupUploadSizeChanged", "totalSpeed", "Ljava/util/HashMap;", "eachSpeed", "onFileGroupUploadSpeedChanged", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileGroupInfo;", "fileGroupInfo", "onFileGroupUploadStatusChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements IKernelGuildFileUploadListener {
        e() {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener
        public void onFileCalcHashSuccess(@Nullable GProUploadFileInfo fileInfo) {
            if (QLog.isDevelopLevel()) {
                QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "onFileCalcHashSuccess fileInfo = " + az.f223861a.d(fileInfo));
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener
        public void onFileGroupUploadSizeChanged(@Nullable String fileGroupId, long totalFileSize, long totalUploadSize) {
            GuildMediaUploadTaskInfo guildMediaUploadTaskInfo;
            long coerceAtLeast;
            long coerceAtMost;
            if (QLog.isDevelopLevel()) {
                QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 4, "onFileGroupUploadSizeChanged, groupId = " + fileGroupId + ", totalSize = " + totalFileSize + ", uploadSize = " + totalUploadSize);
            }
            if (fileGroupId == null) {
                return;
            }
            b bVar = (b) GuildFeedMediaUploadServiceApiSDKImpl.this.uploadTaskMap.get(fileGroupId);
            if (bVar != null) {
                guildMediaUploadTaskInfo = bVar.getTaskResult();
            } else {
                guildMediaUploadTaskInfo = null;
            }
            if (guildMediaUploadTaskInfo == null) {
                QLog.e(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "onFileGroupUploadSizeChanged, groupdId = " + fileGroupId + ", taskInfo is null");
                return;
            }
            int state = guildMediaUploadTaskInfo.getState();
            guildMediaUploadTaskInfo.B(totalFileSize);
            guildMediaUploadTaskInfo.C(totalUploadSize);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(totalFileSize, 1L);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((totalUploadSize * 100) / coerceAtLeast, 100L);
            guildMediaUploadTaskInfo.D((int) coerceAtMost);
            GuildFeedMediaUploadServiceApiSDKImpl.this.notifyTaskInfoChange(fileGroupId, guildMediaUploadTaskInfo, state);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener
        public void onFileGroupUploadSpeedChanged(@Nullable String fileGroupId, long totalSpeed, @Nullable HashMap<String, Long> eachSpeed) {
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                if (eachSpeed != null) {
                    for (Map.Entry<String, Long> entry : eachSpeed.entrySet()) {
                        String key = entry.getKey();
                        sb5.append(((Object) key) + MsgSummary.STR_COLON + entry.getValue() + ", ");
                    }
                }
                QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 4, "onFileGroupUploadSpeedChanged, groupId = " + fileGroupId + ", totalSpeed = " + totalSpeed + ", eachSpeed = [" + ((Object) sb5) + "]");
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener
        public void onFileGroupUploadStatusChanged(@Nullable GProUploadFileGroupInfo fileGroupInfo) {
            int i3;
            GuildMediaUploadTaskInfo taskResult;
            QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "onFileGroupUploadStatusChanged, fileGroupInfo = " + az.f223861a.c(fileGroupInfo));
            if (fileGroupInfo == null) {
                return;
            }
            b bVar = (b) GuildFeedMediaUploadServiceApiSDKImpl.this.uploadTaskMap.get(fileGroupInfo.fileGroupId);
            if (bVar != null && (taskResult = bVar.getTaskResult()) != null) {
                i3 = taskResult.getState();
            } else {
                i3 = -1000;
            }
            GuildMediaUploadTaskInfo taskInfoFromGProUploadFileGroupInfo = GuildFeedMediaUploadServiceApiSDKImpl.this.getTaskInfoFromGProUploadFileGroupInfo(fileGroupInfo);
            if (taskInfoFromGProUploadFileGroupInfo == null) {
                return;
            }
            GuildFeedMediaUploadServiceApiSDKImpl guildFeedMediaUploadServiceApiSDKImpl = GuildFeedMediaUploadServiceApiSDKImpl.this;
            String str = fileGroupInfo.fileGroupId;
            Intrinsics.checkNotNullExpressionValue(str, "fileGroupInfo.fileGroupId");
            guildFeedMediaUploadServiceApiSDKImpl.notifyTaskInfoChange(str, taskInfoFromGProUploadFileGroupInfo, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener
        public void onFileUploadStatusChanged(@Nullable GProUploadFileInfo fileInfo) {
            int i3;
            GuildMediaUploadTaskInfo taskResult;
            QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "onFileUploadStatusChanged, " + az.f223861a.d(fileInfo));
            if (fileInfo == null) {
                return;
            }
            b bVar = (b) GuildFeedMediaUploadServiceApiSDKImpl.this.uploadTaskMap.get(fileInfo.fileGroupId);
            if (bVar != null && (taskResult = bVar.getTaskResult()) != null) {
                i3 = taskResult.getState();
            } else {
                i3 = -1000;
            }
            GuildMediaUploadTaskInfo taskInfoFromGProUploadFileInfo = GuildFeedMediaUploadServiceApiSDKImpl.this.getTaskInfoFromGProUploadFileInfo(fileInfo);
            if (taskInfoFromGProUploadFileInfo == null) {
                return;
            }
            GuildFeedMediaUploadServiceApiSDKImpl guildFeedMediaUploadServiceApiSDKImpl = GuildFeedMediaUploadServiceApiSDKImpl.this;
            String str = fileInfo.fileGroupId;
            Intrinsics.checkNotNullExpressionValue(str, "fileInfo.fileGroupId");
            guildFeedMediaUploadServiceApiSDKImpl.notifyTaskInfoChange(str, taskInfoFromGProUploadFileInfo, i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiSDKImpl$f", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/api/impl/aa;", "", "callback", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements Function1<aa, Unit> {
        f() {
        }

        public void a(@NotNull aa callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(aa aaVar) {
            a(aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiSDKImpl$g", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/api/impl/aa;", "", "callback", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g implements Function1<aa, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f218047d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildFeedMediaUploadServiceApiSDKImpl f218048e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f218049f;

        g(b bVar, GuildFeedMediaUploadServiceApiSDKImpl guildFeedMediaUploadServiceApiSDKImpl, String str) {
            this.f218047d = bVar;
            this.f218048e = guildFeedMediaUploadServiceApiSDKImpl;
            this.f218049f = str;
        }

        public void a(@NotNull aa callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (callback.getResult() != 0) {
                QLog.i(GuildFeedMediaUploadServiceApiSDKImpl.TAG, 1, "resume failed, " + this.f218047d.getGroupId() + "- " + this.f218047d.getFileId() + ", state = " + this.f218047d.getTaskResult().getState());
                this.f218048e.notifyTaskInfoChange(this.f218049f, this.f218047d.getTaskResult(), this.f218047d.getTaskResult().getState());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(aa aaVar) {
            a(aaVar);
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public GuildFeedMediaUploadServiceApiSDKImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void createUploadFileGroupTask(String fileId, com.tencent.mobileqq.guild.data.g mediaInfo) {
        int i3;
        String generateFileGroupId = generateFileGroupId();
        com.tencent.mobileqq.guild.util.i iVar = com.tencent.mobileqq.guild.util.i.f235563a;
        if (iVar.e(mediaInfo)) {
            i3 = 1;
        } else if (iVar.f(mediaInfo)) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        this.fileIdToFileGroupIdMap.put(fileId, generateFileGroupId);
        this.uploadTaskMap.put(generateFileGroupId, new b(generateFileGroupId, fileId, i3, mediaInfo));
    }

    private final String generateFileGroupId() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    private final String getOriginFileIdFromGroupId(String groupId) {
        b bVar = this.uploadTaskMap.get(groupId);
        if (bVar != null) {
            return bVar.getFileId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildMediaUploadTaskInfo getTaskInfoFromGProUploadFileGroupInfo(GProUploadFileGroupInfo fileGroupInfo) {
        GuildMediaUploadTaskInfo guildMediaUploadTaskInfo;
        long coerceAtLeast;
        long coerceAtMost;
        int i3;
        String str = fileGroupInfo.fileGroupId;
        Intrinsics.checkNotNullExpressionValue(str, "fileGroupInfo.fileGroupId");
        String originFileIdFromGroupId = getOriginFileIdFromGroupId(str);
        if (originFileIdFromGroupId == null) {
            QLog.i(TAG, 1, "getTaskInfoFromGProUploadFileGroupInfo failed, groupdId =  " + fileGroupInfo.fileGroupId);
            return null;
        }
        b bVar = this.uploadTaskMap.get(fileGroupInfo.fileGroupId);
        if (bVar != null) {
            guildMediaUploadTaskInfo = bVar.getTaskResult();
        } else {
            guildMediaUploadTaskInfo = null;
        }
        if (guildMediaUploadTaskInfo == null) {
            QLog.e(TAG, 1, "getTaskInfoFromGProUploadFileGroupInfo, " + fileGroupInfo.fileGroupId + "-" + originFileIdFromGroupId + " taskInfo is null");
            return null;
        }
        az azVar = az.f223861a;
        GProUploadStatus gProUploadStatus = fileGroupInfo.uploadStatus;
        Intrinsics.checkNotNullExpressionValue(gProUploadStatus, "fileGroupInfo.uploadStatus");
        guildMediaUploadTaskInfo.A(azVar.b(gProUploadStatus));
        guildMediaUploadTaskInfo.B(fileGroupInfo.totalFileSize);
        guildMediaUploadTaskInfo.C(fileGroupInfo.totalUploadFileSize);
        if (fileGroupInfo.uploadStatus == GProUploadStatus.KUPLOADSUCCESS) {
            i3 = 100;
        } else {
            long totalUploadFileSize = guildMediaUploadTaskInfo.getTotalUploadFileSize() * 100;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(guildMediaUploadTaskInfo.getTotalFileSize(), 1L);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(totalUploadFileSize / coerceAtLeast, 100L);
            i3 = (int) coerceAtMost;
        }
        guildMediaUploadTaskInfo.D(i3);
        guildMediaUploadTaskInfo.s(fileGroupInfo.errorCode);
        String str2 = fileGroupInfo.errorMsg;
        Intrinsics.checkNotNullExpressionValue(str2, "fileGroupInfo.errorMsg");
        guildMediaUploadTaskInfo.t(str2);
        return guildMediaUploadTaskInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildMediaUploadTaskInfo getTaskInfoFromGProUploadFileInfo(GProUploadFileInfo fileInfo) {
        GuildMediaUploadTaskInfo guildMediaUploadTaskInfo;
        int i3;
        int i16;
        b bVar = this.uploadTaskMap.get(fileInfo.fileGroupId);
        if (bVar != null) {
            guildMediaUploadTaskInfo = bVar.getTaskResult();
        } else {
            guildMediaUploadTaskInfo = null;
        }
        if (guildMediaUploadTaskInfo == null) {
            QLog.e(TAG, 1, "getTaskInfoFromGProUploadFileInfo, " + fileInfo.fileGroupId + "-" + fileInfo.fileId + " taskInfo is null");
            return null;
        }
        b bVar2 = this.uploadTaskMap.get(fileInfo.fileGroupId);
        if (bVar2 != null) {
            i3 = bVar2.getType();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return null;
        }
        GuildMediaInfo mediaInfo = guildMediaUploadTaskInfo.getMediaInfo();
        if (mediaInfo == null) {
            String str = fileInfo.filePath;
            Intrinsics.checkNotNullExpressionValue(str, "fileInfo.filePath");
            mediaInfo = new GuildMediaInfo(str, null);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                QLog.e(TAG, 1, "getTaskInfoFromGProUploadFileInfo, " + guildMediaUploadTaskInfo.getFileId() + " invalid task type: " + i3);
                return null;
            }
            GuildVideoResult guildVideoResult = (GuildVideoResult) mediaInfo.getUploadResult();
            if (guildVideoResult == null) {
                guildVideoResult = new GuildVideoResult(null, null, 3, null);
            }
            GProUploadFileType gProUploadFileType = fileInfo.fileType;
            if (gProUploadFileType == null) {
                i16 = -1;
            } else {
                i16 = c.f218042a[gProUploadFileType.ordinal()];
            }
            if (i16 != 1) {
                if (i16 != 2) {
                    QLog.e(TAG, 1, "getTaskInfoFromGProUploadFileInfo, " + fileInfo.fileGroupId + "-" + fileInfo.fileId + ", invalid type: " + fileInfo.fileType);
                } else {
                    GuildImageResult guildImageResult = new GuildImageResult(null, 0, 0, 7, null);
                    String str2 = fileInfo.svrUrl;
                    Intrinsics.checkNotNullExpressionValue(str2, "fileInfo.svrUrl");
                    guildImageResult.b(str2);
                    guildVideoResult.b(guildImageResult);
                    String str3 = fileInfo.svrUrl;
                    Intrinsics.checkNotNullExpressionValue(str3, "fileInfo.svrUrl");
                    guildMediaUploadTaskInfo.r(str3);
                }
            } else {
                String str4 = fileInfo.svrFileId;
                Intrinsics.checkNotNullExpressionValue(str4, "fileInfo.svrFileId");
                guildVideoResult.c(str4);
            }
            mediaInfo.c(guildVideoResult);
        } else {
            String str5 = fileInfo.svrUrl;
            Intrinsics.checkNotNullExpressionValue(str5, "fileInfo.svrUrl");
            mediaInfo.c(new GuildImageResult(str5, 0, 0, 6, null));
            String str6 = fileInfo.svrUrl;
            Intrinsics.checkNotNullExpressionValue(str6, "fileInfo.svrUrl");
            guildMediaUploadTaskInfo.r(str6);
        }
        guildMediaUploadTaskInfo.x(mediaInfo);
        return guildMediaUploadTaskInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyTaskInfoChange(String fileGroupId, GuildMediaUploadTaskInfo taskInfo, int preState) {
        b bVar = this.uploadTaskMap.get(fileGroupId);
        if (bVar == null) {
            QLog.e(TAG, 1, "notifyTaskInfoChange, " + fileGroupId + "-" + taskInfo.getFileId() + " task is null");
            return;
        }
        bVar.r(taskInfo);
        if (getOriginFileIdFromGroupId(fileGroupId) == null) {
            QLog.e(TAG, 1, "notifyTaskInfoChange, " + fileGroupId + " origin fileId not found");
            return;
        }
        this.observable.a(taskInfo, preState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeUploadMediaTask$lambda$0(int i3, String str) {
        QLog.i(TAG, 1, "removeFileGroupUpload, result = " + i3 + ", errMsg = " + str);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    @NotNull
    public Map<String, com.tencent.mobileqq.guild.data.o> batchGetUploadMediaTaskInfoList(@NotNull Set<String> fileIdSet) {
        b bVar;
        GuildMediaUploadTaskInfo taskResult;
        Intrinsics.checkNotNullParameter(fileIdSet, "fileIdSet");
        HashMap hashMap = new HashMap();
        for (String str : fileIdSet) {
            String str2 = this.fileIdToFileGroupIdMap.get(str);
            if (str2 != null && (bVar = this.uploadTaskMap.get(str2)) != null && (taskResult = bVar.getTaskResult()) != null) {
                hashMap.put(str, taskResult);
            }
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean createUploadMediaTask(@NotNull String fileId, @NotNull com.tencent.mobileqq.guild.data.g mediaInfo) {
        boolean z16;
        b bVar;
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (this.runtime == null) {
            QLog.e(TAG, 1, "runtime is null");
            return false;
        }
        if (com.tencent.mobileqq.guild.feed.util.l.d() == null) {
            QLog.e(TAG, 1, "fileTransferService is null");
            return false;
        }
        String str = this.fileIdToFileGroupIdMap.get(fileId);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.i(TAG, 1, ((Object) this.fileIdToFileGroupIdMap.get(fileId)) + "-" + fileId + " task already exist");
            return true;
        }
        createUploadFileGroupTask(fileId, mediaInfo);
        String str2 = this.fileIdToFileGroupIdMap.get(fileId);
        if (str2 == null || (bVar = this.uploadTaskMap.get(str2)) == null) {
            return false;
        }
        bVar.d(new d(bVar, this, str2));
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        this.runtime = appRuntime;
        uh2.h d16 = com.tencent.mobileqq.guild.feed.util.l.d();
        if (d16 != null) {
            d16.addFileUploadListener(this.ntListener);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.runtime = null;
        uh2.h d16 = com.tencent.mobileqq.guild.feed.util.l.d();
        if (d16 != null) {
            d16.c(this.ntListener);
        }
        this.fileIdToFileGroupIdMap.clear();
        this.uploadTaskMap.clear();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean pauseUploadMediaTask(@NotNull String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        String str = this.fileIdToFileGroupIdMap.get(fileId);
        QLog.i(TAG, 1, "pauseUploadMediaTask, groupId= " + str + ", fileId = " + fileId);
        if (str == null) {
            return false;
        }
        b bVar = this.uploadTaskMap.get(str);
        if (bVar == null) {
            QLog.e(TAG, 1, "pauseUploadMediaTask failed, task is null");
            return false;
        }
        bVar.n(new f());
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean removeUploadMediaTask(@NotNull String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        String str = this.fileIdToFileGroupIdMap.get(fileId);
        QLog.i(TAG, 1, "removeUploadMediaTask, groupId= " + str + ", fileId = " + fileId);
        if (str == null) {
            return false;
        }
        uh2.h d16 = com.tencent.mobileqq.guild.feed.util.l.d();
        if (d16 != null) {
            d16.removeFileGroupUpload(str, new IGProTransferFileOperateCallback() { // from class: com.tencent.mobileqq.guild.feed.api.impl.r
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransferFileOperateCallback
                public final void onResult(int i3, String str2) {
                    GuildFeedMediaUploadServiceApiSDKImpl.removeUploadMediaTask$lambda$0(i3, str2);
                }
            });
        }
        this.uploadTaskMap.remove(str);
        this.fileIdToFileGroupIdMap.remove(fileId);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean restoreUploadMediaTask(@NotNull String fileId, @NotNull com.tencent.mobileqq.guild.data.g localMediaInfo, @Nullable Object extraInfo) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        QLog.i(TAG, 1, "restoreUploadMediaTask, fileId = " + fileId);
        return createUploadMediaTask(fileId, localMediaInfo);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean resumeUploadMediaTask(@NotNull String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        String str = this.fileIdToFileGroupIdMap.get(fileId);
        QLog.i(TAG, 1, "resumeFileGroupUpload, groupId= " + str + ", fileId = " + fileId);
        if (str == null) {
            return false;
        }
        b bVar = this.uploadTaskMap.get(str);
        if (bVar == null) {
            QLog.e(TAG, 1, "resumeUploadMediaTask failed, task is null");
            return false;
        }
        if (bVar.getTaskResult().getState() != 5 && !bVar.getTaskResult().j()) {
            if (bVar.getTaskResult().e()) {
                QLog.i(TAG, 1, "resumeUploadMediaTask, task already success");
                notifyTaskInfoChange(str, bVar.getTaskResult(), bVar.getTaskResult().getState());
                return true;
            }
            bVar.p(new g(bVar, this, str));
            return true;
        }
        QLog.e(TAG, 1, "resumeUploadMediaTask failed, state = " + bVar.getTaskResult().getState());
        return false;
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
    public GuildFeedMediaUploadServiceApiSDKImpl(@NotNull q observable) {
        Intrinsics.checkNotNullParameter(observable, "observable");
        this.observable = observable;
        this.ntListener = new e();
        this.fileIdToFileGroupIdMap = new LinkedHashMap();
        this.uploadTaskMap = new LinkedHashMap();
    }

    public /* synthetic */ GuildFeedMediaUploadServiceApiSDKImpl(q qVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new q() : qVar);
    }
}
