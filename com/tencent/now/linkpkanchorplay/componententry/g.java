package com.tencent.now.linkpkanchorplay.componententry;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om3.d;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\rB7\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007J\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/componententry/g;", "", "", "d", "e", "f", h.F, "", "", "paramsMap", "g", "i", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lcom/tencent/now/linkpkanchorplay/componententry/e;", "b", "Lcom/tencent/now/linkpkanchorplay/componententry/e;", "roomInfo", "Lcom/tencent/component/core/event/Eventor;", "c", "Lcom/tencent/component/core/event/Eventor;", "eventor", "", "Z", "selfEndFlag", "Lom3/b;", "Lom3/b;", "linkMicStateMgr", "Lcom/tencent/now/linkpkanchorplay/componententry/AnchorPlayUIController;", "Lcom/tencent/now/linkpkanchorplay/componententry/AnchorPlayUIController;", "viewUIController", "Lcom/tencent/now/linkpkanchorplay/componententry/f;", "pkEntranceSupport", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "<init>", "(Landroid/content/Context;Lcom/tencent/now/linkpkanchorplay/componententry/f;Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModelProvider;Lcom/tencent/now/linkpkanchorplay/componententry/e;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorRoomInfo roomInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean selfEndFlag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final om3.b linkMicStateMgr;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorPlayUIController viewUIController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/componententry/g$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$h;", "it", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements OnEvent<d.StateChangeEvent> {
        b() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.StateChangeEvent it) {
            Intrinsics.checkNotNullParameter(it, "it");
            om3.d curState = it.getCurState();
            om3.d oldState = it.getOldState();
            if ((curState instanceof d.c) && (oldState instanceof d.InLinkScreen)) {
                AegisLogger.INSTANCE.i("PK_Biz|LinkPKAnchorPlayLogic", "linkscreen end,show remind tips");
                if (!g.this.selfEndFlag) {
                    UIUtil.h(g.this.context.getString(R.string.f2315972_), false, 1);
                }
                g.this.selfEndFlag = false;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/componententry/g$c", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$g;", "it", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements OnEvent<d.g> {
        c() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.g it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AegisLogger.INSTANCE.i("PK_Biz|LinkPKAnchorPlayLogic", "SelfEndLinkScreen event");
            g.this.selfEndFlag = true;
        }
    }

    public g(@NotNull Context context, @NotNull f pkEntranceSupport, @NotNull FragmentManager fm5, @NotNull LifecycleOwner lifecycleOwner, @NotNull ViewModelProvider viewModelProvider, @NotNull AnchorRoomInfo roomInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pkEntranceSupport, "pkEntranceSupport");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        this.context = context;
        this.roomInfo = roomInfo;
        this.eventor = new Eventor();
        om3.b bVar = new om3.b();
        this.linkMicStateMgr = bVar;
        this.viewUIController = new AnchorPlayUIController(context, pkEntranceSupport, fm5, lifecycleOwner, viewModelProvider, bVar, roomInfo);
        tm3.b.f436626a.b(bVar);
    }

    private final void d() {
        this.eventor.addOnEvent(new b()).addOnEvent(new c());
    }

    public final void e() {
        this.viewUIController.k();
        d();
        zm3.a.f452778a.f(this.roomInfo);
    }

    public final void f() {
        this.viewUIController.n();
    }

    public final void g(@NotNull Map<String, String> paramsMap) {
        Intrinsics.checkNotNullParameter(paramsMap, "paramsMap");
        zm3.a.f452778a.d(paramsMap);
    }

    public final void h() {
        this.viewUIController.w();
    }

    public final void i() {
        this.viewUIController.x();
        this.linkMicStateMgr.B();
        this.eventor.removeAll();
        zm3.a.f452778a.a();
    }
}
