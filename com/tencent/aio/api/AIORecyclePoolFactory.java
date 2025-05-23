package com.tencent.aio.api;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.AIORecyclePoolFactory;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.pool.AIORecyclePool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J4\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\bH\u0096\u0001J\u0013\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0001\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/api/AIORecyclePoolFactory;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/pool/a;", "Lcom/tencent/aio/api/AIORecyclePoolFactory$a;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/pool/AIORecyclePool;", "param", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "b", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "creator", "c", "d", "<init>", "()V", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AIORecyclePoolFactory implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.pool.a<a, AIORecyclePool> {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final AIORecyclePoolFactory f69112b;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.pool.b f69113a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aio/api/AIORecyclePoolFactory$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/lifecycle/LifecycleOwner;", "a", "Landroidx/lifecycle/LifecycleOwner;", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final LifecycleOwner lifecycleOwner;

        public a(@Nullable LifecycleOwner lifecycleOwner) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lifecycleOwner);
            } else {
                this.lifecycleOwner = lifecycleOwner;
            }
        }

        @Nullable
        public final LifecycleOwner a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (LifecycleOwner) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.lifecycleOwner;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this != other) {
                if (!(other instanceof a) || !Intrinsics.areEqual(this.lifecycleOwner, ((a) other).lifecycleOwner)) {
                    return false;
                }
                return true;
            }
            return true;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner != null) {
                return lifecycleOwner.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "AIORecyclePoolParam(lifecycleOwner=" + this.lifecycleOwner + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_MEDIA_LAB_VR_LATENCY_INFO);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f69112b = new AIORecyclePoolFactory();
        }
    }

    AIORecyclePoolFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f69113a = com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.pool.b.f69634b;
        }
    }

    @NotNull
    public final RecyclerView.RecycledViewPool b(@NotNull final a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (RecyclerView.RecycledViewPool) iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        return c(param, new Function1<a, AIORecyclePool>() { // from class: com.tencent.aio.api.AIORecyclePoolFactory$createRecyclePool$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIORecyclePoolFactory.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final AIORecyclePool invoke(@NotNull AIORecyclePoolFactory.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (AIORecyclePool) iPatchRedirector2.redirect((short) 1, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return new AIORecyclePool(AIORecyclePoolFactory.a.this, AIORecyclePoolFactory.f69112b);
            }
        });
    }

    @NotNull
    public AIORecyclePool c(@NotNull a key, @NotNull Function1<? super a, AIORecyclePool> creator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AIORecyclePool) iPatchRedirector.redirect((short) 4, (Object) this, (Object) key, (Object) creator);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        return this.f69113a.b(key, creator);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.pool.a
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AIORecyclePool a(@NotNull a key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIORecyclePool) iPatchRedirector.redirect((short) 5, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f69113a.a(key);
    }
}
