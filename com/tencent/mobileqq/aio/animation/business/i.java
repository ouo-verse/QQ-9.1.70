package com.tencent.mobileqq.aio.animation.business;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.airbnb.lottie.RenderMode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.aio.animation.business.i;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ds;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u0001:\u0002/SB\u001f\u0012\u0006\u0010.\u001a\u00020\"\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010O\u001a\u00020N\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J*\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J6\u0010\u001a\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J&\u0010 \u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0002J0\u0010'\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"H\u0016J'\u0010+\u001a\u00020\u00022\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010)0(\"\u0004\u0018\u00010)H\u0016\u00a2\u0006\u0004\b+\u0010,J\b\u0010-\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\"H\u0016R\u0014\u00101\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R,\u0010B\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001e ?*\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010>0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020D0C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/i;", "Lcom/tencent/mobileqq/aio/animation/f;", "", HippyTKDListViewAdapter.X, "y", "", "D", "", "strAnimPath", "Lcom/tencent/mobileqq/aio/animation/config/a;", "animationRule", "Lcom/tencent/mobileqq/aio/animation/config/e;", "image", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "Ljava/io/File;", "imageDir", "Ljava/io/FileInputStream;", "fis", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "Lcom/airbnb/lottie/LottieComposition;", "composition", "finalImage", "finalAnimationRule", "E", "Lcom/airbnb/lottie/LottieImageAsset;", "asset", "absolutePath", "Landroid/graphics/Bitmap;", "B", BdhLogUtil.LogTag.Tag_Conn, "changed", "", "left", "top", "right", "bottom", "f", "", "", "args", DomainData.DOMAIN_NAME, "([Ljava/lang/Object;)Z", "o", "type", "a", "Ljava/lang/Object;", "mLock", "Landroid/widget/RelativeLayout;", "g", "Landroid/widget/RelativeLayout;", "mLottieLayout", tl.h.F, "Lcom/airbnb/lottie/LottieAnimationView;", "mLottieView", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "listViewParent", "", "", "kotlin.jvm.PlatformType", "j", "Ljava/util/List;", "bitmapList", "Ljava/util/Queue;", "Lcom/tencent/mobileqq/aio/animation/business/i$b;", "k", "Ljava/util/Queue;", "animatorQueue", "Lcom/tencent/mobileqq/widget/f;", "l", "Lcom/tencent/mobileqq/widget/f;", "mAnimationListener", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/aio/animation/data/a;", "listview", "<init>", "(ILcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;Lcom/tencent/mobileqq/aio/animation/data/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class i extends com.tencent.mobileqq.aio.animation.f {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mLock;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout mLottieLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieAnimationView mLottieView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup listViewParent;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final List<Bitmap> bitmapList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Queue<b> animatorQueue;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.widget.f mAnimationListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/i$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.business.i$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u000b\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/i$b;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setStrPath", "(Ljava/lang/String;)V", "strPath", "", "b", "I", "()I", "setId", "(I)V", "id", "Lcom/tencent/mobileqq/aio/animation/config/a;", "c", "Lcom/tencent/mobileqq/aio/animation/config/a;", "()Lcom/tencent/mobileqq/aio/animation/config/a;", "setRule", "(Lcom/tencent/mobileqq/aio/animation/config/a;)V", TransferConfig.ExtendParamFloats.KEY_RULE, "Lcom/tencent/mobileqq/aio/animation/config/e;", "Lcom/tencent/mobileqq/aio/animation/config/e;", "()Lcom/tencent/mobileqq/aio/animation/config/e;", "setImage", "(Lcom/tencent/mobileqq/aio/animation/config/e;)V", "image", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/aio/animation/config/a;Lcom/tencent/mobileqq/aio/animation/config/e;)V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String strPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int id;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.mobileqq.aio.animation.config.a rule;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.mobileqq.aio.animation.config.e image;

        public b(@NotNull String strPath, int i3, @NotNull com.tencent.mobileqq.aio.animation.config.a rule, @NotNull com.tencent.mobileqq.aio.animation.config.e image) {
            Intrinsics.checkNotNullParameter(strPath, "strPath");
            Intrinsics.checkNotNullParameter(rule, "rule");
            Intrinsics.checkNotNullParameter(image, "image");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, strPath, Integer.valueOf(i3), rule, image);
                return;
            }
            this.strPath = strPath;
            this.id = i3;
            this.rule = rule;
            this.image = image;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.id;
        }

        @NotNull
        public final com.tencent.mobileqq.aio.animation.config.e b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (com.tencent.mobileqq.aio.animation.config.e) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.image;
        }

        @NotNull
        public final com.tencent.mobileqq.aio.animation.config.a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.mobileqq.aio.animation.config.a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.rule;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.strPath;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/animation/business/i$c", "Lcom/airbnb/lottie/ImageAssetDelegate;", "Lcom/airbnb/lottie/LottieImageAsset;", "asset", "Landroid/graphics/Bitmap;", "fetchBitmap", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements ImageAssetDelegate {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f187936b;

        c(String str) {
            this.f187936b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) str);
            }
        }

        @Override // com.airbnb.lottie.ImageAssetDelegate
        @Nullable
        public Bitmap fetchBitmap(@NotNull LottieImageAsset asset) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) asset);
            }
            Intrinsics.checkNotNullParameter(asset, "asset");
            i iVar = i.this;
            String absolutePath = this.f187936b;
            Intrinsics.checkNotNullExpressionValue(absolutePath, "absolutePath");
            return iVar.B(asset, absolutePath);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/animation/business/i$d", "Lcom/airbnb/lottie/OnCompositionLoadedListener;", "Lcom/airbnb/lottie/LottieComposition;", "composition", "", "onCompositionLoaded", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements OnCompositionLoadedListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<LottieAnimationView> f187938b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FileInputStream f187939c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.aio.animation.config.e f187940d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.aio.animation.config.a f187941e;

        d(Ref.ObjectRef<LottieAnimationView> objectRef, FileInputStream fileInputStream, com.tencent.mobileqq.aio.animation.config.e eVar, com.tencent.mobileqq.aio.animation.config.a aVar) {
            this.f187938b = objectRef;
            this.f187939c = fileInputStream;
            this.f187940d = eVar;
            this.f187941e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, i.this, objectRef, fileInputStream, eVar, aVar);
            }
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(@Nullable LottieComposition composition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                i.this.E(this.f187938b.element, composition, this.f187939c, this.f187940d, this.f187941e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) composition);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/animation/business/i$e", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(i this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.D();
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
            QLog.d("DigitLottieAnimation", 1, "onAnimationEnd");
            if (!i.this.animatorQueue.isEmpty()) {
                i.this.animatorQueue.remove();
            }
            if (i.this.animatorQueue.isEmpty()) {
                i.this.o();
            } else {
                final i iVar = i.this;
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.business.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.e.f(i.this);
                    }
                });
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
                QLog.d("DigitLottieAnimation", 1, "onAnimationStart");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29588);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(int i3, @NotNull AIOAnimationContainer container, @NotNull com.tencent.mobileqq.aio.animation.data.a listview) {
        super(i3, container, listview);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listview, "listview");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), container, listview);
            return;
        }
        this.mLock = new Object();
        this.bitmapList = Collections.synchronizedList(new ArrayList());
        this.animatorQueue = new LinkedList();
        this.mAnimationListener = new e();
    }

    private final void A(String strAnimPath, com.tencent.mobileqq.aio.animation.config.a animationRule, com.tencent.mobileqq.aio.animation.config.e image) {
        com.tencent.mobileqq.aio.animation.util.b bVar = com.tencent.mobileqq.aio.animation.util.b.f188159a;
        File file = new File(bVar.c() + strAnimPath + "/data.json");
        File file2 = new File(bVar.c() + strAnimPath + "/images");
        if (file.exists() && file2.exists()) {
            try {
                z(animationRule, image, file2, new FileInputStream(file));
                return;
            } catch (Exception e16) {
                QLog.w("DigitLottieAnimation", 1, "[loadResourcesFromFiles] exception=" + e16);
                return;
            }
        }
        QLog.w("DigitLottieAnimation", 1, "[loadResourcesFromFiles] file not exists, file=" + file + " dir=" + file2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap B(LottieImageAsset asset, String absolutePath) {
        Bitmap bitmap = null;
        if (this.listViewParent == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        ViewGroup viewGroup = this.listViewParent;
        Intrinsics.checkNotNull(viewGroup);
        options.inDensity = viewGroup.getContext().getResources().getDisplayMetrics().densityDpi;
        try {
            bitmap = BitmapFactory.decodeFile(absolutePath + File.separator + asset.getFileName(), options);
            this.bitmapList.add(bitmap);
            return bitmap;
        } catch (Exception unused) {
            QLog.d("DigitLottieAnimation", 1, "playNextAnim setImageAssetDelegate Exception");
            return bitmap;
        } catch (OutOfMemoryError unused2) {
            QLog.d("DigitLottieAnimation", 1, "playNextAnim setImageAssetDelegate OutOfMemoryError");
            return bitmap;
        }
    }

    private final void C(LottieComposition composition, com.tencent.mobileqq.aio.animation.config.e finalImage, com.tencent.mobileqq.aio.animation.config.a finalAnimationRule) {
        synchronized (this.mLock) {
            if (composition == null) {
                QLog.i("DigitLottieAnimation", 1, "[onLottieCompositionLoaded] composition is null");
                return;
            }
            LottieAnimationView lottieAnimationView = this.mLottieView;
            if (lottieAnimationView == null) {
                QLog.i("DigitLottieAnimation", 1, "[onLottieCompositionLoaded] lottie view is null");
                return;
            }
            if (lottieAnimationView != null) {
                lottieAnimationView.setComposition(composition);
                lottieAnimationView.loop(false);
                lottieAnimationView.setVisibility(0);
                if (finalImage != null && finalAnimationRule != null) {
                    float f16 = lottieAnimationView.getResources().getDisplayMetrics().density;
                    String j3 = finalImage.j();
                    Intrinsics.checkNotNull(j3);
                    n nVar = new n(j3);
                    List<Point> b16 = nVar.b();
                    Point point = b16.get(ds.d(0, b16.size()));
                    int c16 = nVar.c() / 2;
                    int a16 = nVar.a() / 2;
                    ViewGroup.LayoutParams layoutParams = lottieAnimationView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.width = (int) (c16 * f16);
                    layoutParams2.height = (int) (a16 * f16);
                    float f17 = 2;
                    layoutParams2.leftMargin = (int) (((point.x - (nVar.c() / 2)) * f16) / f17);
                    int a17 = (int) ((f16 * (point.y - (nVar.a() / 2))) / f17);
                    layoutParams2.topMargin = a17;
                    int i3 = layoutParams2.leftMargin;
                    int i16 = layoutParams2.width + i3;
                    int i17 = layoutParams2.height + a17;
                    lottieAnimationView.setLayoutParams(layoutParams2);
                    lottieAnimationView.layout(i3, a17, i16, i17);
                    lottieAnimationView.requestLayout();
                    lottieAnimationView.playAnimation();
                    QLog.i("DigitLottieAnimation", 1, "[onCompositionLoaded] start to play, layout=" + i3 + "," + a17 + "," + i16 + "," + i17);
                    return;
                }
                Unit unit = Unit.INSTANCE;
            }
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        com.tencent.mobileqq.aio.animation.config.e eVar;
        int i3;
        if (w()) {
            return;
        }
        com.tencent.mobileqq.aio.animation.config.a aVar = null;
        boolean z16 = false;
        String str = "";
        if (this.animatorQueue.size() > 0) {
            b peek = this.animatorQueue.peek();
            if (peek != null) {
                String d16 = peek.d();
                int a16 = peek.a();
                com.tencent.mobileqq.aio.animation.config.a c16 = peek.c();
                eVar = peek.b();
                str = d16;
                aVar = c16;
                i3 = a16;
            } else {
                eVar = null;
                i3 = 0;
            }
            this.animatorQueue.clear();
            QLog.i("DigitLottieAnimation", 1, "[playNextAnim] strAnimPath" + str + "id" + i3);
        } else {
            eVar = null;
        }
        if (str.length() == 0) {
            z16 = true;
        }
        if (!z16 && aVar != null && eVar != null) {
            if (this.listViewParent == null) {
                QLog.d("DigitLottieAnimation", 1, "[playNextAnim] listViewParent is null");
                return;
            } else {
                A(str, aVar, eVar);
                return;
            }
        }
        QLog.i("DigitLottieAnimation", 1, "[playNextAnim] strAnimPath isEmpty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(LottieAnimationView lottieView, final LottieComposition composition, FileInputStream fis, final com.tencent.mobileqq.aio.animation.config.e finalImage, final com.tencent.mobileqq.aio.animation.config.a finalAnimationRule) {
        if (lottieView == null) {
            QLog.i("DigitLottieAnimation", 1, "LottieComposition.Factory.fromInputStream mLottieView is null!");
            return;
        }
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException unused) {
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.business.h
            @Override // java.lang.Runnable
            public final void run() {
                i.F(i.this, composition, finalImage, finalAnimationRule);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(i this$0, LottieComposition lottieComposition, com.tencent.mobileqq.aio.animation.config.e finalImage, com.tencent.mobileqq.aio.animation.config.a finalAnimationRule) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(finalImage, "$finalImage");
        Intrinsics.checkNotNullParameter(finalAnimationRule, "$finalAnimationRule");
        this$0.C(lottieComposition, finalImage, finalAnimationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.bitmapList.isEmpty()) {
            int size = this$0.bitmapList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Bitmap bitmap = this$0.bitmapList.get(i3);
                if (bitmap != null) {
                    bitmap.recycle();
                    this$0.bitmapList.set(i3, null);
                }
            }
            this$0.bitmapList.clear();
        }
    }

    private final boolean w() {
        boolean z16;
        LottieAnimationView lottieAnimationView = this.mLottieView;
        if (lottieAnimationView != null && this.mLottieLayout != null) {
            if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            QLog.d("DigitLottieAnimation", 1, "playNextAnim mLottieView isAnimating");
            return true;
        }
        QLog.d("DigitLottieAnimation", 1, "playNextAnim mLottieView == null || mLottieLayout == null");
        return true;
    }

    private final boolean x() {
        if (Build.VERSION.SDK_INT > 24) {
            return true;
        }
        return false;
    }

    private final boolean y() {
        if (this.mLottieLayout == null) {
            ViewGroup parent = c().getParent();
            this.listViewParent = parent;
            if (parent == null) {
                return true;
            }
            Intrinsics.checkNotNull(parent);
            View inflate = View.inflate(parent.getContext(), R.layout.dum, null);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            RelativeLayout relativeLayout = (RelativeLayout) inflate;
            this.mLottieLayout = relativeLayout;
            if (relativeLayout == null) {
                QLog.d("DigitLottieAnimation", 1, "startAnim mLottieLayout null");
                return true;
            }
            Intrinsics.checkNotNull(relativeLayout);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) relativeLayout.findViewById(R.id.sgs);
            this.mLottieView = lottieAnimationView;
            if (lottieAnimationView == null) {
                QLog.d("DigitLottieAnimation", 1, "startAnim mLottieView null");
                return true;
            }
            Intrinsics.checkNotNull(lottieAnimationView);
            lottieAnimationView.addAnimatorListener(this.mAnimationListener);
            b().addView(relativeLayout);
            lottieAnimationView.setRenderMode(RenderMode.HARDWARE);
            return false;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.airbnb.lottie.LottieAnimationView, T] */
    private final void z(com.tencent.mobileqq.aio.animation.config.a animationRule, com.tencent.mobileqq.aio.animation.config.e image, File imageDir, FileInputStream fis) {
        String absolutePath = imageDir.getAbsolutePath();
        QLog.d("DigitLottieAnimation", 1, "playNextAnim absolutePath" + absolutePath);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.mLock) {
            ?? r16 = this.mLottieView;
            objectRef.element = r16;
            if (r16 == 0) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            if (r16 != 0) {
                r16.setImageAssetDelegate(new c(absolutePath));
            }
            LottieComposition.Factory.fromInputStream(fis, new d(objectRef, fis, image, animationRule));
        }
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
            c();
            int d16 = (ViewUtils.f352270a.d() - c().getInputBarHeight()) - c().V0();
            LottieAnimationView lottieAnimationView = this.mLottieView;
            if (lottieAnimationView != null && (lottieAnimationView.getLeft() != left || lottieAnimationView.getRight() != right || lottieAnimationView.getTop() != top || lottieAnimationView.getBottom() != d16)) {
                RelativeLayout relativeLayout = this.mLottieLayout;
                Intrinsics.checkNotNull(relativeLayout);
                relativeLayout.layout(left, top, right, d16);
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean n(@NotNull Object... args) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (!x()) {
            QLog.d("DigitLottieAnimation", 1, "[start] version too low not support lottie.");
            return false;
        }
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("DigitLottieAnimation", 1, "startAnim args is null");
            return false;
        }
        if (args.length == 2) {
            Object obj = args[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.config.JumpImage");
            com.tencent.mobileqq.aio.animation.config.e eVar = (com.tencent.mobileqq.aio.animation.config.e) obj;
            String k3 = eVar.k();
            Intrinsics.checkNotNull(k3);
            Object obj2 = args[1];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.config.AioAnimationRule");
            com.tencent.mobileqq.aio.animation.config.a aVar = (com.tencent.mobileqq.aio.animation.config.a) obj2;
            int h16 = aVar.h();
            if (!TextUtils.isEmpty(k3) && h16 != 0) {
                this.animatorQueue.add(new b(k3, h16, aVar, eVar));
            }
            LottieAnimationView lottieAnimationView = this.mLottieView;
            if (lottieAnimationView != null) {
                Intrinsics.checkNotNull(lottieAnimationView);
                if (lottieAnimationView.isAnimating()) {
                    QLog.i("DigitLottieAnimation", 1, "startAnim mLottieView isAnimating");
                    return true;
                }
            }
            if (y()) {
                QLog.i("DigitLottieAnimation", 1, "startAnim, failed to init lottie view");
                return false;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.business.f
                @Override // java.lang.Runnable
                public final void run() {
                    i.G(i.this);
                }
            }, 16, null, false);
            QLog.d("DigitLottieAnimation", 1, "startAnim succ");
            return true;
        }
        QLog.i("DigitLottieAnimation", 1, "startAnim args error!");
        return false;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d("DigitLottieAnimation", 1, "[stop]");
        if (!this.animatorQueue.isEmpty()) {
            this.animatorQueue.clear();
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.business.g
            @Override // java.lang.Runnable
            public final void run() {
                i.H(i.this);
            }
        });
        LottieAnimationView lottieAnimationView = this.mLottieView;
        if (lottieAnimationView != null && this.mLottieLayout != null) {
            if (lottieAnimationView != null) {
                lottieAnimationView.removeAllAnimatorListeners();
                if (lottieAnimationView.isAnimating()) {
                    lottieAnimationView.cancelAnimation();
                }
            }
            synchronized (this.mLock) {
                this.mLottieView = null;
                Unit unit = Unit.INSTANCE;
            }
            b().removeView(this.mLottieLayout);
            this.mLottieLayout = null;
            h();
            return;
        }
        QLog.d("DigitLottieAnimation", 1, "mLottieView == null || mLottieLayout == null");
    }
}
