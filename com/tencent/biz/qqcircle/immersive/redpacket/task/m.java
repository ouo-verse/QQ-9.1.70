package com.tencent.biz.qqcircle.immersive.redpacket.task;

import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.richframework.video.player.process.QFSPlayerOptionsExchangeUrlProcess;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/m;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/e;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/h;", "", "a", "data", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "", "e", "c", "()Ljava/lang/String;", "tag", "<init>", "()V", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class m extends e<DownloadVideoData> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(DownloadVideoData data, o callback, RFWPlayerOptions rFWPlayerOptions, boolean z16) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        String realPlayUrl = rFWPlayerOptions.getRealPlayUrl();
        QLog.d("ExchangeUrlProcess", 1, "doProcess, realPlayUrl:" + realPlayUrl);
        data.e(realPlayUrl);
        callback.onSuccess(data);
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    @NotNull
    public String a() {
        return "ExchangeUrlProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.e
    @NotNull
    public String c() {
        return "ExchangeUrlProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull final DownloadVideoData data, @NotNull final o<DownloadVideoData> callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = data.getFeed().video.playUrl.get();
        boolean checkVideoUrlIsNeedChange = RFWVideoUtils.checkVideoUrlIsNeedChange(str);
        QLog.d("ExchangeUrlProcess", 1, "doProcess, url:" + str + ", needExchangeUrl:" + checkVideoUrlIsNeedChange);
        if (!checkVideoUrlIsNeedChange) {
            data.e(str);
            callback.onSuccess(data);
            return;
        }
        RFWPlayerOptionsProcessManager g16 = RFWPlayerOptionsProcessManager.g();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(QFSPlayerOptionsExchangeUrlProcess.f92033a);
        RFWPlayerOptions obtain = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        obtain.setStVideo(gb0.b.k(data.getFeed().video));
        obtain.setPlayUrl(str);
        obtain.setFileId(data.getFeed().video.fileId.get());
        Unit unit = Unit.INSTANCE;
        g16.startProcess(linkedList, obtain, new RFWPlayerOptionsProcessManager.IProcessCallBack() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.task.l
            @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager.IProcessCallBack
            public final void onFinish(RFWPlayerOptions rFWPlayerOptions, boolean z16) {
                m.f(DownloadVideoData.this, callback, rFWPlayerOptions, z16);
            }
        });
    }
}
