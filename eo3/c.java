package eo3;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import hn3.LinkScreenAnchorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0002\u0013\u0017B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0004R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010 \u00a8\u0006$"}, d2 = {"Leo3/c;", "", "Leo3/c$b;", "followCallback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "", "i", "", VasLiveIPCModule.KEY_ANCHOR_UIN, "l", "f", "g", "", "k", "e", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lhn3/a;", "b", "Lhn3/a;", "otherAnchor", "c", "I", "followStatus", "d", "Leo3/c$b;", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "followStateListener", "<init>", "(Landroid/content/Context;Lhn3/a;)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkScreenAnchorInfo otherAnchor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int followStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b followCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQLiveFollowApi.IQQLiveFollowStateListener followStateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Leo3/c$b;", "", "", QCircleDaTongConstant.ElementParamValue.FOLLOWED, "", "onSuccess", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b {
        void onSuccess(boolean followed);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"eo3/c$c", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: eo3.c$c, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C10253c implements IQQLiveFollowCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinkScreenAnchorInfo f396907b;

        C10253c(LinkScreenAnchorInfo linkScreenAnchorInfo) {
            this.f396907b = linkScreenAnchorInfo;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            String str;
            c.this.followStatus = 2;
            b bVar = c.this.followCallback;
            if (bVar != null) {
                bVar.onSuccess(c.this.k());
            }
            if (TextUtils.isEmpty(errMsg)) {
                str = c.this.context.getString(R.string.f1355201o);
            } else {
                str = errMsg;
            }
            QQToast.makeText(c.this.context, 1, str, 0).show();
            QLog.e("AegisConstants.REPORT_TAG_NEW_PK_GAME|FollowLayoutViewModel", 1, "followAnchor onFail: errCode:" + errCode + ", errMsg:" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            c.this.followStatus = 1;
            b bVar = c.this.followCallback;
            if (bVar != null) {
                bVar.onSuccess(c.this.k());
            }
            QLog.i("AegisConstants.REPORT_TAG_NEW_PK_GAME|FollowLayoutViewModel", 1, "\u5df2\u5173\u6ce8 " + this.f396907b.getUin() + " " + this.f396907b.getRoomId());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"eo3/c$d", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements IQQLiveFollowCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinkScreenAnchorInfo f396908a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f396909b;

        d(LinkScreenAnchorInfo linkScreenAnchorInfo, c cVar) {
            this.f396908a = linkScreenAnchorInfo;
            this.f396909b = cVar;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            QLog.e("AegisConstants.REPORT_TAG_NEW_PK_GAME|FollowLayoutViewModel", 1, "followAnchor onFail: errCode:" + errCode + ", errMsg:" + errMsg);
            b bVar = this.f396909b.followCallback;
            if (bVar != null) {
                bVar.onSuccess(this.f396909b.k());
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            QLog.i("AegisConstants.REPORT_TAG_NEW_PK_GAME|FollowLayoutViewModel", 1, "\u5df2\u53d6\u6d88\u5173\u6ce8 " + this.f396908a.getUin() + " " + this.f396908a.getRoomId());
            this.f396909b.followStatus = 2;
            b bVar = this.f396909b.followCallback;
            if (bVar != null) {
                bVar.onSuccess(this.f396909b.k());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"eo3/c$e", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e implements IQQLiveCheckFollowCallback {
        e() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            QLog.e("AegisConstants.REPORT_TAG_NEW_PK_GAME|FollowLayoutViewModel", 1, "checkFollowAnchor onFail: errCode:" + errCode + ", errMsg:" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            c.this.followStatus = isFollow;
            b bVar = c.this.followCallback;
            if (bVar != null) {
                bVar.onSuccess(c.this.k());
            }
        }
    }

    public c(@NotNull Context context, @NotNull LinkScreenAnchorInfo otherAnchor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(otherAnchor, "otherAnchor");
        this.context = context;
        this.otherAnchor = otherAnchor;
        this.followStatus = 2;
        IQQLiveFollowApi.IQQLiveFollowStateListener iQQLiveFollowStateListener = new IQQLiveFollowApi.IQQLiveFollowStateListener() { // from class: eo3.b
            @Override // com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener
            public final void onFollowStateChange(long j3, long j16, int i3, String str) {
                c.h(c.this, j3, j16, i3, str);
            }
        };
        this.followStateListener = iQQLiveFollowStateListener;
        TGLiveFollowManager.f377684a.u(iQQLiveFollowStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(c this$0, long j3, long j16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i16 = 1;
        QLog.i("AegisConstants.REPORT_TAG_NEW_PK_GAME|FollowLayoutViewModel", 1, "onFollowStateChange, followedId " + j16 + ", otherAnchorUid " + this$0.otherAnchor.getUin() + ", followStatus " + this$0.followStatus);
        if (j16 == this$0.otherAnchor.getUin()) {
            if (1 != i3) {
                i16 = 2;
            }
            this$0.followStatus = i16;
            b bVar = this$0.followCallback;
            if (bVar != null) {
                bVar.onSuccess(this$0.k());
            }
        }
    }

    public final void e() {
        TGLiveFollowManager.f377684a.w(this.followStateListener);
        this.followCallback = null;
    }

    public final void f() {
        QLog.i("AegisConstants.REPORT_TAG_NEW_PK_GAME|FollowLayoutViewModel", 1, "doFollowAnchor");
        LinkScreenAnchorInfo linkScreenAnchorInfo = this.otherAnchor;
        TGLiveFollowManager.f377684a.h(null, linkScreenAnchorInfo.getUin(), linkScreenAnchorInfo.getRoomId(), new C10253c(linkScreenAnchorInfo));
    }

    public final void g() {
        QLog.i("AegisConstants.REPORT_TAG_NEW_PK_GAME|FollowLayoutViewModel", 1, "doUnFollowAnchor");
        LinkScreenAnchorInfo linkScreenAnchorInfo = this.otherAnchor;
        TGLiveFollowManager.f377684a.k(null, linkScreenAnchorInfo.getUin(), linkScreenAnchorInfo.getRoomId(), new d(linkScreenAnchorInfo, this));
    }

    /* renamed from: i, reason: from getter */
    public final int getFollowStatus() {
        return this.followStatus;
    }

    @NotNull
    public final String j() {
        return String.valueOf(this.otherAnchor.getUin());
    }

    public final boolean k() {
        if (this.followStatus == 1) {
            return true;
        }
        return false;
    }

    public final void l(long anchorUin) {
        if (anchorUin == 0) {
            return;
        }
        TGLiveFollowManager.f377684a.f(null, anchorUin, new e());
    }

    public final void m(@NotNull b followCallback) {
        Intrinsics.checkNotNullParameter(followCallback, "followCallback");
        this.followCallback = followCallback;
    }
}
