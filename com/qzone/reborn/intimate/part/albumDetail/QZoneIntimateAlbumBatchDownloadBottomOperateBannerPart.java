package com.qzone.reborn.intimate.part.albumDetail;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZonePermission;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.aa;
import nk.w;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumDetail/QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "G9", "", "count", "M9", "I9", "L9", "", "getLogTag", "onInitView", "v", NodeProps.ON_CLICK, "Lnk/aa;", "d", "Lnk/aa;", "operateViewModel", "Lnk/w;", "e", "Lnk/w;", "albumDetailViewModel", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "f", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "btnDownload", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "<set-?>", tl.h.F, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "H9", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "initBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private aa operateViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private w albumDetailViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIButton btnDownload;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateAlbumDetailInitBean initBean;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/intimate/part/albumDetail/QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            aa aaVar = QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart.this.operateViewModel;
            aa aaVar2 = null;
            if (aaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
                aaVar = null;
            }
            String spaceId = QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart.this.H9().getSpaceId();
            String valueOf = String.valueOf(QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart.this.H9().getSpaceType());
            aa aaVar3 = QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart.this.operateViewModel;
            if (aaVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                aaVar2 = aaVar3;
            }
            aaVar.m2(spaceId, valueOf, aaVar2.W1());
            QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart.this.L9();
        }
    }

    private final void I9() {
        if (QZonePermission.requestStoragePermission(getActivity(), new a(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            aa aaVar = this.operateViewModel;
            aa aaVar2 = null;
            if (aaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
                aaVar = null;
            }
            String spaceId = H9().getSpaceId();
            String valueOf = String.valueOf(H9().getSpaceType());
            aa aaVar3 = this.operateViewModel;
            if (aaVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                aaVar2 = aaVar3;
            }
            aaVar.m2(spaceId, valueOf, aaVar2.W1());
            L9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.M9(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        QQToast.makeText(getContext(), 0, com.qzone.util.l.a(R.string.smd), 0).show();
        getActivity().onBackPressed();
    }

    public final QZoneIntimateAlbumDetailInitBean H9() {
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = this.initBean;
        if (qZoneIntimateAlbumDetailInitBean != null) {
            return qZoneIntimateAlbumDetailInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f19525x) {
            I9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Activity activity = getActivity();
        w wVar = null;
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = serializableExtra instanceof QZoneIntimateAlbumDetailInitBean ? (QZoneIntimateAlbumDetailInitBean) serializableExtra : null;
        Intrinsics.checkNotNull(qZoneIntimateAlbumDetailInitBean);
        this.initBean = qZoneIntimateAlbumDetailInitBean;
        View findViewById = rootView.findViewById(R.id.f19525x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.btn_download)");
        QUIButton qUIButton = (QUIButton) findViewById;
        this.btnDownload = qUIButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(this);
        ViewModel viewModel = getViewModel(aa.class);
        Intrinsics.checkNotNull(viewModel);
        aa aaVar = (aa) viewModel;
        aaVar.a2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.intimate.part.albumDetail.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart.J9(QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart.this, (Integer) obj);
            }
        });
        this.operateViewModel = aaVar;
        ViewModel viewModel2 = getViewModel(w.class);
        Intrinsics.checkNotNull(viewModel2);
        w wVar2 = (w) viewModel2;
        this.albumDetailViewModel = wVar2;
        if (wVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumDetailViewModel");
        } else {
            wVar = wVar2;
        }
        MutableLiveData<CommonAlbumInfo> M1 = wVar.M1();
        Fragment hostFragment = getHostFragment();
        final Function1<CommonAlbumInfo, Unit> function1 = new Function1<CommonAlbumInfo, Unit>() { // from class: com.qzone.reborn.intimate.part.albumDetail.QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonAlbumInfo commonAlbumInfo) {
                invoke2(commonAlbumInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommonAlbumInfo it) {
                aa aaVar2 = QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart.this.operateViewModel;
                if (aaVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
                    aaVar2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aaVar2.k2(it);
            }
        };
        M1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.intimate.part.albumDetail.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart.K9(Function1.this, obj);
            }
        });
        G9(rootView);
    }

    private final void M9(int count) {
        QUIButton qUIButton = null;
        if (count <= 0) {
            QUIButton qUIButton2 = this.btnDownload;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
                qUIButton2 = null;
            }
            qUIButton2.setText(R.string.smc);
            QUIButton qUIButton3 = this.btnDownload;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
                qUIButton3 = null;
            }
            qUIButton3.setClickable(false);
            QUIButton qUIButton4 = this.btnDownload;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
            } else {
                qUIButton = qUIButton4;
            }
            qUIButton.setEnabled(false);
            return;
        }
        QUIButton qUIButton5 = this.btnDownload;
        if (qUIButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
            qUIButton5 = null;
        }
        QUIButton qUIButton6 = this.btnDownload;
        if (qUIButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
            qUIButton6 = null;
        }
        Resources resources = qUIButton6.getResources();
        qUIButton5.setText(resources != null ? resources.getString(R.string.slr, Integer.valueOf(count)) : null);
        QUIButton qUIButton7 = this.btnDownload;
        if (qUIButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
            qUIButton7 = null;
        }
        qUIButton7.setClickable(true);
        QUIButton qUIButton8 = this.btnDownload;
        if (qUIButton8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
        } else {
            qUIButton = qUIButton8;
        }
        qUIButton.setEnabled(true);
    }

    private final void G9(View rootView) {
        View findViewById = rootView.findViewById(R.id.nf7);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
        LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = ar.d(77.0f);
        recyclerView.setLayoutParams(layoutParams2);
    }
}
