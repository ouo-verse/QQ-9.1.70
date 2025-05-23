package com.tencent.zplan.encode;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J2\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u001a\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0012\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u0013H&J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/zplan/encode/IEncoder;", "", "Lcom/tencent/zplan/encode/a;", DownloadInfo.spKey_Config, "", "a", "", "mode", "index", "", "pixels", "sourceWidth", "sourceHeight", "c", "totalFrame", "Lcom/tencent/zplan/encode/EncodeResult;", "e", "", "b", "", "getTypeName", "", "d", "(I)Ljava/lang/Long;", "EncodeMode", "base_util_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public interface IEncoder {

    /* compiled from: P */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/zplan/encode/IEncoder$EncodeMode;", "", "base_util_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public @interface EncodeMode {
    }

    boolean a(EncodeConfig config);

    void b(@EncodeMode int mode);

    boolean c(@EncodeMode int mode, int index, byte[] pixels, int sourceWidth, int sourceHeight);

    Long d(int mode);

    EncodeResult e(@EncodeMode int mode, int totalFrame);

    String getTypeName();
}
