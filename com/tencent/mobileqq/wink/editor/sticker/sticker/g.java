package com.tencent.mobileqq.wink.editor.sticker.sticker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.mobileqq.wink.editor.sticker.sticker.WinkApplyStickerMaterialTask;
import com.tencent.mobileqq.wink.event.ReceiveSchemaEvent;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.view.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes21.dex */
public class g extends com.tencent.mobileqq.wink.editor.sticker.sticker.a {
    private RecyclerView N;
    private GridLayoutManager P;
    private x Q;
    private com.tencent.mobileqq.wink.editor.sticker.sticker.b R;
    private BottomSheetBehavior<LinearLayout> S;
    private boolean V;
    private View W;
    private String X = null;
    private boolean Y = false;
    private MenuType Z = null;
    private final List<MetaCategory> T = new ArrayList();
    private final List<MetaMaterial> U = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                g.this.V = false;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            if (!g.this.V) {
                g.this.Q.B(com.tencent.mobileqq.wink.editor.c.f(g.this.T, g.this.U, g.this.P.findFirstVisibleItemPosition()));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            g.this.x9();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class f extends com.tencent.mobileqq.wink.flow.a {
        f() {
        }

        @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void F1(ApplyMaterialTask.Status status, int i3, @NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
            if (m.W(metaMaterial)) {
                super.F1(status, i3, metaMaterial, aVar);
            } else {
                l.K(metaMaterial, aVar);
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void g(int i3, @NonNull MetaMaterial metaMaterial) {
            g.this.Ma().a0(-1);
            g.this.Na();
            try {
                WinkApplyStickerMaterialTask.Companion companion = WinkApplyStickerMaterialTask.INSTANCE;
                WinkEditorFragment F9 = g.this.F9();
                dr H9 = g.this.H9();
                Context context = g.this.getContext();
                g gVar = g.this;
                companion.a(metaMaterial, F9, H9, context, gVar.winkEditorViewModel, (WinkEditPerformanceViewModel) gVar.getViewModel(WinkEditPerformanceViewModel.class), 100);
            } catch (Exception e16) {
                w53.b.c("WinkEditorStickerMenuPart", "onApplyMaterialLocal exception " + e16.getMessage());
            }
        }
    }

    private ApplyMaterialTask La() {
        return new f();
    }

    private void Oa(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.tow);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(this.Q);
    }

    private void Pa(View view) {
        this.W = view.findViewById(R.id.v8s);
    }

    private void Qa(View view) {
        this.N = (RecyclerView) view.findViewById(R.id.u7w);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        this.P = gridLayoutManager;
        this.N.setLayoutManager(gridLayoutManager);
        this.N.addOnScrollListener(new d());
        this.N.addItemDecoration(new com.tencent.mobileqq.wink.editor.sticker.sticker.c(getContext(), this.U));
        this.N.setAdapter(Ma());
    }

    private void Ra(View view) {
        ((CoordinatorLayout) view.findViewById(R.id.u9h)).getLayoutParams().height = (int) ((com.tencent.mobileqq.util.x.f(getContext()).f185861b * 2.0f) / 3.0f);
        BottomSheetBehavior<LinearLayout> from = BottomSheetBehavior.from((LinearLayout) view.findViewById(R.id.leb));
        this.S = from;
        from.addBottomSheetCallback(new c());
    }

    private void Sa() {
        aa().getStickerMaterialVOLiveData().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                g.this.Ta((com.tencent.mobileqq.wink.editor.model.b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ta(com.tencent.mobileqq.wink.editor.model.b bVar) {
        this.T.clear();
        this.T.addAll(bVar.a());
        this.U.clear();
        this.U.addAll(bVar.b());
        dr H9 = H9();
        if (H9 != null && this.X != null) {
            if (H9.getIsReady()) {
                if (this.U.size() > 0) {
                    Ma().Q(this.X);
                    this.X = null;
                }
            } else {
                H9.F(new b());
            }
        }
        this.Q.notifyDataSetChanged();
        Ma().notifyDataSetChanged();
    }

    private void Ua(Bundle bundle) {
        if (bundle == null) {
            this.Z = null;
            return;
        }
        String string = bundle.getString("ARGS_BACK_TO_MENU_TYPE");
        if (string == null) {
            this.Z = null;
        } else {
            this.Z = MenuType.valueOf(string);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f88424x1;
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.a, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        super.J9(editMode);
        com.tencent.mobileqq.wink.editor.sticker.sticker.b bVar = this.R;
        if (bVar != null) {
            bVar.g0(editMode);
        }
    }

    public void Ka() {
        if (this.U.size() > 0 && this.X != null) {
            Ma().Q(this.X);
            this.X = null;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle bundle) {
        ms.a.f("WinkEditorStickerMenuPart", "onShow()");
        View view = this.W;
        boolean z16 = true;
        if (view != null) {
            view.setClickable(true);
            this.W.setOnClickListener(new e());
        }
        Size a16 = H9().a();
        Size renderSize = H9().getRenderSize();
        WinkMaterialViewModel aa5 = aa();
        WinkEditorViewModel.EditMode editMode = this.winkEditorViewModel.getEditMode();
        WinkEditorViewModel.EditMode editMode2 = WinkEditorViewModel.EditMode.Video;
        if (editMode != editMode2) {
            z16 = false;
        }
        aa5.filterSticker(a16, renderSize, z16);
        super.L9(bundle);
        this.S.setState(3);
        if (this.winkEditorViewModel.getEditMode() == editMode2) {
            this.Y = H9().isPlaying();
            H9().pause();
        }
        Ua(bundle);
    }

    protected com.tencent.mobileqq.wink.editor.sticker.sticker.b Ma() {
        if (this.R == null) {
            com.tencent.mobileqq.wink.editor.sticker.sticker.b bVar = new com.tencent.mobileqq.wink.editor.sticker.sticker.b(getContext(), this.winkEditorViewModel.getEditMode());
            this.R = bVar;
            bVar.Y(this.U);
            this.R.S(La());
        }
        return this.R;
    }

    public void Na() {
        if (!this.visible) {
            return;
        }
        View view = this.W;
        if (view != null) {
            view.setOnClickListener(null);
            this.W.setClickable(false);
        }
        if (this.winkEditorViewModel.getEditMode() == WinkEditorViewModel.EditMode.Video && this.winkEditorViewModel.D2() == null && this.Y) {
            H9().play();
        }
        super.x9();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NonNull
    public MenuType ba() {
        return MenuType.STICKER_OLD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    @SuppressLint({"ClickableViewAccessibility"})
    public void initAfterInflation(View view) {
        super.initAfterInflation(view);
        Sa();
        Pa(view);
        Ra(view);
        Oa(view);
        Qa(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            Na();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ms.a.f("WinkEditorStickerMenuPart", "onInitView onInitView start:");
        this.Q = new x(this.T, new a());
        ms.a.f("WinkEditorStickerMenuPart", "onInitView onInitView end:");
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.a, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        HashMap hashMap;
        super.onReceiveEvent(simpleBaseEvent);
        if ((simpleBaseEvent instanceof ReceiveSchemaEvent) && this.X == null && (hashMap = (HashMap) ((ReceiveSchemaEvent) simpleBaseEvent).getAttrs()) != null && !hashMap.isEmpty() && hashMap.containsKey("sticker") && !TextUtils.isEmpty((CharSequence) hashMap.get("sticker"))) {
            this.X = (String) hashMap.get("sticker");
            I9();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.a
    public int wa() {
        return 100;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void x9() {
        MenuType menuType = this.Z;
        if (menuType == null) {
            super.x9();
        } else {
            this.winkEditorViewModel.u5(menuType, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements ISessionListener {
        b() {
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NonNull LAKRenderModel lAKRenderModel, long j3, long j16) {
            g.this.Ka();
            g.this.H9().Q(this);
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void K9() {
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.a, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c extends BottomSheetBehavior.e {
        c() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (i3 == 4) {
                g.this.x9();
                g.super.onDismiss();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements x.b {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.view.x.b
        public void a(x.a aVar, int i3, @Nullable MetaCategory metaCategory) {
            g.this.V = true;
            com.tencent.mobileqq.wink.utils.b.i(g.this.N, g.this.Ma().D(), com.tencent.mobileqq.wink.editor.c.e(g.this.T, g.this.U, i3), false, false);
        }

        @Override // com.tencent.mobileqq.wink.view.x.b
        public void b(x.a aVar, int i3, @Nullable MetaCategory metaCategory) {
        }
    }
}
