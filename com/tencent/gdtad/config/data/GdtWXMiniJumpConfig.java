package com.tencent.gdtad.config.data;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001+BE\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0013\u0010 R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b\u0017\u0010 R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010 \u00a8\u0006,"}, d2 = {"Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig;", "Lcom/tencent/freesia/IConfigData;", "", "posId", "originID", "", "j", "k", "", "value", "Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig$Companion$JumpType;", "a", "originId", "jumpTypeValue", "g", "f", "errorCode", "b", "Lcom/tencent/gdtad/config/data/n;", "d", "Lcom/tencent/gdtad/config/data/n;", "jumpConfig", "", "e", "Ljava/util/Set;", "errorCodeBlackSet", "Z", "i", "()Z", "uploadAuthStatusEnable", tl.h.F, "Ljava/lang/String;", "()Ljava/lang/String;", "authRejectMsg", "loadErrorMsg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "teenagerErrorMsg", BdhLogUtil.LogTag.Tag_Conn, "c", "appInfoErrorMsg", "<init>", "(Lcom/tencent/gdtad/config/data/n;Ljava/util/Set;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "D", "Companion", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtWXMiniJumpConfig implements IConfigData {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String appInfoErrorMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n jumpConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> errorCodeBlackSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean uploadAuthStatusEnable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String authRejectMsg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String loadErrorMsg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String teenagerErrorMsg;

    public GdtWXMiniJumpConfig(@NotNull n jumpConfig, @NotNull Set<String> errorCodeBlackSet, boolean z16, @NotNull String authRejectMsg, @NotNull String loadErrorMsg, @NotNull String teenagerErrorMsg, @NotNull String appInfoErrorMsg) {
        Intrinsics.checkNotNullParameter(jumpConfig, "jumpConfig");
        Intrinsics.checkNotNullParameter(errorCodeBlackSet, "errorCodeBlackSet");
        Intrinsics.checkNotNullParameter(authRejectMsg, "authRejectMsg");
        Intrinsics.checkNotNullParameter(loadErrorMsg, "loadErrorMsg");
        Intrinsics.checkNotNullParameter(teenagerErrorMsg, "teenagerErrorMsg");
        Intrinsics.checkNotNullParameter(appInfoErrorMsg, "appInfoErrorMsg");
        this.jumpConfig = jumpConfig;
        this.errorCodeBlackSet = errorCodeBlackSet;
        this.uploadAuthStatusEnable = z16;
        this.authRejectMsg = authRejectMsg;
        this.loadErrorMsg = loadErrorMsg;
        this.teenagerErrorMsg = teenagerErrorMsg;
        this.appInfoErrorMsg = appInfoErrorMsg;
    }

    private final Companion.JumpType a(int value) {
        Companion.JumpType jumpType = Companion.JumpType.AUTH;
        if (value != jumpType.getValue()) {
            Companion.JumpType jumpType2 = Companion.JumpType.INSIDE;
            if (value != jumpType2.getValue()) {
                return Companion.JumpType.OUTSIDE;
            }
            return jumpType2;
        }
        return jumpType;
    }

    private final boolean j(String posId, String originID) {
        n nVar = this.jumpConfig;
        if (nVar.b().contains(originID) && (nVar.getIsGlobal() || nVar.a().contains(posId))) {
            return true;
        }
        return false;
    }

    private final boolean k(String posId, String originID) {
        n nVar = this.jumpConfig;
        if (nVar.d().contains(originID) && (nVar.getIsGlobal() || nVar.a().contains(posId))) {
            return true;
        }
        return false;
    }

    public final boolean b(@NotNull String errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        return this.errorCodeBlackSet.contains(errorCode);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAppInfoErrorMsg() {
        return this.appInfoErrorMsg;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAuthRejectMsg() {
        return this.authRejectMsg;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getLoadErrorMsg() {
        return this.loadErrorMsg;
    }

    public final int f(@NotNull String posId) {
        Intrinsics.checkNotNullParameter(posId, "posId");
        n nVar = this.jumpConfig;
        if (!nVar.getIsGlobal() && !nVar.a().contains(posId)) {
            return Companion.QQMCJumpType.INVALID.getValue();
        }
        return nVar.getJumpType();
    }

    @NotNull
    public final Companion.JumpType g(@NotNull String posId, @NotNull String originId, int jumpTypeValue) {
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(originId, "originId");
        n nVar = this.jumpConfig;
        if (!nVar.getIsGlobal() && !nVar.a().contains(posId)) {
            return a(jumpTypeValue);
        }
        int jumpType = nVar.getJumpType();
        if (jumpType == Companion.QQMCJumpType.ALL_INSIDE.getValue()) {
            return Companion.JumpType.INSIDE;
        }
        if (jumpType == Companion.QQMCJumpType.ALL_OUTSIDE.getValue()) {
            return Companion.JumpType.OUTSIDE;
        }
        if (jumpType == Companion.QQMCJumpType.SPECIFIC_APP_INSIDE.getValue()) {
            if (j(posId, originId)) {
                return Companion.JumpType.INSIDE;
            }
            return a(jumpTypeValue);
        }
        if (jumpType == Companion.QQMCJumpType.SPECIFIC_APP_OUTSIDE.getValue()) {
            if (k(posId, originId)) {
                return Companion.JumpType.OUTSIDE;
            }
            return a(jumpTypeValue);
        }
        return a(jumpTypeValue);
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTeenagerErrorMsg() {
        return this.teenagerErrorMsg;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getUploadAuthStatusEnable() {
        return this.uploadAuthStatusEnable;
    }
}
