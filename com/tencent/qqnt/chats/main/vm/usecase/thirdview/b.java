package com.tencent.qqnt.chats.main.vm.usecase.thirdview;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/b;", "", "Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/b$a;", "params", "", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "b", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR%\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/b$a;", "", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "b", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "()Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "viewType", "", "", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "extra", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;Ljava/util/Map;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ThirdViewEnum viewType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Map<String, Object> extra;

        public a(@NotNull Context context, @NotNull ThirdViewEnum viewType, @Nullable Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewType, "viewType");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, viewType, map);
                return;
            }
            this.context = context;
            this.viewType = viewType;
            this.extra = map;
        }

        @Nullable
        public final Map<String, Object> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.extra;
        }

        @NotNull
        public final ThirdViewEnum b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ThirdViewEnum) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.viewType;
        }
    }

    boolean a(@NotNull a params);

    @Nullable
    com.tencent.qqnt.chats.main.vm.usecase.result.a b(@NotNull a params);
}
