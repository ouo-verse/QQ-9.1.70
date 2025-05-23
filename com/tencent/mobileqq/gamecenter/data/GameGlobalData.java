package com.tencent.mobileqq.gamecenter.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 \n2\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\"\u0010!\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/GameGlobalData;", "", "", tl.h.F, "b", "", "i", "Lcom/tencent/mobileqq/gamecenter/data/SayHiState;", "a", "Lcom/tencent/mobileqq/gamecenter/data/SayHiState;", "g", "()Lcom/tencent/mobileqq/gamecenter/data/SayHiState;", "o", "(Lcom/tencent/mobileqq/gamecenter/data/SayHiState;)V", "mSayHiState", "Z", "d", "()Z", "l", "(Z)V", "mIsQueryingSayHiState", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "mAppId", "f", DomainData.DOMAIN_NAME, "mRedDotShow", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mMainTitle", "getMIsAIOPartnerUIShowing", "k", "mIsAIOPartnerUIShowing", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameGlobalData {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<GameGlobalData> f211963h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile SayHiState mSayHiState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsQueryingSayHiState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mAppId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mRedDotShow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mMainTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsAIOPartnerUIShowing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/GameGlobalData$a;", "", "Lcom/tencent/mobileqq/gamecenter/data/GameGlobalData;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/gamecenter/data/GameGlobalData;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.data.GameGlobalData$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GameGlobalData a() {
            return (GameGlobalData) GameGlobalData.f211963h.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<GameGlobalData> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<GameGlobalData>() { // from class: com.tencent.mobileqq.gamecenter.data.GameGlobalData$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GameGlobalData invoke() {
                return new GameGlobalData(null);
            }
        });
        f211963h = lazy;
    }

    public /* synthetic */ GameGlobalData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final boolean h() {
        if (this.mSayHiState != SayHiState.UNKNOWN && this.mSayHiState != SayHiState.NORMAL_CHAT) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        QLog.d("GameGlobalData", 1, "canShowIceBreakImages partnerUI:", Boolean.valueOf(this.mIsAIOPartnerUIShowing), " querySayHiUI:", Boolean.valueOf(this.mIsQueryingSayHiState), " sayHiUI:", Boolean.valueOf(h()));
        if (this.mIsAIOPartnerUIShowing || this.mIsQueryingSayHiState || h()) {
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMAppId() {
        return this.mAppId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getMIsQueryingSayHiState() {
        return this.mIsQueryingSayHiState;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getMMainTitle() {
        return this.mMainTitle;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getMRedDotShow() {
        return this.mRedDotShow;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final SayHiState getMSayHiState() {
        return this.mSayHiState;
    }

    public final void i() {
        this.mIsQueryingSayHiState = false;
        this.mSayHiState = SayHiState.UNKNOWN;
        this.mAppId = "";
        this.mMainTitle = "";
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mAppId = str;
    }

    public final void k(boolean z16) {
        this.mIsAIOPartnerUIShowing = z16;
    }

    public final void l(boolean z16) {
        this.mIsQueryingSayHiState = z16;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mMainTitle = str;
    }

    public final void n(boolean z16) {
        this.mRedDotShow = z16;
    }

    public final void o(@NotNull SayHiState sayHiState) {
        Intrinsics.checkNotNullParameter(sayHiState, "<set-?>");
        this.mSayHiState = sayHiState;
    }

    GameGlobalData() {
        this.mSayHiState = SayHiState.UNKNOWN;
        this.mAppId = "";
        this.mMainTitle = "";
    }
}
