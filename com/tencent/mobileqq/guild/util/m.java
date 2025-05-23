package com.tencent.mobileqq.guild.util;

import android.content.res.ColorStateList;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.theme.SkinnableColorStateList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/util/m;", "", "", "desc", "Landroid/content/res/ColorStateList;", "color", "", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f235570a = new m();

    m() {
    }

    public final void a(@NotNull String desc, @Nullable ColorStateList color) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (color == null) {
            Logger logger = Logger.f235387a;
            NullPointerException nullPointerException = new NullPointerException();
            Logger.b bVar = new Logger.b();
            String str = desc + " color is null";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.comm.GuildDiagnosisUtils", 1, (String) it.next(), nullPointerException);
            }
            return;
        }
        if (!(color instanceof SkinnableColorStateList)) {
            Logger logger2 = Logger.f235387a;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            Logger.b bVar2 = new Logger.b();
            String str2 = desc + " color is not SkinnableColorStateList";
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("Guild.comm.GuildDiagnosisUtils", 1, (String) it5.next(), illegalArgumentException);
            }
            return;
        }
        Logger logger3 = Logger.f235387a;
        Logger.b bVar3 = new Logger.b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(desc);
        sb5.append(" color: ");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(((SkinnableColorStateList) color).getDefaultColor())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb5.append(format);
        String sb6 = sb5.toString();
        if (sb6 instanceof String) {
            bVar3.a().add(sb6);
        }
        Iterator<T> it6 = bVar3.a().iterator();
        while (it6.hasNext()) {
            Logger.f235387a.d().e("Guild.comm.GuildDiagnosisUtils", 1, (String) it6.next(), null);
        }
    }
}
