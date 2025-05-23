package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/networkhandler/d;", "", "", "filePath", "Lcom/tencent/mobileqq/onlinestatus/networkhandler/d$a;", "a", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f256083a = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0003\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/networkhandler/d$a;", "", "", "a", "[B", "c", "()[B", "md5", "b", "d", "sha1", "", "J", "()J", "fileSize", "", "Ljava/lang/String;", "()Ljava/lang/String;", TagName.FILE_TYPE, "<init>", "([B[BJLjava/lang/String;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final byte[] md5;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final byte[] sha1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long fileSize;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String fileType;

        public a(@NotNull byte[] md5, @NotNull byte[] sha1, long j3, @NotNull String fileType) {
            Intrinsics.checkNotNullParameter(md5, "md5");
            Intrinsics.checkNotNullParameter(sha1, "sha1");
            Intrinsics.checkNotNullParameter(fileType, "fileType");
            this.md5 = md5;
            this.sha1 = sha1;
            this.fileSize = j3;
            this.fileType = fileType;
        }

        /* renamed from: a, reason: from getter */
        public final long getFileSize() {
            return this.fileSize;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFileType() {
            return this.fileType;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final byte[] getMd5() {
            return this.md5;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final byte[] getSha1() {
            return this.sha1;
        }
    }

    d() {
    }

    @Nullable
    public final a a(@NotNull String filePath) {
        String extension;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            try {
                File file = new File(filePath);
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                MessageDigest messageDigest2 = MessageDigest.getInstance("SHA1");
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read < 0) {
                        byte[] digest = messageDigest.digest();
                        Intrinsics.checkNotNullExpressionValue(digest, "md5.digest()");
                        byte[] digest2 = messageDigest2.digest();
                        Intrinsics.checkNotNullExpressionValue(digest2, "sha1.digest()");
                        long length = file.length();
                        extension = FilesKt__UtilsKt.getExtension(file);
                        a aVar = new a(digest, digest2, length, extension);
                        CloseableKt.closeFinally(fileInputStream, null);
                        return aVar;
                    }
                    messageDigest.update(bArr, 0, read);
                    messageDigest2.update(bArr, 0, read);
                }
            } finally {
            }
        } catch (Exception e16) {
            QLog.i("FileUtility", 1, "[getFileInfo] fail, path=" + filePath + ", exc=" + e16);
            return null;
        }
    }
}
