package com.tencent.mobileqq.wink.editor.template;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart;
import com.tencent.mobileqq.wink.editor.template.bh;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\r\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0016\u0010\u001e\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/bh;", "Lcom/tencent/mobileqq/wink/editor/template/m;", "Lcom/tencent/mobileqq/wink/flow/b;", "Xa", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "Wa", "fb", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Ya", "ab", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "", "B9", "Na", "Ma", "oa", "Landroid/os/Bundle;", "args", "L9", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "Y", "I", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT, "Z", "picCount", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class bh extends m {

    /* renamed from: Y, reason: from kotlin metadata */
    private int videoCount = -1;

    /* renamed from: Z, reason: from kotlin metadata */
    private int picCount = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/template/bh$a", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f322356a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bh f322357b;

        a(MetaMaterial metaMaterial, bh bhVar) {
            this.f322356a = metaMaterial;
            this.f322357b = bhVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(bh this$0, int i3) {
            MetaMaterial metaMaterial;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.R;
            if (qCircleCommonLoadingDialog != null) {
                qCircleCommonLoadingDialog.setProgress(i3);
            }
            if (this$0.G9().getIsSchemaTemplate() && (metaMaterial = this$0.U) != null && Intrinsics.areEqual(metaMaterial.f30533id, this$0.X)) {
                this$0.G9().h5(false);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                WinkEditorResourceManager.a1().i0(this.f322356a);
                this.f322357b.Na(this.f322356a);
            } else {
                this.f322357b.Ma();
            }
            this.f322357b.Ga();
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(final int progress) {
            boolean z16 = false;
            if (1 <= progress && progress < 101) {
                z16 = true;
            }
            if (z16) {
                MetaMaterial metaMaterial = this.f322357b.U;
                if (metaMaterial == null || Intrinsics.areEqual(metaMaterial.f30533id, this.f322356a.f30533id)) {
                    MqqHandler uIHandler = ThreadManager.getUIHandler();
                    final bh bhVar = this.f322357b;
                    uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.bg
                        @Override // java.lang.Runnable
                        public final void run() {
                            bh.a.b(bh.this, progress);
                        }
                    });
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/template/bh$c", "Lcom/tencent/mobileqq/wink/view/AbsWinkMaterialPanelContentAdapter$d;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements AbsWinkMaterialPanelContentAdapter.d {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.d
        public void a(int position, @Nullable MetaMaterial material) {
            if (material == null) {
                return;
            }
            com.tencent.mobileqq.wink.editor.template.c cVar = com.tencent.mobileqq.wink.editor.template.c.f322362a;
            RecyclerView rvFirstTemplateContentView = bh.this.M;
            Intrinsics.checkNotNullExpressionValue(rvFirstTemplateContentView, "rvFirstTemplateContentView");
            String str = material.f30533id;
            Intrinsics.checkNotNullExpressionValue(str, "material.id");
            cVar.i(rvFirstTemplateContentView, str, true, bh.this.Ya());
        }

        @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.c
        public void b(int position, @Nullable MetaMaterial material) {
            if (material == null) {
                return;
            }
            com.tencent.mobileqq.wink.editor.template.c cVar = com.tencent.mobileqq.wink.editor.template.c.f322362a;
            RecyclerView rvFirstTemplateContentView = bh.this.M;
            Intrinsics.checkNotNullExpressionValue(rvFirstTemplateContentView, "rvFirstTemplateContentView");
            String str = material.f30533id;
            Intrinsics.checkNotNullExpressionValue(str, "material.id");
            cVar.h(rvFirstTemplateContentView, str, true, bh.this.Ya());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wa(MetaMaterial material) {
        if (TextUtils.isEmpty(material.packageUrl)) {
            this.Q.notifyDataSetChanged();
            return;
        }
        String m3 = WinkEditorResourceManager.a1().m(material);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
        if (!Ha(m3)) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(getContext(), 1, getContext().getString(R.string.ynb), 0).show();
                this.Q.a0(-1);
                this.Q.notifyDataSetChanged();
                fb(null);
                return;
            }
            this.U = material;
            Pa();
            WinkEditorResourceManager.a1().f(material, Ea(material));
            return;
        }
        if (WinkEditorResourceManager.a1().o2(material)) {
            WinkEditorResourceManager.a1().i0(material);
            Na(material);
        } else {
            WinkEditorResourceManager.a1().h0(material, new a(material, this));
            Pa();
        }
    }

    private final com.tencent.mobileqq.wink.flow.b Xa() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, Object> Ya() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, Integer.valueOf(this.videoCount));
        hashMap.put("xsj_picture_num", Integer.valueOf(this.picCount));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Za(bh this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9().l5();
        com.tencent.mobileqq.wink.editor.template.c cVar = com.tencent.mobileqq.wink.editor.template.c.f322362a;
        ImageView ivFirstTemplateClose = this$0.N;
        Intrinsics.checkNotNullExpressionValue(ivFirstTemplateClose, "ivFirstTemplateClose");
        cVar.e(ivFirstTemplateClose, this$0.Ya());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ab() {
        if (this.videoCount >= 0 && this.picCount >= 0) {
            return;
        }
        this.videoCount = 0;
        this.picCount = 0;
        ArrayList<LocalMediaInfo> R2 = G9().R2();
        if (R2 != null) {
            Iterator<T> it = R2.iterator();
            while (it.hasNext()) {
                if (e93.i.I((LocalMediaInfo) it.next())) {
                    this.videoCount++;
                } else {
                    this.picCount++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bb(bh this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q.a0(-1);
        this$0.Q.notifyDataSetChanged();
        this$0.fb(null);
        QQToast.makeText(this$0.getContext(), 1, this$0.getContext().getString(R.string.f215185ux), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cb(final MetaMaterial metaMaterial, final bh this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.videocut.utils.thread.c.f384289c.e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.bf
            @Override // java.lang.Runnable
            public final void run() {
                bh.eb(bh.this, metaMaterial);
            }
        });
        if (metaMaterial != null) {
            String m3 = WinkEditorResourceManager.a1().m(metaMaterial);
            Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
            com.tencent.mobileqq.wink.editor.c.D1(metaMaterial, m3);
        }
        this$0.fb(metaMaterial);
        this$0.Ca(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eb(bh this$0, MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bb bbVar = this$0.Q;
        if (bbVar != null) {
            Intrinsics.checkNotNull(metaMaterial);
            bbVar.d0(metaMaterial.f30533id, false);
        }
    }

    private final void fb(MetaMaterial material) {
        boolean z16;
        if (H9() instanceof WinkVideoTavCut) {
            if (Da() != null && Da().getIsOriginalVolumeChangedManually()) {
                z16 = true;
            } else {
                z16 = false;
            }
            x xVar = this.S;
            boolean isFromTemplateColl = G9().getIsFromTemplateColl();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            xVar.b2(material, isFromTemplateColl, z16, context);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f70973mw;
    }

    @Override // com.tencent.mobileqq.wink.editor.template.m, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    protected void L9(@Nullable Bundle args) {
        com.tencent.mobileqq.wink.editor.template.c cVar = com.tencent.mobileqq.wink.editor.template.c.f322362a;
        ImageView ivFirstTemplateClose = this.N;
        Intrinsics.checkNotNullExpressionValue(ivFirstTemplateClose, "ivFirstTemplateClose");
        cVar.f(ivFirstTemplateClose, Ya());
        super.L9(args);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.m
    protected void Ma() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.bd
            @Override // java.lang.Runnable
            public final void run() {
                bh.bb(bh.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.template.m
    protected void Na(@Nullable final MetaMaterial material) {
        Ca(true);
        com.tencent.videocut.utils.thread.c.f384289c.c(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.be
            @Override // java.lang.Runnable
            public final void run() {
                bh.cb(MetaMaterial.this, this);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.VIDEO_QZONE_ALBUM_RECOMMEND;
    }

    @Override // com.tencent.mobileqq.wink.editor.template.m, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    protected void initAfterInflation(@NotNull View rootView) {
        bb bbVar;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        ab();
        this.N.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.bc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bh.Za(bh.this, view);
            }
        });
        ArrayList<MetaMaterial> arrayList = com.tencent.mobileqq.wink.edit.manager.h.d().f318436e;
        if (arrayList != null) {
            this.Q.Y(arrayList);
            this.M.setAdapter(this.Q);
            if (!TextUtils.isEmpty(this.X) && (bbVar = this.Q) != null) {
                bbVar.Q(this.X);
            }
            Ba();
        }
        this.Q.S(Xa());
        this.Q.V(new c());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/template/bh$b", "Lcom/tencent/mobileqq/wink/flow/b;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.mobileqq.wink.flow.b {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void Q(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            bh bhVar = bh.this;
            if (bhVar.W) {
                return;
            }
            bhVar.Aa(new a(bhVar, material), bh.this.getContext().getString(R.string.f215205uz), bh.this.getContext().getString(R.string.f215195uy));
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/editor/template/bh$b$a", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorVideoTemplateMenuPart$g;", "", "onConfirm", "onCancel", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a implements WinkEditorVideoTemplateMenuPart.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ bh f322359a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MetaMaterial f322360b;

            a(bh bhVar, MetaMaterial metaMaterial) {
                this.f322359a = bhVar;
                this.f322360b = metaMaterial;
            }

            @Override // com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.g
            public void onConfirm() {
                this.f322359a.Wa(this.f322360b);
            }

            @Override // com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.g
            public void onCancel() {
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
