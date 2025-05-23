package com.tencent.mobileqq.troop.file.main.vm;

import android.app.Activity;
import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.q;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/b;", "Lcom/tencent/qqnt/base/mvi/b;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "i", "Lcom/tencent/mobileqq/troop/file/main/vm/b$a;", "Lcom/tencent/mobileqq/troop/file/main/vm/b$b;", "Lcom/tencent/mobileqq/troop/file/main/vm/b$c;", "Lcom/tencent/mobileqq/troop/file/main/vm/b$d;", "Lcom/tencent/mobileqq/troop/file/main/vm/b$e;", "Lcom/tencent/mobileqq/troop/file/main/vm/b$f;", "Lcom/tencent/mobileqq/troop/file/main/vm/b$g;", "Lcom/tencent/mobileqq/troop/file/main/vm/b$h;", "Lcom/tencent/mobileqq/troop/file/main/vm/b$i;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class b implements com.tencent.qqnt.base.mvi.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/b$a;", "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String name) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/b$b;", "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "Lcom/tencent/mobileqq/troop/data/n;", "a", "Lcom/tencent/mobileqq/troop/data/n;", "()Lcom/tencent/mobileqq/troop/data/n;", "fileInfo", "<init>", "(Lcom/tencent/mobileqq/troop/data/n;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.file.main.vm.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C8685b extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final n fileInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8685b(n fileInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
            this.fileInfo = fileInfo;
        }

        /* renamed from: a, reason: from getter */
        public final n getFileInfo() {
            return this.fileInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/b$c;", "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "Landroid/content/Intent;", "a", "Landroid/content/Intent;", "()Landroid/content/Intent;", "data", "<init>", "(Landroid/content/Intent;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Intent data;

        /* renamed from: a, reason: from getter */
        public final Intent getData() {
            return this.data;
        }

        public c(Intent intent) {
            super(null);
            this.data = intent;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/b$d;", "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        public static final d f295647a = new d();

        d() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/b$e;", "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        public static final e f295648a = new e();

        e() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/b$f;", "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f extends b {

        /* renamed from: a, reason: collision with root package name */
        public static final f f295649a = new f();

        f() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/b$g;", "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "Lcom/tencent/mobileqq/troop/data/q;", "a", "Lcom/tencent/mobileqq/troop/data/q;", "b", "()Lcom/tencent/mobileqq/troop/data/q;", "observer", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle;", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "<init>", "(Lcom/tencent/mobileqq/troop/data/q;Landroidx/lifecycle/Lifecycle;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final q observer;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final Lifecycle lifecycle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(q observer, Lifecycle lifecycle) {
            super(null);
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            this.observer = observer;
            this.lifecycle = lifecycle;
        }

        /* renamed from: a, reason: from getter */
        public final Lifecycle getLifecycle() {
            return this.lifecycle;
        }

        /* renamed from: b, reason: from getter */
        public final q getObserver() {
            return this.observer;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/b$h;", "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "folderId", "b", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String folderId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String folderId, String name) {
            super(null);
            Intrinsics.checkNotNullParameter(folderId, "folderId");
            Intrinsics.checkNotNullParameter(name, "name");
            this.folderId = folderId;
            this.name = name;
        }

        /* renamed from: a, reason: from getter */
        public final String getFolderId() {
            return this.folderId;
        }

        /* renamed from: b, reason: from getter */
        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/b$i;", "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/util/ArrayList;", "", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "filePathList", "<init>", "(Landroid/app/Activity;Ljava/util/ArrayList;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class i extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Activity activity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final ArrayList<String> filePathList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Activity activity, ArrayList<String> filePathList) {
            super(null);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(filePathList, "filePathList");
            this.activity = activity;
            this.filePathList = filePathList;
        }

        /* renamed from: a, reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        public final ArrayList<String> b() {
            return this.filePathList;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
