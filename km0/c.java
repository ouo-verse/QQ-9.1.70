package km0;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 -2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b!\u0010\u0012R\"\u0010&\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R\"\u0010*\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001e\u00a8\u0006."}, d2 = {"Lkm0/c;", "Lcom/tencent/freesia/IConfigData;", "", "content", "i", "d", "Ljava/lang/String;", "TAG", "e", tl.h.F, "()Ljava/lang/String;", "CONTENT_KEY", "", "f", "I", "a", "()I", "setAmsPredownloadDelayTime", "(I)V", "amsPredownloadDelayTime", "g", "setAmsPredownloadVideoNettype", "amsPredownloadVideoNettype", "setAmsPredownloadVideoLimit", "amsPredownloadVideoLimit", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "()Z", "setAmsPredownloadVideoBackgroundEnable", "(Z)V", "amsPredownloadVideoBackgroundEnable", BdhLogUtil.LogTag.Tag_Conn, "setAmsPredownloadNonvideoNettype", "amsPredownloadNonvideoNettype", "D", "c", "setAmsPredownloadNonvideoLimit", "amsPredownloadNonvideoLimit", "E", "b", "setAmsPredownloadNonvideoBackgroundenable", "amsPredownloadNonvideoBackgroundenable", "<init>", "()V", UserInfo.SEX_FEMALE, "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c implements IConfigData {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean amsPredownloadNonvideoBackgroundenable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int amsPredownloadVideoNettype;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean amsPredownloadVideoBackgroundEnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "AmsSplashAdConfigData";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String CONTENT_KEY = "AmsSplashContent";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int amsPredownloadDelayTime = 120;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int amsPredownloadVideoLimit = 40;

    /* renamed from: C, reason: from kotlin metadata */
    private int amsPredownloadNonvideoNettype = 1;

    /* renamed from: D, reason: from kotlin metadata */
    private int amsPredownloadNonvideoLimit = 100;

    /* renamed from: a, reason: from getter */
    public final int getAmsPredownloadDelayTime() {
        return this.amsPredownloadDelayTime;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getAmsPredownloadNonvideoBackgroundenable() {
        return this.amsPredownloadNonvideoBackgroundenable;
    }

    /* renamed from: c, reason: from getter */
    public final int getAmsPredownloadNonvideoLimit() {
        return this.amsPredownloadNonvideoLimit;
    }

    /* renamed from: d, reason: from getter */
    public final int getAmsPredownloadNonvideoNettype() {
        return this.amsPredownloadNonvideoNettype;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getAmsPredownloadVideoBackgroundEnable() {
        return this.amsPredownloadVideoBackgroundEnable;
    }

    /* renamed from: f, reason: from getter */
    public final int getAmsPredownloadVideoLimit() {
        return this.amsPredownloadVideoLimit;
    }

    /* renamed from: g, reason: from getter */
    public final int getAmsPredownloadVideoNettype() {
        return this.amsPredownloadVideoNettype;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getCONTENT_KEY() {
        return this.CONTENT_KEY;
    }

    @NotNull
    public final c i(@Nullable String content) {
        boolean z16;
        boolean z17;
        boolean z18;
        c cVar = new c();
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(this.TAG, 1, "data is null");
            return cVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            this.amsPredownloadDelayTime = jSONObject.optInt("amsPredownloadDelayTime", 120);
            this.amsPredownloadVideoNettype = jSONObject.optInt("amsPredownloadVideoNetType", 0);
            this.amsPredownloadVideoLimit = jSONObject.optInt("amsPredownloadVideoLimit", 0);
            if (jSONObject.optInt("amsPredownloadVideoBgEnable", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.amsPredownloadVideoBackgroundEnable = z17;
            this.amsPredownloadNonvideoNettype = jSONObject.optInt("amsPredownloadNonVideoNetType", 0);
            this.amsPredownloadNonvideoLimit = jSONObject.optInt("amsPredownloadNonVideoLimit", 10);
            if (jSONObject.optInt("amsPredownloadNonVideoBgEnable", 0) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.amsPredownloadNonvideoBackgroundenable = z18;
        } catch (JSONException e16) {
            QLog.e(this.TAG, 1, e16, new Object[0]);
        }
        return cVar;
    }
}
