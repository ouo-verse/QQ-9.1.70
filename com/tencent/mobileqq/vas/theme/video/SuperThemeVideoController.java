package com.tencent.mobileqq.vas.theme.video;

import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SuperThemeVideoController extends a {

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.vas.theme.api.a f310938h = new k();

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void init(ViewGroup viewGroup) {
        super.init(viewGroup);
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310938h;
        if (aVar != null) {
            aVar.init(viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void pause() {
        super.pause();
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310938h;
        if (aVar != null) {
            aVar.pause();
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void playAioAnimation() {
        b bVar = this.f310941f;
        if (bVar == null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.video.SuperThemeVideoController.3
                @Override // java.lang.Runnable
                public void run() {
                    SuperThemeVideoController.this.f310941f = new b(ThemeConstants.THEME_ANIMATION_AIO1_VIDEO, "qq_skin_aio.mp4", ThemeConstants.THEME_ANIMATION_AIO3_VIDEO, R.drawable.skin_chat_background);
                    if (SuperThemeVideoController.this.f310938h != null) {
                        SuperThemeVideoController.this.f310938h.d(SuperThemeVideoController.this.f310941f);
                    }
                }
            });
            return;
        }
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310938h;
        if (aVar != null) {
            aVar.d(bVar);
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void playDrawerAnimation() {
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310938h;
        if (aVar != null && !aVar.e() && ThemeUtil.useNativeThemeVideoPlayer()) {
            b bVar = this.f310939d;
            if (bVar == null) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.video.SuperThemeVideoController.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SuperThemeVideoController.this.f310939d = new b(ThemeConstants.THEME_ANIMATION_DRAWER1_VIDEO, "qq_skin_drawer.mp4", ThemeConstants.THEME_ANIMATION_DRAWER3_VIDEO, R.drawable.qq_setting_me_bg);
                        if (SuperThemeVideoController.this.f310938h != null) {
                            SuperThemeVideoController.this.f310938h.d(SuperThemeVideoController.this.f310939d);
                        }
                    }
                });
            } else {
                this.f310938h.d(bVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void playExitAnimation() {
        if (this.f310938h != null && ThemeUtil.useNativeThemeVideoPlayer()) {
            this.f310938h.a();
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void playMainAnimation() {
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310938h;
        if (aVar != null && !aVar.e() && ThemeUtil.useNativeThemeVideoPlayer()) {
            b bVar = this.f310940e;
            if (bVar == null) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.video.SuperThemeVideoController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SuperThemeVideoController.this.f310940e = new b(ThemeConstants.THEME_ANIMATION_CONVERSATION1_VIDEO, "qq_skin_conversation.mp4", ThemeConstants.THEME_ANIMATION_CONVERSATION3_VIDEO, R.drawable.skin_background);
                        if (SuperThemeVideoController.this.f310938h != null) {
                            SuperThemeVideoController.this.f310938h.d(SuperThemeVideoController.this.f310940e);
                        }
                    }
                });
            } else {
                this.f310938h.d(bVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void release() {
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310938h;
        if (aVar != null) {
            aVar.release();
        }
        super.release();
        this.f310938h = null;
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void resume() {
        super.resume();
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310938h;
        if (aVar != null) {
            aVar.resume();
        }
    }
}
