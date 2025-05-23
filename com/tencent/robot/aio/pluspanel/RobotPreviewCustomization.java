package com.tencent.robot.aio.pluspanel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/aio/pluspanel/RobotPreviewCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "Landroid/content/Intent;", "intent", "", "initData", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "", "needGestureUp", "onSendClick", "", "TAG", "Ljava/lang/String;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotPreviewCustomization extends PreviewCustomizationBase<a> {

    @NotNull
    private final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotPreviewCustomization(@NotNull FragmentActivity activity, @NotNull b<a> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        this.TAG = "RobotPreviewCustomization";
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    @Nullable
    public View getBottomView(@NotNull Context context, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View bottomView = super.getBottomView(context, parent);
        Button sendBtn = getSendBtn();
        if (sendBtn != null) {
            sendBtn.setText("\u786e\u5b9a");
        }
        TextView qualityTv = getQualityTv();
        if (qualityTv != null) {
            qualityTv.setVisibility(8);
        }
        CheckBox qualityCb = getQualityCb();
        if (qualityCb != null) {
            qualityCb.setVisibility(8);
        }
        TextView qualitySize = getQualitySize();
        if (qualitySize != null) {
            qualitySize.setVisibility(8);
        }
        return bottomView;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void initData(@Nullable Intent intent) {
        super.initData(intent);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    public boolean needGestureUp() {
        return false;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onSendClick() {
        Bundle bundle = new Bundle();
        AlbumResult albumResult = new AlbumResult();
        albumResult.o(new ArrayList(getPhotoCommonData().h()));
        albumResult.m(getPhotoCommonData().j());
        albumResult.j(getPhotoCommonData().b());
        albumResult.l(false);
        Unit unit = Unit.INSTANCE;
        bundle.putParcelable("ALBUM_RESULT", albumResult);
        ox3.a.a("QBaseAlbum.Customization", new Function0<String>() { // from class: com.tencent.robot.aio.pluspanel.RobotPreviewCustomization$onSendClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                int collectionSizeOrDefault;
                boolean i3 = QAlbumPickerContext.f361201a.i();
                boolean j3 = RobotPreviewCustomization.this.getPhotoCommonData().j();
                List<LocalMediaInfo> h16 = RobotPreviewCustomization.this.getPhotoCommonData().h();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = h16.iterator();
                while (it.hasNext()) {
                    arrayList.add(((LocalMediaInfo) it.next()).getPath());
                }
                return "[picker] onSendBtnClick finish needActivityResult: " + i3 + ", isQuality:" + j3 + ", " + arrayList;
            }
        });
        if (QAlbumPickerContext.f361201a.i()) {
            getActivity().setResult(-1, new Intent().putExtras(bundle));
        } else {
            g.f361234b.n(getActivity(), bundle);
        }
        getActivity().finish();
        getActivity().overridePendingTransition(0, R.anim.f154816sj);
    }
}
