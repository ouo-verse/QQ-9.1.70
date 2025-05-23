package com.tencent.mobileqq.wink.editor.export;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.editor.cu;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b.\u0010/J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016JJ\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J*\u0010\u0018\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u001a\u0010\u001e\u001a\u00020\u00198\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/x;", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "", "type", "", QCircleWeakNetReporter.KEY_COST, "Lcom/tencent/mobileqq/wink/model/WinkExportParams;", "winkExportParams", "", "useSoftEncoder", "", "b", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "isExported", "hitCache", "exportStartTime", "Lcom/tencent/mobileqq/wink/editor/export/c;", "callBack", "c", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errCode", "e", "", "a", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "tag", "Z", "i", "()Z", "j", "(Z)V", "isCanceled", "J", "f", "()J", "k", "(J)V", "d", "g", "l", "lastSendTime", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag = "WinkPublish-Export-WinkVideoBaseTask";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isCanceled;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long exportStartTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastSendTime;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams) {
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "$winkEditDataWrapper");
        Intrinsics.checkNotNullParameter(winkExportParams, "$winkExportParams");
        e.d(winkEditDataWrapper, winkExportParams.F, winkExportParams.D);
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_VIDEO_EXPORT);
        cu.A(winkEditDataWrapper.getEditDatas());
    }

    public void b(@NotNull WinkEditDataWrapper winkEditDataWrapper, int type, long cost, @NotNull WinkExportParams winkExportParams, boolean useSoftEncoder) {
        long duration;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        winkExportParams.o();
        boolean z16 = true;
        JsonObject a16 = WinkExportUtils.a(true, false, type, 1);
        a16.addProperty("softencoder", Boolean.valueOf(useSoftEncoder));
        a16.addProperty("id", String.valueOf(winkExportParams.K));
        long duration2 = winkEditDataWrapper.getDuration();
        WinkConfig winkConfig = WinkConfig.f317649a;
        if (duration2 > winkConfig.b()) {
            duration = winkConfig.a();
        } else {
            duration = winkEditDataWrapper.getDuration() / 1000;
        }
        a16.addProperty("duration", String.valueOf(duration));
        ArrayList<LocalMediaInfo> originMediaInfos = winkEditDataWrapper.getOriginMediaInfos();
        if (originMediaInfos != null && !originMediaInfos.isEmpty()) {
            z16 = false;
        }
        if (!z16) {
            a16.addProperty("mediaCount", String.valueOf(originMediaInfos.size()));
            JsonArray jsonArray = new JsonArray();
            int min = Math.min(originMediaInfos.size(), 5);
            for (int i3 = 0; i3 < min; i3++) {
                jsonArray.add(WinkExportUtils.n(originMediaInfos.get(i3)));
            }
            a16.add("mediainfo", jsonArray);
        }
        WinkExportUtils.k(winkExportParams, "E_VIDEO_EXPORT_START", 0L, "", String.valueOf(AEOfflineConfig.getPhonePerfLevel()), String.valueOf(cost), String.valueOf(type), com.tencent.mobileqq.wink.editor.draft.c.j(winkEditDataWrapper), "", winkExportParams.E, a16);
    }

    public void c(@NotNull final WinkEditDataWrapper winkEditDataWrapper, @NotNull LocalMediaInfo localMediaInfo, @NotNull final WinkExportParams winkExportParams, boolean isExported, boolean hitCache, int type, long exportStartTime, @Nullable c callBack) {
        String str;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        w53.b.f(h(), "[doOnExportCompleted] filePath=" + localMediaInfo.path + ", missionId=" + winkExportParams.E + ", isExported=" + isExported);
        if (callBack != null) {
            callBack.d(winkExportParams.E, localMediaInfo, isExported);
        }
        if (isExported && !hitCache) {
            WinkExportUtils.U(winkExportParams.E, localMediaInfo, winkExportParams);
        }
        long currentTimeMillis = System.currentTimeMillis() - exportStartTime;
        if (!isExported || hitCache) {
            currentTimeMillis = 0;
        }
        JsonObject a16 = WinkExportUtils.a(isExported, hitCache, type, 1);
        a16.addProperty(QCircleWeakNetReporter.KEY_COST, String.valueOf(currentTimeMillis));
        Boolean bool = u53.i.f438428a;
        if (bool != null) {
            str = String.valueOf(bool);
        } else {
            str = "false";
        }
        a16.addProperty("enableFastSoftDecode", str);
        a16.addProperty("softDecodeThreadCnt", String.valueOf(u53.i.f438429b));
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(ad.d(localMediaInfo, winkEditDataWrapper));
        a16.add("mediainfo", jsonArray);
        ad.b(winkExportParams, "E_VIDEO_EXPORT_RESULT", 0L, "compose suc", String.valueOf(currentTimeMillis), String.valueOf(localMediaInfo.mediaBitrate), String.valueOf(localMediaInfo.fileSize), String.valueOf(localMediaInfo.mDuration / 1000), localMediaInfo.path, com.tencent.mobileqq.wink.editor.draft.c.j(winkEditDataWrapper), a16);
        winkEditDataWrapper.setOutMediaInfo(localMediaInfo);
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.export.w
            @Override // java.lang.Runnable
            public final void run() {
                x.d(WinkEditDataWrapper.this, winkExportParams);
            }
        });
    }

    public void e(@NotNull WinkExportParams winkExportParams, @NotNull ExportErrorCode errCode, int type, @Nullable c callBack) {
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        w53.b.c(h(), "[doOnExportError], missionId=" + winkExportParams.E + ", errCode=" + errCode + ", type=" + type);
        if (callBack != null) {
            callBack.c(winkExportParams.E, errCode);
        }
        ad.c(winkExportParams, "E_VIDEO_EXPORT_RESULT", errCode.transformedCode(), errCode.getMessage(), null, null, String.valueOf(type), null, null, null, ad.a(true, false, type, winkExportParams.H), 944, null);
    }

    /* renamed from: f, reason: from getter */
    public final long getExportStartTime() {
        return this.exportStartTime;
    }

    /* renamed from: g, reason: from getter */
    public final long getLastSendTime() {
        return this.lastSendTime;
    }

    @NotNull
    public String h() {
        throw null;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsCanceled() {
        return this.isCanceled;
    }

    public final void j(boolean z16) {
        this.isCanceled = z16;
    }

    public final void k(long j3) {
        this.exportStartTime = j3;
    }

    public final void l(long j3) {
        this.lastSendTime = j3;
    }
}
