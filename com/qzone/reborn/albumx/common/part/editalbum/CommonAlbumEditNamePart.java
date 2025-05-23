package com.qzone.reborn.albumx.common.part.editalbum;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00028\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/editalbum/CommonAlbumEditNamePart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvName", "e", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "H9", "(Landroid/view/View;)V", ParseCommon.CONTAINER, "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "f", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "vm", "<init>", "()V", h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class CommonAlbumEditNamePart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected View container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.common.viewmodel.c vm;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(CommonAlbumEditNamePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.albumx.common.viewmodel.c cVar = this$0.vm;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            cVar = null;
        }
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        cVar.Z1(activity, 111);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    protected final void H9(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.container = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View getContainer() {
        View view = this.container;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        RFWLog.i("CommonAlbumEditNamePart", RFWLog.USR, "onActivityResult, requestCode:" + requestCode + ", resultCode:" + resultCode);
        if (resultCode == -1 && requestCode == 111) {
            if (data == null || (str = data.getStringExtra("OUTPUT_TEXT")) == null) {
                str = "";
            }
            RFWLog.i("CommonAlbumEditNamePart", RFWLog.DEV, "onActivityResult, outText:" + str);
            com.qzone.reborn.albumx.common.viewmodel.c cVar = this.vm;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                cVar = null;
            }
            cVar.d2(str);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        com.qzone.reborn.albumx.common.viewmodel.c cVar = null;
        this.vm = ((l9.f) RFWIocAbilityProvider.g().getIocInterface(l9.f.class, rootView, null)).te();
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.njc);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_name)");
            this.tvName = (TextView) findViewById;
            View findViewById2 = rootView.findViewById(R.id.m4y);
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.common.part.editalbum.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonAlbumEditNamePart.F9(CommonAlbumEditNamePart.this, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(R.id.\u2026          }\n            }");
            H9(findViewById2);
        }
        com.qzone.reborn.albumx.common.viewmodel.c cVar2 = this.vm;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            cVar = cVar2;
        }
        LiveData<CommonAlbumEditInitBean> M1 = cVar.M1();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final Function1<CommonAlbumEditInitBean, Unit> function1 = new Function1<CommonAlbumEditInitBean, Unit>() { // from class: com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditNamePart$onInitView$2
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
                TextView textView;
                if (commonAlbumEditInitBean != null) {
                    textView = CommonAlbumEditNamePart.this.tvName;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvName");
                        textView = null;
                    }
                    textView.setText(commonAlbumEditInitBean.getAlbumName());
                }
            }
        };
        M1.observe(hostLifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.common.part.editalbum.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonAlbumEditNamePart.G9(Function1.this, obj);
            }
        });
    }
}
