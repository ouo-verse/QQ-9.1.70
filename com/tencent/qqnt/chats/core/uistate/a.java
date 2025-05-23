package com.tencent.qqnt.chats.core.uistate;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.ui.third.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/core/uistate/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "<init>", "()V", "a", "b", "Lcom/tencent/qqnt/chats/core/uistate/a$a;", "Lcom/tencent/qqnt/chats/core/uistate/a$b;", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a implements com.tencent.qqnt.chats.core.uistate.b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/core/uistate/a$a;", "Lcom/tencent/qqnt/chats/core/uistate/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", NotificationCompat.CATEGORY_ERROR, "b", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "<init>", "(ILjava/lang/String;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.uistate.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final /* data */ class C9591a extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int err;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String msg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9591a(int i3, @NotNull String msg2) {
            super(null);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) msg2);
            } else {
                this.err = i3;
                this.msg = msg2;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.err;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.msg;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C9591a)) {
                return false;
            }
            C9591a c9591a = (C9591a) other;
            if (this.err == c9591a.err && Intrinsics.areEqual(this.msg, c9591a.msg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.err * 31) + this.msg.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "ChatListGetFail(err=" + this.err + ", msg=" + this.msg + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001BE\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0002\u001a\u00020\u0000R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b\r\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/chats/core/uistate/a$b;", "Lcom/tencent/qqnt/chats/core/uistate/a;", "a", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "Ljava/util/List;", "d", "()Ljava/util/List;", "data", "Lcom/tencent/qqnt/chats/core/ui/third/f;", "b", "additionalView", "", "c", "Z", "e", "()Z", "fetchOld", "f", "partUpdate", "", "I", "g", "()I", "serverCount", h.F, "j", "(Z)V", "isGuildData", "Lcom/tencent/qqnt/chats/data/a;", "Lcom/tencent/qqnt/chats/data/a;", "()Lcom/tencent/qqnt/chats/data/a;", "i", "(Lcom/tencent/qqnt/chats/data/a;)V", "changeInfo", "<init>", "(Ljava/util/List;Ljava/util/List;ZZI)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static class b extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.qqnt.chats.core.adapter.itemdata.b> data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<f> additionalView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean fetchOld;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean partUpdate;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int serverCount;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean isGuildData;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.chats.data.a changeInfo;

        public b() {
            this(null, null, false, false, 0, 31, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                return;
            }
            iPatchRedirector.redirect((short) 13, (Object) this);
        }

        @NotNull
        public final b a() {
            List emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (b) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            List<com.tencent.qqnt.chats.core.adapter.itemdata.b> list = this.data;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            b bVar = new b(list, emptyList, this.fetchOld, this.partUpdate, this.serverCount);
            bVar.isGuildData = this.isGuildData;
            bVar.changeInfo = this.changeInfo;
            return bVar;
        }

        @NotNull
        public final List<f> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.additionalView;
        }

        @NotNull
        public final com.tencent.qqnt.chats.data.a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (com.tencent.qqnt.chats.data.a) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.changeInfo;
        }

        @NotNull
        public final List<com.tencent.qqnt.chats.core.adapter.itemdata.b> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.data;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.fetchOld;
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.partUpdate;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.serverCount;
        }

        public final boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return this.isGuildData;
        }

        public final void i(@NotNull com.tencent.qqnt.chats.data.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
            } else {
                Intrinsics.checkNotNullParameter(aVar, "<set-?>");
                this.changeInfo = aVar;
            }
        }

        public final void j(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            } else {
                this.isGuildData = z16;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ b(List list, List list2, boolean z16, boolean z17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(r2, r3, (i16 & 4) != 0 ? true : z16, (i16 & 8) != 0 ? false : z17, (i16 & 16) != 0 ? 0 : i3);
            List list3;
            List list4;
            List emptyList;
            List emptyList2;
            if ((i16 & 1) != 0) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                list3 = emptyList2;
            } else {
                list3 = list;
            }
            if ((i16 & 2) != 0) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                list4 = emptyList;
            } else {
                list4 = list2;
            }
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, list, list2, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> data, @NotNull List<f> additionalView, boolean z16, boolean z17, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(additionalView, "additionalView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, data, additionalView, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
                return;
            }
            this.data = data;
            this.additionalView = additionalView;
            this.fetchOld = z16;
            this.partUpdate = z17;
            this.serverCount = i3;
            this.changeInfo = new com.tencent.qqnt.chats.data.a(0, 0L, false, false, false, 31, null);
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
