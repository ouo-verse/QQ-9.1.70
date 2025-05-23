package com.tencent.mobileqq.guild.data;

import com.tencent.mobileqq.guild.data.t;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u001c\u0010\r\u001a\u00020\f8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u00020\f8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u0014\u0010\u001a\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u000eR\u001e\u0010 \u001a\u0004\u0018\u00010\u001b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/data/o;", "Lcom/tencent/mobileqq/guild/data/t;", "", "getFileId", "()Ljava/lang/String;", "fileId", "f", "videoId", "getCoverUrl", "coverUrl", "getUrl", "url", "", "isRaw", "()Z", "setRaw", "(Z)V", "b", "setGif", NodeProps.CUSTOM_PROP_ISGIF, "a", "setMd5", "(Ljava/lang/String;)V", "md5", "isVideoTask", "g", "isImageTask", "Lcom/tencent/mobileqq/guild/data/g;", tl.h.F, "()Lcom/tencent/mobileqq/guild/data/g;", "setLocalMediaInfo", "(Lcom/tencent/mobileqq/guild/data/g;)V", "localMediaInfo", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface o extends t {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static boolean a(@NotNull o oVar) {
            return t.a.a(oVar);
        }
    }

    @NotNull
    String a();

    boolean b();

    @NotNull
    String f();

    boolean g();

    @NotNull
    String getCoverUrl();

    @NotNull
    String getFileId();

    @NotNull
    String getUrl();

    @Nullable
    g h();

    boolean isRaw();

    boolean isVideoTask();
}
