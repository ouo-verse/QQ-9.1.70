package com.tencent.mobileqq.qwallet.hb.skin.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.QPayBaseFragment;
import com.tencent.mobileqq.qwallet.api.IQWalletServletApi;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GenShareArkMsgReq;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GenShareArkMsgRsp;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.a;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/share/HbSkinShareEntryFragment;", "Lcom/tencent/mobileqq/qwallet/QPayBaseFragment;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "skinId", "", "rh", "Lcom/tencent/mobileqq/qwallet/hb/skin/share/HbSkinShareEntryFragment$QQWalletShareSkinState;", "state", "qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "E", "I", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "QQWalletShareSkinState", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinShareEntryFragment extends QPayBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    private int skinId = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/share/HbSkinShareEntryFragment$QQWalletShareSkinState;", "", "retCode", "", "(Ljava/lang/String;II)V", "getRetCode", "()I", "Success", "Cancel", "Fail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum QQWalletShareSkinState {
        Success(1),
        Cancel(2),
        Fail(3);

        private final int retCode;

        QQWalletShareSkinState(int i3) {
            this.retCode = i3;
        }

        public final int getRetCode() {
            return this.retCode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qwallet/hb/skin/share/HbSkinShareEntryFragment$b", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$GenShareArkMsgRsp;", "Lpl2/a;", "rsp", "", "c", "", "errCode", "", "errMsg", "onFail", "Landroid/app/Activity;", "getActivity", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements o<RedPackSkin$GenShareArkMsgRsp>, pl2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f277885a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HbSkinShareEntryFragment f277886b;

        b(Activity activity, HbSkinShareEntryFragment hbSkinShareEntryFragment) {
            this.f277885a = activity;
            this.f277886b = hbSkinShareEntryFragment;
        }

        @Override // pl2.k
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull RedPackSkin$GenShareArkMsgRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            String stringUtf8 = rsp.ark_msg.get().toStringUtf8();
            QLog.i("HbSkinShareEntryFragment", 1, "onSuccess: " + stringUtf8);
            a.f277887a.a(this.f277885a, stringUtf8, 21);
        }

        @Override // pl2.a
        @Nullable
        /* renamed from: getActivity, reason: from getter */
        public Activity getF277885a() {
            return this.f277885a;
        }

        @Override // pl2.b
        @Nullable
        public Context getContext() {
            return a.C11026a.a(this);
        }

        @Override // pl2.b
        public boolean isAlive() {
            return a.C11026a.b(this);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("HbSkinShareEntryFragment", 1, "onFail: " + errCode + " " + errMsg);
            this.f277886b.qh(QQWalletShareSkinState.Fail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qh(QQWalletShareSkinState state) {
        QLog.i("HbSkinShareEntryFragment", 1, "share callback " + state);
        Intent intent = new Intent();
        intent.putExtra("KEY_OUT_SHARE_CODE", state);
        intent.putExtra("KEY_OUT_SHARE_SKIN_ID", this.skinId);
        setResult(-1, intent);
        finish();
    }

    private final void rh(Activity activity, int skinId) {
        b bVar = new b(activity, this);
        QRouteApi api = QRoute.api(IQWalletServletApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletServletApi::class.java)");
        IQWalletServletApi iQWalletServletApi = (IQWalletServletApi) api;
        RedPackSkin$GenShareArkMsgReq redPackSkin$GenShareArkMsgReq = new RedPackSkin$GenShareArkMsgReq();
        redPackSkin$GenShareArkMsgReq.skin_id.set(skinId);
        Unit unit = Unit.INSTANCE;
        IQWalletServletApi.a.a(iQWalletServletApi, "trpc.qpay.red_pack_skin.Skin", "GenShareArkMsg", redPackSkin$GenShareArkMsgReq, (MessageMicro) RedPackSkin$GenShareArkMsgRsp.class.newInstance(), false, false, true, bVar, 48, null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 21) {
            return;
        }
        if (resultCode == -1) {
            qh(QQWalletShareSkinState.Success);
        } else {
            qh(QQWalletShareSkinState.Cancel);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.QPayBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i3;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            i3 = arguments.getInt("KEY_IN_PARAM_SKIN_ID", -1);
        } else {
            i3 = -1;
        }
        this.skinId = i3;
        if (i3 == -1) {
            qh(QQWalletShareSkinState.Fail);
        } else {
            rh(getActivity(), this.skinId);
        }
    }
}
