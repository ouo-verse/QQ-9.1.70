package com.tencent.mobileqq.qwallet.kuikly;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import i01.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0003\u0016\u0006\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002JI\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fj\u0004\u0018\u0001`\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPopWindowModule;", "Li01/e;", "", "params", "", "c", "a", "action", "Landroid/os/Parcelable;", "data", "d", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "CloseWindowBean", "NotifyPagerLoadStateBean", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletKuiklyPopWindowModule extends e {

    @Parcelize
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPopWindowModule$CloseWindowBean;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "pageName", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class CloseWindowBean implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<CloseWindowBean> CREATOR = new a();

        @SerializedName("pageName")
        @NotNull
        private final String pageName;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public static final class a implements Parcelable.Creator<CloseWindowBean> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CloseWindowBean createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CloseWindowBean(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CloseWindowBean[] newArray(int i3) {
                return new CloseWindowBean[i3];
            }
        }

        public CloseWindowBean(@NotNull String pageName) {
            Intrinsics.checkNotNullParameter(pageName, "pageName");
            this.pageName = pageName;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getPageName() {
            return this.pageName;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof CloseWindowBean) && Intrinsics.areEqual(this.pageName, ((CloseWindowBean) other).pageName)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.pageName.hashCode();
        }

        @NotNull
        public String toString() {
            return "CloseWindowBean(pageName=" + this.pageName + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.pageName);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPopWindowModule$NotifyPagerLoadStateBean;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "pageName", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "loadState", "I", "a", "()I", "<init>", "(Ljava/lang/String;I)V", "d", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class NotifyPagerLoadStateBean implements Parcelable {

        @SerializedName("loadState")
        private final int loadState;

        @SerializedName("pageName")
        @NotNull
        private final String pageName;

        @NotNull
        public static final Parcelable.Creator<NotifyPagerLoadStateBean> CREATOR = new a();

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public static final class a implements Parcelable.Creator<NotifyPagerLoadStateBean> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final NotifyPagerLoadStateBean createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NotifyPagerLoadStateBean(parcel.readString(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final NotifyPagerLoadStateBean[] newArray(int i3) {
                return new NotifyPagerLoadStateBean[i3];
            }
        }

        public NotifyPagerLoadStateBean(@NotNull String pageName, int i3) {
            Intrinsics.checkNotNullParameter(pageName, "pageName");
            this.pageName = pageName;
            this.loadState = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getLoadState() {
            return this.loadState;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getPageName() {
            return this.pageName;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotifyPagerLoadStateBean)) {
                return false;
            }
            NotifyPagerLoadStateBean notifyPagerLoadStateBean = (NotifyPagerLoadStateBean) other;
            if (Intrinsics.areEqual(this.pageName, notifyPagerLoadStateBean.pageName) && this.loadState == notifyPagerLoadStateBean.loadState) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.pageName.hashCode() * 31) + this.loadState;
        }

        @NotNull
        public String toString() {
            return "NotifyPagerLoadStateBean(pageName=" + this.pageName + ", loadState=" + this.loadState + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.pageName);
            parcel.writeInt(this.loadState);
        }
    }

    private final void a(String params) {
        CloseWindowBean bean = (CloseWindowBean) new GsonBuilder().create().fromJson(params, CloseWindowBean.class);
        QLog.i("QWalletPopWindowModule", 1, "closeWindow: " + bean);
        Intrinsics.checkNotNullExpressionValue(bean, "bean");
        d(IQWalletKuiklyApi.EVENT_ACTION_CLOSE_WINDOW, bean);
    }

    private final void c(String params) {
        NotifyPagerLoadStateBean stateBean = (NotifyPagerLoadStateBean) new GsonBuilder().create().fromJson(params, NotifyPagerLoadStateBean.class);
        QLog.i("QWalletPopWindowModule", 1, "notifyPagerLoadState: " + stateBean);
        Intrinsics.checkNotNullExpressionValue(stateBean, "stateBean");
        d(IQWalletKuiklyApi.EVENT_ACTION_NOTIFY_LOAD_STATE, stateBean);
    }

    private final void d(String action, Parcelable data) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra("data", data);
        Context context = getContext();
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "notifyPagerLoadState")) {
            c(params);
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(method, InnerWebView.API_CLOSE_WINDOW)) {
            a(params);
            return Unit.INSTANCE;
        }
        QLog.w("QWalletPopWindowModule", 1, "unknown method: " + method);
        return super.call(method, params, callback);
    }
}
