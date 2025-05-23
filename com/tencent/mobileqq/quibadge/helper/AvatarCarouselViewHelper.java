package com.tencent.mobileqq.quibadge.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.richframework.widget.RFWRoundImageView;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import td0.m;
import tl.h;
import ud0.c;
import ud0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u00013\u0018\u0000 \u000b2\u00020\u0001:\u0002=\u001eB\u000f\u0012\u0006\u0010:\u001a\u000206\u00a2\u0006\u0004\b;\u0010<J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0002J\u001e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001c\u0010\u001d\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001c\u001a\u00020\u001bR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u00104R\u0017\u0010:\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u00107\u001a\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/quibadge/helper/AvatarCarouselViewHelper;", "", "Ljava/util/ArrayList;", "Landroid/widget/ImageView;", "Lkotlin/collections/ArrayList;", "avatarList", "Landroid/view/ViewGroup;", "l", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "j", "avatar", "Landroid/view/View;", "leftView", "f", "containerViewA", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "index", "", DomainData.DOMAIN_NAME, "i", h.F, "", "dip", "g", "", "needAnimation", "k", "a", "Ljava/util/List;", "avatarDrawableList", "Ltd0/m;", "b", "Ltd0/m;", "urlDrawableDelegate", "c", "Ljava/util/ArrayList;", "avatarListA", "d", "avatarListB", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "handler", "I", "currentAvatarIndex", "Lcom/tencent/mobileqq/quibadge/helper/AvatarCarouselViewHelper$AvatarState;", "Lcom/tencent/mobileqq/quibadge/helper/AvatarCarouselViewHelper$AvatarState;", "avatarState", "com/tencent/mobileqq/quibadge/helper/AvatarCarouselViewHelper$changeAvatarRunnable$1", "Lcom/tencent/mobileqq/quibadge/helper/AvatarCarouselViewHelper$changeAvatarRunnable$1;", "changeAvatarRunnable", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "AvatarState", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class AvatarCarouselViewHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<? extends Object> avatarDrawableList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private m urlDrawableDelegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ImageView> avatarListA;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ImageView> avatarListB;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentAvatarIndex;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private AvatarState avatarState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final AvatarCarouselViewHelper$changeAvatarRunnable$1 changeAvatarRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/quibadge/helper/AvatarCarouselViewHelper$AvatarState;", "", "(Ljava/lang/String;I)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes17.dex */
    public static final class AvatarState {
        private static final /* synthetic */ AvatarState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final AvatarState A;
        public static final AvatarState B;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9663);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            AvatarState avatarState = new AvatarState(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0);
            A = avatarState;
            AvatarState avatarState2 = new AvatarState("B", 1);
            B = avatarState2;
            $VALUES = new AvatarState[]{avatarState, avatarState2};
        }

        AvatarState(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            }
        }

        public static AvatarState valueOf(String str) {
            return (AvatarState) Enum.valueOf(AvatarState.class, str);
        }

        public static AvatarState[] values() {
            return (AvatarState[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/quibadge/helper/AvatarCarouselViewHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.quibadge.helper.AvatarCarouselViewHelper$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9738);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.tencent.mobileqq.quibadge.helper.AvatarCarouselViewHelper$changeAvatarRunnable$1] */
    public AvatarCarouselViewHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.avatarListA = new ArrayList<>();
        this.avatarListB = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper());
        this.avatarState = AvatarState.B;
        this.changeAvatarRunnable = new Runnable() { // from class: com.tencent.mobileqq.quibadge.helper.AvatarCarouselViewHelper$changeAvatarRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AvatarCarouselViewHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3;
                int i16;
                Handler handler;
                int i17;
                int i18;
                Handler handler2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("changeAvatarRunnable: ");
                i3 = AvatarCarouselViewHelper.this.currentAvatarIndex;
                sb5.append(i3);
                sb5.append(", avatarDrawableList.size: ");
                sb5.append(AvatarCarouselViewHelper.a(AvatarCarouselViewHelper.this).size());
                d.c("QUIBadge_Rich", sb5.toString());
                i16 = AvatarCarouselViewHelper.this.currentAvatarIndex;
                if (i16 >= AvatarCarouselViewHelper.a(AvatarCarouselViewHelper.this).size()) {
                    handler = AvatarCarouselViewHelper.this.handler;
                    handler.removeCallbacks(this);
                    return;
                }
                AvatarCarouselViewHelper avatarCarouselViewHelper = AvatarCarouselViewHelper.this;
                i17 = avatarCarouselViewHelper.currentAvatarIndex;
                avatarCarouselViewHelper.currentAvatarIndex = i17 + 2;
                AvatarCarouselViewHelper avatarCarouselViewHelper2 = AvatarCarouselViewHelper.this;
                i18 = avatarCarouselViewHelper2.currentAvatarIndex;
                avatarCarouselViewHelper2.n(i18);
                handler2 = AvatarCarouselViewHelper.this.handler;
                handler2.postDelayed(this, 2000L);
            }
        };
        this.urlDrawableDelegate = (m) c.a(m.class);
    }

    public static final /* synthetic */ List a(AvatarCarouselViewHelper avatarCarouselViewHelper) {
        List<? extends Object> list = avatarCarouselViewHelper.avatarDrawableList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarDrawableList");
        }
        return list;
    }

    private final ImageView f(Object avatar, View leftView) {
        int color = this.context.getColor(R.color.qui_common_border_superlight);
        RFWRoundImageView rFWRoundImageView = new RFWRoundImageView(this.context);
        int g16 = g(32.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g16, g16);
        if (leftView != null) {
            layoutParams.addRule(1, leftView.getId());
            layoutParams.leftMargin = g(-4.0f);
        }
        rFWRoundImageView.setLayoutParams(layoutParams);
        rFWRoundImageView.setBorderWidth(g(0.5f));
        rFWRoundImageView.setBorderColor(color);
        rFWRoundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (avatar instanceof Drawable) {
            rFWRoundImageView.setImageDrawable((Drawable) avatar);
        } else if (avatar instanceof Bitmap) {
            rFWRoundImageView.setImageBitmap((Bitmap) avatar);
        }
        return rFWRoundImageView;
    }

    private final int g(float dip) {
        return e.a(dip);
    }

    private final void h(int index, List<? extends ImageView> avatarList) {
        for (ImageView imageView : avatarList) {
            List<? extends Object> list = this.avatarDrawableList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarDrawableList");
            }
            int size = index % list.size();
            List<? extends Object> list2 = this.avatarDrawableList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarDrawableList");
            }
            int i3 = size + 1;
            Object obj = list2.get(size);
            if (obj instanceof Drawable) {
                imageView.setImageDrawable((Drawable) obj);
            } else if (obj instanceof Bitmap) {
                imageView.setImageBitmap((Bitmap) obj);
            }
            ViewParent parent = imageView.getParent();
            if (parent != null) {
                Fade fade = new Fade(1);
                fade.setDuration(500L);
                Unit unit = Unit.INSTANCE;
                TransitionManager.beginDelayedTransition((ViewGroup) parent, fade);
                imageView.setVisibility(0);
                index = i3;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }

    private final void i(List<? extends ImageView> avatarList) {
        for (ImageView imageView : avatarList) {
            ViewParent parent = imageView.getParent();
            if (parent != null) {
                Fade fade = new Fade(2);
                fade.setDuration(500L);
                Unit unit = Unit.INSTANCE;
                TransitionManager.beginDelayedTransition((ViewGroup) parent, fade);
                imageView.setVisibility(4);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }

    private final List<Object> j(List<String> uinList) {
        boolean z16;
        m mVar;
        ArrayList arrayList = new ArrayList();
        for (String str : uinList) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (mVar = this.urlDrawableDelegate) != null) {
                Intrinsics.checkNotNull(mVar);
                Drawable a16 = mVar.a(str);
                if (a16 != null) {
                    arrayList.add(a16);
                } else {
                    d.d("QUIBadge_Rich", "[getAvatarRedPoint] uin(" + str + ") get fail face drawable. will use default face bitmap.)");
                    m mVar2 = this.urlDrawableDelegate;
                    Intrinsics.checkNotNull(mVar2);
                    arrayList.add(mVar2.getDefaultFaceBitmap());
                }
            } else {
                d.d("QUIBadge_Rich", "[getAvatarRedPoint] uin is empty! or urlDel is nil!");
            }
        }
        return arrayList;
    }

    private final ViewGroup l(ArrayList<ImageView> avatarList) {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(0);
        List<? extends Object> list = this.avatarDrawableList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarDrawableList");
        }
        Iterator<? extends Object> it = list.iterator();
        ImageView imageView = null;
        int i3 = 1;
        while (it.hasNext()) {
            imageView = f(it.next(), imageView);
            avatarList.add(imageView);
            linearLayout.addView(imageView);
            int i16 = i3 + 1;
            if (i3 >= 2) {
                break;
            }
            i3 = i16;
        }
        return linearLayout;
    }

    private final ViewGroup m(View containerViewA) {
        ViewGroup l3 = l(this.avatarListB);
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        frameLayout.addView(containerViewA);
        frameLayout.addView(l3);
        this.handler.postDelayed(this.changeAvatarRunnable, 2000L);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(int index) {
        List<? extends Object> list = this.avatarDrawableList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarDrawableList");
        }
        if (index >= list.size()) {
            return;
        }
        AvatarState avatarState = this.avatarState;
        AvatarState avatarState2 = AvatarState.A;
        if (avatarState == avatarState2) {
            i(this.avatarListA);
            h(index, this.avatarListB);
            avatarState2 = AvatarState.B;
        } else {
            i(this.avatarListB);
            h(index, this.avatarListA);
        }
        this.avatarState = avatarState2;
    }

    @NotNull
    public final View k(@NotNull List<String> uinList, boolean needAnimation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (View) iPatchRedirector.redirect((short) 1, this, uinList, Boolean.valueOf(needAnimation));
        }
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        this.avatarDrawableList = j(uinList);
        ViewGroup l3 = l(this.avatarListA);
        if (needAnimation && uinList.size() > 2) {
            return m(l3);
        }
        return l3;
    }
}
