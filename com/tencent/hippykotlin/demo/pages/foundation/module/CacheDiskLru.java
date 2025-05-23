package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CacheDiskLru {
    public final int config;
    public List<String> lruList;
    public final String nameDes;

    public CacheDiskLru(int i3) {
        CacheModule cacheModule;
        List emptyList;
        List<String> mutableList;
        this.config = i3;
        this.lruList = new ArrayList();
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("lru_");
        m3.append(LruConfig$EnumUnboxingLocalUtility._getNameDes(i3));
        String sb5 = m3.toString();
        this.nameDes = sb5;
        cacheModule = Utils.INSTANCE.cacheModule("");
        String string = cacheModule.getString(sb5);
        if (!(string.length() > 0)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{",CacheLru,"}, false, 0, 6, (Object) null);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) emptyList);
        this.lruList = mutableList;
        checkRemove();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m16 = CacheDiskLru$$ExternalSyntheticOutline0.m("init: str=", string, ", ");
        m16.append(this.lruList.size());
        kLog.i("CacheLru", m16.toString());
    }

    public final void add(String str, String str2) {
        String name = getName(str);
        if (this.lruList.contains(name)) {
            this.lruList.remove(name);
        }
        Utils.INSTANCE.cacheModule("").setItem(name, str2);
        this.lruList.add(name);
        checkRemove();
    }

    public final void checkRemove() {
        String joinToString$default;
        Object firstOrNull;
        try {
            if (this.lruList.size() > 0 && LruConfig$EnumUnboxingLocalUtility.getMaxSize(this.config) > 0) {
                while (true) {
                    if (this.lruList.size() <= LruConfig$EnumUnboxingLocalUtility.getMaxSize(this.config)) {
                        break;
                    }
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.lruList);
                    String str = (String) firstOrNull;
                    if (str != null) {
                        Utils.INSTANCE.cacheModule("").toNative(false, "removeItem", str, null, true);
                        this.lruList.remove(0);
                    } else {
                        KLog.INSTANCE.d("CacheLru", "checkRemove: itemToRemove is null");
                        break;
                    }
                }
            }
            CacheModule cacheModule = Utils.INSTANCE.cacheModule("");
            String str2 = this.nameDes;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.lruList, ",CacheLru,", null, null, 0, null, null, 62, null);
            cacheModule.setItem(str2, joinToString$default);
        } catch (Exception e16) {
            KLog.INSTANCE.e("CacheLru", "checkRemove: " + e16);
        }
    }

    public final String get(String str) {
        String item = Utils.INSTANCE.cacheModule("").getItem(getName(str));
        if (item.length() > 0) {
            return item;
        }
        return null;
    }

    public final String getName(String str) {
        return OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.nameDes, str);
    }

    public final void remove(String str) {
        String name = getName(str);
        if (this.lruList.contains(name)) {
            this.lruList.remove(name);
            Utils.INSTANCE.cacheModule("").toNative(false, "removeItem", name, null, true);
        }
    }
}
