package com.qzone.reborn.albumx.common.part.editalbum;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\t8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/editalbum/CommonAlbumEditChangeCoverPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "coverUrl", "", "E9", "", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/widget/RoundedImageView;", "d", "Lcom/tencent/mobileqq/widget/RoundedImageView;", "ivCover", "e", "Landroid/view/View;", "F9", "()Landroid/view/View;", "I9", "(Landroid/view/View;)V", "coverContainer", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "f", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "vm", "<init>", "()V", h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class CommonAlbumEditChangeCoverPart extends k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RoundedImageView ivCover;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected View coverContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.common.viewmodel.c vm;

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(String coverUrl) {
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        Option url = Option.obtain().setUrl(coverUrl);
        RoundedImageView roundedImageView = this.ivCover;
        if (roundedImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            roundedImageView = null;
        }
        a16.h(url.setTargetView(roundedImageView).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
    }

    private final boolean G9() {
        Intent intent;
        Activity activity = getActivity();
        CommonAlbumEditInitBean commonAlbumEditInitBean = (activity == null || (intent = activity.getIntent()) == null) ? null : (CommonAlbumEditInitBean) intent.getParcelableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(commonAlbumEditInitBean, "null cannot be cast to non-null type com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean");
        return commonAlbumEditInitBean.isEmptyAlbum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View F9() {
        View view = this.coverContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coverContainer");
        return null;
    }

    protected final void I9(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.coverContainer = view;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        RFWLog.i("CommonAlbumEditChangeCoverPart", RFWLog.USR, "onActivityResult, requestCode:" + requestCode + ", resultCode:" + resultCode);
        if (resultCode == -1 && requestCode == 333) {
            com.qzone.reborn.albumx.common.viewmodel.c cVar = null;
            CommonStMedia commonStMedia = data != null ? (CommonStMedia) data.getParcelableExtra("SELECTED_COVER") : null;
            if (commonStMedia != null) {
                com.qzone.reborn.albumx.common.viewmodel.c cVar2 = this.vm;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    cVar = cVar2;
                }
                cVar.b2(commonStMedia);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        com.qzone.reborn.albumx.common.viewmodel.c cVar = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.m1h) {
            com.qzone.reborn.albumx.common.viewmodel.c cVar2 = this.vm;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                cVar = cVar2;
            }
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            cVar.a2(activity, 333);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        com.qzone.reborn.albumx.common.viewmodel.c cVar = null;
        this.vm = ((l9.f) RFWIocAbilityProvider.g().getIocInterface(l9.f.class, rootView, null)).te();
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.kuq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_cover)");
            this.ivCover = (RoundedImageView) findViewById;
            View findViewById2 = rootView.findViewById(R.id.m1h);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(R.id.layout_change_cover_part)");
            I9(findViewById2);
            F9().setOnClickListener(this);
            if (G9()) {
                F9().setVisibility(8);
            }
        }
        com.qzone.reborn.albumx.common.viewmodel.c cVar2 = this.vm;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            cVar = cVar2;
        }
        LiveData<CommonAlbumEditInitBean> M1 = cVar.M1();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final Function1<CommonAlbumEditInitBean, Unit> function1 = new Function1<CommonAlbumEditInitBean, Unit>() { // from class: com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditChangeCoverPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonAlbumEditInitBean commonAlbumEditInitBean) {
                invoke2(commonAlbumEditInitBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommonAlbumEditInitBean commonAlbumEditInitBean) {
                if (commonAlbumEditInitBean == null) {
                    return;
                }
                CommonAlbumEditChangeCoverPart.this.E9(k9.a.e(commonAlbumEditInitBean.getAlbumCover(), 0, 1, null));
            }
        };
        M1.observe(hostLifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.common.part.editalbum.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonAlbumEditChangeCoverPart.H9(Function1.this, obj);
            }
        });
    }
}
