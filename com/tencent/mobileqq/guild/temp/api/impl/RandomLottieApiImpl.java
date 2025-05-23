package com.tencent.mobileqq.guild.temp.api.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerAnimationListener;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView;
import com.tencent.mobileqq.guild.temp.api.IRandomLottieApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.NTOperateUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0002JC\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ2\u0010$\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H\u0002J,\u0010&\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u000fH\u0016JE\u0010*\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+JY\u0010,\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/RandomLottieApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IRandomLottieApi;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/widget/FrameLayout$LayoutParams;", "lottieViewLP", "Landroid/view/View;", "tryToFindExistLottieView", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup$LayoutParams;", "Landroid/widget/FrameLayout;", "buildLottieView", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "", "localId", "rootLayout", "", "alreadyRead", "", "msgSeq", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "buildRandomLottieViewAndPlay", "(Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;ILandroid/view/View;ZJLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIsLastMsg", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/emoticonview/anisticker/AniStickerLottieView;", "lottieView", "", "resultId", "tag", "Ljava/lang/Runnable;", "finishRunnable", "", "playResultAniSticker", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "setRandomResult", "faceIndex", "isAniStickerRandom", "msgId", "createRandomLottieAnimView", "(Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;IZJLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRandomLottieAnimViewForMedia", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;IZJLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Landroid/widget/FrameLayout$LayoutParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class RandomLottieApiImpl implements IRandomLottieApi {
    private static final int LOTTIE_GROUP_VIEW_ID = 2131363049;
    private static final int LOTTIE_VIEW_ID = 2131363048;
    private static final String TAG = "RandomLottieApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout buildLottieView(Context context, ViewGroup.LayoutParams lottieViewLP) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(R.id.spw);
        AniStickerLottieView aniStickerLottieView = new AniStickerLottieView(context);
        aniStickerLottieView.setId(R.id.spv);
        if (lottieViewLP == null) {
            int i3 = AniStickerHelper.LOTTIE_ANIM_SIZE;
            lottieViewLP = new FrameLayout.LayoutParams(i3, i3);
        }
        frameLayout.addView(aniStickerLottieView, lottieViewLP);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object buildRandomLottieViewAndPlay(FaceElement faceElement, int i3, View view, boolean z16, long j3, Contact contact, Continuation<? super View> continuation) {
        RandomLottieApiImpl$buildRandomLottieViewAndPlay$1 randomLottieApiImpl$buildRandomLottieViewAndPlay$1;
        Object coroutine_suspended;
        int i16;
        AniStickerLottieView aniStickerLottieView;
        int i17;
        boolean z17;
        long j16;
        FaceElement faceElement2;
        RandomLottieApiImpl randomLottieApiImpl;
        Ref.BooleanRef booleanRef;
        boolean z18;
        View view2 = view;
        if (continuation instanceof RandomLottieApiImpl$buildRandomLottieViewAndPlay$1) {
            randomLottieApiImpl$buildRandomLottieViewAndPlay$1 = (RandomLottieApiImpl$buildRandomLottieViewAndPlay$1) continuation;
            int i18 = randomLottieApiImpl$buildRandomLottieViewAndPlay$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                randomLottieApiImpl$buildRandomLottieViewAndPlay$1.label = i18 - Integer.MIN_VALUE;
                RandomLottieApiImpl$buildRandomLottieViewAndPlay$1 randomLottieApiImpl$buildRandomLottieViewAndPlay$12 = randomLottieApiImpl$buildRandomLottieViewAndPlay$1;
                Object obj = randomLottieApiImpl$buildRandomLottieViewAndPlay$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = randomLottieApiImpl$buildRandomLottieViewAndPlay$12.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    View findViewById = view2.findViewById(R.id.spv);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "rootLayout.findViewById(LOTTIE_VIEW_ID)");
                    aniStickerLottieView = (AniStickerLottieView) findViewById;
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    RandomLottieApiImpl$buildRandomLottieViewAndPlay$2 randomLottieApiImpl$buildRandomLottieViewAndPlay$2 = new RandomLottieApiImpl$buildRandomLottieViewAndPlay$2(booleanRef2, this, contact, j3, null);
                    randomLottieApiImpl$buildRandomLottieViewAndPlay$12.L$0 = this;
                    randomLottieApiImpl$buildRandomLottieViewAndPlay$12.L$1 = faceElement;
                    randomLottieApiImpl$buildRandomLottieViewAndPlay$12.L$2 = view2;
                    randomLottieApiImpl$buildRandomLottieViewAndPlay$12.L$3 = aniStickerLottieView;
                    randomLottieApiImpl$buildRandomLottieViewAndPlay$12.L$4 = booleanRef2;
                    i17 = i3;
                    randomLottieApiImpl$buildRandomLottieViewAndPlay$12.I$0 = i17;
                    z17 = z16;
                    randomLottieApiImpl$buildRandomLottieViewAndPlay$12.Z$0 = z17;
                    j16 = j3;
                    randomLottieApiImpl$buildRandomLottieViewAndPlay$12.J$0 = j16;
                    randomLottieApiImpl$buildRandomLottieViewAndPlay$12.label = 1;
                    if (BuildersKt.withContext(io5, randomLottieApiImpl$buildRandomLottieViewAndPlay$2, randomLottieApiImpl$buildRandomLottieViewAndPlay$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    faceElement2 = faceElement;
                    randomLottieApiImpl = this;
                    booleanRef = booleanRef2;
                } else {
                    if (i16 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j17 = randomLottieApiImpl$buildRandomLottieViewAndPlay$12.J$0;
                    boolean z19 = randomLottieApiImpl$buildRandomLottieViewAndPlay$12.Z$0;
                    int i19 = randomLottieApiImpl$buildRandomLottieViewAndPlay$12.I$0;
                    booleanRef = (Ref.BooleanRef) randomLottieApiImpl$buildRandomLottieViewAndPlay$12.L$4;
                    AniStickerLottieView aniStickerLottieView2 = (AniStickerLottieView) randomLottieApiImpl$buildRandomLottieViewAndPlay$12.L$3;
                    view2 = (View) randomLottieApiImpl$buildRandomLottieViewAndPlay$12.L$2;
                    faceElement2 = (FaceElement) randomLottieApiImpl$buildRandomLottieViewAndPlay$12.L$1;
                    randomLottieApiImpl = (RandomLottieApiImpl) randomLottieApiImpl$buildRandomLottieViewAndPlay$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    aniStickerLottieView = aniStickerLottieView2;
                    z17 = z19;
                    i17 = i19;
                    j16 = j17;
                }
                z18 = z17 || !booleanRef.element;
                QLog.i(TAG, 1, "msgSeq=" + j16 + " alreadyRead=" + z17 + " isLastMsg=" + booleanRef.element + " showLastFrame=" + z18);
                if (!z18 && !TextUtils.isEmpty(faceElement2.resultId)) {
                    AniStickerHelper.setAniStickerRandomLastFrameResource(new AniStickerHelper.Builder(aniStickerLottieView).localId(i17).placeholderDrawable(R.drawable.f162503o43).resultId(faceElement2.resultId).build());
                    return view2;
                }
                AniStickerHelper.setAniStickerRandomResource(new AniStickerHelper.Builder(aniStickerLottieView).localId(i17).placeholderDrawable(R.drawable.f162503o43).listener(new b()));
                playResultAniSticker$default(randomLottieApiImpl, aniStickerLottieView, faceElement2.resultId, null, null, 12, null);
                return view2;
            }
        }
        randomLottieApiImpl$buildRandomLottieViewAndPlay$1 = new RandomLottieApiImpl$buildRandomLottieViewAndPlay$1(this, continuation);
        RandomLottieApiImpl$buildRandomLottieViewAndPlay$1 randomLottieApiImpl$buildRandomLottieViewAndPlay$122 = randomLottieApiImpl$buildRandomLottieViewAndPlay$1;
        Object obj2 = randomLottieApiImpl$buildRandomLottieViewAndPlay$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = randomLottieApiImpl$buildRandomLottieViewAndPlay$122.label;
        if (i16 != 0) {
        }
        if (z17) {
            QLog.i(TAG, 1, "msgSeq=" + j16 + " alreadyRead=" + z17 + " isLastMsg=" + booleanRef.element + " showLastFrame=" + z18);
            if (!z18) {
            }
            AniStickerHelper.setAniStickerRandomResource(new AniStickerHelper.Builder(aniStickerLottieView).localId(i17).placeholderDrawable(R.drawable.f162503o43).listener(new b()));
            playResultAniSticker$default(randomLottieApiImpl, aniStickerLottieView, faceElement2.resultId, null, null, 12, null);
            return view2;
        }
        QLog.i(TAG, 1, "msgSeq=" + j16 + " alreadyRead=" + z17 + " isLastMsg=" + booleanRef.element + " showLastFrame=" + z18);
        if (!z18) {
        }
        AniStickerHelper.setAniStickerRandomResource(new AniStickerHelper.Builder(aniStickerLottieView).localId(i17).placeholderDrawable(R.drawable.f162503o43).listener(new b()));
        playResultAniSticker$default(randomLottieApiImpl, aniStickerLottieView, faceElement2.resultId, null, null, 12, null);
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkIsLastMsg(Contact contact, long j3, Continuation<? super Boolean> continuation) {
        RandomLottieApiImpl$checkIsLastMsg$1 randomLottieApiImpl$checkIsLastMsg$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof RandomLottieApiImpl$checkIsLastMsg$1) {
            randomLottieApiImpl$checkIsLastMsg$1 = (RandomLottieApiImpl$checkIsLastMsg$1) continuation;
            int i16 = randomLottieApiImpl$checkIsLastMsg$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                randomLottieApiImpl$checkIsLastMsg$1.label = i16 - Integer.MIN_VALUE;
                Object obj = randomLottieApiImpl$checkIsLastMsg$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = randomLottieApiImpl$checkIsLastMsg$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    NTOperateUtils nTOperateUtils = NTOperateUtils.f359554a;
                    randomLottieApiImpl$checkIsLastMsg$1.J$0 = j3;
                    randomLottieApiImpl$checkIsLastMsg$1.label = 1;
                    obj = nTOperateUtils.g(contact, randomLottieApiImpl$checkIsLastMsg$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    j3 = randomLottieApiImpl$checkIsLastMsg$1.J$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j16 = ((MsgRecord) obj).msgSeq;
                QLog.i(TAG, 1, "checkIsLastMsg lastMsgSeq=" + j16 + " msgSeq=" + j3);
                return Boxing.boxBoolean(j3 == j16);
            }
        }
        randomLottieApiImpl$checkIsLastMsg$1 = new RandomLottieApiImpl$checkIsLastMsg$1(this, continuation);
        Object obj2 = randomLottieApiImpl$checkIsLastMsg$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = randomLottieApiImpl$checkIsLastMsg$1.label;
        if (i3 != 0) {
        }
        long j162 = ((MsgRecord) obj2).msgSeq;
        QLog.i(TAG, 1, "checkIsLastMsg lastMsgSeq=" + j162 + " msgSeq=" + j3);
        return Boxing.boxBoolean(j3 == j162);
    }

    private final void playResultAniSticker(AniStickerLottieView lottieView, String resultId, String tag, Runnable finishRunnable) {
        AniStickerHelper.setAniStickerRandomResultResource(new AniStickerHelper.Builder(lottieView).resultId(resultId).listener(new c(finishRunnable)).build());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b8 A[PHI: r0
  0x00b8: PHI (r0v8 java.lang.Object) = (r0v7 java.lang.Object), (r0v1 java.lang.Object) binds: [B:23:0x00b5, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    @Override // com.tencent.mobileqq.guild.temp.api.IRandomLottieApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createRandomLottieAnimView(Context context, FaceElement faceElement, int i3, boolean z16, long j3, Contact contact, Continuation<? super View> continuation) {
        RandomLottieApiImpl$createRandomLottieAnimView$1 randomLottieApiImpl$createRandomLottieAnimView$1;
        Object coroutine_suspended;
        int i16;
        Ref.ObjectRef objectRef;
        long j16;
        int i17;
        RandomLottieApiImpl randomLottieApiImpl;
        FaceElement faceElement2;
        Contact contact2;
        boolean z17;
        try {
            if (continuation instanceof RandomLottieApiImpl$createRandomLottieAnimView$1) {
                randomLottieApiImpl$createRandomLottieAnimView$1 = (RandomLottieApiImpl$createRandomLottieAnimView$1) continuation;
                int i18 = randomLottieApiImpl$createRandomLottieAnimView$1.label;
                if ((i18 & Integer.MIN_VALUE) != 0) {
                    randomLottieApiImpl$createRandomLottieAnimView$1.label = i18 - Integer.MIN_VALUE;
                    RandomLottieApiImpl$createRandomLottieAnimView$1 randomLottieApiImpl$createRandomLottieAnimView$12 = randomLottieApiImpl$createRandomLottieAnimView$1;
                    Object obj = randomLottieApiImpl$createRandomLottieAnimView$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i16 = randomLottieApiImpl$createRandomLottieAnimView$12.label;
                    if (i16 != 0) {
                        ResultKt.throwOnFailure(obj);
                        int convertToLocal = QQSysFaceUtil.convertToLocal(i3);
                        objectRef = new Ref.ObjectRef();
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        RandomLottieApiImpl$createRandomLottieAnimView$2 randomLottieApiImpl$createRandomLottieAnimView$2 = new RandomLottieApiImpl$createRandomLottieAnimView$2(objectRef, this, context, null);
                        randomLottieApiImpl$createRandomLottieAnimView$12.L$0 = this;
                        randomLottieApiImpl$createRandomLottieAnimView$12.L$1 = faceElement;
                        randomLottieApiImpl$createRandomLottieAnimView$12.L$2 = contact;
                        randomLottieApiImpl$createRandomLottieAnimView$12.L$3 = objectRef;
                        randomLottieApiImpl$createRandomLottieAnimView$12.Z$0 = z16;
                        j16 = j3;
                        randomLottieApiImpl$createRandomLottieAnimView$12.J$0 = j16;
                        randomLottieApiImpl$createRandomLottieAnimView$12.I$0 = convertToLocal;
                        randomLottieApiImpl$createRandomLottieAnimView$12.label = 1;
                        if (BuildersKt.withContext(main, randomLottieApiImpl$createRandomLottieAnimView$2, randomLottieApiImpl$createRandomLottieAnimView$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i17 = convertToLocal;
                        randomLottieApiImpl = this;
                        faceElement2 = faceElement;
                        contact2 = contact;
                        z17 = z16;
                    } else {
                        if (i16 != 1) {
                            if (i16 == 2) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i19 = randomLottieApiImpl$createRandomLottieAnimView$12.I$0;
                        long j17 = randomLottieApiImpl$createRandomLottieAnimView$12.J$0;
                        z17 = randomLottieApiImpl$createRandomLottieAnimView$12.Z$0;
                        objectRef = (Ref.ObjectRef) randomLottieApiImpl$createRandomLottieAnimView$12.L$3;
                        Contact contact3 = (Contact) randomLottieApiImpl$createRandomLottieAnimView$12.L$2;
                        faceElement2 = (FaceElement) randomLottieApiImpl$createRandomLottieAnimView$12.L$1;
                        RandomLottieApiImpl randomLottieApiImpl2 = (RandomLottieApiImpl) randomLottieApiImpl$createRandomLottieAnimView$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        contact2 = contact3;
                        i17 = i19;
                        randomLottieApiImpl = randomLottieApiImpl2;
                        j16 = j17;
                    }
                    View view = (View) objectRef.element;
                    boolean z18 = !z17;
                    randomLottieApiImpl$createRandomLottieAnimView$12.L$0 = null;
                    randomLottieApiImpl$createRandomLottieAnimView$12.L$1 = null;
                    randomLottieApiImpl$createRandomLottieAnimView$12.L$2 = null;
                    randomLottieApiImpl$createRandomLottieAnimView$12.L$3 = null;
                    randomLottieApiImpl$createRandomLottieAnimView$12.label = 2;
                    obj = randomLottieApiImpl.buildRandomLottieViewAndPlay(faceElement2, i17, view, z18, j16, contact2, randomLottieApiImpl$createRandomLottieAnimView$12);
                    return obj != coroutine_suspended ? coroutine_suspended : obj;
                }
            }
            if (i16 != 0) {
            }
            View view2 = (View) objectRef.element;
            if (!z17) {
            }
            randomLottieApiImpl$createRandomLottieAnimView$12.L$0 = null;
            randomLottieApiImpl$createRandomLottieAnimView$12.L$1 = null;
            randomLottieApiImpl$createRandomLottieAnimView$12.L$2 = null;
            randomLottieApiImpl$createRandomLottieAnimView$12.L$3 = null;
            randomLottieApiImpl$createRandomLottieAnimView$12.label = 2;
            obj = randomLottieApiImpl.buildRandomLottieViewAndPlay(faceElement2, i17, view2, z18, j16, contact2, randomLottieApiImpl$createRandomLottieAnimView$12);
            if (obj != coroutine_suspended) {
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "createRandomLottieAnimView error:" + e16);
            return null;
        }
        randomLottieApiImpl$createRandomLottieAnimView$1 = new RandomLottieApiImpl$createRandomLottieAnimView$1(this, continuation);
        RandomLottieApiImpl$createRandomLottieAnimView$1 randomLottieApiImpl$createRandomLottieAnimView$122 = randomLottieApiImpl$createRandomLottieAnimView$1;
        Object obj2 = randomLottieApiImpl$createRandomLottieAnimView$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = randomLottieApiImpl$createRandomLottieAnimView$122.label;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d4 A[PHI: r1
  0x00d4: PHI (r1v11 java.lang.Object) = (r1v10 java.lang.Object), (r1v3 java.lang.Object) binds: [B:22:0x00d1, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    @Override // com.tencent.mobileqq.guild.temp.api.IRandomLottieApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createRandomLottieAnimViewForMedia(Context context, ViewGroup viewGroup, FaceElement faceElement, int i3, boolean z16, long j3, Contact contact, FrameLayout.LayoutParams layoutParams, Continuation<? super View> continuation) {
        RandomLottieApiImpl$createRandomLottieAnimViewForMedia$1 randomLottieApiImpl$createRandomLottieAnimViewForMedia$1;
        Object coroutine_suspended;
        int i16;
        Contact contact2;
        int i17;
        Ref.ObjectRef objectRef;
        FaceElement faceElement2;
        RandomLottieApiImpl randomLottieApiImpl;
        boolean z17;
        long j16;
        try {
            if (continuation instanceof RandomLottieApiImpl$createRandomLottieAnimViewForMedia$1) {
                randomLottieApiImpl$createRandomLottieAnimViewForMedia$1 = (RandomLottieApiImpl$createRandomLottieAnimViewForMedia$1) continuation;
                int i18 = randomLottieApiImpl$createRandomLottieAnimViewForMedia$1.label;
                if ((i18 & Integer.MIN_VALUE) != 0) {
                    randomLottieApiImpl$createRandomLottieAnimViewForMedia$1.label = i18 - Integer.MIN_VALUE;
                    RandomLottieApiImpl$createRandomLottieAnimViewForMedia$1 randomLottieApiImpl$createRandomLottieAnimViewForMedia$12 = randomLottieApiImpl$createRandomLottieAnimViewForMedia$1;
                    Object obj = randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i16 = randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.label;
                    if (i16 != 0) {
                        ResultKt.throwOnFailure(obj);
                        int convertToLocal = QQSysFaceUtil.convertToLocal(i3);
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        RandomLottieApiImpl$createRandomLottieAnimViewForMedia$2 randomLottieApiImpl$createRandomLottieAnimViewForMedia$2 = new RandomLottieApiImpl$createRandomLottieAnimViewForMedia$2(objectRef2, this, viewGroup, layoutParams, context, null);
                        randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$0 = this;
                        randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$1 = faceElement;
                        randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$2 = contact;
                        randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$3 = objectRef2;
                        randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.Z$0 = z16;
                        randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.J$0 = j3;
                        randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.I$0 = convertToLocal;
                        randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.label = 1;
                        if (BuildersKt.withContext(main, randomLottieApiImpl$createRandomLottieAnimViewForMedia$2, randomLottieApiImpl$createRandomLottieAnimViewForMedia$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        contact2 = contact;
                        i17 = convertToLocal;
                        objectRef = objectRef2;
                        faceElement2 = faceElement;
                        randomLottieApiImpl = this;
                        z17 = z16;
                        j16 = j3;
                    } else {
                        if (i16 != 1) {
                            if (i16 == 2) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i17 = randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.I$0;
                        j16 = randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.J$0;
                        z17 = randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.Z$0;
                        objectRef = (Ref.ObjectRef) randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$3;
                        contact2 = (Contact) randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$2;
                        faceElement2 = (FaceElement) randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$1;
                        randomLottieApiImpl = (RandomLottieApiImpl) randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    T t16 = objectRef.element;
                    Intrinsics.checkNotNull(t16);
                    View view = (View) t16;
                    boolean z18 = !z17;
                    randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$0 = null;
                    randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$1 = null;
                    randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$2 = null;
                    randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$3 = null;
                    randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.label = 2;
                    obj = randomLottieApiImpl.buildRandomLottieViewAndPlay(faceElement2, i17, view, z18, j16, contact2, randomLottieApiImpl$createRandomLottieAnimViewForMedia$12);
                    return obj != coroutine_suspended ? coroutine_suspended : obj;
                }
            }
            if (i16 != 0) {
            }
            T t162 = objectRef.element;
            Intrinsics.checkNotNull(t162);
            View view2 = (View) t162;
            if (!z17) {
            }
            randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$0 = null;
            randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$1 = null;
            randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$2 = null;
            randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.L$3 = null;
            randomLottieApiImpl$createRandomLottieAnimViewForMedia$12.label = 2;
            obj = randomLottieApiImpl.buildRandomLottieViewAndPlay(faceElement2, i17, view2, z18, j16, contact2, randomLottieApiImpl$createRandomLottieAnimViewForMedia$12);
            if (obj != coroutine_suspended) {
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "createRandomLottieAnimViewForMedia error:" + e16);
            return null;
        }
        randomLottieApiImpl$createRandomLottieAnimViewForMedia$1 = new RandomLottieApiImpl$createRandomLottieAnimViewForMedia$1(this, continuation);
        RandomLottieApiImpl$createRandomLottieAnimViewForMedia$1 randomLottieApiImpl$createRandomLottieAnimViewForMedia$122 = randomLottieApiImpl$createRandomLottieAnimViewForMedia$1;
        Object obj2 = randomLottieApiImpl$createRandomLottieAnimViewForMedia$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = randomLottieApiImpl$createRandomLottieAnimViewForMedia$122.label;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IRandomLottieApi
    public boolean isAniStickerRandom(int faceIndex) {
        return QQSysFaceUtil.isRandomAniSticker(QQSysFaceUtil.convertToLocal(faceIndex));
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IRandomLottieApi
    public void setRandomResult(String resultId, View rootView, String tag, Runnable finishRunnable) {
        Intrinsics.checkNotNullParameter(resultId, "resultId");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        try {
            AniStickerLottieView aniStickerLottieView = (AniStickerLottieView) rootView.findViewById(R.id.spv);
            if (aniStickerLottieView == null) {
                return;
            }
            playResultAniSticker(aniStickerLottieView, resultId, tag, finishRunnable);
        } catch (Exception e16) {
            QLog.i(TAG, 1, "setRandomResult error" + e16);
        }
    }

    static /* synthetic */ void playResultAniSticker$default(RandomLottieApiImpl randomLottieApiImpl, AniStickerLottieView aniStickerLottieView, String str, String str2, Runnable runnable, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        if ((i3 & 8) != 0) {
            runnable = null;
        }
        randomLottieApiImpl.playResultAniSticker(aniStickerLottieView, str, str2, runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ FrameLayout buildLottieView$default(RandomLottieApiImpl randomLottieApiImpl, Context context, ViewGroup.LayoutParams layoutParams, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            layoutParams = null;
        }
        return randomLottieApiImpl.buildLottieView(context, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View tryToFindExistLottieView(ViewGroup parent, FrameLayout.LayoutParams lottieViewLP) {
        View findViewById = parent != null ? parent.findViewById(R.id.spw) : null;
        AniStickerLottieView aniStickerLottieView = findViewById != null ? (AniStickerLottieView) findViewById.findViewById(R.id.spv) : null;
        if (aniStickerLottieView == null) {
            return null;
        }
        aniStickerLottieView.reset();
        if (lottieViewLP != null) {
            aniStickerLottieView.setLayoutParams(lottieViewLP);
        }
        findViewById.setVisibility(0);
        return findViewById;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/temp/api/impl/RandomLottieApiImpl$b", "Lcom/tencent/mobileqq/emoticonview/anisticker/AniStickerAnimationListener;", "", "localId", "", "resultId", "", "onAnimationStart", "onAnimationEnd", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements AniStickerAnimationListener {
        b() {
        }

        @Override // com.tencent.mobileqq.emoticonview.anisticker.AniStickerAnimationListener
        public void onAnimationEnd(int localId, String resultId) {
        }

        @Override // com.tencent.mobileqq.emoticonview.anisticker.AniStickerAnimationListener
        public void onAnimationStart(int localId, String resultId) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/temp/api/impl/RandomLottieApiImpl$c", "Lcom/tencent/mobileqq/emoticonview/anisticker/AniStickerAnimationListener;", "", "localId", "", "resultId", "", "onAnimationStart", "onAnimationEnd", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements AniStickerAnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f235253a;

        c(Runnable runnable) {
            this.f235253a = runnable;
        }

        @Override // com.tencent.mobileqq.emoticonview.anisticker.AniStickerAnimationListener
        public void onAnimationEnd(int localId, String resultId) {
            Runnable runnable = this.f235253a;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.anisticker.AniStickerAnimationListener
        public void onAnimationStart(int localId, String resultId) {
        }
    }
}
