package com.tencent.ilinklive.interfaces;

import com.tencent.av.ui.ak;
import com.tencent.av.ui.an;
import com.tencent.mobileqq.search.model.ac;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import lo2.ah;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b:\u0010;J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087 \u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0087 \u00a2\u0006\u0004\b\n\u0010\u000bJ0\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0087 \u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0087 \u00a2\u0006\u0004\b\u0014\u0010\u000bJ \u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087 \u00a2\u0006\u0004\b\u0017\u0010\u0018J0\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000eH\u0087 \u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087 \u00a2\u0006\u0004\b \u0010\u0018J(\u0010%\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H\u0087 \u00a2\u0006\u0004\b#\u0010$J(\u0010'\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H\u0087 \u00a2\u0006\u0004\b&\u0010$J(\u0010)\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H\u0087 \u00a2\u0006\u0004\b(\u0010$J(\u0010+\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H\u0087 \u00a2\u0006\u0004\b*\u0010$J(\u0010-\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H\u0087 \u00a2\u0006\u0004\b,\u0010$J(\u0010/\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H\u0087 \u00a2\u0006\u0004\b.\u0010$J\u0018\u00102\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u0004H\u0087 \u00a2\u0006\u0004\b0\u00101J\u0018\u00106\u001a\u0002032\u0006\u0010\b\u001a\u00020\u0004H\u0087 \u00a2\u0006\u0004\b4\u00105J(\u00109\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0002H\u0087 \u00a2\u0006\u0004\b8\u0010$\u00a8\u0006<"}, d2 = {"Lcom/tencent/ilinklive/interfaces/IlinkLiveJniInterface;", "", "", "ilink_appid", "", "aa", "(Ljava/lang/String;)J", "createIlinkLive", "handle", "", "ab", "(J)V", "destroyIlinkLive", "path", "", "publish_mode", "running_mode", ac.f283467k0, "(JLjava/lang/String;II)V", "init", "ad", "unInit", "task_id", ah.f415119g0, "(JJ)V", "autoLogin", "", "auth_buffer", "session_type", "ai", "(JJ[BI)V", "thirdAppLogin", "aj", "finderInit", "body", ak.f75340i, "(JJLjava/lang/String;)V", "finderLivePrepare", "al", "finderCreateLive", "am", "finderJoinLive", an.f75362j, "finderCloseLive", "ao", "finderSetAnchorStatus", "ap", "sendTransferRequest", "aq", "(J)[B", "getJsBridgeData", "", "aw", "(J)Z", "canAutoLogin", "filepath", "ax", "uploadMediaFile", "<init>", "()V", "ilinkservice_standalone_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes7.dex */
public final class IlinkLiveJniInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final IlinkLiveJniInterface f116242a = new IlinkLiveJniInterface();

    @JvmName(name = "aa")
    public final native long aa(@NotNull String ilink_appid);

    @JvmName(name = "ab")
    public final native void ab(long handle);

    @JvmName(name = ac.f283467k0)
    public final native void ac(long handle, @NotNull String path, int publish_mode, int running_mode);

    @JvmName(name = "ad")
    public final native void ad(long handle);

    @JvmName(name = ah.f415119g0)
    public final native void ah(long handle, long task_id);

    @JvmName(name = "ai")
    public final native void ai(long handle, long task_id, @NotNull byte[] auth_buffer, int session_type);

    @JvmName(name = "aj")
    public final native void aj(long handle, long task_id);

    @JvmName(name = ak.f75340i)
    public final native void ak(long handle, long task_id, @NotNull String body);

    @JvmName(name = "al")
    public final native void al(long handle, long task_id, @NotNull String body);

    @JvmName(name = "am")
    public final native void am(long handle, long task_id, @NotNull String body);

    @JvmName(name = an.f75362j)
    public final native void an(long handle, long task_id, @NotNull String body);

    @JvmName(name = "ao")
    public final native void ao(long handle, long task_id, @NotNull String body);

    @JvmName(name = "ap")
    public final native void ap(long handle, long task_id, @NotNull String body);

    @JvmName(name = "aq")
    @NotNull
    public final native byte[] aq(long handle);

    @JvmName(name = "aw")
    public final native boolean aw(long handle);

    @JvmName(name = "ax")
    public final native void ax(long handle, long task_id, @NotNull String filepath);
}
