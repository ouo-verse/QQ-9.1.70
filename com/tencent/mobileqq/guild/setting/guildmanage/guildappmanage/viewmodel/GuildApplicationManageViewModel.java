package com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPreviewNavigationRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSetCategoryOrderRsp;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mz1.AdditionAppItem;
import mz1.NavigatorItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.cg;
import wh2.ct;
import wh2.ef;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001]B\u001b\u0012\b\b\u0002\u00105\u001a\u00020\u0006\u0012\b\b\u0002\u0010Y\u001a\u00020\u0011\u00a2\u0006\u0004\bZ\u0010[J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\bJ \u0010\u0013\u001a\u00020\b2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0010J\u001c\u0010\u0017\u001a\u00020\b2\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\b0\u0014J\u0016\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nJ\u001c\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001dJ\u001c\u0010 \u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001dJ.\u0010#\u001a\u00020\b2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0!J\u0006\u0010$\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020%J\u0006\u0010'\u001a\u00020\bJ\u0016\u0010*\u001a\u00020\b2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fJ\u0006\u0010+\u001a\u00020\fJ\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003R\"\u00105\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\f068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R#\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0003068\u0006\u00a2\u0006\f\n\u0004\b:\u00108\u001a\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\"\u0010H\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010O\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR*\u0010T\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u00118\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010C\u001a\u0004\bR\u0010E\"\u0004\bS\u0010GR\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\f0U8F\u00a2\u0006\u0006\u001a\u0004\bV\u0010W\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/c;", "", "", "list", "", "o2", "", ICustomDataEditor.NUMBER_PARAM_2, "Lmz1/c;", "d2", "", "status", "S1", "U1", "Lkotlin/Function2;", "", "resultFun", ICustomDataEditor.STRING_PARAM_2, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "block", "c2", "curItem", "targetItem", "l2", "Lmz1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lkotlin/Function0;", "successFun", "q2", "Q1", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildNavIconTheme;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "X1", "Lmz1/i;", "R1", "T1", "from", "to", "p2", "j2", SemanticAttributes.DbSystemValues.H2, "i2", "g2", "i", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_pageStatus", BdhLogUtil.LogTag.Tag_Conn, "e2", "()Landroidx/lifecycle/MutableLiveData;", "modelShowListLD", "Lmz1/b;", "D", "Lmz1/b;", "modelListProcess", "E", "Z", "k2", "()Z", "setAllowCheckInCheck", "(Z)V", "isAllowCheckInCheck", UserInfo.SEX_FEMALE, "Lmz1/c;", "getCurrentEditItem", "()Lmz1/c;", "r2", "(Lmz1/c;)V", "currentEditItem", "value", "G", "m2", "u2", "isStartEdit", "Landroidx/lifecycle/LiveData;", "f2", "()Landroidx/lifecycle/LiveData;", "pageStatus", "isEnableShowNavBar", "<init>", "(Ljava/lang/String;Z)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildApplicationManageViewModel extends com.tencent.mobileqq.mvvm.c<c> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<mz1.c>> modelShowListLD;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final mz1.b modelListProcess;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isAllowCheckInCheck;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private mz1.c currentEditItem;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isStartEdit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _pageStatus;

    public GuildApplicationManageViewModel() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(GuildApplicationManageViewModel this$0, ArrayList it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mz1.b bVar = this$0.modelListProcess;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        bVar.k(it);
        this$0.modelShowListLD.postValue(this$0.d2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(GuildApplicationManageViewModel this$0, int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.modelListProcess.p(iGProGetPreviewNavigationRsp.getTotal());
            this$0.modelShowListLD.postValue(this$0.d2());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(GuildApplicationManageViewModel this$0, Function3 successFun, int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(successFun, "$successFun");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this$0), Dispatchers.getMain(), null, new GuildApplicationManageViewModel$fetchThemeIcons$1$1(successFun, i3, str, iGProGetPreviewNavigationRsp, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r1.intValue() == 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<mz1.c> d2() {
        boolean z16;
        mz1.b bVar = this.modelListProcess;
        Integer value = this._pageStatus.getValue();
        if (value != null) {
            z16 = true;
        }
        z16 = false;
        return bVar.e(z16);
    }

    private final void n2() {
        boolean m06 = ch.m0(this.guildId);
        this.isAllowCheckInCheck = m06;
        QLog.i("GuildApplicationManageViewModel", 1, "loadIsAllowCheckInManage isAllowCheckInCheck:" + m06);
    }

    private final String o2(List<Long> list) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(((Number) it.next()).longValue() + ", ");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "logStr.toString()");
        return sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(GuildApplicationManageViewModel this$0, Function2 resultFun, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProSetCategoryOrderRsp iGProSetCategoryOrderRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resultFun, "$resultFun");
        QLog.i("GuildApplicationManageViewModel", 1, "setGuildAppOrder  result=" + i3 + " errMsg:" + str);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this$0), Dispatchers.getMain(), null, new GuildApplicationManageViewModel$setGuildAppOrder$3$1(resultFun, i3, str, null), 2, null);
    }

    public final void Q1(@NotNull AdditionAppItem item, @NotNull Function0<Unit> successFun) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(successFun, "successFun");
        u2(true);
        this.modelListProcess.a(item, successFun);
    }

    public final void R1(@NotNull NavigatorItem item) {
        String uuid;
        Intrinsics.checkNotNullParameter(item, "item");
        u2(true);
        mz1.c cVar = this.currentEditItem;
        if (cVar instanceof AdditionAppItem) {
            Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.model.AdditionAppItem");
            AdditionAppItem additionAppItem = (AdditionAppItem) cVar;
            AdditionAppItem f16 = AdditionAppItem.f(additionAppItem, null, null, 0, null, null, null, false, 0, 0, 511, null);
            int indexOf = this.modelListProcess.g().indexOf(additionAppItem);
            if (indexOf != -1) {
                this.modelListProcess.g().set(indexOf, f16);
            }
            additionAppItem.u(item);
            additionAppItem.p(item.getConfigName());
            additionAppItem.t(item.getIconUri());
        } else if (cVar instanceof mz1.d) {
            if (item.getCategoryId() > 0) {
                uuid = String.valueOf(item.getCategoryId());
            } else {
                uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            }
            this.modelListProcess.d().add(new AdditionAppItem(uuid, item.getConfigName(), 11, item.getIconUri(), null, item, false, 0, 0, 464, null));
        }
        this.modelShowListLD.postValue(d2());
    }

    public final void S1(int status) {
        boolean z16;
        Integer value = this._pageStatus.getValue();
        if (value != null && value.intValue() == status) {
            return;
        }
        boolean z17 = false;
        if (status == 1) {
            u2(false);
        }
        mz1.b bVar = this.modelListProcess;
        if (status == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        bVar.o(z16);
        mz1.b bVar2 = this.modelListProcess;
        if (status == 1) {
            z17 = true;
        }
        bVar2.q(z17);
        this._pageStatus.postValue(Integer.valueOf(status));
    }

    public final void T1() {
        u2(true);
        if (this.currentEditItem instanceof AdditionAppItem) {
            List<mz1.c> h16 = this.modelListProcess.h();
            if (!TypeIntrinsics.asMutableCollection(h16).remove(this.currentEditItem)) {
                List<mz1.c> d16 = this.modelListProcess.d();
                TypeIntrinsics.asMutableCollection(d16).remove(this.currentEditItem);
            }
        }
        this.modelShowListLD.postValue(d2());
    }

    public final void U1() {
        getRepository().l(MiscKt.l(this.guildId), true, false, new cg() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.e
            @Override // wh2.cg
            public final void onGetGuildHomeCategories(ArrayList arrayList) {
                GuildApplicationManageViewModel.W1(GuildApplicationManageViewModel.this, arrayList);
            }
        });
    }

    public final void X1() {
        getRepository().n("fetchNavigationMaxNumber", MiscKt.l(this.guildId), new ct() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.f
            @Override // wh2.ct
            public final void a(int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
                GuildApplicationManageViewModel.Z1(GuildApplicationManageViewModel.this, i3, str, iGProGetPreviewNavigationRsp);
            }
        });
    }

    public final void a2(@NotNull final Function3<? super Boolean, ? super String, ? super List<? extends IGProGuildNavIconTheme>, Unit> successFun) {
        Intrinsics.checkNotNullParameter(successFun, "successFun");
        getRepository().n("fetchThemeIcons", MiscKt.l(this.guildId), new ct() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.d
            @Override // wh2.ct
            public final void a(int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
                GuildApplicationManageViewModel.b2(GuildApplicationManageViewModel.this, successFun, i3, str, iGProGetPreviewNavigationRsp);
            }
        });
    }

    public final void c2(@NotNull final Function1<? super IGProGuildInfo, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        GuildMainFrameUtils.k(this.guildId, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.GuildApplicationManageViewModel$getGuildInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                block.invoke(iGProGuildInfo);
            }
        });
    }

    @NotNull
    public final MutableLiveData<List<mz1.c>> e2() {
        return this.modelShowListLD;
    }

    @NotNull
    public final LiveData<Integer> f2() {
        return this._pageStatus;
    }

    @NotNull
    public final List<String> g2() {
        int collectionSizeOrDefault;
        List<mz1.c> h16 = this.modelListProcess.h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : h16) {
            if (obj instanceof AdditionAppItem) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(((AdditionAppItem) it.next()).getJumpType()));
        }
        return arrayList2;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final List<String> h2() {
        int collectionSizeOrDefault;
        List<mz1.c> h16 = this.modelListProcess.h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : h16) {
            if (obj instanceof AdditionAppItem) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((AdditionAppItem) it.next()).getAppName());
        }
        return arrayList2;
    }

    @NotNull
    public final List<String> i2() {
        int collectionSizeOrDefault;
        NavigatorItem navigation;
        String magnet;
        List<mz1.c> h16 = this.modelListProcess.h();
        ArrayList<AdditionAppItem> arrayList = new ArrayList();
        for (Object obj : h16) {
            if (obj instanceof AdditionAppItem) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (AdditionAppItem additionAppItem : arrayList) {
            String str = "";
            if (additionAppItem.getJumpType() == 11 && (navigation = additionAppItem.getNavigation()) != null && (magnet = navigation.getMagnet()) != null) {
                str = magnet;
            }
            arrayList2.add(str);
        }
        return arrayList2;
    }

    public final int j2() {
        return this.modelListProcess.h().size();
    }

    /* renamed from: k2, reason: from getter */
    public final boolean getIsAllowCheckInCheck() {
        return this.isAllowCheckInCheck;
    }

    public final boolean l2(@NotNull mz1.c curItem, @NotNull mz1.c targetItem) {
        Intrinsics.checkNotNullParameter(curItem, "curItem");
        Intrinsics.checkNotNullParameter(targetItem, "targetItem");
        boolean j3 = this.modelListProcess.j(curItem, targetItem);
        if (j3) {
            u2(true);
        }
        return j3;
    }

    /* renamed from: m2, reason: from getter */
    public final boolean getIsStartEdit() {
        return this.isStartEdit;
    }

    public final void p2(int from, int to5) {
        this.modelListProcess.l(from, to5, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.GuildApplicationManageViewModel$processListOrderAfterMoveGestureDone$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List<mz1.c> d26;
                MutableLiveData<List<mz1.c>> e26 = GuildApplicationManageViewModel.this.e2();
                d26 = GuildApplicationManageViewModel.this.d2();
                e26.postValue(d26);
            }
        });
    }

    public final void q2(@NotNull AdditionAppItem item, @NotNull Function0<Unit> successFun) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(successFun, "successFun");
        u2(true);
        this.modelListProcess.n(item, successFun);
    }

    public final void r2(@Nullable mz1.c cVar) {
        this.currentEditItem = cVar;
    }

    public final void s2(@NotNull final Function2<? super Boolean, ? super String, Unit> resultFun) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(resultFun, "resultFun");
        ArrayList<Long> arrayList = new ArrayList<>();
        List<mz1.c> h16 = this.modelListProcess.h();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : h16) {
            if (obj instanceof AdditionAppItem) {
                arrayList2.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Long.valueOf(MiscKt.l(((AdditionAppItem) it.next()).getId())));
        }
        arrayList.addAll(arrayList3);
        ArrayList<Long> arrayList4 = new ArrayList<>();
        List<mz1.c> d16 = this.modelListProcess.d();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : d16) {
            if (obj2 instanceof AdditionAppItem) {
                arrayList5.add(obj2);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Long.valueOf(MiscKt.l(((AdditionAppItem) it5.next()).getId())));
        }
        arrayList4.addAll(arrayList6);
        QLog.i("GuildApplicationManageViewModel", 1, "setGuildAppOrder guildId:" + MiscKt.l(this.guildId) + "  enableList:[" + o2(arrayList) + "]  disableList:[" + o2(arrayList4) + "]");
        ((c) getRepository()).p(MiscKt.l(this.guildId), arrayList, arrayList4, new ef() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.g
            @Override // wh2.ef
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProSetCategoryOrderRsp iGProSetCategoryOrderRsp) {
                GuildApplicationManageViewModel.t2(GuildApplicationManageViewModel.this, resultFun, i3, str, iGProSecurityResult, iGProSetCategoryOrderRsp);
            }
        });
    }

    public final void u2(boolean z16) {
        QLog.i("GuildApplicationManageViewModel", 1, "isStartEdit set = " + z16);
        this.isStartEdit = z16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildApplicationManageViewModel(@NotNull String guildId, boolean z16) {
        super(new c());
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this._pageStatus = new MutableLiveData<>();
        this.modelShowListLD = new MutableLiveData<>();
        this.modelListProcess = new mz1.b(z16);
        n2();
    }

    public /* synthetic */ GuildApplicationManageViewModel(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? false : z16);
    }
}
