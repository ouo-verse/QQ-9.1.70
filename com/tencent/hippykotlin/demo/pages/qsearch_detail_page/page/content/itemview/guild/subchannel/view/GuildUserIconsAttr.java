package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience;
import com.tencent.kuikly.core.base.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildUserIconsAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildUserIconsAttr.class, "rightIcon", "getRightIcon()Ljava/lang/String;", 0)};
    public String audienceCount;
    public float fontSize;
    public final ReadWriteProperty rightIcon$delegate;
    public float rightIconSize;
    public List<String> userAvatars;

    public GuildUserIconsAttr() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.userAvatars = emptyList;
        this.audienceCount = "";
        this.rightIcon$delegate = c.a("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACUAAAAsCAYAAADikXHLAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAI7SURBVHgB7ZitcgIxEMf3DgqmD4DnHKL4InCtp2gwVSgUqgM8AaYvgKb14HkAKnDUtx5/3YWEOXLJkc8ZZsp/JpO7TWbzu80mlwnATf9RaZpGmTqimhd6BwfFYCEOlBn8UE+nUw4KQruRbL+IInKA2G630WKxgG63e2rE9/TIhvSRU9BuCi+cpRmWJniSVaJLVMNCYD3wIF9QXH0fYD4jxUVgL+AgZygESCTmgUuO+YhUorCPEOweLOQD6klhpym1mkYnKDZFRdPUsYmWNRQbbHShG/V5Zv1runnmEqkZnK86lTiI9l5me0qgCCWa3eus5v0vbhnGUOhwAGxKNMWj+ZCx9RRbiTkUOuqAxYqifMKqlTFRrg3AFYo57oOdZHnUVCW+SaTIsdVmCOrplia9FhSLkkke6UoaLd1ItSCcrKEeIZxyq1AXSmeTtFVdNFwDVM6375OnF+lC7SGccr6vAWonGnShviCcvkWDLtQSwmktGrSg8D5gA2Gm8If5PpPJ6psr7HuwB5b61IbCL/rAaiNp2oEauEgr9Ll0gmJ6g/xq+WXAn6Av8vGuajSCwsFpmoZYVpI2GkQnYhTtIfMlHwcshUcOOsrQeWiPA7xm7PTboDO8+PcniDmLaqGcr9kQooUDrSV2gktYIaBlUXRuCq7JZBJTwccSlhgvX0vtdruMz2WhriRJUsW62mg0+HMFyx1rj1mJMjfNJxnlFHcg3PiS48Nt8LEpopvi3KpGuNM99ng8TpmfVDbOH0irzaPhyDAkAAAAAElFTkSuQmCC");
        this.fontSize = 12.0f;
        this.rightIconSize = 12.0f;
    }

    public final void audienceList(List<Audience> list) {
        int collectionSizeOrDefault;
        List<String> list2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Audience) it.next()).avatar);
        }
        list2 = CollectionsKt___CollectionsKt.toList(arrayList);
        this.userAvatars = list2;
    }

    public final void setRightIcon(String str) {
        this.rightIcon$delegate.setValue(this, $$delegatedProperties[0], str);
    }
}
