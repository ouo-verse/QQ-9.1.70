package com.tencent.mobileqq.aio.animation.data;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/data/d;", "", "", "c", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "b", "", "type", "a", "aio_animation_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class a {
        public static boolean a(@NotNull d dVar, int i3) {
            return true;
        }
    }

    boolean a(int type);

    @NotNull
    Contact b();

    boolean c();
}
