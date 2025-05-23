package com.tencent.mobileqq.pluspanel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public abstract class AIOPanelIconConfigProcessor extends l<a> {
    static IPatchRedirector $redirector_;

    /* loaded from: classes16.dex */
    public static final class C2CPanelConfigProcessor extends AIOPanelIconConfigProcessor {
        static IPatchRedirector $redirector_;

        public C2CPanelConfigProcessor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor
        protected int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return w.CTRL_INDEX;
        }

        @Override // com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor, com.tencent.mobileqq.config.l
        @NonNull
        public /* bridge */ /* synthetic */ a migrateOldOrDefaultContent(int i3) {
            return super.migrateOldOrDefaultContent(i3);
        }

        @Override // com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor, com.tencent.mobileqq.config.l
        @Nullable
        public /* bridge */ /* synthetic */ a onParsed(ai[] aiVarArr) throws QStorageInstantiateException {
            return super.onParsed(aiVarArr);
        }

        @Override // com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor, com.tencent.mobileqq.config.l
        public /* bridge */ /* synthetic */ void onUpdate(a aVar) {
            super.onUpdate(aVar);
        }
    }

    @Deprecated
    /* loaded from: classes16.dex */
    public static final class TroopPanelConfigProcessor extends AIOPanelIconConfigProcessor {
        static IPatchRedirector $redirector_;

        public TroopPanelConfigProcessor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor
        protected int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return w.CTRL_INDEX;
        }

        @Override // com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor, com.tencent.mobileqq.config.l
        @NonNull
        public /* bridge */ /* synthetic */ a migrateOldOrDefaultContent(int i3) {
            return super.migrateOldOrDefaultContent(i3);
        }

        @Override // com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor, com.tencent.mobileqq.config.l
        @Nullable
        public /* bridge */ /* synthetic */ a onParsed(ai[] aiVarArr) throws QStorageInstantiateException {
            return super.onParsed(aiVarArr);
        }

        @Override // com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor, com.tencent.mobileqq.config.l
        public /* bridge */ /* synthetic */ void onUpdate(a aVar) {
            super.onUpdate(aVar);
        }
    }

    /* loaded from: classes16.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final List<com.tencent.mobileqq.pluspanel.a> f258934a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f258934a = new ArrayList();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("c2c");
                    if (optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            com.tencent.mobileqq.pluspanel.a aVar = new com.tencent.mobileqq.pluspanel.a();
                            JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                            aVar.f258935d = jSONObject.optInt("appid");
                            aVar.C = jSONObject.optString("title");
                            aVar.D = jSONObject.optString("iconNormal");
                            aVar.E = jSONObject.optString("iconPress");
                            aVar.F = jSONObject.optString("iconNightNormal");
                            aVar.G = jSONObject.optString("iconNightPress");
                            aVar.f258936e = jSONObject.optInt("redDotID");
                            aVar.f258939i = jSONObject.optString("redDotPath");
                            aVar.f258937f = jSONObject.optString("actionType");
                            aVar.f258938h = jSONObject.optString("action");
                            aVar.f258940m = jSONObject.optInt("order");
                            aVar.i();
                            aVar.h();
                            this.f258934a.add(aVar);
                        }
                    }
                } catch (JSONException e16) {
                    QLog.e("AIOPanelIconConfigProcessor", 1, e16, new Object[0]);
                }
            }
        }
    }

    public AIOPanelIconConfigProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    abstract int a();

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (a) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        ai aiVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aiVarArr);
        }
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            aVar.b(aiVar.f202268b);
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return a();
    }
}
