package com.tencent.guild.api.share;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/api/share/IGuildForwarder;", "", "Landroid/content/Intent;", "intent", "", "b", "", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface IGuildForwarder {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        @Nullable
        public static Contact a(@NotNull IGuildForwarder iGuildForwarder, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            String stringExtra = intent.getStringExtra("guild_id");
            String str = "";
            if (stringExtra == null) {
                stringExtra = "";
            }
            String stringExtra2 = intent.getStringExtra("uin");
            if (stringExtra2 != null) {
                str = stringExtra2;
            }
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(str)) {
                return new Contact(4, str, stringExtra);
            }
            return null;
        }

        public static void b(@NotNull IGuildForwarder iGuildForwarder, @NotNull Intent intent, @NotNull Contact contact, @NotNull ArrayList<MsgElement> msgElements) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(contact, "contact");
            Intrinsics.checkNotNullParameter(msgElements, "msgElements");
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "IGuildForwarder_asyncSetText", null, null, null, new IGuildForwarder$sendMsg$1(contact, msgElements, iGuildForwarder, intent, null), 14, null);
            }
        }
    }

    void a(@NotNull Intent intent);

    boolean b(@NotNull Intent intent);
}
