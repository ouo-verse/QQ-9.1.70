package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view;

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
public final class GuildDoubleItemMiddleAvatarAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildDoubleItemMiddleAvatarAttr.class, "play", "getPlay()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildDoubleItemMiddleAvatarAttr.class, "userScrolling", "getUserScrolling()Z", 0)};
    public List<Audience> audienceList;
    public float marginBetweenAvatar;
    public int maxAvatarCount;
    public final ReadWriteProperty play$delegate;
    public final ReadWriteProperty userScrolling$delegate;

    public GuildDoubleItemMiddleAvatarAttr() {
        List<Audience> emptyList;
        Boolean bool = Boolean.FALSE;
        this.play$delegate = c.a(bool);
        this.userScrolling$delegate = c.a(bool);
        this.marginBetweenAvatar = 4.0f;
        this.maxAvatarCount = 3;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.audienceList = emptyList;
    }
}
