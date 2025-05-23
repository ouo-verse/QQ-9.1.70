package com.tencent.mobileqq.vas.nt;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.t;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.nt.ZPlanCoupleAIOBackgroundContainer;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.zplan.utils.ax;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.b;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import hd0.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001<B\u000f\u0012\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u001a\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0014J\b\u0010\u0019\u001a\u00020\u0005H\u0014J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0010H\u0014J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016R\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010$R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/vas/nt/ZPlanCoupleAIOBackgroundContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/qqnt/aio/api/b;", "", "newTranslationY", "", h.F, "c", "d", "Landroid/graphics/drawable/Drawable;", "backgroundDrawable", "", "uin", "g", "b", "f", "", "type", "curFriendUid", "uinType", "", "needImmersive", "setInfo", "backgroundResume", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/qqnt/aio/api/b$c;", "listener", "setOnBackgroundChangedListener", "Landroid/content/res/ColorStateList;", "getBgTextColor", "visibility", "onWindowVisibilityChanged", "height", "notifyInputHeightChange", "notifyBackgourndUpdate", "Ljava/lang/String;", "friendUid", "e", "I", "Lcom/tencent/mobileqq/activity/aio/t;", "Lcom/tencent/mobileqq/activity/aio/t;", "chatBackground", "Lcom/tencent/qqnt/aio/api/b$c;", "onBackgroundChangedListener", "Lcom/tencent/mobileqq/vas/nt/ZPlanAIOBackgroundImageView;", "i", "Lcom/tencent/mobileqq/vas/nt/ZPlanAIOBackgroundImageView;", "aioBackgroundImageView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Drawable;", "backgroundImageDrawable", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "initPanelHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ZPlanCoupleAIOBackgroundContainer extends RelativeLayout implements b {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private float initPanelHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String friendUid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int uinType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t chatBackground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b.c onBackgroundChangedListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ZPlanAIOBackgroundImageView aioBackgroundImageView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable backgroundImageDrawable;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/nt/ZPlanCoupleAIOBackgroundContainer$a;", "", "Landroid/content/Context;", "context", "", "a", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.nt.ZPlanCoupleAIOBackgroundContainer$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(@Nullable Context context) {
            boolean contains$default;
            boolean contains$default2;
            boolean contains$default3;
            boolean contains$default4;
            int instantScreenHeight = ScreenUtil.getInstantScreenHeight(context);
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            boolean z16 = false;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI, false, 2, (Object) null);
            if (contains$default) {
                String MODEL = DeviceInfoMonitor.getModel();
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "MIX 2S", false, 2, (Object) null);
                if (!contains$default2) {
                    String MODEL2 = DeviceInfoMonitor.getModel();
                    Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                    contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "MI 8", false, 2, (Object) null);
                    if (!contains$default3) {
                        String MODEL3 = DeviceInfoMonitor.getModel();
                        Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                        contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "MIX 2", false, 2, (Object) null);
                        if (!contains$default4) {
                            return instantScreenHeight;
                        }
                    }
                }
                if (Settings.Global.getInt(BaseApplication.getContext().getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                    z16 = true;
                }
                if (z16) {
                    c.a("Q.qqstory.UIViewUtils", "find global screen in Xiaomi");
                    return ScreenUtil.getRealHeight(BaseApplication.getContext());
                }
                return instantScreenHeight;
            }
            return instantScreenHeight;
        }

        public final int b() {
            return ax.f335802a.a();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanCoupleAIOBackgroundContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.friendUid = "";
        this.uinType = -1;
    }

    private final void b() {
        Drawable drawable = this.backgroundImageDrawable;
        boolean z16 = true;
        if (drawable == null) {
            QLog.e("ZPlanCoupleAIOBackgroundContainer", 1, "addImageView failed, currBgDrawable invalid.");
            return;
        }
        QLog.i("ZPlanCoupleAIOBackgroundContainer", 1, "addImageView, initPanelHeight: " + this.initPanelHeight);
        ZPlanAIOBackgroundImageView zPlanAIOBackgroundImageView = this.aioBackgroundImageView;
        if (zPlanAIOBackgroundImageView != null) {
            float f16 = this.initPanelHeight;
            if (f16 != 0.0f) {
                z16 = false;
            }
            if (!z16) {
                this.initPanelHeight = 0.0f;
                h(f16);
            }
            zPlanAIOBackgroundImageView.setImageDrawable(drawable);
            return;
        }
        f(drawable);
    }

    private final void c() {
        if (this.chatBackground == null) {
            QLog.d("ZPlanCoupleAIOBackgroundContainer", 1, "background CREATE " + this);
            setBackgroundResource(R.drawable.qui_msg_list_bg);
            this.chatBackground = new t();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0068, code lost:
    
        if (r1 == true) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d() {
        boolean z16;
        String str;
        boolean contains$default;
        int i3 = this.uinType;
        boolean z17 = true;
        if (i3 == 0) {
            final String uin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(this.friendUid);
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            if (uin.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.e("ZPlanCoupleAIOBackgroundContainer", 1, "fetchAndSetBackgroundImg failed, uin empty.");
                return;
            }
            boolean c16 = t.c(getContext(), VasUtil.getCurrentUin(), uin, this.uinType, true, 5, this.chatBackground);
            QLog.i("ZPlanCoupleAIOBackgroundContainer", 1, "fetchAndSetBackgroundImg, background changed: " + c16);
            t tVar = this.chatBackground;
            if (tVar != null && (str = tVar.f179994a) != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "47967", false, 2, (Object) null);
            }
            z17 = false;
            if (!z17 && c16) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: d23.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanCoupleAIOBackgroundContainer.e(ZPlanCoupleAIOBackgroundContainer.this, uin);
                    }
                });
                return;
            }
            return;
        }
        QLog.i("ZPlanCoupleAIOBackgroundContainer", 1, "uinType invalid: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ZPlanCoupleAIOBackgroundContainer this$0, String uin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        t tVar = this$0.chatBackground;
        if (tVar != null) {
            Drawable drawable = tVar.f179996c;
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            this$0.g(drawable, uin);
            b.c cVar = this$0.onBackgroundChangedListener;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    private final void f(Drawable backgroundDrawable) {
        boolean z16;
        QLog.i("ZPlanCoupleAIOBackgroundContainer", 1, "initBgImageView, container, initPanelHeight: " + this.initPanelHeight);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.aioBackgroundImageView = new ZPlanAIOBackgroundImageView(context, null, 0, 6, null);
        float f16 = this.initPanelHeight;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.initPanelHeight = 0.0f;
            h(f16);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        layoutParams.addRule(10);
        addView(this.aioBackgroundImageView, layoutParams);
        try {
            ZPlanAIOBackgroundImageView zPlanAIOBackgroundImageView = this.aioBackgroundImageView;
            if (zPlanAIOBackgroundImageView != null) {
                zPlanAIOBackgroundImageView.setImageDrawable(backgroundDrawable);
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanCoupleAIOBackgroundContainer", 1, "addImageView failed.", th5);
        }
    }

    private final void g(Drawable backgroundDrawable, String uin) {
        if (backgroundDrawable == null) {
            QLog.e("ZPlanCoupleAIOBackgroundContainer", 1, "updateAIOBackground failed, backgroundDrawable null.");
            return;
        }
        QLog.i("ZPlanCoupleAIOBackgroundContainer", 1, "updateAIOBackground");
        this.backgroundImageDrawable = backgroundDrawable;
        b();
    }

    private final void h(float newTranslationY) {
        if (this.aioBackgroundImageView == null) {
            QLog.i("ZPlanCoupleAIOBackgroundContainer", 1, "updateImageViewTranslationY, aioBackgroundImageView null, newY: " + newTranslationY);
            this.initPanelHeight = newTranslationY;
            return;
        }
        QLog.i("ZPlanCoupleAIOBackgroundContainer", 1, "updateImageViewTranslationY, newY: " + newTranslationY);
        this.initPanelHeight = 0.0f;
        ZPlanAIOBackgroundImageView zPlanAIOBackgroundImageView = this.aioBackgroundImageView;
        if (zPlanAIOBackgroundImageView != null) {
            zPlanAIOBackgroundImageView.a(-newTranslationY);
        }
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void backgroundPause() {
        b.C9449b.a(this);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void backgroundResume() {
        QLog.d("ZPlanCoupleAIOBackgroundContainer", 1, "background RESUME " + this);
        d();
    }

    @Override // com.tencent.qqnt.aio.api.b
    @Nullable
    public ColorStateList getBgTextColor() {
        t tVar = this.chatBackground;
        if (tVar != null) {
            return tVar.f179995b;
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void notifyBackgourndUpdate() {
        QLog.i("ZPlanCoupleAIOBackgroundContainer", 1, "notifyBackgourndUpdate");
        c();
        backgroundResume();
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void notifyInputHeightChange(int height) {
        QLog.i("ZPlanCoupleAIOBackgroundContainer", 1, "notifyInputHeightChange, height: " + height);
        if (height >= 0) {
            h(height);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.d("ZPlanCoupleAIOBackgroundContainer", 1, "background DESTROY " + this);
        removeAllViews();
        this.chatBackground = null;
        this.onBackgroundChangedListener = null;
        this.aioBackgroundImageView = null;
        this.backgroundImageDrawable = null;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            backgroundResume();
        } else {
            backgroundPause();
        }
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setAdapterNavigationBarImmersive(boolean z16) {
        b.C9449b.f(this, z16);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setInfo(@NotNull String curFriendUid, int uinType, boolean needImmersive) {
        Intrinsics.checkNotNullParameter(curFriendUid, "curFriendUid");
        this.friendUid = curFriendUid;
        this.uinType = uinType;
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setOnBackgroundChangedListener(@NotNull b.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onBackgroundChangedListener = listener;
    }

    @Override // com.tencent.qqnt.aio.api.b
    public int type() {
        return 2;
    }
}
