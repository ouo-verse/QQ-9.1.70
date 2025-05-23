package mm;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$InnerMessage;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$MapExtraInfo;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nm.b;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lmm/a;", "", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$Message;", "a", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$Message;", "d", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$Message;", "f", "(Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$Message;)V", "mSourceData", "", "Lnm/b;", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "mInnerMessage", "", "()J", WadlProxyConsts.CREATE_TIME, "", "e", "()I", "messageType", "Landroid/util/Pair;", "", "()Landroid/util/Pair;", "advMessageAdInfo", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public QZoneOfficialAccountBase$Message mSourceData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<b> mInnerMessage = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lmm/a$a;", "", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$Message;", "message", "Lmm/a;", "a", "", "AD_ID", "Ljava/lang/String;", "TAG", "TRACE_INFO", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mm.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(QZoneOfficialAccountBase$Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            a aVar = new a();
            aVar.f(message);
            for (QZoneOfficialAccountBase$InnerMessage innerMessage : message.inner_msg_list.get()) {
                List<b> c16 = aVar.c();
                Intrinsics.checkNotNullExpressionValue(innerMessage, "innerMessage");
                c16.add(new b(innerMessage));
            }
            return aVar;
        }

        Companion() {
        }
    }

    public final Pair<String, String> a() {
        String str;
        String str2 = "";
        Pair<String, String> pair = new Pair<>("", "");
        if (e() != 1) {
            return pair;
        }
        if (this.mInnerMessage.isEmpty()) {
            RFWLog.e("QZonePublicAcntMessage", RFWLog.USR, "inner message list null of empty");
            return pair;
        }
        List<QZoneOfficialAccountBase$MapExtraInfo> h16 = this.mInnerMessage.get(0).h();
        List<QZoneOfficialAccountBase$MapExtraInfo> list = h16;
        if (list == null || list.isEmpty()) {
            RFWLog.e("QZonePublicAcntMessage", RFWLog.USR, "extInfoList is null");
            return pair;
        }
        Iterator<QZoneOfficialAccountBase$MapExtraInfo> it = h16.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            QZoneOfficialAccountBase$MapExtraInfo next = it.next();
            if (TextUtils.equals(next.key.get(), WinkDaTongReportConstant.ElementParamKey.ADID)) {
                str = next.value.get();
                Intrinsics.checkNotNullExpressionValue(str, "info.value.get()");
                break;
            }
        }
        Iterator<QZoneOfficialAccountBase$MapExtraInfo> it5 = h16.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            QZoneOfficialAccountBase$MapExtraInfo next2 = it5.next();
            if (TextUtils.equals(next2.key.get(), MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO)) {
                str2 = next2.value.get();
                Intrinsics.checkNotNullExpressionValue(str2, "info.value.get()");
                break;
            }
        }
        return new Pair<>(str, str2);
    }

    public final long b() {
        return d().create_time.get();
    }

    public final List<b> c() {
        return this.mInnerMessage;
    }

    public final QZoneOfficialAccountBase$Message d() {
        QZoneOfficialAccountBase$Message qZoneOfficialAccountBase$Message = this.mSourceData;
        if (qZoneOfficialAccountBase$Message != null) {
            return qZoneOfficialAccountBase$Message;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSourceData");
        return null;
    }

    public final int e() {
        return d().message_type.get();
    }

    public final void f(QZoneOfficialAccountBase$Message qZoneOfficialAccountBase$Message) {
        Intrinsics.checkNotNullParameter(qZoneOfficialAccountBase$Message, "<set-?>");
        this.mSourceData = qZoneOfficialAccountBase$Message;
    }
}
