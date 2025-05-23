package com.qzone.reborn.groupalbum.upload.selectalbum;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.util.o;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u001e\u001a\n \u001b*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R#\u0010/\u001a\n \u001b*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R#\u00104\u001a\n \u001b*\u0004\u0018\u000100008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/qzone/reborn/groupalbum/upload/selectalbum/GroupAlbumUploadQualitySelectBarPart;", "Lcom/qzone/reborn/base/k;", "", "F9", "K9", "", "I9", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaList", "H9", "Landroid/content/Intent;", "data", "M9", "P9", "", "L9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "newIntent", "onNewIntent", "kotlin.jvm.PlatformType", "d", "Ljava/lang/String;", "haveToChoose", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "qualityBarLayout", "f", "Landroid/view/View;", "albumDivider", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "imageIcon", "Lcom/qzone/reborn/groupalbum/upload/c;", "i", "Lkotlin/Lazy;", "J9", "()Lcom/qzone/reborn/groupalbum/upload/c;", "uploadVm", "Ltl/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "G9", "()Ltl/h;", "mediaPickerVm", "Lcom/qzone/album/ui/widget/g;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/album/ui/widget/g;", "photoSizeView", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumUploadQualitySelectBarPart extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private com.qzone.album.ui.widget.g photoSizeView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String haveToChoose = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastHaveToChoosePhotoOrVideo", "\u672a\u9009\u62e9\u7167\u7247\u6216\u89c6\u9891");

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout qualityBarLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View albumDivider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView imageIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy uploadVm;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy mediaPickerVm;

    public GroupAlbumUploadQualitySelectBarPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.groupalbum.upload.c>() { // from class: com.qzone.reborn.groupalbum.upload.selectalbum.GroupAlbumUploadQualitySelectBarPart$uploadVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.groupalbum.upload.c invoke() {
                return (com.qzone.reborn.groupalbum.upload.c) GroupAlbumUploadQualitySelectBarPart.this.getViewModel(com.qzone.reborn.groupalbum.upload.c.class);
            }
        });
        this.uploadVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<tl.h>() { // from class: com.qzone.reborn.groupalbum.upload.selectalbum.GroupAlbumUploadQualitySelectBarPart$mediaPickerVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final tl.h invoke() {
                return (tl.h) GroupAlbumUploadQualitySelectBarPart.this.getViewModel(tl.h.class);
            }
        });
        this.mediaPickerVm = lazy2;
    }

    private final void F9() {
        J9().i2(getActivity().getIntent().getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, -2016082619));
        if (J9().getCurrentImageUploadQuality() == -2016082619) {
            J9().i2(v5.a.a().d("photo"));
            J9().j2(v5.a.a().d("video"));
            if (J9().getCurrentImageUploadQuality() == -2016082619) {
                J9().i2(0);
                u5.b.L0("photo", J9().getCurrentImageUploadQuality(), LoginData.getInstance().getUin());
            }
        }
        if (LoginData.getInstance().isQzoneVip() || J9().getCurrentVideoUploadQuality() != 3) {
            return;
        }
        J9().j2(0);
        u5.b.L0("video", J9().getCurrentVideoUploadQuality(), LoginData.getInstance().getUin());
    }

    private final tl.h G9() {
        return (tl.h) this.mediaPickerVm.getValue();
    }

    private final ArrayList<String> H9(ArrayList<String> mediaList) {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = mediaList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!G9().R1().containsKey(mediaList.get(i3))) {
                arrayList.add(mediaList.get(i3));
            }
        }
        return arrayList;
    }

    private final String I9() {
        DynamicArrayList<String> value;
        HashMap<String, LocalMediaInfo> Q1 = G9().Q1();
        if (Q1 == null || (value = G9().P1().getValue()) == null) {
            return null;
        }
        int size = value.size();
        for (int i3 = 0; i3 < size; i3++) {
            LocalMediaInfo localMediaInfo = Q1.get(value.get(i3));
            if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.missionID)) {
                return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_QUALITY_TEXT_DIFF, com.qzone.util.l.a(R.string.f2199567t));
            }
        }
        return null;
    }

    private final com.qzone.reborn.groupalbum.upload.c J9() {
        return (com.qzone.reborn.groupalbum.upload.c) this.uploadVm.getValue();
    }

    private final void K9() {
        boolean W1 = G9().W1();
        boolean X1 = G9().X1();
        if (!W1 && !X1) {
            o.f59556a.d(this.haveToChoose, 1);
            return;
        }
        Intent l3 = ak.l(getActivity(), "com.qzone.publish.ui.activity.QZoneUploadQualityActivity");
        DynamicArrayList<String> value = G9().P1().getValue();
        l3.putStringArrayListExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_SELECTED_ARRAY", value != null ? H9(value) : null);
        if (W1) {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", J9().getCurrentImageUploadQuality());
        } else {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", -2016082619);
        }
        if (X1) {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", J9().getCurrentVideoUploadQuality());
        } else {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", -2016082619);
        }
        l3.putExtra("INTENT_QUALITY_DIFF_TEXT", I9());
        getActivity().startActivityForResult(l3, 607);
    }

    private final boolean L9() {
        return (LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, LoginData.getInstance().getUin()) & 8388608) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(GroupAlbumUploadQualitySelectBarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9() {
        if (this.photoSizeView == null) {
            return;
        }
        boolean W1 = G9().W1();
        boolean X1 = G9().X1();
        RelativeLayout relativeLayout = this.qualityBarLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualityBarLayout");
            relativeLayout = null;
        }
        TextView textView = (TextView) relativeLayout.findViewById(R.id.fpr);
        if (textView != null) {
            if (W1) {
                textView.setText("\u753b\u8d28\uff08\u53ef\u9009\u539f\u56fe\u4e0a\u4f20\uff09");
            } else if (X1) {
                textView.setText("\u753b\u8d28\uff08\u53ef\u9009\u539f\u753b\u4e0a\u4f20\uff09");
            } else {
                textView.setText(R.string.f173047gp1);
            }
        }
        com.qzone.album.ui.widget.g gVar = this.photoSizeView;
        Intrinsics.checkNotNull(gVar);
        gVar.f(true);
        if (!W1 && X1) {
            com.qzone.album.ui.widget.g gVar2 = this.photoSizeView;
            Intrinsics.checkNotNull(gVar2);
            gVar2.i(G9().P1().getValue(), J9().getCurrentVideoUploadQuality(), 1);
        } else {
            if (J9().getCurrentImageUploadQuality() == 3 && L9()) {
                J9().i2(0);
            }
            com.qzone.album.ui.widget.g gVar3 = this.photoSizeView;
            Intrinsics.checkNotNull(gVar3);
            gVar3.h(G9().P1().getValue(), J9().getCurrentImageUploadQuality());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumUploadQualitySelectBarPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 607) {
            M9(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View inflate = ((ViewStub) rootView.findViewById(R.id.vt5)).inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            RelativeLayout relativeLayout = (RelativeLayout) inflate;
            this.qualityBarLayout = relativeLayout;
            View view = null;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qualityBarLayout");
                relativeLayout = null;
            }
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.upload.selectalbum.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GroupAlbumUploadQualitySelectBarPart.N9(GroupAlbumUploadQualitySelectBarPart.this, view2);
                }
            });
            View findViewById = rootView.findViewById(R.id.f68673go);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_image_icon)");
            this.imageIcon = (ImageView) findViewById;
            com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
            ImageView imageView = this.imageIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
                imageView = null;
            }
            a16.j(imageView, new c.C8489c().h("qui_image").e(R.color.qui_common_icon_primary));
            F9();
            View findViewById2 = rootView.findViewById(R.id.f164258p8);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.album_divider)");
            this.albumDivider = findViewById2;
            RelativeLayout relativeLayout2 = this.qualityBarLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qualityBarLayout");
                relativeLayout2 = null;
            }
            View view2 = this.albumDivider;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumDivider");
            } else {
                view = view2;
            }
            this.photoSizeView = new com.qzone.album.ui.widget.g(relativeLayout2, view, J9().getCurrentImageUploadQuality());
            P9();
            DynamicArrayList<String> value = G9().P1().getValue();
            if (value != null) {
                LiveData<ArrayList<String>> liveData = value.getLiveData();
                LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
                final Function1<ArrayList<String>, Unit> function1 = new Function1<ArrayList<String>, Unit>() { // from class: com.qzone.reborn.groupalbum.upload.selectalbum.GroupAlbumUploadQualitySelectBarPart$onInitView$1$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ArrayList<String> arrayList) {
                        invoke2(arrayList);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ArrayList<String> arrayList) {
                        GroupAlbumUploadQualitySelectBarPart.this.P9();
                    }
                };
                liveData.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.upload.selectalbum.c
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GroupAlbumUploadQualitySelectBarPart.O9(Function1.this, obj);
                    }
                });
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent newIntent) {
        super.onNewIntent(newIntent);
        P9();
    }

    private final void M9(Intent data) {
        if (data == null) {
            return;
        }
        int intExtra = data.getIntExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", J9().getCurrentImageUploadQuality());
        int intExtra2 = data.getIntExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", J9().getCurrentVideoUploadQuality());
        if (intExtra != J9().getCurrentImageUploadQuality()) {
            J9().i2(intExtra);
            u5.b.L0("photo", J9().getCurrentImageUploadQuality(), LoginData.getInstance().getUin());
        }
        if (intExtra2 != J9().getCurrentVideoUploadQuality()) {
            J9().j2(intExtra2);
            u5.b.L0("video", J9().getCurrentVideoUploadQuality(), LoginData.getInstance().getUin());
        }
        P9();
    }
}
