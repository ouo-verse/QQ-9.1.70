package com.tencent.mobileqq.guild.setting.guildmanage.rule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.setting.guildinfo.ProfileRuleData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.cd;
import com.tencent.mobileqq.qqguildsdk.data.genc.ce;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditBaseItem;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rz1.AddRuleItemData;
import rz1.PageData;
import rz1.RuleData;
import rz1.RuleItemData;
import rz1.SortRuleItemData;
import rz1.SpaceData;
import rz1.TitleStatus;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 N2\u00020\u0001:\u0001OB\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fJ\u0006\u0010\u0011\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bJ\"\u0010\u0019\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018\u0012\u0004\u0012\u00020\r0\u0015R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010!R \u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u000f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010!R \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u000f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010!R\"\u0010-\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\r0\r0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010!R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\r0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u000f0<8F\u00a2\u0006\u0006\u001a\u0004\b=\u0010>R\u001d\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u000f0<8F\u00a2\u0006\u0006\u001a\u0004\b@\u0010>R\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001f0<8F\u00a2\u0006\u0006\u001a\u0004\bB\u0010>R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020#0<8F\u00a2\u0006\u0006\u001a\u0004\bD\u0010>R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0<8F\u00a2\u0006\u0006\u001a\u0004\bF\u0010>R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020/0<8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010>R\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020\r0<8F\u00a2\u0006\u0006\u001a\u0004\bJ\u0010>\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/r;", "Lef1/b;", "", "g2", SemanticAttributes.DbSystemValues.H2, "i2", "j2", "Q1", "Lrz1/d;", "ruleData", "T1", "R1", "U1", "", "S1", "", "W1", "k2", "data", "targetData", "f2", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData;", "Lkotlin/collections/ArrayList;", "b2", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "guildId", "Landroidx/lifecycle/MutableLiveData;", "", "D", "Landroidx/lifecycle/MutableLiveData;", "_pageStatusLiveData", "Lrz1/h;", "E", "_titleStatus", "Lrz1/b;", UserInfo.SEX_FEMALE, "_sortListLiveData", "G", "_ruleListLiveData", "kotlin.jvm.PlatformType", "H", "_hasDataChangedLiveData", "Lcom/tencent/mobileqq/guild/util/cn;", "Lcf1/b;", "I", "Lcom/tencent/mobileqq/guild/util/cn;", "_toastEvent", "J", "_finishEvent", "Lrz1/c;", "K", "Lrz1/c;", ISchemeApi.KEY_PAGE_DATA, "L", "Z", "isSubmitting", "Landroidx/lifecycle/LiveData;", "d2", "()Landroidx/lifecycle/LiveData;", "sortListLiveData", "c2", "ruleListLiveData", ICustomDataEditor.STRING_ARRAY_PARAM_2, "pageStatusLiveData", "e2", "titleStatus", "Z1", "hasDataChangedLiveData", "getToastEvent", "toastEvent", "X1", "finishEvent", "<init>", "(Ljava/lang/String;)V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class r extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _pageStatusLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TitleStatus> _titleStatus;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<rz1.b>> _sortListLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<rz1.b>> _ruleListLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _hasDataChangedLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final cn<cf1.b> _toastEvent;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _finishEvent;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final PageData pageData;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isSubmitting;

    public r(@NotNull String guildId) {
        List<Pair<String, String>> emptyList;
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this._pageStatusLiveData = new MutableLiveData<>();
        this._titleStatus = new MutableLiveData<>();
        this._sortListLiveData = new MutableLiveData<>();
        this._ruleListLiveData = new MutableLiveData<>();
        this._hasDataChangedLiveData = new MutableLiveData<>(Boolean.FALSE);
        this._toastEvent = new cn<>();
        this._finishEvent = new cn<>();
        this.pageData = new PageData(0, null, null, null, 15, null);
        IGProGuildInfo L = ch.L(this.guildId);
        if (L != null) {
            ArrayList arrayList = new ArrayList();
            if (L.getUint32GuildRuleChangeTime() == 0) {
                arrayList.add(PageData.INSTANCE.a());
                arrayList.add(new Pair("", ""));
            } else {
                ArrayList<GProGuildAuditBaseItem> guildRules = L.getGuildRules();
                Intrinsics.checkNotNullExpressionValue(guildRules, "guildInfo.guildRules");
                ArrayList<GProGuildAuditBaseItem> arrayList2 = new ArrayList();
                for (Object obj : guildRules) {
                    if (((GProGuildAuditBaseItem) obj).status == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList2.add(obj);
                    }
                }
                for (GProGuildAuditBaseItem gProGuildAuditBaseItem : arrayList2) {
                    arrayList.add(new Pair(gProGuildAuditBaseItem.getByteAuditTitleStr(), gProGuildAuditBaseItem.auditContentStr));
                }
            }
            this.pageData.n(arrayList);
        } else {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "guildInfo == null, guildId: " + this.guildId;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.mnr.GuildRuleViewModel", 1, (String) it.next(), null);
            }
            PageData pageData = this.pageData;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            pageData.n(emptyList);
        }
        if (this.pageData.getStatus() == 2) {
            g2();
        }
        i2();
    }

    private final void g2() {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : this.pageData.i()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new RuleItemData(i16, (RuleData) obj));
            i3 = i16;
        }
        if (this.pageData.i().size() < 10) {
            arrayList.add(new AddRuleItemData(this.pageData.i().size()));
        }
        arrayList.add(new SpaceData(QQGuildUIUtil.f(16.0f)));
        this._ruleListLiveData.setValue(arrayList);
    }

    private final void h2() {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : this.pageData.j()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new SortRuleItemData(i16, (RuleData) obj));
            i3 = i16;
        }
        this._sortListLiveData.setValue(arrayList);
    }

    private final void i2() {
        TitleStatus g16 = this.pageData.g();
        if (!Intrinsics.areEqual(this._titleStatus.getValue(), g16)) {
            this._titleStatus.setValue(g16);
        }
        Integer value = this._pageStatusLiveData.getValue();
        int status = this.pageData.getStatus();
        if (value == null || value.intValue() != status) {
            this._pageStatusLiveData.setValue(Integer.valueOf(this.pageData.getStatus()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(r this$0, ArrayList ruleAuditList, int i3, String str, IGProSecurityResult iGProSecurityResult, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ruleAuditList, "$ruleAuditList");
        Logger.f235387a.d().i("Guild.mnr.GuildRuleViewModel", 1, "submitRules(" + ruleAuditList.size() + "): " + i3 + " " + str + " " + iGProSecurityResult + " " + i16);
        this$0.isSubmitting = false;
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            if (ruleAuditList.isEmpty()) {
                this$0._toastEvent.setValue(new cf1.b(0, "\u5df2\u6e05\u7a7a\u9891\u9053\u89c4\u5219"));
            } else {
                this$0._toastEvent.setValue(new cf1.b(0, "\u5df2\u63d0\u4ea4\u5ba1\u6838\uff0c\u901a\u8fc7\u540e\u751f\u6548"));
            }
            this$0._finishEvent.setValue(Boolean.TRUE);
            return;
        }
        this$0._toastEvent.setValue(new cf1.b(i3, str, iGProSecurityResult));
    }

    public final void Q1() {
        this.pageData.b();
        g2();
        i2();
        S1();
    }

    public final void R1() {
        if (!this.pageData.c()) {
            Logger.f235387a.d().w("Guild.mnr.GuildRuleViewModel", 1, "cancelSort error: " + this.pageData);
        }
        h2();
        g2();
        i2();
    }

    public final boolean S1() {
        boolean l3 = this.pageData.l();
        this._hasDataChangedLiveData.setValue(Boolean.valueOf(l3));
        return l3;
    }

    public final void T1(@NotNull RuleData ruleData) {
        Intrinsics.checkNotNullParameter(ruleData, "ruleData");
        this.pageData.e(ruleData);
        g2();
        i2();
        S1();
    }

    public final void U1() {
        if (!this.pageData.f()) {
            Logger.f235387a.d().w("Guild.mnr.GuildRuleViewModel", 1, "finishSort error: " + this.pageData);
        }
        h2();
        g2();
        i2();
        S1();
    }

    @NotNull
    public final List<RuleData> W1() {
        return this.pageData.i();
    }

    @NotNull
    public final LiveData<Boolean> X1() {
        return this._finishEvent;
    }

    @NotNull
    public final LiveData<Boolean> Z1() {
        return this._hasDataChangedLiveData;
    }

    @NotNull
    public final LiveData<Integer> a2() {
        return this._pageStatusLiveData;
    }

    @NotNull
    public final Pair<ArrayList<ProfileRuleData>, Boolean> b2() {
        return this.pageData.h();
    }

    @NotNull
    public final LiveData<List<rz1.b>> c2() {
        return this._ruleListLiveData;
    }

    @NotNull
    public final LiveData<List<rz1.b>> d2() {
        return this._sortListLiveData;
    }

    @NotNull
    public final LiveData<TitleStatus> e2() {
        return this._titleStatus;
    }

    public final void f2(@NotNull RuleData data, @NotNull RuleData targetData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(targetData, "targetData");
        this.pageData.d(data, targetData);
        i2();
        h2();
    }

    @NotNull
    public final LiveData<cf1.b> getToastEvent() {
        return this._toastEvent;
    }

    public final void j2() {
        if (!this.pageData.o()) {
            Logger.f235387a.d().w("Guild.mnr.GuildRuleViewModel", 1, "startSort error: " + this.pageData);
            return;
        }
        i2();
        h2();
    }

    public final void k2() {
        int collectionSizeOrDefault;
        if (this.isSubmitting) {
            Logger.f235387a.d().i("Guild.mnr.GuildRuleViewModel", 1, "isSubmiting");
            return;
        }
        final ArrayList<cd> arrayList = new ArrayList<>();
        ArrayList<ProfileRuleData> first = this.pageData.h().getFirst();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(first, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (ProfileRuleData profileRuleData : first) {
            cd cdVar = new cd();
            cdVar.m(10);
            cdVar.l(profileRuleData.getTitle());
            String desc = profileRuleData.getDesc();
            if (desc == null) {
                desc = "";
            }
            cdVar.k(desc);
            arrayList2.add(Boolean.valueOf(arrayList.add(cdVar)));
        }
        ce ceVar = new ce();
        ceVar.g(NumberUtil.stringToLong(this.guildId));
        ceVar.f(10);
        ceVar.e(arrayList);
        ((IGPSService) ch.R0(IGPSService.class)).setGuildAuditInfo(ceVar, new wh2.d() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.q
            @Override // wh2.d
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, int i16) {
                r.l2(r.this, arrayList, i3, str, iGProSecurityResult, i16);
            }
        });
    }
}
