package com.tencent.mobileqq.zootopia.ue;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.lua.ZootopiaShopSendGiftLuaPlugin;
import com.tencent.sqshow.zootopia.data.ZootopiaPortalGiftData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/i;", "Lcom/tencent/mobileqq/zootopia/ue/a;", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShopSendGiftLuaPlugin$b;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShopSendGiftLuaPlugin;", "e", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ue/d;", DownloadInfo.spKey_Config, "", "u9", "resume", "pause", "Lcom/tencent/sqshow/zootopia/data/p;", "sendGiftData", "b", "destroy", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i extends a implements ZootopiaShopSendGiftLuaPlugin.b {
    @Override // com.tencent.mobileqq.zootopia.lua.ZootopiaShopSendGiftLuaPlugin.b
    public void b(ZootopiaPortalGiftData sendGiftData) {
        Intrinsics.checkNotNullParameter(sendGiftData, "sendGiftData");
        ta4.b.f435764a.c(c(), sendGiftData);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void destroy() {
        ZootopiaShopSendGiftLuaPlugin.INSTANCE.a().c(this);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a
    protected List<ZootopiaShopSendGiftLuaPlugin> e() {
        List<ZootopiaShopSendGiftLuaPlugin> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(ZootopiaShopSendGiftLuaPlugin.INSTANCE.a());
        return listOf;
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a, com.tencent.mobileqq.zootopia.ue.c
    public void pause() {
        super.pause();
        ZootopiaShopSendGiftLuaPlugin.INSTANCE.a().c(this);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a, com.tencent.mobileqq.zootopia.ue.c
    public void resume() {
        super.resume();
        ZootopiaShopSendGiftLuaPlugin.INSTANCE.a().b(this);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a, com.tencent.mobileqq.zootopia.ue.c
    public void u9(FragmentActivity activity, d config) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(config, "config");
        super.u9(activity, config);
        ZootopiaShopSendGiftLuaPlugin.INSTANCE.a().b(this);
    }
}
