package com.qzone.reborn.intimate.part.albumDetail;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tH\u0016J\u001c\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tH\u0016J\u001c\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumDetail/a;", "Lcom/qzone/reborn/base/k;", "Ll9/b;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "B4", "r6", "K2", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends com.qzone.reborn.base.k implements l9.b {
    @Override // l9.b
    public List<Class<? extends Section<CommonGridItemData>>> B4() {
        return new ArrayList();
    }

    @Override // l9.b
    public List<Class<? extends Section<CommonGridItemData>>> K2() {
        return new ArrayList();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        registerIoc(this, l9.b.class);
    }

    @Override // l9.b
    public List<Class<? extends Section<CommonGridItemData>>> r6() {
        List<Class<? extends Section<CommonGridItemData>>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(ek.b.class);
        return mutableListOf;
    }
}
