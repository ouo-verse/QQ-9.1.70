package com.tencent.qqnt.aio.gallery.part;

import NS_COMM.COMM;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.aio.longshot.LongShotNTManager;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/o;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "onBackEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "bottomBarRoot", "e", "topBarRoot", "f", "Landroid/view/View;", "backBtn", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "titleTv", "i", "editBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sendBtn", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class o extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup bottomBarRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup topBarRoot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View backBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView titleTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView editBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView sendBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/gallery/part/o$b", "Lcom/tencent/qqnt/aio/adapter/api/c;", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.qqnt.aio.adapter.api.c {
        b() {
        }

        @Override // com.tencent.qqnt.aio.adapter.api.c
        public void a() {
            o.this.getActivity().setResult(-1, new Intent());
            o.this.getActivity().finish();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/gallery/part/o$c", "Lcom/tencent/qqnt/aio/adapter/api/c;", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.qqnt.aio.adapter.api.c {
        c() {
        }

        @Override // com.tencent.qqnt.aio.adapter.api.c
        public void a() {
            o.this.getActivity().setResult(-1, new Intent());
            o.this.getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(o this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPartHost partHost = this$0.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.biz.richframework.part.BasePartFragment");
        ((BasePartFragment) partHost).onBackEvent();
        this$0.getPartHost().getHostActivity().onBackPressed();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "NTAIOLayerLongShotPreviewPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        getActivity().setResult(0, new Intent());
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerIOCUtil.registerPicLoader(rootView, new com.tencent.qqnt.aio.gallery.pic.a(((IPicAIOApi) QRoute.api(IPicAIOApi.class)).getPicLoader()));
        FrameLayout frameLayout = new FrameLayout(rootView.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.dpToPx(44.0f));
        layoutParams.gravity = 48;
        frameLayout.setLayoutParams(layoutParams);
        this.topBarRoot = frameLayout;
        ViewGroup viewGroup = (ViewGroup) rootView;
        viewGroup.addView(frameLayout);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        ViewGroup viewGroup2 = this.topBarRoot;
        ViewGroup viewGroup3 = null;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBarRoot");
            viewGroup2 = null;
        }
        View inflate = from.inflate(R.layout.dvh, viewGroup2, false);
        if (inflate != null) {
            ViewGroup viewGroup4 = this.topBarRoot;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarRoot");
                viewGroup4 = null;
            }
            viewGroup4.addView(inflate);
            ViewGroup viewGroup5 = this.topBarRoot;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarRoot");
                viewGroup5 = null;
            }
            viewGroup5.setVisibility(0);
            this.backBtn = inflate.findViewById(R.id.f27060f8);
            this.titleTv = (TextView) inflate.findViewById(R.id.f27430g8);
        }
        FrameLayout frameLayout2 = new FrameLayout(viewGroup.getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        frameLayout2.setLayoutParams(layoutParams2);
        this.bottomBarRoot = frameLayout2;
        viewGroup.addView(frameLayout2);
        LayoutInflater from2 = LayoutInflater.from(viewGroup.getContext());
        ViewGroup viewGroup6 = this.bottomBarRoot;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBarRoot");
            viewGroup6 = null;
        }
        View inflate2 = from2.inflate(R.layout.dvg, viewGroup6, false);
        if (inflate2 != null) {
            ViewGroup viewGroup7 = this.bottomBarRoot;
            if (viewGroup7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBarRoot");
                viewGroup7 = null;
            }
            viewGroup7.addView(inflate2);
            ViewGroup viewGroup8 = this.bottomBarRoot;
            if (viewGroup8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBarRoot");
            } else {
                viewGroup3 = viewGroup8;
            }
            viewGroup3.setVisibility(0);
            this.editBtn = (TextView) inflate2.findViewById(R.id.f27190fk);
            this.sendBtn = (TextView) inflate2.findViewById(R.id.f27400g5);
        }
        View view = this.backBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.gallery.part.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o.B9(o.this, view2);
                }
            });
        }
        TextView textView = this.titleTv;
        if (textView != null) {
            textView.setText(viewGroup.getContext().getString(R.string.f197404jx));
        }
        TextView textView2 = this.editBtn;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.gallery.part.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o.C9(o.this, view2);
                }
            });
        }
        TextView textView3 = this.sendBtn;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.gallery.part.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o.D9(o.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (r1.isInMultiWindow() == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void C9(o this$0, View view) {
        boolean z16;
        HashMap<String, Object> hashMap;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String localPath;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hf0.a.a(this$0.getTAG())) {
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            QQToast.makeText(this$0.getActivity(), R.string.lwl, 0).show();
            return;
        }
        if (this$0.getActivity().getIntent().getBooleanExtra("key_complete_share_preview", false)) {
            hashMap = new HashMap<>();
            hashMap.put("extra_complete_preview_share", Boolean.TRUE);
        } else {
            hashMap = null;
        }
        HashMap<String, Object> hashMap2 = hashMap;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this$0.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null || (localPath = currentPicInfo.getLocalPath()) == null) {
            return;
        }
        this$0.getActivity().startActivityForResult(((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(this$0.getActivity(), localPath, true, true, true, true, true, false, false, false, 2, 122, 0, false, hashMap2), 18003);
        ReportController.o(null, "dc00898", "", "", "0X8009DED", "0X8009DED", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(o this$0, View view) {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String localPath;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hf0.a.a(this$0.getTAG()) || (rFWLayerItemMediaInfo = this$0.mCurrentSelectedItem) == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null || (localPath = currentPicInfo.getLocalPath()) == null) {
            return;
        }
        if (this$0.getActivity().getIntent().getBooleanExtra("key_complete_share_preview", false)) {
            LongShotNTManager a16 = LongShotNTManager.INSTANCE.a();
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            a16.L(activity, null, localPath, new b());
        } else {
            LongShotNTManager a17 = LongShotNTManager.INSTANCE.a();
            Activity activity2 = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            a17.I(activity2, localPath, new c());
        }
        ReportController.o(null, "dc00898", "", "", "0X8009DEE", "0X8009DEE", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case COMM.oidb_proxy_svr /* 18001 */:
                if (resultCode == -1) {
                    LongShotNTManager a16 = LongShotNTManager.INSTANCE.a();
                    Activity activity = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    Intrinsics.checkNotNull(data);
                    a16.x(activity, data);
                    getActivity().setResult(-1, data);
                    getActivity().finish();
                    return;
                }
                if (data == null || !data.getBooleanExtra("NOCANCEL4DATALIN", false)) {
                    return;
                }
                getActivity().setResult(-1, data);
                getActivity().finish();
                return;
            case 18002:
            case 18003:
                if (resultCode == -1) {
                    getActivity().setResult(-1, data);
                    getActivity().finish();
                    return;
                }
                return;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                return;
        }
    }
}
