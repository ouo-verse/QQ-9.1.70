package com.qzone.reborn.groupalbum.upload.selectalbum;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/groupalbum/upload/selectalbum/a;", "Lcom/qzone/reborn/base/k;", "Ll9/l;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/qzone/reborn/albumx/common/bean/h;", ICustomDataEditor.STRING_ARRAY_PARAM_4, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends com.qzone.reborn.base.k implements l9.l {
    @Override // l9.l
    public List<Class<? extends Section<com.qzone.reborn.albumx.common.bean.h>>> a4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(vi.a.class);
        arrayList.add(com.qzone.reborn.albumx.common.section.selectalbum.h.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        registerIoc(this, l9.l.class);
    }
}
