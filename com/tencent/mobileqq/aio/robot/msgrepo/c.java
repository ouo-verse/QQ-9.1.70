package com.tencent.mobileqq.aio.robot.msgrepo;

import android.os.Bundle;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.aio.msglist.msgrepo.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTSList;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J(\u0010\u0010\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/msgrepo/c;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "Lcom/tencent/aio/data/msglist/a;", "list", "", "o", DomainData.DOMAIN_NAME, "j", "k", "", "", "source", "Landroid/os/Bundle;", "extra", "b", "msgItemList", "c", "", "i", "Z", "mSupportTts", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "msgCount", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends g<BaseMsgRepo> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mSupportTts;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int msgCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull AIOMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
    }

    private final void n() {
        RobotTTSList robotTTSList;
        ArrayList<TtsInfo> arrayList;
        boolean containsKey = d().g().l().containsKey("key_support_tts");
        boolean z16 = false;
        if (containsKey) {
            z16 = d().g().l().getBoolean("key_support_tts", false);
        } else {
            IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class);
            AIOParam g16 = d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            RobotCoreInfo robotCoreInfoFromFriendsCache = iRobotServiceApi.getRobotCoreInfoFromFriendsCache(su3.c.b(g16));
            if (robotCoreInfoFromFriendsCache != null && (robotTTSList = robotCoreInfoFromFriendsCache.ttsList) != null && (arrayList = robotTTSList.ttsList) != null) {
                z16 = !arrayList.isEmpty();
            }
        }
        this.mSupportTts = z16;
        QLog.i("TTSAbility", 1, "[initSupportTtsAbility]: support=" + z16 + ", hasTtsCustomParam=" + containsKey);
    }

    private final void o(List<? extends com.tencent.aio.data.msglist.a> list) {
        AIOMsgItem aIOMsgItem;
        for (com.tencent.aio.data.msglist.a aVar : list) {
            if (aVar instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) aVar;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null && !aVar.isSelf()) {
                aIOMsgItem.Z1(this.mSupportTts);
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void b(@NotNull List<com.tencent.aio.data.msglist.a> list, @NotNull String source, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(source, "source");
        if (list.size() == this.msgCount) {
            return;
        }
        this.msgCount = list.size();
        o(list);
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void c(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
        o(msgItemList);
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void j() {
        super.j();
        n();
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void k() {
        super.k();
        this.msgCount = 0;
    }
}
