package com.tencent.qqnt.chats.main.func.littleear;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarAnimatorHelper;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 s2\u00020\u0001:\u0003:=@B\u0007\u00a2\u0006\u0004\bq\u0010rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\f\u0010\u001e\u001a\u00020\u001a*\u00020\nH\u0002J.\u0010'\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$J\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0002J\u0006\u0010+\u001a\u00020\u0004J \u00100\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00072\b\b\u0001\u0010/\u001a\u00020\u0007J \u00101\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00072\b\b\u0001\u0010/\u001a\u00020\u0007J\u0014\u00105\u001a\u00020\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u00020302J&\u00107\u001a\u00020\u00042\u001e\u00104\u001a\u001a\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020306J&\u00109\u001a\u00020\u00042\u001e\u00108\u001a\u001a\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000406R\u0014\u0010;\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010'R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0018\u0010J\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010IR$\u0010R\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010OR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020\n0U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010a\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010^R\u0018\u0010e\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010^R\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u001e\u0010k\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010jR0\u0010m\u001a\u001c\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000203\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010lR0\u0010o\u001a\u001c\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010lR\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020\u0004028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010j\u00a8\u0006t"}, d2 = {"Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarAnimatorHelper;", "", "", ViewStickEventHelper.IS_SHOW, "", "w", "E", "", "width", "D", "Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarAnimatorHelper$b;", "cache", BdhLogUtil.LogTag.Tag_Conn, "", "delay", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "L", "Landroid/animation/ValueAnimator;", "t", "", "faction", ExifInterface.LATITUDE_SOUTH, "r", "fraction", BdhLogUtil.LogTag.Tag_Req, "opCache", "Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarAnimatorHelper$c;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "K", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "root", "Landroid/widget/TextView;", "srcTv", "swapTv", "Landroid/widget/ImageView;", "srcIv", "swapIv", "I", "H", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "M", "B", "", "text", "textColor", "iconRes", "N", "T", "Lkotlin/Function0;", "Landroid/util/Size;", "measure", UserInfo.SEX_FEMALE, "Lkotlin/Function3;", "G", "update", "J", "a", "fDefaultTextSize", "Landroid/animation/Animator;", "b", "Landroid/animation/Animator;", "mShowAndHideAnim", "c", "Landroid/view/View;", "mRootView", "d", "Landroid/widget/TextView;", "mSrcTextView", "e", "mSwapTextView", "f", "Landroid/widget/ImageView;", "mSrcIconView", "g", "mSwapIconView", "<set-?>", tl.h.F, "Z", "y", "()Z", "hasShown", "i", "mIsInChangeAnim", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "j", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "mActionQueue", "Landroid/os/Handler;", "k", "Landroid/os/Handler;", "mUiHandler", "l", "Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarAnimatorHelper$c;", "mNewViewProp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mOldViewProp", DomainData.DOMAIN_NAME, "mNewTransViewProp", "o", "mOldTransViewProp", "Landroid/animation/AnimatorSet;", "p", "Landroid/animation/AnimatorSet;", "mCurUpdateAnim", "Lkotlin/jvm/functions/Function0;", "mOnCurrentViewMeasure", "Lkotlin/jvm/functions/Function3;", "mOnTempViewMeasure", ReportConstant.COSTREPORT_PREFIX, "mOnViewUpdate", "mUpdateRunnable", "<init>", "()V", "u", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MainChatOldEarAnimatorHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int fDefaultTextSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator mShowAndHideAnim;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mSrcTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mSwapTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mSrcIconView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mSwapIconView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasShown;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsInChangeAnim;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentLinkedDeque<b> mActionQueue;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mUiHandler;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mNewViewProp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mOldViewProp;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mNewTransViewProp;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mOldTransViewProp;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnimatorSet mCurUpdateAnim;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Size> mOnCurrentViewMeasure;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function3<? super String, ? super Integer, ? super Integer, Size> mOnTempViewMeasure;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function3<? super String, ? super Integer, ? super Integer, Unit> mOnViewUpdate;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<Unit> mUpdateRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarAnimatorHelper$a;", "", "", "DEFAULT_ANIM_TIME", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarAnimatorHelper$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarAnimatorHelper$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "text", "I", "c", "()I", "textColor", "iconRes", "<init>", "(Ljava/lang/String;II)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int textColor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int iconRes;

        public b(@NotNull String text, int i3, @DrawableRes int i16) {
            Intrinsics.checkNotNullParameter(text, "text");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, text, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.text = text;
            this.textColor = i3;
            this.iconRes = i16;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.iconRes;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.text;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.textColor;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.text, bVar.text) && this.textColor == bVar.textColor && this.iconRes == bVar.iconRes) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.text.hashCode() * 31) + this.textColor) * 31) + this.iconRes;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "OpCache(text=" + this.text + ", textColor=" + this.textColor + ", iconRes=" + this.iconRes + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0002\u001a\u00020\u0000R\u0017\u0010\u0007\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0014\u0010\u0012R\"\u0010\u0019\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u0012R\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u001a\u0010\u0012R\"\u0010\u001e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarAnimatorHelper$c;", "", "a", "", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "text", "", "b", "I", "e", "()I", "textColor", "c", "iconRes", "i", DomainData.DOMAIN_NAME, "(I)V", "width", "j", "height", "f", "g", "l", "tmpWidth", "k", "tmpHeight", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "translateY", "<init>", "(Ljava/lang/String;II)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int textColor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int iconRes;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int width;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int height;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int tmpWidth;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int tmpHeight;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int translateY;

        public c(@NotNull String text, int i3, @DrawableRes int i16) {
            Intrinsics.checkNotNullParameter(text, "text");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, text, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.text = text;
            this.textColor = i3;
            this.iconRes = i16;
        }

        @NotNull
        public final c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (c) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            c cVar = new c(this.text, this.textColor, this.iconRes);
            cVar.width = this.width;
            cVar.height = this.height;
            cVar.tmpWidth = this.tmpWidth;
            cVar.tmpHeight = this.tmpHeight;
            cVar.translateY = this.translateY;
            return cVar;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.height;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.iconRes;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.text;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.textColor;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.tmpHeight;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.tmpWidth;
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            return this.translateY;
        }

        public final int i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.width;
        }

        public final void j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
            } else {
                this.height = i3;
            }
        }

        public final void k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, i3);
            } else {
                this.tmpHeight = i3;
            }
        }

        public final void l(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, i3);
            } else {
                this.tmpWidth = i3;
            }
        }

        public final void m(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, i3);
            } else {
                this.translateY = i3;
            }
        }

        public final void n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.width = i3;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chats/main/func/littleear/MainChatOldEarAnimatorHelper$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f355224e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f355225f;

        d(boolean z16, View view) {
            this.f355224e = z16;
            this.f355225f = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MainChatOldEarAnimatorHelper.this, Boolean.valueOf(z16), view);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            MainChatOldEarAnimatorHelper.this.mShowAndHideAnim = null;
            if (!this.f355224e) {
                this.f355225f.setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnEnd$$inlined$addListener$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class e implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainChatOldEarAnimatorHelper.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            MainChatOldEarAnimatorHelper.this.z(100L);
            if (i.f355238a.a()) {
                MainChatOldEarAnimatorHelper.this.K();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44971);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MainChatOldEarAnimatorHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.fDefaultTextSize = ViewUtils.spToPx(14.0f);
        this.mActionQueue = new ConcurrentLinkedDeque<>();
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mUpdateRunnable = new Function0<Unit>() { // from class: com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarAnimatorHelper$mUpdateRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainChatOldEarAnimatorHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ConcurrentLinkedDeque concurrentLinkedDeque;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                concurrentLinkedDeque = MainChatOldEarAnimatorHelper.this.mActionQueue;
                MainChatOldEarAnimatorHelper.b bVar = (MainChatOldEarAnimatorHelper.b) concurrentLinkedDeque.pollFirst();
                if (bVar != null) {
                    MainChatOldEarAnimatorHelper.this.C(bVar);
                }
            }
        };
    }

    static /* synthetic */ void A(MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        mainChatOldEarAnimatorHelper.z(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C(b cache) {
        boolean z16;
        c cVar;
        c cVar2;
        boolean z17;
        View view = this.mRootView;
        if (view == null) {
            return;
        }
        if (this.mNewViewProp != null) {
            if (view != null) {
                if (view.getVisibility() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (z16) {
                        String b16 = cache.b();
                        c cVar3 = this.mNewViewProp;
                        Intrinsics.checkNotNull(cVar3);
                        if (TextUtils.equals(b16, cVar3.d())) {
                            A(this, 0L, 1, null);
                            return;
                        }
                        final AnimatorSet animatorSet = this.mCurUpdateAnim;
                        if (animatorSet != null) {
                            au.b(Boolean.valueOf(animatorSet.isStarted()), new Function0<Unit>(animatorSet) { // from class: com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarAnimatorHelper$innerExecUpdateAnim$1$1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ AnimatorSet $this_run;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$this_run = animatorSet;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorSet);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                        this.$this_run.cancel();
                                    } else {
                                        iPatchRedirector.redirect((short) 2, (Object) this);
                                    }
                                }
                            });
                            this.mCurUpdateAnim = null;
                        }
                        c cVar4 = this.mNewViewProp;
                        if (cVar4 != null) {
                            cVar4.m((-cVar4.b()) / 2);
                        } else {
                            cVar4 = null;
                        }
                        this.mOldViewProp = cVar4;
                        c v3 = v(cache);
                        this.mNewViewProp = v3;
                        if (v3 != null) {
                            cVar = v3.a();
                        } else {
                            cVar = null;
                        }
                        this.mNewTransViewProp = cVar;
                        c cVar5 = this.mOldViewProp;
                        if (cVar5 != null) {
                            cVar2 = cVar5.a();
                        } else {
                            cVar2 = null;
                        }
                        this.mOldTransViewProp = cVar2;
                        this.mIsInChangeAnim = true;
                        TextView textView = this.mSwapTextView;
                        if (textView != null) {
                            textView.setText(cache.b());
                            if (i.f355238a.a()) {
                                textView.setTextColor(ResourcesCompat.getColorStateList(textView.getResources(), cache.c(), null));
                            } else {
                                textView.setTextColor(cache.c());
                            }
                            textView.setVisibility(0);
                        }
                        ImageView imageView = this.mSwapIconView;
                        if (imageView != null) {
                            if (i.f355238a.a()) {
                                imageView.setImageDrawable(ResourcesCompat.getDrawable(imageView.getResources(), cache.a(), null));
                            } else {
                                imageView.setImageResource(cache.a());
                            }
                            imageView.setVisibility(0);
                        }
                        S(0.0f);
                        R(0.0f);
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        animatorSet2.playTogether(t(), r());
                        animatorSet2.setInterpolator(new LinearInterpolator());
                        animatorSet2.addListener(new e());
                        animatorSet2.start();
                        this.mCurUpdateAnim = animatorSet2;
                        return;
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        Function3<? super String, ? super Integer, ? super Integer, Unit> function3 = this.mOnViewUpdate;
        if (function3 != null) {
            function3.invoke(cache.b(), Integer.valueOf(cache.c()), Integer.valueOf(cache.a()));
        }
        this.mNewViewProp = q(cache);
        K();
        A(this, 0L, 1, null);
    }

    private final boolean D(int width) {
        View view = this.mRootView;
        if (view == null || view.getTranslationX() >= width) {
            return true;
        }
        return false;
    }

    private final boolean E() {
        View view = this.mRootView;
        if (view == null || view.getTranslationX() > 0.0f || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        View view = this.mRootView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i.f355238a.a()) {
                layoutParams.width = -2;
            } else {
                c cVar = this.mNewViewProp;
                Intrinsics.checkNotNull(cVar);
                layoutParams.width = cVar.i();
            }
            c cVar2 = this.mNewViewProp;
            Intrinsics.checkNotNull(cVar2);
            layoutParams.height = cVar2.b();
            view.setLayoutParams(layoutParams);
        }
    }

    private final void L() {
        Function3<? super String, ? super Integer, ? super Integer, Unit> function3;
        TextView textView = this.mSwapTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.mSrcTextView;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        ImageView imageView = this.mSwapIconView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.mSrcIconView;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        c cVar = this.mNewViewProp;
        if (cVar != null && (function3 = this.mOnViewUpdate) != null) {
            function3.invoke(cVar.d(), Integer.valueOf(cVar.e()), Integer.valueOf(cVar.c()));
        }
        R(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final c Q(b bVar) {
        return new c(bVar.b(), bVar.c(), bVar.a());
    }

    private final void R(float fraction) {
        int i3;
        TextView textView = this.mSrcTextView;
        if (textView != null) {
            textView.setAlpha(1 - fraction);
        }
        TextView textView2 = this.mSwapTextView;
        if (textView2 != null) {
            textView2.setAlpha(fraction);
        }
        TextView textView3 = this.mSrcTextView;
        int i16 = 0;
        if (textView3 != null) {
            textView3.setTextSize(0, this.fDefaultTextSize * (1.0f - (fraction * 0.2f)));
        }
        TextView textView4 = this.mSwapTextView;
        if (textView4 != null) {
            textView4.setTextSize(0, this.fDefaultTextSize * ((0.2f * fraction) + 0.8f));
        }
        TextView textView5 = this.mSrcTextView;
        if (textView5 != null) {
            c cVar = this.mOldTransViewProp;
            if (cVar != null) {
                i3 = cVar.h();
            } else {
                i3 = 0;
            }
            textView5.setTranslationY(i3 * fraction);
        }
        TextView textView6 = this.mSwapTextView;
        if (textView6 != null) {
            c cVar2 = this.mNewTransViewProp;
            if (cVar2 != null) {
                i16 = cVar2.h();
            }
            textView6.setTranslationY(i16 * (1.0f - fraction));
        }
        ImageView imageView = this.mSrcIconView;
        if (imageView != null) {
            imageView.setAlpha(1 - fraction);
        }
        ImageView imageView2 = this.mSwapIconView;
        if (imageView2 != null) {
            imageView2.setAlpha(fraction);
        }
    }

    private final void S(float faction) {
        c cVar = this.mNewTransViewProp;
        Intrinsics.checkNotNull(cVar);
        int b16 = cVar.b();
        Intrinsics.checkNotNull(this.mOldTransViewProp);
        int b17 = (int) ((b16 - r1.b()) * faction);
        c cVar2 = this.mNewTransViewProp;
        Intrinsics.checkNotNull(cVar2);
        int i3 = cVar2.i();
        Intrinsics.checkNotNull(this.mOldTransViewProp);
        int i16 = (int) ((i3 - r2.i()) * faction);
        c cVar3 = this.mNewTransViewProp;
        Intrinsics.checkNotNull(cVar3);
        c cVar4 = this.mOldTransViewProp;
        Intrinsics.checkNotNull(cVar4);
        cVar3.l(cVar4.i() + i16);
        c cVar5 = this.mNewTransViewProp;
        Intrinsics.checkNotNull(cVar5);
        c cVar6 = this.mOldTransViewProp;
        Intrinsics.checkNotNull(cVar6);
        cVar5.k(cVar6.b() + b17);
        View view = this.mRootView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            c cVar7 = this.mNewTransViewProp;
            Intrinsics.checkNotNull(cVar7);
            layoutParams.width = cVar7.g();
            c cVar8 = this.mNewTransViewProp;
            Intrinsics.checkNotNull(cVar8);
            layoutParams.height = cVar8.f();
            view.setLayoutParams(layoutParams);
        }
    }

    private final c q(b opCache) {
        Size size;
        int i3;
        c Q = Q(opCache);
        Function0<Size> function0 = this.mOnCurrentViewMeasure;
        if (function0 != null) {
            size = function0.invoke();
        } else {
            size = null;
        }
        int i16 = 0;
        if (size != null) {
            i3 = size.getWidth();
        } else {
            i3 = 0;
        }
        Q.n(i3);
        if (size != null) {
            i16 = size.getHeight();
        }
        Q.j(i16);
        Q.m((-Q.b()) / 2);
        return Q;
    }

    private final ValueAnimator r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.chats.main.func.littleear.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                MainChatOldEarAnimatorHelper.s(MainChatOldEarAnimatorHelper.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0f, 1f).apply {\n\u2026)\n            }\n        }");
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MainChatOldEarAnimatorHelper this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mNewTransViewProp != null && this$0.mOldTransViewProp != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            this$0.R(((Float) animatedValue).floatValue());
        }
    }

    private final ValueAnimator t() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.chats.main.func.littleear.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                MainChatOldEarAnimatorHelper.u(MainChatOldEarAnimatorHelper.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0f, 1f).apply {\n\u2026)\n            }\n        }");
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MainChatOldEarAnimatorHelper this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mNewTransViewProp != null && this$0.mOldTransViewProp != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            this$0.S(((Float) animatedValue).floatValue());
        }
    }

    private final c v(b opCache) {
        Size size;
        int i3;
        c Q = Q(opCache);
        Function3<? super String, ? super Integer, ? super Integer, Size> function3 = this.mOnTempViewMeasure;
        if (function3 != null) {
            size = function3.invoke(opCache.b(), Integer.valueOf(opCache.c()), Integer.valueOf(opCache.a()));
        } else {
            size = null;
        }
        int i16 = 0;
        if (size != null) {
            i3 = size.getWidth();
        } else {
            i3 = 0;
        }
        Q.n(i3);
        if (size != null) {
            i16 = size.getHeight();
        }
        Q.j(i16);
        Q.m(Q.b() / 2);
        return Q;
    }

    private final void w(boolean isShow) {
        final View view;
        int i3;
        c cVar = this.mNewViewProp;
        if (cVar != null && (view = this.mRootView) != null) {
            Intrinsics.checkNotNull(cVar);
            int i16 = cVar.i();
            if (!isShow || !E()) {
                if (!isShow && D(i16)) {
                    return;
                }
                final Ref.IntRef intRef = new Ref.IntRef();
                if (isShow) {
                    i3 = i16;
                } else {
                    i3 = 0;
                }
                intRef.element = i3;
                if (isShow) {
                    i16 = 0;
                }
                Animator animator = this.mShowAndHideAnim;
                if (animator != null) {
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MainChatOldEarAnimatorHelper", 2, "execSlideAnim: isShow = " + isShow);
                }
                view.setTranslationX(intRef.element);
                view.setVisibility(0);
                ValueAnimator ofInt = ValueAnimator.ofInt(intRef.element, i16);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.chats.main.func.littleear.f
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        MainChatOldEarAnimatorHelper.x(view, valueAnimator);
                    }
                });
                ofInt.addListener(new d(isShow, view));
                ofInt.setDuration(200L);
                ofInt.setInterpolator(new LinearInterpolator());
                ofInt.start();
                this.mShowAndHideAnim = ofInt;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(View this_run, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNull(valueAnimator.getAnimatedValue(), "null cannot be cast to non-null type kotlin.Int");
        this_run.setTranslationX(((Integer) r2).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(long delay) {
        if (this.mNewViewProp == null) {
            return;
        }
        this.mOldViewProp = null;
        au.b(Boolean.valueOf(!this.mActionQueue.isEmpty()), new MainChatOldEarAnimatorHelper$handleUpdateAnimFinishedAction$1(this, delay));
        au.b(Boolean.valueOf(this.mActionQueue.isEmpty()), new Function0<Unit>() { // from class: com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarAnimatorHelper$handleUpdateAnimFinishedAction$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainChatOldEarAnimatorHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    MainChatOldEarAnimatorHelper.this.mIsInChangeAnim = false;
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        L();
    }

    public final void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MainChatOldEarAnimatorHelper", 1, "hideSlideAnim hasShown:" + this.hasShown);
        }
        this.hasShown = false;
        w(false);
    }

    public final void F(@NotNull Function0<Size> measure) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) measure);
        } else {
            Intrinsics.checkNotNullParameter(measure, "measure");
            this.mOnCurrentViewMeasure = measure;
        }
    }

    public final void G(@NotNull Function3<? super String, ? super Integer, ? super Integer, Size> measure) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) measure);
        } else {
            Intrinsics.checkNotNullParameter(measure, "measure");
            this.mOnTempViewMeasure = measure;
        }
    }

    public final void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MainChatOldEarAnimatorHelper", 1, "onViewClear");
        }
        this.mRootView = null;
        this.mSrcTextView = null;
        this.mSwapTextView = null;
        this.mSrcIconView = null;
        this.mSwapIconView = null;
        this.hasShown = false;
        this.mIsInChangeAnim = false;
    }

    public final void I(@NotNull View root, @NotNull TextView srcTv, @NotNull TextView swapTv, @NotNull ImageView srcIv, @NotNull ImageView swapIv) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, root, srcTv, swapTv, srcIv, swapIv);
            return;
        }
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(srcTv, "srcTv");
        Intrinsics.checkNotNullParameter(swapTv, "swapTv");
        Intrinsics.checkNotNullParameter(srcIv, "srcIv");
        Intrinsics.checkNotNullParameter(swapIv, "swapIv");
        if (QLog.isColorLevel()) {
            QLog.i("MainChatOldEarAnimatorHelper", 1, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        }
        this.mRootView = root;
        this.mSrcTextView = srcTv;
        this.mSwapTextView = swapTv;
        this.mSrcIconView = srcIv;
        this.mSwapIconView = swapIv;
        this.hasShown = false;
        if (root != null) {
            root.setVisibility(8);
        }
    }

    public final void J(@NotNull Function3<? super String, ? super Integer, ? super Integer, Unit> update) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) update);
        } else {
            Intrinsics.checkNotNullParameter(update, "update");
            this.mOnViewUpdate = update;
        }
    }

    public final void M(boolean canShow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, canShow);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MainChatOldEarAnimatorHelper", 1, "showSlideAnim hasShown:" + this.hasShown + ", canShow: " + canShow);
        }
        this.hasShown = true;
        if (canShow) {
            w(true);
        } else {
            K();
        }
    }

    public final void N(@NotNull String text, int textColor, @DrawableRes int iconRes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, text, Integer.valueOf(textColor), Integer.valueOf(iconRes));
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        if (QLog.isColorLevel()) {
            QLog.i("MainChatOldEarAnimatorHelper", 1, "startUpdateAnim hasShown:" + this.hasShown);
        }
        if (this.mActionQueue.isEmpty()) {
            this.mActionQueue.offerLast(new b(text, textColor, iconRes));
        } else if (!TextUtils.equals(this.mActionQueue.peekLast().b(), text)) {
            this.mActionQueue.offerLast(new b(text, textColor, iconRes));
        }
        if (this.mIsInChangeAnim) {
            return;
        }
        Handler handler = this.mUiHandler;
        final Function0<Unit> function0 = this.mUpdateRunnable;
        handler.removeCallbacks(new Runnable() { // from class: com.tencent.qqnt.chats.main.func.littleear.d
            @Override // java.lang.Runnable
            public final void run() {
                MainChatOldEarAnimatorHelper.O(Function0.this);
            }
        });
        Handler handler2 = this.mUiHandler;
        final Function0<Unit> function02 = this.mUpdateRunnable;
        handler2.post(new Runnable() { // from class: com.tencent.qqnt.chats.main.func.littleear.e
            @Override // java.lang.Runnable
            public final void run() {
                MainChatOldEarAnimatorHelper.P(Function0.this);
            }
        });
    }

    public final void T(@NotNull String text, int textColor, @DrawableRes int iconRes) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, text, Integer.valueOf(textColor), Integer.valueOf(iconRes));
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        AnimatorSet animatorSet = this.mCurUpdateAnim;
        if (animatorSet != null) {
            bool = Boolean.valueOf(animatorSet.isRunning());
        } else {
            bool = null;
        }
        au.b(bool, new Function0<Unit>() { // from class: com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarAnimatorHelper$updateUi$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainChatOldEarAnimatorHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnimatorSet animatorSet2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                animatorSet2 = MainChatOldEarAnimatorHelper.this.mCurUpdateAnim;
                if (animatorSet2 != null) {
                    animatorSet2.cancel();
                }
                MainChatOldEarAnimatorHelper.this.mCurUpdateAnim = null;
            }
        });
        this.mActionQueue.clear();
        this.mIsInChangeAnim = false;
        this.mNewViewProp = null;
        this.mOldViewProp = null;
        Function3<? super String, ? super Integer, ? super Integer, Unit> function3 = this.mOnViewUpdate;
        if (function3 != null) {
            function3.invoke(text, Integer.valueOf(textColor), Integer.valueOf(iconRes));
        }
        this.mNewViewProp = q(new b(text, textColor, iconRes));
    }

    public final boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.hasShown;
    }
}
