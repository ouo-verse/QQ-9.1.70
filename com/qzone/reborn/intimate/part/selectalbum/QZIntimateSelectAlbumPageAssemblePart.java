package com.qzone.reborn.intimate.part.selectalbum;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.reborn.albumx.common.bean.h;
import com.qzone.reborn.albumx.common.section.selectalbum.g;
import com.qzone.reborn.base.k;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import l9.l;
import mqq.app.Constants;
import nk.bb;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tH\u0016R#\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/intimate/part/selectalbum/QZIntimateSelectAlbumPageAssemblePart;", "Lcom/qzone/reborn/base/k;", "Ll9/l;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/qzone/reborn/albumx/common/bean/h;", ICustomDataEditor.STRING_ARRAY_PARAM_4, "Lnk/bb;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "C9", "()Lnk/bb;", "vm", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateSelectAlbumPageAssemblePart extends k implements l {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    public QZIntimateSelectAlbumPageAssemblePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<bb>() { // from class: com.qzone.reborn.intimate.part.selectalbum.QZIntimateSelectAlbumPageAssemblePart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final bb invoke() {
                return (bb) QZIntimateSelectAlbumPageAssemblePart.this.getViewModel(bb.class);
            }
        });
        this.vm = lazy;
    }

    private final bb C9() {
        return (bb) this.vm.getValue();
    }

    @Override // l9.l
    public List<Class<? extends Section<h>>> a4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(lk.a.class);
        if (C9().Q1()) {
            arrayList.add(com.qzone.reborn.albumx.common.section.selectalbum.h.class);
            arrayList.add(g.class);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        registerIoc(this, l.class);
    }
}
