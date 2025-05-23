package ak2;

import android.app.Activity;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.TextureView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.menu.MenuType;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.qqvideoedit.editor.view.TextBoundsView;
import com.tencent.mobileqq.qqvideoedit.editor.view.TextColorView;
import com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.utils.i;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGPlayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes17.dex */
public class n extends com.tencent.mobileqq.qqvideoedit.editor.menu.h {
    private String I;
    private View J;
    private PAGView K;
    private TextureView.SurfaceTextureListener L;
    private TextBoundsView M;
    private FrameLayout N;
    private View P;
    private EditText Q;
    private LinearLayout R;
    private LinearLayout S;
    private int T = -1;
    private ImageView U;
    private boolean V;
    private RecyclerView W;
    private Animation X;
    private Animation Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.videocut.utils.i f26220a0;

    /* renamed from: b0, reason: collision with root package name */
    private i.b f26221b0;

    /* renamed from: c0, reason: collision with root package name */
    private ak2.a f26222c0;

    /* renamed from: d0, reason: collision with root package name */
    private Drawable f26223d0;

    /* renamed from: e0, reason: collision with root package name */
    private Drawable f26224e0;

    /* renamed from: f0, reason: collision with root package name */
    private o f26225f0;

    /* renamed from: g0, reason: collision with root package name */
    private ApplyMaterialTask f26226g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f26227h0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements i.b {
        b() {
        }

        @Override // com.tencent.videocut.utils.i.b
        public void onSoftKeyboardClosed() {
            String value = n.this.f26225f0.U1().getValue();
            if (!"CATEGORY_KEYBOARD".equals(value)) {
                n.this.Sa(value);
            } else {
                n nVar = n.this;
                nVar.za(nVar.Ia());
            }
        }

        @Override // com.tencent.videocut.utils.i.b
        public void onSoftKeyboardOpened(int i3) {
            if (n.this.N.getLayoutParams().height != i3) {
                n.this.N.getLayoutParams().height = i3;
                n.this.N.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class d extends com.tencent.mobileqq.qqvideoedit.flow.a {
        d() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.flow.a, com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
        public void f0(ApplyMaterialTask.Status status, int i3, @NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
            if (com.tencent.mobileqq.qqvideoedit.editor.sticker.h.E(metaMaterial)) {
                super.f0(status, i3, metaMaterial, aVar);
            } else {
                com.tencent.mobileqq.qqvideoedit.editor.sticker.g.m(metaMaterial, aVar);
            }
        }

        @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
        public void g(int i3, @NonNull MetaMaterial metaMaterial) {
            n.this.f26225f0.M1(metaMaterial);
            oj2.c.b().c(metaMaterial.f30533id, "video", "0");
        }

        @Override // com.tencent.mobileqq.qqvideoedit.flow.a, com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
        public boolean z(int i3, @NonNull MetaMaterial metaMaterial) {
            if (!"TEXT_DEFAULT_DEFAULT_ID".equals(metaMaterial.f30533id) && !"TEXT_PATTERN_NON_ID".equals(metaMaterial.f30533id) && !"TEXT_DECOR_NON_ID".equals(metaMaterial.f30533id)) {
                return super.z(i3, metaMaterial);
            }
            return true;
        }
    }

    private ApplyMaterialTask Aa() {
        if (this.f26226g0 == null) {
            this.f26226g0 = new d();
        }
        return this.f26226g0;
    }

    private void Ba(View view) {
        this.M = (TextBoundsView) view.findViewById(R.id.f94685cy);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.u0r);
        this.S = linearLayout;
        linearLayout.setGravity(16);
        final int i3 = 0;
        while (true) {
            List<Integer> list = o.W;
            if (i3 < list.size()) {
                TextColorView textColorView = new TextColorView(getContext());
                if (list.get(i3).intValue() == -1) {
                    textColorView.setColor(o.Y);
                } else {
                    textColorView.setColor(list.get(i3).intValue());
                }
                FrameLayout frameLayout = new FrameLayout(getContext());
                com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(eVar.a(28.0f), eVar.a(28.0f), 0);
                layoutParams.gravity = 17;
                frameLayout.addView(textColorView, layoutParams);
                eVar.a(8.5f);
                this.S.addView(frameLayout, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                textColorView.setOnClickListener(new View.OnClickListener() { // from class: ak2.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        n.this.Ja(i3, view2);
                    }
                });
                this.f26225f0.b2().observe(getHostFragment(), new Observer() { // from class: ak2.i
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        n.this.Ta(((Integer) obj).intValue());
                    }
                });
                i3++;
            } else {
                return;
            }
        }
    }

    private void Ca(View view) {
        this.P = view.findViewById(R.id.f94745d4);
        this.Q = (EditText) view.findViewById(R.id.f94815da);
        this.f26221b0 = new b();
        com.tencent.videocut.utils.i iVar = new com.tencent.videocut.utils.i(getHostFragment().getView());
        this.f26220a0 = iVar;
        iVar.a(this.f26221b0);
        this.Q.addTextChangedListener(new c());
    }

    private void Da(View view) {
        this.R = (LinearLayout) view.findViewById(R.id.z3e);
    }

    private void Ea(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f94645cu);
        this.U = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ak2.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.this.Ka(view2);
            }
        });
        this.f26225f0.e2().observe(getHostFragment(), new Observer() { // from class: ak2.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.Va(((Boolean) obj).booleanValue());
            }
        });
    }

    private void Fa(View view) {
        this.W = (RecyclerView) view.findViewById(R.id.u7w);
        this.W.setLayoutManager(new GridLayoutManager(getContext(), 4));
        ak2.a aVar = new ak2.a(getContext(), this.videoEditorViewModel.getEditMode());
        this.f26222c0 = aVar;
        aVar.K(Aa());
        this.W.setAdapter(this.f26222c0);
        this.f26225f0.d2().observe(getHostFragment(), new Observer() { // from class: ak2.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.La((List) obj);
            }
        });
        this.f26225f0.c2().observe(getHostFragment(), new Observer() { // from class: ak2.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.Ma((Integer) obj);
            }
        });
    }

    private void Ga(View view) {
        View findViewById = view.findViewById(R.id.enf);
        this.J = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: ak2.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.this.Na(view2);
            }
        });
        PAGView pAGView = (PAGView) view.findViewById(R.id.f94865df);
        this.K = pAGView;
        pAGView.play();
        this.K.setRepeatCount(0);
        this.f26225f0.W1().observe(getHostFragment(), new Observer() { // from class: ak2.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.Ua((MetaMaterial) obj);
            }
        });
    }

    private void Ha() {
        o oVar = (o) getViewModel(o.class);
        this.f26225f0 = oVar;
        oVar.a2().observe(getHostFragment(), new Observer() { // from class: ak2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.Oa((VideoStickerModel) obj);
            }
        });
        this.f26225f0.Q1().observe(getHostFragment(), new Observer() { // from class: ak2.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.Pa((MetaMaterial) obj);
            }
        });
        S9().getTextMaterialVOLiveData().observe(getHostFragment(), new Observer() { // from class: ak2.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.Qa((xj2.a) obj);
            }
        });
        this.f26225f0.U1().observe(getHostFragment(), new Observer() { // from class: ak2.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.Sa((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ia() {
        return !TextUtils.isEmpty(this.Q.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ja(int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f26225f0.q2(o.W.get(i3).intValue(), o.X.get(i3).intValue());
        Ta(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ka(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f26225f0.s2(!this.V);
        Va(!this.V);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void La(List list) {
        ak2.a aVar;
        if (list != null && (aVar = this.f26222c0) != null) {
            aVar.M(list);
            this.f26222c0.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ma(Integer num) {
        ak2.a aVar;
        if (num != null && (aVar = this.f26222c0) != null) {
            aVar.N(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Na(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        za(Ia());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oa(VideoStickerModel videoStickerModel) {
        if (F9() != null) {
            F9().f0(videoStickerModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pa(MetaMaterial metaMaterial) {
        com.tencent.mobileqq.qqvideoedit.editor.sticker.g.d(metaMaterial, F9(), D9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qa(xj2.a aVar) {
        this.f26225f0.k2(aVar.a());
    }

    private void Ra(boolean z16) {
        if (z16) {
            this.P.setVisibility(0);
            com.tencent.videocut.utils.j.f384247a.b(this.Q);
            String obj = this.Q.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                this.Q.setSelection(obj.length());
                return;
            }
            return;
        }
        this.P.setVisibility(4);
        com.tencent.videocut.utils.j.f384247a.a(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sa(String str) {
        com.tencent.videocut.utils.i iVar = this.f26220a0;
        if (iVar == null) {
            QLog.e(this.TAG, 1, "switchCategory error, mKeyboardStateHelper is null!");
            return;
        }
        boolean b16 = iVar.b();
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -921884268:
                if (str.equals("CATEGORY_TEXT_DECOR")) {
                    c16 = 0;
                    break;
                }
                break;
            case -907563552:
                if (str.equals("CATEGORY_TEXT_STYLE")) {
                    c16 = 1;
                    break;
                }
                break;
            case 793913343:
                if (str.equals("CATEGORY_TEXT_PATTERN")) {
                    c16 = 2;
                    break;
                }
                break;
            case 910730760:
                if (str.equals("CATEGORY_KEYBOARD")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                Ra(false);
                if (!b16) {
                    this.W.setVisibility(0);
                    return;
                }
                return;
            case 1:
                Ra(false);
                if (!b16) {
                    this.W.setVisibility(8);
                    return;
                }
                return;
            case 2:
                Ra(false);
                if (!b16) {
                    this.W.setVisibility(0);
                    return;
                }
                return;
            case 3:
                Ra(true);
                this.W.setVisibility(8);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta(int i3) {
        if (this.S == null) {
            return;
        }
        this.f26225f0.b2().getValue().intValue();
        int i16 = this.T;
        if (i16 != -1) {
            this.S.getChildAt(i16).setSelected(false);
        }
        if (i3 != -1 && i3 >= 0 && i3 <= this.S.getChildCount()) {
            this.S.getChildAt(i3).setSelected(true);
            this.T = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ua(MetaMaterial metaMaterial) {
        if (!this.visible) {
            O9(null);
        }
        String t16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.t(metaMaterial);
        PAGFile c16 = com.tencent.mobileqq.qqvideoedit.utils.k.b().c(t16);
        if (c16 == null) {
            QLog.e(this.TAG, 1, "updateEditLayout  pagFile is Null");
            return;
        }
        PAGText textData = c16.getTextData(0);
        if (textData == null) {
            return;
        }
        String h16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(metaMaterial);
        textData.text = h16;
        QLog.d(this.TAG, 1, "updateEditLayout text " + h16 + " pagFilePath " + t16);
        if (t16.equals(o.U)) {
            textData.fillColor = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.c(metaMaterial);
            textData.backgroundColor = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.w(metaMaterial);
            this.M.setVisibility(8);
        } else {
            textData.fillColor = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.w(metaMaterial);
            this.M.setVisibility(0);
        }
        textData.justification = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.x(metaMaterial);
        textData.fontStyle = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.m(metaMaterial);
        textData.fontFamily = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.i(metaMaterial);
        c16.replaceText(0, textData);
        this.K.setComposition(c16);
        if (!com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(metaMaterial).equals(this.Q.getText().toString()) && !com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(metaMaterial).equals(o.V)) {
            this.Q.setText(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(metaMaterial));
        }
        QLog.d(this.TAG, 1, "mTextBoundsView visible " + this.M.getVisibility());
        if (this.M.getVisibility() == 0) {
            a aVar = new a(c16, metaMaterial);
            this.L = aVar;
            this.K.setSurfaceTextureListener(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Va(boolean z16) {
        ImageView imageView = this.U;
        if (imageView == null) {
            return;
        }
        if (z16) {
            imageView.setImageResource(R.drawable.ngl);
        } else {
            imageView.setImageResource(R.drawable.ngk);
        }
        this.V = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void za(boolean z16) {
        this.M.setVisibility(8);
        com.tencent.videocut.utils.j.f384247a.a(this.Q);
        this.f26225f0.P1(z16);
        x9();
        this.Q.setText("");
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public int A9() {
        return R.id.f94845dd;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h, com.tencent.mobileqq.qqvideoedit.editor.d
    public void J9(@NotNull VideoEditorViewModel.EditMode editMode) {
        super.J9(editMode);
        ak2.a aVar = this.f26222c0;
        if (aVar != null) {
            aVar.P(editMode);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h, com.tencent.mobileqq.qqvideoedit.editor.d
    public void K9(@Nullable Bundle bundle) {
        this.K.startAnimation(this.X);
        this.J.startAnimation(this.X);
        this.R.startAnimation(this.slideUpAnimation);
        super.K9(bundle);
        this.f26225f0.L1();
        if (this.videoEditorViewModel.getEditMode() == VideoEditorViewModel.EditMode.Video && F9() != null && F9().getCurrentPlayer() != null) {
            this.f26227h0 = F9().getCurrentPlayer().isPlaying();
            F9().getCurrentPlayer().pause();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h
    @NonNull
    public MenuType T9() {
        return MenuType.TEXT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public void initAfterInflation(View view) {
        super.initAfterInflation(view);
        this.I = getContext().getResources().getString(R.string.f1646326c);
        this.Z = com.tencent.mobileqq.util.x.c(getContext(), 3.0f);
        this.f26223d0 = ContextCompat.getDrawable(getContext(), R.drawable.kvw);
        this.f26224e0 = ContextCompat.getDrawable(getContext(), R.drawable.kvx);
        this.N = (FrameLayout) view.findViewById(R.id.leb);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154548b2);
        this.X = loadAnimation;
        loadAnimation.setDuration(200L);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154550b4);
        this.Y = loadAnimation2;
        loadAnimation2.setDuration(200L);
        Ha();
        Ca(view);
        Ga(view);
        Da(view);
        Fa(view);
        Ba(view);
        Ea(view);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h, com.tencent.mobileqq.qqvideoedit.editor.d
    public void onDismiss() {
        if (!"CATEGORY_KEYBOARD".equals(this.f26225f0.S1())) {
            this.K.startAnimation(this.Y);
            this.J.startAnimation(this.Y);
            this.R.startAnimation(this.slideDownAnimation);
        } else {
            getPartRootView().setVisibility(4);
        }
        if (this.L != null) {
            this.K.setSurfaceTextureListener(null);
            this.L = null;
        }
        if (this.videoEditorViewModel.getEditMode() == VideoEditorViewModel.EditMode.Video && F9() != null && F9().getCurrentPlayer() != null && this.f26227h0) {
            F9().getCurrentPlayer().play();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.videocut.utils.i iVar = this.f26220a0;
        if (iVar != null) {
            iVar.f(this.f26221b0);
            this.f26220a0.e();
            this.f26220a0 = null;
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h
    public void Y9() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements TextureView.SurfaceTextureListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PAGFile f26228d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f26229e;

        a(PAGFile pAGFile, MetaMaterial metaMaterial) {
            this.f26228d = pAGFile;
            this.f26229e = metaMaterial;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            try {
                RectF bounds = ((PAGPlayer) com.tencent.robolectric.a.b(n.this.K, "pagPlayer")).getBounds(this.f26228d.getLayersByEditableIndex(0, 3)[0]);
                if (bounds.width() > 0.0f && bounds.height() > 0.0f) {
                    n.this.M.setRect(bounds);
                    n.this.M.setColor(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.w(this.f26229e));
                    n.this.M.invalidate();
                } else if (QLog.isColorLevel()) {
                    QLog.w(n.this.TAG, 2, "onSurfaceTextureUpdated rect is not invalid. rect = " + bounds);
                }
            } catch (Throwable th5) {
                QLog.e(n.this.TAG, 1, "onSurfaceTextureUpdated error!", th5);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            String obj = editable.toString();
            if (editable.length() > 120) {
                QQToast.makeText(n.this.getContext(), n.this.I, 0).show();
                obj = editable.subSequence(0, 120).toString();
                n.this.Q.setText(obj);
                n.this.Q.setSelection(obj.length());
            }
            n.this.f26225f0.r2(obj);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
