package com.tencent.mobileqq.guild.media;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.guild.api.emoji.IRandomLottieProxyApi;
import com.tencent.guildmedia.data.GuildMediaAIOLottieEvent;
import com.tencent.mobileqq.guild.media.widget.onlooker.GuildOnLookerViewHolder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a*\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u001a\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a \u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002\u001aM\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a*\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002\"0\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020 `!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\"4\u0010&\u001a\"\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001fj\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\u000f`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#\"0\u0010)\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020'0\u001fj\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020'`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010#\"0\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020*0\u001fj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020*`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010#\"\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"", "k", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "Landroid/view/ViewGroup;", "parentView", "", "lottieWH", "j", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Landroid/view/View;", "lottieView", "l", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "Landroid/widget/FrameLayout$LayoutParams;", "lottieLp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Ljava/util/ArrayList;Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;Landroid/view/ViewGroup;Landroid/widget/FrameLayout$LayoutParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "tag", "o", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "curLottieMap", "b", "curRandomLottieViewMap", "Ljava/lang/Runnable;", "c", "autoHideRunnableMap", "Landroid/animation/Animator;", "d", "runningAnimMap", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "uiHandler", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaAIOExKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final HashMap<Integer, Long> f227744a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<Long, View> f227745b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final HashMap<Long, Runnable> f227746c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final HashMap<View, Animator> f227747d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Handler f227748e = new Handler(Looper.getMainLooper());

    public static final void j(@Nullable SimpleBaseEvent simpleBaseEvent, @Nullable com.tencent.mobileqq.guild.media.core.data.p pVar, @NotNull ViewGroup parentView, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        if ((simpleBaseEvent instanceof GuildMediaAIOLottieEvent) && !GuildMediaUtils.m()) {
            GuildMediaAIOLottieEvent guildMediaAIOLottieEvent = (GuildMediaAIOLottieEvent) simpleBaseEvent;
            Object msgItem = guildMediaAIOLottieEvent.getMsgItem();
            if (msgItem instanceof GuildMsgItem) {
                GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
                String str2 = guildMsgItem.getMsgRecord().senderUid;
                if (pVar != null) {
                    str = pVar.f228093a;
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str2, str)) {
                    if (guildMediaAIOLottieEvent.getUpdateResult()) {
                        q(guildMsgItem, parentView);
                    } else {
                        p(guildMsgItem, parentView, i3);
                    }
                }
            }
        }
    }

    public static final void k() {
        f227744a.clear();
        f227745b.clear();
        f227746c.clear();
        f227748e.removeCallbacksAndMessages(null);
        f227747d.clear();
        QLog.i("GuildMediaAIOEx", 1, "[clearLottieEmojiCache] ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View view, int i3) {
        HashMap<View, Animator> hashMap = f227747d;
        Animator remove = hashMap.remove(view);
        if (remove != null) {
            remove.cancel();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new a(view));
        float f16 = i3 / 2.0f;
        view.setPivotX(f16);
        view.setPivotY(f16);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.1f, 1.0f).setDuration(660L), ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.1f, 1.0f).setDuration(660L));
        hashMap.put(view, animatorSet);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.view.View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m(GuildMsgItem guildMsgItem, ArrayList<MsgElement> arrayList, FaceElement faceElement, final ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, Continuation<? super View> continuation) {
        GuildMediaAIOExKt$getLottieView$1 guildMediaAIOExKt$getLottieView$1;
        Object coroutine_suspended;
        int i3;
        final Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        T t16;
        View view;
        final GuildMsgItem guildMsgItem2 = guildMsgItem;
        if (continuation instanceof GuildMediaAIOExKt$getLottieView$1) {
            guildMediaAIOExKt$getLottieView$1 = (GuildMediaAIOExKt$getLottieView$1) continuation;
            int i16 = guildMediaAIOExKt$getLottieView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildMediaAIOExKt$getLottieView$1.label = i16 - Integer.MIN_VALUE;
                GuildMediaAIOExKt$getLottieView$1 guildMediaAIOExKt$getLottieView$12 = guildMediaAIOExKt$getLottieView$1;
                Object obj = guildMediaAIOExKt$getLottieView$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildMediaAIOExKt$getLottieView$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        Ref.ObjectRef objectRef3 = (Ref.ObjectRef) guildMediaAIOExKt$getLottieView$12.L$2;
                        objectRef2 = (Ref.ObjectRef) guildMediaAIOExKt$getLottieView$12.L$1;
                        GuildMsgItem guildMsgItem3 = (GuildMsgItem) guildMediaAIOExKt$getLottieView$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        objectRef = objectRef3;
                        guildMsgItem2 = guildMsgItem3;
                        t16 = obj;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    objectRef = new Ref.ObjectRef();
                    int b16 = com.tencent.guild.aio.util.ex.e.b(arrayList);
                    Context context = viewGroup.getContext();
                    if (((IRandomLottieProxyApi) QRoute.api(IRandomLottieProxyApi.class)).isAniStickerRandom(b16)) {
                        Contact contact = new Contact(4, guildMsgItem.getMsgRecord().channelId, guildMsgItem.getMsgRecord().guildId);
                        IRandomLottieProxyApi iRandomLottieProxyApi = (IRandomLottieProxyApi) QRoute.api(IRandomLottieProxyApi.class);
                        long msgSeq = guildMsgItem.getMsgSeq();
                        guildMediaAIOExKt$getLottieView$12.L$0 = guildMsgItem2;
                        guildMediaAIOExKt$getLottieView$12.L$1 = objectRef;
                        guildMediaAIOExKt$getLottieView$12.L$2 = objectRef;
                        guildMediaAIOExKt$getLottieView$12.label = 1;
                        Object createRandomLottieAnimViewForMedia = iRandomLottieProxyApi.createRandomLottieAnimViewForMedia(context, viewGroup, faceElement, b16, false, msgSeq, contact, layoutParams, guildMediaAIOExKt$getLottieView$12);
                        if (createRandomLottieAnimViewForMedia == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef2 = objectRef;
                        t16 = createRandomLottieAnimViewForMedia;
                    } else {
                        objectRef.element = ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).createLottieAnimViewForMedia(context, viewGroup, b16, layoutParams, new Runnable() { // from class: com.tencent.mobileqq.guild.media.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                GuildMediaAIOExKt.n(viewGroup, guildMsgItem2, objectRef);
                            }
                        });
                        return objectRef.element;
                    }
                }
                objectRef.element = t16;
                view = (View) objectRef2.element;
                if (view != null) {
                    f227745b.put(Boxing.boxLong(guildMsgItem2.getMsgId()), view);
                }
                objectRef = objectRef2;
                return objectRef.element;
            }
        }
        guildMediaAIOExKt$getLottieView$1 = new GuildMediaAIOExKt$getLottieView$1(continuation);
        GuildMediaAIOExKt$getLottieView$1 guildMediaAIOExKt$getLottieView$122 = guildMediaAIOExKt$getLottieView$1;
        Object obj2 = guildMediaAIOExKt$getLottieView$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildMediaAIOExKt$getLottieView$122.label;
        if (i3 == 0) {
        }
        objectRef.element = t16;
        view = (View) objectRef2.element;
        if (view != null) {
        }
        objectRef = objectRef2;
        return objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void n(ViewGroup parentView, GuildMsgItem msgItem, Ref.ObjectRef lottieView) {
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(lottieView, "$lottieView");
        o(parentView, msgItem, (View) lottieView.element, "normal lottie");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ViewGroup viewGroup, GuildMsgItem guildMsgItem, View view, String str) {
        Long l3 = f227744a.get(Integer.valueOf(System.identityHashCode(viewGroup)));
        long msgId = guildMsgItem.getMsgId();
        if (l3 == null || l3.longValue() != msgId) {
            QLog.i("GuildMediaAIOEx", 1, "[hideLottieWhenFinish] skip diff msgId, tag:" + str);
            return;
        }
        if (viewGroup.getChildCount() == 0) {
            QLog.i("GuildMediaAIOEx", 1, "[hideLottieWhenFinish] skip by has removed, tag:" + str);
            return;
        }
        QLog.i("GuildMediaAIOEx", 1, "[hideLottieWhenFinish] random finishRunnable run, tag:" + str + ", lottieView:" + view);
        if (view != null) {
            view.setVisibility(8);
        }
        ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).recyclerLottieViewDrawable(view);
        Runnable remove = f227746c.remove(Long.valueOf(guildMsgItem.getMsgId()));
        if (remove != null) {
            QLog.d("GuildMediaAIOEx", 4, "[hideLottieWhenFinish] remove auto hide runnable, tag:" + str);
            f227748e.removeCallbacks(remove);
        }
    }

    private static final void p(GuildMsgItem guildMsgItem, ViewGroup viewGroup, int i3) {
        List filterNotNull;
        HashMap<Integer, Long> hashMap = f227744a;
        Long l3 = hashMap.get(Integer.valueOf(System.identityHashCode(viewGroup)));
        if (l3 != null) {
            f227745b.remove(l3);
        }
        hashMap.put(Integer.valueOf(System.identityHashCode(viewGroup)), Long.valueOf(guildMsgItem.getMsgId()));
        QLog.i("GuildMediaAIOEx", 1, "[showAIOLottieEmoji] msgId:" + guildMsgItem.getMsgId() + ", lottieWH:" + i3);
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = guildMsgItem.getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        FaceElement a16 = com.tencent.guild.aio.util.ex.e.a(arrayList);
        if (a16 == null) {
            return;
        }
        try {
            CorountineFunKt.e(com.tencent.mobileqq.guild.media.core.j.b(), "showAIOLottieEmoji", null, null, null, new GuildMediaAIOExKt$showAIOLottieEmoji$2(i3, guildMsgItem, arrayList, a16, viewGroup, a16.resultId, null), 14, null);
        } catch (Exception e16) {
            QLog.e(GuildOnLookerViewHolder.TAG, 1, String.valueOf(e16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final GuildMsgItem guildMsgItem, final ViewGroup viewGroup) {
        List filterNotNull;
        QLog.i("GuildMediaAIOEx", 1, "updateRandomLottieResult");
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = guildMsgItem.getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        FaceElement a16 = com.tencent.guild.aio.util.ex.e.a(arrayList);
        if (a16 == null) {
            return;
        }
        String str = a16.resultId;
        if (!TextUtils.isEmpty(str) && str != null) {
            ((IRandomLottieProxyApi) QRoute.api(IRandomLottieProxyApi.class)).setRandomResult(str, viewGroup, "GuildMediaAIOEx", new Runnable() { // from class: com.tencent.mobileqq.guild.media.a
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaAIOExKt.r(viewGroup, guildMsgItem);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ViewGroup parentView, GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        o(parentView, msgItem, f227745b.get(Long.valueOf(msgItem.getMsgId())), "updateRandomLottieResult");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/GuildMediaAIOExKt$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f227749d;

        a(View view) {
            this.f227749d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            GuildMediaAIOExKt.f227747d.remove(this.f227749d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GuildMediaAIOExKt.f227747d.remove(this.f227749d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
