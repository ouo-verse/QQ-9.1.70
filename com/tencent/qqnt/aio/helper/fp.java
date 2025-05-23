package com.tencent.qqnt.aio.helper;

import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001\u001b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/helper/fp;", "Lcom/tencent/aio/main/businesshelper/h;", "", "b", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/app/FriendListHandler;", "e", "Lcom/tencent/mobileqq/app/FriendListHandler;", "friendListHandler", "f", "Ljava/lang/String;", "peerUin", "com/tencent/qqnt/aio/helper/fp$b", tl.h.F, "Lcom/tencent/qqnt/aio/helper/fp$b;", "friendListObserver", "<init>", "()V", "i", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class fp implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FriendListHandler friendListHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String peerUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b friendListObserver = new b();

    private final void b() {
        FriendListHandler friendListHandler = this.friendListHandler;
        String str = null;
        if (friendListHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListHandler");
            friendListHandler = null;
        }
        String str2 = this.peerUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
        } else {
            str = str2;
        }
        friendListHandler.getFriendInfo(str, true);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350635g0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "WPATitleHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        Intrinsics.checkNotNull(a16);
        AIOParam g16 = a16.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext!!.aioParam");
        this.peerUin = su3.c.b(g16);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime).addObserver(this.friendListObserver);
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        BusinessHandler businessHandler = ((QQAppInterface) peekAppRuntime2).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendListHandler");
        this.friendListHandler = (FriendListHandler) businessHandler;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime).removeObserver(this.friendListObserver);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 0, 4};
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/fp$b", "Lcom/tencent/mobileqq/app/ar;", "", "uin", "", "isSuccess", "", "onUpdateFriendInfo", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.app.ar {
        b() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String uin, boolean isSuccess) {
            if (isSuccess) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                String R = com.tencent.mobileqq.utils.ac.R((QQAppInterface) peekAppRuntime, uin, 1005);
                QLog.i("WPATitleHelper", 1, "nick name: " + R);
                if (TextUtils.isEmpty(R)) {
                    return;
                }
                com.tencent.aio.api.runtime.a aVar = fp.this.aioContext;
                Intrinsics.checkNotNull(aVar);
                aVar.g().l().putString("key_chat_name", R);
                com.tencent.aio.api.runtime.a aVar2 = fp.this.aioContext;
                Intrinsics.checkNotNull(aVar2);
                aVar2.e().h(new AIOTitleEvent.TitleResponseEvent(4, R));
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 4) {
            b();
        } else {
            if (state != 12) {
                return;
            }
            onDestroy();
        }
    }
}
