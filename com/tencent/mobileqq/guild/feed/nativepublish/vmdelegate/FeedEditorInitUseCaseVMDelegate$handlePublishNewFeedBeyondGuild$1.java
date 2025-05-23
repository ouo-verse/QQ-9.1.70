package com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate;

import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class FeedEditorInitUseCaseVMDelegate$handlePublishNewFeedBeyondGuild$1 extends FunctionReferenceImpl implements Function0<CoroutineScope> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedEditorInitUseCaseVMDelegate$handlePublishNewFeedBeyondGuild$1(Object obj) {
        super(0, obj, BaseVM.class, "vmScope", "vmScope()Lkotlinx/coroutines/CoroutineScope;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final CoroutineScope invoke() {
        return ((BaseVM) this.receiver).vmScope();
    }
}
