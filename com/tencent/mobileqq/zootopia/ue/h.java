package com.tencent.mobileqq.zootopia.ue;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.lua.ZootopiaReturnLuaPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/h;", "Lcom/tencent/mobileqq/zootopia/ue/a;", "Lcom/tencent/mobileqq/zootopia/api/d;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ue/d;", DownloadInfo.spKey_Config, "", "u9", "", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaReturnLuaPlugin;", "e", "destroy", "Vd", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h extends a implements com.tencent.mobileqq.zootopia.api.d {
    @Override // com.tencent.mobileqq.zootopia.api.d
    public void Vd() {
        if (c().isFinishing()) {
            return;
        }
        c().finish();
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void destroy() {
        ZootopiaReturnLuaPlugin.INSTANCE.a().c(this);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a
    protected List<ZootopiaReturnLuaPlugin> e() {
        List<ZootopiaReturnLuaPlugin> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(ZootopiaReturnLuaPlugin.INSTANCE.a());
        return listOf;
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a, com.tencent.mobileqq.zootopia.ue.c
    public void u9(FragmentActivity activity, d config) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(config, "config");
        super.u9(activity, config);
        ZootopiaReturnLuaPlugin.INSTANCE.a().b(this);
    }
}
