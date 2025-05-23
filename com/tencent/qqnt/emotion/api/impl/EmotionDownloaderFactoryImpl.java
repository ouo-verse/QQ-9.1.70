package com.tencent.qqnt.emotion.api.impl;

import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.emoticon.download.QQSysAndEmojiDownloader;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.qqnt.emotion.api.IEmotionDownloaderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/emotion/api/impl/EmotionDownloaderFactoryImpl;", "Lcom/tencent/qqnt/emotion/api/IEmotionDownloaderFactory;", "()V", "getDownloader", "Lcom/tencent/image/ProtocolDownloader;", AudienceReportConst.PROTOCOL, "", "emotion_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class EmotionDownloaderFactoryImpl implements IEmotionDownloaderFactory {
    static IPatchRedirector $redirector_;

    public EmotionDownloaderFactoryImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (r4.equals("https") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return new com.tencent.mobileqq.temp.transfile.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r4.equals("http") == false) goto L26;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x001c. Please report as an issue. */
    @Override // com.tencent.qqnt.emotion.api.IEmotionDownloaderFactory
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ProtocolDownloader getDownloader(@NotNull String protocol2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ProtocolDownloader) iPatchRedirector.redirect((short) 2, (Object) this, (Object) protocol2);
        }
        Intrinsics.checkNotNullParameter(protocol2, "protocol");
        switch (protocol2.hashCode()) {
            case -1824040026:
                if (protocol2.equals(EmotionConstants.PROTOCOL_EMOTION_PIC)) {
                    return new com.tencent.qqnt.emotion.download.a(MobileQQ.sMobileQQ);
                }
                return null;
            case -1395299788:
                if (protocol2.equals("qqsys_emoji")) {
                    return new QQSysAndEmojiDownloader();
                }
                return null;
            case 3213448:
                break;
            case 99617003:
                break;
            default:
                return null;
        }
    }
}
