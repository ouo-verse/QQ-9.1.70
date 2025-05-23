package com.tencent.mobileqq.filter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static GPUBaseFilter a(int i3) {
        if (i3 != 0) {
            if (i3 != 106) {
                if (i3 != 112) {
                    if (i3 != 101) {
                        if (i3 != 102) {
                            return new GPUBaseFilter();
                        }
                        return new GPUOESBaseFilter();
                    }
                    return new GPUBaseFilter();
                }
                return new GPUOESMovieFilter();
            }
            return new c();
        }
        return new b();
    }

    public static boolean b(int i3) {
        return false;
    }
}
