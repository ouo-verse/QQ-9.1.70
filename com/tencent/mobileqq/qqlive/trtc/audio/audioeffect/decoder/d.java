package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder;

import androidx.annotation.NonNull;
import com.tencent.karaoke.decodesdk.M4AInformation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    @NonNull
    public static c a(@NonNull M4AInformation m4AInformation) {
        c cVar = new c();
        cVar.d(m4AInformation.getAlbum());
        cVar.e(m4AInformation.getArtist());
        cVar.f(m4AInformation.getChannels());
        cVar.g(m4AInformation.getDate());
        cVar.h(m4AInformation.getDuration());
        cVar.i(m4AInformation.getNumSamples());
        cVar.j(m4AInformation.getSampleRate());
        cVar.k(m4AInformation.getTitle());
        cVar.l(m4AInformation.getWriter());
        return cVar;
    }
}
