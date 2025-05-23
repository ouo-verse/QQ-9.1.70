package com.qzone.reborn.intimate.part.albumDetail;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nk.aa;
import nk.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\"\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumDetail/t;", "Lcom/qzone/reborn/albumx/common/part/CommonAlbumDetailTitlePart;", "", "la", "initData", "", WidgetCacheConstellationData.NUM, "wa", "", "it", "qa", "ma", "na", "pa", "oa", "isOperateMode", "va", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "onBackEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/widget/RelativeLayout;", "M", "Landroid/widget/RelativeLayout;", "rlNormalTitleLayout", "N", "rlOperateLayout", "Lnk/w;", "P", "Lnk/w;", "albumViewModel", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "isAllSelectMode", "Lnk/aa;", BdhLogUtil.LogTag.Tag_Req, "Lnk/aa;", "operateViewModel", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class t extends CommonAlbumDetailTitlePart {

    /* renamed from: M, reason: from kotlin metadata */
    private RelativeLayout rlNormalTitleLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private RelativeLayout rlOperateLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private w albumViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isAllSelectMode;

    /* renamed from: R, reason: from kotlin metadata */
    private aa operateViewModel;

    private final void initData() {
        ViewModel viewModel = getViewModel(w.class);
        w wVar = (w) viewModel;
        wVar.X1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.intimate.part.albumDetail.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                t.ra(t.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026\n            })\n        }");
        this.albumViewModel = wVar;
        ViewModel viewModel2 = getViewModel(aa.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneIntima\u2026ateViewModel::class.java)");
        this.operateViewModel = (aa) viewModel2;
        ViewModel viewModel3 = getViewModel(aa.class);
        final aa aaVar = (aa) viewModel3;
        aaVar.d2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.intimate.part.albumDetail.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                t.sa(t.this, (Boolean) obj);
            }
        });
        aaVar.a2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.intimate.part.albumDetail.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                t.ta(t.this, (Integer) obj);
            }
        });
        aaVar.c2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.intimate.part.albumDetail.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                t.ua(t.this, aaVar, (Unit) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(QZoneIntima\u2026\n            })\n        }");
        this.operateViewModel = aaVar;
    }

    private final void la() {
        fo.c.o(G9(), "em_qz_batch_operation_icon", null);
        fo.c.o(H9(), "em_qz_more", null);
        fo.c.o(N9(), "em_qz_select_all", null);
    }

    private final void ma() {
        String str;
        w wVar = this.albumViewModel;
        w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            wVar = null;
        }
        CommonAlbumInfo value = wVar.M1().getValue();
        if (value == null) {
            RFWLog.w("QZoneIntimateAlbumDetailTitlePart", RFWLog.USR, "handEditAlbum, albumInfo is null ");
            return;
        }
        ck.c o16 = ho.i.o();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        w wVar3 = this.albumViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        } else {
            wVar2 = wVar3;
        }
        QZoneIntimateAlbumDetailInitBean initBean = wVar2.getInitBean();
        if (initBean == null || (str = initBean.getSpaceId()) == null) {
            str = "";
        }
        o16.p(activity, 999, new CommonAlbumEditInitBean(str, value, (TextUtils.isEmpty(LoginData.getInstance().getUid()) || TextUtils.isEmpty(value.getCreator().getUid()) || !TextUtils.equals(LoginData.getInstance().getUid(), value.getCreator().getUid())) ? false : true));
    }

    private final void na() {
        boolean z16 = !this.isAllSelectMode;
        this.isAllSelectMode = z16;
        aa aaVar = null;
        if (z16) {
            aa aaVar2 = this.operateViewModel;
            if (aaVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                aaVar = aaVar2;
            }
            aaVar.M1();
        } else {
            aa aaVar3 = this.operateViewModel;
            if (aaVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                aaVar = aaVar3;
            }
            aaVar.h2();
        }
        QLog.i(getTAG(), 1, "handleClickAllSelectOperate  isAllSelectMode = " + this.isAllSelectMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(t this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.qa(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(t this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.va(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(t this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.wa(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(t this$0, aa aaVar, Unit unit) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean value = aaVar.d2().getValue();
        Intrinsics.checkNotNull(value);
        this$0.va(value.booleanValue());
    }

    private final void va(boolean isOperateMode) {
        RelativeLayout relativeLayout = null;
        aa aaVar = null;
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
            aa aaVar2 = this.operateViewModel;
            if (aaVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
                aaVar2 = null;
            }
            if (aaVar2.e2()) {
                N9().setText(com.qzone.util.l.a(R.string.snr));
            } else {
                N9().setText(com.qzone.util.l.a(R.string.sni));
            }
            aa aaVar3 = this.operateViewModel;
            if (aaVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                aaVar = aaVar3;
            }
            this.isAllSelectMode = aaVar.e2();
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

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateAlbumDetailTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        RFWLog.i("QZoneIntimateAlbumDetailTitlePart", RFWLog.USR, "onActivityResult, requestCode:" + requestCode + ", resultCode:" + resultCode);
        if (resultCode == -1 && requestCode == 999) {
            w wVar = null;
            CommonAlbumInfo commonAlbumInfo = data != null ? (CommonAlbumInfo) data.getParcelableExtra("KEY_DELETE_ALBUM_INFO") : null;
            if (commonAlbumInfo != null) {
                RFWLog.i("QZoneIntimateAlbumDetailTitlePart", RFWLog.USR, "onActivityResult, delete album, albumInfo:" + commonAlbumInfo);
                getActivity().finish();
                return;
            }
            CommonAlbumInfo commonAlbumInfo2 = data != null ? (CommonAlbumInfo) data.getParcelableExtra("EDIT_ALBUM_INFO") : null;
            if (commonAlbumInfo2 != null) {
                w wVar2 = this.albumViewModel;
                if (wVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                } else {
                    wVar = wVar2;
                }
                wVar.M1().postValue(commonAlbumInfo2);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        aa aaVar = this.operateViewModel;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            aaVar = null;
        }
        if (Intrinsics.areEqual(aaVar.d2().getValue(), Boolean.TRUE)) {
            pa();
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
            ma();
        } else if (valueOf != null && valueOf.intValue() == R.id.fyg) {
            oa();
        } else if (valueOf != null && valueOf.intValue() == R.id.nia) {
            pa();
        } else if (valueOf != null && valueOf.intValue() == R.id.nhv) {
            na();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.ner);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rl_normal_title_layout)");
        this.rlNormalTitleLayout = (RelativeLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.net);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rl_operate_layout)");
        this.rlOperateLayout = (RelativeLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f162954ni4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_batch_operate_text)");
        ca((TextView) findViewById3);
        View findViewById4 = rootView.findViewById(R.id.nhv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.tv_all_select_text)");
        ba((TextView) findViewById4);
        initData();
        la();
    }

    private final void oa() {
        va(true);
        aa aaVar = this.operateViewModel;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            aaVar = null;
        }
        aaVar.d2().postValue(Boolean.TRUE);
        QLog.i(getTAG(), 1, "handleClickBatchOperate");
    }

    private final void pa() {
        va(false);
        aa aaVar = this.operateViewModel;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            aaVar = null;
        }
        aaVar.Q1();
        QLog.i(getTAG(), 1, "handleClickCancelOperate");
    }

    private final void wa(int num) {
        if (num > 0) {
            O9().setText(getContext().getResources().getString(R.string.sop, Integer.valueOf(num)));
        } else {
            O9().setText(getContext().getResources().getString(R.string.sp6));
        }
    }

    private final void qa(boolean it) {
        if (it) {
            w wVar = this.albumViewModel;
            if (wVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                wVar = null;
            }
            if (wVar.N1().isEmpty()) {
                G9().setVisibility(8);
            } else {
                G9().setVisibility(0);
            }
            H9().setVisibility(0);
            return;
        }
        G9().setVisibility(8);
        H9().setVisibility(8);
    }
}
