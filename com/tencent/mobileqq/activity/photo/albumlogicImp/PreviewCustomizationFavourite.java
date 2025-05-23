package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/activity/photo/albumlogicImp/PreviewCustomizationFavourite;", "Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "Landroid/content/Intent;", "intent", "", "initData", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "onSendClick", "", "needGestureUp", "Lcom/tencent/mobileqq/activity/photo/albumlogicImp/PluginData;", "a", "Lcom/tencent/mobileqq/activity/photo/albumlogicImp/PluginData;", "pluginData", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "b", "Companion", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PreviewCustomizationFavourite extends PreviewCustomizationBase<a> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private PluginData pluginData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewCustomizationFavourite(FragmentActivity activity, b<a> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    public View getBottomView(Context context, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(context).inflate(R.layout.dwz, parent, false);
        setSendBtn((Button) inflate.findViewById(R.id.utu));
        Button sendBtn = getSendBtn();
        if (sendBtn != null) {
            sendBtn.setText("\u786e\u5b9a");
        }
        return inflate;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void initData(Intent intent) {
        super.initData(intent);
        this.pluginData = h71.a.a(intent);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    public boolean needGestureUp() {
        return false;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onSendClick() {
        int collectionSizeOrDefault;
        super.onSendClick();
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
        QLog.d("PreviewCustomizationFavourite", 1, "[preview] onSendClick " + arrayList);
        for (LocalMediaInfo localMediaInfo : getPhotoCommonData().h()) {
            localMediaInfo.setSelectStatus(2);
            com.tencent.qqnt.qbasealbum.ktx.b.s(localMediaInfo, 0);
        }
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
                return;
            }
        }
        QLog.d("PreviewCustomizationFavourite", 1, "[preview] onSendClick packageName or className is null");
    }
}
