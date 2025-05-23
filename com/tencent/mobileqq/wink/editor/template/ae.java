package com.tencent.mobileqq.wink.editor.template;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.cu;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart;
import com.tencent.mobileqq.wink.editor.template.ae;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.model.MediaClip;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.light.AudioOutputConfig;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.VideoOutputConfig;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ae extends m {
    private List<MediaClip> Y;
    private List<LocalMediaInfo> Z;

    /* renamed from: a0, reason: collision with root package name */
    private WinkEditorViewModel f322314a0;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements AbsWinkMaterialPanelContentAdapter.d {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.d
        public void a(int i3, @Nullable MetaMaterial metaMaterial) {
            if (metaMaterial == null) {
                return;
            }
            com.tencent.mobileqq.wink.editor.template.c.f322362a.i(ae.this.M, metaMaterial.f30533id, true, null);
        }

        @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.c
        public void b(int i3, @Nullable MetaMaterial metaMaterial) {
            if (metaMaterial == null) {
                return;
            }
            com.tencent.mobileqq.wink.editor.template.c.f322362a.h(ae.this.M, metaMaterial.f30533id, true, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ae.this.G9().l5();
            com.tencent.mobileqq.wink.editor.template.c.f322362a.e(ae.this.N, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private LocalMediaInfo Ya(LocalMediaInfo localMediaInfo) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(localMediaInfo);
            return (LocalMediaInfo) new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (IOException | ClassNotFoundException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private com.tencent.mobileqq.wink.flow.b Za() {
        return new c();
    }

    private MetaMaterial ab() {
        MetaMaterial metaMaterial = (MetaMaterial) getActivity().getIntent().getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        String stringExtra = getActivity().getIntent().getStringExtra("local_template_path");
        String stringExtra2 = getActivity().getIntent().getStringExtra("lib_template_id");
        if (metaMaterial == null && !TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            MetaMaterial P1 = WinkEditorResourceManager.a1().P1(stringExtra2);
            WinkEditorResourceManager.a1().j0(stringExtra2);
            return P1;
        }
        return metaMaterial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bb(com.tencent.mobileqq.wink.editor.model.b bVar) {
        if (this.f322314a0.a2()) {
            List<MetaMaterial> b16 = bVar.b();
            ms.a.a(this.TAG, String.format(Locale.CHINA, "material list size: %d", Integer.valueOf(b16.size())));
            bb bbVar = this.Q;
            if (bbVar != null) {
                bbVar.Y(b16);
                this.M.setAdapter(this.Q);
                if (!TextUtils.isEmpty(this.X)) {
                    this.Q.Q(this.X);
                }
                Ba();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void cb() {
        this.Q.a0(-1);
        this.Q.notifyDataSetChanged();
        kb(null);
        QQToast.makeText(getContext(), 1, getContext().getString(R.string.f215185ux), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fb(MetaMaterial metaMaterial) {
        bb bbVar = this.Q;
        if (bbVar != null) {
            bbVar.d0(metaMaterial.f30533id, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gb(final MetaMaterial metaMaterial) {
        com.tencent.videocut.utils.thread.c.f384289c.e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.ac
            @Override // java.lang.Runnable
            public final void run() {
                ae.this.fb(metaMaterial);
            }
        });
        com.tencent.mobileqq.wink.editor.c.D1(metaMaterial, WinkEditorResourceManager.a1().m(metaMaterial));
        kb(metaMaterial);
        eb(metaMaterial);
        Ca(false);
        String str = this.f322314a0.getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String();
        if (!TextUtils.isEmpty(str)) {
            y53.e.d().a(str, metaMaterial.f30533id, new WinkPublishQualityReportData.Builder().eventId("P_MATERIAL_COST_END").ext1(metaMaterial.f30533id).ext2("video").retCode("0").getReportData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hb(List list, ArrayList arrayList) {
        if (H9() instanceof WinkVideoTavCut) {
            ((WinkVideoTavCut) H9()).s3(list, false, false);
        }
        this.f322314a0.e2(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ib, reason: merged with bridge method [inline-methods] */
    public void eb(MetaMaterial metaMaterial) {
        MediaClip f16;
        LocalMediaInfo Ya;
        if (H9() != null) {
            this.Y = H9().g0();
        }
        List<MediaClip> list = this.Y;
        if (list != null && list.size() >= 1) {
            LightAsset Load = LightAsset.Load(WinkEditorResourceManager.a1().m(metaMaterial), 100);
            LightEngine make = LightEngine.make(new VideoOutputConfig(30.0f, 0), new AudioOutputConfig(), new RendererConfig());
            ClipPlaceHolder[] clipPlaceHolderArr = null;
            if (make != null) {
                MovieController assetForMovie = make.setAssetForMovie(Load);
                if (assetForMovie != null) {
                    clipPlaceHolderArr = assetForMovie.getClipPlaceHolders();
                }
                make.release();
            }
            if (clipPlaceHolderArr == null) {
                return;
            }
            final ArrayList arrayList = new ArrayList();
            final ArrayList<LocalMediaInfo> arrayList2 = new ArrayList<>();
            for (int i3 = 0; i3 < clipPlaceHolderArr.length; i3++) {
                if (i3 < this.Y.size()) {
                    f16 = this.Y.get(i3);
                } else {
                    List<MediaClip> list2 = this.Y;
                    f16 = com.tencent.videocut.render.extension.e.f(list2.get(list2.size() - 1));
                }
                arrayList.add(com.tencent.videocut.render.extension.e.F(f16, clipPlaceHolderArr[i3].contentDuration));
                if (i3 < this.Z.size()) {
                    Ya = this.Z.get(i3);
                } else {
                    List<LocalMediaInfo> list3 = this.Z;
                    Ya = Ya(list3.get(list3.size() - 1));
                    if (Ya == null) {
                        List<LocalMediaInfo> list4 = this.Z;
                        Ya = list4.get(list4.size() - 1);
                    }
                }
                Ya.mDuration = clipPlaceHolderArr[i3].contentDuration;
                arrayList2.add(Ya);
            }
            getActivity().getIntent().putParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA, arrayList2);
            this.f322314a0.e5(arrayList2);
            this.Z = arrayList2;
            com.tencent.videocut.utils.thread.c.f384289c.e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.ad
                @Override // java.lang.Runnable
                public final void run() {
                    ae.this.hb(arrayList, arrayList2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb(MetaMaterial metaMaterial) {
        boolean z16;
        if (metaMaterial != null) {
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(metaMaterial.f30533id);
        }
        if (H9() instanceof WinkVideoTavCut) {
            if (Da() != null && Da().getIsOriginalVolumeChangedManually()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.S.b2(metaMaterial, this.f322314a0.getIsFromTemplateColl(), z16, getContext());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f1170870h;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        super.J9(editMode);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.m, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle bundle) {
        super.L9(bundle);
        ms.a.a(this.TAG, "onShow");
        com.tencent.mobileqq.wink.editor.template.c.f322362a.f(this.N, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void M9() {
        super.M9();
        final MetaMaterial ab5 = ab();
        if (ab5 != null) {
            if (this.f322314a0 == null) {
                this.f322314a0 = (WinkEditorViewModel) getViewModel(WinkEditorViewModel.class);
            }
            if (this.f322314a0.a2()) {
                I9();
                com.tencent.videocut.utils.thread.c.f384289c.c(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        ae.this.eb(ab5);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.template.m
    protected void Ma() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.z
            @Override // java.lang.Runnable
            public final void run() {
                ae.this.cb();
            }
        });
        cu.F(false);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.m
    protected void Na(final MetaMaterial metaMaterial) {
        Ca(true);
        com.tencent.videocut.utils.thread.c.f384289c.c(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.ab
            @Override // java.lang.Runnable
            public final void run() {
                ae.this.gb(metaMaterial);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NonNull
    public MenuType ba() {
        return MenuType.VIDEO_FIRST_TEMPLATE;
    }

    @Override // com.tencent.mobileqq.wink.editor.template.m, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    protected void initAfterInflation(View view) {
        super.initAfterInflation(view);
        if (this.f322314a0 == null) {
            this.f322314a0 = (WinkEditorViewModel) getViewModel(WinkEditorViewModel.class);
        }
        bb bbVar = this.Q;
        if (bbVar != null) {
            bbVar.S(Za());
            this.Q.V(new a());
        }
        aa().getFirstTemplatesVOLiveData().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.template.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ae.this.bb((com.tencent.mobileqq.wink.editor.model.b) obj);
            }
        });
        this.N.setOnClickListener(new b());
        if (H9() != null) {
            this.Y = H9().g0();
        }
        if (getActivity() != null && getActivity().getIntent() != null) {
            this.Z = this.f322314a0.R2();
        }
    }

    public void jb(boolean z16) {
        int i3;
        if (getPartRootView() != null) {
            View partRootView = getPartRootView();
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            partRootView.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NonNull View view) {
        super.onInitView(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c extends com.tencent.mobileqq.wink.flow.b {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes21.dex */
        public class b implements ResDownLoadListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ MetaMaterial f322321a;

            b(MetaMaterial metaMaterial) {
                this.f322321a = metaMaterial;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b(int i3) {
                ae aeVar;
                MetaMaterial metaMaterial;
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog = ae.this.R;
                if (qCircleCommonLoadingDialog != null) {
                    qCircleCommonLoadingDialog.setProgress(i3);
                }
                if (ae.this.f322314a0.getIsSchemaTemplate() && (metaMaterial = (aeVar = ae.this).U) != null && metaMaterial.f30533id.equals(aeVar.X)) {
                    ae.this.f322314a0.h5(false);
                }
            }

            @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
            public void onDownloadFinish(boolean z16) {
                if (z16) {
                    WinkEditorResourceManager.a1().i0(this.f322321a);
                    ae.this.Na(this.f322321a);
                } else {
                    ae.this.Ma();
                }
                ae.this.Ga();
            }

            @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
            public void onProgressUpdate(final int i3) {
                if (i3 > 0 && i3 <= 100) {
                    MetaMaterial metaMaterial = ae.this.U;
                    if (metaMaterial == null || metaMaterial.f30533id.equals(this.f322321a.f30533id)) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.af
                            @Override // java.lang.Runnable
                            public final void run() {
                                ae.c.b.this.b(i3);
                            }
                        });
                    }
                }
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i3, @NonNull MetaMaterial metaMaterial) {
            if (TextUtils.isEmpty(metaMaterial.packageUrl)) {
                ae.this.Q.notifyDataSetChanged();
                return;
            }
            if (!ae.this.Ha(WinkEditorResourceManager.a1().m(metaMaterial))) {
                if (!NetworkUtil.isNetworkAvailable()) {
                    QQToast.makeText(ae.this.getContext(), 1, ae.this.getContext().getString(R.string.ynb), 0).show();
                    ae.this.Q.a0(-1);
                    ae.this.Q.notifyDataSetChanged();
                    ae.this.kb(null);
                    return;
                }
                ae aeVar = ae.this;
                aeVar.U = metaMaterial;
                aeVar.Pa();
                WinkEditorResourceManager.a1().f(metaMaterial, ae.this.Ea(metaMaterial));
                return;
            }
            if (WinkEditorResourceManager.a1().o2(metaMaterial)) {
                WinkEditorResourceManager.a1().i0(metaMaterial);
                ae.this.Na(metaMaterial);
            } else {
                WinkEditorResourceManager.a1().h0(metaMaterial, new b(metaMaterial));
                ae.this.Pa();
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void Q(int i3, @NonNull MetaMaterial metaMaterial) {
            ae aeVar = ae.this;
            if (aeVar.W) {
                return;
            }
            aeVar.Aa(new a(i3, metaMaterial), ae.this.getContext().getString(R.string.f215205uz), ae.this.getContext().getString(R.string.f215195uy));
        }

        /* compiled from: P */
        /* loaded from: classes21.dex */
        class a implements WinkEditorVideoTemplateMenuPart.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f322318a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MetaMaterial f322319b;

            a(int i3, MetaMaterial metaMaterial) {
                this.f322318a = i3;
                this.f322319b = metaMaterial;
            }

            @Override // com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.g
            public void onConfirm() {
                c.this.b(this.f322318a, this.f322319b);
            }

            @Override // com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.g
            public void onCancel() {
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void K9() {
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
