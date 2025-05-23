package com.tencent.timi.game.room.impl;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class YoloVoiceChangeAlertUtil {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f379165a = false;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f379168a;

        a(b bVar) {
            this.f379168a = bVar;
        }

        @Override // com.tencent.timi.game.room.impl.YoloVoiceChangeAlertUtil.b
        public void onConfirm() {
            YoloVoiceChangeAlertUtil.f379165a = false;
            this.f379168a.onConfirm();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void onConfirm();
    }

    static void b(int i3, @NonNull b bVar) {
        bVar.onConfirm();
    }

    public static boolean c(String str) {
        l.b("YoloVoiceChangeAlertUtil", "\u8fdb\u5165\u623f\u95f4ID" + str);
        return false;
    }

    public static void d(final int i3, @NonNull b bVar) {
        if (f379165a) {
            l.e("YoloVoiceChangeAlertUtil", "showDialog but isDialogShow!");
            return;
        }
        f379165a = true;
        final a aVar = new a(bVar);
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.timi.game.room.impl.YoloVoiceChangeAlertUtil.2
            @Override // java.lang.Runnable
            public void run() {
                YoloVoiceChangeAlertUtil.b(i3, aVar);
            }
        }, 500L);
    }
}
