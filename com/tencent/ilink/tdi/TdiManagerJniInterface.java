package com.tencent.ilink.tdi;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.av.ui.ak;
import com.tencent.av.ui.an;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.search.model.ac;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import lo2.ah;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b3\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b\u000bJ&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b\rJ\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087 \u00a2\u0006\u0002\b\u0010J\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087 \u00a2\u0006\u0002\b\u0012J&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b\u0014J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087 \u00a2\u0006\u0002\b\u0016J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0087 \u00a2\u0006\u0002\b\u0019J\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087 \u00a2\u0006\u0002\b\u001bJ\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0087 \u00a2\u0006\u0002\b\u001fJ\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 \u00a2\u0006\u0002\b!J&\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b#J&\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b%J&\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b'J\u0016\u0010(\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 \u00a2\u0006\u0002\b)J&\u0010*\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b,J&\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b.J&\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b0J\u0016\u00101\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 \u00a2\u0006\u0002\b2J\u001e\u00103\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00104\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b5J0\u00106\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0087 \u00a2\u0006\u0002\b8J\u001e\u00109\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087 \u00a2\u0006\u0002\b:J&\u0010;\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bH\u0087 \u00a2\u0006\u0002\b>J&\u0010?\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\b@J\u001e\u0010A\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\bCJ\u001e\u0010D\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\bH\u0087 \u00a2\u0006\u0002\bFJ\u0016\u0010G\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 \u00a2\u0006\u0002\bHJ\u0016\u0010I\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 \u00a2\u0006\u0002\bJJ\u001e\u0010K\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u001eH\u0087 \u00a2\u0006\u0002\bMJ\u001e\u0010N\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\nH\u0087 \u00a2\u0006\u0002\bP\u00a8\u0006Q"}, d2 = {"Lcom/tencent/ilink/tdi/TdiManagerJniInterface;", "", "()V", "c2CDownload", "", "handle", "", "task_id", "", "req", "", "ba", "c2CUpload", "ay", "cancelC2CDownload", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "bb", "cancelC2CUpload", "az", "cancelOAuth", "ap", "cancelSendAppRequest", "ar", "cancelUniqueTask", "type", "as", "checkLoginQrCode", an.f75362j, "createTdiManager", "ilink_appid", "", "aa", "destroyTdiManager", "ab", "faceExtVerify", "al", "faceRecognize", ak.f75340i, "faceRecognizeConfig", "aj", "getAppId", "af", "getAppPushToken", "extra_info", "aw", "getLoginQrCode", "am", "getOAuthCode", "ao", "getUserInfo", "ag", "init", "param", ac.f283467k0, "login", MsfConstants.ATTRIBUTE_LOGIN_TYPE, ah.f415119g0, "logout", "ai", "requestUploadLogfiles", Element.ELEMENT_NAME_START_TIMESTAMP, Element.ELEMENT_NAME_END_TIMESTAMP, "ax", "sendAppRequest", "aq", "setSmcBaseInfo", "baseinfo", "au", "setSmcUin", "uin", "av", "smcFlushReportData", "bc", "uninit", "ad", "updateIlinkToken", "ilink_token", "ae", "writeKvData", "kvdata", "at", "tdi-android-lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes7.dex */
public final class TdiManagerJniInterface {
    public static final TdiManagerJniInterface INSTANCE = new TdiManagerJniInterface();

    TdiManagerJniInterface() {
    }

    @JvmName(name = "aa")
    public final native long aa(@NotNull String ilink_appid);

    @JvmName(name = "ab")
    public final native void ab(long handle);

    @JvmName(name = ac.f283467k0)
    public final native void ac(long handle, @NotNull byte[] param);

    @JvmName(name = "ad")
    public final native void ad(long handle);

    @JvmName(name = "ae")
    public final native void ae(long handle, @NotNull String ilink_token);

    @JvmName(name = "af")
    @NotNull
    public final native String af(long handle);

    @JvmName(name = "ag")
    @NotNull
    public final native byte[] ag(long handle);

    @JvmName(name = ah.f415119g0)
    public final native void ah(long handle, int task_id, int login_type, @Nullable byte[] req);

    @JvmName(name = "ai")
    public final native void ai(long handle, int task_id);

    @JvmName(name = "aj")
    public final native void aj(long handle, int task_id, @NotNull byte[] req);

    @JvmName(name = ak.f75340i)
    public final native void ak(long handle, int task_id, @NotNull byte[] req);

    @JvmName(name = "al")
    public final native void al(long handle, int task_id, @NotNull byte[] req);

    @JvmName(name = "am")
    public final native void am(long handle, int task_id, @NotNull byte[] req);

    @JvmName(name = an.f75362j)
    public final native void an(long handle, int task_id);

    @JvmName(name = "ao")
    public final native void ao(long handle, int task_id, @NotNull byte[] req);

    @JvmName(name = "ap")
    public final native void ap(long handle, int task_id, @NotNull byte[] req);

    @JvmName(name = "aq")
    public final native void aq(long handle, int task_id, @NotNull byte[] req);

    @JvmName(name = "ar")
    public final native void ar(long handle, long taskId);

    @JvmName(name = "as")
    public final native void as(long handle, int type);

    @JvmName(name = "at")
    public final native void at(long handle, @NotNull byte[] kvdata);

    @JvmName(name = "au")
    public final native void au(long handle, @NotNull byte[] baseinfo);

    @JvmName(name = "av")
    public final native void av(long handle, int uin);

    @JvmName(name = "aw")
    public final native void aw(long handle, int task_id, @NotNull byte[] extra_info);

    @JvmName(name = "ax")
    public final native void ax(long handle, int start_timestamp, int end_timestamp);

    @JvmName(name = "ay")
    public final native void ay(long handle, int task_id, @NotNull byte[] req);

    @JvmName(name = "az")
    public final native void az(long handle, long taskId);

    @JvmName(name = "ba")
    public final native void ba(long handle, int task_id, @NotNull byte[] req);

    @JvmName(name = "bb")
    public final native void bb(long handle, long taskId);

    @JvmName(name = "bc")
    public final native void bc(long handle);
}
