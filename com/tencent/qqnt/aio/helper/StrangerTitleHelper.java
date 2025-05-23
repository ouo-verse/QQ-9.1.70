package com.tencent.qqnt.aio.helper;

import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/helper/StrangerTitleHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "g", "", "e", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "info", "i", "uid", "c", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class StrangerTitleHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    private final String c(String uid) {
        com.tencent.qqnt.kernel.api.m b16;
        String str;
        if (uid == null || TextUtils.isEmpty(uid) || (b16 = com.tencent.qqnt.msg.f.b()) == null) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        Map<String, String> buddyRemark = b16.getBuddyRemark(arrayList);
        return (buddyRemark == null || (str = buddyRemark.get(uid)) == null) ? "" : str;
    }

    private final String e() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null || (g16 = aVar2.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return null;
        }
        aVar.d(j3);
        return ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
    }

    private final void g() {
        com.tencent.mvi.base.route.j e16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.mvi.base.route.j e17;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g17;
        AIOSession r17;
        AIOContact c17;
        AIOParam g18;
        AIOSession r18;
        AIOContact c18;
        AIOParam g19;
        AIOSession r19;
        AIOContact c19;
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        String j3 = (aVar2 == null || (g19 = aVar2.g()) == null || (r19 = g19.r()) == null || (c19 = r19.c()) == null) ? null : c19.j();
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if ((aVar3 == null || (g18 = aVar3.g()) == null || (r18 = g18.r()) == null || (c18 = r18.c()) == null || c18.e() != 101) ? false : true) {
            String c26 = c(j3);
            if (TextUtils.isEmpty(c26) && (c26 = e()) == null) {
                c26 = "";
            }
            if (TextUtils.isEmpty(c26) && ((aVar = this.mAIOContext) == null || (g17 = aVar.g()) == null || (r17 = g17.r()) == null || (c17 = r17.c()) == null || (c26 = c17.g()) == null)) {
                c26 = "";
            }
            com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
            if (aVar4 != null && (e17 = aVar4.e()) != null) {
                e17.h(new AIOTitleEvent.TitleResponseEvent(4, c26));
            }
        }
        com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
        if ((aVar5 == null || (g16 = aVar5.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || c16.e() != 100) ? false : true) {
            String c27 = c(j3);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            if (TextUtils.isEmpty(c27)) {
                com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "")).getMsgService();
                if (msgService != null) {
                    msgService.getTempChatInfo(100, j3, new IGetTempChatInfoCallback() { // from class: com.tencent.qqnt.aio.helper.df
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
                        public final void onResult(int i3, String str, TempChatInfo tempChatInfo) {
                            StrangerTitleHelper.h(StrangerTitleHelper.this, i3, str, tempChatInfo);
                        }
                    });
                    return;
                }
                return;
            }
            com.tencent.aio.api.runtime.a aVar6 = this.mAIOContext;
            if (aVar6 == null || (e16 = aVar6.e()) == null) {
                return;
            }
            e16.h(new AIOTitleEvent.TitleResponseEvent(4, c27));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final StrangerTitleHelper this$0, int i3, String str, TempChatInfo tempChatInfo) {
        AIOParam g16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String groupCode = tempChatInfo != null ? tempChatInfo.getGroupCode() : null;
        com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
        String b16 = (aVar == null || (g16 = aVar.g()) == null) ? null : su3.c.b(g16);
        if (!TextUtils.isEmpty(groupCode) && !TextUtils.isEmpty(b16)) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(groupCode, b16, "StrangerTitleHelper", new Function1<TroopMemberNickInfo, Unit>() { // from class: com.tencent.qqnt.aio.helper.StrangerTitleHelper$updateTitle$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    StrangerTitleHelper.this.i(troopMemberNickInfo);
                }
            });
        } else {
            this$0.i(null);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350659o0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "StrangerTitleHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mAIOContext = param.a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 3};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(TroopMemberNickInfo info) {
        com.tencent.mvi.base.route.j e16;
        AIOParam g16;
        String str = null;
        String showName = info != null ? info.getShowName(false, true) : null;
        if (TextUtils.isEmpty(showName)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar != null && (g16 = aVar.g()) != null) {
                str = su3.c.b(g16);
            }
            showName = com.tencent.mobileqq.utils.ac.H(qQAppInterface, str);
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null || (e16 = aVar2.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.TitleResponseEvent(4, showName));
    }
}
