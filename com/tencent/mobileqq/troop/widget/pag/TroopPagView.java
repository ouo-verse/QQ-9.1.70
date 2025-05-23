package com.tencent.mobileqq.troop.widget.pag;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.widget.pag.TroopPAGLoader;
import com.tencent.mobileqq.troop.widget.pag.TroopPagView;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.light.LightEngine;

@Keep
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0001]B'\b\u0007\u0012\u0006\u0010V\u001a\u00020U\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010W\u0012\b\b\u0002\u0010Y\u001a\u00020\u0004\u00a2\u0006\u0004\bZ\u0010[JE\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J4\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00192\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u001e\u001a\u00020\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020 JA\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\"\u0010\rJ \u0010\"\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020 J\u0010\u0010%\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010#J\u0006\u0010&\u001a\u00020\u000bJ\b\u0010'\u001a\u00020\u000bH\u0014J\u0006\u0010(\u001a\u00020\u000bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R>\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R$\u0010@\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010P\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010R\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010A\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/pag/TroopPagView;", "Landroid/widget/FrameLayout;", "", Constants.PAG_FILE_PATH, "", "repeatCount", "imageIndex", "Landroid/graphics/Bitmap;", "image", "Lorg/libpag/PAGView$PAGViewListener;", "listener", "", "doPlay", "(Ljava/lang/String;ILjava/lang/Integer;Landroid/graphics/Bitmap;Lorg/libpag/PAGView$PAGViewListener;)V", "pagFile0Path", "pagFile1Path", "Lorg/libpag/PAGView;", "pagView", "Lorg/libpag/PAGFile;", "pag0", "pag1", "initPagView", "enterPagUrl", "loopPagUrl", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getNeedDownloadUrlLocalPathMap", "setPagListener", "Landroid/view/View;", "outerPlaceHolderView", "setOuterPlaceHolderView", "pagUrl", "", "enablePlay", "play", "Lcom/tencent/mobileqq/troop/widget/pag/TroopPAGLoader$a;", "callback", "getBitmap", "stop", NodeProps.ON_DETACHED_FROM_WINDOW, "tryOpenFfmpegDecoder", "mLocalPagUrl", "Ljava/lang/String;", "getMLocalPagUrl", "()Ljava/lang/String;", "setMLocalPagUrl", "(Ljava/lang/String;)V", "mLocalEnterPagUrl", "getMLocalEnterPagUrl", "setMLocalEnterPagUrl", "mLocalLoopPagUrl", "getMLocalLoopPagUrl", "setMLocalLoopPagUrl", "mLocalPagUrlMap", "Ljava/util/HashMap;", "getMLocalPagUrlMap", "()Ljava/util/HashMap;", "setMLocalPagUrlMap", "(Ljava/util/HashMap;)V", "Lvk3/a;", "mPagDownloadListener", "Lvk3/a;", "mEnablePlay", "Z", "mListener", "Lorg/libpag/PAGView$PAGViewListener;", "getMListener", "()Lorg/libpag/PAGView$PAGViewListener;", "setMListener", "(Lorg/libpag/PAGView$PAGViewListener;)V", "mOuterPlaceholderView", "Landroid/view/View;", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "vasPagView", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Landroid/widget/ImageView;", "placeHolderImageView", "Landroid/widget/ImageView;", "cachedRepeatCount", "I", "cachedImageIndex", "Ljava/lang/Integer;", "cachedImage", "Landroid/graphics/Bitmap;", "cachedPagListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopPagView extends FrameLayout {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TroopPagView";

    @Nullable
    private Bitmap cachedImage;

    @Nullable
    private Integer cachedImageIndex;

    @Nullable
    private PAGView.PAGViewListener cachedPagListener;
    private int cachedRepeatCount;
    private boolean mEnablePlay;

    @Nullable
    private PAGView.PAGViewListener mListener;

    @Nullable
    private String mLocalEnterPagUrl;

    @Nullable
    private String mLocalLoopPagUrl;

    @Nullable
    private String mLocalPagUrl;

    @NotNull
    private HashMap<String, String> mLocalPagUrlMap;

    @Nullable
    private View mOuterPlaceholderView;

    @NotNull
    private vk3.a mPagDownloadListener;

    @NotNull
    private ImageView placeHolderImageView;

    @NotNull
    private VasPagView vasPagView;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/widget/pag/TroopPagView$a", "Lvk3/a;", "", "url", "path", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements vk3.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPagView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(TroopPagView this$0, String path) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(path, "$path");
            this$0.doPlay(path, this$0.cachedRepeatCount, this$0.cachedImageIndex, this$0.cachedImage, this$0.cachedPagListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(TroopPagView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String str = this$0.getMLocalPagUrlMap().get(this$0.getMLocalEnterPagUrl());
            Intrinsics.checkNotNull(str);
            String str2 = this$0.getMLocalPagUrlMap().get(this$0.getMLocalLoopPagUrl());
            Intrinsics.checkNotNull(str2);
            this$0.doPlay(str, str2);
        }

        @Override // vk3.a
        public void a(@NotNull String url, @NotNull final String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) path);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(path, "path");
            if (Intrinsics.areEqual(url, TroopPagView.this.getMLocalPagUrl()) && !TextUtils.isEmpty(path)) {
                QLog.i(TroopPagView.TAG, 1, "onPagDownloaded url:" + url + ", path:" + path);
                TroopPAGLoader.f302618a.j(this);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final TroopPagView troopPagView = TroopPagView.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.widget.pag.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopPagView.a.d(TroopPagView.this, path);
                    }
                });
            }
            if (!TroopPagView.this.getMLocalPagUrlMap().isEmpty()) {
                QLog.i(TroopPagView.TAG, 1, "onPagDownloaded url:" + url + ", path:" + path);
                TroopPagView.this.getMLocalPagUrlMap().put(url, path);
                if (!TroopPagView.this.getMLocalPagUrlMap().values().contains("") && TroopPagView.this.getMLocalEnterPagUrl() != null && TroopPagView.this.getMLocalLoopPagUrl() != null && TroopPagView.this.getMLocalPagUrlMap().containsKey(TroopPagView.this.getMLocalEnterPagUrl()) && TroopPagView.this.getMLocalPagUrlMap().containsKey(TroopPagView.this.getMLocalLoopPagUrl())) {
                    Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
                    final TroopPagView troopPagView2 = TroopPagView.this;
                    uIHandlerV22.post(new Runnable() { // from class: com.tencent.mobileqq.troop.widget.pag.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            TroopPagView.a.e(TroopPagView.this);
                        }
                    });
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/pag/TroopPagView$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.widget.pag.TroopPagView$b, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62113);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopPagView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            return;
        }
        iPatchRedirector.redirect((short) 23, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doPlay(String pagFilePath, int repeatCount, Integer imageIndex, Bitmap image, PAGView.PAGViewListener listener) {
        setPagListener(listener);
        this.vasPagView.api().postAction(new TroopPagView$doPlay$1(image, pagFilePath, repeatCount, imageIndex, this));
    }

    static /* synthetic */ void doPlay$default(TroopPagView troopPagView, String str, int i3, Integer num, Bitmap bitmap, PAGView.PAGViewListener pAGViewListener, int i16, Object obj) {
        Integer num2;
        Bitmap bitmap2;
        PAGView.PAGViewListener pAGViewListener2;
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        if ((i16 & 8) != 0) {
            bitmap2 = null;
        } else {
            bitmap2 = bitmap;
        }
        if ((i16 & 16) != 0) {
            pAGViewListener2 = null;
        } else {
            pAGViewListener2 = pAGViewListener;
        }
        troopPagView.doPlay(str, i17, num2, bitmap2, pAGViewListener2);
    }

    private final HashMap<String, String> getNeedDownloadUrlLocalPathMap(String enterPagUrl, String loopPagUrl) {
        HashMap<String, String> hashMap = new HashMap<>();
        TroopPAGLoader troopPAGLoader = TroopPAGLoader.f302618a;
        String f16 = troopPAGLoader.f(enterPagUrl, false);
        if (f16 == null) {
            f16 = "";
        }
        String f17 = troopPAGLoader.f(loopPagUrl, false);
        if (f17 == null) {
            f17 = "";
        }
        if (!TextUtils.isEmpty(f16) && !new File(f16).exists()) {
            hashMap.put(enterPagUrl, "");
        } else {
            hashMap.put(enterPagUrl, f16);
        }
        if (!TextUtils.isEmpty(f17) && !new File(f17).exists()) {
            hashMap.put(loopPagUrl, "");
        } else {
            hashMap.put(loopPagUrl, f17);
        }
        QLog.i(TAG, 1, "getNeedDownloadUrlList size " + hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initPagView(PAGView pagView, PAGFile pag0, PAGFile pag1) {
        QLog.i(TAG, 1, "initPagView - start");
        int width = pag0.width();
        int height = pag0.height();
        int width2 = pag1.width();
        int height2 = pag1.height();
        QLog.i(TAG, 1, "initPagView -pag0 width " + width + ", pag0 height: " + height + " -pag1 width " + width2 + ", pag1 height: " + height2);
        PAGComposition Make = PAGComposition.Make(width2, height2);
        if (Make == null) {
            return;
        }
        long duration = pag0.duration();
        long duration2 = pag1.duration();
        QLog.i(TAG, 1, "initPagView -pag0 Duration " + duration + ", pag1 Duration: " + duration2);
        pag0.setStartTime(0L);
        pag1.setStartTime(duration);
        pag1.setTimeStretchMode(2);
        pag1.setDuration(duration2 * ((long) 2500));
        Make.addLayer(pag0);
        Make.addLayer(pag1);
        pagView.setComposition(Make);
        pagView.setVisibility(0);
        pagView.setScaleMode(1);
        pagView.setRepeatCount(0);
        QLog.i(TAG, 1, "initPagView - end");
    }

    public static /* synthetic */ void play$default(TroopPagView troopPagView, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        troopPagView.play(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$0(TroopPagView this$0, String pagFilePath) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pagFilePath, "$pagFilePath");
        doPlay$default(this$0, pagFilePath, 0, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$1(TroopPagView this$0, String pagFilePath, int i3, Integer num, Bitmap bitmap, PAGView.PAGViewListener pAGViewListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pagFilePath, "$pagFilePath");
        this$0.doPlay(pagFilePath, i3, num, bitmap, pAGViewListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$2(TroopPagView this$0, String enterPagUrl, String loopPagUrl) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(enterPagUrl, "$enterPagUrl");
        Intrinsics.checkNotNullParameter(loopPagUrl, "$loopPagUrl");
        String str = this$0.mLocalPagUrlMap.get(enterPagUrl);
        Intrinsics.checkNotNull(str);
        String str2 = this$0.mLocalPagUrlMap.get(loopPagUrl);
        Intrinsics.checkNotNull(str2);
        this$0.doPlay(str, str2);
    }

    public static /* synthetic */ void setOuterPlaceHolderView$default(TroopPagView troopPagView, View view, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            view = null;
        }
        troopPagView.setOuterPlaceHolderView(view);
    }

    public final void getBitmap(@Nullable final TroopPAGLoader.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) callback);
        } else {
            this.vasPagView.api().postAction(new Function1<PAGView, Unit>(callback) { // from class: com.tencent.mobileqq.troop.widget.pag.TroopPagView$getBitmap$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ TroopPAGLoader.a $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                    }
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PAGView pagView) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        Intrinsics.checkNotNullParameter(pagView, "pagView");
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pagView);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                    invoke2(pAGView);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Nullable
    public final PAGView.PAGViewListener getMListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (PAGView.PAGViewListener) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mListener;
    }

    @Nullable
    public final String getMLocalEnterPagUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mLocalEnterPagUrl;
    }

    @Nullable
    public final String getMLocalLoopPagUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mLocalLoopPagUrl;
    }

    @Nullable
    public final String getMLocalPagUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mLocalPagUrl;
    }

    @NotNull
    public final HashMap<String, String> getMLocalPagUrlMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mLocalPagUrlMap;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            super.onDetachedFromWindow();
            TroopPAGLoader.f302618a.j(this.mPagDownloadListener);
        }
    }

    public final void play(@NotNull String pagUrl, boolean enablePlay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, pagUrl, Boolean.valueOf(enablePlay));
            return;
        }
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        QLog.i(TAG, 1, "play url:" + pagUrl);
        if (pagUrl.length() == 0) {
            return;
        }
        this.mEnablePlay = enablePlay;
        this.mLocalPagUrl = pagUrl;
        TroopPAGLoader troopPAGLoader = TroopPAGLoader.f302618a;
        final String g16 = TroopPAGLoader.g(troopPAGLoader, pagUrl, false, 2, null);
        if (g16 == null) {
            g16 = "";
        }
        if (!TextUtils.isEmpty(g16) && new File(g16).exists()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.widget.pag.c
                @Override // java.lang.Runnable
                public final void run() {
                    TroopPagView.play$lambda$0(TroopPagView.this, g16);
                }
            });
        } else {
            troopPAGLoader.j(this.mPagDownloadListener);
            troopPAGLoader.c(this.mPagDownloadListener);
        }
    }

    public final void setMListener(@Nullable PAGView.PAGViewListener pAGViewListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) pAGViewListener);
        } else {
            this.mListener = pAGViewListener;
        }
    }

    public final void setMLocalEnterPagUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.mLocalEnterPagUrl = str;
        }
    }

    public final void setMLocalLoopPagUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.mLocalLoopPagUrl = str;
        }
    }

    public final void setMLocalPagUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mLocalPagUrl = str;
        }
    }

    public final void setMLocalPagUrlMap(@NotNull HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) hashMap);
        } else {
            Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
            this.mLocalPagUrlMap = hashMap;
        }
    }

    public final void setOuterPlaceHolderView(@Nullable View outerPlaceHolderView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) outerPlaceHolderView);
        } else {
            this.mOuterPlaceholderView = outerPlaceHolderView;
        }
    }

    public final void setPagListener(@Nullable final PAGView.PAGViewListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) listener);
        } else {
            this.vasPagView.api().postAction(new Function1<PAGView, Unit>(listener) { // from class: com.tencent.mobileqq.troop.widget.pag.TroopPagView$setPagListener$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ PAGView.PAGViewListener $listener;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$listener = listener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopPagView.this, (Object) listener);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                    invoke2(pAGView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PAGView pagView) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pagView);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(pagView, "pagView");
                    if (TroopPagView.this.getMListener() != null) {
                        pagView.removeListener(TroopPagView.this.getMListener());
                    }
                    TroopPagView.this.setMListener(this.$listener);
                    PAGView.PAGViewListener pAGViewListener = this.$listener;
                    if (pAGViewListener != null) {
                        pagView.addListener(pAGViewListener);
                    }
                }
            });
        }
    }

    public final void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "stop");
        this.mEnablePlay = false;
        this.vasPagView.api().postAction(TroopPagView$stop$1.INSTANCE);
    }

    public final void tryOpenFfmpegDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            QLog.i(TAG, 1, DeviceInfoMonitor.getModel());
            LightEngine.init();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopPagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopPagView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doPlay(String pagFile0Path, String pagFile1Path) {
        this.vasPagView.api().postAction(new TroopPagView$doPlay$2(pagFile0Path, pagFile1Path, this));
    }

    public static /* synthetic */ void play$default(TroopPagView troopPagView, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        troopPagView.play(str, str2, z16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopPagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mLocalPagUrlMap = new HashMap<>();
        this.mEnablePlay = true;
        View inflate = LayoutInflater.from(context).inflate(R.layout.g1d, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.f116426yp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.vas_pag_view)");
        this.vasPagView = (VasPagView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f25540b4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.place_holder_image_view)");
        this.placeHolderImageView = (ImageView) findViewById2;
        this.vasPagView.api().build();
        this.vasPagView.api().postAction(AnonymousClass1.INSTANCE);
        this.mPagDownloadListener = new a();
    }

    public final void play(@NotNull String pagUrl, final int repeatCount, @Nullable final Integer imageIndex, @Nullable final Bitmap image, @Nullable final PAGView.PAGViewListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, pagUrl, Integer.valueOf(repeatCount), imageIndex, image, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        QLog.i(TAG, 1, "play url:" + pagUrl);
        if (pagUrl.length() == 0) {
            return;
        }
        this.mEnablePlay = true;
        this.mLocalPagUrl = pagUrl;
        TroopPAGLoader troopPAGLoader = TroopPAGLoader.f302618a;
        String g16 = TroopPAGLoader.g(troopPAGLoader, pagUrl, false, 2, null);
        if (g16 == null) {
            g16 = "";
        }
        final String str = g16;
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.widget.pag.e
                @Override // java.lang.Runnable
                public final void run() {
                    TroopPagView.play$lambda$1(TroopPagView.this, str, repeatCount, imageIndex, image, listener);
                }
            });
            return;
        }
        this.cachedRepeatCount = repeatCount;
        this.cachedImageIndex = imageIndex;
        this.cachedImage = image;
        this.cachedPagListener = listener;
        setPagListener(listener);
        troopPAGLoader.j(this.mPagDownloadListener);
        troopPAGLoader.c(this.mPagDownloadListener);
    }

    public final void play(@NotNull final String enterPagUrl, @NotNull final String loopPagUrl, boolean enablePlay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, enterPagUrl, loopPagUrl, Boolean.valueOf(enablePlay));
            return;
        }
        Intrinsics.checkNotNullParameter(enterPagUrl, "enterPagUrl");
        Intrinsics.checkNotNullParameter(loopPagUrl, "loopPagUrl");
        QLog.i(TAG, 1, "play enterPagUrl:" + enterPagUrl + ", loopPagUrl:" + loopPagUrl);
        this.mEnablePlay = enablePlay;
        this.mLocalEnterPagUrl = enterPagUrl;
        this.mLocalLoopPagUrl = loopPagUrl;
        this.mLocalPagUrlMap.clear();
        HashMap<String, String> needDownloadUrlLocalPathMap = getNeedDownloadUrlLocalPathMap(enterPagUrl, loopPagUrl);
        this.mLocalPagUrlMap = needDownloadUrlLocalPathMap;
        if (needDownloadUrlLocalPathMap.size() >= 2 && !this.mLocalPagUrlMap.values().contains("")) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.widget.pag.d
                @Override // java.lang.Runnable
                public final void run() {
                    TroopPagView.play$lambda$2(TroopPagView.this, enterPagUrl, loopPagUrl);
                }
            });
            return;
        }
        TroopPAGLoader troopPAGLoader = TroopPAGLoader.f302618a;
        troopPAGLoader.j(this.mPagDownloadListener);
        troopPAGLoader.c(this.mPagDownloadListener);
        TroopPAGLoader.g(troopPAGLoader, enterPagUrl, false, 2, null);
        TroopPAGLoader.g(troopPAGLoader, loopPagUrl, false, 2, null);
    }
}
