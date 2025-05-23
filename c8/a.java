package c8;

import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.personalize.flashnickname.handler.pb.SsoGetActDynamicNickReq;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lc8/a;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lc8/a$a;", "", "Lcom/tencent/falco/base/libapi/channel/ChannelCallback;", "callback", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: c8.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(ChannelCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            try {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime != null && !TextUtils.isEmpty(runtime.getCurrentUin())) {
                    ProtoUtils.a(runtime, new C0175a(callback), new SsoGetActDynamicNickReq().toByteArray(), "OidbSvcTrpcTcp.0x9360_0", 37728, 0);
                }
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }

        Companion() {
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"c8/a$a$a", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: c8.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public static final class C0175a extends ProtoUtils.TroopProtocolObserver {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ChannelCallback f30429d;

            C0175a(ChannelCallback channelCallback) {
                this.f30429d = channelCallback;
            }

            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public void onResult(int errorCode, byte[] data, Bundle bundle) {
                if (errorCode == 0 && data != null) {
                    this.f30429d.onRecv(data);
                    return;
                }
                QLog.e("SsoGetActDynamicNickHandler", 1, "getActDynamicNick error. errorCode:" + errorCode);
                this.f30429d.onError(false, errorCode, "");
            }
        }
    }
}
