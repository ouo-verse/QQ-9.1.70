package com.tencent.mobileqq.guild.background;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.background.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.t;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.background.GuildBackgroundContainer;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.IThemeEffectApi;
import com.tencent.mobileqq.vas.theme.api.IThemeVideoController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B\u0011\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000eH\u0014J\b\u0010\u001a\u001a\u00020\u0003H\u0014J\b\u0010\u001b\u001a\u00020\u0003H\u0014J\u0006\u0010\u001c\u001a\u00020\u0003R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010!R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010#R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010)\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/background/GuildBackgroundContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/guild/aio/background/d;", "", "c", "d", "f", "Landroid/graphics/drawable/Drawable;", VasProfileTemplatePreloadHelper.BACKGROUND, "", "uin", "i", "", "j", "", "type", "curFriendUid", "uinType", "setInfo", "backgroundResume", "Lcom/tencent/guild/aio/background/d$a;", "listener", "setOnBackgroundChangedListener", "backgroundPause", "visibility", "onWindowVisibilityChanged", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "e", "Lcom/tencent/mobileqq/activity/aio/t;", "Lcom/tencent/mobileqq/activity/aio/t;", "mChatBackground", "Landroid/view/View;", "Landroid/view/View;", "mMask", "Ljava/lang/String;", "mCurFriendUid", h.F, "I", "mUinType", "Lcom/tencent/mobileqq/vas/theme/api/IThemeVideoController;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeVideoController;", "mVideoPlayer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildBackgroundContainer extends RelativeLayout implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private t mChatBackground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mMask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mCurFriendUid;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mUinType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private IThemeVideoController mVideoPlayer;

    public GuildBackgroundContainer(Context context) {
        super(context);
        this.mCurFriendUid = "";
        this.mUinType = -1;
    }

    private final void c() {
        QLog.d("GuildBackgroundContainer", 1, "background CREATE " + this);
        if (QQTheme.isVasTheme()) {
            setBackgroundResource(R.drawable.skin_chat_background);
        } else {
            setBackgroundResource(R.drawable.qui_msg_list_bg);
        }
        this.mChatBackground = new t();
    }

    private final void d() {
        QLog.d("GuildBackgroundContainer", 1, "background DESTROY " + this);
        IThemeVideoController iThemeVideoController = this.mVideoPlayer;
        if (iThemeVideoController != null) {
            iThemeVideoController.release();
        }
        this.mVideoPlayer = null;
        removeAllViews();
        this.mChatBackground = null;
        this.mMask = null;
    }

    private final void f() {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: bf1.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildBackgroundContainer.g(GuildBackgroundContainer.this);
            }
        }, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final GuildBackgroundContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (TextUtils.isEmpty(this$0.mCurFriendUid)) {
            QLog.i("GuildBackgroundContainer", 1, "convert uin is empty string, fail");
        }
        if (t.c(this$0.getContext(), VasUtil.getCurrentUin(), this$0.mCurFriendUid, this$0.mUinType, true, 7, this$0.mChatBackground)) {
            QLog.d("GuildBackgroundContainer", 1, "loadBackgroundAsync changed");
            this$0.post(new Runnable() { // from class: bf1.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildBackgroundContainer.h(GuildBackgroundContainer.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(GuildBackgroundContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        t tVar = this$0.mChatBackground;
        if (tVar != null) {
            Intrinsics.checkNotNull(tVar);
            this$0.i(tVar.f179996c, this$0.mCurFriendUid);
        }
    }

    private final boolean j() {
        t tVar = this.mChatBackground;
        if (tVar == null) {
            return true;
        }
        Intrinsics.checkNotNull(tVar);
        String str = tVar.f179994a;
        Intrinsics.checkNotNullExpressionValue(str, "mChatBackground!!.path");
        return ((getContext() instanceof ChatActivity) || (getContext() instanceof MultiForwardActivity) || AppSetting.o(getContext()) || (!TextUtils.isEmpty(str) && !Intrinsics.areEqual("null", str) && !Intrinsics.areEqual("none", str) && !Intrinsics.areEqual(str, ThemeUtil.getAnimatePathByTag(3)))) ? false : true;
    }

    @Override // com.tencent.guild.aio.background.d
    public void backgroundPause() {
        QLog.d("GuildBackgroundContainer", 1, "background PAUSE " + this);
    }

    @Override // com.tencent.guild.aio.background.d
    public void backgroundResume() {
        QLog.d("GuildBackgroundContainer", 1, "background RESUME " + this);
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
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

    public void setInfo(String curFriendUid, int uinType) {
        Intrinsics.checkNotNullParameter(curFriendUid, "curFriendUid");
        this.mCurFriendUid = curFriendUid;
        this.mUinType = uinType;
    }

    public void setOnBackgroundChangedListener(d.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.guild.aio.background.d
    public int type() {
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() {
        boolean z16;
        View view;
        if (ThemeUtil.isInNightMode(null)) {
            t tVar = this.mChatBackground;
            if (tVar == null) {
                return;
            }
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
                        QLog.d("GuildBackgroundContainer", 2, "#handleNightMask# : inNightMode, isDefaultBg=" + z16 + ",mMask=" + view2 + ", sessionInfo.chatBg.path=" + tVar3.f179994a);
                    }
                    if (this.mMask != null && QLog.isColorLevel()) {
                        view = this.mMask;
                        Intrinsics.checkNotNull(view);
                        if (view.getVisibility() != 0) {
                            QLog.d("GuildBackgroundContainer", 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
                        } else {
                            View view3 = this.mMask;
                            Intrinsics.checkNotNull(view3);
                            if (view3.getVisibility() == 4) {
                                QLog.d("GuildBackgroundContainer", 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
                            } else {
                                QLog.d("GuildBackgroundContainer", 2, "#handleNightMask# : mMask getVisibility = GONE");
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
        } else {
            View view6 = this.mMask;
            if (view6 != null) {
                removeView(view6);
                this.mMask = null;
            }
        }
    }

    private final void i(Drawable bg5, String uin) {
        if (bg5 == null) {
            return;
        }
        if (ThemeUtil.useNativeThemeVideoPlayer() && j() && !ThemeUtil.isNowThemeIsSuperTheme()) {
            String videoPath = ThemeUtil.getThemeVideoFilePath("qq_skin_aio.mp4");
            IThemeVideoController iThemeVideoController = this.mVideoPlayer;
            if (iThemeVideoController != null) {
                iThemeVideoController.release();
            }
            if (!TextUtils.isEmpty(videoPath) && new File(videoPath).exists()) {
                IThemeEffectApi iThemeEffectApi = (IThemeEffectApi) QRoute.api(IThemeEffectApi.class);
                Intrinsics.checkNotNullExpressionValue(videoPath, "videoPath");
                this.mVideoPlayer = iThemeEffectApi.newLoopVideoController(videoPath, bg5, this);
            }
        } else {
            QLog.d("GuildBackgroundContainer", 1, "updateAIOBackground view:" + this + " drawable:" + bg5);
            setBackgroundDrawable(bg5);
        }
        e();
    }
}
