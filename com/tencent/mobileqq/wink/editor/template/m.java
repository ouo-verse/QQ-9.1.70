package com.tencent.mobileqq.wink.editor.template;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart;
import com.tencent.mobileqq.wink.editor.template.m;
import com.tencent.mobileqq.wink.event.ReceiveSchemaEvent;
import com.tencent.mobileqq.wink.event.TemplateSelectEvent;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class m extends WinkEditorMenuPart {
    protected RecyclerView M;
    protected ImageView N;
    protected LinearLayoutManager P;
    protected bb Q;
    protected QCircleCommonLoadingDialog R;
    protected x S;
    protected MusicVolumeControlViewModel T;
    protected MetaMaterial U = null;
    protected boolean V = false;
    protected boolean W = false;
    protected String X = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        private final int f322379a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f322380b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f322381c;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.wink.editor.template.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        class C9042a implements ResDownLoadListener {
            C9042a() {
            }

            @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
            public void onDownloadFinish(boolean z16) {
                if (z16) {
                    WinkEditorResourceManager.a1().i0(a.this.f322381c);
                    a aVar = a.this;
                    m.this.Na(aVar.f322381c);
                } else {
                    m.this.Ma();
                }
                m.this.Ga();
            }

            @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
            public void onProgressUpdate(int i3) {
                a.this.d(i3, true);
            }
        }

        a(String[] strArr, MetaMaterial metaMaterial) {
            int i3;
            this.f322380b = strArr;
            this.f322381c = metaMaterial;
            if (strArr != null) {
                i3 = strArr.length;
            } else {
                i3 = 0;
            }
            this.f322379a = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i3) {
            QCircleCommonLoadingDialog qCircleCommonLoadingDialog = m.this.R;
            if (qCircleCommonLoadingDialog != null) {
                qCircleCommonLoadingDialog.setProgress(i3);
            }
            if (m.this.winkEditorViewModel.getIsSchemaTemplate()) {
                m mVar = m.this;
                if (mVar.U.f30533id.equals(mVar.X)) {
                    m.this.winkEditorViewModel.h5(false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(int i3, boolean z16) {
            int i16;
            final int i17;
            if (this.f322379a > 0) {
                i16 = 20;
            } else {
                i16 = 0;
            }
            if (i3 > 0 && i3 <= 100) {
                MetaMaterial metaMaterial = m.this.U;
                if (metaMaterial == null || metaMaterial.f30533id.equals(this.f322381c.f30533id)) {
                    if (z16) {
                        i17 = ((int) ((i16 / 100.0f) * i3)) + (100 - i16);
                    } else {
                        i17 = (int) (((100 - i16) / 100.0f) * i3);
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            m.a.this.c(i17);
                        }
                    });
                }
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            m mVar = m.this;
            if (mVar.V) {
                mVar.V = false;
                return;
            }
            if (z16) {
                if (this.f322379a > 0) {
                    WinkEditorResourceManager.a1().h0(this.f322381c, new C9042a());
                    return;
                } else {
                    mVar.Na(this.f322381c);
                    m.this.Ga();
                    return;
                }
            }
            mVar.Ma();
            m.this.Ga();
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
            d(i3, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ia(WinkEditorVideoTemplateMenuPart.g gVar, DialogInterface dialogInterface, int i3) {
        if (com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.isUserOpCloseSmartClip) {
            com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.isUserOpCloseSmartClip = false;
        }
        if (H9() != null && H9().p()) {
            this.winkEditorViewModel.s5(MenuType.ENHANCE);
        }
        gVar.onConfirm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ka() {
        Fa();
        Ca(false);
        this.winkEditorViewModel.h5(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void La() {
        this.V = true;
        this.W = false;
        this.winkEditorViewModel.W4(false);
        this.Q.T(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Aa(final WinkEditorVideoTemplateMenuPart.g gVar, String str, String str2) {
        dr H9 = H9();
        if (H9 == null) {
            return;
        }
        if ((!(H9 instanceof WinkVideoTavCut) || ((WinkVideoTavCut) H9).f().size() <= 0) && H9.y().size() <= 0 && !H9.p()) {
            gVar.onConfirm();
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        createCustomDialog.setTitle(str);
        createCustomDialog.setMessage(str2);
        createCustomDialog.setPositiveButton(getContext().getString(R.string.a8j), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                m.this.Ia(gVar, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(getContext().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorVideoTemplateMenuPart.g.this.onCancel();
            }
        });
        try {
            if (!createCustomDialog.isShowing()) {
                createCustomDialog.show();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ba() {
        if (H9() instanceof WinkVideoTavCut) {
            ((WinkVideoTavCut) H9()).g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ca(boolean z16) {
        this.W = z16;
        this.Q.T(z16);
        this.winkEditorViewModel.W4(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MusicVolumeControlViewModel Da() {
        if (this.T == null && getHostFragment().getActivity() != null) {
            this.T = (MusicVolumeControlViewModel) new ViewModelProvider(getHostFragment().getActivity()).get(MusicVolumeControlViewModel.class);
        }
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WinkEditorResourceDownloader.d Ea(@NonNull MetaMaterial metaMaterial) {
        return new a(WinkEditorResourceManager.a1().T0(metaMaterial), metaMaterial);
    }

    protected void Fa() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.R;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ga() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.k
            @Override // java.lang.Runnable
            public final void run() {
                m.this.Ka();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ha(String str) {
        return new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle bundle) {
        super.L9(bundle);
        G9().m5(false);
    }

    abstract void Ma();

    abstract void Na(MetaMaterial metaMaterial);

    protected void Oa() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getContext().getString(R.string.f215635w5));
        arrayList.add(getContext().getString(R.string.f215655w7));
        arrayList.add(getContext().getString(R.string.f215645w6));
        arrayList.add(getContext().getString(R.string.f215625w4));
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(getContext()).n(true).q(arrayList).e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.j
            @Override // java.lang.Runnable
            public final void run() {
                m.this.La();
            }
        }).a();
        this.R = a16;
        a16.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Pa() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.R;
        if (qCircleCommonLoadingDialog == null || !qCircleCommonLoadingDialog.isShowing()) {
            Ca(true);
            this.V = false;
            Oa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(View view) {
        super.initAfterInflation(view);
        this.S = (x) getViewModel(x.class);
        this.M = (RecyclerView) view.findViewById(R.id.xys);
        this.N = (ImageView) view.findViewById(R.id.xyr);
        this.M.setOverScrollMode(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.P = linearLayoutManager;
        linearLayoutManager.setAutoMeasureEnabled(false);
        this.M.setLayoutManager(this.P);
        this.Q = new bb(getContext(), this.winkEditorViewModel.getEditMode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void la() {
        G9().m5(true);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        String str;
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof ReceiveSchemaEvent) {
            HashMap hashMap = (HashMap) ((ReceiveSchemaEvent) simpleBaseEvent).getAttrs();
            if (!hashMap.isEmpty() && hashMap.containsKey("template")) {
                str = (String) hashMap.get("template");
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                if (getHostFragment() != null && getHostFragment().getActivity() != null) {
                    I9();
                    this.X = str;
                    this.winkEditorViewModel.h5(true);
                    bb bbVar = this.Q;
                    if (bbVar != null) {
                        bbVar.Q(this.X);
                        return;
                    }
                    return;
                }
                ms.a.c(this.TAG, "initAfterInflation getactivity() failed");
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof TemplateSelectEvent) {
            TemplateSelectEvent templateSelectEvent = (TemplateSelectEvent) simpleBaseEvent;
            MetaMaterial material = templateSelectEvent.getMaterial();
            boolean needRender = templateSelectEvent.getNeedRender();
            if (material != null && this.Q != null && (H9() instanceof WinkVideoTavCut)) {
                if (needRender) {
                    String str2 = material.f30533id;
                    if (str2 != null) {
                        this.Q.Q(str2);
                        return;
                    }
                    return;
                }
                int C = this.Q.C(material.f30533id);
                if (C != -1) {
                    this.Q.a0(C);
                }
            }
        }
    }
}
