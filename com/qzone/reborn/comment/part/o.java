package com.qzone.reborn.comment.part;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.widget.ExtendGridView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.util.QZonePermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vc.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010\u000e\u001a\u00020\u00042\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0015\u001a\u00020\u00042\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fJ\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fR\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/qzone/reborn/comment/part/o;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "L9", "K9", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "H9", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selImgs", "I9", "onInitView", "getLogTag", "Landroid/content/Intent;", "intent", "onNewIntent", "photoPaths", "P9", "N9", "O9", "J9", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mImageIcon", "Lcom/qzone/widget/ExtendGridView;", "f", "Lcom/qzone/widget/ExtendGridView;", "mImageTipsGridView", "Lvc/a;", tl.h.F, "Lvc/a;", "mImageTipsAdapter", "Ldd/b;", "i", "Ldd/b;", "mViewModel", "Lxk/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lxk/d;", "mMediaParse", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mImageIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ExtendGridView mImageTipsGridView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private vc.a mImageTipsAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private dd.b mViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final xk.d mMediaParse;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/comment/part/o$b", "Lvc/a$c;", "", "position", "", "onItemDelete", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements a.c {
        b() {
        }

        @Override // vc.a.c
        public void onItemDelete(int position) {
            vc.a aVar = o.this.mImageTipsAdapter;
            dd.b bVar = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageTipsAdapter");
                aVar = null;
            }
            aVar.b(position);
            dd.b bVar2 = o.this.mViewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                bVar2 = null;
            }
            if (position < bVar2.R1().size()) {
                dd.b bVar3 = o.this.mViewModel;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    bVar = bVar3;
                }
                bVar.R1().remove(position);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/comment/part/o$d", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d extends QQPermission.BasePermissionsListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            o.this.O9();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            super.onDenied(permissions, results);
        }
    }

    public o(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
        this.mMediaParse = new xk.d(new c());
    }

    private final void K9(View rootView) {
        Activity activity = getActivity();
        ExtendGridView extendGridView = this.mImageTipsGridView;
        ImageView imageView = null;
        if (extendGridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageTipsGridView");
            extendGridView = null;
        }
        ImageView imageView2 = this.mImageIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageIcon");
            imageView2 = null;
        }
        this.mImageTipsAdapter = new vc.a(activity, extendGridView, imageView2);
        ExtendGridView extendGridView2 = this.mImageTipsGridView;
        if (extendGridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageTipsGridView");
            extendGridView2 = null;
        }
        vc.a aVar = this.mImageTipsAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageTipsAdapter");
            aVar = null;
        }
        extendGridView2.setAdapter((ListAdapter) aVar);
        vc.a aVar2 = this.mImageTipsAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageTipsAdapter");
            aVar2 = null;
        }
        aVar2.c(new b());
        ImageView imageView3 = this.mImageIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageIcon");
        } else {
            imageView = imageView3;
        }
        fo.c.n(imageView, "em_qz_picture");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final ArrayList<String> J9() {
        return new ArrayList<>();
    }

    public final void N9() {
        if (QZonePermission.requestStoragePermissionForPluginActivity(getActivity(), new d(), QQPermissionConstants.Business.SCENE.QQ_QZONE_PIC_COMMENT_OPEN_MEDIA)) {
            O9();
        }
    }

    public final void O9() {
        com.qzone.common.business.service.b.f().o(getActivity(), J9(), 3, false, 1, QZoneMediaBusiness.QZONE_COMMENT_ADD_PIC);
    }

    public final void P9(ArrayList<String> photoPaths) {
        ExtendGridView extendGridView = null;
        dd.b bVar = null;
        if (photoPaths != null && photoPaths.size() != 0) {
            ExtendGridView extendGridView2 = this.mImageTipsGridView;
            if (extendGridView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageTipsGridView");
                extendGridView2 = null;
            }
            extendGridView2.setVisibility(0);
            vc.a aVar = this.mImageTipsAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageTipsAdapter");
                aVar = null;
            }
            aVar.d(this.initParams.getShowQuickComment(), photoPaths);
            dd.b bVar2 = this.mViewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            } else {
                bVar = bVar2;
            }
            bVar.b2(photoPaths);
            return;
        }
        vc.a aVar2 = this.mImageTipsAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageTipsAdapter");
            aVar2 = null;
        }
        if (aVar2.getCount() <= 0) {
            ExtendGridView extendGridView3 = this.mImageTipsGridView;
            if (extendGridView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageTipsGridView");
            } else {
                extendGridView = extendGridView3;
            }
            extendGridView.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneCommentPanelImagePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mViewModel = (dd.b) viewModel;
        L9(rootView);
        K9(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || this.mMediaParse.a(intent)) {
            return;
        }
        I9(intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(ArrayList<String> selImgs) {
        if (selImgs == null || selImgs.isEmpty()) {
            return;
        }
        P9(selImgs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(localMediaInfo.path);
        I9(arrayList);
    }

    private final void L9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ms8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026comment_panel_image_icon)");
        this.mImageIcon = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.ms9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026nt_panel_image_tips_grid)");
        this.mImageTipsGridView = (ExtendGridView) findViewById2;
        ImageView imageView = this.mImageIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageIcon");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.qui_image);
        ImageView imageView3 = this.mImageIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageIcon");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.mImageIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageIcon");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.M9(o.this, view);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JZ\u0010\u0014\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016\u00a8\u0006\u0016"}, d2 = {"com/qzone/reborn/comment/part/o$c", "Lxk/a;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "exportMediaInfo", "Landroid/content/Intent;", "intent", "", "c", "cameraMediaInfo", "d", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mediaPathListFromIntent", "", "mediaPickerList", "Ljava/util/HashMap;", "LNS_MOBILE_OPERATION/PicInfo;", "Lkotlin/collections/HashMap;", "qZonePicInfoFromIntent", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements xk.a {
        c() {
        }

        @Override // xk.a
        public void a(ArrayList<String> mediaPathListFromIntent, List<? extends LocalMediaInfo> mediaPickerList, HashMap<String, PicInfo> qZonePicInfoFromIntent, Intent intent) {
            Intrinsics.checkNotNullParameter(mediaPathListFromIntent, "mediaPathListFromIntent");
            Intrinsics.checkNotNullParameter(mediaPickerList, "mediaPickerList");
            Intrinsics.checkNotNullParameter(qZonePicInfoFromIntent, "qZonePicInfoFromIntent");
            Intrinsics.checkNotNullParameter(intent, "intent");
            o.this.I9(xk.c.a(mediaPickerList));
        }

        @Override // xk.a
        public void c(LocalMediaInfo exportMediaInfo, Intent intent) {
            Intrinsics.checkNotNullParameter(exportMediaInfo, "exportMediaInfo");
            Intrinsics.checkNotNullParameter(intent, "intent");
            o.this.H9(exportMediaInfo);
        }

        @Override // xk.a
        public void d(LocalMediaInfo cameraMediaInfo, Intent intent) {
            Intrinsics.checkNotNullParameter(cameraMediaInfo, "cameraMediaInfo");
            Intrinsics.checkNotNullParameter(intent, "intent");
            o.this.H9(cameraMediaInfo);
        }

        @Override // xk.a
        public void b() {
        }
    }
}
