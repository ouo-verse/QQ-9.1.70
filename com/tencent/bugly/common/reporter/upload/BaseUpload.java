package com.tencent.bugly.common.reporter.upload;

import com.tencent.component.network.downloader.impl.ipc.Const;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/bugly/common/reporter/upload/BaseUpload;", "", "()V", "getProtocol", "", "url", "Ljava/net/URL;", Const.BUNDLE_KEY_REQUEST, "", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public abstract class BaseUpload {
    public static final int PROTOCOL_HTTP = 0;
    public static final int PROTOCOL_HTTPS = 1;

    public final int getProtocol(@Nullable URL url) {
        if (url == null) {
            return 1;
        }
        return 1 ^ (Intrinsics.areEqual(url.getProtocol(), "http") ? 1 : 0);
    }

    public abstract void request();
}
