package com.tencent.qqnt.emotion.pic.libra;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/qqnt/emotion/pic/libra/SysFaceAndEmojiLibraPicLoader;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class SysFaceAndEmojiLibraPicLoader$Companion$instance$2 extends Lambda implements Function0<SysFaceAndEmojiLibraPicLoader> {
    public static final SysFaceAndEmojiLibraPicLoader$Companion$instance$2 INSTANCE = new SysFaceAndEmojiLibraPicLoader$Companion$instance$2();

    SysFaceAndEmojiLibraPicLoader$Companion$instance$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        try {
            System.loadLibrary("apng");
        } catch (Exception e16) {
            QLog.e("SysFaceAndEmojiLibraPicLoader", 1, "System.loadLibrary exception.", e16);
        } catch (UnsatisfiedLinkError e17) {
            QLog.e("SysFaceAndEmojiLibraPicLoader", 1, "System.loadLibrary UnsatisfiedLinkError.", e17);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final SysFaceAndEmojiLibraPicLoader invoke() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.pic.libra.i
            @Override // java.lang.Runnable
            public final void run() {
                SysFaceAndEmojiLibraPicLoader$Companion$instance$2.c();
            }
        }, 64, null, false);
        return new SysFaceAndEmojiLibraPicLoader();
    }
}
