package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallFlowerCardShareViewModel", f = "LoveWallFlowerCardSharePageView.kt", i = {0, 0, 0, 0}, l = {230}, m = "share", n = {"this", "sharePanelViewModel", "shareItem", HippyHeaderListViewController.VIEW_TAG}, s = {"L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes37.dex */
public final class LoveWallFlowerCardShareViewModel$share$1 extends ContinuationImpl {
    public int I$0;
    public LoveWallFlowerCardShareViewModel L$0;
    public ImageSharePanelViewModel L$1;
    public ShareItem L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ LoveWallFlowerCardShareViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallFlowerCardShareViewModel$share$1(LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel, Continuation<? super LoveWallFlowerCardShareViewModel$share$1> continuation) {
        super(continuation);
        this.this$0 = loveWallFlowerCardShareViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.share(0, null, null, this);
    }
}
