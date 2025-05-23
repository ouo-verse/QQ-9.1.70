package com.tencent.qqnt.chats.core.adapter.itemdata;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0000H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "Lcom/tencent/qqnt/base/adapter/b;", "", "newItem", "", "c", "d", "b", "", "id", "", "Lcom/tencent/qqnt/chats/core/adapter/menu/a;", "a", "()Ljava/util/List;", "menuItems", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b extends com.tencent.qqnt.base.adapter.b {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/b$a;", "", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.adapter.itemdata.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f354522a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40502);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f354522a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.chats.core.adapter.itemdata.b$b, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9570b {
        @Nullable
        public static Object a(@NotNull b bVar, @NotNull b newItem) {
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return null;
        }

        @NotNull
        public static List<com.tencent.qqnt.chats.core.adapter.menu.a> b(@NotNull b bVar) {
            return new ArrayList();
        }

        public static long c(@NotNull b bVar) {
            return 0L;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(40505), (Class<?>) b.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f354522a;
        }
    }

    @NotNull
    List<com.tencent.qqnt.chats.core.adapter.menu.a> a();

    @Nullable
    Object b(@NotNull b newItem);

    boolean c(@NotNull b newItem);

    boolean d(@NotNull b newItem);

    long id();
}
