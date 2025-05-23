package com.tencent.robot.aio.pluspanel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.report.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/aio/pluspanel/RobotPickerCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "v", "", "onSendBtnClick", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotPickerCustomization<O extends a> extends PickerCustomizationBase<O> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotPickerCustomization(@NotNull FragmentActivity activity, @NotNull b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.a
    @Nullable
    public View getBottomView(@NotNull Context context, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View bottomView = super.getBottomView(context, parent);
        TextView magicBtn = getMagicBtn();
        if (magicBtn != null) {
            magicBtn.setVisibility(8);
        }
        CheckBox qualityCb = getQualityCb();
        if (qualityCb != null) {
            qualityCb.setVisibility(8);
        }
        TextView qualityTv = getQualityTv();
        if (qualityTv != null) {
            qualityTv.setVisibility(8);
        }
        return bottomView;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onSendBtnClick(@NotNull View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Bundle bundle = new Bundle();
        AlbumResult albumResult = new AlbumResult();
        albumResult.o(new ArrayList(getPhotoCommonData().h()));
        albumResult.m(getPhotoCommonData().j());
        albumResult.j(getPhotoCommonData().b());
        albumResult.l(false);
        Unit unit = Unit.INSTANCE;
        bundle.putParcelable("ALBUM_RESULT", albumResult);
        ox3.a.a("QBaseAlbum.Customization", new Function0<String>(this) { // from class: com.tencent.robot.aio.pluspanel.RobotPickerCustomization$onSendBtnClick$1
            final /* synthetic */ RobotPickerCustomization<O> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                int collectionSizeOrDefault;
                boolean i3 = QAlbumPickerContext.f361201a.i();
                boolean j3 = this.this$0.getPhotoCommonData().j();
                List<LocalMediaInfo> h16 = this.this$0.getPhotoCommonData().h();
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
        c.f361503a.c("em_bas_send", 2, new Function0<Map<String, ? extends Object>>(this) { // from class: com.tencent.robot.aio.pluspanel.RobotPickerCustomization$onSendBtnClick$2
            final /* synthetic */ RobotPickerCustomization<O> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends Object> invoke() {
                Map<String, ? extends Object> mapOf;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("aio_type", Integer.valueOf(QAlbumPickerContext.f361201a.f())), TuplesKt.to("number_sent", Integer.valueOf(this.this$0.getPhotoCommonData().h().size())), TuplesKt.to("is_original", Integer.valueOf(!this.this$0.getPhotoCommonData().j() ? 1 : 0)));
                return mapOf;
            }
        });
    }
}
