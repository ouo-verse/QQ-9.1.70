package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.os.Bundle;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/helper/jump/n;", "Lcom/tencent/mobileqq/guild/mainframe/helper/jump/c;", "Landroid/os/Bundle;", "extra", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class n implements c {
    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    @Override // com.tencent.mobileqq.guild.mainframe.helper.jump.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable Bundle extra) {
        String str;
        boolean z16;
        boolean isBlank;
        if (extra != null) {
            str = extra.getString("jump_url");
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str2 = "url get error,extra:" + extra;
                    if (str2 instanceof String) {
                        bVar.a().add(str2);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("Guild.jump.OpenUrlOrSchemaJumper", 1, (String) it.next(), null);
                    }
                    return;
                }
                GuildJumpUtil.w(null, str);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
