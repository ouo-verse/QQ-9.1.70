package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.util.PermissionUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/forward/t;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "", "B9", "", "savePath", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "z9", "v", NodeProps.ON_CLICK, "getLogTag", "d", "Landroid/view/View;", "mFooterView", "e", "mSaveView", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class t extends RFWLayerBasePart implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mFooterView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mSaveView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/forward/t$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f211069b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RFWLayerItemMediaInfo f211070c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f211071d;

        a(Context context, RFWLayerItemMediaInfo rFWLayerItemMediaInfo, String str) {
            this.f211069b = context;
            this.f211070c = rFWLayerItemMediaInfo;
            this.f211071d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, t.this, context, rFWLayerItemMediaInfo, str);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                t.this.A9(this.f211069b, this.f211070c, this.f211071d);
            }
        }
    }

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A9(Context context, RFWLayerItemMediaInfo itemInfo, String savePath) {
        if (itemInfo.isVideo() && (context instanceof Activity)) {
            View decorView = getActivity().getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            IMediaProvider mediaProvider = RFWLayerIOCUtil.getMediaProvider(decorView);
            if (mediaProvider != null) {
                mediaProvider.saveToAlbum(itemInfo);
                return;
            }
            return;
        }
        AIOGalleryUtils.l(context, savePath, null);
    }

    private final void B9(Context context, RFWLayerItemMediaInfo itemInfo) {
        String existSaveOrEditPath = itemInfo.getExistSaveOrEditPath();
        if (existSaveOrEditPath == null) {
            existSaveOrEditPath = "";
        }
        QLog.i(getLogTag(), 1, "save: " + existSaveOrEditPath);
        if (TextUtils.isEmpty(existSaveOrEditPath)) {
            QQToast.makeText(context, "\u89c6\u9891\u4e0b\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u7b49", 0).show();
        } else if (!PermissionUtil.isHasStoragePermission(context) && (context instanceof Activity)) {
            QQPermissionFactory.getQQPermission((Activity) context, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_VIDEO)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a(context, itemInfo, existSaveOrEditPath));
        } else {
            A9(context, itemInfo, existSaveOrEditPath);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "ForwardSavePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            if (rFWLayerItemMediaInfo != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                B9(context, rFWLayerItemMediaInfo);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
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
        z9(rootView);
    }

    public final void z9(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View view = null;
        this.mFooterView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f168348fq0, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(110.0f));
        layoutParams.gravity = 80;
        View view2 = this.mFooterView;
        if (view2 != null) {
            view2.setClickable(false);
        }
        ((ViewGroup) rootView).addView(this.mFooterView, layoutParams);
        View view3 = this.mFooterView;
        if (view3 != null) {
            view = view3.findViewById(R.id.zvg);
        }
        this.mSaveView = view;
        if (view != null) {
            view.setVisibility(0);
        }
        View view4 = this.mSaveView;
        if (view4 != null) {
            view4.setOnClickListener(this);
        }
    }
}
