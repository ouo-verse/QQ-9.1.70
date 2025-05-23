package com.tencent.mobileqq.troop.honor.api;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9$HonorList;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopHonorService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f297498a;

        /* renamed from: b, reason: collision with root package name */
        public String f297499b;

        /* renamed from: c, reason: collision with root package name */
        public String f297500c;

        /* renamed from: d, reason: collision with root package name */
        public Byte f297501d;

        public b(String str, String str2, String str3, Byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3, b16);
                return;
            }
            this.f297498a = str;
            this.f297499b = str2;
            this.f297500c = str3;
            this.f297501d = b16;
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (!TextUtils.isEmpty(this.f297498a) && !TextUtils.isEmpty(this.f297499b) && !TextUtils.isEmpty(this.f297500c)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void onResult(List<com.tencent.mobileqq.troop.honor.config.a> list);
    }

    void asyncGetTroopHonorListByDirect(String str, String str2, c cVar);

    List<com.tencent.mobileqq.troop.honor.config.a> convertToHonorList(String str, Byte b16);

    List<Drawable> getHonorIcon(b bVar, a aVar);

    boolean isGrayTroopHonor(String str);

    boolean isSupportTroopHonor(String str);

    void notifyTroopHonorGlobalUpdate();

    void notifyTroopMemberHonorUpdate(String str, String str2);

    void saveHostHonorListRichTag(short s16);

    void sortHonorList(List<com.tencent.mobileqq.troop.honor.config.a> list);

    void updateConfig(com.tencent.mobileqq.troop.honor.config.b bVar, boolean z16);

    boolean updateEntity(Entity entity);

    void updateHostHonorList(List<oidb_0xdc9$HonorList> list, boolean z16);

    void updateHostHonorList(boolean z16);

    void updatePushTroopHonor(String str, byte[] bArr, int i3);

    void updateTroopHonorAIOSwitch(String str, boolean z16);

    void updateTroopMemberHonor(String str, String str2, String str3, byte b16, long j3);
}
