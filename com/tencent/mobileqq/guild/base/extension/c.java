package com.tencent.mobileqq.guild.base.extension;

import android.os.Bundle;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.Logger;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u001e\u0010\u0007\u001a\u00020\u0005*\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a\f\u0010\t\u001a\u00020\b*\u0004\u0018\u00010\u0000\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\u0000\u001a\f\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\u0000\u00a8\u0006\r"}, d2 = {"Landroid/os/Bundle;", "a", "", "key", "g", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "e", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "b", "c", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "d", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {
    @Nullable
    public static final Bundle a(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (bundle.containsKey("android:support:fragments")) {
            bundle.remove("android:support:fragments");
        }
        return bundle;
    }

    @NotNull
    public static final FacadeArgsData b(@Nullable Bundle bundle) {
        FacadeArgsData c16 = c(bundle);
        if (c16 != null) {
            return c16;
        }
        throw new IllegalStateException("getFacadeArgsData failed");
    }

    @Nullable
    public static final FacadeArgsData c(@Nullable Bundle bundle) {
        boolean isBlank;
        FacadeArgsData facadeArgsData;
        if (bundle != null && (facadeArgsData = (FacadeArgsData) bundle.getParcelable("param_facade_args_data")) != null) {
            return facadeArgsData;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("getFacadeArgsData failed");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("BundleEx", 1, (String) it.next(), null);
        }
        JumpGuildParam d16 = d(bundle);
        String str = d16.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!(!isBlank)) {
            return null;
        }
        return zr1.e.INSTANCE.a(d16, null);
    }

    @NotNull
    public static final JumpGuildParam d(@Nullable Bundle bundle) {
        JumpGuildParam jumpGuildParam;
        if (bundle != null) {
            jumpGuildParam = (JumpGuildParam) bundle.getParcelable(JumpGuildParam.KEY_JUMP_GUILD_PARAM);
        } else {
            jumpGuildParam = null;
        }
        if (jumpGuildParam == null) {
            Logger logger = Logger.f235387a;
            IllegalStateException illegalStateException = new IllegalStateException();
            Logger.b bVar = new Logger.b();
            bVar.a().add("getJumpGuildParam failed");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("BundleEx", 1, (String) it.next(), illegalStateException);
            }
            return new JumpGuildParam("", "");
        }
        return jumpGuildParam;
    }

    public static final long e(@Nullable Bundle bundle, @NotNull String key, long j3) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (bundle == null) {
            return j3;
        }
        return bundle.getLong(key, j3);
    }

    public static /* synthetic */ long f(Bundle bundle, String str, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        return e(bundle, str, j3);
    }

    @Nullable
    public static final String g(@Nullable Bundle bundle, @NotNull String key) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(key, "key");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(key);
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!(true ^ z16)) {
            return null;
        }
        return str;
    }
}
