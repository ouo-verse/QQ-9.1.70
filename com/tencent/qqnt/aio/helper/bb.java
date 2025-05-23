package com.tencent.qqnt.aio.helper;

import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/helper/bb;", "Lcom/tencent/aio/main/businesshelper/h;", "", "a", "", "b", "e", "c", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Ljava/lang/Integer;", "chatType", "Ljava/lang/String;", "peerUid", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "<init>", "()V", tl.h.F, "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class bb implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Integer chatType = 0;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String peerUid = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/bb$b", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$a;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqgamepub/data/QQGameMsgInfo;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IQQGamePubMsgApi.a {
        b() {
        }

        @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.a
        public void onSuccess(ArrayList<QQGameMsgInfo> msgList) {
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            Iterator<QQGameMsgInfo> it = msgList.iterator();
            while (it.hasNext()) {
                QQGameMsgInfo next = it.next();
                if (!TextUtils.isEmpty(next.arkAppName)) {
                    ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).addNotify(next.arkAppName);
                }
            }
        }
    }

    private final void a() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new PAInputIntent.InputContainerVisibleIntent(8));
    }

    private final boolean b() {
        Integer num = this.chatType;
        return num != null && num.intValue() == 103 && Intrinsics.areEqual(this.peerUid, "u_-PBswiplK-7J7bmaQLA-mA");
    }

    private final void c() {
        if (Math.abs(System.currentTimeMillis() - ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getClickAioTime()) > 500) {
            ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).initClickAioTime();
        }
    }

    private final void e() {
        ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).getBusinessMsgList(100, 100, new b(), "registerArkEvent");
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350626d0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "GamePubHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        AIOSession r16;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        AIOParam g16 = a16.g();
        AIOContact c16 = (g16 == null || (r16 = g16.r()) == null) ? null : r16.c();
        this.chatType = c16 != null ? Integer.valueOf(c16.e()) : null;
        this.peerUid = c16 != null ? c16.j() : null;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (b() && state == 0) {
            a();
            e();
            c();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0};
    }
}
