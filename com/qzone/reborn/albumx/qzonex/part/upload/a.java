package com.qzone.reborn.albumx.qzonex.part.upload;

import android.content.res.Configuration;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/upload/a;", "Ltl/g;", "", "va", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Z9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Ldb/d;", "G", "Ldb/d;", "getParams", "()Ldb/d;", "params", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "H", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "getInitBean", "()Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "initBean", "Ltl/h;", "I", "Ltl/h;", "mediaPickViewModel", "<init>", "(Ldb/d;Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;)V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends tl.g {

    /* renamed from: G, reason: from kotlin metadata */
    private final db.d params;

    /* renamed from: H, reason: from kotlin metadata */
    private final QZAlbumxUploadAlbumInitBean initBean;

    /* renamed from: I, reason: from kotlin metadata */
    private tl.h mediaPickViewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(db.d params, QZAlbumxUploadAlbumInitBean initBean) {
        super(params);
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.params = params;
        this.initBean = initBean;
    }

    private final void va() {
        String joinToString$default;
        if (bl.b(this.initBean.getSelectImageList())) {
            return;
        }
        List<String> selectImageList = this.initBean.getSelectImageList();
        Intrinsics.checkNotNull(selectImageList);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(selectImageList, ",", null, null, 0, null, null, 62, null);
        QLog.i("QZAlbumxMediaPickPart", 1, "handleParseSelectedImageList  selectImageList=" + joinToString$default);
        DynamicArrayList<String> dynamicArrayList = new DynamicArrayList<>();
        List<String> selectImageList2 = this.initBean.getSelectImageList();
        Intrinsics.checkNotNull(selectImageList2);
        dynamicArrayList.addAll(selectImageList2);
        tl.h hVar = this.mediaPickViewModel;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaPickViewModel");
            hVar = null;
        }
        hVar.P1().setValue(dynamicArrayList);
        this.f436499f = dynamicArrayList;
        ja();
    }

    @Override // tl.g
    protected boolean Z9() {
        return (this.initBean.getFromType() == 6 || this.initBean.getFromType() == 7) ? false : true;
    }

    @Override // tl.g, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxMediaPickPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ja();
    }

    @Override // tl.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(tl.h.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneMediaPickViewModel::class.java)");
        this.mediaPickViewModel = (tl.h) viewModel;
        va();
    }
}
