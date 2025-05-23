package com.qzone.reborn.albumx.qzonex.part.main;

import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc.bn;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/main/e;", "Lcom/qzone/reborn/base/k;", "", "tabIndex", "", "N9", "G9", "", "canUploadMedia", "I9", "J9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lnc/bn;", "d", "Lnc/bn;", "mainTabViewModel", "e", "Landroid/view/View;", "ivPlusBtn", "f", "Ljava/lang/String;", "tabReportPageId", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bn mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View ivPlusBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String tabReportPageId = "pg_qz_space_album_list_new";

    private final void G9() {
        fo.b bVar = new fo.b();
        bVar.h(new IDynamicParams() { // from class: com.qzone.reborn.albumx.qzonex.part.main.d
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map H9;
                H9 = e.H9(str);
                return H9;
            }
        });
        bVar.k(ExposurePolicy.REPORT_NONE);
        View view = this.ivPlusBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
            view = null;
        }
        fo.c.o(view, "em_qz_plus_suspend", bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map H9(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c());
        return linkedHashMap;
    }

    private final void J9() {
        bn bnVar = this.mainTabViewModel;
        bn bnVar2 = null;
        if (bnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar = null;
        }
        Integer value = bnVar.e2().getValue();
        int i3 = (value != null && value.intValue() == 2) ? 10 : 1;
        bn bnVar3 = this.mainTabViewModel;
        if (bnVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
        } else {
            bnVar2 = bnVar3;
        }
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = new QZAlbumxUploadAlbumInitBean(bnVar2.b2().getUin(), 0, true, null, i3);
        vb.b x16 = ho.i.x();
        Intrinsics.checkNotNullExpressionValue(x16, "qzAlbumx()");
        vb.b.m(x16, getContext(), qZAlbumxUploadAlbumInitBean, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(e this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean booleanValue = it.booleanValue();
        bn bnVar = this$0.mainTabViewModel;
        if (bnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar = null;
        }
        this$0.I9(booleanValue, bnVar.getTabIndex());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(e this$0, Integer tabIndex) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(tabIndex, "tabIndex");
        this$0.N9(tabIndex.intValue());
        bn bnVar = this$0.mainTabViewModel;
        if (bnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar = null;
        }
        Boolean value = bnVar.Z1().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        this$0.I9(value.booleanValue(), tabIndex.intValue());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxMainPagePlusMenuPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(bn.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxMai\u2026TabViewModel::class.java)");
        this.mainTabViewModel = (bn) viewModel;
        View findViewById = rootView.findViewById(R.id.n9w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_publish_plus_btn)");
        this.ivPlusBtn = findViewById;
        View findViewById2 = rootView.findViewById(R.id.n9w);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qzone_publish_plus_btn)");
        this.ivPlusBtn = findViewById2;
        bn bnVar = null;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
            findViewById2 = null;
        }
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.main.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.K9(e.this, view);
            }
        });
        View view = this.ivPlusBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
            view = null;
        }
        view.setVisibility(8);
        ViewModel viewModel2 = getViewModel(bn.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZAlbumxMai\u2026TabViewModel::class.java)");
        bn bnVar2 = (bn) viewModel2;
        this.mainTabViewModel = bnVar2;
        if (bnVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar2 = null;
        }
        bnVar2.Z1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.main.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.L9(e.this, (Boolean) obj);
            }
        });
        bn bnVar3 = this.mainTabViewModel;
        if (bnVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
        } else {
            bnVar = bnVar3;
        }
        bnVar.e2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.main.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.M9(e.this, (Integer) obj);
            }
        });
        G9();
    }

    private final void I9(boolean canUploadMedia, int tabIndex) {
        View view = null;
        if (canUploadMedia && tabIndex != 3) {
            View view2 = this.ivPlusBtn;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = this.ivPlusBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    private final void N9(int tabIndex) {
        if (tabIndex == 0) {
            this.tabReportPageId = "pg_qz_space_album_list_new";
            return;
        }
        if (tabIndex == 1) {
            this.tabReportPageId = "pg_qz_pic_list";
        } else if (tabIndex == 2) {
            this.tabReportPageId = "pg_qz_video_list";
        } else {
            if (tabIndex != 3) {
                return;
            }
            this.tabReportPageId = "pg_qz_recommend_content_for_you";
        }
    }
}
