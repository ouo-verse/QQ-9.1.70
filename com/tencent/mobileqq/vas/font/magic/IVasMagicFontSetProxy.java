package com.tencent.mobileqq.vas.font.magic;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H&J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/font/magic/IVasMagicFontSetProxy;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getUidByUin", "", "uin", "isMaigcFontEnable", "", "setMagicFont", "", "id", "", "callback", "Lkotlin/Function1;", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasMagicFontSetProxy extends QRouteApi {
    @NotNull
    String getUidByUin(@NotNull String uin);

    boolean isMaigcFontEnable(@NotNull String uin);

    void setMagicFont(int id5, @NotNull Function1<? super Boolean, Unit> callback);
}
