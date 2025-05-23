package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import t35.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Tacit {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(Tacit.class, "showAfter", "getShowAfter()Z", 0)};
    public int answer;

    /* renamed from: id, reason: collision with root package name */
    public final int f114238id;
    public final List<String> options;
    public final String question;
    public final ReadWriteProperty showAfter$delegate = c.a(Boolean.FALSE);
    public final int status;
    public final a tag;
    public final int type;

    public Tacit(int i3, int i16, String str, a aVar, int i17, List list, int i18) {
        this.f114238id = i3;
        this.type = i16;
        this.question = str;
        this.tag = aVar;
        this.answer = i17;
        this.options = list;
        this.status = i18;
    }

    public final boolean iSelect() {
        return this.type == 2;
    }

    public final boolean isJudge() {
        return this.type == 1;
    }

    public final void setShowAfter(boolean z16) {
        this.showAfter$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
