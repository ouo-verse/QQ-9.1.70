package com.tencent.richframework.gallery.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.idata.IDataStore;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.datacenter.ExtraDataWrapper;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/richframework/gallery/part/RFWLayerExtraDataPart;", "Lcom/tencent/biz/richframework/part/Part;", "()V", "extraDataStore", "Lcom/tencent/richframework/data/idata/IDataStore;", "Lcom/tencent/richframework/gallery/datacenter/ExtraDataWrapper;", "extraDataStoreKey", "", "initIntentData", "", "bundle", "Landroid/os/Bundle;", "onPartCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", Constants.FILE_INSTANCE_STATE, "onPartDestroy", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerExtraDataPart extends Part {
    private IDataStore<ExtraDataWrapper> extraDataStore;
    private String extraDataStoreKey;

    private final void initIntentData(Bundle bundle) {
        List<RFWLayerItemMediaInfo> richMediaDataList;
        ExtraDataWrapper data;
        IDataStore<ExtraDataWrapper> iDataStore = null;
        String string = bundle.getString("EXTRA_STORE_KEY", null);
        if (string != null) {
            this.extraDataStoreKey = string;
            IDataStore<ExtraDataWrapper> iDataStore2 = RFWLayerDataCenter.INSTANCE.getAllDataStore().get(this.extraDataStoreKey);
            if (iDataStore2 instanceof IDataStore) {
                iDataStore = iDataStore2;
            }
            this.extraDataStore = iDataStore;
            IDataStore<ExtraDataWrapper> iDataStore3 = this.extraDataStore;
            if (iDataStore3 != null) {
                Context context = getContext();
                if (context != null) {
                    RFWLayerInitBean rFWLayerInitBean = (RFWLayerInitBean) ((Activity) context).getIntent().getParcelableExtra(RFWLaunchKey.KEY_INIT_BEAN);
                    if (rFWLayerInitBean != null && (richMediaDataList = rFWLayerInitBean.getRichMediaDataList()) != null) {
                        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
                            String mediaId = rFWLayerItemMediaInfo.getMediaId();
                            if (!TextUtils.isEmpty(mediaId) && (data = iDataStore3.getData(mediaId)) != null) {
                                rFWLayerItemMediaInfo.setExtraData(data);
                            }
                        }
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        Intent intent = activity.getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            Intrinsics.checkNotNullExpressionValue(extras, "activity.intent?.extras ?: return");
            initIntentData(extras);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        if (this.extraDataStoreKey != null) {
            RFWLayerDataCenter.INSTANCE.getAllDataStore().remove(this.extraDataStoreKey);
        }
    }
}
