package com.tencent.mobileqq.vas.clean;

import android.content.SharedPreferences;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/clean/VasMMKVCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getWhiteList", "", "getClearSize", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasMMKVCleanUpThoroughCacheTool implements y {

    @NotNull
    public static final String TAG = "ThemeCleanUpThoroughCacheTool";

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        if (ar.INSTANCE.b("anzaihuang", "2024-04-11", "vas_bug_122711015").isEnable(true)) {
            VasMMKV.Companion companion = VasMMKV.INSTANCE;
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            SharedPreferences vipInfo = companion.getVipInfo(context, "QZONE_VIP_INFO");
            SharedPreferences.Editor edit = vipInfo.edit();
            Map<String, ?> all = vipInfo.getAll();
            Intrinsics.checkNotNullExpressionValue(all, "sp.all");
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                edit.remove(it.next().getKey());
            }
            edit.apply();
            edit.putBoolean("_migrate_flag_", true).apply();
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    @NotNull
    public ArrayList<String> getWhiteList() {
        return new ArrayList<>();
    }
}
