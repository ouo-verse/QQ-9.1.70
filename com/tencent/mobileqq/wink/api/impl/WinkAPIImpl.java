package com.tencent.mobileqq.wink.api.impl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Size;
import b93.OutputData;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.smartclip.WinkEditorSegClipFragmentV2;
import com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.event.WinkQZoneMoodAppendEvent;
import com.tencent.mobileqq.wink.event.WinkZoneWriteTaskEvent;
import com.tencent.mobileqq.wink.listener.GenerateListener;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.utils.WinkLruCache;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.light.lightAssetKit.components.TimeRange;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\tJ\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J8\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016JB\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0005H\u0016Js\u00104\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00102\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\b\u0010,\u001a\u0004\u0018\u00010(2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00103\u001a\u0002022\u0006\u0010!\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0016J\"\u0010;\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010=\u001a\u00020\u00022\u0006\u0010<\u001a\u000200H\u0016J\u0018\u0010>\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0005H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/WinkAPIImpl;", "Lcom/tencent/mobileqq/wink/api/IWinkAPI;", "", "cleanAllCache", "cleanCompressCache", "", "getApngCachePath", WadlProxyConsts.RES_URL, "downloadQZoneImageRes", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "videoPath", "moveQZoneVideoRes", "cleanCache", "localPath", "flagUselessFile", "initWinkLruCache", "", "outputPoint", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "outputMedias", "originalMedias", "Landroid/os/Bundle;", "bundle", "Lb93/b;", "retrieveOutputData", "Landroid/content/Intent;", "intent", "", "isRunningPublishTask", "mediaPath", "selectStartTime", "selectDurationTime", "bussinessName", "needShowSelectStart", "needShowThumb", "reportSessionId", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "createWinkEditorSegClipFragment", "videoDuration", "Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "startTime", "duration", "outputSize", "Landroid/graphics/Rect;", "outputRect", QAdRewardDefine$VideoParams.CACHE_PATH, "", "frameTime", "Lcom/tencent/mobileqq/wink/listener/GenerateListener;", "listener", "generateApng", "(Ljava/lang/String;Ljava/lang/Long;Landroid/util/Size;JJLandroid/util/Size;Landroid/graphics/Rect;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/wink/listener/GenerateListener;Ljava/lang/String;)V", WadlProxyConsts.PARAM_FILENAME, "getWinkCachePath", "isIpc", QzoneIPCModule.RESULT_CODE, "data", "exitWink", com.heytap.mcssdk.a.a.f36094d, "notifyZoneWriteOperation", "appendMedia2QZoneMood", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAPIImpl implements IWinkAPI {

    @NotNull
    private static final String TAG = "WinkAPIImpl";

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/wink/api/impl/WinkAPIImpl$c", "Lcom/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$b;", "", "frameNum", "", "frameTs", "", "beforeCaptureFrame", "Landroid/graphics/Bitmap;", "frameBitmap", "onCaptureFrame", "croppedBitmap", "onCropFrame", "onAddFrame", "beforeEncode", "", "outputPath", "onEncoded", "onRelease", "", "t", "onError", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ApngAvatarGenerator.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GenerateListener f317974a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f317975b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f317976c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f317977d;

        c(GenerateListener generateListener, String str, long j3, Ref.LongRef longRef) {
            this.f317974a = generateListener;
            this.f317975b = str;
            this.f317976c = j3;
            this.f317977d = longRef;
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void beforeCaptureFrame(int frameNum, long frameTs) {
            GenerateListener generateListener = this.f317974a;
            if (generateListener != null) {
                generateListener.beforeCaptureFrame(frameNum, frameTs);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void beforeEncode() {
            String replace$default;
            Map mapOf;
            replace$default = StringsKt__StringsJVMKt.replace$default(WinkDengtaReportConstant.Action.BUSSINESS_MOV_TO_PNGS_COST, "name", this.f317975b, false, 4, (Object) null);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_COST_TIME, String.valueOf(SystemClock.elapsedRealtime() - this.f317976c)));
            com.tencent.mobileqq.wink.report.e.o(eVar, replace$default, mapOf, false, 4, null);
            this.f317977d.element = SystemClock.elapsedRealtime();
            GenerateListener generateListener = this.f317974a;
            if (generateListener != null) {
                generateListener.beforeEncode();
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onAddFrame(int frameNum) {
            GenerateListener generateListener = this.f317974a;
            if (generateListener != null) {
                generateListener.onAddFrame(frameNum);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onCaptureFrame(int frameNum, long frameTs, @Nullable Bitmap frameBitmap) {
            GenerateListener generateListener = this.f317974a;
            if (generateListener != null) {
                generateListener.onCaptureFrame(frameNum, frameTs, frameBitmap);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onCropFrame(int frameNum, long frameTs, @Nullable Bitmap croppedBitmap) {
            GenerateListener generateListener = this.f317974a;
            if (generateListener != null) {
                generateListener.onCropFrame(frameNum, frameTs, croppedBitmap);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onEncoded(@NotNull String outputPath) {
            String replace$default;
            Map mapOf;
            Intrinsics.checkNotNullParameter(outputPath, "outputPath");
            replace$default = StringsKt__StringsJVMKt.replace$default(WinkDengtaReportConstant.Action.BUSSINESS_PNG_TO_APNG_COST, "name", this.f317975b, false, 4, (Object) null);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_COST_TIME, String.valueOf(SystemClock.elapsedRealtime() - this.f317977d.element)), TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_APNG_SIZE, String.valueOf(new File(outputPath).length())));
            com.tencent.mobileqq.wink.report.e.o(eVar, replace$default, mapOf, false, 4, null);
            GenerateListener generateListener = this.f317974a;
            if (generateListener != null) {
                generateListener.onEncoded(outputPath);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onError(@NotNull Throwable t16) {
            String replace$default;
            Map mapOf;
            Intrinsics.checkNotNullParameter(t16, "t");
            replace$default = StringsKt__StringsJVMKt.replace$default(WinkDengtaReportConstant.Action.BUSSINESS_GENERATE_APNG_FAILED, "name", this.f317975b, false, 4, (Object) null);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_APNG_FAILED_RESULT, String.valueOf(t16.getMessage())));
            com.tencent.mobileqq.wink.report.e.o(eVar, replace$default, mapOf, false, 4, null);
            GenerateListener generateListener = this.f317974a;
            if (generateListener != null) {
                generateListener.onError(t16);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onRelease() {
            GenerateListener generateListener = this.f317974a;
            if (generateListener != null) {
                generateListener.onRelease();
            }
        }
    }

    private final void cleanAllCache() {
        File file = new File(u53.b.f438370a);
        if (file.exists()) {
            FileUtils.deleteFile(file);
        }
        File file2 = new File(u53.a.f438360a);
        if (file2.exists()) {
            FileUtils.deleteFile(file2);
        }
    }

    private final void cleanCompressCache() {
        File file = new File(u53.a.f438361b);
        if (file.exists()) {
            FileUtils.deleteFile(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object downloadQZoneImageRes(String str, Continuation<? super String> continuation) {
        Continuation intercepted;
        boolean startsWith$default;
        Object orThrow;
        Object coroutine_suspended;
        boolean startsWith$default2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "https://", false, 2, null);
            if (!startsWith$default2) {
                safeContinuation.resumeWith(Result.m476constructorimpl(str));
                orThrow = safeContinuation.getOrThrow();
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (orThrow == coroutine_suspended) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                return orThrow;
            }
        }
        com.tencent.mobileqq.wink.downloader.b bVar = com.tencent.mobileqq.wink.downloader.b.f318210a;
        String str2 = bVar.c() + "/" + com.tencent.securitysdk.utils.c.b(str) + "_" + System.currentTimeMillis() + ".jpg";
        bVar.b(str, str2, new b(safeContinuation, str2));
        orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
        }
        return orThrow;
    }

    private final String getApngCachePath() {
        return getWinkCachePath(System.nanoTime() + "_red_packet.apng");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object moveQZoneVideoRes(String str, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        String str2 = com.tencent.mobileqq.wink.downloader.b.f318210a.c() + "/" + com.tencent.securitysdk.utils.c.b(str) + "_" + System.currentTimeMillis() + ".mp4";
        FileUtils.copyFile(str, str2);
        safeContinuation.resumeWith(Result.m476constructorimpl(str2));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    public void appendMedia2QZoneMood(boolean isIpc, @NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            JSONObject jSONObject = new JSONObject(data);
            JSONArray optJSONArray = jSONObject.optJSONArray("photoList");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String str = (String) BuildersKt.runBlocking(WinkCoroutineScopes.f317652a.c(), new WinkAPIImpl$appendMedia2QZoneMood$1(this, optJSONArray, i3, null));
                    if (str != null) {
                        arrayList.add(str);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("videoList");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                int length2 = optJSONArray2.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    arrayList2.add((String) BuildersKt.runBlocking(WinkCoroutineScopes.f317652a.b(), new WinkAPIImpl$appendMedia2QZoneMood$3(this, optJSONArray2, i16, null)));
                }
            }
            String optString = jSONObject.optString("tagId");
            String optString2 = jSONObject.optString("tagTitle");
            String optString3 = jSONObject.optString("tagUrl");
            String optString4 = jSONObject.optString("tagProtocol");
            String optString5 = jSONObject.optString("adId");
            String optString6 = jSONObject.optString("thirdPartyAppId");
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                hashMap.put("tagId", optString);
                hashMap.put("tagTitle", optString2);
                hashMap.put("tagUrl", optString3);
                hashMap.put("tagProtocol", optString4);
            }
            hashMap.put("adId", optString5);
            hashMap.put("thirdPartyAppId", optString6);
            SimpleEventBus.getInstance().dispatchEvent(new WinkQZoneMoodAppendEvent(arrayList, arrayList2, hashMap), isIpc);
        } catch (Exception e16) {
            w53.b.d(TAG, "error in WinkAPIImpl#appendMedia2QZoneMood", e16);
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    public void cleanCache() {
        w53.b.c(TAG, "[cleanCache]");
        cleanAllCache();
        cleanCompressCache();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    @Nullable
    public BasePartFragment createWinkEditorSegClipFragment(@NotNull String mediaPath, long selectStartTime, long selectDurationTime, @NotNull String bussinessName, boolean needShowSelectStart, boolean needShowThumb, @NotNull String reportSessionId) {
        Intrinsics.checkNotNullParameter(mediaPath, "mediaPath");
        Intrinsics.checkNotNullParameter(bussinessName, "bussinessName");
        Intrinsics.checkNotNullParameter(reportSessionId, "reportSessionId");
        if (WinkExportUtils.R()) {
            return WinkEditorSegClipFragmentV2.INSTANCE.a(mediaPath, selectStartTime, selectDurationTime, bussinessName, needShowSelectStart, needShowThumb, reportSessionId);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    public void exitWink(boolean isIpc, int resultCode, @Nullable Intent data) {
        SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(true, true, resultCode, data), isIpc);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    public void flagUselessFile(@NotNull String localPath) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        WinkLruCache.f326638a.f(localPath);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    public void generateApng(@NotNull String videoPath, @Nullable Long videoDuration, @Nullable Size videoSize, long startTime, long duration, @Nullable Size outputSize, @Nullable Rect outputRect, @Nullable String cachePath, @Nullable Integer frameTime, @NotNull GenerateListener listener, @NotNull String bussinessName) {
        long j3;
        org.light.lightAssetKit.components.Size size;
        org.light.lightAssetKit.components.Size size2;
        Rect rect;
        String str;
        int i3;
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(bussinessName, "bussinessName");
        if (!WinkExportUtils.R()) {
            listener.onError(new Throwable() { // from class: com.tencent.mobileqq.wink.api.impl.WinkAPIImpl$generateApng$1
                @Override // java.lang.Throwable
                @Nullable
                public String getMessage() {
                    return "light sdk is not ready";
                }
            });
            return;
        }
        LocalMediaInfo d16 = WinkExportUtils.d(videoPath);
        String valueOf = String.valueOf(videoPath.hashCode());
        ClipType clipType = ClipType.VIDEO;
        if (videoDuration != null) {
            j3 = videoDuration.longValue();
        } else {
            j3 = d16.mDuration * 1000;
        }
        ClipSource clipSource = new ClipSource(valueOf, videoPath, clipType, j3, null, null, null, null, null, null, null, null, null, 8176, null);
        if (videoSize == null) {
            size = new org.light.lightAssetKit.components.Size(d16.mediaWidth, d16.mediaHeight);
        } else {
            size = new org.light.lightAssetKit.components.Size(videoSize.getWidth(), videoSize.getHeight());
        }
        TimeRange timeRange = new TimeRange(startTime, duration);
        if (outputSize == null) {
            size2 = new org.light.lightAssetKit.components.Size(d16.mediaWidth, d16.mediaHeight);
        } else {
            size2 = new org.light.lightAssetKit.components.Size(outputSize.getWidth(), outputSize.getHeight());
        }
        if (outputRect == null) {
            rect = new Rect(0, 0, d16.mediaWidth, d16.mediaHeight);
        } else {
            rect = outputRect;
        }
        if (cachePath == null) {
            str = getApngCachePath();
        } else {
            str = cachePath;
        }
        if (frameTime != null) {
            i3 = frameTime.intValue();
        } else {
            i3 = 100;
        }
        ApngAvatarGenerator apngAvatarGenerator = new ApngAvatarGenerator(clipSource, size, timeRange, size2, rect, str, i3);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = elapsedRealtime;
        apngAvatarGenerator.q(new c(listener, bussinessName, elapsedRealtime, longRef));
        apngAvatarGenerator.j();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    @NotNull
    public String getWinkCachePath(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String str = u53.e.f438384a + File.separator;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + fileName;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    public void initWinkLruCache() {
        WinkLruCache winkLruCache = WinkLruCache.f326638a;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    public boolean isRunningPublishTask() {
        WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
        if (qfsService != null && qfsService.hasRunningTask()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    public void notifyZoneWriteOperation(int taskID) {
        SimpleEventBus.getInstance().dispatchEvent(new WinkZoneWriteTaskEvent(taskID), true);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    @NotNull
    public OutputData retrieveOutputData(long outputPoint, @NotNull List<? extends LocalMediaInfo> outputMedias, @Nullable List<? extends LocalMediaInfo> originalMedias, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(outputMedias, "outputMedias");
        WinkContext.Companion companion = WinkContext.INSTANCE;
        return new OutputData(outputPoint, companion.d().getMissionId(), outputMedias, originalMedias, Uri.decode(companion.d().p(QCircleScheme.AttrQQPublish.BUSINESS_RETURN_SCHEME)), companion.d().p(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA), companion.d().p("taskid"), new Bundle(bundle));
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkAPI
    @NotNull
    public OutputData retrieveOutputData(long outputPoint, @NotNull List<? extends LocalMediaInfo> outputMedias, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(outputMedias, "outputMedias");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            Serializable serializableExtra = intent.getSerializableExtra(QQWinkConstants.INPUT_MEDIA_ORIGINAL);
            r4 = serializableExtra instanceof List ? (List) serializableExtra : null;
            if (QLog.isColorLevel() && r4 != null) {
                Iterator it = r4.iterator();
                while (it.hasNext()) {
                    QLog.d(TAG, 2, "[retrieve]2 " + ((LocalMediaInfo) it.next()).path);
                }
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[retrieve]2 " + e16);
        }
        WinkContext.Companion companion = WinkContext.INSTANCE;
        return new OutputData(outputPoint, companion.d().getMissionId(), outputMedias, r4, Uri.decode(companion.d().p(QCircleScheme.AttrQQPublish.BUSINESS_RETURN_SCHEME)), companion.d().p(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA), companion.d().p("taskid"), new Bundle(intent.getExtras()));
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/api/impl/WinkAPIImpl$b", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f317972a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f317973b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super String> continuation, String str) {
            this.f317972a = continuation;
            this.f317973b = str;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            String str;
            Continuation<String> continuation = this.f317972a;
            Result.Companion companion = Result.INSTANCE;
            if (isSuccess) {
                str = this.f317973b;
            } else {
                str = null;
            }
            continuation.resumeWith(Result.m476constructorimpl(str));
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }
}
