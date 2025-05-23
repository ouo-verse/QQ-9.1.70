package com.qzone.reborn.albumx.common.part.editalbum;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumResult;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumType;
import com.qzone.reborn.base.k;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00118\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/editalbum/CommonAlbumEditTitleBarPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvCancel", "e", "tvTitle", "f", "tvDone", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", h.F, "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "D9", "()Lcom/qzone/reborn/albumx/common/viewmodel/c;", "F9", "(Lcom/qzone/reborn/albumx/common/viewmodel/c;)V", "vm", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class CommonAlbumEditTitleBarPart extends k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvCancel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvDone;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected com.qzone.reborn.albumx.common.viewmodel.c vm;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.qzone.reborn.albumx.common.viewmodel.c D9() {
        com.qzone.reborn.albumx.common.viewmodel.c cVar = this.vm;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }

    protected final void F9(com.qzone.reborn.albumx.common.viewmodel.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.vm = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.ni_) {
            if (!D9().U1()) {
                getActivity().finish();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.niq && !D9().W1()) {
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        F9(((l9.f) RFWIocAbilityProvider.g().getIocInterface(l9.f.class, rootView, null)).te());
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.ni_);
            TextView textView = (TextView) findViewById;
            textView.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView>(R\u2026tleBarPart)\n            }");
            this.tvCancel = textView;
            View findViewById2 = rootView.findViewById(R.id.nkf);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_title)");
            this.tvTitle = (TextView) findViewById2;
            View findViewById3 = rootView.findViewById(R.id.niq);
            TextView textView2 = (TextView) findViewById3;
            textView2.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026tleBarPart)\n            }");
            this.tvDone = textView2;
        }
        LiveData<EditAlbumResult> N1 = D9().N1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<EditAlbumResult, Unit> function1 = new Function1<EditAlbumResult, Unit>() { // from class: com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditTitleBarPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditAlbumResult editAlbumResult) {
                invoke2(editAlbumResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EditAlbumResult editAlbumResult) {
                if (editAlbumResult.getType() == EditAlbumType.EDIT) {
                    if (!editAlbumResult.getIsSucceed()) {
                        String errMsg = editAlbumResult.getErrMsg();
                        if (errMsg == null || errMsg.length() == 0) {
                            QQToast.makeText(CommonAlbumEditTitleBarPart.this.getContext(), 1, l.a(R.string.v8z), 0).show();
                            return;
                        } else {
                            QQToast.makeText(CommonAlbumEditTitleBarPart.this.getContext(), 1, editAlbumResult.getErrMsg(), 0).show();
                            return;
                        }
                    }
                    Activity activity = CommonAlbumEditTitleBarPart.this.getActivity();
                    Intent intent = new Intent();
                    intent.putExtra("EDIT_ALBUM_INFO", editAlbumResult.getAlbumInfo());
                    Unit unit = Unit.INSTANCE;
                    activity.setResult(-1, intent);
                    activity.finish();
                }
            }
        };
        N1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.common.part.editalbum.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonAlbumEditTitleBarPart.E9(Function1.this, obj);
            }
        });
    }
}
