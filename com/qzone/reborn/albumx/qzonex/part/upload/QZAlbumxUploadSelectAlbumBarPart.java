package com.qzone.reborn.albumx.qzonex.part.upload;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadSelectAlbumInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R#\u0010)\u001a\n $*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/upload/QZAlbumxUploadSelectAlbumBarPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "G9", "", "coverUrl", "F9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "v", NodeProps.ON_CLICK, "d", "Landroid/view/View;", "albumBarLayout", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvAlbumName", "Lcom/tencent/mobileqq/widget/RoundedImageView;", "f", "Lcom/tencent/mobileqq/widget/RoundedImageView;", "ivAlbumCover", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "uploadIcon", "Lqc/e;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "H9", "()Lqc/e;", "vm", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getReportId", "()Ljava/lang/String;", "J9", "(Ljava/lang/String;)V", "reportId", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxUploadSelectAlbumBarPart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View albumBarLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvAlbumName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundedImageView ivAlbumCover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView uploadIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String reportId;

    public QZAlbumxUploadSelectAlbumBarPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<qc.e>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadSelectAlbumBarPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final qc.e invoke() {
                return (qc.e) QZAlbumxUploadSelectAlbumBarPart.this.getViewModel(qc.e.class);
            }
        });
        this.vm = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(String coverUrl) {
        RoundedImageView roundedImageView = null;
        if (TextUtils.isEmpty(coverUrl)) {
            RoundedImageView roundedImageView2 = this.ivAlbumCover;
            if (roundedImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivAlbumCover");
            } else {
                roundedImageView = roundedImageView2;
            }
            roundedImageView.setVisibility(8);
            return;
        }
        RoundedImageView roundedImageView3 = this.ivAlbumCover;
        if (roundedImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivAlbumCover");
            roundedImageView3 = null;
        }
        roundedImageView3.setVisibility(0);
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        Option url = Option.obtain().setUrl(coverUrl);
        RoundedImageView roundedImageView4 = this.ivAlbumCover;
        if (roundedImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivAlbumCover");
        } else {
            roundedImageView = roundedImageView4;
        }
        a16.h(url.setTargetView(roundedImageView).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
    }

    private final void G9() {
        String str = this.reportId;
        if (str != null) {
            RFWLog.d("QZAlbumxUploadSelectAlbumBarPart", RFWLog.USR, "bindReportId, reportId:" + str);
            View view = this.albumBarLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumBarLayout");
                view = null;
            }
            fo.c.o(view, str, null);
        }
    }

    private final qc.e H9() {
        return (qc.e) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void J9(String str) {
        this.reportId = str;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxUploadSelectAlbumBarPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0) {
            RFWLog.d("QZAlbumxUploadSelectAlbumBarPart", RFWLog.USR, "onActivityResult, cancelled ");
        } else if (requestCode == 8888) {
            CommonAlbumInfo commonAlbumInfo = data != null ? (CommonAlbumInfo) data.getParcelableExtra("SELECTED_ALBUM_INFO") : null;
            if (commonAlbumInfo == null) {
                return;
            }
            H9().a2(commonAlbumInfo);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f81994fo) {
            EventCollector.getInstance().onViewClicked(v3);
            vb.b x16 = ho.i.x();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            String uin = H9().R1().getUin();
            CommonAlbumInfo value = H9().Q1().getValue();
            x16.n(activity, 8888, new QZAlbumxUploadSelectAlbumInitBean(uin, value != null ? value.getAlbumId() : null));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (Intrinsics.areEqual(H9().S1().getValue(), Boolean.TRUE)) {
            return;
        }
        if (rootView != null) {
            View inflate = ((ViewStub) rootView.findViewById(R.id.f69353ii)).inflate();
            View findViewById = inflate.findViewById(R.id.f81994fo);
            findViewById.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "stubView.findViewById<Vi\u2026bumBarPart)\n            }");
            this.albumBarLayout = findViewById;
            View findViewById2 = inflate.findViewById(R.id.y_g);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "stubView.findViewById(R.id.iv_upload_icon)");
            this.uploadIcon = (ImageView) findViewById2;
            com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
            ImageView imageView = this.uploadIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uploadIcon");
                imageView = null;
            }
            a16.j(imageView, new c.C8489c().h("qui_upload").e(R.color.qui_common_icon_primary));
            View findViewById3 = inflate.findViewById(R.id.f1059567e);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "stubView.findViewById(R.id.tv_album_name)");
            this.tvAlbumName = (TextView) findViewById3;
            View findViewById4 = inflate.findViewById(R.id.xzv);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "stubView.findViewById(R.id.iv_album_cover)");
            this.ivAlbumCover = (RoundedImageView) findViewById4;
            G9();
        }
        LiveData<CommonAlbumInfo> Q1 = H9().Q1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumInfo, Unit> function1 = new Function1<CommonAlbumInfo, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadSelectAlbumBarPart$onInitView$2
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
            public final void invoke2(CommonAlbumInfo commonAlbumInfo) {
                TextView textView;
                String a17;
                String str;
                CommonStPicUrl f16;
                textView = QZAlbumxUploadSelectAlbumBarPart.this.tvAlbumName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvAlbumName");
                    textView = null;
                }
                if (!TextUtils.isEmpty(commonAlbumInfo != null ? commonAlbumInfo.getName() : null)) {
                    a17 = commonAlbumInfo != null ? commonAlbumInfo.getName() : null;
                } else {
                    a17 = com.qzone.util.l.a(R.string.f2195466p);
                }
                textView.setText(a17);
                if (commonAlbumInfo == null || (f16 = k9.a.f(commonAlbumInfo)) == null || (str = f16.getUrl()) == null) {
                    str = "";
                }
                if (str.length() == 0) {
                    str = "https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/photo-cover-empt.png";
                }
                QZAlbumxUploadSelectAlbumBarPart.this.F9(str);
                QZAlbumxUploadSelectAlbumBarPart.this.broadcastMessage("update_upload_page_input_hint_text", null);
            }
        };
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxUploadSelectAlbumBarPart.I9(Function1.this, obj);
            }
        });
    }
}
