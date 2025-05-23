package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildInnerKeyboardApi;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.IClickInlineKeyboardButtonCallback;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardClickInfo;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import xw1.RobotClickReply;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildInnerKeyboardApiImpl implements IGuildInnerKeyboardApi {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f214384a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ vw1.b f214385b;

        a(String[] strArr, vw1.b bVar) {
            this.f214384a = strArr;
            this.f214385b = bVar;
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ri1.a aVar, List<RoleGroupModel> list) {
            boolean z16 = false;
            if (list != null) {
                HashSet hashSet = new HashSet();
                for (String str : this.f214384a) {
                    hashSet.add(str);
                }
                Iterator<RoleGroupModel> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (hashSet.contains(it.next().getId())) {
                            z16 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.f214385b.a(z16);
                return;
            }
            this.f214385b.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$clickCallbackButton$0(int i3, vw1.a aVar, String str, int i16, String str2, int i17, int i18) {
        if (i3 != 0) {
            aVar.onError(i3, str);
        } else {
            aVar.a(new RobotClickReply(i16, str2, i17, i18));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$clickCallbackButton$1(final vw1.a aVar, final int i3, final String str, final int i16, final String str2, final int i17, final int i18) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.api.impl.r
            @Override // java.lang.Runnable
            public final void run() {
                GuildInnerKeyboardApiImpl.lambda$clickCallbackButton$0(i3, aVar, str, i16, str2, i17, i18);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInnerKeyboardApi
    public void clickCallbackButton(String str, long j3, long j16, long j17, long j18, String str2, final vw1.a aVar) {
        ((IMsgService) QRoute.api(IMsgService.class)).clickInlineKeyboardButton(new InlineKeyboardClickInfo(String.valueOf(j3), String.valueOf(j16), j17, j18, str, str2, 0, 4), new IClickInlineKeyboardButtonCallback() { // from class: com.tencent.mobileqq.guild.api.impl.q
            @Override // com.tencent.qqnt.kernel.nativeinterface.IClickInlineKeyboardButtonCallback
            public final void onResult(int i3, String str3, int i16, String str4, int i17, int i18) {
                GuildInnerKeyboardApiImpl.lambda$clickCallbackButton$1(vw1.a.this, i3, str3, i16, str4, i17, i18);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInnerKeyboardApi
    public void permissionRole(String str, String str2, String str3, String[] strArr, vw1.b bVar) {
        com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().f(str, str3, new a(strArr, bVar));
    }
}
