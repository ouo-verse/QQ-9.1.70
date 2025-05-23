package com.tencent.mobileqq.aio.animation.animator;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.aio.animation.data.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.util.VersionUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001VB\u001f\u0012\u0006\u0010O\u001a\u00020\u0002\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010S\u001a\u00020R\u00a2\u0006\u0004\bT\u0010UJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\u0010\u0007\u001a\u00020\u0005\"\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J!\u0010\u0010\u001a\u00020\b2\u0010\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\rH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0003\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J0\u0010 \u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\u0006\u0010!\u001a\u00020\u0016J'\u0010\"\u001a\u00020\u00142\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\r\"\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\"\u0010#J\u000e\u0010\u0004\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014J\b\u0010%\u001a\u00020\bH\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010.\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00104R\u0016\u0010@\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00104R\u0016\u0010A\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010.R\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010.R\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010.R\"\u0010G\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010.\u001a\u0004\bE\u0010:\"\u0004\bF\u0010<R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010.R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010.\u001a\u0004\bH\u0010:\"\u0004\bI\u0010<R\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010!R\u0016\u0010L\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010!R\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010!R\u0014\u0010N\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010:\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/d;", "Lcom/tencent/mobileqq/aio/animation/f;", "", HippyTKDListViewAdapter.X, "y", "", "", "scale", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/graphics/Rect;", "itemRect", "r", "", "", "args", "B", "([Ljava/lang/Object;)V", "", "url", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "currentMsgSeq", "Lcom/tencent/mobileqq/aio/animation/data/a$a;", ReportConstant.COSTREPORT_PREFIX, "message", "changed", "left", "top", "right", "bottom", "f", UserInfo.SEX_FEMALE, DomainData.DOMAIN_NAME, "([Ljava/lang/Object;)Z", "relayout", "o", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "img", "Landroid/view/View;", "g", "Landroid/view/View;", "animView", tl.h.F, "I", "step", "i", "Z", "running", "j", "J", "jumpFromMsgSeq", "k", "jumpToMsgSeq", "l", "t", "()I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)V", "businessId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "animStart", "bounceTime", "dx", "p", "dy", "x0", "w", "E", "y0", "v", "D", "u", "vx0", "vy0", "refVelocity", "titleBarHeight", "type", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/aio/animation/data/a;", "listview", "<init>", "(ILcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;Lcom/tencent/mobileqq/aio/animation/data/a;)V", "a", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d extends com.tencent.mobileqq.aio.animation.f {
    static IPatchRedirector $redirector_;
    private static final float A;
    private static final float B;
    private static final float C;
    private static final int D;
    private static boolean E;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: y, reason: collision with root package name */
    private static final int f187834y;

    /* renamed from: z, reason: collision with root package name */
    private static final float f187835z;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable img;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View animView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int step;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean running;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long jumpFromMsgSeq;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long jumpToMsgSeq;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int businessId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long animStart;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long bounceTime;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int dx;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int dy;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int x0;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int y0;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int x;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private int y;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private float vx0;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private float vy0;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private float refVelocity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/d$a;", "", "", "BOUNCE_DISTANCE_X", UserInfo.SEX_FEMALE, "", "BOUNCE_DURATION", "I", "BOUNCE_VELOCITY_X", "BUBBLE_PADDING_TOP", "JUMPING_DELAY", "", "OUTPUT_DEBUG_LOG", "Z", "STEP_JUMPING", "STEP_JUMP_IN", "STEP_JUMP_OUT", "STEP_WAITING_JUMPING", "STEP_WAITING_JUMP_IN", "", "TAG", "Ljava/lang/String;", "density", "g", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.animator.d$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29241);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        INSTANCE = new Companion(null);
        f187834y = e.f187854a.a().length * 10;
        float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        f187835z = f16;
        A = 39.772724f * f16;
        B = 17.5f * f16;
        C = 3000 * f16;
        D = (int) (8 * f16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i3, @NotNull AIOAnimationContainer container, @NotNull com.tencent.mobileqq.aio.animation.data.a listview) {
        super(i3, container, listview);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listview, "listview");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), container, listview);
            return;
        }
        this.running = true;
        this.businessId = -1;
        this.refVelocity = 750 * f187835z;
    }

    private final void B(Object[] args) {
        if (args.length >= 5) {
            Object obj = args[3];
            if ((obj instanceof com.tencent.mobileqq.aio.animation.config.a) && (args[4] instanceof com.tencent.mobileqq.aio.animation.data.b)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.config.AioAnimationRule");
                final com.tencent.mobileqq.aio.animation.config.a aVar = (com.tencent.mobileqq.aio.animation.config.a) obj;
                if (!q(aVar.l())) {
                    return;
                }
                Object obj2 = args[4];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.data.AIOMsg");
                if (QLog.isColorLevel()) {
                    QLog.d("FloorJumper", 2, "set jump url, url = " + aVar.l());
                }
                View view = this.animView;
                Intrinsics.checkNotNull(view);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.animation.animator.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        d.C(d.this, aVar, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(d this$0, com.tencent.mobileqq.aio.animation.config.a rule, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class);
        View view2 = this$0.animView;
        Intrinsics.checkNotNull(view2);
        Context context = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "animView!!.context");
        String l3 = rule.l();
        Intrinsics.checkNotNull(l3);
        iAIOJumpAction.openBrowser(context, l3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean q(String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        Intrinsics.checkNotNull(url);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https", false, 2, null);
            if (!startsWith$default2) {
                return false;
            }
        }
        return true;
    }

    private final int r(int x16, Rect itemRect) {
        float random;
        double random2;
        int i3 = itemRect.left;
        int i16 = itemRect.right;
        if (x16 <= i3) {
            if (i16 - B < i3) {
                return i3;
            }
            random2 = (Math.random() * ((i16 - i3) - r1)) + i3;
        } else if (x16 >= i16) {
            if (i3 + B < i16) {
                return i16;
            }
            random2 = r7 + r1 + (Math.random() * ((i16 - i3) - r1));
        } else {
            float f16 = x16 - i3;
            float f17 = B;
            if (f16 > f17 || i16 - x16 > f17) {
                if (f16 > f17 && i16 - x16 > f17) {
                    return (int) (i3 + f17 + ((int) (Math.random() * (((i16 - i3) - f17) - f17))));
                }
                if (f16 > f17) {
                    random = x16 - ((int) (Math.random() * (f16 - f17)));
                } else {
                    random = x16 + ((int) (Math.random() * ((i16 - x16) - f17)));
                }
                return (int) random;
            }
            return x16;
        }
        return (int) random2;
    }

    private final a.C7235a s(long currentMsgSeq) {
        boolean z16;
        List<a.C7235a> j06 = c().j0();
        Object obj = null;
        if (j06.isEmpty()) {
            return null;
        }
        int i3 = 0;
        if (currentMsgSeq == 0) {
            Iterator<T> it = j06.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                a.C7235a c7235a = (a.C7235a) next;
                if (c7235a.c() && c7235a.b().top > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            return (a.C7235a) obj;
        }
        for (Object obj2 : j06) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((a.C7235a) obj2).a() == currentMsgSeq) {
                if (i3 >= j06.size() - 1) {
                    return null;
                }
                return j06.get(i16);
            }
            i3 = i16;
        }
        return null;
    }

    private final int u() {
        return b().l();
    }

    private final void x(String message) {
        if (E) {
            QLog.i("FloorJumper", 1, message);
        }
    }

    private final void z(int x16, int y16, float... scale) {
        boolean z16;
        View view = this.animView;
        Intrinsics.checkNotNull(view);
        int left = view.getLeft();
        View view2 = this.animView;
        Intrinsics.checkNotNull(view2);
        int width = left + (view2.getWidth() / 2);
        View view3 = this.animView;
        Intrinsics.checkNotNull(view3);
        int bottom = view3.getBottom();
        View view4 = this.animView;
        Intrinsics.checkNotNull(view4);
        view4.offsetTopAndBottom(y16 - bottom);
        View view5 = this.animView;
        Intrinsics.checkNotNull(view5);
        view5.offsetLeftAndRight(x16 - width);
        if (VersionUtils.isHoneycomb()) {
            if (scale.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                View view6 = this.animView;
                Intrinsics.checkNotNull(view6);
                view6.setScaleY(scale[0]);
                View view7 = this.animView;
                Intrinsics.checkNotNull(view7);
                view7.setScaleX(2 - scale[0]);
                return;
            }
            View view8 = this.animView;
            Intrinsics.checkNotNull(view8);
            view8.setScaleY(1.0f);
            View view9 = this.animView;
            Intrinsics.checkNotNull(view9);
            view9.setScaleX(1.0f);
        }
    }

    public final void A(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.businessId = i3;
        }
    }

    public final void D(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.y = i3;
        }
    }

    public final void E(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.y0 = i3;
        }
    }

    public final long F() {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        if (!this.running) {
            return -1L;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i3 = this.step;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return -1L;
                        }
                        float f17 = ((float) (currentAnimationTimeMillis - this.animStart)) / 1000.0f;
                        float f18 = this.vy0;
                        float f19 = C;
                        int i16 = (int) ((f18 * f17) + (((f19 * f17) * f17) / 2));
                        int i17 = (int) (this.vx0 * f17);
                        float min = ((Math.min(this.refVelocity, Math.abs(f18 + (f19 * f17))) / this.refVelocity) * 0.25f) + 0.9f;
                        int i18 = this.y0 + i16;
                        this.y = i18;
                        this.x = this.x0 + i17;
                        int height = b().getHeight();
                        View view = this.animView;
                        Intrinsics.checkNotNull(view);
                        if (i18 <= height + view.getHeight()) {
                            int i19 = this.x;
                            View view2 = this.animView;
                            Intrinsics.checkNotNull(view2);
                            if (i19 >= (-view2.getWidth()) / 2) {
                                int i26 = this.x;
                                int width = b().getWidth();
                                View view3 = this.animView;
                                Intrinsics.checkNotNull(view3);
                                if (i26 <= width + (view3.getWidth() / 2)) {
                                    x("step " + this.step + ", jump out, pos0=" + this.x0 + "," + this.y0 + " pos=" + this.x + "," + this.y + " vy0=" + this.vy0 + " sy=" + i16);
                                    z(this.x, this.y, min);
                                    return FloorJumperSet.INSTANCE.a();
                                }
                            }
                        }
                        View view4 = this.animView;
                        Intrinsics.checkNotNull(view4);
                        z(0, view4.getWidth(), new float[0]);
                        o();
                        return -1L;
                    }
                }
            }
            long j3 = this.bounceTime;
            if (j3 == 0) {
                float f26 = ((float) (currentAnimationTimeMillis - this.animStart)) / 1000.0f;
                float f27 = this.vy0;
                float f28 = C;
                int i27 = (int) ((f27 * f26) + (((f28 * f26) * f26) / 2));
                int i28 = (int) (this.vx0 * f26);
                float min2 = ((Math.min(this.refVelocity, Math.abs(f27 + (f28 * f26))) / this.refVelocity) * 0.25f) + 0.9f;
                int i29 = this.dy;
                if (i27 > i29) {
                    this.bounceTime = currentAnimationTimeMillis;
                    i27 = i29;
                    f16 = 1.0f;
                } else {
                    f16 = min2;
                }
                int i36 = this.y0;
                int i37 = i36 + i27;
                this.y = i37;
                int i38 = this.x0;
                int i39 = i28 + i38;
                this.x = i39;
                x("step " + this.step + ", falling down, pos0=" + i38 + "," + i36 + " pos=" + i39 + "," + i37 + " vy0=" + this.vy0 + " sy=" + i27);
                z(this.x, this.y, f16);
                return FloorJumperSet.INSTANCE.a();
            }
            if (currentAnimationTimeMillis - j3 <= f187834y) {
                float f29 = ((float) (currentAnimationTimeMillis - j3)) / 1000.0f;
                int round = Math.round(((float) (currentAnimationTimeMillis - j3)) / 10.0f);
                e eVar = e.f187854a;
                if (round >= eVar.a().length) {
                    round = eVar.a().length - 1;
                }
                float f36 = this.vx0;
                float f37 = A;
                float max = (int) (Math.max(Math.min(f36, f37), -f37) * f29);
                float f38 = eVar.a()[round] * f187835z;
                float f39 = eVar.b()[round];
                int i46 = this.x0;
                int i47 = (int) (this.dx + i46 + max);
                this.x = i47;
                int i48 = this.y0;
                int i49 = (int) ((this.dy + i48) - f38);
                this.y = i49;
                x("step " + this.step + ", bouncing, pos0=" + i46 + "," + i48 + " pos=" + i47 + "," + i49 + " vy0=" + this.vy0 + " sy=" + f38);
                z(this.x, this.y, f39);
                return FloorJumperSet.INSTANCE.a();
            }
            int i56 = this.y0 + this.dy;
            this.y = i56;
            z(this.x, i56, new float[0]);
            long random = (int) ((500 + (Math.random() * 800)) - 400);
            this.animStart = AnimationUtils.currentAnimationTimeMillis() + random;
            this.step = 3;
            x("step 3, rest a while, pos0=" + this.x0 + "," + this.y0 + " pos=" + this.x + "," + this.y + " vy0=" + this.vy0);
            return random;
        }
        long j16 = this.animStart;
        if (currentAnimationTimeMillis < j16) {
            return j16 - currentAnimationTimeMillis;
        }
        if (i3 == 1) {
            this.animStart = currentAnimationTimeMillis;
            a.C7235a s16 = s(0L);
            if (s16 != null) {
                this.step = 2;
                this.jumpFromMsgSeq = 0L;
                this.jumpToMsgSeq = s16.a();
                this.bounceTime = 0L;
                Rect b16 = s16.b();
                this.dx = 0;
                this.dy = (b16.top + D) - u();
                this.x0 = r((b16.left + b16.right) / 2, b16);
                this.y0 = 0;
                this.vx0 = 0.0f;
                float random2 = (float) (500 * f187835z * Math.random());
                this.vy0 = random2;
                this.y = 0;
                this.x = 0;
                x("step " + this.step + ", jump in, pos0=" + this.x0 + "," + this.y0 + " pos=0,0 vy0=" + random2 + " dy=" + this.dy);
                return 0L;
            }
            this.step = 5;
            this.x0 = (c().getWidth() / 2) + ((int) (((Math.random() * 160) * f187835z) - 80));
            this.y0 = this.y;
            this.bounceTime = 0L;
            this.jumpFromMsgSeq = 0L;
            this.jumpToMsgSeq = 0L;
            this.dx = 0;
            this.dy = 0;
            this.vx0 = 0.0f;
            float random3 = (float) (500 * r4 * Math.random());
            this.vy0 = random3;
            x("step " + this.step + ", jump out, pos0=" + this.x0 + "," + this.y0 + " pos=" + this.x + "," + this.y + " vy0=" + random3);
            return 0L;
        }
        a.C7235a s17 = s(this.jumpToMsgSeq);
        if (s17 != null) {
            this.x0 = this.x;
            this.y0 = this.y;
            this.step = 4;
            this.animStart = currentAnimationTimeMillis;
            this.bounceTime = 0L;
            this.jumpFromMsgSeq = this.jumpToMsgSeq;
            this.jumpToMsgSeq = s17.a();
            Rect b17 = s17.b();
            this.vy0 = (-((float) (750.0f + ((Math.random() - 1.0f) * 300.0f)))) * f187835z;
            this.dy = ((b17.top + D) - this.y0) - u();
            float f46 = this.vy0;
            float f47 = C;
            double sqrt = Math.sqrt((f46 * f46) + (2 * f47 * Math.abs(r2)));
            double d16 = (sqrt - this.vy0) / f47;
            int r16 = r(this.x, b17);
            int i57 = this.x;
            int i58 = r16 - i57;
            this.dx = i58;
            this.vx0 = (float) (i58 / d16);
            x("step=" + this.step + ", jump to next, pos0=" + this.x0 + "," + this.y0 + " pos=" + i57 + "," + this.y + " vy0=" + this.vy0 + " vyt=" + sqrt + " dy=" + this.dy + " rect=" + b17);
            return 0L;
        }
        this.x0 = this.x;
        this.y0 = this.y;
        this.step = 5;
        this.animStart = currentAnimationTimeMillis;
        this.bounceTime = 0L;
        this.jumpFromMsgSeq = this.jumpToMsgSeq;
        this.jumpToMsgSeq = 0L;
        this.dx = 0;
        this.dy = 0;
        this.vx0 = (float) ((Math.random() * 400) - 100);
        float f48 = (-((float) (750.0f + ((Math.random() - 1.0f) * 300.0f)))) * f187835z;
        this.vy0 = f48;
        x("step=" + this.step + ", jump out, pos0=" + this.x0 + "," + this.y0 + " pos=" + this.x + "," + this.y + " vy0=" + f48);
        return 0L;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean f(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom))).booleanValue();
        }
        if (!this.running) {
            return false;
        }
        return y(true);
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean n(@NotNull Object... args) {
        int i3;
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        View view = this.animView;
        if (view == null) {
            Object obj = args[0];
            String str = null;
            if (obj instanceof Drawable) {
                drawable = (Drawable) obj;
            } else {
                drawable = null;
            }
            this.img = drawable;
            if (drawable == null) {
                if (obj != null) {
                    str = obj.getClass().getName();
                }
                QLog.i("FloorJumper", 1, "[start] arg 0 is not drawable, type=" + str);
                return false;
            }
            Intrinsics.checkNotNull(drawable);
            Rect bounds = drawable.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "img!!.bounds");
            View view2 = new View(c().getContext());
            this.animView = view2;
            Intrinsics.checkNotNull(view2);
            view2.setBackgroundDrawable(this.img);
            AIOAnimationContainer b16 = b();
            View view3 = this.animView;
            Intrinsics.checkNotNull(view3);
            b16.addViewInLayout(view3, -1, AIOAnimationContainer.INSTANCE.a(), false);
            if (bounds.isEmpty()) {
                View view4 = this.animView;
                Intrinsics.checkNotNull(view4);
                Drawable drawable2 = this.img;
                Intrinsics.checkNotNull(drawable2);
                int i16 = -drawable2.getIntrinsicWidth();
                Drawable drawable3 = this.img;
                Intrinsics.checkNotNull(drawable3);
                view4.layout(i16, -drawable3.getIntrinsicHeight(), 0, 0);
            } else {
                View view5 = this.animView;
                Intrinsics.checkNotNull(view5);
                view5.layout(-bounds.width(), -bounds.height(), 0, 0);
            }
            if (VersionUtils.isHoneycomb()) {
                View view6 = this.animView;
                Intrinsics.checkNotNull(view6);
                Intrinsics.checkNotNull(this.animView);
                view6.setPivotX(r4.getWidth() / 2);
                View view7 = this.animView;
                Intrinsics.checkNotNull(view7);
                Intrinsics.checkNotNull(this.animView);
                view7.setPivotY(r4.getHeight());
                View view8 = this.animView;
                Intrinsics.checkNotNull(view8);
                view8.setLayerType(2, null);
            }
        } else {
            Intrinsics.checkNotNull(view);
            View view9 = this.animView;
            Intrinsics.checkNotNull(view9);
            view.offsetLeftAndRight(-view9.getRight());
            View view10 = this.animView;
            Intrinsics.checkNotNull(view10);
            View view11 = this.animView;
            Intrinsics.checkNotNull(view11);
            view10.offsetTopAndBottom(-view11.getBottom());
        }
        this.step = 2;
        this.running = true;
        if (args.length > 1) {
            i3 = args[1];
        } else {
            i3 = 0;
        }
        Intrinsics.checkNotNull(i3, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) i3).intValue();
        if (QLog.isColorLevel()) {
            QLog.d("eggs", 2, "start floor jumper. delay: " + intValue);
        }
        this.animStart = AnimationUtils.currentAnimationTimeMillis() + intValue;
        this.step = 1;
        B(args);
        return true;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.running = false;
        b().removeViewInLayout(this.animView);
        this.img = null;
        this.animView = null;
    }

    public final int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.businessId;
    }

    public final int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.y;
    }

    public final int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.y0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x0318, code lost:
    
        if (r1 > ((com.tencent.mobileqq.aio.animation.data.a.C7235a) r3).a()) goto L127;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0253  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean y(boolean relayout) {
        List<a.C7235a> list;
        Object first;
        Object last;
        Object first2;
        Object last2;
        Object obj;
        boolean z16;
        Object first3;
        Object first4;
        Object first5;
        int lastIndex;
        Object last3;
        Object obj2;
        boolean z17;
        Object last4;
        Object obj3;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, relayout)).booleanValue();
        }
        List<a.C7235a> j06 = c().j0();
        if (j06.isEmpty()) {
            return false;
        }
        if (!this.running) {
            o();
            return false;
        }
        if (relayout) {
            int i3 = this.step;
            if (i3 != 1 && i3 != 2 && i3 != 3) {
                if (i3 == 4) {
                    long j3 = this.jumpToMsgSeq;
                    long j16 = this.jumpFromMsgSeq;
                    first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) j06);
                    if (j3 >= ((a.C7235a) first3).a()) {
                        last4 = CollectionsKt___CollectionsKt.last((List<? extends Object>) j06);
                        if (j3 <= ((a.C7235a) last4).a()) {
                            Iterator<T> it = j06.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj3 = it.next();
                                    if (((a.C7235a) obj3).a() == j3) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (z18) {
                                        break;
                                    }
                                } else {
                                    obj3 = null;
                                    break;
                                }
                            }
                            a.C7235a c7235a = (a.C7235a) obj3;
                            if (c7235a != null) {
                                int u16 = (c7235a.b().top + D) - u();
                                int i16 = this.y0;
                                int i17 = u16 - (this.dy + i16);
                                if (i17 != 0) {
                                    this.y0 = i16 + i17;
                                    this.y += i17;
                                    View view = this.animView;
                                    Intrinsics.checkNotNull(view);
                                    view.offsetTopAndBottom(i17);
                                }
                                x("step " + this.step + ", jump to next, newY, x=" + this.x + " y=" + this.y + " newY:" + u16);
                            } else {
                                o();
                                return false;
                            }
                        }
                    }
                    first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) j06);
                    if (j16 >= ((a.C7235a) first4).a()) {
                        last3 = CollectionsKt___CollectionsKt.last((List<? extends Object>) j06);
                        if (j16 <= ((a.C7235a) last3).a()) {
                            Iterator<T> it5 = j06.iterator();
                            while (true) {
                                if (it5.hasNext()) {
                                    obj2 = it5.next();
                                    if (((a.C7235a) obj2).a() == j16) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    if (z17) {
                                        break;
                                    }
                                } else {
                                    obj2 = null;
                                    break;
                                }
                            }
                            a.C7235a c7235a2 = (a.C7235a) obj2;
                            if (c7235a2 != null) {
                                int u17 = (c7235a2.b().top + D) - u();
                                int i18 = this.y0;
                                int i19 = u17 - (this.dy + i18);
                                if (i19 != 0) {
                                    this.y0 = i18 + i19;
                                    this.y += i19;
                                    View view2 = this.animView;
                                    Intrinsics.checkNotNull(view2);
                                    view2.offsetTopAndBottom(i19);
                                }
                            } else {
                                o();
                                return false;
                            }
                        }
                    }
                    first5 = CollectionsKt___CollectionsKt.first((List<? extends Object>) j06);
                    if (j3 >= ((a.C7235a) first5).a()) {
                        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(j06);
                        if (j16 > lastIndex) {
                            this.step = 5;
                            this.jumpFromMsgSeq = 0L;
                            this.jumpToMsgSeq = 0L;
                        } else {
                            o();
                            return false;
                        }
                    } else {
                        this.y = -1;
                    }
                }
            } else {
                long j17 = this.jumpToMsgSeq;
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) j06);
                if (j17 < ((a.C7235a) first2).a()) {
                    this.y = -1;
                } else {
                    long j18 = this.jumpToMsgSeq;
                    last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) j06);
                    if (j18 > ((a.C7235a) last2).a()) {
                        if (this.bounceTime > 0) {
                            o();
                            return false;
                        }
                        this.step = 5;
                        this.jumpFromMsgSeq = 0L;
                        this.jumpToMsgSeq = 0L;
                    } else {
                        Iterator<T> it6 = j06.iterator();
                        while (true) {
                            if (it6.hasNext()) {
                                obj = it6.next();
                                list = j06;
                                if (((a.C7235a) obj).a() == this.jumpToMsgSeq) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (z16) {
                                    break;
                                }
                                j06 = list;
                            } else {
                                list = j06;
                                obj = null;
                                break;
                            }
                        }
                        a.C7235a c7235a3 = (a.C7235a) obj;
                        if (c7235a3 != null) {
                            int u18 = (c7235a3.b().top + D) - u();
                            x("step " + this.step + ", wait to jump, newY, x=" + this.x + " y=" + this.y + " newY:" + u18);
                            int i26 = this.y0;
                            int i27 = u18 - (this.dy + i26);
                            if (i27 != 0) {
                                this.y0 = i26 + i27;
                                this.y += i27;
                                View view3 = this.animView;
                                Intrinsics.checkNotNull(view3);
                                view3.offsetTopAndBottom(i27);
                            }
                            if (this.animView != null) {
                                this.running = false;
                                this.img = null;
                                this.animView = null;
                                return false;
                            }
                            int i28 = this.y;
                            int height = b().getHeight();
                            View view4 = this.animView;
                            Intrinsics.checkNotNull(view4);
                            if (i28 <= height + view4.getHeight()) {
                                int i29 = this.x;
                                View view5 = this.animView;
                                Intrinsics.checkNotNull(view5);
                                if (i29 >= (-view5.getWidth()) / 2) {
                                    int i36 = this.x;
                                    int width = b().getWidth();
                                    View view6 = this.animView;
                                    Intrinsics.checkNotNull(view6);
                                    if (i36 <= width + (view6.getWidth() / 2)) {
                                        int i37 = this.y;
                                        if (i37 <= 0) {
                                            int i38 = this.step;
                                            if (i38 != 2 && i38 != 3 && i38 != 4) {
                                                if (i38 == 5) {
                                                    x("step " + i38 + ", restart while jumping out");
                                                    n(new Object[0]);
                                                    z(this.x, this.y, new float[0]);
                                                }
                                            } else {
                                                x("step " + i38 + " restart while jumping, pos=" + this.x + "," + i37 + " jumpToSeq=" + this.jumpToMsgSeq);
                                                long j19 = this.jumpToMsgSeq;
                                                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                                                if (j19 >= ((a.C7235a) first).a()) {
                                                    long j26 = this.jumpToMsgSeq;
                                                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                                                }
                                                n(new Object[0]);
                                                z(this.x, this.y, new float[0]);
                                            }
                                        }
                                        return true;
                                    }
                                }
                            }
                            x("jump out of the screen, stop, pos=" + this.x + "," + this.y);
                            o();
                            return false;
                        }
                        o();
                        return false;
                    }
                }
            }
        }
        list = j06;
        if (this.animView != null) {
        }
    }
}
