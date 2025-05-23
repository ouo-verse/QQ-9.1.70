package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOIceBreakApi;
import com.tencent.qqnt.aio.icebreak.IceBreakingWelcomeWording;
import com.tencent.qqnt.kernel.nativeinterface.GroupAuthority;
import com.tencent.qqnt.kernel.nativeinterface.GroupPermission;
import com.tencent.qqnt.kernel.nativeinterface.GroupPermissions;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOIceBreakApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOIceBreakApi;", "Lmqq/app/AppRuntime;", "app", "", "respRaw", "", "cmd", "", "handleGetIceBreakHotPicResponse", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "senderUid", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "troopUin", "handleIceBreakBubbleWelcomeClick", "handlePreloadWelcomeWording", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOIceBreakApiImpl implements IAIOIceBreakApi {
    private static final String TAG = "AIOIceBreakApiImpl";

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOIceBreakApi
    public void handleGetIceBreakHotPicResponse(AppRuntime app, byte[] respRaw, String cmd) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(respRaw, "respRaw");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        if (Intrinsics.areEqual("BreakIceSvr.Pull", cmd) && (app instanceof QQAppInterface)) {
            Manager manager = app.getManager(QQManagerFactory.ICE_BREAKING_MNG);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng");
            ((IceBreakingMng) manager).A(respRaw);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090 A[EDGE_INSN: B:52:0x0090->B:42:0x0090 BREAK  A[LOOP:1: B:33:0x0079->B:49:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d6  */
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOIceBreakApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleIceBreakBubbleWelcomeClick(final com.tencent.aio.api.runtime.a aioContext, final String senderUid, final String senderUin, final String troopUin) {
        boolean z16;
        List<com.tencent.mobileqq.album.media.c> j3;
        GroupPermissions groupPermissions;
        ArrayList<GroupPermission> arrayList;
        Iterator<T> it;
        GroupPermission groupPermission;
        GroupAuthority groupAuthority;
        GroupPermissions groupPermissions2;
        ArrayList<GroupPermission> arrayList2;
        Object obj;
        GroupAuthority groupAuthority2;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(senderUid, "senderUid");
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        Object obj2 = null;
        boolean z17 = false;
        if (troopInfoFromCache != null && !troopInfoFromCache.isExited() && (groupPermissions2 = troopInfoFromCache.groupPermissions) != null && (arrayList2 = groupPermissions2.permissions) != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it5.next();
                    if (((GroupPermission) obj).key == 10002) {
                        break;
                    }
                }
            }
            GroupPermission groupPermission2 = (GroupPermission) obj;
            if (groupPermission2 != null && (groupAuthority2 = groupPermission2.authority) != null && groupAuthority2.switchVal == 2) {
                z16 = true;
                if (troopInfoFromCache != null && !troopInfoFromCache.isExited() && (groupPermissions = troopInfoFromCache.groupPermissions) != null && (arrayList = groupPermissions.permissions) != null) {
                    it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((GroupPermission) next).key == 10002) {
                            obj2 = next;
                            break;
                        }
                    }
                    groupPermission = (GroupPermission) obj2;
                    if (groupPermission != null && (groupAuthority = groupPermission.authority) != null && groupAuthority.eventIntVal == 2) {
                        z17 = true;
                    }
                }
                QLog.i(TAG, 1, "WelcomeClick isSwitchOn\uff1a" + z16 + " isPic\uff1a" + z17);
                if (z16 && z17) {
                    j3 = IceBreakingWelcomeWording.f351145a.j();
                    if (!j3.isEmpty()) {
                        aioContext.e().h(new AIOMsgSendEvent.SendAlbumMediaEvent(j3, true, false, 4, null));
                        return;
                    }
                }
                final QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(IceBreakingWelcomeWording.f351145a.k(), 32);
                ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(troopUin, senderUin, TAG, new Function1<TroopMemberNickInfo, Unit>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOIceBreakApiImpl$handleIceBreakBubbleWelcomeClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                        invoke2(troopMemberNickInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TroopMemberNickInfo troopMemberNickInfo) {
                        String showName = troopMemberNickInfo != null ? troopMemberNickInfo.getShowName() : null;
                        if (showName == null || showName.length() == 0) {
                            QLog.e("AIOIceBreakApiImpl", 1, "handleIceBreakBubbleWelcomeClick empty! troopUin = " + troopUin + " memberUin = " + senderUin);
                            return;
                        }
                        com.tencent.mvi.base.route.j e16 = aioContext.e();
                        String str = senderUid;
                        String str2 = senderUin;
                        QQText qQText2 = qQText;
                        e16.h(InputEditTextMsgIntent.ClearEditTextContent.f189408d);
                        e16.h(new InputAtMsgIntent.InsertAtMemberSpan(str, str2, showName, false));
                        String qQText3 = qQText2.toString();
                        Intrinsics.checkNotNullExpressionValue(qQText3, "content.toString()");
                        e16.h(new InputEditTextMsgIntent.AppendTextToEditText(qQText3, false, 2, null));
                    }
                });
            }
        }
        z16 = false;
        if (troopInfoFromCache != null) {
            it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                }
            }
            groupPermission = (GroupPermission) obj2;
            if (groupPermission != null) {
                z17 = true;
            }
        }
        QLog.i(TAG, 1, "WelcomeClick isSwitchOn\uff1a" + z16 + " isPic\uff1a" + z17);
        if (z16) {
            j3 = IceBreakingWelcomeWording.f351145a.j();
            if (!j3.isEmpty()) {
            }
        }
        final QQText qQText2 = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(IceBreakingWelcomeWording.f351145a.k(), 32);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(troopUin, senderUin, TAG, new Function1<TroopMemberNickInfo, Unit>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOIceBreakApiImpl$handleIceBreakBubbleWelcomeClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                invoke2(troopMemberNickInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopMemberNickInfo troopMemberNickInfo) {
                String showName = troopMemberNickInfo != null ? troopMemberNickInfo.getShowName() : null;
                if (showName == null || showName.length() == 0) {
                    QLog.e("AIOIceBreakApiImpl", 1, "handleIceBreakBubbleWelcomeClick empty! troopUin = " + troopUin + " memberUin = " + senderUin);
                    return;
                }
                com.tencent.mvi.base.route.j e16 = aioContext.e();
                String str = senderUid;
                String str2 = senderUin;
                QQText qQText22 = qQText2;
                e16.h(InputEditTextMsgIntent.ClearEditTextContent.f189408d);
                e16.h(new InputAtMsgIntent.InsertAtMemberSpan(str, str2, showName, false));
                String qQText3 = qQText22.toString();
                Intrinsics.checkNotNullExpressionValue(qQText3, "content.toString()");
                e16.h(new InputEditTextMsgIntent.AppendTextToEditText(qQText3, false, 2, null));
            }
        });
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOIceBreakApi
    public void handlePreloadWelcomeWording() {
        IceBreakingWelcomeWording iceBreakingWelcomeWording = IceBreakingWelcomeWording.f351145a;
    }
}
