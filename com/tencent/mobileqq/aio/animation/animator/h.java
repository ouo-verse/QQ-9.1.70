package com.tencent.mobileqq.aio.animation.animator;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.airbnb.lottie.RenderMode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0002\u0019>B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J0\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J'\u0010\u0015\u001a\u00020\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0012\"\u0004\u0018\u00010\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\fH\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\"\u0010.\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+\u0018\u00010)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R \u00103\u001a\u000e\u0012\b\u0012\u000600R\u00020\u0000\u0018\u00010/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/h;", "Lcom/tencent/mobileqq/aio/animation/f;", "", "v", "Ljava/io/File;", "imageDir", "", "w", "Ljava/io/FileInputStream;", "fileInputStream", "t", "changed", "", "left", "top", "right", "bottom", "f", "", "", "args", DomainData.DOMAIN_NAME, "([Ljava/lang/Object;)Z", "o", "type", "a", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mLottieLayout", "Lcom/airbnb/lottie/LottieAnimationView;", "g", "Lcom/airbnb/lottie/LottieAnimationView;", "mLottieView", "Landroid/view/ViewGroup;", tl.h.F, "Landroid/view/ViewGroup;", "listViewParent", "Lcom/tencent/mobileqq/aio/animation/data/i;", "i", "Lcom/tencent/mobileqq/aio/animation/data/i;", "extraInfo", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "j", "Ljava/util/HashMap;", "mapBitmap", "Ljava/util/Queue;", "Lcom/tencent/mobileqq/aio/animation/animator/h$b;", "k", "Ljava/util/Queue;", "waitingToPlayQueue", "l", "I", "reportCount", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/aio/animation/data/a;", "listview", "<init>", "(ILcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;Lcom/tencent/mobileqq/aio/animation/data/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class h extends com.tencent.mobileqq.aio.animation.f {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mLottieLayout;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieAnimationView mLottieView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup listViewParent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.animation.data.i extraInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final HashMap<String, Bitmap> mapBitmap;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Queue<b> waitingToPlayQueue;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int reportCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/h$a;", "", "", "MAX_REPORT_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.animator.h$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/h$b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setStrPath", "(Ljava/lang/String;)V", "strPath", "", "I", "()I", "setId", "(I)V", "id", "<init>", "(Lcom/tencent/mobileqq/aio/animation/animator/h;Ljava/lang/String;I)V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String strPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int id;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f187871c;

        public b(@NotNull h hVar, String strPath, int i3) {
            Intrinsics.checkNotNullParameter(strPath, "strPath");
            this.f187871c = hVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, hVar, strPath, Integer.valueOf(i3));
            } else {
                this.strPath = strPath;
                this.id = i3;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.id;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.strPath;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/animation/animator/h$c", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QLog.isColorLevel()) {
                QLog.d("LottieAnimation", 2, "onAnimationEnd");
            }
            h.this.waitingToPlayQueue.remove();
            if (h.this.waitingToPlayQueue.isEmpty()) {
                h.this.o();
            } else if (!h.this.v()) {
                h.this.waitingToPlayQueue.clear();
                h.this.o();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29327);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(int i3, @NotNull AIOAnimationContainer container, @NotNull com.tencent.mobileqq.aio.animation.data.a listview) {
        super(i3, container, listview);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listview, "listview");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), container, listview);
        } else {
            this.mapBitmap = new HashMap<>();
            this.waitingToPlayQueue = new LinkedList();
        }
    }

    private final void t(final FileInputStream fileInputStream) {
        LottieComposition.Factory.fromInputStream(fileInputStream, new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.aio.animation.animator.g
            @Override // com.airbnb.lottie.OnCompositionLoadedListener
            public final void onCompositionLoaded(LottieComposition lottieComposition) {
                h.u(h.this, fileInputStream, lottieComposition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(h this$0, FileInputStream fileInputStream, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mLottieView == null) {
            if (QLog.isColorLevel()) {
                QLog.d("LottieAnimation", 2, "LottieComposition.Factory.fromInputStream mLottieView is null!");
                return;
            }
            return;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        if (lottieComposition != null) {
            LottieAnimationView lottieAnimationView = this$0.mLottieView;
            Intrinsics.checkNotNull(lottieAnimationView);
            lottieAnimationView.setComposition(lottieComposition);
            LottieAnimationView lottieAnimationView2 = this$0.mLottieView;
            Intrinsics.checkNotNull(lottieAnimationView2);
            lottieAnimationView2.loop(false);
            LottieAnimationView lottieAnimationView3 = this$0.mLottieView;
            Intrinsics.checkNotNull(lottieAnimationView3);
            lottieAnimationView3.setVisibility(0);
            LottieAnimationView lottieAnimationView4 = this$0.mLottieView;
            Intrinsics.checkNotNull(lottieAnimationView4);
            lottieAnimationView4.playAnimation();
            if (QLog.isColorLevel()) {
                QLog.d("LottieAnimation", 2, "playNextAnim fromInputStream succ");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "playNextAnim fromInputStream composition null");
        }
        HashMap<String, Bitmap> hashMap = this$0.mapBitmap;
        Intrinsics.checkNotNull(hashMap);
        hashMap.clear();
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v() {
        boolean z16;
        FileInputStream fileInputStream;
        int i3;
        LottieAnimationView lottieAnimationView = this.mLottieView;
        if (lottieAnimationView != null && this.mLottieLayout != null) {
            Intrinsics.checkNotNull(lottieAnimationView);
            if (lottieAnimationView.isAnimating()) {
                if (QLog.isColorLevel()) {
                    QLog.d("LottieAnimation", 2, "playNextAnim mLottieView isAnimating");
                }
                return true;
            }
            Queue<b> queue = this.waitingToPlayQueue;
            String str = "";
            if (queue != null && queue.size() > 0) {
                b peek = this.waitingToPlayQueue.peek();
                if (peek != null) {
                    str = peek.b();
                    i3 = peek.a();
                } else {
                    i3 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LottieAnimation", 2, "playNextAnim strAnimPath" + str + "id" + i3);
                }
            }
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("LottieAnimation", 2, "playNextAnim strAnimPath isEmpty");
                }
                return false;
            }
            if (this.listViewParent == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("LottieAnimation", 2, "playNextAnim listViewParent is null");
                }
                return false;
            }
            ViewGroup viewGroup = this.listViewParent;
            Intrinsics.checkNotNull(viewGroup);
            String file = viewGroup.getContext().getFilesDir().getAbsoluteFile().toString();
            String str2 = File.separator;
            File file2 = new File(file + str2 + "animConfig/" + str + "/data.json");
            ViewGroup viewGroup2 = this.listViewParent;
            Intrinsics.checkNotNull(viewGroup2);
            File file3 = new File(viewGroup2.getContext().getFilesDir().getAbsoluteFile().toString() + str2 + "animConfig/" + str + "/images");
            if (file2.exists()) {
                try {
                    fileInputStream = new FileInputStream(file2);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("LottieAnimation", 2, "playNextAnim tempFis Exception");
                    }
                    return false;
                }
            } else {
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                return false;
            }
            if (!file3.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d("LottieAnimation", 2, "playNextAnim fis == null || !imageDir.exists()");
                }
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                return false;
            }
            w(file3);
            try {
                t(fileInputStream);
                if (this.extraInfo != null) {
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LottieAnimation", 2, "playNextAnim extraInfo null");
                }
                return false;
            } catch (Exception e18) {
                QLog.e("LottieAnimation", 1, "loadResourceFileAndPlayAnim failed " + e18.getMessage());
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "playNextAnim mLottieView == null || mLottieLayout == null");
        }
        return false;
    }

    private final void w(File imageDir) {
        final String absolutePath = imageDir.getAbsolutePath();
        if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "playNextAnim absolutePath" + absolutePath);
        }
        LottieAnimationView lottieAnimationView = this.mLottieView;
        Intrinsics.checkNotNull(lottieAnimationView);
        lottieAnimationView.setImageAssetDelegate(new ImageAssetDelegate() { // from class: com.tencent.mobileqq.aio.animation.animator.f
            @Override // com.airbnb.lottie.ImageAssetDelegate
            public final Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                Bitmap x16;
                x16 = h.x(h.this, absolutePath, lottieImageAsset);
                return x16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap x(h this$0, String str, LottieImageAsset lottieImageAsset) {
        String str2;
        Bitmap decodeFile;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bitmap bitmap = null;
        if (this$0.listViewParent == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        ViewGroup viewGroup = this$0.listViewParent;
        Intrinsics.checkNotNull(viewGroup);
        options.inDensity = viewGroup.getContext().getResources().getDisplayMetrics().densityDpi;
        try {
            str2 = str + File.separator + lottieImageAsset.getFileName();
            HashMap<String, Bitmap> hashMap = this$0.mapBitmap;
            if (hashMap != null) {
                bitmap = hashMap.get(str2);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("LottieAnimation", 2, "playNextAnim setImageAssetDelegate Exception");
            }
            e16.printStackTrace();
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            decodeFile = BitmapFactory.decodeFile(str2, options);
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            if (this$0.reportCount < 10) {
                QLog.e("LottieAnimation", 1, "Lottie get bitmap oom. path = " + str2);
                this$0.reportCount = this$0.reportCount + 1;
            }
            try {
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                decodeFile = BitmapFactory.decodeFile(str2, options);
            } catch (OutOfMemoryError unused) {
                if (this$0.reportCount < 10) {
                    QLog.e("LottieAnimation", 1, "Lottie get bitmap RGB_565 oom. path = " + str2);
                    this$0.reportCount = this$0.reportCount + 1;
                }
            }
        }
        bitmap = decodeFile;
        if (bitmap != null) {
            HashMap<String, Bitmap> hashMap2 = this$0.mapBitmap;
            if (hashMap2 != null) {
                hashMap2.put(str2, bitmap);
            }
        } else if (this$0.reportCount < 10) {
            QLog.e("LottieAnimation", 1, "Lottie get bitmap is null, path = " + str2);
            this$0.reportCount = this$0.reportCount + 1;
        }
        return bitmap;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean a(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, type)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean f(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom))).booleanValue();
        }
        if (this.mLottieView != null && this.mLottieLayout != null && this.listViewParent != null) {
            int d16 = (ViewUtils.f352270a.d() - c().getInputBarHeight()) - c().V0();
            LottieAnimationView lottieAnimationView = this.mLottieView;
            Intrinsics.checkNotNull(lottieAnimationView);
            int left2 = lottieAnimationView.getLeft();
            LottieAnimationView lottieAnimationView2 = this.mLottieView;
            Intrinsics.checkNotNull(lottieAnimationView2);
            int right2 = lottieAnimationView2.getRight();
            LottieAnimationView lottieAnimationView3 = this.mLottieView;
            Intrinsics.checkNotNull(lottieAnimationView3);
            int top2 = lottieAnimationView3.getTop();
            LottieAnimationView lottieAnimationView4 = this.mLottieView;
            Intrinsics.checkNotNull(lottieAnimationView4);
            int bottom2 = lottieAnimationView4.getBottom();
            if (left2 != left || right2 != right || top2 != top || bottom2 != d16) {
                LinearLayout linearLayout = this.mLottieLayout;
                Intrinsics.checkNotNull(linearLayout);
                linearLayout.layout(left, top, right, d16);
                LottieAnimationView lottieAnimationView5 = this.mLottieView;
                Intrinsics.checkNotNull(lottieAnimationView5);
                lottieAnimationView5.layout(left, top, right, d16);
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean n(@NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length > 2) {
            Object obj = args[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Object obj2 = args[1];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj2).intValue();
            if (!TextUtils.isEmpty(str) && intValue != 0) {
                Queue<b> queue = this.waitingToPlayQueue;
                Intrinsics.checkNotNull(queue);
                queue.add(new b(this, str, intValue));
            }
            Object obj3 = args[2];
            if (obj3 != null && (obj3 instanceof com.tencent.mobileqq.aio.animation.data.i)) {
                this.extraInfo = (com.tencent.mobileqq.aio.animation.data.i) obj3;
            }
            Queue<b> queue2 = this.waitingToPlayQueue;
            Intrinsics.checkNotNull(queue2);
            if (queue2.size() > 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("LottieAnimation", 2, "startAnim animatorQueue.isEmpty() false return.");
                }
                return true;
            }
            if (this.mLottieLayout == null) {
                ViewGroup parent = c().getParent();
                this.listViewParent = parent;
                if (parent == null) {
                    return false;
                }
                Intrinsics.checkNotNull(parent);
                View inflate = View.inflate(parent.getContext(), R.layout.du8, null);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
                LinearLayout linearLayout = (LinearLayout) inflate;
                this.mLottieLayout = linearLayout;
                if (linearLayout == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LottieAnimation", 2, "startAnim mLottieLayout null");
                    }
                    return false;
                }
                Intrinsics.checkNotNull(linearLayout);
                LottieAnimationView lottieAnimationView = (LottieAnimationView) linearLayout.findViewById(R.id.sgs);
                this.mLottieView = lottieAnimationView;
                if (lottieAnimationView == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LottieAnimation", 2, "startAnim mLottieView null");
                    }
                    return false;
                }
                Intrinsics.checkNotNull(lottieAnimationView);
                lottieAnimationView.addAnimatorListener(new c());
                b().addView(this.mLottieLayout, new RelativeLayout.LayoutParams(-1, -1));
                LottieAnimationView lottieAnimationView2 = this.mLottieView;
                Intrinsics.checkNotNull(lottieAnimationView2);
                lottieAnimationView2.setRenderMode(RenderMode.HARDWARE);
            }
            if (!v()) {
                if (QLog.isColorLevel()) {
                    QLog.d("LottieAnimation", 2, "playNextAnim false");
                }
                o();
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LottieAnimation", 2, "startAnim succ");
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "startAnim args error!");
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "stopAnim");
        }
        Queue<b> queue = this.waitingToPlayQueue;
        if (queue != null && !queue.isEmpty()) {
            this.waitingToPlayQueue.clear();
        }
        HashMap<String, Bitmap> hashMap = this.mapBitmap;
        if (hashMap != null && !hashMap.isEmpty()) {
            this.mapBitmap.clear();
        }
        LottieAnimationView lottieAnimationView = this.mLottieView;
        if (lottieAnimationView != null && this.mLottieLayout != null) {
            Intrinsics.checkNotNull(lottieAnimationView);
            lottieAnimationView.removeAllAnimatorListeners();
            LottieAnimationView lottieAnimationView2 = this.mLottieView;
            Intrinsics.checkNotNull(lottieAnimationView2);
            if (lottieAnimationView2.isAnimating()) {
                LottieAnimationView lottieAnimationView3 = this.mLottieView;
                Intrinsics.checkNotNull(lottieAnimationView3);
                lottieAnimationView3.cancelAnimation();
            }
            if (b() != null) {
                b().removeView(this.mLottieLayout);
            }
            this.mLottieLayout = null;
            this.mLottieView = null;
            h();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "mLottieView == null || mLottieLayout == null");
        }
    }
}
