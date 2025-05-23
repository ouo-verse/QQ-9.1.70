package com.tencent.mobileqq.vas.theme.video;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DefaultVideoController extends a {

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.vas.theme.api.a f310933h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.vas.theme.api.a f310934i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.vas.theme.api.a f310935m;

    public DefaultVideoController() {
        d();
        this.f310933h = new k(this.f310940e);
        this.f310934i = new k(this.f310939d);
        this.f310935m = new k(this.f310941f);
    }

    private void d() {
        this.f310940e = new b(null, "qq_skin_conversation.mp4", null, R.drawable.skin_background);
        this.f310939d = new b(null, "qq_skin_drawer.mp4", null, R.drawable.qq_setting_me_bg);
        this.f310941f = new b(null, "qq_skin_aio.mp4", null, R.drawable.skin_chat_background);
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void init(ViewGroup viewGroup) {
        super.init(viewGroup);
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310933h;
        if (aVar != null) {
            aVar.init(viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void initAio(View view) {
        ViewGroup viewGroup;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = (ViewGroup) view.getParent();
        }
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310935m;
        if (aVar != null && !aVar.c(viewGroup)) {
            this.f310935m.release();
            this.f310935m.init(viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void initDrawer(View view) {
        ViewGroup viewGroup;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            if ((view instanceof ImageView) && VasNormalToggle.VAS_THEME_VIDEO_BUG_114313158.isEnable(true)) {
                ((ImageView) view).setImageDrawable(null);
            }
            viewGroup = (ViewGroup) view.getParent();
        }
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310934i;
        if (aVar != null && !aVar.c(viewGroup)) {
            this.f310934i.init(viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        super.onActivityPaused(activity);
        if (!VasNormalToggle.VAS_THEME_PLAYER_REMUME_PAUSE.isEnable(true)) {
            com.tencent.xaction.log.b.a("DefaultVideoController", 1, "vas_theme_player_resume_pause false");
            return;
        }
        if (this.f310935m.b(activity)) {
            this.f310935m.pause();
        }
        if (this.f310934i.b(activity)) {
            this.f310934i.pause();
        }
        if (this.f310933h.b(activity)) {
            this.f310933h.pause();
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        super.onActivityResumed(activity);
        if (!VasNormalToggle.VAS_THEME_PLAYER_REMUME_PAUSE.isEnable(true)) {
            com.tencent.xaction.log.b.a("DefaultVideoController", 1, "vas_theme_player_resume_pause false");
            return;
        }
        if (this.f310935m.b(activity)) {
            this.f310935m.resume();
        }
        if (this.f310934i.b(activity)) {
            this.f310934i.resume();
        }
        if (this.f310933h.b(activity)) {
            this.f310933h.resume();
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void pause() {
        super.pause();
        this.f310933h.pause();
        this.f310934i.pause();
        this.f310935m.pause();
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void release() {
        this.f310933h.release();
        this.f310934i.release();
        this.f310935m.release();
        super.release();
        this.f310935m = null;
        this.f310934i = null;
        this.f310933h = null;
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void releaseAioBg() {
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310935m;
        if (aVar != null && !aVar.e() && ThemeUtil.useNativeThemeVideoPlayer()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.video.DefaultVideoController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DefaultVideoController.this.f310935m != null) {
                        DefaultVideoController.this.f310935m.release();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void resume() {
        super.resume();
        this.f310933h.resume();
        this.f310934i.resume();
        this.f310935m.resume();
    }
}
