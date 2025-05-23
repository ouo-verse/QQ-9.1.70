package com.tencent.qqnt.chats.core.userintent;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0010\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000f\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "p", "Lcom/tencent/qqnt/chats/core/userintent/a$a;", "Lcom/tencent/qqnt/chats/core/userintent/a$c;", "Lcom/tencent/qqnt/chats/core/userintent/a$d;", "Lcom/tencent/qqnt/chats/core/userintent/a$e;", "Lcom/tencent/qqnt/chats/core/userintent/a$f;", "Lcom/tencent/qqnt/chats/core/userintent/a$g;", "Lcom/tencent/qqnt/chats/core/userintent/a$h;", "Lcom/tencent/qqnt/chats/core/userintent/a$i;", "Lcom/tencent/qqnt/chats/core/userintent/a$j;", "Lcom/tencent/qqnt/chats/core/userintent/a$k;", "Lcom/tencent/qqnt/chats/core/userintent/a$l;", "Lcom/tencent/qqnt/chats/core/userintent/a$m;", "Lcom/tencent/qqnt/chats/core/userintent/a$n;", "Lcom/tencent/qqnt/chats/core/userintent/a$o;", "Lcom/tencent/qqnt/chats/core/userintent/a$p;", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a implements com.tencent.qqnt.chats.core.userintent.b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$a;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.userintent.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9592a extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C9592a f355047a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44033);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f355047a = new C9592a();
            }
        }

        C9592a() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "I", "()I", "jumpType", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;I)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements com.tencent.qqnt.chats.core.userintent.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final RecentContactInfo item;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int jumpType;

        public b(@Nullable RecentContactInfo recentContactInfo, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentContactInfo, i3);
            } else {
                this.item = recentContactInfo;
                this.jumpType = i3;
            }
        }

        @Nullable
        public final RecentContactInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecentContactInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.item;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.jumpType;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0010\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$c;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "c", "()I", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Z", "()Z", "loadNext", "<init>", "(ILcom/tencent/qqnt/chats/core/adapter/itemdata/g;Z)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class c extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int pos;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.qqnt.chats.core.adapter.itemdata.g item;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean loadNext;

        public c(int i3, @Nullable com.tencent.qqnt.chats.core.adapter.itemdata.g gVar, boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), gVar, Boolean.valueOf(z16));
                return;
            }
            this.pos = i3;
            this.item = gVar;
            this.loadNext = z16;
        }

        @Nullable
        public final com.tencent.qqnt.chats.core.adapter.itemdata.g a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.qqnt.chats.core.adapter.itemdata.g) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.item;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.loadNext;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.pos;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (this.pos == cVar.pos && Intrinsics.areEqual(this.item, cVar.item) && this.loadNext == cVar.loadNext) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            int i3 = this.pos * 31;
            com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = this.item;
            if (gVar == null) {
                hashCode = 0;
            } else {
                hashCode = gVar.hashCode();
            }
            int i16 = (i3 + hashCode) * 31;
            boolean z16 = this.loadNext;
            int i17 = z16;
            if (z16 != 0) {
                i17 = 1;
            }
            return i16 + i17;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "LoadDataIntent(pos=" + this.pos + ", item=" + this.item + ", loadNext=" + this.loadNext + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$d;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f355053a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44147);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f355053a = new d();
            }
        }

        d() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$e;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class e extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final e f355054a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44148);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f355054a = new e();
            }
        }

        e() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$f;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "", "a", "I", "c", "()I", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "clickView", "<init>", "(ILcom/tencent/qqnt/chats/core/adapter/itemdata/g;Landroid/view/View;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class f extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int pos;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chats.core.adapter.itemdata.g item;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View clickView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i3, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull View clickView) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(clickView, "clickView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), item, clickView);
                return;
            }
            this.pos = i3;
            this.item = item;
            this.clickView = clickView;
        }

        @NotNull
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.clickView;
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.itemdata.g b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.chats.core.adapter.itemdata.g) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.item;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.pos;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$g;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "", "a", "I", "c", "()I", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "clickView", "<init>", "(ILcom/tencent/qqnt/chats/core/adapter/itemdata/g;Landroid/view/View;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class g extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int pos;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chats.core.adapter.itemdata.g item;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View clickView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i3, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull View clickView) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(clickView, "clickView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), item, clickView);
                return;
            }
            this.pos = i3;
            this.item = item;
            this.clickView = clickView;
        }

        @NotNull
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.clickView;
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.itemdata.g b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.chats.core.adapter.itemdata.g) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.item;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.pos;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$h;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "", "a", "I", "c", "()I", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "dragType", "<init>", "(ILcom/tencent/qqnt/chats/core/adapter/itemdata/g;I)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class h extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int pos;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chats.core.adapter.itemdata.g item;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int dragType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i3, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), item, Integer.valueOf(i16));
                return;
            }
            this.pos = i3;
            this.item = item;
            this.dragType = i16;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.dragType;
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.itemdata.g b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.chats.core.adapter.itemdata.g) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.item;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.pos;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$i;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "", "a", "I", "c", "()I", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "clickId", "<init>", "(ILcom/tencent/qqnt/chats/core/adapter/itemdata/g;I)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class i extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int pos;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chats.core.adapter.itemdata.g item;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int clickId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i3, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), item, Integer.valueOf(i16));
                return;
            }
            this.pos = i3;
            this.item = item;
            this.clickId = i16;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.clickId;
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.itemdata.g b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.chats.core.adapter.itemdata.g) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.item;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.pos;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$j;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "", "a", "I", "b", "()I", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(ILcom/tencent/qqnt/chats/core/adapter/itemdata/g;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class j extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int pos;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chats.core.adapter.itemdata.g item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i3, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) item);
            } else {
                this.pos = i3;
                this.item = item;
            }
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.itemdata.g a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.chats.core.adapter.itemdata.g) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.item;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.pos;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$k;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "", "a", "I", "b", "()I", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(ILcom/tencent/qqnt/chats/core/adapter/itemdata/g;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class k extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int pos;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chats.core.adapter.itemdata.g item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i3, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) item);
            } else {
                this.pos = i3;
                this.item = item;
            }
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.itemdata.g a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.chats.core.adapter.itemdata.g) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.item;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.pos;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$l;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "Lpw3/c;", "a", "Lpw3/c;", "getSearchBar", "()Lpw3/c;", "searchBar", "<init>", "(Lpw3/c;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class l extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final pw3.c searchBar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(@NotNull pw3.c searchBar) {
            super(null);
            Intrinsics.checkNotNullParameter(searchBar, "searchBar");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) searchBar);
            } else {
                this.searchBar = searchBar;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR%\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$m;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "Landroid/view/View;", "a", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "b", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "()Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "viewType", "", "", "", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "extra", "<init>", "(Landroid/view/View;Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;Ljava/util/Map;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class m extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ThirdViewEnum viewType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Map<String, Object> extra;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(@NotNull View view, @NotNull ThirdViewEnum viewType, @Nullable Map<String, ? extends Object> map) {
            super(null);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(viewType, "viewType");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, view, viewType, map);
                return;
            }
            this.view = view;
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$n;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class n extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final n f355075a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44616);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f355075a = new n();
            }
        }

        n() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$o;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "chatUid", "", "b", "J", "()J", "chatUin", "c", "Z", "d", "()Z", "isTop", "I", "()I", "contactType", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class o extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String chatUid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long chatUin;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean isTop;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int contactType;

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.chatUid;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.chatUin;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.contactType;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.isTop;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof o)) {
                return false;
            }
            o oVar = (o) other;
            if (Intrinsics.areEqual(this.chatUid, oVar.chatUid) && this.chatUin == oVar.chatUin && this.isTop == oVar.isTop && this.contactType == oVar.contactType) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            int hashCode = ((this.chatUid.hashCode() * 31) + androidx.fragment.app.a.a(this.chatUin)) * 31;
            boolean z16 = this.isTop;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.contactType;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "TopChat(chatUid=" + this.chatUid + ", chatUin=" + this.chatUin + ", isTop=" + this.isTop + ", contactType=" + this.contactType + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/core/userintent/a$p;", "Lcom/tencent/qqnt/chats/core/userintent/a;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class p extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final p f355080a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45248);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f355080a = new p();
            }
        }

        p() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
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
