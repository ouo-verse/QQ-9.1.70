package com.tencent.mobileqq.wink.edit.manager;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public /* synthetic */ class WinkEditorStickerResourceManager$getQQMetaCategoryList$2 extends FunctionReferenceImpl implements Function0<MetaCategory> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkEditorStickerResourceManager$getQQMetaCategoryList$2(Object obj) {
        super(0, obj, WinkEditorStickerResourceManager.class, "fetchQQFavoriteMetaCategory", "fetchQQFavoriteMetaCategory()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final MetaCategory invoke() {
        MetaCategory g16;
        g16 = ((WinkEditorStickerResourceManager) this.receiver).g();
        return g16;
    }
}
