package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.jsonconverter.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean;", "", "()V", "enable", "", "getEnable", "()I", "setEnable", "(I)V", "enableDomain", "", "getEnableDomain", "()Ljava/lang/String;", "setEnableDomain", "(Ljava/lang/String;)V", "openParams", "Lcom/tencent/mobileqq/minigame/publicaccount/config/OpenHippyParam;", "getOpenParams", "()Lcom/tencent/mobileqq/minigame/publicaccount/config/OpenHippyParam;", "setOpenParams", "(Lcom/tencent/mobileqq/minigame/publicaccount/config/OpenHippyParam;)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePAConfBean {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Alias("enable")
    private int enable;

    @Alias("enableDomain")
    private String enableDomain;

    @Alias("openParams")
    private OpenHippyParam openParams;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean$Companion;", "", "()V", "convertFromJSONObject", "Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean;", "content", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MiniGamePAConfBean convertFromJSONObject(String content) {
            return (MiniGamePAConfBean) a.e(content, MiniGamePAConfBean.class);
        }

        Companion() {
        }
    }

    public final int getEnable() {
        return this.enable;
    }

    public final String getEnableDomain() {
        return this.enableDomain;
    }

    public final OpenHippyParam getOpenParams() {
        return this.openParams;
    }

    public final void setEnable(int i3) {
        this.enable = i3;
    }

    public final void setEnableDomain(String str) {
        this.enableDomain = str;
    }

    public final void setOpenParams(OpenHippyParam openHippyParam) {
        this.openParams = openHippyParam;
    }
}
