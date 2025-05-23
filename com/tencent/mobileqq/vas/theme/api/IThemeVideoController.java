package com.tencent.mobileqq.vas.theme.api;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IThemeVideoController {
    void init(ViewGroup viewGroup);

    void initAio(View view);

    void initDrawer(View view);

    boolean isSameFile(String str);

    void pause();

    void playAioAnimation();

    void playDrawerAnimation();

    void playExitAnimation();

    void playMainAnimation();

    void release();

    void releaseAioBg();

    void resume();
}
