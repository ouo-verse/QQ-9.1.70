package com.tencent.mobileqq.selectfriend.enter.select;

import android.content.Context;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.api.IMyNodeApi;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0002\u0013\fB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J.\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eR6\u0010\u0015\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0011j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b`\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/enter/select/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "Landroid/os/Bundle;", "fsForwardData", "", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "c", "", "b", "d", "", "multiSelect", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "myNodeAdapterListCache", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, Class<? extends RecyclerView.Adapter<?>>> f285387c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f285388d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> myNodeAdapterListCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R,\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/enter/select/a$a;", "", "Lcom/tencent/mobileqq/selectfriend/enter/select/a;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/selectfriend/enter/select/a;", "a", "()Lcom/tencent/mobileqq/selectfriend/enter/select/a;", "", "", "Ljava/lang/Class;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "mKey2ViewBlock", "Ljava/util/Map;", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.selectfriend.enter.select.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return a.f285388d;
            }
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/enter/select/a$b;", "", "Lcom/tencent/mobileqq/selectfriend/enter/select/a;", "b", "Lcom/tencent/mobileqq/selectfriend/enter/select/a;", "a", "()Lcom/tencent/mobileqq/selectfriend/enter/select/a;", "holder", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f285390a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final a holder;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22827);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f285390a = new b();
                holder = new a();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return holder;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22836);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        HashMap hashMap = new HashMap();
        f285387c = hashMap;
        f285388d = b.f285390a.a();
        hashMap.put(10000, ((IMyNodeApi) QRoute.api(IMyNodeApi.class)).getMyNodeAdapter(10000));
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.myNodeAdapterListCache = new ArrayList<>();
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.myNodeAdapterListCache.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> c(@NotNull Context context, @Nullable FSForwardData<Bundle> fsForwardData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) fsForwardData);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.myNodeAdapterListCache.isEmpty()) {
            return this.myNodeAdapterListCache;
        }
        for (Map.Entry<Integer, Class<? extends RecyclerView.Adapter<?>>> entry : f285387c.entrySet()) {
            entry.getKey().intValue();
            RecyclerView.Adapter<?> newInstance = entry.getValue().getConstructor(Context.class, FSForwardData.class).newInstance(context, fsForwardData);
            if (newInstance != null) {
                newInstance.setHasStableIds(true);
                if ((newInstance instanceof com.tencent.mobileqq.selectfriend.adapter.a) && ((com.tencent.mobileqq.selectfriend.adapter.a) newInstance).isSupportShow()) {
                    this.myNodeAdapterListCache.add(newInstance);
                }
            }
        }
        return this.myNodeAdapterListCache;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int size = this.myNodeAdapterListCache.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.myNodeAdapterListCache.get(i3).notifyDataSetChanged();
        }
    }

    public final void e(boolean multiSelect) {
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, multiSelect);
            return;
        }
        int size = this.myNodeAdapterListCache.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> arrayList = this.myNodeAdapterListCache;
            if (arrayList != null) {
                adapter = arrayList.get(i3);
            } else {
                adapter = null;
            }
            if (adapter != null && (adapter instanceof com.tencent.mobileqq.selectfriend.adapter.a)) {
                ((com.tencent.mobileqq.selectfriend.adapter.a) adapter).setMultiSelect(multiSelect);
            }
        }
    }
}
