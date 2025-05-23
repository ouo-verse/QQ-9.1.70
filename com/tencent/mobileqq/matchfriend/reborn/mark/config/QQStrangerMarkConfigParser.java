package com.tencent.mobileqq.matchfriend.reborn.mark.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/QQStrangerMarkConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/a;", "", "success", "", "onCdnDownload", "", "content", "c", "b", "<init>", "()V", "d", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMarkConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        a a16 = a.INSTANCE.a(new String(content, Charsets.UTF_8));
        QLog.i("QQStrangerMarkConfigParser", 1, "parse isValid=" + a16.c());
        return a16;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        super.onCdnDownload(success);
        QLog.i("QQStrangerMarkConfigParser", 1, "onCdnDownload = " + success);
        b.f245190a.f(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.config.QQStrangerMarkConfigParser$onCdnDownload$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                QLog.i("QQStrangerMarkConfigParser", 1, "[onCdnDownload] initConfig " + z16);
            }
        });
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        QLog.i("QQStrangerMarkConfigParser", 1, "defaultConfig.");
        return new a();
    }
}
