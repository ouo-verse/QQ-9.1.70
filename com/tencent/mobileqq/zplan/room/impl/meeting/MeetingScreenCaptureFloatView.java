package com.tencent.mobileqq.zplan.room.impl.meeting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.room.impl.meeting.MeetingScreenCaptureFloatView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.utils.i;
import gh2.d;
import gk3.b;
import kk3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import pk3.a;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/meeting/MeetingScreenCaptureFloatView;", "Landroid/widget/FrameLayout;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MeetingScreenCaptureFloatView extends FrameLayout {
    private static final int C;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final MeetingScreenCaptureFloatView f335218e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f335219f;

    /* renamed from: h, reason: collision with root package name */
    private static final int f335220h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f335221i;

    /* renamed from: m, reason: collision with root package name */
    private static final int f335222m;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/meeting/MeetingScreenCaptureFloatView$a;", "", "Ljava/lang/Runnable;", "next", "", "g", "k", "e", "", "HEIGHT", "I", "ROUNDCORNER", "WIDTH", "X", "Y", "Lcom/tencent/mobileqq/zplan/room/impl/meeting/MeetingScreenCaptureFloatView;", "meetingFloatView", "Lcom/tencent/mobileqq/zplan/room/impl/meeting/MeetingScreenCaptureFloatView;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.room.impl.meeting.MeetingScreenCaptureFloatView$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/MeetingScreenCaptureFloatView$a$a", "Lgh2/d;", "", "centerX", "centerY", "", "onEnterClick", "onCloseClick", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.room.impl.meeting.MeetingScreenCaptureFloatView$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9194a implements d {
            C9194a() {
            }

            @Override // gh2.d
            public boolean onCloseClick() {
                return true;
            }

            @Override // gh2.d
            public boolean onEnterClick(int centerX, int centerY) {
                return false;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f() {
            ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(h.INSTANCE.a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(Runnable runnable) {
            if (a.a(BaseApplication.context)) {
                MeetingScreenCaptureFloatView.INSTANCE.k();
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            final Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                DialogUtil.createCenterTextDialog(topActivity, 0, "\u9700\u8981\u60ac\u6d6e\u7a97\u6743\u9650", "\u662f\u5426\u53bb\u7533\u8bf7\u60ac\u6d6e\u7a97\u6743\u9650", "\u53d6\u6d88", "\u786e\u8ba4", new DialogInterface.OnClickListener() { // from class: kk3.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        MeetingScreenCaptureFloatView.Companion.i(topActivity, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: kk3.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        MeetingScreenCaptureFloatView.Companion.j(dialogInterface, i3);
                    }
                }).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(Activity activity, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            a.b(activity);
        }

        public final void e() {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: kk3.d
                @Override // java.lang.Runnable
                public final void run() {
                    MeetingScreenCaptureFloatView.Companion.f();
                }
            });
        }

        public final void g(final Runnable next) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: kk3.e
                @Override // java.lang.Runnable
                public final void run() {
                    MeetingScreenCaptureFloatView.Companion.h(next);
                }
            });
        }

        public final void k() {
            ViewUtils.getScreenWidth();
            FloatingScreenParams build = new FloatingScreenParams.FloatingBuilder().setShapeType(2).setCanMove(true).setCanZoom(false).setShapeType(4).setFloatingCenter(MeetingScreenCaptureFloatView.f335222m, MeetingScreenCaptureFloatView.C).setCustomSize(MeetingScreenCaptureFloatView.f335219f, MeetingScreenCaptureFloatView.f335220h).setRoundCorner(MeetingScreenCaptureFloatView.f335221i).build();
            IQQFloatingWindow iQQFloatingWindow = (IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class);
            BaseApplication context = BaseApplication.getContext();
            MeetingScreenCaptureFloatView meetingScreenCaptureFloatView = MeetingScreenCaptureFloatView.f335218e;
            h.Companion companion = h.INSTANCE;
            iQQFloatingWindow.enterCustomFloatingScreen(context, meetingScreenCaptureFloatView, build, companion.a(), 59);
            ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(companion.a(), new C9194a());
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(DialogInterface dialogInterface, int i3) {
        }
    }

    static {
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        f335218e = new MeetingScreenCaptureFloatView(context, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        int dip2px = ViewUtils.dip2px(10.0f);
        f335219f = dip2px;
        f335220h = ViewUtils.dip2px(10.0f);
        f335221i = dip2px;
        u.Companion companion = u.INSTANCE;
        f335222m = (int) (((companion.c(BaseApplication.getContext()) / 2) - (dip2px / 2)) - i.c(14));
        C = ((companion.b(BaseApplication.getContext()) / 2) - (r0 / 2)) - 214;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MeetingScreenCaptureFloatView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ((b) vb3.a.f441346a.a(b.class)).y0();
    }

    public /* synthetic */ MeetingScreenCaptureFloatView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeetingScreenCaptureFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundColor(SupportMenu.CATEGORY_MASK);
    }
}
