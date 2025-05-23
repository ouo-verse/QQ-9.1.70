package com.tencent.aelight.camera.aeeditor.manage;

import android.os.Bundle;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigManager;
import com.tencent.aelight.camera.qipc.api.IAEEditorEffectIpc;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f66157d = false;

    /* renamed from: e, reason: collision with root package name */
    private static volatile a f66158e;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aeeditor.manage.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0569a implements AEEditorEffectConfigManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f66159a;

        C0569a(int i3) {
            this.f66159a = i3;
        }

        @Override // com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigManager.a
        public void a(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("effect_group_json_path", str);
            a.this.callbackResult(this.f66159a, EIPCResult.createSuccessResult(bundle));
        }
    }

    a() {
        super(IAEEditorEffectIpc.NAME);
    }

    public static a b() {
        if (f66158e == null) {
            synchronized (a.class) {
                if (f66158e == null) {
                    f66158e = new a();
                }
            }
        }
        return f66158e;
    }

    public static void registerModule() {
        if (f66157d) {
            return;
        }
        f66157d = true;
        QIPCClientHelper.getInstance().getClient().registerModule(b());
    }

    public static void unRegisterModule() {
        if (f66157d) {
            f66157d = false;
            QIPCClientHelper.getInstance().getClient().unRegisterModule(b());
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (!"action_get_effect_list".equals(str)) {
            return null;
        }
        AEEditorEffectConfigManager.f().e(new C0569a(i3));
        return null;
    }
}
