package com.tencent.mobileqq.vas.graytips.api.impl;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.vas.graytips.api.IVasGrayTips;
import com.tencent.mobileqq.vas.graytips.api.impl.VasGrayTipsImpl;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip$FromChannel;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip$PlatformComm;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip$UniAIOTipsReq;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip$UniAIOTipsRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/graytips/api/impl/VasGrayTipsImpl;", "Lcom/tencent/mobileqq/vas/graytips/api/IVasGrayTips;", "", "cmd", "Lcom/tencent/pb/vas/uni_gray_tip/UniGrayTip$FromChannel;", WadlProxyConsts.CHANNEL, "", "", "map", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observer", "", "requestUnitGrayTips", "peerType", "transformFrom", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasGrayTipsImpl implements IVasGrayTips {
    public static final long AND_PLATFORM = 109;
    public static final int CHANNEL_DISCUSSION = 3;
    public static final int CHANNEL_FRIEND = 1;
    public static final int CHANNEL_TROOP = 2;

    @NotNull
    public static final String CMD = "trpc.qqva.uni_gray_tip.UniGrayTip.UniAIOTips";

    @NotNull
    public static final String TAG = "VasGrayTipsRequestImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestUnitGrayTips$lambda$0(BusinessObserver businessObserver, int i3, boolean z16, Object obj) {
        if (businessObserver != null) {
            businessObserver.onUpdate(i3, z16, obj);
        }
        QLog.d(TAG, 2, "result: " + i3 + " ; " + z16);
    }

    @Override // com.tencent.mobileqq.vas.graytips.api.IVasGrayTips
    public void requestUnitGrayTips(int cmd, @NotNull UniGrayTip$FromChannel channel, @Nullable Map<String, String> map, @Nullable final BusinessObserver observer) {
        int i3;
        Intrinsics.checkNotNullParameter(channel, "channel");
        String str = "";
        if (map != null) {
            try {
                String jSONObject = new JSONObject(map).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(map).toString()");
                str = jSONObject;
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.d(TAG, 1, "json error " + e16.getMessage());
            }
        }
        UniGrayTip$UniAIOTipsReq uniGrayTip$UniAIOTipsReq = new UniGrayTip$UniAIOTipsReq();
        UniGrayTip$PlatformComm uniGrayTip$PlatformComm = new UniGrayTip$PlatformComm();
        uniGrayTip$PlatformComm.platForm.set(109L);
        uniGrayTip$PlatformComm.osver.set(Build.VERSION.RELEASE);
        uniGrayTip$PlatformComm.mqqver.set(AppSetting.f99554n);
        uniGrayTip$UniAIOTipsReq.platInfo.set(uniGrayTip$PlatformComm);
        uniGrayTip$UniAIOTipsReq.cmd.set(cmd);
        uniGrayTip$UniAIOTipsReq.from.set(channel);
        uniGrayTip$UniAIOTipsReq.exInfo.set(ByteStringMicro.copyFromUtf8(str));
        if (QLog.isColorLevel()) {
            if (channel.channel.has()) {
                i3 = channel.channel.get();
            } else {
                i3 = -1;
            }
            QLog.d(TAG, 2, "cmd: " + cmd + " channelId: " + i3 + " json: " + str);
        }
        VasUtil.getService().getPbRequest().request(CMD, uniGrayTip$UniAIOTipsReq, UniGrayTip$UniAIOTipsRsp.class, new BusinessObserver() { // from class: h13.a
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i16, boolean z16, Object obj) {
                VasGrayTipsImpl.requestUnitGrayTips$lambda$0(BusinessObserver.this, i16, z16, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.graytips.api.IVasGrayTips
    public int transformFrom(int peerType) {
        if (peerType != 1) {
            if (peerType != 3000) {
                return 1;
            }
            return 3;
        }
        return 2;
    }
}
