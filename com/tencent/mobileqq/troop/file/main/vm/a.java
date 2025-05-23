package com.tencent.mobileqq.troop.file.main.vm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/a;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "Lcom/tencent/mobileqq/troop/file/main/vm/a$a;", "Lcom/tencent/mobileqq/troop/file/main/vm/a$b;", "Lcom/tencent/mobileqq/troop/file/main/vm/a$c;", "Lcom/tencent/mobileqq/troop/file/main/vm/a$d;", "Lcom/tencent/mobileqq/troop/file/main/vm/a$e;", "Lcom/tencent/mobileqq/troop/file/main/vm/a$f;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/a$a;", "Lcom/tencent/mobileqq/troop/file/main/vm/a;", "", "a", "Z", "c", "()Z", "isSuccess", "", "b", "I", "()I", "errorCode", "", "Ljava/lang/String;", "()Ljava/lang/String;", "fileId", "<init>", "(ZILjava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.file.main.vm.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C8684a extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int errorCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String fileId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8684a(boolean z16, int i3, String fileId) {
            super(null);
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            this.isSuccess = z16;
            this.errorCode = i3;
            this.fileId = fileId;
        }

        /* renamed from: a, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: b, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/a$b;", "Lcom/tencent/mobileqq/troop/file/main/vm/a;", "", "a", "Z", "c", "()Z", "isSuccess", "", "b", "I", "()I", "errorCode", "", "Ljava/lang/String;", "()Ljava/lang/String;", "fileId", "<init>", "(ZILjava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int errorCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String fileId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z16, int i3, String fileId) {
            super(null);
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            this.isSuccess = z16;
            this.errorCode = i3;
            this.fileId = fileId;
        }

        /* renamed from: a, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: b, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/a$c;", "Lcom/tencent/mobileqq/troop/file/main/vm/a;", "Lks2/c;", "a", "Lks2/c;", "()Lks2/c;", "model", "<init>", "(Lks2/c;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ks2.c model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ks2.c model) {
            super(null);
            Intrinsics.checkNotNullParameter(model, "model");
            this.model = model;
        }

        /* renamed from: a, reason: from getter */
        public final ks2.c getModel() {
            return this.model;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/a$d;", "Lcom/tencent/mobileqq/troop/file/main/vm/a;", "", "a", "[I", "()[I", "uploadCount", "<init>", "([I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int[] uploadCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int[] uploadCount) {
            super(null);
            Intrinsics.checkNotNullParameter(uploadCount, "uploadCount");
            this.uploadCount = uploadCount;
        }

        /* renamed from: a, reason: from getter */
        public final int[] getUploadCount() {
            return this.uploadCount;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/a$e;", "Lcom/tencent/mobileqq/troop/file/main/vm/a;", "", "a", "Z", "c", "()Z", "isSuccess", "", "b", "I", "()I", "errorCode", "", "Ljava/lang/String;", "()Ljava/lang/String;", "folderId", "<init>", "(ZILjava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int errorCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String folderId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(boolean z16, int i3, String folderId) {
            super(null);
            Intrinsics.checkNotNullParameter(folderId, "folderId");
            this.isSuccess = z16;
            this.errorCode = i3;
            this.folderId = folderId;
        }

        /* renamed from: a, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: b, reason: from getter */
        public final String getFolderId() {
            return this.folderId;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/a$f;", "Lcom/tencent/mobileqq/troop/file/main/vm/a;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f extends a {

        /* renamed from: a, reason: collision with root package name */
        public static final f f295643a = new f();

        f() {
            super(null);
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
