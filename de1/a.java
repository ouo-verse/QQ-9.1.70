package de1;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB/\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lde1/a;", "Lcom/tencent/mobileqq/utils/ax;", "Landroid/content/Context;", "ctx", "", "action", "url", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "", UserInfo.SEX_FEMALE, "G", "H", "", "b", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", ZPlanPublishSource.FROM_SCHEME, BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "cc", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/app/parser/JumpParserResult;)V", ExifInterface.LATITUDE_SOUTH, "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends ax {

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private final String scheme;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private final JumpParserResult jumpParserResult;

    public a(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context, @Nullable String str, @Nullable JumpParserResult jumpParserResult) {
        super(baseQQAppInterface, context);
        this.scheme = str;
        this.jumpParserResult = jumpParserResult;
    }

    private final void F(Context ctx, String action, String url, JumpParserResult jumpParserResult) {
        if (Intrinsics.areEqual(action, "open_msg_list")) {
            H(jumpParserResult);
        } else if (Intrinsics.areEqual(action, "open_aio")) {
            G(jumpParserResult);
        }
    }

    private final void G(JumpParserResult jumpParserResult) {
        boolean z16;
        QLog.d("QQMetaDreamJumpAction", 1, QCircleScheme.Q_CIRCLE_ACTION_OPEN_AIO);
        String str = jumpParserResult.getParamMap().get("self_tinyid");
        String str2 = jumpParserResult.getParamMap().get("peer_tinyid");
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (str2 == null || str2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                String str3 = jumpParserResult.getParamMap().get("self_openid");
                String str4 = jumpParserResult.getParamMap().get("peer_openid");
                String str5 = jumpParserResult.getParamMap().get("self_roleid");
                ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).enterGameMsgAio(this.f307437b, ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).createUidFromTinyId(Long.parseLong(str), Long.parseLong(str2)), jumpParserResult.getParamMap().get("peer_roleid"), str5, str4, str3, str2, str, "1112198072", jumpParserResult.getParamMap().get(PreloadTRTCPlayerParams.KEY_SIG), "", 0, 8, false);
                return;
            }
        }
        QLog.d("QQMetaDreamJumpAction", 1, "openAio invalid param");
    }

    private final void H(JumpParserResult jumpParserResult) {
        boolean z16 = true;
        QLog.d("QQMetaDreamJumpAction", 1, "openMsgList");
        String str = jumpParserResult.getParamMap().get("tab_index");
        int i3 = 0;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            try {
                i3 = Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).openMsgList(i3);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        String str;
        String str2;
        Context context = this.f307437b;
        if (context == null || (str = this.scheme) == null) {
            return true;
        }
        JumpParserResult jumpParserResult = this.jumpParserResult;
        if (jumpParserResult != null) {
            str2 = jumpParserResult.getAction();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return true;
        }
        F(context, str2, str, this.jumpParserResult);
        return true;
    }
}
