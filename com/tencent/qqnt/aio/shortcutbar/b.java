package com.tencent.qqnt.aio.shortcutbar;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f352101a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f352102b;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f352103c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f352104d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f352105e;

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f352106f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f352107g;

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f352108h;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f352109i;

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f352110j;

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f352111k;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48268);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f352101a = new int[]{1000, R.string.f7k, R.drawable.qui_microphone_on_aio_oversized_light_selector};
        f352102b = new int[]{1003, R.string.f7b, R.drawable.qui_image_aio_oversized_light_selector};
        f352103c = new int[]{1005, R.string.f6z, R.drawable.qui_camera_aio_oversized_light_selector};
        f352104d = new int[]{1004, R.string.f77, R.drawable.qui_red_envelope_aio_oversized_light_selector};
        f352105e = new int[]{1001, R.string.f171479f73, R.drawable.qui_emoticon_aio_oversized_light_selector};
        f352106f = new int[]{1006, R.string.f7g, R.drawable.qui_add_circle_aio_oversized_light_selector};
        f352107g = new int[]{1008, R.string.f197304jn, R.drawable.j68};
        f352108h = new int[]{1010, R.string.f197414jy, R.drawable.qui_aio_gif_light_selector};
        f352109i = new int[]{1013, R.string.f197324jp, R.drawable.qui_game_selector};
        f352110j = new int[]{1015, R.string.f75, R.drawable.qui_folder_aio_oversized_light_selector};
        f352111k = new int[]{1014, R.string.f197474k4, R.drawable.qui_assisted_chat_aio_oversized_light_selector};
    }
}
