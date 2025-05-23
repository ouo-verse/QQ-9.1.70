package com.tencent.mobileqq.qqlive.config;

import com.qq.wx.voice.util.ErrorCode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.zootopia.ue.PayPluginScene;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/config/QQLiveEntrance;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "LIVE_HALL", "ANCHOR_PREPARE", "SCHEME", "WINK", PayPluginScene.OTHERS, "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveEntrance {
    private static final /* synthetic */ QQLiveEntrance[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final QQLiveEntrance ANCHOR_PREPARE;
    public static final QQLiveEntrance LIVE_HALL;
    public static final QQLiveEntrance OTHERS;
    public static final QQLiveEntrance SCHEME;
    public static final QQLiveEntrance WINK;

    @NotNull
    private final String desc;

    private static final /* synthetic */ QQLiveEntrance[] $values() {
        return new QQLiveEntrance[]{LIVE_HALL, ANCHOR_PREPARE, SCHEME, WINK, OTHERS};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.SRERR_SET_DOMAIN_FAILED);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        LIVE_HALL = new QQLiveEntrance("LIVE_HALL", 0, "\u76f4\u64ad\u5927\u5385");
        ANCHOR_PREPARE = new QQLiveEntrance("ANCHOR_PREPARE", 1, "\u5f00\u64ad\u51c6\u5907\u9875");
        SCHEME = new QQLiveEntrance("SCHEME", 2, "scheme\u8df3\u8f6c");
        WINK = new QQLiveEntrance("WINK", 3, "\u53d1\u5e03\u5668");
        OTHERS = new QQLiveEntrance(PayPluginScene.OTHERS, 4, "\u5176\u4ed6");
        $VALUES = $values();
    }

    QQLiveEntrance(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.desc = str2;
        }
    }

    public static QQLiveEntrance valueOf(String str) {
        return (QQLiveEntrance) Enum.valueOf(QQLiveEntrance.class, str);
    }

    public static QQLiveEntrance[] values() {
        return (QQLiveEntrance[]) $VALUES.clone();
    }

    @NotNull
    public final String getDesc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.desc;
    }
}
