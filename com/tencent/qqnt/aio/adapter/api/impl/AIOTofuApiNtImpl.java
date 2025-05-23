package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.aio.api.INTZPlanAvatarView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J8\u0010#\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J \u0010+\u001a\u00020)2\u0006\u0010(\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020$2\u0006\u0010-\u001a\u00020,H\u0016J \u00101\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020$2\u0006\u0010/\u001a\u00020)2\u0006\u0010-\u001a\u000200H\u0016J \u00105\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020$2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0016H\u0016\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOTofuApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOTofuApi;", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "aioCreate", "aioResume", "", "selfUin", "aioDelayLoad", "aioStop", "aioDestroy", "Landroid/content/Context;", "context", "", "isScaleChat", "Lcom/tencent/aio/data/msglist/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "clickTofu", "uin", "Landroid/graphics/drawable/Drawable;", "getHeadDrawable", "Landroid/widget/ImageView;", "targetView", "url", "loadDrawableByUrl", "isTheTofuNeedFiltered", "Landroid/view/View;", "mAvatarStatusView", "Lcom/tencent/qqnt/aio/k;", "curOnlineStatus", "Landroidx/constraintlayout/widget/ConstraintLayout;", "tofuWithQQShowContainer", "Lcom/tencent/qqnt/aio/api/d;", "iNTAvatarStatusViewCb", "updateAvatarStatusView", "", "id", "checkNeedTimeStampForQQShowTofu", "getApngDrawable", "businessId", "", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "getBackgroundTextColor", "Lcom/tencent/qqnt/aio/api/g;", "cb", "getIsLike", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "Lcom/tencent/qqnt/aio/api/f;", "sendLikeStatus", "Landroid/widget/TextView;", "tv", "iv", "setOnlineStatusTextAndIcon", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOTofuApiNtImpl implements IAIOTofuApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "AIOTofuApiNTImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOTofuApiNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOTofuApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31015);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOTofuApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void aioCreate(@NotNull AIOParam aioParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioParam);
        } else {
            Intrinsics.checkNotNullParameter(aioParam, "aioParam");
            QLog.d(TAG, 1, "AIO CREATE");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void aioDelayLoad(@NotNull String selfUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) selfUin);
        } else {
            Intrinsics.checkNotNullParameter(selfUin, "selfUin");
            QLog.d(TAG, 1, "AIO DELAY_LOAD");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void aioDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.d(TAG, 1, "AIO DESTROY");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void aioResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.d(TAG, 1, "AIO RESUME");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void aioStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.d(TAG, 1, "AIO STOP");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean checkNeedTimeStampForQQShowTofu(long id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, id5)).booleanValue();
        }
        QLog.d(TAG, 1, "need timeStamp for QQShow tofu? true");
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void clickTofu(@NotNull Context context, boolean isScaleChat, @NotNull com.tencent.aio.data.msglist.a item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, Boolean.valueOf(isScaleChat), item);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        Toast.makeText(context, "click new tofu", 0).show();
        QLog.d(TAG, 1, "click tofu msg");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    @Nullable
    public Drawable getApngDrawable(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public int getBackgroundTextColor(long businessId, @NotNull String url, int defaultColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, this, Long.valueOf(businessId), url, Integer.valueOf(defaultColor))).intValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return defaultColor;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    @NotNull
    public String getConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return IAIOTofuApi.a.a(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    @Nullable
    public Drawable getHeadDrawable(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, (Object) this, (Object) uin);
        }
        QLog.d(TAG, 1, "get head drawable");
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void getIsLike(long uin, @NotNull com.tencent.qqnt.aio.api.g cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(uin), cb5);
        } else {
            Intrinsics.checkNotNullParameter(cb5, "cb");
            cb5.a(false);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    @NotNull
    public String getTofuConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return IAIOTofuApi.a.b(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean isHitZPlanAvatarExperiment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return IAIOTofuApi.a.c(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean isRevealEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return IAIOTofuApi.a.d(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean isRingRevealEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return IAIOTofuApi.a.e(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean isTheTofuNeedFiltered(@NotNull com.tencent.aio.data.msglist.a item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d(TAG, 1, "is the tofu need filtered? false");
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean isTofuExperimentC() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return IAIOTofuApi.a.f(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void loadDrawableByUrl(@NotNull ImageView targetView, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) targetView, (Object) url);
        } else {
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            QLog.d(TAG, 1, "load drawable by url");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    @NotNull
    public String parseTofuContent(long j3, @NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, this, Long.valueOf(j3), str);
        }
        return IAIOTofuApi.a.g(this, j3, str);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void sendLikeStatus(long uin, int clickType, @NotNull com.tencent.qqnt.aio.api.f cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(uin), Integer.valueOf(clickType), cb5);
        } else {
            Intrinsics.checkNotNullParameter(cb5, "cb");
            cb5.a(true, uin);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void setOnlineStatusTextAndIcon(long uin, @NotNull TextView tv5, @NotNull ImageView iv5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(uin), tv5, iv5);
        } else {
            Intrinsics.checkNotNullParameter(tv5, "tv");
            Intrinsics.checkNotNullParameter(iv5, "iv");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    @Nullable
    public View updateAvatarStatusView(@NotNull com.tencent.aio.data.msglist.a item, @Nullable View mAvatarStatusView, @Nullable com.tencent.qqnt.aio.k curOnlineStatus, @Nullable ConstraintLayout tofuWithQQShowContainer, @NotNull com.tencent.qqnt.aio.api.d iNTAvatarStatusViewCb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, this, item, mAvatarStatusView, curOnlineStatus, tofuWithQQShowContainer, iNTAvatarStatusViewCb);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(iNTAvatarStatusViewCb, "iNTAvatarStatusViewCb");
        QLog.d(TAG, 1, "updateAvatarStatusView, return null");
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    @Nullable
    public INTZPlanAvatarView updateZPlanAvatarView(@NotNull String str, @Nullable ConstraintLayout constraintLayout, @NotNull com.tencent.qqnt.aio.api.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (INTZPlanAvatarView) iPatchRedirector.redirect((short) 21, this, str, constraintLayout, dVar);
        }
        return IAIOTofuApi.a.h(this, str, constraintLayout, dVar);
    }
}
