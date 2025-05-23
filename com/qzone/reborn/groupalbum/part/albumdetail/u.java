package com.qzone.reborn.groupalbum.part.albumdetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.QunMediaRightEnum;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\r\u001a\u00020\u00022\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bH\u0002J\u001c\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010%\u001a\u00020\u0002H\u0014J\b\u0010&\u001a\u00020\u0002H\u0014J\b\u0010'\u001a\u00020\u001bH\u0016J\"\u0010,\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010*H\u0016R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00104\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010/R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u00107\u00a8\u0006J"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/albumdetail/u;", "Lcom/qzone/reborn/albumx/common/part/CommonAlbumDetailTitlePart;", "", "pa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "xa", "", WidgetCacheConstellationData.NUM, "Ga", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "right", "wa", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/a;", "uiStateData", "sa", "ra", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "qa", "ta", "va", "ua", "", "isOperateMode", "Fa", "na", "oa", "", "getLogTag", "onInitView", "v", NodeProps.ON_CLICK, "D9", "E9", "onBackEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/widget/RelativeLayout;", "M", "Landroid/widget/RelativeLayout;", "rlNormalTitleLayout", "N", "rlOperateLayout", "P", "rlOperateContainer", "Landroid/widget/FrameLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/FrameLayout;", "flTitleBar", "Lcom/qzone/reborn/groupalbum/viewmodel/b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/qzone/reborn/groupalbum/viewmodel/b;", "albumViewModel", ExifInterface.LATITUDE_SOUTH, "Z", "isAllSelectMode", "Lcom/qzone/reborn/groupalbum/viewmodel/h;", "T", "Lcom/qzone/reborn/groupalbum/viewmodel/h;", "operateViewModel", "U", "flTransmitLayout", "<init>", "()V", "V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class u extends CommonAlbumDetailTitlePart {

    /* renamed from: M, reason: from kotlin metadata */
    private RelativeLayout rlNormalTitleLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private RelativeLayout rlOperateLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private RelativeLayout rlOperateContainer;

    /* renamed from: Q, reason: from kotlin metadata */
    private FrameLayout flTitleBar;

    /* renamed from: R, reason: from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.b albumViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isAllSelectMode;

    /* renamed from: T, reason: from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.h operateViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private FrameLayout flTransmitLayout;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(u this$0, CommonAlbumInfo commonAlbumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9().setText(commonAlbumInfo.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(u this$0, UIStateData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.sa(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(u this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Fa(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(u this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Ga(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(u this$0, com.qzone.reborn.groupalbum.viewmodel.h hVar, Unit unit) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean value = hVar.d2().getValue();
        Intrinsics.checkNotNull(value);
        this$0.Fa(value.booleanValue());
    }

    private final void Fa(boolean isOperateMode) {
        RelativeLayout relativeLayout = null;
        com.qzone.reborn.groupalbum.viewmodel.h hVar = null;
        if (isOperateMode) {
            RelativeLayout relativeLayout2 = this.rlNormalTitleLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlNormalTitleLayout");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(8);
            RelativeLayout relativeLayout3 = this.rlOperateLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlOperateLayout");
                relativeLayout3 = null;
            }
            relativeLayout3.setVisibility(0);
            com.qzone.reborn.groupalbum.viewmodel.h hVar2 = this.operateViewModel;
            if (hVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
                hVar2 = null;
            }
            if (hVar2.e2()) {
                N9().setText(com.qzone.util.l.a(R.string.snr));
            } else {
                N9().setText(com.qzone.util.l.a(R.string.sni));
            }
            com.qzone.reborn.groupalbum.viewmodel.h hVar3 = this.operateViewModel;
            if (hVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                hVar = hVar3;
            }
            this.isAllSelectMode = hVar.e2();
        } else {
            RelativeLayout relativeLayout4 = this.rlNormalTitleLayout;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlNormalTitleLayout");
                relativeLayout4 = null;
            }
            relativeLayout4.setVisibility(0);
            RelativeLayout relativeLayout5 = this.rlOperateLayout;
            if (relativeLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlOperateLayout");
            } else {
                relativeLayout = relativeLayout5;
            }
            relativeLayout.setVisibility(8);
            this.isAllSelectMode = false;
            N9().setText(com.qzone.util.l.a(R.string.sni));
        }
        VideoReport.traversePage(getPartRootView());
    }

    private final void na() {
        ViewGroup.LayoutParams layoutParams = I9().getLayoutParams();
        if (layoutParams.height != ef.d.b(26)) {
            layoutParams.height = ef.d.b(26);
            layoutParams.width = ef.d.b(26);
            I9().setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = G9().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (marginLayoutParams.rightMargin != ef.d.b(0)) {
            marginLayoutParams.rightMargin = ef.d.b(0);
            G9().setLayoutParams(marginLayoutParams);
        }
        FrameLayout frameLayout = this.flTransmitLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flTransmitLayout");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams3 = frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams3;
        if (marginLayoutParams2.rightMargin != ef.d.b(0)) {
            marginLayoutParams2.rightMargin = ef.d.b(0);
            FrameLayout frameLayout3 = this.flTransmitLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flTransmitLayout");
            } else {
                frameLayout2 = frameLayout3;
            }
            frameLayout2.setLayoutParams(marginLayoutParams2);
        }
    }

    private final void oa() {
        ViewGroup.LayoutParams layoutParams = I9().getLayoutParams();
        if (layoutParams.height != ef.d.b(20)) {
            layoutParams.height = ef.d.b(20);
            layoutParams.width = ef.d.b(20);
            I9().setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = G9().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (marginLayoutParams.rightMargin != ef.d.b(8)) {
            marginLayoutParams.rightMargin = ef.d.b(8);
            G9().setLayoutParams(marginLayoutParams);
        }
        FrameLayout frameLayout = this.flTransmitLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flTransmitLayout");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams3 = frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams3;
        if (marginLayoutParams2.rightMargin != ef.d.b(8)) {
            marginLayoutParams2.rightMargin = ef.d.b(8);
            FrameLayout frameLayout3 = this.flTransmitLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flTransmitLayout");
            } else {
                frameLayout2 = frameLayout3;
            }
            frameLayout2.setLayoutParams(marginLayoutParams2);
        }
    }

    private final void pa() {
        fo.c.o(G9(), "em_qz_batch_operation_icon", null);
        fo.c.o(H9(), "em_qz_more", null);
        fo.c.o(N9(), "em_qz_select_all", null);
    }

    private final GroupAlbumAlbumDetailInitBean qa(Activity activity) {
        Bundle extras;
        Intent intent = activity.getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("key_bundle_common_init_bean")) {
            Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean");
            return (GroupAlbumAlbumDetailInitBean) serializable;
        }
        return new GroupAlbumAlbumDetailInitBean("");
    }

    private final void ra() {
        com.qzone.reborn.groupalbum.viewmodel.b bVar = this.albumViewModel;
        com.qzone.reborn.groupalbum.viewmodel.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            bVar = null;
        }
        CommonAlbumInfo value = bVar.M1().getValue();
        if (value == null) {
            RFWLog.w("GroupAlbumAlbumDetailTitlePart", RFWLog.USR, "handEditAlbum, albumInfo is null ");
            return;
        }
        oi.c m3 = ho.i.m();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        String groupId = qa(activity2).getGroupId();
        com.qzone.reborn.groupalbum.viewmodel.b bVar3 = this.albumViewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            bVar3 = null;
        }
        ArrayList<Integer> value2 = bVar3.T1().getValue();
        Intrinsics.checkNotNull(value2);
        boolean contains = value2.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMTOPALBUM.ordinal()));
        com.qzone.reborn.groupalbum.viewmodel.b bVar4 = this.albumViewModel;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            bVar4 = null;
        }
        ArrayList<Integer> value3 = bVar4.T1().getValue();
        Intrinsics.checkNotNull(value3);
        boolean contains2 = value3.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMDELETEALBUM.ordinal()));
        com.qzone.reborn.groupalbum.viewmodel.b bVar5 = this.albumViewModel;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        } else {
            bVar2 = bVar5;
        }
        m3.d(activity, 999, new CommonAlbumEditInitBean(groupId, value, contains, contains2, bVar2.W1()));
    }

    private final void sa(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        if (uiStateData.getData() != null && !uiStateData.getData().isEmpty()) {
            G9().setVisibility(0);
        } else {
            G9().setVisibility(8);
        }
    }

    private final void ta() {
        boolean z16 = !this.isAllSelectMode;
        this.isAllSelectMode = z16;
        com.qzone.reborn.groupalbum.viewmodel.h hVar = null;
        if (z16) {
            com.qzone.reborn.groupalbum.viewmodel.h hVar2 = this.operateViewModel;
            if (hVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                hVar = hVar2;
            }
            hVar.M1();
        } else {
            com.qzone.reborn.groupalbum.viewmodel.h hVar3 = this.operateViewModel;
            if (hVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                hVar = hVar3;
            }
            hVar.h2();
        }
        QLog.i(getTAG(), 1, "handleClickAllSelectOperate  isAllSelectMode = " + this.isAllSelectMode);
    }

    private final void wa(ArrayList<Integer> right) {
        if (right.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMMODIFYALBUM.ordinal()))) {
            H9().setVisibility(0);
            return;
        }
        ViewGroup.LayoutParams layoutParams = G9().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, 0, marginLayoutParams.bottomMargin);
        G9().setLayoutParams(marginLayoutParams);
        H9().setVisibility(8);
    }

    private final void xa(View rootView) {
        com.qzone.reborn.albumx.common.viewmodel.b Ne;
        com.qzone.reborn.albumx.common.viewmodel.b bVar = null;
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, rootView, null);
        if (cVar != null && (Ne = cVar.Ne()) != null) {
            Ne.T1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    u.za(u.this, (ArrayList) obj);
                }
            });
            Ne.M1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    u.Aa(u.this, (CommonAlbumInfo) obj);
                }
            });
            Ne.O1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    u.Ba(u.this, (UIStateData) obj);
                }
            });
            bVar = Ne;
        }
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.viewmodel.GroupAlbumAlbumDetailViewModel");
        this.albumViewModel = (com.qzone.reborn.groupalbum.viewmodel.b) bVar;
        ViewModel viewModel = getViewModel(com.qzone.reborn.groupalbum.viewmodel.h.class);
        final com.qzone.reborn.groupalbum.viewmodel.h hVar = (com.qzone.reborn.groupalbum.viewmodel.h) viewModel;
        hVar.d2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.Ca(u.this, (Boolean) obj);
            }
        });
        hVar.a2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.Da(u.this, (Integer) obj);
            }
        });
        hVar.c2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.Ea(u.this, hVar, (Unit) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumA\u2026\n            })\n        }");
        this.operateViewModel = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(u this$0, ArrayList it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.wa(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart
    public void D9() {
        super.D9();
        Q9().setVisibility(8);
        J9().setVisibility(0);
        com.qzone.reborn.groupalbum.viewmodel.b bVar = this.albumViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            bVar = null;
        }
        CommonAlbumInfo value = bVar.M1().getValue();
        if (value != null) {
            J9().setText(value.getName());
        }
        RelativeLayout relativeLayout = this.rlOperateLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlOperateLayout");
            relativeLayout = null;
        }
        relativeLayout.setBackground(null);
        na();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart
    public void E9() {
        super.E9();
        Q9().setVisibility(0);
        J9().setVisibility(8);
        if (this.isAllSelectMode) {
            RelativeLayout relativeLayout = this.rlOperateLayout;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlOperateLayout");
                relativeLayout = null;
            }
            relativeLayout.setBackground(getContext().getDrawable(R.drawable.f13730n));
        }
        oa();
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateAlbumDetailTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        RFWLog.i("GroupAlbumAlbumDetailTitlePart", RFWLog.USR, "onActivityResult, requestCode:" + requestCode + ", resultCode:" + resultCode);
        if (resultCode != -1 || data == null) {
            return;
        }
        CommonAlbumInfo commonAlbumInfo = (CommonAlbumInfo) data.getParcelableExtra("EDIT_ALBUM_INFO");
        if (commonAlbumInfo != null) {
            com.qzone.reborn.groupalbum.viewmodel.b bVar = this.albumViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                bVar = null;
            }
            bVar.M1().postValue(commonAlbumInfo);
        }
        CommonAlbumInfo commonAlbumInfo2 = (CommonAlbumInfo) data.getParcelableExtra("KEY_DELETE_ALBUM_INFO");
        if (commonAlbumInfo2 != null) {
            RFWLog.i("GroupAlbumAlbumDetailTitlePart", RFWLog.USR, "onActivityResult, delete album, albumInfo:" + commonAlbumInfo2);
            getActivity().finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        com.qzone.reborn.groupalbum.viewmodel.h hVar = this.operateViewModel;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            hVar = null;
        }
        if (Intrinsics.areEqual(hVar.d2().getValue(), Boolean.TRUE)) {
            va();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart, android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        super.onClick(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.lvo) {
            ra();
        } else if (valueOf != null && valueOf.intValue() == R.id.fyg) {
            ua();
        } else if (valueOf != null && valueOf.intValue() == R.id.nia) {
            va();
        } else if (valueOf != null && valueOf.intValue() == R.id.nhv) {
            ta();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        G9().setVisibility(8);
        H9().setVisibility(8);
        View findViewById = rootView.findViewById(R.id.jor);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.fl_title_bar)");
        this.flTitleBar = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.ner);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rl_normal_title_layout)");
        this.rlNormalTitleLayout = (RelativeLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.net);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.rl_operate_layout)");
        this.rlOperateLayout = (RelativeLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.nes);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.rl_operate_container)");
        this.rlOperateContainer = (RelativeLayout) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f162954ni4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.tv_batch_operate_text)");
        ca((TextView) findViewById5);
        View findViewById6 = rootView.findViewById(R.id.nhv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.tv_all_select_text)");
        ba((TextView) findViewById6);
        View findViewById7 = rootView.findViewById(R.id.n6a);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026mate_title_transmit_view)");
        this.flTransmitLayout = (FrameLayout) findViewById7;
        xa(rootView);
        pa();
    }

    private final void ua() {
        Fa(true);
        com.qzone.reborn.groupalbum.viewmodel.h hVar = this.operateViewModel;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            hVar = null;
        }
        hVar.d2().postValue(Boolean.TRUE);
        QLog.i(getTAG(), 1, "handleClickBatchOperate");
    }

    private final void va() {
        Fa(false);
        com.qzone.reborn.groupalbum.viewmodel.h hVar = this.operateViewModel;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            hVar = null;
        }
        hVar.Q1();
        QLog.i(getTAG(), 1, "handleClickCancelOperate");
    }

    private final void Ga(int num) {
        if (num > 0) {
            O9().setText(getContext().getResources().getString(R.string.sop, Integer.valueOf(num)));
        } else {
            O9().setText(getContext().getResources().getString(R.string.sp6));
        }
    }
}
