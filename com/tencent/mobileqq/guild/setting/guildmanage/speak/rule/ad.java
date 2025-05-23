package com.tencent.mobileqq.guild.setting.guildmanage.speak.rule;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildSpeakRuleData;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ep;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.au;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001HB\u000f\u0012\u0006\u0010D\u001a\u00020\u0002\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J{\u0010\u0017\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019R%\u0010\"\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\r0\r0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R%\u0010%\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\r0\r0\u001c8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R%\u0010(\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\r0\r0\u001c8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R%\u0010+\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\r0\r0\u001c8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R%\u0010.\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\r0\r0\u001c8\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010!R%\u00101\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\r0\r0\u001c8\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u001f\u001a\u0004\b0\u0010!R#\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0007020\u001c8\u0006\u00a2\u0006\f\n\u0004\b3\u0010\u001f\u001a\u0004\b4\u0010!R%\u00108\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\r0\r0\u001c8\u0006\u00a2\u0006\f\n\u0004\b6\u0010\u001f\u001a\u0004\b7\u0010!R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001a098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad;", "Lcom/tencent/mobileqq/mvvm/c;", "Lwy1/a;", "Lcom/tencent/mobileqq/qqguildsdk/data/ep;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "U1", "", "guildId", "W1", "addObserver", "removeObserver", "P1", "", "prohibitRedEnvelope", "prohibitLink", "prohibitQrCode", "prohibitAd", "prohibitFriendFeed", "prohibitRiskFeed", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "prohibiteWd", "e2", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/ArrayList;)V", "Landroidx/lifecycle/LiveData;", "Lcf1/b;", "T1", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "c2", "()Landroidx/lifecycle/MutableLiveData;", "isProhibitRedEnvelope", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ICustomDataEditor.STRING_ARRAY_PARAM_2, "isProhibitLink", BdhLogUtil.LogTag.Tag_Conn, "b2", "isProhibitQrcode", "D", "X1", "isProhibitAd", "E", "Z1", "isProhibitFriendFeed", UserInfo.SEX_FEMALE, "d2", "isProhibitRiskFeed", "", "G", "S1", "prohibiteWords", "H", "R1", "hasGetRuleStatus", "Lcom/tencent/mobileqq/guild/util/cn;", "I", "Lcom/tencent/mobileqq/guild/util/cn;", "toastEvent", "J", "Ljava/lang/String;", "mGuildId", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "K", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "repository", "<init>", "(Lwy1/a;)V", "L", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ad extends com.tencent.mobileqq.mvvm.c<wy1.a> {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static ViewModelProvider.Factory M = new a();

    /* renamed from: C */
    @NotNull
    private final MutableLiveData<Boolean> isProhibitQrcode;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isProhibitAd;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isProhibitFriendFeed;

    /* renamed from: F */
    @NotNull
    private final MutableLiveData<Boolean> isProhibitRiskFeed;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<String>> prohibiteWords;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> hasGetRuleStatus;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final cn<cf1.b> toastEvent;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String mGuildId;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isProhibitRedEnvelope;

    /* renamed from: m */
    @NotNull
    private final MutableLiveData<Boolean> isProhibitLink;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new ad(new wy1.a());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad$b;", "", "Landroidx/lifecycle/ViewModelProvider$Factory;", "sViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "a", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setSViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.ad$b, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ViewModelProvider.Factory a() {
            return ad.M;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onGuildInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (TextUtils.equals(guildId, ad.this.mGuildId)) {
                ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(ad.this.mGuildId);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(@NotNull wy1.a repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        Boolean bool = Boolean.FALSE;
        this.isProhibitRedEnvelope = new MutableLiveData<>(bool);
        this.isProhibitLink = new MutableLiveData<>(bool);
        this.isProhibitQrcode = new MutableLiveData<>(bool);
        this.isProhibitAd = new MutableLiveData<>(bool);
        this.isProhibitFriendFeed = new MutableLiveData<>(bool);
        this.isProhibitRiskFeed = new MutableLiveData<>(bool);
        this.prohibiteWords = new MutableLiveData<>(new ArrayList());
        this.hasGetRuleStatus = new MutableLiveData<>(bool);
        this.toastEvent = new cn<>();
        this.mGuildId = "";
        this.mGPServiceObserver = new c();
    }

    public static final void Q1(ad this$0, int i3, String errMsg, ep rule) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rule, "rule");
        if (QLog.isColorLevel()) {
            QLog.d("Guild.sr.GuildSpeakRuleSettingViewModel", 4, "fetchGuildSpeakRule\uff1aguildId=" + this$0.mGuildId);
        }
        QLog.w("Guild.sr.GuildSpeakRuleSettingViewModel", 1, "fetchGuildSpeakRule\uff1a result=" + i3 + "\uff0c errMsg=" + errMsg);
        if (i3 != 0) {
            return;
        }
        this$0.U1(rule);
        this$0.hasGetRuleStatus.postValue(Boolean.TRUE);
    }

    private final void U1(ep r46) {
        ArrayList<String> e16;
        MutableLiveData<Boolean> mutableLiveData = this.isProhibitLink;
        Boolean g16 = r46.g();
        Boolean bool = Boolean.TRUE;
        mutableLiveData.postValue(Boolean.valueOf(Intrinsics.areEqual(g16, bool)));
        this.isProhibitRedEnvelope.postValue(Boolean.valueOf(Intrinsics.areEqual(r46.f(), bool)));
        this.isProhibitQrcode.postValue(Boolean.valueOf(Intrinsics.areEqual(r46.a(), bool)));
        this.isProhibitAd.postValue(Boolean.valueOf(Intrinsics.areEqual(r46.d(), bool)));
        this.isProhibitFriendFeed.postValue(Boolean.valueOf(Intrinsics.areEqual(r46.b(), bool)));
        this.isProhibitRiskFeed.postValue(Boolean.valueOf(Intrinsics.areEqual(r46.c(), bool)));
        MutableLiveData<List<String>> mutableLiveData2 = this.prohibiteWords;
        if (bl.b(r46.e())) {
            e16 = new ArrayList<>();
        } else {
            e16 = r46.e();
        }
        mutableLiveData2.postValue(e16);
    }

    public static /* synthetic */ void f2(ad adVar, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, ArrayList arrayList, int i3, Object obj) {
        Boolean bool7;
        Boolean bool8;
        Boolean bool9;
        Boolean bool10;
        Boolean bool11;
        Boolean bool12;
        ArrayList arrayList2 = null;
        if ((i3 & 2) != 0) {
            bool7 = null;
        } else {
            bool7 = bool;
        }
        if ((i3 & 4) != 0) {
            bool8 = null;
        } else {
            bool8 = bool2;
        }
        if ((i3 & 8) != 0) {
            bool9 = null;
        } else {
            bool9 = bool3;
        }
        if ((i3 & 16) != 0) {
            bool10 = null;
        } else {
            bool10 = bool4;
        }
        if ((i3 & 32) != 0) {
            bool11 = null;
        } else {
            bool11 = bool5;
        }
        if ((i3 & 64) != 0) {
            bool12 = null;
        } else {
            bool12 = bool6;
        }
        if ((i3 & 128) == 0) {
            arrayList2 = arrayList;
        }
        adVar.e2(str, bool7, bool8, bool9, bool10, bool11, bool12, arrayList2);
    }

    public static final void g2(ad this$0, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, ArrayList arrayList, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("Guild.sr.GuildSpeakRuleSettingViewModel", 4, "modifySpeakRule\uff1aguildId=" + this$0.mGuildId);
        }
        boolean z17 = true;
        QLog.i("Guild.sr.GuildSpeakRuleSettingViewModel", 1, "modifySpeakRule\uff1a result=" + i3 + "\uff0c errMsg=" + str);
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            MutableLiveData<Boolean> mutableLiveData = this$0.isProhibitRedEnvelope;
            if (!z16) {
                if (!booleanValue) {
                    booleanValue = true;
                } else {
                    booleanValue = false;
                }
            }
            mutableLiveData.postValue(Boolean.valueOf(booleanValue));
        }
        if (bool2 != null) {
            boolean booleanValue2 = bool2.booleanValue();
            MutableLiveData<Boolean> mutableLiveData2 = this$0.isProhibitLink;
            if (!z16) {
                if (!booleanValue2) {
                    booleanValue2 = true;
                } else {
                    booleanValue2 = false;
                }
            }
            mutableLiveData2.postValue(Boolean.valueOf(booleanValue2));
        }
        if (bool3 != null) {
            boolean booleanValue3 = bool3.booleanValue();
            MutableLiveData<Boolean> mutableLiveData3 = this$0.isProhibitQrcode;
            if (!z16) {
                if (!booleanValue3) {
                    booleanValue3 = true;
                } else {
                    booleanValue3 = false;
                }
            }
            mutableLiveData3.postValue(Boolean.valueOf(booleanValue3));
        }
        if (bool4 != null) {
            boolean booleanValue4 = bool4.booleanValue();
            MutableLiveData<Boolean> mutableLiveData4 = this$0.isProhibitAd;
            if (!z16) {
                if (!booleanValue4) {
                    booleanValue4 = true;
                } else {
                    booleanValue4 = false;
                }
            }
            mutableLiveData4.postValue(Boolean.valueOf(booleanValue4));
        }
        if (bool5 != null) {
            boolean booleanValue5 = bool5.booleanValue();
            MutableLiveData<Boolean> mutableLiveData5 = this$0.isProhibitFriendFeed;
            if (!z16) {
                if (!booleanValue5) {
                    booleanValue5 = true;
                } else {
                    booleanValue5 = false;
                }
            }
            mutableLiveData5.postValue(Boolean.valueOf(booleanValue5));
        }
        if (bool6 != null) {
            boolean booleanValue6 = bool6.booleanValue();
            MutableLiveData<Boolean> mutableLiveData6 = this$0.isProhibitRiskFeed;
            if (z16) {
                z17 = booleanValue6;
            } else if (booleanValue6) {
                z17 = false;
            }
            mutableLiveData6.postValue(Boolean.valueOf(z17));
        }
        if (arrayList != null) {
            MutableLiveData<List<String>> mutableLiveData7 = this$0.prohibiteWords;
            if (!z16) {
                arrayList = new ArrayList();
            }
            mutableLiveData7.postValue(arrayList);
        }
        this$0.toastEvent.setValue(new cf1.b(i3, str, iGProSecurityResult));
    }

    public final void P1() {
        ((IGPSService) ch.R0(IGPSService.class)).fetchGuildSpeakableRule(this.mGuildId, new au() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.ab
            @Override // vh2.au
            public final void a(int i3, String str, ep epVar) {
                ad.Q1(ad.this, i3, str, epVar);
            }
        });
    }

    @NotNull
    public final MutableLiveData<Boolean> R1() {
        return this.hasGetRuleStatus;
    }

    @NotNull
    public final MutableLiveData<List<String>> S1() {
        return this.prohibiteWords;
    }

    @NotNull
    public final LiveData<cf1.b> T1() {
        return this.toastEvent;
    }

    @MainThread
    public final void W1(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.mGuildId = guildId;
        P1();
    }

    @NotNull
    public final MutableLiveData<Boolean> X1() {
        return this.isProhibitAd;
    }

    @NotNull
    public final MutableLiveData<Boolean> Z1() {
        return this.isProhibitFriendFeed;
    }

    @NotNull
    public final MutableLiveData<Boolean> a2() {
        return this.isProhibitLink;
    }

    public final void addObserver() {
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.mGPServiceObserver);
    }

    @NotNull
    public final MutableLiveData<Boolean> b2() {
        return this.isProhibitQrcode;
    }

    @NotNull
    public final MutableLiveData<Boolean> c2() {
        return this.isProhibitRedEnvelope;
    }

    @NotNull
    public final MutableLiveData<Boolean> d2() {
        return this.isProhibitRiskFeed;
    }

    public final void e2(@NotNull String guildId, @Nullable final Boolean prohibitRedEnvelope, @Nullable final Boolean prohibitLink, @Nullable final Boolean prohibitQrCode, @Nullable final Boolean prohibitAd, @Nullable final Boolean prohibitFriendFeed, @Nullable final Boolean prohibitRiskFeed, @Nullable final ArrayList<String> prohibiteWd) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        ((IGPSService) ch.R0(IGPSService.class)).modifyGuildSpeakableRule(guildId, new GProGuildSpeakRuleData(prohibitRedEnvelope, prohibitLink, prohibitQrCode, prohibitAd, prohibiteWd, prohibitRiskFeed, prohibitFriendFeed), new dv() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.ac
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                ad.g2(ad.this, prohibitRedEnvelope, prohibitLink, prohibitQrCode, prohibitAd, prohibitFriendFeed, prohibitRiskFeed, prohibiteWd, i3, str, iGProSecurityResult);
            }
        });
    }

    public final void removeObserver() {
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.mGPServiceObserver);
    }
}
