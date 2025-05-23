package b00;

import UserGrowth.stNotificationRedDot;
import UserGrowth.stRedDotMenu;
import UserGrowth.stRedDotRsp;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.weishi.combo.msg.WSMsgFragment;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi.request.RedDotRequest;
import com.tencent.biz.pubaccount.weishi.util.af;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$\u00a8\u0006*"}, d2 = {"Lb00/i;", "Lb00/a;", "", "e0", "LUserGrowth/stSimpleMetaPerson;", QCircleAlphaUserReporter.KEY_USER, "i0", "", "notification", "LUserGrowth/stRedDotMenu;", BdhLogUtil.LogTag.Tag_Req, "f", "", "LUserGrowth/stNotificationRedDot;", "v", "notificationRedDot", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/content/Context;", "context", "", "eventId", "D", "G", "K", "n0", "Lb00/b;", "view", "P", "d0", "detachView", "destroy", "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "viewRef", "e", "Ljava/util/List;", "avatarMenu", "<init>", "()V", tl.h.F, "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class i implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<b00.b> viewRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<stNotificationRedDot> notificationRedDot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<stRedDotMenu> avatarMenu;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001J,\u0010\b\u001a\u00020\u00022\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014\u00a8\u0006\u000f"}, d2 = {"b00/i$b", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stRedDotRsp;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "redDotRsp", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "", "f", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "a", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b extends com.tencent.biz.pubaccount.weishi.net.common.b<stRedDotRsp, stRedDotRsp> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j errorInfo) {
            Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j errorInfo) {
            Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
            super.b(errorInfo);
            b00.b d06 = i.this.d0();
            if (d06 != null) {
                d06.x6();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stRedDotRsp c(com.tencent.biz.pubaccount.weishi.net.common.g<stRedDotRsp> request, stRedDotRsp redDotRsp, com.tencent.biz.pubaccount.weishi.net.d headerBean) {
            Intrinsics.checkNotNullParameter(redDotRsp, "redDotRsp");
            i.this.notificationRedDot = redDotRsp.notificationReddot;
            i.this.avatarMenu = redDotRsp.menu;
            af.d(redDotRsp.menu);
            i.this.i0(redDotRsp.user);
            return redDotRsp;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stRedDotRsp redDotRsp) {
            Intrinsics.checkNotNullParameter(redDotRsp, "redDotRsp");
            super.d(redDotRsp);
            b00.b d06 = i.this.d0();
            if (d06 != null) {
                d06.y6(redDotRsp);
            }
        }
    }

    private final stRedDotMenu R(String notification) {
        List<stRedDotMenu> list = this.avatarMenu;
        if (list == null) {
            return null;
        }
        for (stRedDotMenu streddotmenu : list) {
            if (TextUtils.equals(notification, streddotmenu.menuKey)) {
                return streddotmenu;
            }
        }
        return null;
    }

    private final void e0() {
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new RedDotRequest()).b(new b());
    }

    @Override // b00.a
    public void A(List<stNotificationRedDot> notificationRedDot) {
        this.notificationRedDot = notificationRedDot;
    }

    @Override // b00.a
    public void D(Context context, int eventId) {
        Intrinsics.checkNotNullParameter(context, "context");
        WSMsgFragment.INSTANCE.a(context);
    }

    @Override // b00.a
    public void G(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WSProfileFragment.ri(context, bb.q(), "my_profile");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // b00.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void K(Context context) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        stRedDotMenu R = R("Feedback");
        if ((R != null ? R.schema : null) == null) {
            return;
        }
        String str = R.schema.H5Url;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    z.h(context, R.schema.H5Url);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void attachView(b00.b view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.viewRef = new WeakReference<>(view);
    }

    public b00.b d0() {
        WeakReference<b00.b> weakReference = this.viewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void detachView() {
        WeakReference<b00.b> weakReference = this.viewRef;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    @Override // b00.a
    public void f() {
        e0();
    }

    @Override // b00.a
    public List<stNotificationRedDot> v() {
        return this.notificationRedDot;
    }

    @Override // b00.a
    public void n0(Context context) {
        if (context == null) {
            x.j("WSHomeAvatarZonePresenter", "context is null");
        } else {
            bb.N(context, "2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(stSimpleMetaPerson user) {
        boolean isBlank;
        boolean isBlank2;
        if (user == null) {
            return;
        }
        String str = user.f25130id;
        Intrinsics.checkNotNullExpressionValue(str, "user.id");
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            bb.U(user.f25130id);
        }
        String str2 = user.nick;
        Intrinsics.checkNotNullExpressionValue(str2, "user.nick");
        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
        if (!isBlank2) {
            bb.T(user.nick);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void destroy() {
    }
}
