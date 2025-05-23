package com.tencent.ecommerce.biz.comment;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "state", "", "onStateChanged", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface UploadStateListener {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\b\t\n\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "", "", "a", "Ljava/lang/String;", "filePath", "<init>", "(Ljava/lang/String;)V", "b", "c", "d", "e", "f", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$e;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$d;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$f;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$a;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$c;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$b;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String filePath;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$a;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "", "filePath", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.comment.UploadStateListener$a$a, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C1045a extends a {
            public C1045a(String str) {
                super(str, null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$b;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "", "b", "I", "errCode", "", "c", "Ljava/lang/String;", "errMsg", "filePath", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class b extends a {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final int errCode;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            public final String errMsg;

            public b(String str, int i3, String str2) {
                super(str, null);
                this.errCode = i3;
                this.errMsg = str2;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$c;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "", "filePath", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class c extends a {
            public c(String str) {
                super(str, null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$d;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "", "b", UserInfo.SEX_FEMALE, "progress", "", "filePath", "<init>", "(Ljava/lang/String;F)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class d extends a {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final float progress;

            public d(String str, float f16) {
                super(str, null);
                this.progress = f16;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$e;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "", "filePath", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class e extends a {
            public e(String str) {
                super(str, null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$f;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "", "b", "Ljava/lang/String;", "url", "filePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class f extends a {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final String url;

            public f(String str, String str2) {
                super(str, null);
                this.url = str2;
            }
        }

        a(String str) {
            this.filePath = str;
        }

        public /* synthetic */ a(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    void onStateChanged(a state);
}
