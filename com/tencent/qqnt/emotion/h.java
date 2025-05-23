package com.tencent.qqnt.emotion;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/emotion/h;", "", "", "f", "d", "Lcom/tencent/qqnt/emotion/b;", "a", "Lcom/tencent/qqnt/emotion/b;", "getView", "()Lcom/tencent/qqnt/emotion/b;", "setView", "(Lcom/tencent/qqnt/emotion/b;)V", "view", "<init>", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b view;

    public h(@NotNull b view) {
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
        } else {
            this.view = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 6, 7});
        QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes(listOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final List<SystemAndEmojiEmotionInfo> f16 = com.tencent.qqnt.emotion.data.b.INSTANCE.f(true);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.emotion.g
            @Override // java.lang.Runnable
            public final void run() {
                h.h(h.this, f16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(h this$0, List data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.view.a(data);
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.e();
                }
            }, 128, null, false);
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.e
                @Override // java.lang.Runnable
                public final void run() {
                    h.g(h.this);
                }
            }, 64, null, true);
        }
    }
}
