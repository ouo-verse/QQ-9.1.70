package com.tencent.mobileqq.stickerbubble;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.e;
import com.tencent.mobileqq.aio.event.FaceBubbleMsgEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.NTPEItemData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.poke.NTStickerBubbleImageView;
import com.tencent.mobileqq.poke.NTStickerBubbleLinearLayout;
import com.tencent.mobileqq.poke.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceBubbleElement;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002DEB\u0017\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\bA\u0010BJ \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J(\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\rH\u0016J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010%\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0016J\b\u0010&\u001a\u00020\rH\u0016R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010,R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010.R\u001e\u00103\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00105R\u001c\u0010:\u001a\n 8*\u0004\u0018\u000107078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/stickerbubble/StickerBubbleListView;", "Lcom/tencent/widget/ListView;", "Lcom/tencent/mobileqq/activity/aio/stickerbubble/d;", "Lcom/tencent/mobileqq/activity/aio/stickerbubble/StickerBubbleAnimationView$a;", "Landroid/view/View;", "view", "", HippyTKDListViewAdapter.X, "y", "", "h0", "Lcom/tencent/mobileqq/stickerbubble/StickerBubbleListView$a;", "action", "", "i0", "", "pokeEmoId", "count", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;", "g0", "Landroid/view/MotionEvent;", "ev", "onTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "r", "idx", "itemCountInSingleSendingAction", "k", "g", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "j", DomainData.DOMAIN_NAME, "l", "itemTypeCount", "itemCount", h.F, "e", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/activity/aio/stickerbubble/e;", "Lcom/tencent/mobileqq/activity/aio/stickerbubble/e;", "mGestureCallback", "Z", "mIsFirstItem", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/poke/NTStickerBubbleImageView;", "Ljava/lang/ref/WeakReference;", "mTouchDownImageViewRef", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "mTouchDownImageViewRect", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "Lmqq/app/AppRuntime;", "mApp", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "mAfRoot", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/aio/api/runtime/a;)V", "D", "a", "b", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class StickerBubbleListView extends ListView implements com.tencent.mobileqq.activity.aio.stickerbubble.d, StickerBubbleAnimationView.a {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup mAfRoot;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mGestureCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFirstItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<NTStickerBubbleImageView> mTouchDownImageViewRef;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Rect mTouchDownImageViewRect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final AppRuntime mApp;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/stickerbubble/StickerBubbleListView$a;", "", "Landroid/view/View;", "view", "", "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface a {
        void a(@NotNull View view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/stickerbubble/StickerBubbleListView$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.stickerbubble.StickerBubbleListView$b, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/stickerbubble/StickerBubbleListView$c", "Lcom/tencent/mobileqq/stickerbubble/StickerBubbleListView$a;", "Landroid/view/View;", "view", "", "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f290221a;

        c(int[] iArr) {
            this.f290221a = iArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iArr);
            }
        }

        @Override // com.tencent.mobileqq.stickerbubble.StickerBubbleListView.a
        public void a(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            if (view.getTag() instanceof Integer) {
                Object tag = view.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                this.f290221a[0] = ((Integer) tag).intValue();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/stickerbubble/StickerBubbleListView$d", "Lcom/tencent/mobileqq/stickerbubble/StickerBubbleListView$a;", "Landroid/view/View;", "view", "", "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StickerBubbleListView.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        
            if (r0.get() != r8) goto L16;
         */
        @Override // com.tencent.mobileqq.stickerbubble.StickerBubbleListView.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            if ((view instanceof NTStickerBubbleImageView) && view.getVisibility() == 0) {
                ((NTStickerBubbleImageView) view).b();
                if (StickerBubbleListView.this.mTouchDownImageViewRef != null) {
                    WeakReference weakReference = StickerBubbleListView.this.mTouchDownImageViewRef;
                    Intrinsics.checkNotNull(weakReference);
                }
                StickerBubbleListView.this.mTouchDownImageViewRef = new WeakReference(view);
                Object parent = view.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                View view2 = (View) parent;
                Object parent2 = view2.getParent();
                Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
                View view3 = (View) parent2;
                if (StickerBubbleListView.this.mTouchDownImageViewRect == null) {
                    StickerBubbleListView.this.mTouchDownImageViewRect = new Rect();
                }
                Rect rect = StickerBubbleListView.this.mTouchDownImageViewRect;
                Intrinsics.checkNotNull(rect);
                rect.set(view3.getLeft() + view2.getLeft(), view3.getTop() + view2.getTop(), view3.getLeft() + view2.getRight(), view3.getTop() + view2.getBottom());
                if (QLog.isColorLevel()) {
                    QLog.d("StickerBubbleListView", 2, "notifyItemViewTouchDown with rect: " + StickerBubbleListView.this.mTouchDownImageViewRect);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerBubbleListView(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aioContext);
            return;
        }
        this.aioContext = aioContext;
        this.mGestureCallback = new e(this, this, f.k(), false);
        this.mIsFirstItem = true;
        this.mApp = MobileQQ.sMobileQQ.peekAppRuntime();
        View requireView = aioContext.c().requireView();
        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mAfRoot = (ViewGroup) requireView;
    }

    private final FaceBubbleElement g0(int pokeEmoId, int count) {
        String c16 = com.tencent.mobileqq.poke.c.f258994a.c(pokeEmoId);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "[%s]x%d", Arrays.copyOf(new Object[]{c16, Integer.valueOf(count)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        String format2 = String.format("[%s]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u624b\u673aQQ\u4f53\u9a8c\u65b0\u529f\u80fd\u3002", Arrays.copyOf(new Object[]{c16}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        FaceBubbleElement faceBubbleElement = new FaceBubbleElement();
        faceBubbleElement.faceType = pokeEmoId;
        faceBubbleElement.faceCount = Integer.valueOf(count);
        faceBubbleElement.faceSummary = c16;
        faceBubbleElement.content = format;
        faceBubbleElement.oldVersionStr = format2;
        return faceBubbleElement;
    }

    private final boolean h0(View view, float x16, float y16) {
        if (x16 < view.getLeft() || x16 > view.getRight() || y16 < view.getTop() || y16 > view.getBottom()) {
            return false;
        }
        return true;
    }

    private final void i0(float x16, float y16, a action) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
            if (h0(childAt, x16, y16)) {
                if (childAt instanceof NTStickerBubbleLinearLayout) {
                    View b16 = ((NTStickerBubbleLinearLayout) childAt).b(x16 - childAt.getLeft(), y16 - childAt.getTop());
                    if (b16 instanceof LinearLayout) {
                        LinearLayout linearLayout = (LinearLayout) b16;
                        if (linearLayout.getChildAt(0) != null) {
                            View childAt2 = linearLayout.getChildAt(0);
                            Intrinsics.checkNotNullExpressionValue(childAt2, "itemView.getChildAt(0)");
                            action.a(childAt2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(StickerBubbleListView this$0, NTPEItemData nTPEItemData, int i3) {
        NTStickerBubbleImageView nTStickerBubbleImageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aioContext.e().h(new FaceBubbleMsgEvent.FaceBubbleSendEvent(this$0.g0(nTPEItemData.getPokeEmoId(), i3)));
        if (AppSetting.f99565y) {
            String c16 = com.tencent.mobileqq.poke.c.f258994a.c(nTPEItemData.getPokeEmoId());
            QLog.i("StickerBubbleListView", 1, "talkBack summary:" + c16);
            WeakReference<NTStickerBubbleImageView> weakReference = this$0.mTouchDownImageViewRef;
            if (weakReference != null && (nTStickerBubbleImageView = weakReference.get()) != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = this$0.getResources().getString(R.string.ypu);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026io_emo_sending_talk_back)");
                String format = String.format(string, Arrays.copyOf(new Object[]{c16, String.valueOf(i3)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                nTStickerBubbleImageView.announceForAccessibility(format);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            i();
            this.mGestureCallback.d();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return f.g(this.mApp, 10);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            com.tencent.mobileqq.stickerbubble.a.i(this, this.mAfRoot);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
    public void h(int itemTypeCount, int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(itemTypeCount), Integer.valueOf(itemCount));
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            com.tencent.mobileqq.stickerbubble.a.a(this, this.mAfRoot);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void j(float x16, float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(x16), Float.valueOf(y16));
        } else {
            i0(x16, y16, new d());
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void k(float x16, float y16, int idx, int itemCountInSingleSendingAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(x16), Float.valueOf(y16), Integer.valueOf(idx), Integer.valueOf(itemCountInSingleSendingAction));
            return;
        }
        NTPEItemData d16 = com.tencent.mobileqq.poke.c.f258994a.d(idx);
        if (d16 == null) {
            return;
        }
        String localPath = d16.getLocalPath();
        com.tencent.mobileqq.stickerbubble.viewholder.b bVar = com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a;
        StickerBubbleAnimationView u16 = bVar.u(this.mAfRoot);
        if (this.mIsFirstItem) {
            u16.bringToFront();
            bVar.h(this);
            this.mIsFirstItem = false;
        }
        if (localPath != null) {
            u16.d(com.tencent.mobileqq.stickerbubble.a.c(new Point((int) x16, (int) y16), localPath, itemCountInSingleSendingAction));
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public boolean l(float x16, float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }
        Rect rect = this.mTouchDownImageViewRect;
        if (rect != null) {
            Intrinsics.checkNotNull(rect);
            if (!rect.contains((int) x16, (int) y16)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void m(int idx, final int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(idx), Integer.valueOf(count));
            return;
        }
        com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a.k().m();
        final NTPEItemData d16 = com.tencent.mobileqq.poke.c.f258994a.d(idx);
        if (d16 != null) {
            com.tencent.mobileqq.stickerbubble.a.f(d16, this.mApp.getCurrentUin());
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.stickerbubble.b
                @Override // java.lang.Runnable
                public final void run() {
                    StickerBubbleListView.j0(StickerBubbleListView.this, d16, count);
                }
            }, 10, null, false);
            ReportController.o(this.mApp, "dc00898", "", this.aioContext.g().r().c().j(), "0X8009222", "0X8009222", d16.getPokeEmoId(), 0, String.valueOf(count), "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        WeakReference<NTStickerBubbleImageView> weakReference = this.mTouchDownImageViewRef;
        if (weakReference != null) {
            Intrinsics.checkNotNull(weakReference);
            NTStickerBubbleImageView nTStickerBubbleImageView = weakReference.get();
            if (nTStickerBubbleImageView != null) {
                nTStickerBubbleImageView.a();
            }
        }
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) ev5)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ev5)).booleanValue();
        }
        boolean g16 = this.mGestureCallback.g(ev5);
        if (!g16) {
            return super.onTouchEvent(ev5);
        }
        return g16;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public /* synthetic */ void p() {
        com.tencent.mobileqq.activity.aio.stickerbubble.c.a(this);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public int r(float x16, float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Float.valueOf(x16), Float.valueOf(y16))).intValue();
        }
        int[] iArr = {-1};
        i0(x16, y16, new c(iArr));
        return iArr[0];
    }
}
