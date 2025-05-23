package com.tencent.mobileqq.config.aio;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.e;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import ma1.d;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/config/aio/RichTextChatConfParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lma1/d;", "b", "", "content", "d", DownloadInfo.spKey_Config, "", "c", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class RichTextChatConfParser extends BaseConfigParser<d> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f202274e = "RichTextChatConfParser";

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final String f202275f = "101005";

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d defaultConfig() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable d config) {
        String str = f202274e;
        QLog.d(str, 1, "config update");
        super.doOnConfigUpdate(config);
        if (config != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
                e.d(qQAppInterface).j(qQAppInterface, config.getConfigString());
                if (QLog.isColorLevel()) {
                    QLog.d(str, 2, "conifg " + config);
                }
            }
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public d parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        d dVar = new d();
        dVar.b(str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (QLog.isColorLevel()) {
            QLog.d(f202274e, 2, "conifg " + str);
        }
        if (peekAppRuntime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            e.d(qQAppInterface).j(qQAppInterface, str);
        }
        return dVar;
    }
}
