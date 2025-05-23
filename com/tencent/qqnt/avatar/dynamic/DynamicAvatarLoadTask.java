package com.tencent.qqnt.avatar.dynamic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.meta.TaskTracker;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoRequestManager;
import com.tencent.qqnt.avatar.meta.request.c;
import com.tencent.qqnt.avatar.meta.resource.AvatarResourceManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wv3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0002$\u0015B\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0004\b!\u0010\"J/\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u000eJ\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/avatar/dynamic/DynamicAvatarLoadTask;", "Lcom/tencent/qqnt/avatar/meta/task/a;", "Lwv3/a;", "listener", "Landroid/content/Context;", "context", "", "url", "Ljava/io/File;", h.F, "(Lwv3/a;Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "i", "(Lwv3/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "(Lwv3/a;Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/avatar/meta/task/b;", "c", "result", "", "b", "Lcom/tencent/qqnt/avatar/meta/request/c;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/qqnt/avatar/meta/request/c;", "loadRequest", "Lcom/tencent/qqnt/avatar/meta/a;", "Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "Lcom/tencent/qqnt/avatar/meta/TaskTracker;", "d", "Lcom/tencent/qqnt/avatar/meta/TaskTracker;", "taskTracker", "<init>", "(Lcom/tencent/qqnt/avatar/meta/request/c;)V", "e", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class DynamicAvatarLoadTask extends com.tencent.qqnt.avatar.meta.task.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c<Drawable> loadRequest;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.meta.a avatarBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TaskTracker taskTracker;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/dynamic/DynamicAvatarLoadTask$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.dynamic.DynamicAvatarLoadTask$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/avatar/dynamic/DynamicAvatarLoadTask$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "filePath", "dynamicType", "c", "I", "()I", "size", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String filePath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String dynamicType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int size;

        public b(@NotNull String filePath, @NotNull String dynamicType, int i3) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(dynamicType, "dynamicType");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, filePath, dynamicType, Integer.valueOf(i3));
                return;
            }
            this.filePath = filePath;
            this.dynamicType = dynamicType;
            this.size = i3;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.dynamicType;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.filePath;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.size;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.filePath, bVar.filePath) && Intrinsics.areEqual(this.dynamicType, bVar.dynamicType) && this.size == bVar.size) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.filePath.hashCode() * 31) + this.dynamicType.hashCode()) * 31) + this.size;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "DynamicAvatarInfo(filePath=" + this.filePath + ", dynamicType=" + this.dynamicType + ", size=" + this.size + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39405);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicAvatarLoadTask(@NotNull c<Drawable> loadRequest) {
        super(loadRequest.a().d());
        Intrinsics.checkNotNullParameter(loadRequest, "loadRequest");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) loadRequest);
            return;
        }
        this.loadRequest = loadRequest;
        com.tencent.qqnt.avatar.meta.a a16 = loadRequest.a();
        this.avatarBean = a16;
        this.taskTracker = new TaskTracker("DynamicAvatarLoadTask", a16.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(wv3.a aVar, String str, Context context, Continuation<? super File> continuation) {
        DynamicAvatarLoadTask$downloadFile$1 dynamicAvatarLoadTask$downloadFile$1;
        Object coroutine_suspended;
        int i3;
        DynamicAvatarLoadTask dynamicAvatarLoadTask;
        if (continuation instanceof DynamicAvatarLoadTask$downloadFile$1) {
            dynamicAvatarLoadTask$downloadFile$1 = (DynamicAvatarLoadTask$downloadFile$1) continuation;
            int i16 = dynamicAvatarLoadTask$downloadFile$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                dynamicAvatarLoadTask$downloadFile$1.label = i16 - Integer.MIN_VALUE;
                Object obj = dynamicAvatarLoadTask$downloadFile$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = dynamicAvatarLoadTask$downloadFile$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        aVar = (wv3.a) dynamicAvatarLoadTask$downloadFile$1.L$1;
                        dynamicAvatarLoadTask = (DynamicAvatarLoadTask) dynamicAvatarLoadTask$downloadFile$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (aVar != null) {
                        a.C11512a.a(aVar, null, 1, null);
                    }
                    AvatarResourceManager avatarResourceManager = AvatarResourceManager.f352954a;
                    dynamicAvatarLoadTask$downloadFile$1.L$0 = this;
                    dynamicAvatarLoadTask$downloadFile$1.L$1 = aVar;
                    dynamicAvatarLoadTask$downloadFile$1.label = 1;
                    obj = avatarResourceManager.d(str, context, dynamicAvatarLoadTask$downloadFile$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dynamicAvatarLoadTask = this;
                }
                File file = (File) obj;
                if (aVar != null) {
                    aVar.a(dynamicAvatarLoadTask.a());
                }
                return file;
            }
        }
        dynamicAvatarLoadTask$downloadFile$1 = new DynamicAvatarLoadTask$downloadFile$1(this, continuation);
        Object obj2 = dynamicAvatarLoadTask$downloadFile$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = dynamicAvatarLoadTask$downloadFile$1.label;
        if (i3 == 0) {
        }
        File file2 = (File) obj2;
        if (aVar != null) {
        }
        return file2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(wv3.a aVar, Context context, String str, Continuation<? super File> continuation) {
        DynamicAvatarLoadTask$getFile$1 dynamicAvatarLoadTask$getFile$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        DynamicAvatarLoadTask dynamicAvatarLoadTask;
        File file;
        boolean z17;
        if (continuation instanceof DynamicAvatarLoadTask$getFile$1) {
            dynamicAvatarLoadTask$getFile$1 = (DynamicAvatarLoadTask$getFile$1) continuation;
            int i16 = dynamicAvatarLoadTask$getFile$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                dynamicAvatarLoadTask$getFile$1.label = i16 - Integer.MIN_VALUE;
                Object obj = dynamicAvatarLoadTask$getFile$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = dynamicAvatarLoadTask$getFile$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        dynamicAvatarLoadTask = (DynamicAvatarLoadTask) dynamicAvatarLoadTask$getFile$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    File h16 = AvatarResourceManager.f352954a.h(str, context);
                    if (h16 != null && h16.exists()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.taskTracker.b("getFileInDisk end");
                        return h16;
                    }
                    dynamicAvatarLoadTask$getFile$1.L$0 = this;
                    dynamicAvatarLoadTask$getFile$1.label = 1;
                    obj = g(aVar, str, context, dynamicAvatarLoadTask$getFile$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dynamicAvatarLoadTask = this;
                }
                file = (File) obj;
                if (file == null && file.exists()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    TaskTracker.d(dynamicAvatarLoadTask.taskTracker, true, null, 2, null);
                    return file;
                }
                TaskTracker.d(dynamicAvatarLoadTask.taskTracker, false, null, 2, null);
                return null;
            }
        }
        dynamicAvatarLoadTask$getFile$1 = new DynamicAvatarLoadTask$getFile$1(this, continuation);
        Object obj2 = dynamicAvatarLoadTask$getFile$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = dynamicAvatarLoadTask$getFile$1.label;
        if (i3 == 0) {
        }
        file = (File) obj2;
        if (file == null) {
        }
        z17 = false;
        if (!z17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(wv3.a aVar, Continuation<? super com.tencent.qqnt.avatar.meta.info.a[]> continuation) {
        DynamicAvatarLoadTask$getInfoArr$1 dynamicAvatarLoadTask$getInfoArr$1;
        Object coroutine_suspended;
        int i3;
        DynamicAvatarLoadTask dynamicAvatarLoadTask;
        boolean z16;
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr;
        if (continuation instanceof DynamicAvatarLoadTask$getInfoArr$1) {
            dynamicAvatarLoadTask$getInfoArr$1 = (DynamicAvatarLoadTask$getInfoArr$1) continuation;
            int i16 = dynamicAvatarLoadTask$getInfoArr$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                dynamicAvatarLoadTask$getInfoArr$1.label = i16 - Integer.MIN_VALUE;
                DynamicAvatarLoadTask$getInfoArr$1 dynamicAvatarLoadTask$getInfoArr$12 = dynamicAvatarLoadTask$getInfoArr$1;
                Object obj = dynamicAvatarLoadTask$getInfoArr$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = dynamicAvatarLoadTask$getInfoArr$12.label;
                Integer num = null;
                if (i3 == 0) {
                    if (i3 == 1) {
                        aVar = (wv3.a) dynamicAvatarLoadTask$getInfoArr$12.L$1;
                        dynamicAvatarLoadTask = (DynamicAvatarLoadTask) dynamicAvatarLoadTask$getInfoArr$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AvatarInfoRequestManager avatarInfoRequestManager = AvatarInfoRequestManager.f352916a;
                    com.tencent.qqnt.avatar.meta.info.a[] h16 = avatarInfoRequestManager.h(this.avatarBean);
                    if (h16 != null) {
                        if (h16.length == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            this.taskTracker.b("getAvatarInfoFromCache end size:" + h16.length);
                            return h16;
                        }
                    }
                    if (aVar != null) {
                        a.C11512a.a(aVar, null, 1, null);
                    }
                    com.tencent.qqnt.avatar.meta.a aVar2 = this.avatarBean;
                    dynamicAvatarLoadTask$getInfoArr$12.L$0 = this;
                    dynamicAvatarLoadTask$getInfoArr$12.L$1 = aVar;
                    dynamicAvatarLoadTask$getInfoArr$12.label = 1;
                    obj = AvatarInfoRequestManager.g(avatarInfoRequestManager, aVar2, false, dynamicAvatarLoadTask$getInfoArr$12, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dynamicAvatarLoadTask = this;
                }
                aVarArr = (com.tencent.qqnt.avatar.meta.info.a[]) obj;
                TaskTracker taskTracker = dynamicAvatarLoadTask.taskTracker;
                if (aVarArr != null) {
                    num = Boxing.boxInt(aVarArr.length);
                }
                taskTracker.b("asyncGetAvatarInfo end size:" + num);
                if (aVar != null) {
                    aVar.a(dynamicAvatarLoadTask.a());
                }
                return aVarArr;
            }
        }
        dynamicAvatarLoadTask$getInfoArr$1 = new DynamicAvatarLoadTask$getInfoArr$1(this, continuation);
        DynamicAvatarLoadTask$getInfoArr$1 dynamicAvatarLoadTask$getInfoArr$122 = dynamicAvatarLoadTask$getInfoArr$1;
        Object obj2 = dynamicAvatarLoadTask$getInfoArr$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = dynamicAvatarLoadTask$getInfoArr$122.label;
        Integer num2 = null;
        if (i3 == 0) {
        }
        aVarArr = (com.tencent.qqnt.avatar.meta.info.a[]) obj2;
        TaskTracker taskTracker2 = dynamicAvatarLoadTask.taskTracker;
        if (aVarArr != null) {
        }
        taskTracker2.b("asyncGetAvatarInfo end size:" + num2);
        if (aVar != null) {
        }
        return aVarArr;
    }

    @Override // com.tencent.qqnt.avatar.meta.task.a
    public void b(@Nullable com.tencent.qqnt.avatar.meta.task.b result) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) result);
            return;
        }
        String str = null;
        Drawable drawable = null;
        if (result != null && result.b() && (result.a() instanceof b)) {
            b bVar = (b) result.a();
            com.tencent.qqnt.avatar.dynamic.drawable.a a16 = com.tencent.qqnt.avatar.dynamic.drawable.b.f352782a.a(bVar.a());
            if (a16 != null) {
                drawable = a16.a(bVar.a(), bVar.b(), bVar.c(), bVar.c());
            }
            if (drawable != null) {
                this.loadRequest.c().onLoadFinish(drawable);
                return;
            } else {
                this.loadRequest.c().onFail("create drawable fail");
                return;
            }
        }
        if (result != null) {
            obj = result.a();
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (str == null) {
            str = "";
        }
        this.loadRequest.c().onFail(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x005b  */
    @Override // com.tencent.qqnt.avatar.meta.task.a
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(@Nullable wv3.a aVar, @NotNull Continuation<? super com.tencent.qqnt.avatar.meta.task.b> continuation) {
        DynamicAvatarLoadTask$start$1 dynamicAvatarLoadTask$start$1;
        Object coroutine_suspended;
        int i3;
        DynamicAvatarLoadTask dynamicAvatarLoadTask;
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr;
        Context context;
        DynamicAvatarLoadTask dynamicAvatarLoadTask2;
        String str;
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) continuation);
        }
        if (continuation instanceof DynamicAvatarLoadTask$start$1) {
            dynamicAvatarLoadTask$start$1 = (DynamicAvatarLoadTask$start$1) continuation;
            int i16 = dynamicAvatarLoadTask$start$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                dynamicAvatarLoadTask$start$1.label = i16 - Integer.MIN_VALUE;
                Object obj = dynamicAvatarLoadTask$start$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = dynamicAvatarLoadTask$start$1.label;
                boolean z16 = true;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            str = (String) dynamicAvatarLoadTask$start$1.L$1;
                            dynamicAvatarLoadTask2 = (DynamicAvatarLoadTask) dynamicAvatarLoadTask$start$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            file = (File) obj;
                            if (file != null) {
                                return new com.tencent.qqnt.avatar.meta.task.b(false, null);
                            }
                            String path = file.getAbsolutePath();
                            dynamicAvatarLoadTask2.taskTracker.b("file path=" + path);
                            int e16 = dynamicAvatarLoadTask2.avatarBean.e();
                            Intrinsics.checkNotNullExpressionValue(path, "path");
                            return new com.tencent.qqnt.avatar.meta.task.b(file.exists(), new b(path, str, e16));
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (wv3.a) dynamicAvatarLoadTask$start$1.L$1;
                    dynamicAvatarLoadTask = (DynamicAvatarLoadTask) dynamicAvatarLoadTask$start$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.taskTracker.b("start");
                    dynamicAvatarLoadTask$start$1.L$0 = this;
                    dynamicAvatarLoadTask$start$1.L$1 = aVar;
                    dynamicAvatarLoadTask$start$1.label = 1;
                    obj = i(aVar, dynamicAvatarLoadTask$start$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dynamicAvatarLoadTask = this;
                }
                aVarArr = (com.tencent.qqnt.avatar.meta.info.a[]) obj;
                if (aVarArr == null && aVarArr.length == 1) {
                    if (aVarArr[0].e()) {
                        String a16 = aVarArr[0].a();
                        if (a16 != null && a16.length() != 0) {
                            z16 = false;
                        }
                        if (!z16) {
                            String c16 = aVarArr[0].c();
                            String a17 = aVarArr[0].a();
                            Intrinsics.checkNotNull(a17);
                            dynamicAvatarLoadTask.taskTracker.b("dynamic url=" + c16);
                            Context b16 = dynamicAvatarLoadTask.loadRequest.b();
                            if (b16 != null) {
                                context = b16.getApplicationContext();
                            } else {
                                context = null;
                            }
                            if (context == null) {
                                dynamicAvatarLoadTask.taskTracker.b("context is null");
                                TaskTracker.d(dynamicAvatarLoadTask.taskTracker, false, null, 2, null);
                                return new com.tencent.qqnt.avatar.meta.task.b(false, null);
                            }
                            dynamicAvatarLoadTask$start$1.L$0 = dynamicAvatarLoadTask;
                            dynamicAvatarLoadTask$start$1.L$1 = a17;
                            dynamicAvatarLoadTask$start$1.label = 2;
                            Object h16 = dynamicAvatarLoadTask.h(aVar, context, c16, dynamicAvatarLoadTask$start$1);
                            if (h16 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            dynamicAvatarLoadTask2 = dynamicAvatarLoadTask;
                            obj = h16;
                            str = a17;
                            file = (File) obj;
                            if (file != null) {
                            }
                        }
                    }
                    dynamicAvatarLoadTask.taskTracker.b("notDynamicAvatar");
                    TaskTracker.d(dynamicAvatarLoadTask.taskTracker, false, null, 2, null);
                    return new com.tencent.qqnt.avatar.meta.task.b(false, null);
                }
                TaskTracker.d(dynamicAvatarLoadTask.taskTracker, false, null, 2, null);
                return new com.tencent.qqnt.avatar.meta.task.b(false, null);
            }
        }
        dynamicAvatarLoadTask$start$1 = new DynamicAvatarLoadTask$start$1(this, continuation);
        Object obj2 = dynamicAvatarLoadTask$start$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = dynamicAvatarLoadTask$start$1.label;
        boolean z162 = true;
        if (i3 == 0) {
        }
        aVarArr = (com.tencent.qqnt.avatar.meta.info.a[]) obj2;
        if (aVarArr == null) {
        }
        TaskTracker.d(dynamicAvatarLoadTask.taskTracker, false, null, 2, null);
        return new com.tencent.qqnt.avatar.meta.task.b(false, null);
    }
}
