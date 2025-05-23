package com.tencent.luggage.wxa.n5;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import com.tencent.av.business.manager.magicface.MagicfaceDataPendantJason;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import com.tencent.weui.base.preference.IPreferenceScreen;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 12\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u001e\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010)\u00a8\u00062"}, d2 = {"Lcom/tencent/luggage/wxa/n5/a;", "", "", "state", "", "a", "", "desc", "", "hasThreeState", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "preferenceScreen", "b", "Landroid/preference/Preference;", "preference", "Lcom/tencent/luggage/wxa/m5/a;", "Lcom/tencent/luggage/wxa/m5/a;", "mSettingUIAction", "Z", "hasChanged", "c", "I", "mCurrentState", "d", "Ljava/lang/String;", "mDesc", "e", "mHasThreeState", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "f", "Landroid/content/Context;", "mContext", "g", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "mScreen", h.F, "Landroid/preference/Preference;", "mDescPreference", "Lcom/tencent/luggage/wxa/w3/c;", "i", "Lcom/tencent/luggage/wxa/w3/c;", "mCheckPreferenceNone", "j", "mCheckPreferenceForeground", "k", "mCheckPreferenceBoth", "<init>", "(Lcom/tencent/luggage/wxa/m5/a;)V", "l", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.m5.a mSettingUIAction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean hasChanged;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int mCurrentState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public String mDesc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean mHasThreeState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Context mContext;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public IPreferenceScreen mScreen;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public Preference mDescPreference;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.w3.c mCheckPreferenceNone;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.w3.c mCheckPreferenceForeground;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.w3.c mCheckPreferenceBoth;

    public a(@NotNull com.tencent.luggage.wxa.m5.a mSettingUIAction) {
        Intrinsics.checkNotNullParameter(mSettingUIAction, "mSettingUIAction");
        this.mSettingUIAction = mSettingUIAction;
        this.mDesc = "";
        this.mContext = mSettingUIAction.e().getContext();
    }

    public void a(int state) {
        this.mCurrentState = state;
    }

    public void b() {
        if (this.hasChanged) {
            w.d("Luggage.STANDALONE.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", Integer.valueOf(this.mCurrentState));
            Intent intent = new Intent();
            intent.putExtra("key_result_state", this.mCurrentState);
            this.mSettingUIAction.e().setResult(-1, intent);
            return;
        }
        this.mSettingUIAction.e().setResult(0, null);
    }

    public void a(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.mDesc = desc;
    }

    public void a(boolean hasThreeState) {
        this.mHasThreeState = hasThreeState;
    }

    public void a(IPreferenceScreen preferenceScreen) {
        Intrinsics.checkNotNullParameter(preferenceScreen, "preferenceScreen");
        this.mScreen = preferenceScreen;
        IPreferenceScreen iPreferenceScreen = null;
        if (preferenceScreen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScreen");
            preferenceScreen = null;
        }
        preferenceScreen.removeAll();
        String a16 = a();
        if (!w0.c(a16)) {
            Preference preference = new Preference(this.mContext);
            preference.setTitle(a16);
            preference.setLayoutResource(R.layout.dq6);
            IPreferenceScreen iPreferenceScreen2 = this.mScreen;
            if (iPreferenceScreen2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScreen");
                iPreferenceScreen2 = null;
            }
            iPreferenceScreen2.addPreference(preference);
            this.mDescPreference = preference;
        }
        com.tencent.luggage.wxa.w3.c cVar = new com.tencent.luggage.wxa.w3.c(this.mContext);
        cVar.setKey("none");
        cVar.a(R.string.z_2);
        IPreferenceScreen iPreferenceScreen3 = this.mScreen;
        if (iPreferenceScreen3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScreen");
            iPreferenceScreen3 = null;
        }
        iPreferenceScreen3.addPreference(cVar);
        this.mCheckPreferenceNone = cVar;
        com.tencent.luggage.wxa.w3.c cVar2 = new com.tencent.luggage.wxa.w3.c(this.mContext);
        cVar2.setKey(com.tencent.mobileqq.msf.core.net.r.a.f248963o);
        cVar2.a(R.string.z_1);
        IPreferenceScreen iPreferenceScreen4 = this.mScreen;
        if (iPreferenceScreen4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScreen");
            iPreferenceScreen4 = null;
        }
        iPreferenceScreen4.addPreference(cVar2);
        this.mCheckPreferenceForeground = cVar2;
        if (this.mHasThreeState) {
            com.tencent.luggage.wxa.w3.c cVar3 = new com.tencent.luggage.wxa.w3.c(this.mContext);
            cVar3.setKey(MagicfaceDataPendantJason.BELONG_TO_BOTH);
            cVar3.a(R.string.z_0);
            this.mCheckPreferenceBoth = cVar3;
            IPreferenceScreen iPreferenceScreen5 = this.mScreen;
            if (iPreferenceScreen5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScreen");
                iPreferenceScreen5 = null;
            }
            iPreferenceScreen5.addPreference(this.mCheckPreferenceBoth);
        }
        int i3 = this.mCurrentState;
        if (i3 == 0) {
            com.tencent.luggage.wxa.w3.c cVar4 = this.mCheckPreferenceNone;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckPreferenceNone");
                cVar4 = null;
            }
            cVar4.a(true);
        } else if (i3 == 1) {
            com.tencent.luggage.wxa.w3.c cVar5 = this.mCheckPreferenceForeground;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckPreferenceForeground");
                cVar5 = null;
            }
            cVar5.a(true);
        } else if (i3 != 2) {
            com.tencent.luggage.wxa.w3.c cVar6 = this.mCheckPreferenceNone;
            if (cVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckPreferenceNone");
                cVar6 = null;
            }
            cVar6.a(true);
        } else {
            com.tencent.luggage.wxa.w3.c cVar7 = this.mCheckPreferenceBoth;
            if (cVar7 != null) {
                cVar7.a(true);
            }
        }
        IPreferenceScreen iPreferenceScreen6 = this.mScreen;
        if (iPreferenceScreen6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScreen");
        } else {
            iPreferenceScreen = iPreferenceScreen6;
        }
        iPreferenceScreen.notifyDataSetChanged();
    }

    public final void b(Preference preference) {
        String key = preference.getKey();
        IPreferenceScreen iPreferenceScreen = null;
        if (Intrinsics.areEqual(key, MagicfaceDataPendantJason.BELONG_TO_BOTH)) {
            this.mCurrentState = 2;
            com.tencent.luggage.wxa.w3.c cVar = this.mCheckPreferenceNone;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckPreferenceNone");
                cVar = null;
            }
            cVar.a(false);
            com.tencent.luggage.wxa.w3.c cVar2 = this.mCheckPreferenceForeground;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckPreferenceForeground");
                cVar2 = null;
            }
            cVar2.a(false);
            com.tencent.luggage.wxa.w3.c cVar3 = this.mCheckPreferenceBoth;
            if (cVar3 != null) {
                cVar3.a(true);
            }
        } else if (Intrinsics.areEqual(key, com.tencent.mobileqq.msf.core.net.r.a.f248963o)) {
            this.mCurrentState = 1;
            com.tencent.luggage.wxa.w3.c cVar4 = this.mCheckPreferenceForeground;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckPreferenceForeground");
                cVar4 = null;
            }
            cVar4.a(true);
            com.tencent.luggage.wxa.w3.c cVar5 = this.mCheckPreferenceNone;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckPreferenceNone");
                cVar5 = null;
            }
            cVar5.a(false);
            com.tencent.luggage.wxa.w3.c cVar6 = this.mCheckPreferenceBoth;
            if (cVar6 != null) {
                cVar6.a(false);
            }
        } else {
            this.mCurrentState = 0;
            com.tencent.luggage.wxa.w3.c cVar7 = this.mCheckPreferenceNone;
            if (cVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckPreferenceNone");
                cVar7 = null;
            }
            cVar7.a(true);
            com.tencent.luggage.wxa.w3.c cVar8 = this.mCheckPreferenceForeground;
            if (cVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckPreferenceForeground");
                cVar8 = null;
            }
            cVar8.a(false);
            com.tencent.luggage.wxa.w3.c cVar9 = this.mCheckPreferenceBoth;
            if (cVar9 != null) {
                cVar9.a(false);
            }
        }
        IPreferenceScreen iPreferenceScreen2 = this.mScreen;
        if (iPreferenceScreen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScreen");
        } else {
            iPreferenceScreen = iPreferenceScreen2;
        }
        iPreferenceScreen.notifyDataSetChanged();
    }

    public final String a() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.mContext.getString(R.string.z_b);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.string.authorize_usage_desc)");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.mDesc}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public boolean a(Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        w.d("Luggage.STANDALONE.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", preference.getKey());
        if (preference instanceof com.tencent.luggage.wxa.w3.c) {
            this.hasChanged = true;
            b(preference);
        }
        return false;
    }
}
