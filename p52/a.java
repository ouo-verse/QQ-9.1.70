package p52;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.common.TPMediaCodecReadyInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0002\b\u0005B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lp52/a;", "", "Lcom/tencent/thumbplayer/api/common/TPMediaCodecReadyInfo;", "mediaCodecInfo", "", "b", "", "codecJson", "a", "Ljava/lang/String;", "cacheDebugText", "<init>", "()V", "c", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String codecJson = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String cacheDebugText = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lp52/a$a;", "", "Ljava/lang/Object;", "extraObject", "Lq52/a;", "reportData", "", "b", "Lcom/tencent/thumbplayer/api/common/TPMediaCodecReadyInfo;", "mediaCodecInfo", "a", "", "SEPARATOR", "Ljava/lang/String;", "TAG", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: p52.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(TPMediaCodecReadyInfo mediaCodecInfo, q52.a reportData) {
            Intrinsics.checkNotNullParameter(mediaCodecInfo, "mediaCodecInfo");
            Intrinsics.checkNotNullParameter(reportData, "reportData");
            if (mediaCodecInfo.getMediaType() == 0) {
                String msg2 = mediaCodecInfo.getMsg();
                reportData.f428397g0 = msg2;
                try {
                    JSONObject jSONObject = new JSONObject(msg2);
                    reportData.f428391d0 = jSONObject.optBoolean("reuseEnable");
                    reportData.f428393e0 = jSONObject.optBoolean("isReuse");
                    reportData.f428395f0 = jSONObject.optInt("totalCodec");
                } catch (Throwable th5) {
                    LogUtil.e("CodecReuseHelper", "onCodecReuseInfo error:" + th5.getMessage());
                }
            }
        }

        public final void b(Object extraObject, q52.a reportData) {
            Intrinsics.checkNotNullParameter(extraObject, "extraObject");
            Intrinsics.checkNotNullParameter(reportData, "reportData");
            if (extraObject instanceof TPMediaCodecReadyInfo) {
                a((TPMediaCodecReadyInfo) extraObject, reportData);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lp52/a$b;", "", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public interface b {
    }

    public final void a(String codecJson) {
        Intrinsics.checkNotNullParameter(codecJson, "codecJson");
        if (TextUtils.equals(this.codecJson, codecJson)) {
            return;
        }
        this.codecJson = codecJson;
        this.cacheDebugText = "";
    }

    public final void b(TPMediaCodecReadyInfo mediaCodecInfo) {
        if (mediaCodecInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("CodecReuseHelper", 2, "parseAndSetMediaCodecInfo failed for mediaCodecInfo is null.");
            }
        } else if (mediaCodecInfo.getMediaType() == 0) {
            String msg2 = mediaCodecInfo.getMsg();
            Intrinsics.checkNotNullExpressionValue(msg2, "mediaCodecInfo.msg");
            a(msg2);
        }
    }
}
