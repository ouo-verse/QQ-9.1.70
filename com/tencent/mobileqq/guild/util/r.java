package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.HexUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/util/r;", "", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f235613a = new r();

    r() {
    }

    @JvmStatic
    @NotNull
    public static final String a() {
        try {
            String guid = HexUtil.bytes2HexStr(com.tencent.mobileqq.guid.c.f213821a.c());
            Intrinsics.checkNotNullExpressionValue(guid, "guid");
            return guid;
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getGUID ex:" + e16;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildGUIDUtil", 1, (String) it.next(), null);
            }
            return "";
        }
    }
}
