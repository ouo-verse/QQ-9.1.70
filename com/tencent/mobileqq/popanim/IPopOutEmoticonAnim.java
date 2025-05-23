package com.tencent.mobileqq.popanim;

import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.jetbrains.annotations.NotNull;

@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IPopOutEmoticonAnim extends QRouteApi {
    void playPokeEmoAnimation(@NotNull AppInterface appInterface, int i3, @NotNull ViewGroup viewGroup, @NotNull String str);

    void playPopEmoAnimation(ViewGroup viewGroup, PopOutAnimConfig popOutAnimConfig, int i3, int i16);

    void stopAndCleanPopOutAnim();
}
