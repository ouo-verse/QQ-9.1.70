package com.tencent.mobileqq.profilecard.processor;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.bussiness.cub.ProfileQCubBean;
import com.tencent.mobileqq.profilecard.bussiness.cub.ProfileQCubUtil;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qbox.datacard_manager.datacard_manager.DatacardManagerPB$GetActionReq;
import com.tencent.trpcprotocol.qbox.datacard_manager.datacard_manager.DatacardManagerPB$GetActionRsp;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J@\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016JB\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0014j\b\u0012\u0004\u0012\u00020\u0018`\u0016H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/profilecard/processor/ProfileQCubProcessor;", "Lcom/tencent/mobileqq/profilecard/processor/AbsProfileBusinessProcessor;", "appRuntime", "Lmqq/app/AppRuntime;", "(Lmqq/app/AppRuntime;)V", "onProcessProfileService", "", "params", "Landroid/os/Bundle;", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/mobileqq/data/Card;", "respHead", "LSummaryCard/RespHead;", "respSummeryCard", "LSummaryCard/RespSummaryCard;", "businessServices", "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/profilecard/entity/BusinessRespBuffer;", "onRequestProfileCard", IProfileProtocolConst.PARAM_REQ_SERVICES, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/profilecard/entity/BusinessReqBuffer;", "Lkotlin/collections/ArrayList;", IProfileProtocolConst.PARAM_REQ_0X5EB, "", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileQCubProcessor extends AbsProfileBusinessProcessor {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "ProfileQCubProcessor";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/profilecard/processor/ProfileQCubProcessor$Companion;", "", "()V", "TAG", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59745);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileQCubProcessor(@NotNull AppRuntime appRuntime) {
        super(appRuntime);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileService(@Nullable Bundle params, @Nullable Card card, @Nullable RespHead respHead, @Nullable RespSummaryCard respSummeryCard, @Nullable SparseArray<BusinessRespBuffer> businessServices) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, params, card, respHead, respSummeryCard, businessServices);
            return;
        }
        super.onProcessProfileService(params, card, respHead, respSummeryCard, businessServices);
        if (businessServices == null) {
            return;
        }
        BusinessRespBuffer businessRespBuffer = businessServices.get(25);
        if (businessRespBuffer != null) {
            bArr = businessRespBuffer.buffer;
        } else {
            bArr = null;
        }
        if (bArr != null) {
            DatacardManagerPB$GetActionRsp datacardManagerPB$GetActionRsp = new DatacardManagerPB$GetActionRsp();
            try {
                datacardManagerPB$GetActionRsp.mergeFrom(businessRespBuffer.buffer);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[onProcessProfileService] merge rsp fail", th5);
            }
            if (card != null) {
                card.qqCubIsBlack = datacardManagerPB$GetActionRsp.is_black.get();
            }
            if (!datacardManagerPB$GetActionRsp.can_show.get()) {
                QLog.d(TAG, 4, "[onProcessProfileService] q cub cannot show");
            } else if (card != null) {
                card.putBusinessInfo(new ProfileQCubBean(datacardManagerPB$GetActionRsp.action.get().material_url.get(), datacardManagerPB$GetActionRsp.action.get().desc.get(), datacardManagerPB$GetActionRsp.action.get().miniapp_url.get()));
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onRequestProfileCard(@Nullable Bundle params, @NotNull ArrayList<BusinessReqBuffer> reqServiceList, @NotNull ArrayList<Integer> req0x5ebList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, params, reqServiceList, req0x5ebList);
            return;
        }
        Intrinsics.checkNotNullParameter(reqServiceList, "reqServiceList");
        Intrinsics.checkNotNullParameter(req0x5ebList, "req0x5ebList");
        super.onRequestProfileCard(params, reqServiceList, req0x5ebList);
        if (!ProfileQCubUtil.INSTANCE.isShowProfileQCubExp()) {
            QLog.d(TAG, 4, "onRequestProfileCard isShowProfileQCubExp is false");
        } else {
            reqServiceList.add(new BusinessReqBuffer(25, new MessageMicro<DatacardManagerPB$GetActionReq>() { // from class: com.tencent.trpcprotocol.qbox.datacard_manager.datacard_manager.DatacardManagerPB$GetActionReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], DatacardManagerPB$GetActionReq.class);
            }.toByteArray()));
            req0x5ebList.add(Integer.valueOf(ProfileContants.FIELD_Q_CUB_SWITCH));
        }
    }
}
