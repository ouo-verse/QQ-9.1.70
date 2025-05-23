package fr;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.aelight.camera.favemoticon.api.IFavEmoticonIPCServerApi;
import com.tencent.mobileqq.emosm.favroaming.o;
import com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f400335d;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements o {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f400336a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f400337b;

        a(Bundle bundle, int i3) {
            this.f400336a = bundle;
            this.f400337b = i3;
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.o
        public void a() {
            this.f400336a.putString("sync_fav_data_from_server_result", "success");
            d.this.callbackResult(this.f400337b, EIPCResult.createResult(0, this.f400336a));
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.o
        public void notifySyncFail() {
            this.f400336a.putString("sync_fav_data_from_server_result", "fail");
            d.this.callbackResult(this.f400337b, EIPCResult.createResult(0, this.f400336a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements com.tencent.mobileqq.emosm.favroaming.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f400339a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f400340b;

        b(Bundle bundle, int i3) {
            this.f400339a = bundle;
            this.f400340b = i3;
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.a
        public void a(HashMap<Integer, String> hashMap) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(hashMap);
            this.f400339a.putParcelableArrayList("fav_accessibility_data", arrayList);
            d.this.callbackResult(this.f400340b, EIPCResult.createResult(0, this.f400339a));
            ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).removeAccessibilityListener();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class c implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f400342d;

        c(o oVar) {
            this.f400342d = oVar;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            QLog.d(IFavEmoticonIPCServerApi.MODULE_NAME_FAV_EMOTICON, 1, "sync from server result\uff1a" + eIPCResult.code);
            if (this.f400342d == null || eIPCResult.code != 0 || (bundle = eIPCResult.data) == null) {
                return;
            }
            if ("success".equals(bundle.get("sync_fav_data_from_server_result"))) {
                this.f400342d.a();
            } else {
                this.f400342d.notifySyncFail();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: fr.d$d, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10334d implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.emosm.favroaming.a f400344d;

        C10334d(com.tencent.mobileqq.emosm.favroaming.a aVar) {
            this.f400344d = aVar;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            ArrayList parcelableArrayList;
            QLog.d(IFavEmoticonIPCServerApi.MODULE_NAME_FAV_EMOTICON, 1, "get accessibility data result: " + eIPCResult.code);
            if (this.f400344d == null || eIPCResult.code != 0 || (bundle = eIPCResult.data) == null || (parcelableArrayList = bundle.getParcelableArrayList("fav_accessibility_data")) == null || parcelableArrayList.size() <= 0) {
                return;
            }
            this.f400344d.a((HashMap) parcelableArrayList.get(0));
        }
    }

    public d(String str) {
        super(str);
    }

    public static d c() {
        if (f400335d == null) {
            synchronized (d.class) {
                if (f400335d == null) {
                    f400335d = new d(IFavEmoticonIPCServerApi.MODULE_NAME_FAV_EMOTICON);
                }
            }
        }
        return f400335d;
    }

    public void b(o oVar) {
        QIPCClientHelper.getInstance().callServer(IFavEmoticonIPCServerApi.MODULE_NAME_FAV_EMOTICON, "ACTION_SYNC_FAV_EMOTION_FROM_SERVER", new Bundle(), new c(oVar));
    }

    public void getAccessibilityData(com.tencent.mobileqq.emosm.favroaming.a aVar) {
        QIPCClientHelper.getInstance().callServer(IFavEmoticonIPCServerApi.MODULE_NAME_FAV_EMOTICON, "ACTION_GET_FAV_EMOTION_ACCESSIBILITY_DATA", new Bundle(), new C10334d(aVar));
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        QLog.d(IFavEmoticonIPCServerApi.MODULE_NAME_FAV_EMOTICON, 1, "action: " + str + ", callbackId:" + i3);
        Bundle bundle2 = new Bundle();
        if ("ACTION_GET_FAV_EMOTION_DATA_FROM_DB".equals(str)) {
            bundle2.putParcelableArrayList("fav_emoticon_data", ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).getEmoticonData());
            return EIPCResult.createResult(0, bundle2);
        }
        if ("ACTION_SYNC_FAV_EMOTION_FROM_SERVER".equals(str)) {
            ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).triggerToSyncFromServer(new a(bundle2, i3));
            return null;
        }
        if ("ACTION_GET_FAV_EMOTION_ACCESSIBILITY_DATA".equals(str)) {
            ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).getAccessibilityData(new b(bundle2, i3));
        }
        return null;
    }
}
