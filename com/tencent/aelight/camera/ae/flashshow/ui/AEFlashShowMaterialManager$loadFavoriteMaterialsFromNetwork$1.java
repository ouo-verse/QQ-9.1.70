package com.tencent.aelight.camera.ae.flashshow.ui;

import com.tencent.mobileqq.app.LocaleManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager", f = "AEFlashShowMaterialManager.kt", i = {}, l = {433, LocaleManager.MOBILE_COUNTRY_CODE_CN_INT}, m = "loadFavoriteMaterialsFromNetwork", n = {}, s = {})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AEFlashShowMaterialManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1(AEFlashShowMaterialManager aEFlashShowMaterialManager, Continuation<? super AEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1> continuation) {
        super(continuation);
        this.this$0 = aEFlashShowMaterialManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object R;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        R = this.this$0.R(this);
        return R;
    }
}
