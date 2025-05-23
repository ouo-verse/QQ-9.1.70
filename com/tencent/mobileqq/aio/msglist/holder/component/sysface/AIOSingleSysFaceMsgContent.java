package com.tencent.mobileqq.aio.msglist.holder.component.sysface;

import a11.c;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.TextMsgContent;
import com.tencent.mobileqq.aio.msg.ad;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.j;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.aio.widget.SelectableTextView;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002-.B\u0017\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020\n\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0014J!\u0010\u001c\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ2\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\"H\u0014J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u001a\u0010&\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/sysface/AIOSingleSysFaceMsgContent;", "Lcom/tencent/mobileqq/aio/msg/TextMsgContent;", "Lcom/tencent/mobileqq/aio/msg/ae;", "msgItem", "", "U", "Lcom/tencent/mobileqq/aio/msg/ad;", "singleSysFaceMsgItem", "", "O", "Landroid/view/View;", "textView", "keepPlayDuration", "T", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "e", "", "p", "Lcom/tencent/fastertextview/wrapper/a;", "txtView", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "f", "i", "", "unit", "", "size", "y", "(Ljava/lang/Integer;F)V", "Landroid/graphics/drawable/Drawable;", "drawable", "backgroundMinWidth", "backgroundMinHeight", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "skinBubbleInfo", "v", ExifInterface.LATITUDE_SOUTH, "r", "P", "Landroid/content/Context;", "context", "foregroundView", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOSingleSysFaceMsgContent extends TextMsgContent {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    private static Float f191882q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/sysface/AIOSingleSysFaceMsgContent$a;", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "e", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "Lcom/tencent/mobileqq/aio/msg/ad;", "d", "Lcom/tencent/mobileqq/aio/msg/ad;", "singleSysFaceMsgItem", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/sysface/AIOSingleSysFaceMsgContent;", "Ljava/lang/ref/WeakReference;", "msgContentWeakReference", RemoteMessageConst.MessageBody.MSG_CONTENT, "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/sysface/AIOSingleSysFaceMsgContent;Lcom/tencent/mobileqq/aio/msg/ad;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ad singleSysFaceMsgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<AIOSingleSysFaceMsgContent> msgContentWeakReference;

        public a(@NotNull AIOSingleSysFaceMsgContent msgContent, @NotNull ad singleSysFaceMsgItem) {
            Intrinsics.checkNotNullParameter(msgContent, "msgContent");
            Intrinsics.checkNotNullParameter(singleSysFaceMsgItem, "singleSysFaceMsgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgContent, (Object) singleSysFaceMsgItem);
            } else {
                this.singleSysFaceMsgItem = singleSysFaceMsgItem;
                this.msgContentWeakReference = new WeakReference<>(msgContent);
            }
        }

        private final void e(Animator animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOSingleSysFaceMsgContent", 2, "[AnimatorListener] onAnimQuit");
            }
            if (animation != null) {
                animation.removeAllListeners();
            }
            AIOSingleSysFaceMsgContent aIOSingleSysFaceMsgContent = this.msgContentWeakReference.get();
            if (aIOSingleSysFaceMsgContent != null) {
                aIOSingleSysFaceMsgContent.R(this.singleSysFaceMsgItem);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                e(animation);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                e(animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/sysface/AIOSingleSysFaceMsgContent$b;", "", "", "KEEP_PLAY_ANIM_DEFAULT_DURATION_IN_MILLIS", "J", "", "SCALE_ANIM_MULTIPLE", UserInfo.SEX_FEMALE, "SCALE_BIG_ANIM_DURATION_IN_MILLIS", "SCALE_SMALL_ANIM_DURATION_IN_MILLIS", "", "TAG", "Ljava/lang/String;", "TEXT_MAX_SIZE_DP", "TEXT_MIN_SIZE_DP", "sTextAscentPercent", "Ljava/lang/Float;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.sysface.AIOSingleSysFaceMsgContent$b, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63258);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOSingleSysFaceMsgContent(@NotNull Context context, @NotNull View foregroundView) {
        super(context, foregroundView);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(foregroundView, "foregroundView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) foregroundView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long O(ad singleSysFaceMsgItem) {
        FaceElement faceElement;
        MsgElement firstTypeElement = singleSysFaceMsgItem.getFirstTypeElement(6);
        if (firstTypeElement != null && (faceElement = firstTypeElement.faceElement) != null) {
            try {
                String fullResPath = QQSysAndEmojiResMgr.getInstance().getFullResPath(4, faceElement.faceIndex);
                Intrinsics.checkNotNullExpressionValue(fullResPath, "getInstance().getFullRes\u2026RES_QQSYS_APNG, serverId)");
                return c.f25347a.a(fullResPath);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("AIOSingleSysFaceMsgContent", 2, "getEmoticonSpanDrawablePlayDuration by GifDrawable error! stack=", th5);
                }
            }
        }
        return 0L;
    }

    private final void Q() {
        SelectableTextView selectableTextView;
        View l3 = l();
        if (l3 != null) {
            if (l3 instanceof SelectableTextView) {
                selectableTextView = (SelectableTextView) l3;
            } else {
                selectableTextView = null;
            }
            if (selectableTextView != null) {
                selectableTextView.setUseCustomLocationWithoutAnimScale(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(ad singleSysFaceMsgItem) {
        SelectableTextView selectableTextView;
        singleSysFaceMsgItem.P2(2);
        View l3 = l();
        if (l3 != null) {
            if (l3 instanceof SelectableTextView) {
                selectableTextView = (SelectableTextView) l3;
            } else {
                selectableTextView = null;
            }
            if (selectableTextView != null) {
                selectableTextView.setUseCustomLocationWithoutAnimScale(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(View textView, ad singleSysFaceMsgItem, long keepPlayDuration) {
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(textView.getContext(), R.anim.f154976uj);
        Interpolator loadInterpolator2 = AnimationUtils.loadInterpolator(textView.getContext(), R.anim.f154973ug);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.3f);
        ofFloat.setDuration(60L);
        ofFloat.setInterpolator(loadInterpolator);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.3f);
        ofFloat2.setDuration(60L);
        ofFloat2.setInterpolator(loadInterpolator);
        if (QLog.isColorLevel()) {
            QLog.d("AIOSingleSysFaceMsgContent", 2, "[startPlayTextViewScaleAnim] playDuration=" + keepPlayDuration);
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_X, 1.3f, 1.0f);
        ofFloat3.setDuration(60L);
        ofFloat3.setInterpolator(loadInterpolator2);
        ofFloat3.setStartDelay(keepPlayDuration);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_Y, 1.3f, 1.0f);
        ofFloat4.setDuration(60L);
        ofFloat4.setInterpolator(loadInterpolator2);
        ofFloat4.setStartDelay(keepPlayDuration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat3).with(ofFloat4).after(ofFloat);
        animatorSet.addListener(new a(this, singleSysFaceMsgItem));
        Q();
        animatorSet.start();
        singleSysFaceMsgItem.P2(1);
    }

    private final void U(ae msgItem) {
        View l3;
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        if (!(msgItem instanceof ad)) {
            return;
        }
        ad adVar = (ad) msgItem;
        if (!adVar.L2()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOSingleSysFaceMsgContent", 2, "tryPlayTextViewScaleAnim state=" + adVar.N2() + ", msgId=" + msgItem.getMsgId());
        }
        if (adVar.N2() == 0 && (l3 = l()) != null) {
            Object context = l3.getContext();
            if (context instanceof LifecycleOwner) {
                lifecycleOwner = (LifecycleOwner) context;
            } else {
                lifecycleOwner = null;
            }
            if (lifecycleOwner != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                BuildersKt__Builders_commonKt.launch$default(lifecycleScope, Dispatchers.getIO(), null, new AIOSingleSysFaceMsgContent$tryPlayTextViewScaleAnim$1$1(this, msgItem, l3, null), 2, null);
            }
        }
    }

    public final void P(@NotNull ae msgItem) {
        ad adVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof ad) {
            adVar = (ad) msgItem;
        } else {
            adVar = null;
        }
        if (adVar != null) {
            adVar.P2(2);
        }
    }

    public void S(@NotNull ae msgItem, @NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgItem, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        j().setBackground(drawable);
        if (!(msgItem instanceof ad)) {
            return;
        }
        ad adVar = (ad) msgItem;
        if (!adVar.L2()) {
            return;
        }
        adVar.N2();
    }

    @Override // com.tencent.mobileqq.aio.msg.TextMsgContent
    public void e(@NotNull ae msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        super.e(msgItem);
        U(msgItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.TextMsgContent
    @NotNull
    public SelectableLinearLayout f(@NotNull com.tencent.fastertextview.wrapper.a txtView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SelectableLinearLayout) iPatchRedirector.redirect((short) 4, (Object) this, (Object) txtView);
        }
        Intrinsics.checkNotNullParameter(txtView, "txtView");
        SelectableLinearLayout f16 = super.f(txtView);
        f16.setClipToPadding(false);
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.TextMsgContent
    @NotNull
    public com.tencent.fastertextview.wrapper.a i() {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.fastertextview.wrapper.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.fastertextview.wrapper.a i3 = super.i();
        if (f191882q == null) {
            View g16 = i3.g();
            if (g16 instanceof TextView) {
                textView = (TextView) g16;
            } else {
                textView = null;
            }
            if (textView != null) {
                Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
                float f16 = fontMetrics.top - fontMetrics.bottom;
                float f17 = fontMetrics.ascent;
                if (f17 < 0.0f && f16 < 0.0f) {
                    f191882q = Float.valueOf(f17 / f16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AIOSingleSysFaceMsgContent", 2, "[createTextView] sTextAscentPercent=" + f191882q + ", top=" + fontMetrics.top + ", bottom=" + fontMetrics.bottom + ", ascent=" + fontMetrics.ascent);
                }
            }
        }
        Float f18 = f191882q;
        if (f18 != null) {
            float floatValue = f18.floatValue();
            float f19 = 24.0f;
            if (floatValue < 1.0f) {
                f19 = RangesKt___RangesKt.coerceAtLeast(floatValue * 24.0f, 18.0f);
            }
            i3.p(0, (float) Math.ceil(f19 * ViewUtils.getDensity()));
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.aio.msg.TextMsgContent
    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.TextMsgContent
    protected void r(@Nullable AIOBubbleSkinInfo skinBubbleInfo, @NotNull ae msgItem) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) skinBubbleInfo, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        j jVar = null;
        if (skinBubbleInfo != null) {
            aVar = skinBubbleInfo.b();
        } else {
            aVar = null;
        }
        if (aVar instanceof j) {
            jVar = (j) aVar;
        }
        if (jVar != null) {
            if (j().getPaddingLeft() != jVar.c() || j().getPaddingRight() != jVar.d() || j().getPaddingTop() != jVar.e() || j().getPaddingBottom() != jVar.b()) {
                j().setPadding(jVar.c(), jVar.e(), jVar.d(), jVar.b());
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.TextMsgContent
    protected void v(@NotNull ae msgItem, @NotNull Drawable drawable, int backgroundMinWidth, int backgroundMinHeight, @Nullable AIOBubbleSkinInfo skinBubbleInfo) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        j jVar;
        boolean z16;
        int b16;
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, msgItem, drawable, Integer.valueOf(backgroundMinWidth), Integer.valueOf(backgroundMinHeight), skinBubbleInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Integer num = null;
        if (skinBubbleInfo != null) {
            aVar = skinBubbleInfo.b();
        } else {
            aVar = null;
        }
        if (aVar instanceof j) {
            jVar = (j) aVar;
        } else {
            jVar = null;
        }
        if (jVar != null) {
            backgroundMinWidth = (backgroundMinWidth - jVar.c()) - jVar.d();
            backgroundMinHeight = (backgroundMinHeight - jVar.e()) - jVar.b();
        }
        com.tencent.fastertextview.wrapper.a m3 = m();
        Integer valueOf = Integer.valueOf(backgroundMinWidth);
        if (valueOf.intValue() != m().b()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            b16 = valueOf.intValue();
        } else {
            b16 = m().b();
        }
        m3.k(b16);
        com.tencent.fastertextview.wrapper.a m16 = m();
        Integer valueOf2 = Integer.valueOf(backgroundMinHeight);
        if (valueOf2.intValue() == m().a()) {
            z17 = false;
        }
        if (z17) {
            num = valueOf2;
        }
        if (num != null) {
            a16 = num.intValue();
        } else {
            a16 = m().a();
        }
        m16.j(a16);
        if (TextMsgContent.INSTANCE.c() && (drawable instanceof AbsAsyncDrawable)) {
            AbsAsyncDrawable absAsyncDrawable = (AbsAsyncDrawable) drawable;
            if (absAsyncDrawable.getIntrinsicHeight() > r8.b()) {
                absAsyncDrawable.L(r8.b() / absAsyncDrawable.getIntrinsicHeight());
            }
        }
        S(msgItem, drawable);
    }

    @Override // com.tencent.mobileqq.aio.msg.TextMsgContent
    protected void y(@Nullable Integer unit, float size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, unit, Float.valueOf(size));
        }
    }
}
