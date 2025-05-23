package com.tencent.karaoke.audiobasesdk.commom;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/commom/PublicPitchUtil;", "", "()V", "isOpenPublicPitch", "", "enablePublichPitch", "", "enable", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class PublicPitchUtil {
    public static final PublicPitchUtil INSTANCE = new PublicPitchUtil();
    private static boolean isOpenPublicPitch = true;

    PublicPitchUtil() {
    }

    public final void enablePublichPitch(boolean enable) {
        isOpenPublicPitch = enable;
    }

    public final boolean isOpenPublicPitch() {
        return isOpenPublicPitch;
    }
}
