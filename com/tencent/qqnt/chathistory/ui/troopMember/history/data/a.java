package com.tencent.qqnt.chathistory.ui.troopMember.history.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/a;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "b", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/a$a;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/a$b;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/a$a;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/a;", "", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "data", "<init>", "(Ljava/util/List;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.troopMember.history.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9557a extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9557a(@NotNull List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) data);
            } else {
                this.data = data;
            }
        }

        @NotNull
        public final List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.data;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/a$b;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/a;", "", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "data", "<init>", "(Ljava/util/List;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) data);
            } else {
                this.data = data;
            }
        }

        @NotNull
        public final List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.data;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
