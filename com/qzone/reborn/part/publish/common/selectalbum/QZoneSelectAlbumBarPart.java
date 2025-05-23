package com.qzone.reborn.part.publish.common.selectalbum;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.k;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateSelectAlbumInitBean;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import ho.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR#\u0010%\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/qzone/reborn/part/publish/common/selectalbum/QZoneSelectAlbumBarPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "G9", "", "coverUrl", "F9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "v", NodeProps.ON_CLICK, "d", "Landroid/view/View;", "albumBarLayout", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvAlbumName", "Lcom/tencent/mobileqq/widget/RoundedImageView;", "f", "Lcom/tencent/mobileqq/widget/RoundedImageView;", "ivAlbumCover", "Lcom/qzone/reborn/part/publish/common/selectalbum/c;", "kotlin.jvm.PlatformType", h.F, "Lkotlin/Lazy;", "H9", "()Lcom/qzone/reborn/part/publish/common/selectalbum/c;", "vm", "i", "Ljava/lang/String;", "getReportId", "()Ljava/lang/String;", "J9", "(Ljava/lang/String;)V", "reportId", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneSelectAlbumBarPart extends k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View albumBarLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvAlbumName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundedImageView ivAlbumCover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String reportId;

    public QZoneSelectAlbumBarPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.qzone.reborn.part.publish.common.selectalbum.QZoneSelectAlbumBarPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return (c) QZoneSelectAlbumBarPart.this.getViewModel(c.class);
            }
        });
        this.vm = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(String coverUrl) {
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        Option url = Option.obtain().setUrl(coverUrl);
        RoundedImageView roundedImageView = this.ivAlbumCover;
        if (roundedImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivAlbumCover");
            roundedImageView = null;
        }
        a16.h(url.setTargetView(roundedImageView).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
    }

    private final void G9() {
        String str = this.reportId;
        if (str != null) {
            RFWLog.d("QZoneSelectAlbumBarPart", RFWLog.USR, "bindReportId, reportId:" + str);
            View view = this.albumBarLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumBarLayout");
                view = null;
            }
            fo.c.o(view, str, null);
        }
    }

    private final c H9() {
        return (c) this.vm.getValue();
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
        return "QZoneSelectAlbumBarPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0) {
            RFWLog.d("QZoneSelectAlbumBarPart", RFWLog.USR, "onActivityResult, cancelled ");
            return;
        }
        if (requestCode == 6666) {
            byte[] byteArrayExtra = data != null ? data.getByteArrayExtra("SELECTED_ALBUM_INFO") : null;
            if (byteArrayExtra == null) {
                return;
            }
            c H9 = H9();
            QZoneBaseAlbumMeta$AlbumInfo mergeFrom = new QZoneBaseAlbumMeta$AlbumInfo().mergeFrom(byteArrayExtra);
            Intrinsics.checkNotNullExpressionValue(mergeFrom, "AlbumInfo().mergeFrom(byteArray)");
            H9.W1(mergeFrom);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (Intrinsics.areEqual(H9().R1().getValue(), Boolean.TRUE)) {
            return;
        }
        if (rootView != null) {
            View inflate = ((ViewStub) rootView.findViewById(R.id.f69353ii)).inflate();
            View findViewById = inflate.findViewById(R.id.f81994fo);
            findViewById.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "stubView.findViewById<Vi\u2026bumBarPart)\n            }");
            this.albumBarLayout = findViewById;
            View findViewById2 = inflate.findViewById(R.id.f1059567e);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "stubView.findViewById(R.id.tv_album_name)");
            this.tvAlbumName = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.xzv);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "stubView.findViewById(R.id.iv_album_cover)");
            this.ivAlbumCover = (RoundedImageView) findViewById3;
            G9();
        }
        LiveData<QZoneBaseAlbumMeta$AlbumInfo> P1 = H9().P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QZoneBaseAlbumMeta$AlbumInfo, Unit> function1 = new Function1<QZoneBaseAlbumMeta$AlbumInfo, Unit>() { // from class: com.qzone.reborn.part.publish.common.selectalbum.QZoneSelectAlbumBarPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo) {
                invoke2(qZoneBaseAlbumMeta$AlbumInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo) {
                TextView textView;
                String a16;
                String str;
                PBStringField pBStringField;
                textView = QZoneSelectAlbumBarPart.this.tvAlbumName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvAlbumName");
                    textView = null;
                }
                if (qZoneBaseAlbumMeta$AlbumInfo == null || (pBStringField = qZoneBaseAlbumMeta$AlbumInfo.name) == null || (a16 = pBStringField.get()) == null) {
                    a16 = l.a(R.string.f2195466p);
                }
                textView.setText(a16);
                QZoneSelectAlbumBarPart qZoneSelectAlbumBarPart = QZoneSelectAlbumBarPart.this;
                if (qZoneBaseAlbumMeta$AlbumInfo == null || (str = ij.h.d(qZoneBaseAlbumMeta$AlbumInfo, 0, 1, null)) == null) {
                    str = "";
                }
                qZoneSelectAlbumBarPart.F9(str);
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.part.publish.common.selectalbum.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneSelectAlbumBarPart.I9(Function1.this, obj);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        PBStringField pBStringField;
        String str = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f81994fo) {
            EventCollector.getInstance().onViewClicked(v3);
            ck.c o16 = i.o();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            String spaceId = H9().Q1().getSpaceId();
            QZoneBaseAlbumMeta$AlbumInfo value = H9().P1().getValue();
            if (value != null && (pBStringField = value.album_id) != null) {
                str = pBStringField.get();
            }
            o16.v(activity, 6666, new QZoneIntimateSelectAlbumInitBean(spaceId, null, str, 2, null));
        }
    }
}
