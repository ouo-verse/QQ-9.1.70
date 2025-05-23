package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.report.c;
import cooperation.qqfav.QfavHelper;
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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/activity/photo/albumlogicImp/PickerCustomizationFavourite;", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "Landroid/content/Intent;", "intent", "", "initData", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "v", "onSendBtnClick", "Lcom/tencent/mobileqq/activity/photo/albumlogicImp/PluginData;", "a", "Lcom/tencent/mobileqq/activity/photo/albumlogicImp/PluginData;", "pluginData", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "b", "Companion", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PickerCustomizationFavourite extends PickerCustomizationBase<a> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private PluginData pluginData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerCustomizationFavourite(FragmentActivity activity, b<a> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.a
    public View getBottomView(Context context, ViewGroup parent) {
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
        TextView textView = bottomView != null ? (TextView) bottomView.findViewById(R.id.f25150a2) : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        return bottomView;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void initData(Intent intent) {
        super.initData(intent);
        this.pluginData = h71.a.a(intent);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onSendBtnClick(View v3) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(v3, "v");
        super.onSendBtnClick(v3);
        Bundle bundle = new Bundle();
        AlbumResult albumResult = new AlbumResult();
        albumResult.o(new ArrayList(getPhotoCommonData().h()));
        Unit unit = Unit.INSTANCE;
        bundle.putParcelable("ALBUM_RESULT", albumResult);
        List<LocalMediaInfo> h16 = getPhotoCommonData().h();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = h16.iterator();
        while (it.hasNext()) {
            arrayList.add(((LocalMediaInfo) it.next()).getPath());
        }
        QLog.d("PickerCustomizationFavourite", 1, "[picker] onSendBtnClick finish: " + arrayList);
        PluginData pluginData = this.pluginData;
        if (!TextUtils.isEmpty(pluginData != null ? pluginData.getPackageName() : null)) {
            PluginData pluginData2 = this.pluginData;
            if (!TextUtils.isEmpty(pluginData2 != null ? pluginData2.getClassName() : null)) {
                Intent intent = new Intent();
                PluginData pluginData3 = this.pluginData;
                String packageName = pluginData3 != null ? pluginData3.getPackageName() : null;
                Intrinsics.checkNotNull(packageName);
                PluginData pluginData4 = this.pluginData;
                String className = pluginData4 != null ? pluginData4.getClassName() : null;
                Intrinsics.checkNotNull(className);
                intent.setClassName(packageName, className);
                intent.addFlags(603979776);
                intent.putExtras(bundle);
                FragmentActivity activity = getActivity();
                PluginData pluginData5 = this.pluginData;
                QfavHelper.D(activity, pluginData5 != null ? pluginData5.getUin() : null, intent, 2);
                getActivity().finish();
                getActivity().overridePendingTransition(0, R.anim.f154816sj);
                c.f361503a.c("em_bas_send", 2, new Function0<Map<String, ? extends Object>>() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PickerCustomizationFavourite$onSendBtnClick$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Map<String, ? extends Object> invoke() {
                        Map<String, ? extends Object> mapOf;
                        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("aio_type", Integer.valueOf(QAlbumPickerContext.f361201a.f())), TuplesKt.to("number_sent", Integer.valueOf(PickerCustomizationFavourite.this.getPhotoCommonData().h().size())), TuplesKt.to("is_original", Integer.valueOf(!PickerCustomizationFavourite.this.getPhotoCommonData().j() ? 1 : 0)));
                        return mapOf;
                    }
                });
                return;
            }
        }
        QLog.d("PickerCustomizationFavourite", 1, "[picker] onSendBtnClick packageName or className is null");
    }
}
