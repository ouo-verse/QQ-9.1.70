package com.tencent.biz.richframework.publish.base;

import com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileObserver;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishModelObserver;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.raft.codegenmeta.utils.RLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001QB\u000f\u0012\u0006\u0010 \u001a\u00020\r\u00a2\u0006\u0004\bP\u0010%J\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\tJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R>\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000`\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R$\u0010)\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R$\u0010,\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010!\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010!\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R*\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00058\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR*\u0010G\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00038\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006R"}, d2 = {"Lcom/tencent/biz/richframework/publish/base/RFWPublishFile;", "T", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWUploadable;", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile$FileState;", "executePreprocess", "", "isFileUploaded", "isFileUploadNoError", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "genUploadTasks", "", "indexInPublishModel", "", "toString", "task", "", "updateFileAfterUpload", "(Ljava/lang/Object;)V", "Lcom/tencent/biz/richframework/publish/base/RFWPublishModel;", "model", "Lcom/tencent/biz/richframework/publish/base/RFWPublishModel;", "getModel", "()Lcom/tencent/biz/richframework/publish/base/RFWPublishModel;", "setModel", "(Lcom/tencent/biz/richframework/publish/base/RFWPublishModel;)V", "subElements", "Ljava/util/ArrayList;", "getSubElements", "()Ljava/util/ArrayList;", "setSubElements", "(Ljava/util/ArrayList;)V", "filePath", "Ljava/lang/String;", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "fileID", "getFileID", "setFileID", "md5", "getMd5", "setMd5", "sha1", "getSha1", "setSha1", "", "fileSize", "J", "getFileSize", "()J", "setFileSize", "(J)V", WadlProxyConsts.PARAM_FILENAME, "getFileName", "setFileName", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishFileObserver;", "fileStateObserver", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishFileObserver;", "getFileStateObserver", "()Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishFileObserver;", "setFileStateObserver", "(Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishFileObserver;)V", "value", "readyUpload", "Z", "getReadyUpload", "()Z", "setReadyUpload", "(Z)V", "state", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile$FileState;", "getState", "()Lcom/tencent/biz/richframework/publish/base/RFWPublishFile$FileState;", "setState", "(Lcom/tencent/biz/richframework/publish/base/RFWPublishFile$FileState;)V", "Lcom/tencent/biz/richframework/publish/base/RFWPublishPreprocessChain;", "preprocessChain", "Lcom/tencent/biz/richframework/publish/base/RFWPublishPreprocessChain;", "<init>", "FileState", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class RFWPublishFile<T> implements IRFWUploadable<T> {
    private String fileID;
    private String fileName;
    private String filePath;
    private long fileSize;
    private IRFWPublishFileObserver fileStateObserver;
    private String md5;
    private RFWPublishModel<T> model;
    private RFWPublishPreprocessChain preprocessChain;
    private volatile boolean readyUpload;
    private String sha1;
    private volatile FileState state;
    private ArrayList<RFWPublishFile<T>> subElements;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/richframework/publish/base/RFWPublishFile$FileState;", "", "(Ljava/lang/String;I)V", "RAW", "PROCESSING", "READY_TO_UPLOAD", "UPLOADING", "UPLOADED", "CANCEL", RLog.ERROR, "rfw-upload_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public enum FileState {
        RAW,
        PROCESSING,
        READY_TO_UPLOAD,
        UPLOADING,
        UPLOADED,
        CANCEL,
        ERROR
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileState.values().length];
            try {
                iArr[FileState.PROCESSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileState.UPLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileState.UPLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileState.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileState.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FileState.READY_TO_UPLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RFWPublishFile(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.subElements = new ArrayList<>();
        this.filePath = filePath;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.fileID = uuid;
        this.state = FileState.RAW;
        this.preprocessChain = new RFWPublishPreprocessChain();
    }

    public final FileState executePreprocess() {
        return this.preprocessChain.executePreprocess(this);
    }

    public final ArrayList<T> genUploadTasks() {
        ArrayList<T> arrayList = new ArrayList<>();
        arrayList.add(genUploadTask());
        Iterator<RFWPublishFile<T>> it = this.subElements.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().genUploadTask());
        }
        return arrayList;
    }

    public final String getFileID() {
        return this.fileID;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final RFWPublishModel<T> getModel() {
        return this.model;
    }

    public final String getSha1() {
        return this.sha1;
    }

    public final FileState getState() {
        return this.state;
    }

    public final int indexInPublishModel() {
        RFWPublishModel<T> rFWPublishModel = this.model;
        if (rFWPublishModel == null) {
            return -1;
        }
        Iterator<RFWPublishFile<T>> it = rFWPublishModel.getFileList().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().fileID, this.fileID)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public final boolean isFileUploadNoError() {
        boolean z16 = this.state != FileState.ERROR;
        Iterator<RFWPublishFile<T>> it = this.subElements.iterator();
        while (it.hasNext()) {
            z16 = z16 && it.next().state != FileState.ERROR;
        }
        return z16;
    }

    public final boolean isFileUploaded() {
        boolean z16 = this.state == FileState.UPLOADED;
        Iterator<RFWPublishFile<T>> it = this.subElements.iterator();
        while (it.hasNext()) {
            z16 = z16 && it.next().state == FileState.UPLOADED;
        }
        return z16;
    }

    public final void setFileName(String str) {
        this.fileName = str;
    }

    public final void setFileSize(long j3) {
        this.fileSize = j3;
    }

    public final void setFileStateObserver(IRFWPublishFileObserver iRFWPublishFileObserver) {
        this.fileStateObserver = iRFWPublishFileObserver;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final void setModel(RFWPublishModel<T> rFWPublishModel) {
        this.model = rFWPublishModel;
    }

    public final void setReadyUpload(boolean z16) {
        RFWPublishModel<T> rFWPublishModel;
        IRFWPublishModelObserver observer;
        this.readyUpload = z16;
        if (!this.readyUpload || (rFWPublishModel = this.model) == null || (observer = rFWPublishModel.getObserver()) == null) {
            return;
        }
        observer.onTaskReadyToUpload(this);
    }

    public final void setSha1(String str) {
        this.sha1 = str;
    }

    public final void setState(FileState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.state = value;
        switch (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()]) {
            case 1:
                IRFWPublishFileObserver iRFWPublishFileObserver = this.fileStateObserver;
                if (iRFWPublishFileObserver != null) {
                    iRFWPublishFileObserver.onFileProcessing(this);
                    return;
                }
                return;
            case 2:
                IRFWPublishFileObserver iRFWPublishFileObserver2 = this.fileStateObserver;
                if (iRFWPublishFileObserver2 != null) {
                    iRFWPublishFileObserver2.onFileUploading(this);
                    return;
                }
                return;
            case 3:
                IRFWPublishFileObserver iRFWPublishFileObserver3 = this.fileStateObserver;
                if (iRFWPublishFileObserver3 != null) {
                    iRFWPublishFileObserver3.onFileUploaded(this);
                    return;
                }
                return;
            case 4:
                IRFWPublishFileObserver iRFWPublishFileObserver4 = this.fileStateObserver;
                if (iRFWPublishFileObserver4 != null) {
                    iRFWPublishFileObserver4.onFileCancel(this);
                    return;
                }
                return;
            case 5:
                IRFWPublishFileObserver iRFWPublishFileObserver5 = this.fileStateObserver;
                if (iRFWPublishFileObserver5 != null) {
                    iRFWPublishFileObserver5.onFileError(this);
                    return;
                }
                return;
            case 6:
                IRFWPublishFileObserver iRFWPublishFileObserver6 = this.fileStateObserver;
                if (iRFWPublishFileObserver6 != null) {
                    iRFWPublishFileObserver6.onFileReadyToUpload(this);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("model=");
        RFWPublishModel<T> rFWPublishModel = this.model;
        sb5.append(rFWPublishModel != null ? rFWPublishModel.getPublishID() : null);
        sb5.append(", subElements=");
        sb5.append(this.subElements);
        sb5.append(", filePath=");
        sb5.append(this.filePath);
        sb5.append(", fileID=");
        sb5.append(this.fileID);
        sb5.append(", md5=");
        sb5.append(this.md5);
        sb5.append(", sha1=");
        sb5.append(this.sha1);
        sb5.append(", fileSize=");
        sb5.append(this.fileSize);
        sb5.append(", fileName=");
        sb5.append(this.fileName);
        sb5.append(", state=");
        sb5.append(this.state.name());
        sb5.append(", readyUpload=");
        sb5.append(this.readyUpload);
        return sb5.toString();
    }

    public abstract void updateFileAfterUpload(T task);
}
