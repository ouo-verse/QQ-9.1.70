package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience;
import com.tencent.kuikly.core.base.k;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildItemMiddleAvatarAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildItemMiddleAvatarAttr.class, "play", "getPlay()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildItemMiddleAvatarAttr.class, "userScrolling", "getUserScrolling()Z", 0)};
    public String appIcon = "";
    public List<Audience> audienceList;
    public float cardWidth;
    public final ReadWriteProperty play$delegate;
    public final ReadWriteProperty userScrolling$delegate;

    public GuildItemMiddleAvatarAttr() {
        List<Audience> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.audienceList = emptyList;
        Boolean bool = Boolean.FALSE;
        this.play$delegate = c.a(bool);
        this.userScrolling$delegate = c.a(bool);
    }

    public final void setPlay(boolean z16) {
        this.play$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
