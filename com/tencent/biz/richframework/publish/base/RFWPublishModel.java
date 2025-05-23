package com.tencent.biz.richframework.publish.base;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWLog;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileObserver;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishModelObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\t\b\u0016\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010\b\u001a\u00020\u00072\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H&J\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\nJ\u0014\u0010\f\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0007R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R>\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\tj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004`\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/richframework/publish/base/RFWPublishModel;", "T", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWLog;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishFileObserver;", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile;", "", "file", "", "preProcessFile", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "genUploadTasks", "addPublishFile", "", "fileID", "fetchPublishFile", "", "isAllFileUploaded", "isAllFileUploadNoError", "startPreprocess", "publishID", "Ljava/lang/String;", "getPublishID", "()Ljava/lang/String;", "setPublishID", "(Ljava/lang/String;)V", "fileList", "Ljava/util/ArrayList;", "getFileList", "()Ljava/util/ArrayList;", "setFileList", "(Ljava/util/ArrayList;)V", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishModelObserver;", "observer", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishModelObserver;", "getObserver", "()Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishModelObserver;", "setObserver", "(Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishModelObserver;)V", "<init>", "()V", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class RFWPublishModel<T> implements IRFWLog, IRFWPublishFileObserver {
    private ArrayList<RFWPublishFile<T>> fileList = new ArrayList<>();
    private IRFWPublishModelObserver observer;
    private String publishID;

    public RFWPublishModel() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.publishID = uuid;
    }

    public final void addPublishFile(RFWPublishFile<T> file) {
        Intrinsics.checkNotNullParameter(file, "file");
        file.setModel(this);
        file.setFileStateObserver(this);
        this.fileList.add(file);
    }

    public final RFWPublishFile<T> fetchPublishFile(String fileID) {
        Intrinsics.checkNotNullParameter(fileID, "fileID");
        RFWLog.d(getLogTag(), RFWLog.USR, "fetchPublishFile file=" + fileID);
        RFWPublishFile<T> rFWPublishFile = null;
        for (RFWPublishFile<T> rFWPublishFile2 : this.fileList) {
            if (Intrinsics.areEqual(rFWPublishFile2.getFileID(), fileID)) {
                rFWPublishFile = rFWPublishFile2;
            }
        }
        return rFWPublishFile;
    }

    public final ArrayList<T> genUploadTasks() {
        ArrayList<T> arrayList = new ArrayList<>();
        Iterator<RFWPublishFile<T>> it = this.fileList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().genUploadTasks());
        }
        return arrayList;
    }

    public final ArrayList<RFWPublishFile<T>> getFileList() {
        return this.fileList;
    }

    public final IRFWPublishModelObserver getObserver() {
        return this.observer;
    }

    public final String getPublishID() {
        return this.publishID;
    }

    public final boolean isAllFileUploadNoError() {
        Iterator<RFWPublishFile<T>> it = this.fileList.iterator();
        while (true) {
            boolean z16 = true;
            while (it.hasNext()) {
                RFWPublishFile<T> next = it.next();
                if (!z16 || !next.isFileUploadNoError()) {
                    z16 = false;
                }
            }
            return z16;
        }
    }

    public final boolean isAllFileUploaded() {
        Iterator<RFWPublishFile<T>> it = this.fileList.iterator();
        while (true) {
            boolean z16 = true;
            while (it.hasNext()) {
                RFWPublishFile<T> next = it.next();
                if (!z16 || !next.isFileUploaded()) {
                    z16 = false;
                }
            }
            return z16;
        }
    }

    public abstract void preProcessFile(RFWPublishFile<? extends Object> file);

    public final void setObserver(IRFWPublishModelObserver iRFWPublishModelObserver) {
        this.observer = iRFWPublishModelObserver;
    }

    public final void startPreprocess() {
        Iterator<RFWPublishFile<T>> it = this.fileList.iterator();
        while (it.hasNext()) {
            RFWPublishFile<T> file = it.next();
            Intrinsics.checkNotNullExpressionValue(file, "file");
            preProcessFile(file);
        }
    }
}
