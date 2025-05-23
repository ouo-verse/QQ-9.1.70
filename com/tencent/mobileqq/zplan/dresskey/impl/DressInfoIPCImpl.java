package com.tencent.mobileqq.zplan.dresskey.impl;

import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.mobileqq.zplan.dresskey.api.DressInfoIPCData;
import dw4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r94.c;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001c\u0010\u000b\u001a\b\u0018\u00010\nR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/dresskey/impl/DressInfoIPCImpl;", "Leh3/a;", "", "releaseCallback", "", "scene", IZplanHandleApi.METHOD_REFRESH_DRESS_INFO, "Leh3/b;", "callback", "getDefaultAvatarCharacter", "Lcom/tencent/mobileqq/zplan/dresskey/impl/DressInfoIPCImpl$a;", "getDressInfoCallback", "Lcom/tencent/mobileqq/zplan/dresskey/impl/DressInfoIPCImpl$a;", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class DressInfoIPCImpl implements eh3.a {
    private a getDressInfoCallback;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/dresskey/impl/DressInfoIPCImpl$a;", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldw4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "Leh3/b;", "d", "Leh3/b;", "getCallback", "()Leh3/b;", "b", "(Leh3/b;)V", "callback", "<init>", "(Lcom/tencent/mobileqq/zplan/dresskey/impl/DressInfoIPCImpl;Leh3/b;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class a implements e<b> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private eh3.b callback;

        public a(eh3.b bVar) {
            this.callback = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(b result) {
            DressInfoIPCData dressInfoIPCData;
            DressInfoIPCData dressInfoIPCData2;
            Intrinsics.checkNotNullParameter(result, "result");
            qu4.a aVar = result.f395119f;
            JSONObject h16 = aVar != null ? c.h(aVar) : null;
            qu4.a aVar2 = result.f395120g;
            JSONObject h17 = aVar2 != null ? c.h(aVar2) : null;
            if (h16 == null) {
                dressInfoIPCData = new DressInfoIPCData("", -100, "maleAvatarInfoDefault is null");
            } else {
                String jSONObject = h16.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "maleAvatarInfoDefault.toString()");
                dressInfoIPCData = new DressInfoIPCData(jSONObject, 0, "");
            }
            if (h17 == null) {
                dressInfoIPCData2 = new DressInfoIPCData("", -100, "femaleAvatarInfoDefault is null");
            } else {
                String jSONObject2 = h17.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "femaleAvatarInfoDefault.toString()");
                dressInfoIPCData2 = new DressInfoIPCData(jSONObject2, 0, "");
            }
            eh3.b bVar = this.callback;
            if (bVar != null) {
                bVar.a(dressInfoIPCData, dressInfoIPCData2);
            }
            DressInfoIPCImpl.this.releaseCallback();
        }

        public final void b(eh3.b bVar) {
            this.callback = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            if (message == null) {
                message = "";
            }
            DressInfoIPCData dressInfoIPCData = new DressInfoIPCData("", error, message);
            eh3.b bVar = this.callback;
            if (bVar != null) {
                bVar.a(dressInfoIPCData, dressInfoIPCData);
            }
            DressInfoIPCImpl.this.releaseCallback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseCallback() {
        a aVar = this.getDressInfoCallback;
        if (aVar != null) {
            aVar.b(null);
        }
        this.getDressInfoCallback = null;
    }

    @Override // eh3.a
    public void getDefaultAvatarCharacter(eh3.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a(callback);
        this.getDressInfoCallback = aVar;
        com.tencent.sqshow.dresskey.b bVar = com.tencent.sqshow.dresskey.b.f369818a;
        Intrinsics.checkNotNull(aVar);
        bVar.k("mod_enter", true, aVar);
    }

    @Override // eh3.a
    public void refreshDressInfo(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        com.tencent.sqshow.dresskey.b.f369818a.t(scene, true);
    }
}
