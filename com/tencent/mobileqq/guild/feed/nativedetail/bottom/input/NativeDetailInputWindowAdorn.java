package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.InputAnimationControllerImpl;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e;
import com.tencent.mobileqq.guild.feed.util.bd;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t*\u0002\u0007\u000e\u0018\u0000 `2\u00020\u0001:\u0002-\u001fB\u0007\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000f\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\u0014\u0010#\u001a\u00020\u00022\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u000bH\u0016J\u0006\u0010(\u001a\u00020\u0002J\u0010\u0010+\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)J\b\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020.H\u0016J\u000e\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020$R\"\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00102R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00102R\u0016\u0010:\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00109R\u0018\u0010=\u001a\u00060;R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010<R\u001a\u0010\"\u001a\u0006\u0012\u0002\b\u00030!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010>R\"\u0010F\u001a\u00020?8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010M\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010U\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR \u0010\\\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u00104\u00a8\u0006b\u00b2\u0006\f\u0010a\u001a\u00020\u00118\nX\u008a\u0084\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lxk1/e;", "", "H", "Landroid/view/Window;", "window", "E", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$c", "t", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$c;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "state", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$d", "u", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$d;", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "callback", "Landroid/view/View;", "y", "expandedHeight", NodeProps.MAX_HEIGHT, "", ReportConstant.COSTREPORT_PREFIX, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "K", "Landroid/content/Context;", "context", "Lxk1/f;", "b", "c", "Lxk1/d;", "inputWindow", "d", "", "onRenderFirstFrame", "hideIntent", "f", "B", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "r", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$c;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$b;", "e", "isEmotionShowed", "J", "I", "getShadowHeight", "()I", "G", "(I)V", "shadowHeight", "panelContainerHeight", "Z", "hasUpdateFirstFrame", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$b;", "fadeInFadeOutDirector", "Lxk1/d;", "Lyk1/a;", "g", "Lyk1/a;", "v", "()Lyk1/a;", BdhLogUtil.LogTag.Tag_Conn, "(Lyk1/a;)V", "binding", tl.h.F, "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "w", "()Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "D", "(Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;)V", "emojiPanelCallback", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", HippyTKDListViewAdapter.X, "()Ljava/lang/Runnable;", UserInfo.SEX_FEMALE, "(Ljava/lang/Runnable;)V", "onOtherPageOpen", "j", "Landroid/content/Context;", "winContext", "Ljava/lang/ref/WeakReference;", "k", "Ljava/lang/ref/WeakReference;", "hostActivityWeakRef", "windowSoftInputMode", "<init>", "()V", "l", "callbackDelegate", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class NativeDetailInputWindowAdorn implements xk1.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int shadowHeight;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int hideIntent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasUpdateFirstFrame;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private xk1.d<?> inputWindow;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public yk1.a binding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable onOtherPageOpen;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context winContext;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Activity> hostActivityWeakRef;

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f220435m = {Reflection.property0(new PropertyReference0Impl(NativeDetailInputWindowAdorn.class, "callbackDelegate", "<v#0>", 0))};

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int panelContainerHeight = (int) (ViewUtils.getScreenHeight() * 0.7f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b fadeInFadeOutDirector = new b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private EmoticonCallback emojiPanelCallback = u();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$b;", "", "", "expandedHeight", "", "a", "progress", "", "b", UserInfo.SEX_FEMALE, "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private float progress;

        public b() {
        }

        public final float a(int expandedHeight) {
            float coerceAtLeast;
            float coerceAtMost;
            float f16 = expandedHeight;
            xk1.d dVar = NativeDetailInputWindowAdorn.this.inputWindow;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar = null;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f16 / dVar.Y().b(), 0.0f);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.0f);
            return coerceAtMost;
        }

        public final void b(float progress) {
            boolean z16;
            float coerceAtLeast;
            float coerceAtMost;
            float coerceAtLeast2;
            float coerceAtMost2;
            int roundToInt;
            if (this.progress == 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && NativeDetailInputWindowAdorn.this.hideIntent != 0) {
                return;
            }
            this.progress = progress;
            ImageView inputShadow = NativeDetailInputWindowAdorn.this.v().getInputShadow();
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((-2) * progress) + 1.5f, 0.0f);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.0f);
            inputShadow.setAlpha(coerceAtMost);
            View inputContainer = NativeDetailInputWindowAdorn.this.v().getInputContainer();
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast((2 * progress) - 0.5f, 0.0f);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtLeast2, 1.0f);
            inputContainer.setAlpha(coerceAtMost2);
            Drawable background = NativeDetailInputWindowAdorn.this.v().getMRv().getBackground();
            if (background != null) {
                roundToInt = MathKt__MathJVMKt.roundToInt(NativeDetailInputWindowAdorn.this.v().getInputContainer().getAlpha() * 255);
                background.setAlpha(roundToInt);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$d", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements EmoticonCallback {
        d() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$c;", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/view/ViewGroup;", "b", "()Landroid/view/ViewGroup;", "inputPanelContainer", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements e.c {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.c
        @NotNull
        public ViewGroup b() {
            return NativeDetailInputWindowAdorn.this.v().getInputPanelContainer();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.c
        @NotNull
        public View getRoot() {
            return NativeDetailInputWindowAdorn.this.v().getMRv();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0086\u0002\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$f", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f {
        f() {
        }

        @NotNull
        public final EmoticonCallback a(@Nullable Object thisRef, @NotNull KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return NativeDetailInputWindowAdorn.this.getEmojiPanelCallback();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$g", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$b;", "", "keyboardHeight", "", "isVisible", "a", "Z", "isTargetDevice", "b", "()Z", "isInMultiWindowMode", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g implements InputAnimationControllerImpl.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isTargetDevice = com.tencent.common.config.pad.d.d();

        g() {
        }

        private final boolean b() {
            WeakReference weakReference;
            Activity activity;
            boolean isInMultiWindowMode;
            if (Build.VERSION.SDK_INT >= 24 && (weakReference = NativeDetailInputWindowAdorn.this.hostActivityWeakRef) != null && (activity = (Activity) weakReference.get()) != null) {
                isInMultiWindowMode = activity.isInMultiWindowMode();
                if (!isInMultiWindowMode) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.InputAnimationControllerImpl.b
        public boolean a(int keyboardHeight, boolean isVisible) {
            if (!b() || !this.isTargetDevice) {
                return false;
            }
            if (keyboardHeight == 0 && !isVisible) {
                return true;
            }
            if (keyboardHeight != 0 || !isVisible) {
                return false;
            }
            this.isTargetDevice = false;
            return false;
        }
    }

    private static final EmoticonCallback A(f fVar) {
        return fVar.a(null, f220435m[0]);
    }

    private final void E(Window window) {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            RFWImmersiveUtils.setTransparentStatusBar(window);
            RFWImmersiveUtils.setImmersiveLayout(window, true);
        }
        SimpleUIUtil.adjustSimpleStatusBar((ImmersiveTitleBar2) null, window);
        boolean b16 = GuildThemeManager.f235286a.b();
        if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColorNew(!b16, window, false);
        }
    }

    private final void H() {
        v().getMRv().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.e
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                NativeDetailInputWindowAdorn.I(NativeDetailInputWindowAdorn.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(NativeDetailInputWindowAdorn this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 - i18 != i26 - i28) {
            this$0.panelContainerHeight = (int) (this$0.v().getMRv().getMeasuredHeight() * 0.7f);
            FrameLayout panelLayout = this$0.v().getPanelLayout();
            ViewGroup.LayoutParams layoutParams = panelLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = this$0.panelContainerHeight;
                panelLayout.setLayoutParams(layoutParams);
                ViewGroup inputPanelContainer = this$0.v().getInputPanelContainer();
                xk1.d<?> dVar = this$0.inputWindow;
                xk1.d<?> dVar2 = null;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                    dVar = null;
                }
                int expandedHeight = dVar.Y().getExpandedHeight();
                xk1.d<?> dVar3 = this$0.inputWindow;
                if (dVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                } else {
                    dVar2 = dVar3;
                }
                inputPanelContainer.setTranslationY(this$0.s(expandedHeight, dVar2.Y().getCurrentMaxExpandedHeight()));
                QLog.d("NativeDetailInputWindowAdorn", 4, "onLayoutChanged|panelContainerHeight=" + this$0.panelContainerHeight + ", translationY=" + this$0.v().getInputPanelContainer().getTranslationY());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int state) {
        ImageView inputShadow = v().getInputShadow();
        int i3 = 8;
        if ((state & 7) != 1 && inputShadow.getDrawable() != null) {
            i3 = 0;
        }
        inputShadow.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float s(int expandedHeight, int maxHeight) {
        int i3;
        float f16;
        if (this.hideIntent != 0) {
            i3 = -1;
        } else {
            i3 = this.shadowHeight;
        }
        if (i3 < 0) {
            f16 = expandedHeight;
        } else if (maxHeight <= 0) {
            f16 = 0.0f;
        } else {
            int l3 = i3 - v().l();
            if (l3 >= maxHeight) {
                f16 = l3;
            } else {
                float f17 = l3;
                f16 = ((1 - (f17 / maxHeight)) * expandedHeight) + f17;
            }
        }
        return this.panelContainerHeight - f16;
    }

    private final c t() {
        return new c();
    }

    private final d u() {
        return new d();
    }

    private final View y(EmoticonCallback callback) {
        Context context = this.winContext;
        if (context == null) {
            context = HostUIHelper.getInstance().getHostApplicationContext();
        }
        View c16 = ho1.d.c(context, v().a(), callback);
        if (c16 != null) {
            c16.setVisibility(8);
        } else {
            c16 = null;
        }
        Intrinsics.checkNotNull(c16);
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        if (v().getEmotionPanelView() == null) {
            View y16 = y(A(new f()));
            v().v(y16);
            y16.setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
            FrameLayout panelLayout = v().getPanelLayout();
            xk1.d<?> dVar = this.inputWindow;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar = null;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, dVar.Y().b());
            layoutParams.gravity = 48;
            Unit unit = Unit.INSTANCE;
            panelLayout.addView(y16, layoutParams);
            ViewGroup.LayoutParams layoutParams2 = panelLayout.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = this.panelContainerHeight;
                panelLayout.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    public final void B() {
        this.hideIntent = 0;
    }

    public final void C(@NotNull yk1.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.binding = aVar;
    }

    public final void D(@NotNull EmoticonCallback emoticonCallback) {
        Intrinsics.checkNotNullParameter(emoticonCallback, "<set-?>");
        this.emojiPanelCallback = emoticonCallback;
    }

    public final void F(@Nullable Runnable runnable) {
        this.onOtherPageOpen = runnable;
    }

    public final void G(int i3) {
        this.shadowHeight = i3;
    }

    public final void J(boolean isEmotionShowed) {
        yk1.a v3 = v();
        ImageView emotionButton = v3.getEmotionButton();
        Boolean valueOf = Boolean.valueOf(!isEmotionShowed);
        emotionButton.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, emotionButton)) == null) {
            emotionButton.setVisibility(8);
        }
        ImageView keyboardButton = v3.getKeyboardButton();
        Boolean valueOf2 = Boolean.valueOf(isEmotionShowed);
        keyboardButton.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf2, keyboardButton)) == null) {
            keyboardButton.setVisibility(8);
        }
    }

    public final void K(@Nullable Bitmap bitmap) {
        if (this.inputWindow == null) {
            return;
        }
        yk1.a v3 = v();
        if (bitmap != null) {
            v3.getInputShadow().setImageBitmap(bitmap);
            ImageView inputShadow = v3.getInputShadow();
            ViewGroup.LayoutParams layoutParams = inputShadow.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = bitmap.getHeight();
                inputShadow.setLayoutParams(layoutParams);
                this.shadowHeight = bitmap.getHeight();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        v3.getInputShadow().setImageDrawable(null);
        v3.getInputShadow().setVisibility(8);
    }

    @Override // xk1.e
    @NotNull
    public e.c a() {
        return new e();
    }

    @Override // xk1.e
    @NotNull
    public xk1.f b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.winContext = context;
        C(new yk1.a(context));
        return v();
    }

    @Override // xk1.e
    public void c() {
        jt1.b.b(v().getKeyboardButton(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn$beforeInputWindowInitialization$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                xk1.d dVar = NativeDetailInputWindowAdorn.this.inputWindow;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                    dVar = null;
                }
                if (dVar.isShowing()) {
                    NativeDetailInputWindowAdorn.this.v().a().requestFocus();
                    InputMethodUtil.show(NativeDetailInputWindowAdorn.this.v().a());
                }
            }
        });
        FrameLayout panelLayout = v().getPanelLayout();
        ViewGroup.LayoutParams layoutParams = panelLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.panelContainerHeight;
            panelLayout.setLayoutParams(layoutParams);
            H();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // xk1.e
    public void d(@NotNull xk1.d<?> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        this.inputWindow = inputWindow;
        c t16 = t();
        inputWindow.Y().d(t16);
        inputWindow.Y().i(t16);
        Window window = inputWindow.getWindow();
        if (window != null) {
            E(window);
        }
    }

    @Override // xk1.e
    @NotNull
    public InputAnimationControllerImpl.b e() {
        return new g();
    }

    @Override // xk1.e
    public void f(int hideIntent) {
        this.hideIntent = hideIntent;
    }

    @Override // xk1.e
    public int g() {
        if (Build.VERSION.SDK_INT >= 30) {
            return 48;
        }
        return 16;
    }

    @Override // xk1.e
    public boolean onRenderFirstFrame() {
        if (!this.hasUpdateFirstFrame) {
            ViewGroup inputPanelContainer = v().getInputPanelContainer();
            xk1.d<?> dVar = this.inputWindow;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar = null;
            }
            inputPanelContainer.setTranslationY(s(0, dVar.Y().getCurrentMaxExpandedHeight()));
            v().getInputContainer().setAlpha(0.0f);
            return false;
        }
        return true;
    }

    public final void r(@Nullable Activity activity) {
        if (activity != null) {
            this.hostActivityWeakRef = new WeakReference<>(activity);
        }
    }

    @NotNull
    public final yk1.a v() {
        yk1.a aVar = this.binding;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final EmoticonCallback getEmojiPanelCallback() {
        return this.emojiPanelCallback;
    }

    @Nullable
    /* renamed from: x, reason: from getter */
    public final Runnable getOnOtherPageOpen() {
        return this.onOtherPageOpen;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn$c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "", "height", "", "g", "foldState", "keyboardHeight", "c", "panelId", "targetHeight", "e", "f", "targetHeightHint", "a", "b", "state", "onStateChanged", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements e.a, e.b {
        c() {
        }

        private final void g(int height) {
            xk1.d dVar = NativeDetailInputWindowAdorn.this.inputWindow;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar = null;
            }
            com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e Y = dVar.Y();
            if (Y.getStableKeyboardShowHeight() >= Y.b()) {
                b bVar = NativeDetailInputWindowAdorn.this.fadeInFadeOutDirector;
                bVar.b(bVar.a(height));
            } else {
                NativeDetailInputWindowAdorn.this.fadeInFadeOutDirector.b(1.0f);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void a(int height, int targetHeightHint) {
            NativeDetailInputWindowAdorn.this.hasUpdateFirstFrame = true;
            g(height);
            NativeDetailInputWindowAdorn.this.v().getInputPanelContainer().setTranslationY(NativeDetailInputWindowAdorn.this.s(height, targetHeightHint));
            bd.f223882a.b(height, targetHeightHint, NativeDetailInputWindowAdorn.this.v().l());
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.a
        public void c(int foldState, int keyboardHeight) {
            if (foldState == 1 && NativeDetailInputWindowAdorn.this.v().a().hasFocus()) {
                NativeDetailInputWindowAdorn.this.B();
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.a
        public void d() {
            if (NativeDetailInputWindowAdorn.this.hideIntent == 0) {
                xk1.d dVar = NativeDetailInputWindowAdorn.this.inputWindow;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                    dVar = null;
                }
                dVar.dismiss();
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void e(int panelId, int targetHeight) {
            if (panelId == 1) {
                NativeDetailInputWindowAdorn.this.z();
                View emotionPanelView = NativeDetailInputWindowAdorn.this.v().getEmotionPanelView();
                if (emotionPanelView != null) {
                    if (emotionPanelView.getLayoutParams().height != targetHeight) {
                        emotionPanelView.getLayoutParams().height = targetHeight;
                    }
                    emotionPanelView.setVisibility(0);
                }
                NativeDetailInputWindowAdorn.this.J(true);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void f() {
            View emotionPanelView = NativeDetailInputWindowAdorn.this.v().getEmotionPanelView();
            if (emotionPanelView != null) {
                emotionPanelView.setVisibility(8);
            }
            NativeDetailInputWindowAdorn.this.J(false);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.a
        public void onStateChanged(int state) {
            if (state == 0) {
                NativeDetailInputWindowAdorn.this.v().getInputShadow().setVisibility(0);
                f();
            }
            NativeDetailInputWindowAdorn.this.q(state);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void b() {
        }
    }
}
