package com.tencent.biz.qqcircle.immersive.redpacket.task;

import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bH\u0016R \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/j;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/BaseTask;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/h;", "initial", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "", DomainData.DOMAIN_NAME, "Ljava/util/LinkedList;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/p;", "j", "b", "Ljava/util/LinkedList;", "processList", "", "k", "()Ljava/lang/String;", "tag", "<init>", "()V", "c", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class j extends BaseTask<DownloadVideoData> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<p<DownloadVideoData>> processList;

    public j() {
        LinkedList<p<DownloadVideoData>> linkedList = new LinkedList<>();
        linkedList.add(new g());
        linkedList.add(new m());
        linkedList.add(new i());
        this.processList = linkedList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.BaseTask
    @NotNull
    public LinkedList<p<DownloadVideoData>> j() {
        return this.processList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.BaseTask
    @NotNull
    public String k() {
        return "DownloadVideoTask";
    }

    public void n(@NotNull DownloadVideoData initial, @NotNull o<DownloadVideoData> callback) {
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(callback, "callback");
        g(initial, j(), callback);
    }
}
