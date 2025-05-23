package com.tencent.qmethod.monitor.ext.remote;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qmethod.pandoraex.core.x;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020#\u00a2\u0006\u0004\b*\u0010+J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u001e\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b!\u0010\u000eR\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/remote/a;", "", "", h.F, "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setMd5", "(Ljava/lang/String;)V", "md5", "", "b", "J", "()J", "setFileSize", "(J)V", "fileSize", "c", "setFileName", WadlProxyConsts.PARAM_FILENAME, "e", "setModifyTime", "modifyTime", "setFileType", TagName.FILE_TYPE, "f", "path", "Lcom/tencent/qmethod/monitor/ext/remote/ResourceType;", "g", "Lcom/tencent/qmethod/monitor/ext/remote/ResourceType;", "()Lcom/tencent/qmethod/monitor/ext/remote/ResourceType;", "setType", "(Lcom/tencent/qmethod/monitor/ext/remote/ResourceType;)V", "type", "<init>", "(Ljava/lang/String;Lcom/tencent/qmethod/monitor/ext/remote/ResourceType;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qmethod.monitor.ext.remote.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class ResourceInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String md5;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long fileSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String fileName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long modifyTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String fileType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ResourceType type;

    public ResourceInfo(@NotNull String path, @NotNull ResourceType type) {
        String extension;
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.path = path;
        this.type = type;
        this.md5 = "";
        this.fileName = "";
        this.fileType = "";
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            this.fileSize = file.length();
            String name = file.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "file.name");
            this.fileName = name;
            extension = FilesKt__UtilsKt.getExtension(file);
            this.fileType = extension;
            this.modifyTime = file.lastModified();
        }
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: b, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFileType() {
        return this.fileType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* renamed from: e, reason: from getter */
    public final long getModifyTime() {
        return this.modifyTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ResourceInfo) {
                ResourceInfo resourceInfo = (ResourceInfo) other;
                if (!Intrinsics.areEqual(this.path, resourceInfo.path) || !Intrinsics.areEqual(this.type, resourceInfo.type)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final ResourceType getType() {
        return this.type;
    }

    public final void h() {
        String q16 = x.q(new File(this.path));
        Intrinsics.checkExpressionValueIsNotNull(q16, "Utils.getFileMD5(File(path))");
        this.md5 = q16;
    }

    public int hashCode() {
        int i3;
        String str = this.path;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        ResourceType resourceType = this.type;
        if (resourceType != null) {
            i16 = resourceType.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "ResourceInfo(path=" + this.path + ", type=" + this.type + ")";
    }
}
