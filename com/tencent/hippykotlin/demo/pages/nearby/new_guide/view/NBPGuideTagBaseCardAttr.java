package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import kotlin.Pair;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import t35.a;

/* loaded from: classes31.dex */
public class NBPGuideTagBaseCardAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagBaseCardAttr.class, "tagList", "getTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagBaseCardAttr.class, "emojiPosition", "getEmojiPosition()Lkotlin/Pair;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagBaseCardAttr.class, "emojiRotation", "getEmojiRotation()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagBaseCardAttr.class, "tagColor", "getTagColor()Lcom/tencent/kuikly/core/base/Color;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagBaseCardAttr.class, "emojiUrl", "getEmojiUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagBaseCardAttr.class, "tagPositions", "getTagPositions()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty emojiPosition$delegate;
    public final ReadWriteProperty emojiRotation$delegate;
    public final ReadWriteProperty emojiUrl$delegate;
    public final ReadWriteProperty tagColor$delegate;
    public final ReadWriteProperty tagList$delegate = c.b();
    public final ReadWriteProperty tagPositions$delegate;

    public NBPGuideTagBaseCardAttr() {
        Float valueOf = Float.valueOf(-1.0f);
        this.emojiPosition$delegate = c.a(new Pair(valueOf, valueOf));
        this.emojiRotation$delegate = c.a(Float.valueOf(0.0f));
        this.tagColor$delegate = c.a(h.INSTANCE.j());
        this.emojiUrl$delegate = c.a("");
        this.tagPositions$delegate = c.b();
    }

    public final Pair<Float, Float> getEmojiPosition() {
        return (Pair) this.emojiPosition$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final float getEmojiRotation() {
        return ((Number) this.emojiRotation$delegate.getValue(this, $$delegatedProperties[2])).floatValue();
    }

    public final String getEmojiUrl() {
        return (String) this.emojiUrl$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final h getTagColor() {
        return (h) this.tagColor$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<a> getTagList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tagList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<NBPGuideTagPosition> getTagPositions() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tagPositions$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void setEmojiPosition(Pair<Float, Float> pair) {
        this.emojiPosition$delegate.setValue(this, $$delegatedProperties[1], pair);
    }

    public final void setEmojiRotation(float f16) {
        this.emojiRotation$delegate.setValue(this, $$delegatedProperties[2], Float.valueOf(f16));
    }

    public final void setEmojiUrl(String str) {
        this.emojiUrl$delegate.setValue(this, $$delegatedProperties[4], str);
    }

    public final void setTagColor(h hVar) {
        this.tagColor$delegate.setValue(this, $$delegatedProperties[3], hVar);
    }

    public final void setTagList(com.tencent.kuikly.core.reactive.collection.c<a> cVar) {
        this.tagList$delegate.setValue(this, $$delegatedProperties[0], cVar);
    }

    public final void setTagPositions(com.tencent.kuikly.core.reactive.collection.c<NBPGuideTagPosition> cVar) {
        this.tagPositions$delegate.setValue(this, $$delegatedProperties[5], cVar);
    }
}
