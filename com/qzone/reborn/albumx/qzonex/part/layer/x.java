package com.qzone.reborn.albumx.qzonex.part.layer;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxEditMediaEvent;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u001a\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u001f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d`\u001eH\u0016R\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010%R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/x;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/b;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H9", "", "J9", "F9", "Lcom/qzone/reborn/albumx/common/bean/d;", "G9", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "v", NodeProps.ON_CLICK, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", tl.h.F, "Landroid/view/View;", "footerView", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "lbsLinearLayout", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "lbsTextView", BdhLogUtil.LogTag.Tag_Conn, "editLinearLayout", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "D", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "editTextView", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class x extends b implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout editLinearLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneRichTextView editTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View footerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout lbsLinearLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView lbsTextView;

    private final void F9() {
        com.qzone.reborn.albumx.common.bean.d G9 = G9();
        ho.i.c().p(new QZoneCommentPanelParams.a().y(515).getParams(), getActivity(), G9);
    }

    private final com.qzone.reborn.albumx.common.bean.d G9() {
        String str;
        String str2;
        String str3;
        String str4;
        String uploadUid;
        com.qzone.reborn.albumx.common.bean.d dVar = new com.qzone.reborn.albumx.common.bean.d();
        QZAlbumxLayerExtraInfoBean x95 = x9();
        dVar.n(x95 != null ? x95.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String() : false);
        QZAlbumxLayerExtraInfoBean x96 = x9();
        String str5 = "";
        if (x96 == null || (str = x96.getUin()) == null) {
            str = "";
        }
        dVar.k(str);
        QZAlbumxLayerExtraInfoBean x97 = x9();
        if (x97 == null || (str2 = x97.getAlbumId()) == null) {
            str2 = "";
        }
        dVar.h(str2);
        QZAlbumxLayerExtraInfoBean x98 = x9();
        if (x98 == null || (str3 = x98.getBatchId()) == null) {
            str3 = "";
        }
        dVar.i(str3);
        QZAlbumxLayerExtraInfoBean x99 = x9();
        if (x99 == null || (str4 = x99.getLLoc()) == null) {
            str4 = "";
        }
        dVar.l(str4);
        QZAlbumxLayerExtraInfoBean x910 = x9();
        if (x910 != null && (uploadUid = x910.getUploadUid()) != null) {
            str5 = uploadUid;
        }
        dVar.m(str5);
        QZAlbumxLayerExtraInfoBean x911 = x9();
        dVar.j(x911 != null ? x911.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.UPLOAD_TIME java.lang.String() : 0L);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(x this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = this$0.editLinearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editLinearLayout");
            linearLayout = null;
        }
        VideoReport.setElementId(linearLayout, "em_qz_add_description");
    }

    private final boolean J9() {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        return Intrinsics.areEqual(String.valueOf(x95 != null ? x95.getUploadUid() : null), LoginData.getInstance().getUinString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(x this$0, SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneRichTextView qZoneRichTextView = this$0.editTextView;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setRichText(((QZAlbumxEditMediaEvent) simpleBaseEvent).getDesc());
        }
        QZAlbumxLayerExtraInfoBean x95 = this$0.x9();
        if (x95 == null) {
            return;
        }
        x95.D(((QZAlbumxEditMediaEvent) simpleBaseEvent).getDesc());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZAlbumxEditMediaEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.mof) {
            F9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        H9(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        String desc;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        View view = null;
        if (x9() == null) {
            View view2 = this.footerView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footerView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        QZAlbumxLayerExtraInfoBean x95 = x9();
        if (x95 == null) {
            return;
        }
        View view3 = this.footerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            view3 = null;
        }
        boolean z16 = false;
        view3.setVisibility(0);
        String lbs = x95.getLbs();
        if (lbs == null || lbs.length() == 0) {
            LinearLayout linearLayout = this.lbsLinearLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lbsLinearLayout");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
        } else {
            LinearLayout linearLayout2 = this.lbsLinearLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lbsLinearLayout");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(0);
            TextView textView = this.lbsTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lbsTextView");
                textView = null;
            }
            textView.setText(x95.getLbs());
        }
        QZoneRichTextView qZoneRichTextView = this.editTextView;
        if (qZoneRichTextView != null) {
            String desc2 = x95.getDesc();
            if (desc2 == null || desc2.length() == 0) {
                desc = HardCodeUtil.qqStr(R.string.f133165d);
            } else {
                desc = x95.getDesc();
            }
            qZoneRichTextView.setRichText(desc);
        }
        if (J9()) {
            LinearLayout linearLayout3 = this.editLinearLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editLinearLayout");
                linearLayout3 = null;
            }
            linearLayout3.setOnClickListener(this);
            LinearLayout linearLayout4 = this.editLinearLayout;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editLinearLayout");
                linearLayout4 = null;
            }
            linearLayout4.setVisibility(0);
        } else {
            LinearLayout linearLayout5 = this.editLinearLayout;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editLinearLayout");
                linearLayout5 = null;
            }
            String desc3 = x95.getDesc();
            Boolean valueOf = Boolean.valueOf(!(desc3 == null || desc3.length() == 0));
            linearLayout5.setVisibility(0);
            if (((View) au.a(valueOf, linearLayout5)) == null) {
                linearLayout5.setVisibility(8);
            }
            LinearLayout linearLayout6 = this.editLinearLayout;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editLinearLayout");
                linearLayout6 = null;
            }
            linearLayout6.setOnClickListener(null);
        }
        QZAlbumxLayerExtraInfoBean x96 = x9();
        if (x96 != null && x96.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            z16 = true;
        }
        if (z16) {
            View view4 = this.footerView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footerView");
                view4 = null;
            }
            int e16 = ar.e(113.0f);
            ViewGroup.LayoutParams layoutParams = view4.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = view4.getLayoutParams();
                int i3 = layoutParams2 != null ? layoutParams2.width : -2;
                ViewGroup.LayoutParams layoutParams3 = view4.getLayoutParams();
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, layoutParams3 != null ? layoutParams3.height : -2);
            }
            if (e16 != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = e16;
                view4.setLayoutParams(marginLayoutParams);
            }
            com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
            View view5 = this.footerView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footerView");
            } else {
                view = view5;
            }
            bVar.e(view, ar.e(113.0f));
            return;
        }
        View view6 = this.footerView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            view6 = null;
        }
        int e17 = ar.e(70.0f);
        ViewGroup.LayoutParams layoutParams4 = view6.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
        if (marginLayoutParams2 == null) {
            ViewGroup.LayoutParams layoutParams5 = view6.getLayoutParams();
            int i16 = layoutParams5 != null ? layoutParams5.width : -2;
            ViewGroup.LayoutParams layoutParams6 = view6.getLayoutParams();
            marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i16, layoutParams6 != null ? layoutParams6.height : -2);
        }
        if (e17 != marginLayoutParams2.bottomMargin) {
            marginLayoutParams2.bottomMargin = e17;
            view6.setLayoutParams(marginLayoutParams2);
        }
        com.tencent.mobileqq.qui.b bVar2 = com.tencent.mobileqq.qui.b.f276860a;
        View view7 = this.footerView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
        } else {
            view = view7;
        }
        bVar2.e(view, ar.e(70.0f));
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.i, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent event) {
        if (event instanceof QZAlbumxEditMediaEvent) {
            QZAlbumxEditMediaEvent qZAlbumxEditMediaEvent = (QZAlbumxEditMediaEvent) event;
            if (qZAlbumxEditMediaEvent.getSuccess()) {
                QZAlbumxLayerExtraInfoBean x95 = x9();
                if (Intrinsics.areEqual(x95 != null ? x95.getLLoc() : null, qZAlbumxEditMediaEvent.getLloc())) {
                    RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.v
                        @Override // java.lang.Runnable
                        public final void run() {
                            x.K9(x.this, event);
                        }
                    });
                }
            }
        }
    }

    private final void H9(View rootView) {
        if (rootView == null) {
            return;
        }
        View view = null;
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f128934p, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(rootView.context)\n \u2026x_layer_info_layer, null)");
        this.footerView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.mpo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "footerView.findViewById(\u2026d.qzone_albumx_nearby_ll)");
        this.lbsLinearLayout = (LinearLayout) findViewById;
        View view2 = this.footerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.mpn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "footerView.findViewById(\u2026qzone_albumx_nearby_desc)");
        this.lbsTextView = (TextView) findViewById2;
        View view3 = this.footerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.mof);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "footerView.findViewById(R.id.qzone_albumx_edit_ll)");
        this.editLinearLayout = (LinearLayout) findViewById3;
        int e16 = ar.e(10.0f);
        LinearLayout linearLayout = this.editLinearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editLinearLayout");
            linearLayout = null;
        }
        QZoneFeedxViewUtils.a(linearLayout, e16, e16, e16, e16);
        View view4 = this.footerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            view4 = null;
        }
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) view4.findViewById(R.id.moe);
        this.editTextView = qZoneRichTextView;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setClickEnable(false);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        View view5 = this.footerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            view5 = null;
        }
        view5.setClickable(false);
        View view6 = this.footerView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            view6 = null;
        }
        view6.setEnabled(false);
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        View view7 = this.footerView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            view7 = null;
        }
        bVar.a(view7, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view8 = this.footerView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
        } else {
            view = view8;
        }
        viewGroup.addView(view, layoutParams);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.w
            @Override // java.lang.Runnable
            public final void run() {
                x.I9(x.this);
            }
        });
    }
}
