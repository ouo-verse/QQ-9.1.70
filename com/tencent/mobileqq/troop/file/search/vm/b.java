package com.tencent.mobileqq.troop.file.search.vm;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/b;", "Lcom/tencent/qqnt/base/mvi/b;", "<init>", "()V", "a", "b", "c", "d", "e", "Lcom/tencent/mobileqq/troop/file/search/vm/b$a;", "Lcom/tencent/mobileqq/troop/file/search/vm/b$b;", "Lcom/tencent/mobileqq/troop/file/search/vm/b$c;", "Lcom/tencent/mobileqq/troop/file/search/vm/b$d;", "Lcom/tencent/mobileqq/troop/file/search/vm/b$e;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class b implements com.tencent.qqnt.base.mvi.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\u0003\u0010\fR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/b$a;", "Lcom/tencent/mobileqq/troop/file/search/vm/b;", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "fileId", "c", WadlProxyConsts.PARAM_FILENAME, "", "I", "()I", "busId", "d", "thumbnailSizeSmall", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String fileId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String fileName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int busId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int thumbnailSizeSmall;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String fileId, String fileName, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            this.fileId = fileId;
            this.fileName = fileName;
            this.busId = i3;
            this.thumbnailSizeSmall = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getBusId() {
            return this.busId;
        }

        /* renamed from: b, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: c, reason: from getter */
        public final String getFileName() {
            return this.fileName;
        }

        /* renamed from: d, reason: from getter */
        public final int getThumbnailSizeSmall() {
            return this.thumbnailSizeSmall;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/b$b;", "Lcom/tencent/mobileqq/troop/file/search/vm/b;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.file.search.vm.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C8687b extends b {

        /* renamed from: a, reason: collision with root package name */
        public static final C8687b f295683a = new C8687b();

        C8687b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/b$c;", "Lcom/tencent/mobileqq/troop/file/search/vm/b;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        public static final c f295684a = new c();

        c() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/b$d;", "Lcom/tencent/mobileqq/troop/file/search/vm/b;", "", "a", "I", "()I", "from", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int from;

        /* renamed from: a, reason: from getter */
        public final int getFrom() {
            return this.from;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/b$e;", "Lcom/tencent/mobileqq/troop/file/search/vm/b;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        public static final e f295686a = new e();

        e() {
            super(null);
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
