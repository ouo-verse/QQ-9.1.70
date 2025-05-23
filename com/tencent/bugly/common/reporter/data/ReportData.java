package com.tencent.bugly.common.reporter.data;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.commons.fileupload.FileUploadBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020$J\u000e\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020$J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\bH\u00c6\u0003J1\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u00108\u001a\u00020$2\b\u00109\u001a\u0004\u0018\u00010:H\u00d6\u0003J\b\u0010;\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010<\u001a\u00020\u0003J\u0006\u0010=\u001a\u00020\u0003J\t\u0010>\u001a\u00020\u0005H\u00d6\u0001J\u0006\u0010?\u001a\u00020$J\t\u0010@\u001a\u00020\u0003H\u00d6\u0001J\u000e\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\u000bJ\b\u0010C\u001a\u00020\u0003H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R\u000e\u0010+\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/tencent/bugly/common/reporter/data/ReportData;", "Lcom/tencent/bugly/common/reporter/data/BaseJsonObject;", "uin", "", AdMetricTag.Report.TYPE, "", AdMetricTag.EVENT_NAME, "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;)V", "attachmentInfo", "Lcom/tencent/bugly/common/reporter/data/AttachmentInfo;", "dbId", "getDbId", "()I", "setDbId", "(I)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "fileList", "Ljava/util/ArrayList;", "Lcom/tencent/bugly/common/reporter/data/FileInfo;", "Lkotlin/collections/ArrayList;", "getParams", "()Lorg/json/JSONObject;", "setParams", "(Lorg/json/JSONObject;)V", "reportStrategy", "Lcom/tencent/bugly/common/reporter/data/ReportStrategy;", "getReportStrategy", "()Lcom/tencent/bugly/common/reporter/data/ReportStrategy;", "getReportType", "setReportType", "shouldRecordLinkData", "", "getShouldRecordLinkData", "()Z", "setShouldRecordLinkData", "(Z)V", "getUin", "setUin", "uploadFilePath", "addFile", "", "filePath", "delWhenSuccess", "delWhenFail", "checkAndDelFiles", "isSuccess", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "getAttachment", "getPluginName", "getUploadFilePath", "hashCode", "isCurLaunchData", "toString", "updateAttachment", FileUploadBase.ATTACHMENT, "zipUploadFile", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final /* data */ class ReportData extends BaseJsonObject {
    private AttachmentInfo attachmentInfo;
    private int dbId;

    @NotNull
    private String eventName;
    private final ArrayList<FileInfo> fileList;

    @NotNull
    private JSONObject params;

    @NotNull
    private final ReportStrategy reportStrategy;
    private int reportType;
    private boolean shouldRecordLinkData;

    @NotNull
    private String uin;
    private String uploadFilePath;

    public ReportData() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ ReportData copy$default(ReportData reportData, String str, int i3, String str2, JSONObject jSONObject, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = reportData.uin;
        }
        if ((i16 & 2) != 0) {
            i3 = reportData.reportType;
        }
        if ((i16 & 4) != 0) {
            str2 = reportData.eventName;
        }
        if ((i16 & 8) != 0) {
            jSONObject = reportData.params;
        }
        return reportData.copy(str, i3, str2, jSONObject);
    }

    private final String zipUploadFile() {
        Sequence asSequence;
        Sequence map;
        List<String> list;
        FileUtil.Companion companion = FileUtil.INSTANCE;
        File file = new File(companion.getTempPath(), FileUtil.Companion.makeTempFileName$default(companion, null, null, 3, null));
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.fileList);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1<FileInfo, String>() { // from class: com.tencent.bugly.common.reporter.data.ReportData$zipUploadFile$allFiles$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull FileInfo it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.getFilePath();
            }
        });
        list = SequencesKt___SequencesKt.toList(map);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "temp.absolutePath");
        if (companion.zipFiles(list, absolutePath, false)) {
            String absolutePath2 = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath2, "temp.absolutePath");
            return absolutePath2;
        }
        companion.deleteFile(file);
        return "";
    }

    public final void addFile(@NotNull String filePath, boolean delWhenSuccess, boolean delWhenFail) throws IllegalStateException {
        boolean z16;
        List<String> filesInDir;
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        boolean z17 = true;
        if (this.uploadFilePath.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            File file = new File(filePath);
            if (filePath.length() != 0) {
                z17 = false;
            }
            if (!z17 && file.exists()) {
                if (file.isFile()) {
                    this.fileList.add(new FileInfo(filePath, delWhenSuccess, delWhenFail));
                    return;
                } else {
                    if (file.isDirectory() && (filesInDir = FileUtil.INSTANCE.getFilesInDir(filePath)) != null) {
                        Iterator<T> it = filesInDir.iterator();
                        while (it.hasNext()) {
                            this.fileList.add(new FileInfo((String) it.next(), delWhenSuccess, delWhenFail));
                        }
                        return;
                    }
                    return;
                }
            }
            return;
        }
        throw new IllegalStateException("can not add file[" + filePath + "] after call getUploadFilePath");
    }

    public final void checkAndDelFiles(boolean isSuccess) {
        boolean z16 = true;
        if (this.fileList.size() > 1) {
            if (this.uploadFilePath.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                FileUtil.INSTANCE.deleteFile(new File(this.uploadFilePath));
            }
        }
        int size = this.fileList.size();
        for (int i3 = 0; i3 < size; i3++) {
            FileInfo fileInfo = this.fileList.get(i3);
            Intrinsics.checkExpressionValueIsNotNull(fileInfo, "fileList[i]");
            FileInfo fileInfo2 = fileInfo;
            if (isSuccess && fileInfo2.getDelWhenSuccess()) {
                FileUtil.INSTANCE.deleteFile(new File(fileInfo2.getFilePath()));
            } else if (!isSuccess && fileInfo2.getDelWhenFail()) {
                FileUtil.INSTANCE.deleteFile(new File(fileInfo2.getFilePath()));
            }
        }
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final int getReportType() {
        return this.reportType;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final JSONObject getParams() {
        return this.params;
    }

    @NotNull
    public final ReportData copy(@NotNull String uin, int reportType, @NotNull String eventName, @NotNull JSONObject params) {
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(params, "params");
        return new ReportData(uin, reportType, eventName, params);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (this != other) {
            if (other instanceof ReportData) {
                ReportData reportData = (ReportData) other;
                if (Intrinsics.areEqual(this.uin, reportData.uin)) {
                    if (this.reportType == reportData.reportType) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 || !Intrinsics.areEqual(this.eventName, reportData.eventName) || !Intrinsics.areEqual(this.params, reportData.params)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: getAttachment, reason: from getter */
    public final AttachmentInfo getAttachmentInfo() {
        return this.attachmentInfo;
    }

    public final int getDbId() {
        return this.dbId;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    @NotNull
    public final JSONObject getParams() {
        return this.params;
    }

    @NotNull
    public final String getPluginName() {
        String pluginNameFromParam = ReportDataBuilder.getPluginNameFromParam(this.params);
        Intrinsics.checkExpressionValueIsNotNull(pluginNameFromParam, "ReportDataBuilder.getPluginNameFromParam(params)");
        return pluginNameFromParam;
    }

    @NotNull
    public final ReportStrategy getReportStrategy() {
        return this.reportStrategy;
    }

    public final int getReportType() {
        return this.reportType;
    }

    public final boolean getShouldRecordLinkData() {
        return this.shouldRecordLinkData;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }

    @NotNull
    public final String getUploadFilePath() {
        boolean z16;
        String zipUploadFile;
        boolean endsWith$default;
        if (this.uploadFilePath.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return this.uploadFilePath;
        }
        if (this.fileList.isEmpty()) {
            zipUploadFile = "";
        } else {
            if (this.reportType == 1 && this.fileList.size() == 1) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(this.fileList.get(0).getFilePath(), ".zip", false, 2, null);
                if (endsWith$default) {
                    zipUploadFile = this.fileList.get(0).getFilePath();
                }
            }
            zipUploadFile = zipUploadFile();
        }
        this.uploadFilePath = zipUploadFile;
        return zipUploadFile;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.uin;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = ((i3 * 31) + this.reportType) * 31;
        String str2 = this.eventName;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        JSONObject jSONObject = this.params;
        if (jSONObject != null) {
            i17 = jSONObject.hashCode();
        }
        return i19 + i17;
    }

    public final boolean isCurLaunchData() {
        return TextUtils.equals(TraceGenerator.getProcessLaunchId(), ReportDataBuilder.getProcessLaunchIdFromParam(this.params));
    }

    public final void setDbId(int i3) {
        this.dbId = i3;
    }

    public final void setEventName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.eventName = str;
    }

    public final void setParams(@NotNull JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "<set-?>");
        this.params = jSONObject;
    }

    public final void setReportType(int i3) {
        this.reportType = i3;
    }

    public final void setShouldRecordLinkData(boolean z16) {
        this.shouldRecordLinkData = z16;
    }

    public final void setUin(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.uin = str;
    }

    @NotNull
    public String toString() {
        return "ReportData(uin=" + this.uin + ", reportType=" + this.reportType + ", eventName=" + this.eventName + ", params=" + this.params + ")";
    }

    public final void updateAttachment(@NotNull AttachmentInfo attachment) {
        Intrinsics.checkParameterIsNotNull(attachment, "attachment");
        this.attachmentInfo = attachment;
    }

    public /* synthetic */ ReportData(String str, int i3, String str2, JSONObject jSONObject, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN : str, (i16 & 2) != 0 ? 1 : i3, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? new JSONObject() : jSONObject);
    }

    public ReportData(@NotNull String uin, int i3, @NotNull String eventName, @NotNull JSONObject params) {
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(params, "params");
        this.uin = uin;
        this.reportType = i3;
        this.eventName = eventName;
        this.params = params;
        this.fileList = new ArrayList<>();
        this.reportStrategy = new ReportStrategy();
        this.uploadFilePath = "";
    }
}
