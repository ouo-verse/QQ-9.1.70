package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxAlbumDetailCeilingPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "I9", "initData", "Lxa/b;", "bean", "K9", "J9", "initViewModel", "", "getLogTag", "onInitView", "Lnc/y;", "d", "Lnc/y;", "detailViewModel", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTitle", "f", "tvSubTitle", tl.h.F, "Landroid/view/View;", "titleContainer", "i", "Lxa/b;", "curHeadCeilingBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumxAlbumDetailCeilingPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nc.y detailViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvSubTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View titleContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private xa.b curHeadCeilingBean;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(xa.b bean) {
        com.qzone.reborn.albumx.common.bean.a batchBean;
        CommonBatchInfo batchInfo;
        com.qzone.reborn.albumx.common.bean.a batchBean2;
        CommonGridItemData itemData = bean.getItemData();
        TextView textView = null;
        String timeId = (itemData == null || (batchBean2 = itemData.getBatchBean()) == null) ? null : batchBean2.getTimeId();
        CommonGridItemData itemData2 = bean.getItemData();
        String str = (itemData2 == null || (batchBean = itemData2.getBatchBean()) == null || (batchInfo = batchBean.getBatchInfo()) == null) ? null : batchInfo.getCom.tencent.mobileqq.wink.api.QQWinkConstants.TAB_SUBTITLE java.lang.String();
        if (!TextUtils.isEmpty(timeId) && !TextUtils.isEmpty(str)) {
            TextView textView2 = this.tvSubTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
                textView2 = null;
            }
            textView2.setVisibility(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TextView textView3 = this.tvSubTitle;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
                textView3 = null;
            }
            if (TextUtils.equals(textView3.getText(), str)) {
                return;
            }
            TextView textView4 = this.tvSubTitle;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
            } else {
                textView = textView4;
            }
            textView.setText(str);
            return;
        }
        TextView textView5 = this.tvSubTitle;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
        } else {
            textView = textView5;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(xa.b bean) {
        com.qzone.reborn.albumx.common.bean.a batchBean;
        CommonGridItemData itemData = bean.getItemData();
        TextView textView = null;
        String timeId = (itemData == null || (batchBean = itemData.getBatchBean()) == null) ? null : batchBean.getTimeId();
        RFWLog.i(getTAG(), RFWLog.USR, "updateTitle:" + bean.getShowCeiling() + " showTime is " + timeId);
        View view = this.titleContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view = null;
        }
        view.setVisibility(bean.getShowCeiling() ? 0 : 8);
        if (TextUtils.isEmpty(timeId)) {
            return;
        }
        TextView textView2 = this.tvTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView2 = null;
        }
        if (TextUtils.equals(textView2.getText(), timeId)) {
            return;
        }
        TextView textView3 = this.tvTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        } else {
            textView = textView3;
        }
        textView.setText(timeId);
    }

    private final void initData() {
        nc.y yVar = this.detailViewModel;
        if (yVar != null) {
            MutableLiveData<xa.b> y26 = yVar.y2();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<xa.b, Unit> function1 = new Function1<xa.b, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailCeilingPart$initData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(xa.b bVar) {
                    invoke2(bVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(xa.b bVar) {
                    xa.b bVar2;
                    xa.b bVar3;
                    QZAlbumxAlbumDetailCeilingPart.this.curHeadCeilingBean = bVar;
                    QZAlbumxAlbumDetailCeilingPart qZAlbumxAlbumDetailCeilingPart = QZAlbumxAlbumDetailCeilingPart.this;
                    bVar2 = qZAlbumxAlbumDetailCeilingPart.curHeadCeilingBean;
                    Intrinsics.checkNotNull(bVar2);
                    qZAlbumxAlbumDetailCeilingPart.K9(bVar2);
                    QZAlbumxAlbumDetailCeilingPart qZAlbumxAlbumDetailCeilingPart2 = QZAlbumxAlbumDetailCeilingPart.this;
                    bVar3 = qZAlbumxAlbumDetailCeilingPart2.curHeadCeilingBean;
                    Intrinsics.checkNotNull(bVar3);
                    qZAlbumxAlbumDetailCeilingPart2.J9(bVar3);
                }
            };
            y26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAlbumDetailCeilingPart.H9(Function1.this, obj);
                }
            });
        }
    }

    private final void initViewModel() {
        this.detailViewModel = (nc.y) getViewModel(nc.y.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailCeilingItemPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        I9(rootView);
        initData();
    }

    private final void I9(View rootView) {
        View findViewById = rootView.findViewById(R.id.nhc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_container)");
        this.titleContainer = findViewById;
        View findViewById2 = rootView.findViewById(R.id.nkf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.nk8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_sub_title)");
        this.tvSubTitle = (TextView) findViewById3;
        View view = this.titleContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view = null;
        }
        view.setBackground(getContext().getDrawable(R.drawable.qui_common_bg_bottom_light_bg));
        View view3 = this.titleContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        } else {
            view2 = view3;
        }
        view2.setVisibility(8);
    }
}
