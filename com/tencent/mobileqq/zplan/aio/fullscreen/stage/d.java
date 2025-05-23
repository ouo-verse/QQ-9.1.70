package com.tencent.mobileqq.zplan.aio.fullscreen.stage;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.image.SharpDrawable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/fullscreen/stage/d;", "", "Lcom/tencent/mobileqq/zplan/aio/fullscreen/stage/d$a;", "a", "Lcom/tencent/mobileqq/zplan/aio/fullscreen/stage/d$a;", "playEndContWrapper", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a playEndContWrapper = new a(0, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u0006\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/fullscreen/stage/d$a;", "Lcom/tencent/image/SharpDrawable$OnPlayRepeatListener;", "", "count", "", HippyQQPagView.EventName.ON_PLAY_REPEAT, "a", "I", "totalPlayCount", "Lkotlin/coroutines/Continuation;", "b", "Lkotlin/coroutines/Continuation;", "getCont", "()Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "cont", "<init>", "(I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements SharpDrawable.OnPlayRepeatListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int totalPlayCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private volatile Continuation<? super Unit> cont;

        public a(int i3) {
            this.totalPlayCount = i3;
        }

        public final void a(Continuation<? super Unit> continuation) {
            this.cont = continuation;
        }

        @Override // com.tencent.image.SharpDrawable.OnPlayRepeatListener
        public void onPlayRepeat(int count) {
            Continuation<? super Unit> continuation;
            if (count != this.totalPlayCount || (continuation = this.cont) == null) {
                return;
            }
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
        }

        public /* synthetic */ a(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1 : i3);
        }
    }
}
