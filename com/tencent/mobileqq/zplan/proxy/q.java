package com.tencent.mobileqq.zplan.proxy;

import com.epicgames.ue4.GameActivityNative;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zplan.meme.mp4.f;
import com.tencent.mobileqq.zplan.meme.mp4.g;
import com.tencent.mobileqq.zplan.proxy.q;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/q;", "Lzx4/m;", "Lsx4/a;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q implements zx4.m {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JB\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J*\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/zplan/proxy/q$b", "Lsx4/a;", "", "videoFrameWidth", "videoFrameHeight", "videoFrameRate", "audioSampleRate", "audioChannel", "samplePerFrame", "", "storagePath", "onRecordSameStyleStart", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "bytes", "dataSize", "pts", "", "onRecordSameStyleVideoFrame", "onRecordSameStyleAudioFrame", "onRecordSameStyleEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements sx4.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3, int i16) {
            QLog.i("QQZPlanRecordSameStyleProxy", 1, "onTaskEnd: " + i3 + ", " + i16);
            GameActivityNative.SynthesisSameStyleVideoEndCallback(i3, i16);
        }

        @Override // com.epicgames.ue4.GameActivityThunk.RecordSameStyleListener
        public void onRecordSameStyleAudioFrame(int taskId, byte[] bytes, int dataSize, int pts) {
            com.tencent.mobileqq.zplan.meme.mp4.g.d().g(taskId, bytes, dataSize, pts);
        }

        @Override // com.epicgames.ue4.GameActivityThunk.RecordSameStyleListener
        public void onRecordSameStyleEnd(int taskId) {
            com.tencent.mobileqq.zplan.meme.mp4.g.d().h(taskId);
        }

        @Override // com.epicgames.ue4.GameActivityThunk.RecordSameStyleListener
        public int onRecordSameStyleStart(int videoFrameWidth, int videoFrameHeight, int videoFrameRate, int audioSampleRate, int audioChannel, int samplePerFrame, String storagePath) {
            g.b bVar = new g.b();
            bVar.f334182g = storagePath;
            bVar.f334176a = videoFrameWidth;
            bVar.f334177b = videoFrameHeight;
            bVar.f334178c = videoFrameRate;
            bVar.f334179d = audioSampleRate;
            bVar.f334180e = audioChannel;
            bVar.f334181f = 1024;
            return com.tencent.mobileqq.zplan.meme.mp4.g.d().j(bVar, new f.d() { // from class: com.tencent.mobileqq.zplan.proxy.r
                @Override // com.tencent.mobileqq.zplan.meme.mp4.f.d
                public final void a(int i3, int i16) {
                    q.b.b(i3, i16);
                }
            });
        }

        @Override // com.epicgames.ue4.GameActivityThunk.RecordSameStyleListener
        public void onRecordSameStyleVideoFrame(int taskId, byte[] bytes, int dataSize, int pts) {
            com.tencent.mobileqq.zplan.meme.mp4.g.d().i(taskId, bytes, dataSize, pts);
        }
    }

    @Override // zx4.m
    public sx4.a a() {
        QLog.i("QQZPlanRecordSameStyleProxy", 1, "getRecordSameListener");
        return new b();
    }
}
