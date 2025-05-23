package com.tencent.mobileqq.emoticon.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceIPC;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0003\r\u000e\u000fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "<init>", "()V", "d", "AddMarketEmoticonToFavorite", "a", "b", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class EmojiManagerServiceIPC extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00192\u00020\u0001:\u0003\t\u001a\u001bB!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC$AddMarketEmoticonToFavorite;", "", "", "c", "e", "", "result", "b", "Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC;", "a", "Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC;", "getIpc", "()Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC;", "ipc", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "getParams", "()Landroid/os/Bundle;", "params", "I", "getCallbackId", "()I", "callbackId", "<init>", "(Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC;Landroid/os/Bundle;I)V", "d", "ReqParam", "RspParam", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class AddMarketEmoticonToFavorite {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final EmojiManagerServiceIPC ipc;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Bundle params;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int callbackId;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC$AddMarketEmoticonToFavorite$ReqParam;", "Ljava/io/Serializable;", "eId", "", EmojiManagerServiceProxy.EPID, UIJsPlugin.EVENT_SHOW_TOAST, "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getEId", "()Ljava/lang/String;", "getEpId", "getShowToast", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes12.dex */
        public static final /* data */ class ReqParam implements Serializable {
            static IPatchRedirector $redirector_;

            @NotNull
            private final String eId;

            @NotNull
            private final String epId;
            private final boolean showToast;

            public ReqParam(@NotNull String eId, @NotNull String epId, boolean z16) {
                Intrinsics.checkNotNullParameter(eId, "eId");
                Intrinsics.checkNotNullParameter(epId, "epId");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, eId, epId, Boolean.valueOf(z16));
                    return;
                }
                this.eId = eId;
                this.epId = epId;
                this.showToast = z16;
            }

            public static /* synthetic */ ReqParam copy$default(ReqParam reqParam, String str, String str2, boolean z16, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = reqParam.eId;
                }
                if ((i3 & 2) != 0) {
                    str2 = reqParam.epId;
                }
                if ((i3 & 4) != 0) {
                    z16 = reqParam.showToast;
                }
                return reqParam.copy(str, str2, z16);
            }

            @NotNull
            public final String component1() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return this.eId;
            }

            @NotNull
            public final String component2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (String) iPatchRedirector.redirect((short) 6, (Object) this);
                }
                return this.epId;
            }

            public final boolean component3() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
                }
                return this.showToast;
            }

            @NotNull
            public final ReqParam copy(@NotNull String eId, @NotNull String epId, boolean showToast) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    return (ReqParam) iPatchRedirector.redirect((short) 8, this, eId, epId, Boolean.valueOf(showToast));
                }
                Intrinsics.checkNotNullParameter(eId, "eId");
                Intrinsics.checkNotNullParameter(epId, "epId");
                return new ReqParam(eId, epId, showToast);
            }

            public boolean equals(@Nullable Object other) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
                }
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReqParam)) {
                    return false;
                }
                ReqParam reqParam = (ReqParam) other;
                if (Intrinsics.areEqual(this.eId, reqParam.eId) && Intrinsics.areEqual(this.epId, reqParam.epId) && this.showToast == reqParam.showToast) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final String getEId() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.eId;
            }

            @NotNull
            public final String getEpId() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.epId;
            }

            public final boolean getShowToast() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
                }
                return this.showToast;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
                }
                int hashCode = ((this.eId.hashCode() * 31) + this.epId.hashCode()) * 31;
                boolean z16 = this.showToast;
                int i3 = z16;
                if (z16 != 0) {
                    i3 = 1;
                }
                return hashCode + i3;
            }

            @NotNull
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    return (String) iPatchRedirector.redirect((short) 9, (Object) this);
                }
                return "ReqParam(eId=" + this.eId + ", epId=" + this.epId + ", showToast=" + this.showToast + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC$AddMarketEmoticonToFavorite$RspParam;", "Ljava/io/Serializable;", "result", "", "(I)V", "getResult", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes12.dex */
        public static final /* data */ class RspParam implements Serializable {
            static IPatchRedirector $redirector_;
            private final int result;

            public RspParam(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3);
                } else {
                    this.result = i3;
                }
            }

            public static /* synthetic */ RspParam copy$default(RspParam rspParam, int i3, int i16, Object obj) {
                if ((i16 & 1) != 0) {
                    i3 = rspParam.result;
                }
                return rspParam.copy(i3);
            }

            public final int component1() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                return this.result;
            }

            @NotNull
            public final RspParam copy(int result) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (RspParam) iPatchRedirector.redirect((short) 4, (Object) this, result);
                }
                return new RspParam(result);
            }

            public boolean equals(@Nullable Object other) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
                }
                if (this == other) {
                    return true;
                }
                if ((other instanceof RspParam) && this.result == ((RspParam) other).result) {
                    return true;
                }
                return false;
            }

            public final int getResult() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return this.result;
            }

            public int hashCode() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
                }
                return this.result;
            }

            @NotNull
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return "RspParam(result=" + this.result + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC$AddMarketEmoticonToFavorite$a;", "", "", "eId", EmojiManagerServiceProxy.EPID, "", UIJsPlugin.EVENT_SHOW_TOAST, "Lkotlin/Function1;", "", "", "callback", "b", CheckForwardServlet.KEY_CMD, "Ljava/lang/String;", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceIPC$AddMarketEmoticonToFavorite$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c(Function1 callback, EIPCResult eIPCResult) {
                RspParam rspParam;
                int i3;
                Intrinsics.checkNotNullParameter(callback, "$callback");
                int i16 = eIPCResult.code;
                if (i16 != 0) {
                    QLog.w("EmojiManagerService.QIPC", 1, "addMarketEmoticonToFavorite, err=" + i16);
                    callback.invoke(Integer.valueOf(eIPCResult.code));
                    return;
                }
                Serializable serializable = eIPCResult.data.getSerializable("rspParam");
                if (serializable instanceof RspParam) {
                    rspParam = (RspParam) serializable;
                } else {
                    rspParam = null;
                }
                if (rspParam != null) {
                    i3 = rspParam.getResult();
                } else {
                    i3 = -3;
                }
                callback.invoke(Integer.valueOf(i3));
            }

            public final void b(@NotNull String eId, @NotNull String epId, boolean showToast, @NotNull final Function1<? super Integer, Unit> callback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, eId, epId, Boolean.valueOf(showToast), callback);
                    return;
                }
                Intrinsics.checkNotNullParameter(eId, "eId");
                Intrinsics.checkNotNullParameter(epId, "epId");
                Intrinsics.checkNotNullParameter(callback, "callback");
                Bundle bundle = new Bundle();
                bundle.putSerializable("reqParam", new ReqParam(eId, epId, showToast));
                QIPCClientHelper.getInstance().callServer("EmojiManagerServiceQIPC", "addMarketEmoticonToFavorite", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.emoticon.api.impl.b
                    @Override // eipc.EIPCResultCallback
                    public final void onCallback(EIPCResult eIPCResult) {
                        EmojiManagerServiceIPC.AddMarketEmoticonToFavorite.Companion.c(Function1.this, eIPCResult);
                    }
                });
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19291);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public AddMarketEmoticonToFavorite(@NotNull EmojiManagerServiceIPC ipc, @Nullable Bundle bundle, int i3) {
            Intrinsics.checkNotNullParameter(ipc, "ipc");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ipc, bundle, Integer.valueOf(i3));
                return;
            }
            this.ipc = ipc;
            this.params = bundle;
            this.callbackId = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(AddMarketEmoticonToFavorite this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.e();
        }

        public final void b(int result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, result);
            } else {
                this.ipc.callbackResult(this.callbackId, EIPCResult.createResult(result, new Bundle()));
            }
        }

        public final void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticon.api.impl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        EmojiManagerServiceIPC.AddMarketEmoticonToFavorite.d(EmojiManagerServiceIPC.AddMarketEmoticonToFavorite.this);
                    }
                }, 16, null, false);
            }
        }

        public final void e() {
            IEmojiManagerService iEmojiManagerService;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iEmojiManagerService = (IEmojiManagerService) peekAppRuntime.getRuntimeService(IEmojiManagerService.class, "");
            } else {
                iEmojiManagerService = null;
            }
            if (iEmojiManagerService == null) {
                QLog.w("EmojiManagerService.QIPC", 1, "onCall, failed to get service");
                b(-1);
                return;
            }
            Bundle bundle = this.params;
            Intrinsics.checkNotNull(bundle);
            Serializable serializable = bundle.getSerializable("reqParam");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceIPC.AddMarketEmoticonToFavorite.ReqParam");
            ReqParam reqParam = (ReqParam) serializable;
            if (!TextUtils.isEmpty(reqParam.getEId()) && !TextUtils.isEmpty(reqParam.getEpId())) {
                Emoticon emoticon = new Emoticon();
                emoticon.epId = reqParam.getEpId();
                emoticon.eId = reqParam.getEId();
                int collectEmoji = iEmojiManagerService.collectEmoji(emoticon, reqParam.getShowToast());
                if (collectEmoji != 0) {
                    QLog.w("EmojiManagerService.QIPC", 1, "collectEmoji, result=" + collectEmoji);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("rspParam", new RspParam(collectEmoji));
                this.ipc.callbackResult(this.callbackId, EIPCResult.createResult(0, bundle2));
                return;
            }
            QLog.w("EmojiManagerService.QIPC", 1, "invalid args, eid=" + reqParam.getEId() + ", epid=" + reqParam.getEpId());
            b(-3);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC$a;", "", "Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC;", "a", "", "ERROR_INVALID_PARAMS", "I", "ERROR_NO_APP_RUNTIME", "ERROR_UNKNOWN_ACTION", "", "KEY_REQ_PARAM", "Ljava/lang/String;", "KEY_RSP_PARAM", "TAG", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceIPC$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final EmojiManagerServiceIPC a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EmojiManagerServiceIPC) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return b.f204694a.a();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC$b;", "", "Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC;", "b", "Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC;", "a", "()Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPC;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f204694a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final EmojiManagerServiceIPC instance;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19319);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f204694a = new b();
                instance = new EmojiManagerServiceIPC();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final EmojiManagerServiceIPC a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EmojiManagerServiceIPC) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return instance;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19330);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EmojiManagerServiceIPC() {
        super("EmojiManagerServiceQIPC");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.i("EmojiManagerService.QIPC", 1, "onCall, no app runtime, action=" + action);
            callbackResult(callbackId, EIPCResult.createResult(-1, new Bundle()));
            return null;
        }
        if (Intrinsics.areEqual(action, "addMarketEmoticonToFavorite")) {
            new AddMarketEmoticonToFavorite(this, params, callbackId).c();
            return null;
        }
        QLog.w("EmojiManagerService.QIPC", 1, "onCall, unknown action '" + action + "'");
        return EIPCResult.createResult(-2, new Bundle());
    }
}
