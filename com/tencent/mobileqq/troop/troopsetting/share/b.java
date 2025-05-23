package com.tencent.mobileqq.troop.troopsetting.share;

import android.content.Intent;
import android.graphics.Bitmap;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001c\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010.\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0004\u0012\u00020)\u0018\u00010'\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b5\u00106B-\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\b\u00103\u001a\u0004\u0018\u00010/\u0012\b\u00104\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b5\u00107B\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b5\u00108J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\n\u0010#\"\u0004\b$\u0010%R2\u0010.\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0004\u0012\u00020)\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010*\u001a\u0004\b\u0015\u0010+\"\u0004\b,\u0010-R\u0019\u00103\u001a\u0004\u0018\u00010/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b!\u00102R\u0019\u00104\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b0\u0010#\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/app/QBaseActivity;", "a", "Lcom/tencent/mobileqq/app/QBaseActivity;", "b", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", h.F, "()Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfo", "Lcom/tencent/mobileqq/troop/troopshare/a;", "c", "Lcom/tencent/mobileqq/troop/troopshare/a;", "f", "()Lcom/tencent/mobileqq/troop/troopshare/a;", "k", "(Lcom/tencent/mobileqq/troop/troopshare/a;)V", "rsp", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "finishReqLiveData", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "actionId", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "j", "(Lkotlin/jvm/functions/Function1;)V", "block", "Landroid/graphics/Bitmap;", "g", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "preview", "shareLink", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/troop/data/TroopInfoData;Lcom/tencent/mobileqq/troop/troopshare/a;Landroidx/lifecycle/MutableLiveData;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroid/graphics/Bitmap;Ljava/lang/String;)V", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/troop/data/TroopInfoData;Landroid/graphics/Bitmap;Ljava/lang/String;)V", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/troop/data/TroopInfoData;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopInfoData troopInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopshare.a rsp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> finishReqLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String actionId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Intent, Unit> block;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bitmap preview;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String shareLink;

    public b(@NotNull QBaseActivity activity, @NotNull TroopInfoData troopInfo, @Nullable com.tencent.mobileqq.troop.troopshare.a aVar, @NotNull MutableLiveData<Boolean> finishReqLiveData, @NotNull String actionId, @Nullable Function1<? super Intent, Unit> function1, @Nullable Bitmap bitmap, @Nullable String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        Intrinsics.checkNotNullParameter(finishReqLiveData, "finishReqLiveData");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, troopInfo, aVar, finishReqLiveData, actionId, function1, bitmap, str);
            return;
        }
        this.activity = activity;
        this.troopInfo = troopInfo;
        this.rsp = aVar;
        this.finishReqLiveData = finishReqLiveData;
        this.actionId = actionId;
        this.block = function1;
        this.preview = bitmap;
        this.shareLink = str;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.actionId;
    }

    @NotNull
    public final QBaseActivity b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.activity;
    }

    @Nullable
    public final Function1<Intent, Unit> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Function1) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.block;
    }

    @NotNull
    public final MutableLiveData<Boolean> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.finishReqLiveData;
    }

    @Nullable
    public final Bitmap e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.preview;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.activity, bVar.activity) && Intrinsics.areEqual(this.troopInfo, bVar.troopInfo) && Intrinsics.areEqual(this.rsp, bVar.rsp) && Intrinsics.areEqual(this.finishReqLiveData, bVar.finishReqLiveData) && Intrinsics.areEqual(this.actionId, bVar.actionId) && Intrinsics.areEqual(this.block, bVar.block) && Intrinsics.areEqual(this.preview, bVar.preview) && Intrinsics.areEqual(this.shareLink, bVar.shareLink)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final com.tencent.mobileqq.troop.troopshare.a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.troop.troopshare.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.rsp;
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.shareLink;
    }

    @NotNull
    public final TroopInfoData h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopInfoData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopInfo;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        int hashCode4 = ((this.activity.hashCode() * 31) + this.troopInfo.hashCode()) * 31;
        com.tencent.mobileqq.troop.troopshare.a aVar = this.rsp;
        int i3 = 0;
        if (aVar == null) {
            hashCode = 0;
        } else {
            hashCode = aVar.hashCode();
        }
        int hashCode5 = (((((hashCode4 + hashCode) * 31) + this.finishReqLiveData.hashCode()) * 31) + this.actionId.hashCode()) * 31;
        Function1<? super Intent, Unit> function1 = this.block;
        if (function1 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = function1.hashCode();
        }
        int i16 = (hashCode5 + hashCode2) * 31;
        Bitmap bitmap = this.preview;
        if (bitmap == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = bitmap.hashCode();
        }
        int i17 = (i16 + hashCode3) * 31;
        String str = this.shareLink;
        if (str != null) {
            i3 = str.hashCode();
        }
        return i17 + i3;
    }

    public final void i(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.actionId = str;
        }
    }

    public final void j(@Nullable Function1<? super Intent, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) function1);
        } else {
            this.block = function1;
        }
    }

    public final void k(@Nullable com.tencent.mobileqq.troop.troopshare.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            this.rsp = aVar;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return "ShareContext(activity=" + this.activity + ", troopInfo=" + this.troopInfo + ", rsp=" + this.rsp + ", finishReqLiveData=" + this.finishReqLiveData + ", actionId=" + this.actionId + ", block=" + this.block + ", preview=" + this.preview + ", shareLink=" + this.shareLink + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NotNull QBaseActivity activity, @NotNull TroopInfoData troopInfo, @Nullable Bitmap bitmap, @Nullable String str) {
        this(activity, troopInfo, null, new MutableLiveData(Boolean.FALSE), "", null, bitmap, str);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, this, activity, troopInfo, bitmap, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NotNull QBaseActivity activity, @NotNull TroopInfoData troopInfo) {
        this(activity, troopInfo, null, new MutableLiveData(Boolean.FALSE), "", null, null, "");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity, (Object) troopInfo);
    }
}
