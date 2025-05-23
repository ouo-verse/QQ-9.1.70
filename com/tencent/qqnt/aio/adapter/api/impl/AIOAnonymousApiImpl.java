package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.component.network.utils.Base64;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.TroopAnonyRevokeConfProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOAnonymousApi;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOAnonymousApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOAnonymousApi;", "", "isSupportRevokeAnonymousMsg", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "openAnonymousMemberProfile", "", "memberUin", "", "getRobotDrawableId", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOAnonymousApiImpl implements IAIOAnonymousApi {
    public static final String TAG = "AIOAnonymousApiImpl";

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAnonymousApi
    public int getRobotDrawableId(String memberUin) {
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && com.tencent.mobileqq.troop.utils.k.l(peekAppRuntime, memberUin)) {
            return R.drawable.qq_troop_bot_icon;
        }
        return 0;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAnonymousApi
    public boolean isSupportRevokeAnonymousMsg() {
        boolean z16 = TroopAnonyRevokeConfProcessor.a().f202817a;
        QLog.d(TAG, 1, "isSupportRevokeAnonymousMsg = " + z16);
        return z16;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAnonymousApi
    public void openAnonymousMemberProfile(com.tencent.aio.api.runtime.a context, AIOMsgItem msgItem) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (context.c() == null || context.c().getContext() == null) {
            return;
        }
        AnonymousExtInfo anonymousExtInfo = msgItem.getMsgRecord().anonymousExtInfo;
        int k3 = com.tencent.biz.anonymous.a.k(String.valueOf(msgItem.getMsgRecord().peerUin));
        byte[] bArr = anonymousExtInfo.anonymousId;
        if (TextUtils.isEmpty(anonymousExtInfo.anonymousNick)) {
            str = "";
        } else {
            str = anonymousExtInfo.anonymousNick;
        }
        String f16 = com.tencent.biz.anonymous.a.f((int) anonymousExtInfo.headPicIndex);
        Intent intent = new Intent(context.c().getContext(), (Class<?>) QQBrowserActivity.class);
        QLog.d(TAG, 1, "openAnonymousMemberProfile| extInfo = " + anonymousExtInfo);
        QLog.d(TAG, 1, "openAnonymousMemberProfile| role=" + k3 + ", byteArray=" + bArr + ", nickName=" + str + ", avatarUrl=" + f16);
        if (bArr != null && msgItem.getMsgRecord().sendType == 0) {
            String encode = URLEncoder.encode(Base64.encodeToString(bArr, 2));
            com.tencent.biz.anonymous.a.f78360i = msgItem.getMsgRecord().msgSeq;
            str2 = "https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=" + encode + "&gcode=" + su3.b.b(context.g().r()).f179557e + "&avatar=" + f16 + "&nick=" + str + "&role=" + k3 + "&self=0";
        } else if (msgItem.getMsgRecord().sendType != 0) {
            str2 = "https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=" + su3.b.b(context.g().r()).f179557e + "&avatar=" + f16 + "&nick=" + str + "&role=" + k3 + "&self=1";
        } else {
            str2 = null;
        }
        QLog.d(TAG, 1, "openAnonymousMemberProfile| open friends profile, url = " + str2);
        intent.putExtra("url", str2);
        Context context2 = context.c().getContext();
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context2).startActivity(intent);
    }
}
