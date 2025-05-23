package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.api.IVasReadPublicAccount;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasReadPublicAccountImpl;", "Lcom/tencent/mobileqq/vas/api/IVasReadPublicAccount;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "startVipReadFragment", "", "uin", "", "isVipRead", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasReadPublicAccountImpl implements IVasReadPublicAccount {
    public static final String TAG = "VasReadPublicAccountImpl";
    private static final UnitedProxy config = com.tencent.mobileqq.vas.ar.INSTANCE.b("linkliang", "2024-12-12", "vas_kuikly_novel_account_9130");

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVipReadFragment$lambda$0(VasReadPublicAccountImpl this$0, Context context, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startVipReadFragment(context, arrayList);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReadPublicAccount
    public boolean isVipRead(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return TextUtils.equals(AppConstants.QQ_VIP_READ_UIN, uin) && config.isEnable(false);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReadPublicAccount
    public void startVipReadFragment(final Context context) {
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(new Contact(103, IVasReadPublicAccount.READ_UID, ""), 0L, 10, true, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.vas.api.impl.an
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                VasReadPublicAccountImpl.startVipReadFragment$lambda$0(VasReadPublicAccountImpl.this, context, i3, str, arrayList);
            }
        });
    }

    private final void startVipReadFragment(Context context, ArrayList<MsgRecord> msgList) {
        String stringDataSet = config.getStringDataSet("kuikly_url", "mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_novel_public_account&bundle_name=vas_qqvip_novel_public_account");
        QLog.i(TAG, 1, "src feed kuikly url: " + stringDataSet);
        IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class);
        JSONArray a16 = s23.a.a(AppConstants.QQ_VIP_READ_UIN, msgList);
        Intrinsics.checkNotNullExpressionValue(a16, "buildJSONArrFromMsgList(\u2026QQ_VIP_READ_UIN, msgList)");
        iVasKuiklyApi.setMqqToKuiklyData("readpublicaccount", a16);
        QLog.i(TAG, 1, "final feed kuikl url: " + stringDataSet);
        IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(stringDataSet);
        iVasHybridRoute.openKuiklySchema(context, stringDataSet, null);
    }
}
