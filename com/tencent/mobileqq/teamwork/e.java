package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.teamwork.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/teamwork/e;", "Lcom/tencent/mobileqq/teamwork/f;", "Lcom/tencent/mobileqq/teamwork/OpenDocsPerformanceRecorder;", "b", "", "getFilePath", "", "getFileSize", "getFileName", "Lcom/tencent/mobileqq/teamwork/e$a;", "a", "Lcom/tencent/mobileqq/teamwork/e$a;", "fileInfoGetter", "Lcom/tencent/mobileqq/teamwork/OpenDocsPerformanceRecorder;", "recorder", "<init>", "(Lcom/tencent/mobileqq/teamwork/e$a;)V", "tencentdoc-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a fileInfoGetter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OpenDocsPerformanceRecorder recorder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/teamwork/e$a;", "", "", "getFilePath", "", "getFileSize", "getFileName", "tencentdoc-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface a {
        @NotNull
        String getFileName();

        @NotNull
        String getFilePath();

        long getFileSize();
    }

    public e(@NotNull a fileInfoGetter) {
        Intrinsics.checkNotNullParameter(fileInfoGetter, "fileInfoGetter");
        this.fileInfoGetter = fileInfoGetter;
        this.recorder = new OpenDocsPerformanceRecorder();
    }

    @Override // com.tencent.mobileqq.teamwork.f
    public void a(@NotNull String str, int i3, long j3, int i16, @NotNull String str2, @NotNull String str3) {
        f.a.b(this, str, i3, j3, i16, str2, str3);
    }

    @Override // com.tencent.mobileqq.teamwork.f
    @NotNull
    /* renamed from: b, reason: from getter */
    public OpenDocsPerformanceRecorder getRecorder() {
        return this.recorder;
    }

    public void c(@NotNull String str, int i3, long j3, int i16, @NotNull String str2) {
        f.a.a(this, str, i3, j3, i16, str2);
    }

    public void d() {
        f.a.c(this);
    }

    @Override // com.tencent.mobileqq.teamwork.f
    @NotNull
    public String getFileName() {
        return this.fileInfoGetter.getFileName();
    }

    @Override // com.tencent.mobileqq.teamwork.f
    @NotNull
    public String getFilePath() {
        return this.fileInfoGetter.getFilePath();
    }

    @Override // com.tencent.mobileqq.teamwork.f
    public long getFileSize() {
        return this.fileInfoGetter.getFileSize();
    }
}
