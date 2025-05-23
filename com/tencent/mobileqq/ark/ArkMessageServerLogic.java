package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import com.tencent.ark.ArkAppPanelList;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkMessageServerLogic {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(ArrayList<h> arrayList);
    }

    public static void a(final a aVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ark.ArkMessageServerLogic.1

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.ark.ArkMessageServerLogic$1$a */
            /* loaded from: classes11.dex */
            class a implements BusinessObserver {
                a() {
                }

                @Override // com.tencent.mobileqq.app.BusinessObserver
                public void onUpdate(int i3, boolean z16, Object obj) {
                    List<ArkAppPanelList.AppDetail> list = null;
                    if (z16 && obj != null) {
                        ArkAppPanelList.RespBody respBody = new ArkAppPanelList.RespBody();
                        try {
                            respBody.mergeFrom((byte[]) obj);
                            ArrayList<h> arrayList = new ArrayList<>();
                            if (respBody.apps.has()) {
                                list = respBody.apps.get();
                            }
                            if (list != null && list.size() > 0) {
                                for (ArkAppPanelList.AppDetail appDetail : list) {
                                    if (appDetail != null) {
                                        String str = appDetail.appName.get();
                                        String str2 = appDetail.cnName.get();
                                        String str3 = appDetail.iconUrl.get();
                                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                                            arrayList.add(new h(str, str2, str3));
                                        }
                                    }
                                }
                            }
                            a aVar = a.this;
                            if (aVar != null) {
                                aVar.a(arrayList);
                                return;
                            }
                            return;
                        } catch (InvalidProtocolBufferMicroException e16) {
                            d.d("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList mergeFrom exception=" + e16);
                            a aVar2 = a.this;
                            if (aVar2 != null) {
                                aVar2.a(null);
                                return;
                            }
                            return;
                        }
                    }
                    a aVar3 = a.this;
                    if (aVar3 != null) {
                        aVar3.a(null);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                p sso = ((IArkService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IArkService.class, "all")).getSSO();
                if (sso == null) {
                    d.d("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, ark sso is null");
                } else if (!sso.a("ArkAppPanel.List", 10000, 0, new a())) {
                    d.d("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, fail send sso request");
                } else {
                    return;
                }
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.a(null);
                }
            }
        }, 5, null, true);
    }
}
