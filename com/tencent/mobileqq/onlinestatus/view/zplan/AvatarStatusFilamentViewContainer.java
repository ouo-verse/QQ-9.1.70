package com.tencent.mobileqq.onlinestatus.view.zplan;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewContainer;
import com.tencent.mobileqq.onlinestatus.view.zplan.j;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0004\u0015&\u0010\u0017B\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001aR$\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u0017\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/k;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$d;", "other", "", "e", "", "uin", "", "onlineStatus", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", DKWebViewController.DKHippyWebviewFunction.RELOAD, "", "f", "c", "i", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/j;", "view", "g", "a", tl.h.F, "d", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/j;", "avatarView", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$d;", "param", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$c;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$c;", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$c;", "setListener", "(Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$c;)V", "listener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "b", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarStatusFilamentViewContainer extends FrameLayout implements k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j avatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Param param;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c listener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$a;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/j$a;", "", "uin", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$d;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$d;", "getLoadParam", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$d;", "loadParam", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer;Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$d;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class a implements j.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Param loadParam;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AvatarStatusFilamentViewContainer f256769b;

        public a(@NotNull AvatarStatusFilamentViewContainer avatarStatusFilamentViewContainer, Param loadParam) {
            Intrinsics.checkNotNullParameter(loadParam, "loadParam");
            this.f256769b = avatarStatusFilamentViewContainer;
            this.loadParam = loadParam;
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.zplan.j.a
        public void a(@NotNull String uin, @NotNull com.tencent.mobileqq.onlinestatus.model.b res, @Nullable Bitmap bitmap) {
            c listener;
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(res, "res");
            Param param = this.loadParam;
            Param param2 = this.f256769b.param;
            if (param2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                param2 = null;
            }
            if (param != param2) {
                QLog.i("AvatarStatusFilamentViewContainer", 1, "[onSnapshot] load param changed");
            } else if (bitmap != null && (listener = this.f256769b.getListener()) != null) {
                listener.c(this.loadParam.getUin(), this.loadParam.getOnlineStatus(), res, bitmap);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$c;", "", "", "success", "", "error", "", "b", "onBind", "a", "", "uin", "onlineStatus", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "c", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface c {
        void a();

        void b(boolean success, int error);

        void c(@NotNull String uin, int onlineStatus, @NotNull com.tencent.mobileqq.onlinestatus.model.b res, @NotNull Bitmap bitmap);

        void onBind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uin", "b", "I", "()I", "onlineStatus", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "()Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/onlinestatus/model/b;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewContainer$d, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Param {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int onlineStatus;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.mobileqq.onlinestatus.model.b res;

        public Param(@NotNull String uin, int i3, @NotNull com.tencent.mobileqq.onlinestatus.model.b res) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(res, "res");
            this.uin = uin;
            this.onlineStatus = i3;
            this.res = res;
        }

        /* renamed from: a, reason: from getter */
        public final int getOnlineStatus() {
            return this.onlineStatus;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final com.tencent.mobileqq.onlinestatus.model.b getRes() {
            return this.res;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            if (Intrinsics.areEqual(this.uin, param.uin) && this.onlineStatus == param.onlineStatus && Intrinsics.areEqual(this.res, param.res)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.uin.hashCode() * 31) + this.onlineStatus) * 31) + this.res.hashCode();
        }

        @NotNull
        public String toString() {
            return "Param(uin=" + this.uin + ", onlineStatus=" + this.onlineStatus + ", res=" + this.res + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarStatusFilamentViewContainer(@NotNull Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean e(Param other) {
        Param param = this.param;
        if (param == null) {
            return true;
        }
        Param param2 = null;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param = null;
        }
        if (!Intrinsics.areEqual(param.getUin(), other.getUin())) {
            return true;
        }
        Param param3 = this.param;
        if (param3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param3 = null;
        }
        if (!Intrinsics.areEqual(param3.getRes().getCom.qq.e.comm.managers.plugin.PM.BASE java.lang.String(), other.getRes().getCom.qq.e.comm.managers.plugin.PM.BASE java.lang.String())) {
            return true;
        }
        Param param4 = this.param;
        if (param4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            param2 = param4;
        }
        if (!Intrinsics.areEqual(param2.getRes().getAction(), other.getRes().getAction())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.zplan.k
    public void a() {
        QLog.i("AvatarStatusFilamentViewContainer", 1, "[onUnbind] this=" + hashCode() + " avatarView=" + this.avatarView);
        j jVar = this.avatarView;
        if (jVar != null) {
            jVar.b(null);
            removeView(jVar.getView());
            this.avatarView = null;
            c cVar = this.listener;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public final boolean c() {
        Integer num;
        int hashCode = hashCode();
        j jVar = this.avatarView;
        if (jVar != null) {
            num = Integer.valueOf(jVar.hashCode());
        } else {
            num = null;
        }
        QLog.i("AvatarStatusFilamentViewContainer", 1, "[bind] this=" + hashCode + " avatarView=" + num);
        if (this.avatarView != null) {
            return false;
        }
        AvatarStatusFilamentViewManager a16 = AvatarStatusFilamentViewManager.INSTANCE.a();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        j c16 = a16.c(context, this);
        this.avatarView = c16;
        Intrinsics.checkNotNull(c16);
        g(c16);
        return true;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final c getListener() {
        return this.listener;
    }

    public final void f(@NotNull String uin, int onlineStatus, @NotNull com.tencent.mobileqq.onlinestatus.model.b res, boolean reload) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(res, "res");
        Param param = new Param(uin, onlineStatus, res);
        if (!e(param)) {
            QLog.i("AvatarStatusFilamentViewContainer", 1, "[load] param is not changed, uin=" + uin + " onlineStatus=" + onlineStatus);
        }
        this.param = param;
        j jVar = this.avatarView;
        Unit unit = null;
        Param param2 = null;
        if (jVar != null) {
            jVar.b(new a(this, param));
            Param param3 = this.param;
            if (param3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                param3 = null;
            }
            String uin2 = param3.getUin();
            Param param4 = this.param;
            if (param4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            } else {
                param2 = param4;
            }
            jVar.a(uin2, param2.getRes(), reload, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewContainer$load$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                    invoke(bool.booleanValue(), num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, int i3) {
                    AvatarStatusFilamentViewContainer.c listener = AvatarStatusFilamentViewContainer.this.getListener();
                    if (listener != null) {
                        listener.b(z16, i3);
                    }
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.i("AvatarStatusFilamentViewContainer", 1, "[load] avatar view is empty, uin=" + uin + " onlineStatus=" + onlineStatus);
        }
    }

    public void g(@NotNull j view) {
        Intrinsics.checkNotNullParameter(view, "view");
        addView(view.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.avatarView = view;
        c cVar = this.listener;
        if (cVar != null) {
            cVar.onBind();
        }
        Param param = this.param;
        if (param != null) {
            Param param2 = null;
            if (param == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                param = null;
            }
            view.b(new a(this, param));
            Param param3 = this.param;
            if (param3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                param3 = null;
            }
            String uin = param3.getUin();
            Param param4 = this.param;
            if (param4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            } else {
                param2 = param4;
            }
            view.a(uin, param2.getRes(), false, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewContainer$onBind$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                    invoke(bool.booleanValue(), num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, int i3) {
                    AvatarStatusFilamentViewContainer.c listener = AvatarStatusFilamentViewContainer.this.getListener();
                    if (listener != null) {
                        listener.b(z16, i3);
                    }
                }
            });
        }
    }

    public void h() {
        QLog.i("AvatarStatusFilamentViewContainer", 1, "[release] this=" + hashCode());
        i();
        AvatarStatusFilamentViewManager a16 = AvatarStatusFilamentViewManager.INSTANCE.a();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a16.j(context, this);
    }

    public final void i() {
        QLog.i("AvatarStatusFilamentViewContainer", 1, "[unbind] this=" + hashCode());
        if (this.avatarView != null) {
            a();
        }
        AvatarStatusFilamentViewManager a16 = AvatarStatusFilamentViewManager.INSTANCE.a();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a16.m(context, this);
    }

    public final void setListener(@Nullable c cVar) {
        this.listener = cVar;
    }
}
