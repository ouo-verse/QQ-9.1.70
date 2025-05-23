package com.tencent.mobileqq.zplan.utils;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.mobileqq.zplan.utils.w;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\n\u000b\fB\u0013\b\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/g;", "Lcom/tencent/mobileqq/zplan/utils/w;", "Lcom/tencent/component/network/downloader/DownloadResult;", "a", "Lcom/tencent/component/network/downloader/DownloadResult;", "getResult", "()Lcom/tencent/component/network/downloader/DownloadResult;", "result", "<init>", "(Lcom/tencent/component/network/downloader/DownloadResult;)V", "b", "c", "d", "Lcom/tencent/mobileqq/zplan/utils/g$b;", "Lcom/tencent/mobileqq/zplan/utils/g$c;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class g implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final DownloadResult result;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/g$a;", "Lcom/tencent/mobileqq/zplan/utils/g$c;", "Ljava/io/File;", "file", "<init>", "(Ljava/io/File;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File file) {
            super(file, null);
            Intrinsics.checkNotNullParameter(file, "file");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/g$b;", "Lcom/tencent/mobileqq/zplan/utils/g;", "Lcom/tencent/component/network/downloader/DownloadResult;", "result", "<init>", "(Lcom/tencent/component/network/downloader/DownloadResult;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static class b extends g {
        public b(DownloadResult downloadResult) {
            super(downloadResult, null);
        }

        public /* synthetic */ b(DownloadResult downloadResult, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : downloadResult);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/g$c;", "Lcom/tencent/mobileqq/zplan/utils/g;", "Lcom/tencent/mobileqq/zplan/utils/w$a;", "Ljava/io/File;", "b", "Ljava/io/File;", "a", "()Ljava/io/File;", "file", "Lcom/tencent/component/network/downloader/DownloadResult;", "result", "<init>", "(Ljava/io/File;Lcom/tencent/component/network/downloader/DownloadResult;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static class c extends g implements w.a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final File file;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(File file, DownloadResult downloadResult) {
            super(downloadResult, null);
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
        }

        /* renamed from: a, reason: from getter */
        public final File getFile() {
            return this.file;
        }
    }

    public /* synthetic */ g(DownloadResult downloadResult, DefaultConstructorMarker defaultConstructorMarker) {
        this(downloadResult);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/g$d;", "Lcom/tencent/mobileqq/zplan/utils/g$b;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static class d extends b {
        public d() {
            super(null, 1, 0 == true ? 1 : 0);
        }
    }

    g(DownloadResult downloadResult) {
        this.result = downloadResult;
    }
}
