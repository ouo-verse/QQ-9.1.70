package com.tencent.biz.richframework.publish.base;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.publish.base.RFWPublishModel;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\b&\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/richframework/publish/base/RFWPublisher;", "Lcom/tencent/biz/richframework/publish/base/RFWPublishModel;", "M", "", "publishModel", "", "createMission", "(Lcom/tencent/biz/richframework/publish/base/RFWPublishModel;)V", "", "publishID", "fetchMission", "(Ljava/lang/String;)Lcom/tencent/biz/richframework/publish/base/RFWPublishModel;", "startPreprocess", "", "publishModelMap", "Ljava/util/Map;", "<init>", "()V", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class RFWPublisher<M extends RFWPublishModel<?>> implements IRFWLog {
    private Map<String, M> publishModelMap = new HashMap();

    public void createMission(M publishModel) {
        Intrinsics.checkNotNullParameter(publishModel, "publishModel");
        RFWLog.d(getLogTag(), RFWLog.USR, "createMission publisher=" + hashCode() + ", model=" + publishModel.getPublishID() + ", fileSize=" + publishModel.getFileList().size());
        this.publishModelMap.put(publishModel.getPublishID(), publishModel);
    }

    public M fetchMission(String publishID) {
        Intrinsics.checkNotNullParameter(publishID, "publishID");
        RFWLog.d(getLogTag(), RFWLog.CLR, "fetchMission publisher=" + hashCode() + ", model=" + publishID);
        return this.publishModelMap.get(publishID);
    }

    public void startPreprocess(String publishID) {
        Intrinsics.checkNotNullParameter(publishID, "publishID");
        M fetchMission = fetchMission(publishID);
        if (fetchMission == null) {
            return;
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "startPreprocess publisher=" + hashCode() + ", model=" + fetchMission.getPublishID() + ", fileSize=" + fetchMission.getFileList().size());
        fetchMission.startPreprocess();
    }
}
