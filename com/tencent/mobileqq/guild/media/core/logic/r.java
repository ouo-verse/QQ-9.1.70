package com.tencent.mobileqq.guild.media.core.logic;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0006H&J\b\u0010\u0018\u001a\u00020\u0006H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/r;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/q;", "startParams", "Lcom/tencent/mobileqq/guild/media/core/b;", "callback", "", "c", "Lcom/tencent/mobileqq/guild/media/core/h;", UserInfo.SEX_FEMALE, "", "showTips", "reasonForLog", "D", "", "themeType", "d", "L0", "Lcom/tencent/mobileqq/guild/media/core/c;", "G0", "", "needReset", "g0", "y", "w", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface r extends com.tencent.mobileqq.guild.media.core.g {
    void D(@Nullable String showTips, @Nullable String reasonForLog);

    void F(@Nullable com.tencent.mobileqq.guild.media.core.h callback);

    void G0(@Nullable com.tencent.mobileqq.guild.media.core.c callback);

    void L0(@Nullable com.tencent.mobileqq.guild.media.core.b callback);

    void c(@NotNull com.tencent.mobileqq.guild.media.core.q startParams, @Nullable com.tencent.mobileqq.guild.media.core.b callback);

    void d(int themeType);

    void g0(boolean needReset);

    void w();

    void y();
}
