package com.tencent.mobileqq.hermes.layer.part;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.util.PermissionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/hermes/layer/part/g;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "", "savePath", "", "J9", "Landroid/content/Context;", "context", "H9", "", "result", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class g extends RFWLayerBasePart {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/hermes/layer/part/g$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f236777b;

        a(String str) {
            this.f236777b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            g gVar = g.this;
            Context context = gVar.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            gVar.H9(context, this.f236777b);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void D9(final Context context, boolean result) {
        final int i3;
        final int i16;
        if (result) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (result) {
            i16 = R.string.f158781qj;
        } else {
            i16 = R.string.f158771qi;
        }
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.hermes.layer.part.f
            @Override // java.lang.Runnable
            public final void run() {
                g.E9(context, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Context context, int i3, int i16) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, i3, i16, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(g this$0, View view) {
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String url;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this$0.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null && (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null && (url = currentPicInfo.getUrl()) != null) {
            String picLocalPath = QQPicLoader.f201806a.d().getPicLocalPath(Option.obtain().setUrl(url));
            Intrinsics.checkNotNullExpressionValue(picLocalPath, "QQPicLoader.loader.getPi\u2026        .setUrl(saveUrl))");
            this$0.J9(picLocalPath);
            com.tencent.mobileqq.hermes.util.a.f236827a.d(url);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(Context context, String savePath) {
        RFWSaveUtil.insertMedia(context, savePath, new Consumer() { // from class: com.tencent.mobileqq.hermes.layer.part.e
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                g.I9(g.this, (RFWSaveMediaResultBean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(g this$0, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        this$0.D9(activity, rFWSaveMediaResultBean.isSuccess);
    }

    private final void J9(String savePath) {
        if (!TextUtils.isEmpty(savePath)) {
            if (!PermissionUtil.isHasStoragePermission(getContext()) && (getContext() instanceof Activity)) {
                BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC);
                Object partHost = getPartHost();
                Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                QQPermissionFactory.getQQPermission((Fragment) partHost, businessConfig).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a(savePath));
                return;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            H9(context, savePath);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.x9m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.hermes_gallery_back_btn)");
        ((ImageButton) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.hermes.layer.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.F9(g.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.x9o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.hermes_gallery_save_btn)");
        ((ImageButton) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.hermes.layer.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.G9(g.this, view);
            }
        });
    }
}
