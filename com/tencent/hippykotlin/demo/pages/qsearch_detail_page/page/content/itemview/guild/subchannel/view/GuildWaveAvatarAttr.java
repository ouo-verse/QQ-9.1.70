package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildWaveAvatarAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildWaveAvatarAttr.class, "play", "getPlay()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildWaveAvatarAttr.class, "userScrolling", "getUserScrolling()Z", 0)};
    public int colorB;
    public int colorG;
    public int colorR;
    public float maxAlpha;
    public float maxStrokeWidth;
    public float minStrokeWidth;
    public final ReadWriteProperty play$delegate;
    public String src = "";
    public final ReadWriteProperty userScrolling$delegate;
    public int waveCount;

    public GuildWaveAvatarAttr() {
        Boolean bool = Boolean.FALSE;
        this.play$delegate = c.a(bool);
        this.userScrolling$delegate = c.a(bool);
        this.waveCount = 2;
        this.maxStrokeWidth = 2.0f;
        this.minStrokeWidth = 1.0f;
        this.maxAlpha = 1.0f;
    }
}
