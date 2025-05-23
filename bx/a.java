package bx;

import android.os.Bundle;
import com.tencent.av.zplan.AvatarResDownUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filament.zplan.avatar.model.AvatarResourceModel;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f29344d;

    /* compiled from: P */
    /* renamed from: bx.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0154a implements com.tencent.av.zplan.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f29345a;

        C0154a(int i3) {
            this.f29345a = i3;
        }

        @Override // com.tencent.av.zplan.b
        public void a(String str, AvatarResourceModel avatarResourceModel) {
            Bundle bundle = new Bundle();
            bundle.putString("action_json_str", str);
            bundle.putParcelable("action_avatar_res", avatarResourceModel);
            a.this.callbackResult(this.f29345a, EIPCResult.createResult(0, bundle));
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements com.tencent.av.zplan.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f29347a;

        b(int i3) {
            this.f29347a = i3;
        }

        @Override // com.tencent.av.zplan.a
        public void onSuccess(String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("action_animation_face_path", str);
            bundle.putString("action_animation_body_path", str2);
            a.this.callbackResult(this.f29347a, EIPCResult.createResult(0, bundle));
        }
    }

    public a(String str) {
        super(str);
    }

    public static a b() {
        if (f29344d == null) {
            synchronized (a.class) {
                if (f29344d == null) {
                    f29344d = new a("ZplanAvatarQIPCModule");
                }
            }
        }
        return f29344d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        EnumUserGender enumUserGender;
        if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ZplanAvatarQIPCModule", 2, "ZplanAvatarQIPCModule: action: " + str);
        }
        if ("action_get_avatar_resource".equals(str)) {
            AvatarResDownUtil.f77244a.a(bundle.getBoolean("is_myself"), bundle.getString("uin"), new C0154a(i3));
        } else if ("action_get_avatar_animation_resource".equals(str)) {
            boolean z16 = bundle.getBoolean("is_male");
            String string = bundle.getString("face_action_path");
            String string2 = bundle.getString("body_action_path");
            AvatarResDownUtil avatarResDownUtil = AvatarResDownUtil.f77244a;
            if (z16) {
                enumUserGender = EnumUserGender.GENDER_MALE;
            } else {
                enumUserGender = EnumUserGender.GENDER_FEMALE;
            }
            avatarResDownUtil.b(enumUserGender, string, string2, new b(i3));
        }
        return null;
    }
}
