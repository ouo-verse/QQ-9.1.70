package com.tencent.mobileqq.vas.nt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider;
import com.tencent.mobileqq.activity.aio.t;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.nt.AIOBackgroundContainer;
import com.tencent.mobileqq.vas.theme.ThemeVideoController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.AIODrawableUtils;
import com.tencent.qqnt.aio.api.b;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001@B\u0011\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0012H\u0014J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u0003H\u0014J\b\u0010$\u001a\u00020\u0003H\u0014J\u0006\u0010%\u001a\u00020\u0003R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010-R\u0016\u00100\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010/R\u0016\u00103\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00104R\u0016\u00108\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/vas/nt/AIOBackgroundContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/qqnt/aio/api/b;", "", "d", "e", "c", h.F, "Landroid/graphics/drawable/Drawable;", VasProfileTemplatePreloadHelper.BACKGROUND, "", "uin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", DomainData.DOMAIN_NAME, "g", "l", "", "type", "curFriendUid", "uinType", "needImmersive", "setInfo", "backgroundResume", "Landroid/content/res/ColorStateList;", "getBgTextColor", "Lcom/tencent/qqnt/aio/api/b$c;", "listener", "setOnBackgroundChangedListener", "backgroundPause", "visibility", "onWindowVisibilityChanged", "adapter", "setAdapterNavigationBarImmersive", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "f", "Lcom/tencent/mobileqq/activity/aio/t;", "Lcom/tencent/mobileqq/activity/aio/t;", "mChatBackground", "Lcom/tencent/mobileqq/activity/aio/helper/QEffectBgProvider;", "Lcom/tencent/mobileqq/activity/aio/helper/QEffectBgProvider;", "mQEffectBgProvider", "Landroid/view/View;", "Landroid/view/View;", "mMask", "Ljava/lang/String;", "mCurFriendUid", "i", "I", "mUinType", "Lcom/tencent/qqnt/aio/api/b$c;", "mOnBackgroundChangedListener", BdhLogUtil.LogTag.Tag_Conn, "Z", "mCurrentUseVideoPlayer", "D", "mNeedAdapterNavigationBarImmersive", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class AIOBackgroundContainer extends RelativeLayout implements b {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mCurrentUseVideoPlayer;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mNeedAdapterNavigationBarImmersive;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t mChatBackground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QEffectBgProvider mQEffectBgProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mMask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCurFriendUid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mUinType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b.c mOnBackgroundChangedListener;

    public AIOBackgroundContainer(@Nullable Context context) {
        super(context);
        this.mCurFriendUid = "";
        this.mUinType = -1;
        this.mNeedAdapterNavigationBarImmersive = true;
    }

    private final void c() {
        int i3;
        if (QQTheme.isVasTheme()) {
            i3 = R.drawable.skin_aio_panel_icon_bg;
        } else {
            i3 = R.drawable.qui_common_bg_nav_bottom_aio_bg;
        }
        com.tencent.mobileqq.qui.b.f276860a.g(this, getContext().getDrawable(i3));
    }

    private final void d() {
        if (QQTheme.isVasTheme() && this.mUinType == 1) {
            setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.skin_chat_background, null));
        } else {
            setBackgroundColor(getResources().getColor(R.color.qui_common_bg_aio_01));
        }
        this.mChatBackground = new t();
        this.mQEffectBgProvider = new QEffectBgProvider(null);
    }

    private final void e() {
        QEffectBgProvider qEffectBgProvider = this.mQEffectBgProvider;
        if (qEffectBgProvider != null) {
            qEffectBgProvider.c();
        }
        removeAllViews();
        this.mQEffectBgProvider = null;
        this.mChatBackground = null;
        this.mMask = null;
        this.mOnBackgroundChangedListener = null;
        if (VasNormalToggle.VAS_CHAT_BACKGROUND_RELEASE.isEnable(true)) {
            k();
        }
    }

    private final boolean g() {
        if (!(getContext() instanceof Activity)) {
            return false;
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Intent intent = ((Activity) context).getIntent();
        if (!intent.getBooleanExtra("key_is_forward_aio", false) && !intent.getBooleanExtra("key_is_scale_chat", false)) {
            return false;
        }
        return true;
    }

    private final void h() {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: d23.a
            @Override // java.lang.Runnable
            public final void run() {
                AIOBackgroundContainer.i(AIOBackgroundContainer.this);
            }
        }, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final AIOBackgroundContainer this$0) {
        final String uinFromUid;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mUinType == 1) {
            uinFromUid = this$0.mCurFriendUid;
        } else {
            uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(this$0.mCurFriendUid);
        }
        if (TextUtils.isEmpty(uinFromUid)) {
            QLog.i("AIOBackgroundContainer", 1, "convert uin is empty string, fail");
        }
        if (t.c(this$0.getContext(), VasUtil.getCurrentUin(), uinFromUid, this$0.mUinType, true, 7, this$0.mChatBackground)) {
            QLog.d("AIOBackgroundContainer", 1, "loadBackgroundAsync changed");
            this$0.post(new Runnable() { // from class: d23.b
                @Override // java.lang.Runnable
                public final void run() {
                    AIOBackgroundContainer.j(AIOBackgroundContainer.this, uinFromUid);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AIOBackgroundContainer this$0, String uin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        t tVar = this$0.mChatBackground;
        if (tVar != null) {
            Intrinsics.checkNotNull(tVar);
            Drawable drawable = tVar.f179996c;
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            this$0.m(drawable, uin);
            b.c cVar = this$0.mOnBackgroundChangedListener;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    private final void k() {
        if (ThemeUtil.useNativeThemeVideoPlayer() && VasToggle.BUG_108742548.isEnable(false) && this.mCurrentUseVideoPlayer) {
            QLog.d("AIOBackgroundContainer", 1, "releaseThemeBg");
            ThemeVideoController.getInstance().releaseAioBg();
        }
    }

    private final void l() {
        ViewParent parent;
        if (getContext() instanceof SplashActivity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.activity.SplashActivity");
            View findViewById = ((SplashActivity) context).findViewById(R.id.j0l);
            if (findViewById != null && (parent = findViewById.getParent()) != null) {
                ((ViewGroup) parent).removeView(findViewById);
            }
        }
        SetSplash.j();
    }

    private final void m(Drawable bg5, String uin) {
        if (bg5 == null) {
            return;
        }
        Activity activity = null;
        if (ThemeUtil.useNativeThemeVideoPlayer() && n()) {
            this.mCurrentUseVideoPlayer = true;
            if (ThemeUtil.isNowThemeIsSuperTheme()) {
                setBackgroundDrawable(null);
                if (VasNormalToggle.THEME_SUPER_BG_REMOVE_SPLASH.isEnable(true)) {
                    l();
                }
            }
            ThemeVideoController.getInstance().initAio(this);
            ThemeVideoController.getInstance().playAioAnimation();
        } else {
            QLog.d("AIOBackgroundContainer", 1, "updateAIOBackground view:" + this + " drawable:" + bg5);
            k();
            setBackgroundDrawable(bg5);
            this.mCurrentUseVideoPlayer = false;
        }
        QEffectBgProvider qEffectBgProvider = this.mQEffectBgProvider;
        if (qEffectBgProvider != null) {
            qEffectBgProvider.h(getContext(), ThemeUtil.getCreateAppRuntime(), bg5, uin, this);
        }
        f();
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity != null) {
            QUIImmersiveHelper.u(activity.getWindow(), true, true);
        }
    }

    private final boolean n() {
        t tVar = this.mChatBackground;
        if (tVar == null) {
            return true;
        }
        Intrinsics.checkNotNull(tVar);
        String str = tVar.f179994a;
        Intrinsics.checkNotNullExpressionValue(str, "mChatBackground!!.path");
        if (!(getContext() instanceof ChatActivity) && !(getContext() instanceof MultiForwardActivity) && !AppSetting.o(getContext()) && !g() && (TextUtils.isEmpty(str) || Intrinsics.areEqual("null", str) || Intrinsics.areEqual("none", str) || Intrinsics.areEqual(str, ThemeUtil.getAnimatePathByTag(3)))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void backgroundPause() {
        QEffectBgProvider qEffectBgProvider = this.mQEffectBgProvider;
        if (qEffectBgProvider != null) {
            qEffectBgProvider.f();
        }
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void backgroundResume() {
        h();
        QEffectBgProvider qEffectBgProvider = this.mQEffectBgProvider;
        if (qEffectBgProvider != null) {
            qEffectBgProvider.g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        boolean z16;
        View view;
        if (ThemeUtil.isInNightMode(null)) {
            t tVar = this.mChatBackground;
            if (tVar != null) {
                Intrinsics.checkNotNull(tVar);
                if (!Intrinsics.areEqual("", tVar.f179994a)) {
                    t tVar2 = this.mChatBackground;
                    Intrinsics.checkNotNull(tVar2);
                    if (!Intrinsics.areEqual("null", tVar2.f179994a)) {
                        z16 = false;
                        if (QLog.isColorLevel()) {
                            View view2 = this.mMask;
                            t tVar3 = this.mChatBackground;
                            Intrinsics.checkNotNull(tVar3);
                            QLog.d("AIOBackgroundContainer", 2, "#handleNightMask# : inNightMode, isDefaultBg=" + z16 + ",mMask=" + view2 + ", sessionInfo.chatBg.path=" + tVar3.f179994a);
                        }
                        if (this.mMask != null && QLog.isColorLevel()) {
                            view = this.mMask;
                            Intrinsics.checkNotNull(view);
                            if (view.getVisibility() != 0) {
                                QLog.d("AIOBackgroundContainer", 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
                            } else {
                                View view3 = this.mMask;
                                Intrinsics.checkNotNull(view3);
                                if (view3.getVisibility() == 4) {
                                    QLog.d("AIOBackgroundContainer", 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
                                } else {
                                    QLog.d("AIOBackgroundContainer", 2, "#handleNightMask# : mMask getVisibility = GONE");
                                }
                            }
                        }
                        if (z16) {
                            if (this.mMask == null) {
                                this.mMask = new View(getContext());
                            }
                            View view4 = this.mMask;
                            Intrinsics.checkNotNull(view4);
                            view4.setBackgroundColor(1996488704);
                            if (indexOfChild(this.mMask) == -1) {
                                addView(this.mMask, new ViewGroup.LayoutParams(-1, -1));
                                return;
                            }
                            return;
                        }
                        View view5 = this.mMask;
                        if (view5 != null) {
                            removeView(view5);
                            this.mMask = null;
                            return;
                        }
                        return;
                    }
                }
                z16 = true;
                if (QLog.isColorLevel()) {
                }
                if (this.mMask != null) {
                    view = this.mMask;
                    Intrinsics.checkNotNull(view);
                    if (view.getVisibility() != 0) {
                    }
                }
                if (z16) {
                }
            }
        } else {
            View view6 = this.mMask;
            if (view6 != null) {
                removeView(view6);
                this.mMask = null;
            }
        }
    }

    @Override // com.tencent.qqnt.aio.api.b
    @Nullable
    public ColorStateList getBgTextColor() {
        t tVar;
        ColorStateList colorStateList = getResources().getColorStateList(R.color.skin_chat_nick);
        if (VasNormalToggle.THEME_BG_TEXT_ENABLE.isEnable(true) && (tVar = this.mChatBackground) != null) {
            return tVar.f179995b;
        }
        return colorStateList;
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void notifyBackgourndUpdate() {
        b.C9449b.d(this);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void notifyInputHeightChange(int i3) {
        b.C9449b.e(this, i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((!AIODrawableUtils.b() || !QQTheme.isVasTheme()) && this.mNeedAdapterNavigationBarImmersive) {
            c();
        }
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
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
    public void setAdapterNavigationBarImmersive(boolean adapter) {
        this.mNeedAdapterNavigationBarImmersive = adapter;
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setInfo(@NotNull String curFriendUid, int uinType, boolean needImmersive) {
        Intrinsics.checkNotNullParameter(curFriendUid, "curFriendUid");
        this.mCurFriendUid = curFriendUid;
        this.mUinType = uinType;
        h();
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setOnBackgroundChangedListener(@NotNull b.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnBackgroundChangedListener = listener;
    }

    @Override // com.tencent.qqnt.aio.api.b
    public int type() {
        return 1;
    }
}
