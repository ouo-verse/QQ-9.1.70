package com.tencent.mobileqq.ai.main.feeds;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.ai.main.AIAvatarFeedsTabInfo;
import com.tencent.mobileqq.ai.main.AIAvatarMainViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003+,-B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cRT\u0010'\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/ai/main/feeds/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/ai/b;", "", "position", "", "getItemId", "getItemCount", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "j0", "vh", com.tencent.luggage.wxa.c8.c.G, "", "i0", "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "vm", "Lcom/tencent/mobileqq/ai/main/AIAvatarFeedsTabInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/ai/main/AIAvatarFeedsTabInfo;", "tabInfo", "", "Lcom/tencent/mobileqq/ai/main/feeds/b$c;", "D", "Ljava/util/Map;", "viewTypeMap", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "E", "Lkotlin/jvm/functions/Function2;", "getOnBindViewListener", "()Lkotlin/jvm/functions/Function2;", "k0", "(Lkotlin/jvm/functions/Function2;)V", "onBindViewListener", "<init>", "(Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;Lcom/tencent/mobileqq/ai/main/AIAvatarFeedsTabInfo;)V", UserInfo.SEX_FEMALE, "a", "b", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends RecyclerView.Adapter<com.tencent.mobileqq.ai.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AIAvatarFeedsTabInfo tabInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, c> viewTypeMap;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function2<? super com.tencent.mobileqq.ai.b, ? super Integer, Unit> onBindViewListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIAvatarMainViewModel vm;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ai/main/feeds/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.main.feeds.b$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/ai/main/feeds/b$b;", "Lcom/tencent/mobileqq/ai/b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.main.feeds.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7231b extends com.tencent.mobileqq.ai.b {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7231b(@NotNull Context context) {
            super(new View(context));
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/ai/main/feeds/b$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "renderViewType", "getRenderHex", "renderHex", "c", "dataType", "<init>", "(III)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int renderViewType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int renderHex;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int dataType;

        public c(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.renderViewType = i3;
            this.renderHex = i16;
            this.dataType = i17;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.dataType;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.renderViewType;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (this.renderViewType == cVar.renderViewType && this.renderHex == cVar.renderHex && this.dataType == cVar.dataType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.renderViewType * 31) + this.renderHex) * 31) + this.dataType;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "InnerViewType(renderViewType=" + this.renderViewType + ", renderHex=" + this.renderHex + ", dataType=" + this.dataType + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22600);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull AIAvatarMainViewModel vm5, @NotNull AIAvatarFeedsTabInfo tabInfo) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) vm5, (Object) tabInfo);
            return;
        }
        this.vm = vm5;
        this.tabInfo = tabInfo;
        this.viewTypeMap = new LinkedHashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        List<a> T1 = this.vm.T1(this.tabInfo);
        if (T1 != null) {
            return T1.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        a aVar;
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, position)).longValue();
        }
        List<a> T1 = this.vm.T1(this.tabInfo);
        if (T1 != null && (aVar = T1.get(position)) != null && (c16 = aVar.c()) != null) {
            return c16.hashCode();
        }
        return 0L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, position)).intValue();
        }
        List<a> T1 = this.vm.T1(this.tabInfo);
        if (T1 != null) {
            aVar = T1.get(position);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            QLog.e("AIAvatarFeedsListAdapter", 2, "getItemViewType: feedsInfo is null tabInfo=" + this.tabInfo + " position=" + position);
            return -1;
        }
        int d16 = aVar.d();
        com.tencent.mobileqq.ai.i<?, ?> a16 = com.tencent.mobileqq.ai.a.f187656a.a(d16);
        if (a16 == null) {
            QLog.e("AIAvatarFeedsListAdapter", 1, "getItemViewType: render is null tabInfo=" + this.tabInfo + " position=" + position + " dataType=" + d16);
            return -1;
        }
        c cVar = new c(h.a(a16, position, aVar), a16.hashCode(), d16);
        this.viewTypeMap.put(Integer.valueOf(cVar.hashCode()), cVar);
        return cVar.hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.mobileqq.ai.b vh5, int pos) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) vh5, pos);
            return;
        }
        Intrinsics.checkNotNullParameter(vh5, "vh");
        vh5.m(pos);
        if (vh5 instanceof C7231b) {
            return;
        }
        List<a> T1 = this.vm.T1(this.tabInfo);
        if (T1 != null) {
            aVar = T1.get(pos);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            QLog.e("AIAvatarFeedsListAdapter", 2, "onBindViewHolder: feedsInfo is null tabInfo=" + this.tabInfo + " position=" + pos);
            return;
        }
        int d16 = aVar.d();
        com.tencent.mobileqq.ai.i<?, ?> a16 = com.tencent.mobileqq.ai.a.f187656a.a(d16);
        if (a16 == null) {
            QLog.e("AIAvatarFeedsListAdapter", 1, "onBindViewHolder: render is null tabInfo=" + this.tabInfo + " position=" + pos + " dataType=" + d16);
            return;
        }
        h.b(a16, vh5, pos, aVar);
        Function2<? super com.tencent.mobileqq.ai.b, ? super Integer, Unit> function2 = this.onBindViewListener;
        if (function2 != null) {
            function2.invoke(vh5, Integer.valueOf(pos));
        }
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [com.tencent.mobileqq.ai.b] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.ai.b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.ai.b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        c cVar = this.viewTypeMap.get(Integer.valueOf(viewType));
        if (cVar == null) {
            QLog.e("AIAvatarFeedsListAdapter", 1, "onCreateViewHolder: innerViewType is null viewType=" + viewType);
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new C7231b(context);
        }
        com.tencent.mobileqq.ai.i<?, ?> a16 = com.tencent.mobileqq.ai.a.f187656a.a(cVar.a());
        if (a16 == null) {
            QLog.e("AIAvatarFeedsListAdapter", 1, "onCreateViewHolder: render is null viewType=" + viewType + " innerViewType=" + cVar);
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            return new C7231b(context2);
        }
        Context context3 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
        ?? b16 = a16.b(context3, cVar.b());
        b16.l(cVar.a());
        return b16;
    }

    public final void k0(@Nullable Function2<? super com.tencent.mobileqq.ai.b, ? super Integer, Unit> function2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function2);
        } else {
            this.onBindViewListener = function2;
        }
    }
}
