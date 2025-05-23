package com.tenpay.sdk.grab;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tenpay.sdk.util.HBUtil;
import com.tenpay.sdk.util.OnGetResult;
import com.tenpay.sdk.util.QQFaceFileUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0002J \u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\b\u0010#\u001a\u0004\u0018\u00010\n2\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010\nJ\u001a\u0010,\u001a\u00020\"2\b\u0010-\u001a\u0004\u0018\u00010\n2\b\u0010.\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tenpay/sdk/grab/HbSenderViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_recieverIconDrawableLiveData", "Landroidx/lifecycle/MutableLiveData;", "Landroid/graphics/drawable/Drawable;", "_senderIconDrawableLiveData", "_senderIconLiveData", "Landroid/graphics/Bitmap;", "_senderTextLiveData", "", "mSenderIconPath", "getMSenderIconPath", "()Ljava/lang/String;", "setMSenderIconPath", "(Ljava/lang/String;)V", "mSenderIconUrl", "getMSenderIconUrl", "setMSenderIconUrl", "recieverIconDrawableLiveData", "Landroidx/lifecycle/LiveData;", "getRecieverIconDrawableLiveData", "()Landroidx/lifecycle/LiveData;", "sendIconDrawableLiveData", "getSendIconDrawableLiveData", "sendIconLiveData", "getSendIconLiveData", "sendTextLiveData", "getSendTextLiveData", "senderIconSize", "", "senderIconUtil", "Lcom/tenpay/sdk/util/QQFaceFileUtil;", "getUserNick", "", "groupId", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "update", "sendObj", "Lorg/json/JSONObject;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "updateAtGuild", "guildId", "updateReceiverIconAtGuild", "receiverTinyId", "receiverGuildId", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HbSenderViewModel extends ViewModel {
    private static final float HB_ICON_SIZE_DP = 22.0f;

    @Nullable
    private String mSenderIconPath;

    @Nullable
    private String mSenderIconUrl;
    private final int senderIconSize = ViewUtils.dpToPx(HB_ICON_SIZE_DP);

    @NotNull
    private final MutableLiveData<Bitmap> _senderIconLiveData = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<Drawable> _senderIconDrawableLiveData = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<String> _senderTextLiveData = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<Drawable> _recieverIconDrawableLiveData = new MutableLiveData<>();

    @NotNull
    private final QQFaceFileUtil senderIconUtil = new QQFaceFileUtil(new OnGetResult() { // from class: com.tenpay.sdk.grab.o
        @Override // com.tenpay.sdk.util.OnGetResult
        public final void getResult(Object obj) {
            HbSenderViewModel.senderIconUtil$lambda$0(HbSenderViewModel.this, obj);
        }
    });

    private final void getUserNick(final String groupId, final String senderUin) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.grab.s
            @Override // java.lang.Runnable
            public final void run() {
                HbSenderViewModel.getUserNick$lambda$1(groupId, senderUin, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUserNick$lambda$1(String groupId, String senderUin, final HbSenderViewModel this$0) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(senderUin, "$senderUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QWalletNickNameServer.b(groupId, senderUin, new Function1<String, Unit>() { // from class: com.tenpay.sdk.grab.HbSenderViewModel$getUserNick$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HbSenderViewModel.this._senderTextLiveData;
                mutableLiveData.postValue(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void senderIconUtil$lambda$0(HbSenderViewModel this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!(obj instanceof String)) {
            return;
        }
        String str = (String) obj;
        this$0.mSenderIconPath = str;
        Bitmap imageByPath = QQFaceFileUtil.getImageByPath(str, this$0.senderIconSize);
        if (imageByPath == null) {
            imageByPath = QQFaceFileUtil.loadDefaultQQIcon(MobileQQ.sMobileQQ, this$0.senderIconSize, R.drawable.dwv);
        }
        this$0._senderIconLiveData.postValue(imageByPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateAtGuild$lambda$2(HbSenderViewModel this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!(obj instanceof String)) {
            return;
        }
        String str = (String) obj;
        this$0.mSenderIconUrl = str;
        this$0._senderIconDrawableLiveData.postValue(HBUtil.getAvatarDrawable(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateAtGuild$lambda$3(HbSenderViewModel this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!(obj instanceof String)) {
            return;
        }
        this$0._senderTextLiveData.postValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateReceiverIconAtGuild$lambda$4(HbSenderViewModel this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!(obj instanceof String)) {
            return;
        }
        this$0._recieverIconDrawableLiveData.postValue(HBUtil.getAvatarDrawable((String) obj));
    }

    @Nullable
    public final String getMSenderIconPath() {
        return this.mSenderIconPath;
    }

    @Nullable
    public final String getMSenderIconUrl() {
        return this.mSenderIconUrl;
    }

    @NotNull
    public final LiveData<Drawable> getRecieverIconDrawableLiveData() {
        return this._recieverIconDrawableLiveData;
    }

    @NotNull
    public final LiveData<Drawable> getSendIconDrawableLiveData() {
        return this._senderIconDrawableLiveData;
    }

    @NotNull
    public final LiveData<Bitmap> getSendIconLiveData() {
        return this._senderIconLiveData;
    }

    @NotNull
    public final LiveData<String> getSendTextLiveData() {
        return this._senderTextLiveData;
    }

    public final void setMSenderIconPath(@Nullable String str) {
        this.mSenderIconPath = str;
    }

    public final void setMSenderIconUrl(@Nullable String str) {
        this.mSenderIconUrl = str;
    }

    public final void update(@NotNull JSONObject sendObj, @Nullable String groupId, @NotNull Activity activity) {
        boolean z16;
        Intrinsics.checkNotNullParameter(sendObj, "sendObj");
        Intrinsics.checkNotNullParameter(activity, "activity");
        String senderUin = sendObj.optString("send_uin");
        String optString = sendObj.optString("send_name");
        Intrinsics.checkNotNullExpressionValue(optString, "sendObj.optString(\"send_name\")");
        boolean z17 = true;
        if (optString.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this._senderTextLiveData.postValue(optString);
        }
        Intrinsics.checkNotNullExpressionValue(senderUin, "senderUin");
        if (senderUin.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            this.senderIconUtil.getQQFaceImage(senderUin, activity);
            if (groupId == null) {
                groupId = "";
            }
            getUserNick(groupId, senderUin);
        }
    }

    public final void updateAtGuild(@NotNull JSONObject sendObj, @Nullable String guildId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(sendObj, "sendObj");
        String tinyId = sendObj.optString("send_tinyid");
        String defaultName = sendObj.optString("send_name");
        Intrinsics.checkNotNullExpressionValue(defaultName, "defaultName");
        boolean z17 = true;
        if (defaultName.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this._senderTextLiveData.postValue(defaultName);
        }
        Intrinsics.checkNotNullExpressionValue(tinyId, "tinyId");
        if (tinyId.length() != 0) {
            z17 = false;
        }
        if (z17) {
            return;
        }
        HBUtil.getGuildUsersAvatarUrl(tinyId, guildId, new OnGetResult() { // from class: com.tenpay.sdk.grab.q
            @Override // com.tenpay.sdk.util.OnGetResult
            public final void getResult(Object obj) {
                HbSenderViewModel.updateAtGuild$lambda$2(HbSenderViewModel.this, obj);
            }
        });
        HBUtil.getGuildMemberName(tinyId, guildId, new OnGetResult() { // from class: com.tenpay.sdk.grab.r
            @Override // com.tenpay.sdk.util.OnGetResult
            public final void getResult(Object obj) {
                HbSenderViewModel.updateAtGuild$lambda$3(HbSenderViewModel.this, obj);
            }
        });
    }

    public final void updateReceiverIconAtGuild(@Nullable String receiverTinyId, @Nullable String receiverGuildId) {
        boolean z16;
        if (receiverTinyId != null && receiverTinyId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        HBUtil.getGuildUsersAvatarUrl(receiverTinyId, receiverGuildId, new OnGetResult() { // from class: com.tenpay.sdk.grab.p
            @Override // com.tenpay.sdk.util.OnGetResult
            public final void getResult(Object obj) {
                HbSenderViewModel.updateReceiverIconAtGuild$lambda$4(HbSenderViewModel.this, obj);
            }
        });
    }
}
