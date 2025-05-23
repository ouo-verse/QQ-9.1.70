package com.tencent.qqlive.tvkplayer.logo.impl;

import android.view.ViewGroup;
import com.tencent.qqlive.tvkplayer.context.TVKContext;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoImplFactory {
    public static ITVKLogoImpl createLogoImpl(TVKContext tVKContext, ViewGroup viewGroup, int i3, int i16) {
        if (i3 == 2) {
            return new TVKDynamicsLogo(tVKContext, viewGroup, i16);
        }
        return new TVKStaticLogo(tVKContext, viewGroup, i16);
    }
}
