package com.tencent.mobileqq.wink.editor.sticker;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/c;", "", "Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContentWrapper;", "wrapper", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f321565a = new c();

    c() {
    }

    @Nullable
    public final MetaMaterialContentWrapper a(@Nullable MetaMaterialContentWrapper wrapper) {
        MetaMaterialContent copy;
        if (wrapper == null) {
            return null;
        }
        MetaMaterialContentWrapper metaMaterialContentWrapper = new MetaMaterialContentWrapper(null, 1, null);
        for (MetaMaterialContent metaMaterialContent : wrapper.getMetaMaterialContent()) {
            ArrayList<MetaMaterialContent> metaMaterialContent2 = metaMaterialContentWrapper.getMetaMaterialContent();
            copy = metaMaterialContent.copy((r44 & 1) != 0 ? metaMaterialContent.content : null, (r44 & 2) != 0 ? metaMaterialContent.layerName : null, (r44 & 4) != 0 ? metaMaterialContent.layerIndex : null, (r44 & 8) != 0 ? metaMaterialContent.layerType : null, (r44 & 16) != 0 ? metaMaterialContent.defaultText : null, (r44 & 32) != 0 ? metaMaterialContent.textColor : null, (r44 & 64) != 0 ? metaMaterialContent.fontFamily : null, (r44 & 128) != 0 ? metaMaterialContent.fontStyle : null, (r44 & 256) != 0 ? metaMaterialContent.applyFill : null, (r44 & 512) != 0 ? metaMaterialContent.applyStroke : null, (r44 & 1024) != 0 ? metaMaterialContent.baselineShift : null, (r44 & 2048) != 0 ? metaMaterialContent.boxText : null, (r44 & 4096) != 0 ? metaMaterialContent.firstBaseLine : null, (r44 & 8192) != 0 ? metaMaterialContent.fauxBold : null, (r44 & 16384) != 0 ? metaMaterialContent.fauxItalic : null, (r44 & 32768) != 0 ? metaMaterialContent.fontSize : null, (r44 & 65536) != 0 ? metaMaterialContent.strokeColor : null, (r44 & 131072) != 0 ? metaMaterialContent.strokeOverFill : null, (r44 & 262144) != 0 ? metaMaterialContent.stokeWidth : null, (r44 & 524288) != 0 ? metaMaterialContent.justification : null, (r44 & 1048576) != 0 ? metaMaterialContent.leading : null, (r44 & 2097152) != 0 ? metaMaterialContent.tracking : null, (r44 & 4194304) != 0 ? metaMaterialContent.backgroundColor : null, (r44 & 8388608) != 0 ? metaMaterialContent.backgroundAlpha : null, (r44 & 16777216) != 0 ? metaMaterialContent.layerSize : null, (r44 & 33554432) != 0 ? metaMaterialContent.fontPath : null);
            metaMaterialContent2.add(copy);
        }
        return metaMaterialContentWrapper;
    }
}
