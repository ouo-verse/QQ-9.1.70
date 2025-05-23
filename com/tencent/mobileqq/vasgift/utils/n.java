package com.tencent.mobileqq.vasgift.utils;

import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vasgift/utils/n;", "", "", "scene", "", "b", "a", "Z", "()Z", "isEnable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "sceneList", "<init>", "()V", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> sceneList;

    public n() {
        IConfigProxy iConfigProxy = VasLongToggle.VAS_COMBO_GIFT_DOWNLOAD_CONFIG;
        boolean isEnable = iConfigProxy.isEnable(true);
        this.isEnable = isEnable;
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.sceneList = arrayList;
        if (isEnable) {
            JSONArray optJSONArray = iConfigProxy.getJson().optJSONArray("scene_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    this.sceneList.add(Integer.valueOf(optJSONArray.optInt(i3)));
                }
                return;
            }
            return;
        }
        arrayList.add(10008);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    public final boolean b(int scene) {
        return this.sceneList.contains(Integer.valueOf(scene));
    }
}
